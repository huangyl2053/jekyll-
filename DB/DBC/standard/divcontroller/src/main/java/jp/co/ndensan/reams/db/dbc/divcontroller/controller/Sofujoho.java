/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011.SofujohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011.dgSofuIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;


/**
 * 過誤申立書送付情報照会画面です。
 *
 * @author N3317 塚田 萌
 * @author n8223 改善事項：YMLデータ対応　2014.6.13
 */
public class Sofujoho {

    /**
     * 過誤申立書送付情報照会画面 初期表示
     *
     * @param panel 過誤申立書送付情報照会パネル
     * @return ResponseData
     */
    public ResponseData<SofujohoDiv> onLoad(SofujohoDiv panel) {
        ResponseData<SofujohoDiv> response = new ResponseData<>();
        //送付年月の表示
        setfuYminfo(panel);

        response.data = panel;
        return response;
    }

    //指定年月の送付済情報の条件が入力されたことをチェックするメソッド
    private Boolean setfuYminfo(SofujohoDiv panel) {
        boolean status = true;
        
        List<HashMap> ymlData = ymlData("dbc0070011/SofujohoSofuzumi.yml");
        
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);
               
        RDate ymlsofuYm = ymlDt.getAsRDate("sofuYM");
        RDate txtsoftYm = panel.getTxtSofuYM().getValue();

        System.out.println("++++ ymlsofuYm +++++ " + ymlsofuYm);
        System.out.println("++++ panel.getTxtSofuYM().getValue() +++++ " + txtsoftYm);
        
        //ユーザが指定年月の送付済情報を入力された情報がYML（7月）と同じ場合、データを表示する。
        if(!ymlsofuYm.equals(txtsoftYm)) {

            status = false;
            return status;  
        }
        return status;
       // panel.getTxtSofuYM().setValue(ymlDt.getAsRDate("sofuYM"));
   
    }

    /**
     * 未送付情報を表示するボタンで未送付情報一覧を表示します。
     *
     * @param panel 過誤申立書送付情報照会パネル
     * @return ResponseData
     */
    public ResponseData<SofujohoDiv> onClick_btnMisofu(SofujohoDiv panel) {
        ResponseData<SofujohoDiv> response = new ResponseData<>();
        //未送付済情報を表示
        setSearchMisofuList(panel);

        response.data = panel;
        return response;
    }

    private void setSearchMisofuList(SofujohoDiv panel) {
        panel.getTxtSofuYM().clearValue();
        List<dgSofuIchiran_Row> arraydata = createRowSearchSofuTestData(panel, "dbc0070011/SofujohoMisofu.yml");

        DataGrid<dgSofuIchiran_Row> grid = panel.getSofuIchiran().getDgSofuIchiran();
        grid.setDataSource(arraydata);
    }

    /**
     * 送付年月を指定して表示するボタンで指定年月の送付済情報を表示します。
     *
     * @param panel 過誤申立書送付情報照会パネル
     * @return ResponseData
     */
    public ResponseData<SofujohoDiv> onClick_btnSofuzumi(SofujohoDiv panel) {
        ResponseData<SofujohoDiv> response = new ResponseData<>();

        //送付年月を指定後、YMLデータ（送付年月）と比較する。2014.06.24 朴
        Boolean status = setfuYminfo(panel);
        //2014.06.27 朴　 
         if (status.equals(true)) {
             //送付済情報を表示
            setSearchSofuzumiList(panel);
         } else { 
             
            //送付済情報を表示 (DATAGRID clear) 2014.6.26 朴　
            List<dgSofuIchiran_Row> arrayData = new ArrayList<>();  
            DataGrid<dgSofuIchiran_Row> grid = panel.getSofuIchiran().getDgSofuIchiran();
            
            
            grid.setDataSource(arrayData);
            
         } 
         
        response.data = panel;
        return response;
    }

    private void setSearchSofuzumiList(SofujohoDiv panel) {
        List<dgSofuIchiran_Row> arraydata = createRowSearchSofuTestData(panel, "dbc0070011/SofujohoSofuzumi.yml");

        DataGrid<dgSofuIchiran_Row> grid = panel.getSofuIchiran().getDgSofuIchiran();
        grid.setDataSource(arraydata);

    }

    private List<dgSofuIchiran_Row> createRowSearchSofuTestData(SofujohoDiv panel, String ymlName) {
        List<dgSofuIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> ymlData = ymlData(ymlName);
           
        //TO DO データを増える場合。
        for (int i = 1; i < ymlData.size(); i++) {

            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);

            arrayData.add(createRowSearchSofuzumiList(
                    ymlDt.getAsRString("jigyoshaNo"),
                    ymlDt.getAsRString("jigyoshaName"),
                    ymlDt.getAsRString("hihoNo"),
                    ymlDt.getAsRString("hihoName"),
                    ymlDt.getAsRString("moshitateshaKubun"),
                    ymlDt.getAsRString("style"),
                    ymlDt.getAsRString("moshitateRiyu"),
                    ymlDt.getAsRString("serviceTeikyoYM"),
                    ymlDt.getAsRString("moshitateYMD"),
                    ymlDt.getAsRString("shokisaiHokenshaNo")
            ));
        }

        return arrayData;
    }

    private dgSofuIchiran_Row createRowSearchSofuzumiList(
            RString jigyoshaNo,
            RString jigyoshaName,
            RString hihoNo,
            RString hihoName,
            RString moshitateshaKubun,
            RString style,
            RString moshitateRiyu,
            RString serviceTeikyoYM,
            RString moshitateYMD,
            RString shokisaiHokenshaNo) {

        dgSofuIchiran_Row rowSearchSofuzumiList;
        rowSearchSofuzumiList   = new dgSofuIchiran_Row(
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
                      
         rowSearchSofuzumiList.setTxtJigyoshaNo(jigyoshaNo);
         rowSearchSofuzumiList.setTxtJigyoshaName(jigyoshaName);
         rowSearchSofuzumiList.setTxtHihoNo(hihoNo);
         rowSearchSofuzumiList.setTxtHihoName(hihoName);
         rowSearchSofuzumiList.setTxtMoshitateshaKubun(moshitateshaKubun);
         rowSearchSofuzumiList.setTxtMoshitateRiyu(moshitateRiyu);
         rowSearchSofuzumiList.setTxtStyle(style);
         rowSearchSofuzumiList.setTxtServiceTeikyoYM(serviceTeikyoYM);
         rowSearchSofuzumiList.setTxtMoshitateYMD(moshitateYMD);
         rowSearchSofuzumiList.setTxtShokisaiHokenshaNo(shokisaiHokenshaNo);
          
                      
        return rowSearchSofuzumiList;

    }

    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }

}
