/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputHandler;
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
     * @param div 調査委託先/調査員入力共有子Div
     * @return 調査委託先投票区名称
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_txtChosaItakusakiCode(ChosaItakusakiAndChosainInputDiv div) {
        createHandOf(div).onBlurTxtChosaItakusakiCode();
        return createSettingData(div);
    }

    /**
     * 共有子Div上で入力された調査員コードから調査員名称を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 調査員名称
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_txtChosainCode(ChosaItakusakiAndChosainInputDiv div) {
        createHandOf(div).onBlurTxtChosainCode();
        return createSettingData(div);
    }

    /**
     * 共有子Div上で前回(委託先情報)を複写するボタンを押下すると前回(委託先情報)を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 前回(委託先情報)
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_btnZenkaiFukusha(ChosaItakusakiAndChosainInputDiv div) {
        createHandOf(div).onClickBtnZenkaiFukusha();
        return createSettingData(div);
    }

    /**
     * onClick_btnClearボタンを押下した際に動作するメソッドです。<br/>
     * 共有子Div内の項目に設定された値をすべてクリアします。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_btnClear(ChosaItakusakiAndChosainInputDiv div) {
        createHandOf(div).onClickBtnClear();
        return createSettingData(div);
    }

    /**
     * onClickbtnTorokuボタンを押した際に動作するメソッドです。<br/>
     * 共有子Div内の項目に設定された値を保存します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClickbtnToroku(ChosaItakusakiAndChosainInputDiv div) {
        createHandOf(div).onClickbtnToroku();
        return createSettingData(div);
    }

    private ChosaItakusakiAndChosainInputHandler createHandOf(ChosaItakusakiAndChosainInputDiv div) {
        return new ChosaItakusakiAndChosainInputHandler(div);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }
}
