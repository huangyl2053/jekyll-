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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.NinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
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
        System.out.println("a");
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
            RString shimei = YamlUtil.toRString(map.get("氏名"));
            RString kanaShimei = YamlUtil.toRString(map.get("カナ氏名"));
            return new dgNinteichosaResultTaishosha_Row(
                    new Button(),
                    YamlUtil.toRString(map.get("保険者番号")),
                    YamlUtil.toRString(map.get("保険者名")),
                    YamlUtil.toRString(map.get("被保番号")),
                    YamlUtil.toRString(map.get("識別コード")),
                    shimei,
                    kanaShimei,
                    DataGridUtil.lineFeedBetween(kanaShimei, shimei),
                    YamlUtil.toTextBoxFlexibleDate(map.get("申請日")),
                    YamlUtil.toRString(map.get("申請区分")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("調査依頼日")),
                    YamlUtil.toRString(map.get("調査委託先コード")),
                    YamlUtil.toRString(map.get("調査委託先名")),
                    YamlUtil.toRString(map.get("調査員コード")),
                    YamlUtil.toRString(map.get("調査員氏名")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("誕生日")),
                    YamlUtil.toRString(map.get("性別")),
                    YamlUtil.toRString(map.get("郵便番号")),
                    YamlUtil.toRString(map.get("住所")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("受付日")),
                    YamlUtil.toTextBoxFlexibleDate(map.get("データ入力日"))
            );
        }
    }
}
