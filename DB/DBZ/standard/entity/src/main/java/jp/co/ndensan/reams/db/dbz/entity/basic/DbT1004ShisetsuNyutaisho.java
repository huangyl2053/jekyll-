package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1004ShisetsuNyutaishoの項目定義クラスです
 *
 */
public enum DbT1004ShisetsuNyutaisho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonCode(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    shoriTimestamp(29, 0),
    daichoShubetsu(1, 0),
    nyushoShisetsuShurui(2, 0),
    nyushoShisetsuCode(10, 0),
    nyushoYMD(2147483647, 0),
    taishoYMD(2147483647, 0),
    nyushoShoriYMD(2147483647, 0),
    taishoShoriYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1004ShisetsuNyutaisho(int maxLength, int scale) {
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
