package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会割当委員情報テーブルの項目定義クラスです。
 */
public enum DbT5503ShinsakaiWariateIinJoho implements IColumnDefinition {
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
     * 介護認定審査会開催番号
     * <br/>介護認定審査会開催予定情報
     */
    shinsakaiKaisaiNo(8, 0),
    /**
     * 介護認定審査会委員コード
     * <br/>介護認定審査会委員情報
     */
    shinsakaiIinCode(8, 0),
    /**
     * 介護認定審査会開催年月日
     */
    shinsakaiKaisaiYMD(2147483647, 0),
    /**
     * 介護認定審査会議長区分コード
     * <br/>Enum（DBE：介護認定審査会議長区分コード）0：委員、1：議長
     */
    kaigoninteiShinsakaiGichoKubunCode(2147483647, 0),
    /**
     * 委員出席
     * <br/>Enum（DBE：委員出席）
     */
    shussekiFlag(1, 0),
    /**
     * 委員遅刻有無
     * <br/>Enum（DBE：委員遅刻有無）
     */
    existChikokuFlag(1, 0),
    /**
     * 委員出席時間
     */
    shussekiTime(4, 0),
    /**
     * 委員早退有無
     * <br/>Enum（DBE：委員早退有無）
     */
    existSotaiFlag(1, 0),
    /**
     * 委員退席時間
     */
    taisekiTime(4, 0);

    private final int maxLength;
    private final int scale;

    private DbT5503ShinsakaiWariateIinJoho(int maxLength, int scale) {
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
