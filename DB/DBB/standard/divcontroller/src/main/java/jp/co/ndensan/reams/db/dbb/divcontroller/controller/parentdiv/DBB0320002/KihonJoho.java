/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320002;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.KihonJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 賦課照会の基本情報Divです。
 *
 * @author N3317 塚田 萌
 */
public class KihonJoho {

    /**
     * 初期処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<KihonJohoDiv> initialize(KihonJohoDiv div) {

//        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
//
//        div.getCcdKaigoAtenaInfo().set介護宛名賦課モード();
//        div.getCcdKaigoAtenaInfo().load(taishoshaKey.get識別コード());
//
//        //TODO 市町村コードはどこから取得？→searchKey見直し予定
//        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
//                taishoshaKey.get通知書番号(), new FukaNendo(taishoshaKey.get賦課年度()), LasdecCode.EMPTY, taishoshaKey.get識別コード()).build();
//        div.getCcdKaigoFukaKihon().load(searchKey);
//
        return createResponseData(div);
    }

    private ResponseData<KihonJohoDiv> createResponseData(KihonJohoDiv div) {
        ResponseData<KihonJohoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
