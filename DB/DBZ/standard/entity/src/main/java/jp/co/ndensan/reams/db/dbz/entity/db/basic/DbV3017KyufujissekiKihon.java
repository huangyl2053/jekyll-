package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV3017KyufujissekiKihonテーブルの項目定義クラスです。
 */
public enum DbV3017KyufujissekiKihon implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * kokanShikibetsuNo
     */
    kokanShikibetsuNo(2147483647, 0),
    /**
     * inputShikibetsuNo
     */
    inputShikibetsuNo(2147483647, 0),
    /**
     * recodeShubetsuCode
     */
    recodeShubetsuCode(2, 0),
    /**
     * hokenshaNo
     */
    hokenshaNo(2147483647, 0),
    /**
     * hiHokenshaNo
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * serviceTeikyoYM
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * jigyoshoNo
     */
    jigyoshoNo(2147483647, 0),
    /**
     * kyufuSakuseiKubunCode
     */
    kyufuSakuseiKubunCode(1, 0),
    /**
     * kyufuJissekiKubunCode
     */
    kyufuJissekiKubunCode(1, 0),
    /**
     * toshiNo
     */
    toshiNo(10, 0);

    private final int maxLength;
    private final int scale;

    private DbV3017KyufujissekiKihon(int maxLength, int scale) {
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
