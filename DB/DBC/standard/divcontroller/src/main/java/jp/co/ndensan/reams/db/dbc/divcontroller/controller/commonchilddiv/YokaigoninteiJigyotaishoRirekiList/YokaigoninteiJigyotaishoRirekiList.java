///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.YokaigoninteiJigyotaishoRirekiList;
//
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.YokaigoninteiJigyotaishoRirekiList.YokaigoninteiJigyotaishoRirekiListDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.YokaigoninteiJigyotaishoRirekiList.YokaigoninteiJigyotaishoRirekiListHandler;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//
///**
// * DBCKD00001_認定履歴一覧
// *
// * @reamsid_L DBC-4350-010 wangxingpeng
// */
//public class YokaigoninteiJigyotaishoRirekiList {
//
//    /**
//     * 初期化のンメソッドます。
//     *
//     * @param div YokaigoninteiJigyotaishoRirekiListDiv
//     * @return ResponseData YokaigoninteiJigyotaishoRirekiListDiv
//     */
//    public ResponseData<YokaigoninteiJigyotaishoRirekiListDiv> onLoad(YokaigoninteiJigyotaishoRirekiListDiv div) {
//        getHandler(div).initialize();
//        return ResponseData.of(div).respond();
//    }
//
//    /**
//     * 閉じるボタンのンメソッドます。
//     *
//     * @param div YokaigoninteiJigyotaishoRirekiListDiv
//     * @return ResponseData YokaigoninteiJigyotaishoRirekiListDiv
//     */
//    public ResponseData<YokaigoninteiJigyotaishoRirekiListDiv> onClick_BtnClose(YokaigoninteiJigyotaishoRirekiListDiv div) {
//        return ResponseData.of(div).respond();
//    }
//
//    /**
//     * 認定履歴一覧のHandlerクラスを取得のンメソッドます。
//     *
//     * @param div YokaigoninteiJigyotaishoRirekiListDiv
//     * @return YokaigoninteiJigyotaishoRirekiListHandler
//     */
//    private YokaigoninteiJigyotaishoRirekiListHandler getHandler(YokaigoninteiJigyotaishoRirekiListDiv div) {
//        return new YokaigoninteiJigyotaishoRirekiListHandler(div);
//    }
//}
