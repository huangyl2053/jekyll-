/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免・徴収猶予状態区分の列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum GemmenChoshuYuyoStateKubun {

    /**
     * 申請 <br />
     * コード : 0
     */
    申請("0"),
    /**
     * 決定（承認） <br />
     * コード : 1
     */
    決定_承認("1"),
    /**
     * 決定（不承認） <br />
     * コード : 2
     */
    決定_不承認("2"),
    /**
     * 取消 <br />
     * コード : 3
     */
    取消("3"),
    /**
     * 論理削除 <br />
     * コード : 9
     */
    論理削除("9");
    private final RString code;

    private GemmenChoshuYuyoStateKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.code;
    }

    /**
     * 指定のコードに対応するGemmenChoshuYuyoStateKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するGemmenChoshuYuyoStateKubun
     * @throws IllegalArgumentException
     * 指定のコードに対応するGemmenChoshuYuyoStateKubunがないとき
     */
    public static GemmenChoshuYuyoStateKubun toValue(RString code) throws IllegalArgumentException {
        for (GemmenChoshuYuyoStateKubun target : values()) {
            if (target.code().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する減免・徴収猶予状態区分").evaluate());
    }
}
