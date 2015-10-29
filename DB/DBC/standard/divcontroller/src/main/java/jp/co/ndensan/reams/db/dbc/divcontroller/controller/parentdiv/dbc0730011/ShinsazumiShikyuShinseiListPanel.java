package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0730011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ShinsazumiShikyuShinseiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.dgShinsazumiShikyuShinsei_Row;
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
 * @author n8223 朴
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

        panel.getTxtKetteiDate().setValue(RDate.getNowDate());
        setShinsazumiShikyuShinseiList(panel);

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

        //requestSettingsにセットしていない。
        //検索ボタンを押してから時間がかかるので、オンロード時にデータセットしておく。パネルは閉じているので。
        setShinsazumiShikyuShinseiList(panel);
        response.data = panel;
        return response;
    }

    /*
     * 住宅改修費支給申請審査 審査済支給申請一覧の内容を設定する。
     */
    private void setShinsazumiShikyuShinseiList(ShinsazumiShikyuShinseiListPanelDiv panel) {

        //TO DO
        RString ymlDataName = new RString("ShinsazumiShikyuShinseiList.yml");

        List<dgShinsazumiShikyuShinsei_Row> arraydata = createRowShinsazumiShikyuShinseiTestData(ymlDataName.toString());
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
        RString shikyuShinseiDate = new RString(hashMap.get("shikyuShinseiDate").toString());
        RString teikyoYM = new RString(hashMap.get("teikyoYM").toString());
        RString hihoNo = new RString(hashMap.get("hihoNo").toString());
        RString hihokenshaName = new RString(hashMap.get("hihokenshaName").toString());
        RString hokenKyufuAmount = new RString(hashMap.get("hokenKyufuAmount").toString());
        RString riyoshaFutanAmount = new RString(hashMap.get("riyoshaFutanAmount").toString());
        RString hiyoTotalAmount = new RString(hashMap.get("hiyoTotalAmount").toString());
        //追加 2014.5.30 park 　審査日追加
        RString shinsaDate = new RString(hashMap.get("shinsaDate").toString());
        RString shinsaResult = new RString(hashMap.get("shinsaResult").toString());
        RString seiriNo = new RString(hashMap.get("seiriNo").toString());

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
            RString 支給申請日,
            RString 提供年月,
            RString 被保番号,
            RString 氏名,
            RString 保険給付額,
            RString 利用者負担額,
            RString 費用額合計,
            RString 審査日,
            RString 審査結果,
            RString 整理番号) {

        dgShinsazumiShikyuShinsei_Row rowShinsazumiShinseiListData;
        rowShinsazumiShinseiListData = new dgShinsazumiShikyuShinsei_Row(
                new TextBoxDate(),
                new TextBoxDate(),
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                Boolean.valueOf(false),
                Boolean.valueOf(false),
                new TextBoxDate(),
                RString.EMPTY,
                new TextBoxCode()
        );

        rowShinsazumiShinseiListData.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日.toString()));
        rowShinsazumiShinseiListData.getTxtTeikyoYM().setValue(new RDate(提供年月.toString()));
        rowShinsazumiShinseiListData.setTxtHihoNo(被保番号);
        rowShinsazumiShinseiListData.setTxtHihokenshaName(氏名);
        rowShinsazumiShinseiListData.getTxtHokenKyufuAmount().setValue(new Decimal(保険給付額.toString()));
        rowShinsazumiShinseiListData.getTxtRiyoshaFutanAmount().setValue(new Decimal(利用者負担額.toString()));
        rowShinsazumiShinseiListData.getTxtHiyoTotalAmount().setValue(new Decimal(費用額合計.toString()));
        rowShinsazumiShinseiListData.getTxtShinsaDate().setValue(new RDate(審査日.toString()));

        if (("1111111114").equals(被保番号)) {
            rowShinsazumiShinseiListData.setTxt3DankaiReset(Boolean.TRUE);
        }

        rowShinsazumiShinseiListData.setTxtShinsaResult(審査結果);
        rowShinsazumiShinseiListData.getTxtSeiriNo().setValue(整理番号);

        return rowShinsazumiShinseiListData;
    }
    /*
     * YML DATA 設定する
     */

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.DBC.loadAsList(new RString("dbc0730011/" + ymlDataName));
    }
}
