/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410024;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410024.TsuchishoJoho652Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報受取データ取込_[652]介護給付費再審査決定通知書（公費）情報のクラスです
 */
public class TsuchishoJoho652 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho652Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho652Div> onLoad(TsuchishoJoho652Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200049_SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBun")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho652Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho652Div> onClick_btnExcute(TsuchishoJoho652Div div) {
        // TODO QA471 パラメータ作成ビジネスを呼び出して、バッチを起動する
        return ResponseData.of(div).respond();
    }
}
