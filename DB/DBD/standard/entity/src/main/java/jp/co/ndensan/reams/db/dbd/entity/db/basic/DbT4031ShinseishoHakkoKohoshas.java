package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 申請書発行候補者テーブルの項目定義クラスです。
 * <br/> 申請書把握処理で候補者として判断された情報を保持する。
 */
public enum DbT4031ShinseishoHakkoKohoshas implements IColumnDefinition {
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
     * 把握処理ID
     */
    haakuShoriID(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 更新認定フラグ
     */
    willBeRenewed(1, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 世帯課税区分
     */
    setaiKazeiKubun(1, 0),
    /**
     * 本人課税区分
     */
    honninKazeiKubun(1, 0),
    /**
     * 老齢受給者フラグ
     */
    isRoreiFukushiNenkinJukyusha(1, 0),
    /**
     * 生保受給者フラグ
     */
    isSeikatsuHogoJukyusha(1, 0),
    /**
     * 利用者負担段階
     */
    riyoshaFutanDankai(1, 0),
    /**
     * 合計所得金額
     */
    gokeiShotokuKingaku(12, 0),
    /**
     * 年金収入額
     */
    nenkinShunyuGaku(12, 0),
    /**
     * 非課税年金勘案額
     * <br/>減免減額申請書発行用対象者把握時に把握された、非課税年金対象者テーブルから引用する金額
     */
    hikazeinenkinKananGaku(12, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4031ShinseishoHakkoKohoshas(int maxLength, int scale) {
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
