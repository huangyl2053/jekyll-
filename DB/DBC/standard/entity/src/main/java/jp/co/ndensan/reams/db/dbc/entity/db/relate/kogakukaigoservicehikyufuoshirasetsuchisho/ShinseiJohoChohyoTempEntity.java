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
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 申請情報帳票発行一時のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShinseiJohoChohyoTempEntity extends DbTableEntityBase<ShinseiJohoChohyoTempEntity> implements IDbAccessable {

    private HihokenshaNo hihokenshaNoChohyo;
    private FlexibleYearMonth serviceTeikyoYMChohyo;
    private HokenshaNo shoKisaiHokenshaNoChohyo;
    private Decimal rirekiNoChohyo;
    private FlexibleDate uketsukeYMDChohyo;
    private FlexibleDate shinseiYMDChohyo;
    private RString shinseiRiyuChohyo;
    private RString shinseishaKubunChohyo;
    private AtenaMeisho shinseishaShimeiChohyo;
    private AtenaKanaMeisho shinseishaShimeiKanaChohyo;
    private RString shinseishaJushoChohyo;
    private TelNo shinseishaTelNoChohyo;
    private JigyoshaNo shinseiJigyoshaNoChohyo;
    private RString shiharaiHohoKubunCodeChohyo;
    private RString shiharaiBashoChohyo;
    private FlexibleDate shiharaiKaishiYMDChohyo;
    private FlexibleDate shiharaiShuryoYMDChohyo;
    private RString heichoNaiyoChohyo;
    private RString shiharaiKaishiTimeChohyo;
    private RString shiharaiShuryoTimeChohyo;
    private long kozaIDChohyo;
    private RString juryoininKeiyakuNoChohyo;

    private FlexibleDate ketteiYMDChohyo;
    private Decimal honninShiharaiGakuChohyo;
    private RString hanteiKekkaShikyuKubunCodeChohyo;
    private Decimal shikyuKingakuChohyo;
    private RString fushikyuRiyuChohyo;
    private RString shinsaHohoKubunChohyo;
    private FlexibleYearMonth hanteiKekkaSofuYMChohyo;
    private boolean saiSofuFlagChohyo;
    private boolean hanteiKekkaSofuFuyoFlagChohyo;
    private RString shinsaKekkaHaneiKubunChohyo;
    private FlexibleDate ketteiTsuchishoSakuseiYMDChohyo;
    private FlexibleDate furikomiMeisaishoSakuseiYMDChohyo;

    private Decimal serviceHiyoGokeiGakuGokeiChohyo;
    private Decimal riyoshaFutanGakuGokeiChohyo;
    private Decimal santeiKijunGakuChohyo;
    private Decimal shiharaiSumiKingakuGokeiChohyo;
    private Decimal gokeiKogakuShikyuGakuChohyo;
    private FlexibleYearMonth gokeiTashoshaUketoriYMChohyo;
    private FlexibleYearMonth taishoshaHanteiShinsaYMChohyo;
    private RString setaiShuyakuNoChohyo;
    private boolean kyokaisoTaishoshaFlagChohyo;
    private boolean hojinKeigenTaishoFlagChohyo;
    private boolean kogakuTaishoGaiFlagChohyo;
    private boolean jidoShokanTaishoFlagChohyo;

    private Decimal serviceHiyoGokeiGakuChohyo;
    private Decimal meisaiRiyoshaFutanGakuChohyo;
    private RString kogakuKyufuKonkyoChohyo;
    private FlexibleYearMonth meisaiTaishoshaUketoriYMChohyo;
    private JigyoshaNo jigyoshaNoChohyo;
    private ServiceShuruiCode serviceShuruiCodeChohyo;

    private FlexibleYearMonth ketteishaUketoriYMChohyo;
    private RString tsuchishoNoChohyo;
    private Decimal ketteiRiyoshaFutanGakuChohyo;
    private RString ketteiShikyuKubunCodeChohyo;
    private FlexibleYearMonth ketteiYMChohyo;
    private Decimal ketteiKogakuShikyuGakuChohyo;

    private FlexibleDate idoYMDChohyo;
    private RString idoJiyuCodeChohyo;
    private LasdecCode shichosonCodeChohyo;
    private ShikibetsuCode shikibetsuCodeChohyo;
    private RString shikakuShutokuJiyuCodeChohyo;
    private FlexibleDate shikakuShutokuYMDChohyo;
    private FlexibleDate shikakuShutokuTodokedeYMDChohyo;
    private FlexibleDate ichigoShikakuShutokuYMDChohyo;
    private RString hihokennshaKubunCodeChohyo;
    private RString shikakuSoshitsuJiyuCodeChohyo;
    private FlexibleDate shikakuSoshitsuYMDChohyo;
    private FlexibleDate shikakuSoshitsuTodokedeYMDChohyo;
    private RString shikakuHenkoJiyuCodeChohyo;
    private FlexibleDate shikakuHenkoYMDChohyo;
    private FlexibleDate shikakuHenkoTodokedeYMDChohyo;
    private RString jushochitokureiTekiyoJiyuCodeChohyo;
    private FlexibleDate jushochitokureiTekiyoYMDChohyo;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMDChohyo;
    private RString jushochitokureiKaijoJiyuCodeChohyo;
    private FlexibleDate jushochitokureiKaijoYMDChohyo;
    private FlexibleDate jushochitokureiKaijoTodokedeYMDChohyo;
    private RString jushochiTokureiFlagChohyo;
    private RString koikinaiJushochiTokureiFlagChohyo;
    private LasdecCode koikinaiTokureiSochimotoShichosonCodeChohyo;
    private LasdecCode kyuShichosonCodeChohyo;
    private boolean kyuSochishaFlagChohyo;
    private Code yokaigoJotaiKubunCodeChohyo;
    private FlexibleDate ninteiYukoKikanKaishiYMDChohyo;
    private FlexibleDate ninteiYukoKikanShuryoYMDChohyo;

    private AtenaMeisho meishoChohyo;
    private AtenaKanaMeisho shimeikanaChohyo;
    private AtenaJusho jushoChohyo;
    private YubinNo yubinNoChohyo;
    private GyoseikuCode gyoseikuCodeChohyo;
    private RString gyoseikuNameChohyo;
    private FlexibleDate seinengappiYMDChohyo;
    private RString seibetsuCodeChohyo;
    private TelNo telNoChohyo;
    private KojinNo kojinNoChohyo;

    private KinyuKikanCode kinyuKikanCodeChohyo;
    private RString tsuchoKigoChohyo;
    private RString tsuchoNoChohyo;

    private RString ininjoTeishutsusakiChohyo;
}
