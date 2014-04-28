/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定の申請者の区分です。
 *
 * @author N3327 三浦 凌
 */
public enum YokaigoninteiShinseishaKubun {

    /**
     * 本人 <br />
     * コード: "1"
     */
    本人("1"),
    /**
     * 家族 <br />
     * コード : "2"
     */
    家族("2"),
    /**
     * 施設職員 <br />
     * コード : "3"
     */
    施設職員("3"),
    /**
     * その他 <br />
     * コード : "9"
     */
    その他("9");

    private final RString code;
    private final RString name;

    private YokaigoninteiShinseishaKubun(String code) {
        this.code = new RString(code);
        this.name = new RString(name());
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
     * {@link #name() name()}と同じ文字列をRStringで返します。
     *
     * @return {@link #name() name()}と同じ文字列を持ったRString
     */
    public RString toRString() {
        return this.name;
    }

    /**
     * コードからYokaigoninteiShinseishaへ変換します。
     *
     * @param code コード
     * @return コードに対応するYokaigoninteiShinseisha
     */
    public static YokaigoninteiShinseishaKubun toValue(RString code) {
        for (YokaigoninteiShinseishaKubun kubun : values()) {
            if (kubun.getCode().equals(code)) {
                return kubun;
            }
        }
        return その他;
    }
}
