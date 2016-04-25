/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.shokan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付・償還払い状況・支払方法を表す列挙型です。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public enum ShiharaiHoho {

    /**
     * コード:0 定義名:すべて 表示名称:すべて
     */
    すべて("0", "すべて"),
    /**
     * コード:1 定義名:窓口払い 表示名称:窓口払い
     */
    窓口払い("1", "窓口払い"),
    /**
     * コード:2 定義名:口座払い 表示名称:口座払い
     */
    口座払い("2", "口座払い");

    private final RString code;
    private final RString fullName;

    private ShiharaiHoho(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 給付・償還払い状況・支払方法のコードを返します。
     *
     * @return 給付・償還払い状況・支払方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付・償還払い状況・支払方法の名称を返します。
     *
     * @return 給付・償還払い状況・支払方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付・償還払い状況・支払方法のコードと一致する内容を探します。
     *
     * @param code 給付・償還払い状況・支払方法のコード
     * @return {@code code} に対応する給付・償還払い状況・支払方法
     */
    public static ShiharaiHoho toValue(RString code) {

        for (ShiharaiHoho shiharaihoho : ShiharaiHoho.values()) {
            if (shiharaihoho.code.equals(code)) {
                return shiharaihoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法"));
    }
}
