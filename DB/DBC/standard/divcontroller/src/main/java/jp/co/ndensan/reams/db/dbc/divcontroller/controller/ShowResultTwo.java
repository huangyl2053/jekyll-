/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.ShowResultTwoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultL_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultR_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 高額介護サービス費照会 #37963
 * @author n8223
 */
public class ShowResultTwo {
    
 /**
 * 高額介護サービス費照会  並べて表示
 *
 * @author n8223
 */
  public ResponseData<ShowResultTwoDiv> onClick_btnShowTwo(ShowResultTwoDiv panel) {
        ResponseData<ShowResultTwoDiv> response = new ResponseData<>();
        
        // 並べて表示 提供年月～世帯集約番号        
        setKogakuServicehiShowResultTwo(panel);
        //判定結果　L
        setKogakuServicehiShowResultTwoJudgementResultL(panel);
        //判定結果　R
        setKogakuServicehiShowResultTwoJudgementResultR(panel);
        
        response.data = panel;
        return response;
  }

    // 並べて表示 提供年月～世帯集約番号の情報を設定する。
    private void setKogakuServicehiShowResultTwo(ShowResultTwoDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiShowResultTwo.yml");

        // 提供年月～世帯集約番号(氏名）   
        panel.getTxtTeikyoYMShowTwo().setValue(new RDate(ymlData.get(0).get("teikyoYMShowTwo").toString()));
        panel.getTxtSetaiShuyakuNo().setValue(new RString(ymlData.get(0).get("setaiShuyakuNo").toString()));
        
        //dgJudgementResultLR	 判定結果
        panel.getTxtHihoNoL().setValue(new RString(ymlData.get(0).get("hihoNoL").toString()));
        panel.getTxtHihoNameR().setValue(new RString(ymlData.get(0).get("hhoNameR").toString()));
        panel.getTxtHihoNoR().setValue(new RString(ymlData.get(0).get("hihoNoR").toString()));
        panel.getTxtHihoNameL().setValue(new RString(ymlData.get(0).get("hihoNameL").toString()));
        
        panel.getJudgementResultL().getTxtBikoL().setValue(new RString(ymlData.get(1).get("bkoL").toString()));
        panel.getJudgementResultL().getTxtUketsukeDateL().setValue(new RDate(ymlData.get(1).get("uketsukeDateL").toString()));
        panel.getJudgementResultL().getTxtKetteiDateL().setValue(new RDate(ymlData.get(1).get("ketteiDateL").toString()));
        panel.getJudgementResultL().getTxtShiharaiAmountL().setValue(new Decimal(ymlData.get(1).get("shiharaiAmountL").toString()));
        panel.getJudgementResultL().getTxtFushikyuRiyuL().setValue(new RString(ymlData.get(1).get("fushikyuRiyuL").toString()));
        panel.getJudgementResultL().getTxtShikyuAmountL().setValue(new Decimal(ymlData.get(1).get("shikyuAmountL").toString()));
        
        panel.getJudgementResultR().getTxtBikoR().setValue(new RString(ymlData.get(2).get("bkoR").toString()));
        panel.getJudgementResultR().getTxtUketsukeDateR().setValue(new RDate(ymlData.get(2).get("uketsukeDateR").toString()));
        panel.getJudgementResultR().getTxtKetteiDateR().setValue(new RDate(ymlData.get(2).get("ketteiDateR").toString()));
        panel.getJudgementResultR().getTxtShiharaiAmountR().setValue(new Decimal(ymlData.get(2).get("shiharaiAmountR").toString()));
        panel.getJudgementResultR().getTxtFushikyuRiyuR().setValue(new RString(ymlData.get(2).get("fushikyuRiyuR").toString()));
        panel.getJudgementResultR().getTxtShikyuAmountR().setValue(new Decimal(ymlData.get(2).get("shikyuAmountR").toString()));
    
    }

    // dgJudgementResultL	 判定結果
    private void setKogakuServicehiShowResultTwoJudgementResultL(ShowResultTwoDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiShowResultTwoJudgementResultL.yml");
        
        List<dgJudgementResultL_Row> arraydata = createRowKogakuServicehiShowResultTwoJudgementResultLTestData(ymlData);
        DataGrid<dgJudgementResultL_Row> grid = panel.getJudgementResultL().getDgJudgementResultL();

        grid.setDataSource(arraydata);
      
    }

    private List<dgJudgementResultL_Row> createRowKogakuServicehiShowResultTwoJudgementResultLTestData(List<HashMap> ymlData) {
        List<dgJudgementResultL_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            hashMapResultL(hashMap, arrayData);
        }

