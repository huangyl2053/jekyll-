/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE3010002;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010002.DBE3010002StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010002.DBE3010002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010002.IchijiHanteiExecuterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010002.IchijiHanteiExecuterHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 一次判定を1対象者ずつ実行する画面の処理を定義します。
 *
 * @author n8178
 */
public class IchijiHanteiExecuter {

    /**
     * onLoad時に実行する処理を定義します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onLoad(IchijiHanteiExecuterDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧へ簿t何をクリックした場合の処理を定義します。遷移元画面の、検索結果一覧が表示されている状態へ遷移します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onClick_backSearchResult(IchijiHanteiExecuterDiv div) {

        return executeTransition(div, DBE3010002TransitionEventName.検索結果一覧に戻る);
    }

    /**
     * 再検索するボタンをクリックした場合の処理を定義します。遷移元画面の、検索条件を指定する状態へ遷移します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onClick_research(IchijiHanteiExecuterDiv div) {

        return executeTransition(div, DBE3010002TransitionEventName.再検索する);
    }

    private ResponseData<IchijiHanteiExecuterDiv> executeTransition(IchijiHanteiExecuterDiv div, DBE3010002TransitionEventName 遷移イベント名) {
        if (ResponseHolder.isReRequest()) {
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(遷移イベント名).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }

        if (getHandler(div).hasChanged一次判定結果()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        return ResponseData.of(div).forwardWithEventName(遷移イベント名).respond();
    }

    /**
     * 保存するボタンをクリックした場合の処理を定義します。一次判定結果をDBに保存します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onClick_btnSave(IchijiHanteiExecuterDiv div) {

        if (!ResponseHolder.isReRequest()) {
            if (!getHandler(div).hasChanged一次判定結果()) {
                return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            IchijiHanteiKekkaJoho torokuTaisho = div.getCcdHanteiKekka().get一次判定結果();
            if (torokuTaisho == null) {
                return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
            }

            IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();

            IchijiHanteiKekkaJoho existingData = manager.get一次判定結果(torokuTaisho.identifier().get申請書管理番号());
            if (existingData != null) {
                torokuTaisho = getHandler(div).updateHanteiKekka(existingData, torokuTaisho);
            }

            manager.save要介護認定一次判定結果情報(torokuTaisho);

            div.getCcdHanteiKekka().clear一次判定結果();
            div.getCcdKanryoMessage().setSuccessMessage(new RString("一次判定結果を保存しました。"));
            return ResponseData.of(div).setState(DBE3010002StateName.complete);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 完了するボタンをクリックした場合の処理を定義します。 完了するボタンをクリックした場合、画面を終了しメニューに遷移します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onClick_btnComplete(IchijiHanteiExecuterDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBE3010002TransitionEventName.完了する).respond();
    }

    /**
     * 完了処理に遷移するボタンをクリックしたときの処理を定義します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onClick_btnKanryoShori(IchijiHanteiExecuterDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBE3010002TransitionEventName.完了処理へ遷移).respond();
    }

    private IchijiHanteiExecuterHandler getHandler(IchijiHanteiExecuterDiv div) {
        return new IchijiHanteiExecuterHandler(div);
    }
}
