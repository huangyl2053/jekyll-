package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoの項目定義クラスです
 *
 */
public enum DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo implements IColumnDefinition {
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
    jigyoshoNo(2147483647, 0),
    toshiNo(10, 0),
    recodeJunjiNo(2, 0),
    shobyoName(50, 0),
    shikibetsuNo(2, 0),
    tanisu(5, 0),
    hokenKaisu(5, 0),
    hokenServiceTanisu(10, 0),
    hokenTotalTanisu(10, 0),
    kohi1Kaisu(5, 0),
    kohi1ServiceTanisu(10, 0),
    kohi1TotalTanisu(10, 0),
    kohi2Kaisu(5, 0),
    kohi2ServiceTanisu(10, 0),
    kohi2TotalTanisu(10, 0),
    kohi3Kaisu(5, 0),
    kohi3ServiceTanisu(10, 0),
    kohi3TotalTanisu(10, 0),
    tekiyo(50, 0),
    atoTanisu(5, 0),
    atoHokenKaisu(5, 0),
    atoHokenServiceTanisu(10, 0),
    atoHokenTotalTanisu(10, 0),
    atoKohi1Kaisu(5, 0),
    atoKohi1ServiceTanisu(10, 0),
    atoKohi1TotalTanisu(10, 0),
    atoKohi2Kaisu(5, 0),
    atoKohi2ServiceTanisu(10, 0),
    atoKohi2TotalTanisu(10, 0),
    atoKohi3Kaisu(5, 0),
    atoKohi3ServiceTanisu(10, 0),
    atoKohi3TotalTanisu(10, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo(int maxLength, int scale) {
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
