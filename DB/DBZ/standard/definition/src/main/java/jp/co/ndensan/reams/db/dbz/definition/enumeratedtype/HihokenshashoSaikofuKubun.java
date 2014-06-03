/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証再交付の有無についての列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum HihokenshashoSaikofuKubun {

    /**
     * 被保険者証の再交付があることを表す。<br />
     * コード : 1
     */
    あり("1"),
    /**
     * 被保険者証の再交付がないこと表す。<br />
     * コード : 2
     */
    なし("2");
    private final RString code;

    private HihokenshashoSaikofuKubun(String code) {
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
     * 指定のコードに対応するHihokenshashoSaikofuKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するHihokenshashoSaikofuKubun
     * @throws IllegalArgumentException
     * 指定のコードに対応するHihokenshashoSaikofuKubunがないとき。
     */
    public static HihokenshashoSaikofuKubun toValue(RString code) throws IllegalArgumentException {
        for (HihokenshashoSaikofuKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する被保険者証再交付区分").getMessage());
    }
}
