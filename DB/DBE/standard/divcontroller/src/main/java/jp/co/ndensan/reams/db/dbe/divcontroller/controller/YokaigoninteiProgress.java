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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.SerchCriteriaForYokaigoninteiProgressDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.YokaigoninteiProgressDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.dgYokaigoninteiProgress_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 要介護認定進捗状況照会での検索結果画面の処理を表します。
 *
 * @author N1013 松本直樹
 */
public class YokaigoninteiProgress {

    /**
     * 進捗状況照会の検索指示画面にて「検索する」を押下した際の処理を表します。
     *
     * @param div 要介護認定進捗状況照会Div
     * @param searchDiv 要介護認定進捗状況検索条件指示Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToSearch(YokaigoninteiProgressDiv div,
            SerchCriteriaForYokaigoninteiProgressDiv searchDiv) {
        ResponseData<YokaigoninteiProgressDiv> response = new ResponseData<>();

        RString ymlFile;
        if (searchDiv.getRadSearchType().getSelectedItem().equalsIgnoreCase("2")) {
            ymlFile = new RString("dbe8010001/ShinchokuList.yml");
        } else {
            ymlFile = new RString("dbe8010001/ShinchokuKojin.yml");
        }

        div.getDgYokaigoninteiProgress().setDataSource(createRowSearchResultTestData(ymlFile));

        response.data = div;
        return response;
    }

    private List<dgYokaigoninteiProgress_Row> createRowSearchResultTestData(RString ymlFile) {
        List<dgYokaigoninteiProgress_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(ymlFile);
        for (Map info : targetSource) {
            arrayData.add(toDgYokaigoninteiProgress_Row(info));
        }

        return arrayData;
    }

    private dgYokaigoninteiProgress_Row toDgYokaigoninteiProgress_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString hokensha = cg.getAsRString("保険者");
        RString hihokenshaNo = cg.getAsRString("被保番号");
        RString shimei = cg.getAsRString("氏名");
        RString kanaShimei = cg.getAsRString("カナ氏名");
        RString shimeiAndKanaShimei = cg.getAsRString("漢字カナ氏名");
        RString shikaku = cg.getAsRString("資格");
        TextBoxFlexibleDate shinseiDate = cg.getAsTextBoxFlexibleDate("申請日");
        RString shinseiKubun = cg.getAsRString("申請区分");
        RString chosaIrai = cg.getAsRString("調査依頼");
        RString chosaJisshi = cg.getAsRString("調査実施");
        RString tokkiJisshi = cg.getAsRString("特記実施");
        RString shujiiIrai = cg.getAsRString("主治医依頼");
        RString shujiiJuryo = cg.getAsRString("主治医受領");
        RString ichijiHantei = cg.getAsRString("一次判定実施");
        RString shinsakaiWariate = cg.getAsRString("審査会割当");
        RString shinsakaiJissi = cg.getAsRString("審査会実施");
        TextBoxFlexibleDate chosaIraiDate = cg.getAsTextBoxFlexibleDate("調査依頼日");
        TextBoxFlexibleDate chosaJuryoDate = cg.getAsTextBoxFlexibleDate("調査受領日");
        RString itakusaki = cg.getAsRString("委託先");
        RString chosaIn = cg.getAsRString("調査員");
        TextBoxFlexibleDate ikenshoIraiDate = cg.getAsTextBoxFlexibleDate("意見書依頼日");
        TextBoxFlexibleDate ikenshoJuryoDate = cg.getAsTextBoxFlexibleDate("意見書受領日");
        RString iryoKikan = cg.getAsRString("医療機関");
        RString shujii = cg.getAsRString("主治医");
        TextBoxFlexibleDate ichijiHanteiDate = cg.getAsTextBoxFlexibleDate("一次判定日");
        TextBoxFlexibleDate ichijiHanteiKanryoDate = cg.getAsTextBoxFlexibleDate("一次判定完了日");
        RString ichijiHanteiResult = cg.getAsRString("一次判定結果");
        TextBoxFlexibleDate shinsakaiWariateDate = cg.getAsTextBoxFlexibleDate("審査会割当日");
        TextBoxFlexibleDate shinsakaiYoteiDate = cg.getAsTextBoxFlexibleDate("審査会予定日");
        TextBoxFlexibleDate shinsakaiKaisaiDate = cg.getAsTextBoxFlexibleDate("審査会開催日");
        RString shinsakaiKaisaiNo = cg.getAsRString("審査会開催番号");
        RString gogitai = cg.getAsRString("合議体");
        RString yokaigodo = cg.getAsRString("要介護度");
        RString yubinNo = cg.getAsRString("郵便番号");
        RString jusho = cg.getAsRString("住所");
        RString sex = cg.getAsRString("性別");
        TextBoxFlexibleDate umareDate = cg.getAsTextBoxFlexibleDate("生年月日");

        dgYokaigoninteiProgress_Row row = new dgYokaigoninteiProgress_Row(hokensha, hihokenshaNo, shimei,
                kanaShimei, shimeiAndKanaShimei, shikaku, shinseiDate, shinseiKubun, chosaIrai, chosaJisshi,
                tokkiJisshi, shujiiIrai, shujiiJuryo, ichijiHantei, shinsakaiWariate, shinsakaiJissi,
                chosaIraiDate, chosaJuryoDate, itakusaki, chosaIn, ikenshoIraiDate, ikenshoJuryoDate,
                iryoKikan, shujii, ichijiHanteiDate, ichijiHanteiKanryoDate, ichijiHanteiResult,
                shinsakaiWariateDate, shinsakaiYoteiDate, shinsakaiKaisaiDate, shinsakaiKaisaiNo,
                gogitai, yokaigodo, yubinNo, jusho, sex, umareDate);
        return row;
    }

}
