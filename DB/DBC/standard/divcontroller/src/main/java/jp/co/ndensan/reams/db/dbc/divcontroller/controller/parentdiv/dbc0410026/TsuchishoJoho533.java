/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410026;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410026.DBC0410026TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410026.TsuchishoJoho533Div;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 国保連情報受取データ取込_[533]受給者情報更新結果情報のクラスです
 */
public class TsuchishoJoho533 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho533Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho533Div> onLoad(TsuchishoJoho533Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200055_JukyushaKoshinkekkaIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho533Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho533Div> onClick_btnExcute(TsuchishoJoho533Div div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0410026TransitionEventName.実行する).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }
}
