package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7055GappeiJohoの項目定義クラスです
 *
 */
public enum DbT7055GappeiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    gappeiYMD(2147483647, 0),
    chiikiNo(2, 0),
    shichosonCode(2147483647, 0),
    gappeiShurui(1, 0),
    hokenshaNo(2147483647, 0),
    kyuJohoFuyoToYMD(2147483647, 0),
    kokuhorenDataFromYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7055GappeiJoho(int maxLength, int scale) {
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
