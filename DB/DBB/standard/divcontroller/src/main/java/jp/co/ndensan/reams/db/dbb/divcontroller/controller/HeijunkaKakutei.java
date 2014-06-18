/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130002.HeijunkaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgHeijunkaKakutei_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author n3336
 */
public class HeijunkaKakutei {

   private static final RString HEIJUNKA_KAKITEI_1000 = new RString("dgHeijunkaKakutei1000.yml");        
   private static final RString HEIJUNKA_KAKITEI_1000_UNDER = new RString("dgHeijunkaKakutei1000under.yml");        
   private static final RString HEIJUNKA_KAKITEI_1000_OVER = new RString("dgHeijunkaKakutei1000over.yml");        
   private static final Decimal SAGAKU_1000 = new Decimal("1000");        
   

    public ResponseData<HeijunkaKakuteiDiv> onLoad_HeijunkaKakutei(HeijunkaKakuteiDiv panel) {
        ResponseData<HeijunkaKakuteiDiv> response = new ResponseData<>(); 
        response.data = panel;
        return response;    
    }   
   
    public ResponseData<HeijunkaKakuteiDiv> onClick_btnSagakuSettei(HeijunkaKakuteiDiv panel) {
        ResponseData<HeijunkaKakuteiDiv> response = new ResponseData<>();
        TextBoxNum sagaku = panel.getHeijunkaSagakuKakunin().getTxtSagaku();
        
        List<dgHeijunkaKakutei_Row> arrayData = createSagakuData( sagaku );
        DataGrid<dgHeijunkaKakutei_Row> grid = panel.getHeijunkaSagakuKakunin().getDgHeijunkaKakutei();
        grid.setDataSource(arrayData);   
        response.data = panel;
        return response;    
    }
    
  private List<dgHeijunkaKakutei_Row> createSagakuData(TextBoxNum sagaku) {
        List<dgHeijunkaKakutei_Row> arrayData = new ArrayList<>();
        List<HashMap> demoDataList;            

        
        if( sagaku.getValue().equals(SAGAKU_1000) ){
            demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_KAKITEI_1000);
        }
        else if( sagaku.getValue().compareTo(SAGAKU_1000) < 0){
            demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_KAKITEI_1000_UNDER);           
        }
        else if( sagaku.getValue().compareTo(SAGAKU_1000) > 0){
             demoDataList = YamlLoader.DBB.loadAsList(HEIJUNKA_KAKITEI_1000_OVER);                      
        }
        else{
              demoDataList = null;                                 
        }
        for (HashMap demoData : demoDataList) {
            // コンストラクタにMapを渡して生成。
            ControlGenerator cg = new ControlGenerator(demoData);
            dgHeijunkaKakutei_Row row = new dgHeijunkaKakutei_Row(RString.EMPTY, sagaku, RString.EMPTY , RString.EMPTY, RString.EMPTY);

            row.setTxtHokenryoDankai(cg.getAsRString("保険料段階"));
            row.setTxtSagaku(sagaku);
            row.setTxtHeijunkaKensu(cg.getAsRString("平準化対象件数"));
            row.setTxtKakuteiKensu(cg.getAsRString("確定対象件数"));
            row.setTxtTaishogaiKensu(cg.getAsRString("差額設定による対象外件数"));

            arrayData.add(row);
        }
        return arrayData;
  }    
    
}
