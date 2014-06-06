/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * YamlLoaderをより便利に使うためのユーティリティです。<br/>
 * また、YamlLoader#loadAsList()より取得できるListを、指定の型のオブジェクトを保持するListへ変換する
 * convertList()などを提供します。
 *
 * @author N3327 三浦 凌
 */
public final class YamlUtil {

    private YamlUtil() {
    }

    /**
     * YamlLoader#loadAsList()より取得できるListが保持するHashMapをIConverterにより変換し、
     * その変換後のオブジェクトを保持するListを返します。
     * <pre>
     * 使用例:
     * <code>
     * {@literal List<HashMap>} dataFromYaml = YamlLoader.loadAsList(new RString("fileName"));
     *  {@literal List<dgXXXX_Row>} list = YamlUtil.convertList(dataFromYaml,
     *          new YamlUtil.Converter.IConverter{@literal <dgXXXX_Row>}() {
     *             {@literal @Override}
     *              public dgXXXX_Row exec(Map map) {
     *                  return to_dgXXXX_Row(map);
     *              }
     *          });
     * <code/>
     * <pre/>
     *
     * @param <T> 変換後のListが保持するオブジェクトの型
     * @param dataFromYaml YamlLoader#loadAsList()より取得できるList
     * @param conveter mapを変換するためのIConverter
     * @return IConverterにより変換されたオブジェクトを保持するList
     */
    public static <T> List<T> convertList(List<HashMap> dataFromYaml, Converter.IConverter<T> conveter) {
        List<T> list = new ArrayList<>();
        for (Map map : dataFromYaml) {
            list.add(conveter.exec(map));
        }
        return list;
    }

    /**
     * YamlUtil#convertList()で使用する、Mapを変換するための定数やインターフェースを持ちます。
     */
    public static final class Converter {

        private Converter() {
        }

        /**
         * HashMapへ変換するIConverterです。
         */
        public static final IConverter<Map> NO_CHANGE;

        static {
            NO_CHANGE = new IConverter<Map>() {

                @Override
                public Map exec(Map map) {
                    return map;
                }

            };
        }

        /**
         * 指定の型へHashMapを変換します。
         *
         * @param <T> 変換後の型
         */
        public interface IConverter<T> {

            /**
             * HashMapをT型のオブジェクトへ変換して返します。
             *
             * @param map Map
             * @return T型のオブジェクト
             */
            T exec(Map map);
        }

    }
}
