/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付取込区分を表す列挙型です。
 *
 * @reamsid_L DBC-2010-080 jiangzongyue
 */
public enum SofuTorikomiKubun {

    /**
     * コード:1 名称:送付 略称:定義なし
     */
    送付("1", "送付"),
    /**
     * コード:2 名称:取込 略称:定義なし
     */
    取込("2", "取込"),
    /**
     * コード:3 名称:それ以外 略称:定義なし
     */
    それ以外("3", "それ以外");

    private final RString code;
    private final RString fullName;

    private SofuTorikomiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 送付取込区分のコードを返します。
     *
     * @return 送付取込区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 送付取込区分の名称を返します。
     *
     * @return 送付取込区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 送付取込区分のコードと一致する内容を探します。
     *
     * @param code 送付取込区分のコード
     * @return {@code code} に対応する送付取込区分
     */
    public static SofuTorikomiKubun toValue(RString code) {

        for (SofuTorikomiKubun keikokuKubun : SofuTorikomiKubun.values()) {
            if (keikokuKubun.code.equals(code)) {
                return keikokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("送付取込区分"));
    }
}
