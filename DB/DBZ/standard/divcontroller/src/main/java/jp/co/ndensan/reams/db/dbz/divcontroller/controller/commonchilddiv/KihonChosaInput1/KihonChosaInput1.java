/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KihonChosaInput1;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInput1Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInputHandler1;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 認定基本調査入力の第一群身体機能のDivControllerです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaInput1 {

    private static final int 整数1 = 1;
    private static final int 整数2 = 2;
    private static final int 整数3 = 3;
    private static final int 整数4 = 4;
    private static final int 整数5 = 5;
    private static final int 整数6 = 6;
    private static final int 整数7 = 7;
    private static final int 整数8 = 8;
    private static final int 整数9 = 9;
    private static final int 整数11 = 11;

    /**
     * 画面初期化
     *
     * @param div KihonChosaInput1Div
     * @return ResponseData<KihonChosaInput1Div>
     */
    public ResponseData<KihonChosaInput1Div> onLoad(KihonChosaInput1Div div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getDaiichigunShintaiKino().getShinseishoKanriNo());
        RString 認定調査依頼履歴番号 = div.getDaiichigunShintaiKino().getRecordNumber();
        ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
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
            ArrayList<KihonChosaInput> 認定調査基本情報リスト = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
            ArrayList<KihonChosaInput> new認定調査基本情報リスト = getHandler(div).onClick_btnConfirm(認定調査基本情報リスト);
            ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, new認定調査基本情報リスト);
            必須入力チェック(new認定調査基本情報リスト);
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

    /**
     * 認定基本調査入力を麻痺等の有無ないを押下する。
     *
     * @param div {@link KihonChosaInput1Div 認定基本調査入力Div}
     * @return 認定基本調査入力Divを持つResponseData
     */
    public ResponseData<KihonChosaInput1Div> onClick_chkMahiChange(KihonChosaInput1Div div) {
        getHandler(div).麻痺等の有無ないChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定基本調査入力を拘縮の有無ないを押下する。
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

    private void 必須入力チェック(ArrayList<KihonChosaInput> new認定調査基本情報リスト) {
        int size = 0;
        int 連番;
        for (KihonChosaInput joho : new認定調査基本情報リスト) {
            連番 = joho.get調査連番();
            if (連番 != 整数1 && 連番 != 整数2 && 連番 != 整数3 && 連番 != 整数4 && 連番 != 整数5
                    && 連番 != 整数6 && 連番 != 整数7 && 連番 != 整数8 && 連番 != 整数9) {
                size++;
            }
        }
        if (size == 整数11) {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
        } else {
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("0"));
        }
    }
}
