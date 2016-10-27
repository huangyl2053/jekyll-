/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.RirekiShusei;

import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.business.core.rirekishusei.RirekiShuseiDataPass;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RirekiShusei.RirekiShuseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RirekiShusei.RirekiShuseiHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RirekiShusei.RirekiShuseiValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 履歴修正のコントローラです。
 *
 * @reamsid_L DBZ-1330-030 chengsanyuan
 */
public class RirekiShusei {

    /**
     * 認定調査状況初期化処理です。
     *
     * @param div 履歴修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onLoad(RirekiShuseiDiv div) {
        getHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面の状態を変更する。
     *
     * @param div 履歴修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onChange_ddlIdoJiyu(RirekiShuseiDiv div) {
        getHandler(div).set状態(div.getCcdShinseiSonotaJohoInput().get異動事由());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査状況ダイアログを開くの場合、画面の設定
     *
     * @param div 履歴修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onBefore_btnChosaJokyo(RirekiShuseiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 調査状況ダイアログを閉じるの場合、画面の設定
     *
     * @param div 履歴修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onOkClose_btnChosaJokyo(RirekiShuseiDiv div) {
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnKonkaiJoho(),
                NinteiChosaJokyoDataPass.class);
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(konkaiDataPass.get市町村コード(),
                konkaiDataPass.get申請書管理番号(), new SubGyomuCode(div.getHdnSubGyomuCd()),
                konkaiDataPass.get主治医医療機関コード(), konkaiDataPass.get医療機関名称(), konkaiDataPass.get主治医コード(), konkaiDataPass.get主治医氏名());
        div.getCcdShujiiIryokikanAndShujiiInput().setShiteii(konkaiDataPass.is指定医フラグ());
        div.getCcdChosaItakusakiAndChosainInput().initialize(RString.EMPTY,
                konkaiDataPass.get認定調査委託先コード(), konkaiDataPass.get事業者名称(), konkaiDataPass.get認定調査員コード(), konkaiDataPass.get調査員氏名());
        div.getCcdChosaItakusakiAndChosainInput().setHdnShinseishoKanriNo(konkaiDataPass.get申請書管理番号().value());
        div.getCcdChosaItakusakiAndChosainInput().setHdnShichosonCode(konkaiDataPass.get市町村コード().value());
        RirekiShuseiDataPass konkai = DataPassingConverter.deserialize(div.getHdnKonkaiJohoSerialized(),
                RirekiShuseiDataPass.class);
        konkai.set調査状況用情報(konkaiDataPass);
        div.setHdnKonkaiJohoSerialized(DataPassingConverter.serialize(konkai));
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンをクリックの時、結果を親画面に渡してダイアログを閉じる
     *
     * @param div 履歴修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onClick_btnKakutei(RirekiShuseiDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(getValidationHandler(div).validate認定情報());
        validPairs.add(getValidationHandler(div).validate認定期間が重複());
        validPairs.add(getValidationHandler(div).validate削除事由必須のチェック());
        validPairs.add(getValidationHandler(div).validateみなし更新の整合性チェック());
        if (validPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        div.setHdnKonkaiJohoSerialized(DataPassingConverter.serialize(getHandler(div).get画面項目ForDataPass()));
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 確定ボタンをクリックの時、結果を親画面に渡してダイアログを閉じる
     *
     * @param div 履歴修正Div
     * @return ResponseData<RirekiShuseiDiv>
     */
    public ResponseData<RirekiShuseiDiv> onClick_btnCancel(RirekiShuseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RString hdnInput = getHandler(div).get画面項目();
            if (!hdnInput.equals(div.getHdnInput())) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogNGClose();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).dialogNGClose();
    }

    private RirekiShuseiHandler getHandler(RirekiShuseiDiv div) {
        return new RirekiShuseiHandler(div);
    }

    private RirekiShuseiValidationHandler getValidationHandler(RirekiShuseiDiv div) {
        return new RirekiShuseiValidationHandler(div);
    }
}
