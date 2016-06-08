package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV3016KyufujissekiShuruiDetailテーブルの項目定義クラスです。
 */
public enum DbV3016KyufujissekiShuruiDetail implements IColumnDefinition {
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
     * toshiNo
     */
    toshiNo(10, 0),
    /**
     * serviceSyuruiCode
     */
    serviceSyuruiCode(2147483647, 0),
    /**
     * hokenRiyoshaFutangaku
     */
    hokenRiyoshaFutangaku(10, 0),
    /**
     * atoHokenTanisuTotal
     */
    atoHokenTanisuTotal(10, 0),
    /**
     * atoHokenSeikyugaku
     */
    atoHokenSeikyugaku(9, 0),
    /**
     * atoHokenDekidakaTanisuTotal
     */
    atoHokenDekidakaTanisuTotal(10, 0),
    /**
     * serviceCode
     */
    serviceCode(2147483647, 0),
    /**
     * atoServiceTanisuTotal
     */
    atoServiceTanisuTotal(10, 0),
    /**
     * atotanisu
     */
    atotanisu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV3016KyufujissekiShuruiDetail(int maxLength, int scale) {
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
