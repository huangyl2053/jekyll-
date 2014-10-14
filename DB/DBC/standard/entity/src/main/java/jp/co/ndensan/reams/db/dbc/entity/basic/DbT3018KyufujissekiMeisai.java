package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3018KyufujissekiMeisaiの項目定義クラスです
 *
 */
public enum DbT3018KyufujissekiMeisai implements IColumnDefinition {
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
    serviceShuruiCode(2147483647, 0),
    serviceKomokuCode(2147483647, 0),
    tanisu(5, 0),
    nissuKaisu(5, 0),
    kohi1TaishoNissuKaisu(5, 0),
    kohi2TaishoNissuKaisu(5, 0),
    kohi3TaishoNissuKaisu(5, 0),
    serviceTanisu(10, 0),
    kohi1TaishoServiceTanisu(10, 0),
    kohi2TaishoServiceTanisu(10, 0),
    kohi3TaishoServiceTanisu(10, 0),
    tekiyo(20, 0),
    atoTanisu(5, 0),
    atoNissuKaisu(5, 0),
    atoKohi1TaishoNissuKaisu(5, 0),
    atoKohi2TaishoNissukaisu(5, 0),
    atoKohi3TaishoNissuKaisu(5, 0),
    atoServiceTanisu(10, 0),
    atoKohi1TaishoServiceTanisu(10, 0),
    atoKohi2TaishoServiceTanisu(10, 0),
    atoKohi3TaishoServiceTanisu(10, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3018KyufujissekiMeisai(int maxLength, int scale) {
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
