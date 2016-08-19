/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0070011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sofujoho.SofujohoBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sofujoho.SofujohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0070011.SofujohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0070011.SofujohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0070011.SofujohoValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.sofujoho.KagoMousitatesyoSouhuJyohouFinder;
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
 * 過誤申立送付情報照会のControllerです。
 *
 * @reamsid_L DBC-2950-010 jinjue
 */
public class Sofujoho {

    private static final int 連番_5 = 5;
    private static final RString 申立書区分_1 = new RString("1");
    private static final RString 申立書区分_2 = new RString("2");
    private static final RString 申立書区分_3 = new RString("3");
    private static final RString キー = new RString("000000");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div SoufuJouhouDiv
     * @return 過誤申立送付情報照会
     */
    public ResponseData<SofujohoDiv> onLoad(SofujohoDiv div) {
        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(UrControlDataFactory
                .createInstance().getLoginInfo().getUserId());
        List<KoikiZenShichosonJoho> 構成市町村 = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        getHandler(div).onLoad(市町村情報, 市町村識別ID, 構成市町村);
        return ResponseData.of(div).respond();
    }

    /**
     * 「送付年月を指定して表示する」ボタンを押下です。
     *
     * @param div SofujohoDiv
     * @return 過誤申立送付情報照会
     */
    public ResponseData<SofujohoDiv> onClick_btnSearchSofuzumi(SofujohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 送付年月 = div.getTxtSofuYM().getValue().getYearMonth().toDateString();
        List<SofujohoBusiness> 過誤申立書情報 = get申立書情報(div, 送付年月, 申立書区分_1, true);
        List<SofujohoBusiness> 経過措置 = get申立書情報(div, 送付年月, 申立書区分_2, true);
        List<SofujohoBusiness> 総合事業費過誤申立書情報 = get申立書情報(div, 送付年月, 申立書区分_3, true);
        List<SofujohoBusiness> 情報Business = getHandler(div).
                onClick_btnSearch(過誤申立書情報, 経過措置, 総合事業費過誤申立書情報);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).過誤申立送付情報照会(情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「未送付情報を表示する」ボタンを押下です。
     *
     * @param div SofujohoDiv
     * @return 過誤申立送付情報照会
     */
    public ResponseData<SofujohoDiv> onClick_btnSearchMisofu(SofujohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 送付年月 = div.getTxtSofuYM().getValue().getYearMonth().toDateString();
        List<SofujohoBusiness> 過誤申立書情報 = get申立書情報(div, 送付年月, 申立書区分_1, false);
        List<SofujohoBusiness> 経過措置 = get申立書情報(div, 送付年月, 申立書区分_2, false);
        List<SofujohoBusiness> 総合事業費過誤申立書情報 = get申立書情報(div, 送付年月, 申立書区分_3, false);
        List<SofujohoBusiness> 情報Business = getHandler(div).
                onClick_btnSearch(過誤申立書情報, 経過措置, 総合事業費過誤申立書情報);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).過誤申立送付情報照会(情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「過誤申立書情報」ボタンを押下です。
     *
     * @param div SofujohoDiv
     * @return 過誤申立送付情報照会
     */
    public ResponseData<SofujohoDiv> onClick_btnKagiMoshitate(SofujohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<SofujohoBusiness> 過誤申立書情報 = this.get申立書情報(div, div.getTxtSofuYM().getText(), 申立書区分_1, true);
        List<SofujohoBusiness> 情報Business = getHandler(div).onClick_btnSearch再(過誤申立書情報, 申立書区分_1);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).過誤申立送付情報照会(情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費（経過措置）過誤申立書情報」ボタンを押下です。
     *
     * @param div SofujohoDiv
     * @return 過誤申立送付情報照会
     */
    public ResponseData<SofujohoDiv> onClick_btnSogojigyohiKeikasochi(SofujohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<SofujohoBusiness> 経過措置 = this.get申立書情報(div, div.getTxtSofuYM().getText(), 申立書区分_2, true);
        List<SofujohoBusiness> 情報Business = getHandler(div).onClick_btnSearch再(経過措置, 申立書区分_2);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).過誤申立送付情報照会(情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「総合事業費過誤申立書情報」ボタンを押下です。
     *
     * @param div SofujohoDiv
     * @return 過誤申立送付情報照会
     */
    public ResponseData<SofujohoDiv> onClick_btnSogojigyohi(SofujohoDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<SofujohoBusiness> 総合事業費過誤申立書情報 = this.get申立書情報(div, div.getTxtSofuYM().getText(), 申立書区分_3, true);
        List<SofujohoBusiness> 情報Business = getHandler(div).onClick_btnSearch再(総合事業費過誤申立書情報, 申立書区分_3);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).過誤申立送付情報照会(情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        return ResponseData.of(div).respond();
    }

    private List<SofujohoBusiness> get申立書情報(SofujohoDiv div, RString 送付年月, RString 申立書区分コード, boolean 送付年月フラグ) {
        boolean 保険者番号フラグ = false;
        RString 証記載保険者番号 = RString.EMPTY;
        if (!div.getDdlShichosonName().getDataSource().isEmpty() && (!キー.equals(div.getDdlShichosonName().getSelectedKey()))) {
            証記載保険者番号 = div.getDdlShichosonName().getSelectedKey().substring(0, 連番_5);
            保険者番号フラグ = true;
        }
        SofujohoMybatisParameter parameter = SofujohoMybatisParameter
                .creatParameter(送付年月, 申立書区分コード, 証記載保険者番号, 送付年月フラグ, 保険者番号フラグ);
        return KagoMousitatesyoSouhuJyohouFinder.createInstance().get過誤申立送付情報照会(parameter).records();
    }

    private SofujohoHandler getHandler(SofujohoDiv div) {
        return new SofujohoHandler(div);
    }

    private SofujohoValidationHandler getValidationHandler(SofujohoDiv div) {
        return new SofujohoValidationHandler(div);
    }
}
