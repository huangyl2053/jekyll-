/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.SearchShoKaishuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証回収記録管理対象者を検索するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class SearchShoKaishuKanri {

    private final static RString HIHOKENSHA_DATA = new RString("dbu0500011/HihokenshaData.yml");

    /**
     * 未発行検索条件画面の初期処理を表します。
     *
     * @param searchDiv SearchShoKaishuKanriDiv
     * @return ResponseData
     */
    public ResponseData<SearchShoKaishuKanriDiv> onLoad(SearchShoKaishuKanriDiv searchDiv) {
        ResponseData<SearchShoKaishuKanriDiv> response = new ResponseData<>();

        searchDiv.getTxtSearchHihokenshaMeisho().setValue(RString.EMPTY);
//        HashMap yamlData = YamlLoader.DBU.loadAsList(HIHOKENSHA_DATA).get(0);
//        ControlGenerator generator = new ControlGenerator(yamlData);
//        searchDiv.getTxtSearchHihokenshaNo().setValue(generator.getAsRString("被保番号"));
//        searchDiv.getTxtSearchHihokenshaMeisho().setValue(generator.getAsRString("氏名"));
        searchDiv.getRadSearchKohushoShurui().setSelectedItem(new RString("hihokenshasho"));

        response.data = searchDiv;
        return response;

    }

    /**
     * 検索対象の被保険者番号を入力し、フォーカスをはずした際に実行されます。<br/>
     * 入力した被保険者番号に対応する被保険者が存在していた場合
     *
     * @param searchDiv 証回収状況検索Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtSearchHihokenshaNo(SearchShoKaishuKanriDiv searchDiv) {
        ResponseData<SearchShoKaishuKanriDiv> response = new ResponseData<>();

        searchDiv.getTxtSearchHihokenshaMeisho().setValue(RString.EMPTY);
        List<HashMap> yamlDataList = YamlLoader.DBU.loadAsList(HIHOKENSHA_DATA);
        for (HashMap yamlData : yamlDataList) {
            ControlGenerator generator = new ControlGenerator(yamlData);
            RString hihokenshaNo = searchDiv.getTxtSearchHihokenshaNo().getValue();
            if (hihokenshaNo != null) {
                searchDiv.getTxtSearchHihokenshaMeisho().setValue(generator.getAsRString("氏名"));
            }
        }

        response.data = searchDiv;
        return response;
    }
}
