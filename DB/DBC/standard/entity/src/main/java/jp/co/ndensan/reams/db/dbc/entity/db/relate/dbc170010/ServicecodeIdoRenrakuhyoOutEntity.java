/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 出力対象データのエンティティクラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIdoRenrakuhyoOutEntity {

    private ServiceShuruiCode serviceShuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private FlexibleYearMonth tekiyoKaishiYM;
    private int rirekiNo;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString serviceMeisho;
    private Decimal taniSu;
    private RString gendoGakuTaishogaiFlag;
    private RString taniSuShikibetsuCode;
    private RString gaibuServiceRiyoKubun;
    private RString tokubetsuChiikiKasanFlag;
    private RString teiRitsu_TeiGakuKubun;
    private Decimal riyoshaFutanGaku;
    private HokenKyufuRitsu kyufuRitsu;
    private RString nijiYoboTaishosha_JissiKubun;
    private RString yoShien1_JisshiKubun;
    private RString yoShien2_JisshiKubun;
    private RString taishoJigyosha_JisshiKubun;
    private RString santeiTaniKubun;
    private int seigenNissuKaisu;
    private RString santeiKaisuSeigenKikanKubun;
    private RString sofuKubun;
    private FlexibleYearMonth sofuYM;
    private FlexibleDate shinkiHenkoIdoYMD;
    private FlexibleDate shuryoIdoYMD;
    private int サービスコード件数;
}
