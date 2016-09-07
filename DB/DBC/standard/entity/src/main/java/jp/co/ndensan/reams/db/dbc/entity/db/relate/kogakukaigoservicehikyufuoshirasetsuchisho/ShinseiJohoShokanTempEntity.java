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
 * 申請情報償還一時のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShinseiJohoShokanTempEntity extends DbTableEntityBase<ShinseiJohoShokanTempEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNoShokan;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYMShokan;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNoShokan;
    @PrimaryKey
    private Decimal rirekiNoShokan;
    private FlexibleDate uketsukeYMDShokan;
    private FlexibleDate shinseiYMDShokan;
    private RString shinseiRiyuShokan;
    private RString shinseishaKubunShokan;
    private AtenaMeisho shinseishaShimeiShokan;
    private AtenaKanaMeisho shinseishaShimeiKanaShokan;
    private RString shinseishaJushoShokan;
    private TelNo shinseishaTelNoShokan;
    private JigyoshaNo shinseiJigyoshaNoShokan;
    private RString shiharaiHohoKubunCodeShokan;
    private RString shiharaiBashoShokan;
    private FlexibleDate shiharaiKaishiYMDShokan;
    private FlexibleDate shiharaiShuryoYMDShokan;
    private RString heichoNaiyoShokan;
    private RString shiharaiKaishiTimeShokan;
    private RString shiharaiShuryoTimeShokan;
    private long kozaIDShokan;
    private RString juryoininKeiyakuNoShokan;

    private FlexibleDate ketteiYMDShokan;
    private Decimal honninShiharaiGakuShokan;
    private RString hanteiKekkaShikyuKubunCodeShokan;
    private Decimal shikyuKingakuShokan;
    private RString fushikyuRiyuShokan;
    private RString shinsaHohoKubunShokan;
    private FlexibleYearMonth hanteiKekkaSofuYMShokan;
    private boolean saiSofuFlagShokan;
    private boolean hanteiKekkaSofuFuyoFlagShokan;
    private RString shinsaKekkaHaneiKubunShokan;
    private FlexibleDate ketteiTsuchishoSakuseiYMDShokan;
    private FlexibleDate furikomiMeisaishoSakuseiYMDShokan;

    private Decimal serviceHiyoGokeiGakuGokeiShokan;
    private Decimal riyoshaFutanGakuGokeiShokan;
    private Decimal santeiKijunGakuShokan;
    private Decimal shiharaiSumiKingakuGokeiShokan;
    private Decimal gokeiKogakuShikyuGakuShokan;
    private FlexibleYearMonth gokeiTashoshaUketoriYMShokan;
    private FlexibleYearMonth taishoshaHanteiShinsaYMShokan;
    private RString setaiShuyakuNoShokan;
    private boolean kyokaisoTaishoshaFlagShokan;
    private boolean hojinKeigenTaishoFlagShokan;
    private boolean kogakuTaishoGaiFlagShokan;
    private boolean jidoShokanTaishoFlagShokan;

    private Decimal serviceHiyoGokeiGakuShokan;
    private Decimal meisaiRiyoshaFutanGakuShokan;
    private RString kogakuKyufuKonkyoShokan;
    private FlexibleYearMonth meisaiTaishoshaUketoriYMShokan;
    private JigyoshaNo jigyoshaNoShokan;
    private ServiceShuruiCode serviceShuruiCodeShokan;

    private FlexibleYearMonth ketteishaUketoriYMShokan;
    private RString tsuchishoNoShokan;
    private Decimal ketteiRiyoshaFutanGakuShokan;
    private RString ketteiShikyuKubunCodeShokan;
    private FlexibleYearMonth ketteiYMShokan;
    private Decimal ketteiKogakuShikyuGakuShokan;

    private FlexibleDate idoYMDShokan;
    private RString idoJiyuCodeShokan;
    private LasdecCode shichosonCodeShokan;
    private ShikibetsuCode shikibetsuCodeShokan;
    private RString shikakuShutokuJiyuCodeShokan;
    private FlexibleDate shikakuShutokuYMDShokan;
    private FlexibleDate shikakuShutokuTodokedeYMDShokan;
    private FlexibleDate ichigoShikakuShutokuYMDShokan;
    private RString hihokennshaKubunCodeShokan;
    private RString shikakuSoshitsuJiyuCodeShokan;
    private FlexibleDate shikakuSoshitsuYMDShokan;
    private FlexibleDate shikakuSoshitsuTodokedeYMDShokan;
    private RString shikakuHenkoJiyuCodeShokan;
    private FlexibleDate shikakuHenkoYMDShokan;
    private FlexibleDate shikakuHenkoTodokedeYMDShokan;
    private RString jushochitokureiTekiyoJiyuCodeShokan;
    private FlexibleDate jushochitokureiTekiyoYMDShokan;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMDShokan;
    private RString jushochitokureiKaijoJiyuCodeShokan;
    private FlexibleDate jushochitokureiKaijoYMDShokan;
    private FlexibleDate jushochitokureiKaijoTodokedeYMDShokan;
    private RString jushochiTokureiFlagShokan;
    private RString koikinaiJushochiTokureiFlagShokan;
    private LasdecCode koikinaiTokureiSochimotoShichosonCodeShokan;
    private LasdecCode kyuShichosonCodeShokan;

    /**
     * コンストラクタのメソッドです。
     */
    public ShinseiJohoShokanTempEntity() {
    }
}
