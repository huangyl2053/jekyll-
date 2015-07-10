package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3022KyufujissekiShokujiHiyoの項目定義クラスです
 *
 */
public enum DbT3022KyufujissekiShokujiHiyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    kokanJohoShikibetsuNo(2147483647, 0),
    inputShikibetsuNo(2147483647, 0),
    recodeShubetsuCode(2, 0),
    shokisaiHokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    jigyoshoNo(2147483647, 0),
    toshiNo(10, 0),
    kihonTeikyoNissu(5, 0),
    kihonTeikyoTanka(5, 0),
    kihonTeikyoKingaku(5, 0),
    tokubestuTeikyoNissu(5, 0),
    tokubestuTeikyoTanka(5, 0),
    tokubestuTeikyoKingaku(5, 0),
    syokujiTeikyoNissu(5, 0),
    kohi1SyokujiTeikyoNissu(5, 0),
    kohi2SyokujiTeikyoNissu(5, 0),
    kohi3SyokujiTeikyoNissu(5, 0),
    syokujiTeikyohiTotal(5, 0),
    getsugakuHyojunFutanGaku(5, 0),
    syokujiTeikyohiSeikyugaku(5, 0),
    kohi1SyokujiTeikyohiSeikyugaku(5, 0),
    kohi2SyokujiTeikyohiSeikyugaku(5, 0),
    kohi3SyokujiTeikyohiSeikyugaku(5, 0),
    nichigakuHyojunFutanGaku(5, 0),
    atoKihonTeikyoTanka(5, 0),
    atoTokubestuTeikyoTanka(5, 0),
    atoSyokujiTeikyohiSeikyugaku(5, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3022KyufujissekiShokujiHiyo(int maxLength, int scale) {
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
