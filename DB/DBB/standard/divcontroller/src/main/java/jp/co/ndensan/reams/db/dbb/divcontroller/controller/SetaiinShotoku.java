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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.SetaiinShotokuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8211
 */
public class SetaiinShotoku {
    private static final RString SETAISHOTOKU = new RString("SetaiShotoku.yml");
    private static final RString OTHER = new RString("other.yml");    
    
    public ResponseData<SetaiinShotokuDiv> onClick_btnSetaiinnShotoku(SetaiinShotokuDiv div, FukaRirekiDiv rirekiDiv) {

        div.setDisplayNone(false);
        
        loadSetaiinShotoku(div, rirekiDiv, new RString("onClick"));
        
        return returnResponse(div);
    }
    
    
    public ResponseData<SetaiinShotokuDiv> onChange_chkSetaiIchiranAll(SetaiinShotokuDiv div, FukaRirekiDiv rirekiDiv) {
        
        div.setDisplayNone(false);
        
        RString mode = setProperty_SetaiinShotku(div);
        loadSetaiinShotoku(div, rirekiDiv, mode);

        return returnResponse(div);
    }
    

    /**
     * 比較画面にデータを渡す
     * @param div
     * @param fukaRirekiDiv
     * @return 
     */
    public ResponseData<SetaiinShotokuDiv>  onClick_DisplayedAligned(SetaiinShotokuDiv div, FukaRirekiDiv fukaRirekiDiv) {
        //ViewStateに格納
        ViewStateHolder.put("世帯所得", div);
        ViewStateHolder.put("mode", new RString("displayedAligned"));
        
        return  returnResponse(div);
    }
    
    /**
     * 比較画面にデータを渡す
     * @param div
     * @param fukaRirekiDiv
     * @return 
     */
    public ResponseData<SetaiinShotokuDiv>  onClick_ComparedWithPrevious(SetaiinShotokuDiv div, FukaRirekiDiv fukaRirekiDiv) {
        //ViewStateに格納
        ViewStateHolder.put("賦課履歴", fukaRirekiDiv);
        ViewStateHolder.put("mode", new RString("comparedWithPrevious"));
        
        return  returnResponse(div);
    }    
    
    
//    public ResponseData<SetaiinShotokuDiv> onSelect_dgSetaiShotoku(SetaiinShotokuDiv div, FukaRirekiDiv rirekiDiv) {
//        
//        List<dgSetaiShotoku_Row> selected = div.getSetaiShotokuIchiran().getDgSetaiShotoku().getSelectedItems();
//
//        rirekiAllDiv.setLoadShikibetsuCode(selected.get(0).getTxtShikibetsuCode());
//
//        return returnResponse(div);
//    } 
    
    /**
     * イベント処理後のレスポンスデータをリターン
     * @param div
     * @return 
     */
    private ResponseData<SetaiinShotokuDiv> returnResponse(SetaiinShotokuDiv div) {
        ResponseData<SetaiinShotokuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }    
        
    
   /**
     * 履歴一覧から選択行の情報取得
     * @param fukaRirekiDiv
     * @param mode
     * @return 
     */
    private List getRirekiKey(FukaRirekiDiv fukaRirekiDiv, String mode) {
        
        List keyList = new ArrayList();

        switch (mode) {
            case "select":
                // 選択行の情報を取得
                List<dgFukaRirekiFukaRireki_Row> selectedItem = fukaRirekiDiv.getDgFukaRirekiFukaRireki().getSelectedItems();
                for (dgFukaRirekiFukaRireki_Row selectData : selectedItem) {
                    keyList.add(selectData.getTxtTsuchishoNo());
                    keyList.add(selectData.getTxtChoteiNendo());
                    keyList.add(selectData.getTxtKoseiM());
                    keyList.add(selectData.getTxtKoseiYMD());
                }
                
                break;
            case "click":
                dgFukaRirekiFukaRireki_Row clickedItem = fukaRirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem();
                keyList.add(clickedItem.getTxtTokubetsuChoshu());
                keyList.add(clickedItem.getTxtChoteiNendo());
                keyList.add(clickedItem.getTxtKoseiM());
                keyList.add(clickedItem.getTxtKoseiYMD());

                break;
        }
        
        return keyList;
    }    
 
