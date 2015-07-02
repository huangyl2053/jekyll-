/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.controller.helper.NinteiInputValidationHelper;
import jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput.NinteiInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

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

    /**
     * 有効開始日に対するバリデーションを行います。
     *
     * @param div 認定申請連絡先情報Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<NinteiInputDiv> beforeClickValidate(NinteiInputDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        pairs.add(NinteiInputValidationHelper.validate有効開始日(div.getTxtYukoKaishiYMD()));

        ResponseData<NinteiInputDiv> response = new ResponseData<>();

        response.addValidationMessages(pairs);
        response.data = div;
        return response;
    }

}
