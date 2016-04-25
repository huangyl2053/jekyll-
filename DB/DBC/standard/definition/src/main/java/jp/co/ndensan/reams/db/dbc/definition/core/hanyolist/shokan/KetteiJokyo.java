/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.shokan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付・償還払い状況・決定状況を表す列挙型です。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public enum KetteiJokyo {

    /**
     * コード:0 定義名:すべて 表示名称:すべて
     */
    すべて("0", "すべて"),
    /**
     * コード:1 定義名:支給分 表示名称:支給分のみ
     */
    支給分("1", "支給分のみ"),
    /**
     * コード:2 定義名:支給分のみ 表示名称:不支給分のみ
     */
    支給分のみ("2", "不支給分のみ");

    private final RString code;
    private final RString fullName;

    private KetteiJokyo(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 給付・償還払い状況・決定状況のコードを返します。
     *
     * @return 給付・償還払い状況・決定状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付・償還払い状況・決定状況の名称を返します。
     *
     * @return 給付・償還払い状況・決定状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付・償還払い状況・決定状況のコードと一致する内容を探します。
     *
     * @param code 給付・償還払い状況・決定状況のコード
     * @return {@code code} に対応する給付・償還払い状況・決定状況
     */
    public static KetteiJokyo toValue(RString code) {

        for (KetteiJokyo ketteijokyo : KetteiJokyo.values()) {
            if (ketteijokyo.code.equals(code)) {
                return ketteijokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定状況"));
    }
}
