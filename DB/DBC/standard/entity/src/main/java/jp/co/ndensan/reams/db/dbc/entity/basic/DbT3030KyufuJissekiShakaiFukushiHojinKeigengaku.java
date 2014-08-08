package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuの項目定義クラスです
 *
 */
public enum DbT3030KyufuJissekiShakaiFukushiHojinKeigengaku implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    kokanJohoShikibetsuNo(2147483647, 0),
    inputShikibetsuNo(2147483647, 0),
    recodeShubetsuCode(2, 0),
    shokisaiHokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    jigyoshoNo(2147483647, 0),
    toshiNo(10, 0),
    keigenritsu(5, 0),
    serviceSyuruiCode(2147483647, 0),
    riyoshaFutanTotal(10, 0),
    keigengaku(10, 0),
    keigengoRiyoshaFutangaku(10, 0),
    biko(20, 0),
    atoRiyoshaFutanTotal(10, 0),
    atoKeigengaku(10, 0),
    atoKeigengoRiyoshaFutangaku(10, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3030KyufuJissekiShakaiFukushiHojinKeigengaku(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
