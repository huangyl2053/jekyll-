/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput3;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3.KihonChosaInput3Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3.KihonChosaInputHandler3;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 認定基本調査入力の第三群認知機能のDivControllerです。
 *
 * @reamsid_L DBE-3000-092 wangjie2
 */
public class KihonChosaInput3 {

    private static final int 整数9 = 9;

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput3Div
     * @return ResponseData<KihonChosaInput3Div>
     */
    public ResponseData<KihonChosaInput3Div> onLoad(KihonChosaInput3Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getNinchiKinou().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getNinchiKinou().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param div {@link KihonChosaInput3Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput3Div> onClick_btnConfirm(KihonChosaInput3Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
            ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, new認定調査基本情報リスト);
            必須入力チェック(new認定調査基本情報リスト);
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
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

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        if (new認定調査基本情報リスト != null && new認定調査基本情報リスト.size() == 整数9) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }

}
