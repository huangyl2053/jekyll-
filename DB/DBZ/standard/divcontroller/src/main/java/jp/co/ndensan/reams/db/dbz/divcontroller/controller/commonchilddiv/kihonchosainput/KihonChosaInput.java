/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kihonchosainput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.KihonChosaInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput.KihonChosaInputHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定基本調査入力のDivControllerです。
 */
public class KihonChosaInput {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput
     * @return ResponseData<KihonChosaInput>
     */
    public ResponseData<KihonChosaInputDiv> onLoad(KihonChosaInputDiv div) {
        ShinseishoKanriNo 申請書管理番号
                = DataPassingConverter.deserialize(div.getDaiichigunShintaiKino().getShinseishoKanriNo(), ShinseishoKanriNo.class);
        RString 認定調査依頼履歴番号 = div.getDaiichigunShintaiKino().getRecordNumber();
        RString 初期状態モード = div.getモード();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 初期状態モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力をを処置内容特記事項を押下する。
     *
     * @param div {@link KihonChosaInputDiv 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInputDiv> onClick_btnOpenDialog(KihonChosaInputDiv div) {
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
     * 認定基本調査入力をを処置内容特記事項を押下する。
     *
     * @param div {@link KihonChosaInputDiv 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInputDiv> onClick_chkMahiChange(KihonChosaInputDiv div) {
        getHandler(div).麻痺等の有無ないChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力をを処置内容特記事項を押下する。
     *
     * @param div {@link KihonChosaInputDiv 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInputDiv> onClick_chkKoshukuChange(KihonChosaInputDiv div) {
        getHandler(div).拘縮の有無ないChange();
        return ResponseData.of(div).respond();
    }

    private KihonChosaInputHandler getHandler(KihonChosaInputDiv div) {
        return new KihonChosaInputHandler(div);
    }

    private Message get質問メッセージ() {
        return UrQuestionMessages.確認_汎用.getMessage().replace("ダイアログを開く");
    }

    private RString get質問メッセージCode() {
        return new RString(UrQuestionMessages.確認_汎用.getMessage().getCode());
    }

}
