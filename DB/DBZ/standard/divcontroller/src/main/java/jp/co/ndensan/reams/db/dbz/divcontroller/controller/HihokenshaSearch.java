/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbzu020001.HihokenshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
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

    private static final RString SHIKAKU_KANRI_TAISHOSHA = new RString("DBZU020001/gaitoshaListData.yml");

    /**
     * 読み込まれた際に1度だけ実行されます。フローIDを元に、親Div名を設定します。
     *
     * @param searchDiv 被保険者検索Div
     * @return レスポンス
     */
    public ResponseData onLoad(HihokenshaSearchDiv searchDiv) {
        ResponseData<HihokenshaSearchDiv> response = new ResponseData<>();
        response.data = searchDiv;
        response.setRootTitle(RootTitleSetter.getTitle());
        return response;
    }

    /**
     * 資格管理対象者の検索を行った際に実行されます。検索条件に該当する人物をグリッドに表示します。
     *
     * @param searchDiv 被保険者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToSearch(HihokenshaSearchDiv searchDiv) {

        ResponseData<HihokenshaSearchDiv> response = new ResponseData<>();

        List<HashMap> taishoshaDataList = YamlLoader.DBZ.loadAsList(SHIKAKU_KANRI_TAISHOSHA);
        List<dgSearchResult_Row> taishoshaList = new ArrayList<>();
        for (HashMap taishoshaData : taishoshaDataList) {
            taishoshaList.add(createShikakuKanriGaitosha(new ControlGenerator(taishoshaData)));
        }

        searchDiv.getTaishoshaList()
                .getDgSearchResult().setDataSource(taishoshaList);

        if (taishoshaList.size() > 1) {
            searchDiv.getTaishoshaList().setIsOpen(true);
        }

        response.data = searchDiv;
        return response;
    }

    private dgSearchResult_Row createShikakuKanriGaitosha(ControlGenerator generator) {
        dgSearchResult_Row row = new dgSearchResult_Row(new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxDate(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setHihokenshaNo(generator.getAsRString("被保番号"));
        row.setShimei(generator.getAsRString("氏名"));
        row.setKanaShimsei(generator.getAsRString("カナ氏名"));
        row.setShimeiAndKanaShimsei(row.getKanaShimsei().concat("<br/>").concat(row.getShimei()));
        row.getBirthDay().setValue(generator.getAsRDate("生年月日"));
        row.setGender(generator.getAsRString("性別"));
        row.setJusho(generator.getAsRString("住所"));
        row.setShikibetsuCode(generator.getAsRString("識別コード"));
        row.setHihokenshaKubun(generator.getAsRString("被保区分"));
        row.setYubinNo(generator.getAsRString("郵便番号"));
        row.setJusho(generator.getAsRString("住所"));
        row.setJuminShubetsu(generator.getAsRString("住民種別"));
        row.setSetaiCode(generator.getAsRString("世帯コード"));
        return row;
    }

    /**
     * 該当者グリッドから対象を選んだ際に実行されます。ViewStateに選択した対象の識別コードと被保険者番号を渡します。
     *
     * @param searchDiv 被保険者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(HihokenshaSearchDiv searchDiv) {
        ResponseData<HihokenshaSearchDiv> response = new ResponseData<>();

        RString nowSelectShikibetsuCode = searchDiv.getTaishoshaList().getDgSearchResult().getClickedItem().getShikibetsuCode();
        RString nowSelectHihokenshaNo = searchDiv.getTaishoshaList().getDgSearchResult().getClickedItem().getHihokenshaNo();
        ViewStateHolder.put("shikibetsuCode", nowSelectShikibetsuCode);
        ViewStateHolder.put("hihokenshaNo", nowSelectHihokenshaNo);

        response.data = searchDiv;
        return response;
    }

    /**
     * 再検索ボタンが押下された際に実行されます。該当者一覧グリッドを初期化し、検索画面に戻ります。
     *
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToResearch(HihokenshaSearchDiv searchDiv) {
        ResponseData<HihokenshaSearchDiv> response = new ResponseData<>();

        searchDiv.getTaishoshaList().getDgSearchResult().setDataSource(Collections.EMPTY_LIST);

        response.data = searchDiv;
        return response;
    }
}
