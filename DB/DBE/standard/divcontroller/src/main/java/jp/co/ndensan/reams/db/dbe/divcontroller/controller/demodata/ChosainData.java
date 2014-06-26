/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosaItakusakiData.ChosaItakusaki;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
public class ChosainData {

    private static final RString FILE_NAME = new RString("Chosain/Chosain.yml");

    public static final class Chosain {

        public static final Chosain EMPTY;

        static {
            EMPTY = new Chosain(RString.EMPTY, RString.EMPTY, ChosaItakusaki.EMPTY);
        }
        private final RString theCode;
        private final RString theName;
        private final ChosaItakusaki theItakusaki;

        private Chosain(RString code, RString name, ChosaItakusaki itakusaki) {
            this.theCode = code;
            this.theName = name;
            this.theItakusaki = itakusaki;
        }

        public RString code() {
            return this.theCode;
        }

        public RString name() {
            return this.theName;
        }

        public ChosaItakusaki itakusaki() {
            return this.theItakusaki;
        }
    }

    public IDemoData<Chosain> get調査員一覧() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(FILE_NAME);
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<Chosain>() {
            @Override
            public Chosain exec(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new Chosain(cg.getAsRString("調査員番号"), cg.getAsRString("調査員氏名"),
                        new ChosaItakusakiData().get調査委託先From(cg.getAsRString("調査委託先番号")));
            }
        });
    }

    public Chosain get調査員From(RString code) {
        List<Chosain> list = get調査員一覧().asConvetedType();
        for (Chosain chosain : list) {
            if (chosain.code().equals(code)) {
                return chosain;
            }
        }
        return Chosain.EMPTY;
    }
}
