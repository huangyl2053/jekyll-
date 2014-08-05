package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoの項目定義クラスです
 *
 */
public enum DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
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
    recodeJunjiNo(2, 0),
    toshiNo(10, 0),
    serviceSyuruiCode(2147483647, 0),
    serviceKomokuCode(2147483647, 0),
    hiyoTanka(5, 0),
    futanGendogaku(5, 0),
    nissu(5, 0),
    kohi1Nissu(5, 0),
    kohi2Nissu(5, 0),
    kohi3Nissu(5, 0),
    hiyogaku(10, 0),
    hokenbunSeikyugaku(10, 0),
    kohi1Futangaku(10, 0),
    kohi2Futangaku(10, 0),
    kohi3Futangaku(10, 0),
    riyoshaFutangaku(10, 0),
    hiyogakuTotal(10, 0),
    hokenbunSeikyugakuTotal(10, 0),
    riyoshaFutangakuTotal(10, 0),
    kohi1FutangakuTotal(10, 0),
    kohi1Seikyugaku(10, 0),
    kohi1HonninFutanGetsugaku(10, 0),
    kohi2FutangakuTotal(10, 0),
    kohi2Seikyugaku(10, 0),
    kohi2HonninFutanGetsugaku(10, 0),
    kohi3FutangakuTotal(10, 0),
    kohi3Seikyugaku(10, 0),
    kohi3HonninFutanGetsugaku(10, 0),
    atoHiyoTanka(5, 0),
    atoNissu(5, 0),
    atoKohi1Nissu(5, 0),
    atoKohi2Nissu(5, 0),
    atoKohi3Nissu(5, 0),
    atoHiyogaku(10, 0),
    atoHokenbunSeikyugaku(10, 0),
    atoKohi1Futangaku(10, 0),
    atoKohi2Futangaku(10, 0),
    atoKohi3Futangaku(10, 0),
    atoRiyoshaFutangaku(10, 0),
    atoHiyogakuTotal(10, 0),
    atoHokenbunSeikyugakuTotal(10, 0),
    atoRiyoshaFutangakuTotal(10, 0),
    atoKohi1FutangakuTotal(10, 0),
    atoKohi1Seikyugaku(10, 0),
    atoKohi1HonninFutanGetsugaku(10, 0),
    atoKohi2FutangakuTotal(10, 0),
    atoKohi2Seikyugaku(10, 0),
    atoKohi2HonninFutanGetsugaku(10, 0),
    atoKohi3FutangakuTotal(10, 0),
    atoKohi3Seikyugaku(10, 0),
    atoKohi3HonninFutanGetsugaku(10, 0),
    saishinsaKaisu(5, 0),
    kagoKaisu(5, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(int maxLength, int scale) {
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
