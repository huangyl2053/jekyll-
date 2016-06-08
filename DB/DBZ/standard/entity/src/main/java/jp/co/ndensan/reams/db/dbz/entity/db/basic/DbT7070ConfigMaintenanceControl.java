package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * コンフィグメンテナンス制御テーブルの項目定義クラスです。
 * <br/> コンフィグメンテナンス画面で表示のみ（修正不可）のキーを管理します。
 */
public enum DbT7070ConfigMaintenanceControl implements IColumnDefinition {
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
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * コンフィグ名
     */
    configName(2147483647, 0),
    /**
     * 表示順１
     */
    hyojiJun1(5, 0),
    /**
     * 表示順２
     */
    hyojiJun2(5, 0),
    /**
     * 表示順３
     */
    hyojiJun3(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT7070ConfigMaintenanceControl(int maxLength, int scale) {
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
