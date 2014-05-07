///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.divcontroller.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchConditionDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchPanelDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoSearchResult_Row;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.lang.Range;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
//
///**
// * 受給者異動連絡票情報照会の検索パネルです。
// *
// * @author N3317 塚田 萌
// */
//public class JukyushaIdoRenrakuhyoSearchPanel {
//
//    /**
//     * 検索パネルが読み込まれた時は、検索項目をEMPTYで初期化し、検索結果一覧を閉じた状態にします。
//     *
//     * @param searchPanel
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onLoad(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//
//        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(false);
//        clearSearchCondtion(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition());
//
//        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
//        response.data = searchPanel;
//        return response;
//    }
//
//    /**
//     * 検索ボタンが押された時は、検索結果一覧を開き、検索結果を表示します。
//     *
//     * @param searchPanel
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnSearch(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//
//        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(true);
//        set連絡票検索結果一覧(searchPanel);
//
//        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
//        response.data = searchPanel;
//
//        return response;
//    }
//
//    /**
//     * 条件をクリアするボタンが押された時は検索条件をEMPTYでクリアします。
//     *
//     * @param searchPanel
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnClearSearchCondition(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//
//        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(false);
//        clearSearchCondtion(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition());
//
//        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
//        response.data = searchPanel;
//
//        return response;
//    }
//
//    /**
//     * 現在使用なし
//     *
//     * @param searchPanel
//     * @return
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_dgDetail_show(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
//        response.data = searchPanel;
//        return response;
//    }
//
//    private void clearSearchCondtion(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
////        searchConditionDiv.getTxtIdoDateRange().setFromValue(RDate.MAX);
////        searchConditionDiv.getTxtIdoDateRange().setToValue(RDate.MAX);
//        searchConditionDiv.getTxtSearchHihoNo().setValue(RString.EMPTY);
//        searchConditionDiv.getTxtGetDataMaxNum().setValue(Decimal.ZERO);
////        searchConditionDiv.getChkIsSearchDeletedData().setSelectedItems(null);
//    }
//
//    private void set連絡票検索結果一覧(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
//                getDgJukyushaIdoRenrakuhyoSearchResult().setDataSource(createData(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition()));
//    }
//
//    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createData(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
//        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> testDataList;
//        testDataList = createTestData();
//
//        //TODO テストデータをそのまま返す
//        return testDataList;
////        return selectData(searchConditionDiv, testDataList);
//    }
//
//    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> selectData(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv,
//            List<dgJukyushaIdoRenrakuhyoSearchResult_Row> testDataList) {
//
//        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> selectedList = new ArrayList<>();
//
////        if (!isEmpty異動期間(searchConditionDiv)) {
////            if (!isEmpty被保番号(searchConditionDiv)) {
////                selectedList = match異動期間(searchConditionDiv, testDataList);
////                selectedList = match被保番号(searchConditionDiv, selectedList);
////            } else {
////                selectedList = match異動期間(searchConditionDiv, testDataList);
////            }
////        } else if (!isEmpty被保番号(searchConditionDiv)) {
////            selectedList = match被保番号(searchConditionDiv, testDataList);
////        }
////        selectedList = match異動期間(searchConditionDiv, testDataList);
//        selectedList = match被保番号List(searchConditionDiv, testDataList);
//        return selectedList;
//    }
//
////    private boolean isEmpty異動期間(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
////        return isEmpty異動開始期間(searchConditionDiv) & (isEmpty異動終了期間(searchConditionDiv));
////    }
////
////    private boolean isEmpty異動開始期間(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
////        return searchConditionDiv.getTxtIdoDateRange().getFromText().equals(RString.EMPTY);
////    }
////
////    private boolean isEmpty異動終了期間(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
////        return searchConditionDiv.getTxtIdoDateRange().getToText().equals(RString.EMPTY);
////    }
////    private boolean isEmpty被保番号(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
////        return searchConditionDiv.getTxtSearchHihoNo().getText().equals(RString.EMPTY);
////    }
////    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> match異動期間(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv,
////            List<dgJukyushaIdoRenrakuhyoSearchResult_Row> testDataList) {
////
////        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> selectedList = new ArrayList<>();
////        Range<RDate> dateRange = new Range(searchConditionDiv.getTxtIdoDateRange().getFromValue(),
////                searchConditionDiv.getTxtIdoDateRange().getToValue());
////
////        for (dgJukyushaIdoRenrakuhyoSearchResult_Row row : testDataList) {
////            if (dateRange.between(new RDate(row.getTxtResultIdoDate().getValue().toString()))) {
////                selectedList.add(row);
////            }
////        }
////        return selectedList;
////    }
//    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> match被保番号List(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv,
//            List<dgJukyushaIdoRenrakuhyoSearchResult_Row> testDataList) {
//
//        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> selectedList = new ArrayList<>();
//        for (dgJukyushaIdoRenrakuhyoSearchResult_Row row : testDataList) {
//            if (row.getTxtResultHihoNo().getValue().equals(searchConditionDiv.getTxtSearchHihoNo().getValue())) {
//                selectedList.add(row);
//            }
//        }
//        return selectedList;
//    }
//
//    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createTestData() {
//        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> list = new ArrayList<>();
//        dgJukyushaIdoRenrakuhyoSearchResult_Row row;
//
//        row = createRow("20130101", "0000000001", "電算　一郎", "20111010");
//        list.add(row);
//        row = createRow("20140101", "0000000001", "電算　一郎", "20111010");
//        list.add(row);
//        row = createRow("20130202", "0000000002", "電算　二郎", "20111010");
//        list.add(row);
//        row = createRow("20140202", "0000000002", "電算　二郎", "20111010");
//        list.add(row);
//        row = createRow("20140301", "0000000003", "電算　三郎", "20111010");
//        list.add(row);
//        row = createRow("20140402", "0000000004", "電算　四郎", "20111010");
//        list.add(row);
//        row = createRow("20140501", "0000000005", "電算　五郎", "20111010");
//        list.add(row);
//        row = createRow("20140602", "0000000006", "電算　六郎", "20111010");
//        list.add(row);
////        row = createRow("20110701", "0000000007", "電算　七郎", "20111010");
////        list.add(row);
////        row = createRow("20110801", "0000000008", "電算　八郎", "20111010");
////        list.add(row);
////        row = createRow("20110902", "0000000009", "電算　九郎", "20111010");
////        list.add(row);
////        row = createRow("20111002", "0000000010", "電算　十郎", "20111010");
////        list.add(row);
//
//        return list;
//    }
//
//    private dgJukyushaIdoRenrakuhyoSearchResult_Row createRow(String 異動日, String 被保番号, String 氏名, String 送付年月) {
//
//        dgJukyushaIdoRenrakuhyoSearchResult_Row row = new dgJukyushaIdoRenrakuhyoSearchResult_Row(
//                new Button(), new TextBoxFlexibleDate(), new TextBoxCode(), new TextBox(), new TextBoxFlexibleDate());
//
//        row.getTxtResultIdoDate().setValue(new FlexibleDate(異動日));
//        row.getTxtResultHihoNo().setValue(new RString(被保番号));
//        row.getTxtResultHihoName().setValue(new RString(氏名));
//        row.getTxtResultSendYM().setValue(new FlexibleDate(送付年月));
//
//        return row;
//    }
//}
