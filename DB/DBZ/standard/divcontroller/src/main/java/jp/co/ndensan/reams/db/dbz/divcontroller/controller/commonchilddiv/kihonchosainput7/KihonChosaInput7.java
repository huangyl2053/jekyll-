/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kihonchosainput7;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7.KihonChosaInput7Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7.KihonChosaInputHandler7;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 認定基本調査入力の自立度のDivControllerです。
 *
 * @reamsid_L DBE-3000-096 wangjie2
 */
public class KihonChosaInput7 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput7Div
     * @return ResponseData<KihonChosaInput7Div>
     */
    public ResponseData<KihonChosaInput7Div> onLoad(KihonChosaInput7Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getJiritsudo().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getJiritsudo().getRecordNumber();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput7Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput7Div> onClick_btnConfirm(KihonChosaInput7Div div) {
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

    private KihonChosaInputHandler7 getHandler(KihonChosaInput7Div div) {
        return new KihonChosaInputHandler7(div);
    }

    /**
     * 認定基本調査入力を戻るを押下する。
     *
     * @param div {@link KihonChosaInput7Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput7Div> onClick_btnBack(KihonChosaInput7Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

}
