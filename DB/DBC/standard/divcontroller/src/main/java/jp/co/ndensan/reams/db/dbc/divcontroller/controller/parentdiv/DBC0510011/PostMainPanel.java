/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC130010.DBC130010_KokuhoShikakuIdoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC130020.DBC130020_KokikoreishaShikakuIdoInParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.DBC0510011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.PostMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011.PostMainPanelCheck;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011.PostMainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011.PostMainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanel {

    private RString メニューID;
    private static final RString DBCMN82001 = new RString("DBCMN82001");
    private static final RString DBCMN82002 = new RString("DBCMN82002");
    private static final RString 国保資格異動情報取込 = new RString("国保資格異動情報取込");
    private static final RString 後期資格異動情報取込 = new RString("後期資格異動情報取込");
    private static final RString STRING_1 = new RString("1");
    private static final RString STRING_2 = new RString("2");
    private static final RDate DATE = RDate.getNowDate();

    /**
     * 画面初期化のメソッドます。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<PostMainPanelDiv> onLoad(PostMainPanelDiv div) {
        メニューID = ResponseHolder.getMenuID();
        DBC0510011StateName stateName = DBC0510011StateName.NoChange;
        if (メニューID.equals(DBCMN82001)) {
            div.setTitle(国保資格異動情報取込);
            stateName = DBC0510011StateName.国保;
        }
        if (メニューID.equals(DBCMN82002)) {
            div.setTitle(後期資格異動情報取込);
            stateName = DBC0510011StateName.後期;
        }
        RString 場合 = getHandler(div).initialize();
        ViewStateHolder.put(ViewStateKeys.場合, 場合);
        return ResponseData.of(div).setState(stateName);
    }

    /**
     * onOkClose_bth事件です。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<PostMainPanelDiv> onOkClose_bth(PostMainPanelDiv div) {
        getHandler(div).onOkClosebth();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<PostMainPanelDiv> onBeforeOpenCheck(PostMainPanelDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate(ViewStateHolder.get(
                ViewStateKeys.場合, RString.class));
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC130020_KokikoreishaShikakuIdoInParameter> onClick_btnLast(
            PostMainPanelDiv div) {
        getCheck(div).validateCheck();
        DBC130020_KokikoreishaShikakuIdoInParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBC130020_KokikoreishaShikakuIdoInParameter setBatchParameter(PostMainPanelDiv div) {
        DBC130020_KokikoreishaShikakuIdoInParameter parameter = new DBC130020_KokikoreishaShikakuIdoInParameter();
        if (div.getTxtRenkekeishiki().isVisible() && !div.getTxtRenkekeishiki().getValue().isEmpty()
                && !div.getTxtRenkekeishiki().getValue().isNull()) {
            parameter.setInsurerDistinction(STRING_1);
            parameter.setShoriShichoson(null);
        } else {
            parameter.setInsurerDistinction(STRING_2);
            List<RString> listresult = new ArrayList();
            for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                listresult.add(row.getShichosonShikibetuID());
            }
            parameter.setShoriShichoson(listresult);
        }

        parameter.setTableName(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期Ｆ, DATE,
                SubGyomuCode.DBC介護給付));

        parameter.setIfType(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類,
                DATE, SubGyomuCode.DBC介護給付));
        parameter.setTorikomiKeishiki(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期全件差分区分, DATE,
                SubGyomuCode.DBC介護給付));
        parameter.setShoriTimestamp(new RString(RDate.getNowDateTime().toString()));
        return parameter;
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBC130010_KokuhoShikakuIdoInParameter> onClick_btnKoku(
            PostMainPanelDiv div) {
        getCheck(div).validateCheck();
        DBC130010_KokuhoShikakuIdoInParameter param = setBatchParameters(div);
        return ResponseData.of(param).respond();
    }

    private DBC130010_KokuhoShikakuIdoInParameter setBatchParameters(PostMainPanelDiv div) {
        DBC130010_KokuhoShikakuIdoInParameter parameter = new DBC130010_KokuhoShikakuIdoInParameter();
        if (div.getTxtRenkekeishiki().isVisible() && !div.getTxtRenkekeishiki().getValue().isEmpty()
                && !div.getTxtRenkekeishiki().getValue().isNull()) {
            parameter.setInsurerDistinction(STRING_1);
            parameter.setShoriShichoson(null);
        } else {
            parameter.setInsurerDistinction(STRING_2);
            List<RString> listresult = new ArrayList();
            for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                listresult.add(row.getShichosonShikibetuID());
            }
            parameter.setShoriShichoson(listresult);
        }

        parameter.setTableName(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保Ｆ, DATE,
                SubGyomuCode.DBC介護給付));

        parameter.setIfType(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類,
                DATE, SubGyomuCode.DBC介護給付));
        parameter.setTorikomiKeishiki(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保全件差分区分,
                DATE, SubGyomuCode.DBC介護給付));

        parameter.setShoriTimestamp(new RString(RDate.getNowDateTime().toString()));
        return parameter;
    }

    private PostMainPanelHandler getHandler(PostMainPanelDiv div) {
        return new PostMainPanelHandler(div);
    }

    private PostMainPanelValidationHandler getValidationHandler(PostMainPanelDiv div) {
        return new PostMainPanelValidationHandler(div);
    }

    private PostMainPanelCheck getCheck(PostMainPanelDiv div) {
        return new PostMainPanelCheck(div);
    }
}
