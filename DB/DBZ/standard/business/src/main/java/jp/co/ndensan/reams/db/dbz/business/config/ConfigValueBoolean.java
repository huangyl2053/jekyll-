/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二値のみ（1と0しか持たない等）の業務コンフィグを、Bool値に変換するためのクラスです。<br/>
 * trueに変換されてほしい値を内部に持ち、それらの値と業務コンフィグの値を比較することでtrue／falseを判定します。
 *
 * <pre>
 * 使用例
 * {@code
 * public class HihokenshashoJushoEditConfig {
 *     ...
 *     private final Map<ConfigKeysHihokenshashoJushoEdit, RString> configs;
 *     ...
 *     public boolean is帳票独自区分を使用() {
 *         return ConfigValueBoolean.perseBoolean(
 *                 configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_帳票独自区分));
 *     }
 *     ...
 * }
 * }
 * </pre>
 *
 * @author n8178 城間篤人
 */
public final class ConfigValueBoolean {

    private ConfigValueBoolean() {
    }

    private enum Definitions {

        /**
         * trueであると判定されてほしい文字列を設定します。<br/>
         * 現状1と0が主ですが、他の文字列でもtrue／falseの判定を行いたい場合には、必要な文字列を追加していく必要があります。
         * <pre>
         * 追加例
         * INSTANCE("1", "true", "TRUE" ...);
         * </pre>
         */
        INSTANCE("1");

        private final Set<RString> valuesOfTrue;

        private Definitions(String... values) {
            Set<RString> set = new HashSet<>();
            for (String str : values) {
                set.add(new RString(str));
            }
            this.valuesOfTrue = Collections.unmodifiableSet(set);
        }
    }

    /**
     * 引数から受け取った文字列と、trueであると判定されてほしい文字列の集合を比較して、Bool値に変換します。
     *
     * @param rstr 比較対象の文字列
     * @return 比較対象の文字列と同値の文字列が、trueであると判定される文字列の集合に存在している場合true
     */
    public static boolean perseBoolean(RString rstr) {
        return Definitions.INSTANCE.valuesOfTrue.contains(rstr);
    }
}
