/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SetaiInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 世帯情報
 * @author n8223
 */
public class SetaiInfo {

    private static final RString SETAISHOTOKU = new RString("dbc0030011/SetaiShotoku.yml");
    private static final RString OTHER = new RString("dbc0030011/other.yml");

    public ResponseData<SetaiInfoDiv> onClick_btnShowSeteiJoho(SetaiInfoDiv panel) {
        ResponseData<SetaiInfoDiv> response = new ResponseData<>();
                
        //2014.07.04 朴　宛名・介護基本 対応
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000019");

        int rowId = 0;
        KaigoShikakuKihon.setData(panel.getCommonKaigAtenChildDiv1(),
                panel.getCommonKaigoShiChildDiv2(), 識別コード, rowId);

        
        RString mode = new RString("onClick");
        loadSetaiinShotoku(panel, mode);
        
        List<HashMap> other = YamlLoader.DBC.loadAsList(OTHER);
        ControlGenerator cg = new ControlGenerator(other.get(0));
        
        panel.getSetaiinShotoku().getTxtSetaiIchiranKijunYMD().setValue(cg.getAsRDate("基準日"));
       // panel.getSetaiinShotoku().getTxtSetaiIchiranKazeiNendo().setValue(new RString((String)other.get(0).get("賦課年度")));
       //2014/.07.07 世帯コード15桁に
        panel.getSetaiinShotoku().getTxtSetaiIchiranSetaiCode().setValue(cg.getAsRString("世帯コード"));
       // panel.getSetaiinShotoku().getTxtSetaiIchiranSetaiCode().setValue(new RString("1234567890"));
        response.data = panel;
        return response;

    }

    /**
     * 世帯所得Divのロード
     *
     * @param
     */
    private void loadSetaiinShotoku(SetaiInfoDiv panel, RString mode) {

        List formatData = new ArrayList();
        RString key = null;

        if (mode.contains("onClick")) {
            key = new RString("基準日");
        } else if (mode.contains("onChange")) {
            key = new RString("直近");
        }

        List shotokuList = getYamlSetaiShotoku(key);

        for (int i = 0; i < shotokuList.size(); i++) {
            formatData.add(getFormatData((List) shotokuList.get(i)));
        }

        List dataGridAll = new ArrayList(formatData.size());

        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List) formatData.get(i);

            dgSetaiShotoku_Row row = createRowSetaiShotoku(dataGrid);
            dataGridAll.add(row);
        }

        DataGrid<dgSetaiShotoku_Row> ssid = panel.getSetaiinShotoku().getDgSetaiShotoku();
        ssid.setDataSource(dataGridAll);
    }

    /**
     * 世帯所得一覧のDataGridの行にデータを代入
     *
     * @param dataGrid
     * @return
     */
    private dgSetaiShotoku_Row createRowSetaiShotoku(List dataGrid) {
        dgSetaiShotoku_Row row = new dgSetaiShotoku_Row(
                new Button(), RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, new Button(), RString.FULL_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        StringBuilder buf = new StringBuilder();

        row.setTxtShikibetsuCode((RString) dataGrid.get(0));
        buf.append(dataGrid.get(0).toString());
        buf.append("<br>");
        buf.append(dataGrid.get(1).toString());
        row.setTxtKetsugo01(new RString(buf.toString()));
        row.setTxtShimei((RString) dataGrid.get(3));
        
        //2014.07.07 個人番号
        row.setTxtHihokenshaNo((RString) dataGrid.get(1));

        row.setTxtSonzaiUmuKijunbi((RString) dataGrid.get(7));
        row.setTxtSonzaiUmuChokkin((RString) dataGrid.get(8));

        buf.delete(0, buf.length());
        buf.append((RString) dataGrid.get(4));
        //生年月日と性別の間にスペースを入れる
        buf.append("　");
        buf.append((RString) dataGrid.get(5));
        buf.append("<br>");
        buf.append((RString) dataGrid.get(6));
        row.setTxtKetsugo02(new RString(buf.toString()));

        buf.delete(0, buf.length());
        row.setTxtShubetsu((RString) dataGrid.get(9));
        row.setTxtIdoYMD((RString) dataGrid.get(10));
        row.setTxtHaaku((RString) dataGrid.get(11));
        row.setTxtJuminzei((RString) dataGrid.get(12));

        buf.append((RString) dataGrid.get(13));
        buf.append("<br>");
        buf.append((RString) dataGrid.get(14));
        row.setTxtKetsugo03(new RString(buf.toString()));

        row.setTxtJukiIdoJiyu((RString) dataGrid.get(15));
        row.setTxtJuteiYMD((RString) dataGrid.get(16));
        row.setTxtJukiIdoJiyu((RString) dataGrid.get(17));
        row.setTxtDougetsuService((RString) dataGrid.get(18));

        return row;
    }

    /**
     * 世帯所得一覧のYamlを取得
     *
     * @param yamlFileName
     * @return
     */
    private List getYamlSetaiShotoku(RString key) {

        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBC.loadAsList(SETAISHOTOKU);

        //YamlData用List
        List yamlDatalistAll = new ArrayList();

        for (int i = 0; i < (int) fukaKonkyo.size(); i++) {

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
     *
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
        yamlDatalist.add(cg.getAsRString("同月ｻｰﾋﾞｽ"));


        return yamlDatalist;
    }

    /**
     * List の 値を確認し、int なら setComma を実行
     *
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
                    formatData.add(setComma((int) listData.get(i)));
                } else {
                    formatData.add(listData.get(i));
                }
            }
        }

        return formatData;
    }

    //再表示ボタン　2014.07.04
    public  ResponseData<SetaiInfoDiv> onClick_Saihyoji(SetaiInfoDiv panel) {
        ResponseData<SetaiInfoDiv> response = new ResponseData<>();
        
        RString mode = new RString("onClick");  
        
        panel.getSetaiinShotoku().getDgSetaiShotoku().getDataSource().clear();
        loadSetaiinShotoku(panel, mode);        
        
        response.data = panel;
        return response;

    }

    public ResponseData<SetaiInfoDiv> onChange_chkSetaiIchiranAll(SetaiInfoDiv panel) {
        ResponseData<SetaiInfoDiv> response = new ResponseData<>();

        if (panel.getSetaiinShotoku().getChkSetaiIchiranAll().getSelectedItems().size() > 0) {
            panel.getSetaiinShotoku().getLblSetaiIchiranMsg().setDisplayNone(true);
        } else {
            panel.getSetaiinShotoku().getLblSetaiIchiranMsg().setDisplayNone(false);
        }

        panel.setDisplayNone(false);

        RString mode = setProperty_SetaiinShotku(panel);
        loadSetaiinShotoku(panel, mode);

        response.data = panel;
        return response;
    }

    /**
     * 最新世帯表示のチェックボックスを判断し、一部列の表示、非表示の切り替え
     *
     * @param div
     */
    private RString setProperty_SetaiinShotku(SetaiInfoDiv panel) {

        SetaiShotokuIchiranDiv shotokuIchiranDiv = panel.getSetaiinShotoku();
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
     * int をカンマ付で String に変換
     *
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
     *
     * @param checkData
     * @return
     */
    private boolean intChecker(List checkData) {
        return checkData.get(0).getClass().getName().equals("java.lang.Integer");
    }
    
    
    
}
