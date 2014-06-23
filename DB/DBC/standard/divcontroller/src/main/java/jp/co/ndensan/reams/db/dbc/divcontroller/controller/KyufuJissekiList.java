/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgKyufuJissekiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumn;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiList {

    public ResponseData<KyufuJissekiListDiv> onClick_btnKyufuJissekiSearch(KyufuJissekiListDiv panel,
            KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();
        setData(panel, panel2);

        response.data = panel;
        return response;
    }

    public ResponseData<KyufuJissekiListDiv> onClick_btnKyufuJissekiResearch(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();
        panel.getTxtKyufuJissekiListHihokenshaNo().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListJuminShubetsu().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListYokaigodo().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListNinteiYukoKikan().clearFromValue();
        panel.getTxtKyufuJissekiListNinteiYukoKikan().clearToValue();
        panel.getTxtKyufuJissekiListName().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListSeibetsu().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListSeinengappi().setValue(RString.EMPTY);
        panel.getDgKyufuJissekiList().setDataSource(Collections.EMPTY_LIST);
        List<DataGridColumn> colList = panel.getDgKyufuJissekiList().getGridSetting().getColumns();
        for (int i = 0; i < colList.size(); i++) {
            colList.get(i).setVisible(false);
        }
        response.data = panel;
        return response;
    }

    private void setData(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {

        List<HashMap> kyufuJissekiList = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJissekiList.yml"));

        //ヘッダー情報取得、設定
        HashMap hashMap = kyufuJissekiList.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtKyufuJissekiListHihokenshaNo().setValue(
                panel2.getTxtKyufuJissekiSearchHihokenshaNo().getValue());
        panel.getTxtKyufuJissekiListJuminShubetsu().setValue(ymlData.getAsRString("JuminShubetsu"));
        panel.getTxtKyufuJissekiListYokaigodo().setValue(ymlData.getAsRString("Yokaigodo"));
        panel.getTxtKyufuJissekiListNinteiYukoKikan().setFromValue(ymlData.getAsRDate("NinteiYukoKikanFrom"));
        panel.getTxtKyufuJissekiListNinteiYukoKikan().setToValue(ymlData.getAsRDate("NinteiYukoKikanTo"));
        panel.getTxtKyufuJissekiListName().setValue(ymlData.getAsRString("Name"));
        panel.getTxtKyufuJissekiListSeibetsu().setValue(ymlData.getAsRString("Seibetsu"));
        panel.getTxtKyufuJissekiListSeinengappi().setValue(ymlData.getAsRString("Seinengappi"));

        //給付実績一覧データ取得、設定
        List<dgKyufuJissekiList_Row> arraydata = createRowKyufuJissekiList(kyufuJissekiList);

        List<DataGridColumn> colList = panel.getDgKyufuJissekiList().getGridSetting().getColumns();
        for (int i = 0; i < colList.size(); i++) {
            colList.get(i).setVisible(true);
        }
        panel.getDgKyufuJissekiList().setDataSource(arraydata);

//        List<dgKyufuJissekiList_Row> list = new ArrayList<>();
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "訪問介護", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206", "1,206"));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "訪問入浴", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "訪問看護", "880", "880", "880", "880", "880", "880", "880", "880", "880", "880", "880", "880"));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "訪問リハビリ", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "通所介護", "10,292", "12,101", "10,488", "10,488", "11,362", "11,362", "11,362", "11,362", "11,362", "11,362", "11,362", "11,362"));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "通所リハビリ", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "訪問通所", "福祉用具貸与", "1,075", "887", "350", "350", "350", "350", "350", "350", "350", "350", "350", "350"));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "短期入所", "生活介護", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "短期入所", "療養介護（老人保健施設）", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "短期入所", "療養介護（療養型医療施設等）", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "短期入所", "出来高請求額", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "", "居宅療養管理指導", "1,400", "1,150", "1,450", "1,450", "1,450", "1,950", "1,950", "1,950", "1,950", "1,950", "1,950", "1,950"));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "", "特定施設入所者生活介護(短期以外)", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "", "特定施設入所者生活介護(短期)", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "認知症対応型共同生活介護", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "地域密着型特定施設入所者生活介護(短期以外)", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "地域密着型特定施設入所者生活介護(短期)", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "認知症対応型共同生活(短期)", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "夜間対応型訪問介護", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "認知症対応型通所介護", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "小規模多機能型居宅介護", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "定期巡回・随時対応型訪問介護看護", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定居宅サービス", "地域密着", "複合型サービス", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("居宅介護", "", "居宅介護支援", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定施設サービス等", "", "介護福祉施設サービス", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定施設サービス等", "", "介護保健施設サービス", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定施設サービス等", "", "介護療養施設サービス", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定施設サービス等", "地域", "地域密着型介護老人福祉施設", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("指定施設サービス等", "", "出来高請求額", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("", "", "居宅サービス合計単位", "14,903", "16,174", "14,324", "14,324", "15,198", "14,894", "14,894", "14,894", "14,894", "14,894", "14,894", "14,894"));
//        list.add(createKyufuJissekiListRow("", "", "施設サービス合計単位", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("", "", "地域密着型サービス合計単位", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("", "", "給付費合計", "134,127", "145,566", "128,916", "123,916", "136,782", "", "134,046", "134,046", "134,046", "134,046", "134,046", "134,046"));
//        list.add(createKyufuJissekiListRow("", "", "利用者負担合計", "14,903", "16,174", "14,324", "14,324", "15,198", "14,894", "14,894", "14,894", "14,894", "14,894", "14,894", "14,894"));
//        list.add(createKyufuJissekiListRow("", "", "高額介護費", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("", "", "福祉用具販売", "", "", "", "", "", "", "", "", "", "", "", ""));
//        list.add(createKyufuJissekiListRow("", "", "住宅改修", "", "", "", "", "", "", "", "", "", "", "", ""));
//        List<DataGridColumn> colList = panel.getDgKyufuJissekiList().getGridSetting().getColumns();
//        for (int i = 0; i < colList.size(); i++) {
//            colList.get(i).setVisible(true);
//        }
//        panel.getDgKyufuJissekiList().setDataSource(list);
    }

//    private dgKyufuJissekiList_Row createRowKyufuJissekiList(
//            String txtServiceGroup1, String txtServiceGroup2, String txtServiceShurui,
//            String txtYM1, String txtYM2, String txtYM3, String txtYM4, String txtYM5, String txtYM6,
//            String txtYM7, String txtYM8, String txtYM9, String txtYM10, String txtYM11, String txtYM12) {
//        return new dgKyufuJissekiList_Row(
//                new Button(), new RString(txtServiceGroup1), new RString(txtServiceGroup2), new RString(txtServiceShurui),
//                new RString(txtYM1), new RString(txtYM2), new RString(txtYM3), new RString(txtYM4), new RString(txtYM5), new RString(txtYM6),
//                new RString(txtYM7), new RString(txtYM8), new RString(txtYM9), new RString(txtYM10), new RString(txtYM11), new RString(txtYM12));
//    }

    /*
     *給付実績一覧情報の初期値をセットします。
     */
    private List createRowKyufuJissekiList(
            List<HashMap> kyufuJissekiList) {

        List<dgKyufuJissekiList_Row> arrayDataList = new ArrayList();

        for (int i = 1; i < kyufuJissekiList.size(); i++) {
            HashMap hashMap = kyufuJissekiList.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsServiceGroup1 = ymlData.getAsRString("txtServiceGroup1");
            RString rsServiceGroup2 = ymlData.getAsRString("txtServiceGroup2");
            RString rsServiceShurui = ymlData.getAsRString("txtServiceShurui");
            RString rsYM1 = ymlData.getAsRString("txtYM1");
            RString rsYM2 = ymlData.getAsRString("txtYM2");
            RString rsYM3 = ymlData.getAsRString("txtYM3");
            RString rsYM4 = ymlData.getAsRString("txtYM4");
            RString rsYM5 = ymlData.getAsRString("txtYM5");
            RString rsYM6 = ymlData.getAsRString("txtYM6");
            RString rsYM7 = ymlData.getAsRString("txtYM7");
            RString rsYM8 = ymlData.getAsRString("txtYM8");
            RString rsYM9 = ymlData.getAsRString("txtYM9");
            RString rsYM10 = ymlData.getAsRString("txtYM10");
            RString rsYM11 = ymlData.getAsRString("txtYM11");
            RString rsYM12 = ymlData.getAsRString("txtYM12");

            arrayDataList.add(createRowKyufuJissekiList(
                    rsServiceGroup1,
                    rsServiceGroup2,
                    rsServiceShurui,
                    rsYM1,
                    rsYM2,
                    rsYM3,
                    rsYM4,
                    rsYM5,
                    rsYM6,
                    rsYM7,
                    rsYM8,
                    rsYM9,
                    rsYM10,
                    rsYM11,
                    rsYM12
            ));

        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する被保険者証発行対象者情報データを作成します。
     */
    private dgKyufuJissekiList_Row createRowKyufuJissekiList(
            RString rsServiceGroup1,
            RString rsServiceGroup2,
            RString rsServiceShurui,
            RString rsYM1,
            RString rsYM2,
            RString rsYM3,
            RString rsYM4,
            RString rsYM5,
            RString rsYM6,
            RString rsYM7,
            RString rsYM8,
            RString rsYM9,
            RString rsYM10,
            RString rsYM11,
            RString rsYM12
    ) {
        dgKyufuJissekiList_Row rowKyufuJissekiList
                = new dgKyufuJissekiList_Row(
                        new Button(),
                        rsServiceGroup1,
                        rsServiceGroup2,
                        rsServiceShurui,
                        rsYM1,
                        rsYM2,
                        rsYM3,
                        rsYM4,
                        rsYM5,
                        rsYM6,
                        rsYM7,
                        rsYM8,
                        rsYM9,
                        rsYM10,
                        rsYM11,
                        rsYM12
                );
        return rowKyufuJissekiList;
    }
}
