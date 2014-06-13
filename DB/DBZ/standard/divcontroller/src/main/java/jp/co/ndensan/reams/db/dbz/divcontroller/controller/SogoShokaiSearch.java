/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.SogoShokaiSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 該当者検索のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class SogoShokaiSearch {

    private final RString YML_SEARCH = new RString("dbz0010000/SearchData.yml");
    private final RString YML_SEARCH_RESULT = new RString("dbz0010000/SearchResultData.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiSearchDiv> onLoad(SogoShokaiSearchDiv panel) {
        ResponseData<SogoShokaiSearchDiv> response = new ResponseData<>();

        HashMap map = YamlLoader.FOR_DBZ.loadAsList(YML_SEARCH).get(0);
        SearchCriteriaOfKojinDiv kojinDiv = panel.getSogoShokaiSearchInfo().getSearchCriteriaOfKojin();
        kojinDiv.getTxtShimei().setValue(new RString(map.get("氏名").toString()));
        kojinDiv.getRadSearchPatternOfShimei().setSelectedItem(new RString("key0"));

        response.data = panel;
        return response;
    }

    /**
     * 該当者検索時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<SogoShokaiSearchDiv> onClick_btnSearch(SogoShokaiSearchDiv panel) {
        ResponseData<SogoShokaiSearchDiv> response = new ResponseData<>();

        List<HashMap> mapList = YamlLoader.FOR_DBZ.loadAsList(YML_SEARCH_RESULT);
        List<dgSearchResult_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createSearchResultRow(
                    map.get("被保番号").toString(),
                    map.get("識別コード").toString(),
                    map.get("被保険者区分").toString(),
                    map.get("氏名").toString(),
                    map.get("氏名").toString(),
                    map.get("氏名").toString(),
                    map.get("性別").toString(),
                    map.get("生年月日").toString(),
                    map.get("郵便番号").toString(),
                    map.get("住所").toString(),
                    "",
                    map.get("住民種別").toString(),
                    map.get("世帯コード").toString()
            ));
        }
        panel.getSogoShokaiGaitoshaListInfo().getDgSearchResult().setDataSource(list);

        response.data = panel;
        return response;
    }

    // 該当者情報を作成する
    private dgSearchResult_Row createSearchResultRow(
            String hihokenshaNo,
            String shikibetsuCode,
            String hihokenshaKubun,
            String shimei,
            String kanaShimsei,
            String shimeiAndKanaShimsei,
            String gender,
            String birthDay,
            String yubinNo,
            String jusho,
            String kojinNo,
            String juminShubetsu,
            String setaiCode) {
        TextBoxDate tBirthDay = new TextBoxDate();
        tBirthDay.setValue(new RDate(birthDay));
        tBirthDay.setReadOnly(true);
        return new dgSearchResult_Row(
                new Button(),
                new RString(hihokenshaNo),
                new RString(shikibetsuCode),
                new RString(hihokenshaKubun),
                new RString(shimei),
                new RString(kanaShimsei),
                new RString(shimeiAndKanaShimsei),
                new RString(gender),
                tBirthDay,
                new RString(yubinNo),
                new RString(jusho),
                new RString(kojinNo),
                new RString(juminShubetsu),
                new RString(setaiCode));
    }
}
