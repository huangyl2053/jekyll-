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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaShokaiGrandsonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoAndKiwariDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.TokuchoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgTokuChoIdoAndIrai_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgTokuchoKekka_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8211
 */
public class FukaShokaiGrandson {
    public static final RString FUKAKONKYO = new RString("FukaKonkyo.yml");
    public static final RString SETAISHOTOKU = new RString("SetaiShotoku.yml");
    public static final RString TOKUCHO = new RString("Tokucho.yml");
    public static final RString IDOANDIRAI = new RString("IdoAndIrai.yml");
    public static final RString TOKUCHORESULT = new RString("TokuchoResult.yml");
    public static final RString OTHER = new RString("other.yml");
    
    public ResponseData<FukaShokaiGrandsonDiv> onSelect(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {
        
        div.setCanOpenAndClose(true);
        div.setIsOpen(true);
        
        div.getFukakonkyoAndKiwari().setDisplayNone(false);
        div.getSetaiinShotoku().setDisplayNone(true);
        div.getTokucho().setDisplayNone(true);
        div.getInjiNaiyoSettei().setDisplayNone(true);            
                
        loadFukaKonkyoAndKiwarigaku(div, rirekiDiv, "select");

        return returnResponse(div);
    }

    public ResponseData<FukaShokaiGrandsonDiv> onClick(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {
        div.setCanOpenAndClose(true);
        div.setIsOpen(true);
        
        div.getFukakonkyoAndKiwari().setDisplayNone(false);
        div.getSetaiinShotoku().setDisplayNone(true);
        div.getTokucho().setDisplayNone(true);
        div.getInjiNaiyoSettei().setDisplayNone(true);    

        loadFukaKonkyoAndKiwarigaku(div, rirekiDiv, "click");

        return returnResponse(div);
    }    
  
    public ResponseData<FukaShokaiGrandsonDiv> onClick_btnFukakonkyoKiwari(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {

        div.getFukakonkyoAndKiwari().setDisplayNone(false);
        div.getSetaiinShotoku().setDisplayNone(true);
        div.getTokucho().setDisplayNone(true);
        div.getInjiNaiyoSettei().setDisplayNone(true);       
        
//        loadFukaKonkyoAndKiwarigaku(fukaShokaiGrandsonDiv, rirekiDiv, "Click");
        
        return returnResponse(div);
    }    

    public ResponseData<FukaShokaiGrandsonDiv> onClick_btnSetaiinnShotoku(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {

        div.getFukakonkyoAndKiwari().setDisplayNone(true);
        div.getSetaiinShotoku().setDisplayNone(false);
        div.getTokucho().setDisplayNone(true);
        div.getInjiNaiyoSettei().setDisplayNone(true);
        
        setProperty_SetaiinShotku(div);
        loadSetaiinShotoku(div, rirekiDiv, new RString("onClick"));
        
        return returnResponse(div);
    }    
    
    public ResponseData<FukaShokaiGrandsonDiv> onClick_btnTokucho(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {

        div.getFukakonkyoAndKiwari().setDisplayNone(true);
        div.getSetaiinShotoku().setDisplayNone(true);
        div.getTokucho().setDisplayNone(false);
        div.getInjiNaiyoSettei().setDisplayNone(true);
        
        loadTokucho(div, rirekiDiv);

        return returnResponse(div);
    }
    
    public ResponseData<FukaShokaiGrandsonDiv> onClick_btnInjiNaiyoSettei(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, FukaRirekiDiv fukaRirekiDiv) {

        fukaShokaiGrandsonDiv.getFukakonkyoAndKiwari().setDisplayNone(true);
        fukaShokaiGrandsonDiv.getSetaiinShotoku().setDisplayNone(true);
        fukaShokaiGrandsonDiv.getTokucho().setDisplayNone(true);
        fukaShokaiGrandsonDiv.getInjiNaiyoSettei().setDisplayNone(false);

        return returnResponse(fukaShokaiGrandsonDiv);
    }
    
    public ResponseData<FukaShokaiGrandsonDiv> onChange_chkSetaiIchiranAll(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, FukaRirekiDiv fukaRirekiDiv) {
        
        setProperty_SetaiinShotku(fukaShokaiGrandsonDiv);
         loadSetaiinShotoku(fukaShokaiGrandsonDiv, fukaRirekiDiv, new RString("onChange"));

        return returnResponse(fukaShokaiGrandsonDiv);
    }
    

    /**
     * 比較画面にデータを渡す
     * @param div
     * @param fukaRirekiDiv
     * @return 
     */
    public ResponseData<FukaShokaiGrandsonDiv>  onClick_DisplayedAligned(FukaShokaiGrandsonDiv div, FukaRirekiDiv fukaRirekiDiv) {
        //ViewStateに格納
        ViewStateHolder.put("賦課照会", div);
        ViewStateHolder.put("賦課履歴", fukaRirekiDiv);
        
        return  returnResponse(div);
    }
    
    /**
     * レスポンスデータのリターン
     * @param div
     * @return 
     */
    private ResponseData<FukaShokaiGrandsonDiv> returnResponse(FukaShokaiGrandsonDiv div) {
        ResponseData<FukaShokaiGrandsonDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
    
    /**
     * 賦課根拠・期割額Div のロード
     * @param  
     */
    private void loadFukaKonkyoAndKiwarigaku(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv, String mode) {
        List formatData = new ArrayList();
        
        List key = getRirekiKey(rirekiDiv, mode);

        List fukaKonkyoData = getYamlFukaKonkyo(key);
        
        for (int i = 0; i < fukaKonkyoData.size(); i++) {
            formatData.add(getFormatData((List)fukaKonkyoData.get(i)));
        }
        
        div.getTxtChoteiNendo().setValue((RString)key.get(1));
        div.getTxtKoseiM().setValue((RString)key.get(2));
        div.getTxtKoseiYMD().setValue((RString)key.get(3));
        
//        setFukaKonkyo(fukaShokaiGrandsonDiv, formatData);
    }

    /**
     * 世帯所得Divのロード
     * @param  
     */
    private void loadSetaiinShotoku(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv, RString mode) {
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
        div.getSetaiinShotoku().getSetaiShotokuIchiran().getTxtSetaiIchiranKijunYMD().setValue(new RDate((String)other.get(0).get("基準日")));
        div.getSetaiinShotoku().getSetaiShotokuIchiran().getTxtSetaiIchiranKazeiNendo().setValue(new RString((String)other.get(0).get("賦課年度")));
        
        List keyShotoku = getRirekiKey(rirekiDiv, "select");
        
        setSetaiShotoku(div, formatData, (RString)keyShotoku.get(0));
    }
    
    /**
     * 特別徴収情報Divのロード
     * @param div 
     */
    private void loadTokucho(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {
        List formatData = new ArrayList();

        RString key = div.getTokucho().getRadChoshu().getSelectedValue();
        
        if (key.length() <= 0) {
            
            List<dgFukaRirekiFukaRireki_Row> selectedItem = rirekiDiv.getDgFukaRirekiFukaRireki().getSelectedItems();
            RString selectedHokenryoDankai = selectedItem.get(0).getTxtHokenryoDankai();
            if (selectedHokenryoDankai.length() > 0) {
                key = new RString("本");
            } else {
                key = new RString("仮");
            }
        }
        
        List fukaTokuchoValue = getYamlTokucho(key);
        
        for (int i = 0; i < fukaTokuchoValue.size(); i++) {
            formatData.add(getFormatData((List)fukaTokuchoValue.get(i)));
        }
        
        setTokucho(div, (List)formatData.get(0));
        loadIdoAndIrai(div, key);
        loadTokuchoResult(div, key);
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

    /**
     * 最新世帯表示のチェックボックスを判断し、一部列の表示、非表示の切り替え
     * @param div 
     */
    private void setProperty_SetaiinShotku(FukaShokaiGrandsonDiv div) {
        
        SetaiShotokuIchiranDiv shotokuIchiranDiv = div.getSetaiinShotoku().getSetaiShotokuIchiran();
        DataGridSetting gridSetting = shotokuIchiranDiv.getDgSetaiShotoku().getGridSetting();
        List<KeyValueDataSource> selectItem = shotokuIchiranDiv.getChkSetaiIchiranAll().getSelectedItems();
        
        //チェックによりOnOff
        if (selectItem.size() >= 1) {            
            gridSetting.getColumn("txtSonzaiUmuChokkin").setVisible(true);
            gridSetting.getColumn("txtSonzaiUmuKijunbi").setVisible(true);
        } else {
            gridSetting.getColumn("txtSonzaiUmuChokkin").setVisible(false);
            gridSetting.getColumn("txtSonzaiUmuKijunbi").setVisible(false);
        }
    }
    
    /**
     * 賦課根拠テーブルの値をセット
     * @param fukakonkyoAndKiwari
     * @param formatData 
     * 0>賦課基準日 1>本人課税 2>世帯課税 3>合計所得 4>年金収入額 5>保険料段階_前年
     * 6>保険料率_前年 7>年額保険料_前年 8>計算上年間保険料額 9>減免額 10>確定年間保険料額
     * 11>期間 12>月数 13>保険料段階区分 14>保険料率 15>保険料算出額　16>保険料額 17>調定事由
     */
    private void setFukakonkyoAndKiwari(FukakonkyoAndKiwariDiv fukakonkyoAndKiwari, List formatData) {
        tblFukaKonkyoDiv tFukaKonkyoDiv = fukakonkyoAndKiwari.getTblFukaKonkyo();
        
        if (formatData.get(1) == null) {
            // 仮算定時　非表示
            tFukaKonkyoDiv.getTxtHonninKazei().setDisplayNone(true);
            tFukaKonkyoDiv.getTxtSetaiKazei().setDisplayNone(true);
            tFukaKonkyoDiv.getTxtShotokuSum().setDisplayNone(true);
            tFukaKonkyoDiv.getTxtNenkinShunyu().setDisplayNone(true);
            tFukaKonkyoDiv.getTxtKeisanjoNenkanHokenryo().setDisplayNone(true);
            tFukaKonkyoDiv.getTblKikan().setVisible(true);

            // ラベル変更
            tFukaKonkyoDiv.getTxtNenkanHokenryo().setLabelLText(new RString("暫定保険料額合計"));

            // 仮算定時　表示
            tFukaKonkyoDiv.getLblZennendo().setDisplayNone(false);
            tFukaKonkyoDiv.getTxtHokenryoDankai().setDisplayNone(false);
            tFukaKonkyoDiv.getTxtHokenryoritsu().setDisplayNone(false);
            tFukaKonkyoDiv.getTxtNengakuHokenryo().setDisplayNone(false);

            tFukaKonkyoDiv.getTxtHokenryoDankai().setValue((RString) formatData.get(5));
            tFukaKonkyoDiv.getTxtHokenryoritsu().setValue(new Decimal((String) formatData.get(6)));
            tFukaKonkyoDiv.getTxtNengakuHokenryo().setValue(new Decimal((String) formatData.get(7)));

            tFukaKonkyoDiv.getTxtGemmen().setValue(new Decimal((String) formatData.get(9)));
            tFukaKonkyoDiv.getTxtNenkanHokenryo().setValue(new Decimal((String) formatData.get(10)));

        } else {
                // 本算定時　表示
                tFukaKonkyoDiv.getTxtHonninKazei().setDisplayNone(false);
                tFukaKonkyoDiv.getTxtSetaiKazei().setDisplayNone(false);
                tFukaKonkyoDiv.getTxtShotokuSum().setDisplayNone(false);
                tFukaKonkyoDiv.getTxtNenkinShunyu().setDisplayNone(false);
                tFukaKonkyoDiv.getTxtKeisanjoNenkanHokenryo().setDisplayNone(false);

                // ラベル変更
                tFukaKonkyoDiv.getTxtNenkanHokenryo().setLabelLText(new RString("確定年間保険料額"));

                // 本算定時　非表示
                tFukaKonkyoDiv.getLblZennendo().setDisplayNone(true);
                tFukaKonkyoDiv.getTxtHokenryoDankai().setDisplayNone(true);
                tFukaKonkyoDiv.getTxtHokenryoritsu().setDisplayNone(true);
                tFukaKonkyoDiv.getTxtNengakuHokenryo().setDisplayNone(true);

                tFukaKonkyoDiv.getTxtHonninKazei().setValue(new RString((String) formatData.get(1)));
                tFukaKonkyoDiv.getTxtSetaiKazei().setValue(new RString((String) formatData.get(2)));
                tFukaKonkyoDiv.getTxtShotokuSum().setValue(new Decimal((String) formatData.get(3)));
                tFukaKonkyoDiv.getTxtNenkinShunyu().setValue(new Decimal((String) formatData.get(4)));

                tFukaKonkyoDiv.getTxtKeisanjoNenkanHokenryo().setValue(new Decimal((String) formatData.get(8)));
                tFukaKonkyoDiv.getTxtGemmen().setValue(new Decimal((String) formatData.get(9)));
                tFukaKonkyoDiv.getTxtNenkanHokenryo().setValue(new Decimal((String) formatData.get(10)));

                tFukaKonkyoDiv.getTblKikan().getLblKikan1().setText((RString)formatData.get(11));
                tFukaKonkyoDiv.getTblKikan().getLblTsukiSu1().setText((RString)formatData.get(12));
                tFukaKonkyoDiv.getTblKikan().getLblShotokuDankai1().setText((RString)formatData.get(13));
                tFukaKonkyoDiv.getTblKikan().getLblHokenryoritsu1().setText(new RString((String) formatData.get(14)));
                tFukaKonkyoDiv.getTblKikan().getLblHokenryoSansyutsu1().setText(new RString((String) formatData.get(15)));
                tFukaKonkyoDiv.getTblKikan().getLblHokenryo1().setText(new RString((String) formatData.get(16)));
        }

    }
    
    /**
     * 世帯所得一覧のグリッドをセット
     * @param div
     * @param formatData 
     */
    private void setSetaiShotoku(FukaShokaiGrandsonDiv div, List formatData, RString selectShokai) {

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
            
        DataGrid<dgSetaiShotoku_Row> ssid = div.getSetaiinShotoku().getSetaiShotokuIchiran().getDgSetaiShotoku();
        ssid.setDataSource(dataGridAll);
    }

    /**
     * 世帯所得一覧のDataGridの行にデータを代入
     * @param dataGrid
     * @return 
     */
    private dgSetaiShotoku_Row createRowSetaiShotoku(List dataGrid) {
        dgSetaiShotoku_Row row = new dgSetaiShotoku_Row(new Button()
                , RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY
                , new Button(), RString.FULL_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY
                , RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY
                , RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY
                , RString.EMPTY, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        
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
     * 特別徴収を値をセット
     * @param fukaShokaiGrandsonDiv
     * @param formatData 
     */
    private void setTokucho(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, List formatData) {
        TokuchoDiv td = fukaShokaiGrandsonDiv.getTokucho();

        td.getTxtFukaNendo1().setValue((RString)formatData.get(1));
        td.getTxtKisoNenkinNo2().setValue((RString)formatData.get(2));
        td.getTxtNenkinCode2().setValue((RString)formatData.get(3));
        td.getTxtHosokuYM().setValue((RString)formatData.get(4));
        td.getTxtKaishiTsuki().setValue((RString)formatData.get(5));
        td.getTxtTokubetsuChoshuTaishoNenkin().setValue((RString)formatData.get(6));
        td.getTxtTokuChoGimusha().setValue((RString)formatData.get(7));
    }

    /**
     * 特徴内の異動・依頼DataGridをロード
     * @param fukaShokaiGrandsonDiv
     * @param key 
     */
    private void loadIdoAndIrai(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, RString key) {
        List formatData = new ArrayList();

        List idoAndIraiValue = getYamlIdoAndIrai(key);
        
        for (int i = 0; i < idoAndIraiValue.size(); i++) {
            formatData.add(getFormatData((List)idoAndIraiValue.get(i)));
        }
        
        setDataGridTokuchoIdoAndIrai(fukaShokaiGrandsonDiv, formatData);
    }
        
    /**
     * 異動・依頼DataGridに値をセット
     * @param fukaShokaiGrandsonDiv
     * @param formatData 
     */
    private void setDataGridTokuchoIdoAndIrai(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, List formatData) {
        List dataGridAll = new ArrayList();
        
        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List)formatData.get(i);
            dgTokuChoIdoAndIrai_Row row = createRowTokuchoIdoAndIrai(fukaShokaiGrandsonDiv, dataGrid);
        
            dataGridAll.add(row);
        }
            
        DataGrid<dgTokuChoIdoAndIrai_Row> grid = fukaShokaiGrandsonDiv.getTokucho().getTokuChoIdoAndIrai().getDgTokuChoIdoAndIrai();
        grid.setDataSource(dataGridAll);
    }

    /**
     * 異動・依頼DataGridの行を生成
     * @param fukaShokaiGrandsonDiv
     * @param dataGrid
     * @return 
     */
    private dgTokuChoIdoAndIrai_Row createRowTokuchoIdoAndIrai(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, List dataGrid) {
        dgTokuChoIdoAndIrai_Row row = 
                new dgTokuChoIdoAndIrai_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        
        row.setTxtSofuYM((RString)dataGrid.get(1));
        row.setTxtTsuchiNaiyo((RString)dataGrid.get(2));
        row.setTxtKakushuKbn((RString)dataGrid.get(3));
        row.setTxtKakushuKingaku1((RString)dataGrid.get(4));
        row.setTxtKakushuKingaku2((RString)dataGrid.get(5));
        row.setTxtKakushuKingaku3((RString)dataGrid.get(6));
        
        return row;
    }

    /**
     * 特徴結果DataGridのロード
     * @param fukaShokaiGrandsonDiv
     * @param key 
     */
    private void loadTokuchoResult(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, RString key) {
        List formatData = new ArrayList();

        List TokuchoResultValue = getYamlTokuchoResult(key);
        
        for (int i = 0; i < TokuchoResultValue.size(); i++) {
            formatData.add(getFormatData((List)TokuchoResultValue.get(i)));
        }
        
        setDataGridTokuchoResult(fukaShokaiGrandsonDiv, formatData);
    }

    /**
     * 特徴結果DataGridをロード
     * @param div
     * @param formatData 
     */
    private void setDataGridTokuchoResult(FukaShokaiGrandsonDiv div, List formatData) {
        List dataGridAll = new ArrayList();
        
        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List)formatData.get(i);
            dgTokuchoKekka_Row row = createRowTokuchoResult(dataGrid);
        
            dataGridAll.add(row);
        }
            
        DataGrid<dgTokuchoKekka_Row> grid = div.getTokucho().getTokuChoKekka().getDgTokuchoKekka();
        grid.setDataSource(dataGridAll);
    }

    /**
     * 特徴結果DataGridの行を生成
     * @param dataGrid
     * @return 
     */
    private dgTokuchoKekka_Row createRowTokuchoResult(List dataGrid) {
        dgTokuchoKekka_Row row =
                new dgTokuchoKekka_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        
        if ((RString)dataGrid.get(0) != null) row.setTxtUketoriYM((RString)dataGrid.get(0));
        if ((RString)dataGrid.get(1) != null) row.setTxtTsuchiNaiyo((RString)dataGrid.get(1));
        if ((RString)dataGrid.get(2) != null) row.setTxtKakushuKbn((RString)dataGrid.get(2));
        if ((RString)dataGrid.get(3) != null) row.setTxtKakushuKingaku1((RString)dataGrid.get(3));
        if ((RString)dataGrid.get(4) != null) row.setTxtKakushuKingaku2((RString)dataGrid.get(4));
        if ((RString)dataGrid.get(5) != null) row.setTxtKakushuKingaku3((RString)dataGrid.get(5));
        if ((RString)dataGrid.get(6) != null) row.setTxtShoriKekka((RString)dataGrid.get(6));
        
        return row;
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
     * YamlLoader から 賦課根拠データを取り込み、Listに格納
     * @param yamlFileName Yamlファイル名
     * @return YamlデータのList
     */
    private List getYamlFukaKonkyo(List keyList) {

        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBB.loadAsList(FUKAKONKYO);

        //YamlData用List
        List yamlDatalistAll = new ArrayList();
        
        for (int i = 0; i < (int)fukaKonkyo.size(); i++) {

            RString key1 = (RString) keyList.get(0);
            
            ControlGenerator cg = new ControlGenerator(fukaKonkyo.get(i));
            
            if (key1.contains(cg.getAsRString("賦課根拠No"))) {
                
                List getYamlDatalist = getYamlListFukaKonkyo(cg);

                yamlDatalistAll.add(getYamlDatalist);
            }
        }

        return yamlDatalistAll;
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
     * 特別徴収のYamlデータを取得
     * @param yamlFileName
     * @param key
     * @return 
     */
    private List getYamlTokucho(RString key) {
        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBB.loadAsList(TOKUCHO);
       
        //YamlData用List
        List yamlDatalistAll = new ArrayList();
        
        for (int i = 0; i < (int)fukaKonkyo.size(); i++) {

            ControlGenerator cg = new ControlGenerator(fukaKonkyo.get(i));
                
            if (key.contains(cg.getAsRString("状態"))) {
                List getYamlDatalist = getYamlListTokucho(cg);

                yamlDatalistAll.add(getYamlDatalist);
            }
        }

        return yamlDatalistAll;
    }    
    
    /**
     * 賦課根拠データをList化
     * @param cg
     * @return 
     */
    private List getYamlListFukaKonkyo(ControlGenerator cg) {
        
        List yamlDatalist = new ArrayList();
        
        yamlDatalist.add(cg.get("賦課基準日"));
        yamlDatalist.add(cg.getAsRString("本人課税"));
        yamlDatalist.add(cg.getAsRString("世帯課税"));
        yamlDatalist.add(cg.get("合計所得"));
        yamlDatalist.add(cg.get("年金収入額"));
        yamlDatalist.add(cg.getAsRString("保険料段階_前年"));
        yamlDatalist.add(cg.get("保険料率_前年"));
        yamlDatalist.add(cg.get("年額保険料_前年"));
        yamlDatalist.add(cg.get("計算上年間保険料額"));
        yamlDatalist.add(cg.get("減免額"));
        yamlDatalist.add(cg.get("確定年間保険料額"));
        yamlDatalist.add(cg.getAsRString("期間"));
        yamlDatalist.add(cg.getAsRString("月数"));
        yamlDatalist.add(cg.getAsRString("保険料段階区分"));
        yamlDatalist.add(cg.get("保険料率"));
        yamlDatalist.add(cg.get("保険料算出額"));
        yamlDatalist.add(cg.get("保険料額"));
        yamlDatalist.add(cg.get("調定事由"));
        
        return yamlDatalist;
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
     * 特別徴収のYamlをList化
     * @param cg
     * @return 
     */
    private List getYamlListTokucho(ControlGenerator cg) {

        List yamlDatalist = new ArrayList();
        
        yamlDatalist.add(cg.getAsRString("状態"));
        yamlDatalist.add(cg.getAsRString("賦課年度"));
        yamlDatalist.add(cg.getAsRString("基礎年金番号"));
        yamlDatalist.add(cg.getAsRString("年金コード"));
        yamlDatalist.add(cg.getAsRString("捕捉年月"));
        yamlDatalist.add(cg.getAsRString("開始年月"));
        yamlDatalist.add(cg.getAsRString("特別徴収対象年金"));
        yamlDatalist.add(cg.getAsRString("特別徴収義務者"));
        yamlDatalist.add(cg.getAsRString("カナ氏名"));
        yamlDatalist.add(cg.getAsRString("氏名"));
        yamlDatalist.add(cg.getAsRString("住所"));
        yamlDatalist.add(cg.getAsRString("性別"));
        yamlDatalist.add(cg.getAsRString("生年月日"));
        yamlDatalist.add(cg.getAsRString("異動日"));
        yamlDatalist.add(cg.getAsRString("住定日"));
        yamlDatalist.add(cg.getAsRString("異動事由"));
        
        return yamlDatalist;
    }

    /**
     * 異動・依頼用のYamlを取得
     * @param yamlFileName
     * @param key
     * @return 
     */
    private List getYamlIdoAndIrai(RString key) {
        //Yaml データ読み込み
        List<HashMap> yamlValue = YamlLoader.DBB.loadAsList(IDOANDIRAI);
       
        //YamlData用List
        List yamlList = new ArrayList();
        
        for (int i = 0; i < (int)yamlValue.size(); i++) {

            ControlGenerator cg = new ControlGenerator(yamlValue.get(i));
                
            if (key.contains(cg.getAsRString("状態"))) {
                List getYamlList = getYamlIdoAndIrai(cg);

                yamlList.add(getYamlList);
            }
        }

        return yamlList;
    }

    /**
     * 異動・依頼用のYamlをList化
     * @param cg
     * @return 
     */
    private List getYamlIdoAndIrai(ControlGenerator cg) {

        List yamlList = new ArrayList();
        
        yamlList.add(cg.getAsRString("状態"));
        yamlList.add(cg.getAsRString("送付月"));
        yamlList.add(cg.getAsRString("通知内容"));
        yamlList.add(cg.getAsRString("各種区分"));
        yamlList.add(cg.get("各種金額1"));
        yamlList.add(cg.get("各種金額2"));
        yamlList.add(cg.get("各種金額3"));
        
        return yamlList;
    }

    /**
     * 特徴結果DataGridのYaml取得
     * @param yamlFileName
     * @param key
     * @return 
     */
    private List getYamlTokuchoResult(RString key) {
        //Yaml データ読み込み
        List<HashMap> yamlValue = YamlLoader.DBB.loadAsList(TOKUCHORESULT);
       
        //YamlData用List
        List yamlList = new ArrayList();
        
        for (int i = 0; i < (int)yamlValue.size(); i++) {

            ControlGenerator cg = new ControlGenerator(yamlValue.get(i));
                
            if (key.contains(cg.getAsRString("状態"))) {
                List getYamlList = getYamlTokuchoResult(cg);

                yamlList.add(getYamlList);
            }
        }

        return yamlList;
    }

    /** 
     * 特徴結果DataGridのYamlをList化
     * @param cg
     * @return 
     */
    private List getYamlTokuchoResult(ControlGenerator cg) {
        
        List yamlList = new ArrayList();
        
        yamlList.add(cg.getAsRString("受取年月"));
        yamlList.add(cg.getAsRString("通知内容"));
        yamlList.add(cg.getAsRString("各種区分"));
        yamlList.add(cg.get("各種金額1"));
        yamlList.add(cg.get("各種金額2"));
        yamlList.add(cg.get("各種金額3"));
        yamlList.add(cg.getAsRString("処理結果"));
        
        return yamlList;
    }
}