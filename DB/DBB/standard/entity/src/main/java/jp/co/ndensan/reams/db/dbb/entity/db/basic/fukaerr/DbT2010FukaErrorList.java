package jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT2010FukaErrorListの項目定義クラスです
 *
 */
public enum DbT2010FukaErrorList implements IColumnDefinition {
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
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * 内部帳票ID
     */
    internalReportId(128, 0),
    /**
     * 内部帳票作成日時
     */
    internalReportCreationDateTime(2147483647, 0),
    /**
     * バッチID
     */
    batchId(255, 0),
    /**
     * バッチ起動日時
     */
    batchStartingDateTime(2147483647, 0),
    /**
     * 処理区分コード
     */
    shoriKubunCode(2147483647, 0),
    /**
     * 賦課年度
     */
    fukaNendo(2147483647, 0),
    /**
     * 通知書番号
     */
    tsuchishoNo(2147483647, 0),
    /**
     * エラーコード
     */
    errorCode(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2010FukaErrorList(int maxLength, int scale) {
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
