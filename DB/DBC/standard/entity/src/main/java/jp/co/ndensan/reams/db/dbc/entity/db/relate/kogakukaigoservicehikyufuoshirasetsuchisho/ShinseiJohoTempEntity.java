/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 申請情報一時のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShinseiJohoTempEntity extends DbTableEntityBase<ShinseiJohoTempEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNoJoho;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYMJoho;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNoJoho;
    @PrimaryKey
    private Decimal rirekiNoJoho;
    private FlexibleDate uketsukeYMDJoho;
    private FlexibleDate shinseiYMDJoho;
    private RString shinseiRiyuJoho;
    private RString shinseishaKubunJoho;
    private AtenaMeisho shinseishaShimeiJoho;
    private AtenaKanaMeisho shinseishaShimeiKanaJoho;
    private RString shinseishaJushoJoho;
    private TelNo shinseishaTelNoJoho;
    private JigyoshaNo shinseiJigyoshaNoJoho;
    private RString shiharaiHohoKubunCodeJoho;
    private RString shiharaiBashoJoho;
    private FlexibleDate shiharaiKaishiYMDJoho;
    private FlexibleDate shiharaiShuryoYMDJoho;
    private RString heichoNaiyoJoho;
    private RString shiharaiKaishiTimeJoho;
    private RString shiharaiShuryoTimeJoho;
    private long kozaIDJoho;
    private RString juryoininKeiyakuNoJoho;

    private FlexibleDate ketteiYMDJoho;
    private Decimal honninShiharaiGakuJoho;
    private RString hanteiKekkaShikyuKubunCodeJoho;
    private Decimal shikyuKingakuJoho;
    private RString fushikyuRiyuJoho;
    private RString shinsaHohoKubunJoho;
    private FlexibleYearMonth hanteiKekkaSofuYMJoho;
    private boolean saiSofuFlagJoho;
    private boolean hanteiKekkaSofuFuyoFlagJoho;
    private RString shinsaKekkaHaneiKubunJoho;
    private FlexibleDate ketteiTsuchishoSakuseiYMDJoho;
    private FlexibleDate furikomiMeisaishoSakuseiYMDJoho;

    private Decimal serviceHiyoGokeiGakuGokeiJoho;
    private Decimal riyoshaFutanGakuGokeiJoho;
    private Decimal santeiKijunGakuJoho;
    private Decimal shiharaiSumiKingakuGokeiJoho;
    private Decimal gokeiKogakuShikyuGakuJoho;
    private FlexibleYearMonth gokeiTashoshaUketoriYMJoho;
    private FlexibleYearMonth taishoshaHanteiShinsaYMJoho;
    private RString setaiShuyakuNoJoho;
    private boolean kyokaisoTaishoshaFlagJoho;
    private boolean hojinKeigenTaishoFlagJoho;
    private boolean kogakuTaishoGaiFlagJoho;
    private boolean jidoShokanTaishoFlagJoho;

    private Decimal serviceHiyoGokeiGakuJoho;
    private Decimal meisaiRiyoshaFutanGakuJoho;
    private RString kogakuKyufuKonkyoJoho;
    private FlexibleYearMonth meisaiTaishoshaUketoriYMJoho;
    private JigyoshaNo jigyoshaNoJoho;
    private ServiceShuruiCode serviceShuruiCodeJoho;

    private FlexibleYearMonth ketteishaUketoriYMJoho;
    private RString tsuchishoNoJoho;
    private Decimal ketteiRiyoshaFutanGakuJoho;
    private RString ketteiShikyuKubunCodeJoho;
    private FlexibleYearMonth ketteiYMJoho;
    private Decimal ketteiKogakuShikyuGakuJoho;

    private FlexibleDate idoYMDJoho;
    private RString idoJiyuCodeJoho;
    private LasdecCode shichosonCodeJoho;
    private ShikibetsuCode shikibetsuCodeJoho;
    private RString shikakuShutokuJiyuCodeJoho;
    private FlexibleDate shikakuShutokuYMDJoho;
    private FlexibleDate shikakuShutokuTodokedeYMDJoho;
    private FlexibleDate ichigoShikakuShutokuYMDJoho;
    private RString hihokennshaKubunCodeJoho;
    private RString shikakuSoshitsuJiyuCodeJoho;
    private FlexibleDate shikakuSoshitsuYMDJoho;
    private FlexibleDate shikakuSoshitsuTodokedeYMDJoho;
    private RString shikakuHenkoJiyuCodeJoho;
    private FlexibleDate shikakuHenkoYMDJoho;
    private FlexibleDate shikakuHenkoTodokedeYMDJoho;
    private RString jushochitokureiTekiyoJiyuCodeJoho;
    private FlexibleDate jushochitokureiTekiyoYMDJoho;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMDJoho;
    private RString jushochitokureiKaijoJiyuCodeJoho;
    private FlexibleDate jushochitokureiKaijoYMDJoho;
    private FlexibleDate jushochitokureiKaijoTodokedeYMDJoho;
    private RString jushochiTokureiFlagJoho;
    private RString koikinaiJushochiTokureiFlagJoho;
    private LasdecCode koikinaiTokureiSochimotoShichosonCodeJoho;
    private LasdecCode kyuShichosonCodeJoho;

    /**
     * コンストラクタのメソッドです。
     *
     * @param hihokenshaNoJoho 被保険者番号
     * @param serviceTeikyoYMJoho サービス提供年月
     * @param shoKisaiHokenshaNoJoho 証記載保険者番号
     * @param jigyoshaNoJoho 事業者番号
     * @param serviceShuruiCodeJoho サービス種類コード
     * @param rirekiNoJoho 履歴番号
     * @param uketsukeYMDJoho 受付年月日
     * @param shinseiYMDJoho 申請年月日
     * @param shinseiRiyuJoho 申請理由
     * @param shinseishaKubunJoho 申請者区分
     * @param shinseishaShimeiJoho 申請者氏名
     * @param shinseishaShimeiKanaJoho 申請者氏名カナ
     * @param shinseishaJushoJoho 申請者住所
     * @param shinseishaTelNoJoho 申請者電話番号
     * @param shinseiJigyoshaNoJoho 申請事業者番号
     * @param shiharaiHohoKubunCodeJoho 支払方法区分コード
     * @param shiharaiBashoJoho 支払場所
     * @param shiharaiKaishiYMDJoho 支払期間開始年月日
     * @param shiharaiShuryoYMDJoho 支払期間終了年月日
     * @param heichoNaiyoJoho 閉庁内容
     * @param shiharaiKaishiTimeJoho 支払窓口開始時間
     * @param shiharaiShuryoTimeJoho 支払窓口終了時間
     * @param kozaIDJoho 口座ID
     * @param juryoininKeiyakuNoJoho 受領委任契約番号
     * @param ketteiYMDJoho 決定年月日
     * @param honninShiharaiGakuJoho 本人支払額
     * @param hanteiKekkaShikyuKubunCodeJoho 判定結果・支給区分コード
     * @param shikyuKingakuJoho 支給金額
     * @param fushikyuRiyuJoho 不支給理由
     * @param shinsaHohoKubunJoho 審査方法区分
     * @param hanteiKekkaSofuYMJoho 判定結果送付年月
     * @param saiSofuFlagJoho 再送付フラグ
     * @param hanteiKekkaSofuFuyoFlagJoho 判定結果送付不要フラグ
     * @param shinsaKekkaHaneiKubunJoho 審査結果反映区分
     * @param ketteiTsuchishoSakuseiYMDJoho 決定通知書作成年月日
     * @param furikomiMeisaishoSakuseiYMDJoho 振込明細書作成年月日
     * @param serviceHiyoGokeiGakuGokeiJoho サービス費用合計額合計
     * @param riyoshaFutanGakuGokeiJoho 利用者負担額合計
     * @param santeiKijunGakuJoho 算定基準額
     * @param shiharaiSumiKingakuGokeiJoho 支払済金額合計
     * @param gokeiKogakuShikyuGakuJoho 合計・高額支給額
     * @param gokeiTashoshaUketoriYMJoho 合計・対象者受取年月
     * @param taishoshaHanteiShinsaYMJoho 対象者判定審査年月
     * @param setaiShuyakuNoJoho 世帯集約番号
     * @param kyokaisoTaishoshaFlagJoho 境界層対象者フラグ
     * @param hojinKeigenTaishoFlagJoho 社会福祉法人軽減対象者フラグ
     * @param kogakuTaishoGaiFlagJoho 高額対象外フラグ
     * @param jidoShokanTaishoFlagJoho 自動償還対象フラグ
     * @param serviceHiyoGokeiGakuJoho サービス費用合計額
     * @param meisaiRiyoshaFutanGakuJoho 明細・利用者負担額
     * @param kogakuKyufuKonkyoJoho 高額給付根拠
     * @param meisaiTaishoshaUketoriYMJoho 明細・対象者受取年月
     * @param ketteishaUketoriYMJoho 決定者受取年月
     * @param tsuchishoNoJoho 通知書番号
     * @param ketteiRiyoshaFutanGakuJoho 決定・利用者負担額
     * @param ketteiShikyuKubunCodeJoho 決定・支給区分コード
     * @param ketteiYMJoho 決定年月
     * @param ketteiKogakuShikyuGakuJoho 決定・高額支給額
     * @param idoYMDJoho 異動日
     * @param idoJiyuCodeJoho 異動事由コード
     * @param shichosonCodeJoho 市町村コード
     * @param shikibetsuCodeJoho 識別コード
     * @param shikakuShutokuJiyuCodeJoho 資格取得事由コード
     * @param shikakuShutokuYMDJoho 資格取得年月日
     * @param shikakuShutokuTodokedeYMDJoho 資格取得届出年月日
     * @param ichigoShikakuShutokuYMDJoho 第1号資格取得年月日
     * @param hihokennshaKubunCodeJoho 被保険者区分コード
     * @param shikakuSoshitsuJiyuCodeJoho 資格喪失事由コード
     * @param shikakuSoshitsuYMDJoho 資格喪失年月日
     * @param shikakuSoshitsuTodokedeYMDJoho 資格喪失届出年月日
     * @param shikakuHenkoJiyuCodeJoho 資格変更事由コード
     * @param shikakuHenkoYMDJoho 資格変更年月日
     * @param shikakuHenkoTodokedeYMDJoho 資格変更届出年月日
     * @param jushochitokureiTekiyoJiyuCodeJoho 住所地特例適用事由コード
     * @param jushochitokureiTekiyoYMDJoho 適用年月日
     * @param jushochitokureiTekiyoTodokedeYMDJoho 適用届出年月日
     * @param jushochitokureiKaijoJiyuCodeJoho 住所地特例解除事由コード
     * @param jushochitokureiKaijoYMDJoho 解除年月日
     * @param jushochitokureiKaijoTodokedeYMDJoho 解除届出年月日
     * @param jushochiTokureiFlagJoho 住所地特例フラグ
     * @param koikinaiJushochiTokureiFlagJoho 広域内住所地特例フラグ
     * @param koikinaiTokureiSochimotoShichosonCodeJoho 広住特措置元市町村コード
     * @param kyuShichosonCodeJoho 旧市町村コード
     */
    public ShinseiJohoTempEntity(HihokenshaNo hihokenshaNoJoho, FlexibleYearMonth serviceTeikyoYMJoho, HokenshaNo shoKisaiHokenshaNoJoho,
            Decimal rirekiNoJoho, FlexibleDate uketsukeYMDJoho, FlexibleDate shinseiYMDJoho, RString shinseiRiyuJoho, RString shinseishaKubunJoho,
            AtenaMeisho shinseishaShimeiJoho, AtenaKanaMeisho shinseishaShimeiKanaJoho, RString shinseishaJushoJoho, TelNo shinseishaTelNoJoho,
            JigyoshaNo shinseiJigyoshaNoJoho, RString shiharaiHohoKubunCodeJoho, RString shiharaiBashoJoho, FlexibleDate shiharaiKaishiYMDJoho,
            FlexibleDate shiharaiShuryoYMDJoho, RString heichoNaiyoJoho, RString shiharaiKaishiTimeJoho, RString shiharaiShuryoTimeJoho,
            long kozaIDJoho, RString juryoininKeiyakuNoJoho, FlexibleDate ketteiYMDJoho, Decimal honninShiharaiGakuJoho,
            RString hanteiKekkaShikyuKubunCodeJoho, Decimal shikyuKingakuJoho, RString fushikyuRiyuJoho, RString shinsaHohoKubunJoho,
            FlexibleYearMonth hanteiKekkaSofuYMJoho, boolean saiSofuFlagJoho, boolean hanteiKekkaSofuFuyoFlagJoho, RString shinsaKekkaHaneiKubunJoho,
            FlexibleDate ketteiTsuchishoSakuseiYMDJoho, FlexibleDate furikomiMeisaishoSakuseiYMDJoho, Decimal serviceHiyoGokeiGakuGokeiJoho,
            Decimal riyoshaFutanGakuGokeiJoho, Decimal santeiKijunGakuJoho, Decimal shiharaiSumiKingakuGokeiJoho, Decimal gokeiKogakuShikyuGakuJoho,
            FlexibleYearMonth gokeiTashoshaUketoriYMJoho, FlexibleYearMonth taishoshaHanteiShinsaYMJoho, RString setaiShuyakuNoJoho,
            boolean kyokaisoTaishoshaFlagJoho, boolean hojinKeigenTaishoFlagJoho, boolean kogakuTaishoGaiFlagJoho, boolean jidoShokanTaishoFlagJoho,
            Decimal serviceHiyoGokeiGakuJoho, Decimal meisaiRiyoshaFutanGakuJoho, RString kogakuKyufuKonkyoJoho,
            FlexibleYearMonth meisaiTaishoshaUketoriYMJoho, JigyoshaNo jigyoshaNoJoho, ServiceShuruiCode serviceShuruiCodeJoho,
            FlexibleYearMonth ketteishaUketoriYMJoho, RString tsuchishoNoJoho, Decimal ketteiRiyoshaFutanGakuJoho, RString ketteiShikyuKubunCodeJoho,
            FlexibleYearMonth ketteiYMJoho, Decimal ketteiKogakuShikyuGakuJoho, FlexibleDate idoYMDJoho,
            RString idoJiyuCodeJoho, LasdecCode shichosonCodeJoho, ShikibetsuCode shikibetsuCodeJoho, RString shikakuShutokuJiyuCodeJoho,
            FlexibleDate shikakuShutokuYMDJoho, FlexibleDate shikakuShutokuTodokedeYMDJoho, FlexibleDate ichigoShikakuShutokuYMDJoho,
            RString hihokennshaKubunCodeJoho, RString shikakuSoshitsuJiyuCodeJoho, FlexibleDate shikakuSoshitsuYMDJoho,
            FlexibleDate shikakuSoshitsuTodokedeYMDJoho, RString shikakuHenkoJiyuCodeJoho, FlexibleDate shikakuHenkoYMDJoho,
            FlexibleDate shikakuHenkoTodokedeYMDJoho, RString jushochitokureiTekiyoJiyuCodeJoho, FlexibleDate jushochitokureiTekiyoYMDJoho,
            FlexibleDate jushochitokureiTekiyoTodokedeYMDJoho, RString jushochitokureiKaijoJiyuCodeJoho, FlexibleDate jushochitokureiKaijoYMDJoho,
            FlexibleDate jushochitokureiKaijoTodokedeYMDJoho, RString jushochiTokureiFlagJoho, RString koikinaiJushochiTokureiFlagJoho,
            LasdecCode koikinaiTokureiSochimotoShichosonCodeJoho, LasdecCode kyuShichosonCodeJoho) {
        this.hihokenshaNoJoho = hihokenshaNoJoho;
        this.serviceTeikyoYMJoho = serviceTeikyoYMJoho;
        this.shoKisaiHokenshaNoJoho = shoKisaiHokenshaNoJoho;
        this.rirekiNoJoho = rirekiNoJoho;
        this.uketsukeYMDJoho = uketsukeYMDJoho;
        this.shinseiYMDJoho = shinseiYMDJoho;
        this.shinseiRiyuJoho = shinseiRiyuJoho;
        this.shinseishaKubunJoho = shinseishaKubunJoho;
        this.shinseishaShimeiJoho = shinseishaShimeiJoho;
        this.shinseishaShimeiKanaJoho = shinseishaShimeiKanaJoho;
        this.shinseishaJushoJoho = shinseishaJushoJoho;
        this.shinseishaTelNoJoho = shinseishaTelNoJoho;
        this.shinseiJigyoshaNoJoho = shinseiJigyoshaNoJoho;
        this.shiharaiHohoKubunCodeJoho = shiharaiHohoKubunCodeJoho;
        this.shiharaiBashoJoho = shiharaiBashoJoho;
        this.shiharaiKaishiYMDJoho = shiharaiKaishiYMDJoho;
        this.shiharaiShuryoYMDJoho = shiharaiShuryoYMDJoho;
        this.heichoNaiyoJoho = heichoNaiyoJoho;
        this.shiharaiKaishiTimeJoho = shiharaiKaishiTimeJoho;
        this.shiharaiShuryoTimeJoho = shiharaiShuryoTimeJoho;
        this.kozaIDJoho = kozaIDJoho;
        this.juryoininKeiyakuNoJoho = juryoininKeiyakuNoJoho;
        this.ketteiYMDJoho = ketteiYMDJoho;
        this.honninShiharaiGakuJoho = honninShiharaiGakuJoho;
        this.hanteiKekkaShikyuKubunCodeJoho = hanteiKekkaShikyuKubunCodeJoho;
        this.shikyuKingakuJoho = shikyuKingakuJoho;
        this.fushikyuRiyuJoho = fushikyuRiyuJoho;
        this.shinsaHohoKubunJoho = shinsaHohoKubunJoho;
        this.hanteiKekkaSofuYMJoho = hanteiKekkaSofuYMJoho;
        this.saiSofuFlagJoho = saiSofuFlagJoho;
        this.hanteiKekkaSofuFuyoFlagJoho = hanteiKekkaSofuFuyoFlagJoho;
        this.shinsaKekkaHaneiKubunJoho = shinsaKekkaHaneiKubunJoho;
        this.ketteiTsuchishoSakuseiYMDJoho = ketteiTsuchishoSakuseiYMDJoho;
        this.furikomiMeisaishoSakuseiYMDJoho = furikomiMeisaishoSakuseiYMDJoho;
        this.serviceHiyoGokeiGakuGokeiJoho = serviceHiyoGokeiGakuGokeiJoho;
        this.riyoshaFutanGakuGokeiJoho = riyoshaFutanGakuGokeiJoho;
        this.santeiKijunGakuJoho = santeiKijunGakuJoho;
        this.shiharaiSumiKingakuGokeiJoho = shiharaiSumiKingakuGokeiJoho;
        this.gokeiKogakuShikyuGakuJoho = gokeiKogakuShikyuGakuJoho;
        this.gokeiTashoshaUketoriYMJoho = gokeiTashoshaUketoriYMJoho;
        this.taishoshaHanteiShinsaYMJoho = taishoshaHanteiShinsaYMJoho;
        this.setaiShuyakuNoJoho = setaiShuyakuNoJoho;
        this.kyokaisoTaishoshaFlagJoho = kyokaisoTaishoshaFlagJoho;
        this.hojinKeigenTaishoFlagJoho = hojinKeigenTaishoFlagJoho;
        this.kogakuTaishoGaiFlagJoho = kogakuTaishoGaiFlagJoho;
        this.jidoShokanTaishoFlagJoho = jidoShokanTaishoFlagJoho;
        this.serviceHiyoGokeiGakuJoho = serviceHiyoGokeiGakuJoho;
        this.meisaiRiyoshaFutanGakuJoho = meisaiRiyoshaFutanGakuJoho;
        this.kogakuKyufuKonkyoJoho = kogakuKyufuKonkyoJoho;
        this.meisaiTaishoshaUketoriYMJoho = meisaiTaishoshaUketoriYMJoho;
        this.jigyoshaNoJoho = jigyoshaNoJoho;
        this.serviceShuruiCodeJoho = serviceShuruiCodeJoho;
        this.ketteishaUketoriYMJoho = ketteishaUketoriYMJoho;
        this.tsuchishoNoJoho = tsuchishoNoJoho;
        this.ketteiRiyoshaFutanGakuJoho = ketteiRiyoshaFutanGakuJoho;
        this.ketteiShikyuKubunCodeJoho = ketteiShikyuKubunCodeJoho;
        this.ketteiYMJoho = ketteiYMJoho;
        this.ketteiKogakuShikyuGakuJoho = ketteiKogakuShikyuGakuJoho;
        this.idoYMDJoho = idoYMDJoho;
        this.idoJiyuCodeJoho = idoJiyuCodeJoho;
        this.shichosonCodeJoho = shichosonCodeJoho;
        this.shikibetsuCodeJoho = shikibetsuCodeJoho;
        this.shikakuShutokuJiyuCodeJoho = shikakuShutokuJiyuCodeJoho;
        this.shikakuShutokuYMDJoho = shikakuShutokuYMDJoho;
        this.shikakuShutokuTodokedeYMDJoho = shikakuShutokuTodokedeYMDJoho;
        this.ichigoShikakuShutokuYMDJoho = ichigoShikakuShutokuYMDJoho;
        this.hihokennshaKubunCodeJoho = hihokennshaKubunCodeJoho;
        this.shikakuSoshitsuJiyuCodeJoho = shikakuSoshitsuJiyuCodeJoho;
        this.shikakuSoshitsuYMDJoho = shikakuSoshitsuYMDJoho;
        this.shikakuSoshitsuTodokedeYMDJoho = shikakuSoshitsuTodokedeYMDJoho;
        this.shikakuHenkoJiyuCodeJoho = shikakuHenkoJiyuCodeJoho;
        this.shikakuHenkoYMDJoho = shikakuHenkoYMDJoho;
        this.shikakuHenkoTodokedeYMDJoho = shikakuHenkoTodokedeYMDJoho;
        this.jushochitokureiTekiyoJiyuCodeJoho = jushochitokureiTekiyoJiyuCodeJoho;
        this.jushochitokureiTekiyoYMDJoho = jushochitokureiTekiyoYMDJoho;
        this.jushochitokureiTekiyoTodokedeYMDJoho = jushochitokureiTekiyoTodokedeYMDJoho;
        this.jushochitokureiKaijoJiyuCodeJoho = jushochitokureiKaijoJiyuCodeJoho;
        this.jushochitokureiKaijoYMDJoho = jushochitokureiKaijoYMDJoho;
        this.jushochitokureiKaijoTodokedeYMDJoho = jushochitokureiKaijoTodokedeYMDJoho;
        this.jushochiTokureiFlagJoho = jushochiTokureiFlagJoho;
        this.koikinaiJushochiTokureiFlagJoho = koikinaiJushochiTokureiFlagJoho;
        this.koikinaiTokureiSochimotoShichosonCodeJoho = koikinaiTokureiSochimotoShichosonCodeJoho;
        this.kyuShichosonCodeJoho = kyuShichosonCodeJoho;
    }

    public ShinseiJohoTempEntity() {
    }
}
