/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_有料老人ホーム等同意書の有無。
 *
 * @author DBC-2740-010 fuyanling
 */
public enum JukyushaIF_YuryoRojinHomeDoishoUmu {

    /**
     * コード:1 名称:無し 表示名称:無し
     */
    無し("1", "無し"),
    /**
     * コード:2 名称:有り 表示名称:有り
     */
    有り("2", "有り");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_YuryoRojinHomeDoishoUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_有料老人ホーム等同意書の有無を返します。
     *
     * @return 受給者IF_有料老人ホーム等同意書の有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_有料老人ホーム等同意書の有無の名称を返します。
     *
     * @return 受給者IF_有料老人ホーム等同意書の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_有料老人ホーム等同意書の有無のコードと一致する内容を探します。
     *
     * @param code 受給者IF_有料老人ホーム等同意書の有無のコード
     * @return {@code code} に対応する受給者IF_有料老人ホーム等同意書の有無
     */
    public static JukyushaIF_YuryoRojinHomeDoishoUmu toValue(RString code) {

        for (JukyushaIF_YuryoRojinHomeDoishoUmu jukyushaIF : JukyushaIF_YuryoRojinHomeDoishoUmu.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_有料老人ホーム等同意書の有無のコード"));
    }
}
