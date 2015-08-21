package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT7063KaigoJigyoshaShiteiServiceの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public enum DbT7063KaigoJigyoshaShiteiService implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    jigyoshaNo(2147483647, 0),
    serviceShuruiCode(2147483647, 0),
    yukoKaishiYMD(2147483647, 0),
    yukoShuryoYMD(2147483647, 0),
    idoYMD(2147483647, 0),
    idoJiyu(2, 0),
    shiteiNo(2, 0),
    kihonJohoJunkyoKubun(1, 0),
    jigyoKaishiYMD(2147483647, 0),
    jigyoKyushiYMD(2147483647, 0),
    jigyoSaikaiYMD(2147483647, 0),
    jigyoHaishiYMD(2147483647, 0),
    jigyoshaName(2147483647, 0),
    jigyoshaNameKana(2147483647, 0),
    jigyoshaYubinNo(2147483647, 0),
    jigyoshaAddress(2147483647, 0),
    jigyoshaAddressKana(100, 0),
    jigyoshaTelNo(2147483647, 0),
    jigyoshaFaxNo(2147483647, 0),
    torokuHokenshaNo(6, 0),
    juryoininUmu(2147483647, 0),
    torokuKaishiYMD(2147483647, 0),
    torokuShuryoYMD(2147483647, 0),
    kanrishaName(2147483647, 0),
    kanrishaNameKana(2147483647, 0),
    kanrishaYubinNo(2147483647, 0),
    kanrishaAddress(2147483647, 0),
    kanrishaAddressKana(50, 0),
    kozaJohoJunkyoKubun(1, 0),
    ginkoCode(2147483647, 0),
    shitenCode(2147483647, 0),
    kozaShubetsu(2147483647, 0),
    kozaNo(2147483647, 0),
    kozaMeiginin(2147483647, 0),
    kozaMeigininKana(2147483647, 0),
    shakaiFukushihoujinKeigenjigyouJisshi_umu(2147483647, 0),
    seikatsuhogohouShitei_umu(2147483647, 0),
    shisetsunadoKubun(2147483647, 0),
    jininHaichiKubun(2147483647, 0),
    tokubetsuChiikiKasan_umu(2147483647, 0),
    kinkyujiHomonkaigoKasan_umu(2147483647, 0),
    tokubetsuKanriTaisei(2147483647, 0),
    kinoKunrenShidoTaisei_umu(2147483647, 0),
    shokujiTeikyoTaisei_umu(2147483647, 0),
    nyuyokuKaijoTaisei_umu(2147483647, 0),
    tokubetsuNyuyokuKaijoTaisei_umu(2147483647, 0),
    joukinsenjuIshiHaichi_umu(2147483647, 0),
    ishiHaichiKijun(2147483647, 0),
    seisinkaIshiTeikitekiRyouyousidou_umu(2147483647, 0),
    yakanKinmuJokenKijun(2147483647, 0),
    ninchishouSenmontou_umu(2147483647, 0),
    shokujiTeikyoJokyo(2147483647, 0),
    sougeiTaisei(2147483647, 0),
    rehaTeikyoTaisei_SogoRehaShisetsu_umu(2147483647, 0),
    rehaTeikyoTaisei_RigakuRyohoII_umu(2147483647, 0),
    rehaTeikyoTaisei_RigakuRyohoIII_umu(2147483647, 0),
    rehaTeikyoTaisei_SagyoRyohoII_umu(2147483647, 0),
    rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(2147483647, 0),
    rehaTeikyoTaisei_Sonota_umu(2147483647, 0),
    rehabilitationKasanJokyo(2147483647, 0),
    ryoyoKankyoKijun(2147483647, 0),
    ishiKetuinGenzanJokyo_umu(2147483647, 0),
    kangoShokuinKetsuinGenzanJokyo_umu(2147483647, 0),
    rigakuRyouhousiKetsuinGenzanJokyo_umu(2147483647, 0),
    sagyouRyouhousiKetsuinGenzanJokyo_umu(2147483647, 0),
    kaigoShokuinKetsuinGenzanJokyo_umu(2147483647, 0),
    kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(2147483647, 0),
    kaigoJujishaKetsuinGenzanJokyo_umu(2147483647, 0),
    kansenTaisakuSidoKanri_umu(2147483647, 0),
    jushoHifuKaiyouShidoKanri_umu(2147483647, 0),
    yakuzaiKaniriShido_umu(2147483647, 0),
    shogaishaSeikatsuShienTaisei_umu(2147483647, 0),
    chiikiKubunCode(2147483647, 0),
    jikanEnchoServiceTaisei(2147483647, 0),
    kobetsuRehabilitationTeikyoTaisei(2147483647, 0),
    kyojuhiTaisaku(2147483647, 0),
    yakanCare_umu(2147483647, 0),
    rehabilitationKinoKyoka_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(2147483647, 0),
    kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(2147483647, 0),
    gengoChokakushiKetsuinGenzanJokyo_umu(2147483647, 0),
    eiyouKanriHyoka(2147483647, 0),
    tokuteijigyoushoKasan_HomonKaigo_umu(2147483647, 0),
    jakunenseiNinchishoCareTaisei_umu(2147483647, 0),
    undokiKinoKojoTaisei_umu(2147483647, 0),
    eiyoManagement_KaizenTaisei_umu(2147483647, 0),
    kokuKinoKojoTaisei_umu(2147483647, 0),
    jigyoshoHyokaKasan_Moshide_umu(2147483647, 0),
    jigyoshoHyokaKasan_Kettei_umu(2147483647, 0),
    kinkyuUkeireTaisei_umu(2147483647, 0),
    yakanKangoTaisei_umu(2147483647, 0),
    tokuteijigyoshoKasan_Kyotakukaigoshien_umu(2147483647, 0),
    kaigoShienSemmoninSenjuJokinshaNinsu(5, 0),
    kaigoSienSemmoninSenjuHijokinshaNinsu(5, 0),
    kaigoSienSemmoninKemmuJokinshaNinsu(5, 0),
    kaigoSienSemmoninKemmuHijokinshaNinsu(5, 0),
    homonkaigoServiceTeikyoSekininshaNinsu(5, 0),
    homonkaigoSenjuJokinshaNinsu(5, 0),
    homonkaigoSenjuHijokinshaNinsu(5, 0),
    homonkaigoKemmuJokinshaNinsu(5, 0),
    homonkaigoKemmuHijokinshaNinsu(5, 0),
    homonkaigoJokinKanzangoNinsu(5, 0),
    riyoTeiinNinsu(5, 0),
    shiteiYukoKaishiYMD(2147483647, 0),
    shiteiYukoShuryoYMD(2147483647, 0),
    shiteiKoshinShinseichuKubun(2147483647, 0),
    koryokuTeishiKaishiYMD(2147483647, 0),
    koryokuTeishiShuryoYMD(2147483647, 0),
    daikiboJigyoshaGaito_umu(2147483647, 0),
    junUnitCareTaisei_umu(2147483647, 0),
    judokaTaioTaisei_umu(2147483647, 0),
    iryoRenkeiTaisei_umu(2147483647, 0),
    unitCareTaisei_umu(2147483647, 0),
    zaitaku_nyushoSogoRiyoTaisei_umu(2147483647, 0),
    terminalCareTaisei_umu(2147483647, 0),
    shintaiKosokuHaishiTorikumi_umu(2147483647, 0),
    shokiboKyotenShugoTaisei_umu(2147483647, 0),
    ninchishoCareKasan_umu(2147483647, 0),
    kobetsuKinoKunrenTaisei_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(2147483647, 0),
    kobetsuRehaTeikyoTaisei_SagyoRyoho_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(2147483647, 0),
    kobetsuRehaTeikyoTaisei_Sonota_umu(2147483647, 0),
    setsubiKijun(2147483647, 0),
    ryoyoTaiseiIjiTokubetsuKasan(2147483647, 0),
    kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(2147483647, 0),
    sankyuHelperTaisei(2147483647, 0),
    chuSankanChiikiShokiboJigyoshoKasan_chiiki(2147483647, 0),
    chuSankanChiikiShokiboJigyoushoKasan_kibo(2147483647, 0),
    serviceTeikyoTaiseiKyokaKasan(2147483647, 0),
    ninchishoTankiShuchuRehabilitationKasan(2147483647, 0),
    jakunenseiNinchishoRiyoushaUkeeireKasan(2147483647, 0),
    kangoTaiseiKasan(2147483647, 0),
    yakinShokuinHaichiKasan(2147483647, 0),
    ryoyoShokuKasan(2147483647, 0),
    nichijoSeikatsuKeizokuShienKasan(2147483647, 0),
    ninchishoSemmonCareKasan(2147483647, 0),
    twentyFourHoursTsuhoTaioKasan(2147483647, 0),
    kangoShokuinHaichiKasan(2147483647, 0),
    yakanCareKasan(2147483647, 0),
    shudanCommunicationRyoho_umu(2147483647, 0),
    serviceTeikyoTaiseiKyokaKasan_Karadokogata(2147483647, 0),
    nitchuShintaikaigoTaise_20funmiman_umu(2147483647, 0),
    serviceTeikyoSekininshaTaisei_umu(2147483647, 0),
    doitsuTatemonoKyojuRiyoshaGenzan_umu(2147483647, 0),
    kinkyuTankiNyushoTaiseiKakuhoKasan(2147483647, 0),
    zaitakuFukki_ZaitakuRyoyoShienKinoKasan(2147483647, 0),
    seikatuKinoKojoGroupKatsudoKasan(2147483647, 0),
    kaigoShokuinShoguKaizenKasan(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7063KaigoJigyoshaShiteiService(int maxLength, int scale) {
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
