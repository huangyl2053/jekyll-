/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払先を表す列挙型です。
 *
 * @reamsid_L DBC-3092-010 zhuliangwei
 */
public enum ShiharaiSaki {

    /**
     * コード:0 名称:すべて
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:口座払い
     */
    口座払い("1", "口座払い"),
    /**
     * コード:2 名称:窓口払い
     */
    窓口払い("2", "窓口払い");

    private final RString code;
    private final RString fullName;

    private ShiharaiSaki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払先のコードを返します。
     *
     * @return 支払先のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払先の名称を返します。
     *
     * @return 支払先の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払先のコードと一致する内容を探します。
     *
     * @param code 支払先のコード
     * @return {@code code} に対応する支払先
     */
    public static ShiharaiSaki toValue(RString code) {

        for (ShiharaiSaki shiharaiSaki : ShiharaiSaki.values()) {
            if (shiharaiSaki.code.equals(code)) {
                return shiharaiSaki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払先"));
    }
}
