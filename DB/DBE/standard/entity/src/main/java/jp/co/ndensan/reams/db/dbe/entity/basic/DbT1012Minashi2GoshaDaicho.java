package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1012Minashi2GoshaDaichoの項目定義クラスです
 *
 */
public enum DbT1012Minashi2GoshaDaicho implements IColumnDefinition {
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
    hihokenshaNo(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    hihokenshaKubunCode(1, 0),
    minashi2GoshaTorokuYMD(2147483647, 0),
    minashi2GoshaKaijoYMD(2147483647, 0),
    fukushiHihokenshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1012Minashi2GoshaDaicho(int maxLength, int scale) {
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
