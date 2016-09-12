/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0080011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.soufujouhou.SoufuJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.SoufuJouhouParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0080011.DBC0080011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0080011.SoufuJouhouDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0080011.SoufuJouhouHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0080011.SoufuJouhouValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.soufujouhou.SoufuJouhouFinder;
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
 * 画面設計_DBC0080011_再審査申立送付情報照会のControllerです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
public class SoufuJouhou {

    private static final int 連番_5 = 5;
    private static final RString キー = new RString("000000");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div SoufuJouhouDiv
     * @return 再審査申立送付情報照会
     */
    public ResponseData<SoufuJouhouDiv> onLoad(SoufuJouhouDiv div) {
        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<AuthorityItem> 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(UrControlDataFactory
                .createInstance().getLoginInfo().getUserId());
        List<KoikiZenShichosonJoho> 構成市町村 = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        getHandler(div).onLoad(市町村情報, 市町村識別ID, 構成市町村);
        return ResponseData.of(div).setState(DBC0080011StateName.初期表示);
    }

    /**
     * 「送付年月を指定して表示する」ボタンを押下です。
     *
     * @param div SoufuJouhouDiv
     * @return 再審査申立書情報
     */
    public ResponseData<SoufuJouhouDiv> onClick_btnSofuzumi(SoufuJouhouDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).取扱年月未入力Check();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 送付年月 = div.getTxtSofuYM().getValue().getYearMonth().toDateString();
        List<SoufuJouhouBusiness> 再審査申立書情報Business = get申立書情報(div, 送付年月, true);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).再審査申立書情報(再審査申立書情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        getHandler(div).onClick_btnSofuzumi(再審査申立書情報Business);
        return ResponseData.of(div).setState(DBC0080011StateName.検索結果);
    }

    /**
     * 「未送付情報を表示する」ボタンを押下です。
     *
     * @param div SoufuJouhouDiv
     * @return 再審査申立書情報
     */
    public ResponseData<SoufuJouhouDiv> onClick_btnMisofu(SoufuJouhouDiv div) {
        List<SoufuJouhouBusiness> 再審査申立書情報Business = get申立書情報(div, RString.EMPTY, false);
        ValidationMessageControlPairs validPairs1 = getValidationHandler(div).再審査申立書情報(再審査申立書情報Business);
        if (validPairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs1).respond();
        }
        getHandler(div).onClick_btnSofuzumi(再審査申立書情報Business);
        return ResponseData.of(div).setState(DBC0080011StateName.検索結果);
    }

    private List<SoufuJouhouBusiness> get申立書情報(SoufuJouhouDiv div, RString 送付年月, boolean 送付年月フラグ) {
        boolean 保険者番号フラグ = false;
        RString 証記載保険者番号 = RString.EMPTY;
        if (!div.getDdlShichosonName().getDataSource().isEmpty() && (!キー.equals(div.getDdlShichosonName().getSelectedKey()))) {
            証記載保険者番号 = div.getDdlShichosonName().getSelectedKey().substring(0, 連番_5);
            保険者番号フラグ = true;
        }
        SoufuJouhouParameter parameter = SoufuJouhouParameter
                .creatParameter(送付年月, 証記載保険者番号, 送付年月フラグ, 保険者番号フラグ);
        return SoufuJouhouFinder.createInstance().get再審査申立書情報(parameter).records();
    }

    private SoufuJouhouHandler getHandler(SoufuJouhouDiv div) {
        return new SoufuJouhouHandler(div);
    }

    private SoufuJouhouValidationHandler getValidationHandler(SoufuJouhouDiv div) {
        return new SoufuJouhouValidationHandler(div);
    }
}
