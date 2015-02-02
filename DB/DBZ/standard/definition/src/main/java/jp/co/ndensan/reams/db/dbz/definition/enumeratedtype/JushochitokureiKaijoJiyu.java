/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例の解除事由を表す列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum JushochitokureiKaijoJiyu implements IShikakuIdoJiyu {

    /**
     * EMPTY <br />
     * 住所地自特例解除事由がないこと表す。<br />
     * コード : EMPTY
     */
    EMPTY("", ""),
    /**
     * 自特例転入 <br />
     * コード : 01
     */
    自特例転入("01", "自特例転入"),
    /**
     * 自特例解除 <br />
     * コード : 02
     */
    自特例解除("02", "自特例解除"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99", "その他");
    private final RString code;
    private final RString shortName;

    private JushochitokureiKaijoJiyu(String code, String shortName) {
        this.code = new RString(code);
        this.shortName = new RString(shortName);
    }

    @Override
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString getName() {
        return new RString(name());
    }

    @Override
    public RString getShortName() {
        return shortName;
    }

    /**
     * 指定のコードに対応するJushochitokureiKaijoJiyuを返します。
     * 空文字列、もしくはnullを受け取った場合は<@code>JushochitokureiTekiyoJiyu.EMPTY</code>を返します。
     *
     * @param code コード
     * @return 指定のコードに対応するJushochitokureiKaijoJiyu
     * @throws IllegalArgumentException
     * 指定のコードに対応するJushochitokureiKaijoJiyuがないとき。
     */
    public static JushochitokureiKaijoJiyu toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }
        for (JushochitokureiKaijoJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する住所地特例解除事由").evaluate());
    }
}
