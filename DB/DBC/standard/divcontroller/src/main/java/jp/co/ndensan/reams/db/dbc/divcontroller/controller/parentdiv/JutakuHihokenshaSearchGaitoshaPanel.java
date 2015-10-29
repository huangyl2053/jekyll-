/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuHihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuHihokenshaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 住宅改修費事前申請登録 該当者一覧のパネルです。
 *
 * @author n8223
 */
public class JutakuHihokenshaSearchGaitoshaPanel {

    /**
     * 住宅改修費事前申請登録 該当者一覧の情報を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuHihokenshaSearchGaitoshaPanelDiv> onClick_btnHihokenshaSearch(JutakuHihokenshaSearchGaitoshaPanelDiv panel, JutakuHihokenshaSearchPanelDiv panel1) {
        ResponseData<JutakuHihokenshaSearchGaitoshaPanelDiv> response = new ResponseData<>();

        setHihokenshaSearchData(panel);
        response.data = panel;
        return response;

    }

    /*
     該当者一覧の初期値をセットします。
     */
    private void setHihokenshaSearchData(JutakuHihokenshaSearchGaitoshaPanelDiv panel) {

        List<dgHihokenshaSearchGaitosha_Row> arraydata = createRowHihokenshaSearchTestData();
        DataGrid<dgHihokenshaSearchGaitosha_Row> grid = panel.getDgHihokenshaSearchGaitosha();
        grid.setDataSource(arraydata);

    }


    /*
     該当者一覧の初期値のテストデータです。
     */
    private List<dgHihokenshaSearchGaitosha_Row> createRowHihokenshaSearchTestData() {

        List<dgHihokenshaSearchGaitosha_Row> arrayData = new ArrayList<>();

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuHihokenshaSearchData.xml ①
        List<HashMap> ymlData = YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData.yml"));

        //JutakuData.xml Read　②
        RString hihokenshaNo = (RString) ymlData.get(1).get("hihokenshaNo");
        RString shimei = (RString) ymlData.get(1).get("shimei");
        RString dateOfBirth = (RString) ymlData.get(1).get("dateOfBirth");
        RString age = (RString) ymlData.get(1).get("age");
        RString gender = (RString) ymlData.get(1).get("gender");
        RString jusho = (RString) ymlData.get(1).get("jusho");
        RString shikibetsuCode = (RString) ymlData.get(1).get("shikibetsuCode");
        /////////////////////////////////////////////////////////////////////////////////////////

        dgHihokenshaSearchGaitosha_Row item;
        item = createRowHihokenshaData(
                hihokenshaNo,
                shimei,
                dateOfBirth,
                age,
                gender,
                jusho,
                shikibetsuCode
        );
        arrayData.add(item);
        return arrayData;

    }

    /*
     引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgHihokenshaSearchGaitosha_Row createRowHihokenshaData(
            RString 被保番号,
            RString 氏名,
            RString 生年月日,
            RString 年齢,
            RString 性別,
            RString 住所,
            RString 識別コード
    ) {

        dgHihokenshaSearchGaitosha_Row rowHihokenshaData
                = new dgHihokenshaSearchGaitosha_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowHihokenshaData.setHihokenshaNo(被保番号);
        rowHihokenshaData.setShimei(氏名);
        rowHihokenshaData.setDateOfBirth(生年月日);
        rowHihokenshaData.setAge(年齢);
        rowHihokenshaData.setGender(性別);
        rowHihokenshaData.setJusho(住所);
        rowHihokenshaData.setShikibetsuCode(識別コード);

        return rowHihokenshaData;
    }

}
