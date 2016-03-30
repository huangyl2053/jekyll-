/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kihonchosainput3;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3.KihonChosaInput3Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput3.KihonChosaInputHandler3;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 認定基本調査入力の第三群認知機能のDivControllerです。
 */
public class KihonChosaInput3 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput3Div
     * @return ResponseData<KihonChosaInput3Div>
     */
    public ResponseData<KihonChosaInput3Div> onLoad(KihonChosaInput3Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getNinchiKinou().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getNinchiKinou().getRecordNumber();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力をを処置内容特記事項を押下する。
     *
     * @param div {@link KihonChosaInput3Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput3Div> onClick_btnOpenDialog(KihonChosaInput3Div div) {
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
     * @param div {@link KihonChosaInput3Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput3Div> onClick_btnConfirm(KihonChosaInput3Div div) {
        getHandler(div).onClick_btnConfirm();
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput3Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput3Div> onClick_btnBack(KihonChosaInput3Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler3 getHandler(KihonChosaInput3Div div) {
        return new KihonChosaInputHandler3(div);
    }

    private Message get質問メッセージ() {
        return UrQuestionMessages.確認_汎用.getMessage().replace("ダイアログを開く");
    }

    private RString get質問メッセージCode() {
        return new RString(UrQuestionMessages.確認_汎用.getMessage().getCode());
    }

}
