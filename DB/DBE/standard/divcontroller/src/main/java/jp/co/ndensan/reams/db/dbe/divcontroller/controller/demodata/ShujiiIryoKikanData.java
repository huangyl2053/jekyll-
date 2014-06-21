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
 * 主治医医療機関のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class ShujiiIryoKikanData {

    private static final RString FILE_NAME = new RString("Shujii/IryoKikan.yml");

    public static class IryoKikan {

        public static final IryoKikan EMPTY;

        static {
            EMPTY = new IryoKikan(RString.EMPTY, RString.EMPTY);
        }
        private final RString theCode;
        private final RString theName;

        private IryoKikan(RString code, RString name) {
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

    public IDemoData<IryoKikan> get医療機関一覧() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(FILE_NAME);
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<IryoKikan>() {

            @Override
            public IryoKikan exec(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new IryoKikan(cg.getAsRString("医療機関コード"), cg.getAsRString("医療機関名称"));
            }
        });
    }

    public IryoKikan get医療機関From(RString code) {
        List<IryoKikan> list = get医療機関一覧().asConvetedType();
        for (IryoKikan iryoKikan : list) {
            if (iryoKikan.code().equals(code)) {
                return iryoKikan;
            }
        }
        return IryoKikan.EMPTY;
    }
}
