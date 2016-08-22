/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 構成介護住民票個別事項連携情報[他社住基]Entityクラスです。
 *
 * @reamsid_L DBU-0350-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaigoJuminhyoEntity {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    private RString jushochiTokureiFlag;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private LasdecCode kyuShichosonCode;
    private boolean logicalDeletedFlag;
    private RDateTime insertTimestamp;
    private RDateTime lastUpdateTimestamp;
    private LasdecCode dbT4001ShichosonCode;
    private HihokenshaNo dbT4001HihokenshaNo;
    private RString dbT4001RirekiNo;
    private RString dbT4001Edaban;
    private ShinseishoKanriNo dbT4001ShinseishoKanriNo;
    private RString dbT4001ShinseiJokyoKubun;
    private RString dbT4001ShishoCode;
    private boolean dbT4001ChokkinFlag;
    private ShikibetsuCode dbT4001ShikibetsuCode;
    private Code dbT4001JukyuShinseiJiyu;
    private RString dbT4001ShinseiRiyu;
    private Code dbT4001ShinseishaKankeiCode;
    private RString dbT4001HomninKankei;
    private FlexibleDate dbT4001JukyuShinseiYMD;
    private Code dbT4001NigoTokuteiShippeiCode;
    private FlexibleDate dbT4001ShinsakaiIraiYMD;
    private Code dbT4001YokaigoJotaiKubunCode;
    private FlexibleDate dbT4001NinteiYukoKikanKaishiYMD;
    private FlexibleDate dbT4001NinteiYukoKikanShuryoYMD;
    private FlexibleDate dbT4001NinteiYMD;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui01;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui02;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui03;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui04;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui05;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui06;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui07;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui08;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui09;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui10;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui11;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui12;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui13;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui14;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui15;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui16;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui17;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui18;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui19;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui20;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui21;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui22;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui23;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui24;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui25;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui26;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui27;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui28;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui29;
    private ServiceShuruiCode dbT4001ShiteiServiceShurui30;
    private FlexibleDate dbT4001SoshitsuYMD;
    private FlexibleDate dbT4001ChokkinIdoYMD;
    private Code dbT4001ChokkinIdoJiyuCode;
    private Code dbT4001YukoMukoKubun;
    private Code dbT4001DataKubun;
    private RString dbT4001Remban;
    private RString dbT4001IdoRiyu;
    private Code dbT4001ShinseishoKubun;
    private Code dbT4001SakujoJiyuCode;
    private boolean dbT4001YoshienshaNinteiShinseiFlag;
    private Decimal dbT4001ShikyuGendoTanisu;
    private FlexibleDate dbT4001ShikyuGendoKaishiYMD;
    private FlexibleDate dbT4001ShikyuGendoShuryoYMD;
    private int dbT4001TankiSikyuGendoNissu;
    private FlexibleDate dbT4001TankiShikyuGendoKaishiYMD;
    private FlexibleDate dbT4001TankiShikyuGendoShuryoYMD;
    private FlexibleDate dbT4001ToshoNinteiYukoKaishiYMD;
    private FlexibleDate dbT4001ToshoNinteiYukoShuryoYMD;
    private FlexibleDate dbT4001JukyuShikakuShomeishoHakkoYMD1;
    private FlexibleDate dbT4001JukyuShikakuShomeishoHakkoYMD2;
    private FlexibleDate dbT4001ShindanMeireishoHakkoYMD;
    private FlexibleDate dbT4001NigoShinseiJuriTsuchishoHakkoYMD;
    private FlexibleDate dbT4001NinteiKekkaTsuchishoHakkoYMD;
    private FlexibleDate dbT4001KubunHenkoTsuchishoHakkoYMD;
    private FlexibleDate dbT4001ServiceHenkoTsuchishoHakkoYMD;
    private FlexibleDate dbT4001NinteiKyakkaTsuchishoHakkoYMD;
    private FlexibleDate dbT4001NinteiTorikeshiTsuchishoHakkoYMD;
    private boolean dbT4001ShikakuShutokuMaeShinseiFlag;
    private boolean dbT4001KyuSochishaFlag;
    private boolean dbT4001LogicalDeletedFlag;
    private RDateTime dbT4001InsertTimestamp;
    private RDateTime dbT4001LastUpdateTimestamp;
}
