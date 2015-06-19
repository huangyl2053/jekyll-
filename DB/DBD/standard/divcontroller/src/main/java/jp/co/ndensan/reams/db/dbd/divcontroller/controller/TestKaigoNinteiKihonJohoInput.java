/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestKaigoNinteiKihonJohoInput.TestKaigoNinteiKihonJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「介護認定申請基本情報入力」のテスト用
 *
 * @author N8235 船山 洋介
 */
public class TestKaigoNinteiKihonJohoInput {

    /**
     * ロードボタン押下の処理を行います。
     *
     * @param div 介護認定基本情報入力
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestKaigoNinteiKihonJohoInputDiv> onClickLoad(TestKaigoNinteiKihonJohoInputDiv div) {
        div.getCcdKaigoNinteiKihonJokyoInput().initialize();
        return createResponseData(div);
    }

    /**
     * クリアボタン押下の処理を行います。
     *
     * @param div 介護認定基本情報入力
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestKaigoNinteiKihonJohoInputDiv> onClickClear(TestKaigoNinteiKihonJohoInputDiv div) {
        div.getCcdKaigoNinteiKihonJokyoInput().clear();
        return createResponseData(div);
    }

    private ResponseData<TestKaigoNinteiKihonJohoInputDiv> createResponseData(TestKaigoNinteiKihonJohoInputDiv div) {
        ResponseData<TestKaigoNinteiKihonJohoInputDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }

}
