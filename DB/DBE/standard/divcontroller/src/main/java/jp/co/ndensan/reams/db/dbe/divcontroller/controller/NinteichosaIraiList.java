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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
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
        dataGrid.setDataSource(ChosaIraiTargets.DATA_SORCE);
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
        grid.setDataSource(DataGridUtil.unselectedItems(grid));

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
    private static class ChosaIraiTargets {

        private static final List<dgNinteichosaIraiList_Row> DATA_SORCE;

        static {
            DATA_SORCE = new ArrayList<>();
            try {
                List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("dbeuc21000/ChosaIraiTargets.yml"));
                for (Map target : targetSource) {
                    DATA_SORCE.add(_to_dgNinteichosaIraiList_Row(target));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private static dgNinteichosaIraiList_Row _to_dgNinteichosaIraiList_Row(Map map) {
            RString shimei = toRString(map.get("氏名"));
            RString kanaShimei = toRString(map.get("カナ氏名"));
            RString iraiDate = toRString(map.get("調査依頼日"));
            boolean is依頼済 = !iraiDate.equals(RString.EMPTY);
            RString iraishoHakkoDate = toRString(map.get("依頼書発行日"));
            boolean is依頼書発行済 = !iraishoHakkoDate.equals(RString.EMPTY);

            return new dgNinteichosaIraiList_Row(
                    toRString(map.get("保険者番号")), toRString(map.get("市町村")),
                    toRString(map.get("市著コード")), toRString(map.get("支所")),
                    toRString(map.get("被保番号")),
                    toRString(map.get("識別コード")),
                    shimei, kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    toTextBoxFlexibleDate(toRString(map.get("認定申請日"))),
                    toRString(map.get("認定申請区分")),
                    toRString(map.get("申請書管理番号")),
                    toTextBoxFlexibleDate(iraiDate),
                    toTextBoxFlexibleDate(iraishoHakkoDate),
                    toTextBoxFlexibleDate(toRString(map.get("依頼完了日"))),
                    toTextBoxFlexibleDate(toRString(map.get("調査期限日"))),
                    toRString(map.get("調査依頼区分")),
                    toRString(map.get("調査回数")),
                    toRString(map.get("認定調査履歴番号")),
                    toRString(map.get("調査委託先番号")), toRString(map.get("調査委託先名")),
                    toRString(map.get("調査員番号")), toRString(map.get("調査員名")),
                    toRString(map.get("前回調査委託先番号")), toRString(map.get("前回調査委託先名")),
                    toRString(map.get("前回調査員番号")), toRString(map.get("前回調査員名")),
                    toRString(map.get("審査会開催地区コード")), toRString(map.get("審査会開催地区")),
                    toTextBoxFlexibleDate(toRString(map.get("督促日"))),
                    toRString(map.get("督促方法")),
                    toRString(map.get("督促回数")),
                    toTextBoxFlexibleDate(toRString(map.get("督促期限"))),
                    toTextBoxFlexibleDate(toRString(map.get("督促発行日"))),
                    toRString(map.get("住所")), toRString(map.get("郵便番号")),
                    toRString(map.get("入所施設")),
                    toRString(map.get("性別")),
                    toTextBoxFlexibleDate(toRString(map.get("生年月日"))),
                    toRString(map.get("データ出力")),
                    is依頼済, is依頼書発行済);
        }

        private static RString toRString(Object obj) {
            if (obj == null) {
                return RString.EMPTY;
            }
            return new RString(obj.toString());
        }

        private static TextBoxFlexibleDate toTextBoxFlexibleDate(RString date) {
            TextBoxFlexibleDate textBox = new TextBoxFlexibleDate();
            if (date.equals(RString.EMPTY)) {
                textBox.setValue(FlexibleDate.EMPTY);
            } else {
                textBox.setValue(new FlexibleDate(date));
            }
            return textBox;
        }
    }
}
