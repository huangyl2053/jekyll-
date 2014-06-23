/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 居宅サービス自己作成届出情報登録の該当者検索のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoTodokedeSearch {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeSearch.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoTodokedeSearchDiv panel) {
        ResponseData<KyotakuJikoTodokedeSearchDiv> response = new ResponseData<>();
        setHihokenshaSearchData(panel);
        panel.getKyotakuJikoTodokedeHihokenshaFinder().setIsOpen(true);
        panel.getKyotakuJikoTodokedeHihokenshaList().setIsOpen(false);
        response.data = panel;
        return response;
    }

    private void setHihokenshaSearchData(KyotakuJikoTodokedeSearchDiv panel) {
        HihokenshaFinderDiv finder = panel.getKyotakuJikoTodokedeHihokenshaFinder();
        SearchCriteriaOfHihokenshaDiv hihokensha = finder.getSearchCriteriaOfHihokensha();
        SearchCriteriaOfKojinDiv kojin = finder.getSearchCriteriaOfKojin();

        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
//        hihokensha.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));

////        kojin.getTxtShikibetsuCode().setValue(cg.getAsRString("識別コード"));
//        kojin.getTxtSetaiCode().setValue(cg.getAsRString("世帯コード"));
//        kojin.getTxtKojinNo().setValue(cg.getAsRString("個人番号"));
//        kojin.getDdlJuminShubetsu().setSelectedItem(cg.getAsRString("住民種別"));
//        kojin.getTxtShimei().setValue(cg.getAsRString("氏名"));
////        kojin.getRadSearchPatternOfShimei().setSelectedItem(cg.getAsRString("検索条件"));
////        kojin.getTxtYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
////        kojin.getTxtBirthDay().setValue(cg.getAsFlexibleDate("生年月日"));
//        kojin.getTxtJusho().setValue(cg.getAsRString("住所"));
    }

    /**
     * 検索するボタン押下時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBtnToSearch(KyotakuJikoTodokedeSearchDiv panel) {
        ResponseData<KyotakuJikoTodokedeSearchDiv> response = new ResponseData<>();
        setHihokenshaListData(panel);
        panel.getKyotakuJikoTodokedeHihokenshaFinder().setIsOpen(false);
        panel.getKyotakuJikoTodokedeHihokenshaList().setIsOpen(true);
        response.data = panel;
        return response;
    }

    /**
     * 再検索するボタン押下時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBtnToResearch(KyotakuJikoTodokedeSearchDiv panel) {
        ResponseData<KyotakuJikoTodokedeSearchDiv> response = new ResponseData<>();
        SearchResultOfHihokenshaDiv hihokensha = panel.getKyotakuJikoTodokedeHihokenshaList();
        List<dgSearchResult_Row> dgList = hihokensha.getDgSearchResult().getDataSource();
        dgList.clear();
        hihokensha.getDgSearchResult().setDataSource(dgList);
        panel.getKyotakuJikoTodokedeHihokenshaFinder().setIsOpen(true);
        panel.getKyotakuJikoTodokedeHihokenshaList().setIsOpen(false);
        response.data = panel;
        return response;
    }

    private void setHihokenshaListData(KyotakuJikoTodokedeSearchDiv panel) {
        SearchResultOfHihokenshaDiv hihokensha = panel.getKyotakuJikoTodokedeHihokenshaList();
        List<dgSearchResult_Row> dgList = hihokensha.getDgSearchResult().getDataSource();
        dgList.clear();
        for (int index = 1; index < 3; index++) {
            dgList.add(createHihokenshaData(index));
        }
        hihokensha.getDgSearchResult().setDataSource(dgList);
    }

    private dgSearchResult_Row createHihokenshaData(int index) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(index));
        dgSearchResult_Row row = new dgSearchResult_Row(
                new Button(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxDate(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        row.setHihokenshaNo(cg.getAsRString("被保番号"));
        row.setShikibetsuCode(cg.getAsRString("識別コード"));
        row.setHihokenshaKubun(cg.getAsRString("被保険者区分"));
        row.setShimei(cg.getAsRString("氏名"));
        row.setKanaShimsei(cg.getAsRString("カナ氏名"));
        row.setShimeiAndKanaShimsei(cg.getAsRString("氏名カナ氏名"));
        row.setGender(cg.getAsRString("性別"));
        row.getBirthDay().setValue(cg.getAsRDate("生年月日"));
        row.setYubinNo(cg.getAsRString("郵便番号"));
        row.setJusho(cg.getAsRString("住所"));
        row.setKojinNo(cg.getAsRString("個人番号"));
        row.setJuminShubetsu(cg.getAsRString("住民種別"));
        row.setSetaiCode(cg.getAsRString("世帯コード"));
        return row;
    }
}
