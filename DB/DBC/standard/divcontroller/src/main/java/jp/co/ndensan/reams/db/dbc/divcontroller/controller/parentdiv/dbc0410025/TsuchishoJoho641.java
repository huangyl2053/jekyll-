/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410025;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410025.DBC0410025TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410025.TsuchishoJoho641Div;
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
 * 国保連情報受取データ取込_[641]介護給付費公費受給者別一覧表情報のクラスです
 */
public class TsuchishoJoho641 {

    /**
     * 画面初期化
     *
     * @param div TsuchishoJoho641Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho641Div> onLoad(TsuchishoJoho641Div div) {
        ChohyoBunruiKanri code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                new ReportId(new RString("DBC200008_KohijukyushaBetsuIchiran")));
        div.getCcdKokurenJohoTorikomi().onLoadModeShutsuryokujunJoken2(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン事件
     *
     * @param div TsuchishoJoho641Div
     * @return ResponseData
     */
    public ResponseData<TsuchishoJoho641Div> onClick_btnExcute(TsuchishoJoho641Div div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0410025TransitionEventName.実行する).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }
}
