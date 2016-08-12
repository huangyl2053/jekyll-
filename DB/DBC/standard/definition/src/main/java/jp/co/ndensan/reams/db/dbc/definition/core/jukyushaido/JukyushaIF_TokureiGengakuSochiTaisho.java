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
public enum JukyushaIF_TokureiGengakuSochiTaisho {
    /**
     * コード:1 名称:該当無し 表示名称:該当無し
     */
    該当無し("1", "該当無し"),
    /**
     * コード:2 名称:該当有り 表示名称:該当有り
     */
    該当有り("2", "該当有り");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_TokureiGengakuSochiTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_特例減額措置対象を返します。
     *
     * @return 受給者IF_特例減額措置対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_特例減額措置対象の名称を返します。
     *
     * @return 受給者IF_特例減額措置対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_特例減額措置対象のコードと一致する内容を探します。
     *
     * @param code 受給者IF_特例減額措置対象のコード
     * @return {@code code} に対応する受給者IF_特例減額措置対象
     */
    public static JukyushaIF_TokureiGengakuSochiTaisho toValue(RString code) {

        for (JukyushaIF_TokureiGengakuSochiTaisho jukyushaIF : JukyushaIF_TokureiGengakuSochiTaisho.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_特例減額措置対象のコード"));
    }
}
