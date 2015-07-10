package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV3104KokuhorenTorikomiJohoの項目定義クラスです
 *
 */
public enum DbV3104KokuhorenTorikomiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    shoriYM(2147483647, 0),
    kokanShikibetsuNo(3, 0),
    shoriJotaiKubun(1, 0),
    zen_shorijotaikubun(1, 0),
    zenzen_shorijotaikubun(1, 0),
    tougetsushoridate(2147483647, 0),
    saiShoriKahiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV3104KokuhorenTorikomiJoho(int maxLength, int scale) {
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
