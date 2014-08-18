/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会優先割付区分を表す列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum ShinsakaiYusenWaritsukeKubun {

    /**
     * コード : 1
     */
    優先する("1"),
    /**
     * コード : 2
     */
    優先しない("2");
    private final RString theCode;

    private ShinsakaiYusenWaritsukeKubun(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.theCode;
    }

    /**
     * デフォルト値を返します。
     *
     * @return デフォルトのShinsakaiYusenWarituskeKubun
     */
    public static ShinsakaiYusenWaritsukeKubun defaultValue() {
        return 優先しない;
    }

    /**
     * 指定のコードをもつ、ShinsakaiYusenWaritsukeKubunを返します。 <br/>
     * 一致するコードを持ったオブジェクトがないときは、 {@link #defaultValue() defalutValue()}と同値を返します。
     *
     * @param code コード
     * @return ShinsakaiYusenWaritsukeKubun
     */
    public static ShinsakaiYusenWaritsukeKubun toValue(RString code) {
        for (ShinsakaiYusenWaritsukeKubun value : values()) {
            if (value.code().equals(code)) {
                return value;
            }
        }
        return defaultValue();
    }
}
