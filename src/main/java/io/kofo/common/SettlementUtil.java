package io.kofo.common;

import io.kofo.common.model.MakerOrder;
import io.kofo.common.model.TakerOrder;

/**
 * author: fanyongpeng
 * date: 2019/2/22
 **/
public class SettlementUtil {
    /**
     * Calculate the signature string of maker order
     * @param kofoSecretHex
     * @param order
     * @return
     */
    public static String signMakerOrder(String kofoSecretHex, MakerOrder order) {
        checkOrder(order);
        return KofoUtil.sign(kofoSecretHex, order.toSignatureString());
    }

    /**
     * Calculate the signature string of taker order
     * @param kofoSecretHex
     * @param order
     * @return
     */
    public static String signTakerOrder(String kofoSecretHex, TakerOrder order) {
        checkOrder(order);
        return KofoUtil.sign(kofoSecretHex, order.toSignatureString());
    }

    private static void checkOrder(MakerOrder order) {
        Assert.notNull(order,"order is null");
        Assert.notBlank(order.getMakerChain());
        Assert.notBlank(order.getMakerCurrency());
        Assert.notNull(order.getMakerAmount());
        Assert.notBlank(order.getMakerAddress());
        Assert.notBlank(order.getMakerCounterChainAddress());
        Assert.notBlank(order.getMakerKofoId());
        Assert.notBlank(order.getTakerChain());
        Assert.notBlank(order.getTakerCurrency());
        Assert.notNull(order.getTakerAmount());
    }

    private static void checkOrder(TakerOrder order) {
        Assert.notNull(order,"order is null");
        Assert.notBlank(order.getMakerChain());
        Assert.notBlank(order.getMakerCurrency());
        Assert.notNull(order.getMakerAmount());
        Assert.notBlank(order.getTakerAddress());
        Assert.notBlank(order.getTakerCounterChainAddress());
        Assert.notBlank(order.getTakerKofoId());
        Assert.notBlank(order.getTakerChain());
        Assert.notBlank(order.getTakerCurrency());
        Assert.notNull(order.getTakerAmount());
    }


}
