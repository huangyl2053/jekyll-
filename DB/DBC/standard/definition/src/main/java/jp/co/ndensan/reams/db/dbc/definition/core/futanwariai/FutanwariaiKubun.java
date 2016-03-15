/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.futanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合区分を表す列挙型です。
 */
public enum FutanwariaiKubun {

    /**
     * コード:1 名称:_１割 略称:１割
     */
    _１割("1", "_１割", "１割"),
    /**
     * コード:2 名称:_２割 略称:２割
     */
    _２割("2", "_２割", "２割");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private FutanwariaiKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 負担割合区分のコードを返します。
     *
     * @return 負担割合区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 負担割合区分の名称を返します。
     *
     * @return 負担割合区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 負担割合区分の略称を返します。
     *
     * @return 負担割合区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 負担割合区分のコードと一致する内容を探します。
     *
     * @param code 負担割合区分のコード
     * @return {@code code} に対応する負担割合区分
     */
    public static FutanwariaiKubun toValue(RString code) {

        for (FutanwariaiKubun futanwariaiKubun : FutanwariaiKubun.values()) {
            if (futanwariaiKubun.code.equals(code)) {
                return futanwariaiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合区分"));
    }
}
