package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績基本明細・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7508KyufujissekiKihonMeisaiFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * kyufuSakuseiKubunCode
     */
    kyufuSakuseiKubunCode(1, 0),
    /**
     * shokisaiHokenshaNo
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * hiHokenshaNo
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * serviceTeikyoYM
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * kyufuJissekiKubunCode
     */
    kyufuJissekiKubunCode(1, 0),
    /**
     * jigyoshoNo
     */
    jigyoshoNo(2147483647, 0),
    /**
     * toshiNo
     */
    toshiNo(10, 0),
    /**
     * kohi1FutanshaNo
     */
    kohi1FutanshaNo(8, 0),
    /**
     * kohi1JukyushaNo
     */
    kohi1JukyushaNo(7, 0),
    /**
     * kohi2FutanshaNo
     */
    kohi2FutanshaNo(8, 0),
    /**
     * kohi2JukyushaNo
     */
    kohi2JukyushaNo(7, 0),
    /**
     * kohi3FutanshaNo
     */
    kohi3FutanshaNo(8, 0),
    /**
     * kohi3JukyushaNo
     */
    kohi3JukyushaNo(7, 0),
    /**
     * umareYMD
     */
    umareYMD(2147483647, 0),
    /**
     * seibetsuCode
     */
    seibetsuCode(1, 0),
    /**
     * yoKaigoJotaiKubunCode
     */
    yoKaigoJotaiKubunCode(2, 0),
    /**
     * kyuSochiNyushoshaTokureiCode
     */
    kyuSochiNyushoshaTokureiCode(1, 0),
    /**
     * ninteiYukoKaishiYMD
     */
    ninteiYukoKaishiYMD(2147483647, 0),
    /**
     * ninteiYukoShuryoYMD
     */
    ninteiYukoShuryoYMD(2147483647, 0),
    /**
     * rojinHokenShichosonNo
     */
    rojinHokenShichosonNo(8, 0),
    /**
     * rojinhokenJukyushaNo
     */
    rojinhokenJukyushaNo(7, 0),
    /**
     * kokiHokenshaNo
     */
    kokiHokenshaNo(8, 0),
    /**
     * kokiHiHokenshaNo
     */
    kokiHiHokenshaNo(8, 0),
    /**
     * kokuhoHokenshaNo
     */
    kokuhoHokenshaNo(8, 0),
    /**
     * kokuhoHiHokenshashoNo
     */
    kokuhoHiHokenshashoNo(20, 0),
    /**
     * kokuhoKojinNo
     */
    kokuhoKojinNo(10, 0),
    /**
     * kyotakuServiceSakuseiKubunCode
     */
    kyotakuServiceSakuseiKubunCode(1, 0),
    /**
     * kyotakuKaigoShienJigyoshoNo
     */
    kyotakuKaigoShienJigyoshoNo(2147483647, 0),
    /**
     * kaishiYMD
     */
    kaishiYMD(2147483647, 0),
    /**
     * chushiYMD
     */
    chushiYMD(2147483647, 0),
    /**
     * chushiRiyuNyushomaeJyokyoCode
     */
    chushiRiyuNyushomaeJyokyoCode(1, 0),
    /**
     * nyushoYMD
     */
    nyushoYMD(2147483647, 0),
    /**
     * taishoYMD
     */
    taishoYMD(2147483647, 0),
    /**
     * nyushoJitsunissu
     */
    nyushoJitsunissu(5, 0),
    /**
     * gaihakuNissu
     */
    gaihakuNissu(5, 0),
    /**
     * taishogoJotaiCode
     */
    taishogoJotaiCode(1, 0),
    /**
     * hokenKyufuritsu
     */
    hokenKyufuritsu(2147483647, 0),
    /**
     * kohi1Kyufuritsu
     */
    kohi1Kyufuritsu(2147483647, 0),
    /**
     * kohi2Kyufuritsu
     */
    kohi2Kyufuritsu(2147483647, 0),
    /**
     * kohi3Kyufuritsu
     */
    kohi3Kyufuritsu(2147483647, 0),
    /**
     * maeHokenServiceTanisu
     */
    maeHokenServiceTanisu(10, 0),
    /**
     * maeHokenSeikyugaku
     */
    maeHokenSeikyugaku(9, 0),
    /**
     * maeHokenRiyoshaFutangaku
     */
    maeHokenRiyoshaFutangaku(10, 0),
    /**
     * maeHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    maeHokenKinkyuShisetsuRyoyoSeikyugaku(9, 0),
    /**
     * maeHokenTokuteiShinryohiSeikyugaku
     */
    maeHokenTokuteiShinryohiSeikyugaku(9, 0),
    /**
     * maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    maeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * maeKohi1ServiceTanisu
     */
    maeKohi1ServiceTanisu(10, 0),
    /**
     * maeKohi1Seikyugaku
     */
    maeKohi1Seikyugaku(10, 0),
    /**
     * maeKohi1RiyoshaFutangaku
     */
    maeKohi1RiyoshaFutangaku(10, 0),
    /**
     * maeKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    maeKohi1KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * maeKohi1TokuteiShinryohiSeikyugaku
     */
    maeKohi1TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    maeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * maeKohi2ServiceTanisu
     */
    maeKohi2ServiceTanisu(10, 0),
    /**
     * maeKohi2Seikyugaku
     */
    maeKohi2Seikyugaku(10, 0),
    /**
     * maeKohi2RiyoshaFutangaku
     */
    maeKohi2RiyoshaFutangaku(10, 0),
    /**
     * maeKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    maeKohi2KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * maeKohi2TokuteiShinryohiSeikyugaku
     */
    maeKohi2TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    maeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * maeKohi3ServiceTanisu
     */
    maeKohi3ServiceTanisu(10, 0),
    /**
     * maeKohi3Seikyugaku
     */
    maeKohi3Seikyugaku(10, 0),
    /**
     * maeKohi3RiyoshaFutangaku
     */
    maeKohi3RiyoshaFutangaku(10, 0),
    /**
     * maeKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    maeKohi3KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * maeKohi3TokuteiShinryohiSeikyugaku
     */
    maeKohi3TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    maeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * atoHokenServiceTanisu
     */
    atoHokenServiceTanisu(10, 0),
    /**
     * atoHokenSeikyugaku
     */
    atoHokenSeikyugaku(9, 0),
    /**
     * atoHokenRiyoshaFutangaku
     */
    atoHokenRiyoshaFutangaku(10, 0),
    /**
     * atoHokenKinkyuShisetsuRyoyoSeikyugaku
     */
    atoHokenKinkyuShisetsuRyoyoSeikyugaku(9, 0),
    /**
     * atoHokenTokuteiShinryohiSeikyugaku
     */
    atoHokenTokuteiShinryohiSeikyugaku(9, 0),
    /**
     * atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    atoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * atoKohi1ServiceTanisu
     */
    atoKohi1ServiceTanisu(10, 0),
    /**
     * atoKohi1Seikyugaku
     */
    atoKohi1Seikyugaku(10, 0),
    /**
     * atoKohi1RiyoshaFutangaku
     */
    atoKohi1RiyoshaFutangaku(10, 0),
    /**
     * atoKohi1KinkyuShisetsuRyoyoSeikyugaku
     */
    atoKohi1KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * atoKohi1TokuteiShinryohiSeikyugaku
     */
    atoKohi1TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    atoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * atoKohi2ServiceTanisu
     */
    atoKohi2ServiceTanisu(10, 0),
    /**
     * atoKohi2Seikyugaku
     */
    atoKohi2Seikyugaku(10, 0),
    /**
     * atoKohi2RiyoshaFutangaku
     */
    atoKohi2RiyoshaFutangaku(10, 0),
    /**
     * atoKohi2KinkyuShisetsuRyoyoSeikyugaku
     */
    atoKohi2KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * atoKohi2TokuteiShinryohiSeikyugaku
     */
    atoKohi2TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    atoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * atoKohi3ServiceTanisu
     */
    atoKohi3ServiceTanisu(10, 0),
    /**
     * atoKohi3Seikyugaku
     */
    atoKohi3Seikyugaku(10, 0),
    /**
     * atoKohi3RiyoshaFutangaku
     */
    atoKohi3RiyoshaFutangaku(10, 0),
    /**
     * atoKohi3KinkyuShisetsuRyoyoSeikyugaku
     */
    atoKohi3KinkyuShisetsuRyoyoSeikyugaku(10, 0),
    /**
     * atoKohi3TokuteiShinryohiSeikyugaku
     */
    atoKohi3TokuteiShinryohiSeikyugaku(10, 0),
    /**
     * atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku
     */
    atoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(10, 0),
    /**
     * keikaiKubunCode
     */
    keikaiKubunCode(1, 0),
    /**
     * shinsaYM
     */
    shinsaYM(2147483647, 0),
    /**
     * seiriNo
     */
    seiriNo(10, 0),
    /**
     * sofuYM
     */
    sofuYM(2147483647, 0),
    /**
     * torikomiYM
     */
    torikomiYM(2147483647, 0),
    /**
     * dokujiSakuseiKubun
     */
    dokujiSakuseiKubun(1, 0),
    /**
     * hokenshaHoyuKyufujissekiJohoSakujoFlag
     */
    hokenshaHoyuKyufujissekiJohoSakujoFlag(1, 0),
    /**
     * serviceShuruiCode
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * serviceKomokuCode
     */
    serviceKomokuCode(2147483647, 0),
    /**
     * tanisu
     */
    tanisu(5, 0),
    /**
     * nissuKaisu
     */
    nissuKaisu(5, 0),
    /**
     * kohi1TaishoNissuKaisu
     */
    kohi1TaishoNissuKaisu(5, 0),
    /**
     * kohi2TaishoNissuKaisu
     */
    kohi2TaishoNissuKaisu(5, 0),
    /**
     * kohi3TaishoNissuKaisu
     */
    kohi3TaishoNissuKaisu(5, 0),
    /**
     * serviceTanisu
     */
    serviceTanisu(10, 0),
    /**
     * kohi1TaishoServiceTanisu
     */
    kohi1TaishoServiceTanisu(10, 0),
    /**
     * kohi2TaishoServiceTanisu
     */
    kohi2TaishoServiceTanisu(10, 0),
    /**
     * kohi3TaishoServiceTanisu
     */
    kohi3TaishoServiceTanisu(10, 0),
    /**
     * tekiyo
     */
    tekiyo(20, 0),
    /**
     * atoTanisu
     */
    atoTanisu(5, 0),
    /**
     * atoNissuKaisu
     */
    atoNissuKaisu(5, 0),
    /**
     * atoKohi1TaishoNissuKaisu
     */
    atoKohi1TaishoNissuKaisu(5, 0),
    /**
     * atoKohi2TaishoNissukaisu
     */
    atoKohi2TaishoNissukaisu(5, 0),
    /**
     * atoKohi3TaishoNissuKaisu
     */
    atoKohi3TaishoNissuKaisu(5, 0),
    /**
     * atoServiceTanisu
     */
    atoServiceTanisu(10, 0),
    /**
     * atoKohi1TaishoServiceTanisu
     */
    atoKohi1TaishoServiceTanisu(10, 0),
    /**
     * atoKohi2TaishoServiceTanisu
     */
    atoKohi2TaishoServiceTanisu(10, 0),
    /**
     * atoKohi3TaishoServiceTanisu
     */
    atoKohi3TaishoServiceTanisu(10, 0),
    /**
     * saishinsaKaisu
     */
    saishinsaKaisu(5, 0),
    /**
     * kagoKaisu
     */
    kagoKaisu(5, 0);

    private final int maxLength;
    private final int scale;

    private DbV7508KyufujissekiKihonMeisaiFukushi(int maxLength, int scale) {
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
