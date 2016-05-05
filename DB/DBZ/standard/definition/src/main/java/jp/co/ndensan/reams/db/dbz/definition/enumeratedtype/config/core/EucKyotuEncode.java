/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.config.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * EUC共通_文字コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum EucKyotuEncode {

    /**
     * コード:1 名称:ReamsUnicode 略称:定義なし
     */
    ReamsUnicode("1", "ReamsUnicode"),
    /**
     * コード:2 名称:SJIS 略称:定義なし
     */
    SJIS("2", "SJIS"),
    /**
     * コード:3 名称:SJIS類字 略称:定義なし
     */
    SJIS類字("3", "SJIS類字");

    private final RString code;
    private final RString fullName;

    private EucKyotuEncode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * EUC共通_文字コードのコードを返します。
     *
     * @return EUC共通_文字コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * EUC共通_文字コードの名称を返します。
     *
     * @return EUC共通_文字コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * EUC共通_文字コードのコードと一致する内容を探します。
     *
     * @param code EUC共通_文字コードのコード
     * @return {@code code} に対応するEUC共通_文字コード
     */
    public static EucKyotuEncode toValue(RString code) {

        for (EucKyotuEncode eucKyotuEncode : EucKyotuEncode.values()) {
            if (eucKyotuEncode.code.equals(code)) {
                return eucKyotuEncode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("EUC共通_文字コード"));
    }
}
