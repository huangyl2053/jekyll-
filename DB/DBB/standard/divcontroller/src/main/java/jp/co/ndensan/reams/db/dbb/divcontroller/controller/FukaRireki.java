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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.AtenaJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiAll_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8211
 */
public class FukaRireki {

    private static final RString FUKARIREKI = new RString("FukaRireki.yml");

    public ResponseData<FukaRirekiDiv> onSelect(FukaRirekiDiv rirekiDiv, FukaRirekiAllDiv rirekiAllDiv , AtenaJohoDiv atenajoho) {
        panelActivatedFukaRireki(rirekiDiv);

        lordData(rirekiDiv, rirekiAllDiv, "select");

        return returnResponse(rirekiDiv);
    }

    public ResponseData<FukaRirekiDiv> onClick(FukaRirekiDiv rirekiDiv, FukaRirekiAllDiv rirekiAllDiv , AtenaJohoDiv atenajoho) {
        panelActivatedFukaRireki(rirekiDiv);

        lordData(rirekiDiv, rirekiAllDiv, "click");

        return returnResponse(rirekiDiv);
    }

    /**
     * 比較画面にデータを渡す
     *
     * @param div
     * @param fukaRirekiDiv
     * @return
     */
    public ResponseData<FukaRirekiDiv> onClick_ComparedWithPrevious(FukaRirekiDiv div, FukaRirekiAllDiv rirekiAllDiv, AtenaJohoDiv atenajoho) {
        //ViewStateに格納
        ViewStateHolder.put("賦課履歴", div);
        ViewStateHolder.put("mode", new RString("comparedWithPrevious"));

        return returnResponse(div);
    }

    /**
     * 賦課照会画面にデータを渡す
     *
     * @param div
     * @param fukaRirekiDiv
     * @param atenajoho
     * @return
     */
    public ResponseData<FukaRirekiDiv> onSelect_dgFukaRirekiFukaRireki(FukaRirekiDiv div, FukaRirekiAllDiv rirekiAllDiv, AtenaJohoDiv atenajoho) {
        //ViewStateに格納
        ViewStateHolder.put("賦課履歴", div);
        ViewStateHolder.put("宛名情報", atenajoho);

        return returnResponse(div);
    }

    /**
     * レスポンスデータのリターン
     *
     * @param rirekiDiv
     * @return
     */
    private ResponseData<FukaRirekiDiv> returnResponse(FukaRirekiDiv rirekiDiv) {
        ResponseData<FukaRirekiDiv> response = new ResponseData<>();
        response.data = rirekiDiv;
        return response;
    }

    /**
     * 賦課履歴一覧パネルを有効化
     *
     * @param rirekiDiv
     */
    private void panelActivatedFukaRireki(FukaRirekiDiv rirekiDiv) {
        rirekiDiv.setCanOpenAndClose(true);
        rirekiDiv.setIsOpen(true);
    }

    /**
     * 賦課履歴のロード
     *
     * @param fukaRirekiAllDiv
     */
    private void lordData(FukaRirekiDiv fukaRirekiDiv, FukaRirekiAllDiv fukaRirekiAllDiv, String mode) {
        List fukaRirekiFormatData = new ArrayList();

        List rirekiKey = getRirekiKey(fukaRirekiAllDiv, mode);

        List fukaRirekiData = getYamlDataList(rirekiKey);

        for (int i = 0; i < fukaRirekiData.size(); i++) {
            fukaRirekiFormatData.add(getFormatData((List) fukaRirekiData.get(i)));
        }

        setRirekiAll(fukaRirekiDiv, fukaRirekiFormatData);
    }

    /**
     * 全賦課履歴 DataGrid に値をセット
     *
     * @param formatData DataGrid にセットする値List
     */
    private void setRirekiAll(FukaRirekiDiv fukaRirekiDiv, List formatData) {

        List dataGridAll = new ArrayList();

        for (int i = 0; i < formatData.size(); i++) {
            List dataGrid = (List) formatData.get(i);
            dgFukaRirekiFukaRireki_Row dRirekiAll_Row = createRowRirekiAll(fukaRirekiDiv, dataGrid);

            dataGridAll.add(dRirekiAll_Row);
        }

        DataGrid<dgFukaRirekiFukaRireki_Row> grid = fukaRirekiDiv.getDgFukaRirekiFukaRireki();
        grid.setDataSource(dataGridAll);
    }

