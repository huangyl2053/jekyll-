/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込_支払方法指定を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum Furikomi_ShihraiHohoShitei {

    /**
     * コード:1 名称:口座 略称:定義なし
     */
    口座("1", "口座"),
    /**
     * コード:2 名称:窓口 略称:定義なし
     */
    窓口("2", "窓口");

    private final RString code;
    private final RString fullName;

    private Furikomi_ShihraiHohoShitei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込_支払方法指定のコードを返します。
     *
     * @return 振込_支払方法指定のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込_支払方法指定の名称を返します。
     *
     * @return 振込_支払方法指定の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込_支払方法指定のコードと一致する内容を探します。
     *
     * @param code 振込_支払方法指定のコード
     * @return {@code code} に対応する振込_支払方法指定名称
     */
    public static Furikomi_ShihraiHohoShitei toValue(RString code) {

        for (Furikomi_ShihraiHohoShitei furikomi_ShihraiHohoShitei : Furikomi_ShihraiHohoShitei.values()) {
            if (furikomi_ShihraiHohoShitei.code.equals(code)) {
                return furikomi_ShihraiHohoShitei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込_支払方法指定"));
    }
}
