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
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 全賦課履歴Divクラス
 * @author n8211 田辺 紘一
 */
public class FukaRirekiAll {
    private static final RString FUKARIREKIALL = new RString("FukaRirekiAll.yml");

    /**
     * 介護保険料賦課照会の初回ロード時に実行
     * @param div 全賦課履歴Div
     * @return 全賦課履歴Div
     */
    public ResponseData<FukaRirekiAllDiv> onLoad_shokai(FukaRirekiAllDiv div) {
        
        div.setDisplayNone(false);
        
        RString loadShikibetsuCode;
        if (div.getLoadShikibetsuCode().length() < 1) {
            loadShikibetsuCode = new RString("0000000000001901");
        } else {
            loadShikibetsuCode = div.getLoadShikibetsuCode();
        }
        
        lordData(div, loadShikibetsuCode);

        return returnResponse(div);
    }
    
    /**
     * 帳票モード用
     * @param div
     * @return 
     */
    public ResponseData<FukaRirekiAllDiv> onLoad_chohyo(FukaRirekiAllDiv div) {

        div.setDisplayNone(false);
        
        lordData(div, new RString("0000000000001901"));
        
        return returnResponse(div);
    }
    
    /**
     * 世帯員一覧から情報取得しロード（循環参照回避が出来なかった為）
     * @param div
     * @return 
     */
    public ResponseData<FukaRirekiAllDiv> onSelect_dgSetaiShotoku(FukaRirekiAllDiv div) {

        div.setDisplayNone(false);

        lordData(div, new RString("0000000000002701"));
        
        return returnResponse(div);
    }
    
    /**
     * レスポンスデータのリターン
     * @param div
     * @return 
     */
    private ResponseData<FukaRirekiAllDiv> returnResponse(FukaRirekiAllDiv div) {
        ResponseData<FukaRirekiAllDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 初回ロード
     * @param fukaRirekiAllDiv 
     */
    private void lordData(FukaRirekiAllDiv div, RString tsuchishoNo) {
        
        loadAtena();
        
        loadFukaKihon();
                
        loadFukarireki(div, tsuchishoNo);

    }
    
    private void loadFukarireki(FukaRirekiAllDiv div, RString tsuchishoNo) {
               List formatList = new ArrayList();
        
        List yamlList = getYamlList(tsuchishoNo);
        
        for (int i = 0; i < yamlList.size(); i++) {
            formatList.add(getFormatData((List)yamlList.get(i)));
        }
        
        setRirekiAll(div, formatList); 
    }
    
    private void loadAtena() {
        
    }

    private void loadFukaKihon() {
        
    }

    /**
     * 全賦課履歴DataGrid に値をセット
     * @param formatData DataGrid にセットする値List
     */
    private void setRirekiAll(FukaRirekiAllDiv div, List formatData) {
        
        List dataGridList = new ArrayList();
       
        for (int i = 0; i < formatData.size(); i++) {
            List dataGridValue = (List)formatData.get(i);
            dgFukaRirekiAll_Row row = createRowRirekiAll(dataGridValue);
        
            dataGridList.add(row);
        }
            
        DataGrid<dgFukaRirekiAll_Row> grid = div.getDgFukaRirekiAll();
        grid.setDataSource(dataGridList);
    }    

    /**
     * DataGrid の 行を生成
     * @param rowValue 行に代入するデータ
     * @return 行データ
     */
    private dgFukaRirekiAll_Row createRowRirekiAll(List rowValue) {
       dgFukaRirekiAll_Row row =
                new dgFukaRirekiAll_Row(RString.EMPTY, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY);
                        
        row.setTxtChoteiNendo((RString)rowValue.get(0));
        row.setTxtFukaNendo((RString)rowValue.get(1));
        row.setTxtHokenryoDankai((RString)rowValue.get(2));
        row.setTxtHokenryoNengaku((RString)rowValue.get(3));
        row.setTxtTsuchishoNo((RString)rowValue.get(4));
        
        return row;
    }
    



    /**
     * List の 値を確認し、必要なフォーマットを実行
     * @param listData 対象List
     * @return フォーマット完了List
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
     * int かどうかチェック
     * @param checkData 対象データ
     * @return true or false
     */
    private boolean intChecker(List checkData) {
        return checkData.get(0).getClass().getName().equals("java.lang.Integer");
    }

    /**
     * int をカンマ付(3桁毎)で RString に変換
     * @param intValue 対象値
     * @return 変換完了値
     */
    private RString setComma(int intValue) {
        RString commaData = new RString(NumberFormat.getNumberInstance().format(intValue));
        
        return commaData;
    }

    /**
     * YamlLoader から データを取り込み、Listに格納
     * @param yamlFileName Yamlファイル名
     * @return YamlデータのList
     */
    private List getYamlList(RString tsuchishoNo) {

        //Yaml データ読み込み
        List<HashMap> yamlArray = YamlLoader.DBB.loadAsList(FUKARIREKIALL);
        
        //YamlData用List
        List yamlList = new ArrayList();
        
        for (int i = 0; i < yamlArray.size(); i++) {
            ControlGenerator cg = new ControlGenerator(yamlArray.get(i));
            
            if (tsuchishoNo.contains(cg.getAsRString("通知書番号"))) {
                List yamlValue = getYamlGenerate(cg);

                yamlList.add(yamlValue);
            }
        }

        return yamlList;
    }

    /**
     * Yaml を List化
     * @param cg 生成後のYamlデータ
     * @return List化したYamlデータ
     */
    private List getYamlGenerate(ControlGenerator cg) {
        
        List yamlValue = new ArrayList();
        
        yamlValue.add(cg.getAsRString("調定年度"));
        yamlValue.add(cg.getAsRString("賦課年度"));
        yamlValue.add(cg.getAsRString("保険料段階"));
        yamlValue.add(cg.get("保険料年額"));
        yamlValue.add(cg.getAsRString("通知書番号"));
        
        return yamlValue;
    }
}
