package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3031KyufuJissekiCareManagementHiの項目定義クラスです
 *
 */
public enum DbT3031KyufuJissekiCareManagementHi implements IColumnDefinition {
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
    shiteiKijungaitoJigyoshoKubunCode(1, 0),
    kyotakuServiceSakuseiIraiYMD(2147483647, 0),
    toshiNo(10, 0),
    servicePlanhiMeisaiLineNo(2, 0),
    tanisuTanka(6, 0),
    serviceCode(2147483647, 0),
    tanisu(5, 0),
    kaisu(5, 0),
    serviceTanisu(10, 0),
    serivceTanisuTotal(10, 0),
    seikyuKingaku(10, 0),
    tantoKaigoShienSemmoninNo(8, 0),
    tekiyo(20, 0),
    riyoushaFutangaku(10, 0),
    atoTanisu(5, 0),
    atoKaisu(5, 0),
    atoServiceTanisu(10, 0),
    atoServiceTanisuTotal(10, 0),
    atoSeikyuKingaku(10, 0),
    atoRiyoshaFutangaku(10, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3031KyufuJissekiCareManagementHi(int maxLength, int scale) {
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
