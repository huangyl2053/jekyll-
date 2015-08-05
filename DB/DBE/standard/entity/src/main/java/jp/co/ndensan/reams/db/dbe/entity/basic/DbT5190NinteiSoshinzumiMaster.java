package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定送信済みマスタテーブルの項目定義クラスです。
 */
public enum DbT5190NinteiSoshinzumiMaster implements IColumnDefinition {
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
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 同一連番
     */
    doitsuRemban(5, 0),
    /**
     * 引き渡しフラグ
     */
    isHikiwatashi(1, 0),
    /**
     * 引き渡し日時
     */
    hikiwatashiYMDHM(2147483647, 0),
    /**
     * 引き渡し解除日時
     */
    hikiwatashiKaijoYMDHM(2147483647, 0),
    /**
     * 引き渡しカウント
     */
    hikiwatashiCount(5, 0),
    /**
     * 取り込み日時
     */
    torikomiYMDHM(2147483647, 0),
    /**
     * 再送付区分
     */
    saiSofuKubun(2, 0),
    /**
     * 再調査送付区分
     */
    saiChosaSofuKubun(2, 0),
    /**
     * 再意見書送付区分
     */
    saiIkenshoSofuKubun(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT5190NinteiSoshinzumiMaster(int maxLength, int scale) {
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
