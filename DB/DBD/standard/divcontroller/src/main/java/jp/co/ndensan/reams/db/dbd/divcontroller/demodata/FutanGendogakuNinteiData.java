/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.dgFutanGendogakuNinteiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 負担減額減額認定のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class FutanGendogakuNinteiData {

    /**
     * 負担限度額認定履歴を返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 負担限度額認定履歴
     */
    public IDemoData<dgFutanGendogakuNinteiList_Row> get負担限度額認定履歴of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        return new DemoData(dataFromYaml, new YamlUtil.Converter.IConverter<dgFutanGendogakuNinteiList_Row>() {

            @Override
            public dgFutanGendogakuNinteiList_Row exec(Map map) {
                return toDgFutanGendogakuNinteiList_Row(map);
            }

            private dgFutanGendogakuNinteiList_Row toDgFutanGendogakuNinteiList_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new dgFutanGendogakuNinteiList_Row(
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsTextBoxFlexibleDate("決定日"),
                        cg.getAsRString("決定区分"),
                        cg.getAsTextBoxFlexibleDate("適用日"),
                        cg.getAsTextBoxFlexibleDate("有効期限"),
                        cg.getAsRString("申請理由"),
                        cg.getAsRString("承認しない理由"),
                        cg.getAsRString("負担段階"),
                        cg.getAsRString("旧措置"),
                        cg.getAsRString("居室種別"),
                        cg.getAsRString("境界層"),
                        cg.getAsRString("激変緩和"),
                        cg.getAsTextBoxNum("食費"),
                        cg.getAsTextBoxNum("ユニット型個室"),
                        cg.getAsTextBoxNum("ユニット型準個室"),
                        cg.getAsTextBoxNum("多床室"),
                        cg.getAsTextBoxNum("従来型個室_特養等"),
                        cg.getAsTextBoxNum("従来型個室_老健")
                );
            }

        });
    }

    /**
     * 負担限度額認定履歴があるかどうかを返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return あればtrue。
     */
    public boolean exists負担限度額認定履歴of(RString hihokenshaNo) {
        try {
            YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        } catch (SystemException e) {
            return false;
        }
        return true;
    }

    private RString composeYAMLFilePathOf(RString hihokenshaNo) {
        return new RString("FutanGendogakuNintei/" + hihokenshaNo + ".yml");
    }

}
