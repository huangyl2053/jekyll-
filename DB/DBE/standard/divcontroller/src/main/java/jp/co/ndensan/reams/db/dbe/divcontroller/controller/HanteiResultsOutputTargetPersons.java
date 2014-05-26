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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HanteiResultsOutputTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsakaiTargetPersons_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査会判定結果一覧出力時に、出力対象となる審査会の審査対象者一覧Dviを制御します。
 *
 * @author N1013 松本直樹
 */
public class HanteiResultsOutputTargetPersons {

    /**
     * Divが表示されたときの、初期値を設定します。
     *
     * @param personsDiv 審査対象者Div
     * @return ResponsData
     */
    public ResponseData onLoad_PersonsDiv(HanteiResultsOutputTargetPersonsDiv personsDiv) {
        ResponseData<HanteiResultsOutputTargetPersonsDiv> response = new ResponseData<>();

        personsDiv.getDgShinsakaiTargetPersons().setDataSource(createRowTargetPersonTestData());

        response.data = personsDiv;
        return response;
    }

    private List<dgShinsakaiTargetPersons_Row> createRowTargetPersonTestData() {
        List<dgShinsakaiTargetPersons_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("HanteiResultsOutputTargetPersons.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiTargetPersons_Row(info));
        }

        return arrayData;
    }

    private dgShinsakaiTargetPersons_Row toDgShinsakaiTargetPersons_Row(Map map) {
        RString jun = _toRString(map.get("順"));
        RString hokenshaNo = _toRString(map.get("保険者"));
        RString hokenshaMeisho = _toRString(map.get("保険者名称"));
        RString hihokenshaNo = _toRString(map.get("被保番号"));
        RString hihokenshaKubun = _toRString(map.get("区分"));
        RString shimei = _toRString(map.get("漢字氏名"));
        RString kanaShimei = _toRString(map.get("カナ氏名"));
        RString shimeiAndKanaShimei = _toRString(map.get("氏名"));
        RString gender = _toRString(map.get("性別"));
        TextBoxFlexibleDate shinseiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("申請日").toString()));
        RString shinseiKubun = _toRString(map.get("申請区分"));
        RString ichijiHanteiResult = _toRString(map.get("一次判定結果"));
        RString yokaigodo = _toRString(map.get("要介護度"));
        RString yukokikan = _toRString(map.get("有効期間月数"));
        TextBoxFlexibleDate startDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("有効期間開始日").toString()));
        TextBoxFlexibleDate endDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("有効期間終了日").toString()));
        RString latestYokaigodo = _toRString(map.get("前回要介護度"));
        RString latestYukokikan = _toRString(map.get("前回有効期間"));
        TextBoxFlexibleDate latestStartDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("前回有効開始日").toString()));
        TextBoxFlexibleDate latestEndDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("前回有効終了日").toString()));

        dgShinsakaiTargetPersons_Row row = new dgShinsakaiTargetPersons_Row(jun, hokenshaNo, hokenshaMeisho, hihokenshaNo, hihokenshaKubun, shimei,
                kanaShimei, shimeiAndKanaShimei, gender, shinseiDate, shinseiKubun, ichijiHanteiResult, yokaigodo, yukokikan, startDate, endDate,
                latestYokaigodo, latestYukokikan, latestStartDate, latestEndDate);
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
