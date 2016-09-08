/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込_処理区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum Furikomi_ShoriKubun {

    /**
     * コード:1 名称:振込データを作成する 略称:定義なし
     */
    振込データ作成("1", "振込データを作成する"),
    /**
     * コード:2 名称:振込指定日を修正する 略称:定義なし
     */
    振込指定日修正("2", "振込指定日を修正する"),
    /**
     * コード:3 名称:振込明細一覧表を作成 略称:定義なし
     */
    明細一覧表作成("3", "振込明細一覧表を作成");

    private final RString code;
    private final RString fullName;

    private Furikomi_ShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込_処理区分のコードを返します。
     *
     * @return 振込_処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込_処理区分の名称を返します。
     *
     * @return 振込_処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込_処理区分のコードと一致する内容を探します。
     *
     * @param code 振込_処理区分のコード
     * @return {@code code} に対応する振込_処理区分名称
     */
    public static Furikomi_ShoriKubun toValue(RString code) {

        for (Furikomi_ShoriKubun furikomi_ShoriKubun : Furikomi_ShoriKubun.values()) {
            if (furikomi_ShoriKubun.code.equals(code)) {
                return furikomi_ShoriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込_処理区分"));
    }
}
