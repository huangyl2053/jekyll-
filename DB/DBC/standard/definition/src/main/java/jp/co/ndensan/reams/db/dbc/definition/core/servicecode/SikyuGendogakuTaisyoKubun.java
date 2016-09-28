/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.servicecode;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給限度額対象区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhaowei
 */
public enum SikyuGendogakuTaisyoKubun {

    /**
     * コード:3 名称:区分支給限度額管理対照 略称:定義なし
     */
    区分支給限度額管理対照("0", "区分支給限度額管理対照");
    private final RString code;
    private final RString fullName;

    private SikyuGendogakuTaisyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支給限度額対象区分のコードを返します。
     *
     * @return 支給限度額対象区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支給限度額対象区分の名称を返します。
     *
     * @return 支給限度額対象区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支給限度額対象区分のコードと一致する内容を探します。
     *
     * @param code 支給限度額対象区分のコード
     * @return {@code code} に対応する支給限度額対象区分
     */
    public static SikyuGendogakuTaisyoKubun toValue(RString code) {

        for (SikyuGendogakuTaisyoKubun flag : SikyuGendogakuTaisyoKubun.values()) {
            if (flag.code.equals(code)) {
                return flag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支給限度額対象区分"));
    }
}
