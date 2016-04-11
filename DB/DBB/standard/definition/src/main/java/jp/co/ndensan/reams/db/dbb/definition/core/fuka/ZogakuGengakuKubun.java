/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 増額減額区分を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum ZogakuGengakuKubun {

    /**
     * コード:0 名称:減額更正 略称:減額更正
     */
    減額更正("0", "減額更正", "減額更正"),
    /**
     * コード:1 名称:増額更正 略称:減額更正
     */
    増額更正("1", "増額更正", "増額更正");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ZogakuGengakuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 増額減額区分のコードを返します。
     *
     * @return 職権区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 増額減額区分の名称を返します。
     *
     * @return 増額減額区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 増額減額区分の略称を返します。
     *
     * @return 増額減額区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 増額減額区分のコードと一致する内容を探します。
     *
     * @param code 増額減額区分のコード
     * @return {@code code} に対応する増額減額区分
     */
    public static ZogakuGengakuKubun toValue(RString code) {
        for (ZogakuGengakuKubun zogakuGengakuKubun : ZogakuGengakuKubun.values()) {
            if (zogakuGengakuKubun.code.equals(code)) {
                return zogakuGengakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("増額減額区分"));
    }
}
