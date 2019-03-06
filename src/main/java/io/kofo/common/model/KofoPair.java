package io.kofo.common.model;

import io.kofo.common.crypto.Base58;

/**
 * author: fanyongpeng
 * date: 2019/2/19
 **/

public class KofoPair {
    private String kofoId;
    private String kofoSecret;
    private String kofoPubKey;
    public static final String KOFO_PREFIX = "KOFO";
    public KofoPair(String kofoId, String kofoSecret, String kofoPubKey) {
        this.kofoId = kofoId;
        this.kofoSecret = kofoSecret;
        this.kofoPubKey = kofoPubKey;
    }

    public String getKofoId() {
        return kofoId;
    }

    public void setKofoId(String kofoId) {
        this.kofoId = kofoId;
    }

    public String getKofoSecret() {
        return kofoSecret;
    }

    public void setKofoSecret(String kofoSecret) {
        this.kofoSecret = kofoSecret;
    }

    public String getKofoPubKey() {
        return kofoPubKey;
    }

    public void setKofoPubKey(String kofoPubKey) {
        this.kofoPubKey = kofoPubKey;
    }

    @Override
    public String toString() {
        return String.format("kofo id %s , kofo secret %s, kofo pubkey %s", kofoId,kofoSecret, kofoPubKey);
    }
}
