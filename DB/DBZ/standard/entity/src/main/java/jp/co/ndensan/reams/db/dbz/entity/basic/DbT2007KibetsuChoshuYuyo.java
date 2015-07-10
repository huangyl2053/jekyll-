package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT2007KibetsuChoshuYuyoの項目定義クラスです
 *
 */
public enum DbT2007KibetsuChoshuYuyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    choteiNendo(2147483647, 0),
    fukaNendo(2147483647, 0),
    tsuchishoNo(2147483647, 0),
    shoriTimestamp(29, 0),
    choshuHoho(1, 0),
    ki(10, 0),
    yuyoStartYMD(2147483647, 0),
    yuyoEndYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2007KibetsuChoshuYuyo(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
