/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition;

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
    資格取得(new RString("1")),
    /**
     * 介護保険資格の変更に該当します。
     */
    資格変更(new RString("2")),
    /**
     * 介護保険資格を喪失した場合に該当します。
     */
    資格喪失(new RString("3"));
    private final RString code;

    private ShikakuIdoKubun(RString コード) {
        this.code = コード;
    }

    /**
     * コードを取得します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 指定したコードの資格異動区分を取得します。
     *
     * @param コード コード
     * @return 対応する資格異動区分
     */
    public static ShikakuIdoKubun toValue(RString コード) {
        for (ShikakuIdoKubun shikakuIdoKubun : ShikakuIdoKubun.values()) {
            if (shikakuIdoKubun.getCode().equals(コード)) {
                return shikakuIdoKubun;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace(コード + "に対応する資格異動区分").getMessage());
    }
}
