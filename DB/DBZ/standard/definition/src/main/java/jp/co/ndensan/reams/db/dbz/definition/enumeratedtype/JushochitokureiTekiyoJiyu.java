/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu.values;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例の適用事由の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum JushochitokureiTekiyoJiyu implements IShikakuIdoJiyu {

    /**
     * なし <br />
     * 住所地特例解除事由がないこと表す。<br />
     * コード : 00
     */
    なし("00"),
    /**
     * 自特例適用 <br />
     * コード : 05
     */
    自特例適用("05"),
    /**
     * 自特例転入 <br />
     * コード : 06
     */
    自特例転入("06"),
    /**
     * 自特例転入 <br />
     * コード : 10
     */
    自特例解除("10"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99");
    private final RString code;

    private JushochitokureiTekiyoJiyu(String code) {
        this.code = new RString(code);
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
        return new RString(name());
    }

    /**
     * 指定のコードに対応するJushochitokureiTekiyoJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するJushochitokureiTekiyoJiyu
     * @throws IllegalArgumentException
     * 指定のコードに対応するJushochitokureiTekiyoJiyuがないとき。
     */
    public static JushochitokureiTekiyoJiyu toValue(RString code) throws IllegalArgumentException {
        for (JushochitokureiTekiyoJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する住所地特例適用事由").getMessage());
    }
}