        return arrayData;
    }
   
       //gJudgementResultL	 判定結果
       private void hashMapResultL(HashMap hashMap, List<dgJudgementResultL_Row> arrayData) {

           dgJudgementResultL_Row item; 
           
           item = createRowKogakuServicehiShowResultLData(
           hashMap.get("jigyosha").toString(),
           hashMap.get("serviceShurui").toString(),
           hashMap.get("serviceHiyoTotalAmount").toString(),
           hashMap.get("riyoshaFutanTotalAmount") .toString(),
           hashMap.get("santeiKijunAmount").toString(), 
           hashMap.get("shiharaizumiAmount").toString(), 
           hashMap.get("kogakuShikyuAmount").toString()
        );
        arrayData.add(item);
    }

     private dgJudgementResultL_Row createRowKogakuServicehiShowResultLData
        (
                String jigyosha,
                String serviceShurui,
                String serviceHiyoTotalAmount,
                String riyoshaFutanTotalAmount,
                String santeiKijunAmount,
                String shiharaizumiAmount,
                String kogakuShikyuAmount
        ) {
        dgJudgementResultL_Row rowKogakuServicehiShowResultLData;
        rowKogakuServicehiShowResultLData = new dgJudgementResultL_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );
        
        //事業者
        rowKogakuServicehiShowResultLData.setTxtJigyosha(new RString(jigyosha));
        //サービス種類
        rowKogakuServicehiShowResultLData.setTxtServiceShurui(new RString(serviceShurui));
        //サービス費用合計
        rowKogakuServicehiShowResultLData.setTxtServiceHiyoTotalAmount(new RString(serviceHiyoTotalAmount));
        //利用者<負担額合計
        rowKogakuServicehiShowResultLData.setTxtRiyoshaFutanTotalAmount(new RString(riyoshaFutanTotalAmount));
        //算定基準額
        rowKogakuServicehiShowResultLData.setTxtSanteiKijunAmount(new RString(santeiKijunAmount));
        //支払済金額
        rowKogakuServicehiShowResultLData.setTxtShiharaizumiAmount(new RString(shiharaizumiAmount));
        //高額支給額
        rowKogakuServicehiShowResultLData.setTxtKogakuShikyuAmount(new RString(kogakuShikyuAmount));

        return rowKogakuServicehiShowResultLData;
      
        }
    
    
    // dgJudgementResultR	 判定結果
    private void setKogakuServicehiShowResultTwoJudgementResultR(ShowResultTwoDiv panel) {
         List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiShowResultTwoJudgementResultR.yml");
        
        List<dgJudgementResultR_Row> arraydata = createRowKogakuServicehiShowResultTwoJudgementResultRTestData(ymlData);
        DataGrid<dgJudgementResultR_Row> grid = panel.getJudgementResultR().getDgJudgementResultR();

        grid.setDataSource(arraydata);
        
    }
  
   
    private List<dgJudgementResultR_Row> createRowKogakuServicehiShowResultTwoJudgementResultRTestData(List<HashMap> ymlData) {
        List<dgJudgementResultR_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            hashMapResultR(hashMap, arrayData);
        }

        return arrayData;
    
    }
    
    private void hashMapResultR(HashMap hashMap, List<dgJudgementResultR_Row> arrayData) {
            dgJudgementResultR_Row item; 
           
           item = createRowKogakuServicehiShowResultRData(
           hashMap.get("jigyosha").toString(),
           hashMap.get("serviceShurui").toString(),
           hashMap.get("serviceHiyoTotalAmount").toString(),
           hashMap.get("riyoshaFutanTotalAmount") .toString(),
           hashMap.get("santeiKijunAmount").toString(), 
           hashMap.get("shiharaizumiAmount").toString(), 
           hashMap.get("kogakuShikyuAmount").toString()
        );
        arrayData.add(item);
        
     }

        private dgJudgementResultR_Row createRowKogakuServicehiShowResultRData(
                String jigyosha,
                String serviceShurui,
                String serviceHiyoTotalAmount,
                String riyoshaFutanTotalAmount,
                String santeiKijunAmount,
                String shiharaizumiAmount,
                String kogakuShikyuAmount
        ) {
        dgJudgementResultR_Row rowKogakuServicehiShowResultRData;
        rowKogakuServicehiShowResultRData = new dgJudgementResultR_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );
        
        //事業者
        rowKogakuServicehiShowResultRData.setTxtJigyosha(new RString(jigyosha));
        //サービス種類
        rowKogakuServicehiShowResultRData.setTxtServiceShurui(new RString(serviceShurui));
        //サービス費用合計
        rowKogakuServicehiShowResultRData.setTxtServiceHiyoTotalAmount(new RString(serviceHiyoTotalAmount));
        //利用者<負担額合計
        rowKogakuServicehiShowResultRData.setTxtRiyoshaFutanTotalAmount(new RString(riyoshaFutanTotalAmount));
        //算定基準額
        rowKogakuServicehiShowResultRData.setTxtSanteiKijunAmount(new RString(santeiKijunAmount));
        //支払済金額
        rowKogakuServicehiShowResultRData.setTxtShiharaizumiAmount(new RString(shiharaizumiAmount));
        //高額支給額
        rowKogakuServicehiShowResultRData.setTxtKogakuShikyuAmount(new RString(kogakuShikyuAmount));

        return rowKogakuServicehiShowResultRData;
        }
        
        
    
    private List<HashMap> ymlData(String ymlData) {
    return YamlLoader.FOR_DBC.loadAsList(new RString(ymlData));
   }

}
