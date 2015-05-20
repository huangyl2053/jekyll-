/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「調査委託先/調査員入力」のイベントを定義した共有子Divです。
 *
 * @author n8223　朴義一
 */
public class ChosaItakusakiAndChosainInput {

    /**
     * 共有子Div上で入力された調査委託先コードから調査委託先投票区名称を取得します。
     *
     * @param chosaItakusakiAndChosainInputDiv 調査委託先/調査員入力共有子Div
     * @return
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_txtChosaItakusakiCode(ChosaItakusakiAndChosainInputDiv chosaItakusakiAndChosainInputDiv) {
        createHandOf(chosaItakusakiAndChosainInputDiv).onBlurTxtChosaItakusakiCode();
        return createSettingData(chosaItakusakiAndChosainInputDiv);

    }

    private ChosaItakusakiAndChosainInputHandler createHandOf(ChosaItakusakiAndChosainInputDiv chosaItakusakiAndChosainInputDiv) {
        return new ChosaItakusakiAndChosainInputHandler(chosaItakusakiAndChosainInputDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }
}
