/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001.DvShokanbaraiJohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001.DvShokanbaraiJohoValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.dvshokanbaraijoho.DvShokanbaraiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト出力(償還払い状況)のパネルです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJoho {

    private static final ReportId 帳票ID = new ReportId("DBC701002_HanyoListShokanbaraiJokyo");
    private static final RString 実行する = new RString("btnExecute");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<DvShokanbaraiJohoDiv> onLoad(DvShokanbaraiJohoDiv div) {
        List<ShikibetsuNoKanri> 様式番号一覧 = DvShokanbaraiJohoManager.createInstance().select様式名称とコード();
        if (様式番号一覧 == null || 様式番号一覧.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, true);
            DvShokanbaraiJohoValidationHandler validationHandler = new DvShokanbaraiJohoValidationHandler(div);
            ValidationMessageControlPairs pairs = validationHandler.validateCommonButton();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        RString 市町村判定 = getHandler(div).initialize抽出条件パネル();
        ViewStateHolder.put(ViewStateKeys.市町村判定, 市町村判定);
        div.getDvShokanbaraiParam().getCcdShokanShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        return createResponse(div);
    }

    /**
     * 「介護」ボタンのonClick事件です。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<DvShokanbaraiJohoDiv> onClick_btnShokanKaigo(DvShokanbaraiJohoDiv div) {
        getHandler(div).onClick_介護();
        return createResponse(div);
    }

    /**
     * 「予防」ボタンのonClick事件です。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<DvShokanbaraiJohoDiv> onClick_btnYobo(DvShokanbaraiJohoDiv div) {
        getHandler(div).onClick_予防();
        return createResponse(div);
    }

    /**
     * 支払先RDBのonChange事件です。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<DvShokanbaraiJohoDiv> onChange_radKogakuShiharaisaki(DvShokanbaraiJohoDiv div) {
        getHandler(div).onChange支払先RDB();
        return createResponse(div);
    }

    /**
     * 「実行する」を押下 バッチを起動する。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return バッチを起動する
     */
    public ResponseData<HanyoListShokanbaraiJokyoBatchParameter> onClick_btnBatchRegister(DvShokanbaraiJohoDiv div) {
        RString 市町村判定 = ViewStateHolder.get(ViewStateKeys.市町村判定, RString.class);
        HanyoListShokanbaraiJokyoBatchParameter parameter = getHandler(div).setBatchParamter(市町村判定);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 入力項目チェックです。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<DvShokanbaraiJohoDiv> batchCheck(DvShokanbaraiJohoDiv div) {
        DvShokanbaraiJohoValidationHandler validationHandler = new DvShokanbaraiJohoValidationHandler(div);
        ValidationMessageControlPairs pairs = validationHandler.validateサービス提供年月();
        pairs.add(validationHandler.validate住宅改修支給届出日());
        pairs.add(validationHandler.validate国保連送付年月());
        pairs.add(validationHandler.validate様式番号一覧());
        pairs.add(validationHandler.validate決定日());
        pairs.add(validationHandler.validate申請日());
        pairs.add(validationHandler.validate金融機関コード());
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    private DvShokanbaraiJohoHandler getHandler(DvShokanbaraiJohoDiv div) {
        return new DvShokanbaraiJohoHandler(div);
    }

    private ResponseData<DvShokanbaraiJohoDiv> createResponse(DvShokanbaraiJohoDiv div) {
        return ResponseData.of(div).respond();
    }
}
