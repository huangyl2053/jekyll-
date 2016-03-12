/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2710011;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011StateName.特徴対象者登録;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011StateName.結果確認;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011TransitionEventName.再検索する;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011TransitionEventName.検索結果一覧へ;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011TransitionEventName.終了する;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.KaigoAtenaJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710011.KaigoAtenaJohoHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 特別徴収対象者登録情報Divを制御します。
 */
public class KaigoAtenaJoho {

    /**
     * 特別徴収対象者登録情報を画面初期化処理しました。
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onload(KaigoAtenaJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    DbbErrorMessages.特徴対象者でないため処理不可.getMessage().getCode(),
                    DbbErrorMessages.特徴対象者でないため処理不可.getMessage().evaluate());
            return getHandler(div).onload() ? ResponseData.of(div).addMessage(message).respond() : ResponseData.of(div).setState(特徴対象者登録);
        }
        if (ResponseHolder.getMessageCode().equals(new RString(DbbErrorMessages.特徴対象者でないため処理不可.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 特別徴収対象者登録を「年金情報を検索する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnNenkinInfoKensaku(KaigoAtenaJohoDiv div) {
        getHandler(div).onClick_btnNenkinInfoKensaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 「年金コード」フォーカスロスト処理する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> lostFocus(KaigoAtenaJohoDiv div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 特別徴収対象者登録を「関連付を削除する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnKanrenTsukeSakujo(KaigoAtenaJohoDiv div) {
        getHandler(div).onClick_btnKanrenTsukeSakujo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特別徴収対象者登録を「検索結果一覧へ」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnToSearchResult(KaigoAtenaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
    }

    /**
     * 特別徴収対象者登録を「再検索する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnReSearch(KaigoAtenaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(再検索する).respond();
    }

    /**
     * 特別徴収対象者登録を「終了する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnComplete(KaigoAtenaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(終了する).respond();
    }

    /**
     * 特別徴収対象者登録を「保存する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnUpdate(KaigoAtenaJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoAtenaJohoHandler handler = getHandler(div);
            QuestionMessage message = new QuestionMessage(
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            QuestionMessage message1 = new QuestionMessage(
                    UrQuestionMessages.保存の確認.getMessage().getCode(), UrQuestionMessages.保存の確認.getMessage().evaluate());
            return handler.is画面内容の変更有無() ? ResponseData.of(div).addMessage(message1).respond()
                    : ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.保存の確認.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            getHandler(div).onClick_btnUpdate();
            return ResponseData.of(div).setState(結果確認);
        }
        return ResponseData.of(div).respond();
    }

    private KaigoAtenaJohoHandler getHandler(KaigoAtenaJohoDiv div) {
        return new KaigoAtenaJohoHandler(div);
    }

}
