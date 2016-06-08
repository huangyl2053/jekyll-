/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_共同_高額_老齢福祉年金受給有無を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu {

    /**
     * コード:1 名称:受給無し 表示名称:受給無し
     */
    受給無し("1", "受給無し"),
    /**
     * コード:2 名称:受給有り 表示名称:受給有り
     */
    受給有り("2", "受給有り");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_共同_高額_老齢福祉年金受給有無のコードを返します。
     *
     * @return 受給者IF_共同_高額_老齢福祉年金受給有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_共同_高額_老齢福祉年金受給有無の名称を返します。
     *
     * @return 受給者IF_共同_高額_老齢福祉年金受給有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_共同_高額_老齢福祉年金受給有無のコードと一致する内容を探します。
     *
     * @param code 受給者IF_共同_高額_老齢福祉年金受給有無のコード
     * @return {@code code} に対応する受給者IF_共同_高額_老齢福祉年金受給有無
     */
    public static JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu toValue(RString code) {

        for (JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu jukyushaIF : JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_共同_高額_老齢福祉年金受給有無のコード"));
    }
}
