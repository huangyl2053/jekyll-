/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「介護認定申請情報入力」のイベントを定義したクラスです。
 *
 * @author N8235 船山 洋介
 */
public class KaigoNinteiShinseiKihonJohoInput {

    /**
     * ロード時の処理を行います。
     *
     * @param div 介護認定申請基本情報入力Div
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> onLoad(KaigoNinteiShinseiKihonJohoInputDiv div) {
        KaigoNinteiShinseiKihonJohoInputHandler handler = createHandler(div);
        handler.Initialize();

        return createResponseData(div);
    }

    private ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> createResponseData(KaigoNinteiShinseiKihonJohoInputDiv div) {
        ResponseData<KaigoNinteiShinseiKihonJohoInputDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }

    private KaigoNinteiShinseiKihonJohoInputHandler createHandler(KaigoNinteiShinseiKihonJohoInputDiv div) {
        return new KaigoNinteiShinseiKihonJohoInputHandler(div);
    }
}
