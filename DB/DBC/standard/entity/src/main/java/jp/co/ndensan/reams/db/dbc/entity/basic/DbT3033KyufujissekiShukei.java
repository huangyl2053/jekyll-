package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3033KyufujissekiShukeiの項目定義クラスです
 *
 */
public enum DbT3033KyufujissekiShukei implements IColumnDefinition {
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
    toshiNo(10, 0),
    serviceSyuruiCode(2147483647, 0),
    serviceJitsunissu(5, 0),
    planTanisu(10, 0),
    gendogakuKanriTaishoTanisu(10, 0),
    gendogakuKanritaishogaiTanisu(10, 0),
    tankiNyushoPlanNissu(5, 0),
    tankiNyushoJitsunissu(5, 0),
    hokenTanisuTotal(10, 0),
    hokenTanisuTani(6, 0),
    hokenSeikyugaku(9, 0),
    hokenRiyoshaFutangaku(10, 0),
    kohi1TanisuTotal(10, 0),
    kohi1Seikyugaku(9, 0),
    kohi1HonninFutangaku(10, 0),
    kohi2TanisuTotal(10, 0),
    kohi2Seikyugaku(9, 0),
    kohi2HonninFutangaku(10, 0),
    kohi3TanisuTotal(10, 0),
    kohi3Seikyugaku(9, 0),
    kohi3HonninFutangaku(10, 0),
    hokenDekidakaTanisuTotal(10, 0),
    hokenDekidakaSeikyugaku(9, 0),
    hokenDekidakaIryohiRiyoshaFutangaku(10, 0),
    kohi1DekidakaTanisuTotal(10, 0),
    kohi1DekidakaSeikyugaku(9, 0),
    kohi1DekidakaIryohiRiyoshaFutangaku(10, 0),
    kohi2DekidakaTanisuTotal(10, 0),
    kohi2DekidakaSeikyugaku(9, 0),
    kohi2DekidakaIryohiRiyoshaFutangaku(10, 0),
    kohi3DekidakaTanisuTotal(10, 0),
    kohi3DekidakaSeikyugaku(9, 0),
    kohi3DekidakaIryohiRiyoshaFutangaku(10, 0),
    atoTankiNyushoJitsunissu(10, 0),
    atoHokenTanisuTotal(10, 0),
    atoHokenSeikyugaku(9, 0),
    atoKohi1TanisuTotal(10, 0),
    atoKohi1Seikyugaku(9, 0),
    atoKohi2TanisuTotal(10, 0),
    atoKohi2Seikyugaku(9, 0),
    atoKohi3TanisuTotal(10, 0),
    atoKohi3Seikyugaku(9, 0),
    atoHokenDekidakaTanisuTotal(10, 0),
    atoHokenDekidakaSeikyugaku(9, 0),
    atoKohi1DekidakaTanisuTotal(10, 0),
    atoKohi1DekidakaSeikyugaku(9, 0),
    atoKohi2DekidakaTanisuTotal(10, 0),
    atoKohi2DekidakaSeikyugaku(9, 0),
    atoKohi3DekidakaTanisuTotal(10, 0),
    atoKohi3DekidakaSeikyugaku(9, 0),
    saishinsaKaisu(10, 0),
    kagoKaisu(10, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3033KyufujissekiShukei(int maxLength, int scale) {
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
