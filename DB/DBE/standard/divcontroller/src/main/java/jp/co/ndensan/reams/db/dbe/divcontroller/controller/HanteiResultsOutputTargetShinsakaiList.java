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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.HanteiResultsOutputTargetShinsakaiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.dgShinsakaiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査会判定結果一覧出力時に、対象となる審査会を検索するDviを制御します。
 *
 * @author N1013 松本直樹
 */
public class HanteiResultsOutputTargetShinsakaiList {

    /**
     * 抽出するボタンをクリックした際、対象となる認定審査会一覧を設定します。
     *
     * @param div 対象審査会一覧Div
     * @return ResponsData
     */
    public ResponseData onClick_btnToExtract(HanteiResultsOutputTargetShinsakaiListDiv div) {
        ResponseData<HanteiResultsOutputTargetShinsakaiListDiv> response = new ResponseData<>();

        div.getDgShinsakaiList().setDataSource(createRowShinsakaiListTestData());

        response.data = div;
        return response;
    }

    private List<dgShinsakaiList_Row> createRowShinsakaiListTestData() {
        List<dgShinsakaiList_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("dbe5030003/HanteiResultsOutputTargetShinsakaiList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiList_Row(info));
        }

        return arrayData;
    }

    private dgShinsakaiList_Row toDgShinsakaiList_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString kaisaiNo = cg.getAsRString("開催番号");
        TextBoxFlexibleDate kaisaiDate = cg.getAsTextBoxFlexibleDate("開催日");
        RString gogitaiNo = new RString("00001");
        RString gogitaiMeisho = cg.getAsRString("合議体名称");
        RString kaisaiBasho = cg.getAsRString("開催場所");
        RString yoteiTeiin = cg.getAsRString("予定定員");
        RString wariateNinzu = cg.getAsRString("割当済人数");
        RString startTime = cg.getAsRString("開始時間");
        RString endTime = cg.getAsRString("終了時間");

        Button btn = new Button();
        dgShinsakaiList_Row row = new dgShinsakaiList_Row(btn, kaisaiNo, kaisaiDate, gogitaiNo, gogitaiMeisho, kaisaiBasho, yoteiTeiin, wariateNinzu,
                startTime, endTime);
        return row;
    }

}
