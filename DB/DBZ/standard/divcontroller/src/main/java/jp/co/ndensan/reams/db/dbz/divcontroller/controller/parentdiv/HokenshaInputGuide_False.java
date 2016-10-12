/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hokenshainputguide.HokenshaInputGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hokenshainputguide.dgSearchResultHokensha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 保険者番号、保険者名称の入力を補助する共通子Divのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class HokenshaInputGuide_False {

    private static final RString DATA_SOURCE = new RString("hokenshaData/hokenshaData.yml");

    /**
     * ダイアログを読み込んだ際に実行される処理です。<br/>
     * 検索条件となる県コードを表示するドロップダウンリストを作成します。
     *
     * @param div 被保険者入力ガイド
     * @return レスポンス
     */
    public ResponseData onLoad(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> response = new ResponseData<>();

        List<KeyValueDataSource> ddlSourceList = new ArrayList<>();
        List<HashMap> kenList = YamlLoader.DBZ.loadAsList(DATA_SOURCE);
        for (HashMap ken : kenList) {
            ControlGenerator generator = new ControlGenerator(ken);
            KeyValueDataSource source = new KeyValueDataSource(generator.getAsRString("県コード"),
                    generator.getAsRString("県コード").concat(" ").concat(generator.getAsRString("県名")));
            ddlSourceList.add(source);
        }
        div.getDdlHokenshaKenCode().setDataSource(ddlSourceList);

        response.data = div;
        return response;
    }

    /**
     * ドロップダウンリストから県コードを選択し、検索を行う際に動作するメソッドです。<br/>
     * 県コードから保険者を検索し、グリッド上に表示します。
     *
     * @param div HokenshaInputGuideDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnSearchGaitoHokensha(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> response = new ResponseData<>();

        DataGrid<dgSearchResultHokensha_Row> grid = div.getSearchResultHokensha().getDgSearchResultHokensha();
        setHokenshaList(grid, div.getDdlHokenshaKenCode().getSelectedItem());

        response.data = div;
        return response;
    }

    private void setHokenshaList(DataGrid<dgSearchResultHokensha_Row> grid, RString selectKey) {
        List<HashMap> kenList = YamlLoader.DBZ.loadAsList(DATA_SOURCE);
        List<HashMap> hokenshaList = getKenList(kenList, selectKey);

        grid.setDataSource(createHokenshaGrid(hokenshaList));
    }

    private List<HashMap> getKenList(List<HashMap> kenList, RString selectKey) {
        for (HashMap ken : kenList) {
            if (ken.get("県コード").toString().equals(selectKey.toString())) {
                return (List<HashMap>) ken.get("保険者");
            }
        }
        return Collections.EMPTY_LIST;
    }

    private List<dgSearchResultHokensha_Row> createHokenshaGrid(List<HashMap> hokenshaList) {
        List<dgSearchResultHokensha_Row> list = new ArrayList<>();
        for (Map hokensha : hokenshaList) {
            list.add(createHokenshaGridRow(hokensha));
        }
        return list;
    }

    private dgSearchResultHokensha_Row createHokenshaGridRow(Map hokensha) {
        dgSearchResultHokensha_Row row = new dgSearchResultHokensha_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setHokenshaNo(new RString(hokensha.get("保険者番号").toString()));
        row.setHokenshaMeisho(new RString(hokensha.get("保険者名称").toString()));
        row.setHokensha(row.getHokenshaNo().concat(":").concat(row.getHokenshaMeisho()));
        return row;
    }

    /**
     * グリッドから保険者が選択された際に動作するメソッドです。<br/>
     * 選択されたデータを、ダイアログ呼び出し元へ渡されるメンバにセットします。
     *
     * @param div HokenshaInputGuideDiv
     * @return レスポンス
     */
    public ResponseData onSelectBySelectButton_dgSearchResultHokensha(HokenshaInputGuideDiv div) {
        ResponseData<HokenshaInputGuideDiv> response = new ResponseData<>();
        setReturnedItem(div);
        response.data = div;
        return response;
    }

    private void setReturnedItem(HokenshaInputGuideDiv div) {
        DataGrid<dgSearchResultHokensha_Row> grid = div.getSearchResultHokensha().getDgSearchResultHokensha();
        dgSearchResultHokensha_Row row = grid.getClickedItem();

        div.setHokenshaNo(row.getHokenshaNo());
        div.setHokenshaMeisho(row.getHokenshaMeisho());
    }
}
