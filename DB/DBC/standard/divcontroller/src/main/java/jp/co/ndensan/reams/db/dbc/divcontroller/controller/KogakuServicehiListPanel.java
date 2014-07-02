/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.KogakuServicehiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author n8223
 */
public class KogakuServicehiListPanel {

    /**
     * 高額介護サービス費照会 高額介護サービス費照会画面の一覧で該当者を検索するボタンを押したら、一覧の内容が表示する。
     *
     * @author n8223
     * @param panel
     * @return 
     */
    public ResponseData<KogakuServicehiListPanelDiv> onClick_btnSearch(KogakuServicehiListPanelDiv panel) {
        ResponseData<KogakuServicehiListPanelDiv> response = new ResponseData<>();

        //高額介護サービス費照会画面の一覧内容を設定する。
        setKogakuServicehiList(panel);

        response.data = panel;
        return response;
    }

//dgKogakuServicehiRireki 高額介護サービス費一覧
    private void setKogakuServicehiList(KogakuServicehiListPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiList.yml");

        List<dgKogakuServicehiRireki_Row> arraydata = createRowKogakuServicehiListTestData(ymlData);
        DataGrid<dgKogakuServicehiRireki_Row> grid = panel.getDgKogakuServicehiRireki();

        grid.setDataSource(arraydata);
    }

    private List<dgKogakuServicehiRireki_Row> createRowKogakuServicehiListTestData(List<HashMap> ymlData) {

        List<dgKogakuServicehiRireki_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
           
            ControlGenerator ymlDt = new ControlGenerator(hashMap);
            hashMap(ymlDt, arrayData);
        }

        return arrayData;
    }

    private void hashMap(ControlGenerator ymlDt, List<dgKogakuServicehiRireki_Row> arrayData) {

        dgKogakuServicehiRireki_Row item;

        item = createRowKogakuServicehiListData(
                
                //被保険番号
                ymlDt.getAsRString("hihoNo"),
                //被保険名
                ymlDt.getAsRString("hihoName"),
                //提供年月
                ymlDt.getAsRString("teikyoYM"),
                ymlDt.getAsDecimal("kogakuShikyuAmount"),
                //申請年月             
                ymlDt.getAsRString("shinseiDate"),
                //決定年月
                ymlDt.getAsRString("ketteiDate"),
                
                ymlDt.getAsRString("shikyuKubun"),
                ymlDt.getAsDecimal("shikyuKingaku"),
                ymlDt.getAsRString("kogakuAutoShokan"),
                ymlDt.getAsRString("hokensha")
        );
        arrayData.add(item);
    }

    private dgKogakuServicehiRireki_Row createRowKogakuServicehiListData(
            RString hihoNo,
            RString hihoName,
            RString teikyoYM,
            Decimal kogakuShikyuAmount,
            RString shinseiDate,
            RString ketteiDate,
            RString shikyuKubun,
            Decimal shikyuKingaku,
            RString kogakuAutoShokan,
            RString hokensha
    ) {
        dgKogakuServicehiRireki_Row rowKogakuServicehiData;
        rowKogakuServicehiData = new dgKogakuServicehiRireki_Row(
                new Button(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                RString.EMPTY,
                RString.EMPTY
        );

        //被保番号 
        rowKogakuServicehiData.setTxtHihoNo(hihoNo);
        //氏名
        rowKogakuServicehiData.setTxtHihoName(hihoName);
        //提供年月
        rowKogakuServicehiData.setTxtTeikyoYM(teikyoYM);
        //高額支給額
        rowKogakuServicehiData.getTxtKogakuShikyuAmount().setValue(kogakuShikyuAmount);
        //申請日
        rowKogakuServicehiData.setTxtShinseiDate(shinseiDate);
        //決定日
        rowKogakuServicehiData.setTxtKetteiDate(ketteiDate);
        //支給区分
        rowKogakuServicehiData.setTxtShikyuKubun(shikyuKubun);
        //支給金額
        rowKogakuServicehiData.getTxtShikyuKingaku().setValue(shikyuKingaku);
        //高額自動償還
        rowKogakuServicehiData.setTxtKogakuAutoShokan(kogakuAutoShokan);
        //保険者
        rowKogakuServicehiData.setTxtHokensha(hokensha);

        return rowKogakuServicehiData;

    }

    private List<HashMap> ymlData(String ymlData) {
        return YamlLoader.DBC.loadAsList(new RString(ymlData));
    }

}
