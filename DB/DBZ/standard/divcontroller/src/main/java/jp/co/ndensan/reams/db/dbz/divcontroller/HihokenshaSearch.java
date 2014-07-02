/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbzu020001.HihokenshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 被保険者個人の検索を行う、共有親Divに対応したコントローラです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaSearch {

    private static final RString SHIKAKU_KANRI_TAISHOSHA = new RString("DBZU020001/ShikakuKanriTaishoshaData.yml");

    /**
     * 資格管理対象者の検索を行った際に実行されます。検索条件に該当する人物をグリッドに表示します。
     *
     * @param searchDiv 被保険者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToSearch(HihokenshaSearchDiv searchDiv) {
        ResponseData<HihokenshaSearchDiv> response = new ResponseData<>();

        List<HashMap> taishoshaDataList = YamlLoader.FOR_DBZ.loadAsList(SHIKAKU_KANRI_TAISHOSHA);
        List<dgSearchResult_Row> taishoshaList = new ArrayList<>();
        for (HashMap taishoshaData : taishoshaDataList) {
            taishoshaList.add(createShikakuKanriGaitosha(taishoshaData));
        }
        searchDiv.getTaishoshaList().getDgSearchResult().setDataSource(taishoshaList);

        if (taishoshaList.size() > 1) {
            searchDiv.getTaishoshaList().setIsOpen(true);
        }

        response.data = searchDiv;
        return response;
    }

    private dgSearchResult_Row createShikakuKanriGaitosha(HashMap taishoshaData) {
        dgSearchResult_Row row = new dgSearchResult_Row(new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxDate(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setHihokenshaNo(new RString(taishoshaData.get("被保番号").toString()));
        row.setShimei(new RString(taishoshaData.get("氏名").toString()));
        row.getBirthDay().setValue(new RDate(taishoshaData.get("生年月日").toString()));
        row.setGender(new RString(taishoshaData.get("性別").toString()));
        row.setJusho(new RString(taishoshaData.get("住所").toString()));
        row.setShikibetsuCode(new RString(taishoshaData.get("識別コード").toString()));
        row.setYubinNo(new RString(taishoshaData.get("郵便番号").toString()));
        row.setJusho(new RString(taishoshaData.get("住所").toString()));
        row.setJuminShubetsu(new RString(taishoshaData.get("住民種別").toString()));
        row.setSetaiCode(new RString(taishoshaData.get("世帯コード").toString()));
        return row;
    }

    /**
     * 該当者グリッドから対象を選んだ際に実行されます。ViewStateに選択した対象の識別コードを渡します。
     *
     * @param searchDiv 被保険者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(HihokenshaSearchDiv searchDiv) {
        ResponseData<HihokenshaSearchDiv> response = new ResponseData<>();

        RString nowSelectShikibetsuCode = searchDiv.getTaishoshaList().getDgSearchResult().getClickedItem().getShikibetsuCode();
        ViewStateHolder.put("shikibetsuCode", nowSelectShikibetsuCode);

        response.data = searchDiv;
        return response;
    }
}
