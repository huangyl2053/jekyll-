package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 新旧調査委託先調査員番号変換テーブルテーブルの項目定義クラスです。
 */
public enum DbT7029ShinKyuChosaItakusakiChosainNoHenkan implements IColumnDefinition {
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
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 新調査委託先番号
     */
    shinChosaItakusakiNo(10, 0),
    /**
     * 新調査員番号
     */
    shinChosainNo(8, 0),
    /**
     * 旧調査委託先番号
     */
    kyuChosaItakusakiNo(10, 0),
    /**
     * 旧調査員番号
     */
    kyuChosainNo(8, 0),
    /**
     * 市町村コード２
     */
    shichosonCode2(2147483647, 0),
    /**
     * 旧調査委託先番号２
     */
    kyuChosaItakusakiNo2(10, 0),
    /**
     * 旧調査員番号２
     */
    kyuChosainNo2(8, 0);

    private final int maxLength;
    private final int scale;

    private DbT7029ShinKyuChosaItakusakiChosainNoHenkan(int maxLength, int scale) {
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
