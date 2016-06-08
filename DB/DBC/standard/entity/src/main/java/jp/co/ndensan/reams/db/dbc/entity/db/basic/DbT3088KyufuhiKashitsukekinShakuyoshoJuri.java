package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付費貸付金借用書受理テーブルの項目定義クラスです。
 */
public enum DbT3088KyufuhiKashitsukekinShakuyoshoJuri implements IColumnDefinition {
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
    hihokenshaNo(2147483647, 0),
    /**
     * 借入申請年月日
     */
    kariireShinseiYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 借受年月日
     */
    kariukeYMD(2147483647, 0),
    /**
     * 借受人郵便番号
     */
    kariukeninYubinNo(2147483647, 0),
    /**
     * 借受人住所
     */
    kariukeninJusho(100, 0),
    /**
     * 借受人氏名カナ
     */
    kariukeninShimeiKana(2147483647, 0),
    /**
     * 借受人氏名
     */
    kariukeninShimei(2147483647, 0),
    /**
     * 借受人電話番号
     */
    kariukeninTelNo(2147483647, 0),
    /**
     * 保証人氏名カナ
     */
    hoshoninShimeiKana(2147483647, 0),
    /**
     * 保証人氏名
     */
    hoshoninShimei(2147483647, 0),
    /**
     * 保証人郵便番号
     */
    hoshoninYubinNo(2147483647, 0),
    /**
     * 保証人住所
     */
    hoshoninJusho(100, 0),
    /**
     * 保証人電話番号
     */
    hoshoninTelNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3088KyufuhiKashitsukekinShakuyoshoJuri(int maxLength, int scale) {
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
