package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 地区認定調査員テーブルの項目定義クラスです。
 */
public enum DbT5223ChikuNinteiChosain implements IColumnDefinition {
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
     * 調査地区コード
     * <br/>Code（DBE：5002）
     */
    chosaChikuCode(2147483647, 0),
    /**
     * 認定調査委託先コード
     * <br/>認定調査委託先情報
     */
    ninteiChosaItakusakiCode(10, 0),
    /**
     * 認定調査員コード
     * <br/>認定調査員コード
     */
    ninteiChosainCode(8, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 優先番号
     */
    yusenNo(5, 0),
    /**
     * 備考
     */
    biko(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5223ChikuNinteiChosain(int maxLength, int scale) {
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
