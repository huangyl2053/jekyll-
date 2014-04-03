package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5106ShinsakaiWariateIinJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public enum DbT5106ShinsakaiWariateIinJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinsakaiKaisaiNo(5, 0),
    shinsakaiKaisaiYMD(2147483647, 0),
    shinsakaiIinCode(8, 0),
    shinsainKubunCode(2147483647, 0),
    gogitaichoKubunCode(2147483647, 0),
    shinsakaiIinShinsaKaishiTime(4, 0),
    shinsakaiIinshinsaShuryoTime(4, 0),
    shinsakaiIinShukketsuKubun(2, 0);
    private final int maxLength;
    private final int scale;

    private DbT5106ShinsakaiWariateIinJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
