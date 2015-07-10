package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7011ShujiiIryoKikanJohoの項目定義クラスです
 *
 */
public enum DbT7011ShujiiIryoKikanJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonCode(2147483647, 0),
    kaigoIryokikanCode(10, 0),
    iryokikanCode(10, 0),
    iryokikanJokyo(1, 0),
    iryoKikanMeisho(120, 0),
    iryoKikanMeishoKana(120, 0),
    yubinNo(2147483647, 0),
    jusho(50, 0),
    jushoKana(50, 0),
    telNo(2147483647, 0),
    ginkoCode(2147483647, 0),
    shitenCode(2147483647, 0),
    kozaShubetsu(2147483647, 0),
    kozaNo(2147483647, 0),
    kozaMeiginin(120, 0),
    kozaMeigininKana(120, 0),
    kikanKubunCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7011ShujiiIryoKikanJoho(int maxLength, int scale) {
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
