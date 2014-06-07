/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiAll_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n8211
 */
public class FukaRirekiAll {
    
    public ResponseData<FukaRirekiAllDiv> onLoad(FukaRirekiAllDiv fukaRirekiAllDiv) {
        ResponseData<FukaRirekiAllDiv> response = new ResponseData<>();

        lordData(fukaRirekiAllDiv);

        response.data = fukaRirekiAllDiv;
        return response;
    }

    /**
     * 実行メソッド群
     * @param fukaRirekiAllDiv 
     */
    private void lordData(FukaRirekiAllDiv fukaRirekiAllDiv) {
        List fukaRirekiFormatData = new ArrayList();
        RString fukaRirekiFileName = new RString("FukaRirekiAll.yml");
        
        List fukaRirekiData = setYamlData(fukaRirekiFileName);
        
        for (int i = 0; i < fukaRirekiData.size(); i++) {
            fukaRirekiFormatData.add(getFormatData((List)fukaRirekiData.get(i)));
        }
        
        setRirekiAll(fukaRirekiAllDiv, fukaRirekiFormatData);
    }

    /**
     * 全賦課履歴 DataGrid に値をセット
     * @param formatData DataGrid にセットする値List
     */
    private void setRirekiAll(FukaRirekiAllDiv fukaRirekiAllDiv, List formatData) {
        
        List dataGridAll = new ArrayList();
        List dataGrid = new ArrayList();

       
        
        for (int i = 0; i < formatData.size(); i++) {
            dataGrid = (List)formatData.get(i);
            dgFukaRirekiAll_Row dRirekiAll_Row = createRirekiAllRow(fukaRirekiAllDiv, dataGrid);
        
            dataGridAll.add(dRirekiAll_Row);
        }
            
        DataGrid<dgFukaRirekiAll_Row> grid = fukaRirekiAllDiv.getDgFukaRirekiAll();
        grid.setDataSource(dataGridAll);
    }    

    private dgFukaRirekiAll_Row createRirekiAllRow(FukaRirekiAllDiv fukaRirekiAllDiv, List dataGrid) {
       dgFukaRirekiAll_Row dRirekiAll_Row =
                new dgFukaRirekiAll_Row(new Button(), RString.EMPTY, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);
        
        dRirekiAll_Row.setTxtChoteiNendo((RString)dataGrid.get(0));
        dRirekiAll_Row.setTxtFukaNendo((RString)dataGrid.get(1));
        dRirekiAll_Row.setTxtHokenryoDankai(new RString(dataGrid.get(2).toString()));
        dRirekiAll_Row.setTxtHokenryoNengaku(new RString(dataGrid.get(3).toString()));
        
        return dRirekiAll_Row;
    }
    
    /**
     * YamlLoader から データを取り込み、Listに格納
     * @param yamlFileName Yamlファイル名
     * @return YamlデータのList
     */
    private List setYamlData(RString yamlFileName) {

        //Yaml データ読み込み
        List<HashMap> fukaRirekiAll = YamlLoader.FOR_DBB.loadAsList(yamlFileName);

        
        //YamlData用List
        List yamlDatalistAll = new ArrayList();
        List getYamlDatalist = new ArrayList();
        
        for (int i = 1; i <= (int)fukaRirekiAll.get(0).get("データ数"); i++) {
            ControlGenerator cg = new ControlGenerator(fukaRirekiAll.get(i));
            
            getYamlDatalist = getYamaData(cg);

            yamlDatalistAll.add(getYamlDatalist);
        }

        return yamlDatalistAll;
    }

    private List getYamaData(ControlGenerator cg) {
        
        List yamlDatalist = new ArrayList();
        
        yamlDatalist.add(cg.getAsRString("調定年度"));
        yamlDatalist.add(cg.getAsRString("賦課年度"));
        yamlDatalist.add(cg.get("保険料段階"));
        yamlDatalist.add(cg.get("保険料年額"));
        
        return yamlDatalist;
    }

    /**
     * List の 値を確認し、int なら setComma を実行
     * @param listData
     * @return 
     */
    private List getFormatData(List listData) {
        List checkData = new ArrayList();
        List formatData = new ArrayList();        

        for (int i = 0; i < listData.size(); i++) {

            checkData.clear();
            checkData.add(listData.get(i));
            
            boolean intCheck = intChecker(checkData);
            
            if (intCheck == true) {
                formatData.add(setComma((int)listData.get(i)));
            } else {
                formatData.add(listData.get(i));
            }
        }
        
        return formatData;
    }    

    /**
     * int をカンマ付で String に変換
     * @param intData
     * @return 
     */
    private String setComma(int intData) {
        NumberFormat isComma = NumberFormat.getNumberInstance();
   
        String commaData = isComma.format(intData);
        
        return commaData;
    }

    /**
     * int かどうかチェック
     * @param checkData
     * @return 
     */
    private boolean intChecker(List checkData) {
        return checkData.get(0).getClass().getName().equals("java.lang.Integer");
    }
}
