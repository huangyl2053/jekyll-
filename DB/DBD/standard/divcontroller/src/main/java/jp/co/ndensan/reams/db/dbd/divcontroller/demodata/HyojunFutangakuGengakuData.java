/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.hyojunFutangakuGemmen.dgHyojunFutangakuGengakuList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 標準負担額減額のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class HyojunFutangakuGengakuData {

    /**
     * 標準負担額減額履歴を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return DemoData
     */
    public IDemoData<dgHyojunFutangakuGengakuList_Row> get標準負担額減額履歴Of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<dgHyojunFutangakuGengakuList_Row>() {
            @Override
            public dgHyojunFutangakuGengakuList_Row exec(Map map) {
                return toDgHyojunFutangakuGengakuList_Row(map);
            }

            private dgHyojunFutangakuGengakuList_Row toDgHyojunFutangakuGengakuList_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new dgHyojunFutangakuGengakuList_Row(
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsTextBoxFlexibleDate("適用日"),
                        cg.getAsTextBoxFlexibleDate("有効期限"),
                        cg.getAsRString("決定区分"),
                        cg.getAsTextBoxFlexibleDate("決定日"),
                        cg.getAsTextBoxNum("標準負担額"),
                        cg.getAsRString("減額区分"),
                        cg.getAsRString("承認しない理由"));
            }
        });
    }

    /**
     * 標準負担額減額の履歴が存在するかどうかを返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return あればtrue。
     */
    public boolean exists標準負担額減額履歴Of(RString hihokenshaNo) {
        try {
            YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        } catch (SystemException e) {
            return false;
        }
        return true;
    }

    private RString composeYAMLFilePathOf(RString hihokenshaNo) {
        return new RString("HyojunFutangakuGengaku/" + hihokenshaNo + ".yml");
    }
}
