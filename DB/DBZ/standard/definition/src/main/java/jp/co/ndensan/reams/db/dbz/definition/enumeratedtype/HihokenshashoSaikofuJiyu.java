/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証を再交付した事由の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum HihokenshashoSaikofuJiyu {

    /**
     * 被保険者再交付事由がないこと表す。<br />
     * コード : 00
     */
    なし("00"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99");
    private RString code;

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
     *
     * @param code コード
     * @return 指定のコードに対応するHihokenshashoSaikofuJiyu
     * @throws IllegalArgumentException
     * 指定のコードに対応するHihokenshashoSaikofuJiyuがないとき。
     */
    public static HihokenshashoSaikofuJiyu toValue(RString code) throws IllegalArgumentException {
        for (HihokenshashoSaikofuJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する被保険者証再交付事由").getMessage());
    }
}
