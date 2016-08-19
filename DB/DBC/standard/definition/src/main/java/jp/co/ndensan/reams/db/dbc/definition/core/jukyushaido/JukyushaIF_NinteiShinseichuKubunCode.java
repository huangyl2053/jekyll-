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
public enum JukyushaIF_NinteiShinseichuKubunCode {

    /**
     * コード:1 名称:申請無し 表示名称:申請無し
     */
    申請無し("1", "申請無し"),
    /**
     * コード:2 名称:申請中 表示名称:申請中
     */
    申請中("2", "申請中"),
    /**
     * コード:2 名称:決定済み 表示名称:決定済み
     */
    決定済み("3", "設定済み");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_NinteiShinseichuKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_認定申請中区分コードを返します。
     *
     * @return 受給者IF_認定申請中区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_認定申請中区分コードの名称を返します。
     *
     * @return 受給者IF_認定申請中区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_認定申請中区分コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_認定申請中区分コードのコード
     * @return {@code code} に対応する受給者IF_認定申請中区分コード
     */
    public static JukyushaIF_NinteiShinseichuKubunCode toValue(RString code) {

        for (JukyushaIF_NinteiShinseichuKubunCode jukyushaIF : JukyushaIF_NinteiShinseichuKubunCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_認定申請中区分コードのコード"));
    }
}
