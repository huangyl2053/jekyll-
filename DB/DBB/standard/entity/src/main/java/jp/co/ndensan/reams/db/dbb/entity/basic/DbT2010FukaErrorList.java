package jp.co.ndensan.reams.db.dbb.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT2010FukaErrorListの項目定義クラスです
 *
 */
public enum DbT2010FukaErrorList implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    subGyomuCode(2147483647, 0),
    internalReportId(128, 0),
    internalReportCreationDateTime(2147483647, 0),
    batchId(255, 0),
    batchStartingDateTime(2147483647, 0),
    shoriKubunCode(2147483647, 0),
    fukaNendo(2147483647, 0),
    tsuchishoNo(2147483647, 0),
    errorCode(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shikibetsuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2010FukaErrorList(int maxLength, int scale) {
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
