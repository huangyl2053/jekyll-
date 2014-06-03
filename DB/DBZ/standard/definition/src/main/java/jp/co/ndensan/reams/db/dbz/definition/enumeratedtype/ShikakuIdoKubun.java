/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 介護保険の資格異動を表す区分の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuIdoKubun {

    /**
     * 介護保険資格を新たに取得した場合に該当します。
     */
    資格取得("1"),
    /**
     * 介護保険資格の変更に該当します。
     */
    資格変更("2"),
    /**
     * 介護保険資格を喪失した場合に該当します。
     */
    資格喪失("3");
    private final RString code;

    private ShikakuIdoKubun(String code) {
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
     * 指定のコードに対応するShikakuIdoKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuIdoKubun
     * @throws IllegalArgumentException 指定のコードに対応するShikakuIdoKubunがないとき。
     */
    public static ShikakuIdoKubun toValue(RString code) throws IllegalArgumentException {
        for (ShikakuIdoKubun shikakuIdoKubun : ShikakuIdoKubun.values()) {
            if (shikakuIdoKubun.getCode().equals(code)) {
                return shikakuIdoKubun;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する資格異動区分").getMessage());
    }
}
