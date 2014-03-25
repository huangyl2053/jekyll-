package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5102ShinsakaiIinJohoの項目定義クラスです
 *
 */
public enum DbT5102ShinsakaiIinJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinsakaiIinCode(8, 0),
    shinsakaiIinKaishiYMD(2147483647, 0),
    shinsakaiIinShuryoYMD(2147483647, 0),
    shinsakaiIinJokyo(1, 0),
    jigyoushaNo(2147483647, 0),
    shinsakaiIinShimei(2147483647, 0),
    ShinsakaiIinKanaShimei(2147483647, 0),
    seibetsu(1, 0),
    shinsakaiIinShikakuCode(2147483647, 0),
    shinsainYusoKubun(1, 0),
    yubinNo(2147483647, 0),
    Jusho(2147483647, 0),
    telNo(2147483647, 0),
    kinyuKikanCode(2147483647, 0),
    kinyuKikanShitenCode(2147483647, 0),
    KozaShubetsu(1, 0),
    KozaMeigi(80, 0),
    KozaMeigiKana(80, 0),
    KozaNo(7, 0);

    private final int maxLength;
    private final int scale;

    private DbT5102ShinsakaiIinJoho(int maxLength, int scale) {
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
