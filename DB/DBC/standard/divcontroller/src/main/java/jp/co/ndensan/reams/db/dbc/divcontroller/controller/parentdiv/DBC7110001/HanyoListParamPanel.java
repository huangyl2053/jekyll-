/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7110001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710110.DBC710110_HanyoListSaishinsaMoshitateParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710120.DBC710120_HanyoListSaishinsaKekkaParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7110001.DBC7110001StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7110001.HanyoListParamPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7110001.HanyoListParamHandler;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 画面設計_DBCGM23011_汎用リスト 再審査申立情報のクラスです。
 *
 * @reamsid_L DBC-3106-010 zhengsongling
 */
public class HanyoListParamPanel {

    private static final RString 単一 = new RString("単一");
    private static final RString 広域 = new RString("広域");
    private static final RString 再審査申立情報 = new RString("再審査申立情報");
    private static final RString 再審査結果情報 = new RString("再審査結果情報");
    private static final RString 事業者入力モード = new RString("事業者入力モード");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");

    /**
     * 初期化処理です。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<HanyoListParamPanelDiv>
     */
    public ResponseData<HanyoListParamPanelDiv> onLoad(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        RString モード = ResponseHolder.getState();
        ViewStateHolder.put(ViewStateKeys.事業者入力モード, 事業者入力モード);
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        div.getCcdJigyoshaBango().initialize();
        getHandler(div).initialize(導入形態, モード);
        if (再審査申立情報.equals(モード)) {
            return ResponseData.of(div).setState(DBC7110001StateName.再審査申立情報);
        } else if (再審査結果情報.equals(モード)) {
            return ResponseData.of(div).setState(DBC7110001StateName.再審査結果情報);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 再審査申立情報の条件を復元する。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<HanyoListParamPanelDiv>
     */
    public ResponseData<HanyoListParamPanelDiv> onClick_HanyoListSaishinsaMoshitate(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        getHandler(div).hanyoListSaishinsaMoshitate(導入形態);
        return ResponseData.of(div).respond();
    }

    /**
     * 再審査申立情報の条件を保存する。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_HanyoListSaishinsaMoshitateParamSave(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).hanyoListSaishinsaMoshitateParamSave(導入形態));
        return responseData;
    }

    /**
     * 再審査結果情報の条件を復元する。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<HanyoListParamPanelDiv>
     */
    public ResponseData<HanyoListParamPanelDiv> onClick_HanyoListSaishinsaKekka(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        getHandler(div).hanyoListSaishinsaKekka(導入形態);
        return ResponseData.of(div).respond();
    }

    /**
     * 再審査結果情報の条件を保存する。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_HanyoListSaishinsaKekkaParamSave(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).hanyoListSaishinsaKekkaParamSave(導入形態));
        return responseData;
    }

    /**
     * 再審査申立情報の実行です。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<DBC710110_HanyoListSaishinsaMoshitateParameter>
     */
    public ResponseData<DBC710110_HanyoListSaishinsaMoshitateParameter> onClick_btnExecuteMoshitate(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        return ResponseData.of(getHandler(div).btnExecuteMoshitate(導入形態)).respond();
    }

    /**
     * 再審査結果情報の実行です。
     *
     * @param div HanyoListParamPanelDiv
     * @return ResponseData<DBC710120_HanyoListSaishinsaKekkaParameter>
     */
    public ResponseData<DBC710120_HanyoListSaishinsaKekkaParameter> onClick_btnExecuteKekka(HanyoListParamPanelDiv div) {
        RString 導入形態 = get導入形態();
        return ResponseData.of(getHandler(div).btnExecuteKekka(導入形態)).respond();
    }

    private RString get導入形態() {
        RString 導入形態;
        List<KaigoDonyuKeitai> kaigoDonyuKeitai
                = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        if (kaigoDonyuKeitai.get(0).get導入形態コード().is単一()) {
            導入形態 = 単一;
        } else if (kaigoDonyuKeitai.get(0).get導入形態コード().is広域()) {
            導入形態 = 広域;
        } else {
            導入形態 = RString.EMPTY;
        }
        return 導入形態;
    }

    private HanyoListParamHandler getHandler(HanyoListParamPanelDiv div) {
        return new HanyoListParamHandler(div);
    }
}
