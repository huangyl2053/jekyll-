package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付費貸付金強制返還テーブルの項目定義クラスです。
 */
public enum DbT3093KyufuhiKashitsukeKinKyoseiHenkan implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 貸付管理番号
     */
    kashitsukeKanriNo(10, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 返還金区分
     */
    henkanKinKubun(1, 0),
    /**
     * 返還金額
     */
    henkanKingaku(10, 0),
    /**
     * 返還期限
     */
    henkanKigenYMD(2147483647, 0),
    /**
     * 返還理由
     */
    henkanRiyu(200, 0);

    private final int maxLength;
    private final int scale;

    private DbT3093KyufuhiKashitsukeKinKyoseiHenkan(int maxLength, int scale) {
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
