/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 給付費貸付金申請登録 該当者検索のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KashitsukeShinseiSearch {

    private static final RString YML_SEARCH = new RString("dbc1800000/SearchData.yml");
    private static final RString YML_SEARCH_RESULT = new RString("dbc1800000/SearchResultData.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiSearchDiv> onLoad(KashitsukeShinseiSearchDiv panel) {
        ResponseData<KashitsukeShinseiSearchDiv> response = new ResponseData<>();

        setSerachInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 該当者検索時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiSearchDiv> onClick_btnSearch(KashitsukeShinseiSearchDiv panel) {
        ResponseData<KashitsukeShinseiSearchDiv> response = new ResponseData<>();

        setSearchResultInfo(panel);

        response.data = panel;
        return response;
    }

    // Yamlデータを取得する
    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBC.loadAsList(yamlName);
    }

    // 検索条件情報を設定する
    private void setSerachInfo(KashitsukeShinseiSearchDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYamlData(YML_SEARCH).get(0));
        SearchCriteriaOfKojinDiv kojinDiv = panel.getKashitsukeShinseiSearchInfo().getSearchCriteriaOfKojin();
        kojinDiv.getTxtShimei().setValue(cg.getAsRString("氏名"));
    }

    // 該当者一覧情報を設定する
    private void setSearchResultInfo(KashitsukeShinseiSearchDiv panel) {
        List<HashMap> mapList = getYamlData(YML_SEARCH_RESULT);
        List<dgSearchResult_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            ControlGenerator cg = new ControlGenerator(mapList.get(index));
            list.add(createSearchResultRow(
                    cg.getAsRString("被保番号"),
                    cg.getAsRString("識別コード"),
                    cg.getAsRString("被保険者区分"),
                    cg.getAsRString("氏名"),
                    cg.getAsRString("氏名"),
                    cg.getAsRString("氏名"),
                    cg.getAsRString("性別"),
                    cg.getAsTextBoxDate("生年月日"),
                    cg.getAsRString("郵便番号"),
                    cg.getAsRString("住所"),
                    RString.EMPTY,
                    cg.getAsRString("住民種別"),
                    cg.getAsRString("世帯コード")
            ));
        }
        panel.getKashitsukeShinseiSearchResultInfo().getDgSearchResult().setDataSource(list);
    }

    // 該当者情報を作成する
    private dgSearchResult_Row createSearchResultRow(
            RString hihokenshaNo,
            RString shikibetsuCode,
            RString hihokenshaKubun,
            RString shimei,
            RString kanaShimsei,
            RString shimeiAndKanaShimsei,
            RString gender,
            TextBoxDate birthDay,
            RString yubinNo,
            RString jusho,
            RString kojinNo,
            RString juminShubetsu,
            RString setaiCode) {
        birthDay.setReadOnly(true);
        return new dgSearchResult_Row(
                new Button(),
                hihokenshaNo,
                shikibetsuCode,
                hihokenshaKubun,
                shimei,
                kanaShimsei,
                shimeiAndKanaShimsei,
                gender,
                birthDay,
                yubinNo,
                jusho,
                kojinNo,
                juminShubetsu,
                setaiCode);
    }
}
