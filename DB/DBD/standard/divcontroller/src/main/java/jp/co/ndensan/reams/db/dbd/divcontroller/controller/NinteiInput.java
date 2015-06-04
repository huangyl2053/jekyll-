/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput.NinteiInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「認定情報」のイベントを定義したクラスです。
 *
 * @author N8235 船山 洋介
 */
public class NinteiInput {

    /**
     * 認定区分変更時の処理を行います。
     *
     * @param div 認定情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<NinteiInputDiv> onChangeNinteiKubun(NinteiInputDiv div) {

        createHandler(div).onChangeNinteiKubun();

        return createResponseData(div);

    }

    /**
     * 6ヶ月ボタン押下時の処理を行います。
     *
     * @param div 認定情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<NinteiInputDiv> onClickSixMonthLater(NinteiInputDiv div) {

        createHandler(div).onClickSixMonthLater();

        return createResponseData(div);
    }

    /**
     * 12ヶ月ボタン押下時の処理を行います。
     *
     * @param div 認定情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<NinteiInputDiv> onClickTwelveMonthLater(NinteiInputDiv div) {

        createHandler(div).onClickTwelveMonthLater();

        return createResponseData(div);
    }

    /**
     * 18ヶ月ボタン押下時の処理を行います。
     *
     * @param div 認定情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<NinteiInputDiv> onClickEighteenMonthLater(NinteiInputDiv div) {

        createHandler(div).onClickEighteenMonthLater();

        return createResponseData(div);
    }

    /**
     * 24ヶ月ボタン押下時の処理を行います。
     *
     * @param div 認定情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<NinteiInputDiv> onClickTwentyfourMonthLater(NinteiInputDiv div) {

        createHandler(div).onClickTwentyfourMonthLater();

        return createResponseData(div);
    }

    private ResponseData<NinteiInputDiv> createResponseData(NinteiInputDiv div) {

        ResponseData<NinteiInputDiv> responseData = new ResponseData<>();
        responseData.data = div;

        return responseData;
    }

    private NinteiInputHandler createHandler(NinteiInputDiv div) {
        return new NinteiInputHandler(div);
    }

}
