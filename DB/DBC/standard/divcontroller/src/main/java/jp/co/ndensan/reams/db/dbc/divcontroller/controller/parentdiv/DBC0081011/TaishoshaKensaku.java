/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0081011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saisinsaketeijyohou.TaishoshaKensakuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saisinsaketeijyohou.TaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011.TaishoshaKensakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0081011.TaishoshaKensakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0081011.TaishoshaKensakuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.saisinsaketeijyohou.TaishoshaKensakuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のControllerです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
public class TaishoshaKensaku {

    private static final RString キー = new RString("000000");
    private static final RString 保険者区分_1 = new RString("1");
    private static final RString 保険者区分_3 = new RString("3");
    private static final RString 保険者区分_2 = new RString("2");
    private static final RString 保険者区分_4 = new RString("4");
    private static final int 連番_5 = 5;

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TaishoshaKensakuDiv
     * @return 再審査申立決定情報照会
     */
    public ResponseData<TaishoshaKensakuDiv> onLoad(TaishoshaKensakuDiv div) {
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
     * @param div TaishoshaKensakuDiv
     * @return 再審査申立決定情報照会
     */
    public ResponseData<TaishoshaKensakuDiv> onClick_btnSearch(TaishoshaKensakuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 市町村コード = RString.EMPTY;
        boolean 市町村フラグ = false;
        if (!div.getDDLSityouson().getDataSource().isEmpty() && !キー.equals(div.getDDLSityouson().getSelectedKey())) {
            市町村コード = div.getDDLSityouson().getSelectedKey().substring(0, 連番_5);
            市町村フラグ = true;
        }
        List<TaishoshaKensakuBusiness> 保険者Business = get明細情報(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString(),
                保険者区分_1, 0, 市町村コード, false, 市町村フラグ);
        List<TaishoshaKensakuBusiness> 総合保険者Business = get明細情報(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString(),
                保険者区分_3, 0, 市町村コード, false, 市町村フラグ);
        List<TaishoshaKensakuBusiness> 公費負担者Business = get明細情報(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString(),
                保険者区分_2, 0, 市町村コード, false, 市町村フラグ);
        List<TaishoshaKensakuBusiness> 総合公費負担者Business = get明細情報(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString(),
                保険者区分_4, 0, 市町村コード, false, 市町村フラグ);
        List<TaishoshaKensakuBusiness> 履歴番号Business = get履歴番号(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString(),
                市町村コード, 市町村フラグ);
        List<TaishoshaKensakuBusiness> 再審査決定情報Business = getHandler(div).
                onClick_btnSearch(保険者Business, 総合保険者Business, 公費負担者Business, 総合公費負担者Business, 履歴番号Business);
        div.getKetteiHokensha().setToriatsukaiYM(div.getTxtToriatsukaiYM().getValue().getYearMonth().toDateString());
        div.getKetteiHokensha().setShichosonCode(市町村コード);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).再審査決定情報(再審査決定情報Business);
        if (!RString.isNullOrEmpty(div.getKetteiHokensha().getKubunn())) {
            getHandler(div).set再審査決定情報(再審査決定情報Business, div.getKetteiHokensha().getKubunn(), 履歴番号Business);
        }
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保険者情報」ボタンを押下です。
     *
     * @param div TaishoshaKensakuDiv
     * @return 保険者情報
     */
    public ResponseData<TaishoshaKensakuDiv> onClick_btnHokenn(TaishoshaKensakuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_1, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費保険者情報」ボタンを押下です。
     *
     * @param div TaishoshaKensakuDiv
     * @return 総合事業費保険者情報
     */
    public ResponseData<TaishoshaKensakuDiv> onClick_btnSougouHokenn(TaishoshaKensakuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_3, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「公費負担者情報」ボタンを押下です。
     *
     * @param div TaishoshaKensakuDiv
     * @return 公費負担者情報
     */
    public ResponseData<TaishoshaKensakuDiv> onClick_btnFutann(TaishoshaKensakuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_2, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費公費負担者情報」ボタンを押下です。
     *
     * @param div TaishoshaKensakuDiv
     * @return 総合事業費公費負担者情報
     */
    public ResponseData<TaishoshaKensakuDiv> onClick_btnSougouFutann(TaishoshaKensakuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        get保険者情報(div, 保険者区分_4, false);
        return ResponseData.of(div).respond();
    }

    private ResponseData<TaishoshaKensakuDiv> get保険者情報(TaishoshaKensakuDiv div, RString 保険者区分, boolean 履歴番号フラグ) {
        RString 市町村コード = div.getKetteiHokensha().getShichosonCode();
        boolean 市町村フラグ = false;
        if (!RString.isNullOrEmpty(市町村コード) && !キー.equals(市町村コード)) {
            市町村フラグ = true;
        }
        int 履歴番号 = 0;
        if (!div.getDDLRireki().getDataSource().isEmpty()) {
            履歴番号 = Integer.parseInt(div.getDDLRireki().getSelectedKey().toString());
        }
        List<TaishoshaKensakuBusiness> 総合保険者Business = get明細情報(div.getKetteiHokensha().getToriatsukaiYM(),
                保険者区分, 履歴番号, 市町村コード, 履歴番号フラグ, 市町村フラグ);
        List<TaishoshaKensakuBusiness> 履歴番号Business = get履歴番号(div.getKetteiHokensha().getToriatsukaiYM(),
                市町村コード, 市町村フラグ);
        getHandler(div).set再審査決定情報(総合保険者Business, 保険者区分, 履歴番号Business);
        return ResponseData.of(div).respond();
    }

    /**
     * 市町村指定DDL表示制御を変更です。
     *
     * @param div TaishoshaKensakuDiv
     * @return 再審査申立決定情報照会
     */
    public ResponseData<TaishoshaKensakuDiv> onChange_Shichousonn(TaishoshaKensakuDiv div) {
        getHandler(div).onChange_Shichousonn();
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴番号DDL表示制御を変更です。
     *
     * @param div TaishoshaKensakuDiv
     * @return 再審査申立決定情報照会
     */
    public ResponseData<TaishoshaKensakuDiv> onChange_Rireki(TaishoshaKensakuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 履歴番号 = div.getDDLRireki().getSelectedKey();
        get保険者情報(div, div.getKetteiHokensha().getKubunn(), true);
        div.getDDLRireki().setSelectedKey(履歴番号);
        return ResponseData.of(div).respond();
    }

    private List<TaishoshaKensakuBusiness> get履歴番号(RString 取扱年月, RString 市町村コード, boolean 市町村フラグ) {
        TaishoshaKensakuParameter parameter = TaishoshaKensakuParameter.creatRirekiParameter(取扱年月, 市町村コード, 市町村フラグ);
        return TaishoshaKensakuFinder.createInstance().get履歴番号(parameter).records();
    }

    private List<TaishoshaKensakuBusiness> get明細情報(RString 取扱年月, RString 保険者区分, int 履歴番号,
            RString 市町村コード, boolean 履歴番号フラグ, boolean 市町村フラグ) {
        TaishoshaKensakuParameter parameter = TaishoshaKensakuParameter
                .creatParameter(取扱年月, 保険者区分, 履歴番号, 市町村コード, 履歴番号フラグ, 市町村フラグ);
        return TaishoshaKensakuFinder.createInstance().saiSinsaKeteiJyohouList(parameter).records();
    }

    private TaishoshaKensakuHandler getHandler(TaishoshaKensakuDiv div) {
        return new TaishoshaKensakuHandler(div);
    }

    private TaishoshaKensakuValidationHandler getValidationHandler(TaishoshaKensakuDiv div) {
        return new TaishoshaKensakuValidationHandler(div);
    }
}
