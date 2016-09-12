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
}
