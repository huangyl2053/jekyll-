/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710080;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.KagoMoshitateJukyoshaRealEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.NijiYoboJigyoTaishoRealEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト(給付管理票)のエンティティクラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyufuKanriHyoEntity {

    private boolean isDeleted = false;
    private FlexibleYearMonth shinsaYM;
    private FlexibleYearMonth serviceTeikyoYM;
    private HihokenshaNo hiHokenshaNo;
    private RString kyufuShubetsuKubunCode;
    private RString kyufuMeisaiLineNo;
    private HokenshaNo shokisaiHokenshaNo;
    private JigyoshaNo kyotakushienJigyoshoNo;
    private RString kyufuSakuseiKubunCode;
    private FlexibleDate kyufuSakuseiYMD;
    private HokenshaNo hokenshaNo;
    private FlexibleDate hiHokenshaUmareYMD;
    private RString seibetsuCode;
    private RString yoKaigoJotaiKubunCode;
    private FlexibleYearMonth gendogakuTekiyoKaishiYM;
    private FlexibleYearMonth gendogakuTekiyoShuryoYM;
    private int kyotakuKaigoYoboShikyuGendogaku;
    private RString kyotakuServicePlanSakuseiKubunCode;
    private JigyoshaNo serviceJigyoshoNo;
    private RString shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    private ServiceShuruiCode serviceShuruiCode;
    private int kyufuKeikakuTanisuNissu;
    private int kyufuKeikakuNissu;
    private int shiteiServiceSubTotal;
    private int kijyunGaitoServiceSubTotal;
    private int kyufuKeikakuTotalTanisuNissu;
    private RString tantoKaigoShienSemmoninNo;
    private JigyoshaNo kaigoShienJigyoshaNo;
    private RString itakusakiTantoKaigoShienSemmoninNo;
    private FlexibleDate toshoTorokuYMD;
    private FlexibleYearMonth torikomiYM;
    private DbT1001HihokenshaDaichoEntity 最新被保台帳;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private JukyushaDaichoKyufuKanriHyoEntity 受給者台帳;
    private DbT7130KaigoServiceShuruiEntity サービス種類;
    private KagoMoshitateJukyoshaRealEntity 計画事業者;
    private KagoMoshitateJukyoshaRealEntity サービス事業者;
    private KagoMoshitateJukyoshaRealEntity 居宅支援事業者;
    private NijiYoboJigyoTaishoRealEntity 二次予防事業対象情報;
}
