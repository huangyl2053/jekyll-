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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.TokuchoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgTokuChoIdoAndIrai_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgTokuchoKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8211
 */
public class Tokucho {

    public static final RString TOKUCHO = new RString("DBB0320002/Tokucho.yml");
    public static final RString IDOANDIRAI = new RString("DBB0320002/IdoAndIrai.yml");
    public static final RString TOKUCHORESULT = new RString("DBB0320002/TokuchoResult.yml");

    public ResponseData<TokuchoDiv> onClick_btnTokucho(TokuchoDiv div) {

        FukaRirekiDiv rirekiDiv = (FukaRirekiDiv) ViewStateHolder.get("賦課履歴", FukaRirekiDiv.class);

        div.setDisplayNone(false);

        loadTokucho(div, rirekiDiv);

        return returnResponse(div);
    }

    /**
     * イベント処理後のレスポンスデータをリターン
     *
     * @param div
     * @return
     */
    private ResponseData<TokuchoDiv> returnResponse(TokuchoDiv div) {
        ResponseData<TokuchoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 特別徴収情報Divのロード
     *
     * @param div
     */
    private void loadTokucho(TokuchoDiv div, FukaRirekiDiv rirekiDiv) {
        List formatData = new ArrayList();

        RString key = div.getRadChoshu().getSelectedItem();

        if (key.length() <= 0) {

            List<dgFukaRirekiFukaRireki_Row> selectedItem = rirekiDiv.getDgFukaRirekiFukaRireki().getSelectedItems();
            RString selectedHokenryoDankai = selectedItem.get(0).getTxtHokenryoDankai();
            if (selectedHokenryoDankai.length() > 0) {
                key = new RString("本");
            } else {
                key = new RString("仮");
            }
        } else {
            if (key.contains("0")) {
                key = new RString("仮");
            } else {
                key = new RString("本");
            }
        }

        List fukaTokuchoValue = getYamlTokucho(key);

        for (int i = 0; i < fukaTokuchoValue.size(); i++) {
            formatData.add(getFormatData((List) fukaTokuchoValue.get(i)));
        }

        setTokucho(div, (List) formatData.get(0));
        loadIdoAndIrai(div, key);
        loadTokuchoResult(div, key);
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
                formatData.add(new RString(""));
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

    /**
     * int かどうかチェック
     *
     * @param checkData
     * @return
     */
    private boolean intChecker(List checkData) {
        return checkData.get(0).getClass().getName().equals("java.lang.Integer");
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
     * 特別徴収を値をセット
     *
     * @param div
     * @param formatData
     */
    private void setTokucho(TokuchoDiv div, List formatData) {

        div.getTxtFukaNendo1().setValue((RString) formatData.get(1));
        div.getTxtKisoNenkinNo2().setValue((RString) formatData.get(2));
        div.getTxtNenkinCode2().setValue((RString) formatData.get(3));
        div.getTxtHosokuYM().setValue((RString) formatData.get(4));
        div.getTxtKaishiTsuki().setValue((RString) formatData.get(5));
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue((RString) formatData.get(6));
        div.getTxtTokuChoGimusha().setValue((RString) formatData.get(7));
    }

    /**
     * 特徴内の異動・依頼DataGridをロード
     *
     * @param div
     * @param key
     */
    private void loadIdoAndIrai(TokuchoDiv div, RString key) {
        List formatData = new ArrayList();

        List idoAndIraiValue = getYamlIdoAndIrai(key);

        for (int i = 0; i < idoAndIraiValue.size(); i++) {
            formatData.add(getFormatData((List) idoAndIraiValue.get(i)));
        }

        setDataGridTokuchoIdoAndIrai(div, formatData);
    }

    /**
     * 異動・依頼DataGridに値をセット
     *
     * @param div
     * @param formatData
     */
    private void setDataGridTokuchoIdoAndIrai(TokuchoDiv div, List formatData) {
        List dataGridAll = new ArrayList();

        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List) formatData.get(i);
            dgTokuChoIdoAndIrai_Row row = createRowTokuchoIdoAndIrai(dataGrid);

            dataGridAll.add(row);
        }

        DataGrid<dgTokuChoIdoAndIrai_Row> grid = div.getTokuChoIdoAndIrai().getDgTokuChoIdoAndIrai();
        grid.setDataSource(dataGridAll);
    }

    /**
     * 異動・依頼DataGridの行を生成
     *
     * @param div
     * @param dataGrid
     * @return
     */
    private dgTokuChoIdoAndIrai_Row createRowTokuchoIdoAndIrai(List dataGrid) {
        dgTokuChoIdoAndIrai_Row row
                = new dgTokuChoIdoAndIrai_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setTxtSofuYM((RString) dataGrid.get(1));
        row.setTxtTsuchiNaiyo((RString) dataGrid.get(2));
        row.setTxtKakushuKbn((RString) dataGrid.get(3));
        row.setTxtKakushuKingaku1((RString) dataGrid.get(4));
        row.setTxtKakushuKingaku2((RString) dataGrid.get(5));
        row.setTxtKakushuKingaku3((RString) dataGrid.get(6));

        return row;
    }

    /**
     * 特徴結果DataGridのロード
     *
     * @param div
     * @param key
     */
    private void loadTokuchoResult(TokuchoDiv div, RString key) {
        List formatData = new ArrayList();

        List TokuchoResultValue = getYamlTokuchoResult(key);

        for (int i = 0; i < TokuchoResultValue.size(); i++) {
            formatData.add(getFormatData((List) TokuchoResultValue.get(i)));
        }

        setDataGridTokuchoResult(div, formatData);
    }

    /**
     * 特徴結果DataGridをロード
     *
     * @param div
     * @param formatData
     */
    private void setDataGridTokuchoResult(TokuchoDiv div, List formatData) {
        List dataGridAll = new ArrayList();

        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List) formatData.get(i);
            dgTokuchoKekka_Row row = createRowTokuchoResult(dataGrid);

            dataGridAll.add(row);
        }

