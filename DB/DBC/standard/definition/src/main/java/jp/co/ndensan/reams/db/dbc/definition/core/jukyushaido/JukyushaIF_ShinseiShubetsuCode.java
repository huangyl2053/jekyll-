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
public enum JukyushaIF_ShinseiShubetsuCode {
    /**
     * コード:1 名称:新規申請 表示名称:新規申請
     */
    新規申請("1", "新規申請"),
    /**
     * コード:2 名称:更新申請 表示名称:更新申請
     */
    更新申請("2", "更新申請"),
    /**
     * コード:3 名称:変更申請 表示名称:変更申請
     */
    変更申請("3", "変更申請"),
    /**
     * コード:4 名称:職権 表示名称:職権
     */
    職権("4", "職権");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_ShinseiShubetsuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_申請種別コードを返します。
     *
     * @return 受給者IF_申請種別コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_申請種別コードの名称を返します。
     *
     * @return 受給者IF_申請種別コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_申請種別コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_申請種別コードのコード
     * @return {@code code} に対応する受給者IF_申請種別コード
     */
    public static JukyushaIF_ShinseiShubetsuCode toValue(RString code) {

        for (JukyushaIF_ShinseiShubetsuCode jukyushaIF : JukyushaIF_ShinseiShubetsuCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_申請種別コードのコード"));
    }
}
