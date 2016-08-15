///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;
//
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
//
///**
// * 受給者異動連絡票変更登録 対象者一覧のコントローラークラスです。
// *
// * @author n8156 宮本 康
// */
//public class JukyushaIdoRenrakuhyoHenkoSearchResultListPanel {
//
//    /**
//     * 検索時の処理です。
//     *
//     * @param panel panel
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> onClick_btnSearch(
//            JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
//        setJukyushaIdoRenrakuhyoHenkoSearchResult(panel);
//
//        return ResponseData.of(panel).respond();
//    }
//
//    /**
//     * 削除時の処理です。
//     *
//     * @param panel panel
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> onClick_btnDelete(
//            JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
//        modifyJukyushaIdoRenrakuhyoHenkoSearchResult(panel, RowState.Deleted);
//
//        return ResponseData.of(panel).respond();
//    }
//
//    private void setJukyushaIdoRenrakuhyoHenkoSearchResult(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
//        //TODO n3317塚田　遷移させるために空のリストを作成
////        List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> list = new ArrayList<>();
////        list.add(new dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row());
////        panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().setDataSource(list);
////        loadJukyushaIdoRenrakuhyoHenkoSearchResult(panel);
//    }
//
////    private void loadJukyushaIdoRenrakuhyoHenkoSearchResult(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
////        List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> list = new ArrayList<>();
////        list.add(createJukyushaIdoRenrakuhyoHenkoSearchResultRow());
////
////        panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult()
////                .setDataSource(list);
////    }
//    private void modifyJukyushaIdoRenrakuhyoHenkoSearchResult(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel, RowState rowState) {
////        int clickedRowId = panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedRowId();
////        if (clickedRowId > -1) {
//////            panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getDataSource().get(clickedRowId).setRowState(rowState);
////        }
//    }
//
////    private dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row createJukyushaIdoRenrakuhyoHenkoSearchResultRow(
////            TextBoxDate txtResultIdoDate,
////            TextBoxCode txtResultHihoNo,
////            TextBox txtResultHihoName,
////            TextBoxDate txtResultSendYM) {
////        return new dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row(
////                new Button(),
////                new Button(),
////                txtResultIdoDate,
////                txtResultHihoNo,
////                txtResultHihoName,
////                txtResultSendYM,
////                true);
////    }
//}
