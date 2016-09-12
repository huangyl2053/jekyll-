/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.taino;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 時効区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum JikoKubun {

    /**
     * コード: 名称:空 略称:定義なし
     */
    空("", "空"),
    /**
     * コード:1 名称:時効未到来 略称:定義なし
     */
    時効未到来("1", "時効未到来"),
    /**
     * コード:2 名称:時効到来 略称:定義なし
     */
    時効到来("2", "時効到来");
    private final RString code;
    private final RString fullName;

    private JikoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 時効区分のコードを返します。
     *
     * @return 激変緩和措置区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 時効区分の名称を返します。
     *
     * @return 激変緩和措置区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 時効区分のコードと一致する内容を探します。
     *
     * @param code 時効区分のコード
     * @return {@code code} に対応する時効区分
     */
    public static JikoKubun toValue(RString code) {

        for (JikoKubun jikoKubun : JikoKubun.values()) {
            if (jikoKubun.code.equals(code)) {
                return jikoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("時効区分"));
    }
}
