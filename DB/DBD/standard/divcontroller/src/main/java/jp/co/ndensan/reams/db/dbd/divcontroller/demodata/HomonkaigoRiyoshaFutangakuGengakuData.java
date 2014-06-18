/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.dgHomonkaigoRiyoshaFutangakuGengakuList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter.IConverter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 訪問介護利用者負担額減額のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class HomonkaigoRiyoshaFutangakuGengakuData {

    /**
     * 訪問介護利用者負担額減額履歴を返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 訪問介護利用者負担額減額履歴
     */
    public IDemoData<dgHomonkaigoRiyoshaFutangakuGengakuList_Row>
            get訪問介護利用者負担額減額履歴Of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        return new DemoData(dataFromYaml, new IConverter<dgHomonkaigoRiyoshaFutangakuGengakuList_Row>() {
            @Override
            public dgHomonkaigoRiyoshaFutangakuGengakuList_Row exec(Map map) {
                return toDgHomonkaigoRiyoshaFutangakuGengakuList_Row(map);
            }

            public dgHomonkaigoRiyoshaFutangakuGengakuList_Row
                    toDgHomonkaigoRiyoshaFutangakuGengakuList_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new dgHomonkaigoRiyoshaFutangakuGengakuList_Row(
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsRString("申請理由"),
                        cg.getAsTextBoxFlexibleDate("適用日"),
                        cg.getAsTextBoxFlexibleDate("有効期限"),
                        cg.getAsRString("決定区分"),
                        cg.getAsTextBoxFlexibleDate("決定日"),
                        cg.getAsRString("承認しない理由"),
                        cg.getAsRString("法別区分"),
                        cg.getAsTextBoxNum("給付率"),
                        cg.getAsRString("公費負担者番号"),
                        cg.getAsRString("公費受給者番号"),
                        cg.getAsBooleanValue("障害手帳有無"),
                        cg.getAsRString("障害手帳_等級"),
                        cg.getAsRString("障害手帳_番号")
                );
            }
        });
    }

    /**
     * 訪問介護利用者負担額減額履歴があるかどうかを返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return あればtrue。
     */
    public boolean exsits訪問介護利用者負担額減額履歴(RString hihokenshaNo) {
        try {
            YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        } catch (SystemException e) {
            return false;
        }
        return true;
    }

    private RString composeYAMLFilePathOf(RString hihokenshaNo) {
        return new RString("HomonkaigoRiyoshaFutangakuGengaku/" + hihokenshaNo + ".yml");
    }
}
