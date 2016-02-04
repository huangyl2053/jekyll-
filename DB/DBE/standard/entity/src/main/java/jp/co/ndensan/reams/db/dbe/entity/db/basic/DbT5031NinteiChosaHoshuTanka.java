package jp.co.ndensan.reams.db.dbe.entity.db.basic.;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5031NinteiChosaHoshuTankaの項目定義クラスです
 *
 */
public enum DbT5031NinteiChosaHoshuTanka implements IColumnDefinition {
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
     * 調査区分
     */
    chosaKubun(2147483647, 0),
    /**
     * 訪問種別
     */
    homonShubetsu(2147483647, 0),
    /**
     * 開始年月
     */
    kaishiYM(2147483647, 0),
    /**
     * 終了年月
     */
    shuryoYM(2147483647, 0),
    /**
     * 単価
     */
    tanka(13, 0);

    private final int maxLength;
    private final int scale;

    private DbT5031NinteiChosaHoshuTanka(int maxLength, int scale) {
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
