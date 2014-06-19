/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 認定調査依頼登録対象者のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultEntryTargetsData {

    private static final RString FILE_NAME;

    static {
        FILE_NAME = new RString("dbe2060001/NinteichosaResultEntryTargets.yml");
    }

    public IDemoData<dgNinteichosaResultTaishosha_Row> get認定調査依頼登録対象者一覧() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(FILE_NAME);
        return new DemoData(dataFromYaml, new YamlUtil.Converter.IConverter<dgNinteichosaResultTaishosha_Row>() {

            @Override
            public dgNinteichosaResultTaishosha_Row exec(Map map) {
                return toDgNinteichosaResultTaishosha_Row(map);
            }

            private dgNinteichosaResultTaishosha_Row toDgNinteichosaResultTaishosha_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                RString shimei = cg.getAsRString("氏名");
                RString kanaShimei = cg.getAsRString("カナ氏名");
                return new dgNinteichosaResultTaishosha_Row(
                        new Button(),
                        cg.getAsRString("保険者番号"),
                        cg.getAsRString("保険者名"),
                        cg.getAsRString("被保番号"),
                        cg.getAsRString("識別コード"),
                        shimei,
                        kanaShimei,
                        DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsRString("申請区分"),
                        cg.getAsTextBoxFlexibleDate("調査依頼日"),
                        cg.getAsTextBoxFlexibleDate("調査実施日"),
                        cg.getAsTextBoxFlexibleDate("調査完了日"),
                        cg.getAsRString("調査委託先コード"),
                        cg.getAsRString("調査委託先名"),
                        cg.getAsRString("調査員コード"),
                        cg.getAsRString("調査員氏名"),
                        cg.getAsRString("実施場所区分"),
                        cg.getAsRString("実施場所その他"),
                        cg.getAsTextBoxFlexibleDate("誕生日"),
                        cg.getAsRString("性別"),
                        cg.getAsRString("郵便番号"),
                        cg.getAsRString("住所"),
                        cg.getAsTextBoxFlexibleDate("受付日"),
                        cg.getAsTextBoxFlexibleDate("データ入力日")
                );
            }
        });
    }
}
