package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.JunkyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ChiikiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.DaikiboJigyoshoGaitoUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.DoitsuTatemonoKyojuUserGenzanUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.EiyoManagementTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByGengoChokakushiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByIshiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByKaigoStaffKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByKaigoSupportSemmoninKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByKaigojugyoshaKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByKangoStaffKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByRigakuryohoshiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuBySagyoryohoshiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.IryoRenkeiTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.IshiHaichiKijun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JakunenseiNinchishoCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JakunenseiNinchishoRiyoshaUkeireKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JigyoshoHyokaKasanKetteiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JigyoshoHyokaKasanMoshideUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JikanEnchoServiceTaisei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JokinSenjuIshiHaichiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JudokaTaioTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JunUnitCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JuryoininUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JushoHifukaiyoShidoKanriUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.JutakuNyushoSogoriyoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoStaffShoguKaizenKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KangoStaffHaichiKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KangoTaiseiKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KansentaisakuShidoKanriUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KinkyuTankinyushoTaiseiKakuhoKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KinkyuUkeireTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KinkyujiHomonKaigoKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KinokunrenShidoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaisei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_Sonota;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KokuKinoKojoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KyojuhiTaiseku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.NichijoSeikatsuKeizokuSupprtKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.NinchishoCareKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.NinchishoSemmonCareKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.NinchishoSemmontoUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.NinchishoTankiShuchuRehabilitationKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.NyuyokuKaijoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationKasanJokyoUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationKinoKyokaUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationTeikyoTaiseiUmu_RigakuRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationTeikyoTaiseiUmu_RigakuRyoho3;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationTeikyoTaiseiUmu_SagyoRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RehabilitationTeikyoTaiseiUmu_Sonota;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RyoyoTaiseiIjiTokubetsuKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.RyoyoshokuKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.SeikatsuKinoKojoGroupKatsudoKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.SeishinkaIshiTeikitekiRyoyoshidoUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ServiceTeikyoSekininshaTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ServiceTeikyoTaiseiKyokaKasanForKushoType;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.SetsubiKijun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShafukuhojinKeigenJigyoJisshiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShintaikosokuHaishiTorikumiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShiteiKoshinShinseichuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShiteiUmuBySeikatsuhogoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShogaishaSeikatsuSupportTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShokiboJigyoshoKasanInMountainArea_SituationAboutArea;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShokiboJigyoshoKasanInMountainArea_SituationAboutScale;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShokiboKyotenShugoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShokujiTeikyoJokyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShokujiTeikyoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShudanCommunicationRyohoUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.SogeiTaisei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TerminalCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ThirdGradeHelperTaisei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TokubetsuChiikiKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TokubetsuKanriTaisei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TokubetsuNyuyokuKaijoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TokuteiJigyoshoKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TsuhoTaioFor24HoursKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.UndokiKinoKojoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.UnitCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.YakanCareKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.YakanCareUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.YakanKangoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.YakinStaffHaichiKasan;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.YakuzaiKanriShidoUmu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ZaitakuFukkiZaitakuRyoyoSupportKinoKasan;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7063KaigoJigyoshaShiteiServiceの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public class DbT7063KaigoJigyoshaShiteiServiceEntity extends DbTableEntityBase<DbT7063KaigoJigyoshaShiteiServiceEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7063KaigoJigyoshaShiteiService");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    @PrimaryKey
    private KaigoServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private FlexibleDate idoYMD;
    private RString idoJiyu;
    private RString shiteiNo;
    private JunkyoKubun kihonJohoJunkyoKubun;
    private FlexibleDate jigyoKaishiYMD;
    private FlexibleDate jigyoKyushiYMD;
    private FlexibleDate jigyoSaikaiYMD;
    private FlexibleDate jigyoHaishiYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaKanaMeisho jigyoshaNameKana;
    private YubinNo jigyoshaYubinNo;
    private AtenaJusho jigyoshaAddress;
    private RString jigyoshaAddressKana;
    private TelNo jigyoshaTelNo;
    private TelNo jigyoshaFaxNo;
    private RString torokuHokenshaNo;
    private JuryoininUmu juryoininUmu;
    private FlexibleDate torokuKaishiYMD;
    private FlexibleDate torokuShuryoYMD;
    private AtenaMeisho kanrishaName;
    private AtenaKanaMeisho kanrishaNameKana;
    private YubinNo kanrishaYubinNo;
    private AtenaJusho kanrishaAddress;
    private RString kanrishaAddressKana;
    private JunkyoKubun kozaJohoJunkyoKubun;
    private KinyuKikanCode ginkoCode;
    private KinyuKikanShitenCode shitenCode;
    private RString kozaShubetsu;
    private RString kozaNo;
    private AtenaMeisho kozaMeiginin;
    private AtenaKanaMeisho kozaMeigininKana;
    private ShafukuhojinKeigenJigyoJisshiUmu shakaiFukushihoujinKeigenjigyouJisshi_umu;
    private ShiteiUmuBySeikatsuhogoho seikatsuhogohouShitei_umu;
    private Code shisetsunadoKubun;
    private Code jininHaichiKubun;
    private TokubetsuChiikiKasanUmu tokubetsuChiikiKasan_umu;
    private KinkyujiHomonKaigoKasanUmu kinkyujiHomonkaigoKasan_umu;
    private TokubetsuKanriTaisei tokubetsuKanriTaisei;
    private KinokunrenShidoTaiseiUmu kinoKunrenShidoTaisei_umu;
    private ShokujiTeikyoTaiseiUmu shokujiTeikyoTaisei_umu;
    private NyuyokuKaijoTaiseiUmu nyuyokuKaijoTaisei_umu;
    private TokubetsuNyuyokuKaijoTaiseiUmu tokubetsuNyuyokuKaijoTaisei_umu;
    private JokinSenjuIshiHaichiUmu joukinsenjuIshiHaichi_umu;
    private IshiHaichiKijun ishiHaichiKijun;
    private SeishinkaIshiTeikitekiRyoyoshidoUmu seisinkaIshiTeikitekiRyouyousidou_umu;
    private Code yakanKinmuJokenKijun;
    private NinchishoSemmontoUmu ninchishouSenmontou_umu;
    private ShokujiTeikyoJokyo shokujiTeikyoJokyo;
    private SogeiTaisei sougeiTaisei;
    private RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu rehaTeikyoTaisei_SogoRehaShisetsu_umu;
    private RehabilitationTeikyoTaiseiUmu_RigakuRyoho2 rehaTeikyoTaisei_RigakuRyohoII_umu;
    private RehabilitationTeikyoTaiseiUmu_RigakuRyoho3 rehaTeikyoTaisei_RigakuRyohoIII_umu;
    private RehabilitationTeikyoTaiseiUmu_SagyoRyoho2 rehaTeikyoTaisei_SagyoRyohoII_umu;
    private RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
    private RehabilitationTeikyoTaiseiUmu_Sonota rehaTeikyoTaisei_Sonota_umu;
    private RehabilitationKasanJokyoUmu rehabilitationKasanJokyo;
    private Code ryoyoKankyoKijun;
    private GenzanJokyoUmuByIshiKetsuin ishiKetuinGenzanJokyo_umu;
    private GenzanJokyoUmuByKangoStaffKetsuin kangoShokuinKetsuinGenzanJokyo_umu;
    private GenzanJokyoUmuByRigakuryohoshiKetsuin rigakuRyouhousiKetsuinGenzanJokyo_umu;
    private GenzanJokyoUmuBySagyoryohoshiKetsuin sagyouRyouhousiKetsuinGenzanJokyo_umu;
    private GenzanJokyoUmuByKaigoStaffKetsuin kaigoShokuinKetsuinGenzanJokyo_umu;
    private GenzanJokyoUmuByKaigoSupportSemmoninKetsuin kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
    private GenzanJokyoUmuByKaigojugyoshaKetsuin kaigoJujishaKetsuinGenzanJokyo_umu;
    private KansentaisakuShidoKanriUmu kansenTaisakuSidoKanri_umu;
    private JushoHifukaiyoShidoKanriUmu jushoHifuKaiyouShidoKanri_umu;
    private YakuzaiKanriShidoUmu yakuzaiKaniriShido_umu;
    private ShogaishaSeikatsuSupportTaiseiUmu shogaishaSeikatsuShienTaisei_umu;
    private ChiikiKubun chiikiKubunCode;
    private JikanEnchoServiceTaisei jikanEnchoServiceTaisei;
    private KobetsuRehabilitationTeikyoTaisei kobetsuRehabilitationTeikyoTaisei;
    private KyojuhiTaiseku kyojuhiTaisaku;
    private YakanCareUmu yakanCare_umu;
    private RehabilitationKinoKyokaUmu rehabilitationKinoKyoka_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2 kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
    private KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3 kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1 kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2 kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2 kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
    private GenzanJokyoUmuByGengoChokakushiKetsuin gengoChokakushiKetsuinGenzanJokyo_umu;
    private ShafukuhojinKeigenJigyoJisshiUmu eiyouKanriHyoka;
    private TokuteiJigyoshoKasanUmu tokuteijigyoushoKasan_HomonKaigo_umu;
    private JakunenseiNinchishoCareTaiseiUmu jakunenseiNinchishoCareTaisei_umu;
    private UndokiKinoKojoTaiseiUmu undokiKinoKojoTaisei_umu;
    private EiyoManagementTaiseiUmu eiyoManagement_KaizenTaisei_umu;
    private KokuKinoKojoTaiseiUmu kokuKinoKojoTaisei_umu;
    private JigyoshoHyokaKasanMoshideUmu jigyoshoHyokaKasan_Moshide_umu;
    private JigyoshoHyokaKasanKetteiUmu jigyoshoHyokaKasan_Kettei_umu;
    private KinkyuUkeireTaiseiUmu kinkyuUkeireTaisei_umu;
    private YakanKangoTaiseiUmu yakanKangoTaisei_umu;
    private Code tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
    private Decimal kaigoShienSemmoninSenjuJokinshaNinsu;
    private Decimal kaigoSienSemmoninSenjuHijokinshaNinsu;
    private Decimal kaigoSienSemmoninKemmuJokinshaNinsu;
    private Decimal kaigoSienSemmoninKemmuHijokinshaNinsu;
    private Decimal homonkaigoServiceTeikyoSekininshaNinsu;
    private Decimal homonkaigoSenjuJokinshaNinsu;
    private Decimal homonkaigoSenjuHijokinshaNinsu;
    private Decimal homonkaigoKemmuJokinshaNinsu;
    private Decimal homonkaigoKemmuHijokinshaNinsu;
    private Decimal homonkaigoJokinKanzangoNinsu;
    private Decimal riyoTeiinNinsu;
    private FlexibleDate shiteiYukoKaishiYMD;
    private FlexibleDate shiteiYukoShuryoYMD;
    private ShiteiKoshinShinseichuKubun shiteiKoshinShinseichuKubun;
    private FlexibleDate koryokuTeishiKaishiYMD;
    private FlexibleDate koryokuTeishiShuryoYMD;
    private DaikiboJigyoshoGaitoUmu daikiboJigyoshaGaito_umu;
    private JunUnitCareTaiseiUmu junUnitCareTaisei_umu;
    private JudokaTaioTaiseiUmu judokaTaioTaisei_umu;
    private IryoRenkeiTaiseiUmu iryoRenkeiTaisei_umu;
    private UnitCareTaiseiUmu unitCareTaisei_umu;
    private JutakuNyushoSogoriyoTaiseiUmu zaitaku_nyushoSogoRiyoTaisei_umu;
    private TerminalCareTaiseiUmu terminalCareTaisei_umu;
    private ShintaikosokuHaishiTorikumiUmu shintaiKosokuHaishiTorikumi_umu;
    private ShokiboKyotenShugoTaiseiUmu shokiboKyotenShugoTaisei_umu;
    private NinchishoCareKasanUmu ninchishoCareKasan_umu;
    private Code kobetsuKinoKunrenTaisei_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1 kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3 kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
    private KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
    private KobetsuRehabilitationTeikyoTaiseiUmu_Sonota kobetsuRehaTeikyoTaisei_Sonota_umu;
    private SetsubiKijun setsubiKijun;
    private RyoyoTaiseiIjiTokubetsuKasan ryoyoTaiseiIjiTokubetsuKasan;
    private KobetsuRehabilitationTeikyoTaiseiUmu kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
    private ThirdGradeHelperTaisei sankyuHelperTaisei;
    private ShokiboJigyoshoKasanInMountainArea_SituationAboutArea chuSankanChiikiShokiboJigyoshoKasan_chiiki;
    private ShokiboJigyoshoKasanInMountainArea_SituationAboutScale chuSankanChiikiShokiboJigyoushoKasan_kibo;
    private Code serviceTeikyoTaiseiKyokaKasan;
    private NinchishoTankiShuchuRehabilitationKasan ninchishoTankiShuchuRehabilitationKasan;
    private JakunenseiNinchishoRiyoshaUkeireKasan jakunenseiNinchishoRiyoushaUkeeireKasan;
    private KangoTaiseiKasan kangoTaiseiKasan;
    private YakinStaffHaichiKasan yakinShokuinHaichiKasan;
    private RyoyoshokuKasan ryoyoShokuKasan;
    private NichijoSeikatsuKeizokuSupprtKasan nichijoSeikatsuKeizokuShienKasan;
    private NinchishoSemmonCareKasan ninchishoSemmonCareKasan;
    private TsuhoTaioFor24HoursKasan twentyFourHoursTsuhoTaioKasan;
    private KangoStaffHaichiKasan kangoShokuinHaichiKasan;
    private YakanCareKasan yakanCareKasan;
    private ShudanCommunicationRyohoUmu shudanCommunicationRyoho_umu;
    private ServiceTeikyoTaiseiKyokaKasanForKushoType serviceTeikyoTaiseiKyokaKasan_Karadokogata;
    private ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu nitchuShDecimalaikaigoTaise_20funmiman_umu;
    private ServiceTeikyoSekininshaTaiseiUmu serviceTeikyoSekininshaTaisei_umu;
    private DoitsuTatemonoKyojuUserGenzanUmu doitsuTatemonoKyojuRiyoshaGenzan_umu;
    private KinkyuTankinyushoTaiseiKakuhoKasan kinkyuTankiNyushoTaiseiKakuhoKasan;
    private ZaitakuFukkiZaitakuRyoyoSupportKinoKasan zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
    private SeikatsuKinoKojoGroupKatsudoKasan seikatuKinoKojoGroupKatsudoKasan;
    private KaigoStaffShoguKaizenKasan kaigoShokuinShoguKaizenKasan;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public KaigoServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(KaigoServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getYukoKaishiYMD
     *
     * @return yukoKaishiYMD
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * setYukoKaishiYMD
     *
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * getYukoShuryoYMD
     *
     * @return yukoShuryoYMD
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * setYukoShuryoYMD
     *
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * getIdoYMD
     *
     * @return idoYMD
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * setIdoYMD
     *
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * getIdoJiyu
     *
     * @return idoJiyu
     */
    public RString getIdoJiyu() {
        return idoJiyu;
    }

    /**
     * setIdoJiyu
     *
     * @param idoJiyu idoJiyu
     */
    public void setIdoJiyu(RString idoJiyu) {
        this.idoJiyu = idoJiyu;
    }

    /**
     * getShiteiNo
     *
     * @return shiteiNo
     */
    public RString getShiteiNo() {
        return shiteiNo;
    }

    /**
     * setShiteiNo
     *
     * @param shiteiNo shiteiNo
     */
    public void setShiteiNo(RString shiteiNo) {
        this.shiteiNo = shiteiNo;
    }

    /**
     * getKihonJohoJunkyoKubun
     *
     * @return kihonJohoJunkyoKubun
     */
    public JunkyoKubun getKihonJohoJunkyoKubun() {
        return kihonJohoJunkyoKubun;
    }

    /**
     * setKihonJohoJunkyoKubun
     *
     * @param kihonJohoJunkyoKubun kihonJohoJunkyoKubun
     */
    public void setKihonJohoJunkyoKubun(JunkyoKubun kihonJohoJunkyoKubun) {
        this.kihonJohoJunkyoKubun = kihonJohoJunkyoKubun;
    }

    /**
     * getJigyoKaishiYMD
     *
     * @return jigyoKaishiYMD
     */
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * setJigyoKaishiYMD
     *
     * @param jigyoKaishiYMD jigyoKaishiYMD
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * getJigyoKyushiYMD
     *
     * @return jigyoKyushiYMD
     */
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * setJigyoKyushiYMD
     *
     * @param jigyoKyushiYMD jigyoKyushiYMD
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * getJigyoSaikaiYMD
     *
     * @return jigyoSaikaiYMD
     */
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * setJigyoSaikaiYMD
     *
     * @param jigyoSaikaiYMD jigyoSaikaiYMD
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * getJigyoHaishiYMD
     *
     * @return jigyoHaishiYMD
     */
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * setJigyoHaishiYMD
     *
     * @param jigyoHaishiYMD jigyoHaishiYMD
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * getJigyoshaName
     *
     * @return jigyoshaName
     */
    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    /**
     * setJigyoshaName
     *
     * @param jigyoshaName jigyoshaName
     */
    public void setJigyoshaName(AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    /**
     * getJigyoshaNameKana
     *
     * @return jigyoshaNameKana
     */
    public AtenaKanaMeisho getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * setJigyoshaNameKana
     *
     * @param jigyoshaNameKana jigyoshaNameKana
     */
    public void setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * getJigyoshaYubinNo
     *
     * @return jigyoshaYubinNo
     */
    public YubinNo getJigyoshaYubinNo() {
        return jigyoshaYubinNo;
    }

    /**
     * setJigyoshaYubinNo
     *
     * @param jigyoshaYubinNo jigyoshaYubinNo
     */
    public void setJigyoshaYubinNo(YubinNo jigyoshaYubinNo) {
        this.jigyoshaYubinNo = jigyoshaYubinNo;
    }

    /**
     * getJigyoshaAddress
     *
     * @return jigyoshaAddress
     */
    public AtenaJusho getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * setJigyoshaAddress
     *
     * @param jigyoshaAddress jigyoshaAddress
     */
    public void setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * getJigyoshaAddressKana
     *
     * @return jigyoshaAddressKana
     */
    public RString getJigyoshaAddressKana() {
        return jigyoshaAddressKana;
    }

    /**
     * setJigyoshaAddressKana
     *
     * @param jigyoshaAddressKana jigyoshaAddressKana
     */
    public void setJigyoshaAddressKana(RString jigyoshaAddressKana) {
        this.jigyoshaAddressKana = jigyoshaAddressKana;
    }

    /**
     * getJigyoshaTelNo
     *
     * @return jigyoshaTelNo
     */
    public TelNo getJigyoshaTelNo() {
        return jigyoshaTelNo;
    }

    /**
     * setJigyoshaTelNo
     *
     * @param jigyoshaTelNo jigyoshaTelNo
     */
    public void setJigyoshaTelNo(TelNo jigyoshaTelNo) {
        this.jigyoshaTelNo = jigyoshaTelNo;
    }

    /**
     * getJigyoshaFaxNo
     *
     * @return jigyoshaFaxNo
     */
    public TelNo getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * setJigyoshaFaxNo
     *
     * @param jigyoshaFaxNo jigyoshaFaxNo
     */
    public void setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * getTorokuHokenshaNo
     *
     * @return torokuHokenshaNo
     */
    public RString getTorokuHokenshaNo() {
        return torokuHokenshaNo;
    }

    /**
     * setTorokuHokenshaNo
     *
     * @param torokuHokenshaNo torokuHokenshaNo
     */
    public void setTorokuHokenshaNo(RString torokuHokenshaNo) {
        this.torokuHokenshaNo = torokuHokenshaNo;
    }

    /**
     * getJuryoininUmu
     *
     * @return juryoininUmu
     */
    public JuryoininUmu getJuryoininUmu() {
        return juryoininUmu;
    }

    /**
     * setJuryoininUmu
     *
     * @param juryoininUmu juryoininUmu
     */
    public void setJuryoininUmu(JuryoininUmu juryoininUmu) {
        this.juryoininUmu = juryoininUmu;
    }

    /**
     * getTorokuKaishiYMD
     *
     * @return torokuKaishiYMD
     */
    public FlexibleDate getTorokuKaishiYMD() {
        return torokuKaishiYMD;
    }

    /**
     * setTorokuKaishiYMD
     *
     * @param torokuKaishiYMD torokuKaishiYMD
     */
    public void setTorokuKaishiYMD(FlexibleDate torokuKaishiYMD) {
        this.torokuKaishiYMD = torokuKaishiYMD;
    }

    /**
     * getTorokuShuryoYMD
     *
     * @return torokuShuryoYMD
     */
    public FlexibleDate getTorokuShuryoYMD() {
        return torokuShuryoYMD;
    }

    /**
     * setTorokuShuryoYMD
     *
     * @param torokuShuryoYMD torokuShuryoYMD
     */
    public void setTorokuShuryoYMD(FlexibleDate torokuShuryoYMD) {
        this.torokuShuryoYMD = torokuShuryoYMD;
    }

    /**
     * getKanrishaName
     *
     * @return kanrishaName
     */
    public AtenaMeisho getKanrishaName() {
        return kanrishaName;
    }

    /**
     * setKanrishaName
     *
     * @param kanrishaName kanrishaName
     */
    public void setKanrishaName(AtenaMeisho kanrishaName) {
        this.kanrishaName = kanrishaName;
    }

    /**
     * getKanrishaNameKana
     *
     * @return kanrishaNameKana
     */
    public AtenaKanaMeisho getKanrishaNameKana() {
        return kanrishaNameKana;
    }

    /**
     * setKanrishaNameKana
     *
     * @param kanrishaNameKana kanrishaNameKana
     */
    public void setKanrishaNameKana(AtenaKanaMeisho kanrishaNameKana) {
        this.kanrishaNameKana = kanrishaNameKana;
    }

    /**
     * getKanrishaYubinNo
     *
     * @return kanrishaYubinNo
     */
    public YubinNo getKanrishaYubinNo() {
        return kanrishaYubinNo;
    }

    /**
     * setKanrishaYubinNo
     *
     * @param kanrishaYubinNo kanrishaYubinNo
     */
    public void setKanrishaYubinNo(YubinNo kanrishaYubinNo) {
        this.kanrishaYubinNo = kanrishaYubinNo;
    }

    /**
     * getKanrishaAddress
     *
     * @return kanrishaAddress
     */
    public AtenaJusho getKanrishaAddress() {
        return kanrishaAddress;
    }

    /**
     * setKanrishaAddress
     *
     * @param kanrishaAddress kanrishaAddress
     */
    public void setKanrishaAddress(AtenaJusho kanrishaAddress) {
        this.kanrishaAddress = kanrishaAddress;
    }

    /**
     * getKanrishaAddressKana
     *
     * @return kanrishaAddressKana
     */
    public RString getKanrishaAddressKana() {
        return kanrishaAddressKana;
    }

    /**
     * setKanrishaAddressKana
     *
     * @param kanrishaAddressKana kanrishaAddressKana
     */
    public void setKanrishaAddressKana(RString kanrishaAddressKana) {
        this.kanrishaAddressKana = kanrishaAddressKana;
    }

    /**
     * getKozaJohoJunkyoKubun
     *
     * @return kozaJohoJunkyoKubun
     */
    public JunkyoKubun getKozaJohoJunkyoKubun() {
        return kozaJohoJunkyoKubun;
    }

    /**
     * setKozaJohoJunkyoKubun
     *
     * @param kozaJohoJunkyoKubun kozaJohoJunkyoKubun
     */
    public void setKozaJohoJunkyoKubun(JunkyoKubun kozaJohoJunkyoKubun) {
        this.kozaJohoJunkyoKubun = kozaJohoJunkyoKubun;
    }

    /**
     * getGinkoCode
     *
     * @return ginkoCode
     */
    public KinyuKikanCode getGinkoCode() {
        return ginkoCode;
    }

    /**
     * setGinkoCode
     *
     * @param ginkoCode ginkoCode
     */
    public void setGinkoCode(KinyuKikanCode ginkoCode) {
        this.ginkoCode = ginkoCode;
    }

    /**
     * getShitenCode
     *
     * @return shitenCode
     */
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * setShitenCode
     *
     * @param shitenCode shitenCode
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * getKozaShubetsu
     *
     * @return kozaShubetsu
     */
    public RString getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * setKozaShubetsu
     *
     * @param kozaShubetsu kozaShubetsu
     */
    public void setKozaShubetsu(RString kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * getKozaNo
     *
     * @return kozaNo
     */
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * setKozaNo
     *
     * @param kozaNo kozaNo
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * getKozaMeiginin
     *
     * @return kozaMeiginin
     */
    public AtenaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * setKozaMeiginin
     *
     * @param kozaMeiginin kozaMeiginin
     */
    public void setKozaMeiginin(AtenaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * getKozaMeigininKana
     *
     * @return kozaMeigininKana
     */
    public AtenaKanaMeisho getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * setKozaMeigininKana
     *
     * @param kozaMeigininKana kozaMeigininKana
     */
    public void setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * getShakaiFukushihoujinKeigenjigyouJisshi_umu
     *
     * @return shakaiFukushihoujinKeigenjigyouJisshi_umu
     */
    public ShafukuhojinKeigenJigyoJisshiUmu getShakaiFukushihoujinKeigenjigyouJisshi_umu() {
        return shakaiFukushihoujinKeigenjigyouJisshi_umu;
    }

    /**
     * setShakaiFukushihoujinKeigenjigyouJisshi_umu
     *
     * @param shakaiFukushihoujinKeigenjigyouJisshi_umu
     * shakaiFukushihoujinKeigenjigyouJisshi_umu
     */
    public void setShakaiFukushihoujinKeigenjigyouJisshi_umu(ShafukuhojinKeigenJigyoJisshiUmu shakaiFukushihoujinKeigenjigyouJisshi_umu) {
        this.shakaiFukushihoujinKeigenjigyouJisshi_umu = shakaiFukushihoujinKeigenjigyouJisshi_umu;
    }

    /**
     * getSeikatsuhogohouShitei_umu
     *
     * @return seikatsuhogohouShitei_umu
     */
    public ShiteiUmuBySeikatsuhogoho getSeikatsuhogohouShitei_umu() {
        return seikatsuhogohouShitei_umu;
    }

    /**
     * setSeikatsuhogohouShitei_umu
     *
     * @param seikatsuhogohouShitei_umu seikatsuhogohouShitei_umu
     */
    public void setSeikatsuhogohouShitei_umu(ShiteiUmuBySeikatsuhogoho seikatsuhogohouShitei_umu) {
        this.seikatsuhogohouShitei_umu = seikatsuhogohouShitei_umu;
    }

    /**
     * getShisetsunadoKubun
     *
     * @return shisetsunadoKubun
     */
    public Code getShisetsunadoKubun() {
        return shisetsunadoKubun;
    }

    /**
     * setShisetsunadoKubun
     *
     * @param shisetsunadoKubun shisetsunadoKubun
     */
    public void setShisetsunadoKubun(Code shisetsunadoKubun) {
        this.shisetsunadoKubun = shisetsunadoKubun;
    }

    /**
     * getJininHaichiKubun
     *
     * @return jininHaichiKubun
     */
    public Code getJininHaichiKubun() {
        return jininHaichiKubun;
    }

    /**
     * setJininHaichiKubun
     *
     * @param jininHaichiKubun jininHaichiKubun
     */
    public void setJininHaichiKubun(Code jininHaichiKubun) {
        this.jininHaichiKubun = jininHaichiKubun;
    }

    /**
     * getTokubetsuChiikiKasan_umu
     *
     * @return tokubetsuChiikiKasan_umu
     */
    public TokubetsuChiikiKasanUmu getTokubetsuChiikiKasan_umu() {
        return tokubetsuChiikiKasan_umu;
    }

    /**
     * setTokubetsuChiikiKasan_umu
     *
     * @param tokubetsuChiikiKasan_umu tokubetsuChiikiKasan_umu
     */
    public void setTokubetsuChiikiKasan_umu(TokubetsuChiikiKasanUmu tokubetsuChiikiKasan_umu) {
        this.tokubetsuChiikiKasan_umu = tokubetsuChiikiKasan_umu;
    }

    /**
     * getKinkyujiHomonkaigoKasan_umu
     *
     * @return kinkyujiHomonkaigoKasan_umu
     */
    public KinkyujiHomonKaigoKasanUmu getKinkyujiHomonkaigoKasan_umu() {
        return kinkyujiHomonkaigoKasan_umu;
    }

    /**
     * setKinkyujiHomonkaigoKasan_umu
     *
     * @param kinkyujiHomonkaigoKasan_umu kinkyujiHomonkaigoKasan_umu
     */
    public void setKinkyujiHomonkaigoKasan_umu(KinkyujiHomonKaigoKasanUmu kinkyujiHomonkaigoKasan_umu) {
        this.kinkyujiHomonkaigoKasan_umu = kinkyujiHomonkaigoKasan_umu;
    }

    /**
     * getTokubetsuKanriTaisei
     *
     * @return tokubetsuKanriTaisei
     */
    public TokubetsuKanriTaisei getTokubetsuKanriTaisei() {
        return tokubetsuKanriTaisei;
    }

    /**
     * setTokubetsuKanriTaisei
     *
     * @param tokubetsuKanriTaisei tokubetsuKanriTaisei
     */
    public void setTokubetsuKanriTaisei(TokubetsuKanriTaisei tokubetsuKanriTaisei) {
        this.tokubetsuKanriTaisei = tokubetsuKanriTaisei;
    }

    /**
     * getKinoKunrenShidoTaisei_umu
     *
     * @return kinoKunrenShidoTaisei_umu
     */
    public KinokunrenShidoTaiseiUmu getKinoKunrenShidoTaisei_umu() {
        return kinoKunrenShidoTaisei_umu;
    }

    /**
     * setKinoKunrenShidoTaisei_umu
     *
     * @param kinoKunrenShidoTaisei_umu kinoKunrenShidoTaisei_umu
     */
    public void setKinoKunrenShidoTaisei_umu(KinokunrenShidoTaiseiUmu kinoKunrenShidoTaisei_umu) {
        this.kinoKunrenShidoTaisei_umu = kinoKunrenShidoTaisei_umu;
    }

    /**
     * getShokujiTeikyoTaisei_umu
     *
     * @return shokujiTeikyoTaisei_umu
     */
    public ShokujiTeikyoTaiseiUmu getShokujiTeikyoTaisei_umu() {
        return shokujiTeikyoTaisei_umu;
    }

    /**
     * setShokujiTeikyoTaisei_umu
     *
     * @param shokujiTeikyoTaisei_umu shokujiTeikyoTaisei_umu
     */
    public void setShokujiTeikyoTaisei_umu(ShokujiTeikyoTaiseiUmu shokujiTeikyoTaisei_umu) {
        this.shokujiTeikyoTaisei_umu = shokujiTeikyoTaisei_umu;
    }

    /**
     * getNyuyokuKaijoTaisei_umu
     *
     * @return nyuyokuKaijoTaisei_umu
     */
    public NyuyokuKaijoTaiseiUmu getNyuyokuKaijoTaisei_umu() {
        return nyuyokuKaijoTaisei_umu;
    }

    /**
     * setNyuyokuKaijoTaisei_umu
     *
     * @param nyuyokuKaijoTaisei_umu nyuyokuKaijoTaisei_umu
     */
    public void setNyuyokuKaijoTaisei_umu(NyuyokuKaijoTaiseiUmu nyuyokuKaijoTaisei_umu) {
        this.nyuyokuKaijoTaisei_umu = nyuyokuKaijoTaisei_umu;
    }

    /**
     * getTokubetsuNyuyokuKaijoTaisei_umu
     *
     * @return tokubetsuNyuyokuKaijoTaisei_umu
     */
    public TokubetsuNyuyokuKaijoTaiseiUmu getTokubetsuNyuyokuKaijoTaisei_umu() {
        return tokubetsuNyuyokuKaijoTaisei_umu;
    }

    /**
     * setTokubetsuNyuyokuKaijoTaisei_umu
     *
     * @param tokubetsuNyuyokuKaijoTaisei_umu tokubetsuNyuyokuKaijoTaisei_umu
     */
    public void setTokubetsuNyuyokuKaijoTaisei_umu(TokubetsuNyuyokuKaijoTaiseiUmu tokubetsuNyuyokuKaijoTaisei_umu) {
        this.tokubetsuNyuyokuKaijoTaisei_umu = tokubetsuNyuyokuKaijoTaisei_umu;
    }

    /**
     * getJoukinsenjuIshiHaichi_umu
     *
     * @return joukinsenjuIshiHaichi_umu
     */
    public JokinSenjuIshiHaichiUmu getJoukinsenjuIshiHaichi_umu() {
        return joukinsenjuIshiHaichi_umu;
    }

    /**
     * setJoukinsenjuIshiHaichi_umu
     *
     * @param joukinsenjuIshiHaichi_umu joukinsenjuIshiHaichi_umu
     */
    public void setJoukinsenjuIshiHaichi_umu(JokinSenjuIshiHaichiUmu joukinsenjuIshiHaichi_umu) {
        this.joukinsenjuIshiHaichi_umu = joukinsenjuIshiHaichi_umu;
    }

    /**
     * getIshiHaichiKijun
     *
     * @return ishiHaichiKijun
     */
    public IshiHaichiKijun getIshiHaichiKijun() {
        return ishiHaichiKijun;
    }

    /**
     * setIshiHaichiKijun
     *
     * @param ishiHaichiKijun ishiHaichiKijun
     */
    public void setIshiHaichiKijun(IshiHaichiKijun ishiHaichiKijun) {
        this.ishiHaichiKijun = ishiHaichiKijun;
    }

    /**
     * getSeisinkaIshiTeikitekiRyouyousidou_umu
     *
     * @return seisinkaIshiTeikitekiRyouyousidou_umu
     */
    public SeishinkaIshiTeikitekiRyoyoshidoUmu getSeisinkaIshiTeikitekiRyouyousidou_umu() {
        return seisinkaIshiTeikitekiRyouyousidou_umu;
    }

    /**
     * setSeisinkaIshiTeikitekiRyouyousidou_umu
     *
     * @param seisinkaIshiTeikitekiRyouyousidou_umu
     * seisinkaIshiTeikitekiRyouyousidou_umu
     */
    public void setSeisinkaIshiTeikitekiRyouyousidou_umu(SeishinkaIshiTeikitekiRyoyoshidoUmu seisinkaIshiTeikitekiRyouyousidou_umu) {
        this.seisinkaIshiTeikitekiRyouyousidou_umu = seisinkaIshiTeikitekiRyouyousidou_umu;
    }

    /**
     * getYakanKinmuJokenKijun
     *
     * @return yakanKinmuJokenKijun
     */
    public Code getYakanKinmuJokenKijun() {
        return yakanKinmuJokenKijun;
    }

    /**
     * setYakanKinmuJokenKijun
     *
     * @param yakanKinmuJokenKijun yakanKinmuJokenKijun
     */
    public void setYakanKinmuJokenKijun(Code yakanKinmuJokenKijun) {
        this.yakanKinmuJokenKijun = yakanKinmuJokenKijun;
    }

    /**
     * getNinchishouSenmontou_umu
     *
     * @return ninchishouSenmontou_umu
     */
    public NinchishoSemmontoUmu getNinchishouSenmontou_umu() {
        return ninchishouSenmontou_umu;
    }

    /**
     * setNinchishouSenmontou_umu
     *
     * @param ninchishouSenmontou_umu ninchishouSenmontou_umu
     */
    public void setNinchishouSenmontou_umu(NinchishoSemmontoUmu ninchishouSenmontou_umu) {
        this.ninchishouSenmontou_umu = ninchishouSenmontou_umu;
    }

    /**
     * getShokujiTeikyoJokyo
     *
     * @return shokujiTeikyoJokyo
     */
    public ShokujiTeikyoJokyo getShokujiTeikyoJokyo() {
        return shokujiTeikyoJokyo;
    }

    /**
     * setShokujiTeikyoJokyo
     *
     * @param shokujiTeikyoJokyo shokujiTeikyoJokyo
     */
    public void setShokujiTeikyoJokyo(ShokujiTeikyoJokyo shokujiTeikyoJokyo) {
        this.shokujiTeikyoJokyo = shokujiTeikyoJokyo;
    }

    /**
     * getSougeiTaisei
     *
     * @return sougeiTaisei
     */
    public SogeiTaisei getSougeiTaisei() {
        return sougeiTaisei;
    }

    /**
     * setSougeiTaisei
     *
     * @param sougeiTaisei sougeiTaisei
     */
    public void setSougeiTaisei(SogeiTaisei sougeiTaisei) {
        this.sougeiTaisei = sougeiTaisei;
    }

    /**
     * getRehaTeikyoTaisei_SogoRehaShisetsu_umu
     *
     * @return rehaTeikyoTaisei_SogoRehaShisetsu_umu
     */
    public RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu getRehaTeikyoTaisei_SogoRehaShisetsu_umu() {
        return rehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * setRehaTeikyoTaisei_SogoRehaShisetsu_umu
     *
     * @param rehaTeikyoTaisei_SogoRehaShisetsu_umu
     * rehaTeikyoTaisei_SogoRehaShisetsu_umu
     */
    public void setRehaTeikyoTaisei_SogoRehaShisetsu_umu(RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu rehaTeikyoTaisei_SogoRehaShisetsu_umu) {
        this.rehaTeikyoTaisei_SogoRehaShisetsu_umu = rehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * getRehaTeikyoTaisei_RigakuRyohoII_umu
     *
     * @return rehaTeikyoTaisei_RigakuRyohoII_umu
     */
    public RehabilitationTeikyoTaiseiUmu_RigakuRyoho2 getRehaTeikyoTaisei_RigakuRyohoII_umu() {
        return rehaTeikyoTaisei_RigakuRyohoII_umu;
    }

    /**
     * setRehaTeikyoTaisei_RigakuRyohoII_umu
     *
     * @param rehaTeikyoTaisei_RigakuRyohoII_umu
     * rehaTeikyoTaisei_RigakuRyohoII_umu
     */
    public void setRehaTeikyoTaisei_RigakuRyohoII_umu(RehabilitationTeikyoTaiseiUmu_RigakuRyoho2 rehaTeikyoTaisei_RigakuRyohoII_umu) {
        this.rehaTeikyoTaisei_RigakuRyohoII_umu = rehaTeikyoTaisei_RigakuRyohoII_umu;
    }

    /**
     * getRehaTeikyoTaisei_RigakuRyohoIII_umu
     *
     * @return rehaTeikyoTaisei_RigakuRyohoIII_umu
     */
    public RehabilitationTeikyoTaiseiUmu_RigakuRyoho3 getRehaTeikyoTaisei_RigakuRyohoIII_umu() {
        return rehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * setRehaTeikyoTaisei_RigakuRyohoIII_umu
     *
     * @param rehaTeikyoTaisei_RigakuRyohoIII_umu
     * rehaTeikyoTaisei_RigakuRyohoIII_umu
     */
    public void setRehaTeikyoTaisei_RigakuRyohoIII_umu(RehabilitationTeikyoTaiseiUmu_RigakuRyoho3 rehaTeikyoTaisei_RigakuRyohoIII_umu) {
        this.rehaTeikyoTaisei_RigakuRyohoIII_umu = rehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * getRehaTeikyoTaisei_SagyoRyohoII_umu
     *
     * @return rehaTeikyoTaisei_SagyoRyohoII_umu
     */
    public RehabilitationTeikyoTaiseiUmu_SagyoRyoho2 getRehaTeikyoTaisei_SagyoRyohoII_umu() {
        return rehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * setRehaTeikyoTaisei_SagyoRyohoII_umu
     *
     * @param rehaTeikyoTaisei_SagyoRyohoII_umu
     * rehaTeikyoTaisei_SagyoRyohoII_umu
     */
    public void setRehaTeikyoTaisei_SagyoRyohoII_umu(RehabilitationTeikyoTaiseiUmu_SagyoRyoho2 rehaTeikyoTaisei_SagyoRyohoII_umu) {
        this.rehaTeikyoTaisei_SagyoRyohoII_umu = rehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu
     *
     * @return rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu
     */
    public RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu() {
        return rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
    }

    /**
     * setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu
     *
     * @param rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu
     * rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu
     */
    public void setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu) {
        this.rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu = rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
    }

    /**
     * getRehaTeikyoTaisei_Sonota_umu
     *
     * @return rehaTeikyoTaisei_Sonota_umu
     */
    public RehabilitationTeikyoTaiseiUmu_Sonota getRehaTeikyoTaisei_Sonota_umu() {
        return rehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * setRehaTeikyoTaisei_Sonota_umu
     *
     * @param rehaTeikyoTaisei_Sonota_umu rehaTeikyoTaisei_Sonota_umu
     */
    public void setRehaTeikyoTaisei_Sonota_umu(RehabilitationTeikyoTaiseiUmu_Sonota rehaTeikyoTaisei_Sonota_umu) {
        this.rehaTeikyoTaisei_Sonota_umu = rehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * getRehabilitationKasanJokyo
     *
     * @return rehabilitationKasanJokyo
     */
    public RehabilitationKasanJokyoUmu getRehabilitationKasanJokyo() {
        return rehabilitationKasanJokyo;
    }

    /**
     * setRehabilitationKasanJokyo
     *
     * @param rehabilitationKasanJokyo rehabilitationKasanJokyo
     */
    public void setRehabilitationKasanJokyo(RehabilitationKasanJokyoUmu rehabilitationKasanJokyo) {
        this.rehabilitationKasanJokyo = rehabilitationKasanJokyo;
    }

    /**
     * getRyoyoKankyoKijun
     *
     * @return ryoyoKankyoKijun
     */
    public Code getRyoyoKankyoKijun() {
        return ryoyoKankyoKijun;
    }

    /**
     * setRyoyoKankyoKijun
     *
     * @param ryoyoKankyoKijun ryoyoKankyoKijun
     */
    public void setRyoyoKankyoKijun(Code ryoyoKankyoKijun) {
        this.ryoyoKankyoKijun = ryoyoKankyoKijun;
    }

    /**
     * getIshiKetuinGenzanJokyo_umu
     *
     * @return ishiKetuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByIshiKetsuin getIshiKetuinGenzanJokyo_umu() {
        return ishiKetuinGenzanJokyo_umu;
    }

    /**
     * setIshiKetuinGenzanJokyo_umu
     *
     * @param ishiKetuinGenzanJokyo_umu ishiKetuinGenzanJokyo_umu
     */
    public void setIshiKetuinGenzanJokyo_umu(GenzanJokyoUmuByIshiKetsuin ishiKetuinGenzanJokyo_umu) {
        this.ishiKetuinGenzanJokyo_umu = ishiKetuinGenzanJokyo_umu;
    }

    /**
     * getKangoShokuinKetsuinGenzanJokyo_umu
     *
     * @return kangoShokuinKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByKangoStaffKetsuin getKangoShokuinKetsuinGenzanJokyo_umu() {
        return kangoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * setKangoShokuinKetsuinGenzanJokyo_umu
     *
     * @param kangoShokuinKetsuinGenzanJokyo_umu
     * kangoShokuinKetsuinGenzanJokyo_umu
     */
    public void setKangoShokuinKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKangoStaffKetsuin kangoShokuinKetsuinGenzanJokyo_umu) {
        this.kangoShokuinKetsuinGenzanJokyo_umu = kangoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * getRigakuRyouhousiKetsuinGenzanJokyo_umu
     *
     * @return rigakuRyouhousiKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByRigakuryohoshiKetsuin getRigakuRyouhousiKetsuinGenzanJokyo_umu() {
        return rigakuRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * setRigakuRyouhousiKetsuinGenzanJokyo_umu
     *
     * @param rigakuRyouhousiKetsuinGenzanJokyo_umu
     * rigakuRyouhousiKetsuinGenzanJokyo_umu
     */
    public void setRigakuRyouhousiKetsuinGenzanJokyo_umu(GenzanJokyoUmuByRigakuryohoshiKetsuin rigakuRyouhousiKetsuinGenzanJokyo_umu) {
        this.rigakuRyouhousiKetsuinGenzanJokyo_umu = rigakuRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * getSagyouRyouhousiKetsuinGenzanJokyo_umu
     *
     * @return sagyouRyouhousiKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuBySagyoryohoshiKetsuin getSagyouRyouhousiKetsuinGenzanJokyo_umu() {
        return sagyouRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * setSagyouRyouhousiKetsuinGenzanJokyo_umu
     *
     * @param sagyouRyouhousiKetsuinGenzanJokyo_umu
     * sagyouRyouhousiKetsuinGenzanJokyo_umu
     */
    public void setSagyouRyouhousiKetsuinGenzanJokyo_umu(GenzanJokyoUmuBySagyoryohoshiKetsuin sagyouRyouhousiKetsuinGenzanJokyo_umu) {
        this.sagyouRyouhousiKetsuinGenzanJokyo_umu = sagyouRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * getKaigoShokuinKetsuinGenzanJokyo_umu
     *
     * @return kaigoShokuinKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByKaigoStaffKetsuin getKaigoShokuinKetsuinGenzanJokyo_umu() {
        return kaigoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * setKaigoShokuinKetsuinGenzanJokyo_umu
     *
     * @param kaigoShokuinKetsuinGenzanJokyo_umu
     * kaigoShokuinKetsuinGenzanJokyo_umu
     */
    public void setKaigoShokuinKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKaigoStaffKetsuin kaigoShokuinKetsuinGenzanJokyo_umu) {
        this.kaigoShokuinKetsuinGenzanJokyo_umu = kaigoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
     *
     * @return kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByKaigoSupportSemmoninKetsuin getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu() {
        return kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
     *
     * @param kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
     * kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
     */
    public void setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKaigoSupportSemmoninKetsuin kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu) {
        this.kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu = kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * getKaigoJujishaKetsuinGenzanJokyo_umu
     *
     * @return kaigoJujishaKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByKaigojugyoshaKetsuin getKaigoJujishaKetsuinGenzanJokyo_umu() {
        return kaigoJujishaKetsuinGenzanJokyo_umu;
    }

    /**
     * setKaigoJujishaKetsuinGenzanJokyo_umu
     *
     * @param kaigoJujishaKetsuinGenzanJokyo_umu
     * kaigoJujishaKetsuinGenzanJokyo_umu
     */
    public void setKaigoJujishaKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKaigojugyoshaKetsuin kaigoJujishaKetsuinGenzanJokyo_umu) {
        this.kaigoJujishaKetsuinGenzanJokyo_umu = kaigoJujishaKetsuinGenzanJokyo_umu;
    }

    /**
     * getKansenTaisakuSidoKanri_umu
     *
     * @return kansenTaisakuSidoKanri_umu
     */
    public KansentaisakuShidoKanriUmu getKansenTaisakuSidoKanri_umu() {
        return kansenTaisakuSidoKanri_umu;
    }

    /**
     * setKansenTaisakuSidoKanri_umu
     *
     * @param kansenTaisakuSidoKanri_umu kansenTaisakuSidoKanri_umu
     */
    public void setKansenTaisakuSidoKanri_umu(KansentaisakuShidoKanriUmu kansenTaisakuSidoKanri_umu) {
        this.kansenTaisakuSidoKanri_umu = kansenTaisakuSidoKanri_umu;
    }

    /**
     * getJushoHifuKaiyouShidoKanri_umu
     *
     * @return jushoHifuKaiyouShidoKanri_umu
     */
    public JushoHifukaiyoShidoKanriUmu getJushoHifuKaiyouShidoKanri_umu() {
        return jushoHifuKaiyouShidoKanri_umu;
    }

    /**
     * setJushoHifuKaiyouShidoKanri_umu
     *
     * @param jushoHifuKaiyouShidoKanri_umu jushoHifuKaiyouShidoKanri_umu
     */
    public void setJushoHifuKaiyouShidoKanri_umu(JushoHifukaiyoShidoKanriUmu jushoHifuKaiyouShidoKanri_umu) {
        this.jushoHifuKaiyouShidoKanri_umu = jushoHifuKaiyouShidoKanri_umu;
    }

    /**
     * getYakuzaiKaniriShido_umu
     *
     * @return yakuzaiKaniriShido_umu
     */
    public YakuzaiKanriShidoUmu getYakuzaiKaniriShido_umu() {
        return yakuzaiKaniriShido_umu;
    }

    /**
     * setYakuzaiKaniriShido_umu
     *
     * @param yakuzaiKaniriShido_umu yakuzaiKaniriShido_umu
     */
    public void setYakuzaiKaniriShido_umu(YakuzaiKanriShidoUmu yakuzaiKaniriShido_umu) {
        this.yakuzaiKaniriShido_umu = yakuzaiKaniriShido_umu;
    }

    /**
     * getShogaishaSeikatsuShienTaisei_umu
     *
     * @return shogaishaSeikatsuShienTaisei_umu
     */
    public ShogaishaSeikatsuSupportTaiseiUmu getShogaishaSeikatsuShienTaisei_umu() {
        return shogaishaSeikatsuShienTaisei_umu;
    }

    /**
     * setShogaishaSeikatsuShienTaisei_umu
     *
     * @param shogaishaSeikatsuShienTaisei_umu shogaishaSeikatsuShienTaisei_umu
     */
    public void setShogaishaSeikatsuShienTaisei_umu(ShogaishaSeikatsuSupportTaiseiUmu shogaishaSeikatsuShienTaisei_umu) {
        this.shogaishaSeikatsuShienTaisei_umu = shogaishaSeikatsuShienTaisei_umu;
    }

    /**
     * getChiikiKubunCode
     *
     * @return chiikiKubunCode
     */
    public ChiikiKubun getChiikiKubunCode() {
        return chiikiKubunCode;
    }

    /**
     * setChiikiKubunCode
     *
     * @param chiikiKubunCode chiikiKubunCode
     */
    public void setChiikiKubunCode(ChiikiKubun chiikiKubunCode) {
        this.chiikiKubunCode = chiikiKubunCode;
    }

    /**
     * getJikanEnchoServiceTaisei
     *
     * @return jikanEnchoServiceTaisei
     */
    public JikanEnchoServiceTaisei getJikanEnchoServiceTaisei() {
        return jikanEnchoServiceTaisei;
    }

    /**
     * setJikanEnchoServiceTaisei
     *
     * @param jikanEnchoServiceTaisei jikanEnchoServiceTaisei
     */
    public void setJikanEnchoServiceTaisei(JikanEnchoServiceTaisei jikanEnchoServiceTaisei) {
        this.jikanEnchoServiceTaisei = jikanEnchoServiceTaisei;
    }

    /**
     * getKobetsuRehabilitationTeikyoTaisei
     *
     * @return kobetsuRehabilitationTeikyoTaisei
     */
    public KobetsuRehabilitationTeikyoTaisei getKobetsuRehabilitationTeikyoTaisei() {
        return kobetsuRehabilitationTeikyoTaisei;
    }

    /**
     * setKobetsuRehabilitationTeikyoTaisei
     *
     * @param kobetsuRehabilitationTeikyoTaisei
     * kobetsuRehabilitationTeikyoTaisei
     */
    public void setKobetsuRehabilitationTeikyoTaisei(KobetsuRehabilitationTeikyoTaisei kobetsuRehabilitationTeikyoTaisei) {
        this.kobetsuRehabilitationTeikyoTaisei = kobetsuRehabilitationTeikyoTaisei;
    }

    /**
     * getKyojuhiTaisaku
     *
     * @return kyojuhiTaisaku
     */
    public KyojuhiTaiseku getKyojuhiTaisaku() {
        return kyojuhiTaisaku;
    }

    /**
     * setKyojuhiTaisaku
     *
     * @param kyojuhiTaisaku kyojuhiTaisaku
     */
    public void setKyojuhiTaisaku(KyojuhiTaiseku kyojuhiTaisaku) {
        this.kyojuhiTaisaku = kyojuhiTaisaku;
    }

    /**
     * getYakanCare_umu
     *
     * @return yakanCare_umu
     */
    public YakanCareUmu getYakanCare_umu() {
        return yakanCare_umu;
    }

    /**
     * setYakanCare_umu
     *
     * @param yakanCare_umu yakanCare_umu
     */
    public void setYakanCare_umu(YakanCareUmu yakanCare_umu) {
        this.yakanCare_umu = yakanCare_umu;
    }

    /**
     * getRehabilitationKinoKyoka_umu
     *
     * @return rehabilitationKinoKyoka_umu
     */
    public RehabilitationKinoKyokaUmu getRehabilitationKinoKyoka_umu() {
        return rehabilitationKinoKyoka_umu;
    }

    /**
     * setRehabilitationKinoKyoka_umu
     *
     * @param rehabilitationKinoKyoka_umu rehabilitationKinoKyoka_umu
     */
    public void setRehabilitationKinoKyoka_umu(RehabilitationKinoKyokaUmu rehabilitationKinoKyoka_umu) {
        this.rehabilitationKinoKyoka_umu = rehabilitationKinoKyoka_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
     *
     * @return kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu() {
        return kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
     *
     * @param kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
     * kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
     */
    public void setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu) {
        this.kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu = kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
     *
     * @return kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2 getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
     * kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2 kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1 = kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
     *
     * @return kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3 getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
     * kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3 kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu = kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu
     *
     * @return kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1 getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu() {
        return kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu
     *
     * @param kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu
     * kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu
     */
    public void setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1 kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu) {
        this.kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu = kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
     *
     * @return kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2 getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu() {
        return kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
     *
     * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
     * kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
     */
    public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2 kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu) {
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu = kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
     *
     * @return kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2 getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu() {
        return kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
     *
     * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
     * kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
     */
    public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2 kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu) {
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu = kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
    }

    /**
     * getGengoChokakushiKetsuinGenzanJokyo_umu
     *
     * @return gengoChokakushiKetsuinGenzanJokyo_umu
     */
    public GenzanJokyoUmuByGengoChokakushiKetsuin getGengoChokakushiKetsuinGenzanJokyo_umu() {
        return gengoChokakushiKetsuinGenzanJokyo_umu;
    }

    /**
     * setGengoChokakushiKetsuinGenzanJokyo_umu
     *
     * @param gengoChokakushiKetsuinGenzanJokyo_umu
     * gengoChokakushiKetsuinGenzanJokyo_umu
     */
    public void setGengoChokakushiKetsuinGenzanJokyo_umu(GenzanJokyoUmuByGengoChokakushiKetsuin gengoChokakushiKetsuinGenzanJokyo_umu) {
        this.gengoChokakushiKetsuinGenzanJokyo_umu = gengoChokakushiKetsuinGenzanJokyo_umu;
    }

    /**
     * getEiyouKanriHyoka
     *
     * @return eiyouKanriHyoka
     */
    public ShafukuhojinKeigenJigyoJisshiUmu getEiyouKanriHyoka() {
        return eiyouKanriHyoka;
    }

    /**
     * setEiyouKanriHyoka
     *
     * @param eiyouKanriHyoka eiyouKanriHyoka
     */
    public void setEiyouKanriHyoka(ShafukuhojinKeigenJigyoJisshiUmu eiyouKanriHyoka) {
        this.eiyouKanriHyoka = eiyouKanriHyoka;
    }

    /**
     * getTokuteijigyoushoKasan_HomonKaigo_umu
     *
     * @return tokuteijigyoushoKasan_HomonKaigo_umu
     */
    public TokuteiJigyoshoKasanUmu getTokuteijigyoushoKasan_HomonKaigo_umu() {
        return tokuteijigyoushoKasan_HomonKaigo_umu;
    }

    /**
     * setTokuteijigyoushoKasan_HomonKaigo_umu
     *
     * @param tokuteijigyoushoKasan_HomonKaigo_umu
     * tokuteijigyoushoKasan_HomonKaigo_umu
     */
    public void setTokuteijigyoushoKasan_HomonKaigo_umu(TokuteiJigyoshoKasanUmu tokuteijigyoushoKasan_HomonKaigo_umu) {
        this.tokuteijigyoushoKasan_HomonKaigo_umu = tokuteijigyoushoKasan_HomonKaigo_umu;
    }

    /**
     * getJakunenseiNinchishoCareTaisei_umu
     *
     * @return jakunenseiNinchishoCareTaisei_umu
     */
    public JakunenseiNinchishoCareTaiseiUmu getJakunenseiNinchishoCareTaisei_umu() {
        return jakunenseiNinchishoCareTaisei_umu;
    }

    /**
     * setJakunenseiNinchishoCareTaisei_umu
     *
     * @param jakunenseiNinchishoCareTaisei_umu
     * jakunenseiNinchishoCareTaisei_umu
     */
    public void setJakunenseiNinchishoCareTaisei_umu(JakunenseiNinchishoCareTaiseiUmu jakunenseiNinchishoCareTaisei_umu) {
        this.jakunenseiNinchishoCareTaisei_umu = jakunenseiNinchishoCareTaisei_umu;
    }

    /**
     * getUndokiKinoKojoTaisei_umu
     *
     * @return undokiKinoKojoTaisei_umu
     */
    public UndokiKinoKojoTaiseiUmu getUndokiKinoKojoTaisei_umu() {
        return undokiKinoKojoTaisei_umu;
    }

    /**
     * setUndokiKinoKojoTaisei_umu
     *
     * @param undokiKinoKojoTaisei_umu undokiKinoKojoTaisei_umu
     */
    public void setUndokiKinoKojoTaisei_umu(UndokiKinoKojoTaiseiUmu undokiKinoKojoTaisei_umu) {
        this.undokiKinoKojoTaisei_umu = undokiKinoKojoTaisei_umu;
    }

    /**
     * getEiyoManagement_KaizenTaisei_umu
     *
     * @return eiyoManagement_KaizenTaisei_umu
     */
    public EiyoManagementTaiseiUmu getEiyoManagement_KaizenTaisei_umu() {
        return eiyoManagement_KaizenTaisei_umu;
    }

    /**
     * setEiyoManagement_KaizenTaisei_umu
     *
     * @param eiyoManagement_KaizenTaisei_umu eiyoManagement_KaizenTaisei_umu
     */
    public void setEiyoManagement_KaizenTaisei_umu(EiyoManagementTaiseiUmu eiyoManagement_KaizenTaisei_umu) {
        this.eiyoManagement_KaizenTaisei_umu = eiyoManagement_KaizenTaisei_umu;
    }

    /**
     * getKokuKinoKojoTaisei_umu
     *
     * @return kokuKinoKojoTaisei_umu
     */
    public KokuKinoKojoTaiseiUmu getKokuKinoKojoTaisei_umu() {
        return kokuKinoKojoTaisei_umu;
    }

    /**
     * setKokuKinoKojoTaisei_umu
     *
     * @param kokuKinoKojoTaisei_umu kokuKinoKojoTaisei_umu
     */
    public void setKokuKinoKojoTaisei_umu(KokuKinoKojoTaiseiUmu kokuKinoKojoTaisei_umu) {
        this.kokuKinoKojoTaisei_umu = kokuKinoKojoTaisei_umu;
    }

    /**
     * getJigyoshoHyokaKasan_Moshide_umu
     *
     * @return jigyoshoHyokaKasan_Moshide_umu
     */
    public JigyoshoHyokaKasanMoshideUmu getJigyoshoHyokaKasan_Moshide_umu() {
        return jigyoshoHyokaKasan_Moshide_umu;
    }

    /**
     * setJigyoshoHyokaKasan_Moshide_umu
     *
     * @param jigyoshoHyokaKasan_Moshide_umu jigyoshoHyokaKasan_Moshide_umu
     */
    public void setJigyoshoHyokaKasan_Moshide_umu(JigyoshoHyokaKasanMoshideUmu jigyoshoHyokaKasan_Moshide_umu) {
        this.jigyoshoHyokaKasan_Moshide_umu = jigyoshoHyokaKasan_Moshide_umu;
    }

    /**
     * getJigyoshoHyokaKasan_Kettei_umu
     *
     * @return jigyoshoHyokaKasan_Kettei_umu
     */
    public JigyoshoHyokaKasanKetteiUmu getJigyoshoHyokaKasan_Kettei_umu() {
        return jigyoshoHyokaKasan_Kettei_umu;
    }

    /**
     * setJigyoshoHyokaKasan_Kettei_umu
     *
     * @param jigyoshoHyokaKasan_Kettei_umu jigyoshoHyokaKasan_Kettei_umu
     */
    public void setJigyoshoHyokaKasan_Kettei_umu(JigyoshoHyokaKasanKetteiUmu jigyoshoHyokaKasan_Kettei_umu) {
        this.jigyoshoHyokaKasan_Kettei_umu = jigyoshoHyokaKasan_Kettei_umu;
    }

    /**
     * getKinkyuUkeireTaisei_umu
     *
     * @return kinkyuUkeireTaisei_umu
     */
    public KinkyuUkeireTaiseiUmu getKinkyuUkeireTaisei_umu() {
        return kinkyuUkeireTaisei_umu;
    }

    /**
     * setKinkyuUkeireTaisei_umu
     *
     * @param kinkyuUkeireTaisei_umu kinkyuUkeireTaisei_umu
     */
    public void setKinkyuUkeireTaisei_umu(KinkyuUkeireTaiseiUmu kinkyuUkeireTaisei_umu) {
        this.kinkyuUkeireTaisei_umu = kinkyuUkeireTaisei_umu;
    }

    /**
     * getYakanKangoTaisei_umu
     *
     * @return yakanKangoTaisei_umu
     */
    public YakanKangoTaiseiUmu getYakanKangoTaisei_umu() {
        return yakanKangoTaisei_umu;
    }

    /**
     * setYakanKangoTaisei_umu
     *
     * @param yakanKangoTaisei_umu yakanKangoTaisei_umu
     */
    public void setYakanKangoTaisei_umu(YakanKangoTaiseiUmu yakanKangoTaisei_umu) {
        this.yakanKangoTaisei_umu = yakanKangoTaisei_umu;
    }

    /**
     * getTokuteijigyoshoKasan_Kyotakukaigoshien_umu
     *
     * @return tokuteijigyoshoKasan_Kyotakukaigoshien_umu
     */
    public Code getTokuteijigyoshoKasan_Kyotakukaigoshien_umu() {
        return tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
    }

    /**
     * setTokuteijigyoshoKasan_Kyotakukaigoshien_umu
     *
     * @param tokuteijigyoshoKasan_Kyotakukaigoshien_umu
     * tokuteijigyoshoKasan_Kyotakukaigoshien_umu
     */
    public void setTokuteijigyoshoKasan_Kyotakukaigoshien_umu(Code tokuteijigyoshoKasan_Kyotakukaigoshien_umu) {
        this.tokuteijigyoshoKasan_Kyotakukaigoshien_umu = tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
    }

    /**
     * getKaigoShienSemmoninSenjuJokinshaNinsu
     *
     * @return kaigoShienSemmoninSenjuJokinshaNinsu
     */
    public Decimal getKaigoShienSemmoninSenjuJokinshaNinsu() {
        return kaigoShienSemmoninSenjuJokinshaNinsu;
    }

    /**
     * setKaigoShienSemmoninSenjuJokinshaNinsu
     *
     * @param kaigoShienSemmoninSenjuJokinshaNinsu
     * kaigoShienSemmoninSenjuJokinshaNinsu
     */
    public void setKaigoShienSemmoninSenjuJokinshaNinsu(Decimal kaigoShienSemmoninSenjuJokinshaNinsu) {
        this.kaigoShienSemmoninSenjuJokinshaNinsu = kaigoShienSemmoninSenjuJokinshaNinsu;
    }

    /**
     * getKaigoSienSemmoninSenjuHijokinshaNinsu
     *
     * @return kaigoSienSemmoninSenjuHijokinshaNinsu
     */
    public Decimal getKaigoSienSemmoninSenjuHijokinshaNinsu() {
        return kaigoSienSemmoninSenjuHijokinshaNinsu;
    }

    /**
     * setKaigoSienSemmoninSenjuHijokinshaNinsu
     *
     * @param kaigoSienSemmoninSenjuHijokinshaNinsu
     * kaigoSienSemmoninSenjuHijokinshaNinsu
     */
    public void setKaigoSienSemmoninSenjuHijokinshaNinsu(Decimal kaigoSienSemmoninSenjuHijokinshaNinsu) {
        this.kaigoSienSemmoninSenjuHijokinshaNinsu = kaigoSienSemmoninSenjuHijokinshaNinsu;
    }

    /**
     * getKaigoSienSemmoninKemmuJokinshaNinsu
     *
     * @return kaigoSienSemmoninKemmuJokinshaNinsu
     */
    public Decimal getKaigoSienSemmoninKemmuJokinshaNinsu() {
        return kaigoSienSemmoninKemmuJokinshaNinsu;
    }

    /**
     * setKaigoSienSemmoninKemmuJokinshaNinsu
     *
     * @param kaigoSienSemmoninKemmuJokinshaNinsu
     * kaigoSienSemmoninKemmuJokinshaNinsu
     */
    public void setKaigoSienSemmoninKemmuJokinshaNinsu(Decimal kaigoSienSemmoninKemmuJokinshaNinsu) {
        this.kaigoSienSemmoninKemmuJokinshaNinsu = kaigoSienSemmoninKemmuJokinshaNinsu;
    }

    /**
     * getKaigoSienSemmoninKemmuHijokinshaNinsu
     *
     * @return kaigoSienSemmoninKemmuHijokinshaNinsu
     */
    public Decimal getKaigoSienSemmoninKemmuHijokinshaNinsu() {
        return kaigoSienSemmoninKemmuHijokinshaNinsu;
    }

    /**
     * setKaigoSienSemmoninKemmuHijokinshaNinsu
     *
     * @param kaigoSienSemmoninKemmuHijokinshaNinsu
     * kaigoSienSemmoninKemmuHijokinshaNinsu
     */
    public void setKaigoSienSemmoninKemmuHijokinshaNinsu(Decimal kaigoSienSemmoninKemmuHijokinshaNinsu) {
        this.kaigoSienSemmoninKemmuHijokinshaNinsu = kaigoSienSemmoninKemmuHijokinshaNinsu;
    }

    /**
     * getHomonkaigoServiceTeikyoSekininshaNinsu
     *
     * @return homonkaigoServiceTeikyoSekininshaNinsu
     */
    public Decimal getHomonkaigoServiceTeikyoSekininshaNinsu() {
        return homonkaigoServiceTeikyoSekininshaNinsu;
    }

    /**
     * setHomonkaigoServiceTeikyoSekininshaNinsu
     *
     * @param homonkaigoServiceTeikyoSekininshaNinsu
     * homonkaigoServiceTeikyoSekininshaNinsu
     */
    public void setHomonkaigoServiceTeikyoSekininshaNinsu(Decimal homonkaigoServiceTeikyoSekininshaNinsu) {
        this.homonkaigoServiceTeikyoSekininshaNinsu = homonkaigoServiceTeikyoSekininshaNinsu;
    }

    /**
     * getHomonkaigoSenjuJokinshaNinsu
     *
     * @return homonkaigoSenjuJokinshaNinsu
     */
    public Decimal getHomonkaigoSenjuJokinshaNinsu() {
        return homonkaigoSenjuJokinshaNinsu;
    }

    /**
     * setHomonkaigoSenjuJokinshaNinsu
     *
     * @param homonkaigoSenjuJokinshaNinsu homonkaigoSenjuJokinshaNinsu
     */
    public void setHomonkaigoSenjuJokinshaNinsu(Decimal homonkaigoSenjuJokinshaNinsu) {
        this.homonkaigoSenjuJokinshaNinsu = homonkaigoSenjuJokinshaNinsu;
    }

    /**
     * getHomonkaigoSenjuHijokinshaNinsu
     *
     * @return homonkaigoSenjuHijokinshaNinsu
     */
    public Decimal getHomonkaigoSenjuHijokinshaNinsu() {
        return homonkaigoSenjuHijokinshaNinsu;
    }

    /**
     * setHomonkaigoSenjuHijokinshaNinsu
     *
     * @param homonkaigoSenjuHijokinshaNinsu homonkaigoSenjuHijokinshaNinsu
     */
    public void setHomonkaigoSenjuHijokinshaNinsu(Decimal homonkaigoSenjuHijokinshaNinsu) {
        this.homonkaigoSenjuHijokinshaNinsu = homonkaigoSenjuHijokinshaNinsu;
    }

    /**
     * getHomonkaigoKemmuJokinshaNinsu
     *
     * @return homonkaigoKemmuJokinshaNinsu
     */
    public Decimal getHomonkaigoKemmuJokinshaNinsu() {
        return homonkaigoKemmuJokinshaNinsu;
    }

    /**
     * setHomonkaigoKemmuJokinshaNinsu
     *
     * @param homonkaigoKemmuJokinshaNinsu homonkaigoKemmuJokinshaNinsu
     */
    public void setHomonkaigoKemmuJokinshaNinsu(Decimal homonkaigoKemmuJokinshaNinsu) {
        this.homonkaigoKemmuJokinshaNinsu = homonkaigoKemmuJokinshaNinsu;
    }

    /**
     * getHomonkaigoKemmuHijokinshaNinsu
     *
     * @return homonkaigoKemmuHijokinshaNinsu
     */
    public Decimal getHomonkaigoKemmuHijokinshaNinsu() {
        return homonkaigoKemmuHijokinshaNinsu;
    }

    /**
     * setHomonkaigoKemmuHijokinshaNinsu
     *
     * @param homonkaigoKemmuHijokinshaNinsu homonkaigoKemmuHijokinshaNinsu
     */
    public void setHomonkaigoKemmuHijokinshaNinsu(Decimal homonkaigoKemmuHijokinshaNinsu) {
        this.homonkaigoKemmuHijokinshaNinsu = homonkaigoKemmuHijokinshaNinsu;
    }

    /**
     * getHomonkaigoJokinKanzangoNinsu
     *
     * @return homonkaigoJokinKanzangoNinsu
     */
    public Decimal getHomonkaigoJokinKanzangoNinsu() {
        return homonkaigoJokinKanzangoNinsu;
    }

    /**
     * setHomonkaigoJokinKanzangoNinsu
     *
     * @param homonkaigoJokinKanzangoNinsu homonkaigoJokinKanzangoNinsu
     */
    public void setHomonkaigoJokinKanzangoNinsu(Decimal homonkaigoJokinKanzangoNinsu) {
        this.homonkaigoJokinKanzangoNinsu = homonkaigoJokinKanzangoNinsu;
    }

    /**
     * getRiyoTeiinNinsu
     *
     * @return riyoTeiinNinsu
     */
    public Decimal getRiyoTeiinNinsu() {
        return riyoTeiinNinsu;
    }

    /**
     * setRiyoTeiinNinsu
     *
     * @param riyoTeiinNinsu riyoTeiinNinsu
     */
    public void setRiyoTeiinNinsu(Decimal riyoTeiinNinsu) {
        this.riyoTeiinNinsu = riyoTeiinNinsu;
    }

    /**
     * getShiteiYukoKaishiYMD
     *
     * @return shiteiYukoKaishiYMD
     */
    public FlexibleDate getShiteiYukoKaishiYMD() {
        return shiteiYukoKaishiYMD;
    }

    /**
     * setShiteiYukoKaishiYMD
     *
     * @param shiteiYukoKaishiYMD shiteiYukoKaishiYMD
     */
    public void setShiteiYukoKaishiYMD(FlexibleDate shiteiYukoKaishiYMD) {
        this.shiteiYukoKaishiYMD = shiteiYukoKaishiYMD;
    }

    /**
     * getShiteiYukoShuryoYMD
     *
     * @return shiteiYukoShuryoYMD
     */
    public FlexibleDate getShiteiYukoShuryoYMD() {
        return shiteiYukoShuryoYMD;
    }

    /**
     * setShiteiYukoShuryoYMD
     *
     * @param shiteiYukoShuryoYMD shiteiYukoShuryoYMD
     */
    public void setShiteiYukoShuryoYMD(FlexibleDate shiteiYukoShuryoYMD) {
        this.shiteiYukoShuryoYMD = shiteiYukoShuryoYMD;
    }

    /**
     * getShiteiKoshinShinseichuKubun
     *
     * @return shiteiKoshinShinseichuKubun
     */
    public ShiteiKoshinShinseichuKubun getShiteiKoshinShinseichuKubun() {
        return shiteiKoshinShinseichuKubun;
    }

    /**
     * setShiteiKoshinShinseichuKubun
     *
     * @param shiteiKoshinShinseichuKubun shiteiKoshinShinseichuKubun
     */
    public void setShiteiKoshinShinseichuKubun(ShiteiKoshinShinseichuKubun shiteiKoshinShinseichuKubun) {
        this.shiteiKoshinShinseichuKubun = shiteiKoshinShinseichuKubun;
    }

    /**
     * getKoryokuTeishiKaishiYMD
     *
     * @return koryokuTeishiKaishiYMD
     */
    public FlexibleDate getKoryokuTeishiKaishiYMD() {
        return koryokuTeishiKaishiYMD;
    }

    /**
     * setKoryokuTeishiKaishiYMD
     *
     * @param koryokuTeishiKaishiYMD koryokuTeishiKaishiYMD
     */
    public void setKoryokuTeishiKaishiYMD(FlexibleDate koryokuTeishiKaishiYMD) {
        this.koryokuTeishiKaishiYMD = koryokuTeishiKaishiYMD;
    }

    /**
     * getKoryokuTeishiShuryoYMD
     *
     * @return koryokuTeishiShuryoYMD
     */
    public FlexibleDate getKoryokuTeishiShuryoYMD() {
        return koryokuTeishiShuryoYMD;
    }

    /**
     * setKoryokuTeishiShuryoYMD
     *
     * @param koryokuTeishiShuryoYMD koryokuTeishiShuryoYMD
     */
    public void setKoryokuTeishiShuryoYMD(FlexibleDate koryokuTeishiShuryoYMD) {
        this.koryokuTeishiShuryoYMD = koryokuTeishiShuryoYMD;
    }

    /**
     * getDaikiboJigyoshaGaito_umu
     *
     * @return daikiboJigyoshaGaito_umu
     */
    public DaikiboJigyoshoGaitoUmu getDaikiboJigyoshaGaito_umu() {
        return daikiboJigyoshaGaito_umu;
    }

    /**
     * setDaikiboJigyoshaGaito_umu
     *
     * @param daikiboJigyoshaGaito_umu daikiboJigyoshaGaito_umu
     */
    public void setDaikiboJigyoshaGaito_umu(DaikiboJigyoshoGaitoUmu daikiboJigyoshaGaito_umu) {
        this.daikiboJigyoshaGaito_umu = daikiboJigyoshaGaito_umu;
    }

    /**
     * getJunUnitCareTaisei_umu
     *
     * @return junUnitCareTaisei_umu
     */
    public JunUnitCareTaiseiUmu getJunUnitCareTaisei_umu() {
        return junUnitCareTaisei_umu;
    }

    /**
     * setJunUnitCareTaisei_umu
     *
     * @param junUnitCareTaisei_umu junUnitCareTaisei_umu
     */
    public void setJunUnitCareTaisei_umu(JunUnitCareTaiseiUmu junUnitCareTaisei_umu) {
        this.junUnitCareTaisei_umu = junUnitCareTaisei_umu;
    }

    /**
     * getJudokaTaioTaisei_umu
     *
     * @return judokaTaioTaisei_umu
     */
    public JudokaTaioTaiseiUmu getJudokaTaioTaisei_umu() {
        return judokaTaioTaisei_umu;
    }

    /**
     * setJudokaTaioTaisei_umu
     *
     * @param judokaTaioTaisei_umu judokaTaioTaisei_umu
     */
    public void setJudokaTaioTaisei_umu(JudokaTaioTaiseiUmu judokaTaioTaisei_umu) {
        this.judokaTaioTaisei_umu = judokaTaioTaisei_umu;
    }

    /**
     * getIryoRenkeiTaisei_umu
     *
     * @return iryoRenkeiTaisei_umu
     */
    public IryoRenkeiTaiseiUmu getIryoRenkeiTaisei_umu() {
        return iryoRenkeiTaisei_umu;
    }

    /**
     * setIryoRenkeiTaisei_umu
     *
     * @param iryoRenkeiTaisei_umu iryoRenkeiTaisei_umu
     */
    public void setIryoRenkeiTaisei_umu(IryoRenkeiTaiseiUmu iryoRenkeiTaisei_umu) {
        this.iryoRenkeiTaisei_umu = iryoRenkeiTaisei_umu;
    }

    /**
     * getUnitCareTaisei_umu
     *
     * @return unitCareTaisei_umu
     */
    public UnitCareTaiseiUmu getUnitCareTaisei_umu() {
        return unitCareTaisei_umu;
    }

    /**
     * setUnitCareTaisei_umu
     *
     * @param unitCareTaisei_umu unitCareTaisei_umu
     */
    public void setUnitCareTaisei_umu(UnitCareTaiseiUmu unitCareTaisei_umu) {
        this.unitCareTaisei_umu = unitCareTaisei_umu;
    }

    /**
     * getZaitaku_nyushoSogoRiyoTaisei_umu
     *
     * @return zaitaku_nyushoSogoRiyoTaisei_umu
     */
    public JutakuNyushoSogoriyoTaiseiUmu getZaitaku_nyushoSogoRiyoTaisei_umu() {
        return zaitaku_nyushoSogoRiyoTaisei_umu;
    }

    /**
     * setZaitaku_nyushoSogoRiyoTaisei_umu
     *
     * @param zaitaku_nyushoSogoRiyoTaisei_umu zaitaku_nyushoSogoRiyoTaisei_umu
     */
    public void setZaitaku_nyushoSogoRiyoTaisei_umu(JutakuNyushoSogoriyoTaiseiUmu zaitaku_nyushoSogoRiyoTaisei_umu) {
        this.zaitaku_nyushoSogoRiyoTaisei_umu = zaitaku_nyushoSogoRiyoTaisei_umu;
    }

    /**
     * getTerminalCareTaisei_umu
     *
     * @return terminalCareTaisei_umu
     */
    public TerminalCareTaiseiUmu getTerminalCareTaisei_umu() {
        return terminalCareTaisei_umu;
    }

    /**
     * setTerminalCareTaisei_umu
     *
     * @param terminalCareTaisei_umu terminalCareTaisei_umu
     */
    public void setTerminalCareTaisei_umu(TerminalCareTaiseiUmu terminalCareTaisei_umu) {
        this.terminalCareTaisei_umu = terminalCareTaisei_umu;
    }

    /**
     * getShintaiDecimalaiKosokuHaishiTorikumi_umu
     *
     * @return shintaiKosokuHaishiTorikumi_umu
     */
    public ShintaikosokuHaishiTorikumiUmu getShintaiKosokuHaishiTorikumi_umu() {
        return shintaiKosokuHaishiTorikumi_umu;
    }

    /**
     * setShintaiDecimalaiKosokuHaishiTorikumi_umu
     *
     * @param shintaiKosokuHaishiTorikumi_umu shintaiKosokuHaishiTorikumi_umu
     */
    public void setShintaiKosokuHaishiTorikumi_umu(ShintaikosokuHaishiTorikumiUmu shintaiKosokuHaishiTorikumi_umu) {
        this.shintaiKosokuHaishiTorikumi_umu = shintaiKosokuHaishiTorikumi_umu;
    }

    /**
     * getShokiboKyotenShugoTaisei_umu
     *
     * @return shokiboKyotenShugoTaisei_umu
     */
    public ShokiboKyotenShugoTaiseiUmu getShokiboKyotenShugoTaisei_umu() {
        return shokiboKyotenShugoTaisei_umu;
    }

    /**
     * setShokiboKyotenShugoTaisei_umu
     *
     * @param shokiboKyotenShugoTaisei_umu shokiboKyotenShugoTaisei_umu
     */
    public void setShokiboKyotenShugoTaisei_umu(ShokiboKyotenShugoTaiseiUmu shokiboKyotenShugoTaisei_umu) {
        this.shokiboKyotenShugoTaisei_umu = shokiboKyotenShugoTaisei_umu;
    }

    /**
     * getNinchishoCareKasan_umu
     *
     * @return ninchishoCareKasan_umu
     */
    public NinchishoCareKasanUmu getNinchishoCareKasan_umu() {
        return ninchishoCareKasan_umu;
    }

    /**
     * setNinchishoCareKasan_umu
     *
     * @param ninchishoCareKasan_umu ninchishoCareKasan_umu
     */
    public void setNinchishoCareKasan_umu(NinchishoCareKasanUmu ninchishoCareKasan_umu) {
        this.ninchishoCareKasan_umu = ninchishoCareKasan_umu;
    }

    /**
     * getKobetsuKinoKunrenTaisei_umu
     *
     * @return kobetsuKinoKunrenTaisei_umu
     */
    public Code getKobetsuKinoKunrenTaisei_umu() {
        return kobetsuKinoKunrenTaisei_umu;
    }

    /**
     * setKobetsuKinoKunrenTaisei_umu
     *
     * @param kobetsuKinoKunrenTaisei_umu kobetsuKinoKunrenTaisei_umu
     */
    public void setKobetsuKinoKunrenTaisei_umu(Code kobetsuKinoKunrenTaisei_umu) {
        this.kobetsuKinoKunrenTaisei_umu = kobetsuKinoKunrenTaisei_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu
     *
     * @return kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1 getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu
     * kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1 kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu = kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
     *
     * @return kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3 getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
     * kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3 kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2 = kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu
     *
     * @return kobetsuRehaTeikyoTaisei_SagyoRyoho_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu() {
        return kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu
     *
     * @param kobetsuRehaTeikyoTaisei_SagyoRyoho_umu
     * kobetsuRehaTeikyoTaisei_SagyoRyoho_umu
     */
    public void setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho kobetsuRehaTeikyoTaisei_SagyoRyoho_umu) {
        this.kobetsuRehaTeikyoTaisei_SagyoRyoho_umu = kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
     *
     * @return kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu() {
        return kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
     *
     * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
     * kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
     */
    public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu) {
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu = kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_Sonota_umu
     *
     * @return kobetsuRehaTeikyoTaisei_Sonota_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_Sonota getKobetsuRehaTeikyoTaisei_Sonota_umu() {
        return kobetsuRehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_Sonota_umu
     *
     * @param kobetsuRehaTeikyoTaisei_Sonota_umu
     * kobetsuRehaTeikyoTaisei_Sonota_umu
     */
    public void setKobetsuRehaTeikyoTaisei_Sonota_umu(KobetsuRehabilitationTeikyoTaiseiUmu_Sonota kobetsuRehaTeikyoTaisei_Sonota_umu) {
        this.kobetsuRehaTeikyoTaisei_Sonota_umu = kobetsuRehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * getSetsubiKijun
     *
     * @return setsubiKijun
     */
    public SetsubiKijun getSetsubiKijun() {
        return setsubiKijun;
    }

    /**
     * setSetsubiKijun
     *
     * @param setsubiKijun setsubiKijun
     */
    public void setSetsubiKijun(SetsubiKijun setsubiKijun) {
        this.setsubiKijun = setsubiKijun;
    }

    /**
     * getRyoyoTaiseiIjiTokubetsuKasan
     *
     * @return ryoyoTaiseiIjiTokubetsuKasan
     */
    public RyoyoTaiseiIjiTokubetsuKasan getRyoyoTaiseiIjiTokubetsuKasan() {
        return ryoyoTaiseiIjiTokubetsuKasan;
    }

    /**
     * setRyoyoTaiseiIjiTokubetsuKasan
     *
     * @param ryoyoTaiseiIjiTokubetsuKasan ryoyoTaiseiIjiTokubetsuKasan
     */
    public void setRyoyoTaiseiIjiTokubetsuKasan(RyoyoTaiseiIjiTokubetsuKasan ryoyoTaiseiIjiTokubetsuKasan) {
        this.ryoyoTaiseiIjiTokubetsuKasan = ryoyoTaiseiIjiTokubetsuKasan;
    }

    /**
     * getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
     *
     * @return kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu() {
        return kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
    }

    /**
     * setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
     *
     * @param kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
     * kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
     */
    public void setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(KobetsuRehabilitationTeikyoTaiseiUmu kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu) {
        this.kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu = kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
    }

    /**
     * getSankyuHelperTaisei
     *
     * @return sankyuHelperTaisei
     */
    public ThirdGradeHelperTaisei getSankyuHelperTaisei() {
        return sankyuHelperTaisei;
    }

    /**
     * setSankyuHelperTaisei
     *
     * @param sankyuHelperTaisei sankyuHelperTaisei
     */
    public void setSankyuHelperTaisei(ThirdGradeHelperTaisei sankyuHelperTaisei) {
        this.sankyuHelperTaisei = sankyuHelperTaisei;
    }

    /**
     * getChuSankanChiikiShokiboJigyoshoKasan_chiiki
     *
     * @return chuSankanChiikiShokiboJigyoshoKasan_chiiki
     */
    public ShokiboJigyoshoKasanInMountainArea_SituationAboutArea getChuSankanChiikiShokiboJigyoshoKasan_chiiki() {
        return chuSankanChiikiShokiboJigyoshoKasan_chiiki;
    }

    /**
     * setChuSankanChiikiShokiboJigyoshoKasan_chiiki
     *
     * @param chuSankanChiikiShokiboJigyoshoKasan_chiiki
     * chuSankanChiikiShokiboJigyoshoKasan_chiiki
     */
    public void setChuSankanChiikiShokiboJigyoshoKasan_chiiki(ShokiboJigyoshoKasanInMountainArea_SituationAboutArea chuSankanChiikiShokiboJigyoshoKasan_chiiki) {
        this.chuSankanChiikiShokiboJigyoshoKasan_chiiki = chuSankanChiikiShokiboJigyoshoKasan_chiiki;
    }

    /**
     * getChuSankanChiikiShokiboJigyoushoKasan_kibo
     *
     * @return chuSankanChiikiShokiboJigyoushoKasan_kibo
     */
    public ShokiboJigyoshoKasanInMountainArea_SituationAboutScale getChuSankanChiikiShokiboJigyoushoKasan_kibo() {
        return chuSankanChiikiShokiboJigyoushoKasan_kibo;
    }

    /**
     * setChuSankanChiikiShokiboJigyoushoKasan_kibo
     *
     * @param chuSankanChiikiShokiboJigyoushoKasan_kibo
     * chuSankanChiikiShokiboJigyoushoKasan_kibo
     */
    public void setChuSankanChiikiShokiboJigyoushoKasan_kibo(ShokiboJigyoshoKasanInMountainArea_SituationAboutScale chuSankanChiikiShokiboJigyoushoKasan_kibo) {
        this.chuSankanChiikiShokiboJigyoushoKasan_kibo = chuSankanChiikiShokiboJigyoushoKasan_kibo;
    }

    /**
     * getServiceTeikyoTaiseiKyokaKasan
     *
     * @return serviceTeikyoTaiseiKyokaKasan
     */
    public Code getServiceTeikyoTaiseiKyokaKasan() {
        return serviceTeikyoTaiseiKyokaKasan;
    }

    /**
     * setServiceTeikyoTaiseiKyokaKasan
     *
     * @param serviceTeikyoTaiseiKyokaKasan serviceTeikyoTaiseiKyokaKasan
     */
    public void setServiceTeikyoTaiseiKyokaKasan(Code serviceTeikyoTaiseiKyokaKasan) {
        this.serviceTeikyoTaiseiKyokaKasan = serviceTeikyoTaiseiKyokaKasan;
    }

    /**
     * getNinchishoTankiShuchuRehabilitationKasan
     *
     * @return ninchishoTankiShuchuRehabilitationKasan
     */
    public NinchishoTankiShuchuRehabilitationKasan getNinchishoTankiShuchuRehabilitationKasan() {
        return ninchishoTankiShuchuRehabilitationKasan;
    }

    /**
     * setNinchishoTankiShuchuRehabilitationKasan
     *
     * @param ninchishoTankiShuchuRehabilitationKasan
     * ninchishoTankiShuchuRehabilitationKasan
     */
    public void setNinchishoTankiShuchuRehabilitationKasan(NinchishoTankiShuchuRehabilitationKasan ninchishoTankiShuchuRehabilitationKasan) {
        this.ninchishoTankiShuchuRehabilitationKasan = ninchishoTankiShuchuRehabilitationKasan;
    }

    /**
     * getJakunenseiNinchishoRiyoushaUkeeireKasan
     *
     * @return jakunenseiNinchishoRiyoushaUkeeireKasan
     */
    public JakunenseiNinchishoRiyoshaUkeireKasan getJakunenseiNinchishoRiyoushaUkeeireKasan() {
        return jakunenseiNinchishoRiyoushaUkeeireKasan;
    }

    /**
     * setJakunenseiNinchishoRiyoushaUkeeireKasan
     *
     * @param jakunenseiNinchishoRiyoushaUkeeireKasan
     * jakunenseiNinchishoRiyoushaUkeeireKasan
     */
    public void setJakunenseiNinchishoRiyoushaUkeeireKasan(JakunenseiNinchishoRiyoshaUkeireKasan jakunenseiNinchishoRiyoushaUkeeireKasan) {
        this.jakunenseiNinchishoRiyoushaUkeeireKasan = jakunenseiNinchishoRiyoushaUkeeireKasan;
    }

    /**
     * getKangoTaiseiKasan
     *
     * @return kangoTaiseiKasan
     */
    public KangoTaiseiKasan getKangoTaiseiKasan() {
        return kangoTaiseiKasan;
    }

    /**
     * setKangoTaiseiKasan
     *
     * @param kangoTaiseiKasan kangoTaiseiKasan
     */
    public void setKangoTaiseiKasan(KangoTaiseiKasan kangoTaiseiKasan) {
        this.kangoTaiseiKasan = kangoTaiseiKasan;
    }

    /**
     * getYakinShokuinHaichiKasan
     *
     * @return yakinShokuinHaichiKasan
     */
    public YakinStaffHaichiKasan getYakinShokuinHaichiKasan() {
        return yakinShokuinHaichiKasan;
    }

    /**
     * setYakinShokuinHaichiKasan
     *
     * @param yakinShokuinHaichiKasan yakinShokuinHaichiKasan
     */
    public void setYakinShokuinHaichiKasan(YakinStaffHaichiKasan yakinShokuinHaichiKasan) {
        this.yakinShokuinHaichiKasan = yakinShokuinHaichiKasan;
    }

    /**
     * getRyoyoShokuKasan
     *
     * @return ryoyoShokuKasan
     */
    public RyoyoshokuKasan getRyoyoShokuKasan() {
        return ryoyoShokuKasan;
    }

    /**
     * setRyoyoShokuKasan
     *
     * @param ryoyoShokuKasan ryoyoShokuKasan
     */
    public void setRyoyoShokuKasan(RyoyoshokuKasan ryoyoShokuKasan) {
        this.ryoyoShokuKasan = ryoyoShokuKasan;
    }

    /**
     * getNichijoSeikatsuKeizokuShienKasan
     *
     * @return nichijoSeikatsuKeizokuShienKasan
     */
    public NichijoSeikatsuKeizokuSupprtKasan getNichijoSeikatsuKeizokuShienKasan() {
        return nichijoSeikatsuKeizokuShienKasan;
    }

    /**
     * setNichijoSeikatsuKeizokuShienKasan
     *
     * @param nichijoSeikatsuKeizokuShienKasan nichijoSeikatsuKeizokuShienKasan
     */
    public void setNichijoSeikatsuKeizokuShienKasan(NichijoSeikatsuKeizokuSupprtKasan nichijoSeikatsuKeizokuShienKasan) {
        this.nichijoSeikatsuKeizokuShienKasan = nichijoSeikatsuKeizokuShienKasan;
    }

    /**
     * getNinchishoSemmonCareKasan
     *
     * @return ninchishoSemmonCareKasan
     */
    public NinchishoSemmonCareKasan getNinchishoSemmonCareKasan() {
        return ninchishoSemmonCareKasan;
    }

    /**
     * setNinchishoSemmonCareKasan
     *
     * @param ninchishoSemmonCareKasan ninchishoSemmonCareKasan
     */
    public void setNinchishoSemmonCareKasan(NinchishoSemmonCareKasan ninchishoSemmonCareKasan) {
        this.ninchishoSemmonCareKasan = ninchishoSemmonCareKasan;
    }

    /**
     * gettwentyFourHoursTsuhoTaioKasan
     *
     * @return twentyFourHoursTsuhoTaioKasan
     */
    public TsuhoTaioFor24HoursKasan getTwentyFourHoursTsuhoTaioKasan() {
        return twentyFourHoursTsuhoTaioKasan;
    }

    /**
     * settwentyFourHoursTsuhoTaioKasan
     *
     * @param twentyFourHoursTsuhoTaioKasan twentyFourHoursTsuhoTaioKasan
     */
    public void setTwentyFourHoursTsuhoTaioKasan(TsuhoTaioFor24HoursKasan twentyFourHoursTsuhoTaioKasan) {
        this.twentyFourHoursTsuhoTaioKasan = twentyFourHoursTsuhoTaioKasan;
    }

    /**
     * getKangoShokuinHaichiKasan
     *
     * @return kangoShokuinHaichiKasan
     */
    public KangoStaffHaichiKasan getKangoShokuinHaichiKasan() {
        return kangoShokuinHaichiKasan;
    }

    /**
     * setKangoShokuinHaichiKasan
     *
     * @param kangoShokuinHaichiKasan kangoShokuinHaichiKasan
     */
    public void setKangoShokuinHaichiKasan(KangoStaffHaichiKasan kangoShokuinHaichiKasan) {
        this.kangoShokuinHaichiKasan = kangoShokuinHaichiKasan;
    }

    /**
     * getYakanCareKasan
     *
     * @return yakanCareKasan
     */
    public YakanCareKasan getYakanCareKasan() {
        return yakanCareKasan;
    }

    /**
     * setYakanCareKasan
     *
     * @param yakanCareKasan yakanCareKasan
     */
    public void setYakanCareKasan(YakanCareKasan yakanCareKasan) {
        this.yakanCareKasan = yakanCareKasan;
    }

    /**
     * getShudanCommunicationRyoho_umu
     *
     * @return shudanCommunicationRyoho_umu
     */
    public ShudanCommunicationRyohoUmu getShudanCommunicationRyoho_umu() {
        return shudanCommunicationRyoho_umu;
    }

    /**
     * setShudanCommunicationRyoho_umu
     *
     * @param shudanCommunicationRyoho_umu shudanCommunicationRyoho_umu
     */
    public void setShudanCommunicationRyoho_umu(ShudanCommunicationRyohoUmu shudanCommunicationRyoho_umu) {
        this.shudanCommunicationRyoho_umu = shudanCommunicationRyoho_umu;
    }

    /**
     * getServiceTeikyoTaiseiKyokaKasan_Karadokogata
     *
     * @return serviceTeikyoTaiseiKyokaKasan_Karadokogata
     */
    public ServiceTeikyoTaiseiKyokaKasanForKushoType getServiceTeikyoTaiseiKyokaKasan_Karadokogata() {
        return serviceTeikyoTaiseiKyokaKasan_Karadokogata;
    }

    /**
     * setServiceTeikyoTaiseiKyokaKasan_Karadokogata
     *
     * @param serviceTeikyoTaiseiKyokaKasan_Karadokogata
     * serviceTeikyoTaiseiKyokaKasan_Karadokogata
     */
    public void setServiceTeikyoTaiseiKyokaKasan_Karadokogata(ServiceTeikyoTaiseiKyokaKasanForKushoType serviceTeikyoTaiseiKyokaKasan_Karadokogata) {
        this.serviceTeikyoTaiseiKyokaKasan_Karadokogata = serviceTeikyoTaiseiKyokaKasan_Karadokogata;
    }

    /**
     * getNitchuShDecimalaikaigoTaise_20funmiman_umu
     *
     * @return nitchuShDecimalaikaigoTaise_20funmiman_umu
     */
    public ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu getNitchuShintaikaigoTaise_20funmiman_umu() {
        return nitchuShDecimalaikaigoTaise_20funmiman_umu;
    }

    /**
     * setNitchuShDecimalaikaigoTaise_20funmiman_umu
     *
     * @param nitchuShDecimalaikaigoTaise_20funmiman_umu
     * nitchuShDecimalaikaigoTaise_20funmiman_umu
     */
    public void setNitchuShintaikaigoTaise_20funmiman_umu(ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu nitchuShDecimalaikaigoTaise_20funmiman_umu) {
        this.nitchuShDecimalaikaigoTaise_20funmiman_umu = nitchuShDecimalaikaigoTaise_20funmiman_umu;
    }

    /**
     * getServiceTeikyoSekininshaTaisei_umu
     *
     * @return serviceTeikyoSekininshaTaisei_umu
     */
    public ServiceTeikyoSekininshaTaiseiUmu getServiceTeikyoSekininshaTaisei_umu() {
        return serviceTeikyoSekininshaTaisei_umu;
    }

    /**
     * setServiceTeikyoSekininshaTaisei_umu
     *
     * @param serviceTeikyoSekininshaTaisei_umu
     * serviceTeikyoSekininshaTaisei_umu
     */
    public void setServiceTeikyoSekininshaTaisei_umu(ServiceTeikyoSekininshaTaiseiUmu serviceTeikyoSekininshaTaisei_umu) {
        this.serviceTeikyoSekininshaTaisei_umu = serviceTeikyoSekininshaTaisei_umu;
    }

    /**
     * getDoitsuTatemonoKyojuRiyoshaGenzan_umu
     *
     * @return doitsuTatemonoKyojuRiyoshaGenzan_umu
     */
    public DoitsuTatemonoKyojuUserGenzanUmu getDoitsuTatemonoKyojuRiyoshaGenzan_umu() {
        return doitsuTatemonoKyojuRiyoshaGenzan_umu;
    }

    /**
     * setDoitsuTatemonoKyojuRiyoshaGenzan_umu
     *
     * @param doitsuTatemonoKyojuRiyoshaGenzan_umu
     * doitsuTatemonoKyojuRiyoshaGenzan_umu
     */
    public void setDoitsuTatemonoKyojuRiyoshaGenzan_umu(DoitsuTatemonoKyojuUserGenzanUmu doitsuTatemonoKyojuRiyoshaGenzan_umu) {
        this.doitsuTatemonoKyojuRiyoshaGenzan_umu = doitsuTatemonoKyojuRiyoshaGenzan_umu;
    }

    /**
     * getKinkyuTankiNyushoTaiseiKakuhoKasan
     *
     * @return kinkyuTankiNyushoTaiseiKakuhoKasan
     */
    public KinkyuTankinyushoTaiseiKakuhoKasan getKinkyuTankiNyushoTaiseiKakuhoKasan() {
        return kinkyuTankiNyushoTaiseiKakuhoKasan;
    }

    /**
     * setKinkyuTankiNyushoTaiseiKakuhoKasan
     *
     * @param kinkyuTankiNyushoTaiseiKakuhoKasan
     * kinkyuTankiNyushoTaiseiKakuhoKasan
     */
    public void setKinkyuTankiNyushoTaiseiKakuhoKasan(KinkyuTankinyushoTaiseiKakuhoKasan kinkyuTankiNyushoTaiseiKakuhoKasan) {
        this.kinkyuTankiNyushoTaiseiKakuhoKasan = kinkyuTankiNyushoTaiseiKakuhoKasan;
    }

    /**
     * getZaitakuFukki_ZaitakuRyoyoShienKinoKasan
     *
     * @return zaitakuFukki_ZaitakuRyoyoShienKinoKasan
     */
    public ZaitakuFukkiZaitakuRyoyoSupportKinoKasan getZaitakuFukki_ZaitakuRyoyoShienKinoKasan() {
        return zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
    }

    /**
     * setZaitakuFukki_ZaitakuRyoyoShienKinoKasan
     *
     * @param zaitakuFukki_ZaitakuRyoyoShienKinoKasan
     * zaitakuFukki_ZaitakuRyoyoShienKinoKasan
     */
    public void setZaitakuFukki_ZaitakuRyoyoShienKinoKasan(ZaitakuFukkiZaitakuRyoyoSupportKinoKasan zaitakuFukki_ZaitakuRyoyoShienKinoKasan) {
        this.zaitakuFukki_ZaitakuRyoyoShienKinoKasan = zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
    }

    /**
     * getSeikatuKinoKojoGroupKatsudoKasan
     *
     * @return seikatuKinoKojoGroupKatsudoKasan
     */
    public SeikatsuKinoKojoGroupKatsudoKasan getSeikatuKinoKojoGroupKatsudoKasan() {
        return seikatuKinoKojoGroupKatsudoKasan;
    }

    /**
     * setSeikatuKinoKojoGroupKatsudoKasan
     *
     * @param seikatuKinoKojoGroupKatsudoKasan seikatuKinoKojoGroupKatsudoKasan
     */
    public void setSeikatuKinoKojoGroupKatsudoKasan(SeikatsuKinoKojoGroupKatsudoKasan seikatuKinoKojoGroupKatsudoKasan) {
        this.seikatuKinoKojoGroupKatsudoKasan = seikatuKinoKojoGroupKatsudoKasan;
    }

    /**
     * getKaigoShokuinShoguKaizenKasan
     *
     * @return kaigoShokuinShoguKaizenKasan
     */
    public KaigoStaffShoguKaizenKasan getKaigoShokuinShoguKaizenKasan() {
        return kaigoShokuinShoguKaizenKasan;
    }

    /**
     * setKaigoShokuinShoguKaizenKasan
     *
     * @param kaigoShokuinShoguKaizenKasan kaigoShokuinShoguKaizenKasan
     */
    public void setKaigoShokuinShoguKaizenKasan(KaigoStaffShoguKaizenKasan kaigoShokuinShoguKaizenKasan) {
        this.kaigoShokuinShoguKaizenKasan = kaigoShokuinShoguKaizenKasan;
    }

    /**
     * このエンティティの主キーが他の{@literal UrT0521KaigoJigyoshaShiteiServiceEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal UrT0521KaigoJigyoshaShiteiServiceEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7063KaigoJigyoshaShiteiServiceEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.idoYMD = entity.idoYMD;
        this.idoJiyu = entity.idoJiyu;
        this.shiteiNo = entity.shiteiNo;
        this.kihonJohoJunkyoKubun = entity.kihonJohoJunkyoKubun;
        this.jigyoKaishiYMD = entity.jigyoKaishiYMD;
        this.jigyoKyushiYMD = entity.jigyoKyushiYMD;
        this.jigyoSaikaiYMD = entity.jigyoSaikaiYMD;
        this.jigyoHaishiYMD = entity.jigyoHaishiYMD;
        this.jigyoshaName = entity.jigyoshaName;
        this.jigyoshaNameKana = entity.jigyoshaNameKana;
        this.jigyoshaYubinNo = entity.jigyoshaYubinNo;
        this.jigyoshaAddress = entity.jigyoshaAddress;
        this.jigyoshaAddressKana = entity.jigyoshaAddressKana;
        this.jigyoshaTelNo = entity.jigyoshaTelNo;
        this.jigyoshaFaxNo = entity.jigyoshaFaxNo;
        this.torokuHokenshaNo = entity.torokuHokenshaNo;
        this.juryoininUmu = entity.juryoininUmu;
        this.torokuKaishiYMD = entity.torokuKaishiYMD;
        this.torokuShuryoYMD = entity.torokuShuryoYMD;
        this.kanrishaName = entity.kanrishaName;
        this.kanrishaNameKana = entity.kanrishaNameKana;
        this.kanrishaYubinNo = entity.kanrishaYubinNo;
        this.kanrishaAddress = entity.kanrishaAddress;
        this.kanrishaAddressKana = entity.kanrishaAddressKana;
        this.kozaJohoJunkyoKubun = entity.kozaJohoJunkyoKubun;
        this.ginkoCode = entity.ginkoCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKana = entity.kozaMeigininKana;
        this.shakaiFukushihoujinKeigenjigyouJisshi_umu = entity.shakaiFukushihoujinKeigenjigyouJisshi_umu;
        this.seikatsuhogohouShitei_umu = entity.seikatsuhogohouShitei_umu;
        this.shisetsunadoKubun = entity.shisetsunadoKubun;
        this.jininHaichiKubun = entity.jininHaichiKubun;
        this.tokubetsuChiikiKasan_umu = entity.tokubetsuChiikiKasan_umu;
        this.kinkyujiHomonkaigoKasan_umu = entity.kinkyujiHomonkaigoKasan_umu;
        this.tokubetsuKanriTaisei = entity.tokubetsuKanriTaisei;
        this.kinoKunrenShidoTaisei_umu = entity.kinoKunrenShidoTaisei_umu;
        this.shokujiTeikyoTaisei_umu = entity.shokujiTeikyoTaisei_umu;
        this.nyuyokuKaijoTaisei_umu = entity.nyuyokuKaijoTaisei_umu;
        this.tokubetsuNyuyokuKaijoTaisei_umu = entity.tokubetsuNyuyokuKaijoTaisei_umu;
        this.joukinsenjuIshiHaichi_umu = entity.joukinsenjuIshiHaichi_umu;
        this.ishiHaichiKijun = entity.ishiHaichiKijun;
        this.seisinkaIshiTeikitekiRyouyousidou_umu = entity.seisinkaIshiTeikitekiRyouyousidou_umu;
        this.yakanKinmuJokenKijun = entity.yakanKinmuJokenKijun;
        this.ninchishouSenmontou_umu = entity.ninchishouSenmontou_umu;
        this.shokujiTeikyoJokyo = entity.shokujiTeikyoJokyo;
        this.sougeiTaisei = entity.sougeiTaisei;
        this.rehaTeikyoTaisei_SogoRehaShisetsu_umu = entity.rehaTeikyoTaisei_SogoRehaShisetsu_umu;
        this.rehaTeikyoTaisei_RigakuRyohoII_umu = entity.rehaTeikyoTaisei_RigakuRyohoII_umu;
        this.rehaTeikyoTaisei_RigakuRyohoIII_umu = entity.rehaTeikyoTaisei_RigakuRyohoIII_umu;
        this.rehaTeikyoTaisei_SagyoRyohoII_umu = entity.rehaTeikyoTaisei_SagyoRyohoII_umu;
        this.rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu = entity.rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
        this.rehaTeikyoTaisei_Sonota_umu = entity.rehaTeikyoTaisei_Sonota_umu;
        this.rehabilitationKasanJokyo = entity.rehabilitationKasanJokyo;
        this.ryoyoKankyoKijun = entity.ryoyoKankyoKijun;
        this.ishiKetuinGenzanJokyo_umu = entity.ishiKetuinGenzanJokyo_umu;
        this.kangoShokuinKetsuinGenzanJokyo_umu = entity.kangoShokuinKetsuinGenzanJokyo_umu;
        this.rigakuRyouhousiKetsuinGenzanJokyo_umu = entity.rigakuRyouhousiKetsuinGenzanJokyo_umu;
        this.sagyouRyouhousiKetsuinGenzanJokyo_umu = entity.sagyouRyouhousiKetsuinGenzanJokyo_umu;
        this.kaigoShokuinKetsuinGenzanJokyo_umu = entity.kaigoShokuinKetsuinGenzanJokyo_umu;
        this.kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu = entity.kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
        this.kaigoJujishaKetsuinGenzanJokyo_umu = entity.kaigoJujishaKetsuinGenzanJokyo_umu;
        this.kansenTaisakuSidoKanri_umu = entity.kansenTaisakuSidoKanri_umu;
        this.jushoHifuKaiyouShidoKanri_umu = entity.jushoHifuKaiyouShidoKanri_umu;
        this.yakuzaiKaniriShido_umu = entity.yakuzaiKaniriShido_umu;
        this.shogaishaSeikatsuShienTaisei_umu = entity.shogaishaSeikatsuShienTaisei_umu;
        this.chiikiKubunCode = entity.chiikiKubunCode;
        this.jikanEnchoServiceTaisei = entity.jikanEnchoServiceTaisei;
        this.kobetsuRehabilitationTeikyoTaisei = entity.kobetsuRehabilitationTeikyoTaisei;
        this.kyojuhiTaisaku = entity.kyojuhiTaisaku;
        this.yakanCare_umu = entity.yakanCare_umu;
        this.rehabilitationKinoKyoka_umu = entity.rehabilitationKinoKyoka_umu;
        this.kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu = entity.kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1 = entity.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu = entity.kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
        this.kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu = entity.kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu = entity.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu = entity.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
        this.gengoChokakushiKetsuinGenzanJokyo_umu = entity.gengoChokakushiKetsuinGenzanJokyo_umu;
        this.eiyouKanriHyoka = entity.eiyouKanriHyoka;
        this.tokuteijigyoushoKasan_HomonKaigo_umu = entity.tokuteijigyoushoKasan_HomonKaigo_umu;
        this.jakunenseiNinchishoCareTaisei_umu = entity.jakunenseiNinchishoCareTaisei_umu;
        this.undokiKinoKojoTaisei_umu = entity.undokiKinoKojoTaisei_umu;
        this.eiyoManagement_KaizenTaisei_umu = entity.eiyoManagement_KaizenTaisei_umu;
        this.kokuKinoKojoTaisei_umu = entity.kokuKinoKojoTaisei_umu;
        this.jigyoshoHyokaKasan_Moshide_umu = entity.jigyoshoHyokaKasan_Moshide_umu;
        this.jigyoshoHyokaKasan_Kettei_umu = entity.jigyoshoHyokaKasan_Kettei_umu;
        this.kinkyuUkeireTaisei_umu = entity.kinkyuUkeireTaisei_umu;
        this.yakanKangoTaisei_umu = entity.yakanKangoTaisei_umu;
        this.tokuteijigyoshoKasan_Kyotakukaigoshien_umu = entity.tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
        this.kaigoShienSemmoninSenjuJokinshaNinsu = entity.kaigoShienSemmoninSenjuJokinshaNinsu;
        this.kaigoSienSemmoninSenjuHijokinshaNinsu = entity.kaigoSienSemmoninSenjuHijokinshaNinsu;
        this.kaigoSienSemmoninKemmuJokinshaNinsu = entity.kaigoSienSemmoninKemmuJokinshaNinsu;
        this.kaigoSienSemmoninKemmuHijokinshaNinsu = entity.kaigoSienSemmoninKemmuHijokinshaNinsu;
        this.homonkaigoServiceTeikyoSekininshaNinsu = entity.homonkaigoServiceTeikyoSekininshaNinsu;
        this.homonkaigoSenjuJokinshaNinsu = entity.homonkaigoSenjuJokinshaNinsu;
        this.homonkaigoSenjuHijokinshaNinsu = entity.homonkaigoSenjuHijokinshaNinsu;
        this.homonkaigoKemmuJokinshaNinsu = entity.homonkaigoKemmuJokinshaNinsu;
        this.homonkaigoKemmuHijokinshaNinsu = entity.homonkaigoKemmuHijokinshaNinsu;
        this.homonkaigoJokinKanzangoNinsu = entity.homonkaigoJokinKanzangoNinsu;
        this.riyoTeiinNinsu = entity.riyoTeiinNinsu;
        this.shiteiYukoKaishiYMD = entity.shiteiYukoKaishiYMD;
        this.shiteiYukoShuryoYMD = entity.shiteiYukoShuryoYMD;
        this.shiteiKoshinShinseichuKubun = entity.shiteiKoshinShinseichuKubun;
        this.koryokuTeishiKaishiYMD = entity.koryokuTeishiKaishiYMD;
        this.koryokuTeishiShuryoYMD = entity.koryokuTeishiShuryoYMD;
        this.daikiboJigyoshaGaito_umu = entity.daikiboJigyoshaGaito_umu;
        this.junUnitCareTaisei_umu = entity.junUnitCareTaisei_umu;
        this.judokaTaioTaisei_umu = entity.judokaTaioTaisei_umu;
        this.iryoRenkeiTaisei_umu = entity.iryoRenkeiTaisei_umu;
        this.unitCareTaisei_umu = entity.unitCareTaisei_umu;
        this.zaitaku_nyushoSogoRiyoTaisei_umu = entity.zaitaku_nyushoSogoRiyoTaisei_umu;
        this.terminalCareTaisei_umu = entity.terminalCareTaisei_umu;
        this.shintaiKosokuHaishiTorikumi_umu = entity.shintaiKosokuHaishiTorikumi_umu;
        this.shokiboKyotenShugoTaisei_umu = entity.shokiboKyotenShugoTaisei_umu;
        this.ninchishoCareKasan_umu = entity.ninchishoCareKasan_umu;
        this.kobetsuKinoKunrenTaisei_umu = entity.kobetsuKinoKunrenTaisei_umu;
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu = entity.kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2 = entity.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
        this.kobetsuRehaTeikyoTaisei_SagyoRyoho_umu = entity.kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu = entity.kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
        this.kobetsuRehaTeikyoTaisei_Sonota_umu = entity.kobetsuRehaTeikyoTaisei_Sonota_umu;
        this.setsubiKijun = entity.setsubiKijun;
        this.ryoyoTaiseiIjiTokubetsuKasan = entity.ryoyoTaiseiIjiTokubetsuKasan;
        this.kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu = entity.kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
        this.sankyuHelperTaisei = entity.sankyuHelperTaisei;
        this.chuSankanChiikiShokiboJigyoshoKasan_chiiki = entity.chuSankanChiikiShokiboJigyoshoKasan_chiiki;
        this.chuSankanChiikiShokiboJigyoushoKasan_kibo = entity.chuSankanChiikiShokiboJigyoushoKasan_kibo;
        this.serviceTeikyoTaiseiKyokaKasan = entity.serviceTeikyoTaiseiKyokaKasan;
        this.ninchishoTankiShuchuRehabilitationKasan = entity.ninchishoTankiShuchuRehabilitationKasan;
        this.jakunenseiNinchishoRiyoushaUkeeireKasan = entity.jakunenseiNinchishoRiyoushaUkeeireKasan;
        this.kangoTaiseiKasan = entity.kangoTaiseiKasan;
        this.yakinShokuinHaichiKasan = entity.yakinShokuinHaichiKasan;
        this.ryoyoShokuKasan = entity.ryoyoShokuKasan;
        this.nichijoSeikatsuKeizokuShienKasan = entity.nichijoSeikatsuKeizokuShienKasan;
        this.ninchishoSemmonCareKasan = entity.ninchishoSemmonCareKasan;
        this.twentyFourHoursTsuhoTaioKasan = entity.twentyFourHoursTsuhoTaioKasan;
        this.kangoShokuinHaichiKasan = entity.kangoShokuinHaichiKasan;
        this.yakanCareKasan = entity.yakanCareKasan;
        this.shudanCommunicationRyoho_umu = entity.shudanCommunicationRyoho_umu;
        this.serviceTeikyoTaiseiKyokaKasan_Karadokogata = entity.serviceTeikyoTaiseiKyokaKasan_Karadokogata;
        this.nitchuShDecimalaikaigoTaise_20funmiman_umu = entity.nitchuShDecimalaikaigoTaise_20funmiman_umu;
        this.serviceTeikyoSekininshaTaisei_umu = entity.serviceTeikyoSekininshaTaisei_umu;
        this.doitsuTatemonoKyojuRiyoshaGenzan_umu = entity.doitsuTatemonoKyojuRiyoshaGenzan_umu;
        this.kinkyuTankiNyushoTaiseiKakuhoKasan = entity.kinkyuTankiNyushoTaiseiKakuhoKasan;
        this.zaitakuFukki_ZaitakuRyoyoShienKinoKasan = entity.zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
        this.seikatuKinoKojoGroupKatsudoKasan = entity.seikatuKinoKojoGroupKatsudoKasan;
        this.kaigoShokuinShoguKaizenKasan = entity.kaigoShokuinShoguKaizenKasan;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, serviceShuruiCode, yukoKaishiYMD, yukoShuryoYMD, idoYMD, idoJiyu, shiteiNo, kihonJohoJunkyoKubun, jigyoKaishiYMD, jigyoKyushiYMD, jigyoSaikaiYMD, jigyoHaishiYMD, jigyoshaName, jigyoshaNameKana, jigyoshaYubinNo, jigyoshaAddress, jigyoshaAddressKana, jigyoshaTelNo, jigyoshaFaxNo, torokuHokenshaNo, juryoininUmu, torokuKaishiYMD, torokuShuryoYMD, kanrishaName, kanrishaNameKana, kanrishaYubinNo, kanrishaAddress, kanrishaAddressKana, kozaJohoJunkyoKubun, ginkoCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana, shakaiFukushihoujinKeigenjigyouJisshi_umu, seikatsuhogohouShitei_umu, shisetsunadoKubun, jininHaichiKubun, tokubetsuChiikiKasan_umu, kinkyujiHomonkaigoKasan_umu, tokubetsuKanriTaisei, kinoKunrenShidoTaisei_umu, shokujiTeikyoTaisei_umu, nyuyokuKaijoTaisei_umu, tokubetsuNyuyokuKaijoTaisei_umu, joukinsenjuIshiHaichi_umu, ishiHaichiKijun, seisinkaIshiTeikitekiRyouyousidou_umu, yakanKinmuJokenKijun, ninchishouSenmontou_umu, shokujiTeikyoJokyo, sougeiTaisei, rehaTeikyoTaisei_SogoRehaShisetsu_umu, rehaTeikyoTaisei_RigakuRyohoII_umu, rehaTeikyoTaisei_RigakuRyohoIII_umu, rehaTeikyoTaisei_SagyoRyohoII_umu, rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu, rehaTeikyoTaisei_Sonota_umu, rehabilitationKasanJokyo, ryoyoKankyoKijun, ishiKetuinGenzanJokyo_umu, kangoShokuinKetsuinGenzanJokyo_umu, rigakuRyouhousiKetsuinGenzanJokyo_umu, sagyouRyouhousiKetsuinGenzanJokyo_umu, kaigoShokuinKetsuinGenzanJokyo_umu, kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu, kaigoJujishaKetsuinGenzanJokyo_umu, kansenTaisakuSidoKanri_umu, jushoHifuKaiyouShidoKanri_umu, yakuzaiKaniriShido_umu, shogaishaSeikatsuShienTaisei_umu, chiikiKubunCode, jikanEnchoServiceTaisei, kobetsuRehabilitationTeikyoTaisei, kyojuhiTaisaku, yakanCare_umu, rehabilitationKinoKyoka_umu, kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu, kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1, kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu, kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu, kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu, kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu, gengoChokakushiKetsuinGenzanJokyo_umu, eiyouKanriHyoka, tokuteijigyoushoKasan_HomonKaigo_umu, jakunenseiNinchishoCareTaisei_umu, undokiKinoKojoTaisei_umu, eiyoManagement_KaizenTaisei_umu, kokuKinoKojoTaisei_umu, jigyoshoHyokaKasan_Moshide_umu, jigyoshoHyokaKasan_Kettei_umu, kinkyuUkeireTaisei_umu, yakanKangoTaisei_umu, tokuteijigyoshoKasan_Kyotakukaigoshien_umu, kaigoShienSemmoninSenjuJokinshaNinsu, kaigoSienSemmoninSenjuHijokinshaNinsu, kaigoSienSemmoninKemmuJokinshaNinsu, kaigoSienSemmoninKemmuHijokinshaNinsu, homonkaigoServiceTeikyoSekininshaNinsu, homonkaigoSenjuJokinshaNinsu, homonkaigoSenjuHijokinshaNinsu, homonkaigoKemmuJokinshaNinsu, homonkaigoKemmuHijokinshaNinsu, homonkaigoJokinKanzangoNinsu, riyoTeiinNinsu, shiteiYukoKaishiYMD, shiteiYukoShuryoYMD, shiteiKoshinShinseichuKubun, koryokuTeishiKaishiYMD, koryokuTeishiShuryoYMD, daikiboJigyoshaGaito_umu, junUnitCareTaisei_umu, judokaTaioTaisei_umu, iryoRenkeiTaisei_umu, unitCareTaisei_umu, zaitaku_nyushoSogoRiyoTaisei_umu, terminalCareTaisei_umu, shintaiKosokuHaishiTorikumi_umu, shokiboKyotenShugoTaisei_umu, ninchishoCareKasan_umu, kobetsuKinoKunrenTaisei_umu, kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu, kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2, kobetsuRehaTeikyoTaisei_SagyoRyoho_umu, kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu, kobetsuRehaTeikyoTaisei_Sonota_umu, setsubiKijun, ryoyoTaiseiIjiTokubetsuKasan, kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu, sankyuHelperTaisei, chuSankanChiikiShokiboJigyoshoKasan_chiiki, chuSankanChiikiShokiboJigyoushoKasan_kibo, serviceTeikyoTaiseiKyokaKasan, ninchishoTankiShuchuRehabilitationKasan, jakunenseiNinchishoRiyoushaUkeeireKasan, kangoTaiseiKasan, yakinShokuinHaichiKasan, ryoyoShokuKasan, nichijoSeikatsuKeizokuShienKasan, ninchishoSemmonCareKasan, twentyFourHoursTsuhoTaioKasan, kangoShokuinHaichiKasan, yakanCareKasan, shudanCommunicationRyoho_umu, serviceTeikyoTaiseiKyokaKasan_Karadokogata, nitchuShDecimalaikaigoTaise_20funmiman_umu, serviceTeikyoSekininshaTaisei_umu, doitsuTatemonoKyojuRiyoshaGenzan_umu, kinkyuTankiNyushoTaiseiKakuhoKasan, zaitakuFukki_ZaitakuRyoyoShienKinoKasan, seikatuKinoKojoGroupKatsudoKasan, kaigoShokuinShoguKaizenKasan
        );
    }

// </editor-fold>
}
