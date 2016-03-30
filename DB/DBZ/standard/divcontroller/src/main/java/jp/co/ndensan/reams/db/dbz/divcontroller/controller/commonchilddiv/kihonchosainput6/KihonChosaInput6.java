/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kihonchosainput6;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6.KihonChosaInput6Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput6.KihonChosaInputHandler6;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 認定基本調査入力の特別な医療のDivControllerです。
 */
public class KihonChosaInput6 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput6Div
     * @return ResponseData<KihonChosaInput6Div>
     */
    public ResponseData<KihonChosaInput6Div> onLoad(KihonChosaInput6Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getTokubetsuIryo().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getTokubetsuIryo().getRecordNumber();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力をを処置内容特記事項を押下する。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onClick_btnOpenDialog(KihonChosaInput6Div div) {
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
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onClick_btnConfirm(KihonChosaInput6Div div) {
        getHandler(div).onClick_btnConfirm();
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput6Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput6Div> onClick_btnBack(KihonChosaInput6Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private Message get質問メッセージ() {
        return UrQuestionMessages.確認_汎用.getMessage().replace("ダイアログを開く");
    }

    private RString get質問メッセージCode() {
        return new RString(UrQuestionMessages.確認_汎用.getMessage().getCode());
    }

    private KihonChosaInputHandler6 getHandler(KihonChosaInput6Div div) {
        return new KihonChosaInputHandler6(div);
    }

}
