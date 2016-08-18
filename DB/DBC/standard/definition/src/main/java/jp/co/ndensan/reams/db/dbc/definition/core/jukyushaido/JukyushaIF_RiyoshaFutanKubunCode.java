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
public enum JukyushaIF_RiyoshaFutanKubunCode {
    /**
     * コード:1 名称:利用者負担 表示名称:利用者負担
     */
    利用者負担("1", "利用者負担"),

    /**
     * コード:2 名称:旧措置入所者利用者負担 表示名称:旧措置入所者利用者負担
     */
    旧措置入所者利用者負担("2", "旧措置入所者利用者負担");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_RiyoshaFutanKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_利用者負担区分コードを返します。
     *
     * @return 受給者IF_利用者負担区分コード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_減免申請中区分コードの名称を返します。
     *
     * @return 受給者IF_減免申請中区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_利用者負担区分コードと一致する内容を探します。
     *
     * @param code 受給者IF_利用者負担区分コード
     * @return {@code code} に対応する受給者IF_減免申請中区分コード
     */
    public static JukyushaIF_RiyoshaFutanKubunCode toValue(RString code) {

        for (JukyushaIF_RiyoshaFutanKubunCode jukyushaIF : JukyushaIF_RiyoshaFutanKubunCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_利用者負担区分コード"));
    }
}
