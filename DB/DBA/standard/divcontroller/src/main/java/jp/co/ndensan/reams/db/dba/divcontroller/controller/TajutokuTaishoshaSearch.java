/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011.TajutokuTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 他市町村住所地特例の処理を行う対象者を検索するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class TajutokuTaishoshaSearch {

    private static final RString GAITOSHA_DATA = new RString("DBA2040011/gaitoshaListData.yml");

    /**
     * 検索ボタンが押された際に実行されます。<br/>
     * 検索条件にしたがって対象者を検索し、その結果をグリッドに表示します。
     *
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToSearch(TajutokuTaishoshaSearchDiv searchDiv) {
        ResponseData<TajutokuTaishoshaSearchDiv> response = new ResponseData<>();

        setGaitoshaList(searchDiv.getSearchResult().getDgSearchResult());

        response.data = searchDiv;
        return response;
    }

    private void setGaitoshaList(DataGrid<dgSearchResult_Row> dgSearchResult) {
        List<dgSearchResult_Row> taishoshaList = new ArrayList<>();
        List<HashMap> yamlTaishoshaDataList = YamlLoader.DBA.loadAsList(GAITOSHA_DATA);
        for (HashMap yamlTaishoshaData : yamlTaishoshaDataList) {
            ControlGenerator generator = new ControlGenerator(yamlTaishoshaData);
            taishoshaList.add(craeteSearchResultRow(generator));
        }
        dgSearchResult.setDataSource(taishoshaList);
    }

    private dgSearchResult_Row craeteSearchResultRow(ControlGenerator generator) {
        dgSearchResult_Row row = new dgSearchResult_Row(new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY);

        row.setShikibetsuCode(generator.getAsRString("識別コード"));
        row.setHihokenshaNo(generator.getAsRString("被保番号"));
        row.setHihokenshaKubun(generator.getAsRString("被保区分"));
        row.setShimei(generator.getAsRString("氏名"));
        row.setKanaShimsei(generator.getAsRString("カナ氏名"));
        row.setShimeiAndKanaShimsei(row.getKanaShimsei().concat("<br/>").concat(row.getShimei()));
        row.setGender(generator.getAsRString("性別"));
        row.getBirthDay().setValue(generator.getAsRDate("生年月日"));
        row.setYubinNo(generator.getAsRString("郵便番号"));
        row.setJusho(generator.getAsRString("住所"));
        row.setJuminShubetsu(generator.getAsRString("住民種別"));
        row.setSetaiCode(generator.getAsRString("世帯コード"));
        row.setKojinNo(generator.getAsRString("個人番号"));
        return row;
    }

    /**
     * 再検索ボタンが押された際に実行されます。<br/>
     * グリッドに表示した検索結果を削除します。
     *
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToResearch(TajutokuTaishoshaSearchDiv searchDiv) {
        ResponseData<TajutokuTaishoshaSearchDiv> response = new ResponseData<>();

        resetGaitoshaList(searchDiv.getSearchResult().getDgSearchResult());

        response.data = searchDiv;
        return response;
    }

    private void resetGaitoshaList(DataGrid<dgSearchResult_Row> dgSearchResult) {
        dgSearchResult.setDataSource(Collections.EMPTY_LIST);
    }

}
