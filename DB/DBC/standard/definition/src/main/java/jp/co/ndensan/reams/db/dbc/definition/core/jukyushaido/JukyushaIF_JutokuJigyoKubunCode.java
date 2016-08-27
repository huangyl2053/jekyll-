/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public enum JukyushaIF_JutokuJigyoKubunCode {
     /**
     * コード:1 名称:非該当 表示名称:非該当
     */
    非該当("1", "非該当"),
    /**
     * コード:2 名称:該当 表示名称:該当
     */
    該当("2", "該当");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_JutokuJigyoKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_住特事業区分コードを返します。
     *
     * @return 受給者IF_住特事業区分コード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_住特事業区分コードの名称を返します。
     *
     * @return 受給者IF_住特事業区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_住特事業区分コードと一致する内容を探します。
     *
     * @param code 受給者IF_住特事業区分コード
     * @return {@code code} に対応する受給者IF_住特事業区分コード
     */
    public static JukyushaIF_JutokuJigyoKubunCode toValue(RString code) {

        for (JukyushaIF_JutokuJigyoKubunCode jukyushaIF : JukyushaIF_JutokuJigyoKubunCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_住特事業区分コード"));
    }
}
