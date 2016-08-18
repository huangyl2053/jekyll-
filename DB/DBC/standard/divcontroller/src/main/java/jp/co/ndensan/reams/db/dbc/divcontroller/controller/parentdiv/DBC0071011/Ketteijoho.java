/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0071011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensakubusiness.TaishoshaKensakuRelateBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensakumybatisprm.TaishoshaKensakuMybitisParamter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011.KetteijohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011.KetteijohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011.KetteijohoValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.taishoshakensakuservice.TaishoshaKensakuRelateFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「過誤申立決定情報照会」のクラスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
public class Ketteijoho {

    private static final RString キー = new RString("000000");
    private static final RString 保険者区分_1 = new RString("1");
    private static final RString 保険者区分_3 = new RString("3");
    private static final RString 保険者区分_2 = new RString("2");
    private static final RString 保険者区分_4 = new RString("4");
    private static final RString 保険者区分_5 = new RString("5");
    private static final int 連番_5 = 5;
    private static final RString 過誤申立事由 = new RString("0016");
    private static final RString 経過措置 = new RString("0049");
    private static final RString 総合事業過誤申立事由 = new RString("0053");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KetteijohoDiv
     * @return 過誤申立決定情報照会
     */
    public ResponseData<KetteijohoDiv> onLoad(KetteijohoDiv div) {
        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(UrControlDataFactory
                .createInstance().getLoginInfo().getUserId());
        List<KoikiZenShichosonJoho> 構成市町村 = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        getHandler(div).onLoad(市町村情報, 市町村識別ID, 構成市町村);
        return ResponseData.of(div).respond();
    }

