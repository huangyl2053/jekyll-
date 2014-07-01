/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.SearchResultShoKaishuKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.SearchShoKaishuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 検索した証回収状況を表示するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class SearchResultShoKaishuKanri {

    private final static RString SHO_KOFU_DATA = new RString("dbu0500011/ShoKofuData.yml");

    /**
     * 検索ボタンをクリックした際に実行されます。<br/>
     * 検索条件に該当する証回収情報をグリッドに表示します。
     *
     * @param searchResultDiv　証回収状況検索結果Div
     * @param searchDiv 証回収状況検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSearchShoKaishuKanri(SearchResultShoKaishuKanriDiv searchResultDiv, SearchShoKaishuKanriDiv searchDiv) {
        ResponseData<SearchResultShoKaishuKanriDiv> response = new ResponseData<>();
        if (!searchDiv.getTxtSearchHihokenshaNo().getText().isEmpty()) {
            searchResultDiv.setHihokenshaNo(searchDiv.getTxtSearchHihokenshaNo().getValue());
            setShoKofuGrid(searchResultDiv, searchDiv);
            openAndClosePanel(searchResultDiv);
        }

        response.data = searchResultDiv;
        return response;
    }

    private void setShoKofuGrid(SearchResultShoKaishuKanriDiv searchResultDiv, SearchShoKaishuKanriDiv searchDiv) {
        List<HashMap> shoKofuDataList = getShoKofuDataList(searchResultDiv);
        List<dgShoKaishuJokyo_Row> shoKaishuJokyoList = getShoKofuDataSource(shoKofuDataList, searchDiv);
        searchResultDiv.getSearchResultShoKaishuJokyoList().getDgShoKaishuJokyo().setDataSource(shoKaishuJokyoList);
    }

    private List<HashMap> getShoKofuDataList(SearchResultShoKaishuKanriDiv searchResultDiv) {
        List<HashMap> yamlDataList = YamlLoader.DBU.loadAsList(SHO_KOFU_DATA);
        List<HashMap> shoKofuDataList = new ArrayList<>();
        for (HashMap yamlData : yamlDataList) {
            RString hihokenshaNo = searchResultDiv.getHihokenshaNo();
            ControlGenerator generator = new ControlGenerator(yamlData);
            if (hihokenshaNo != null) {
                shoKofuDataList = (List<HashMap>) generator.get("証交付記録");
            }
        }
        return shoKofuDataList;
    }

    private List<dgShoKaishuJokyo_Row> getShoKofuDataSource(List<HashMap> shoKofuDataList, SearchShoKaishuKanriDiv searchDiv) {
        List<dgShoKaishuJokyo_Row> shoKaishuJokyoList = new ArrayList<>();
        for (HashMap shoKofuData : shoKofuDataList) {
            ControlGenerator generator = new ControlGenerator(shoKofuData);
            if (excludeKaishuKirokuZumi(generator, searchDiv)) {
                continue;
            }
            if (excludeShoKofuKanriTaishoGai(generator, searchDiv)) {
                continue;
            }
            if (excludeOutOfDateRange(generator, searchDiv)) {
                continue;
            }
            shoKaishuJokyoList.add(createShoKaishuJokyoRow(generator));
        }
        return shoKaishuJokyoList;
    }

    private boolean excludeKaishuKirokuZumi(ControlGenerator generator, SearchShoKaishuKanriDiv searchDiv) throws IllegalArgumentException {
        RDate kaishuDate = generator.getAsRDate("回収日");
        CheckBoxList chkKaishuKirokuZumi = searchDiv.getChkKaishuKirokuZumi();
        if (chkKaishuKirokuZumi.getSelectedItems().isEmpty()) {
            if (kaishuDate != null) {
                return true;
            }
        }
        return false;
    }

    private boolean excludeShoKofuKanriTaishoGai(ControlGenerator generator, SearchShoKaishuKanriDiv searchDiv) {
        RString shoKohuShuruiKey = generator.getAsRString("証交付種類Key");
        return !searchDiv.getRadSearchKohushoShurui().getSelectedItem().equals(shoKohuShuruiKey);
    }

    private boolean excludeOutOfDateRange(ControlGenerator generator, SearchShoKaishuKanriDiv searchDiv) {
        RDate searchKaishiDate = searchDiv.getTxtSearchKofuKikan().getFromValue();
        RDate searchShuryoDate = searchDiv.getTxtSearchKofuKikan().getToValue();
        if (searchKaishiDate == null) {
            searchKaishiDate = RDate.MIN;
        }
        if (searchShuryoDate == null) {
            searchShuryoDate = RDate.MAX;
        }

        RDate kaishiDate = generator.getAsRDate("交付日");
        return !(searchKaishiDate.isBefore(kaishiDate) && kaishiDate.isBefore(searchShuryoDate));
    }

    private dgShoKaishuJokyo_Row createShoKaishuJokyoRow(ControlGenerator generator) {
        dgShoKaishuJokyo_Row row = new dgShoKaishuJokyo_Row(new Button(), RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate());

        row.setKofushoShurui(generator.getAsRString("証交付種類"));
        row.setKofuDate(generator.getAsTextBoxFlexibleDate("交付日"));
        row.setKofuJiyuKey(generator.getAsRString("交付事由Key"));
        row.setKofuJiyu(generator.getAsRString("交付事由"));
        row.setKofuRiyu(generator.getAsRString("交付理由"));
        row.setKaishuDate(generator.getAsTextBoxFlexibleDate("回収日"));
        row.setKaishuJiyuKey(generator.getAsRString("回収事由Key"));
        row.setKaishuJiyu(generator.getAsRString("回収事由"));
        row.setKaishuRiyu(generator.getAsRString("回収理由"));
        row.setYukoKigen(generator.getAsTextBoxFlexibleDate("有効期限"));
        return row;
    }

    private void openAndClosePanel(SearchResultShoKaishuKanriDiv searchResultDiv) {
        DataGrid<dgShoKaishuJokyo_Row> grid = searchResultDiv.getSearchResultShoKaishuJokyoList().getDgShoKaishuJokyo();
        if (grid.getDataSource().isEmpty()) {
//            searchResultDiv.setIsOpen(false);
        } else {
            searchResultDiv.setIsOpen(true);
        }
    }
}