    /**
     * 最新世帯表示のチェックボックスを判断し、一部列の表示、非表示の切り替え
     * @param div 
     */
    private RString setProperty_SetaiinShotku(SetaiinShotokuDiv div) {
        
        SetaiShotokuIchiranDiv shotokuIchiranDiv = div.getSetaiShotokuIchiran();
        DataGridSetting gridSetting = shotokuIchiranDiv.getDgSetaiShotoku().getGridSetting();
        List<KeyValueDataSource> selectItem = shotokuIchiranDiv.getChkSetaiIchiranAll().getSelectedItems();
        
        RString mode;
        
        //チェックによりOnOff
        if (selectItem.size() >= 1) {            
            gridSetting.getColumn("txtSonzaiUmuChokkin").setVisible(true);
            gridSetting.getColumn("txtSonzaiUmuKijunbi").setVisible(true);
            mode = new RString("onChange");  
        } else {
            gridSetting.getColumn("txtSonzaiUmuChokkin").setVisible(false);
            gridSetting.getColumn("txtSonzaiUmuKijunbi").setVisible(false);
            mode = new RString("onClick");
        }
               
        return mode;
    }
    
    /**
     * 世帯所得Divのロード
     * @param  
     */
    private void loadSetaiinShotoku(SetaiinShotokuDiv div, FukaRirekiDiv rirekiDiv, RString mode) {
        List formatData = new ArrayList();
        
        RString key = null;
        
        if (mode.contains("onClick")) {
            key = new RString("基準日");
        } else if (mode.contains("onChange")) {
            key = new RString("直近");
        }
        
        List shotokuList = getYamlSetaiShotoku(key);
        
        for (int i = 0; i < shotokuList.size(); i++) {
            formatData.add(getFormatData((List)shotokuList.get(i)));
        }

        List<HashMap> other = YamlLoader.DBB.loadAsList(OTHER);
        ControlGenerator cg = new ControlGenerator(other.get(0));
        
        div.getSetaiShotokuIchiran().getTxtSetaiIchiranKijunYMD().setValue(cg.getAsRDate("基準日"));
        div.getSetaiShotokuIchiran().getTxtSetaiIchiranKazeiNendo().setValue(new RString((String)other.get(0).get("賦課年度")));
        
        List keyShotoku = getRirekiKey(rirekiDiv, "select");
        
        setSetaiShotoku(div, formatData, (RString)keyShotoku.get(0));
    }

    /**
     * 世帯所得一覧のグリッドをセット
     * @param div
     * @param formatData 
     */
    private void setSetaiShotoku(SetaiinShotokuDiv div, List formatData, RString selectShokai) {

        List dataGridAll = new ArrayList(formatData.size());
        int addNo = 1;
        
        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List)formatData.get(i);
            
            dgSetaiShotoku_Row row = createRowSetaiShotoku(dataGrid);
            
