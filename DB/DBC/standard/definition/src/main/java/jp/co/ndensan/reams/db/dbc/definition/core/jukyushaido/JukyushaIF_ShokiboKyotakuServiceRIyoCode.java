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
public enum JukyushaIF_ShokiboKyotakuServiceRIyoCode {
    /**
     * コード:1 名称:利用無し 表示名称:利用無し
     */
    利用無し("1", "利用無し"),
    /**
     * コード:2 名称:利用有り 表示名称:利用有り
     */
    利用有り("2", "利用有り");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_ShokiboKyotakuServiceRIyoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_小規模居宅サービス利用コードを返します。
     *
     * @return 受給者IF_小規模居宅サービス利用コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_小規模居宅サービス利用コードの名称を返します。
     *
     * @return 受給者IF_小規模居宅サービス利用コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_小規模居宅サービス利用コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_小規模居宅サービス利用コードのコード
     * @return {@code code} に対応する受給者IF_小規模居宅サービス利用コード
     */
    public static JukyushaIF_ShokiboKyotakuServiceRIyoCode toValue(RString code) {

        for (JukyushaIF_ShokiboKyotakuServiceRIyoCode jukyushaIF : JukyushaIF_ShokiboKyotakuServiceRIyoCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_小規模居宅サービス利用コードのコード"));
    }
}
