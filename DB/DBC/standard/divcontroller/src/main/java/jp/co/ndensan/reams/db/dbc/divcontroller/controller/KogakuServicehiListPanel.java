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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultL_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgKogakuServicehiRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author n8223
 */
public class KogakuServicehiListPanel {
    
    
    
     /**
 * 高額介護サービス費照会  高額介護サービス費照会画面の一覧で該当者を検索するボタンを押したら、一覧の内容が表示する。
 *
 * @author n8223
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
            hashMap(hashMap, arrayData);
        }

        return arrayData;
    }

    private void hashMap(HashMap hashMap, List<dgKogakuServicehiRireki_Row> arrayData) {
  
           dgKogakuServicehiRireki_Row item; 
           
           item = createRowKogakuServicehiListData(
           hashMap.get("hihoNo").toString(),
           hashMap.get("hihoName").toString(),
           hashMap.get("teikyoYM").toString(),
           hashMap.get("kogakuShikyuAmount") .toString(),
           hashMap.get("shinseiDate").toString(), 
           hashMap.get("ketteiDate").toString(), 
           hashMap.get("shikyuKubun").toString(), 
           hashMap.get("shikyuKingaku").toString(),
           hashMap.get("kogakuAutoShokan").toString(),
           hashMap.get("hokensha").toString()
        );
        arrayData.add(item);
    }

        private dgKogakuServicehiRireki_Row createRowKogakuServicehiListData
        (
          String hihoNo,
          String hihoName,
          String teikyoYM,
          String kogakuShikyuAmount,
          String shinseiDate,
          String ketteiDate,
          String shikyuKubun,
          String shikyuKingaku,
          String kogakuAutoShokan,
          String hokensha
        ){
        dgKogakuServicehiRireki_Row rowKogakuServicehiData;
        rowKogakuServicehiData = new dgKogakuServicehiRireki_Row(
                new Button(),
                new TextBoxCode(),
                RString.EMPTY,
                new TextBoxDate(),
                new TextBoxNum(),
                new TextBoxDate(),
                new TextBoxDate(),
                RString.EMPTY,
                new TextBoxNum(),
                RString.EMPTY,
                RString.EMPTY
        );

        //被保番号 
        rowKogakuServicehiData.getTxtHihoNo().setValue(new RString(hihoNo));
        //氏名
        rowKogakuServicehiData.setTxtHihoName(new RString(hihoName));
        //提供年月
        rowKogakuServicehiData.getTxtTeikyoYM().setValue(new RDate(teikyoYM));
        //高額支給額
        rowKogakuServicehiData.getTxtKogakuShikyuAmount().setValue(new Decimal(kogakuShikyuAmount));
        //申請日
        rowKogakuServicehiData.getTxtShinseiDate().setValue(new RDate(shinseiDate));
        //決定日
        rowKogakuServicehiData.getTxtKetteiDate().setValue(new RDate(ketteiDate));
        //支給区分
        rowKogakuServicehiData.setTxtShikyuKubun(new RString(shikyuKubun));
        //支給金額
        rowKogakuServicehiData.getTxtShikyuKingaku().setValue(new Decimal(shikyuKingaku));
        //高額自動償還
        rowKogakuServicehiData.setTxtKogakuAutoShokan(new RString(kogakuAutoShokan));
        //保険者
        rowKogakuServicehiData.setTxtHokensha(new RString(hokensha));
 
        return  rowKogakuServicehiData;  
            
    }
    
    
     private List<HashMap> ymlData(String ymlData) {
    return YamlLoader.FOR_DBC.loadAsList(new RString(ymlData));
   }



}
