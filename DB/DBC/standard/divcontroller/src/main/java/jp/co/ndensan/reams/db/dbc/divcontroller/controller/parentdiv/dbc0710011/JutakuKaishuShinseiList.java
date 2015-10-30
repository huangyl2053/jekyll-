/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0710011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuKaishuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.dgJutakuKaishuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 住宅改修費申請登録 申請内容のパネルです。
 *
 * @author n8223 朴
 */
public class JutakuKaishuShinseiList {

    /**
     * 住宅改修費事申請登録 申請内容の情報をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiListDiv> onLoad(JutakuKaishuShinseiListDiv panel) {

        //TODO n3317塚田　遷移するために空行を作成
        List<dgJutakuKaishuShinseiList_Row> list = new ArrayList<>();
        list.add(new dgJutakuKaishuShinseiList_Row());
        panel.getDgJutakuKaishuShinseiList().setDataSource(list);
//        setJutakuKaishuShinseiList(panel);
        return ResponseData.of(panel).respond();
    }

    /**
     * 住宅改修費事申請登録 行を新規追加し、申請内容の情報をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiListDiv> onClick_btnAddShinseiContents(JutakuKaishuShinseiListDiv panel) {

//        int selRowId = panel.getDgJutakuKaishuShinseiList().getClickedRowId();
//
//        String ymlDataName;
//        setJutakuKaishuShinseiList(panel, ymlDataName);
        return ResponseData.of(panel).respond();
    }

    /*
     * 住宅改修費事申請登録 申請を追加するボタンを押下後、
     */
//    private void setJutakuKaishuShinseiList(JutakuKaishuShinseiListDiv panel) {
//
//        List<dgJutakuKaishuShinseiList_Row> arraydata = createRowJutakuKaishuShinseiTestData();
//        DataGrid<dgJutakuKaishuShinseiList_Row> grid = panel.getDgJutakuKaishuShinseiList();
//        grid.setDataSource(arraydata);
//
//    }

    /*
     * 住宅改修費事申請登録 申請内容の情報を設定する。
     */
    private List<dgJutakuKaishuShinseiList_Row> createRowJutakuKaishuShinseiTestData() {

        List<dgJutakuKaishuShinseiList_Row> arrayData = new ArrayList<>();
        arrayData.add(new dgJutakuKaishuShinseiList_Row());

        return arrayData;
    }

    /*
     * 共通内容を設定する
     */
//    private void hashMap(HashMap hashMap, List<dgJutakuKaishuShinseiList_Row> arrayData) {
//        RString state = new RString(hashMap.get("state").toString()); //状態
//        RString shinseiKubun = new RString(hashMap.get("shinseiKubun").toString()); //申請区分
//        RString teikyoYM = new RString(hashMap.get("teikyoYM").toString()); //提供年月
//        RString shinseiDate = new RString(hashMap.get("shinseiDate").toString()); //申請日
//        RString shinsaResult = new RString(hashMap.get("shinsaResult").toString()); //審査結果
//        RString shinsaDate = new RString(hashMap.get("shinsaDate").toString()); //審査日
//        RString shikyuKubun = new RString(hashMap.get("shikyuKubun").toString()); //審査結果
//        RString ketteiDate = new RString(hashMap.get("ketteiDate").toString()); //審査日
//        RString seiriNo = new RString(hashMap.get("seiriNo").toString()); //整理番号
//        RString jizenShinsei = new RString(hashMap.get("jizenShinsei").toString()); //事前申請
//
//        dgJutakuKaishuShinseiList_Row item;
//
//        item = createRowSearchHihokenshaiListData(
//                state,
//                shinseiKubun,
//                teikyoYM,
//                shinseiDate,
//                shinsaResult,
//                shinsaDate,
//                shikyuKubun,
//                ketteiDate,
//                seiriNo,
//                jizenShinsei
//        );
//        arrayData.add(item);
//    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgJutakuKaishuShinseiList_Row createRowSearchHihokenshaiListData(
            RString 状態,
            RString 申請区分,
            RString 提供年月,
            RString 申請日,
            RString 審査結果,
            RString 審査日,
            RString 支給区分,
            RString 決定日,
            RString 整理番号,
            RString 事前申請) {

        dgJutakuKaishuShinseiList_Row rowJutakuKaishuShinseiListData;
        rowJutakuKaishuShinseiListData = new dgJutakuKaishuShinseiList_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        if (isAddRow(状態.toString())) {
            rowJutakuKaishuShinseiListData.setRowState(RowState.Added);
        }
        rowJutakuKaishuShinseiListData.setTxtShinseiKubun(new RString(申請区分.toString()));
        rowJutakuKaishuShinseiListData.setTxtTeikyoYM(new RString(提供年月.toString()));
        rowJutakuKaishuShinseiListData.setTxtShinseiDate(new RString(申請日.toString()));
        rowJutakuKaishuShinseiListData.setTxtShinsaResult(new RString(審査結果.toString()));
        rowJutakuKaishuShinseiListData.setTxtShinsaDate(new RString(審査日.toString()));
        rowJutakuKaishuShinseiListData.setTxtShikyuKubun(new RString(支給区分.toString()));
        rowJutakuKaishuShinseiListData.setTxtKetteiDate(new RString(決定日.toString()));
        rowJutakuKaishuShinseiListData.setTxtSeiriNo(new RString(整理番号.toString()));
        rowJutakuKaishuShinseiListData.setTxtJizenShinsei(new RString(事前申請.toString()));

        return rowJutakuKaishuShinseiListData;

    }

    private boolean isAddRow(String 状態) {
        return ("追加").equals(状態);
    }
}
