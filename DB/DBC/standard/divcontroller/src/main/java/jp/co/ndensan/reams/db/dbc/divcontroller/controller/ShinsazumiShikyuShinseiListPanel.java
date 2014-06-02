package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotsuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShinsazumiShikyuShinseiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyufuJissekiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShinsazumiShikyuShinsei_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author n8223
 */
public class ShinsazumiShikyuShinseiListPanel {

    /**
     * 住宅改修費支給申請決定　決定日の内容をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<ShinsazumiShikyuShinseiListPanelDiv> onLoad(ShinsazumiShikyuShinseiListPanelDiv panel) {
        ResponseData<ShinsazumiShikyuShinseiListPanelDiv> response = new ResponseData<>();

        //TO DO 
        //TO DO 
        String ymlDataName = "ShinsazumiShikyuShinseiSearchCondition.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        String ketteiDate = ymlData.get(1).get("ketteiDate").toString();
        panel.getTxtKetteiDate().setValue(new RDate(ketteiDate));

        response.data = panel;
        return response;

    }

    /**
     * 住宅改修費支給申請決定 審査済支給申請一覧の内容をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<ShinsazumiShikyuShinseiListPanelDiv> onClick_btnSearchShinsazumi(ShinsazumiShikyuShinseiListPanelDiv panel) {
        ResponseData<ShinsazumiShikyuShinseiListPanelDiv> response = new ResponseData<>();

        //TO DO 
        setShinsazumiShikyuShinseiList(panel);

        response.data = panel;
        return response;

    }

    /*
     * 住宅改修費支給申請審査 審査済支給申請一覧の内容を設定する。
     */
    private void setShinsazumiShikyuShinseiList(ShinsazumiShikyuShinseiListPanelDiv panel) {

        //TO DO 
        String ymlDataName = "ShinsazumiShikyuShinseiList.yml";

        List<dgShinsazumiShikyuShinsei_Row> arraydata = createRowShinsazumiShikyuShinseiTestData(ymlDataName);
        DataGrid<dgShinsazumiShikyuShinsei_Row> grid = panel.getDgShinsazumiShikyuShinsei();
       
        grid.setDataSource(arraydata);

    }

    private List<dgShinsazumiShikyuShinsei_Row> createRowShinsazumiShikyuShinseiTestData(String ymlDataName) {
        List<dgShinsazumiShikyuShinsei_Row> arrayData = new ArrayList<>();

        List<HashMap> ymlData = ymlData(ymlDataName);

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            hashMap(hashMap, arrayData);
        }

        return arrayData;
    }

    private void hashMap(HashMap hashMap, List<dgShinsazumiShikyuShinsei_Row> arrayData) {
        //TO DO DataGrid
        String shikyuShinseiDate = hashMap.get("shikyuShinseiDate").toString();
        String teikyoYM = hashMap.get("teikyoYM").toString();
        String hihoNo = hashMap.get("hihoNo").toString();
        String hihokenshaName = hashMap.get("hihokenshaName").toString();
        String hokenKyufuAmount = hashMap.get("hokenKyufuAmount").toString();
        String riyoshaFutanAmount = hashMap.get("riyoshaFutanAmount").toString();
        String hiyoTotalAmount = hashMap.get("hiyoTotalAmount").toString();
        //追加 2014.5.30 park 　審査日追加
        String shinsaDate = hashMap.get("shinsaDate").toString();
        String shinsaResult = hashMap.get("shinsaResult").toString();
        String seiriNo = hashMap.get("seiriNo").toString();

        dgShinsazumiShikyuShinsei_Row item;

        item = createRowShinsazumiShikyuShinseiListData(
                shikyuShinseiDate,
                teikyoYM,
                hihoNo,
                hihokenshaName,
                hokenKyufuAmount,
                riyoshaFutanAmount,
                hiyoTotalAmount,
                shinsaDate,
                shinsaResult,
                seiriNo
        );
        arrayData.add(item);
    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgShinsazumiShikyuShinsei_Row createRowShinsazumiShikyuShinseiListData(
            String 支給申請日,
            String 提供年月,
            String 被保番号,
            String 氏名,
            String 保険給付額,
            String 利用者負担額,
            String 費用額合計,
            String 審査日,
            String 審査結果,
            String 整理番号) {

        dgShinsazumiShikyuShinsei_Row rowShinsazumiShikyuShinseiListData;
        rowShinsazumiShikyuShinseiListData = new dgShinsazumiShikyuShinsei_Row(
                new TextBoxDate(),
                new TextBoxDate(),
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new Boolean(false),
                new Boolean(false),
                new TextBoxDate(),
                RString.EMPTY,
                new TextBoxCode()
        );

        rowShinsazumiShikyuShinseiListData.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日));
        rowShinsazumiShikyuShinseiListData.getTxtTeikyoYM().setValue(new RDate(提供年月));
        rowShinsazumiShikyuShinseiListData.setTxtHihoNo(new RString(被保番号));
        rowShinsazumiShikyuShinseiListData.setTxtHihokenshaName(new RString(氏名));
        rowShinsazumiShikyuShinseiListData.getTxtHokenKyufuAmount().setValue(new Decimal(保険給付額));
        rowShinsazumiShikyuShinseiListData.getTxtRiyoshaFutanAmount().setValue(new Decimal(利用者負担額));
        rowShinsazumiShikyuShinseiListData.getTxtHiyoTotalAmount().setValue(new Decimal(費用額合計));
        rowShinsazumiShikyuShinseiListData.getTxtShinsaDate().setValue(new RDate(審査日));

        if (被保番号.equals("1111111114")) {
            rowShinsazumiShikyuShinseiListData.setTxt3DankaiReset(Boolean.TRUE);
        }
        
        rowShinsazumiShikyuShinseiListData.setTxtShinsaResult(new RString(審査結果));
        rowShinsazumiShikyuShinseiListData.getTxtSeiriNo().setValue(new RString(整理番号));

        return rowShinsazumiShikyuShinseiListData;

    }
            /*
     * YML DATA 設定する
     */
    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }

}
