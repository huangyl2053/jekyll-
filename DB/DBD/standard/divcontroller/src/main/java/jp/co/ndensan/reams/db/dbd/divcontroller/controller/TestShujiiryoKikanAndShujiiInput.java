/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.testshujiiiryokikanandshujiiinput.TestShujiiryoKikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「主治医医療機関＆主治医入力」のテストクラスです。
 *
 * @author N8235 船山 洋介
 */
public class TestShujiiryoKikanAndShujiiInput {

    /**
     * テスト用データをセットします。
     *
     * @param div テスト主治医医療機関＆主治医入力Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestShujiiryoKikanAndShujiiInputDiv> setTestData(TestShujiiryoKikanAndShujiiInputDiv div) {
        div.getCcdShujiiIryokikanAndShujiiInput().setHdnShichosonCode(div.getTxtShichosonCode().getValue());
        div.getCcdShujiiIryokikanAndShujiiInput().setHdnShinseishoKanriNo(div.getTxtShinseishoKanriNo().getValue());
        div.getCcdShujiiIryokikanAndShujiiInput().setHdnDatabaseSubGyomuCode(div.getTxtSubGyomuCode().getValue());
        return createResponseDate(div);
    }

    private ResponseData<TestShujiiryoKikanAndShujiiInputDiv> createResponseDate(TestShujiiryoKikanAndShujiiInputDiv div) {
        ResponseData<TestShujiiryoKikanAndShujiiInputDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }
}
