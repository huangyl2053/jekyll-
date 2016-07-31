/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 共有子Div「資格変更履歴」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class ShikakuHenkoRireki {

    /**
     * 追加ボタンを押下した際に実行します。<br/>
     * 追加処理のための前準備を行います。
     *
     * @param div {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnAdd(ShikakuHenkoRirekiDiv div) {
        div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        div.setInputMode(ViewExecutionStatus.Add.getValue());
        div.getBtnAdd().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 資格変更履歴上の修正アイコンが押下された際に実行します。<br/>
     * 修正・変更処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByModifyButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = getHandler(henkoRirekiDiv);
        henkoRirekiDiv.getBtnAdd().setDisabled(true);
        handler.set資格変更入力Panel();
        if (!ViewExecutionStatus.Add.getValue().equals(henkoRirekiDiv.getInputMode())) {
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.Modify.getValue());
        }
        henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
        ViewStateHolder.put(ViewStateKeys.資格変更入力, handler.get資格変更入力Panel());
        return ResponseData.of(henkoRirekiDiv).respond();
    }

    /**
     * 資格変更履歴上の削除アイコンが押下された際に実行します。<br/>
     * 削除処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByDeleteButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = getHandler(henkoRirekiDiv);
        henkoRirekiDiv.getBtnAdd().setDisabled(true);
        handler.set資格変更入力Panel();
        if (!ViewExecutionStatus.Add.getValue().equals(henkoRirekiDiv.getInputMode())) {
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.Delete.getValue());
        }
        henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.sakujo);
        return ResponseData.of(henkoRirekiDiv).respond();
    }

    /**
     * 資格変更履歴上の選択した項目が押下された際に実行します。<br/>
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelect_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        ShikakuHenkoRirekiHandler handler = getHandler(henkoRirekiDiv);
        henkoRirekiDiv.getBtnAdd().setDisabled(true);
        handler.set資格変更入力Panel();
        if (henkoRirekiDiv.getDgHenko().getClickedItem().getState().equals(new RString("追加"))
                || henkoRirekiDiv.getDgHenko().getClickedItem().getState().equals(new RString("修正"))) {
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.Modify.getValue());
        } else if (henkoRirekiDiv.getDgHenko().getClickedItem().getState().equals(new RString("削除"))) {
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.sakujo);
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.Delete.getValue());
        } else {
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
            henkoRirekiDiv.getBtnAdd().setDisabled(false);
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.None.getValue());
        }
        ViewStateHolder.put(ViewStateKeys.資格変更入力, handler.get資格変更入力Panel());
        return ResponseData.of(henkoRirekiDiv).respond();
    }

    /**
     * 資格変更履歴上の選択した項目が押下された際に実行します。<br/>
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByDblClick_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        return onSelect_dgHenko(henkoRirekiDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoTorikeshi(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        if (!ResponseHolder.isReRequest()) {
            RString input = getHandler(henkoRirekiDiv).get資格変更入力Panel();
            if (henkoRirekiDiv.getInputMode().equals(ViewExecutionStatus.Add.getValue())
                    && !input.isEmpty()) {
                return ResponseData.of(henkoRirekiDiv).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            RString inputBef = ViewStateHolder.get(ViewStateKeys.資格変更入力, RString.class);
            if (henkoRirekiDiv.getInputMode().equals(ViewExecutionStatus.Modify.getValue())
                    && !input.equals(inputBef)) {
                return ResponseData.of(henkoRirekiDiv).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (henkoRirekiDiv.getInputMode().equals(ViewExecutionStatus.Delete.getValue())) {
                return ResponseData.of(henkoRirekiDiv).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || ResponseHolder.getMessageCode().isNullOrEmpty()) {
            getHandler(henkoRirekiDiv).clear資格変更入力Panel();
            if (!ShikakuHenkoRirekiDiv.MeisaiMode.shokai.equals(henkoRirekiDiv.getMode_MeisaiMode())) {
                henkoRirekiDiv.getBtnAdd().setDisabled(false);
                henkoRirekiDiv.getDgHenko().setDisabled(false);
                henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
                henkoRirekiDiv.setInputMode(ViewExecutionStatus.None.getValue());
            }
        }
        return ResponseData.of(henkoRirekiDiv).respond();
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を資格変更履歴一覧に反映します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoKakutei(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result = ViewStateHolder.get(ViewStateKeys.被保険者台帳情報, Models.class);

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        HihokenshaDaicho hihokenshaDaicho;
        if (henkoRirekiDiv.getInputMode().equals(ViewExecutionStatus.Add.getValue())) {
            hihokenshaDaicho = getHandler(henkoRirekiDiv).getTsuikaEntity(result);
            validationMessages.add(getValidationHandler(henkoRirekiDiv).tsuikaShoriCheck(result.iterator().next()));
        } else {
            HihokenshaDaichoIdentifier hihokenshaDaichoIdentifier = new HihokenshaDaichoIdentifier(
                    new HihokenshaNo(henkoRirekiDiv.getDgHenko().getClickedItem().getHihokenshaNo()),
                    henkoRirekiDiv.getDgHenko().getClickedItem().getIdoYMD().getValue(),
                    henkoRirekiDiv.getDgHenko().getClickedItem().getEdaNo());
            hihokenshaDaicho = result.get(hihokenshaDaichoIdentifier);
        }
        validationMessages.add(getValidationHandler(henkoRirekiDiv).henkoJiyuCheck(hihokenshaDaicho));
        if (validationMessages.iterator().hasNext()
                && !henkoRirekiDiv.getInputMode().equals(ViewExecutionStatus.Delete.getValue())) {
            return ResponseData.of(henkoRirekiDiv).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest() && henkoRirekiDiv.getInputMode().equals(ViewExecutionStatus.Delete.getValue())) {
            return ResponseData.of(henkoRirekiDiv).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }

        if (!henkoRirekiDiv.getInputMode()
                .equals(ViewExecutionStatus.Delete.getValue())
                || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(henkoRirekiDiv).updateEntryData(hihokenshaDaicho);
            getHandler(henkoRirekiDiv).clear資格変更入力Panel();
            henkoRirekiDiv.getDgHenko().setDisabled(false);
            henkoRirekiDiv.getBtnAdd().setDisabled(false);
            henkoRirekiDiv.setInputMode(ViewExecutionStatus.None.getValue());
            henkoRirekiDiv.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
        }

        return ResponseData.of(henkoRirekiDiv).respond();
    }

    private ShikakuHenkoRirekiHandler getHandler(ShikakuHenkoRirekiDiv requestDiv) {
        return new ShikakuHenkoRirekiHandler(requestDiv);
    }

    private ShikakuHenkoRirekiValidationHandler getValidationHandler(ShikakuHenkoRirekiDiv requestDiv) {
        return new ShikakuHenkoRirekiValidationHandler(requestDiv);
    }
}
