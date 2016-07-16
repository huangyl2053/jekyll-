package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * UrT0705ChoteiKyotsuの項目定義クラスです
 *
 */
public enum UrT0705ChoteiKyotsu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    choteiId(19, 0),
    shunoId(19, 0),
    kaikeiNendo(2147483647, 0),
    shoriNendo(2147483647, 0),
    shoriNo(10, 0),
    koseiKaisu(10, 0),
    choteiJiyuCode(2147483647, 0),
    choteiYMD(2147483647, 0),
    choteigaku(131089, 0),
    shohizei(131089, 0),
    nokigenYMD(2147483647, 0),
    hoteiNokigenToYMD(2147483647, 0),
    fukaShoriJokyo(1, 0);

    private final int maxLength;
    private final int scale;

    private UrT0705ChoteiKyotsu(int maxLength, int scale) {
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
