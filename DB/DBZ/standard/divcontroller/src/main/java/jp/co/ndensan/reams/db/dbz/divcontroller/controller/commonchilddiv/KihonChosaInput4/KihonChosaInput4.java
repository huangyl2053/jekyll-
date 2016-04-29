/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput4;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4.KihonChosaInput4Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4.KihonChosaInputHandler4;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 認定基本調査入力の第四群精神・行動障害のDivControllerです。
 *
 * @reamsid_L DBE-3000-093 wangjie2
 */
public class KihonChosaInput4 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput4Div
     * @return ResponseData<KihonChosaInput4Div>
     */
    public ResponseData<KihonChosaInput4Div> onLoad(KihonChosaInput4Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getKoudoShogai().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getKoudoShogai().getRecordNumber();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onClick_btnConfirm(KihonChosaInput4Div div) {
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
     * @param div {@link KihonChosaInput4Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput4Div> onClick_btnBack(KihonChosaInput4Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler4 getHandler(KihonChosaInput4Div div) {
        return new KihonChosaInputHandler4(div);
    }

}
