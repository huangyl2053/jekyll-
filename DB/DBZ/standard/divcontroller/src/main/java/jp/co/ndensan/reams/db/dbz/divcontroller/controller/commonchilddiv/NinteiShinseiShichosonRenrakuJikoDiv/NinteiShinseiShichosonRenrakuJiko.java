/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseiShichosonRenrakuJikoDiv;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJikoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 市町村連絡事項共有子Divです。
 *
 * @reamsid_L DBZ-1300-090 suguangjun
 */
public class NinteiShinseiShichosonRenrakuJiko {

    /**
     * 市町村連絡事項を初期化する。
     *
     * @param requestDiv NinteiShinseiShichosonRenrakuJikoDiv
     * @return ResponseData<NinteiShinseiShichosonRenrakuJikoDiv>
     */
    public ResponseData<NinteiShinseiShichosonRenrakuJikoDiv> onLoad(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        NinteiShinseiCodeModel shinseiCodeModel = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        getHandler(requestDiv).initialize(shinseiCodeModel);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 確定するボタンが押下された場合、入力されている内容を親画面に渡す。
     *
     * @param requestDiv NinteiShinseiShichosonRenrakuJikoDiv
     * @return ResponseData<NinteiShinseiShichosonRenrakuJikoDiv>
     */
    public ResponseData<NinteiShinseiShichosonRenrakuJikoDiv> onClick_btnKakutei(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        getHandler(requestDiv).onClick_btnKakutei();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 戻るボタンが押下された場合、結果を親画面に反映せずにダイアログを閉じる。
     *
     * @param requestDiv NinteiShinseiShichosonRenrakuJikoDiv
     * @return ResponseData<NinteiShinseiShichosonRenrakuJikoDiv>
     */
    public ResponseData<NinteiShinseiShichosonRenrakuJikoDiv> onClick_btnTorikeshi(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        NinteiShinseiCodeModel shinseiCodeModel = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        if (shinseiCodeModel == null || NinteiShinseiCodeModel.HyojiMode.ShokaiMode.equals(shinseiCodeModel.get表示モード())) {
            return ResponseData.of(requestDiv).dialogNGClose();
        }

        if (!Objects.equals(shinseiCodeModel.get連絡事項(), requestDiv.getTxtRenrakujiko().getValue()) && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if ((new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
             .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            return ResponseData.of(requestDiv).dialogOKClose();
        } else if ((new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No)) {
            return ResponseData.of(requestDiv).respond();
        }
        return ResponseData.of(requestDiv).dialogOKClose();
    }

    private NinteiShinseiShichosonHandler getHandler(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        return new NinteiShinseiShichosonHandler(requestDiv);
    }
}
