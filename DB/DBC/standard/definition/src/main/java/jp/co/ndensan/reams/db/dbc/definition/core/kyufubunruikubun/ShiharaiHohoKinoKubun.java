/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法機能区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 wangkanglei
 */
public enum ShiharaiHohoKinoKubun {

    /**
     * コード:1 名称:事業高額
     */
    事業高額("1", "事業高額"),
    /**
     * コード:2 名称:事業高額
     */
    高額介護("2", "高額介護"),
    /**
     * コード:2 名称:事業高額
     */
    高額合算("3", "高額合算"),
    /**
     * コード:4 名称:事業高額
     */
    償還払("4", "償還払");

    private final RString code;
    private final RString fullName;

    private ShiharaiHohoKinoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法機能区分のコードを返します。
     *
     * @return 支払方法機能区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法機能区分の名称を返します。
     *
     * @return 支払方法機能区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法機能区分のコードと一致する内容を探します。
     *
     * @param code 支払方法機能区分のコード
     * @return {@code code} に対応する支払方法機能区分
     */
    public static ShiharaiHohoKinoKubun toValue(RString code) {

        for (ShiharaiHohoKinoKubun shiharaihouhouKinouKubun : ShiharaiHohoKinoKubun.values()) {
            if (shiharaihouhouKinouKubun.code.equals(code)) {
                return shiharaihouhouKinouKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法機能区分"));
    }
}
