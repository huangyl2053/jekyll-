/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kihonchosainput1;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInput1Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInputHandler1;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 認定基本調査入力の第一群身体機能のDivControllerです。
 */
public class KihonChosaInput1 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput1Div
     * @return ResponseData<KihonChosaInput1Div>
     */
    public ResponseData<KihonChosaInput1Div> onLoad(KihonChosaInput1Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getDaiichigunShintaiKino().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getDaiichigunShintaiKino().getRecordNumber();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力をを処置内容特記事項を押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_btnOpenDialog(KihonChosaInput1Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(get質問メッセージ()).respond();
        }
        if (get質問メッセージCode().equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_btnConfirm(KihonChosaInput1Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).onClick_btnConfirm();
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_btnBack(KihonChosaInput1Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private Message get質問メッセージ() {
        return UrQuestionMessages.確認_汎用.getMessage().replace("ダイアログを開く");
    }

    private RString get質問メッセージCode() {
        return new RString(UrQuestionMessages.確認_汎用.getMessage().getCode());
    }

    /**
     * 認定基本調査入力を麻痺等の有無特記事項を押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_chkMahiChange(KihonChosaInput1Div div) {
        getHandler(div).麻痺等の有無ないChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を拘縮の有無特記事項を押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_chkKoshukuChange(KihonChosaInput1Div div) {
        getHandler(div).拘縮の有無ないChange();
        return ResponseData.of(div).respond();
    }

    private KihonChosaInputHandler1 getHandler(KihonChosaInput1Div div) {
        return new KihonChosaInputHandler1(div);
    }
}