    /**
     * 「取扱年月を指定して表示する」ボタンを押下です。
     *
     * @param div KetteijohoDiv
     * @return 過誤申立決定情報照会
     */
    public ResponseData<KetteijohoDiv> onClick_btnSearch(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 市町村コード = RString.EMPTY;
        boolean 市町村フラグ = false;
        if (!div.getDdlShichosonName().getDataSource().isEmpty() && !キー.equals(div.getDdlShichosonName().getSelectedKey())) {
            市町村コード = div.getDdlShichosonName().getSelectedKey().substring(0, 連番_5);
            市町村フラグ = true;
        }
        List<TaishoshaKensakuRelateBusiness> 保険者Business = get明細情報(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue()
                .getYearMonth().toDateString()), 保険者区分_1, Decimal.ZERO, 市町村コード, 過誤申立事由, false, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 公費負担者Business = get明細情報(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue()
                .getYearMonth().toDateString()), 保険者区分_2, Decimal.ZERO, 市町村コード, 過誤申立事由, false, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 経過措置Business = get明細情報(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue()
                .getYearMonth().toDateString()), 保険者区分_3, Decimal.ZERO, 市町村コード, 経過措置, false, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 総合事業費保険者Business = get明細情報(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue()
                .getYearMonth().toDateString()), 保険者区分_4, Decimal.ZERO, 市町村コード, 総合事業過誤申立事由, false, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 総合事業費公費負担者Business = get明細情報(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue()
                .getYearMonth().toDateString()), 保険者区分_5, Decimal.ZERO, 市町村コード, 総合事業過誤申立事由, false, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 履歴番号Business = get履歴番号(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue()
                .getYearMonth().toDateString()), 市町村コード, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 再審査決定情報Business = getHandler(div).
                onClick_btnSearch(保険者Business, 公費負担者Business, 経過措置Business, 総合事業費保険者Business, 総合事業費公費負担者Business, 履歴番号Business);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).過誤申立決定情報照会(再審査決定情報Business);
        if (!RString.isNullOrEmpty(div.getKubunn())) {
            getHandler(div).set過誤決定情報(再審査決定情報Business, div.getKubunn(), 履歴番号Business);
        }
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保険者情報」ボタン押下の場合、処理を行きます。
     *
     * @param div KetteijohoDiv
     * @return 保険者情報
     */
    public ResponseData<KetteijohoDiv> onClick_btnHokneshaJoho(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_1, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費（経過措置）保険者情報」ボタン押下の場合、処理を行きます。
     *
     * @param div KetteijohoDiv
     * @return 経過措置保険者情報
     */
    public ResponseData<KetteijohoDiv> onClick_btnSogojigyohiKeikasochiHokenshaJoho(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_3, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費保険者情報」ボタン押下の場合、処理を行きます。
     *
     * @param div KetteijohoDiv
     * @return 総合事業費保険者情報
     */
    public ResponseData<KetteijohoDiv> onClick_btnSogojigyohiHokenshaJoho(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_4, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「公費負担者情報」ボタン押下の場合、処理を行きます。
     *
     * @param div KetteijohoDiv
     * @return 公費負担者情報
     */
    public ResponseData<KetteijohoDiv> onClick_btnKohoFutanshaJoho(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_2, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費公費負担者情報」ボタン押下の場合、処理を行きます。
     *
     * @param div KetteijohoDiv
     * @return 総合事業費公費負担者情報
     */
    public ResponseData<KetteijohoDiv> onClick_btnSogojigyohiKohiFutanshaJoho(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_5, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴番号DDL表示制御を変更です。
     *
     * @param div KetteijohoDiv
     * @return 履歴番号
     */
    public ResponseData<KetteijohoDiv> onChange_Rireki(KetteijohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakutei();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 履歴番号 = div.getDdlShichosonName().getSelectedKey();
        get保険者情報(div, div.getKubunn(), true);
        div.getDdlShichosonName().setSelectedKey(履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村指定DDL表示制御を変更です。
     *
     * @param div KetteijohoDiv
     * @return 再審査申立決定情報照会
     */
    public ResponseData<KetteijohoDiv> onChange_Shichousonn(KetteijohoDiv div) {
        getHandler(div).onChange_Shichousonn();
        return ResponseData.of(div).respond();
    }

    private ResponseData<KetteijohoDiv> get保険者情報(KetteijohoDiv div, RString 保険者区分, boolean 履歴番号フラグ) {
        RString 市町村コード = RString.EMPTY;
        RString コード種別 = RString.EMPTY;
        boolean 市町村フラグ = false;
        if (!div.getDdlShichosonName().getDataSource().isEmpty() && !キー.equals(div.getDdlShichosonName().getSelectedKey())) {
            市町村コード = div.getDdlShichosonName().getSelectedKey().substring(0, 連番_5);
            市町村フラグ = true;
        }
        if (保険者区分_1.equals(保険者区分) || 保険者区分_2.equals(保険者区分)) {
            コード種別 = 過誤申立事由;
        } else if (保険者区分_3.equals(保険者区分)) {
            コード種別 = 経過措置;
        } else if (保険者区分_4.equals(保険者区分) || 保険者区分_5.equals(保険者区分)) {
            コード種別 = 総合事業過誤申立事由;
        }
        int 履歴番号 = 0;
        if (!div.getDdlRirekiNo1().getDataSource().isEmpty()) {
            履歴番号 = Integer.parseInt(div.getDdlRirekiNo1().getSelectedKey().toString());
        }
        List<TaishoshaKensakuRelateBusiness> 保険者情報 = get明細情報(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString()),
                保険者区分, new Decimal(履歴番号), 市町村コード, コード種別, 履歴番号フラグ, 市町村フラグ);
        List<TaishoshaKensakuRelateBusiness> 履歴番号Business = get履歴番号(new FlexibleYearMonth(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString()),
                市町村コード, 市町村フラグ);
        getHandler(div).set過誤決定情報(保険者情報, 保険者区分, 履歴番号Business);
        return ResponseData.of(div).respond();
    }

    private List<TaishoshaKensakuRelateBusiness> get履歴番号(FlexibleYearMonth 取扱年月, RString 市町村コード, boolean 市町村フラグ) {
        TaishoshaKensakuMybitisParamter parameter = TaishoshaKensakuMybitisParamter.creatRirekiParameter(取扱年月, 市町村コード, 市町村フラグ);
        return TaishoshaKensakuRelateFinder.createInstance().get履歴番号(parameter).records();
    }

    private List<TaishoshaKensakuRelateBusiness> get明細情報(FlexibleYearMonth 取扱年月, RString 保険者区分, Decimal 履歴番号,
            RString 市町村コード, RString コード種別, boolean 履歴番号フラグ, boolean 市町村フラグ) {
        TaishoshaKensakuMybitisParamter parameter = TaishoshaKensakuMybitisParamter
                .createParamter(取扱年月, 保険者区分, 履歴番号, 市町村コード, コード種別, 履歴番号フラグ, 市町村フラグ);
        return TaishoshaKensakuRelateFinder.createInstance().saiSinsaKeteiJyohouList(parameter).records();
    }

    private KetteijohoValidationHandler getValidationHandler(KetteijohoDiv div) {
        return new KetteijohoValidationHandler(div);
    }

    private KetteijohoHandler getHandler(KetteijohoDiv div) {
        return new KetteijohoHandler(div);
    }
}
