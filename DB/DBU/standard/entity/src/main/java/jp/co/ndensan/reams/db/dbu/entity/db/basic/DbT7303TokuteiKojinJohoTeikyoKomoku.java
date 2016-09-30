package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特定個人情報提供項目テーブルの項目定義クラスです。
 */
public enum DbT7303TokuteiKojinJohoTeikyoKomoku implements IColumnDefinition {
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
     * 特定個人情報名コード
     */
    tokuteiKojinJohoMeiCode(16, 0),
    /**
     * データセット番号
     */
    dataSetNo(4, 0),
    /**
     * 版番号
     */
    hanNo(4, 0),
    /**
     * 特定個人情報項目コード
     */
    tokuteiKojinJohoKomokuCode(16, 0),
    /**
     * 特定個人情報項目区分
     */
    tokuteiKojinJohoKomokuKubun(1, 0),
    /**
     * 提供内容項目番号
     */
    teikyoNaiyoKomokuNo(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT7303TokuteiKojinJohoTeikyoKomoku(int maxLength, int scale) {
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
