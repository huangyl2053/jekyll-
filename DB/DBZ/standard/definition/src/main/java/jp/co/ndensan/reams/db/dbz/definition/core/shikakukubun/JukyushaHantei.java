/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者判定を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 surun
 */
public enum JukyushaHantei {

    /**
     * コード:1 名称:１号被保険者全てで抽出
     */
    _1号被保険者全て("1", "１号被保険者全て"),
    /**
     * コード:2 名称:受給者のみで抽出
     */
    受給者のみ("2", "受給者のみ");

    private final RString code;
    private final RString fullName;

    private JukyushaHantei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者判定のコードを返します。
     *
     * @return 受給者判定のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者判定の名称を返します。
     *
     * @return 受給者判定の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者判定のコードと一致する内容を探します。
     *
     * @param code 受給者判定のコード
     * @return {@code code} に対応する受給者判定
     */
    public static JukyushaHantei toValue(RString code) {
        for (JukyushaHantei jukyushaHantei : JukyushaHantei.values()) {
            if (jukyushaHantei.code.equals(code)) {
                return jukyushaHantei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給者判定"));
    }
}
