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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
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
        ddlHokensha(div).setDataSource(new ArrayList<KeyValueDataSource>());

        RString key1 = new RString("1");
        RString densanTown = new RString("電算町");

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("DemoCity.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        if (!cg.getAsRString("保険者番号").equals(RString.EMPTY)) {

            RString key2 = new RString("2");
            RString hokenshaName = cg.getAsRString("保険者名称");
            ddlHokensha(div).getDataSource().add(new KeyValueDataSource(key2, hokenshaName));
            ddlHokensha(div).getDataSource().add(new KeyValueDataSource(key1, densanTown));

            ddlHokensha(div).setSelectedItem(key2);
        } else {
            ddlHokensha(div).getDataSource().add(new KeyValueDataSource(key1, densanTown));
            ddlHokensha(div).setSelectedItem(key1);
        }
//        keyList.add(new KeyValueDataSource(new RString("1"), new RString("男")));
//        keyList.add(new KeyValueDataSource(new RString("2"), new RString("女")));
//        div.getNinteitsuchishoKobetsuHakkoTargetSearch().getHihokensha().getChkGender().setSelectedItems(keyList);
        div.getNinteitsuchishoKobetsuHakkoTargetSearch().getHihokensha().getTxtHihokenshaNo().clearValue();

        response.data = div;
        return response;
    }

    private DropDownList ddlHokensha(NinteitsuchishoKobetsuHakkoDiv div) {
        return div.getNinteitsuchishoKobetsuHakkoTargetSearch().getDdlHokensha();
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
            ymlFile = new RString("dbe5040002/NinteitsuchishoKobetsuHakkoTargetList_All.yml");
        } else {
            ymlFile = new RString("dbe5040002/NinteitsuchishoKobetsuHakkoTargetList_Kobetsu.yml");
        }

        div.getNinteitsuchishoKobetsuHakkoTargetList().getDgSearchResult().setDataSource(createRowSearchResultTestData(ymlFile));

        response.data = div;
        return response;
    }

    private List<dgSearchResult_Row> createRowSearchResultTestData(RString ymlFile) {
        List<dgSearchResult_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(ymlFile);
        for (Map info : targetSource) {
            arrayData.add(toDgSearchResult_Row(info));
        }

        return arrayData;
    }

    private dgSearchResult_Row toDgSearchResult_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString shikibetsuCode = cg.getAsRString("識別コード");
        RString hihokenshaNo = cg.getAsRString("被保険者番号");
        RString shimei = cg.getAsRString("漢字氏名");
        RString kanaShimei = cg.getAsRString("カナ氏名");
        RString shimeiAndKanaShimei = cg.getAsRString("氏名");
        RString gender = cg.getAsRString("性別");
        TextBoxFlexibleDate birthDay = cg.getAsTextBoxFlexibleDate("誕生日");
        TextBoxFlexibleDate shinseiDate = cg.getAsTextBoxFlexibleDate("申請日");
        RString shinseiKubunShinsei = cg.getAsRString("申請区分申請");
        RString shinseiKubunHorei = cg.getAsRString("申請区分法令");
        TextBoxFlexibleDate ninteiDate = cg.getAsTextBoxFlexibleDate("認定日");
        RString yokaigodo = cg.getAsRString("要介護度");
        RString yukokikan = cg.getAsRString("有効期間月数");
        TextBoxFlexibleDate startDate = cg.getAsTextBoxFlexibleDate("有効期間開始日");
        TextBoxFlexibleDate endDate = cg.getAsTextBoxFlexibleDate("有効期間終了日");

        dgSearchResult_Row row = new dgSearchResult_Row(shikibetsuCode, hihokenshaNo, shimei,
                kanaShimei, shimeiAndKanaShimei, gender, birthDay, shinseiDate, shinseiKubunShinsei, shinseiKubunHorei, ninteiDate,
                yokaigodo, yukokikan, startDate, endDate);
        return row;
    }

}
