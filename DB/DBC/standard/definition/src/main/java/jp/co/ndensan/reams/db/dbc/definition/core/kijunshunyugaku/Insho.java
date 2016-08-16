/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 印書DDLを表す列挙型です。
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public enum Insho {

    /**
     * コード:1 名称:発行済みも含める 略称:定義なし
     */
    発行済みも含める("1", "発行済みも含める"),
    /**
     * コード:0 名称:未発行分のみ 略称:定義なし
     */
    未発行分のみ("0", "未発行分のみ");

    private final RString code;
    private final RString fullName;

    private Insho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 印書DDLのコードを返します。
     *
     * @return 印書DDLのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 印書DDLの名称を返します。
     *
     * @return 印書DDLの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 印書DDLのコードと一致する内容を探します。
     *
     * @param code 印書DDLのコード
     * @return {@code code} に対応する印書DDL
     */
    public static Insho toValue(RString code) {

        for (Insho insho : Insho.values()) {
            if (insho.code.equals(code)) {
                return insho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("印書DDLのコード"));
    }

}
