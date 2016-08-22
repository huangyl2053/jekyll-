/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給限度額テーブル区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 jianglaisheng
 */
public enum ShikyuGendogakuTableKubun {

    /**
     * コード:1 名称:標準 略称:定義なし
     */
    標準("1", "標準"),
    /**
     * コード:2 名称:上乗せ後 略称:定義なし
     */
    上乗せ後("2", "上乗せ後");
    private final RString code;
    private final RString fullName;

    private ShikyuGendogakuTableKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支給限度額テーブル区分のコードを返します。
     *
     * @return 支給限度額テーブル区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支給限度額テーブル区分の名称を返します。
     *
     * @return 支給限度額テーブル区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支給限度額テーブル区分のコードと一致する内容を探します。
     *
     * @param code 支給限度額テーブル区分のコード
     * @return {@code code} に対応する支給限度額テーブル区分
     */
    public static ShikyuGendogakuTableKubun toValue(RString code) {

        for (ShikyuGendogakuTableKubun value : ShikyuGendogakuTableKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支給限度額テーブル区分"));
    }

}
