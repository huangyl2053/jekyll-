/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410035;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410035.TsuchishoJoho38B38GDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[38B・38G]高額合算支給（不支給）決定通知書情報
 */
public class TsuchishoJoho38B38G {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho38B38GDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho38B38GDiv> onLoad(TsuchishoJoho38B38GDiv div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200053_GassanKetteiTsuchishoShiharaiYoteiBiYijiNashi")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho38B38GDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho38B38GDiv> onClick_btnExcute(TsuchishoJoho38B38GDiv div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }

}
