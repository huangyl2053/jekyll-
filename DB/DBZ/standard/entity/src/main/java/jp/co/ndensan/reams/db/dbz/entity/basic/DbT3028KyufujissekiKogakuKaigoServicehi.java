package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3028KyufujissekiKogakuKaigoServicehiの項目定義クラスです
 *
 */
public enum DbT3028KyufujissekiKogakuKaigoServicehi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
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
    toshiNo(10, 0),
    kyufuSakuseiKubunCode(1, 0),
    kyufuJissekiKubunCode(1, 0),
    uketsukeYMD(2147483647, 0),
    ketteiYMD(2147483647, 0),
    kohi1FutanNo(8, 0),
    kohi2FutanNo(8, 0),
    kohi3FutanNo(8, 0),
    riyoshaFutangaku(10, 0),
    kohi1Futangaku(10, 0),
    kohi2Futangaku(10, 0),
    kohi3Futangaku(10, 0),
    shikyugaku(10, 0),
    kohi1Shikyugaku(10, 0),
    kohi2Shikyugaku(10, 0),
    kohi3Shikyugaku(10, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    sofuYM(2147483647, 0),
    torikomiYM(2147483647, 0),
    sakuseiKubun(1, 0),
    kanriNo(4, 0),
    hokenshaHoyuKyufujissekiJohoSakujoZumiFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3028KyufujissekiKogakuKaigoServicehi(int maxLength, int scale) {
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
