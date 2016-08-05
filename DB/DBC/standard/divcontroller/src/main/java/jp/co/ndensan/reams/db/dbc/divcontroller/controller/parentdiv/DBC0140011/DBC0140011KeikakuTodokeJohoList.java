/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0140011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0140011.DBC0140011KeikakuTodokeJohoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0140011.DBC0140011KeikakuTodokeJohoListHandler;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBC0140011_計画届出情報リスト
 *
 * @reamsid_L DBC-1960-010 wangxingpeng
 */
public class DBC0140011KeikakuTodokeJohoList {

//    private final ReportId 帳票ID = new ReportId("DBC200060_KyotakuSerivceKeikakuSakuseiIraitodokedeJyokyoIchiran");
    private final ReportId 帳票ID = new ReportId("DBC120810_KokuhorenJukyushaIn");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div DBC0140011KeikakuTodokeJohoListDiv
     * @return ResponseData
     */
    public ResponseData<DBC0140011KeikakuTodokeJohoListDiv> onLoad(DBC0140011KeikakuTodokeJohoListDiv div) {

        div.getPrintOrderCv().load(SubGyomuCode.DBC介護給付, 帳票ID);
//        KaigoChohyoShutsuryokujunDiv para = new KaigoChohyoShutsuryokujunDiv();
//        para.loadChohyoMode(SubGyomuCode.DBC介護給付, 帳票ID);
        return ResponseData.of(div).respond();

    }

    /**
     * バッチ処理のメソッドます。
     *
     * @param div DBC0140011KeikakuTodokeJohoListDiv
     * @return ResponseData
     */
    public ResponseData<DBC0140011KeikakuTodokeJohoListDiv> onClick_btnBatchRegister(DBC0140011KeikakuTodokeJohoListDiv div) {

        getHandler(div).onClick_btnBatchRegister();
        return ResponseData.of(div).respond();

    }

    private DBC0140011KeikakuTodokeJohoListHandler getHandler(DBC0140011KeikakuTodokeJohoListDiv div) {
        return DBC0140011KeikakuTodokeJohoListHandler.of(div);
    }
}
