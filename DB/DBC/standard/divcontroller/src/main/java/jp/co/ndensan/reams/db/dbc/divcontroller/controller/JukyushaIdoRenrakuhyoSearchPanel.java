/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N3317 塚田 萌
 */
public class JukyushaIdoRenrakuhyoSearchPanel {

//    static List<dgJukyushaIdoRenrakuhyoSearchResult_Row> testDataList;
    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onLoad(JukyushaIdoRenrakuhyoSearchPanelDiv panel) {
//        testDataList = createTestData();
        panel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtSearchHihoNo().setValue(new RString("0000000001"));
        set検索結果一覧(panel);
//        panel.getJukyushaIdoRenrakuhyoSearchResultIchiran().getDgJukyushaIdoRenrakuhyoSearchResult().
//                getDataSource().get(0).setTxtResultHihoName(new RString("田中"));
        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
        response.data = panel;

        return response;
    }

//    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnSearch(JukyushaIdoRenrakuhyoSearchPanelDiv panel) {
//        set検索結果一覧(panel);
//
//        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
//        response.data = panel;
//
//        return response;
//    }
//
//    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnClearSearchCondition(JukyushaIdoRenrakuhyoSearchPanelDiv panel) {
//        panel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtIdoDateRange().setFromValue(RString.EMPTY);
//        panel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtIdoDateRange().setToValue(RString.EMPTY);
//        panel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtSearchHihoNo().setValue(RString.EMPTY);
//        panel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtGetDataMaxNum().setValue(RString.EMPTY);
////        panel.getJukyushaIdoRenrakuhyoSearchCondition().getChkIsSearchDeletedDate().setDataSource(null);
//
//        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
//        response.data = panel;
//
//        return response;
//    }
//
////    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_dgDetail_show(JukyushaIdoRenrakuhyoSearchPanelDiv panel) {
//////        set検索結果一覧(panel);
////
////        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
////        response.data = panel;
////
////        return response;
////    }
    private void set検索結果一覧(JukyushaIdoRenrakuhyoSearchPanelDiv panel) {
//        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> dataList = createTestData();
        //   selectedDataList = selectData(panel);
//        dataList = createTestData();
//        DataGrid<dgJukyushaIdoRenrakuhyoSearchResult_Row> grid
//                = panel.getJukyushaIdoRenrakuhyoSearchResultIchiran().getDgJukyushaIdoRenrakuhyoSearchResult();
        panel.getJukyushaIdoRenrakuhyoSearchResultIchiran().getDgJukyushaIdoRenrakuhyoSearchResult().setDataSource(createTestData());
    }
//
////    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> selectData(JukyushaIdoRenrakuhyoSearchPanelDiv panel) {
////        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> selectedList = new ArrayList<>();
////
////        for (dgJukyushaIdoRenrakuhyoSearchResult_Row row : testDataList) {
////            if (row.getTxtResultHihoNo().equals(
////                    panel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtSearchHihoNo().getValue())) {
////                selectedList.add(row);
////            }
////        }
////        return selectedList;
////    }

    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createTestData() {
        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> list = new ArrayList<>();
        dgJukyushaIdoRenrakuhyoSearchResult_Row row;

        row = createRow("20110101", "0000000001", "電算　一郎", "201110102");
        list.add(row);
//        row = createRow("20120101", "0000000001", "電算　一郎", "201110102");
//        list.add(row);
//        row = createRow("20110202", "0000000002", "電算　二郎", "201110102");
//        list.add(row);
//        row = createRow("20120202", "0000000002", "電算　二郎", "201120102");
//        list.add(row);
//        row = createRow("20110301", "0000000003", "電算　三郎", "201110102");
//        list.add(row);
//        row = createRow("20110402", "0000000004", "電算　四郎", "201110102");
//        list.add(row);
//        row = createRow("20110501", "0000000005", "電算　五郎", "201110102");
//        list.add(row);
//        row = createRow("20110602", "0000000006", "電算　六郎", "201110102");
//        list.add(row);
//        row = createRow("20110701", "0000000007", "電算　七郎", "201110102");
//        list.add(row);
//        row = createRow("20110801", "0000000008", "電算　八郎", "201110102");
//        list.add(row);
//        row = createRow("20110902", "0000000009", "電算　九郎", "201110102");
//        list.add(row);
//        row = createRow("20111002", "0000000010", "電算　十郎", "201110102");
//        list.add(row);
        return list;
    }

    private dgJukyushaIdoRenrakuhyoSearchResult_Row createRow(String 異動日, String 被保番号, String 氏名, String 送付年月) {

        dgJukyushaIdoRenrakuhyoSearchResult_Row row = new dgJukyushaIdoRenrakuhyoSearchResult_Row(
                new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setTxtResultIdoDate(convertDate(異動日));
        row.setTxtResultHihoNo(new RString(被保番号));
        row.setTxtResultHihoName(new RString(氏名));
        row.setTxtResultSendYM(convertDate(送付年月));

        return row;
    }

    private RString convertDate(String date) {
        return new FlexibleDate(new RString(date)).wareki().eraType(EraType.KANJI_RYAKU).toDateString();
    }
}
