/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力 Entityクラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoOutDoBillOutEntity {

    private KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity;
    private HihokenshaTempEntity 被保険者一時Entity;
    private Decimal exRenban;
    private RString exHokenshaNo;
    private RString exHokenshaName;
    private RString exShoHokenshaNo;
    private RString exHihokenshaNo;
    private FlexibleYearMonth exServiceTeikyoYm;
    private RString henkanFlag;
    private RString oldShichosonCode;
    private RString sofuHihokenshaNo;
    private RString shichosonCode;
    private RString kannaiKangaiKubun;
    private RString yubinNo;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString gyoseikuMei;
    private RString jusho;
    private RString banchi;
    private RString katagaki;
    private RString kanaMeisho;
    private RString meisho;
    private RString shimei50onKana;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate shikakuShutokuYmd;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuSoshitsuYmd;
    private RString shikakuSoshitsuJiyuCode;
    private RString setaiShuyakuNo;
    private FlexibleDate seinenYmd;
    private RString seibetsuCode;
    private FlexibleDate shichosonKanyuYmd;
    private FlexibleDate shichosonDattaiYmd;
    private Decimal renban;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth taishoYM;
    private RString rirekiNo;
    private FlexibleYearMonth riyoYM;
    private RString kyotakuServiceKubun;
    private RString meisaiNo;
    private RString serviceTeikyoJigyoshaNo;
    private RString serviceShuruiCode;
    private RString serviceKomokuCode;
    private RString taniSu;
    private RString kaisu_Nissu;
    private RString waribikiGoTekiyoRitsu;
    private RString waribikiGoTekiyoTaniSu;
    private RString kyufuTaishoNissu;
    private boolean goukeiFlag;
    private RString shuruiGendoNaiTaniSuNissu;
    private RString shuruiGendoChokaTaniSuNissu;
    private Decimal kubunGendoNaiTaniSuNissu;
    private RString kubunGendoChokaTaniSuNissu;
    private RString taniSuTanka;
    private RString kyufuRitsu;
    private Decimal kyufuKeikakuTaniSu;
    private RString zenkaiRiyoNissu;
    private RString konkaiKeikakuRiyoNissu;
    private RString zanteiKubun;
    private RString koshinKubun;
    private FlexibleDate koshinYMD;
    private FlexibleYearMonth sofuYM;
    private RString hyojiYokaigoJotaiKubunCode;
    private Decimal hyojiShikyuGendoTanisu;
    private RString yokaigoJotaiKubunCode;
    private FlexibleYearMonth ninteiYukoKikanKaishiYM;
    private FlexibleYearMonth ninteiYukoKikanShuryoYM;
    private Decimal shikyuGendoTanisu;
    private FlexibleYearMonth shikyuGendoKaishiYM;
    private FlexibleYearMonth shikyuGendoShuryoYM;
    private RString tankiYokaigoJotaiKubunCode;
    private RString tankiSikyuGendoNissu;
    private FlexibleYearMonth tankiShikyuGendoKaishiYM;
    private FlexibleYearMonth tankiShikyuGendoShuryoYM;
    private RString serviceTeikyoJigyoshaName;
    private RString hokenshaNo;
    private RString hokenshaName;

}
