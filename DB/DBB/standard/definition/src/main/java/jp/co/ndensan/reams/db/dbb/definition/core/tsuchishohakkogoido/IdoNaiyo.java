/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.tsuchishohakkogoido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動内容を表す列挙型です。
 *
 * @reamsid_L DBB-0690-030 surun
 */
public enum IdoNaiyo {

    /**
     * コード:0 名称:なし 略称:定義なし
     */
    なし("0", "なし"),
    /**
     * コード:1 名称:資格の異動 略称:定義なし
     */
    資格異動("1", "資格の異動"),
    /**
     * コード:2 名称:氏名の変更 略称:定義なし
     */
    氏名変更("2", "氏名の変更"),
    /**
     * コード:3 名称:本人住所の変更 略称:定義なし
     */
    本人住所変更("3", "本人住所の変更");

    private final RString code;
    private final RString fullName;

    private IdoNaiyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 異動内容のコードを返します。
     *
     * @return 異動内容のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 異動内容の名称を返します。
     *
     * @return 異動内容の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 異動内容のコードと一致する内容を探します。
     *
     * @param code 異動内容のコード
     * @return {@code code} に対応する異動内容
     */
    public static IdoNaiyo toValue(RString code) {
        for (IdoNaiyo idoNaiyo : IdoNaiyo.values()) {
            if (idoNaiyo.code.equals(code)) {
                return idoNaiyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("異動内容"));
    }

    /**
     * 異動内容のコードと一致する内容を探します。
     *
     * @param value 異動内容のコード
     * @return {@value value} に対応する異動内容
     */
    public static IdoNaiyo toIdoNaiyo(RString value) {
        for (IdoNaiyo idoNaiyo : IdoNaiyo.values()) {
            if (idoNaiyo.fullName.equals(value)) {
                return idoNaiyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("異動内容"));
    }
}
