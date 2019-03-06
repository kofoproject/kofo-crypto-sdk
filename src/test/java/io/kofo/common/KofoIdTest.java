package io.kofo.common;

import io.kofo.common.crypto.CryptoUtils;
import io.kofo.common.crypto.ECKey;
import io.kofo.common.model.KofoPair;
import org.junit.Assert;
import org.junit.Test;
import org.spongycastle.util.encoders.Base64;

/**
 * author: fanyongpeng
 * date: 2019/2/21
 **/
public class KofoIdTest {

    @Test
    public void testKofo() {
        KofoPair kofoPair = KofoUtil.createKofo();
        System.out.println(kofoPair);
        Assert.assertEquals(kofoPair.getKofoId(), KofoUtil.createKofoIdByPubKey(kofoPair.getKofoPubKey()));
        String data = kofoPair.getKofoId() + " check signature test";

        String sign = KofoUtil.sign(kofoPair.getKofoSecret(), data);
        System.out.println(sign);
        System.out.println(sign.length());
        Assert.assertTrue(KofoUtil.verifyWithPubKey(kofoPair.getKofoPubKey(), sign, data));
        Assert.assertTrue(KofoUtil.verifyWithKofoId(kofoPair.getKofoId(),sign ,data));

        System.out.println(KofoUtil.createKofoIdByPubKey("02eae856c717f1a18c12093f9be1cfe4b17cfebf236e596fb7097def5d379ae8fd"));
        System.out.println(CryptoUtils.HEX.encode(Base64.decode(KofoUtil.sign("b1dfcfb43316ae9dbc4a6c6e7b073e77b7a313ece7d25ccb3c778a9ab913386a","Hello, World!"))));


    }


    @Test
    public void verifySign() {
        String data = "Hello world!!!!";
        String secret = "30f359e9fb6bb10da37bccf3fcc3c26550e4501c2427e64d134bce78fd472058";
        String kofoId = "KOFOkoRwQegeF29RjSSiBnkz4j7jbvCeYK1RTRBArbdDEmcK";
        System.out.println(KofoUtil.sign(secret,data));
        String signature = KofoUtil.sign(secret,data);
        System.out.println("AN1rKvtdpqGKdf4dz9DCDKRR4FEQDouKyCEzEcnkujYzznaHjUtFt9YbhSoEMepWAQsmcAgA7ZH1YtUdczSMYLGH1zrHbsfqP".length());

        System.out.println(KofoUtil.verifyWithKofoId(kofoId,signature,data));
        ECKey ecKey= ECKey.fromPrivateKey("91b1d30d1097cf656c2957e332962f8c5d0b166d3197129b0fd04c94cf4ada08");
//        System.out.println(ecKey.getPublicKeyAsHex());
    }
}
