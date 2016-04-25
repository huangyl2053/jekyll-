/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理状況を表す列挙型です。
 *
 * @reamsid_L DBC-3092-010 zhuliangwei
 */
public enum ShoriJokyo {

    /**
     * コード:0 名称:すべて
     */
    すべて("0", "すべて"),
    /**
     * コード:1名称:対象者で抽出なし
     */
    対象者で抽出なし("1", "対象者で抽出なし"),
    /**
     * コード:2 名称:申請入力のみ
     */
    申請入力のみ("2", "申請入力のみ"),
    /**
     * コード:3 名称:支給不支給決定済み
     */
    支給不支給決定済み("3", "支給不支給決定済み"),
    /**
     * コード:4 名称:国保連結果送付済み
     */
    国保連結果送付済み("4", "国保連結果送付済み"),
    /**
     * コード:5 名称:国保連決定取込済み
     */
    国保連決定取込済み("5", "国保連決定取込済み"),
    /**
     * コード:6 名称:通知書発行済み
     */
    通知書発行済み("6", "通知書発行済み"),
    /**
     * コード:7 名称:振込明細発行済み
     */
    振込明細発行済み("7", "振込明細発行済み");

    private final RString code;
    private final RString fullName;

    private ShoriJokyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 処理状況のコードを返します。
     *
     * @return 処理状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処理状況の名称を返します。
     *
     * @return 処理状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理状況のコードと一致する内容を探します。
     *
     * @param code 処理状況のコード
     * @return {@code code} に対応する処理状況
     */
    public static ShoriJokyo toValue(RString code) {

        for (ShoriJokyo shoriJokyo : ShoriJokyo.values()) {
            if (shoriJokyo.code.equals(code)) {
                return shoriJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理状況"));
    }
}
