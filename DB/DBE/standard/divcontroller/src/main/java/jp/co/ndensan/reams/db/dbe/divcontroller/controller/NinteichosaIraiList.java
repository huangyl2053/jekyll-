/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.dgNinteichosaIraiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * NinteichosaIraiListDuvを操作するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaIraiList {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiListDiv> onLoad(NinteichosaIraiListDiv div) {
        ResponseData<NinteichosaIraiListDiv> response = new ResponseData<>();

        DataGrid<dgNinteichosaIraiList_Row> dataGrid = div.getDgNinteichosaIraiList();
        dataGrid.setDataSource(new DemoData().get調査依頼対象者());
        NinteichosaIraiListHolder.saveNinteichosaIraiList(Collections.EMPTY_LIST);

        response.data = div;
        return response;
    }

    /**
     * 復帰時の処理です。
     *
     * @param div NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiListDiv> onRetrun(NinteichosaIraiListDiv div) {
        ResponseData<NinteichosaIraiListDiv> response = new ResponseData<>();

        DataGrid<dgNinteichosaIraiList_Row> dataGrid = div.getDgNinteichosaIraiList();
        List<dgNinteichosaIraiList_Row> list = new ArrayList<>(DataGridUtil.unselectedItems(dataGrid));
        list.addAll(NinteichosaIraiListHolder.getNinteichosaIraiList());
        dataGrid.setDataSource(list);
        NinteichosaIraiListHolder.saveNinteichosaIraiList(Collections.EMPTY_LIST);

        response.data = div;
        return response;
    }

    /**
     * btnToEntry1押下時の処理です。
     *
     * @param div NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiListDiv> onClick_btnToEntryChosaIrai(NinteichosaIraiListDiv div) {
        ResponseData<NinteichosaIraiListDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * btnToComplete押下時の処理です。
     *
     * @param div NinteichosaIraiListDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaIraiListDiv> onClick_btnToComplete(NinteichosaIraiListDiv div) {
        ResponseData<NinteichosaIraiListDiv> response = new ResponseData<>();

        DataGrid<dgNinteichosaIraiList_Row> grid = div.getDgNinteichosaIraiList();

        List<dgNinteichosaIraiList_Row> list = new ArrayList<>();
        for (dgNinteichosaIraiList_Row selectedItem : grid.getSelectedItems()) {
            if (selectedItem.get依頼書発行済()) {
                selectedItem.get調査依頼完了日().setValue(FlexibleDate.getNowDate());
            }
            list.add(selectedItem);
        }
        list.addAll(DataGridUtil.unselectedItems(grid));
        grid.setDataSource(list);

        response.data = div;
        return response;
    }

    /**
     * 認定調査依頼対象者を保持します。
     */
    static final class NinteichosaIraiListHolder {

        private static final RString SELECTED = new RString("selected");

        /**
         * 認定調査依頼対象者を保存します。
         *
         * @param list 認定調査依頼対象者
         */
        static void saveNinteichosaIraiList(List<dgNinteichosaIraiList_Row> list) {
            ViewStateHolder.put(SELECTED, list);
        }

        /**
         * 認定調査依頼対象者を取得します。
         *
         * @return 認定調査依頼対象者
         */
        static List<dgNinteichosaIraiList_Row> getNinteichosaIraiList() {
            List<dgNinteichosaIraiList_Row> dataSource
                    = (List<dgNinteichosaIraiList_Row>) ViewStateHolder.get(SELECTED.toString(), List.class);
            return _isNull(dataSource) ? Collections.EMPTY_LIST : dataSource;
        }

        private static boolean _isNull(Object obj) {
            return obj == null;
        }

    }

    /**
     * 調査依頼対象のデモ用データを持ちます。
     */
    private static final class DemoData {

        private final List<dgNinteichosaIraiList_Row> chosaIraiTargets;

        /**
         * デモデータを生成します。
         */
        DemoData() {
            this.chosaIraiTargets = _createList();
        }

        /**
         * 調査依頼対象者を取得します。
         *
         * @return 調査依頼対象者
         */
        List<dgNinteichosaIraiList_Row> get調査依頼対象者() {
            return this.chosaIraiTargets;
        }

        private List<dgNinteichosaIraiList_Row> _createList() {
            List<HashMap> dataFromYaml = YamlLoader.FOR_DBE.loadAsList(new RString("dbeuc21000/ChosaIraiTargets.yml"));
            return YamlUtil.convertList(dataFromYaml, _createConverter());
        }

        private YamlUtil.Converter.IConverter<dgNinteichosaIraiList_Row> _createConverter() {
            return new YamlUtil.Converter.IConverter<dgNinteichosaIraiList_Row>() {

                @Override
                public dgNinteichosaIraiList_Row exec(Map map) {
                    return _toDgNinteichosaIraiList_Row(map);
                }
            };
        }

        private dgNinteichosaIraiList_Row _toDgNinteichosaIraiList_Row(Map map) {
            ControlGenerator cg = new ControlGenerator(map);
            RString shimei = cg.getAsRString("氏名");
            RString kanaShimei = cg.getAsRString("カナ氏名");
            RString iraiDate = cg.getAsRString("依頼完了日");
            boolean is依頼済 = !iraiDate.equals(RString.EMPTY);
            RString iraishoHakkoDate = cg.getAsRString("依頼書発行日");
            boolean is依頼書発行済 = !iraishoHakkoDate.equals(RString.EMPTY);
            return new dgNinteichosaIraiList_Row(
                    cg.getAsRString("保険者番号"),
                    cg.getAsRString("市町村"),
                    cg.getAsRString("市著コード"),
                    cg.getAsRString("支所"),
                    cg.getAsRString("被保番号"),
                    cg.getAsRString("識別コード"),
                    shimei, kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    cg.getAsTextBoxFlexibleDate("認定申請日"),
                    cg.getAsRString("認定申請区分"),
                    cg.getAsRString("申請書管理番号"),
                    cg.getAsTextBoxFlexibleDate("調査依頼日"),
                    cg.getAsTextBoxFlexibleDate("依頼書発行日"),
                    cg.getAsTextBoxFlexibleDate("依頼完了日"),
                    cg.getAsTextBoxFlexibleDate("調査期限日"),
                    cg.getAsRString("調査依頼区分"),
                    cg.getAsRString("調査回数"),
                    cg.getAsRString("認定調査履歴番号"),
                    cg.getAsRString("調査委託先番号"),
                    cg.getAsRString("調査委託先名"),
                    cg.getAsRString("調査員番号"),
                    cg.getAsRString("調査員名"),
                    cg.getAsRString("前回調査委託先番号"),
                    cg.getAsRString("前回調査委託先名"),
                    cg.getAsRString("前回調査員番号"),
                    cg.getAsRString("前回調査員名"),
                    cg.getAsRString("審査会開催地区コード"),
                    cg.getAsRString("審査会開催地区"),
                    cg.getAsTextBoxFlexibleDate("督促日"),
                    cg.getAsRString("督促方法"),
                    cg.getAsRString("督促回数"),
                    cg.getAsTextBoxFlexibleDate("督促期限"),
                    cg.getAsTextBoxFlexibleDate("督促発行日"),
                    cg.getAsRString("郵便番号"),
                    cg.getAsRString("住所"),
                    cg.getAsRString("入所施設"),
                    cg.getAsRString("性別"),
                    cg.getAsTextBoxFlexibleDate("生年月日"),
                    cg.getAsRString("データ出力"),
                    is依頼済, is依頼書発行済);
        }
    }
}
