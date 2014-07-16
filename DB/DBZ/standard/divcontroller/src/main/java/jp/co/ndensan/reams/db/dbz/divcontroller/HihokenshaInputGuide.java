/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshainputguide.HihokenshaInputGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshainputguide.dgSearchResultOfHihokensha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 被保険者入力補助ダイアログに対応するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaInputGuide {

    private final static RString HIHOKENSHA_DATA = new RString("hihokenshaInputGuide/HihokenshaData.yml");

    /**
     * 被保険者入力補助ガイドの初期処理を表示します。
     *
     * @param inputGuideDiv 被保険者入力補助ガイド
     * @return レスポンス
     */
    public ResponseData onLoad(HihokenshaInputGuideDiv inputGuideDiv) {
        ResponseData<HihokenshaInputGuideDiv> response = new ResponseData<>();

        List<HashMap> yamlDataList = YamlLoader.DBZ.loadAsList(HIHOKENSHA_DATA);
        HashMap hashMap = yamlDataList.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //検索キー氏名の初期値設定
        inputGuideDiv.getHihokenshaFinder().getKaigoAtenaFinder().getTxtAtenaMeisho().
                setValue(ymlData.getAsRString("検索条件氏名"));

        //前方一致を初期選択とする
        inputGuideDiv.getHihokenshaFinder().getKaigoAtenaFinder().getDdlAtenaSearchKubun().
                setSelectedItem(new RString("1"));

        response.data = inputGuideDiv;
        return response;
    }

    /**
     * 検索ボタンを押した際に実行されます。<br/>
     * 該当者一覧に、検索条件に該当した被保険者の情報を表示します。
     *
     * @param inputGuideDiv 被保険者入力補助ガイド
     * @return レスポンス
     */
    public ResponseData onClickBtnToSearch_HihokenshaFinder(HihokenshaInputGuideDiv inputGuideDiv) {
        ResponseData<HihokenshaInputGuideDiv> response = new ResponseData<>();

        setSearchResult(inputGuideDiv.getDgSearchResultOfHihokensha());

        response.data = inputGuideDiv;
        return response;
    }

    private void setSearchResult(DataGrid<dgSearchResultOfHihokensha_Row> dgSearchResult) {
        List<HashMap> yamlDataList = YamlLoader.DBZ.loadAsList(HIHOKENSHA_DATA);
        yamlDataList.remove(0);
        List<dgSearchResultOfHihokensha_Row> hihokenshaSearchResultList = new ArrayList<>();
        for (HashMap yamlData : yamlDataList) {
            ControlGenerator generator = new ControlGenerator(yamlData);
            hihokenshaSearchResultList.add(createSearchResultRow(generator));
        }
        dgSearchResult.setDataSource(hihokenshaSearchResultList);
    }

    private dgSearchResultOfHihokensha_Row createSearchResultRow(ControlGenerator generator) {
        dgSearchResultOfHihokensha_Row row = new dgSearchResultOfHihokensha_Row(new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY);

        row.setShikibetsuCode(generator.getAsRString("識別コード"));
        row.setHihokenshaNo(generator.getAsRString("被保番号"));
        row.setHihokenshaKubun(generator.getAsRString("被保区分"));
        row.setShimei(generator.getAsRString("氏名"));
        row.setKanaShimsei(generator.getAsRString("カナ氏名"));
        row.setShimeiAndKanaShimsei(row.getShimei().concat(row.getKanaShimsei()));
        row.setGender(generator.getAsRString("性別"));
        row.setBirthDay(generator.getAsTextBoxDate("生年月日"));
        row.setYubinNo(generator.getAsRString("郵便番号"));
        row.setJusho(generator.getAsRString("住所"));
        row.setJuminShubetsu(generator.getAsRString("住民種別"));
        row.setSetaiCode(generator.getAsRString("世帯コード"));
        return row;
    }

    /**
     * 該当者グリッドに表示された被保険者から、一人選択した際に実行されます。<br/>
     * ダイアログの呼び出し元に渡す情報を設定します。
     *
     * @param inputGuideDiv 被保険者入力補助ガイド
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(HihokenshaInputGuideDiv inputGuideDiv) {
        ResponseData<HihokenshaInputGuideDiv> response = new ResponseData<>();

        dgSearchResultOfHihokensha_Row clickRow = inputGuideDiv.getDgSearchResultOfHihokensha().getClickedItem();
        inputGuideDiv.setHihokenshaNo(clickRow.getHihokenshaNo());
        inputGuideDiv.setHihokenshaMeisho(clickRow.getShimei());

        response.data = inputGuideDiv;
        return response;
    }

}
