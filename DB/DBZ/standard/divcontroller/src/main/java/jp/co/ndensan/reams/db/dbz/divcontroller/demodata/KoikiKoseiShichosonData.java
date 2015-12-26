/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author N3327 三浦 凌
 */
public class KoikiKoseiShichosonData {

    /**
     *
     */
    public interface IShichoson {

        /**
         * 市町村コード。
         *
         * @return 市町村コード
         */
        RString getCode();

        /**
         * 市町村名。
         *
         * @return 市町村名
         */
        RString getName();
    }

    /**
     *
     */
    public interface IShichosons {

        /**
         * @return as List
         */
        List<IShichoson> asList();

        /**
         * @return as list of KeyValueDataSource
         */
        List<KeyValueDataSource> asKeyValueDataSources();

    }

    private final static class Shichosons implements IShichosons {

        private final List<HashMap> dataFromYaml;

        private Shichosons(List<HashMap> dataFromYaml) {
            this.dataFromYaml = dataFromYaml;
        }

        @Override
        public List<IShichoson> asList() {
            return YamlUtil.convertList(dataFromYaml, new YamlUtil.Converter.IConverter<IShichoson>() {

                @Override
                public IShichoson exec(Map map) {
                    ControlGenerator cg = new ControlGenerator(map);
                    return new Shichoson(cg.getAsRString("市町村コード"), cg.getAsRString("市町村名"));
                }
            });
        }

        @Override
        public List<KeyValueDataSource> asKeyValueDataSources() {
            return YamlUtil.convertList(dataFromYaml, new YamlUtil.Converter.IConverter<KeyValueDataSource>() {

                @Override
                public KeyValueDataSource exec(Map map) {
                    ControlGenerator cg = new ControlGenerator(map);
                    return new KeyValueDataSource(cg.getAsRString("市町村コード"), cg.getAsRString("市町村名"));
                }
            });
        }

        private final class Shichoson implements KoikiKoseiShichosonData.IShichoson {

            private final RString code;
            private final RString name;

            private Shichoson(RString code, RString name) {
                this.code = code;
                this.name = name;
            }

            @Override
            public RString getCode() {
                return this.code;
            }

            @Override
            public RString getName() {
                return this.name;
            }

        }
    }

    /**
     * @return IShichosons
     */
    public IShichosons get広域構成市町村() {
        return new Shichosons(YamlLoader.DBZ.loadAsList(new RString("hihokenshaFinder/KoikiKoseiShichoson.yml")));
    }

}
