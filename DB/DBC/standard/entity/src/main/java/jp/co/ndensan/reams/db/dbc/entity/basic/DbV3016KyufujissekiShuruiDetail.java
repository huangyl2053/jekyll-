package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV3016KyufujissekiShuruiDetailの項目定義クラスです
 *
 */
public enum DbV3016KyufujissekiShuruiDetail implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    kokanShikibetsuNo(2147483647, 0),
    inputShikibetsuNo(2147483647, 0),
    recodeShubetsuCode(2, 0),
    hokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    jigyoshoNo(2147483647, 0),
    toshiNo(10, 0),
    serviceSyuruiCode(2147483647, 0),
    hokenRiyoshaFutangaku(10, 0),
    atoHokenTanisuTotal(10, 0),
    atoHokenSeikyugaku(9, 0),
    atoHokenDekidakaTanisuTotal(10, 0),
    servicecode(2147483647, 0),
    atoservicetanisutotal(2147483647, 0),
    atotanisu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV3016KyufujissekiShuruiDetail(int maxLength, int scale) {
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
