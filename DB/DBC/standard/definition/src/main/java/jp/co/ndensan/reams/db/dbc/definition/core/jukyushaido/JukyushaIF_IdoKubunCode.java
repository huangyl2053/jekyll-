/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_異動区分コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum JukyushaIF_IdoKubunCode {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:変更 略称:定義なし
     */
    変更("2", "変更"),
    /**
     * コード:3 名称:終了 略称:定義なし
     */
    終了("3", "終了");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_IdoKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_異動区分コードのコードを返します。
     *
     * @return 受給者IF_異動区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_異動区分コードの名称を返します。
     *
     * @return 受給者IF_異動区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_異動区分コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_異動区分コードのコード
     * @return {@code code} に対応する受給者IF_異動区分コード
     */
    public static JukyushaIF_IdoKubunCode toValue(RString code) {

        for (JukyushaIF_IdoKubunCode jukyushaIF : JukyushaIF_IdoKubunCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_異動区分コードのコード"));
    }
}
