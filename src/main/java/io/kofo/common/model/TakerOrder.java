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
public class TakerOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String makerChain;
    private String makerCurrency;
    private BigDecimal makerAmount;
    private String takerAddress;
    private String takerCounterChainAddress;
    private String takerKofoId;
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
        map.put("takerAddress", takerAddress);
        map.put("takerCounterChainAddress", takerCounterChainAddress);
        map.put("takerKofoId", takerKofoId);
        map.put("takerChain", takerChain);
        map.put("takerCurrency", takerCurrency);
        map.put("takerAmount", takerAmount.toPlainString());
        return map;
    }

    public TakerOrder() {
    }

    public TakerOrder(String makerChain, String makerCurrency, BigDecimal makerAmount, String takerAddress, String takerCounterChainAddress, String takerKofoId, String takerChain, String takerCurrency, BigDecimal takerAmount) {
        this.makerChain = makerChain;
        this.makerCurrency = makerCurrency;
        this.makerAmount = makerAmount;
        this.takerAddress = takerAddress;
        this.takerCounterChainAddress = takerCounterChainAddress;
        this.takerKofoId = takerKofoId;
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

    public String getTakerAddress() {
        return takerAddress;
    }

    public void setTakerAddress(String takerAddress) {
        this.takerAddress = takerAddress;
    }

    public String getTakerCounterChainAddress() {
        return takerCounterChainAddress;
    }

    public void setTakerCounterChainAddress(String takerCounterChainAddress) {
        this.takerCounterChainAddress = takerCounterChainAddress;
    }

    public String getTakerKofoId() {
        return takerKofoId;
    }

    public void setTakerKofoId(String takerKofoId) {
        this.takerKofoId = takerKofoId;
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
