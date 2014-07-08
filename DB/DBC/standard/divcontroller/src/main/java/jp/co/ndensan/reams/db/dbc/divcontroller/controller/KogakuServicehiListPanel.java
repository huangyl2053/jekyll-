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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SearchKogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author n8223 初期非表示、対応 20104.06.30
 */
public class KogakuServicehiListPanel {

    /**
     * 高額介護サービス費照会 高額介護サービス費照会画面の一覧で該当者を検索するボタンを押したら、一覧の内容が表示する。
     *
     * @author n8223 ①高額介護サービス費照会画面の一覧から選択された 「被保険番号 ,被保険名 , 提供年月, 申請年月, 決定年月」
     * その YMLデータを設定する。」014．07.01
     *
     * @param panel
     * @param searchpanel
     * @return
     */
    public ResponseData<KogakuServicehiListPanelDiv> onClick_btnSearch(KogakuServicehiListPanelDiv panel, SearchKogakuServicehiPanelDiv searchpanel) {
        ResponseData<KogakuServicehiListPanelDiv> response = new ResponseData<>();

        //2014.07.01 朴　入力データがあるのかチェックする
        //  Boolean status = setStatus(searchpanel);
        //if (status.equals(true)) {
        //高額介護サービス費照会画面の一覧内容を設定する。
        setKogakuServicehiList(panel, searchpanel);
        //}

        response.data = panel;
        return response;
    }

    //dgKogakuServicehiRireki 高額介護サービス費一覧
    private void setKogakuServicehiList(KogakuServicehiListPanelDiv panel, SearchKogakuServicehiPanelDiv searchpanel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiList.yml");

        List<dgKogakuServicehiRireki_Row> arraydata = createRowKogakuServicehiListTestData(ymlData, searchpanel);
        DataGrid<dgKogakuServicehiRireki_Row> grid = panel.getDgKogakuServicehiRireki();

        grid.setDataSource(arraydata);
    }

    private List<dgKogakuServicehiRireki_Row> createRowKogakuServicehiListTestData(List<HashMap> ymlData, SearchKogakuServicehiPanelDiv searchpanel) {

        List<dgKogakuServicehiRireki_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);

            ControlGenerator ymlDt = new ControlGenerator(hashMap);
            hashMap(ymlDt, arrayData, searchpanel);
        }

        return arrayData;
    }

    private void hashMap(ControlGenerator ymlDt, List<dgKogakuServicehiRireki_Row> arrayData, SearchKogakuServicehiPanelDiv searchpanel) {
        RString hihonNo = null;
        RString hihoName = null;
        RString teikyoYM = null;
        RString shinseiYM = null;
        RString ketteiYM = null;

        dgKogakuServicehiRireki_Row item;
        switch (searchpanel.getRadSearchKubun().getSelectedItem().toString()) {
            case "hihokenshaShitei":
                //2014.07.01 画面入力
                //被保番号
              //  hihonNo = searchpanel.getSearchKogakuHihokensha().getTxtHihoNo().getValue();
                hihonNo = ymlDt.getAsRString("hihoNo");

                if (IsBlankString(searchpanel.getSearchKogakuHihokensha().getTxtHihoName().getValue())) {
                    hihoName = ymlDt.getAsRString("hihoName");
                } else {
                    hihoName = searchpanel.getSearchKogakuHihokensha().getTxtHihoName().getValue();
                }

                //提供年月
                if (IsNullDate(searchpanel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().getFromValue())) {
                    teikyoYM = ymlDt.getAsRString("teikyoYM");
                } else {
                    teikyoYM = searchpanel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().getFromValue().toDateString();
                }
                
                //申請年月
                if (IsNullDate(searchpanel.getSearchKogakuHihokensha().getTxtShinseiYMRange().getFromValue())) {
                    shinseiYM =  ymlDt.getAsRString("shinseiDate"); 
                } else { 
                    shinseiYM = searchpanel.getSearchKogakuHihokensha().getTxtShinseiYMRange().getFromValue().toDateString();
                }
                
                //決定年月
                if (IsNullDate(searchpanel.getSearchKogakuHihokensha().getTxtKetteiYMRange().getFromValue())) {
                    ketteiYM =  ymlDt.getAsRString("ketteiDate"); 
                }  else {
                    ketteiYM = searchpanel.getSearchKogakuHihokensha().getTxtKetteiYMRange().getFromValue().toDateString(); }
                break;

            case "YMShitei":
                //被保番号
                hihonNo = ymlDt.getAsRString("hihoNo");
                //提供年月
                hihoName = ymlDt.getAsRString("hihoName");
                //2014.07.01 画面入力
                //提供年月                
                if(IsNullDate(searchpanel.getSearchYM().getTxtTeikyoYM().getValue())) {
                    teikyoYM = ymlDt.getAsRString("teikyoYM"); 
                } else {   
                    teikyoYM = searchpanel.getSearchYM().getTxtTeikyoYM().getValue().toDateString();
                }
              
                //申請年月
                if(IsNullDate(searchpanel.getSearchYM().getTxtShinseiYM().getValue())) {
                    shinseiYM = ymlDt.getAsRString("shinseiDate"); 
                } else {
                     shinseiYM = searchpanel.getSearchYM().getTxtShinseiYM().getValue().toDateString();
                }
               
                //決定年月
                if(IsNullDate(searchpanel.getSearchYM().getTxtKetteiYM().getValue())) {
                    ketteiYM =  ymlDt.getAsRString("ketteiDate"); 
                } else {
                    ketteiYM = searchpanel.getSearchYM().getTxtKetteiYM().getValue().toDateString();
                }
                
                break;
        }

        item = createRowKogakuServicehiListData(
                //2014.07.01 画面入力
                //被保険番号
                hihonNo,
                //提供年月
                hihoName,
                //提供年月
                teikyoYM,
                ymlDt.getAsDecimal("kogakuShikyuAmount"),
                //申請年月
                shinseiYM,
                //決定年月
                ketteiYM,
                //YML DATA
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
        rowKogakuServicehiData.setTxtTeikyoYM(setWareki(teikyoYM).substring(0, 6));
        //高額支給額
        rowKogakuServicehiData.getTxtKogakuShikyuAmount().setValue(kogakuShikyuAmount);
        //申請日
        rowKogakuServicehiData.setTxtShinseiDate(setWareki(shinseiDate));
        //決定日
        rowKogakuServicehiData.setTxtKetteiDate(setWareki(ketteiDate));
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

    private Boolean IsBlankString(RString str) {
        return (str == null || str.isEmpty());
    }

    private Boolean IsNullDate(RDate ymd) {
        return (ymd == null);
    }

    private RString setWareki(RString wareki) {
        FlexibleDate warekiYmd = new FlexibleDate(wareki);
        return warekiYmd.wareki().toDateString();
    }

    private List<HashMap> ymlData(String ymlData) {
        return YamlLoader.DBC.loadAsList(new RString(ymlData));
    }

}
