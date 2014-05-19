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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * NinteichosaResultEntryTargetDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultEntryTarget {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultsInputDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onLoad(NinteichosaResultEntryTargetDiv div) {
        ResponseData<NinteichosaResultEntryTargetDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("NinteichosaResultEntryTarget.yml"));
        div.getDgNinteichosaResultTaishosha().setDataSource(toListOfDataSource(targetSource));

        response.data = div;
        return response;
    }

    private List<dgNinteichosaResultTaishosha_Row> toListOfDataSource(List<? extends Map> data) {
        List<dgNinteichosaResultTaishosha_Row> list = new ArrayList<>();
        for (Map map : data) {
            list.add(toDgNinteichosaResultTaishosha_Row(map));
        }
        return list;
    }

    private dgNinteichosaResultTaishosha_Row toDgNinteichosaResultTaishosha_Row(Map map) {
        RString shimei = new RString(map.get("氏名").toString());
        RString kanaShimei = new RString(map.get("カナ氏名").toString());
        return new dgNinteichosaResultTaishosha_Row(new Button(),
                new RString(map.get("被保番号").toString()),
                new RString(map.get("保険者番号").toString()),
                shimei,
                kanaShimei,
                DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                toTextBoxFlexibleDate(new FlexibleDate(map.get("申請日").toString())),
                new RString(map.get("申請区分").toString()),
                toTextBoxFlexibleDate(new FlexibleDate(map.get("調査依頼日").toString())),
                toTextBoxFlexibleDate(new FlexibleDate(map.get("生年月日").toString())),
                new RString(map.get("性別").toString()),
                new RString(map.get("郵便番号").toString()),
                new RString(map.get("住所").toString()),
                toTextBoxFlexibleDate(new FlexibleDate(map.get("受付日").toString())),
                toTextBoxFlexibleDate(new FlexibleDate(map.get("データ入力日").toString())));
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