    private dgFukaRirekiFukaRireki_Row createRowRirekiAll(FukaRirekiDiv fukaRirekiDiv, List dataGrid) {
        dgFukaRirekiFukaRireki_Row row
                = new dgFukaRirekiFukaRireki_Row(new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        RStringBuilder buf = new RStringBuilder();
        fukaRirekiDiv.getTxtFukaNendoFukaRireki().setValue((RString) dataGrid.get(0));
        row.setTxtTsuchishoNo((RString) dataGrid.get(1));
        row.setTxtChoteiNendo((RString) dataGrid.get(2));
        buf.append(dataGrid.get(3));
        buf.append(" ");
        buf.append(dataGrid.get(4));
        row.setTxtKoseiYMD(buf.toRString());
        row.setTxtKoseiM((RString) dataGrid.get(5));
        row.setTxtHokenryoDankai((RString) dataGrid.get(6));
        row.setTxtHokenryoGaku((RString) dataGrid.get(7));
        row.setTxtTokubetsuChoshu((RString) dataGrid.get(8));
        row.setTxtFutsuChoshu((RString) dataGrid.get(9));
        row.setTxtRirekiNo((RString) dataGrid.get(10));
        row.setTxtShikibetsuCode((RString) dataGrid.get(11));

        return row;
    }

    /**
     * YamlLoader から データを取り込み、Listに格納
     *
     * @param yamlFileName Yamlファイル名
     * @return YamlデータのList
     */
    private List getYamlDataList(List keyList) {

        //Yaml データ読み込み
        List<HashMap> fukaRireki = YamlLoader.DBB.loadAsList(FUKARIREKI);

        //YamlData用List
        List yamlDatalistAll = new ArrayList();

        for (int i = 0; i < (int) fukaRireki.size(); i++) {

            RString key1 = (RString) keyList.get(0);
            RString key2 = (RString) keyList.get(1);
            RString key3 = (RString) keyList.get(2);

            ControlGenerator cg = new ControlGenerator(fukaRireki.get(i));

            if (key1.contains(cg.getAsRString("通知書番号"))
                    & key2.contains(cg.getAsRString("賦課年度"))
                    //                    & key3.contains(cg.getAsRString("調定年度"))
                    & !cg.get("状態").toString().equals("発行")) {

                List getYamlDatalist = getYamaData(cg);

                yamlDatalistAll.add(getYamlDatalist);
            }
        }

        return yamlDatalistAll;
    }

    private List getYamaData(ControlGenerator cg) {

        List yamlDatalist = new ArrayList();

        yamlDatalist.add(cg.getAsRString("賦課年度"));
        yamlDatalist.add(cg.getAsRString("通知書番号"));
        yamlDatalist.add(cg.getAsRString("調定年度"));
        yamlDatalist.add(cg.getAsRString("更正日"));
        yamlDatalist.add(cg.getAsRString("更正時"));
        yamlDatalist.add(cg.getAsRString("更正月"));
        yamlDatalist.add(cg.getAsRString("保険料段階"));
        yamlDatalist.add(cg.get("保険料額"));
        yamlDatalist.add(cg.get("特別徴収額"));
        yamlDatalist.add(cg.get("普通徴収額"));
        yamlDatalist.add(cg.get("賦課根拠No"));
        yamlDatalist.add(cg.getAsRString("識別コード"));

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

            boolean intCheck = intChecker(checkData);

            if (intCheck == true) {
                formatData.add(setComma((int) listData.get(i)));
            } else {
                formatData.add(listData.get(i));
            }
        }

        return formatData;
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

    private List getRirekiKey(FukaRirekiAllDiv fukaRirekiAllDiv, String mode) {

        List selectedKeyList = new ArrayList();

        switch (mode) {
            case "select":
                // 選択行の情報を取得
                List<dgFukaRirekiAll_Row> selectedItem = fukaRirekiAllDiv.getDgFukaRirekiAll().getSelectedItems();
                for (dgFukaRirekiAll_Row selectData : selectedItem) {
                    selectedKeyList.add(selectData.getTxtTsuchishoNo());
                    selectedKeyList.add(selectData.getTxtFukaNendo());
                    selectedKeyList.add(selectData.getTxtChoteiNendo());
                }
                break;
            case "click":
                dgFukaRirekiAll_Row clickedItem = fukaRirekiAllDiv.getDgFukaRirekiAll().getClickedItem();
                selectedKeyList.add(clickedItem.getTxtTsuchishoNo());
                selectedKeyList.add(clickedItem.getTxtFukaNendo());
                selectedKeyList.add(clickedItem.getTxtChoteiNendo());
                break;
        }

        return selectedKeyList;
    }
}
