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
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;

/**
 * 一次判定を1対象者ずつ実行する画面の処理を定義します。
 *
 * @author n8178
 */
public class IchijiHanteiExecuter {
    
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");

    /**
     * onLoad時に実行する処理を定義します。
     *
     * @param div 一次判定実行Div
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onLoad(IchijiHanteiExecuterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            getHandler(div).initialize();
            ShinsakaiWariateJohoManager manager = ShinsakaiWariateJohoManager.createInstance();
            RString shinseishoKanriNoStr = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
            ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(shinseishoKanriNoStr);
            if (Boolean.TRUE.equals(manager.get審査会割当データ(shinseishoKanriNo))) {
                div.getShoriSelectPanel().getRadShoriSelect().clearSelectedItem();
                div.setReadOnly(true);
                return ResponseData.of(div).addMessage(DbeErrorMessages.審査会割当済のため処理不可.getMessage()).respond();
            }
        }
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
            if (KEY0.equals(div.getShoriSelectPanel().getRadShoriSelect().getSelectedKey())) {
                if (!getHandler(div).hasChanged一次判定結果()) {
                    return ResponseData.of(div).addMessage(UrErrorMessages.保存データなし.getMessage()).respond();
                }
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
                if (KEY0.equals(div.getShoriSelectPanel().getRadShoriSelect().getSelectedKey())) {
                    torokuTaisho = getHandler(div).updateHanteiKekka(existingData, torokuTaisho);
                    manager.save要介護認定一次判定結果情報(torokuTaisho);
                } else if (KEY1.equals(div.getShoriSelectPanel().getRadShoriSelect().getSelectedKey())) {
                    manager.saveOrDeletePhysical要介護認定一次判定結果情報(existingData.deleted());
                    NinteiKanryoJohoManager ninteiKanryoManager = NinteiKanryoJohoManager.createInstance();
                    NinteiKanryoJoho ninteiKanryoJoho = ninteiKanryoManager.get要介護認定完了情報(torokuTaisho.identifier().get申請書管理番号());
                    ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().set要介護認定一次判定完了年月日(null).build();
                    ninteiKanryoManager.save要介護認定完了情報(ninteiKanryoJoho.modifiedModel());
                }
            }else{
                manager.save要介護認定一次判定結果情報(torokuTaisho);
            }
            div.getCcdHanteiKekka().clear一次判定結果();
            div.getCcdKanryoMessage().setSuccessMessage(new RString("一次判定結果を保存しました。"));
            return ResponseData.of(div).setState(DBE3010002StateName.complete);
        }
        return ResponseData.of(div).respond();
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
   
    /**
     * 処理選択ラジオボタンをチェンジしたときの処理を定義します。
     *
     * @param div 一次判定実行Divquals(div.getRadShoriSelect().getSelectedKey())) {
            div.getCcdHanteiKekka().setAbledBtnIchijiHantei();
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiExecuterDiv> onChange_radShoriSelect(IchijiHanteiExecuterDiv div) {
        if (KEY0.equals(div.getShoriSelectPanel().getRadShoriSelect().getSelectedKey())) {
            div.getCcdHanteiKekka().setAbledBtnIchijiHantei();
        } else if (KEY1.equals(div.getShoriSelectPanel().getRadShoriSelect().getSelectedKey())) {
            div.getCcdHanteiKekka().setDisabledBtnIchijiHantei();
        }
        return ResponseData.of(div).respond();
    }

    private IchijiHanteiExecuterHandler getHandler(IchijiHanteiExecuterDiv div) {
        return new IchijiHanteiExecuterHandler(div);
    }
}
