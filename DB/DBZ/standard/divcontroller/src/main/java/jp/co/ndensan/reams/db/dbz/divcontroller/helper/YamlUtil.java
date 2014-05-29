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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * Yaml用ユーティリティです。<br/>
 * Object型を、RString,boolean,TextBoxFlexibleDateなどへ変換するメソッドを提供します。<br/>
 * また、YamlLoader#loadAsList()より取得できるListを、指定の型のオブジェクトを保持するListへ変換する
 * convertList()などを提供します。
 *
 * @author N3327 三浦 凌
 */
public final class YamlUtil {

    private YamlUtil() {
    }

    /**
     * Object.toString() をRStringへ変換して返します。 <br/>
     * 引数がnullのときはRString.EMPTYを返します。
     *
     * @param obj Object
     * @return obj.toString()の値を持ったRString
     */
    public static RString toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    /**
     * Object.toString() が"true"のときtrueを返します。<br/>
     * 引数nullのときはfalseを返します。
     *
     * @param obj Object
     * @return Object.toString() が"true"のときtrue,それ以外false
     */
    public static boolean toBoolean(Object obj) {
        if (obj == null) {
            return false;
        }
        return Boolean.valueOf(obj.toString()).booleanValue();
    }

    /**
     * Object.toString()と同値のFlexibleDateをもったTextBoxFlexibleDate返します。
     * 引数がnullのときはFlexibleDate.EMPTYをもったTextBoxFlexibleDate返します。
     *
     * @param obj Object
     * @return TextBoxFlexibleDate
     */
    public static TextBoxFlexibleDate toTextBoxFlexibleDate(Object obj) {
        TextBoxFlexibleDate textBox = new TextBoxFlexibleDate();
        RString date = toRString(obj);
        if (date.equals(RString.EMPTY)) {
            textBox.setValue(FlexibleDate.EMPTY);
        } else {
            textBox.setValue(new FlexibleDate(date));
        }
        return textBox;
    }

    /**
     * YamlLoader#loadAsList()より取得できるListが保持するHashMapをIConverterにより変換し、
     * その変換後のオブジェクトを保持するListを返します。
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
     * HashMapを変換するための定数やインターフェースを持ちます。
     */
    public static final class Converter {

        private Converter() {
        }

        /**
         * HashMapへ変換するIConverterです。
         */
        public static final IConverter<HashMap> NO_CHANGE;

        static {
            NO_CHANGE = new IConverter<HashMap>() {

                @Override
                public HashMap exec(Map map) {
                    return new HashMap(map);
                }

            };
        }

        /**
         * 指定の型へMapを変換します。
         *
         * @param <T> 変換後の型
         */
        public interface IConverter<T> {

            /**
             * MapをT型のオブジェクトへ変換して返します。
             *
             * @param map Map
             * @return T型のオブジェクト
             */
            T exec(Map map);
        }

    }
}
