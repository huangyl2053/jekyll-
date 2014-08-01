/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8211 田辺 紘一
 */
public enum Minashi2GoHihokenshaKubun {

    みなし2号("1"),
    その他("0");

    private final RString みなし2号区分;

    private Minashi2GoHihokenshaKubun(String みなし2号区分) {
        this.みなし2号区分 = new RString(みなし2号区分);
    }

    public RString getみなし2号区分() {
        return みなし2号区分;
    }

    public static Minashi2GoHihokenshaKubun toValue(RString みなし2号区分) {

        for (Minashi2GoHihokenshaKubun value : values()) {
            if (value.getみなし2号区分().equals(みなし2号区分)) {
                return value;
            }
        }

        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応するみなし2号区分").getMessage());
    }
}
