/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0140011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0140011.KeikakuTodokeJohoListDiv;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBC0140011_計画届出情報リスト
 *
 * @@reamsid_L DBC-1960-010 wangxingpeng
 */
public class KeikakuTodokeJohoList {

   
    private final ReportId 帳票ID = new ReportId("DBC200060_KyotakuServiceKeikakuSakuseiIraitodokedeJyokyoIchiran");

     /**
     * 画面初期化のメソッドます。
     *
     * @param div KeikakuTodokeJohoListDiv
     * @return ResponseData
     */
    public ResponseData<KeikakuTodokeJohoListDiv> onLoad(KeikakuTodokeJohoListDiv div) {

        KaigoChohyoShutsuryokujunDiv para = new KaigoChohyoShutsuryokujunDiv();
        para.loadChohyoMode(SubGyomuCode.DBC介護給付, 帳票ID);

        return ResponseData.of(div).respond();

    }

}
