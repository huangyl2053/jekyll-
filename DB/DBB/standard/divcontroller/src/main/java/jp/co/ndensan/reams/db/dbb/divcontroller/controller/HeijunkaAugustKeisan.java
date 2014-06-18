/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001.HeijunkaAugustKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001.dgHeijunka8ShoriKakunin1_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n3336
 */
public class HeijunkaAugustKeisan {

   private static final RString HEIJUNKA_8SHORI_KAKUNIN1 = new RString("dgHeijunka8ShoriKakunin1.yml");    
    
    public ResponseData<HeijunkaAugustKeisanDiv> onLoad_HeijunkaAugustKeisan(HeijunkaAugustKeisanDiv panel) {
        ResponseData<HeijunkaAugustKeisanDiv> response = new ResponseData<>();
        panel.getHeijunka8ShoriNaiyo().getTxtChoteiNendo().setValue(new RString("平26"));
        panel.getHeijunka8ShoriNaiyo().getTxtFukaNendo().setValue(new RString("平26"));
        
        List<dgHeijunka8ShoriKakunin1_Row> arrayData = createKakunin1Data();
        DataGrid<dgHeijunka8ShoriKakunin1_Row> grid = panel.getHeijunka8ShoriKakunin().getDgHeijunka8ShoriKakunin1();
        grid.setDataSource(arrayData);   
        response.data = panel;
        return response;    
    }
    
  private List<dgHeijunka8ShoriKakunin1_Row> createKakunin1Data() {
        List<dgHeijunka8ShoriKakunin1_Row> arrayData = new ArrayList<>();

        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_8SHORI_KAKUNIN1);
        for (HashMap demoData : demoDataList) {
            // コンストラクタにMapを渡して生成。
            ControlGenerator cg = new ControlGenerator(demoData);
            dgHeijunka8ShoriKakunin1_Row row = new dgHeijunka8ShoriKakunin1_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);

            row.setTxtShoriMei(cg.getAsRString("処理名"));
            row.setTxtJokyo(cg.getAsRString("状況"));
            row.setTxtShoriNichiji(cg.getAsRString("処理日時"));

            arrayData.add(row);
        }
        return arrayData;
  }
    
}
