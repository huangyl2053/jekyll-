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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * NinteichosaResultEntryTargetDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaResultEntryTarget {

    /**
     * ロード時の処理です。
     *
     * @param div NinteichosaResultEntryTargetDiv
     * @return ResponseData
     */
    public ResponseData<NinteichosaResultEntryTargetDiv> onLoad(NinteichosaResultEntryTargetDiv div) {
        ResponseData<NinteichosaResultEntryTargetDiv> response = new ResponseData<>();

        div.getDgNinteichosaResultTaishosha().setDataSource(_findTarget());

        response.data = div;
        return response;
    }

    private List<dgNinteichosaResultTaishosha_Row> _findTarget() {
        return new DemoData().get認定調査依頼登録対象者();
    }

    private static final class DemoData {

        /**
         * Demo用データの一覧です。
         */
        enum DemoDataType {

            認定調査結果登録対象者(new RString("NinteichosaResultTaishosha.yml"));
            private final RString thePath;

            private DemoDataType(RString fileName) {
                this.thePath = new RString("dbe2060001/" + fileName);
            }

            /**
             * YamlLeader用のパスを返します。
             *
             * @return thePath
             */
            RString path() {
                return this.thePath;
            }
        }

        /**
         * 認定調査結果登録対象者のListです。
         */
        private final List<dgNinteichosaResultTaishosha_Row> targets;

        /**
         * DemoDataを生成します。
         */
        DemoData() {
            targets = createList(DemoDataType.認定調査結果登録対象者);
        }

        /**
         * 認定調査依頼対象者を取得します。
         *
         * @return 認定調査依頼対象者
         */
        List<dgNinteichosaResultTaishosha_Row> get認定調査依頼登録対象者() {
            return this.targets;
        }

        private <T> List<T> createList(DemoDataType type) {
            List<HashMap> dataFromYaml = YamlLoader.FOR_DBE.loadAsList(type.path());
            return YamlUtil.convertList(dataFromYaml, createConverter(type));
        }

        private YamlUtil.Converter.IConverter createConverter(DemoDataType type) {
            switch (type) {
                case 認定調査結果登録対象者:
                    return new YamlUtil.Converter.IConverter<dgNinteichosaResultTaishosha_Row>() {

                        @Override
                        public dgNinteichosaResultTaishosha_Row exec(Map map) {
                            return toDgNinteichosaResultTaishosha_Row(map);

                        }

                    };
                default:
                    return YamlUtil.Converter.NO_CHANGE;
            }
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
                    cg.getAsRString("調査委託先コード"),
                    cg.getAsRString("調査委託先名"),
                    cg.getAsRString("調査員コード"),
                    cg.getAsRString("調査員氏名"),
                    cg.getAsTextBoxFlexibleDate("誕生日"),
                    cg.getAsRString("性別"),
                    cg.getAsRString("郵便番号"),
                    cg.getAsRString("住所"),
                    cg.getAsTextBoxFlexibleDate("受付日"),
                    cg.getAsTextBoxFlexibleDate("データ入力日")
            );
        }
    }
}
