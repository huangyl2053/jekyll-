/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.servicecode;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別地域加算フラグを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 chenhui
 */
public enum TokubetsuChikiKasanFlg {

    /**
     * コード:0 名称:特別地域加算対象外 略称:"対象外"
     */
    特別地域加算対象外("0", "特別地域加算対象外", "対象外"),
    /**
     * コード:1 名称:特別地域加算対象 略称:対象
     */
    特別地域加算対象("1", "特別地域加算対象", "対象");
    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokubetsuChikiKasanFlg(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特別地域加算フラグのコードを返します。
     *
     * @return 特別地域加算フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特別地域加算フラグの名称を返します。
     *
     * @return 特別地域加算フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特別地域加算フラグの略称を返します。
     *
     * @return 特別地域加算フラグの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特別地域加算フラグのコードと一致する内容を探します。
     *
     * @param code 特別地域加算フラグのコード
     * @return {@code code} に対応する特別地域加算フラグ
     */
    public static TokubetsuChikiKasanFlg toValue(RString code) {

        for (TokubetsuChikiKasanFlg flag : TokubetsuChikiKasanFlg.values()) {
            if (flag.code.equals(code)) {
                return flag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特別地域加算フラグ"));
    }
}
