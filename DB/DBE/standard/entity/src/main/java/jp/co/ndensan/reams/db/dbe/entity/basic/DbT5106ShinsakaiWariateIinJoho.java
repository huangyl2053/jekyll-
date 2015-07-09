package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5106ShinsakaiWariateIinJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public enum DbT5106ShinsakaiWariateIinJoho implements IColumnDefinition {
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
     * 介護認定審査会開催番号
     */
    shinsakaiKaisaiNo(5, 0),
    /**
     * 介護認定審査会委員コード
     */
    shinsakaiIinCode(8, 0),
    /**
     * 認定審査員区分コード
     */
    shinsainKubunCode(2147483647, 0),
    /**
     * 合議体長区分コード
     */
    gogitaichoKubunCode(2147483647, 0),
    /**
     * 介護認定審査会委員審査開始時間
     */
    shinsakaiIinShinsaKaishiTime(4, 0),
    /**
     * 介護認定審査会委員審査終了時間
     */
    shinsakaiIinshinsaShuryoTime(4, 0),
    /**
     * 介護認定審査会委員出欠区分
     */
    shinsakaiIinShukketsuKubun(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT5106ShinsakaiWariateIinJoho(int maxLength, int scale) {
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
