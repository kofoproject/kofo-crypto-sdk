package io.kofo.common;


import io.kofo.common.crypto.Base58;
import io.kofo.common.crypto.CryptoUtils;
import io.kofo.common.crypto.ECKey;
import io.kofo.common.crypto.Sha256Hash;
import io.kofo.common.model.KofoPair;
import org.spongycastle.util.encoders.Base64;

import static io.kofo.common.model.KofoPair.KOFO_PREFIX;

/**
 * author: fanyongpeng
 * date: 2019/2/19
 **/
public class KofoUtil {
    /**
     * Create kofo pair
     * @return
     */
    public static KofoPair createKofo() {
        ECKey ecKey = new ECKey();
        String kofoSecret = ecKey.getPrivateKeyAsHex();
        String kofoId = KOFO_PREFIX+ Base58.encode(ecKey.getPublicKey());
        String kofoPubkey = ecKey.getPublicKeyAsHex();
        return new KofoPair(kofoId, kofoSecret, kofoPubkey);
    }

    /**
     * Genrate kofoid from public key
     * @param hexPubKey
     * @return
     */
    public static String createKofoIdByPubKey(String hexPubKey) {
        return KOFO_PREFIX+ Base58.encode(CryptoUtils.HEX.decode(hexPubKey));
    }

    /**
     * Signature
     * @param kofoSecret
     * @param data
     * @return
     */
    public static String sign( String kofoSecret,String data) {
        if (kofoSecret == null || data == null) {
            throw new NullPointerException();
        }
        ECKey ecKey = ECKey.fromPrivateKey(kofoSecret);
//        String str = CryptoUtils.HEX.encode(Sha256Hash.hash(data.getBytes()));
        return ecKey.signMessage(data);
    }

    /**
     * Verify the signature
     * @param kofoPubKey
     * @param signature
     * @param data
     * @return
     */
    public static boolean verifyWithPubKey( String kofoPubKey,String signature, String data) {
        if (kofoPubKey == null || signature == null || data == null) {
            throw new NullPointerException();
        }
//        String str = CryptoUtils.HEX.encode(Sha256Hash.hash(data.getBytes()));
        return  ECKey.verifySign(data,signature, kofoPubKey);
    }

    /**
     * Verify signature by kofoid
     * @param kofoId
     * @param signature
     * @param data
     * @return
     */
    public static boolean verifyWithKofoId( String kofoId,String signature, String data) {
        if (kofoId == null || signature == null || data == null) {
            throw new NullPointerException();
        }
        if (!kofoId.startsWith(KOFO_PREFIX)) {
            throw new IllegalArgumentException("Kofo id is illegal " + kofoId);
        }
        String kofoPubkey = CryptoUtils.HEX.encode(Base58.decode(kofoId.substring(KOFO_PREFIX.length())));
        String str = CryptoUtils.HEX.encode(Sha256Hash.hash(data.getBytes()));
        return  verifyWithPubKey(kofoPubkey,signature, str);
    }

}
