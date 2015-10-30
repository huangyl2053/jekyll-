package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定1.5次判定結果情報テーブルの項目定義クラスです。
 */
public enum DbT5510IchiGojiHanteiKekkaJoho implements IColumnDefinition {
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
     * 要介護認定1.5次判定年月日
     */
    ichiGojiHanteiYMD(2147483647, 0),
    /**
     * 要介護認定1.5次判定結果コード
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     */
    ichiGojiHanteiKekkaCode(2147483647, 0),
    /**
     * 要介護認定1.5次判定結果コード（認知症加算）
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））
     */
    ichiGojiHanteiKekkaNinchishoKasanCode(2147483647, 0),
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
     * 要介護認定1.5次判定警告コード
     * <br/>Enum（DBD：一次判定警告コード09）
     */
    ichiGojiHnateiKeikokuCode(2147483647, 0),
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
    suiteiKyufuKubunCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5510IchiGojiHanteiKekkaJoho(int maxLength, int scale) {
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
