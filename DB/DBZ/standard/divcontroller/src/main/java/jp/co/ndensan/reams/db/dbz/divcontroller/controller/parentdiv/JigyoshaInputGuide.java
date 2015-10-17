/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.jigyoshainputguide.JigyoshaInputGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.jigyoshainputguide.dgSearchResultJigyosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author n8178 城間篤人
 */
public class JigyoshaInputGuide {

    private static final RString JIGYOSHA_DATA_SOURCE = new RString("shisetsuJoho/shisetsuData.yml");

    /**
     * 事業者の検索を行い、グリッドに表示します。
     *
     * @param div JigyoshaInputGuideDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnSearchJigyosha(JigyoshaInputGuideDiv div) {
        ResponseData<JigyoshaInputGuideDiv> response = new ResponseData<>();

        DataGrid<dgSearchResultJigyosha_Row> grid = div.getSearchResultJigyosha().getDgSearchResultJigyosha();
        RString 条件 = div.getTxtJigyoshaCode().getText();
        setJigyoshaList(grid, 条件);

        response.data = div;
        return response;
    }

    private void setJigyoshaList(DataGrid<dgSearchResultJigyosha_Row> grid, RString 条件) {
        List<HashMap> jigyoshaList = YamlLoader.DBZ.loadAsList(JIGYOSHA_DATA_SOURCE);
        List<dgSearchResultJigyosha_Row> searchResultJigyoshaList = new ArrayList<>();

        for (HashMap jigyosha : jigyoshaList) {
            RString jigyoshaCode = new RString(jigyosha.get("事業者コード").toString());
            if (jigyoshaCode.startsWith(条件)) {
                searchResultJigyoshaList.add(createJigyoshaGridRow(jigyosha));
            }
        }

        grid.setDataSource(searchResultJigyoshaList);
    }

    private dgSearchResultJigyosha_Row createJigyoshaGridRow(HashMap jigyosha) {
        dgSearchResultJigyosha_Row row = new dgSearchResultJigyosha_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY);
        row.setJigyoshaCode(new RString(jigyosha.get("事業者コード").toString()));
        row.setJigyoshaMeisho(new RString(jigyosha.get("事業者名称").toString()));
        row.setJigyosha(row.getJigyoshaCode()
                .concat(new RString(":"))
                .concat(row.getJigyoshaMeisho()));
        row.setJusho(new RString(jigyosha.get("住所").toString()));
        row.setKeigenTaisho(new RString(jigyosha.get("軽減対象").toString()));
        row.setService(new RString(jigyosha.get("サービス").toString()));
        row.getNinteiKaishiDate().setValue(new FlexibleDate(jigyosha.get("認定開始日").toString()));
        row.getNinteiShuryoDate().setValue(new FlexibleDate(jigyosha.get("認定終了日").toString()));
        return row;
    }

    /**
     * グリッド上からデータを一件選択した際に、ダイアログ呼び出し元に渡すデータを用意します。
     *
     * @param div JigyoshaInputGuideDiv
     * @return レスポンス
     */
    public ResponseData onSelectBySelectButton_dgSearchResultJigyosha(JigyoshaInputGuideDiv div) {
        ResponseData<JigyoshaInputGuideDiv> response = new ResponseData<>();

        dgSearchResultJigyosha_Row row = div.getSearchResultJigyosha().getDgSearchResultJigyosha().getClickedItem();
        div.setJigyoshaCode(row.getJigyoshaCode());
        div.setJigyoshaMeisho(row.getJigyoshaMeisho());
        div.setJigyoshaCodeMeisho(row.getJigyoshaCode().concat(new RString(":")).concat(row.getJigyoshaMeisho()));

        response.data = div;
        return response;
    }

}
