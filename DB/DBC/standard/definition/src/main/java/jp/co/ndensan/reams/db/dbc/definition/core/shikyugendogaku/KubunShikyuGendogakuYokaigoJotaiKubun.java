/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 区分支給限度額要介護状態区分を表す列挙型です。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public enum KubunShikyuGendogakuYokaigoJotaiKubun {

    /**
     * コード:06 名称:経過介護 略称:定義なし
     */
    事業対象者("06", "事業対象者"),
    /**
     * コード:11 名称:経過介護 略称:定義なし
     */
    経過介護("11", "経過介護"),
    /**
     * コード:12 名称:要支援1 略称:定義なし
     */
    要支援1("12", "要支援1"),
    /**
     * コード:13 名称:要支援2 略称:定義なし
     */
    要支援2("13", "要支援2"),
    /**
     * コード:21 名称:要介護1 略称:定義なし
     */
    要介護1("21", "要介護1"),
    /**
     * コード:22 名称:要介護2 略称:定義なし
     */
    要介護2("22", "要介護2"),
    /**
     * コード:23 名称:要介護3 略称:定義なし
     */
    要介護3("23", "要介護3"),
    /**
     * コード:24 名称:要介護4 略称:定義なし
     */
    要介護4("24", "要介護4"),
    /**
     * コード:25 名称:要介護5 略称:定義なし
     */
    要介護5("25", "要介護5");

    private final RString code;
    private final RString fullName;

    private KubunShikyuGendogakuYokaigoJotaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 区分支給限度額要介護状態区分のコードを返します。
     *
     * @return 区分支給限度額要介護状態区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 区分支給限度額要介護状態区分の名称を返します。
     *
     * @return 区分支給限度額要介護状態区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 区分支給限度額要介護状態区分のコードと一致する内容を探します。
     *
     * @param code 区分支給限度額要介護状態区分のコード
     * @return {@code code} に対応する区分支給限度額要介護状態区分
     */
    public static KubunShikyuGendogakuYokaigoJotaiKubun toValue(RString code) {

        for (KubunShikyuGendogakuYokaigoJotaiKubun kaigoJotaiKubun : KubunShikyuGendogakuYokaigoJotaiKubun.values()) {
            if (kaigoJotaiKubun.code.equals(code)) {
                return kaigoJotaiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("区分支給限度額要介護状態区分のコード"));
    }
}
