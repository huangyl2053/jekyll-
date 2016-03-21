/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410036;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410036.TsuchishoJoho38PDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[38P]高額合算給付実績情報
 */
public class TsuchishoJoho38P {

    /**
     * onLoad
     *
     * @param div TsuchishoJoho38PDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho38PDiv> onLoad(TsuchishoJoho38PDiv div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200041_GassanKyufujissekiTorikomiIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div TsuchishoJoho38PDiv
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho38PDiv> onClick_btnExcute(TsuchishoJoho38PDiv div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }

}
