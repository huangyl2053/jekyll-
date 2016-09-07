package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護予防・日常生活支援総合事業サービスコードテーブルの項目定義クラスです。
 */
public enum DbT7122SogoJigyoServiceCode implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * サービス項目コード
     */
    serviceKomokuCode(2147483647, 0),
    /**
     * 適用開始年月
     */
    tekiyoKaishiYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 適用終了年月
     */
    tekiyoShuryoYM(2147483647, 0),
    /**
     * サービス名称
     */
    serviceMeisho(100, 0),
    /**
     * 単位数
     */
    taniSu(10, 0),
    /**
     * 限度額対象外フラグ
     */
    gendoGakuTaishogaiFlag(1, 0),
    /**
     * 単位数識別コード
     */
    taniSuShikibetsuCode(2, 0),
    /**
     * 外部サービス利用型区分
     */
    gaibuServiceRiyoKubun(1, 0),
    /**
     * 特別地域加算フラグ
     */
    tokubetsuChiikiKasanFlag(1, 0),
    /**
     * 利用者負担定率／定額区分
     */
    teiRitsu_TeiGakuKubun(1, 0),
    /**
     * 利用者負担額
     * <br/>利用者負担定率／定額区分が”2”（定額）時
     */
    riyoshaFutanGaku(10, 0),
    /**
     * 給付率
     * <br/>利用者負担定率／定額区分が”1”（定率）時
     */
    kyufuRitsu(2147483647, 0),
    /**
     * 二次予防事業対象者実施区分
     */
    nijiYoboTaishosha_JissiKubun(1, 0),
    /**
     * 要支援１受給者実施区分
     */
    yoShien1_JisshiKubun(1, 0),
    /**
     * 要支援２受給者実施区分
     */
    yoShien2_JisshiKubun(1, 0),
    /**
     * 対象事業者実施区分
     */
    taishoJigyosha_JisshiKubun(1, 0),
    /**
     * 算定単位区分
     * <br/>01：1回につき、02：1日につき、03：1月につき、05：1週間につき
     */
    santeiTaniKubun(2, 0),
    /**
     * 制限日数・回数
     */
    seigenNissuKaisu(5, 0),
    /**
     * 算定回数制限期間区分
     * <br/>01：1月につき、08：1日につき
     */
    santeiKaisuSeigenKikanKubun(2, 0),
    /**
     * 送付区分
     * <br/>サービスコード異動連絡票の送付区分（1：送付不要、2：送付対象、3：送付済み）
     */
    sofuKubun(1, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * 新規・変更異動年月日
     */
    shinkiHenkoIdoYMD(2147483647, 0),
    /**
     * 終了・異動年月日
     */
    shuryoIdoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7122SogoJigyoServiceCode(int maxLength, int scale) {
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
