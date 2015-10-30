/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0320001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.KihonJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 賦課照会の基本情報Divです。
 *
 * @author N3317 塚田 萌
 */
public class KihonJoho {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<KihonJohoDiv> onLoad(KihonJohoDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 基本情報Div
     * @return レスポンスデータ
     */
    public ResponseData<KihonJohoDiv> initialize(KihonJohoDiv div) {

        // TODO n8187久保田 画面遷移の確認のために一時的にコメントアウト。
        // ここから
//        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
//
//        div.getCcdKaigoAtenaInfo().set介護宛名賦課モード();
//        div.getCcdKaigoAtenaInfo().load(taishoshaKey.get識別コード());
//
//        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
//                taishoshaKey.get通知書番号(),
//                new FukaNendo(taishoshaKey.get賦課年度()),
//                new LasdecCode(BusinessConfig.get(SystemConfigKey.DonyuDantaiCode, SubGyomuCode.UZAフレームワーク)),
//                taishoshaKey.get識別コード()).build();
//        div.getCcdKaigoFukaKihon().load(searchKey);
        // ここまで
        return createResponseData(div);
    }

    private ResponseData<KihonJohoDiv> createResponseData(KihonJohoDiv div) {
        return ResponseData.of(div).respond();
    }

}
