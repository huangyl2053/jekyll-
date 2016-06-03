/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput2;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2.KihonChosaInput2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2.KihonChosaInputHandler2;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 認定基本調査入力の第二群生活機能のDivControllerです。
 *
 * @reamsid_L DBE-3000-091 wangjie2
 */
public class KihonChosaInput2 {

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput1Div
     * @return ResponseData<KihonChosaInput1Div>
     */
    public ResponseData<KihonChosaInput2Div> onLoad(KihonChosaInput2Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getSeikatsuKinou().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getSeikatsuKinou().getRecordNumber();
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onClick_btnConfirm(KihonChosaInput2Div div) {
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
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput2Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput2Div> onClick_btnBack(KihonChosaInput2Div div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private KihonChosaInputHandler2 getHandler(KihonChosaInput2Div div) {
        return new KihonChosaInputHandler2(div);
    }

}
