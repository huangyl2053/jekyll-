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
 * 業務コンフィグに登録されている値が{@code boolean}として扱われるかを判定する機能を持ちます。
 * {@code true}として扱いたい値を{@link ConfigValueBoolean.Dictionary}に持ち、それらの値と業務コンフィグの値を比較することでtrue／falseを判定します。
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

    /**
     * {@code true}として扱う文字列を定義するための列挙型です。{@link #INSTANCE}以外の要素を持たせることは禁止します。
     */
    private enum Dictionary {

        /**
         * {@code true}であると判定されてほしい文字列を設定します。<br/>
         * 現状1と0が主ですが、他の文字列でもtrue／falseの判定を行いたい場合には、必要な文字列を追加していく必要があります。
         * <p>
         * 追加例：
         * <pre>
         * INSTANCE("1", "true", "TRUE" ...);
         * </pre>
         * </p>
         */
        INSTANCE("1");

        private final Set<RString> valuesOfTrue;

        private Dictionary(String... values) {
            Set<RString> set = new HashSet<>();
            for (String str : values) {
                set.add(new RString(str));
            }
            this.valuesOfTrue = Collections.unmodifiableSet(set);
        }
    }

    /**
     * 指定の文字列が{@code true}として扱われるものである時、{@code true}を返します。
     *
     * @param rstr 比較対象の文字列
     * @return 指定の文字列が{@code true}として扱われるものである時、{@code true}
     */
    public static boolean perseBoolean(RString rstr) {
        return Dictionary.INSTANCE.valuesOfTrue.contains(rstr);
    }
}
