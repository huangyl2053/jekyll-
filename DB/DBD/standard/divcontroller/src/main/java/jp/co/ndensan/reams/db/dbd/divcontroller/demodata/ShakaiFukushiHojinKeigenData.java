/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.dgShakaiFukushiHojinKeigenList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 社会福祉法人軽減のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class ShakaiFukushiHojinKeigenData {

    /**
     * 社会福祉法人軽減の履歴を返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 社会福祉法人軽減の履歴
     */
    public IDemoData<dgShakaiFukushiHojinKeigenList_Row>
            get社会福祉法人軽減履歴Of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<dgShakaiFukushiHojinKeigenList_Row>() {

            @Override
            public dgShakaiFukushiHojinKeigenList_Row exec(Map map) {
                return toDgShakaiFukushiHojinKeigenList_Row(map);
            }

            private dgShakaiFukushiHojinKeigenList_Row toDgShakaiFukushiHojinKeigenList_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                TextBoxNum keigenRitsu_bunshi = cg.getAsTextBoxNum("軽減率_分子");
                TextBoxNum keigenRitsu_bunbo = cg.getAsTextBoxNum("軽減率_分母");
                return new dgShakaiFukushiHojinKeigenList_Row(
                        cg.getAsRString("確認番号"),
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsTextBoxFlexibleDate("適用日"),
                        cg.getAsTextBoxFlexibleDate("有効期限"),
                        cg.getAsRString("決定区分"),
                        cg.getAsTextBoxFlexibleDate("決定日"),
                        keigenRitsu_bunshi,
                        keigenRitsu_bunbo,
                        compose軽減率(keigenRitsu_bunshi, keigenRitsu_bunbo),
                        cg.getAsRString("軽減事由"),
                        cg.getAsRString("居宅サービス限定"),
                        cg.getAsRString("居住費_食費のみ"),
                        cg.getAsRString("旧措置ユニット型個室のみ"),
                        cg.getAsRString("承認しない理由"));
            }

            private RString compose軽減率(TextBoxNum bunshi, TextBoxNum bunbo) {
                return new RString(bunshi.getValue().intValue() + "/" + bunbo.getValue().intValue());
            }
        });
    }

    /**
     * 社会福祉法人軽減の履歴があるかどうかチェックします。
     *
     * @param hihokenshaNo 被保険者番号
     * @return あればtrue。なければfalse。
     */
    public boolean exists社会福祉法人軽減履歴Of(RString hihokenshaNo) {
        try {
            YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        } catch (SystemException e) {
            return false;
        }
        return true;
    }

    private RString composeYAMLFilePathOf(RString hihokenshaNo) {
        return new RString("ShakaiFukushiHojinKeigen/" + hihokenshaNo + ".yml");
    }
}
