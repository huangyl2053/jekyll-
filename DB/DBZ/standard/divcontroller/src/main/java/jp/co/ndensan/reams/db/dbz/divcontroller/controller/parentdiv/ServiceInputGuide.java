/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.serviceInputGuide.ServiceInputGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.serviceInputGuide.dgSearchResultService_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 *
 * @author N8187 久保田 英男
 */
public class ServiceInputGuide {

    private static final RString SERVICE_DATA_SOURCE = new RString("serviceInputGuide/serviceData.yml");
    private static final RString SERVICE_MONTH_SOURCE = new RString("serviceInputGuide/serviceMonth.yml");

    /**
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData onLoad(ServiceInputGuideDiv div) {
        ResponseData<ServiceInputGuideDiv> response = new ResponseData<>();

        ControlGenerator cg = new ControlGenerator(YamlLoader.DBZ.loadAsList(SERVICE_MONTH_SOURCE).get(0));
        div.getTxtKijyunYM().setValue(cg.getAsRDate("基準年月"));
        response.data = div;
        return response;
    }

    /**
     * サービスの検索を行い、グリッドに表示します。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData onClick_btnSearchJigyosha(ServiceInputGuideDiv div) {
        ResponseData<ServiceInputGuideDiv> response = new ResponseData<>();

        DataGrid<dgSearchResultService_Row> grid = div.getSearchResultService().getDgSearchResultService();
//        RString 条件 = div.getTxtServiceShuruiCode().getValue();
//        setServiceList(grid, 条件);
        setServiceList(grid);

        response.data = div;
        return response;
    }

//    private void setServiceList(DataGrid<dgSearchResultService_Row> grid, RString 条件) {
    private void setServiceList(DataGrid<dgSearchResultService_Row> grid) {
        List<HashMap> jigyoshaList = YamlLoader.DBZ.loadAsList(SERVICE_DATA_SOURCE);
        List<dgSearchResultService_Row> searchResultJigyoshaList = new ArrayList<>();
        for (HashMap jigyosha : jigyoshaList) {
            searchResultJigyoshaList.add(createJigyoshaGridRow(jigyosha));
        }

        grid.setDataSource(searchResultJigyoshaList);
    }

    private dgSearchResultService_Row createJigyoshaGridRow(HashMap service) {
        dgSearchResultService_Row row = new dgSearchResultService_Row(new TextBoxCode(), RString.EMPTY);
        ControlGenerator cg = new ControlGenerator(service);
        row.getServiceCode().setValue(cg.getAsRString("サービスコード"));
        row.setServiceMeisho(cg.getAsRString("サービス名称"));
        return row;
    }

    /**
     * グリッド上からデータを一件選択した際に、ダイアログ呼び出し元に渡すデータを用意します。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData onSelectBySelectButton_SearchResultService(ServiceInputGuideDiv div) {
        ResponseData<ServiceInputGuideDiv> response = new ResponseData<>();

        dgSearchResultService_Row row = div.getSearchResultService().getDgSearchResultService().getClickedItem();
        div.setServiceCode(row.getServiceCode().getValue());
        div.setServiceMeisho(row.getServiceMeisho());
        div.setServiceCodeMeisho(row.getServiceCode().getValue().concat(new RString(":")).concat(row.getServiceMeisho()));

        response.data = div;
        return response;
    }

}
