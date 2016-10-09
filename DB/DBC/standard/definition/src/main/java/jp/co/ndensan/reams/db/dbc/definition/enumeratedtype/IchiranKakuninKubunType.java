/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一覧用確認区分を定義した列挙型です。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public enum IchiranKakuninKubunType {

    /**
     * 空白を表します。
     */
    空白("", ""),
    /**
     * 審査方法区分が未設定を表します。
     */
    審査方法区分が未設定("1", "審査方法区分が未設定"),
    /**
     * 補正後事業高額支給額がマイナス値を表します。
     */
    補正後事業高額支給額がマイナス値("2", "補正後事業高額支給額がマイナス値"),
    /**
     * 旧措置を表します。
     */
    一かつニ("3", "１かつ２"),
    /**
     * 帳票側自己負担額事業高額支給額を表します。
     */
    帳票側自己負担額事業高額支給額("4", "自己負担額＜事業高額支給額"),
    /**
     * 自己負担額事業高額支給額を表します。
     */
    自己負担額事業高額支給額("*", "自己負担額＜事業高額支給額");
    private final RString code;
    private final RString name;

    private IchiranKakuninKubunType() {
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
    }

    private IchiranKakuninKubunType(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return code;
    }

    /**
     * displayNameを返します。
     *
     * @return displayName
     */
    public RString displayName() {
        return this.name;
    }

    /**
     * 対応する列挙型を返します。
     * <p/>
     * @param codeOrName codeOrName
     * @return 列挙型
     * @throws IllegalArgumentException 対応する列挙型がない場合
     */
    public static IchiranKakuninKubunType toValue(RString codeOrName) throws IllegalArgumentException {
        if (RString.isNullOrEmpty(codeOrName)) {
            return 空白;
        }
        for (IchiranKakuninKubunType data : values()) {
            if (data.displayName().equals(codeOrName) || data.code().equals(codeOrName)) {
                return data;
            }
        }
        return 空白;
    }
}
