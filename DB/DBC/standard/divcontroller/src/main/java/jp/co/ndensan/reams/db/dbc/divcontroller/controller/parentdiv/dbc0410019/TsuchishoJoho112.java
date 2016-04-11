/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410019;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410019.TsuchishoJoho112Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[112]給付管理票情報
 *
 * @reamsid_L DBC-0980-120 xuhao
 */
public class TsuchishoJoho112 {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho112Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho112Div> onLoad(TsuchishoJoho112Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200073_KyufuKanrihyoTorikomiKekkaIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho112Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho112Div> onClick_btnExcute(TsuchishoJoho112Div div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }

}
