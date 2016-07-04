/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7020001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001.DvKogakuServiceJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7020001.DvKogakuServiceJohoHandler;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト_高額介護サービス費状況
 *
 * @reamsid_L DBC-3092-010 sunhui
 */
public class DvKogakuServiceJoho {

    private static final ReportId 帳票ID = new ReportId("DBC701003_HanyoListKogakuKaigoServiceHiJokyo");
    private static final RString 事務広域 = new RString("事務広域");
    private static final RString 事務単一 = new RString("事務単一");

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
        if (市町村セキュリティ情報 == null) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (市町村セキュリティ情報.get導入形態コード() != null
                && 市町村セキュリティ情報.get導入形態コード().is広域()) {
            ViewStateHolder.put(ViewStateKeys.市町村判定, 事務広域);
            panel.getCcdHokenshaList().setDisabled(false);
            panel.getCcdHokenshaList().setVisible(true);
            panel.getCcdHokenshaList().loadHokenshaList();
        } else {
            ViewStateHolder.put(ViewStateKeys.市町村判定, 事務単一);
            panel.getCcdHokenshaList().setDisabled(true);
            panel.getCcdHokenshaList().setVisible(false);
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
    public ResponseData<HanyoListKogakuKaigoBatchParameter> click_batchRegister(DvKogakuServiceJohoDiv div) {
        DvKogakuServiceJohoHandler handler = getHandler(div);
        RString 市町村判定 = ViewStateHolder.get(ViewStateKeys.市町村判定, RString.class);
        HanyoListKogakuKaigoBatchParameter parameter = handler.getBatchParamter(市町村判定);
        return ResponseData.of(parameter).respond();
    }

    private ResponseData<DvKogakuServiceJohoDiv> createResponse(DvKogakuServiceJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    private DvKogakuServiceJohoHandler getHandler(DvKogakuServiceJohoDiv div) {
        return DvKogakuServiceJohoHandler.of(div);
    }

}
