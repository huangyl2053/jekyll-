/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
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
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護事業者指定サービスを管理するクラスです。
 */
public class KaigoJigyoshaShiteiService extends ModelBase<KaigoJigyoshaShiteiServiceIdentifier, DbT7063KaigoJigyoshaShiteiServiceEntity, KaigoJigyoshaShiteiService> implements Serializable {

    private final DbT7063KaigoJigyoshaShiteiServiceEntity entity;
    private final KaigoJigyoshaShiteiServiceIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護事業者指定サービスの新規作成時に使用します。
     *
     * @param 事業者番号 事業者番号
     * @param サービス種類コード サービス種類コード
     * @param 有効開始日 有効開始日
     */
    public KaigoJigyoshaShiteiService(KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));
        this.entity = new DbT7063KaigoJigyoshaShiteiServiceEntity();
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setYukoKaishiYMD(有効開始日);
        this.id = new KaigoJigyoshaShiteiServiceIdentifier(
                事業者番号,
                サービス種類コード,
                有効開始日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7063KaigoJigyoshaShiteiServiceEntity}より{@link KaigoJigyoshaShiteiService}を生成します。
     *
     * @param entity DBより取得した{@link DbT7063KaigoJigyoshaShiteiServiceEntity}
     */
    public KaigoJigyoshaShiteiService(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者指定サービス"));
        this.id = new KaigoJigyoshaShiteiServiceIdentifier(
                entity.getJigyoshaNo(),
                entity.getServiceShuruiCode(),
                entity.getYukoKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7063KaigoJigyoshaShiteiServiceEntity}
     * @param id {@link KaigoJigyoshaShiteiServiceIdentifier}
     */
    KaigoJigyoshaShiteiService(
            DbT7063KaigoJigyoshaShiteiServiceEntity entity,
            KaigoJigyoshaShiteiServiceIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public KaigoServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了日を返します。
     *
     * @return 有効終了日
     */
    public FlexibleDate get有効終了日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    public RString get異動事由() {
        return entity.getIdoJiyu();
    }

    /**
     * 指定番号を返します。
     *
     * @return 指定番号
     */
    public RString get指定番号() {
        return entity.getShiteiNo();
    }

    /**
     * 基本情報準拠区分を返します。
     *
     * @return 基本情報準拠区分
     */
    public RString get基本情報準拠区分() {
        return entity.getKihonJohoJunkyoKubun().getColumnValue();
    }

    /**
     * 事業開始日を返します。
     *
     * @return 事業開始日
     */
    public FlexibleDate get事業開始日() {
        return entity.getJigyoKaishiYMD();
    }

    /**
     * 事業休止日を返します。
     *
     * @return 事業休止日
     */
    public FlexibleDate get事業休止日() {
        return entity.getJigyoKyushiYMD();
    }

    /**
     * 事業再開日を返します。
     *
     * @return 事業再開日
     */
    public FlexibleDate get事業再開日() {
        return entity.getJigyoSaikaiYMD();
    }

    /**
     * 事業廃止日を返します。
     *
     * @return 事業廃止日
     */
    public FlexibleDate get事業廃止日() {
        return entity.getJigyoHaishiYMD();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaName();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho get事業者名称カナ() {
        return entity.getJigyoshaNameKana();
    }

    /**
     * 事業者郵便番号を返します。
     *
     * @return 事業者郵便番号
     */
    public YubinNo get事業者郵便番号() {
        return entity.getJigyoshaYubinNo();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public AtenaJusho get事業者住所() {
        return entity.getJigyoshaAddress();
    }

    /**
     * 事業者住所カナを返します。
     *
     * @return 事業者住所カナ
     */
    public RString get事業者住所カナ() {
        return entity.getJigyoshaAddressKana();
    }

    /**
     * 事業者電話番号を返します。
     *
     * @return 事業者電話番号
     */
    public TelNo get事業者電話番号() {
        return entity.getJigyoshaTelNo();
    }

    /**
     * 事業者FAX番号を返します。
     *
     * @return 事業者FAX番号
     */
    public TelNo get事業者FAX番号() {
        return entity.getJigyoshaFaxNo();
    }

    /**
     * 登録保険者番号を返します。
     *
     * @return 登録保険者番号
     */
    public RString get登録保険者番号() {
        return entity.getTorokuHokenshaNo();
    }

    /**
     * 受領委任の有無を返します。
     *
     * @return 受領委任の有無
     */
    public Code get受領委任の有無() {
        return entity.getJuryoininUmu().value();
    }

    /**
     * 登録開始日を返します。
     *
     * @return 登録開始日
     */
    public FlexibleDate get登録開始日() {
        return entity.getTorokuKaishiYMD();
    }

    /**
     * 登録終了日を返します。
     *
     * @return 登録終了日
     */
    public FlexibleDate get登録終了日() {
        return entity.getTorokuShuryoYMD();
    }

    /**
     * 管理者氏名を返します。
     *
     * @return 管理者氏名
     */
    public AtenaMeisho get管理者氏名() {
        return entity.getKanrishaName();
    }

    /**
     * 管理者氏名カナを返します。
     *
     * @return 管理者氏名カナ
     */
    public AtenaKanaMeisho get管理者氏名カナ() {
        return entity.getKanrishaNameKana();
    }

    /**
     * 管理者住所郵便番号を返します。
     *
     * @return 管理者住所郵便番号
     */
    public YubinNo get管理者住所郵便番号() {
        return entity.getKanrishaYubinNo();
    }

    /**
     * 管理者住所を返します。
     *
     * @return 管理者住所
     */
    public AtenaJusho get管理者住所() {
        return entity.getKanrishaAddress();
    }

    /**
     * 管理者住所カナを返します。
     *
     * @return 管理者住所カナ
     */
    public RString get管理者住所カナ() {
        return entity.getKanrishaAddressKana();
    }

    /**
     * 口座情報準拠区分を返します。
     *
     * @return 口座情報準拠区分
     */
    public RString get口座情報準拠区分() {
        return entity.getKozaJohoJunkyoKubun().getColumnValue();
    }

    /**
     * 銀行コードを返します。
     *
     * @return 銀行コード
     */
    public KinyuKikanCode get銀行コード() {
        return entity.getGinkoCode();
    }

    /**
     * 支店コードを返します。
     *
     * @return 支店コード
     */
    public KinyuKikanShitenCode get支店コード() {
        return entity.getShitenCode();
    }

    /**
     * 口座種別を返します。
     *
     * @return 口座種別
     */
    public Code get口座種別() {
        return new Code(entity.getKozaShubetsu());
    }

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return entity.getKozaNo();
    }

    /**
     * 口座名義人を返します。
     *
     * @return 口座名義人
     */
    public AtenaMeisho get口座名義人() {
        return entity.getKozaMeiginin();
    }

    /**
     * 口座名義人カナを返します。
     *
     * @return 口座名義人カナ
     */
    public AtenaKanaMeisho get口座名義人カナ() {
        return entity.getKozaMeigininKana();
    }

    /**
     * 社会福祉法人軽減事業実施の有無を返します。
     *
     * @return 社会福祉法人軽減事業実施の有無
     */
    public Code get社会福祉法人軽減事業実施の有無() {
        return entity.getShakaiFukushihoujinKeigenjigyouJisshi_umu().value();
    }

    /**
     * 生活保護法による指定の有無を返します。
     *
     * @return 生活保護法による指定の有無
     */
    public Code get生活保護法による指定の有無() {
        return entity.getSeikatsuhogohouShitei_umu().value();
    }

    /**
     * 施設等の区分を返します。
     *
     * @return 施設等の区分
     */
    public Code get施設等の区分() {
        return entity.getShisetsunadoKubun();
    }

    /**
     * 人員配置区分を返します。
     *
     * @return 人員配置区分
     */
    public Code get人員配置区分() {
        return entity.getJininHaichiKubun();
    }

    /**
     * 特別地域加算の有無を返します。
     *
     * @return 特別地域加算の有無
     */
    public Code get特別地域加算の有無() {
        return entity.getTokubetsuChiikiKasan_umu().value();
    }

    /**
     * 緊急時訪問介護加算の有無を返します。
     *
     * @return 緊急時訪問介護加算の有無
     */
    public Code get緊急時訪問介護加算の有無() {
        return entity.getKinkyujiHomonkaigoKasan_umu().value();
    }

    /**
     * 特別管理体制を返します。
     *
     * @return 特別管理体制
     */
    public Code get特別管理体制() {
        return entity.getTokubetsuKanriTaisei().value();
    }

    /**
     * 機能訓練指導体制の有無を返します。
     *
     * @return 機能訓練指導体制の有無
     */
    public Code get機能訓練指導体制の有無() {
        return entity.getKinoKunrenShidoTaisei_umu().value();
    }

    /**
     * 食事提供体制の有無を返します。
     *
     * @return 食事提供体制の有無
     */
    public Code get食事提供体制の有無() {
        return entity.getShokujiTeikyoTaisei_umu().value();
    }

    /**
     * 入浴介助体制の有無を返します。
     *
     * @return 入浴介助体制の有無
     */
    public Code get入浴介助体制の有無() {
        return entity.getNyuyokuKaijoTaisei_umu().value();
    }

    /**
     * 特別入浴介助体制の有無を返します。
     *
     * @return 特別入浴介助体制の有無
     */
    public Code get特別入浴介助体制の有無() {
        return entity.getTokubetsuNyuyokuKaijoTaisei_umu().value();
    }

    /**
     * 常勤専従医師配置の有無を返します。
     *
     * @return 常勤専従医師配置の有無
     */
    public Code get常勤専従医師配置の有無() {
        return entity.getJoukinsenjuIshiHaichi_umu().value();
    }

    /**
     * 医師の配置基準を返します。
     *
     * @return 医師の配置基準
     */
    public Code get医師の配置基準() {
        return entity.getIshiHaichiKijun().value();
    }

    /**
     * 精神科医師定期的療養指導の有無を返します。
     *
     * @return 精神科医師定期的療養指導の有無
     */
    public Code get精神科医師定期的療養指導の有無() {
        return entity.getSeisinkaIshiTeikitekiRyouyousidou_umu().value();
    }

    /**
     * 夜間勤務条件基準を返します。
     *
     * @return 夜間勤務条件基準
     */
    public Code get夜間勤務条件基準() {
        return entity.getYakanKinmuJokenKijun();
    }

    /**
     * 認知症専門棟の有無を返します。
     *
     * @return 認知症専門棟の有無
     */
    public Code get認知症専門棟の有無() {
        return entity.getNinchishouSenmontou_umu().value();
    }

    /**
     * 食事提供の状況を返します。
     *
     * @return 食事提供の状況
     */
    public Code get食事提供の状況() {
        return entity.getShokujiTeikyoJokyo().value();
    }

    /**
     * 送迎体制を返します。
     *
     * @return 送迎体制
     */
    public Code get送迎体制() {
        return entity.getSougeiTaisei().value();
    }

    /**
     * リハビリテーション提供体制_総合リハビリテーション施設_の有無を返します。
     *
     * @return リハビリテーション提供体制_総合リハビリテーション施設_の有無
     */
    public Code getリハビリテーション提供体制_総合リハビリテーション施設_の有無() {
        return entity.getRehaTeikyoTaisei_SogoRehaShisetsu_umu().value();
    }

    /**
     * リハビリテーション提供体制_理学療法Ⅱ_の有無を返します。
     *
     * @return リハビリテーション提供体制_理学療法Ⅱ_の有無
     */
    public Code getリハビリテーション提供体制_理学療法Ⅱ_の有無() {
        return entity.getRehaTeikyoTaisei_RigakuRyohoII_umu().value();
    }

    /**
     * リハビリテーション提供体制_理学療法Ⅲ_の有無を返します。
     *
     * @return リハビリテーション提供体制_理学療法Ⅲ_の有無
     */
    public Code getリハビリテーション提供体制_理学療法Ⅲ_の有無() {
        return entity.getRehaTeikyoTaisei_RigakuRyohoIII_umu().value();
    }

    /**
     * リハビリテーション提供体制_作業療法Ⅱ_の有無を返します。
     *
     * @return リハビリテーション提供体制_作業療法Ⅱ_の有無
     */
    public Code getリハビリテーション提供体制_作業療法Ⅱ_の有無() {
        return entity.getRehaTeikyoTaisei_SagyoRyohoII_umu().value();
    }

    /**
     * リハビリテーション提供体制_精神科作業療法_の有無を返します。
     *
     * @return リハビリテーション提供体制_精神科作業療法_の有無
     */
    public Code getリハビリテーション提供体制_精神科作業療法_の有無() {
        return entity.getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu().value();
    }

    /**
     * リハビリテーション提供体制_その他_の有無を返します。
     *
     * @return リハビリテーション提供体制_その他_の有無
     */
    public Code getリハビリテーション提供体制_その他_の有無() {
        return entity.getRehaTeikyoTaisei_Sonota_umu().value();
    }

    /**
     * リハビリテーションの加算状況の有無を返します。
     *
     * @return リハビリテーションの加算状況の有無
     */
    public Code getリハビリテーションの加算状況の有無() {
        return entity.getRehabilitationKasanJokyo().value();
    }

    /**
     * 療養環境基準を返します。
     *
     * @return 療養環境基準
     */
    public Code get療養環境基準() {
        return entity.getRyoyoKankyoKijun();
    }

    /**
     * 医師の欠員による減算の状況の有無を返します。
     *
     * @return 医師の欠員による減算の状況の有無
     */
    public Code get医師の欠員による減算の状況の有無() {
        return entity.getIshiKetuinGenzanJokyo_umu().value();
    }

    /**
     * 看護職員の欠員による減算の状況の有無を返します。
     *
     * @return 看護職員の欠員による減算の状況の有無
     */
    public Code get看護職員の欠員による減算の状況の有無() {
        return entity.getKangoShokuinKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 理学療法士の欠員による減算の状況の有無を返します。
     *
     * @return 理学療法士の欠員による減算の状況の有無
     */
    public Code get理学療法士の欠員による減算の状況の有無() {
        return entity.getRigakuRyouhousiKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 作業療法士の欠員による減算の状況の有無を返します。
     *
     * @return 作業療法士の欠員による減算の状況の有無
     */
    public Code get作業療法士の欠員による減算の状況の有無() {
        return entity.getSagyouRyouhousiKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 介護職員の欠員による減算の状況の有無を返します。
     *
     * @return 介護職員の欠員による減算の状況の有無
     */
    public Code get介護職員の欠員による減算の状況の有無() {
        return entity.getKaigoShokuinKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 介護支援専門員の欠員による減算の状況の有無を返します。
     *
     * @return 介護支援専門員の欠員による減算の状況の有無
     */
    public Code get介護支援専門員の欠員による減算の状況の有無() {
        return entity.getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 介護従業者の欠員による減算の状況の有無を返します。
     *
     * @return 介護従業者の欠員による減算の状況の有無
     */
    public Code get介護従業者の欠員による減算の状況の有無() {
        return entity.getKaigoJujishaKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 感染対策指導管理の有無を返します。
     *
     * @return 感染対策指導管理の有無
     */
    public Code get感染対策指導管理の有無() {
        return entity.getKansenTaisakuSidoKanri_umu().value();
    }

    /**
     * 重症皮膚潰瘍指導管理の有無を返します。
     *
     * @return 重症皮膚潰瘍指導管理の有無
     */
    public Code get重症皮膚潰瘍指導管理の有無() {
        return entity.getJushoHifuKaiyouShidoKanri_umu().value();
    }

    /**
     * 薬剤管理指導の有無を返します。
     *
     * @return 薬剤管理指導の有無
     */
    public Code get薬剤管理指導の有無() {
        return entity.getYakuzaiKaniriShido_umu().value();
    }

    /**
     * 障害者生活支援体制の有無を返します。
     *
     * @return 障害者生活支援体制の有無
     */
    public Code get障害者生活支援体制の有無() {
        return entity.getShogaishaSeikatsuShienTaisei_umu().value();
    }

    /**
     * 地域区分コードを返します。
     *
     * @return 地域区分コード
     */
    public Code get地域区分コード() {
        return entity.getChiikiKubunCode().value();
    }

    /**
     * 時間延長サービス体制を返します。
     *
     * @return 時間延長サービス体制
     */
    public Code get時間延長サービス体制() {
        return entity.getJikanEnchoServiceTaisei().value();
    }

    /**
     * 個別リハビリテーション提供体制を返します。
     *
     * @return 個別リハビリテーション提供体制
     */
    public Code get個別リハビリテーション提供体制() {
        return entity.getKobetsuRehabilitationTeikyoTaisei().value();
    }

    /**
     * 居住費対策を返します。
     *
     * @return 居住費対策
     */
    public Code get居住費対策() {
        return entity.getKyojuhiTaisaku().value();
    }

    /**
     * 夜間ケアの有無を返します。
     *
     * @return 夜間ケアの有無
     */
    public Code get夜間ケアの有無() {
        return entity.getYakanCare_umu().value();
    }

    /**
     * リハビリテーション機能強化の有無を返します。
     *
     * @return リハビリテーション機能強化の有無
     */
    public Code getリハビリテーション機能強化の有無() {
        return entity.getRehabilitationKinoKyoka_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_総合リハビリテーション施設_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_総合リハビリテーション施設_の有無
     */
    public Code get個別リハビリテーション提供体制_総合リハビリテーション施設_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_理学療法Ⅱ_の有無1を返します。
     *
     * @return 個別リハビリテーション提供体制_理学療法Ⅱ_の有無1
     */
    public Code get個別リハビリテーション提供体制_理学療法Ⅱ_の有無1() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1().value();
    }

    /**
     * 個別リハビリテーション提供体制_理学療法Ⅲ_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_理学療法Ⅲ_の有無
     */
    public Code get個別リハビリテーション提供体制_理学療法Ⅲ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_作業療法Ⅱ_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_作業療法Ⅱ_の有無
     */
    public Code get個別リハビリテーション提供体制_作業療法Ⅱ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無
     */
    public Code get個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無
     */
    public Code get個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu().value();
    }

    /**
     * 言語聴覚士の欠員による減算の状況の有無を返します。
     *
     * @return 言語聴覚士の欠員による減算の状況の有無
     */
    public Code get言語聴覚士の欠員による減算の状況の有無() {
        return entity.getGengoChokakushiKetsuinGenzanJokyo_umu().value();
    }

    /**
     * 栄養管理の評価を返します。
     *
     * @return 栄養管理の評価
     */
    public Code get栄養管理の評価() {
        return entity.getEiyouKanriHyoka().value();
    }

    /**
     * 特定事業所加算_訪問介護_の有無を返します。
     *
     * @return 特定事業所加算_訪問介護_の有無
     */
    public Code get特定事業所加算_訪問介護_の有無() {
        return entity.getTokuteijigyoushoKasan_HomonKaigo_umu().value();
    }

    /**
     * 若年性認知症ケア体制の有無を返します。
     *
     * @return 若年性認知症ケア体制の有無
     */
    public Code get若年性認知症ケア体制の有無() {
        return entity.getJakunenseiNinchishoCareTaisei_umu().value();
    }

    /**
     * 運動器機能向上体制の有無を返します。
     *
     * @return 運動器機能向上体制の有無
     */
    public Code get運動器機能向上体制の有無() {
        return entity.getUndokiKinoKojoTaisei_umu().value();
    }

    /**
     * 栄養マネジメント_改善_体制の有無を返します。
     *
     * @return 栄養マネジメント_改善_体制の有無
     */
    public Code get栄養マネジメント_改善_体制の有無() {
        return entity.getEiyoManagement_KaizenTaisei_umu().value();
    }

    /**
     * 口腔機能向上体制の有無を返します。
     *
     * @return 口腔機能向上体制の有無
     */
    public Code get口腔機能向上体制の有無() {
        return entity.getKokuKinoKojoTaisei_umu().value();
    }

    /**
     * 事業所評価加算_申出_の有無を返します。
     *
     * @return 事業所評価加算_申出_の有無
     */
    public Code get事業所評価加算_申出_の有無() {
        return entity.getJigyoshoHyokaKasan_Moshide_umu().value();
    }

    /**
     * 事業所評価加算_決定_の有無を返します。
     *
     * @return 事業所評価加算_決定_の有無
     */
    public Code get事業所評価加算_決定_の有無() {
        return entity.getJigyoshoHyokaKasan_Kettei_umu().value();
    }

    /**
     * 緊急受入体制の有無を返します。
     *
     * @return 緊急受入体制の有無
     */
    public Code get緊急受入体制の有無() {
        return entity.getKinkyuUkeireTaisei_umu().value();
    }

    /**
     * 夜間看護体制の有無を返します。
     *
     * @return 夜間看護体制の有無
     */
    public Code get夜間看護体制の有無() {
        return entity.getYakanKangoTaisei_umu().value();
    }

    /**
     * 特定事業所加算_居宅介護支援_の有無を返します。
     *
     * @return 特定事業所加算_居宅介護支援_の有無
     */
    public Code get特定事業所加算_居宅介護支援_の有無() {
        return entity.getTokuteijigyoshoKasan_Kyotakukaigoshien_umu();
    }

    /**
     * 介護支援専門員数_専従の常勤者_を返します。
     *
     * @return 介護支援専門員数_専従の常勤者_
     */
    public Decimal get介護支援専門員数_専従の常勤者_() {
        return entity.getKaigoShienSemmoninSenjuJokinshaNinsu();
    }

    /**
     * 介護支援専門員数_専従の非常勤者_を返します。
     *
     * @return 介護支援専門員数_専従の非常勤者_
     */
    public Decimal get介護支援専門員数_専従の非常勤者_() {
        return entity.getKaigoSienSemmoninSenjuHijokinshaNinsu();
    }

    /**
     * 介護支援専門員数_兼務の常勤者_を返します。
     *
     * @return 介護支援専門員数_兼務の常勤者_
     */
    public Decimal get介護支援専門員数_兼務の常勤者_() {
        return entity.getKaigoSienSemmoninKemmuJokinshaNinsu();
    }

    /**
     * 介護支援専門員数_兼務の非常勤者_を返します。
     *
     * @return 介護支援専門員数_兼務の非常勤者_
     */
    public Decimal get介護支援専門員数_兼務の非常勤者_() {
        return entity.getKaigoSienSemmoninKemmuHijokinshaNinsu();
    }

    /**
     * 訪問介護サービス提供責任者数を返します。
     *
     * @return 訪問介護サービス提供責任者数
     */
    public Decimal get訪問介護サービス提供責任者数() {
        return entity.getHomonkaigoServiceTeikyoSekininshaNinsu();
    }

    /**
     * 訪問介護員数_専従の常勤者_を返します。
     *
     * @return 訪問介護員数_専従の常勤者_
     */
    public Decimal get訪問介護員数_専従の常勤者_() {
        return entity.getHomonkaigoSenjuJokinshaNinsu();
    }

    /**
     * 訪問介護員数_専従の非常勤者_を返します。
     *
     * @return 訪問介護員数_専従の非常勤者_
     */
    public Decimal get訪問介護員数_専従の非常勤者_() {
        return entity.getHomonkaigoSenjuHijokinshaNinsu();
    }

    /**
     * 訪問介護員数_兼務の常勤者_を返します。
     *
     * @return 訪問介護員数_兼務の常勤者_
     */
    public Decimal get訪問介護員数_兼務の常勤者_() {
        return entity.getHomonkaigoKemmuJokinshaNinsu();
    }

    /**
     * 訪問介護員数_兼務の非常勤者_を返します。
     *
     * @return 訪問介護員数_兼務の非常勤者_
     */
    public Decimal get訪問介護員数_兼務の非常勤者_() {
        return entity.getHomonkaigoKemmuHijokinshaNinsu();
    }

    /**
     * 訪問介護員数_常勤換算後の人数_を返します。
     *
     * @return 訪問介護員数_常勤換算後の人数_
     */
    public Decimal get訪問介護員数_常勤換算後の人数_() {
        return entity.getHomonkaigoJokinKanzangoNinsu();
    }

    /**
     * 利用定員数を返します。
     *
     * @return 利用定員数
     */
    public Decimal get利用定員数() {
        return entity.getRiyoTeiinNinsu();
    }

    /**
     * 指定有効開始日を返します。
     *
     * @return 指定有効開始日
     */
    public FlexibleDate get指定有効開始日() {
        return entity.getShiteiYukoKaishiYMD();
    }

    /**
     * 指定有効終了日を返します。
     *
     * @return 指定有効終了日
     */
    public FlexibleDate get指定有効終了日() {
        return entity.getShiteiYukoShuryoYMD();
    }

    /**
     * 指定更新申請中区分を返します。
     *
     * @return 指定更新申請中区分
     */
    public Code get指定更新申請中区分() {
        return entity.getShiteiKoshinShinseichuKubun().value();
    }

    /**
     * 効力停止開始日を返します。
     *
     * @return 効力停止開始日
     */
    public FlexibleDate get効力停止開始日() {
        return entity.getKoryokuTeishiKaishiYMD();
    }

    /**
     * 効力停止終了日を返します。
     *
     * @return 効力停止終了日
     */
    public FlexibleDate get効力停止終了日() {
        return entity.getKoryokuTeishiShuryoYMD();
    }

    /**
     * 大規模事業所該当の有無を返します。
     *
     * @return 大規模事業所該当の有無
     */
    public Code get大規模事業所該当の有無() {
        return entity.getDaikiboJigyoshaGaito_umu().value();
    }

    /**
     * 準ユニットケア体制の有無を返します。
     *
     * @return 準ユニットケア体制の有無
     */
    public Code get準ユニットケア体制の有無() {
        return entity.getJunUnitCareTaisei_umu().value();
    }

    /**
     * 重度化対応体制の有無を返します。
     *
     * @return 重度化対応体制の有無
     */
    public Code get重度化対応体制の有無() {
        return entity.getJudokaTaioTaisei_umu().value();
    }

    /**
     * 医療連携体制の有無を返します。
     *
     * @return 医療連携体制の有無
     */
    public Code get医療連携体制の有無() {
        return entity.getIryoRenkeiTaisei_umu().value();
    }

    /**
     * ユニットケア体制の有無を返します。
     *
     * @return ユニットケア体制の有無
     */
    public Code getユニットケア体制の有無() {
        return entity.getUnitCareTaisei_umu().value();
    }

    /**
     * 在宅_入所相互利用体制の有無を返します。
     *
     * @return 在宅_入所相互利用体制の有無
     */
    public Code get在宅_入所相互利用体制の有無() {
        return entity.getZaitaku_nyushoSogoRiyoTaisei_umu().value();
    }

    /**
     * ターミナルケア体制_看取り介護体制_の有無を返します。
     *
     * @return ターミナルケア体制_看取り介護体制_の有無
     */
    public Code getターミナルケア体制_看取り介護体制_の有無() {
        return entity.getTerminalCareTaisei_umu().value();
    }

    /**
     * 身体拘束廃止取組の有無を返します。
     *
     * @return 身体拘束廃止取組の有無
     */
    public Code get身体拘束廃止取組の有無() {
        return entity.getNitchuShintaikaigoTaise_20funmiman_umu().value();
    }

    /**
     * 小規模拠点集合体制の有無を返します。
     *
     * @return 小規模拠点集合体制の有無
     */
    public Code get小規模拠点集合体制の有無() {
        return entity.getShokiboKyotenShugoTaisei_umu().value();
    }

    /**
     * 認知症ケア加算の有無を返します。
     *
     * @return 認知症ケア加算の有無
     */
    public Code get認知症ケア加算の有無() {
        return entity.getNinchishoCareKasan_umu().value();
    }

    /**
     * 個別機能訓練体制の有無を返します。
     *
     * @return 個別機能訓練体制の有無
     */
    public Code get個別機能訓練体制の有無() {
        return entity.getKobetsuKinoKunrenTaisei_umu();
    }

    /**
     * 個別リハビリテーション提供体制_理学療法Ⅰ_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_理学療法Ⅰ_の有無
     */
    public Code get個別リハビリテーション提供体制_理学療法Ⅰ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_理学療法Ⅱ_の有無2を返します。
     *
     * @return 個別リハビリテーション提供体制_理学療法Ⅱ_の有無2
     */
    public Code get個別リハビリテーション提供体制_理学療法Ⅱ_の有無2() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2().value();
    }

    /**
     * 個別リハビリテーション提供体制_作業療法_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_作業療法_の有無
     */
    public Code get個別リハビリテーション提供体制_作業療法_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_言語聴覚療法_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_言語聴覚療法_の有無
     */
    public Code get個別リハビリテーション提供体制_言語聴覚療法_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu().value();
    }

    /**
     * 個別リハビリテーション提供体制_その他_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_その他_の有無
     */
    public Code get個別リハビリテーション提供体制_その他_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_Sonota_umu().value();
    }

    /**
     * 設備基準を返します。
     *
     * @return 設備基準
     */
    public Code get設備基準() {
        return entity.getSetsubiKijun().value();
    }

    /**
     * 療養体制維持特別加算を返します。
     *
     * @return 療養体制維持特別加算
     */
    public Code get療養体制維持特別加算() {
        return entity.getRyoyoTaiseiIjiTokubetsuKasan().value();
    }

    /**
     * 個別リハビリテーション提供体制_リハビリテーション指導管理_の有無を返します。
     *
     * @return 個別リハビリテーション提供体制_リハビリテーション指導管理_の有無
     */
    public Code get個別リハビリテーション提供体制_リハビリテーション指導管理_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu().value();
    }

    /**
     * ３級ヘルパー体制を返します。
     *
     * @return ３級ヘルパー体制
     */
    public Code get３級ヘルパー体制() {
        return entity.getSankyuHelperTaisei().value();
    }

    /**
     * 中山間地域等における小規模事業所加算_地域に関する状況_を返します。
     *
     * @return 中山間地域等における小規模事業所加算_地域に関する状況_
     */
    public Code get中山間地域等における小規模事業所加算_地域に関する状況_() {
        return entity.getChuSankanChiikiShokiboJigyoshoKasan_chiiki().value();
    }

    /**
     * 中山間地域等における小規模事業所加算_規模に関する状況_を返します。
     *
     * @return 中山間地域等における小規模事業所加算_規模に関する状況_
     */
    public Code get中山間地域等における小規模事業所加算_規模に関する状況_() {
        return entity.getChuSankanChiikiShokiboJigyoushoKasan_kibo().value();
    }

    /**
     * サービス提供体制強化加算を返します。
     *
     * @return サービス提供体制強化加算
     */
    public Code getサービス提供体制強化加算() {
        return entity.getServiceTeikyoTaiseiKyokaKasan();
    }

    /**
     * 認知症短期集中リハビリテーション加算を返します。
     *
     * @return 認知症短期集中リハビリテーション加算
     */
    public Code get認知症短期集中リハビリテーション加算() {
        return entity.getNinchishoTankiShuchuRehabilitationKasan().value();
    }

    /**
     * 若年性認知症利用者_入所者_患者_受入加算を返します。
     *
     * @return 若年性認知症利用者_入所者_患者_受入加算
     */
    public Code get若年性認知症利用者_入所者_患者_受入加算() {
        return entity.getJakunenseiNinchishoRiyoushaUkeeireKasan().value();
    }

    /**
     * 看護体制加算を返します。
     *
     * @return 看護体制加算
     */
    public Code get看護体制加算() {
        return entity.getKangoTaiseiKasan().value();
    }

    /**
     * 夜勤職員配置加算を返します。
     *
     * @return 夜勤職員配置加算
     */
    public Code get夜勤職員配置加算() {
        return entity.getYakinShokuinHaichiKasan().value();
    }

    /**
     * 療養食加算を返します。
     *
     * @return 療養食加算
     */
    public Code get療養食加算() {
        return entity.getRyoyoShokuKasan().value();
    }

    /**
     * 日常生活継続支援加算を返します。
     *
     * @return 日常生活継続支援加算
     */
    public Code get日常生活継続支援加算() {
        return entity.getNichijoSeikatsuKeizokuShienKasan().value();
    }

    /**
     * 認知症専門ケア加算を返します。
     *
     * @return 認知症専門ケア加算
     */
    public Code get認知症専門ケア加算() {
        return entity.getNinchishoSemmonCareKasan().value();
    }

    /**
     * ２４時間通報対応加算を返します。
     *
     * @return ２４時間通報対応加算
     */
    public Code get２４時間通報対応加算() {
        return entity.getTwentyFourHoursTsuhoTaioKasan().value();
    }

    /**
     * 看護職員配置加算を返します。
     *
     * @return 看護職員配置加算
     */
    public Code get看護職員配置加算() {
        return entity.getKangoShokuinHaichiKasan().value();
    }

    /**
     * 夜間ケア加算を返します。
     *
     * @return 夜間ケア加算
     */
    public Code get夜間ケア加算() {
        return entity.getYakanCareKasan().value();
    }

    /**
     * 集団コミュニケーション療法の有無を返します。
     *
     * @return 集団コミュニケーション療法の有無
     */
    public Code get集団コミュニケーション療法の有無() {
        return entity.getShudanCommunicationRyoho_umu().value();
    }

    /**
     * サービス提供体制強化加算_空床型_を返します。
     *
     * @return サービス提供体制強化加算_空床型_
     */
    public Code getサービス提供体制強化加算_空床型_() {
        return entity.getServiceTeikyoTaiseiKyokaKasan_Karadokogata().value();
    }

    /**
     * 日中の身体介護２０分未満体制の有無を返します。
     *
     * @return 日中の身体介護２０分未満体制の有無
     */
    public Code get日中の身体介護２０分未満体制の有無() {
        return entity.getNitchuShintaikaigoTaise_20funmiman_umu().value();
    }

    /**
     * サービス提供責任者体制の有無を返します。
     *
     * @return サービス提供責任者体制の有無
     */
    public Code getサービス提供責任者体制の有無() {
        return entity.getServiceTeikyoSekininshaTaisei_umu().value();
    }

    /**
     * 同一建物に居住する利用者の減算の有無を返します。
     *
     * @return 同一建物に居住する利用者の減算の有無
     */
    public Code get同一建物に居住する利用者の減算の有無() {
        return entity.getDoitsuTatemonoKyojuRiyoshaGenzan_umu().value();
    }

    /**
     * 緊急短期入所体制確保加算を返します。
     *
     * @return 緊急短期入所体制確保加算
     */
    public Code get緊急短期入所体制確保加算() {
        return entity.getKinkyuTankiNyushoTaiseiKakuhoKasan().value();
    }

    /**
     * 在宅復帰_在宅療養支援機能加算を返します。
     *
     * @return 在宅復帰_在宅療養支援機能加算
     */
    public Code get在宅復帰_在宅療養支援機能加算() {
        return entity.getZaitakuFukki_ZaitakuRyoyoShienKinoKasan().value();
    }

    /**
     * 生活機能向上グループ活動加算を返します。
     *
     * @return 生活機能向上グループ活動加算
     */
    public Code get生活機能向上グループ活動加算() {
        return entity.getSeikatuKinoKojoGroupKatsudoKasan().value();
    }

    /**
     * 介護職員処遇改善加算を返します。
     *
     * @return 介護職員処遇改善加算
     */
    public Code get介護職員処遇改善加算() {
        return entity.getKaigoShokuinShoguKaizenKasan().value();
    }

    /**
     * {@link DbT7063KaigoJigyoshaShiteiServiceEntity}のクローンを返します。
     *
     * @return {@link DbT7063KaigoJigyoshaShiteiServiceEntity}のクローン
     */
    @Override
    public DbT7063KaigoJigyoshaShiteiServiceEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護事業者指定サービスの識別子{@link KaigoJigyoshaShiteiServiceIdentifier}を返します。
     *
     * @return 介護事業者指定サービスの識別子{@link KaigoJigyoshaShiteiServiceIdentifier}
     */
    @Override
    public KaigoJigyoshaShiteiServiceIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護事業者指定サービスを削除対象とします。<br/>
     * {@link DbT7063KaigoJigyoshaShiteiServiceEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoJigyoshaShiteiService}
     */
    @Override
    public KaigoJigyoshaShiteiService deleted() {
        DbT7063KaigoJigyoshaShiteiServiceEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoJigyoshaShiteiService(deletedEntity, id);
    }

    /**
     * {@link KaigoJigyoshaShiteiService}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoJigyoshaShiteiService}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7063KaigoJigyoshaShiteiServiceEntity entity;
        private final KaigoJigyoshaShiteiServiceIdentifier id;

        private _SerializationProxy(DbT7063KaigoJigyoshaShiteiServiceEntity entity, KaigoJigyoshaShiteiServiceIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoJigyoshaShiteiService(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoJigyoshaShiteiServiceBuilder createBuilderForEdit() {
        return new KaigoJigyoshaShiteiServiceBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
