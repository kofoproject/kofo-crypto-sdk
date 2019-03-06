package io.kofo.common.model;

import io.kofo.common.crypto.CryptoUtils;
import io.kofo.common.crypto.Sha256Hash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * author: fanyongpeng
 * date: 2019/2/22
 **/
public class MakerOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String makerChain;
    private String makerCurrency;
    private BigDecimal makerAmount;
    private String makerAddress;
    private String makerCounterChainAddress;
    private String makerKofoId;
    private String takerChain;
    private String takerCurrency;
    private BigDecimal takerAmount;


    public String toSignatureString() {
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = toMap();
        for (Map.Entry<String, String> entry: map.entrySet()){
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private Map<String, String>  toMap() {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("makerChain", makerChain);
        map.put("makerCurrency", makerCurrency);
        map.put("makerAmount", makerAmount.toPlainString());
        map.put("makerAddress", makerAddress);
        map.put("makerCounterChainAddress", makerCounterChainAddress);
        map.put("makerKofoId", makerKofoId);
        map.put("takerChain", takerChain);
        map.put("takerCurrency", takerCurrency);
        map.put("takerAmount", takerAmount.toPlainString());
        return map;
    }

    public MakerOrder() {
    }

    public MakerOrder(String makerChain, String makerCurrency, BigDecimal makerAmount, String makerAddress, String makerCounterChainAddress, String makerKofoId, String makerSignature, String takerChain, String takerCurrency, BigDecimal takerAmount) {
        this.makerChain = makerChain;
        this.makerCurrency = makerCurrency;
        this.makerAmount = makerAmount;
        this.makerAddress = makerAddress;
        this.makerCounterChainAddress = makerCounterChainAddress;
        this.makerKofoId = makerKofoId;
        this.takerChain = takerChain;
        this.takerCurrency = takerCurrency;
        this.takerAmount = takerAmount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMakerChain() {
        return makerChain;
    }

    public void setMakerChain(String makerChain) {
        this.makerChain = makerChain;
    }

    public String getMakerCurrency() {
        return makerCurrency;
    }

    public void setMakerCurrency(String makerCurrency) {
        this.makerCurrency = makerCurrency;
    }

    public BigDecimal getMakerAmount() {
        return makerAmount;
    }

    public void setMakerAmount(BigDecimal makerAmount) {
        this.makerAmount = makerAmount;
    }

    public String getMakerAddress() {
        return makerAddress;
    }

    public void setMakerAddress(String makerAddress) {
        this.makerAddress = makerAddress;
    }

    public String getMakerCounterChainAddress() {
        return makerCounterChainAddress;
    }

    public void setMakerCounterChainAddress(String makerCounterChainAddress) {
        this.makerCounterChainAddress = makerCounterChainAddress;
    }

    public String getMakerKofoId() {
        return makerKofoId;
    }

    public void setMakerKofoId(String makerKofoId) {
        this.makerKofoId = makerKofoId;
    }


    public String getTakerChain() {
        return takerChain;
    }

    public void setTakerChain(String takerChain) {
        this.takerChain = takerChain;
    }

    public String getTakerCurrency() {
        return takerCurrency;
    }

    public void setTakerCurrency(String takerCurrency) {
        this.takerCurrency = takerCurrency;
    }

    public BigDecimal getTakerAmount() {
        return takerAmount;
    }

    public void setTakerAmount(BigDecimal takerAmount) {
        this.takerAmount = takerAmount;
    }
}
