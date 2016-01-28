package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求所定疾患施設療養費等テーブルの項目定義クラスです。
 */
public enum DbT3052ShokanShoteiShikkanShisetsuRyoyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 様式番号
     */
    yoshikiNo(4, 0),
    /**
     * 順次番号
     * <br/>複数レコード対応のため
     */
    junjiNo(4, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 緊急時傷病名１
     */
    kinkyuShobyoName1(20, 0),
    /**
     * 緊急時傷病名２
     */
    kinkyuShobyoName2(20, 0),
    /**
     * 緊急時傷病名３
     */
    kinkyuShobyoName3(20, 0),
    /**
     * 緊急時治療開始年月日１
     */
    kinkyuChiryoKaishiYMD1(2147483647, 0),
    /**
     * 緊急時治療開始年月日２
     */
    kinkyuChiryoKaishiYMD2(2147483647, 0),
    /**
     * 緊急時治療開始年月日３
     */
    kinkyuChiryoKaishiYMD3(2147483647, 0),
    /**
     * 往診日数
     */
    oshinNissu(5, 0),
    /**
     * 往診医療機関名
     */
    oshinIryoKikanName(20, 0),
    /**
     * 通院日数
     */
    tsuinNissu(5, 0),
    /**
     * 通院医療機関名
     */
    tsuinKikanName(20, 0),
    /**
     * 緊急時治療管理単位数
     */
    kinkyuChiryoKanriTanisu(10, 0),
    /**
     * 緊急時治療管理日数
     */
    kinkyuChiryoKanriNissu(5, 0),
    /**
     * 緊急時治療管理小計
     */
    kinkyuChiryoKanriSubTotal(10, 0),
    /**
     * リハビリテーション単位数
     */
    rehabilitationTanisu(10, 0),
    /**
     * 処置単位数
     */
    shochiTanisu(10, 0),
    /**
     * 手術単位数
     */
    shujutsuTanisu(10, 0),
    /**
     * 麻酔単位数
     */
    masuiTanisu(10, 0),
    /**
     * 放射線治療単位数
     */
    hoshasenChiryoTanisu(10, 0),
    /**
     * 摘要１
     */
    tekiyo1(32, 0),
    /**
     * 摘要２
     */
    tekiyo2(32, 0),
    /**
     * 摘要３
     */
    tekiyo3(32, 0),
    /**
     * 摘要４
     */
    tekiyo4(32, 0),
    /**
     * 摘要５
     */
    tekiyo5(32, 0),
    /**
     * 摘要６
     */
    tekiyo6(32, 0),
    /**
     * 摘要７
     */
    tekiyo7(32, 0),
    /**
     * 摘要８
     */
    tekiyo8(32, 0),
    /**
     * 摘要９
     */
    tekiyo9(32, 0),
    /**
     * 摘要１０
     */
    tekiyo10(32, 0),
    /**
     * 摘要１１
     */
    tekiyo11(32, 0),
    /**
     * 摘要１２
     */
    tekiyo12(32, 0),
    /**
     * 摘要１３
     */
    tekiyo13(32, 0),
    /**
     * 摘要１４
     */
    tekiyo14(32, 0),
    /**
     * 摘要１５
     */
    tekiyo15(32, 0),
    /**
     * 摘要１６
     */
    tekiyo16(32, 0),
    /**
     * 摘要１７
     */
    tekiyo17(32, 0),
    /**
     * 摘要１８
     */
    tekiyo18(32, 0),
    /**
     * 摘要１９
     */
    tekiyo19(32, 0),
    /**
     * 摘要２０
     */
    tekiyo20(32, 0),
    /**
     * 緊急時施設療養費合計単位数
     */
    kinkyuShisetsuRyoyohiTotalTanisu(10, 0),
    /**
     * 所定疾患施設療養費傷病名１
     */
    shoteiShikkanShobyoName1(20, 0),
    /**
     * 所定疾患施設療養費傷病名２
     */
    shoteiShikkanShobyoName2(20, 0),
    /**
     * 所定疾患施設療養費傷病名３
     */
    shoteiShikkanShobyoName3(20, 0),
    /**
     * 所定疾患施設療養費開始年月日１
     */
    shoteiShikkanShobyoKaishiYMD1(2147483647, 0),
    /**
     * 所定疾患施設療養費開始年月日２
     */
    shoteiShikkanShobyoKaishiYMD2(2147483647, 0),
    /**
     * 所定疾患施設療養費開始年月日３
     */
    shoteiShikkanShobyoKaishiYMD3(2147483647, 0),
    /**
     * 所定疾患施設療養費単位数
     */
    shoteiShikkanTanisu(10, 0),
    /**
     * 所定疾患施設療養費日数
     */
    shoteiShikkanNissu(5, 0),
    /**
     * 所定疾患施設療養費小計
     */
    shoteiShikkanSubTotal(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3052ShokanShoteiShikkanShisetsuRyoyo(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