            if (selectShokai.contains((RString)dataGrid.get(0))) {
                dataGridAll.add(0, row);
            } else {
                dataGridAll.add(addNo, row);
                addNo++;
            }
        }
            
        DataGrid<dgSetaiShotoku_Row> ssid = div.getSetaiShotokuIchiran().getDgSetaiShotoku();
        ssid.setDataSource(dataGridAll);
    }

    /**
     * 世帯所得一覧のDataGridの行にデータを代入
     * @param dataGrid
     * @return 
     */
    private dgSetaiShotoku_Row createRowSetaiShotoku(List dataGrid) {
        dgSetaiShotoku_Row row = new dgSetaiShotoku_Row(
                new Button(), RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY
                , new Button(), RString.FULL_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY
                , RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY
                , RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY
                , RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        
        StringBuilder buf = new StringBuilder();
        
        row.setTxtShikibetsuCode((RString)dataGrid.get(0));
        buf.append(dataGrid.get(0).toString());
        buf.append("<br>");
        buf.append(dataGrid.get(1).toString());
        row.setTxtKetsugo01(new RString(buf.toString()));
        row.setTxtShimei((RString)dataGrid.get(3));
        
        row.setTxtSonzaiUmuKijunbi((RString) dataGrid.get(7));
        row.setTxtSonzaiUmuChokkin((RString) dataGrid.get(8));
        
        buf.delete(0, buf.length());
        buf.append((RString)dataGrid.get(4));
        buf.append((RString)dataGrid.get(5));
        buf.append("<br>");
        buf.append((RString)dataGrid.get(6));
        row.setTxtKetsugo02(new RString(buf.toString()));
        
        buf.delete(0, buf.length());
        row.setTxtShubetsu((RString)dataGrid.get(9));
        row.setTxtIdoYMD((RString)dataGrid.get(10));
        row.setTxtHaaku((RString)dataGrid.get(11));
        row.setTxtJuminzei((RString)dataGrid.get(12));
        
        buf.append((RString)dataGrid.get(13));
        buf.append("<br>");
        buf.append((RString)dataGrid.get(14));
        row.setTxtKetsugo03(new RString(buf.toString()));
        
        row.setTxtJukiIdoJiyu((RString)dataGrid.get(15));
        row.setTxtJuteiYMD((RString)dataGrid.get(16));
        row.setTxtJukiIdoJiyu((RString)dataGrid.get(17));
        
        return row;
    }
    
    /**
     * 世帯所得一覧のYamlを取得
     * @param yamlFileName
     * @return 
     */
    private List getYamlSetaiShotoku(RString key) {

        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBB.loadAsList(SETAISHOTOKU);
       
        //YamlData用List
        List yamlDatalistAll = new ArrayList();
        
        for (int i = 0; i < (int)fukaKonkyo.size(); i++) {

            ControlGenerator cg = new ControlGenerator(fukaKonkyo.get(i));
                
            if (cg.getAsRString(key.toString()).contains("○")) {
                List getYamlDatalist = getYamlListSetaiShotoku(cg);

                yamlDatalistAll.add(getYamlDatalist);
            }
        }

        return yamlDatalistAll;
    }
    /**
     * 世帯所得一覧のYamlをList化
     * @param cg
     * @return 
     */
    private List getYamlListSetaiShotoku(ControlGenerator cg) {
        
        List yamlDatalist = new ArrayList();
        
        yamlDatalist.add(cg.getAsRString("識別コード"));
        yamlDatalist.add(cg.getAsRString("被保番号"));
        yamlDatalist.add(cg.getAsRString("カナ氏名"));
        yamlDatalist.add(cg.getAsRString("氏名"));
        yamlDatalist.add(cg.getAsRString("生年月日"));
        yamlDatalist.add(cg.getAsRString("性別"));
        yamlDatalist.add(cg.getAsRString("続柄"));
        yamlDatalist.add(cg.getAsRString("基準日"));
        yamlDatalist.add(cg.getAsRString("直近"));
        yamlDatalist.add(cg.getAsRString("種別"));
        yamlDatalist.add(cg.getAsRString("異動日"));
        yamlDatalist.add(cg.getAsRString("把握"));
        yamlDatalist.add(cg.getAsRString("住民税"));
        yamlDatalist.add(cg.get("合計所得金額"));
        yamlDatalist.add(cg.get("年金収入額"));
        yamlDatalist.add(cg.getAsRString("異動日"));
        yamlDatalist.add(cg.getAsRString("住定日"));
        yamlDatalist.add(cg.getAsRString("異動事由"));
        
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
            
            if (checkData.get(0) == null) {
                formatData.add("");
            } else {
                boolean intCheck = intChecker(checkData);

                if (intCheck == true) {
                    formatData.add(setComma((int)listData.get(i)));
                } else {
                    formatData.add(listData.get(i));
                }
            }
        }
        
        return formatData;
    }

    /**
     * int をカンマ付で String に変換
     * @param intData
     * @return 
     */
    private RString setComma(int intData) {
        NumberFormat isComma = NumberFormat.getNumberInstance();
   
        RString commaData = new RString(isComma.format(intData));
        
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