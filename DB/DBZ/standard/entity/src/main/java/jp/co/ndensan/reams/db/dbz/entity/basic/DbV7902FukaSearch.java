package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV7902FukaSearchの項目定義クラスです
 *
 */
public enum DbV7902FukaSearch implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    choteiNendo(2147483647, 0),
    fukaNendo(2147483647, 0),
    tsuchishoNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    hihodaichoHihokenshaNo(10, 0);

    private final int maxLength;
    private final int scale;

    private DbV7902FukaSearch(int maxLength, int scale) {
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
