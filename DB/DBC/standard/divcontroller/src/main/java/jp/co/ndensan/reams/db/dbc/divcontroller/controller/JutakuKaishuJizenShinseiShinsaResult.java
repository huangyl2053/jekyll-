/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiShinsaResultDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費事前申請登録 審査結果のパネルです。
 * @author n8223
 */
public class JutakuKaishuJizenShinseiShinsaResult {
    
     /**
     * 住宅改修費事前申請登録 審査結果内容の情報を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiShinsaResultDiv> onLoad(JutakuKaishuJizenShinseiShinsaResultDiv panel) {
        ResponseData<JutakuKaishuJizenShinseiShinsaResultDiv> response = new ResponseData<>();
        
        //審査結果の初期値をセットする
        setShinseiShinsaResult(panel);
        //判定区分(承認、不承認）セットする。
        setRadJudgeKubun(panel);
        
        response.data = panel;
        return response;
    }
    
     /*
     審査結果の初期値をセットします。
     */
     private void setShinseiShinsaResult(JutakuKaishuJizenShinseiShinsaResultDiv panel) {
         
        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuHihokenshaSearchData.xml ①
         
        List<HashMap> ymlData = YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData.yml"));
        

        //JutakuData.xml Read　② 
        String judgeDate = ymlData.get(10).get("judgeDate").toString();
        String shoninCondition = ymlData.get(10).get("shoninCondition").toString();
       
        ///////////////////////////////////////////////////////////////////////////////////////// 
        
        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getTxtJudgeDate().setValue(new RDate(judgeDate));
        panel.getTxtShoninCondition().setValue(new RString(shoninCondition));
   
     }

     /*
     *判定区分(承認、不承認）セットする。
     */
    private void setRadJudgeKubun(JutakuKaishuJizenShinseiShinsaResultDiv panel) {
        
        panel.getTxtFushoninReason().setDisabled(true);
    }
    
    
     /**
     * 住宅改修費事前申請登録 判定区分を選択するとき、承認条件の内容を入力欄を不入力・入力可能。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiShinsaResultDiv> onClick_radJudgeKubun(JutakuKaishuJizenShinseiShinsaResultDiv panel) {
        ResponseData<JutakuKaishuJizenShinseiShinsaResultDiv> response = new ResponseData<>();
 
        System.out.println("++++" + panel.getRadJudgeKubun().getSelectedItem().toString());
        String selRadJudgeKubun = panel.getRadJudgeKubun().getSelectedItem().toString();
        
        
        //判定区分を選択するとき shonin 承認
       if(selRadJudgeKubun.equals("shonin")){
          panel.getTxtShoninCondition().setDisabled(false); 
          panel.getTxtFushoninReason().setDisabled(true);
        //判定区分を選択するとき fushonin 不承認   
       } else if(selRadJudgeKubun.equals("fushonin")){
           panel.getTxtFushoninReason().setDisabled(false);
          panel.getTxtShoninCondition().setDisabled(true);
       }
        
        response.data = panel;
        return response; 
    }

}    
    