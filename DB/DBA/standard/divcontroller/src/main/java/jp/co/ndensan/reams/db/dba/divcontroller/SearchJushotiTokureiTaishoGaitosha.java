/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SearchJushotiTokureiTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgJushochiTokureiTaishoGaitosha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 住所地特例対象を検索した際、検索条件に合致したものを表示するパネルのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class SearchJushotiTokureiTaishoGaitosha {

    private static final RString DATA_SOURCE = new RString("dba/demoData/JushochiTokureiTaishosha.yml");

    /**
     * 住所地特例対象者検索ボタンを押した際に動作するメソッドです。 検索条件に該当した対象者をグリッドに表示します。
     *
     * @param div SearchJushotiTokureiTaishoGaitoshaDiv
     * @return レスポンスデータ
     */
    public ResponseData onClick_btnSearchJushochiTokureiTaishosha(SearchJushotiTokureiTaishoGaitoshaDiv div) {
        ResponseData<SearchJushotiTokureiTaishoGaitoshaDiv> response = new ResponseData<>();
        setGrid(div.getDgJushochiTokureiTaishoGaitosha());
        response.data = div;
        return response;
    }

    private void setGrid(DataGrid<dgJushochiTokureiTaishoGaitosha_Row> grid) {
        List<dgJushochiTokureiTaishoGaitosha_Row> list = new ArrayList<>();
        dgJushochiTokureiTaishoGaitosha_Row item;

        List<HashMap> demoDataList = YamlLoader.loadAsList(DATA_SOURCE);
        HashMap demoData = demoDataList.get(0);

        item = setGridRow(demoData);
        list.add(item);

        grid.setDataSource(list);
    }

    private dgJushochiTokureiTaishoGaitosha_Row setGridRow(Map demoData) {
        dgJushochiTokureiTaishoGaitosha_Row row = new dgJushochiTokureiTaishoGaitosha_Row(RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setAge(new RString(demoData.get("年齢").toString()));
        row.getDateOfBirth().setValue(new FlexibleDate(demoData.get("生年月日").toString()));
        row.setGender(new RString(demoData.get("性別").toString()));
        row.setHihokenshaNo(new RString(demoData.get("被保番号").toString()));
        row.setJusho(new RString(demoData.get("住所").toString()));
        row.setShimei(new RString(demoData.get("氏名").toString()));

        return row;
    }
}
