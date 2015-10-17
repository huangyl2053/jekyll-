package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5032ShujiiIkenshoHoshuTankaの項目定義クラスです
 *
 */
public enum DbT5032ShujiiIkenshoHoshuTanka implements IColumnDefinition {
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
     * 在宅施設区分
     */
    zaitakuShisetsuKubun(2147483647, 0),
    /**
     * 意見書作成回数区分
     */
    ikenshoSakuseiKaisuKubun(2147483647, 0),
    /**
     * 開始年月
     */
    kaishiYM(2147483647, 0),
    /**
     * 終了年月
     */
    shuryoYM(2147483647, 0),
    /**
     * 単価
     */
    tanka(13, 0);

    private final int maxLength;
    private final int scale;

    private DbT5032ShujiiIkenshoHoshuTanka(int maxLength, int scale) {
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
