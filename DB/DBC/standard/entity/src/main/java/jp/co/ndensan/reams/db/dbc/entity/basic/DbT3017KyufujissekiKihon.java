package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績基本を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT3017KyufujissekiKihon implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    kokanShikibetsuNo(2147483647, 0),
    inputShikibetsuNo(2147483647, 0),
    recodeShubetsuCode(2, 0),
    kyufuSakuseiKubunCode(1, 0),
    hokenshaNo(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    kyufuJissekiKubunCode(1, 0),
    jigyoshoNo(2147483647, 0),
    toshiNo(10, 0),
    kohi1FutanshaNo(8, 0),
    kohi1JukyushaNo(7, 0),
    kohi2FutanshaNo(8, 0),
    kohi2JukyushaNo(7, 0),
    kohi3FutanshaNo(8, 0),
    kohi3JukyushaNo(7, 0),
    umareYMD(2147483647, 0),
    seibetsuCode(1, 0),
    yoKaigoJotaiKubunCode(2, 0),
    kyuSochiNyushoshaTokureiCode(1, 0),
    ninteiYukoKaishiYMD(2147483647, 0),
    ninteiYukoShuryoYMD(2147483647, 0),
    rojinHokenShichosonNo(8, 0),
    rojinhokenJukyushaNo(7, 0),
    kokiHokenshaNo(8, 0),
    kokiHiHokenshaNo(8, 0),
    kokuhoHokenshaNo(8, 0),
    kokuhoHiHokenshashoNo(20, 0),
    kokuhoKojinNo(10, 0),
    kyotakuServiceSakuseiKubunCode(1, 0),
    kyotakuKaigoShienJigyoshoNo(2147483647, 0),
    kaishiYMD(2147483647, 0),
    chushiYMD(2147483647, 0),
    chushiRiyuNyushomaeJyokyoCode(1, 0),
    nyushoYMD(2147483647, 0),
    taishoYMD(2147483647, 0),
    nyushoJitsunissu(5, 0),
    gaihakuNissu(5, 0),
    taishogoJotaiCode(1, 0),
    hokenKyufuritsu(2147483647, 0),
    kohi1Kyufuritsu(2147483647, 0),
    kohi2Kyufuritsu(2147483647, 0),
    kohi3Kyufuritsu(2147483647, 0),
    maeHokenServiceTanisu(10, 0),
    maeHokenSeikyugaku(9, 0),
    maeHokenRiyoshaFutangaku(10, 0),
    maeHokenKinkyuShisetsuRyoyoSeikyugaku(9, 0),
    maeHokenTokuteiShinryohiSeikyugaku(9, 0),
    maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    maeKohi1ServiceTanisu(10, 0),
    maeKohi1Seikyugaku(10, 0),
    maeKohi1RiyoshaFutangaku(10, 0),
    maeKohi1KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    maeKohi1TokuteiShinryohiSeikyugaku(10, 0),
    maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    maeKohi2ServiceTanisu(10, 0),
    maeKohi2Seikyugaku(10, 0),
    maeKohi2RiyoshaFutangaku(10, 0),
    maeKohi2KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    maeKohi2TokuteiShinryohiSeikyugaku(10, 0),
    maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    maeKohi3ServiceTanisu(10, 0),
    maeKohi3Seikyugaku(10, 0),
    maeKohi3RiyoshaFutangaku(10, 0),
    maeKohi3KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    maeKohi3TokuteiShinryohiSeikyugaku(10, 0),
    maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    atoHokenServiceTanisu(10, 0),
    atoHokenSeikyugaku(9, 0),
    atoHokenRiyoshaFutangaku(10, 0),
    atoHokenKinkyuShisetsuRyoyoSeikyugaku(9, 0),
    atoHokenTokuteiShinryohiSeikyugaku(9, 0),
    atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    atoKohi1ServiceTanisu(10, 0),
    atoKohi1Seikyugaku(10, 0),
    atoKohi1RiyoshaFutangaku(10, 0),
    atoKohi1KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    atoKohi1TokuteiShinryohiSeikyugaku(10, 0),
    atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    atoKohi2ServiceTanisu(10, 0),
    atoKohi2Seikyugaku(10, 0),
    atoKohi2RiyoshaFutangaku(10, 0),
    atoKohi2KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    atoKohi2TokuteiShinryohiSeikyugaku(10, 0),
    atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    atoKohi3ServiceTanisu(10, 0),
    atoKohi3Seikyugaku(10, 0),
    atoKohi3RiyoshaFutangaku(10, 0),
    atoKohi3KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    atoKohi3TokuteiShinryohiSeikyugaku(10, 0),
    atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    keikaiKubunCode(1, 0),
    shinsaYM(2147483647, 0),
    seiriNo(10, 0),
    sofuYM(2147483647, 0),
    torikomiYM(2147483647, 0),
    dokujiSakuseiKubun(1, 0),
    hokenshaHoyuKyufujissekiJohoSakujoFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3017KyufujissekiKihon(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
