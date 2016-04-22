/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.shokan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付・償還払い状況・処理状況を表す列挙型です。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public enum ShoriJokyo {

    /**
     * コード:0 定義名:すべて 表示名称:すべて
     */
    すべて("0", "すべて"),
    /**
     * コード:1 定義名:申請入力 表示名称:申請入力のみ
     */
    申請入力("1", "申請入力のみ"),
    /**
     * コード:2 定義名:国保連送付済 表示名称:国保連送付済み
     */
    国保連送付済("2", "国保連送付済み"),
    /**
     * コード:3 定義名:不給不支給決定済 表示名称:不給不支給決定済み
     */
    不給不支給決定済("3", "不給不支給決定済み"),
    /**
     * コード:4 定義名:通知書発行済 表示名称:通知書発行済み
     */
    通知書発行済("4", "通知書発行済み"),
    /**
     * コード:5 定義名:振込明細発行済 表示名称:振込明細発行済み
     */
    振込明細発行済("5", "振込明細発行済み");

    private final RString code;
    private final RString fullName;

    private ShoriJokyo(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 給付・償還払い状況・処理状況のコードを返します。
     *
     * @return 給付・償還払い状況・処理状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付・償還払い状況・処理状況の名称を返します。
     *
     * @return 給付・償還払い状況・処理状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付・償還払い状況・処理状況のコードと一致する内容を探します。
     *
     * @param code 給付・償還払い状況・処理状況のコード
     * @return {@code code} に対応する給付・償還払い状況・処理状況
     */
    public static ShoriJokyo toValue(RString code) {

        for (ShoriJokyo shorijokyo : ShoriJokyo.values()) {
            if (shorijokyo.code.equals(code)) {
                return shorijokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理状況"));
    }
}
