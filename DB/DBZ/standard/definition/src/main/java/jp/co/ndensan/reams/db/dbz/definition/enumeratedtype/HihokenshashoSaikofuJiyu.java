/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証を再交付した事由の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum HihokenshashoSaikofuJiyu {

    /**
     * 被保険者再交付事由が設定されていないことを表す。<br />
     * コード : なし
     */
    EMPTY(""),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99");
    private final RString code;

    private HihokenshashoSaikofuJiyu(String code) {
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
     * 指定のコードに対応するHihokenshashoSaikofuJiyuを返します。
     * 空文字列、もしくはnullを受け取った場合は<@code>HihokenshashoSaikofuJiyu.EMPTY</code>を返します。
     *
     * @param code コード
     * @return 指定のコードに対応するHihokenshashoSaikofuJiyu
     * @throws IllegalArgumentException
     * 指定のコードに対応するHihokenshashoSaikofuJiyuがないとき。
     */
    public static HihokenshashoSaikofuJiyu toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (HihokenshashoSaikofuJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage()
                .replace("コード:" + code + " に対応する被保険者証再交付事由").evaluate());
    }
}
