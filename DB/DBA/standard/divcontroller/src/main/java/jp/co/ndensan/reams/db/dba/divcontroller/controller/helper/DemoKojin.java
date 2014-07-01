/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.helper;

import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class DemoKojin {

    private static final RString demoKojin = new RString("demoKojin.yml");
    private final ControlGenerator generator;

    public DemoKojin() {
        generator = new ControlGenerator(YamlLoader.DBA.loadAsMap(demoKojin));
    }

    public RString getShikibetsuCode() {
        return generator.getAsRString("識別コード");
    }

    public RString getHihokenshaNo() {
        return generator.getAsRString("被保番号");
    }

}
