package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 合議体割当委員情報テーブルの項目定義クラスです。
 */
public enum DbT5593GogitaiWariateIinJoho implements IColumnDefinition {
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
     * 合議体番号
     */
    gogitaiNo(5, 0),
    /**
     * 合議体有効期間開始年月日
     */
    gogitaiYukoKikanKaishiYMD(2147483647, 0),
    /**
     * 合議体有効期間終了年月日
     */
    gogitaiYukoKikanShuryoYMD(2147483647, 0),
    /**
     * 介護認定審査会委員コード
     */
    shinsakaiIinCode(8, 0),
    /**
     * 合議体長区分コード
     */
    gogitaichoKubunCode(2147483647, 0),
    /**
     * 補欠
     */
    substituteFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5593GogitaiWariateIinJoho(int maxLength, int scale) {
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
