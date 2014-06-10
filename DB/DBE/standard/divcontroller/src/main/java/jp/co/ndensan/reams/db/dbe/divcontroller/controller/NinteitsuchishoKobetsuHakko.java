/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.NinteitsuchishoKobetsuHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 認定通知書個別発行指示画面の検索指示と印刷指示の設定を行います。
 *
 * @author N1013 松本直樹
 */
public class NinteitsuchishoKobetsuHakko {

    /**
     * 画面ロード時の設定を行います。
     *
     * @param div 個別発行指示Div
     * @return ResponseData
     */
    public ResponseData onLoad(NinteitsuchishoKobetsuHakkoDiv div) {
        ResponseData<NinteitsuchishoKobetsuHakkoDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("DemoCity.yml"));
        Map map = targetSource.get(0);
        if (_toRString(map.get("保険者番号")).equalsIgnoreCase(new RString("152264"))) {
            div.getNinteitsuchishoKobetsuHakkoTargetSearch().getDdlHokensha().setSelectedItem(new RString("2"));
            div.getNinteitsuchishoKobetsuHakkoTargetList().getTxtHokenshaNo().setValue(_toRString(map.get("保険者番号")));
            div.getNinteitsuchishoKobetsuHakkoTargetList().getTxtHokensaName().setValue(_toRString(map.get("保険者名称")));
        } else {
            div.getNinteitsuchishoKobetsuHakkoTargetSearch().getDdlHokensha().setSelectedItem(new RString("1"));
            div.getNinteitsuchishoKobetsuHakkoTargetList().getTxtHokenshaNo().setValue(_toRString(map.get("保険者番号")));
            div.getNinteitsuchishoKobetsuHakkoTargetList().getTxtHokensaName().setValue(_toRString(map.get("保険者名称")));
        }

        List<KeyValueDataSource> keyList = new ArrayList<>();
        keyList.add(new KeyValueDataSource(new RString("1"), new RString("男")));
        keyList.add(new KeyValueDataSource(new RString("2"), new RString("女")));
        div.getNinteitsuchishoKobetsuHakkoTargetSearch().getHihokensha().getChkGender().setSelectedItems(keyList);
        div.getNinteitsuchishoKobetsuHakkoTargetSearch().getHihokensha().getTxtHihokenshaNo().setValue(RString.EMPTY);

        response.data = div;
        return response;
    }

    /**
     * 「検索する」ボタン押下時の処理を表します。
     *
     * @param div 個別発行指示Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToSearch(NinteitsuchishoKobetsuHakkoDiv div) {
        ResponseData<NinteitsuchishoKobetsuHakkoDiv> response = new ResponseData<>();
        RString ymlFile;

        if (div.getNinteitsuchishoKobetsuHakkoTargetSearch().getHihokensha().getTxtHihokenshaNo().getValue().equalsIgnoreCase(RString.EMPTY)) {
            ymlFile = new RString("NinteitsuchishoKobetsuHakkoTargetList_All.yml");
        } else {
            ymlFile = new RString("NinteitsuchishoKobetsuHakkoTargetList_Kobetsu.yml");
        }

        div.getNinteitsuchishoKobetsuHakkoTargetList().getDgSearchResult().setDataSource(createRowSearchResultTestData(ymlFile));

        response.data = div;
        return response;
    }

    private List<dgSearchResult_Row> createRowSearchResultTestData(RString ymlFile) {
        List<dgSearchResult_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(ymlFile);
        for (Map info : targetSource) {
            arrayData.add(toDgSearchResult_Row(info));
        }

        return arrayData;
    }

    private dgSearchResult_Row toDgSearchResult_Row(Map map) {
        RString shikibetsuCode = _toRString(map.get("識別コード"));
        RString hihokenshaNo = _toRString(map.get("被保険者番号"));
        RString shimei = _toRString(map.get("漢字氏名"));
        RString kanaShimei = _toRString(map.get("カナ氏名"));
        RString shimeiAndKanaShimei = _toRString(map.get("氏名"));
        RString gender = _toRString(map.get("性別"));
        TextBoxFlexibleDate birthDay = toTextBoxFlexibleDate(new FlexibleDate(map.get("誕生日").toString()));
        TextBoxFlexibleDate shinseiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("申請日").toString()));
        RString shinseiKubunShinsei = _toRString(map.get("申請区分申請"));
        RString shinseiKubunHorei = _toRString(map.get("申請区分法令"));
        TextBoxFlexibleDate ninteiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("認定日").toString()));
        RString yokaigodo = _toRString(map.get("要介護度"));
        RString yukokikan = _toRString(map.get("有効期間月数"));
        TextBoxFlexibleDate startDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("有効期間開始日").toString()));
        TextBoxFlexibleDate endDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("有効期間終了日").toString()));

        dgSearchResult_Row row = new dgSearchResult_Row(shikibetsuCode, hihokenshaNo, shimei,
                kanaShimei, shimeiAndKanaShimei, gender, birthDay, shinseiDate, shinseiKubunShinsei, shinseiKubunHorei, ninteiDate,
                yokaigodo, yukokikan, startDate, endDate);
        return row;
    }

    private RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
