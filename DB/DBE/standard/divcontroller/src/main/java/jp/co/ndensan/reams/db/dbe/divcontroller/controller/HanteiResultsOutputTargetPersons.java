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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.HanteiResultsOutputTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.dgShinsakaiTargetPersons_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
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
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5030003/HanteiResultsOutputTargetPersons.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiTargetPersons_Row(info));
        }

        return arrayData;
    }

    private dgShinsakaiTargetPersons_Row toDgShinsakaiTargetPersons_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString jun = cg.getAsRString("順");
        RString hokenshaNo = cg.getAsRString("保険者");
        RString hokenshaMeisho = cg.getAsRString("保険者名称");
        RString hihokenshaNo = cg.getAsRString("被保番号");
        RString hihokenshaKubun = cg.getAsRString("区分");
        RString shimei = cg.getAsRString("漢字氏名");
        RString kanaShimei = cg.getAsRString("カナ氏名");
        RString shimeiAndKanaShimei = cg.getAsRString("氏名");
        RString gender = cg.getAsRString("性別");
        TextBoxFlexibleDate shinseiDate = cg.getAsTextBoxFlexibleDate("申請日");
        RString shinseiKubun = cg.getAsRString("申請区分");
        RString ichijiHanteiResult = cg.getAsRString("一次判定結果");
        RString yokaigodo = cg.getAsRString("要介護度");
        RString yukokikan = cg.getAsRString("有効期間月数");
        TextBoxFlexibleDate startDate = cg.getAsTextBoxFlexibleDate("有効期間開始日");
        TextBoxFlexibleDate endDate = cg.getAsTextBoxFlexibleDate("有効期間終了日");
        RString latestYokaigodo = cg.getAsRString("前回要介護度");
        RString latestYukokikan = cg.getAsRString("前回有効期間");
        TextBoxFlexibleDate latestStartDate = cg.getAsTextBoxFlexibleDate("前回有効開始日");
        TextBoxFlexibleDate latestEndDate = cg.getAsTextBoxFlexibleDate("前回有効終了日");

        dgShinsakaiTargetPersons_Row row = new dgShinsakaiTargetPersons_Row(jun, hokenshaNo, hokenshaMeisho, hihokenshaNo, hihokenshaKubun, shimei,
                kanaShimei, shimeiAndKanaShimei, gender, shinseiDate, shinseiKubun, ichijiHanteiResult, yokaigodo, yukokikan, startDate, endDate,
                latestYokaigodo, latestYukokikan, latestStartDate, latestEndDate);
        return row;
    }

}
