# kofo-sdk

kofo crypto sdk 
        
        //Create kofo id
        KofoPair kofoPair = KofoUtil.createKofo();
        String kofoId1 = kofoPair.getKofoId();
        String kofoSecret = kofoPair.getKofoSecret();
        String kofoPubKey = kofoPair.getKofoPubKey();
        
        //Create kofo id from public key
        String kofoId2 = KofoUtil.createKofoIdByPubKey(kofoPair.getKofoPubKey());
        
        // Signature
        String data = kofoPair.getKofoId() + " check signature test";
        String sign = KofoUtil.sign(kofoPair.getKofoSecret(), data);
        
        // Verify signature by public key
        boolean result1 = KofoUtil.verifyWithPubKey(kofoPair.getKofoPubKey(), sign, data);
        
        // Verify signature by kofo id
        boolean result2 = KofoUtil.verifyWithKofoId(kofoPair.getKofoId(),sign ,data);