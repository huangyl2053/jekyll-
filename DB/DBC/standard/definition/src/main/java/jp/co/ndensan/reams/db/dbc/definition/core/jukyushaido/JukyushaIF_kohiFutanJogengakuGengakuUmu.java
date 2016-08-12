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
public enum JukyushaIF_kohiFutanJogengakuGengakuUmu {
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

    private JukyushaIF_kohiFutanJogengakuGengakuUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_公費負担上限額減額有無を返します。
     *
     * @return 受給者IF_公費負担上限額減額有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_公費負担上限額減額有無の名称を返します。
     *
     * @return 受給者IF_公費負担上限額減額有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_公費負担上限額減額有無のコードと一致する内容を探します。
     *
     * @param code 受給者IF_公費負担上限額減額有無のコード
     * @return {@code code} に対応する受給者IF_公費負担上限額減額有無
     */
    public static JukyushaIF_kohiFutanJogengakuGengakuUmu toValue(RString code) {

        for (JukyushaIF_kohiFutanJogengakuGengakuUmu jukyushaIF : JukyushaIF_kohiFutanJogengakuGengakuUmu.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_公費負担上限額減額有無のコード"));
    }
}
