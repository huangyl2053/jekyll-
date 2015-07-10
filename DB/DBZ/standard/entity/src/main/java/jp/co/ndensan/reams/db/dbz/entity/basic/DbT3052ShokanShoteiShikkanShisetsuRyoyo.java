package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3052ShokanShoteiShikkanShisetsuRyoyoの項目定義クラスです
 *
 */
public enum DbT3052ShokanShoteiShikkanShisetsuRyoyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    seiriNo(10, 0),
    jigyoshaNo(2147483647, 0),
    yoshikiNo(4, 0),
    junjiNo(4, 0),
    shoriTimestamp(2147483647, 0),
    kinkyuShobyoName1(20, 0),
    kinkyuShobyoName2(20, 0),
    kinkyuShobyoName3(20, 0),
    kinkyuChiryoKaishiYMD1(2147483647, 0),
    kinkyuChiryoKaishiYMD2(2147483647, 0),
    kinkyuChiryoKaishiYMD3(2147483647, 0),
    oshinNissu(5, 0),
    oshinIryoKikanName(20, 0),
    tsuinNissu(5, 0),
    tsuinKikanName(20, 0),
    kinkyuChiryoKanriTanisu(10, 0),
    kinkyuChiryoKanriNissu(5, 0),
    kinkyuChiryoKanriSubTotal(10, 0),
    rehabilitationTanisu(10, 0),
    shochiTanisu(10, 0),
    shujutsuTanisu(10, 0),
    masuiTanisu(10, 0),
    hoshasenChiryoTanisu(10, 0),
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
    kinkyuShisetsuRyoyohiTotalTanisu(10, 0),
    shoteiShikkanShobyoName1(20, 0),
    shoteiShikkanShobyoName2(20, 0),
    shoteiShikkanShobyoName3(20, 0),
    shoteiShikkanShobyoKaishiYMD1(2147483647, 0),
    shoteiShikkanShobyoKaishiYMD2(2147483647, 0),
    shoteiShikkanShobyoKaishiYMD3(2147483647, 0),
    shoteiShikkanTanisu(10, 0),
    shoteiShikkanNissu(5, 0),
    shoteiShikkanSubTotal(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3052ShokanShoteiShikkanShisetsuRyoyo(int maxLength, int scale) {
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
