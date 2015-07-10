package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3020KyufujissekiTokuteiSinryohiの項目定義クラスです
 *
 */
public enum DbT3020KyufujissekiTokuteiSinryohi implements IColumnDefinition {
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
    shobyoName(20, 0),
    hokenShidoKanriryo(10, 0),
    hokenTanjunXsen(10, 0),
    hokenRehabilitation(10, 0),
    hokenSeishinkaSemmonRyoho(10, 0),
    hokenTotalTanisu(10, 0),
    kohi1ShidoKanriryo(10, 0),
    kohi1TanjunXsen(10, 0),
    kohi1Rehabilitation(10, 0),
    kohi1SeishinkaSemmonRyoho(10, 0),
    kohi1TotalTanisu(10, 0),
    kohi2ShidoKanriryo(10, 0),
    kohi2TanjunXsen(10, 0),
    kohi2Rehabilitation(10, 0),
    kohi2SeishinkaSemmonRyoho(10, 0),
    kohi2TotalTanisu(10, 0),
    kohi3ShidoKanriryo(10, 0),
    kohi3TanjunXsen(10, 0),
    kohi3Rehabilitation(10, 0),
    kohi3SeishinkaSemmonRyoho(10, 0),
    kohi3TotalTanisu(10, 0),
    tekiyo1(32, 0),
    tekiyo2(32, 0),
    tekiyo3(32, 0),
    tekiyo4(32, 0),
    tekiyo5(32, 0),
    tekiyo6(32, 0),
    tekiyo7(32, 0),
    tekiyo8(32, 0),
    tekiyo9(32, 0),
    tekiyo10(32, 0),
    tekiyo11(32, 0),
    tekiyo12(32, 0),
    tekiyo13(32, 0),
    tekiyo14(32, 0),
    tekiyo15(32, 0),
    tekiyo16(32, 0),
    tekiyo17(32, 0),
    tekiyo18(32, 0),
    tekiyo19(32, 0),
    tekiyo20(32, 0),
    atoHokenShidoKanriryo(10, 0),
    atoHokenTanjunXsen(10, 0),
    atoHokenRehabilitation(10, 0),
    atoHokenSeishinkaSemmonRyoho(10, 0),
    atoKohi1ShidoKanriryo(10, 0),
    atoKohi1TanjunXsen(10, 0),
    atoKohi1Rehabilitation(10, 0),
    atoKohi1SeishinkaSemmonRyoho(10, 0),
    atoKohi2ShidoKanriryo(10, 0),
    atoKohi2TanjunXsen(10, 0),
    atoKohi2Rehabilitation(10, 0),
    atoKohi2SeishinkaSemmonRyoho(10, 0),
    atoKohi3ShidoKanriryo(10, 0),
    atoKohi3TanjunXsen(10, 0),
    atoKohi3Rehabilitation(10, 0),
    atoKohi3SeishinkaSemmonRyoho(10, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3020KyufujissekiTokuteiSinryohi(int maxLength, int scale) {
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