        DataGrid<dgTokuchoKekka_Row> grid = div.getTokuChoKekka().getDgTokuchoKekka();
        grid.setDataSource(dataGridAll);
    }

    /**
     * 特徴結果DataGridの行を生成
     *
     * @param dataGrid
     * @return
     */
    private dgTokuchoKekka_Row createRowTokuchoResult(List dataGrid) {
        dgTokuchoKekka_Row row
                = new dgTokuchoKekka_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        if ((RString) dataGrid.get(0) != null) {
            row.setTxtUketoriYM((RString) dataGrid.get(0));
        }
        if ((RString) dataGrid.get(1) != null) {
            row.setTxtTsuchiNaiyo((RString) dataGrid.get(1));
        }
        if ((RString) dataGrid.get(2) != null) {
            row.setTxtKakushuKbn((RString) dataGrid.get(2));
        }
        if ((RString) dataGrid.get(3) != null) {
            row.setTxtKakushuKingaku1((RString) dataGrid.get(3));
        }
        if ((RString) dataGrid.get(4) != null) {
            row.setTxtKakushuKingaku2((RString) dataGrid.get(4));
        }
        if ((RString) dataGrid.get(5) != null) {
            row.setTxtKakushuKingaku3((RString) dataGrid.get(5));
        }
        if ((RString) dataGrid.get(6) != null) {
            row.setTxtShoriKekka((RString) dataGrid.get(6));
        }

        return row;
    }

    /**
     * 特別徴収のYamlデータを取得
     *
     * @param yamlFileName
     * @param key
     * @return
     */
    private List getYamlTokucho(RString key) {
        //Yaml データ読み込み
        List<HashMap> fukaKonkyo = YamlLoader.DBB.loadAsList(TOKUCHO);

        //YamlData用List
        List yamlDatalistAll = new ArrayList();

        for (int i = 0; i < (int) fukaKonkyo.size(); i++) {

            ControlGenerator cg = new ControlGenerator(fukaKonkyo.get(i));

            if (key.contains(cg.getAsRString("状態"))) {
                List getYamlDatalist = getYamlListTokucho(cg);

                yamlDatalistAll.add(getYamlDatalist);
            }
        }

        return yamlDatalistAll;
    }

    /**
     * 特別徴収のYamlをList化
     *
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
     *
     * @param yamlFileName
     * @param key
     * @return
     */
    private List getYamlIdoAndIrai(RString key) {
        //Yaml データ読み込み
        List<HashMap> yamlValue = YamlLoader.DBB.loadAsList(IDOANDIRAI);

        //YamlData用List
        List yamlList = new ArrayList();

        for (int i = 0; i < (int) yamlValue.size(); i++) {

            ControlGenerator cg = new ControlGenerator(yamlValue.get(i));

            if (key.contains(cg.getAsRString("状態"))) {
                List getYamlList = getYamlIdoAndIraiList(cg);

                yamlList.add(getYamlList);
            }
        }

        return yamlList;
    }

    /**
     * 異動・依頼用のYamlをList化
     *
     * @param cg
     * @return
     */
    private List getYamlIdoAndIraiList(ControlGenerator cg) {

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
     *
     * @param yamlFileName
     * @param key
     * @return
     */
    private List getYamlTokuchoResult(RString key) {
        //Yaml データ読み込み
        List<HashMap> yamlValue = YamlLoader.DBB.loadAsList(TOKUCHORESULT);

        //YamlData用List
        List yamlList = new ArrayList();

        for (int i = 0; i < (int) yamlValue.size(); i++) {

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
     *
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
