/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画作成依頼届出情報登録の個人検索条件のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeSearch {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeSearch.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuKeikakuTodokedeSearchDiv panel) {
        ResponseData<KyotakuKeikakuTodokedeSearchDiv> response = new ResponseData<>();
        setHihokenshaSearchData(panel);
        response.data = panel;
        return response;
    }

    private void setHihokenshaSearchData(KyotakuKeikakuTodokedeSearchDiv panel) {
        HihokenshaFinderDiv finder = panel.getKyotakuKeikakuTodokedeHihokenshaFinder();
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
