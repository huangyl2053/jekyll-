/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen.dgRiyoshaFutangakuGemmenList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 利用者負担額減免のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class RiyoshaFutangakuGemmenData {

    /**
     * 利用者負担額減免履歴を返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 利用者負担額減免履歴
     */
    public IDemoData<dgRiyoshaFutangakuGemmenList_Row> get利用者負担額減免履歴Of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<dgRiyoshaFutangakuGemmenList_Row>() {
            @Override
            public dgRiyoshaFutangakuGemmenList_Row exec(Map map) {
                return toDgRiyoshaFutangakuGemmenList_Row(map);
            }

            private dgRiyoshaFutangakuGemmenList_Row toDgRiyoshaFutangakuGemmenList_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new dgRiyoshaFutangakuGemmenList_Row(
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsTextBoxFlexibleDate("適用日"),
                        cg.getAsTextBoxFlexibleDate("有効期限"),
                        cg.getAsRString("決定区分"),
                        cg.getAsTextBoxFlexibleDate("決定日"),
                        cg.getAsTextBoxNum("給付率"),
                        cg.getAsRString("承認しない理由"));
            }
        });
    }

    /**
     * かなり強引なやり方で、利用者負担額減免の履歴があるかどうかチェックします。
     *
     * @param hihokenshaNo 被保険者番号
     * @return あればtrue。なければfalse。
     */
    public boolean exists利用者負担額減免履歴Of(RString hihokenshaNo) {
        try {
            YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        } catch (SystemException e) {
            return false;
        }
        return true;
    }

    private RString composeYAMLFilePathOf(RString hihokenshaNo) {
        return new RString("RiyoshaFutangakuGemmen/" + hihokenshaNo + ".yml");
    }
}
