package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績緊急時施設療養テーブルの項目定義クラスです。
 */
public enum DbT3019KyufujissekiKinkyuShisetsuRyoyo implements IColumnDefinition {
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
     * 交換情報識別番号
     */
    kokanJohoShikibetsuNo(2147483647, 0),
    /**
     * 入力識別番号
     */
    inputShikibetsuNo(2147483647, 0),
    /**
     * レコード種別コード
     */
    recodeShubetsuCode(2, 0),
    /**
     * 証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 通し番号
     */
    toshiNo(10, 0),
    /**
     * 緊急時施設療養情報レコード順次番号
     */
    recodeJunjiNo(2, 0),
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
    tsuinIryoKikanName(20, 0),
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
     * リハビリテーション点数
     */
    rehabilitationTensu(10, 0),
    /**
     * 処置点数
     */
    shochiTensu(10, 0),
    /**
     * 手術点数
     */
    shujutsuTensu(10, 0),
    /**
     * 麻酔点数
     */
    masuiTensu(10, 0),
    /**
     * 放射線治療点数
     */
    hoshasenChiryoTensu(10, 0),
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
     * 緊急時施設療養費合計点数
     */
    kinkyuShisetsuRyoyoHiTotalTensu(10, 0),
    /**
     * 後・往診日数
     */
    atoOshinNissu(5, 0),
    /**
     * 後・通院日数
     */
    atoTsuinNissu(5, 0),
    /**
     * 後・緊急時治療管理単位数
     */
    atoKinkyuChiryoKanriTanisu(10, 0),
    /**
     * 後・緊急時治療管理日数
     */
    atoKinkyuChiryoKanriNissu(5, 0),
    /**
     * 後・リハビリテーション点数
     */
    atoRehabilitationTensu(10, 0),
    /**
     * 後・処置点数
     */
    atoShochiTensu(10, 0),
    /**
     * 後・手術点数
     */
    atoShujutsuTensu(10, 0),
    /**
     * 後・麻酔点数
     */
    atoMasuiTensu(10, 0),
    /**
     * 後・放射線治療点数
     */
    atoHoshasenChiryoTensu(10, 0),
    /**
     * 再審査回数
     */
    saishinsaKaisu(5, 0),
    /**
     * 過誤回数
     */
    kagoKaisu(5, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3019KyufujissekiKinkyuShisetsuRyoyo(int maxLength, int scale) {
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
