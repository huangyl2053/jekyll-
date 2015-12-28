package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定一次判定結果情報テーブルの項目定義クラスです。
 */
public enum DbT5116IchijiHanteiKekkaJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 仮一次判定区分
     * <br/>Enum（DBE：仮一次判定区分）
     */
    kariIchijiHanteiKubun(1, 0),
    /**
     * 要介護認定一次判定年月日
     */
    ichijiHanteiYMD(2147483647, 0),
    /**
     * 要介護認定一次判定結果コード
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     */
    ichijiHanteiKekkaCode(2147483647, 0),
    /**
     * 要介護認定一次判定結果コード（認知症加算）
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））要介護認定一次判定結果コード（重み）
     */
    ichijiHanteiKekkaNinchishoKasanCode(2147483647, 0),
    /**
     * 要介護認定等基準時間
     */
    kijunJikan(5, 0),
    /**
     * 要介護認定等基準時間（食事）
     */
    kijunJikanShokuji(5, 0),
    /**
     * 要介護認定等基準時間（排泄）
     */
    kijunJikanHaisetsu(5, 0),
    /**
     * 要介護認定等基準時間（移動）
     */
    kijunJikanIdo(5, 0),
    /**
     * 要介護認定等基準時間（清潔保持）
     */
    kijunJikanSeiketsuHoji(5, 0),
    /**
     * 要介護認定等基準時間（間接ケア）
     */
    kijunJikanKansetsuCare(5, 0),
    /**
     * 要介護認定等基準時間（BPSD関連）
     */
    kijunJikanBPSDKanren(5, 0),
    /**
     * 要介護認定等基準時間（機能訓練）
     */
    kijunJikanKinoKunren(5, 0),
    /**
     * 要介護認定等基準時間（医療関連）
     */
    kijunJikanIryoKanren(5, 0),
    /**
     * 要介護認定等基準時間（認知症加算）
     */
    kijunJikanNinchishoKasan(5, 0),
    /**
     * 中間評価項目得点第1群
     */
    chukanHyokaKomoku1gun(5, 0),
    /**
     * 中間評価項目得点第2群
     */
    chukanHyokaKomoku2gun(5, 0),
    /**
     * 中間評価項目得点第3群
     */
    chukanHyokaKomoku3gun(5, 0),
    /**
     * 中間評価項目得点第4群
     */
    chukanHyokaKomoku4gun(5, 0),
    /**
     * 中間評価項目得点第5群
     */
    chukanHyokaKomoku5gun(5, 0),
    /**
     * 中間評価項目得点第6群
     */
    chukanHyokaKomoku6gun(5, 0),
    /**
     * 中間評価項目得点第7群
     */
    chukanHyokaKomoku7gun(5, 0),
    /**
     * 要介護認定一次判定警告コード
     */
    ichijiHnateiKeikokuCode(62, 0),
    /**
     * 要介護認定状態の安定性コード
     * <br/>Enum（DBE：要介護認定状態の安定性コード）
     */
    jotaiAnteiseiCode(2147483647, 0),
    /**
     * 認知症自立度Ⅱ以上の蓋然性
     */
    ninchishoJiritsudoIIijoNoGaizensei(131089, 0),
    /**
     * 認知機能及び状態安定性から推定される給付区分コード
     * <br/>Enum（DBE：認知機能及び状態安定性から推定される給付区分コード）
     */
    suiteiKyufuKubunCode(2147483647, 0),
    /**
     * 運動能力の低下していない認知症高齢者の指標コード
     * <br/>Enum（DBE：運動能力の低下していない認知症高齢者の指標コード）
     */
    ninchishoKoreishaShihyoCode(2147483647, 0),
    /**
     * 日常生活自立度の組み合わせ（自立）
     */
    jiritsudoKumiawase1(5, 0),
    /**
     * 日常生活自立度の組み合わせ（要支援）
     */
    jiritsudoKumiawase2(5, 0),
    /**
     * 日常生活自立度の組み合わせ（要介護１）
     */
    jiritsudoKumiawase3(5, 0),
    /**
     * 日常生活自立度の組み合わせ（要介護２）
     */
    jiritsudoKumiawase4(5, 0),
    /**
     * 日常生活自立度の組み合わせ（要介護３）
     */
    jiritsudoKumiawase5(5, 0),
    /**
     * 日常生活自立度の組み合わせ（要介護４）
     */
    jiritsudoKumiawase6(5, 0),
    /**
     * 日常生活自立度の組み合わせ（要介護５）
     */
    jiritsudoKumiawase7(5, 0),
    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コード
     * <br/>Enum（DBE：認知症高齢者の日常生活自立度の蓋然性評価コード）
     */
    gaizenseiHyokaCode(2147483647, 0),
    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価％
     */
    gaizenseiHyokaPercent(5, 0),
    /**
     * 一次判定結果送付区分
     * <br/>Enum（DBE：一次判定結果送付区分）
     */
    ichijiHanteiSofuKubun(1, 0),
    /**
     * 一次判定結果送付年月日
     */
    ichijiHanteiKekkaSofuYMD(2147483647, 0),
    /**
     * チャート
     */
    chert(2, 0),
    /**
     * 状態像
     */
    jotaizo(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT5116IchijiHanteiKekkaJoho(int maxLength, int scale) {
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
