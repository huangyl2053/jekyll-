/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 障害者控除対象者認定書を個別発行する場合の発行対象者を検索する画面です。
 *
 * @author N3317 塚田 萌
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoSearchPanel {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 検索panel
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv> onLoad(ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv panel) {
        ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv> response = new ResponseData<>();

        setSearchCondition(panel);

        response.data = panel;
        return response;
    }

    /**
     * 検索ボタン押下時の処理です。
     *
     * @param panel 検索panel
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv> onClick_btnSearch(
            ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv panel) {
        ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv> response = new ResponseData<>();

        setSearchResultOfGaitosha(panel);

        response.data = panel;
        return response;
    }

    private void setSearchCondition(ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv panel) {
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4040011/ShogaishaKojoInformation.yml"));

        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        panel.getShogaishaKojoTaishoshaSearch().getSearchCriteriaOfKojin().
                getTxtShimei().setValue(cg.getAsRString("検索名"));
    }

    private void setSearchResultOfGaitosha(ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv panel) {
        panel.getShogaishaKojoTaishoshaList().
                getDgSearchResult().setDataSource(getSearchResultOfGaitoshaList());
    }

    private List<dgSearchResult_Row> getSearchResultOfGaitoshaList() {
        List<dgSearchResult_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4040011/SearchResultOfGaitosha.yml"));

        for (Map info : targetSource) {
            list.add(toDgSearchResult_Row(info));
        }
        return list;
    }

    private static dgSearchResult_Row toDgSearchResult_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);

        dgSearchResult_Row row = new dgSearchResult_Row(
                new Button(),
                cg.getAsRString("被保番号"),
                cg.getAsRString("識別コード"),
                cg.getAsRString("被保区分"),
                cg.getAsRString("氏名"),
                cg.getAsRString("カナ氏名"),
                cg.getAsRString("氏名とカナ"),
                cg.getAsRString("性別"),
                cg.getAsTextBoxDate("生年月日"),
                cg.getAsRString("郵便番号"),
                cg.getAsRString("住所"),
                cg.getAsRString("個人番号"),
                cg.getAsRString("住民種別"),
                cg.getAsRString("世帯コード")
        );
        return row;
    }
}
