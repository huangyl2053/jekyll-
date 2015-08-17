/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.JunkyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ChiikiKubun;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.DaikiboJigyoshoGaitoUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.DoitsuTatemonoKyojuUserGenzanUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.EiyoManagementTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByGengoChokakushiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByIshiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByKaigoStaffKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByKaigoSupportSemmoninKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByKaigojugyoshaKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByKangoStaffKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuByRigakuryohoshiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.GenzanJokyoUmuBySagyoryohoshiKetsuin;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.IryoRenkeiTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.IshiHaichiKijun;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JakunenseiNinchishoCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JakunenseiNinchishoRiyoshaUkeireKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JigyoshoHyokaKasanKetteiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JigyoshoHyokaKasanMoshideUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JikanEnchoServiceTaisei;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JokinSenjuIshiHaichiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JudokaTaioTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JunUnitCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JuryoininUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JushoHifukaiyoShidoKanriUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.JutakuNyushoSogoriyoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoStaffShoguKaizenKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KangoStaffHaichiKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KangoTaiseiKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KansentaisakuShidoKanriUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KinkyuTankinyushoTaiseiKakuhoKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KinkyuUkeireTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KinkyujiHomonKaigoKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KinokunrenShidoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaisei;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KobetsuRehabilitationTeikyoTaiseiUmu_Sonota;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KokuKinoKojoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KyojuhiTaiseku;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.NichijoSeikatsuKeizokuSupprtKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.NinchishoCareKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.NinchishoSemmonCareKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.NinchishoSemmontoUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.NinchishoTankiShuchuRehabilitationKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.NyuyokuKaijoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationKasanJokyoUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationKinoKyokaUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationTeikyoTaiseiUmu_RigakuRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationTeikyoTaiseiUmu_RigakuRyoho3;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationTeikyoTaiseiUmu_SagyoRyoho2;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RehabilitationTeikyoTaiseiUmu_Sonota;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RyoyoTaiseiIjiTokubetsuKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.RyoyoshokuKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.SeikatsuKinoKojoGroupKatsudoKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.SeishinkaIshiTeikitekiRyoyoshidoUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ServiceTeikyoSekininshaTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ServiceTeikyoTaiseiKyokaKasanForKushoType;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.SetsubiKijun;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShafukuhojinKeigenJigyoJisshiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShintaikosokuHaishiTorikumiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShiteiKoshinShinseichuKubun;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShiteiUmuBySeikatsuhogoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShogaishaSeikatsuSupportTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShokiboJigyoshoKasanInMountainArea_SituationAboutArea;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShokiboJigyoshoKasanInMountainArea_SituationAboutScale;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShokiboKyotenShugoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShokujiTeikyoJokyo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShokujiTeikyoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShudanCommunicationRyohoUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.SogeiTaisei;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TerminalCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ThirdGradeHelperTaisei;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TokubetsuChiikiKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TokubetsuKanriTaisei;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TokubetsuNyuyokuKaijoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TokuteiJigyoshoKasanUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TsuhoTaioFor24HoursKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.UndokiKinoKojoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.UnitCareTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.YakanCareKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.YakanCareUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.YakanKangoTaiseiUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.YakinStaffHaichiKasan;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.YakuzaiKanriShidoUmu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ZaitakuFukkiZaitakuRyoyoSupportKinoKasan;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
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
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護事業者指定サービスの情報を保持するクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者指定サービス
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public class KaigoJigyoshaShiteiService {

    private final DbT7063KaigoJigyoshaShiteiServiceEntity entity;

    private KaigoJigyoshaShiteiService() {
        this.entity = new DbT7063KaigoJigyoshaShiteiServiceEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity UrT0520KaigoJigyoshaDaihyoshaEntity
     */
    public KaigoJigyoshaShiteiService(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者指定サービス"));
    }

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
    public JunkyoKubun get基本情報準拠区分() {
        return entity.getKihonJohoJunkyoKubun();
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
    public JuryoininUmu get受領委任の有無() {
        return entity.getJuryoininUmu();
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
     * 管理者名を返します。
     *
     * @return 管理者名
     */
    public AtenaMeisho get管理者名() {
        return entity.getKanrishaName();
    }

    /**
     * 管理者名カナを返します。
     *
     * @return 管理者名カナ
     */
    public AtenaKanaMeisho get管理者名カナ() {
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
    public JunkyoKubun get口座情報準拠区分() {
        return entity.getKozaJohoJunkyoKubun();
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
    public RString get口座種別() {
        return entity.getKozaShubetsu();
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
    public ShafukuhojinKeigenJigyoJisshiUmu get社会福祉法人軽減事業実施の有無() {
        return entity.getShakaiFukushihoujinKeigenjigyouJisshi_umu();
    }

    /**
     * 生活保護法による指定の有無を返します。
     *
     * @return 生活保護法による指定の有無
     */
    public ShiteiUmuBySeikatsuhogoho get生活保護法による指定の有無() {
        return entity.getSeikatsuhogohouShitei_umu();
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
    public TokubetsuChiikiKasanUmu get特別地域加算の有無() {
        return entity.getTokubetsuChiikiKasan_umu();
    }

    /**
     * 緊急時訪問介護加算の有無を返します。
     *
     * @return 緊急時訪問介護加算の有無
     */
    public KinkyujiHomonKaigoKasanUmu get緊急時訪問介護加算の有無() {
        return entity.getKinkyujiHomonkaigoKasan_umu();
    }

    /**
     * 特別管理体制を返します。
     *
     * @return 特別管理体制
     */
    public TokubetsuKanriTaisei get特別管理体制() {
        return entity.getTokubetsuKanriTaisei();
    }

    /**
     * 機能訓練指導体制の有無を返します。
     *
     * @return 機能訓練指導体制の有無
     */
    public KinokunrenShidoTaiseiUmu get機能訓練指導体制の有無() {
        return entity.getKinoKunrenShidoTaisei_umu();
    }

    /**
     * 食事提供体制の有無を返します。
     *
     * @return 食事提供体制の有無
     */
    public ShokujiTeikyoTaiseiUmu get食事提供体制の有無() {
        return entity.getShokujiTeikyoTaisei_umu();
    }

    /**
     * 入浴介助体制の有無を返します。
     *
     * @return 入浴介助体制の有無
     */
    public NyuyokuKaijoTaiseiUmu get入浴介助体制の有無() {
        return entity.getNyuyokuKaijoTaisei_umu();
    }

    /**
     * 特別入浴介助体制の有無を返します。
     *
     * @return 特別入浴介助体制の有無
     */
    public TokubetsuNyuyokuKaijoTaiseiUmu get特別入浴介助体制の有無() {
        return entity.getTokubetsuNyuyokuKaijoTaisei_umu();
    }

    /**
     * 常勤専従医師配置の有無を返します。
     *
     * @return 常勤専従医師配置の有無
     */
    public JokinSenjuIshiHaichiUmu get常勤専従医師配置の有無() {
        return entity.getJoukinsenjuIshiHaichi_umu();
    }

    /**
     * 医師の配置基準を返します。
     *
     * @return 医師の配置基準
     */
    public IshiHaichiKijun get医師の配置基準() {
        return entity.getIshiHaichiKijun();
    }

    /**
     * 精神科医師定期的療養指導の有無を返します。
     *
     * @return 精神科医師定期的療養指導の有無
     */
    public SeishinkaIshiTeikitekiRyoyoshidoUmu get精神科医師定期的療養指導の有無() {
        return entity.getSeisinkaIshiTeikitekiRyouyousidou_umu();
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
    public NinchishoSemmontoUmu get認知症専門棟の有無() {
        return entity.getNinchishouSenmontou_umu();
    }

    /**
     * 食事提供の状況を返します。
     *
     * @return 食事提供の状況
     */
    public ShokujiTeikyoJokyo get食事提供の状況() {
        return entity.getShokujiTeikyoJokyo();
    }

    /**
     * 送迎体制を返します。
     *
     * @return 送迎体制
     */
    public SogeiTaisei get送迎体制() {
        return entity.getSougeiTaisei();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無
     */
    public RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無() {
        return entity.getRehaTeikyoTaisei_SogoRehaShisetsu_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無
     */
    public RehabilitationTeikyoTaiseiUmu_RigakuRyoho2 getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無() {
        return entity.getRehaTeikyoTaisei_RigakuRyohoII_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無
     */
    public RehabilitationTeikyoTaiseiUmu_RigakuRyoho3 getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無() {
        return entity.getRehaTeikyoTaisei_RigakuRyohoIII_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無
     */
    public RehabilitationTeikyoTaiseiUmu_SagyoRyoho2 getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無() {
        return entity.getRehaTeikyoTaisei_SagyoRyohoII_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_精神科作業療法_の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_精神科作業療法_の有無
     */
    public RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_精神科作業療法_の有無() {
        return entity.getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無
     */
    public RehabilitationTeikyoTaiseiUmu_Sonota getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無() {
        return entity.getRehaTeikyoTaisei_Sonota_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝの加算状況の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝの加算状況の有無
     */
    public RehabilitationKasanJokyoUmu getﾘﾊﾋﾞﾘﾃｰｼｮﾝの加算状況の有無() {
        return entity.getRehabilitationKasanJokyo();
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
    public GenzanJokyoUmuByIshiKetsuin get医師の欠員による減算の状況の有無() {
        return entity.getIshiKetuinGenzanJokyo_umu();
    }

    /**
     * 看護職員の欠員による減算の状況の有無を返します。
     *
     * @return 看護職員の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuByKangoStaffKetsuin get看護職員の欠員による減算の状況の有無() {
        return entity.getKangoShokuinKetsuinGenzanJokyo_umu();
    }

    /**
     * 理学療法士の欠員による減算の状況の有無を返します。
     *
     * @return 理学療法士の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuByRigakuryohoshiKetsuin get理学療法士の欠員による減算の状況の有無() {
        return entity.getRigakuRyouhousiKetsuinGenzanJokyo_umu();
    }

    /**
     * 作業療法士の欠員による減算の状況の有無を返します。
     *
     * @return 作業療法士の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuBySagyoryohoshiKetsuin get作業療法士の欠員による減算の状況の有無() {
        return entity.getSagyouRyouhousiKetsuinGenzanJokyo_umu();
    }

    /**
     * 介護職員の欠員による減算の状況の有無を返します。
     *
     * @return 介護職員の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuByKaigoStaffKetsuin get介護職員の欠員による減算の状況の有無() {
        return entity.getKaigoShokuinKetsuinGenzanJokyo_umu();
    }

    /**
     * 介護支援専門員の欠員による減算の状況の有無を返します。
     *
     * @return 介護支援専門員の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuByKaigoSupportSemmoninKetsuin get介護支援専門員の欠員による減算の状況の有無() {
        return entity.getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu();
    }

    /**
     * 介護従業者の欠員による減算の状況の有無を返します。
     *
     * @return 介護従業者の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuByKaigojugyoshaKetsuin get介護従業者の欠員による減算の状況の有無() {
        return entity.getKaigoJujishaKetsuinGenzanJokyo_umu();
    }

    /**
     * 感染対策指導管理の有無を返します。
     *
     * @return 感染対策指導管理の有無
     */
    public KansentaisakuShidoKanriUmu get感染対策指導管理の有無() {
        return entity.getKansenTaisakuSidoKanri_umu();
    }

    /**
     * 重症皮膚潰瘍指導管理の有無を返します。
     *
     * @return 重症皮膚潰瘍指導管理の有無
     */
    public JushoHifukaiyoShidoKanriUmu get重症皮膚潰瘍指導管理の有無() {
        return entity.getJushoHifuKaiyouShidoKanri_umu();
    }

    /**
     * 薬剤管理指導の有無を返します。
     *
     * @return 薬剤管理指導の有無
     */
    public YakuzaiKanriShidoUmu get薬剤管理指導の有無() {
        return entity.getYakuzaiKaniriShido_umu();
    }

    /**
     * 障害者生活支援体制の有無を返します。
     *
     * @return 障害者生活支援体制の有無
     */
    public ShogaishaSeikatsuSupportTaiseiUmu get障害者生活支援体制の有無() {
        return entity.getShogaishaSeikatsuShienTaisei_umu();
    }

    /**
     * 地域区分コードを返します。
     *
     * @return 地域区分コード
     */
    public ChiikiKubun get地域区分コード() {
        return entity.getChiikiKubunCode();
    }

    /**
     * 時間延長サービス体制を返します。
     *
     * @return 時間延長サービス体制
     */
    public JikanEnchoServiceTaisei get時間延長サービス体制() {
        return entity.getJikanEnchoServiceTaisei();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制
     */
    public KobetsuRehabilitationTeikyoTaisei get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制() {
        return entity.getKobetsuRehabilitationTeikyoTaisei();
    }

    /**
     * 居住費対策を返します。
     *
     * @return 居住費対策
     */
    public KyojuhiTaiseku get居住費対策() {
        return entity.getKyojuhiTaisaku();
    }

    /**
     * 夜間ケアの有無を返します。
     *
     * @return 夜間ケアの有無
     */
    public YakanCareUmu get夜間ケアの有無() {
        return entity.getYakanCare_umu();
    }

    /**
     * ﾘﾊﾋﾞﾘﾃｰｼｮﾝ機能強化の有無を返します。
     *
     * @return ﾘﾊﾋﾞﾘﾃｰｼｮﾝ機能強化の有無
     */
    public RehabilitationKinoKyokaUmu getﾘﾊﾋﾞﾘﾃｰｼｮﾝ機能強化の有無() {
        return entity.getRehabilitationKinoKyoka_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無1を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無1
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無1() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅰ_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅰ_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅰ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅱ_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅱ_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅱ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu();
    }

    /**
     * 言語聴覚士の欠員による減算の状況の有無を返します。
     *
     * @return 言語聴覚士の欠員による減算の状況の有無
     */
    public GenzanJokyoUmuByGengoChokakushiKetsuin get言語聴覚士の欠員による減算の状況の有無() {
        return entity.getGengoChokakushiKetsuinGenzanJokyo_umu();
    }

    /**
     * 栄養管理の評価を返します。
     *
     * @return 栄養管理の評価
     */
    public ShafukuhojinKeigenJigyoJisshiUmu get栄養管理の評価() {
        return entity.getEiyouKanriHyoka();
    }

    /**
     * 特定事業所加算_訪問介護_の有無を返します。
     *
     * @return 特定事業所加算_訪問介護_の有無
     */
    public TokuteiJigyoshoKasanUmu get特定事業所加算_訪問介護_の有無() {
        return entity.getTokuteijigyoushoKasan_HomonKaigo_umu();
    }

    /**
     * 若年性認知症ケア体制の有無を返します。
     *
     * @return 若年性認知症ケア体制の有無
     */
    public JakunenseiNinchishoCareTaiseiUmu get若年性認知症ケア体制の有無() {
        return entity.getJakunenseiNinchishoCareTaisei_umu();
    }

    /**
     * 運動器機能向上体制の有無を返します。
     *
     * @return 運動器機能向上体制の有無
     */
    public UndokiKinoKojoTaiseiUmu get運動器機能向上体制の有無() {
        return entity.getUndokiKinoKojoTaisei_umu();
    }

    /**
     * 栄養マネジメント_改善_体制の有無を返します。
     *
     * @return 栄養マネジメント_改善_体制の有無
     */
    public EiyoManagementTaiseiUmu get栄養マネジメント_改善_体制の有無() {
        return entity.getEiyoManagement_KaizenTaisei_umu();
    }

    /**
     * 口腔機能向上体制の有無を返します。
     *
     * @return 口腔機能向上体制の有無
     */
    public KokuKinoKojoTaiseiUmu get口腔機能向上体制の有無() {
        return entity.getKokuKinoKojoTaisei_umu();
    }

    /**
     * 事業所評価加算_申出_の有無を返します。
     *
     * @return 事業所評価加算_申出_の有無
     */
    public JigyoshoHyokaKasanMoshideUmu get事業所評価加算_申出_の有無() {
        return entity.getJigyoshoHyokaKasan_Moshide_umu();
    }

    /**
     * 事業所評価加算_決定_の有無を返します。
     *
     * @return 事業所評価加算_決定_の有無
     */
    public JigyoshoHyokaKasanKetteiUmu get事業所評価加算_決定_の有無() {
        return entity.getJigyoshoHyokaKasan_Kettei_umu();
    }

    /**
     * 緊急受入体制の有無を返します。
     *
     * @return 緊急受入体制の有無
     */
    public KinkyuUkeireTaiseiUmu get緊急受入体制の有無() {
        return entity.getKinkyuUkeireTaisei_umu();
    }

    /**
     * 夜間看護体制の有無を返します。
     *
     * @return 夜間看護体制の有無
     */
    public YakanKangoTaiseiUmu get夜間看護体制の有無() {
        return entity.getYakanKangoTaisei_umu();
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
     * 介護支援専門員数_専従の常勤者を返します。
     *
     * @return 介護支援専門員数_専従の常勤者
     */
    public int get介護支援専門員数_専従の常勤者() {
        return entity.getKaigoShienSemmoninSenjuJokinshaNinsu();
    }

    /**
     * 介護支援専門員数_専従の非常勤者を返します。
     *
     * @return 介護支援専門員数_専従の非常勤者
     */
    public int get介護支援専門員数_専従の非常勤者() {
        return entity.getKaigoSienSemmoninSenjuHijokinshaNinsu();
    }

    /**
     * 介護支援専門員数_兼務の常勤者を返します。
     *
     * @return 介護支援専門員数_兼務の常勤者
     */
    public int get介護支援専門員数_兼務の常勤者() {
        return entity.getKaigoSienSemmoninKemmuJokinshaNinsu();
    }

    /**
     * 介護支援専門員数_兼務の非常勤者を返します。
     *
     * @return 介護支援専門員数_兼務の非常勤者
     */
    public int get介護支援専門員数_兼務の非常勤者() {
        return entity.getKaigoSienSemmoninKemmuHijokinshaNinsu();
    }

    /**
     * 訪問介護サービス提供責任者数を返します。
     *
     * @return 訪問介護サービス提供責任者数
     */
    public int get訪問介護サービス提供責任者数() {
        return entity.getHomonkaigoServiceTeikyoSekininshaNinsu();
    }

    /**
     * 訪問介護員数_専従の常勤者を返します。
     *
     * @return 訪問介護員数_専従の常勤者
     */
    public int get訪問介護員数_専従の常勤者() {
        return entity.getHomonkaigoSenjuJokinshaNinsu();
    }

    /**
     * 訪問介護員数_専従の非常勤者を返します。
     *
     * @return 訪問介護員数_専従の非常勤者
     */
    public int get訪問介護員数_専従の非常勤者() {
        return entity.getHomonkaigoSenjuHijokinshaNinsu();
    }

    /**
     * 訪問介護員数_兼務の常勤者を返します。
     *
     * @return 訪問介護員数_兼務の常勤者
     */
    public int get訪問介護員数_兼務の常勤者() {
        return entity.getHomonkaigoKemmuJokinshaNinsu();
    }

    /**
     * 訪問介護員数_兼務の非常勤者を返します。
     *
     * @return 訪問介護員数_兼務の非常勤者
     */
    public int get訪問介護員数_兼務の非常勤者() {
        return entity.getHomonkaigoKemmuHijokinshaNinsu();
    }

    /**
     * 訪問介護員数_常勤換算後の人数を返します。
     *
     * @return 訪問介護員数_常勤換算後の人数
     */
    public int get訪問介護員数_常勤換算後の人数() {
        return entity.getHomonkaigoJokinKanzangoNinsu();
    }

    /**
     * 利用定員数を返します。
     *
     * @return 利用定員数
     */
    public int get利用定員数() {
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
    public ShiteiKoshinShinseichuKubun get指定更新申請中区分() {
        return entity.getShiteiKoshinShinseichuKubun();
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
    public DaikiboJigyoshoGaitoUmu get大規模事業所該当の有無() {
        return entity.getDaikiboJigyoshaGaito_umu();
    }

    /**
     * 準ユニットケア体制の有無を返します。
     *
     * @return 準ユニットケア体制の有無
     */
    public JunUnitCareTaiseiUmu get準ユニットケア体制の有無() {
        return entity.getJunUnitCareTaisei_umu();
    }

    /**
     * 重度化対応体制の有無を返します。
     *
     * @return 重度化対応体制の有無
     */
    public JudokaTaioTaiseiUmu get重度化対応体制の有無() {
        return entity.getJudokaTaioTaisei_umu();
    }

    /**
     * 医療連携体制の有無を返します。
     *
     * @return 医療連携体制の有無
     */
    public IryoRenkeiTaiseiUmu get医療連携体制の有無() {
        return entity.getIryoRenkeiTaisei_umu();
    }

    /**
     * ユニットケア体制の有無を返します。
     *
     * @return ユニットケア体制の有無
     */
    public UnitCareTaiseiUmu getユニットケア体制の有無() {
        return entity.getUnitCareTaisei_umu();
    }

    /**
     * 在宅・入所相互利用体制の有無を返します。
     *
     * @return 在宅・入所相互利用体制の有無
     */
    public JutakuNyushoSogoriyoTaiseiUmu get在宅_入所相互利用体制の有無() {
        return entity.getZaitaku_nyushoSogoRiyoTaisei_umu();
    }

    /**
     * ターミナルケア体制_看取り介護体制_の有無を返します。
     *
     * @return ターミナルケア体制_看取り介護体制_の有無
     */
    public TerminalCareTaiseiUmu getターミナルケア体制_看取り介護体制_の有無() {
        return entity.getTerminalCareTaisei_umu();
    }

    /**
     * 身体拘束廃止取組の有無を返します。
     *
     * @return 身体拘束廃止取組の有無
     */
    public ShintaikosokuHaishiTorikumiUmu get身体拘束廃止取組の有無() {
        return entity.getShintaiKosokuHaishiTorikumi_umu();
    }

    /**
     * 小規模拠点集合体制の有無を返します。
     *
     * @return 小規模拠点集合体制の有無
     */
    public ShokiboKyotenShugoTaiseiUmu get小規模拠点集合体制の有無() {
        return entity.getShokiboKyotenShugoTaisei_umu();
    }

    /**
     * 認知症ケア加算の有無を返します。
     *
     * @return 認知症ケア加算の有無
     */
    public NinchishoCareKasanUmu get認知症ケア加算の有無() {
        return entity.getNinchishoCareKasan_umu();
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
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無2を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無2
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3 get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無2() {
        return entity.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu_Sonota get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_Sonota_umu();
    }

    /**
     * 設備基準を返します。
     *
     * @return 設備基準
     */
    public SetsubiKijun get設備基準() {
        return entity.getSetsubiKijun();
    }

    /**
     * 療養体制維持特別加算を返します。
     *
     * @return 療養体制維持特別加算
     */
    public RyoyoTaiseiIjiTokubetsuKasan get療養体制維持特別加算() {
        return entity.getRyoyoTaiseiIjiTokubetsuKasan();
    }

    /**
     * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無を返します。
     *
     * @return 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無
     */
    public KobetsuRehabilitationTeikyoTaiseiUmu get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無() {
        return entity.getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu();
    }

    /**
     * 三級ヘルパー体制を返します。
     *
     * @return 三級ヘルパー体制
     */
    public ThirdGradeHelperTaisei get三級ヘルパー体制() {
        return entity.getSankyuHelperTaisei();
    }

    /**
     * 中山間地域等における小規模事業所加算_地域に関する状況を返します。
     *
     * @return 中山間地域等における小規模事業所加算_地域に関する状況
     */
    public ShokiboJigyoshoKasanInMountainArea_SituationAboutArea get中山間地域等における小規模事業所加算_地域に関する状況() {
        return entity.getChuSankanChiikiShokiboJigyoshoKasan_chiiki();
    }

    /**
     * 中山間地域等における小規模事業所加算_規模に関する状況を返します。
     *
     * @return 中山間地域等における小規模事業所加算_規模に関する状況
     */
    public ShokiboJigyoshoKasanInMountainArea_SituationAboutScale get中山間地域等における小規模事業所加算_規模に関する状況() {
        return entity.getChuSankanChiikiShokiboJigyoushoKasan_kibo();
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
    public NinchishoTankiShuchuRehabilitationKasan get認知症短期集中リハビリテーション加算() {
        return entity.getNinchishoTankiShuchuRehabilitationKasan();
    }

    /**
     * 若年性認知症利用者_入所者・患者_受入加算を返します。
     *
     * @return 若年性認知症利用者_入所者・患者_受入加算
     */
    public JakunenseiNinchishoRiyoshaUkeireKasan get若年性認知症利用者_入所者_患者_受入加算() {
        return entity.getJakunenseiNinchishoRiyoushaUkeeireKasan();
    }

    /**
     * 看護体制加算を返します。
     *
     * @return 看護体制加算
     */
    public KangoTaiseiKasan get看護体制加算() {
        return entity.getKangoTaiseiKasan();
    }

    /**
     * 夜勤職員配置加算を返します。
     *
     * @return 夜勤職員配置加算
     */
    public YakinStaffHaichiKasan get夜勤職員配置加算() {
        return entity.getYakinShokuinHaichiKasan();
    }

    /**
     * 療養食加算を返します。
     *
     * @return 療養食加算
     */
    public RyoyoshokuKasan get療養食加算() {
        return entity.getRyoyoShokuKasan();
    }

    /**
     * 日常生活継続支援加算を返します。
     *
     * @return 日常生活継続支援加算
     */
    public NichijoSeikatsuKeizokuSupprtKasan get日常生活継続支援加算() {
        return entity.getNichijoSeikatsuKeizokuShienKasan();
    }

    /**
     * 認知症専門ケア加算を返します。
     *
     * @return 認知症専門ケア加算
     */
    public NinchishoSemmonCareKasan get認知症専門ケア加算() {
        return entity.getNinchishoSemmonCareKasan();
    }

    /**
     * 二十四時間通報対応加算を返します。
     *
     * @return 二十四時間通報対応加算
     */
    public TsuhoTaioFor24HoursKasan get二十四時間通報対応加算() {
        return entity.getTwentyFourHoursTsuhoTaioKasan();
    }

    /**
     * 看護職員配置加算を返します。
     *
     * @return 看護職員配置加算
     */
    public KangoStaffHaichiKasan get看護職員配置加算() {
        return entity.getKangoShokuinHaichiKasan();
    }

    /**
     * 夜間ケア加算を返します。
     *
     * @return 夜間ケア加算
     */
    public YakanCareKasan get夜間ケア加算() {
        return entity.getYakanCareKasan();
    }

    /**
     * 集団コミュニケーション療法の有無を返します。
     *
     * @return 集団コミュニケーション療法の有無
     */
    public ShudanCommunicationRyohoUmu get集団コミュニケーション療法の有無() {
        return entity.getShudanCommunicationRyoho_umu();
    }

    /**
     * サービス提供体制強化加算_空床型を返します。
     *
     * @return サービス提供体制強化加算_空床型
     */
    public ServiceTeikyoTaiseiKyokaKasanForKushoType getサービス提供体制強化加算_空床型() {
        return entity.getServiceTeikyoTaiseiKyokaKasan_Karadokogata();
    }

    /**
     * 日中の身体介護２０分未満体制の有無を返します。
     *
     * @return 日中の身体介護２０分未満体制の有無
     */
    public ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu get日中の身体介護２０分未満体制の有無() {
        return entity.getNitchuShintaikaigoTaise_20funmiman_umu();
    }

    /**
     * サービス提供責任者体制の有無を返します。
     *
     * @return サービス提供責任者体制の有無
     */
    public ServiceTeikyoSekininshaTaiseiUmu getサービス提供責任者体制の有無() {
        return entity.getServiceTeikyoSekininshaTaisei_umu();
    }

    /**
     * 同一建物に居住する利用者の減算の有無を返します。
     *
     * @return 同一建物に居住する利用者の減算の有無
     */
    public DoitsuTatemonoKyojuUserGenzanUmu get同一建物に居住する利用者の減算の有無() {
        return entity.getDoitsuTatemonoKyojuRiyoshaGenzan_umu();
    }

    /**
     * 緊急短期入所体制確保加算を返します。
     *
     * @return 緊急短期入所体制確保加算
     */
    public KinkyuTankinyushoTaiseiKakuhoKasan get緊急短期入所体制確保加算() {
        return entity.getKinkyuTankiNyushoTaiseiKakuhoKasan();
    }

    /**
     * 在宅復帰_在宅療養支援機能加算を返します。
     *
     * @return 在宅復帰_在宅療養支援機能加算
     */
    public ZaitakuFukkiZaitakuRyoyoSupportKinoKasan get在宅復帰_在宅療養支援機能加算() {
        return entity.getZaitakuFukki_ZaitakuRyoyoShienKinoKasan();
    }

    /**
     * 生活機能向上グループ活動加算を返します。
     *
     * @return 生活機能向上グループ活動加算
     */
    public SeikatsuKinoKojoGroupKatsudoKasan get生活機能向上グループ活動加算() {
        return entity.getSeikatuKinoKojoGroupKatsudoKasan();
    }

    /**
     * 介護職員処遇改善加算を返します。
     *
     * @return 介護職員処遇改善加算
     */
    public KaigoStaffShoguKaizenKasan get介護職員処遇改善加算() {
        return entity.getKaigoShokuinShoguKaizenKasan();
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    //TODO n3423 樋木隆真 KaigoJigyoshaDaihyoshaModelの内容をそのまま移します。ただし、stateの扱いについては現在検討中のため変更の可能性があります。
    public EntityDataState getState() {
        return entity.getState();
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return 介護事業者指定サービスエンティティ
     */
    public DbT7063KaigoJigyoshaShiteiServiceEntity toEntity() {
        return entity.clone();
    }

    private KaigoJigyoshaShiteiService(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    public Builder createBuilderForEdit() {
        return new Builder(this);
    }

    /**
     * 新しい{@link KaigoJigyoshaShiteiService}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link KaigoJigyoshaShiteiService}を生成するためのビルダーです。
     */
    public static final class Builder {

        private DbT7063KaigoJigyoshaShiteiServiceEntity entity;

        Builder() {
            this.entity = new DbT7063KaigoJigyoshaShiteiServiceEntity();
        }

        Builder(KaigoJigyoshaShiteiService kaigoJigyoshaShiteiService) {
            this.entity = kaigoJigyoshaShiteiService.entity.clone();
        }

        /**
         * jigyoshaNoを設定します。
         *
         * @param jigyoshaNo 事業者番号
         * @return builder
         */
        public Builder setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
            Objects.requireNonNull(jigyoshaNo);
            this.entity.setJigyoshaNo(jigyoshaNo);
            return this;
        }

        /**
         * serviceShuruiCodeを設定します。
         *
         * @param serviceShuruiCode サービス種類コード
         * @return builder
         */
        public Builder setServiceShuruiCode(KaigoServiceShuruiCode serviceShuruiCode) {
            Objects.requireNonNull(serviceShuruiCode);
            this.entity.setServiceShuruiCode(serviceShuruiCode);
            return this;
        }

        /**
         * yukoKaishiYMDを設定します。
         *
         * @param yukoKaishiYMD 有効開始日
         * @return builder
         */
        public Builder setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
            Objects.requireNonNull(yukoKaishiYMD);
            this.entity.setYukoKaishiYMD(yukoKaishiYMD);
            return this;
        }

        /**
         * yukoShuryoYMDを設定します。
         *
         * @param yukoShuryoYMD get有効終了日
         * @return builder
         */
        public Builder setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
            Objects.requireNonNull(yukoShuryoYMD);
            this.entity.setYukoShuryoYMD(yukoShuryoYMD);
            return this;
        }

        /**
         * idoYMDを設定します。
         *
         * @param idoYMD 異動日
         * @return builder
         */
        public Builder setIdoYMD(FlexibleDate idoYMD) {
            Objects.requireNonNull(idoYMD);
            this.entity.setIdoYMD(idoYMD);
            return this;
        }

        /**
         * idoJiyuを設定します。
         *
         * @param idoJiyu 異動事由
         * @return builder
         */
        public Builder setIdoJiyu(RString idoJiyu) {
            Objects.requireNonNull(idoJiyu);
            this.entity.setIdoJiyu(idoJiyu);
            return this;
        }

        /**
         * shiteiNoを設定します。
         *
         * @param shiteiNo 指定番号
         * @return builder
         */
        public Builder setShiteiNo(RString shiteiNo) {
            Objects.requireNonNull(shiteiNo);
            this.entity.setShiteiNo(shiteiNo);
            return this;
        }

        /**
         * kihonJohoJunkyoKubunを設定します。
         *
         * @param kihonJohoJunkyoKubun 基本情報準拠区分
         * @return builder
         */
        public Builder setKihonJohoJunkyoKubun(JunkyoKubun kihonJohoJunkyoKubun) {
            Objects.requireNonNull(kihonJohoJunkyoKubun);
            this.entity.setKihonJohoJunkyoKubun(kihonJohoJunkyoKubun);
            return this;
        }

        /**
         * jigyoKaishiYMDを設定します。
         *
         * @param jigyoKaishiYMD get事業開始日
         * @return builder
         */
        public Builder setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
            Objects.requireNonNull(jigyoKaishiYMD);
            this.entity.setJigyoKaishiYMD(jigyoKaishiYMD);
            return this;
        }

        /**
         * jigyoKyushiYMDを設定します。
         *
         * @param jigyoKyushiYMD 事業休止日
         * @return builder
         */
        public Builder setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
            Objects.requireNonNull(jigyoKyushiYMD);
            this.entity.setJigyoKyushiYMD(jigyoKyushiYMD);
            return this;
        }

        /**
         * jigyoSaikaiYMDを設定します。
         *
         * @param jigyoSaikaiYMD 事業再開日
         * @return builder
         */
        public Builder setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
            Objects.requireNonNull(jigyoSaikaiYMD);
            this.entity.setJigyoSaikaiYMD(jigyoSaikaiYMD);
            return this;
        }

        /**
         * jigyoHaishiYMDを設定します。
         *
         * @param jigyoHaishiYMD 事業廃止日
         * @return builder
         */
        public Builder setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
            Objects.requireNonNull(jigyoHaishiYMD);
            this.entity.setJigyoHaishiYMD(jigyoHaishiYMD);
            return this;
        }

        /**
         * jigyoshaNameを設定します。
         *
         * @param jigyoshaName 事業者名称
         * @return builder
         */
        public Builder setJigyoshaName(AtenaMeisho jigyoshaName) {
            Objects.requireNonNull(jigyoshaName);
            this.entity.setJigyoshaName(jigyoshaName);
            return this;
        }

        /**
         * jigyoshaNameKanaを設定します。
         *
         * @param jigyoshaNameKana 事業者名称カナ
         * @return builder
         */
        public Builder setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
            Objects.requireNonNull(jigyoshaNameKana);
            this.entity.setJigyoshaNameKana(jigyoshaNameKana);
            return this;
        }

        /**
         * jigyoshaYubinNoを設定します。
         *
         * @param jigyoshaYubinNo 事業者郵便番号
         * @return builder
         */
        public Builder setJigyoshaYubinNo(YubinNo jigyoshaYubinNo) {
            Objects.requireNonNull(jigyoshaYubinNo);
            this.entity.setJigyoshaYubinNo(jigyoshaYubinNo);
            return this;
        }

        /**
         * jigyoshaAddressを設定します。
         *
         * @param jigyoshaAddress 事業者住所
         * @return builder
         */
        public Builder setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
            Objects.requireNonNull(jigyoshaAddress);
            this.entity.setJigyoshaAddress(jigyoshaAddress);
            return this;
        }

        /**
         * jigyoshaAddressKanaを設定します。
         *
         * @param jigyoshaAddressKana 事業者住所カナ
         * @return builder
         */
        public Builder setJigyoshaAddressKana(RString jigyoshaAddressKana) {
            Objects.requireNonNull(jigyoshaAddressKana);
            this.entity.setJigyoshaAddressKana(jigyoshaAddressKana);
            return this;
        }

        /**
         * jigyoshaTelNoを設定します。
         *
         * @param jigyoshaTelNo 事業者電話番号
         * @return builder
         */
        public Builder setJigyoshaTelNo(TelNo jigyoshaTelNo) {
            Objects.requireNonNull(jigyoshaTelNo);
            this.entity.setJigyoshaTelNo(jigyoshaTelNo);
            return this;
        }

        /**
         * jigyoshaFaxNoを設定します。
         *
         * @param jigyoshaFaxNo 事業者FAX番号
         * @return builder
         */
        public Builder setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
            Objects.requireNonNull(jigyoshaFaxNo);
            this.entity.setJigyoshaFaxNo(jigyoshaFaxNo);
            return this;
        }

        /**
         * torokuHokenshaNoを設定します。
         *
         * @param torokuHokenshaNo 登録保険者番号
         * @return builder
         */
        public Builder setTorokuHokenshaNo(RString torokuHokenshaNo) {
            Objects.requireNonNull(torokuHokenshaNo);
            this.entity.setTorokuHokenshaNo(torokuHokenshaNo);
            return this;
        }

        /**
         * juryoininUmuを設定します。
         *
         * @param juryoininUmu 受領委任の有無
         * @return builder
         */
        public Builder setJuryoininUmu(JuryoininUmu juryoininUmu) {
            Objects.requireNonNull(juryoininUmu);
            this.entity.setJuryoininUmu(juryoininUmu);
            return this;
        }

        /**
         * torokuKaishiYMDを設定します。
         *
         * @param torokuKaishiYMD 登録開始日
         * @return builder
         */
        public Builder setTorokuKaishiYMD(FlexibleDate torokuKaishiYMD) {
            Objects.requireNonNull(torokuKaishiYMD);
            this.entity.setTorokuKaishiYMD(torokuKaishiYMD);
            return this;
        }

        /**
         * torokuShuryoYMDを設定します。
         *
         * @param torokuShuryoYMD 登録終了日
         * @return builder
         */
        public Builder setTorokuShuryoYMD(FlexibleDate torokuShuryoYMD) {
            Objects.requireNonNull(torokuShuryoYMD);
            this.entity.setTorokuShuryoYMD(torokuShuryoYMD);
            return this;
        }

        /**
         * kanrishaNameを設定します。
         *
         * @param kanrishaName 管理者名
         * @return builder
         */
        public Builder setKanrishaName(AtenaMeisho kanrishaName) {
            Objects.requireNonNull(kanrishaName);
            this.entity.setKanrishaName(kanrishaName);
            return this;
        }

        /**
         * kanrishaNameKanaを設定します。
         *
         * @param kanrishaNameKana 管理者名カナ
         * @return builder
         */
        public Builder setKanrishaNameKana(AtenaKanaMeisho kanrishaNameKana) {
            Objects.requireNonNull(kanrishaNameKana);
            this.entity.setKanrishaNameKana(kanrishaNameKana);
            return this;
        }

        /**
         * kanrishaYubinNoを設定します。
         *
         * @param kanrishaYubinNo 管理者住所郵便番号
         * @return builder
         */
        public Builder setKanrishaYubinNo(YubinNo kanrishaYubinNo) {
            Objects.requireNonNull(kanrishaYubinNo);
            this.entity.setKanrishaYubinNo(kanrishaYubinNo);
            return this;
        }

        /**
         * kanrishaAddressを設定します。
         *
         * @param kanrishaAddress 管理者住所
         * @return builder
         */
        public Builder setKanrishaAddress(AtenaJusho kanrishaAddress) {
            Objects.requireNonNull(kanrishaAddress);
            this.entity.setKanrishaAddress(kanrishaAddress);
            return this;
        }

        /**
         * kanrishaAddressKanaを設定します。
         *
         * @param kanrishaAddressKana 管理者住所カナ
         * @return builder
         */
        public Builder setKanrishaAddressKana(RString kanrishaAddressKana) {
            Objects.requireNonNull(kanrishaAddressKana);
            this.entity.setKanrishaAddressKana(kanrishaAddressKana);
            return this;
        }

        /**
         * kozaJohoJunkyoKubunを設定します。
         *
         * @param kozaJohoJunkyoKubun 口座情報準拠区分
         * @return builder
         */
        public Builder setKozaJohoJunkyoKubun(JunkyoKubun kozaJohoJunkyoKubun) {
            Objects.requireNonNull(kozaJohoJunkyoKubun);
            this.entity.setKozaJohoJunkyoKubun(kozaJohoJunkyoKubun);
            return this;
        }

        /**
         * ginkoCodeを設定します。
         *
         * @param ginkoCode 銀行コード
         * @return builder
         */
        public Builder setGinkoCode(KinyuKikanCode ginkoCode) {
            Objects.requireNonNull(ginkoCode);
            this.entity.setGinkoCode(ginkoCode);
            return this;
        }

        /**
         * shitenCodeを設定します。
         *
         * @param shitenCode 支店コード
         * @return builder
         */
        public Builder setShitenCode(KinyuKikanShitenCode shitenCode) {
            Objects.requireNonNull(shitenCode);
            this.entity.setShitenCode(shitenCode);
            return this;
        }

        /**
         * kozaShubetsuを設定します。
         *
         * @param kozaShubetsu 口座種別
         * @return builder
         */
        public Builder setKozaShubetsu(RString kozaShubetsu) {
            Objects.requireNonNull(kozaShubetsu);
            this.entity.setKozaShubetsu(kozaShubetsu);
            return this;
        }

        /**
         * kozaNoを設定します。
         *
         * @param kozaNo 口座番号
         * @return builder
         */
        public Builder setKozaNo(RString kozaNo) {
            Objects.requireNonNull(kozaNo);
            this.entity.setKozaNo(kozaNo);
            return this;
        }

        /**
         * kozaMeigininを設定します。
         *
         * @param kozaMeiginin 口座名義人
         * @return builder
         */
        public Builder setKozaMeiginin(AtenaMeisho kozaMeiginin) {
            Objects.requireNonNull(kozaMeiginin);
            this.entity.setKozaMeiginin(kozaMeiginin);
            return this;
        }

        /**
         * kozaMeigininKanaを設定します。
         *
         * @param kozaMeigininKana 口座名義人カナ
         * @return builder
         */
        public Builder setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
            Objects.requireNonNull(kozaMeigininKana);
            this.entity.setKozaMeigininKana(kozaMeigininKana);
            return this;
        }

        /**
         * shakaiFukushihoujinKeigenjigyouJisshi_umuを設定します。
         *
         * @param shakaiFukushihoujinKeigenjigyouJisshi_umu 社会福祉法人軽減事業実施の有無
         * @return builder
         */
        public Builder setShakaiFukushihoujinKeigenjigyouJisshi_umu(ShafukuhojinKeigenJigyoJisshiUmu shakaiFukushihoujinKeigenjigyouJisshi_umu) {
            Objects.requireNonNull(shakaiFukushihoujinKeigenjigyouJisshi_umu);
            this.entity.setShakaiFukushihoujinKeigenjigyouJisshi_umu(shakaiFukushihoujinKeigenjigyouJisshi_umu);
            return this;
        }

        /**
         * seikatsuhogohouShitei_umuを設定します。
         *
         * @param seikatsuhogohouShitei_umu 生活保護法による指定の有無
         * @return builder
         */
        public Builder setSeikatsuhogohouShitei_umu(ShiteiUmuBySeikatsuhogoho seikatsuhogohouShitei_umu) {
            Objects.requireNonNull(seikatsuhogohouShitei_umu);
            this.entity.setSeikatsuhogohouShitei_umu(seikatsuhogohouShitei_umu);
            return this;
        }

        /**
         * shisetsunadoKubunを設定します。
         *
         * @param shisetsunadoKubun 施設等の区分
         * @return builder
         */
        public Builder setShisetsunadoKubun(Code shisetsunadoKubun) {
            Objects.requireNonNull(shisetsunadoKubun);
            this.entity.setShisetsunadoKubun(shisetsunadoKubun);
            return this;
        }

        /**
         * jininHaichiKubunを設定します。
         *
         * @param jininHaichiKubun 人員配置区分
         * @return builder
         */
        public Builder setJininHaichiKubun(Code jininHaichiKubun) {
            Objects.requireNonNull(jininHaichiKubun);
            this.entity.setJininHaichiKubun(jininHaichiKubun);
            return this;
        }

        /**
         * tokubetsuChiikiKasan_umuを設定します。
         *
         * @param tokubetsuChiikiKasan_umu 特別地域加算の有無
         * @return builder
         */
        public Builder setTokubetsuChiikiKasan_umu(TokubetsuChiikiKasanUmu tokubetsuChiikiKasan_umu) {
            Objects.requireNonNull(tokubetsuChiikiKasan_umu);
            this.entity.setTokubetsuChiikiKasan_umu(tokubetsuChiikiKasan_umu);
            return this;
        }

        /**
         * kinkyujiHomonkaigoKasan_umuを設定します。
         *
         * @param kinkyujiHomonkaigoKasan_umu 緊急時訪問介護加算の有無
         * @return builder
         */
        public Builder setKinkyujiHomonkaigoKasan_umu(KinkyujiHomonKaigoKasanUmu kinkyujiHomonkaigoKasan_umu) {
            Objects.requireNonNull(kinkyujiHomonkaigoKasan_umu);
            this.entity.setKinkyujiHomonkaigoKasan_umu(kinkyujiHomonkaigoKasan_umu);
            return this;
        }

        /**
         * tokubetsuKanriTaiseiを設定します。
         *
         * @param tokubetsuKanriTaisei 特別管理体制
         * @return builder
         */
        public Builder setTokubetsuKanriTaisei(TokubetsuKanriTaisei tokubetsuKanriTaisei) {
            Objects.requireNonNull(tokubetsuKanriTaisei);
            this.entity.setTokubetsuKanriTaisei(tokubetsuKanriTaisei);
            return this;
        }

        /**
         * kinoKunrenShidoTaisei_umuを設定します。
         *
         * @param kinoKunrenShidoTaisei_umu 機能訓練指導体制の有無
         * @return builder
         */
        public Builder setKinoKunrenShidoTaisei_umu(KinokunrenShidoTaiseiUmu kinoKunrenShidoTaisei_umu) {
            Objects.requireNonNull(kinoKunrenShidoTaisei_umu);
            this.entity.setKinoKunrenShidoTaisei_umu(kinoKunrenShidoTaisei_umu);
            return this;
        }

        /**
         * shokujiTeikyoTaisei_umuを設定します。
         *
         * @param shokujiTeikyoTaisei_umu 食事提供体制の有無
         * @return builder
         */
        public Builder setShokujiTeikyoTaisei_umu(ShokujiTeikyoTaiseiUmu shokujiTeikyoTaisei_umu) {
            Objects.requireNonNull(shokujiTeikyoTaisei_umu);
            this.entity.setShokujiTeikyoTaisei_umu(shokujiTeikyoTaisei_umu);
            return this;
        }

        /**
         * nyuyokuKaijoTaisei_umuを設定します。
         *
         * @param nyuyokuKaijoTaisei_umu 入浴介助体制の有無
         * @return builder
         */
        public Builder setNyuyokuKaijoTaisei_umu(NyuyokuKaijoTaiseiUmu nyuyokuKaijoTaisei_umu) {
            Objects.requireNonNull(nyuyokuKaijoTaisei_umu);
            this.entity.setNyuyokuKaijoTaisei_umu(nyuyokuKaijoTaisei_umu);
            return this;
        }

        /**
         * tokubetsuNyuyokuKaijoTaisei_umuを設定します。
         *
         * @param tokubetsuNyuyokuKaijoTaisei_umu 特別入浴介助体制の有無
         * @return builder
         */
        public Builder setTokubetsuNyuyokuKaijoTaisei_umu(TokubetsuNyuyokuKaijoTaiseiUmu tokubetsuNyuyokuKaijoTaisei_umu) {
            Objects.requireNonNull(tokubetsuNyuyokuKaijoTaisei_umu);
            this.entity.setTokubetsuNyuyokuKaijoTaisei_umu(tokubetsuNyuyokuKaijoTaisei_umu);
            return this;
        }

        /**
         * joukinsenjuIshiHaichi_umuを設定します。
         *
         * @param joukinsenjuIshiHaichi_umu 常勤専従医師配置の有無
         * @return builder
         */
        public Builder setJoukinsenjuIshiHaichi_umu(JokinSenjuIshiHaichiUmu joukinsenjuIshiHaichi_umu) {
            Objects.requireNonNull(joukinsenjuIshiHaichi_umu);
            this.entity.setJoukinsenjuIshiHaichi_umu(joukinsenjuIshiHaichi_umu);
            return this;
        }

        /**
         * ishiHaichiKijunを設定します。
         *
         * @param ishiHaichiKijun 医師の配置基準
         * @return builder
         */
        public Builder setIshiHaichiKijun(IshiHaichiKijun ishiHaichiKijun) {
            Objects.requireNonNull(ishiHaichiKijun);
            this.entity.setIshiHaichiKijun(ishiHaichiKijun);
            return this;
        }

        /**
         * seisinkaIshiTeikitekiRyouyousidou_umuを設定します。
         *
         * @param seisinkaIshiTeikitekiRyouyousidou_umu 精神科医師定期的療養指導の有無
         * @return builder
         */
        public Builder setSeisinkaIshiTeikitekiRyouyousidou_umu(SeishinkaIshiTeikitekiRyoyoshidoUmu seisinkaIshiTeikitekiRyouyousidou_umu) {
            Objects.requireNonNull(seisinkaIshiTeikitekiRyouyousidou_umu);
            this.entity.setSeisinkaIshiTeikitekiRyouyousidou_umu(seisinkaIshiTeikitekiRyouyousidou_umu);
            return this;
        }

        /**
         * yakanKinmuJokenKijunを設定します。
         *
         * @param yakanKinmuJokenKijun 夜間勤務条件基準
         * @return builder
         */
        public Builder setYakanKinmuJokenKijun(Code yakanKinmuJokenKijun) {
            Objects.requireNonNull(yakanKinmuJokenKijun);
            this.entity.setYakanKinmuJokenKijun(yakanKinmuJokenKijun);
            return this;
        }

        /**
         * ninchishouSenmontou_umuを設定します。
         *
         * @param ninchishouSenmontou_umu 認知症専門棟の有無
         * @return builder
         */
        public Builder setNinchishouSenmontou_umu(NinchishoSemmontoUmu ninchishouSenmontou_umu) {
            Objects.requireNonNull(ninchishouSenmontou_umu);
            this.entity.setNinchishouSenmontou_umu(ninchishouSenmontou_umu);
            return this;
        }

        /**
         * shokujiTeikyoJokyoを設定します。
         *
         * @param shokujiTeikyoJokyo 食事提供の状況
         * @return builder
         */
        public Builder setShokujiTeikyoJokyo(ShokujiTeikyoJokyo shokujiTeikyoJokyo) {
            Objects.requireNonNull(shokujiTeikyoJokyo);
            this.entity.setShokujiTeikyoJokyo(shokujiTeikyoJokyo);
            return this;
        }

        /**
         * sougeiTaiseiを設定します。
         *
         * @param sougeiTaisei 送迎体制
         * @return builder
         */
        public Builder setSougeiTaisei(SogeiTaisei sougeiTaisei) {
            Objects.requireNonNull(sougeiTaisei);
            this.entity.setSougeiTaisei(sougeiTaisei);
            return this;
        }

        /**
         * rehaTeikyoTaisei_SogoRehaShisetsu_umuを設定します。
         *
         * @param rehaTeikyoTaisei_SogoRehaShisetsu_umu
         * リハビリテーション提供体制_総合リハビリテーション施設_の有無
         * @return builder
         */
        public Builder setRehaTeikyoTaisei_SogoRehaShisetsu_umu(
                RehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu rehaTeikyoTaisei_SogoRehaShisetsu_umu) {
            Objects.requireNonNull(rehaTeikyoTaisei_SogoRehaShisetsu_umu);
            this.entity.setRehaTeikyoTaisei_SogoRehaShisetsu_umu(rehaTeikyoTaisei_SogoRehaShisetsu_umu);
            return this;
        }

        /**
         * rehaTeikyoTaisei_RigakuRyohoII_umuを設定します。
         *
         * @param rehaTeikyoTaisei_RigakuRyohoII_umu リハビリテーション提供体制_理学療法Ⅱ_の有無
         * @return builder
         */
        public Builder setRehaTeikyoTaisei_RigakuRyohoII_umu(RehabilitationTeikyoTaiseiUmu_RigakuRyoho2 rehaTeikyoTaisei_RigakuRyohoII_umu) {
            Objects.requireNonNull(rehaTeikyoTaisei_RigakuRyohoII_umu);
            this.entity.setRehaTeikyoTaisei_RigakuRyohoII_umu(rehaTeikyoTaisei_RigakuRyohoII_umu);
            return this;
        }

        /**
         * rehaTeikyoTaisei_RigakuRyohoIII_umuを設定します。
         *
         * @param rehaTeikyoTaisei_RigakuRyohoIII_umu リハビリテーション提供体制_理学療法Ⅲ_の有無
         * @return builder
         */
        public Builder setRehaTeikyoTaisei_RigakuRyohoIII_umu(RehabilitationTeikyoTaiseiUmu_RigakuRyoho3 rehaTeikyoTaisei_RigakuRyohoIII_umu) {
            Objects.requireNonNull(rehaTeikyoTaisei_RigakuRyohoIII_umu);
            this.entity.setRehaTeikyoTaisei_RigakuRyohoIII_umu(rehaTeikyoTaisei_RigakuRyohoIII_umu);
            return this;
        }

        /**
         * rehaTeikyoTaisei_SagyoRyohoII_umuを設定します。
         *
         * @param rehaTeikyoTaisei_SagyoRyohoII_umu リハビリテーション提供体制_作業療法Ⅱ_の有無
         * @return builder
         */
        public Builder setRehaTeikyoTaisei_SagyoRyohoII_umu(RehabilitationTeikyoTaiseiUmu_SagyoRyoho2 rehaTeikyoTaisei_SagyoRyohoII_umu) {
            Objects.requireNonNull(rehaTeikyoTaisei_SagyoRyohoII_umu);
            this.entity.setRehaTeikyoTaisei_SagyoRyohoII_umu(rehaTeikyoTaisei_SagyoRyohoII_umu);
            return this;
        }

        /**
         * rehaTeikyoTaisei_SeisinkaSagyouRyoho_umuを設定します。
         *
         * @param rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu
         * リハビリテーション提供体制_精神科作業療法_の有無
         * @return builder
         */
        public Builder setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(
                RehabilitationTeikyoTaiseiUmu_SeishinkaSagyoRyoho rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu) {
            Objects.requireNonNull(rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu);
            this.entity.setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(rehaTeikyoTaisei_SeisinkaSagyouRyoho_umu);
            return this;
        }

        /**
         * rehaTeikyoTaisei_Sonota_umuを設定します。
         *
         * @param rehaTeikyoTaisei_Sonota_umu リハビリテーション提供体制_その他_の有無
         * @return builder
         */
        public Builder setRehaTeikyoTaisei_Sonota_umu(RehabilitationTeikyoTaiseiUmu_Sonota rehaTeikyoTaisei_Sonota_umu) {
            Objects.requireNonNull(rehaTeikyoTaisei_Sonota_umu);
            this.entity.setRehaTeikyoTaisei_Sonota_umu(rehaTeikyoTaisei_Sonota_umu);
            return this;
        }

        /**
         * rehabilitationKasanJokyoを設定します。
         *
         * @param rehabilitationKasanJokyo リハビリテーションの加算状況の有無
         * @return builder
         */
        public Builder setRehabilitationKasanJokyo(RehabilitationKasanJokyoUmu rehabilitationKasanJokyo) {
            Objects.requireNonNull(rehabilitationKasanJokyo);
            this.entity.setRehabilitationKasanJokyo(rehabilitationKasanJokyo);
            return this;
        }

        /**
         * ryoyoKankyoKijunを設定します。
         *
         * @param ryoyoKankyoKijun 療養環境基準
         * @return builder
         */
        public Builder setRyoyoKankyoKijun(Code ryoyoKankyoKijun) {
            Objects.requireNonNull(ryoyoKankyoKijun);
            this.entity.setRyoyoKankyoKijun(ryoyoKankyoKijun);
            return this;
        }

        /**
         * ishiKetuinGenzanJokyo_umuを設定します。
         *
         * @param ishiKetuinGenzanJokyo_umu 医師の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setIshiKetuinGenzanJokyo_umu(GenzanJokyoUmuByIshiKetsuin ishiKetuinGenzanJokyo_umu) {
            Objects.requireNonNull(ishiKetuinGenzanJokyo_umu);
            this.entity.setIshiKetuinGenzanJokyo_umu(ishiKetuinGenzanJokyo_umu);
            return this;
        }

        /**
         * kangoShokuinKetsuinGenzanJokyo_umuを設定します。
         *
         * @param kangoShokuinKetsuinGenzanJokyo_umu 看護職員の欠員による減算の状況の有無を返します
         * @return builder
         */
        public Builder setKangoShokuinKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKangoStaffKetsuin kangoShokuinKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(kangoShokuinKetsuinGenzanJokyo_umu);
            this.entity.setKangoShokuinKetsuinGenzanJokyo_umu(kangoShokuinKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * rigakuRyouhousiKetsuinGenzanJokyo_umuを設定します。
         *
         * @param rigakuRyouhousiKetsuinGenzanJokyo_umu 理学療法士の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setRigakuRyouhousiKetsuinGenzanJokyo_umu(GenzanJokyoUmuByRigakuryohoshiKetsuin rigakuRyouhousiKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(rigakuRyouhousiKetsuinGenzanJokyo_umu);
            this.entity.setRigakuRyouhousiKetsuinGenzanJokyo_umu(rigakuRyouhousiKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * sagyouRyouhousiKetsuinGenzanJokyo_umuを設定します。
         *
         * @param sagyouRyouhousiKetsuinGenzanJokyo_umu 作業療法士の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setSagyouRyouhousiKetsuinGenzanJokyo_umu(GenzanJokyoUmuBySagyoryohoshiKetsuin sagyouRyouhousiKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(sagyouRyouhousiKetsuinGenzanJokyo_umu);
            this.entity.setSagyouRyouhousiKetsuinGenzanJokyo_umu(sagyouRyouhousiKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * kaigoShokuinKetsuinGenzanJokyo_umuを設定します。
         *
         * @param kaigoShokuinKetsuinGenzanJokyo_umu 介護職員の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setKaigoShokuinKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKaigoStaffKetsuin kaigoShokuinKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(kaigoShokuinKetsuinGenzanJokyo_umu);
            this.entity.setKaigoShokuinKetsuinGenzanJokyo_umu(kaigoShokuinKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umuを設定します。
         *
         * @param kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu
         * 介護支援専門員の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(
                GenzanJokyoUmuByKaigoSupportSemmoninKetsuin kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu);
            this.entity.setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(kaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * kaigoJujishaKetsuinGenzanJokyo_umuを設定します。
         *
         * @param kaigoJujishaKetsuinGenzanJokyo_umu 介護従業者の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setKaigoJujishaKetsuinGenzanJokyo_umu(GenzanJokyoUmuByKaigojugyoshaKetsuin kaigoJujishaKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(kaigoJujishaKetsuinGenzanJokyo_umu);
            this.entity.setKaigoJujishaKetsuinGenzanJokyo_umu(kaigoJujishaKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * kansenTaisakuSidoKanri_umuを設定します。
         *
         * @param kansenTaisakuSidoKanri_umu 感染対策指導管理の有無
         * @return builder
         */
        public Builder setKansenTaisakuSidoKanri_umu(KansentaisakuShidoKanriUmu kansenTaisakuSidoKanri_umu) {
            Objects.requireNonNull(kansenTaisakuSidoKanri_umu);
            this.entity.setKansenTaisakuSidoKanri_umu(kansenTaisakuSidoKanri_umu);
            return this;
        }

        /**
         * jushoHifuKaiyouShidoKanri_umuを設定します。
         *
         * @param jushoHifuKaiyouShidoKanri_umu 重症皮膚潰瘍指導管理の有無
         * @return builder
         */
        public Builder setJushoHifuKaiyouShidoKanri_umu(JushoHifukaiyoShidoKanriUmu jushoHifuKaiyouShidoKanri_umu) {
            Objects.requireNonNull(jushoHifuKaiyouShidoKanri_umu);
            this.entity.setJushoHifuKaiyouShidoKanri_umu(jushoHifuKaiyouShidoKanri_umu);
            return this;
        }

        /**
         * yakuzaiKaniriShido_umuを設定します。
         *
         * @param yakuzaiKaniriShido_umu 薬剤管理指導の有無
         * @return builder
         */
        public Builder setYakuzaiKaniriShido_umu(YakuzaiKanriShidoUmu yakuzaiKaniriShido_umu) {
            Objects.requireNonNull(yakuzaiKaniriShido_umu);
            this.entity.setYakuzaiKaniriShido_umu(yakuzaiKaniriShido_umu);
            return this;
        }

        /**
         * shogaishaSeikatsuShienTaisei_umuを設定します。
         *
         * @param shogaishaSeikatsuShienTaisei_umu 障害者生活支援体制の有無
         * @return builder
         */
        public Builder setShogaishaSeikatsuShienTaisei_umu(ShogaishaSeikatsuSupportTaiseiUmu shogaishaSeikatsuShienTaisei_umu) {
            Objects.requireNonNull(shogaishaSeikatsuShienTaisei_umu);
            this.entity.setShogaishaSeikatsuShienTaisei_umu(shogaishaSeikatsuShienTaisei_umu);
            return this;
        }

        /**
         * chiikiKubunCodeを設定します。
         *
         * @param chiikiKubunCode 地域区分コード
         * @return builder
         */
        public Builder setChiikiKubunCode(ChiikiKubun chiikiKubunCode) {
            Objects.requireNonNull(chiikiKubunCode);
            this.entity.setChiikiKubunCode(chiikiKubunCode);
            return this;
        }

        /**
         * jikanEnchoServiceTaiseiを設定します。
         *
         * @param jikanEnchoServiceTaisei 時間延長サービス体制
         * @return builder
         */
        public Builder setJikanEnchoServiceTaisei(JikanEnchoServiceTaisei jikanEnchoServiceTaisei) {
            Objects.requireNonNull(jikanEnchoServiceTaisei);
            this.entity.setJikanEnchoServiceTaisei(jikanEnchoServiceTaisei);
            return this;
        }

        /**
         * kobetsuRehabilitationTeikyoTaiseiを設定します。
         *
         * @param kobetsuRehabilitationTeikyoTaisei 個別リハビリテーション提供体制
         * @return builder
         */
        public Builder setKobetsuRehabilitationTeikyoTaisei(KobetsuRehabilitationTeikyoTaisei kobetsuRehabilitationTeikyoTaisei) {
            Objects.requireNonNull(kobetsuRehabilitationTeikyoTaisei);
            this.entity.setKobetsuRehabilitationTeikyoTaisei(kobetsuRehabilitationTeikyoTaisei);
            return this;
        }

        /**
         * kyojuhiTaisakuを設定します。
         *
         * @param kyojuhiTaisaku 居住費対策
         * @return builder
         */
        public Builder setKyojuhiTaisaku(KyojuhiTaiseku kyojuhiTaisaku) {
            Objects.requireNonNull(kyojuhiTaisaku);
            this.entity.setKyojuhiTaisaku(kyojuhiTaisaku);
            return this;
        }

        /**
         * yakanCare_umuを設定します。
         *
         * @param yakanCare_umu 夜間ケアの有無
         * @return builder
         */
        public Builder setYakanCare_umu(YakanCareUmu yakanCare_umu) {
            Objects.requireNonNull(yakanCare_umu);
            this.entity.setYakanCare_umu(yakanCare_umu);
            return this;
        }

        /**
         * rehabilitationKinoKyoka_umuを設定します。
         *
         * @param rehabilitationKinoKyoka_umu リハビリテーション機能強化の有無
         * @return builder
         */
        public Builder setRehabilitationKinoKyoka_umu(RehabilitationKinoKyokaUmu rehabilitationKinoKyoka_umu) {
            Objects.requireNonNull(rehabilitationKinoKyoka_umu);
            this.entity.setRehabilitationKinoKyoka_umu(rehabilitationKinoKyoka_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu
         * 個別リハビリテーション提供体制_総合リハビリテーション施設_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_SogoRehabilitationShisetsu kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(kobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1を設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1
         * 個別リハビリテーション提供体制_理学療法Ⅱ_の有無1
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(
                KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2 kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1);
            this.entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu
         * 個別リハビリテーション提供体制_理学療法Ⅲ_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho3_BeforeH18_3 kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(kobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_SagyoRyohoII_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu
         * 個別リハビリテーション提供体制_作業療法Ⅱ_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho1 kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(kobetsuRehaTeikyoTaisei_SagyoRyohoII_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu
         * 個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho2 kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(kobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu
         * 個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho2 kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(kobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu);
            return this;
        }

        /**
         * gengoChokakushiKetsuinGenzanJokyo_umuを設定します。
         *
         * @param gengoChokakushiKetsuinGenzanJokyo_umu 言語聴覚士の欠員による減算の状況の有無
         * @return builder
         */
        public Builder setGengoChokakushiKetsuinGenzanJokyo_umu(GenzanJokyoUmuByGengoChokakushiKetsuin gengoChokakushiKetsuinGenzanJokyo_umu) {
            Objects.requireNonNull(gengoChokakushiKetsuinGenzanJokyo_umu);
            this.entity.setGengoChokakushiKetsuinGenzanJokyo_umu(gengoChokakushiKetsuinGenzanJokyo_umu);
            return this;
        }

        /**
         * eiyouKanriHyokaを設定します。
         *
         * @param eiyouKanriHyoka 栄養管理の評価
         * @return builder
         */
        public Builder setEiyouKanriHyoka(ShafukuhojinKeigenJigyoJisshiUmu eiyouKanriHyoka) {
            Objects.requireNonNull(eiyouKanriHyoka);
            this.entity.setEiyouKanriHyoka(eiyouKanriHyoka);
            return this;
        }

        /**
         * tokuteijigyoushoKasan_HomonKaigo_umuを設定します。
         *
         * @param tokuteijigyoushoKasan_HomonKaigo_umu 特定事業所加算_訪問介護_の有無
         * @return builder
         */
        public Builder setTokuteijigyoushoKasan_HomonKaigo_umu(TokuteiJigyoshoKasanUmu tokuteijigyoushoKasan_HomonKaigo_umu) {
            Objects.requireNonNull(tokuteijigyoushoKasan_HomonKaigo_umu);
            this.entity.setTokuteijigyoushoKasan_HomonKaigo_umu(tokuteijigyoushoKasan_HomonKaigo_umu);
            return this;
        }

        /**
         * jakunenseiNinchishoCareTaisei_umuを設定します。
         *
         * @param jakunenseiNinchishoCareTaisei_umu 若年性認知症ケア体制の有無
         * @return builder
         */
        public Builder setJakunenseiNinchishoCareTaisei_umu(JakunenseiNinchishoCareTaiseiUmu jakunenseiNinchishoCareTaisei_umu) {
            Objects.requireNonNull(jakunenseiNinchishoCareTaisei_umu);
            this.entity.setJakunenseiNinchishoCareTaisei_umu(jakunenseiNinchishoCareTaisei_umu);
            return this;
        }

        /**
         * undokiKinoKojoTaisei_umuを設定します。
         *
         * @param undokiKinoKojoTaisei_umu 運動器機能向上体制の有無
         * @return builder
         */
        public Builder setUndokiKinoKojoTaisei_umu(UndokiKinoKojoTaiseiUmu undokiKinoKojoTaisei_umu) {
            Objects.requireNonNull(undokiKinoKojoTaisei_umu);
            this.entity.setUndokiKinoKojoTaisei_umu(undokiKinoKojoTaisei_umu);
            return this;
        }

        /**
         * eiyoManagement_KaizenTaisei_umuを設定します。
         *
         * @param eiyoManagement_KaizenTaisei_umu 栄養マネジメント_改善_体制の有無
         * @return builder
         */
        public Builder setEiyoManagement_KaizenTaisei_umu(EiyoManagementTaiseiUmu eiyoManagement_KaizenTaisei_umu) {
            Objects.requireNonNull(eiyoManagement_KaizenTaisei_umu);
            this.entity.setEiyoManagement_KaizenTaisei_umu(eiyoManagement_KaizenTaisei_umu);
            return this;
        }

        /**
         * kokuKinoKojoTaisei_umuを設定します。
         *
         * @param kokuKinoKojoTaisei_umu 口腔機能向上体制の有無
         * @return builder
         */
        public Builder setKokuKinoKojoTaisei_umu(KokuKinoKojoTaiseiUmu kokuKinoKojoTaisei_umu) {
            Objects.requireNonNull(kokuKinoKojoTaisei_umu);
            this.entity.setKokuKinoKojoTaisei_umu(kokuKinoKojoTaisei_umu);
            return this;
        }

        /**
         * jigyoshoHyokaKasan_Moshide_umuを設定します。
         *
         * @param jigyoshoHyokaKasan_Moshide_umu 事業所評価加算_申出_の有無
         * @return builder
         */
        public Builder setJigyoshoHyokaKasan_Moshide_umu(JigyoshoHyokaKasanMoshideUmu jigyoshoHyokaKasan_Moshide_umu) {
            Objects.requireNonNull(jigyoshoHyokaKasan_Moshide_umu);
            this.entity.setJigyoshoHyokaKasan_Moshide_umu(jigyoshoHyokaKasan_Moshide_umu);
            return this;
        }

        /**
         * jigyoshoHyokaKasan_Kettei_umuを設定します。
         *
         * @param jigyoshoHyokaKasan_Kettei_umu 事業所評価加算_決定_の有無
         * @return builder
         */
        public Builder setJigyoshoHyokaKasan_Kettei_umu(JigyoshoHyokaKasanKetteiUmu jigyoshoHyokaKasan_Kettei_umu) {
            Objects.requireNonNull(jigyoshoHyokaKasan_Kettei_umu);
            this.entity.setJigyoshoHyokaKasan_Kettei_umu(jigyoshoHyokaKasan_Kettei_umu);
            return this;
        }

        /**
         * kinkyuUkeireTaisei_umuを設定します。
         *
         * @param kinkyuUkeireTaisei_umu 緊急受入体制の有無
         * @return builder
         */
        public Builder setKinkyuUkeireTaisei_umu(KinkyuUkeireTaiseiUmu kinkyuUkeireTaisei_umu) {
            Objects.requireNonNull(kinkyuUkeireTaisei_umu);
            this.entity.setKinkyuUkeireTaisei_umu(kinkyuUkeireTaisei_umu);
            return this;
        }

        /**
         * yakanKangoTaisei_umuを設定します。
         *
         * @param yakanKangoTaisei_umu 夜間看護体制の有無
         * @return builder
         */
        public Builder setYakanKangoTaisei_umu(YakanKangoTaiseiUmu yakanKangoTaisei_umu) {
            Objects.requireNonNull(yakanKangoTaisei_umu);
            this.entity.setYakanKangoTaisei_umu(yakanKangoTaisei_umu);
            return this;
        }

        /**
         * tokuteijigyoshoKasan_Kyotakukaigoshien_umuを設定します。
         *
         * @param tokuteijigyoshoKasan_Kyotakukaigoshien_umu 特定事業所加算_居宅介護支援_の有無
         * @return builder
         */
        public Builder setTokuteijigyoshoKasan_Kyotakukaigoshien_umu(Code tokuteijigyoshoKasan_Kyotakukaigoshien_umu) {
            Objects.requireNonNull(tokuteijigyoshoKasan_Kyotakukaigoshien_umu);
            this.entity.setTokuteijigyoshoKasan_Kyotakukaigoshien_umu(tokuteijigyoshoKasan_Kyotakukaigoshien_umu);
            return this;
        }

        /**
         * kaigoShienSemmoninSenjuJokinshaNinsuを設定します。
         *
         * @param kaigoShienSemmoninSenjuJokinshaNinsu 介護支援専門員数_専従の常勤者
         * @return builder
         */
        public Builder setKaigoShienSemmoninSenjuJokinshaNinsu(int kaigoShienSemmoninSenjuJokinshaNinsu) {
            this.entity.setKaigoShienSemmoninSenjuJokinshaNinsu(kaigoShienSemmoninSenjuJokinshaNinsu);
            return this;
        }

        /**
         * kaigoSienSemmoninSenjuHijokinshaNinsuを設定します。
         *
         * @param kaigoSienSemmoninSenjuHijokinshaNinsu 介護支援専門員数_専従の非常勤者
         * @return builder
         */
        public Builder setKaigoSienSemmoninSenjuHijokinshaNinsu(int kaigoSienSemmoninSenjuHijokinshaNinsu) {
            this.entity.setKaigoSienSemmoninSenjuHijokinshaNinsu(kaigoSienSemmoninSenjuHijokinshaNinsu);
            return this;
        }

        /**
         * kaigoSienSemmoninKemmuJokinshaNinsuを設定します。
         *
         * @param kaigoSienSemmoninKemmuJokinshaNinsu 介護支援専門員数_兼務の常勤者
         * @return builder
         */
        public Builder setKaigoSienSemmoninKemmuJokinshaNinsu(int kaigoSienSemmoninKemmuJokinshaNinsu) {
            this.entity.setKaigoSienSemmoninKemmuJokinshaNinsu(kaigoSienSemmoninKemmuJokinshaNinsu);
            return this;
        }

        /**
         * kaigoSienSemmoninKemmuHijokinshaNinsuを設定します。
         *
         * @param kaigoSienSemmoninKemmuHijokinshaNinsu 介護支援専門員数_兼務の非常勤者
         * @return builder
         */
        public Builder setKaigoSienSemmoninKemmuHijokinshaNinsu(int kaigoSienSemmoninKemmuHijokinshaNinsu) {
            this.entity.setKaigoSienSemmoninKemmuHijokinshaNinsu(kaigoSienSemmoninKemmuHijokinshaNinsu);
            return this;
        }

        /**
         * homonkaigoServiceTeikyoSekininshaNinsuを設定します。
         *
         * @param homonkaigoServiceTeikyoSekininshaNinsu 訪問介護サービス提供責任者数
         * @return builder
         */
        public Builder setHomonkaigoServiceTeikyoSekininshaNinsu(int homonkaigoServiceTeikyoSekininshaNinsu) {
            this.entity.setHomonkaigoServiceTeikyoSekininshaNinsu(homonkaigoServiceTeikyoSekininshaNinsu);
            return this;
        }

        /**
         * homonkaigoSenjuJokinshaNinsuを設定します。
         *
         * @param homonkaigoSenjuJokinshaNinsu 訪問介護員数_専従の常勤者
         * @return builder
         */
        public Builder setHomonkaigoSenjuJokinshaNinsu(int homonkaigoSenjuJokinshaNinsu) {
            this.entity.setHomonkaigoSenjuJokinshaNinsu(homonkaigoSenjuJokinshaNinsu);
            return this;
        }

        /**
         * homonkaigoSenjuHijokinshaNinsuを設定します。
         *
         * @param homonkaigoSenjuHijokinshaNinsu 訪問介護員数_専従の非常勤者
         * @return builder
         */
        public Builder setHomonkaigoSenjuHijokinshaNinsu(int homonkaigoSenjuHijokinshaNinsu) {
            this.entity.setHomonkaigoSenjuHijokinshaNinsu(homonkaigoSenjuHijokinshaNinsu);
            return this;
        }

        /**
         * homonkaigoKemmuJokinshaNinsuを設定します。
         *
         * @param homonkaigoKemmuJokinshaNinsu 訪問介護員数_兼務の常勤者
         * @return builder
         */
        public Builder setHomonkaigoKemmuJokinshaNinsu(int homonkaigoKemmuJokinshaNinsu) {
            this.entity.setHomonkaigoKemmuJokinshaNinsu(homonkaigoKemmuJokinshaNinsu);
            return this;
        }

        /**
         * homonkaigoKemmuHijokinshaNinsuを設定します。
         *
         * @param homonkaigoKemmuHijokinshaNinsu 訪問介護員数_兼務の非常勤者
         * @return builder
         */
        public Builder setHomonkaigoKemmuHijokinshaNinsu(int homonkaigoKemmuHijokinshaNinsu) {
            this.entity.setHomonkaigoKemmuHijokinshaNinsu(homonkaigoKemmuHijokinshaNinsu);
            return this;
        }

        /**
         * homonkaigoJokinKanzangoNinsuを設定します。
         *
         * @param homonkaigoJokinKanzangoNinsu 訪問介護員数_常勤換算後の人数
         * @return builder
         */
        public Builder setHomonkaigoJokinKanzangoNinsu(int homonkaigoJokinKanzangoNinsu) {
            this.entity.setHomonkaigoJokinKanzangoNinsu(homonkaigoJokinKanzangoNinsu);
            return this;
        }

        /**
         * riyoTeiinNinsuを設定します。
         *
         * @param riyoTeiinNinsu 利用定員数
         * @return builder
         */
        public Builder setRiyoTeiinNinsu(int riyoTeiinNinsu) {
            this.entity.setRiyoTeiinNinsu(riyoTeiinNinsu);
            return this;
        }

        /**
         * shiteiYukoKaishiYMDを設定します。
         *
         * @param shiteiYukoKaishiYMD 指定有効開始日
         * @return builder
         */
        public Builder setShiteiYukoKaishiYMD(FlexibleDate shiteiYukoKaishiYMD) {
            Objects.requireNonNull(shiteiYukoKaishiYMD);
            this.entity.setShiteiYukoKaishiYMD(shiteiYukoKaishiYMD);
            return this;
        }

        /**
         * shiteiYukoShuryoYMDを設定します。
         *
         * @param shiteiYukoShuryoYMD 指定有効終了日
         * @return builder
         */
        public Builder setShiteiYukoShuryoYMD(FlexibleDate shiteiYukoShuryoYMD) {
            Objects.requireNonNull(shiteiYukoShuryoYMD);
            this.entity.setShiteiYukoShuryoYMD(shiteiYukoShuryoYMD);
            return this;
        }

        /**
         * shiteiKoshinShinseichuKubunを設定します。
         *
         * @param shiteiKoshinShinseichuKubun 指定更新申請中区分
         * @return builder
         */
        public Builder setShiteiKoshinShinseichuKubun(ShiteiKoshinShinseichuKubun shiteiKoshinShinseichuKubun) {
            Objects.requireNonNull(shiteiKoshinShinseichuKubun);
            this.entity.setShiteiKoshinShinseichuKubun(shiteiKoshinShinseichuKubun);
            return this;
        }

        /**
         * koryokuTeishiKaishiYMDを設定します。
         *
         * @param koryokuTeishiKaishiYMD 効力停止開始日
         * @return builder
         */
        public Builder setKoryokuTeishiKaishiYMD(FlexibleDate koryokuTeishiKaishiYMD) {
            Objects.requireNonNull(koryokuTeishiKaishiYMD);
            this.entity.setKoryokuTeishiKaishiYMD(koryokuTeishiKaishiYMD);
            return this;
        }

        /**
         * koryokuTeishiShuryoYMDを設定します。
         *
         * @param koryokuTeishiShuryoYMD 効力停止終了日
         * @return builder
         */
        public Builder setKoryokuTeishiShuryoYMD(FlexibleDate koryokuTeishiShuryoYMD) {
            Objects.requireNonNull(koryokuTeishiShuryoYMD);
            this.entity.setKoryokuTeishiShuryoYMD(koryokuTeishiShuryoYMD);
            return this;
        }

        /**
         * daikiboJigyoshaGaito_umuを設定します。
         *
         * @param daikiboJigyoshaGaito_umu 大規模事業所該当の有無
         * @return builder
         */
        public Builder setDaikiboJigyoshaGaito_umu(DaikiboJigyoshoGaitoUmu daikiboJigyoshaGaito_umu) {
            Objects.requireNonNull(daikiboJigyoshaGaito_umu);
            this.entity.setDaikiboJigyoshaGaito_umu(daikiboJigyoshaGaito_umu);
            return this;
        }

        /**
         * junUnitCareTaisei_umuを設定します。
         *
         * @param junUnitCareTaisei_umu 準ユニットケア体制の有無
         * @return builder
         */
        public Builder setJunUnitCareTaisei_umu(JunUnitCareTaiseiUmu junUnitCareTaisei_umu) {
            Objects.requireNonNull(junUnitCareTaisei_umu);
            this.entity.setJunUnitCareTaisei_umu(junUnitCareTaisei_umu);
            return this;
        }

        /**
         * judokaTaioTaisei_umuを設定します。
         *
         * @param judokaTaioTaisei_umu 重度化対応体制の有無
         * @return builder
         */
        public Builder setJudokaTaioTaisei_umu(JudokaTaioTaiseiUmu judokaTaioTaisei_umu) {
            Objects.requireNonNull(judokaTaioTaisei_umu);
            this.entity.setJudokaTaioTaisei_umu(judokaTaioTaisei_umu);
            return this;
        }

        /**
         * iryoRenkeiTaisei_umuを設定します。
         *
         * @param iryoRenkeiTaisei_umu 医療連携体制の有無
         * @return builder
         */
        public Builder setIryoRenkeiTaisei_umu(IryoRenkeiTaiseiUmu iryoRenkeiTaisei_umu) {
            Objects.requireNonNull(iryoRenkeiTaisei_umu);
            this.entity.setIryoRenkeiTaisei_umu(iryoRenkeiTaisei_umu);
            return this;
        }

        /**
         * unitCareTaisei_umuを設定します。
         *
         * @param unitCareTaisei_umu ユニットケア体制の有無
         * @return builder
         */
        public Builder setUnitCareTaisei_umu(UnitCareTaiseiUmu unitCareTaisei_umu) {
            Objects.requireNonNull(unitCareTaisei_umu);
            this.entity.setUnitCareTaisei_umu(unitCareTaisei_umu);
            return this;
        }

        /**
         * zaitaku_nyushoSogoRiyoTaisei_umuを設定します。
         *
         * @param zaitaku_nyushoSogoRiyoTaisei_umu 在宅・入所相互利用体制の有無
         * @return builder
         */
        public Builder setZaitaku_nyushoSogoRiyoTaisei_umu(JutakuNyushoSogoriyoTaiseiUmu zaitaku_nyushoSogoRiyoTaisei_umu) {
            Objects.requireNonNull(zaitaku_nyushoSogoRiyoTaisei_umu);
            this.entity.setZaitaku_nyushoSogoRiyoTaisei_umu(zaitaku_nyushoSogoRiyoTaisei_umu);
            return this;
        }

        /**
         * terminalCareTaisei_umuを設定します。
         *
         * @param terminalCareTaisei_umu ターミナルケア体制_看取り介護体制_の有無
         * @return builder
         */
        public Builder setTerminalCareTaisei_umu(TerminalCareTaiseiUmu terminalCareTaisei_umu) {
            Objects.requireNonNull(terminalCareTaisei_umu);
            this.entity.setTerminalCareTaisei_umu(terminalCareTaisei_umu);
            return this;
        }

        /**
         * shintaiKosokuHaishiTorikumi_umuを設定します。
         *
         * @param shintaiKosokuHaishiTorikumi_umu 身体拘束廃止取組の有無
         * @return builder
         */
        public Builder setShintaiKosokuHaishiTorikumi_umu(ShintaikosokuHaishiTorikumiUmu shintaiKosokuHaishiTorikumi_umu) {
            Objects.requireNonNull(shintaiKosokuHaishiTorikumi_umu);
            this.entity.setShintaiKosokuHaishiTorikumi_umu(shintaiKosokuHaishiTorikumi_umu);
            return this;
        }

        /**
         * shokiboKyotenShugoTaisei_umuを設定します。
         *
         * @param shokiboKyotenShugoTaisei_umu 小規模拠点集合体制の有無
         * @return builder
         */
        public Builder setShokiboKyotenShugoTaisei_umu(ShokiboKyotenShugoTaiseiUmu shokiboKyotenShugoTaisei_umu) {
            Objects.requireNonNull(shokiboKyotenShugoTaisei_umu);
            this.entity.setShokiboKyotenShugoTaisei_umu(shokiboKyotenShugoTaisei_umu);
            return this;
        }

        /**
         * ninchishoCareKasan_umuを設定します。
         *
         * @param ninchishoCareKasan_umu 認知症ケア加算の有無
         * @return builder
         */
        public Builder setNinchishoCareKasan_umu(NinchishoCareKasanUmu ninchishoCareKasan_umu) {
            Objects.requireNonNull(ninchishoCareKasan_umu);
            this.entity.setNinchishoCareKasan_umu(ninchishoCareKasan_umu);
            return this;
        }

        /**
         * kobetsuKinoKunrenTaisei_umuを設定します。
         *
         * @param kobetsuKinoKunrenTaisei_umu 個別機能訓練体制の有無
         * @return builder
         */
        public Builder setKobetsuKinoKunrenTaisei_umu(Code kobetsuKinoKunrenTaisei_umu) {
            Objects.requireNonNull(kobetsuKinoKunrenTaisei_umu);
            this.entity.setKobetsuKinoKunrenTaisei_umu(kobetsuKinoKunrenTaisei_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_RigakuRyohoI_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu
         * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho1 kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(kobetsuRehaTeikyoTaisei_RigakuRyohoI_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2を設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2
         * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無2
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(
                KobetsuRehabilitationTeikyoTaiseiUmu_RigakuRyoho2_BeforeH21_3 kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2);
            this.entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(kobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_SagyoRyoho_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_SagyoRyoho_umu
         * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_SagyoRyoho kobetsuRehaTeikyoTaisei_SagyoRyoho_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_SagyoRyoho_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(kobetsuRehaTeikyoTaisei_SagyoRyoho_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu
         * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu_GengoChokakuRyoho kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(kobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_Sonota_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_Sonota_umu 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_Sonota_umu(KobetsuRehabilitationTeikyoTaiseiUmu_Sonota kobetsuRehaTeikyoTaisei_Sonota_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_Sonota_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_Sonota_umu(kobetsuRehaTeikyoTaisei_Sonota_umu);
            return this;
        }

        /**
         * setsubiKijunを設定します。
         *
         * @param setsubiKijun 設備基準
         * @return builder
         */
        public Builder setSetsubiKijun(SetsubiKijun setsubiKijun) {
            Objects.requireNonNull(setsubiKijun);
            this.entity.setSetsubiKijun(setsubiKijun);
            return this;
        }

        /**
         * ryoyoTaiseiIjiTokubetsuKasanを設定します。
         *
         * @param ryoyoTaiseiIjiTokubetsuKasan 療養体制維持特別加算
         * @return builder
         */
        public Builder setRyoyoTaiseiIjiTokubetsuKasan(RyoyoTaiseiIjiTokubetsuKasan ryoyoTaiseiIjiTokubetsuKasan) {
            Objects.requireNonNull(ryoyoTaiseiIjiTokubetsuKasan);
            this.entity.setRyoyoTaiseiIjiTokubetsuKasan(ryoyoTaiseiIjiTokubetsuKasan);
            return this;
        }

        /**
         * kobetsuRehaTeikyoTaisei_RehaShidoKanri_umuを設定します。
         *
         * @param kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu
         * 個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無
         * @return builder
         */
        public Builder setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(
                KobetsuRehabilitationTeikyoTaiseiUmu kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu) {
            Objects.requireNonNull(kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu);
            this.entity.setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(kobetsuRehaTeikyoTaisei_RehaShidoKanri_umu);
            return this;
        }

        /**
         * sankyuHelperTaiseiを設定します。
         *
         * @param sankyuHelperTaisei 三級ヘルパー体制
         * @return builder
         */
        public Builder setSankyuHelperTaisei(ThirdGradeHelperTaisei sankyuHelperTaisei) {
            Objects.requireNonNull(sankyuHelperTaisei);
            this.entity.setSankyuHelperTaisei(sankyuHelperTaisei);
            return this;
        }

        /**
         * chuSankanChiikiShokiboJigyoshoKasan_chiikiを設定します。
         *
         * @param chuSankanChiikiShokiboJigyoshoKasan_chiiki
         * 中山間地域等における小規模事業所加算_地域に関する状況
         * @return builder
         */
        public Builder setChuSankanChiikiShokiboJigyoshoKasan_chiiki(
                ShokiboJigyoshoKasanInMountainArea_SituationAboutArea chuSankanChiikiShokiboJigyoshoKasan_chiiki) {
            Objects.requireNonNull(chuSankanChiikiShokiboJigyoshoKasan_chiiki);
            this.entity.setChuSankanChiikiShokiboJigyoshoKasan_chiiki(chuSankanChiikiShokiboJigyoshoKasan_chiiki);
            return this;
        }

        /**
         * chuSankanChiikiShokiboJigyoushoKasan_kiboを設定します。
         *
         * @param chuSankanChiikiShokiboJigyoushoKasan_kibo
         * 中山間地域等における小規模事業所加算_規模に関する状況
         * @return builder
         */
        public Builder setChuSankanChiikiShokiboJigyoushoKasan_kibo(
                ShokiboJigyoshoKasanInMountainArea_SituationAboutScale chuSankanChiikiShokiboJigyoushoKasan_kibo) {
            Objects.requireNonNull(chuSankanChiikiShokiboJigyoushoKasan_kibo);
            this.entity.setChuSankanChiikiShokiboJigyoushoKasan_kibo(chuSankanChiikiShokiboJigyoushoKasan_kibo);
            return this;
        }

        /**
         * serviceTeikyoTaiseiKyokaKasanを設定します。
         *
         * @param serviceTeikyoTaiseiKyokaKasan サービス提供体制強化加算
         * @return builder
         */
        public Builder setServiceTeikyoTaiseiKyokaKasan(Code serviceTeikyoTaiseiKyokaKasan) {
            Objects.requireNonNull(serviceTeikyoTaiseiKyokaKasan);
            this.entity.setServiceTeikyoTaiseiKyokaKasan(serviceTeikyoTaiseiKyokaKasan);
            return this;
        }

        /**
         * ninchishoTankiShuchuRehabilitationKasanを設定します。
         *
         * @param ninchishoTankiShuchuRehabilitationKasan 認知症短期集中リハビリテーション加算
         * @return builder
         */
        public Builder setNinchishoTankiShuchuRehabilitationKasan(NinchishoTankiShuchuRehabilitationKasan ninchishoTankiShuchuRehabilitationKasan) {
            Objects.requireNonNull(ninchishoTankiShuchuRehabilitationKasan);
            this.entity.setNinchishoTankiShuchuRehabilitationKasan(ninchishoTankiShuchuRehabilitationKasan);
            return this;
        }

        /**
         * jakunenseiNinchishoRiyoushaUkeeireKasanを設定します。
         *
         * @param jakunenseiNinchishoRiyoushaUkeeireKasan 若年性認知症利用者_入所者・患者_受入加算
         * @return builder
         */
        public Builder setJakunenseiNinchishoRiyoushaUkeeireKasan(JakunenseiNinchishoRiyoshaUkeireKasan jakunenseiNinchishoRiyoushaUkeeireKasan) {
            Objects.requireNonNull(jakunenseiNinchishoRiyoushaUkeeireKasan);
            this.entity.setJakunenseiNinchishoRiyoushaUkeeireKasan(jakunenseiNinchishoRiyoushaUkeeireKasan);
            return this;
        }

        /**
         * kangoTaiseiKasanを設定します。
         *
         * @param kangoTaiseiKasan 看護体制加算
         * @return builder
         */
        public Builder setKangoTaiseiKasan(KangoTaiseiKasan kangoTaiseiKasan) {
            Objects.requireNonNull(kangoTaiseiKasan);
            this.entity.setKangoTaiseiKasan(kangoTaiseiKasan);
            return this;
        }

        /**
         * yakinShokuinHaichiKasanを設定します。
         *
         * @param yakinShokuinHaichiKasan 夜勤職員配置加算
         * @return builder
         */
        public Builder setYakinShokuinHaichiKasan(YakinStaffHaichiKasan yakinShokuinHaichiKasan) {
            Objects.requireNonNull(yakinShokuinHaichiKasan);
            this.entity.setYakinShokuinHaichiKasan(yakinShokuinHaichiKasan);
            return this;
        }

        /**
         * ryoyoShokuKasanを設定します。
         *
         * @param ryoyoShokuKasan 療養食加算
         * @return builder
         */
        public Builder setRyoyoShokuKasan(RyoyoshokuKasan ryoyoShokuKasan) {
            Objects.requireNonNull(ryoyoShokuKasan);
            this.entity.setRyoyoShokuKasan(ryoyoShokuKasan);
            return this;
        }

        /**
         * nichijoSeikatsuKeizokuShienKasanを設定します。
         *
         * @param nichijoSeikatsuKeizokuShienKasan 日常生活継続支援加算
         * @return builder
         */
        public Builder setNichijoSeikatsuKeizokuShienKasan(NichijoSeikatsuKeizokuSupprtKasan nichijoSeikatsuKeizokuShienKasan) {
            Objects.requireNonNull(nichijoSeikatsuKeizokuShienKasan);
            this.entity.setNichijoSeikatsuKeizokuShienKasan(nichijoSeikatsuKeizokuShienKasan);
            return this;
        }

        /**
         * ninchishoSemmonCareKasanを設定します。
         *
         * @param ninchishoSemmonCareKasan 認知症専門ケア加算
         * @return builder
         */
        public Builder setNinchishoSemmonCareKasan(NinchishoSemmonCareKasan ninchishoSemmonCareKasan) {
            Objects.requireNonNull(ninchishoSemmonCareKasan);
            this.entity.setNinchishoSemmonCareKasan(ninchishoSemmonCareKasan);
            return this;
        }

        /**
         * twentyFourHoursTsuhoTaioKasanを設定します。
         *
         * @param twentyFourHoursTsuhoTaioKasan 二十四時間通報対応加算
         * @return builder
         */
        public Builder setTwentyFourHoursTsuhoTaioKasan(TsuhoTaioFor24HoursKasan twentyFourHoursTsuhoTaioKasan) {
            Objects.requireNonNull(twentyFourHoursTsuhoTaioKasan);
            this.entity.setTwentyFourHoursTsuhoTaioKasan(twentyFourHoursTsuhoTaioKasan);
            return this;
        }

        /**
         * kangoShokuinHaichiKasanを設定します。
         *
         * @param kangoShokuinHaichiKasan 看護職員配置加算
         * @return builder
         */
        public Builder setKangoShokuinHaichiKasan(KangoStaffHaichiKasan kangoShokuinHaichiKasan) {
            Objects.requireNonNull(kangoShokuinHaichiKasan);
            this.entity.setKangoShokuinHaichiKasan(kangoShokuinHaichiKasan);
            return this;
        }

        /**
         * yakanCareKasanを設定します。
         *
         * @param yakanCareKasan 夜間ケア加算
         * @return builder
         */
        public Builder setYakanCareKasan(YakanCareKasan yakanCareKasan) {
            Objects.requireNonNull(yakanCareKasan);
            this.entity.setYakanCareKasan(yakanCareKasan);
            return this;
        }

        /**
         * shudanCommunicationRyoho_umuを設定します。
         *
         * @param shudanCommunicationRyoho_umu 集団コミュニケーション療法の有無
         * @return builder
         */
        public Builder setShudanCommunicationRyoho_umu(ShudanCommunicationRyohoUmu shudanCommunicationRyoho_umu) {
            Objects.requireNonNull(shudanCommunicationRyoho_umu);
            this.entity.setShudanCommunicationRyoho_umu(shudanCommunicationRyoho_umu);
            return this;
        }

        /**
         * serviceTeikyoTaiseiKyokaKasan_Karadokogataを設定します。
         *
         * @param serviceTeikyoTaiseiKyokaKasan_Karadokogata サービス提供体制強化加算_空床型
         * @return builder
         */
        public Builder setServiceTeikyoTaiseiKyokaKasan_Karadokogata(
                ServiceTeikyoTaiseiKyokaKasanForKushoType serviceTeikyoTaiseiKyokaKasan_Karadokogata) {
            Objects.requireNonNull(serviceTeikyoTaiseiKyokaKasan_Karadokogata);
            this.entity.setServiceTeikyoTaiseiKyokaKasan_Karadokogata(serviceTeikyoTaiseiKyokaKasan_Karadokogata);
            return this;
        }

        /**
         * nitchuShintaikaigoTaise_20funmiman_umuを設定します。
         *
         * @param nitchuShintaikaigoTaise_20funmiman_umu 日中の身体介護２０分未満体制の有無
         * @return builder
         */
        public Builder setNitchuShintaikaigoTaise_20funmiman_umu(
                ShintaiKaigoUnder20minutesInDaytimeTaiseiUmu nitchuShintaikaigoTaise_20funmiman_umu) {
            Objects.requireNonNull(nitchuShintaikaigoTaise_20funmiman_umu);
            this.entity.setNitchuShintaikaigoTaise_20funmiman_umu(nitchuShintaikaigoTaise_20funmiman_umu);
            return this;
        }

        /**
         * serviceTeikyoSekininshaTaisei_umuを設定します。
         *
         * @param serviceTeikyoSekininshaTaisei_umu サービス提供責任者体制の有無
         * @return builder
         */
        public Builder setServiceTeikyoSekininshaTaisei_umu(ServiceTeikyoSekininshaTaiseiUmu serviceTeikyoSekininshaTaisei_umu) {
            Objects.requireNonNull(serviceTeikyoSekininshaTaisei_umu);
            this.entity.setServiceTeikyoSekininshaTaisei_umu(serviceTeikyoSekininshaTaisei_umu);
            return this;
        }

        /**
         * doitsuTatemonoKyojuRiyoshaGenzan_umuを設定します。
         *
         * @param doitsuTatemonoKyojuRiyoshaGenzan_umu 同一建物に居住する利用者の減算の有無
         * @return builder
         */
        public Builder setDoitsuTatemonoKyojuRiyoshaGenzan_umu(DoitsuTatemonoKyojuUserGenzanUmu doitsuTatemonoKyojuRiyoshaGenzan_umu) {
            Objects.requireNonNull(doitsuTatemonoKyojuRiyoshaGenzan_umu);
            this.entity.setDoitsuTatemonoKyojuRiyoshaGenzan_umu(doitsuTatemonoKyojuRiyoshaGenzan_umu);
            return this;
        }

        /**
         * kinkyuTankiNyushoTaiseiKakuhoKasanを設定します。
         *
         * @param kinkyuTankiNyushoTaiseiKakuhoKasan 緊急短期入所体制確保加算
         * @return builder
         */
        public Builder setKinkyuTankiNyushoTaiseiKakuhoKasan(KinkyuTankinyushoTaiseiKakuhoKasan kinkyuTankiNyushoTaiseiKakuhoKasan) {
            Objects.requireNonNull(kinkyuTankiNyushoTaiseiKakuhoKasan);
            this.entity.setKinkyuTankiNyushoTaiseiKakuhoKasan(kinkyuTankiNyushoTaiseiKakuhoKasan);
            return this;
        }

        /**
         * zaitakuFukki_ZaitakuRyoyoShienKinoKasanを設定します。
         *
         * @param zaitakuFukki_ZaitakuRyoyoShienKinoKasan 在宅復帰_在宅療養支援機能加算
         * @return builder
         */
        public Builder setZaitakuFukki_ZaitakuRyoyoShienKinoKasan(ZaitakuFukkiZaitakuRyoyoSupportKinoKasan zaitakuFukki_ZaitakuRyoyoShienKinoKasan) {
            Objects.requireNonNull(zaitakuFukki_ZaitakuRyoyoShienKinoKasan);
            this.entity.setZaitakuFukki_ZaitakuRyoyoShienKinoKasan(zaitakuFukki_ZaitakuRyoyoShienKinoKasan);
            return this;
        }

        /**
         * seikatuKinoKojoGroupKatsudoKasanを設定します。
         *
         * @param seikatuKinoKojoGroupKatsudoKasan 生活機能向上グループ活動加算
         * @return builder
         */
        public Builder setSeikatuKinoKojoGroupKatsudoKasan(SeikatsuKinoKojoGroupKatsudoKasan seikatuKinoKojoGroupKatsudoKasan) {
            Objects.requireNonNull(seikatuKinoKojoGroupKatsudoKasan);
            this.entity.setSeikatuKinoKojoGroupKatsudoKasan(seikatuKinoKojoGroupKatsudoKasan);
            return this;
        }

        /**
         * kaigoShokuinShoguKaizenKasanを設定します。
         *
         * @param kaigoShokuinShoguKaizenKasan 介護職員処遇改善加算
         * @return builder
         */
        public Builder setKaigoShokuinShoguKaizenKasan(KaigoStaffShoguKaizenKasan kaigoShokuinShoguKaizenKasan) {
            Objects.requireNonNull(kaigoShokuinShoguKaizenKasan);
            this.entity.setKaigoShokuinShoguKaizenKasan(kaigoShokuinShoguKaizenKasan);
            return this;
        }

        /**
         * {@link KaigoJigyoshaShiteiService}を生成します。
         *
         * @return {@link KaigoJigyoshaShiteiService}
         */
        public KaigoJigyoshaShiteiService build() {
            return new KaigoJigyoshaShiteiService(this);
        }
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。
     * 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 8992867731784824094L;

        private final DbT7063KaigoJigyoshaShiteiServiceEntity entity;

        private _SerializationProxy(KaigoJigyoshaShiteiService kaigoJigyoshaShiteiService) {
            this.entity = kaigoJigyoshaShiteiService.entity;
        }

        private Object readResolve() {
            return new KaigoJigyoshaShiteiService(entity);
        }
    }
}
