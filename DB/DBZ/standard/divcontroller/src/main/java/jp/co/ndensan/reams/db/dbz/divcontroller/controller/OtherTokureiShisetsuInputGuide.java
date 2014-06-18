/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.othertokureishisetsuinputguide.OtherTokureiShisetsuInputGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.othertokureishisetsuinputguide.dgSearchResultOtherTokureiShisetsu_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他特例施設を入力する際に使用する、入力補助のための共通子Divです。
 *
 * @author n8178 城間篤人
 */
public class OtherTokureiShisetsuInputGuide {

    private static final RString OTHER_SHISETSU_DATA_SOURCE = new RString("shisetsuJoho/otherShisetsuData.yml");

    /**
     * その他特例施設を検索し、その情報をグリッドに設定します。
     *
     * @param div OtherTokureiShisetsuInputGuideDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnSearchOtherShisetsu(OtherTokureiShisetsuInputGuideDiv div) {
        ResponseData<OtherTokureiShisetsuInputGuideDiv> response = new ResponseData<>();

        List<dgSearchResultOtherTokureiShisetsu_Row> otherShisetsuGridRowList = new ArrayList<>();
        if (div.getRadkannaiKubun().getSelectedValue().equals(new RString("管内"))) {
            otherShisetsuGridRowList.addAll(createOtherShisetsuGridRowList("管内"));
        } else if (div.getRadkannaiKubun().getSelectedValue().equals(new RString("管外"))) {
            otherShisetsuGridRowList.addAll(createOtherShisetsuGridRowList("管外"));
        } else {
            otherShisetsuGridRowList.addAll(createOtherShisetsuGridRowList("管内"));
            otherShisetsuGridRowList.addAll(createOtherShisetsuGridRowList("管外"));
        }

        div.getSearchResultOtherShisetsu().getDgSearchResultOtherTokureiShisetsu().setDataSource(otherShisetsuGridRowList);
        response.data = div;
        return response;
    }

    private List<dgSearchResultOtherTokureiShisetsu_Row> createOtherShisetsuGridRowList(String 検索条件) {
        List<dgSearchResultOtherTokureiShisetsu_Row> otherShisetsuGridRowList = new ArrayList<>();

        Map<String, List> 特例施設List = YamlLoader.DBZ.loadAsMap(OTHER_SHISETSU_DATA_SOURCE);
        List<HashMap> 検索結果List = 特例施設List.get(検索条件);

        for (HashMap 特例施設情報 : 検索結果List) {
            otherShisetsuGridRowList.add(createOtherShisetsuGridRow(特例施設情報));
        }
        return otherShisetsuGridRowList;
    }

    private dgSearchResultOtherTokureiShisetsu_Row createOtherShisetsuGridRow(Map 特例施設情報) {
        dgSearchResultOtherTokureiShisetsu_Row row = new dgSearchResultOtherTokureiShisetsu_Row(RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY);
        row.setJigyoshaCode(new RString(特例施設情報.get("事業者コード").toString()));
        row.setJigyoshaMeisho(new RString(特例施設情報.get("事業者名称").toString()));
        row.setJusho(new RString(特例施設情報.get("住所").toString()));
        row.setJigyosha(row.getJigyoshaCode()
                .concat(new RString(":"))
                .concat(row.getJigyoshaMeisho()));
        return row;
    }

    /**
     * グリッドから項目を一つ選んだ際に、ダイアログ呼び出し元に返す値を用意します。
     *
     * @param div OtherTokureiShisetsuInputGuideDiv
     * @return レスポンス
     */
    public ResponseData onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu(OtherTokureiShisetsuInputGuideDiv div) {
        ResponseData<OtherTokureiShisetsuInputGuideDiv> response = new ResponseData<>();

        dgSearchResultOtherTokureiShisetsu_Row row = div.getSearchResultOtherShisetsu().getDgSearchResultOtherTokureiShisetsu().getClickedItem();
        div.setShisetsuCode(row.getJigyoshaCode());
        div.setShisetsuMeisho(row.getJigyoshaMeisho());

        response.data = div;
        return response;
    }

}
