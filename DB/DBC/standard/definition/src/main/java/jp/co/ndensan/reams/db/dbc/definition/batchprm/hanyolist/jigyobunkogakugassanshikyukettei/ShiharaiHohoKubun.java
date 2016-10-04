/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum ShiharaiHohoKubun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:窓口払 略称:定義なし
     */
    窓口払("1", "窓口払"),
    /**
     * コード:2 名称:口座払 略称:定義なし
     */
    口座払("2", "口座払");

    private final RString code;
    private final RString fullName;

    private ShiharaiHohoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法区分のコードを返します。
     *
     * @return 支払方法区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法区分の名称を返します。
     *
     * @return 支払方法区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法区分のコードと一致する内容を探します。
     *
     * @param code 支払方法区分のコード
     * @return {@code code} に対応する支払方法区分
     */
    public static ShiharaiHohoKubun toValue(RString code) {

        for (ShiharaiHohoKubun shiharaiHohoKubun : ShiharaiHohoKubun.values()) {
            if (shiharaiHohoKubun.code.equals(code)) {
                return shiharaiHohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法区分"));
    }
}
