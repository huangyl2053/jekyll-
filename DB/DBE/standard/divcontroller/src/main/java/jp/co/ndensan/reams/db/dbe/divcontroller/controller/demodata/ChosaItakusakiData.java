/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
public class ChosaItakusakiData {

    private static final RString FILE_NAME = new RString("ChosaKikanDialog/ChosaKikanList.yml");

    public static final class ChosaItakusaki {

        public static final ChosaItakusaki EMPTY;

        static {
            EMPTY = new ChosaItakusaki(RString.EMPTY, RString.EMPTY);
        }
        private final RString theCode;
        private final RString theName;

        private ChosaItakusaki(RString code, RString name) {
            this.theCode = code;
            this.theName = name;
        }

        public RString code() {
            return this.theCode;
        }

        public RString name() {
            return this.theName;
        }
    }

    public IDemoData<ChosaItakusaki> get調査委託先一覧() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(FILE_NAME);
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<ChosaItakusaki>() {
            @Override
            public ChosaItakusaki exec(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new ChosaItakusaki(cg.getAsRString("機関番号"), cg.getAsRString("機関名称"));
            }
        });
    }

    public ChosaItakusaki get調査委託先From(RString code) {
        List<ChosaItakusaki> list = get調査委託先一覧().asConvertedType();
        for (ChosaItakusaki itakusaki : list) {
            if (itakusaki.code().equals(code)) {
                return itakusaki;
            }
        }
        return ChosaItakusaki.EMPTY;
    }
}
