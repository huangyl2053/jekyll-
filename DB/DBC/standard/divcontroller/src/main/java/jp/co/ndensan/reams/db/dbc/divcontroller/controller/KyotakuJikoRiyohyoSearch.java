/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000.KyotakuJikoRiyohyoSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoRiyohyoSearch {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeSearch.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoSearchDiv panel) {
        ResponseData<KyotakuJikoRiyohyoSearchDiv> response = new ResponseData<>();
        setHihokenshaSearchData(panel);
        response.data = panel;
        return response;
    }

    private void setHihokenshaSearchData(KyotakuJikoRiyohyoSearchDiv panel) {
        HihokenshaFinderDiv finder = panel.getKyotakuJikoRiyohyoHihokenshaFinder();
        SearchCriteriaOfHihokenshaDiv hihokensha = finder.getSearchCriteriaOfHihokensha();
        SearchCriteriaOfKojinDiv kojin = finder.getSearchCriteriaOfKojin();

        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        hihokensha.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));

//        kojin.getTxtShikibetsuCode().setValue(cg.getAsRString("識別コード"));
        kojin.getTxtSetaiCode().setValue(cg.getAsRString("世帯コード"));
        kojin.getTxtKojinNo().setValue(cg.getAsRString("個人番号"));
        kojin.getDdlJuminShubetsu().setSelectedItem(cg.getAsRString("住民種別"));
        kojin.getTxtShimei().setValue(cg.getAsRString("氏名"));
////        kojin.getRadSearchPatternOfShimei().setSelectedItem(cg.getAsRString("検索条件"));
////        kojin.getTxtYubinNo().setValue(cg.getAsYubinNo("郵便番号"));
////        kojin.getTxtBirthDay().setValue(cg.getAsFlexibleDate("生年月日"));
        kojin.getTxtJusho().setValue(cg.getAsRString("住所"));
    }
}
