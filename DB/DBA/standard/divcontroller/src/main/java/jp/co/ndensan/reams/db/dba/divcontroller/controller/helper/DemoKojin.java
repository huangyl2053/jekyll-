/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.helper;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class DemoKojin {

    private static final RString demoKojin = new RString("demoKojin.yml");
    private ControlGenerator generator;

    public DemoKojin(String hihokenshaKubun) {
        List<HashMap> yamlDataList = YamlLoader.DBA.loadAsList(demoKojin);
        generator = null;
        for (HashMap yamlData : yamlDataList) {
            ControlGenerator nestGenerator = new ControlGenerator(yamlData);
            if (nestGenerator.getAsRString("被保区分").equals(new RString(hihokenshaKubun))) {
                generator = nestGenerator;
            }
        }

        if (generator == null) {
            generator = new ControlGenerator(YamlLoader.DBA.loadAsList(demoKojin).get(0));
        }
    }

    public RString getShikibetsuCode() {
        return generator.getAsRString("識別コード");
    }

    public RString getHihokenshaNo() {
        return generator.getAsRString("被保番号");
    }

}
