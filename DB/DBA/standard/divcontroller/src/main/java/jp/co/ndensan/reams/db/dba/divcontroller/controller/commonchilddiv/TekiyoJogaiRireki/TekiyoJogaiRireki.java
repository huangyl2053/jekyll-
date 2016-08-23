/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.TekiyoJogaiRireki;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 適用除外者管理のクラス。
 *
 * @reamsid_L DBA-0210-010 dingyi
 */
public class TekiyoJogaiRireki {

    /**
     * 「選択」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onClick_Selected(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onClick_Selected();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「追加する」ボタンを押下する場合、適用除外者明細エリア全項目をクリアします。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onClick_BtnAdd(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onClick_BtnAdd();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onClick_Update(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onClick_Update();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「削除」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onClick_Delete(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onClick_Delete();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「適用除外情報を確定する」ボタンを押下する場合、入力の内容を適用情報一覧に反映します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onClick_BtnKakunin(TekiyoJogaiRirekiDiv requestDiv) {
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).validate();
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        getHandler(requestDiv).onClick_BtnKakunin(requestDiv.getDatagridTekiyoJogai().getActiveRow());
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「取消する」ボタンを押下する場合、入力の内容をクリアします。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onClick_Torikeshi(TekiyoJogaiRirekiDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(requestDiv).onClick_Torikeshi();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 除外者適用パネルの入所日がある場合、適用日・適用届出日を設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onBlur_Tekiyo(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onBlur_Tekiyo();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 除外者解除パネルの退所日がある場合、解除日・解除届出日を設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onBlur_Kayijo(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onBlur_Kayijo();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 除外者履歴変更パネルの適用日がある場合、適用届出日を設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onBlur_TekiyoRireki(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onBlur_TekiyoRireki();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 除外者履歴変更パネルの解除日がある場合、解除届出日を設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return ResponseData<TekiyoJogaiRirekiDiv>
     */
    public ResponseData<TekiyoJogaiRirekiDiv> onBlur_KayijoRireki(TekiyoJogaiRirekiDiv requestDiv) {
        getHandler(requestDiv).onBlur_KayijoRireki();
        return ResponseData.of(requestDiv).respond();
    }

    private TekiyoJogaiRirekiHandler getHandler(TekiyoJogaiRirekiDiv requestDiv) {
        return new TekiyoJogaiRirekiHandler(requestDiv);
    }

    private TekiyoJogaiRirekiValidationHandler getValidationHandler(TekiyoJogaiRirekiDiv requestDiv) {
        return new TekiyoJogaiRirekiValidationHandler(requestDiv);
    }
}
