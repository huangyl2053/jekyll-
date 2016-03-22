/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410032;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410032.TsuchishoJoho37JDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[37J]高額合算自己負担額確認情報
 */
public class TsuchishoJoho37J {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho37JDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho37JDiv> onLoad(TsuchishoJoho37JDiv div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200028_GassanJikofutangakuKakuninTorikomiIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho37JDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho37JDiv> onClick_btnExcute(TsuchishoJoho37JDiv div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }

}
