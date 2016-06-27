/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_共同_高額_支給申請書出力有無コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu {

    /**
     * コード:1 名称:出力無し 表示名称:出力無し
     */
    出力無し("1", "出力無し"),
    /**
     * コード:2 名称:出力有り 表示名称:出力有り
     */
    出力有り("2", "出力有り");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_共同_高額_支給申請書出力有無コードのコードを返します。
     *
     * @return 受給者IF_共同_高額_支給申請書出力有無コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_共同_高額_支給申請書出力有無コードの名称を返します。
     *
     * @return 受給者IF_共同_高額_支給申請書出力有無コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_共同_高額_支給申請書出力有無コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_共同_高額_支給申請書出力有無コードのコード
     * @return {@code code} に対応する受給者IF_共同_高額_支給申請書出力有無コード
     */
    public static JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu toValue(RString code) {

        for (JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu jukyushaIF : JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_共同_高額_支給申請書出力有無コードのコード"));
    }
}
