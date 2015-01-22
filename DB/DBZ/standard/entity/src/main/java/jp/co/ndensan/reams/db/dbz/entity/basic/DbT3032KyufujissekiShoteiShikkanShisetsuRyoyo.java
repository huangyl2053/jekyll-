package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoの項目定義クラスです
 *
 */
public enum DbT3032KyufujissekiShoteiShikkanShisetsuRyoyo implements IColumnDefinition {
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
    kinkyuShobyoName1(20, 0),
    kinkyuShobyoName2(20, 0),
    kinkyuShobyoName3(20, 0),
    kinkyuChiryoKaishiYMD1(2147483647, 0),
    kinkyuChiryoKaishiYMD2(2147483647, 0),
    kinkyuChiryoKaishiYMD3(2147483647, 0),
    oshinNissu(5, 0),
    oshinIryoKikanName(20, 0),
    tsuinNissu(5, 0),
    tsuinIryoKikanName(20, 0),
    kinkyuChiryoKanriTanisu(10, 0),
    kinkyuChiryoKanriNissu(5, 0),
    kinkyuChiryoKanriSubTotal(10, 0),
    rehabilitationTensu(10, 0),
    shochiTensu(10, 0),
    shujutsuTensu(10, 0),
    masuiTensu(10, 0),
    hoshasenChiryoTensu(10, 0),
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
    kinkyuShisetsuRyoyohiTotalTensu(10, 0),
    shoteiShikkanShisetsuRyoyohiShobyoName1(20, 0),
    shoteiShikkanShisetsuRyoyohiShobyoName2(20, 0),
    shoteiShikkanShisetsuRyoyohiShobyoName3(20, 0),
    shoteiShikkanShisetsuRyoyohiKaishiYMD1(2147483647, 0),
    shoteiShikkanShisetsuRyoyohiKaishiYMD2(2147483647, 0),
    shoteiShikkanShisetsuRyoyohiKaishiYMD3(2147483647, 0),
    shoteiShikkanShisetsuRyoyohiTanisu(10, 0),
    shoteiShikkanShisetsuRyoyohiNissu(5, 0),
    shoteiShikkanShisetsuRyoyohiSubTotal(10, 0),
    atoOshinNissu(5, 0),
    atoTsuinNissu(5, 0),
    atoKinkyuChiryoKanriTanisu(10, 0),
    atoKinkyuChiryoKanriNissu(5, 0),
    atoRehabilitationTensu(10, 0),
    atoShochiTensu(10, 0),
    atoShujutsuTensu(10, 0),
    atoMasuiTensu(10, 0),
    atoHoshasenChiryoTensu(10, 0),
    atoShoteiShikkanShisetsuRyoyoHiTanisu(10, 0),
    atoShoteiShikkanShisetsuRyoyoHiNissu(5, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3032KyufujissekiShoteiShikkanShisetsuRyoyo(int maxLength, int scale) {
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
