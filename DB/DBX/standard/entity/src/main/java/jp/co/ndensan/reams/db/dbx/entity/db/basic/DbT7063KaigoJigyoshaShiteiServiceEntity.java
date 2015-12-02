package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
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
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護事業者指定サービステーブルのエンティティクラスです。
 * <br/> 介護事業者単位に利用できるサービスを管理する
 */
public class DbT7063KaigoJigyoshaShiteiServiceEntity extends DbTableEntityBase<DbT7063KaigoJigyoshaShiteiServiceEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
    private RString kihonJohoJunkyoKubun;
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
    private Code juryoininUmu;
    private FlexibleDate torokuKaishiYMD;
    private FlexibleDate torokuShuryoYMD;
    private AtenaMeisho kanrishaName;
    private AtenaKanaMeisho kanrishaNameKana;
    private YubinNo kanrishaYubinNo;
    private AtenaJusho kanrishaAddress;
    private RString kanrishaAddressKana;
    private RString kozaJohoJunkyoKubun;
    private KinyuKikanCode ginkoCode;
    private KinyuKikanShitenCode shitenCode;
    private Code kozaShubetsu;
    private RString kozaNo;
    private AtenaMeisho kozaMeiginin;
    private AtenaKanaMeisho kozaMeigininKana;
    private Code shakaiFukushihoujinKeigenjigyouJisshi_umu;
    private Code seikatsuhogohouShitei_umu;
    private Code shisetsunadoKubun;
    private Code jininHaichiKubun;
    private Code tokubetsuChiikiKasan_umu;
    private Code kinkyujiHomonkaigoKasan_umu;
    private Code tokubetsuKanriTaisei;
    private Code kinoKunrenShidoTaisei_umu;
    private Code shokujiTeikyoTaisei_umu;
    private Code nyuyokuKaijoTaisei_umu;
    private Code tokubetsuNyuyokuKaijoTaisei_umu;
    private Code joukinsenjuIshiHaichi_umu;
    private Code ishiHaichiKijun;
    private Code seisinkaIshiTeikitekiRyouyousidou_umu;
    private Code yakanKinmuJokenKijun;
    private Code ninchishouSenmontou_umu;
    private Code shokujiTeikyoJokyo;
    private Code sougeiTaisei;
    private Code rehaTeikyoTaisei_SogoRehaShisetsu_umu;
    private Code rehaTeikyoTaisei_RigakuRyohoII_umu;
    private Code rehaTeikyoTaisei_RigakuRyohoIII_umu;
    private Code rehaTeikyoTaisei_SagyoRyohoII_umu;
    private Code rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
    private Code rehaTeikyoTaisei_Sonota_umu;
    private Code rehabilitationKasanJokyo;
    private Code ryoyoKankyoKijun;
    private Code ishiKetuinGenzanJokyo_umu;
    private Code kangoShokuinKetsuinGenzanJokyo_umu;
    private Code rigakuRyouhousiKetsuinGenzanJokyo_umu;
    private Code sagyouRyouhousiKetsuinGenzanJokyo_umu;
    private Code kaigoShokuinKetsuinGenzanJokyo_umu;
    private Code kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
    private Code kaigoJujishaKetsuinGenzanJokyo_umu;
    private Code kansenTaisakuSidoKanri_umu;
    private Code jushoHifuKaiyouShidoKanri_umu;
    private Code yakuzaiKaniriShido_umu;
    private Code shogaishaSeikatsuShienTaisei_umu;
    private Code chiikiKubunCode;
    private Code jikanEnchoServiceTaisei;
    private Code kobetsuRehabilitationTeikyoTaisei;
    private Code kyojuhiTaisaku;
    private Code yakanCare_umu;
    private Code rehabilitationKinoKyoka_umu;
    private Code kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
    private Code kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
    private Code kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
    private Code kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
    private Code kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
    private Code kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
    private Code gengoChokakushiKetsuinGenzanJokyo_umu;
    private Code eiyouKanriHyoka;
    private Code tokuteijigyoushoKasan_HomonKaigo_umu;
    private Code jakunenseiNinchishoCareTaisei_umu;
    private Code undokiKinoKojoTaisei_umu;
    private Code eiyoManagement_KaizenTaisei_umu;
    private Code kokuKinoKojoTaisei_umu;
    private Code jigyoshoHyokaKasan_Moshide_umu;
    private Code jigyoshoHyokaKasan_Kettei_umu;
    private Code kinkyuUkeireTaisei_umu;
    private Code yakanKangoTaisei_umu;
    private Code tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
    private int kaigoShienSemmoninSenjuJokinshaNinsu;
    private int kaigoSienSemmoninSenjuHijokinshaNinsu;
    private int kaigoSienSemmoninKemmuJokinshaNinsu;
    private int kaigoSienSemmoninKemmuHijokinshaNinsu;
    private int homonkaigoServiceTeikyoSekininshaNinsu;
    private int homonkaigoSenjuJokinshaNinsu;
    private int homonkaigoSenjuHijokinshaNinsu;
    private int homonkaigoKemmuJokinshaNinsu;
    private int homonkaigoKemmuHijokinshaNinsu;
    private int homonkaigoJokinKanzangoNinsu;
    private int riyoTeiinNinsu;
    private FlexibleDate shiteiYukoKaishiYMD;
    private FlexibleDate shiteiYukoShuryoYMD;
    private Code shiteiKoshinShinseichuKubun;
    private FlexibleDate koryokuTeishiKaishiYMD;
    private FlexibleDate koryokuTeishiShuryoYMD;
    private Code daikiboJigyoshaGaito_umu;
    private Code junUnitCareTaisei_umu;
    private Code judokaTaioTaisei_umu;
    private Code iryoRenkeiTaisei_umu;
    private Code unitCareTaisei_umu;
    private Code zaitaku_nyushoSogoRiyoTaisei_umu;
    private Code terminalCareTaisei_umu;
    private Code shintaiKosokuHaishiTorikumi_umu;
    private Code shokiboKyotenShugoTaisei_umu;
    private Code ninchishoCareKasan_umu;
    private Code kobetsuKinoKunrenTaisei_umu;
    private Code kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
    private Code kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
    private Code kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
    private Code kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
    private Code kobetsuRehaTeikyoTaisei_Sonota_umu;
    private Code setsubiKijun;
    private Code ryoyoTaiseiIjiTokubetsuKasan;
    private Code kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
    private Code sankyuHelperTaisei;
    private Code chuSankanChiikiShokiboJigyoshoKasan_chiiki;
    private Code chuSankanChiikiShokiboJigyoushoKasan_kibo;
    private Code serviceTeikyoTaiseiKyokaKasan;
    private Code ninchishoTankiShuchuRehabilitationKasan;
    private Code jakunenseiNinchishoRiyoushaUkeeireKasan;
    private Code kangoTaiseiKasan;
    private Code yakinShokuinHaichiKasan;
    private Code ryoyoShokuKasan;
    private Code nichijoSeikatsuKeizokuShienKasan;
    private Code ninchishoSemmonCareKasan;
    private Code twentyFourHoursTsuhoTaioKasan;
    private Code kangoShokuinHaichiKasan;
    private Code yakanCareKasan;
    private Code shudanCommunicationRyoho_umu;
    private Code serviceTeikyoTaiseiKyokaKasan_Karadokogata;
    private Code nitchuShintaikaigoTaise_20funmiman_umu;
    private Code serviceTeikyoSekininshaTaisei_umu;
    private Code doitsuTatemonoKyojuRiyoshaGenzan_umu;
    private Code kinkyuTankiNyushoTaiseiKakuhoKasan;
    private Code zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
    private Code seikatuKinoKojoGroupKatsudoKasan;
    private Code kaigoShokuinShoguKaizenKasan;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(@Nonnull KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public KaigoServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(@Nonnull KaigoServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * 有効開始日のgetメソッドです。
     *
     * @return 有効開始日
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * 有効開始日のsetメソッドです。
     *
     * @param yukoKaishiYMD 有効開始日
     */
    public void setYukoKaishiYMD(@Nonnull FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 有効終了日のgetメソッドです。
     *
     * @return 有効終了日
     */
    @CheckForNull
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * 有効終了日のsetメソッドです。
     *
     * @param yukoShuryoYMD 有効終了日
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * 異動日のgetメソッドです。
     *
     * @return 異動日
     */
    @CheckForNull
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動日のsetメソッドです。
     *
     * @param idoYMD 異動日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 異動事由のgetメソッドです。
     *
     * @return 異動事由
     */
    @CheckForNull
    public RString getIdoJiyu() {
        return idoJiyu;
    }

    /**
     * 異動事由のsetメソッドです。
     *
     * @param idoJiyu 異動事由
     */
    public void setIdoJiyu(RString idoJiyu) {
        this.idoJiyu = idoJiyu;
    }

    /**
     * 指定番号のgetメソッドです。
     *
     * @return 指定番号
     */
    @CheckForNull
    public RString getShiteiNo() {
        return shiteiNo;
    }

    /**
     * 指定番号のsetメソッドです。
     *
     * @param shiteiNo 指定番号
     */
    public void setShiteiNo(RString shiteiNo) {
        this.shiteiNo = shiteiNo;
    }

    /**
     * 基本情報準拠区分のgetメソッドです。
     *
     * @return 基本情報準拠区分
     */
    @CheckForNull
    public RString getKihonJohoJunkyoKubun() {
        return kihonJohoJunkyoKubun;
    }

    /**
     * 基本情報準拠区分のsetメソッドです。
     *
     * @param kihonJohoJunkyoKubun 基本情報準拠区分
     */
    public void setKihonJohoJunkyoKubun(RString kihonJohoJunkyoKubun) {
        this.kihonJohoJunkyoKubun = kihonJohoJunkyoKubun;
    }

    /**
     * 事業開始日のgetメソッドです。
     *
     * @return 事業開始日
     */
    @CheckForNull
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * 事業開始日のsetメソッドです。
     *
     * @param jigyoKaishiYMD 事業開始日
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * 事業休止日のgetメソッドです。
     *
     * @return 事業休止日
     */
    @CheckForNull
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * 事業休止日のsetメソッドです。
     *
     * @param jigyoKyushiYMD 事業休止日
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * 事業再開日のgetメソッドです。
     *
     * @return 事業再開日
     */
    @CheckForNull
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * 事業再開日のsetメソッドです。
     *
     * @param jigyoSaikaiYMD 事業再開日
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * 事業廃止日のgetメソッドです。
     *
     * @return 事業廃止日
     */
    @CheckForNull
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * 事業廃止日のsetメソッドです。
     *
     * @param jigyoHaishiYMD 事業廃止日
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    /**
     * 事業者名称のsetメソッドです。
     *
     * @param jigyoshaName 事業者名称
     */
    public void setJigyoshaName(@Nonnull AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     *
     * @param jigyoshaNameKana 事業者名称カナ
     */
    public void setJigyoshaNameKana(@Nonnull AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * 事業者郵便番号のgetメソッドです。
     *
     * @return 事業者郵便番号
     */
    @CheckForNull
    public YubinNo getJigyoshaYubinNo() {
        return jigyoshaYubinNo;
    }

    /**
     * 事業者郵便番号のsetメソッドです。
     *
     * @param jigyoshaYubinNo 事業者郵便番号
     */
    public void setJigyoshaYubinNo(YubinNo jigyoshaYubinNo) {
        this.jigyoshaYubinNo = jigyoshaYubinNo;
    }

    /**
     * 事業者住所のgetメソッドです。
     *
     * @return 事業者住所
     */
    @CheckForNull
    public AtenaJusho getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * 事業者住所のsetメソッドです。
     *
     * @param jigyoshaAddress 事業者住所
     */
    public void setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * 事業者住所カナのgetメソッドです。
     *
     * @return 事業者住所カナ
     */
    @CheckForNull
    public RString getJigyoshaAddressKana() {
        return jigyoshaAddressKana;
    }

    /**
     * 事業者住所カナのsetメソッドです。
     *
     * @param jigyoshaAddressKana 事業者住所カナ
     */
    public void setJigyoshaAddressKana(RString jigyoshaAddressKana) {
        this.jigyoshaAddressKana = jigyoshaAddressKana;
    }

    /**
     * 事業者電話番号のgetメソッドです。
     *
     * @return 事業者電話番号
     */
    @CheckForNull
    public TelNo getJigyoshaTelNo() {
        return jigyoshaTelNo;
    }

    /**
     * 事業者電話番号のsetメソッドです。
     *
     * @param jigyoshaTelNo 事業者電話番号
     */
    public void setJigyoshaTelNo(TelNo jigyoshaTelNo) {
        this.jigyoshaTelNo = jigyoshaTelNo;
    }

    /**
     * 事業者FAX番号のgetメソッドです。
     *
     * @return 事業者FAX番号
     */
    @CheckForNull
    public TelNo getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * 事業者FAX番号のsetメソッドです。
     *
     * @param jigyoshaFaxNo 事業者FAX番号
     */
    public void setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * 登録保険者番号のgetメソッドです。
     *
     * @return 登録保険者番号
     */
    @CheckForNull
    public RString getTorokuHokenshaNo() {
        return torokuHokenshaNo;
    }

    /**
     * 登録保険者番号のsetメソッドです。
     *
     * @param torokuHokenshaNo 登録保険者番号
     */
    public void setTorokuHokenshaNo(RString torokuHokenshaNo) {
        this.torokuHokenshaNo = torokuHokenshaNo;
    }

    /**
     * 受領委任の有無のgetメソッドです。
     *
     * @return 受領委任の有無
     */
    @CheckForNull
    public Code getJuryoininUmu() {
        return juryoininUmu;
    }

    /**
     * 受領委任の有無のsetメソッドです。
     *
     * @param juryoininUmu 受領委任の有無
     */
    public void setJuryoininUmu(Code juryoininUmu) {
        this.juryoininUmu = juryoininUmu;
    }

    /**
     * 登録開始日のgetメソッドです。
     *
     * @return 登録開始日
     */
    @CheckForNull
    public FlexibleDate getTorokuKaishiYMD() {
        return torokuKaishiYMD;
    }

    /**
     * 登録開始日のsetメソッドです。
     *
     * @param torokuKaishiYMD 登録開始日
     */
    public void setTorokuKaishiYMD(FlexibleDate torokuKaishiYMD) {
        this.torokuKaishiYMD = torokuKaishiYMD;
    }

    /**
     * 登録終了日のgetメソッドです。
     *
     * @return 登録終了日
     */
    @CheckForNull
    public FlexibleDate getTorokuShuryoYMD() {
        return torokuShuryoYMD;
    }

    /**
     * 登録終了日のsetメソッドです。
     *
     * @param torokuShuryoYMD 登録終了日
     */
    public void setTorokuShuryoYMD(FlexibleDate torokuShuryoYMD) {
        this.torokuShuryoYMD = torokuShuryoYMD;
    }

    /**
     * 管理者氏名のgetメソッドです。
     *
     * @return 管理者氏名
     */
    public AtenaMeisho getKanrishaName() {
        return kanrishaName;
    }

    /**
     * 管理者氏名のsetメソッドです。
     *
     * @param kanrishaName 管理者氏名
     */
    public void setKanrishaName(@Nonnull AtenaMeisho kanrishaName) {
        this.kanrishaName = kanrishaName;
    }

    /**
     * 管理者氏名カナのgetメソッドです。
     *
     * @return 管理者氏名カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getKanrishaNameKana() {
        return kanrishaNameKana;
    }

    /**
     * 管理者氏名カナのsetメソッドです。
     *
     * @param kanrishaNameKana 管理者氏名カナ
     */
    public void setKanrishaNameKana(AtenaKanaMeisho kanrishaNameKana) {
        this.kanrishaNameKana = kanrishaNameKana;
    }

    /**
     * 管理者住所郵便番号のgetメソッドです。
     *
     * @return 管理者住所郵便番号
     */
    @CheckForNull
    public YubinNo getKanrishaYubinNo() {
        return kanrishaYubinNo;
    }

    /**
     * 管理者住所郵便番号のsetメソッドです。
     *
     * @param kanrishaYubinNo 管理者住所郵便番号
     */
    public void setKanrishaYubinNo(YubinNo kanrishaYubinNo) {
        this.kanrishaYubinNo = kanrishaYubinNo;
    }

    /**
     * 管理者住所のgetメソッドです。
     *
     * @return 管理者住所
     */
    @CheckForNull
    public AtenaJusho getKanrishaAddress() {
        return kanrishaAddress;
    }

    /**
     * 管理者住所のsetメソッドです。
     *
     * @param kanrishaAddress 管理者住所
     */
    public void setKanrishaAddress(AtenaJusho kanrishaAddress) {
        this.kanrishaAddress = kanrishaAddress;
    }

    /**
     * 管理者住所カナのgetメソッドです。
     *
     * @return 管理者住所カナ
     */
    @CheckForNull
    public RString getKanrishaAddressKana() {
        return kanrishaAddressKana;
    }

    /**
     * 管理者住所カナのsetメソッドです。
     *
     * @param kanrishaAddressKana 管理者住所カナ
     */
    public void setKanrishaAddressKana(RString kanrishaAddressKana) {
        this.kanrishaAddressKana = kanrishaAddressKana;
    }

    /**
     * 口座情報準拠区分のgetメソッドです。
     *
     * @return 口座情報準拠区分
     */
    @CheckForNull
    public RString getKozaJohoJunkyoKubun() {
        return kozaJohoJunkyoKubun;
    }

    /**
     * 口座情報準拠区分のsetメソッドです。
     *
     * @param kozaJohoJunkyoKubun 口座情報準拠区分
     */
    public void setKozaJohoJunkyoKubun(RString kozaJohoJunkyoKubun) {
        this.kozaJohoJunkyoKubun = kozaJohoJunkyoKubun;
    }

    /**
     * 銀行コードのgetメソッドです。
     *
     * @return 銀行コード
     */
    @CheckForNull
    public KinyuKikanCode getGinkoCode() {
        return ginkoCode;
    }

    /**
     * 銀行コードのsetメソッドです。
     *
     * @param ginkoCode 銀行コード
     */
    public void setGinkoCode(KinyuKikanCode ginkoCode) {
        this.ginkoCode = ginkoCode;
    }

    /**
     * 支店コードのgetメソッドです。
     *
     * @return 支店コード
     */
    @CheckForNull
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * 支店コードのsetメソッドです。
     *
     * @param shitenCode 支店コード
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * 口座種別のgetメソッドです。
     *
     * @return 口座種別
     */
    @CheckForNull
    public Code getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * 口座種別のsetメソッドです。
     *
     * @param kozaShubetsu 口座種別
     */
    public void setKozaShubetsu(Code kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * 口座番号のgetメソッドです。
     *
     * @return 口座番号
     */
    @CheckForNull
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * 口座番号のsetメソッドです。
     *
     * @param kozaNo 口座番号
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * 口座名義人のgetメソッドです。
     *
     * @return 口座名義人
     */
    @CheckForNull
    public AtenaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * 口座名義人のsetメソッドです。
     *
     * @param kozaMeiginin 口座名義人
     */
    public void setKozaMeiginin(AtenaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * 口座名義人カナのgetメソッドです。
     *
     * @return 口座名義人カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * 口座名義人カナのsetメソッドです。
     *
     * @param kozaMeigininKana 口座名義人カナ
     */
    public void setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * 社会福祉法人軽減事業実施の有無のgetメソッドです。
     *
     * @return 社会福祉法人軽減事業実施の有無
     */
    @CheckForNull
    public Code getShakaiFukushihoujinKeigenjigyouJisshi_umu() {
        return shakaiFukushihoujinKeigenjigyouJisshi_umu;
    }

    /**
     * 社会福祉法人軽減事業実施の有無のsetメソッドです。
     *
     * @param shakaiFukushihoujinKeigenjigyouJisshi_umu 社会福祉法人軽減事業実施の有無
     */
    public void setShakaiFukushihoujinKeigenjigyouJisshi_umu(Code shakaiFukushihoujinKeigenjigyouJisshi_umu) {
        this.shakaiFukushihoujinKeigenjigyouJisshi_umu = shakaiFukushihoujinKeigenjigyouJisshi_umu;
    }

    /**
     * 生活保護法による指定の有無のgetメソッドです。
     *
     * @return 生活保護法による指定の有無
     */
    @CheckForNull
    public Code getSeikatsuhogohouShitei_umu() {
        return seikatsuhogohouShitei_umu;
    }

    /**
     * 生活保護法による指定の有無のsetメソッドです。
     *
     * @param seikatsuhogohouShitei_umu 生活保護法による指定の有無
     */
    public void setSeikatsuhogohouShitei_umu(Code seikatsuhogohouShitei_umu) {
        this.seikatsuhogohouShitei_umu = seikatsuhogohouShitei_umu;
    }

    /**
     * 施設等の区分のgetメソッドです。
     *
     * @return 施設等の区分
     */
    @CheckForNull
    public Code getShisetsunadoKubun() {
        return shisetsunadoKubun;
    }

    /**
     * 施設等の区分のsetメソッドです。
     *
     * @param shisetsunadoKubun 施設等の区分
     */
    public void setShisetsunadoKubun(Code shisetsunadoKubun) {
        this.shisetsunadoKubun = shisetsunadoKubun;
    }

    /**
     * 人員配置区分のgetメソッドです。
     *
     * @return 人員配置区分
     */
    @CheckForNull
    public Code getJininHaichiKubun() {
        return jininHaichiKubun;
    }

    /**
     * 人員配置区分のsetメソッドです。
     *
     * @param jininHaichiKubun 人員配置区分
     */
    public void setJininHaichiKubun(Code jininHaichiKubun) {
        this.jininHaichiKubun = jininHaichiKubun;
    }

    /**
     * 特別地域加算の有無のgetメソッドです。
     *
     * @return 特別地域加算の有無
     */
    @CheckForNull
    public Code getTokubetsuChiikiKasan_umu() {
        return tokubetsuChiikiKasan_umu;
    }

    /**
     * 特別地域加算の有無のsetメソッドです。
     *
     * @param tokubetsuChiikiKasan_umu 特別地域加算の有無
     */
    public void setTokubetsuChiikiKasan_umu(Code tokubetsuChiikiKasan_umu) {
        this.tokubetsuChiikiKasan_umu = tokubetsuChiikiKasan_umu;
    }

    /**
     * 緊急時訪問介護加算の有無のgetメソッドです。
     *
     * @return 緊急時訪問介護加算の有無
     */
    @CheckForNull
    public Code getKinkyujiHomonkaigoKasan_umu() {
        return kinkyujiHomonkaigoKasan_umu;
    }

    /**
     * 緊急時訪問介護加算の有無のsetメソッドです。
     *
     * @param kinkyujiHomonkaigoKasan_umu 緊急時訪問介護加算の有無
     */
    public void setKinkyujiHomonkaigoKasan_umu(Code kinkyujiHomonkaigoKasan_umu) {
        this.kinkyujiHomonkaigoKasan_umu = kinkyujiHomonkaigoKasan_umu;
    }

    /**
     * 特別管理体制のgetメソッドです。
     *
     * @return 特別管理体制
     */
    @CheckForNull
    public Code getTokubetsuKanriTaisei() {
        return tokubetsuKanriTaisei;
    }

    /**
     * 特別管理体制のsetメソッドです。
     *
     * @param tokubetsuKanriTaisei 特別管理体制
     */
    public void setTokubetsuKanriTaisei(Code tokubetsuKanriTaisei) {
        this.tokubetsuKanriTaisei = tokubetsuKanriTaisei;
    }

    /**
     * 機能訓練指導体制の有無のgetメソッドです。
     *
     * @return 機能訓練指導体制の有無
     */
    @CheckForNull
    public Code getKinoKunrenShidoTaisei_umu() {
        return kinoKunrenShidoTaisei_umu;
    }

    /**
     * 機能訓練指導体制の有無のsetメソッドです。
     *
     * @param kinoKunrenShidoTaisei_umu 機能訓練指導体制の有無
     */
    public void setKinoKunrenShidoTaisei_umu(Code kinoKunrenShidoTaisei_umu) {
        this.kinoKunrenShidoTaisei_umu = kinoKunrenShidoTaisei_umu;
    }

    /**
     * 食事提供体制の有無のgetメソッドです。
     *
     * @return 食事提供体制の有無
     */
    @CheckForNull
    public Code getShokujiTeikyoTaisei_umu() {
        return shokujiTeikyoTaisei_umu;
    }

    /**
     * 食事提供体制の有無のsetメソッドです。
     *
     * @param shokujiTeikyoTaisei_umu 食事提供体制の有無
     */
    public void setShokujiTeikyoTaisei_umu(Code shokujiTeikyoTaisei_umu) {
        this.shokujiTeikyoTaisei_umu = shokujiTeikyoTaisei_umu;
    }

    /**
     * 入浴介助体制の有無のgetメソッドです。
     *
     * @return 入浴介助体制の有無
     */
    @CheckForNull
    public Code getNyuyokuKaijoTaisei_umu() {
        return nyuyokuKaijoTaisei_umu;
    }

    /**
     * 入浴介助体制の有無のsetメソッドです。
     *
     * @param nyuyokuKaijoTaisei_umu 入浴介助体制の有無
     */
    public void setNyuyokuKaijoTaisei_umu(Code nyuyokuKaijoTaisei_umu) {
        this.nyuyokuKaijoTaisei_umu = nyuyokuKaijoTaisei_umu;
    }

    /**
     * 特別入浴介助体制の有無のgetメソッドです。
     *
     * @return 特別入浴介助体制の有無
     */
    @CheckForNull
    public Code getTokubetsuNyuyokuKaijoTaisei_umu() {
        return tokubetsuNyuyokuKaijoTaisei_umu;
    }

    /**
     * 特別入浴介助体制の有無のsetメソッドです。
     *
     * @param tokubetsuNyuyokuKaijoTaisei_umu 特別入浴介助体制の有無
     */
    public void setTokubetsuNyuyokuKaijoTaisei_umu(Code tokubetsuNyuyokuKaijoTaisei_umu) {
        this.tokubetsuNyuyokuKaijoTaisei_umu = tokubetsuNyuyokuKaijoTaisei_umu;
    }

    /**
     * 常勤専従医師配置の有無のgetメソッドです。
     *
     * @return 常勤専従医師配置の有無
     */
    @CheckForNull
    public Code getJoukinsenjuIshiHaichi_umu() {
        return joukinsenjuIshiHaichi_umu;
    }

    /**
     * 常勤専従医師配置の有無のsetメソッドです。
     *
     * @param joukinsenjuIshiHaichi_umu 常勤専従医師配置の有無
     */
    public void setJoukinsenjuIshiHaichi_umu(Code joukinsenjuIshiHaichi_umu) {
        this.joukinsenjuIshiHaichi_umu = joukinsenjuIshiHaichi_umu;
    }

    /**
     * 医師の配置基準のgetメソッドです。
     *
     * @return 医師の配置基準
     */
    @CheckForNull
    public Code getIshiHaichiKijun() {
        return ishiHaichiKijun;
    }

    /**
     * 医師の配置基準のsetメソッドです。
     *
     * @param ishiHaichiKijun 医師の配置基準
     */
    public void setIshiHaichiKijun(Code ishiHaichiKijun) {
        this.ishiHaichiKijun = ishiHaichiKijun;
    }

    /**
     * 精神科医師定期的療養指導の有無のgetメソッドです。
     *
     * @return 精神科医師定期的療養指導の有無
     */
    @CheckForNull
    public Code getSeisinkaIshiTeikitekiRyouyousidou_umu() {
        return seisinkaIshiTeikitekiRyouyousidou_umu;
    }

    /**
     * 精神科医師定期的療養指導の有無のsetメソッドです。
     *
     * @param seisinkaIshiTeikitekiRyouyousidou_umu 精神科医師定期的療養指導の有無
     */
    public void setSeisinkaIshiTeikitekiRyouyousidou_umu(Code seisinkaIshiTeikitekiRyouyousidou_umu) {
        this.seisinkaIshiTeikitekiRyouyousidou_umu = seisinkaIshiTeikitekiRyouyousidou_umu;
    }

    /**
     * 夜間勤務条件基準のgetメソッドです。
     *
     * @return 夜間勤務条件基準
     */
    @CheckForNull
    public Code getYakanKinmuJokenKijun() {
        return yakanKinmuJokenKijun;
    }

    /**
     * 夜間勤務条件基準のsetメソッドです。
     *
     * @param yakanKinmuJokenKijun 夜間勤務条件基準
     */
    public void setYakanKinmuJokenKijun(Code yakanKinmuJokenKijun) {
        this.yakanKinmuJokenKijun = yakanKinmuJokenKijun;
    }

    /**
     * 認知症専門棟の有無のgetメソッドです。
     *
     * @return 認知症専門棟の有無
     */
    @CheckForNull
    public Code getNinchishouSenmontou_umu() {
        return ninchishouSenmontou_umu;
    }

    /**
     * 認知症専門棟の有無のsetメソッドです。
     *
     * @param ninchishouSenmontou_umu 認知症専門棟の有無
     */
    public void setNinchishouSenmontou_umu(Code ninchishouSenmontou_umu) {
        this.ninchishouSenmontou_umu = ninchishouSenmontou_umu;
    }

    /**
     * 食事提供の状況のgetメソッドです。
     *
     * @return 食事提供の状況
     */
    @CheckForNull
    public Code getShokujiTeikyoJokyo() {
        return shokujiTeikyoJokyo;
    }

    /**
     * 食事提供の状況のsetメソッドです。
     *
     * @param shokujiTeikyoJokyo 食事提供の状況
     */
    public void setShokujiTeikyoJokyo(Code shokujiTeikyoJokyo) {
        this.shokujiTeikyoJokyo = shokujiTeikyoJokyo;
    }

    /**
     * 送迎体制のgetメソッドです。
     *
     * @return 送迎体制
     */
    @CheckForNull
    public Code getSougeiTaisei() {
        return sougeiTaisei;
    }

    /**
     * 送迎体制のsetメソッドです。
     *
     * @param sougeiTaisei 送迎体制
     */
    public void setSougeiTaisei(Code sougeiTaisei) {
        this.sougeiTaisei = sougeiTaisei;
    }

    /**
     * リハビリテーション提供体制（総合リハビリテーション施設）の有無のgetメソッドです。
     *
     * @return リハビリテーション提供体制（総合リハビリテーション施設）の有無
     */
    @CheckForNull
    public Code getRehaTeikyoTaisei_SogoRehaShisetsu_umu() {
        return rehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * リハビリテーション提供体制（総合リハビリテーション施設）の有無のsetメソッドです。
     *
     * @param rehaTeikyoTaisei_SogoRehaShisetsu_umu
     * リハビリテーション提供体制（総合リハビリテーション施設）の有無
     */
    public void setRehaTeikyoTaisei_SogoRehaShisetsu_umu(Code rehaTeikyoTaisei_SogoRehaShisetsu_umu) {
        this.rehaTeikyoTaisei_SogoRehaShisetsu_umu = rehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * リハビリテーション提供体制（理学療法Ⅱ）の有無のgetメソッドです。
     *
     * @return リハビリテーション提供体制（理学療法Ⅱ）の有無
     */
    @CheckForNull
    public Code getRehaTeikyoTaisei_RigakuRyohoII_umu() {
        return rehaTeikyoTaisei_RigakuRyohoII_umu;
    }

    /**
     * リハビリテーション提供体制（理学療法Ⅱ）の有無のsetメソッドです。
     *
     * @param rehaTeikyoTaisei_RigakuRyohoII_umu リハビリテーション提供体制（理学療法Ⅱ）の有無
     */
    public void setRehaTeikyoTaisei_RigakuRyohoII_umu(Code rehaTeikyoTaisei_RigakuRyohoII_umu) {
        this.rehaTeikyoTaisei_RigakuRyohoII_umu = rehaTeikyoTaisei_RigakuRyohoII_umu;
    }

    /**
     * リハビリテーション提供体制（理学療法Ⅲ）の有無のgetメソッドです。
     *
     * @return リハビリテーション提供体制（理学療法Ⅲ）の有無
     */
    @CheckForNull
    public Code getRehaTeikyoTaisei_RigakuRyohoIII_umu() {
        return rehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * リハビリテーション提供体制（理学療法Ⅲ）の有無のsetメソッドです。
     *
     * @param rehaTeikyoTaisei_RigakuRyohoIII_umu リハビリテーション提供体制（理学療法Ⅲ）の有無
     */
    public void setRehaTeikyoTaisei_RigakuRyohoIII_umu(Code rehaTeikyoTaisei_RigakuRyohoIII_umu) {
        this.rehaTeikyoTaisei_RigakuRyohoIII_umu = rehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * リハビリテーション提供体制（作業療法Ⅱ）の有無のgetメソッドです。
     *
     * @return リハビリテーション提供体制（作業療法Ⅱ）の有無
     */
    @CheckForNull
    public Code getRehaTeikyoTaisei_SagyoRyohoII_umu() {
        return rehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * リハビリテーション提供体制（作業療法Ⅱ）の有無のsetメソッドです。
     *
     * @param rehaTeikyoTaisei_SagyoRyohoII_umu リハビリテーション提供体制（作業療法Ⅱ）の有無
     */
    public void setRehaTeikyoTaisei_SagyoRyohoII_umu(Code rehaTeikyoTaisei_SagyoRyohoII_umu) {
        this.rehaTeikyoTaisei_SagyoRyohoII_umu = rehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * リハビリテーション提供体制（精神科作業療法）の有無のgetメソッドです。
     *
     * @return リハビリテーション提供体制（精神科作業療法）の有無
     */
    @CheckForNull
    public Code getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu() {
        return rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
    }

    /**
     * リハビリテーション提供体制（精神科作業療法）の有無のsetメソッドです。
     *
     * @param rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu リハビリテーション提供体制（精神科作業療法）の有無
     */
    public void setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(Code rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu) {
        this.rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu = rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu;
    }

    /**
     * リハビリテーション提供体制（その他）の有無のgetメソッドです。
     *
     * @return リハビリテーション提供体制（その他）の有無
     */
    @CheckForNull
    public Code getRehaTeikyoTaisei_Sonota_umu() {
        return rehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * リハビリテーション提供体制（その他）の有無のsetメソッドです。
     *
     * @param rehaTeikyoTaisei_Sonota_umu リハビリテーション提供体制（その他）の有無
     */
    public void setRehaTeikyoTaisei_Sonota_umu(Code rehaTeikyoTaisei_Sonota_umu) {
        this.rehaTeikyoTaisei_Sonota_umu = rehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * リハビリテーションの加算状況の有無のgetメソッドです。
     *
     * @return リハビリテーションの加算状況の有無
     */
    @CheckForNull
    public Code getRehabilitationKasanJokyo() {
        return rehabilitationKasanJokyo;
    }

    /**
     * リハビリテーションの加算状況の有無のsetメソッドです。
     *
     * @param rehabilitationKasanJokyo リハビリテーションの加算状況の有無
     */
    public void setRehabilitationKasanJokyo(Code rehabilitationKasanJokyo) {
        this.rehabilitationKasanJokyo = rehabilitationKasanJokyo;
    }

    /**
     * 療養環境基準のgetメソッドです。
     *
     * @return 療養環境基準
     */
    @CheckForNull
    public Code getRyoyoKankyoKijun() {
        return ryoyoKankyoKijun;
    }

    /**
     * 療養環境基準のsetメソッドです。
     *
     * @param ryoyoKankyoKijun 療養環境基準
     */
    public void setRyoyoKankyoKijun(Code ryoyoKankyoKijun) {
        this.ryoyoKankyoKijun = ryoyoKankyoKijun;
    }

    /**
     * 医師の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 医師の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getIshiKetuinGenzanJokyo_umu() {
        return ishiKetuinGenzanJokyo_umu;
    }

    /**
     * 医師の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param ishiKetuinGenzanJokyo_umu 医師の欠員による減算の状況の有無
     */
    public void setIshiKetuinGenzanJokyo_umu(Code ishiKetuinGenzanJokyo_umu) {
        this.ishiKetuinGenzanJokyo_umu = ishiKetuinGenzanJokyo_umu;
    }

    /**
     * 看護職員の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 看護職員の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getKangoShokuinKetsuinGenzanJokyo_umu() {
        return kangoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * 看護職員の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param kangoShokuinKetsuinGenzanJokyo_umu 看護職員の欠員による減算の状況の有無
     */
    public void setKangoShokuinKetsuinGenzanJokyo_umu(Code kangoShokuinKetsuinGenzanJokyo_umu) {
        this.kangoShokuinKetsuinGenzanJokyo_umu = kangoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * 理学療法士の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 理学療法士の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getRigakuRyouhousiKetsuinGenzanJokyo_umu() {
        return rigakuRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * 理学療法士の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param rigakuRyouhousiKetsuinGenzanJokyo_umu 理学療法士の欠員による減算の状況の有無
     */
    public void setRigakuRyouhousiKetsuinGenzanJokyo_umu(Code rigakuRyouhousiKetsuinGenzanJokyo_umu) {
        this.rigakuRyouhousiKetsuinGenzanJokyo_umu = rigakuRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * 作業療法士の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 作業療法士の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getSagyouRyouhousiKetsuinGenzanJokyo_umu() {
        return sagyouRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * 作業療法士の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param sagyouRyouhousiKetsuinGenzanJokyo_umu 作業療法士の欠員による減算の状況の有無
     */
    public void setSagyouRyouhousiKetsuinGenzanJokyo_umu(Code sagyouRyouhousiKetsuinGenzanJokyo_umu) {
        this.sagyouRyouhousiKetsuinGenzanJokyo_umu = sagyouRyouhousiKetsuinGenzanJokyo_umu;
    }

    /**
     * 介護職員の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 介護職員の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getKaigoShokuinKetsuinGenzanJokyo_umu() {
        return kaigoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * 介護職員の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param kaigoShokuinKetsuinGenzanJokyo_umu 介護職員の欠員による減算の状況の有無
     */
    public void setKaigoShokuinKetsuinGenzanJokyo_umu(Code kaigoShokuinKetsuinGenzanJokyo_umu) {
        this.kaigoShokuinKetsuinGenzanJokyo_umu = kaigoShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * 介護支援専門員の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 介護支援専門員の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu() {
        return kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * 介護支援専門員の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
     * 介護支援専門員の欠員による減算の状況の有無
     */
    public void setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(Code kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu) {
        this.kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu = kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu;
    }

    /**
     * 介護従業者の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 介護従業者の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getKaigoJujishaKetsuinGenzanJokyo_umu() {
        return kaigoJujishaKetsuinGenzanJokyo_umu;
    }

    /**
     * 介護従業者の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param kaigoJujishaKetsuinGenzanJokyo_umu 介護従業者の欠員による減算の状況の有無
     */
    public void setKaigoJujishaKetsuinGenzanJokyo_umu(Code kaigoJujishaKetsuinGenzanJokyo_umu) {
        this.kaigoJujishaKetsuinGenzanJokyo_umu = kaigoJujishaKetsuinGenzanJokyo_umu;
    }

    /**
     * 感染対策指導管理の有無のgetメソッドです。
     *
     * @return 感染対策指導管理の有無
     */
    @CheckForNull
    public Code getKansenTaisakuSidoKanri_umu() {
        return kansenTaisakuSidoKanri_umu;
    }

    /**
     * 感染対策指導管理の有無のsetメソッドです。
     *
     * @param kansenTaisakuSidoKanri_umu 感染対策指導管理の有無
     */
    public void setKansenTaisakuSidoKanri_umu(Code kansenTaisakuSidoKanri_umu) {
        this.kansenTaisakuSidoKanri_umu = kansenTaisakuSidoKanri_umu;
    }

    /**
     * 重症皮膚潰瘍指導管理の有無のgetメソッドです。
     *
     * @return 重症皮膚潰瘍指導管理の有無
     */
    @CheckForNull
    public Code getJushoHifuKaiyouShidoKanri_umu() {
        return jushoHifuKaiyouShidoKanri_umu;
    }

    /**
     * 重症皮膚潰瘍指導管理の有無のsetメソッドです。
     *
     * @param jushoHifuKaiyouShidoKanri_umu 重症皮膚潰瘍指導管理の有無
     */
    public void setJushoHifuKaiyouShidoKanri_umu(Code jushoHifuKaiyouShidoKanri_umu) {
        this.jushoHifuKaiyouShidoKanri_umu = jushoHifuKaiyouShidoKanri_umu;
    }

    /**
     * 薬剤管理指導の有無のgetメソッドです。
     *
     * @return 薬剤管理指導の有無
     */
    @CheckForNull
    public Code getYakuzaiKaniriShido_umu() {
        return yakuzaiKaniriShido_umu;
    }

    /**
     * 薬剤管理指導の有無のsetメソッドです。
     *
     * @param yakuzaiKaniriShido_umu 薬剤管理指導の有無
     */
    public void setYakuzaiKaniriShido_umu(Code yakuzaiKaniriShido_umu) {
        this.yakuzaiKaniriShido_umu = yakuzaiKaniriShido_umu;
    }

    /**
     * 障害者生活支援体制の有無のgetメソッドです。
     *
     * @return 障害者生活支援体制の有無
     */
    @CheckForNull
    public Code getShogaishaSeikatsuShienTaisei_umu() {
        return shogaishaSeikatsuShienTaisei_umu;
    }

    /**
     * 障害者生活支援体制の有無のsetメソッドです。
     *
     * @param shogaishaSeikatsuShienTaisei_umu 障害者生活支援体制の有無
     */
    public void setShogaishaSeikatsuShienTaisei_umu(Code shogaishaSeikatsuShienTaisei_umu) {
        this.shogaishaSeikatsuShienTaisei_umu = shogaishaSeikatsuShienTaisei_umu;
    }

    /**
     * 地域区分コードのgetメソッドです。
     *
     * @return 地域区分コード
     */
    @CheckForNull
    public Code getChiikiKubunCode() {
        return chiikiKubunCode;
    }

    /**
     * 地域区分コードのsetメソッドです。
     *
     * @param chiikiKubunCode 地域区分コード
     */
    public void setChiikiKubunCode(Code chiikiKubunCode) {
        this.chiikiKubunCode = chiikiKubunCode;
    }

    /**
     * 時間延長サービス体制のgetメソッドです。
     *
     * @return 時間延長サービス体制
     */
    @CheckForNull
    public Code getJikanEnchoServiceTaisei() {
        return jikanEnchoServiceTaisei;
    }

    /**
     * 時間延長サービス体制のsetメソッドです。
     *
     * @param jikanEnchoServiceTaisei 時間延長サービス体制
     */
    public void setJikanEnchoServiceTaisei(Code jikanEnchoServiceTaisei) {
        this.jikanEnchoServiceTaisei = jikanEnchoServiceTaisei;
    }

    /**
     * 個別リハビリテーション提供体制のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制
     */
    @CheckForNull
    public Code getKobetsuRehabilitationTeikyoTaisei() {
        return kobetsuRehabilitationTeikyoTaisei;
    }

    /**
     * 個別リハビリテーション提供体制のsetメソッドです。
     *
     * @param kobetsuRehabilitationTeikyoTaisei 個別リハビリテーション提供体制
     */
    public void setKobetsuRehabilitationTeikyoTaisei(Code kobetsuRehabilitationTeikyoTaisei) {
        this.kobetsuRehabilitationTeikyoTaisei = kobetsuRehabilitationTeikyoTaisei;
    }

    /**
     * 居住費対策のgetメソッドです。
     *
     * @return 居住費対策
     */
    @CheckForNull
    public Code getKyojuhiTaisaku() {
        return kyojuhiTaisaku;
    }

    /**
     * 居住費対策のsetメソッドです。
     *
     * @param kyojuhiTaisaku 居住費対策
     */
    public void setKyojuhiTaisaku(Code kyojuhiTaisaku) {
        this.kyojuhiTaisaku = kyojuhiTaisaku;
    }

    /**
     * 夜間ケアの有無のgetメソッドです。
     *
     * @return 夜間ケアの有無
     */
    @CheckForNull
    public Code getYakanCare_umu() {
        return yakanCare_umu;
    }

    /**
     * 夜間ケアの有無のsetメソッドです。
     *
     * @param yakanCare_umu 夜間ケアの有無
     */
    public void setYakanCare_umu(Code yakanCare_umu) {
        this.yakanCare_umu = yakanCare_umu;
    }

    /**
     * リハビリテーション機能強化の有無のgetメソッドです。
     *
     * @return リハビリテーション機能強化の有無
     */
    @CheckForNull
    public Code getRehabilitationKinoKyoka_umu() {
        return rehabilitationKinoKyoka_umu;
    }

    /**
     * リハビリテーション機能強化の有無のsetメソッドです。
     *
     * @param rehabilitationKinoKyoka_umu リハビリテーション機能強化の有無
     */
    public void setRehabilitationKinoKyoka_umu(Code rehabilitationKinoKyoka_umu) {
        this.rehabilitationKinoKyoka_umu = rehabilitationKinoKyoka_umu;
    }

    /**
     * 個別リハビリテーション提供体制（総合リハビリテーション施設）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（総合リハビリテーション施設）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu() {
        return kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * 個別リハビリテーション提供体制（総合リハビリテーション施設）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
     * 個別リハビリテーション提供体制（総合リハビリテーション施設）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(Code kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu) {
        this.kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu = kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無1のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（理学療法Ⅱ）の有無1
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無1のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無1
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(Code kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1 = kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅲ）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（理学療法Ⅲ）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅲ）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
     * 個別リハビリテーション提供体制（理学療法Ⅲ）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(Code kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu = kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu;
    }

    /**
     * 個別リハビリテーション提供体制（作業療法Ⅱ）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（作業療法Ⅱ）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu() {
        return kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * 個別リハビリテーション提供体制（作業療法Ⅱ）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu 個別リハビリテーション提供体制（作業療法Ⅱ）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(Code kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu) {
        this.kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu = kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅰ）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（言語聴覚療法Ⅰ）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu() {
        return kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅰ）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅰ）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(Code kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu) {
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu = kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅱ）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（言語聴覚療法Ⅱ）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu() {
        return kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅱ）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅱ）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(Code kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu) {
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu = kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu;
    }

    /**
     * 言語聴覚士の欠員による減算の状況の有無のgetメソッドです。
     *
     * @return 言語聴覚士の欠員による減算の状況の有無
     */
    @CheckForNull
    public Code getGengoChokakushiKetsuinGenzanJokyo_umu() {
        return gengoChokakushiKetsuinGenzanJokyo_umu;
    }

    /**
     * 言語聴覚士の欠員による減算の状況の有無のsetメソッドです。
     *
     * @param gengoChokakushiKetsuinGenzanJokyo_umu 言語聴覚士の欠員による減算の状況の有無
     */
    public void setGengoChokakushiKetsuinGenzanJokyo_umu(Code gengoChokakushiKetsuinGenzanJokyo_umu) {
        this.gengoChokakushiKetsuinGenzanJokyo_umu = gengoChokakushiKetsuinGenzanJokyo_umu;
    }

    /**
     * 栄養管理の評価のgetメソッドです。
     *
     * @return 栄養管理の評価
     */
    @CheckForNull
    public Code getEiyouKanriHyoka() {
        return eiyouKanriHyoka;
    }

    /**
     * 栄養管理の評価のsetメソッドです。
     *
     * @param eiyouKanriHyoka 栄養管理の評価
     */
    public void setEiyouKanriHyoka(Code eiyouKanriHyoka) {
        this.eiyouKanriHyoka = eiyouKanriHyoka;
    }

    /**
     * 特定事業所加算（訪問介護）の有無のgetメソッドです。
     *
     * @return 特定事業所加算（訪問介護）の有無
     */
    @CheckForNull
    public Code getTokuteijigyoushoKasan_HomonKaigo_umu() {
        return tokuteijigyoushoKasan_HomonKaigo_umu;
    }

    /**
     * 特定事業所加算（訪問介護）の有無のsetメソッドです。
     *
     * @param tokuteijigyoushoKasan_HomonKaigo_umu 特定事業所加算（訪問介護）の有無
     */
    public void setTokuteijigyoushoKasan_HomonKaigo_umu(Code tokuteijigyoushoKasan_HomonKaigo_umu) {
        this.tokuteijigyoushoKasan_HomonKaigo_umu = tokuteijigyoushoKasan_HomonKaigo_umu;
    }

    /**
     * 若年性認知症ケア体制の有無のgetメソッドです。
     *
     * @return 若年性認知症ケア体制の有無
     */
    @CheckForNull
    public Code getJakunenseiNinchishoCareTaisei_umu() {
        return jakunenseiNinchishoCareTaisei_umu;
    }

    /**
     * 若年性認知症ケア体制の有無のsetメソッドです。
     *
     * @param jakunenseiNinchishoCareTaisei_umu 若年性認知症ケア体制の有無
     */
    public void setJakunenseiNinchishoCareTaisei_umu(Code jakunenseiNinchishoCareTaisei_umu) {
        this.jakunenseiNinchishoCareTaisei_umu = jakunenseiNinchishoCareTaisei_umu;
    }

    /**
     * 運動器機能向上体制の有無のgetメソッドです。
     *
     * @return 運動器機能向上体制の有無
     */
    @CheckForNull
    public Code getUndokiKinoKojoTaisei_umu() {
        return undokiKinoKojoTaisei_umu;
    }

    /**
     * 運動器機能向上体制の有無のsetメソッドです。
     *
     * @param undokiKinoKojoTaisei_umu 運動器機能向上体制の有無
     */
    public void setUndokiKinoKojoTaisei_umu(Code undokiKinoKojoTaisei_umu) {
        this.undokiKinoKojoTaisei_umu = undokiKinoKojoTaisei_umu;
    }

    /**
     * 栄養マネジメント（改善）体制の有無のgetメソッドです。
     *
     * @return 栄養マネジメント（改善）体制の有無
     */
    @CheckForNull
    public Code getEiyoManagement_KaizenTaisei_umu() {
        return eiyoManagement_KaizenTaisei_umu;
    }

    /**
     * 栄養マネジメント（改善）体制の有無のsetメソッドです。
     *
     * @param eiyoManagement_KaizenTaisei_umu 栄養マネジメント（改善）体制の有無
     */
    public void setEiyoManagement_KaizenTaisei_umu(Code eiyoManagement_KaizenTaisei_umu) {
        this.eiyoManagement_KaizenTaisei_umu = eiyoManagement_KaizenTaisei_umu;
    }

    /**
     * 口腔機能向上体制の有無のgetメソッドです。
     *
     * @return 口腔機能向上体制の有無
     */
    @CheckForNull
    public Code getKokuKinoKojoTaisei_umu() {
        return kokuKinoKojoTaisei_umu;
    }

    /**
     * 口腔機能向上体制の有無のsetメソッドです。
     *
     * @param kokuKinoKojoTaisei_umu 口腔機能向上体制の有無
     */
    public void setKokuKinoKojoTaisei_umu(Code kokuKinoKojoTaisei_umu) {
        this.kokuKinoKojoTaisei_umu = kokuKinoKojoTaisei_umu;
    }

    /**
     * 事業所評価加算（申出）の有無のgetメソッドです。
     *
     * @return 事業所評価加算（申出）の有無
     */
    @CheckForNull
    public Code getJigyoshoHyokaKasan_Moshide_umu() {
        return jigyoshoHyokaKasan_Moshide_umu;
    }

    /**
     * 事業所評価加算（申出）の有無のsetメソッドです。
     *
     * @param jigyoshoHyokaKasan_Moshide_umu 事業所評価加算（申出）の有無
     */
    public void setJigyoshoHyokaKasan_Moshide_umu(Code jigyoshoHyokaKasan_Moshide_umu) {
        this.jigyoshoHyokaKasan_Moshide_umu = jigyoshoHyokaKasan_Moshide_umu;
    }

    /**
     * 事業所評価加算（決定）の有無のgetメソッドです。
     *
     * @return 事業所評価加算（決定）の有無
     */
    @CheckForNull
    public Code getJigyoshoHyokaKasan_Kettei_umu() {
        return jigyoshoHyokaKasan_Kettei_umu;
    }

    /**
     * 事業所評価加算（決定）の有無のsetメソッドです。
     *
     * @param jigyoshoHyokaKasan_Kettei_umu 事業所評価加算（決定）の有無
     */
    public void setJigyoshoHyokaKasan_Kettei_umu(Code jigyoshoHyokaKasan_Kettei_umu) {
        this.jigyoshoHyokaKasan_Kettei_umu = jigyoshoHyokaKasan_Kettei_umu;
    }

    /**
     * 緊急受入体制の有無のgetメソッドです。
     *
     * @return 緊急受入体制の有無
     */
    @CheckForNull
    public Code getKinkyuUkeireTaisei_umu() {
        return kinkyuUkeireTaisei_umu;
    }

    /**
     * 緊急受入体制の有無のsetメソッドです。
     *
     * @param kinkyuUkeireTaisei_umu 緊急受入体制の有無
     */
    public void setKinkyuUkeireTaisei_umu(Code kinkyuUkeireTaisei_umu) {
        this.kinkyuUkeireTaisei_umu = kinkyuUkeireTaisei_umu;
    }

    /**
     * 夜間看護体制の有無のgetメソッドです。
     *
     * @return 夜間看護体制の有無
     */
    @CheckForNull
    public Code getYakanKangoTaisei_umu() {
        return yakanKangoTaisei_umu;
    }

    /**
     * 夜間看護体制の有無のsetメソッドです。
     *
     * @param yakanKangoTaisei_umu 夜間看護体制の有無
     */
    public void setYakanKangoTaisei_umu(Code yakanKangoTaisei_umu) {
        this.yakanKangoTaisei_umu = yakanKangoTaisei_umu;
    }

    /**
     * 特定事業所加算（居宅介護支援）の有無のgetメソッドです。
     *
     * @return 特定事業所加算（居宅介護支援）の有無
     */
    @CheckForNull
    public Code getTokuteijigyoshoKasan_Kyotakukaigoshien_umu() {
        return tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
    }

    /**
     * 特定事業所加算（居宅介護支援）の有無のsetメソッドです。
     *
     * @param tokuteijigyoshoKasan_Kyotakukaigoshien_umu 特定事業所加算（居宅介護支援）の有無
     */
    public void setTokuteijigyoshoKasan_Kyotakukaigoshien_umu(Code tokuteijigyoshoKasan_Kyotakukaigoshien_umu) {
        this.tokuteijigyoshoKasan_Kyotakukaigoshien_umu = tokuteijigyoshoKasan_Kyotakukaigoshien_umu;
    }

    /**
     * 介護支援専門員数（専従の常勤者）のgetメソッドです。
     *
     * @return 介護支援専門員数（専従の常勤者）
     */
    @CheckForNull
    public int getKaigoShienSemmoninSenjuJokinshaNinsu() {
        return kaigoShienSemmoninSenjuJokinshaNinsu;
    }

    /**
     * 介護支援専門員数（専従の常勤者）のsetメソッドです。
     *
     * @param kaigoShienSemmoninSenjuJokinshaNinsu 介護支援専門員数（専従の常勤者）
     */
    public void setKaigoShienSemmoninSenjuJokinshaNinsu(int kaigoShienSemmoninSenjuJokinshaNinsu) {
        this.kaigoShienSemmoninSenjuJokinshaNinsu = kaigoShienSemmoninSenjuJokinshaNinsu;
    }

    /**
     * 介護支援専門員数（専従の非常勤者）のgetメソッドです。
     *
     * @return 介護支援専門員数（専従の非常勤者）
     */
    @CheckForNull
    public int getKaigoSienSemmoninSenjuHijokinshaNinsu() {
        return kaigoSienSemmoninSenjuHijokinshaNinsu;
    }

    /**
     * 介護支援専門員数（専従の非常勤者）のsetメソッドです。
     *
     * @param kaigoSienSemmoninSenjuHijokinshaNinsu 介護支援専門員数（専従の非常勤者）
     */
    public void setKaigoSienSemmoninSenjuHijokinshaNinsu(int kaigoSienSemmoninSenjuHijokinshaNinsu) {
        this.kaigoSienSemmoninSenjuHijokinshaNinsu = kaigoSienSemmoninSenjuHijokinshaNinsu;
    }

    /**
     * 介護支援専門員数（兼務の常勤者）のgetメソッドです。
     *
     * @return 介護支援専門員数（兼務の常勤者）
     */
    @CheckForNull
    public int getKaigoSienSemmoninKemmuJokinshaNinsu() {
        return kaigoSienSemmoninKemmuJokinshaNinsu;
    }

    /**
     * 介護支援専門員数（兼務の常勤者）のsetメソッドです。
     *
     * @param kaigoSienSemmoninKemmuJokinshaNinsu 介護支援専門員数（兼務の常勤者）
     */
    public void setKaigoSienSemmoninKemmuJokinshaNinsu(int kaigoSienSemmoninKemmuJokinshaNinsu) {
        this.kaigoSienSemmoninKemmuJokinshaNinsu = kaigoSienSemmoninKemmuJokinshaNinsu;
    }

    /**
     * 介護支援専門員数（兼務の非常勤者）のgetメソッドです。
     *
     * @return 介護支援専門員数（兼務の非常勤者）
     */
    @CheckForNull
    public int getKaigoSienSemmoninKemmuHijokinshaNinsu() {
        return kaigoSienSemmoninKemmuHijokinshaNinsu;
    }

    /**
     * 介護支援専門員数（兼務の非常勤者）のsetメソッドです。
     *
     * @param kaigoSienSemmoninKemmuHijokinshaNinsu 介護支援専門員数（兼務の非常勤者）
     */
    public void setKaigoSienSemmoninKemmuHijokinshaNinsu(int kaigoSienSemmoninKemmuHijokinshaNinsu) {
        this.kaigoSienSemmoninKemmuHijokinshaNinsu = kaigoSienSemmoninKemmuHijokinshaNinsu;
    }

    /**
     * 訪問介護サービス提供責任者数のgetメソッドです。
     *
     * @return 訪問介護サービス提供責任者数
     */
    @CheckForNull
    public int getHomonkaigoServiceTeikyoSekininshaNinsu() {
        return homonkaigoServiceTeikyoSekininshaNinsu;
    }

    /**
     * 訪問介護サービス提供責任者数のsetメソッドです。
     *
     * @param homonkaigoServiceTeikyoSekininshaNinsu 訪問介護サービス提供責任者数
     */
    public void setHomonkaigoServiceTeikyoSekininshaNinsu(int homonkaigoServiceTeikyoSekininshaNinsu) {
        this.homonkaigoServiceTeikyoSekininshaNinsu = homonkaigoServiceTeikyoSekininshaNinsu;
    }

    /**
     * 訪問介護員数（専従の常勤者）のgetメソッドです。
     *
     * @return 訪問介護員数（専従の常勤者）
     */
    @CheckForNull
    public int getHomonkaigoSenjuJokinshaNinsu() {
        return homonkaigoSenjuJokinshaNinsu;
    }

    /**
     * 訪問介護員数（専従の常勤者）のsetメソッドです。
     *
     * @param homonkaigoSenjuJokinshaNinsu 訪問介護員数（専従の常勤者）
     */
    public void setHomonkaigoSenjuJokinshaNinsu(int homonkaigoSenjuJokinshaNinsu) {
        this.homonkaigoSenjuJokinshaNinsu = homonkaigoSenjuJokinshaNinsu;
    }

    /**
     * 訪問介護員数（専従の非常勤者）のgetメソッドです。
     *
     * @return 訪問介護員数（専従の非常勤者）
     */
    @CheckForNull
    public int getHomonkaigoSenjuHijokinshaNinsu() {
        return homonkaigoSenjuHijokinshaNinsu;
    }

    /**
     * 訪問介護員数（専従の非常勤者）のsetメソッドです。
     *
     * @param homonkaigoSenjuHijokinshaNinsu 訪問介護員数（専従の非常勤者）
     */
    public void setHomonkaigoSenjuHijokinshaNinsu(int homonkaigoSenjuHijokinshaNinsu) {
        this.homonkaigoSenjuHijokinshaNinsu = homonkaigoSenjuHijokinshaNinsu;
    }

    /**
     * 訪問介護員数（兼務の常勤者）のgetメソッドです。
     *
     * @return 訪問介護員数（兼務の常勤者）
     */
    @CheckForNull
    public int getHomonkaigoKemmuJokinshaNinsu() {
        return homonkaigoKemmuJokinshaNinsu;
    }

    /**
     * 訪問介護員数（兼務の常勤者）のsetメソッドです。
     *
     * @param homonkaigoKemmuJokinshaNinsu 訪問介護員数（兼務の常勤者）
     */
    public void setHomonkaigoKemmuJokinshaNinsu(int homonkaigoKemmuJokinshaNinsu) {
        this.homonkaigoKemmuJokinshaNinsu = homonkaigoKemmuJokinshaNinsu;
    }

    /**
     * 訪問介護員数（兼務の非常勤者）のgetメソッドです。
     *
     * @return 訪問介護員数（兼務の非常勤者）
     */
    @CheckForNull
    public int getHomonkaigoKemmuHijokinshaNinsu() {
        return homonkaigoKemmuHijokinshaNinsu;
    }

    /**
     * 訪問介護員数（兼務の非常勤者）のsetメソッドです。
     *
     * @param homonkaigoKemmuHijokinshaNinsu 訪問介護員数（兼務の非常勤者）
     */
    public void setHomonkaigoKemmuHijokinshaNinsu(int homonkaigoKemmuHijokinshaNinsu) {
        this.homonkaigoKemmuHijokinshaNinsu = homonkaigoKemmuHijokinshaNinsu;
    }

    /**
     * 訪問介護員数（常勤換算後の人数）のgetメソッドです。
     *
     * @return 訪問介護員数（常勤換算後の人数）
     */
    @CheckForNull
    public int getHomonkaigoJokinKanzangoNinsu() {
        return homonkaigoJokinKanzangoNinsu;
    }

    /**
     * 訪問介護員数（常勤換算後の人数）のsetメソッドです。
     *
     * @param homonkaigoJokinKanzangoNinsu 訪問介護員数（常勤換算後の人数）
     */
    public void setHomonkaigoJokinKanzangoNinsu(int homonkaigoJokinKanzangoNinsu) {
        this.homonkaigoJokinKanzangoNinsu = homonkaigoJokinKanzangoNinsu;
    }

    /**
     * 利用定員数のgetメソッドです。
     *
     * @return 利用定員数
     */
    @CheckForNull
    public int getRiyoTeiinNinsu() {
        return riyoTeiinNinsu;
    }

    /**
     * 利用定員数のsetメソッドです。
     *
     * @param riyoTeiinNinsu 利用定員数
     */
    public void setRiyoTeiinNinsu(int riyoTeiinNinsu) {
        this.riyoTeiinNinsu = riyoTeiinNinsu;
    }

    /**
     * 指定有効開始日のgetメソッドです。
     *
     * @return 指定有効開始日
     */
    @CheckForNull
    public FlexibleDate getShiteiYukoKaishiYMD() {
        return shiteiYukoKaishiYMD;
    }

    /**
     * 指定有効開始日のsetメソッドです。
     *
     * @param shiteiYukoKaishiYMD 指定有効開始日
     */
    public void setShiteiYukoKaishiYMD(FlexibleDate shiteiYukoKaishiYMD) {
        this.shiteiYukoKaishiYMD = shiteiYukoKaishiYMD;
    }

    /**
     * 指定有効終了日のgetメソッドです。
     *
     * @return 指定有効終了日
     */
    @CheckForNull
    public FlexibleDate getShiteiYukoShuryoYMD() {
        return shiteiYukoShuryoYMD;
    }

    /**
     * 指定有効終了日のsetメソッドです。
     *
     * @param shiteiYukoShuryoYMD 指定有効終了日
     */
    public void setShiteiYukoShuryoYMD(FlexibleDate shiteiYukoShuryoYMD) {
        this.shiteiYukoShuryoYMD = shiteiYukoShuryoYMD;
    }

    /**
     * 指定更新申請中区分のgetメソッドです。
     *
     * @return 指定更新申請中区分
     */
    @CheckForNull
    public Code getShiteiKoshinShinseichuKubun() {
        return shiteiKoshinShinseichuKubun;
    }

    /**
     * 指定更新申請中区分のsetメソッドです。
     *
     * @param shiteiKoshinShinseichuKubun 指定更新申請中区分
     */
    public void setShiteiKoshinShinseichuKubun(Code shiteiKoshinShinseichuKubun) {
        this.shiteiKoshinShinseichuKubun = shiteiKoshinShinseichuKubun;
    }

    /**
     * 効力停止開始日のgetメソッドです。
     *
     * @return 効力停止開始日
     */
    @CheckForNull
    public FlexibleDate getKoryokuTeishiKaishiYMD() {
        return koryokuTeishiKaishiYMD;
    }

    /**
     * 効力停止開始日のsetメソッドです。
     *
     * @param koryokuTeishiKaishiYMD 効力停止開始日
     */
    public void setKoryokuTeishiKaishiYMD(FlexibleDate koryokuTeishiKaishiYMD) {
        this.koryokuTeishiKaishiYMD = koryokuTeishiKaishiYMD;
    }

    /**
     * 効力停止終了日のgetメソッドです。
     *
     * @return 効力停止終了日
     */
    @CheckForNull
    public FlexibleDate getKoryokuTeishiShuryoYMD() {
        return koryokuTeishiShuryoYMD;
    }

    /**
     * 効力停止終了日のsetメソッドです。
     *
     * @param koryokuTeishiShuryoYMD 効力停止終了日
     */
    public void setKoryokuTeishiShuryoYMD(FlexibleDate koryokuTeishiShuryoYMD) {
        this.koryokuTeishiShuryoYMD = koryokuTeishiShuryoYMD;
    }

    /**
     * 大規模事業所該当の有無のgetメソッドです。
     *
     * @return 大規模事業所該当の有無
     */
    @CheckForNull
    public Code getDaikiboJigyoshaGaito_umu() {
        return daikiboJigyoshaGaito_umu;
    }

    /**
     * 大規模事業所該当の有無のsetメソッドです。
     *
     * @param daikiboJigyoshaGaito_umu 大規模事業所該当の有無
     */
    public void setDaikiboJigyoshaGaito_umu(Code daikiboJigyoshaGaito_umu) {
        this.daikiboJigyoshaGaito_umu = daikiboJigyoshaGaito_umu;
    }

    /**
     * 準ユニットケア体制の有無のgetメソッドです。
     *
     * @return 準ユニットケア体制の有無
     */
    @CheckForNull
    public Code getJunUnitCareTaisei_umu() {
        return junUnitCareTaisei_umu;
    }

    /**
     * 準ユニットケア体制の有無のsetメソッドです。
     *
     * @param junUnitCareTaisei_umu 準ユニットケア体制の有無
     */
    public void setJunUnitCareTaisei_umu(Code junUnitCareTaisei_umu) {
        this.junUnitCareTaisei_umu = junUnitCareTaisei_umu;
    }

    /**
     * 重度化対応体制の有無のgetメソッドです。
     *
     * @return 重度化対応体制の有無
     */
    @CheckForNull
    public Code getJudokaTaioTaisei_umu() {
        return judokaTaioTaisei_umu;
    }

    /**
     * 重度化対応体制の有無のsetメソッドです。
     *
     * @param judokaTaioTaisei_umu 重度化対応体制の有無
     */
    public void setJudokaTaioTaisei_umu(Code judokaTaioTaisei_umu) {
        this.judokaTaioTaisei_umu = judokaTaioTaisei_umu;
    }

    /**
     * 医療連携体制の有無のgetメソッドです。
     *
     * @return 医療連携体制の有無
     */
    @CheckForNull
    public Code getIryoRenkeiTaisei_umu() {
        return iryoRenkeiTaisei_umu;
    }

    /**
     * 医療連携体制の有無のsetメソッドです。
     *
     * @param iryoRenkeiTaisei_umu 医療連携体制の有無
     */
    public void setIryoRenkeiTaisei_umu(Code iryoRenkeiTaisei_umu) {
        this.iryoRenkeiTaisei_umu = iryoRenkeiTaisei_umu;
    }

    /**
     * ユニットケア体制の有無のgetメソッドです。
     *
     * @return ユニットケア体制の有無
     */
    @CheckForNull
    public Code getUnitCareTaisei_umu() {
        return unitCareTaisei_umu;
    }

    /**
     * ユニットケア体制の有無のsetメソッドです。
     *
     * @param unitCareTaisei_umu ユニットケア体制の有無
     */
    public void setUnitCareTaisei_umu(Code unitCareTaisei_umu) {
        this.unitCareTaisei_umu = unitCareTaisei_umu;
    }

    /**
     * 在宅・入所相互利用体制の有無のgetメソッドです。
     *
     * @return 在宅・入所相互利用体制の有無
     */
    @CheckForNull
    public Code getZaitaku_nyushoSogoRiyoTaisei_umu() {
        return zaitaku_nyushoSogoRiyoTaisei_umu;
    }

    /**
     * 在宅・入所相互利用体制の有無のsetメソッドです。
     *
     * @param zaitaku_nyushoSogoRiyoTaisei_umu 在宅・入所相互利用体制の有無
     */
    public void setZaitaku_nyushoSogoRiyoTaisei_umu(Code zaitaku_nyushoSogoRiyoTaisei_umu) {
        this.zaitaku_nyushoSogoRiyoTaisei_umu = zaitaku_nyushoSogoRiyoTaisei_umu;
    }

    /**
     * ターミナルケア体制（看取り介護体制）の有無のgetメソッドです。
     *
     * @return ターミナルケア体制（看取り介護体制）の有無
     */
    @CheckForNull
    public Code getTerminalCareTaisei_umu() {
        return terminalCareTaisei_umu;
    }

    /**
     * ターミナルケア体制（看取り介護体制）の有無のsetメソッドです。
     *
     * @param terminalCareTaisei_umu ターミナルケア体制（看取り介護体制）の有無
     */
    public void setTerminalCareTaisei_umu(Code terminalCareTaisei_umu) {
        this.terminalCareTaisei_umu = terminalCareTaisei_umu;
    }

    /**
     * 身体拘束廃止取組の有無のgetメソッドです。
     *
     * @return 身体拘束廃止取組の有無
     */
    @CheckForNull
    public Code getShintaiKosokuHaishiTorikumi_umu() {
        return shintaiKosokuHaishiTorikumi_umu;
    }

    /**
     * 身体拘束廃止取組の有無のsetメソッドです。
     *
     * @param shintaiKosokuHaishiTorikumi_umu 身体拘束廃止取組の有無
     */
    public void setShintaiKosokuHaishiTorikumi_umu(Code shintaiKosokuHaishiTorikumi_umu) {
        this.shintaiKosokuHaishiTorikumi_umu = shintaiKosokuHaishiTorikumi_umu;
    }

    /**
     * 小規模拠点集合体制の有無のgetメソッドです。
     *
     * @return 小規模拠点集合体制の有無
     */
    @CheckForNull
    public Code getShokiboKyotenShugoTaisei_umu() {
        return shokiboKyotenShugoTaisei_umu;
    }

    /**
     * 小規模拠点集合体制の有無のsetメソッドです。
     *
     * @param shokiboKyotenShugoTaisei_umu 小規模拠点集合体制の有無
     */
    public void setShokiboKyotenShugoTaisei_umu(Code shokiboKyotenShugoTaisei_umu) {
        this.shokiboKyotenShugoTaisei_umu = shokiboKyotenShugoTaisei_umu;
    }

    /**
     * 認知症ケア加算の有無のgetメソッドです。
     *
     * @return 認知症ケア加算の有無
     */
    @CheckForNull
    public Code getNinchishoCareKasan_umu() {
        return ninchishoCareKasan_umu;
    }

    /**
     * 認知症ケア加算の有無のsetメソッドです。
     *
     * @param ninchishoCareKasan_umu 認知症ケア加算の有無
     */
    public void setNinchishoCareKasan_umu(Code ninchishoCareKasan_umu) {
        this.ninchishoCareKasan_umu = ninchishoCareKasan_umu;
    }

    /**
     * 個別機能訓練体制の有無のgetメソッドです。
     *
     * @return 個別機能訓練体制の有無
     */
    @CheckForNull
    public Code getKobetsuKinoKunrenTaisei_umu() {
        return kobetsuKinoKunrenTaisei_umu;
    }

    /**
     * 個別機能訓練体制の有無のsetメソッドです。
     *
     * @param kobetsuKinoKunrenTaisei_umu 個別機能訓練体制の有無
     */
    public void setKobetsuKinoKunrenTaisei_umu(Code kobetsuKinoKunrenTaisei_umu) {
        this.kobetsuKinoKunrenTaisei_umu = kobetsuKinoKunrenTaisei_umu;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅰ）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（理学療法Ⅰ）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅰ）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu 個別リハビリテーション提供体制（理学療法Ⅰ）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(Code kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu = kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無2のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（理学療法Ⅱ）の有無2
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2() {
        return kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無2のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無2
     */
    public void setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(Code kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2) {
        this.kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2 = kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2;
    }

    /**
     * 個別リハビリテーション提供体制（作業療法）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（作業療法）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu() {
        return kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
    }

    /**
     * 個別リハビリテーション提供体制（作業療法）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_SagyoRyoho_umu 個別リハビリテーション提供体制（作業療法）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(Code kobetsuRehaTeikyoTaisei_SagyoRyoho_umu) {
        this.kobetsuRehaTeikyoTaisei_SagyoRyoho_umu = kobetsuRehaTeikyoTaisei_SagyoRyoho_umu;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（言語聴覚療法）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu() {
        return kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
     * 個別リハビリテーション提供体制（言語聴覚療法）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(Code kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu) {
        this.kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu = kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu;
    }

    /**
     * 個別リハビリテーション提供体制（その他）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（その他）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_Sonota_umu() {
        return kobetsuRehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * 個別リハビリテーション提供体制（その他）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_Sonota_umu 個別リハビリテーション提供体制（その他）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_Sonota_umu(Code kobetsuRehaTeikyoTaisei_Sonota_umu) {
        this.kobetsuRehaTeikyoTaisei_Sonota_umu = kobetsuRehaTeikyoTaisei_Sonota_umu;
    }

    /**
     * 設備基準のgetメソッドです。
     *
     * @return 設備基準
     */
    @CheckForNull
    public Code getSetsubiKijun() {
        return setsubiKijun;
    }

    /**
     * 設備基準のsetメソッドです。
     *
     * @param setsubiKijun 設備基準
     */
    public void setSetsubiKijun(Code setsubiKijun) {
        this.setsubiKijun = setsubiKijun;
    }

    /**
     * 療養体制維持特別加算のgetメソッドです。
     *
     * @return 療養体制維持特別加算
     */
    @CheckForNull
    public Code getRyoyoTaiseiIjiTokubetsuKasan() {
        return ryoyoTaiseiIjiTokubetsuKasan;
    }

    /**
     * 療養体制維持特別加算のsetメソッドです。
     *
     * @param ryoyoTaiseiIjiTokubetsuKasan 療養体制維持特別加算
     */
    public void setRyoyoTaiseiIjiTokubetsuKasan(Code ryoyoTaiseiIjiTokubetsuKasan) {
        this.ryoyoTaiseiIjiTokubetsuKasan = ryoyoTaiseiIjiTokubetsuKasan;
    }

    /**
     * 個別リハビリテーション提供体制（リハビリテーション指導管理）の有無のgetメソッドです。
     *
     * @return 個別リハビリテーション提供体制（リハビリテーション指導管理）の有無
     */
    @CheckForNull
    public Code getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu() {
        return kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
    }

    /**
     * 個別リハビリテーション提供体制（リハビリテーション指導管理）の有無のsetメソッドです。
     *
     * @param kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
     * 個別リハビリテーション提供体制（リハビリテーション指導管理）の有無
     */
    public void setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(Code kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu) {
        this.kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu = kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu;
    }

    /**
     * ３級ヘルパー体制のgetメソッドです。
     *
     * @return ３級ヘルパー体制
     */
    @CheckForNull
    public Code getSankyuHelperTaisei() {
        return sankyuHelperTaisei;
    }

    /**
     * ３級ヘルパー体制のsetメソッドです。
     *
     * @param sankyuHelperTaisei ３級ヘルパー体制
     */
    public void setSankyuHelperTaisei(Code sankyuHelperTaisei) {
        this.sankyuHelperTaisei = sankyuHelperTaisei;
    }

    /**
     * 中山間地域等における小規模事業所加算（地域に関する状況）のgetメソッドです。
     *
     * @return 中山間地域等における小規模事業所加算（地域に関する状況）
     */
    @CheckForNull
    public Code getChuSankanChiikiShokiboJigyoshoKasan_chiiki() {
        return chuSankanChiikiShokiboJigyoshoKasan_chiiki;
    }

    /**
     * 中山間地域等における小規模事業所加算（地域に関する状況）のsetメソッドです。
     *
     * @param chuSankanChiikiShokiboJigyoshoKasan_chiiki
     * 中山間地域等における小規模事業所加算（地域に関する状況）
     */
    public void setChuSankanChiikiShokiboJigyoshoKasan_chiiki(Code chuSankanChiikiShokiboJigyoshoKasan_chiiki) {
        this.chuSankanChiikiShokiboJigyoshoKasan_chiiki = chuSankanChiikiShokiboJigyoshoKasan_chiiki;
    }

    /**
     * 中山間地域等における小規模事業所加算（規模に関する状況）のgetメソッドです。
     *
     * @return 中山間地域等における小規模事業所加算（規模に関する状況）
     */
    @CheckForNull
    public Code getChuSankanChiikiShokiboJigyoushoKasan_kibo() {
        return chuSankanChiikiShokiboJigyoushoKasan_kibo;
    }

    /**
     * 中山間地域等における小規模事業所加算（規模に関する状況）のsetメソッドです。
     *
     * @param chuSankanChiikiShokiboJigyoushoKasan_kibo
     * 中山間地域等における小規模事業所加算（規模に関する状況）
     */
    public void setChuSankanChiikiShokiboJigyoushoKasan_kibo(Code chuSankanChiikiShokiboJigyoushoKasan_kibo) {
        this.chuSankanChiikiShokiboJigyoushoKasan_kibo = chuSankanChiikiShokiboJigyoushoKasan_kibo;
    }

    /**
     * サービス提供体制強化加算のgetメソッドです。
     *
     * @return サービス提供体制強化加算
     */
    @CheckForNull
    public Code getServiceTeikyoTaiseiKyokaKasan() {
        return serviceTeikyoTaiseiKyokaKasan;
    }

    /**
     * サービス提供体制強化加算のsetメソッドです。
     *
     * @param serviceTeikyoTaiseiKyokaKasan サービス提供体制強化加算
     */
    public void setServiceTeikyoTaiseiKyokaKasan(Code serviceTeikyoTaiseiKyokaKasan) {
        this.serviceTeikyoTaiseiKyokaKasan = serviceTeikyoTaiseiKyokaKasan;
    }

    /**
     * 認知症短期集中リハビリテーション加算のgetメソッドです。
     *
     * @return 認知症短期集中リハビリテーション加算
     */
    @CheckForNull
    public Code getNinchishoTankiShuchuRehabilitationKasan() {
        return ninchishoTankiShuchuRehabilitationKasan;
    }

    /**
     * 認知症短期集中リハビリテーション加算のsetメソッドです。
     *
     * @param ninchishoTankiShuchuRehabilitationKasan 認知症短期集中リハビリテーション加算
     */
    public void setNinchishoTankiShuchuRehabilitationKasan(Code ninchishoTankiShuchuRehabilitationKasan) {
        this.ninchishoTankiShuchuRehabilitationKasan = ninchishoTankiShuchuRehabilitationKasan;
    }

    /**
     * 若年性認知症利用者（入所者・患者）受入加算のgetメソッドです。
     *
     * @return 若年性認知症利用者（入所者・患者）受入加算
     */
    @CheckForNull
    public Code getJakunenseiNinchishoRiyoushaUkeeireKasan() {
        return jakunenseiNinchishoRiyoushaUkeeireKasan;
    }

    /**
     * 若年性認知症利用者（入所者・患者）受入加算のsetメソッドです。
     *
     * @param jakunenseiNinchishoRiyoushaUkeeireKasan 若年性認知症利用者（入所者・患者）受入加算
     */
    public void setJakunenseiNinchishoRiyoushaUkeeireKasan(Code jakunenseiNinchishoRiyoushaUkeeireKasan) {
        this.jakunenseiNinchishoRiyoushaUkeeireKasan = jakunenseiNinchishoRiyoushaUkeeireKasan;
    }

    /**
     * 看護体制加算のgetメソッドです。
     *
     * @return 看護体制加算
     */
    @CheckForNull
    public Code getKangoTaiseiKasan() {
        return kangoTaiseiKasan;
    }

    /**
     * 看護体制加算のsetメソッドです。
     *
     * @param kangoTaiseiKasan 看護体制加算
     */
    public void setKangoTaiseiKasan(Code kangoTaiseiKasan) {
        this.kangoTaiseiKasan = kangoTaiseiKasan;
    }

    /**
     * 夜勤職員配置加算のgetメソッドです。
     *
     * @return 夜勤職員配置加算
     */
    @CheckForNull
    public Code getYakinShokuinHaichiKasan() {
        return yakinShokuinHaichiKasan;
    }

    /**
     * 夜勤職員配置加算のsetメソッドです。
     *
     * @param yakinShokuinHaichiKasan 夜勤職員配置加算
     */
    public void setYakinShokuinHaichiKasan(Code yakinShokuinHaichiKasan) {
        this.yakinShokuinHaichiKasan = yakinShokuinHaichiKasan;
    }

    /**
     * 療養食加算のgetメソッドです。
     *
     * @return 療養食加算
     */
    @CheckForNull
    public Code getRyoyoShokuKasan() {
        return ryoyoShokuKasan;
    }

    /**
     * 療養食加算のsetメソッドです。
     *
     * @param ryoyoShokuKasan 療養食加算
     */
    public void setRyoyoShokuKasan(Code ryoyoShokuKasan) {
        this.ryoyoShokuKasan = ryoyoShokuKasan;
    }

    /**
     * 日常生活継続支援加算のgetメソッドです。
     *
     * @return 日常生活継続支援加算
     */
    @CheckForNull
    public Code getNichijoSeikatsuKeizokuShienKasan() {
        return nichijoSeikatsuKeizokuShienKasan;
    }

    /**
     * 日常生活継続支援加算のsetメソッドです。
     *
     * @param nichijoSeikatsuKeizokuShienKasan 日常生活継続支援加算
     */
    public void setNichijoSeikatsuKeizokuShienKasan(Code nichijoSeikatsuKeizokuShienKasan) {
        this.nichijoSeikatsuKeizokuShienKasan = nichijoSeikatsuKeizokuShienKasan;
    }

    /**
     * 認知症専門ケア加算のgetメソッドです。
     *
     * @return 認知症専門ケア加算
     */
    @CheckForNull
    public Code getNinchishoSemmonCareKasan() {
        return ninchishoSemmonCareKasan;
    }

    /**
     * 認知症専門ケア加算のsetメソッドです。
     *
     * @param ninchishoSemmonCareKasan 認知症専門ケア加算
     */
    public void setNinchishoSemmonCareKasan(Code ninchishoSemmonCareKasan) {
        this.ninchishoSemmonCareKasan = ninchishoSemmonCareKasan;
    }

    /**
     * ２４時間通報対応加算のgetメソッドです。
     *
     * @return ２４時間通報対応加算
     */
    @CheckForNull
    public Code getTwentyFourHoursTsuhoTaioKasan() {
        return twentyFourHoursTsuhoTaioKasan;
    }

    /**
     * ２４時間通報対応加算のsetメソッドです。
     *
     * @param twentyFourHoursTsuhoTaioKasan ２４時間通報対応加算
     */
    public void setTwentyFourHoursTsuhoTaioKasan(Code twentyFourHoursTsuhoTaioKasan) {
        this.twentyFourHoursTsuhoTaioKasan = twentyFourHoursTsuhoTaioKasan;
    }

    /**
     * 看護職員配置加算のgetメソッドです。
     *
     * @return 看護職員配置加算
     */
    @CheckForNull
    public Code getKangoShokuinHaichiKasan() {
        return kangoShokuinHaichiKasan;
    }

    /**
     * 看護職員配置加算のsetメソッドです。
     *
     * @param kangoShokuinHaichiKasan 看護職員配置加算
     */
    public void setKangoShokuinHaichiKasan(Code kangoShokuinHaichiKasan) {
        this.kangoShokuinHaichiKasan = kangoShokuinHaichiKasan;
    }

    /**
     * 夜間ケア加算のgetメソッドです。
     *
     * @return 夜間ケア加算
     */
    @CheckForNull
    public Code getYakanCareKasan() {
        return yakanCareKasan;
    }

    /**
     * 夜間ケア加算のsetメソッドです。
     *
     * @param yakanCareKasan 夜間ケア加算
     */
    public void setYakanCareKasan(Code yakanCareKasan) {
        this.yakanCareKasan = yakanCareKasan;
    }

    /**
     * 集団コミュニケーション療法の有無のgetメソッドです。
     *
     * @return 集団コミュニケーション療法の有無
     */
    @CheckForNull
    public Code getShudanCommunicationRyoho_umu() {
        return shudanCommunicationRyoho_umu;
    }

    /**
     * 集団コミュニケーション療法の有無のsetメソッドです。
     *
     * @param shudanCommunicationRyoho_umu 集団コミュニケーション療法の有無
     */
    public void setShudanCommunicationRyoho_umu(Code shudanCommunicationRyoho_umu) {
        this.shudanCommunicationRyoho_umu = shudanCommunicationRyoho_umu;
    }

    /**
     * サービス提供体制強化加算（空床型）のgetメソッドです。
     *
     * @return サービス提供体制強化加算（空床型）
     */
    @CheckForNull
    public Code getServiceTeikyoTaiseiKyokaKasan_Karadokogata() {
        return serviceTeikyoTaiseiKyokaKasan_Karadokogata;
    }

    /**
     * サービス提供体制強化加算（空床型）のsetメソッドです。
     *
     * @param serviceTeikyoTaiseiKyokaKasan_Karadokogata サービス提供体制強化加算（空床型）
     */
    public void setServiceTeikyoTaiseiKyokaKasan_Karadokogata(Code serviceTeikyoTaiseiKyokaKasan_Karadokogata) {
        this.serviceTeikyoTaiseiKyokaKasan_Karadokogata = serviceTeikyoTaiseiKyokaKasan_Karadokogata;
    }

    /**
     * 日中の身体介護２０分未満体制の有無のgetメソッドです。
     *
     * @return 日中の身体介護２０分未満体制の有無
     */
    @CheckForNull
    public Code getNitchuShintaikaigoTaise_20funmiman_umu() {
        return nitchuShintaikaigoTaise_20funmiman_umu;
    }

    /**
     * 日中の身体介護２０分未満体制の有無のsetメソッドです。
     *
     * @param nitchuShintaikaigoTaise_20funmiman_umu 日中の身体介護２０分未満体制の有無
     */
    public void setNitchuShintaikaigoTaise_20funmiman_umu(Code nitchuShintaikaigoTaise_20funmiman_umu) {
        this.nitchuShintaikaigoTaise_20funmiman_umu = nitchuShintaikaigoTaise_20funmiman_umu;
    }

    /**
     * サービス提供責任者体制の有無のgetメソッドです。
     *
     * @return サービス提供責任者体制の有無
     */
    @CheckForNull
    public Code getServiceTeikyoSekininshaTaisei_umu() {
        return serviceTeikyoSekininshaTaisei_umu;
    }

    /**
     * サービス提供責任者体制の有無のsetメソッドです。
     *
     * @param serviceTeikyoSekininshaTaisei_umu サービス提供責任者体制の有無
     */
    public void setServiceTeikyoSekininshaTaisei_umu(Code serviceTeikyoSekininshaTaisei_umu) {
        this.serviceTeikyoSekininshaTaisei_umu = serviceTeikyoSekininshaTaisei_umu;
    }

    /**
     * 同一建物に居住する利用者の減算の有無のgetメソッドです。
     *
     * @return 同一建物に居住する利用者の減算の有無
     */
    @CheckForNull
    public Code getDoitsuTatemonoKyojuRiyoshaGenzan_umu() {
        return doitsuTatemonoKyojuRiyoshaGenzan_umu;
    }

    /**
     * 同一建物に居住する利用者の減算の有無のsetメソッドです。
     *
     * @param doitsuTatemonoKyojuRiyoshaGenzan_umu 同一建物に居住する利用者の減算の有無
     */
    public void setDoitsuTatemonoKyojuRiyoshaGenzan_umu(Code doitsuTatemonoKyojuRiyoshaGenzan_umu) {
        this.doitsuTatemonoKyojuRiyoshaGenzan_umu = doitsuTatemonoKyojuRiyoshaGenzan_umu;
    }

    /**
     * 緊急短期入所体制確保加算のgetメソッドです。
     *
     * @return 緊急短期入所体制確保加算
     */
    @CheckForNull
    public Code getKinkyuTankiNyushoTaiseiKakuhoKasan() {
        return kinkyuTankiNyushoTaiseiKakuhoKasan;
    }

    /**
     * 緊急短期入所体制確保加算のsetメソッドです。
     *
     * @param kinkyuTankiNyushoTaiseiKakuhoKasan 緊急短期入所体制確保加算
     */
    public void setKinkyuTankiNyushoTaiseiKakuhoKasan(Code kinkyuTankiNyushoTaiseiKakuhoKasan) {
        this.kinkyuTankiNyushoTaiseiKakuhoKasan = kinkyuTankiNyushoTaiseiKakuhoKasan;
    }

    /**
     * 在宅復帰・在宅療養支援機能加算のgetメソッドです。
     *
     * @return 在宅復帰・在宅療養支援機能加算
     */
    @CheckForNull
    public Code getZaitakuFukki_ZaitakuRyoyoShienKinoKasan() {
        return zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
    }

    /**
     * 在宅復帰・在宅療養支援機能加算のsetメソッドです。
     *
     * @param zaitakuFukki_ZaitakuRyoyoShienKinoKasan 在宅復帰・在宅療養支援機能加算
     */
    public void setZaitakuFukki_ZaitakuRyoyoShienKinoKasan(Code zaitakuFukki_ZaitakuRyoyoShienKinoKasan) {
        this.zaitakuFukki_ZaitakuRyoyoShienKinoKasan = zaitakuFukki_ZaitakuRyoyoShienKinoKasan;
    }

    /**
     * 生活機能向上グループ活動加算のgetメソッドです。
     *
     * @return 生活機能向上グループ活動加算
     */
    @CheckForNull
    public Code getSeikatuKinoKojoGroupKatsudoKasan() {
        return seikatuKinoKojoGroupKatsudoKasan;
    }

    /**
     * 生活機能向上グループ活動加算のsetメソッドです。
     *
     * @param seikatuKinoKojoGroupKatsudoKasan 生活機能向上グループ活動加算
     */
    public void setSeikatuKinoKojoGroupKatsudoKasan(Code seikatuKinoKojoGroupKatsudoKasan) {
        this.seikatuKinoKojoGroupKatsudoKasan = seikatuKinoKojoGroupKatsudoKasan;
    }

    /**
     * 介護職員処遇改善加算のgetメソッドです。
     *
     * @return 介護職員処遇改善加算
     */
    @CheckForNull
    public Code getKaigoShokuinShoguKaizenKasan() {
        return kaigoShokuinShoguKaizenKasan;
    }

    /**
     * 介護職員処遇改善加算のsetメソッドです。
     *
     * @param kaigoShokuinShoguKaizenKasan 介護職員処遇改善加算
     */
    public void setKaigoShokuinShoguKaizenKasan(Code kaigoShokuinShoguKaizenKasan) {
        this.kaigoShokuinShoguKaizenKasan = kaigoShokuinShoguKaizenKasan;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7063KaigoJigyoshaShiteiServiceEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7063KaigoJigyoshaShiteiServiceEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
     *
     * @param entity
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
        this.nitchuShintaikaigoTaise_20funmiman_umu = entity.nitchuShintaikaigoTaise_20funmiman_umu;
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
        return super.toMd5(jigyoshaNo, serviceShuruiCode, yukoKaishiYMD, yukoShuryoYMD, idoYMD, idoJiyu, shiteiNo, kihonJohoJunkyoKubun, jigyoKaishiYMD, jigyoKyushiYMD, jigyoSaikaiYMD, jigyoHaishiYMD, jigyoshaName, jigyoshaNameKana, jigyoshaYubinNo, jigyoshaAddress, jigyoshaAddressKana, jigyoshaTelNo, jigyoshaFaxNo, torokuHokenshaNo, juryoininUmu, torokuKaishiYMD, torokuShuryoYMD, kanrishaName, kanrishaNameKana, kanrishaYubinNo, kanrishaAddress, kanrishaAddressKana, kozaJohoJunkyoKubun, ginkoCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana, shakaiFukushihoujinKeigenjigyouJisshi_umu, seikatsuhogohouShitei_umu, shisetsunadoKubun, jininHaichiKubun, tokubetsuChiikiKasan_umu, kinkyujiHomonkaigoKasan_umu, tokubetsuKanriTaisei, kinoKunrenShidoTaisei_umu, shokujiTeikyoTaisei_umu, nyuyokuKaijoTaisei_umu, tokubetsuNyuyokuKaijoTaisei_umu, joukinsenjuIshiHaichi_umu, ishiHaichiKijun, seisinkaIshiTeikitekiRyouyousidou_umu, yakanKinmuJokenKijun, ninchishouSenmontou_umu, shokujiTeikyoJokyo, sougeiTaisei, rehaTeikyoTaisei_SogoRehaShisetsu_umu, rehaTeikyoTaisei_RigakuRyohoII_umu, rehaTeikyoTaisei_RigakuRyohoIII_umu, rehaTeikyoTaisei_SagyoRyohoII_umu, rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu, rehaTeikyoTaisei_Sonota_umu, rehabilitationKasanJokyo, ryoyoKankyoKijun, ishiKetuinGenzanJokyo_umu, kangoShokuinKetsuinGenzanJokyo_umu, rigakuRyouhousiKetsuinGenzanJokyo_umu, sagyouRyouhousiKetsuinGenzanJokyo_umu, kaigoShokuinKetsuinGenzanJokyo_umu, kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu, kaigoJujishaKetsuinGenzanJokyo_umu, kansenTaisakuSidoKanri_umu, jushoHifuKaiyouShidoKanri_umu, yakuzaiKaniriShido_umu, shogaishaSeikatsuShienTaisei_umu, chiikiKubunCode, jikanEnchoServiceTaisei, kobetsuRehabilitationTeikyoTaisei, kyojuhiTaisaku, yakanCare_umu, rehabilitationKinoKyoka_umu, kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu, kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1, kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu, kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu, kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu, kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu, gengoChokakushiKetsuinGenzanJokyo_umu, eiyouKanriHyoka, tokuteijigyoushoKasan_HomonKaigo_umu, jakunenseiNinchishoCareTaisei_umu, undokiKinoKojoTaisei_umu, eiyoManagement_KaizenTaisei_umu, kokuKinoKojoTaisei_umu, jigyoshoHyokaKasan_Moshide_umu, jigyoshoHyokaKasan_Kettei_umu, kinkyuUkeireTaisei_umu, yakanKangoTaisei_umu, tokuteijigyoshoKasan_Kyotakukaigoshien_umu, kaigoShienSemmoninSenjuJokinshaNinsu, kaigoSienSemmoninSenjuHijokinshaNinsu, kaigoSienSemmoninKemmuJokinshaNinsu, kaigoSienSemmoninKemmuHijokinshaNinsu, homonkaigoServiceTeikyoSekininshaNinsu, homonkaigoSenjuJokinshaNinsu, homonkaigoSenjuHijokinshaNinsu, homonkaigoKemmuJokinshaNinsu, homonkaigoKemmuHijokinshaNinsu, homonkaigoJokinKanzangoNinsu, riyoTeiinNinsu, shiteiYukoKaishiYMD, shiteiYukoShuryoYMD, shiteiKoshinShinseichuKubun, koryokuTeishiKaishiYMD, koryokuTeishiShuryoYMD, daikiboJigyoshaGaito_umu, junUnitCareTaisei_umu, judokaTaioTaisei_umu, iryoRenkeiTaisei_umu, unitCareTaisei_umu, zaitaku_nyushoSogoRiyoTaisei_umu, terminalCareTaisei_umu, shintaiKosokuHaishiTorikumi_umu, shokiboKyotenShugoTaisei_umu, ninchishoCareKasan_umu, kobetsuKinoKunrenTaisei_umu, kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu, kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2, kobetsuRehaTeikyoTaisei_SagyoRyoho_umu, kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu, kobetsuRehaTeikyoTaisei_Sonota_umu, setsubiKijun, ryoyoTaiseiIjiTokubetsuKasan, kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu, sankyuHelperTaisei, chuSankanChiikiShokiboJigyoshoKasan_chiiki, chuSankanChiikiShokiboJigyoushoKasan_kibo, serviceTeikyoTaiseiKyokaKasan, ninchishoTankiShuchuRehabilitationKasan, jakunenseiNinchishoRiyoushaUkeeireKasan, kangoTaiseiKasan, yakinShokuinHaichiKasan, ryoyoShokuKasan, nichijoSeikatsuKeizokuShienKasan, ninchishoSemmonCareKasan, twentyFourHoursTsuhoTaioKasan, kangoShokuinHaichiKasan, yakanCareKasan, shudanCommunicationRyoho_umu, serviceTeikyoTaiseiKyokaKasan_Karadokogata, nitchuShintaikaigoTaise_20funmiman_umu, serviceTeikyoSekininshaTaisei_umu, doitsuTatemonoKyojuRiyoshaGenzan_umu, kinkyuTankiNyushoTaiseiKakuhoKasan, zaitakuFukki_ZaitakuRyoyoShienKinoKasan, seikatuKinoKojoGroupKatsudoKasan, kaigoShokuinShoguKaizenKasan);
    }

// </editor-fold>
}
