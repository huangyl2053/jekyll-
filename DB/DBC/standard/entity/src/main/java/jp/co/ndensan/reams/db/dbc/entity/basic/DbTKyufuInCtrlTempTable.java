package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbTKyufuInCtrlTempTableの項目定義クラスです
 *
 */
public enum DbTKyufuInCtrlTempTable implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">
    recordShubetsu(1, 0),
    recordNo(9, 0),
    volumeRenban(3, 0),
    recordKensu(9, 0),
    dataShubetsu(3, 0),
    fukushijimushoTokuteiNo(2, 0),
    hokenshaNo(6, 0),
    jigyoshoNo(10, 0),
    todofukenNo(2, 0),
    baitaiKubun(1, 0),
    shoriTaishoYM(6, 0),
    fileKanriNo(6, 0),
    fileBunruiCode(4, 0),
    jissekiDataShinsaYM(6, 0);

    private final int maxLength;
    private final int scale;

    private DbTKyufuInCtrlTempTable(int maxLength, int scale) {
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
