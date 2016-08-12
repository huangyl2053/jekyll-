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
 * @author DBC-2730-030 chenjie
 */
public enum JukyushaIF_HyojunFutanKubunCode {
    /**
     * コード:1 名称:標準負担 表示名称:標準負担
     */
    標準負担("1", "標準負担"),
    /**
     * コード:2 名称:特定標準負担 表示名称:特定標準負担
     */
    特定標準負担("2", "特定標準負担");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_HyojunFutanKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_標準負担区分コードを返します。
     *
     * @return 受給者IF_標準負担区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_標準負担区分コードの名称を返します。
     *
     * @return 受給者IF_標準負担区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_標準負担区分コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_標準負担区分コードのコード
     * @return {@code code} に対応する受給者IF_標準負担区分コード
     */
    public static JukyushaIF_HyojunFutanKubunCode toValue(RString code) {

        for (JukyushaIF_HyojunFutanKubunCode jukyushaIF : JukyushaIF_HyojunFutanKubunCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_標準負担区分コードのコード"));
    }
}
