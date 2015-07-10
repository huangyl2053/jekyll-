/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例の適用事由の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum JushochitokureiTekiyoJiyu implements IShikakuIdoJiyu {

    /**
     * EMPTY <br />
     * 住所地自特例解除事由がないこと表す。<br />
     * コード : EMPTY
     */
    EMPTY("", ""),
    /**
     * 自特例適用 <br />
     * コード : 01
     */
    自特例適用("01", "自特例適用"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99", "その他");
    private final RString code;
    private final RString shortName;

    private JushochitokureiTekiyoJiyu(String code, String shortName) {
        this.code = new RString(code);
        this.shortName = new RString(shortName);
    }

    @Override
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString getName() {
        return shortName;
    }

    @Override
    public RString getShortName() {
        return shortName;
    }

    /**
     * 指定のコードに対応するJushochitokureiTekiyoJiyuを返します。
     * 空文字列、もしくはnullを受け取った場合は"EMPTY"を表すJushochitokureiTekiyoJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するJushochitokureiTekiyoJiyu
     * @throws IllegalArgumentException
     * 指定のコードに対応するJushochitokureiTekiyoJiyuがないとき。
     */
    public static JushochitokureiTekiyoJiyu toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (JushochitokureiTekiyoJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する住所地特例適用事由").evaluate());
    }
}
