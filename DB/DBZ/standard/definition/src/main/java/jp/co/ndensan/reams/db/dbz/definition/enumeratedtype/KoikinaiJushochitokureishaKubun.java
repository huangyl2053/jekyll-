/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内住所地特例者区分の列挙型です。<br />
 * 広域内の住所地特例者かどうかを表します。
 *
 * @author N3327 三浦 凌
 */
public enum KoikinaiJushochitokureishaKubun {

    /**
     * EMPTY <br />
     * コード : EMPTY
     */
    EMPTY(""),
    /**
     * 広域内住所地特例者 <br />
     * コード : 1
     */
    広域内住所地特例者("1"),
    /**
     * 通常資格者 <br />
     * コード : 2
     */
    通常資格者("2");
    private final RString code;

    private KoikinaiJushochitokureishaKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 指定のコードに対応するKoikinaiJushochitokureishaKubunを返します。<br/>
     * 空文字列、もしくはnullを受け取った場合は"EMPTY"を表すKoikinaiJushochitokureishaKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するKoikinaiJushochitokureishaKubun
     * @throws IllegalArgumentException
     * 指定のコードに対応するKoikinaiJushochitokureishaKubunがないとき。
     */
    public static KoikinaiJushochitokureishaKubun toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (KoikinaiJushochitokureishaKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する広域内住所地特例者区分").evaluate());
    }
}
