/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7020001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dvkogakuservicejoho.DvKogakuServiceJohoBatchParamter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuServiceJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7020001.DvKogakuServiceJohoHandler;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト_高額介護サービス費状況
 *
 * @reamsid_L DBC-3092-010 sunhui
 */
public class DvKogakuServiceJoho {

    private static final ReportId 帳票ID = new ReportId("DBC701003_HanyoListKogakuKaigoServiceHiJokyo");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div DvKogakuServiceJohoDiv
     * @return ResponseData
     */
    public ResponseData<DvKogakuServiceJohoDiv> onLoad(DvKogakuServiceJohoDiv div) {
        DvKogakuServiceJohoHandler handler = getHandler(div);
        handler.initialize();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護事務);
        DvKogakuChushutsuJokenDiv panel = div.getDvKogakuServiceParam().getDvKogakuChushutsuJoken();
        panel.getCcdHokenshaList().loadHokenshaList();
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            if (市町村セキュリティ情報.get導入形態コード().is広域()) {
                panel.getCcdHokenshaList().setDisabled(false);
                panel.getCcdHokenshaList().setVisible(true);
            } else {
                panel.getCcdHokenshaList().setDisabled(true);
                panel.getCcdHokenshaList().setVisible(false);
            }
        }
        div.getDvKogakuServiceParam().getCcdKogakuShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        div.getCcdKogakuShutsuryokuKomoku().setVisible(false);
        div.getDvCsvHenshuHoho().setVisible(true);
        return createResponse(div);
    }

    /**
     * onChange事件 支払先RDBボタンの制御事件です
     *
     * @param div DvKogakuServiceJohoDiv
     * @return ResponseData
     */
    public ResponseData<DvKogakuServiceJohoDiv> onChange_radKogakuShiharaisaki(DvKogakuServiceJohoDiv div) {
        DvKogakuServiceJohoHandler handler = getHandler(div);
        handler.getKinyuKikanSeigyo();
        return createResponse(div);
    }

    /**
     * 入力項目チェックです。
     *
     * @param div DvKogakuServiceJohoDiv
     * @return ResponseData
     */
    public ResponseData<DvKogakuServiceJohoDiv> nyuryokuCheck(DvKogakuServiceJohoDiv div) {
        DvKogakuServiceJohoHandler handler = getHandler(div);
        ValidationMessageControlPairs pairs = handler.getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    /**
     * click事件「実行する」ボタンです。
     *
     * @param div DvKogakuServiceJohoDiv
     * @return ResponseData
     */
    public ResponseData<DvKogakuServiceJohoBatchParamter> click_batchRegister(DvKogakuServiceJohoDiv div) {
        DvKogakuServiceJohoHandler handler = getHandler(div);
        DvKogakuServiceJohoBatchParamter parameter = handler.getBatchParamter();
        return ResponseData.of(parameter).respond();
    }

    private ResponseData<DvKogakuServiceJohoDiv> createResponse(DvKogakuServiceJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    private DvKogakuServiceJohoHandler getHandler(DvKogakuServiceJohoDiv div) {
        return DvKogakuServiceJohoHandler.of(div);
    }

}
