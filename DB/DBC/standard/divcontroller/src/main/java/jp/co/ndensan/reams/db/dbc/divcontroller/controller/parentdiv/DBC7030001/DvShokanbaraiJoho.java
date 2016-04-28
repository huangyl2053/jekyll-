/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7030001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001.DvShokanbaraiJohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001.DvShokanbaraiJohoValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(償還払い状況)のパネルです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJoho {

    private static final ReportId 帳票ID = new ReportId("DBC701002_HanyoListShokanbaraiJokyo");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<DvShokanbaraiJohoDiv> onLoad(DvShokanbaraiJohoDiv div) {
        getHandler(div).initialize抽出条件パネル();
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
        HanyoListShokanbaraiJokyoBatchParameter parameter = getHandler(div).setBatchParamter();
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
