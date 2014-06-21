/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuShinseiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 住宅改修費事申請登録 申請内容のパネルです。
 *
 * @author n8223
 */ 
public class JutakuKaishuShinseiList {

    /**
     * 住宅改修費事申請登録 申請内容の情報をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiListDiv> onClick_btnToDecide(JutakuKaishuShinseiListDiv panel) {
        ResponseData<JutakuKaishuShinseiListDiv> response = new ResponseData<>();

        //TO DO 
        String ymlDataName = "JutakuData_1.yml";
        
        setJutakuKaishuShinseiList(panel, ymlDataName);

        response.data = panel;
        return response;

    }

    /**
     * 住宅改修費事申請登録 行を新規追加し、申請内容の情報をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiListDiv> onClick_btnAddShinseiContents(JutakuKaishuShinseiListDiv panel) {
        ResponseData<JutakuKaishuShinseiListDiv> response = new ResponseData<>();

        //TO DO 
        int selRowId = panel.getDgJutakuKaishuShinseiList().getClickedRowId();
        
        System.out.println("+++selRowId++++" + selRowId);
        
        String ymlDataName;

        ///////////////////////////////////////////////////////////
        if (selRowId >= 0 ) {
            ymlDataName = "JutakuData_1_2.yml";
        } else {
            ymlDataName = "JutakuData_2.yml";
        }
        ///////////////////////////////////////////////////////////
        
        setJutakuKaishuShinseiList(panel, ymlDataName);

        response.data = panel;
        return response;

    }

    /*
     * 住宅改修費事申請登録 申請を追加するボタンを押下後、
     */
    private void setJutakuKaishuShinseiList(JutakuKaishuShinseiListDiv panel, String ymlDataName) {

        List<dgJutakuKaishuShinseiList_Row> arraydata = createRowJutakuKaishuShinseiTestData(ymlDataName);
        DataGrid<dgJutakuKaishuShinseiList_Row> grid = panel.getDgJutakuKaishuShinseiList();
        grid.setDataSource(arraydata);

    }

    /*
     * 住宅改修費事申請登録 申請内容の情報を設定する。
     */
    private List<dgJutakuKaishuShinseiList_Row> createRowJutakuKaishuShinseiTestData(String ymlDataName) {

        List<dgJutakuKaishuShinseiList_Row> arrayData = new ArrayList<>();

/////////////////////////////////////////////////////////////////////////////////////////
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        if (ymlDataName.equals("JutakuData_2.yml")) {

            //TO DO データを増える場合。
            for (int i = 2; i < ymlData.size(); i++) {
                HashMap hashMap = ymlData.get(i);
                hashMap(hashMap, arrayData);
            }

        } else if(ymlDataName.equals("JutakuData_1.yml")) {

            HashMap hashMap = ymlData.get(2);
            hashMap(hashMap, arrayData);

        } else if(ymlDataName.equals("JutakuData_1_2.yml")) {

            HashMap hashMap = ymlData.get(2);
            hashMap(hashMap, arrayData);
        }

        return arrayData;

    }

    /*
     * 共通内容を設定する
     */
    private void hashMap(HashMap hashMap, List<dgJutakuKaishuShinseiList_Row> arrayData) {
        String state = hashMap.get("state").toString(); //状態
        String shinseiKubun = hashMap.get("shinseiKubun").toString(); //申請区分
        String teikyoYM = hashMap.get("teikyoYM").toString(); //提供年月
        String shinseiDate = hashMap.get("shinseiDate").toString(); //申請日
        String shinsaResult = hashMap.get("shinsaResult").toString(); //審査結果
        String shinsaDate = hashMap.get("shinsaDate").toString(); //審査日
        String shikyuKubun = hashMap.get("shikyuKubun").toString(); //審査結果
        String ketteiDate = hashMap.get("ketteiDate").toString(); //審査日
        String seiriNo = hashMap.get("seiriNo").toString(); //整理番号
        String jizenShinsei = hashMap.get("jizenShinsei").toString();//事前申請

        dgJutakuKaishuShinseiList_Row item;

        item = createRowSearchHihokenshaiListData(
                state,
                shinseiKubun,
                teikyoYM,
                shinseiDate,
                shinsaResult,
                shinsaDate,
                shikyuKubun,
                ketteiDate,
                seiriNo,
                jizenShinsei
        );
        arrayData.add(item);
    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgJutakuKaishuShinseiList_Row createRowSearchHihokenshaiListData(
            String 状態,
            String 申請区分,
            String 提供年月,
            String 申請日,
            String 審査結果,
            String 審査日,
            String 支給区分,
            String 決定日,
            String 整理番号,
            String 事前申請) {

        dgJutakuKaishuShinseiList_Row rowJutakuKaishuShinseiListData;
        rowJutakuKaishuShinseiListData = new dgJutakuKaishuShinseiList_Row(
                new Button(),
                RString.EMPTY,
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

        rowJutakuKaishuShinseiListData.setTxtState(new RString(状態));
        rowJutakuKaishuShinseiListData.setTxtShinseiKubun(new RString(申請区分));
        rowJutakuKaishuShinseiListData.setTxtTeikyoYM(new RString(提供年月));
        rowJutakuKaishuShinseiListData.setTxtShinseiDate(new RString(申請日));
        rowJutakuKaishuShinseiListData.setTxtShinsaResult(new RString(審査結果));
        rowJutakuKaishuShinseiListData.setTxtShinsaDate(new RString(審査日));
        rowJutakuKaishuShinseiListData.setTxtShikyuKubun(new RString(支給区分));
        rowJutakuKaishuShinseiListData.setTxtKetteiDate(new RString(決定日));
        rowJutakuKaishuShinseiListData.setTxtSeiriNo(new RString(整理番号));
        rowJutakuKaishuShinseiListData.setTxtJizenShinsei(new RString(事前申請));

        return rowJutakuKaishuShinseiListData;

    }

    // TO DO  JutakuData１.xml ①
    private List<HashMap> ymlData(String ymlDataName) {

        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }

}
