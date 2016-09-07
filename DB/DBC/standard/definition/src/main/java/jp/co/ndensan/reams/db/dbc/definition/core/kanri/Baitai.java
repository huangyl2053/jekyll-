/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kanri;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 媒体区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Baitai {

    /**
     * コード:1 名称:1:伝送 略称:定義なし
     */
    伝送("1", "伝送"),
    /**
     * コード:2 名称:2:ＭＯ 略称:定義なし
     */
    ＭＯ("2", "ＭＯ"),
    /**
     * コード:4 名称:4:ＦＤ 略称:定義なし
     */
    ＦＤ("4", "ＦＤ"),
    /**
     * コード:5 名称:5:帳票 略称:定義なし
     */
    帳票("5", "帳票");

    private final RString code;
    private final RString fullName;

    private Baitai(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 媒体区分のコードを返します。
     *
     * @return 媒体区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 媒体区分の名称を返します。
     *
     * @return 媒体区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 媒体区分のコードと一致する内容を探します。
     *
     * @param code 媒体区分のコード
     * @return {@code code} に対応する媒体区分
     */
    public static Baitai toValue(RString code) {

        for (Baitai baitai : Baitai.values()) {
            if (baitai.code.equals(code)) {
                return baitai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("媒体区分"));
    }

}
