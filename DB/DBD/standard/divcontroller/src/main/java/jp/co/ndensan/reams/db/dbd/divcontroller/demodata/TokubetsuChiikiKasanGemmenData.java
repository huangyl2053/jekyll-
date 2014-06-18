/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.tokubetsuChiikiKasanGemmen.dgTokubetsuChiikiKasanGemmenList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 特別地域加算減免のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class TokubetsuChiikiKasanGemmenData {

    /**
     * 特別地域加算減免履歴を返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 特別地域加算減免履歴
     */
    public IDemoData<dgTokubetsuChiikiKasanGemmenList_Row>
            get特別地域加算減免履歴Of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        return new DemoData(dataFromYaml, new YamlUtil.Converter.IConverter<dgTokubetsuChiikiKasanGemmenList_Row>() {

            @Override
            public dgTokubetsuChiikiKasanGemmenList_Row exec(Map map) {
                return toDgTokubetsuChiikiKasanGemmenList_Row(map);
            }

            private dgTokubetsuChiikiKasanGemmenList_Row toDgTokubetsuChiikiKasanGemmenList_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new dgTokubetsuChiikiKasanGemmenList_Row(
                        cg.getAsRString("確認番号"),
                        cg.getAsTextBoxFlexibleDate("申請日"),
                        cg.getAsTextBoxFlexibleDate("適用日"),
                        cg.getAsTextBoxFlexibleDate("有効期限"),
                        cg.getAsRString("決定区分"),
                        cg.getAsTextBoxFlexibleDate("決定日"),
                        cg.getAsTextBoxNum("減額率"),
                        cg.getAsRString("承認しない理由"));
            }
        });
    }

    /**
     * 特別地域加算減免の履歴があるかどうかチェックします。
     *
     * @param hihokenshaNo 被保険者番号
     * @return あればtrue。なければfalse。
     */
    public boolean exists特別地域加算減免履歴Of(RString hihokenshaNo) {
        try {
            YamlLoader.DBD.loadAsList(composeYAMLFilePathOf(hihokenshaNo));
        } catch (SystemException e) {
            return false;
        }
        return true;
    }

    private RString composeYAMLFilePathOf(RString hihokenshaNo) {
        return new RString("TokubetsuChiikiKasanGemmen/" + hihokenshaNo + ".yml");
    }
}
