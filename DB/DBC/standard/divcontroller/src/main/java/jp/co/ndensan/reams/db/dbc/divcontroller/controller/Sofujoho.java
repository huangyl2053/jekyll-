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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

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

    private void setfuYminfo(SofujohoDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0070011/SofujohoSofuzumi.yml");
        
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);
       
        panel.getTxtSofuYM().setValue(ymlDt.getAsRDate("sofuYM"));
   
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

        setfuYminfo(panel);
        //送付済情報を表示
        setSearchSofuzumiList(panel);

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

//            //2014.6.14 タイプ変更：日付以外は、RStringに変更 
//            RString jigyoshaNo = ymlDt.getAsRString("jigyoshaNo");
//            RString jigyoshaName = ymlDt.getAsRString("jigyoshaName");
//            RString hihoNo = ymlDt.getAsRString("hihoNo");
//            RString hihoName = ymlDt.getAsRString("hihoName");
//            RString moshitateshaKubun = ymlDt.getAsRString("moshitateshaKubun");
//            RString style = ymlDt.getAsRString("style");
//            RString moshitateRiyu = ymlDt.getAsRString("moshitateRiyu");
//            RString serviceTeikyoYM = ymlDt.getAsRString("serviceTeikyoYM");
//            RString moshitateYMD = ymlDt.getAsRString("moshitateYMD");
//            RString shokisaiHokenshaNo = ymlDt.getAsRString("shokisaiHokenshaNo");

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
