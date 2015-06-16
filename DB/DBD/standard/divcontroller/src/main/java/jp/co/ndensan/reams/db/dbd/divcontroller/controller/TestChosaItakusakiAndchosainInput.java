/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestChosaItakusakiAndchosainInput.TestChosaItakusakiAndchosainInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * TestChosaItakusakiAndchosainInputDiv用の処理クラスです。
 *
 * @author n8223　朴義一
 */
public class TestChosaItakusakiAndchosainInput {

    /**
     * 親画面で業務コード・市町村コード・申請管理番号を受け取って（テスト用）設定します。
     *
     * @param div TestChosaItakusakiAndchosainInputDiv
     * @return ResponseData
     */
    public ResponseData<TestChosaItakusakiAndchosainInputDiv> onClickbtnSetinput(TestChosaItakusakiAndchosainInputDiv div) {

        div.getCcdChosaItakutsakiAndChosainInput().setHdnDatabaseSubGyomuCode(div.getTxtSubGyomuCode().getValue());
        div.getCcdChosaItakutsakiAndChosainInput().setHdnShinseishoKanriNo(div.getTxtShinseishoKanriNo().getValue());
        div.getCcdChosaItakutsakiAndChosainInput().setHdnShichosonCode(div.getTxtShichosonCode().getValue());

        return _createResponseData(div);
    }

    /**
     * 調査先情報・調査員情報を更新します。
     *
     * @param div TestChosaItakusakiAndchosainInputDiv
     * @return ResponseData
     */
    public ResponseData<TestChosaItakusakiAndchosainInputDiv> onClickbtnToroku(TestChosaItakusakiAndchosainInputDiv div) {
        div.getCcdChosaItakutsakiAndChosainInput().onClickbtnToroku();
        return _createResponseData(div);
    }

    private ResponseData<TestChosaItakusakiAndchosainInputDiv> _createResponseData(TestChosaItakusakiAndchosainInputDiv div) {
        ResponseData<TestChosaItakusakiAndchosainInputDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

}
