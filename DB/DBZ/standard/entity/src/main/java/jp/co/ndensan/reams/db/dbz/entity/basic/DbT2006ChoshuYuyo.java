package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT2006ChoshuYuyoの項目定義クラスです
 *
 */
public enum DbT2006ChoshuYuyo implements IColumnDefinition {
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
    shinseiYMD(2147483647, 0),
    ketteiYMD(2147483647, 0),
    torikeshiYMD(2147483647, 0),
    jotaiKubun(1, 0),
    sakuseiKubun(1, 0),
    shinseiJiyu(2147483647, 0),
    yuyoJiyuCode(2147483647, 0),
    yuyoJiyu(2147483647, 0),
    yuyoTorikeshiJiyuCode(2147483647, 0),
    yuyoTorikeshiJiyu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2006ChoshuYuyo(int maxLength, int scale) {
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
