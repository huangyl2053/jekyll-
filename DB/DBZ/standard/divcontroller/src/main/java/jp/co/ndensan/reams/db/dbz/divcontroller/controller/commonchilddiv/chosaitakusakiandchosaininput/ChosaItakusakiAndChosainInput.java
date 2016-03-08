/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「調査委託先/調査員入力」のDivControllerです。
 *
 */
public class ChosaItakusakiAndChosainInput {

    /**
     * 入力された調査委託先コードより、調査委託先名称を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 調査委託先投票区名称
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_TxtChosaItakusakiCode(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onBlurTxtChosaItakusakiCode();
        return ResponseData.of(div).respond();
    }

    /**
     * 共有子Div上で入力された調査員コードから調査員名称を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 調査員名称
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_TxtChosainCode(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onBlurTxtChosainCode();
        return ResponseData.of(div).respond();
    }

    /**
     * 共有子Div上で前回(委託先情報)を複写するボタンを押下すると前回(委託先情報)を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 前回(委託先情報)
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_BtnZenkaiFukusha(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onClickBtnZenkaiFukusha();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnClearボタンを押下した際に動作するメソッドです。<br/>
     * 共有子Div内の項目に設定された値をすべてクリアします。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_BtnClear(ChosaItakusakiAndChosainInputDiv div) {
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiName().clearValue();
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainName().clearValue();
        return ResponseData.of(div).respond();
    }

    private ChosaItakusakiAndChosainInputHandler getHandler(ChosaItakusakiAndChosainInputDiv div) {
        return new ChosaItakusakiAndChosainInputHandler(div);
    }

}
