package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 利用者負担割合明細テーブルの項目定義クラスです。
 * <br/> 利用者負担割合の明細
 */
public enum DbT3114RiyoshaFutanWariaiMeisai implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 年度
     */
    nendo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 枝番号
     */
    edaNo(5, 0),
    /**
     * 資格区分
     * <br/>01：1号被保険者
     * <br/>02：2号被保険者
     * <br/>03：2号被保険者（基準日時点1号被保険者）
     */
    shikakuKubun(2, 0),
    /**
     * 負担割合区分
     * <br/>10：1割　20：2割
     */
    futanWariaiKubun(2, 0),
    /**
     * 有効開始日
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * 有効終了日
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * 本人合計所得金額
     */
    honninGoukeiShotokuGaku(12, 0),
    /**
     * 世帯１号被保険者数
     */
    setaiIchigouHihoknehsaSu(5, 0),
    /**
     * 年金収入合計
     */
    nenkinShunyuGoukei(12, 0),
    /**
     * その他の合計所得金額合計
     */
    sonotanoGoukeiShotokuKingakuGoukei(12, 0),
    /**
     * 更正理由
     */
    koseiRiyu(2147483647, 0),
    /**
     * 世帯コード
     */
    setaiCd(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3114RiyoshaFutanWariaiMeisai(int maxLength, int scale) {
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
