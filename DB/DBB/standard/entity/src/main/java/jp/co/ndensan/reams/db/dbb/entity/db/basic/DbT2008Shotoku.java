package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護所得テーブルの項目定義クラスです。
 */
public enum DbT2008Shotoku implements IColumnDefinition {
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
     * 所得年度
     */
    shotokuNendo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(10, 0),
    /**
     * 非課税区分（住民税減免前）
     * <br/>保険料賦課の際に参照する
     */
    hiKazeiKubun(1, 0),
    /**
     * 非課税区分（住民税減免後）
     * <br/>給付（高額等）で参照する
     */
    hiKazeiKubunGemmenGo(1, 0),
    /**
     * 合計所得金額
     */
    gokeiShotokuGaku(12, 0),
    /**
     * 公的年金収入額
     */
    nenkiniShunyuGaku(12, 0),
    /**
     * 激変緩和措置区分
     */
    gekihenKanwaKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT2008Shotoku(int maxLength, int scale) {
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
