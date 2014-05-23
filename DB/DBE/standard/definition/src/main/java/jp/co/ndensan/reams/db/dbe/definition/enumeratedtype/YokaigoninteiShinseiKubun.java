/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定の申請の種類を表す区分の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum YokaigoninteiShinseiKubun {

    /**
     * 新規申請 <br />
     * コード : "1"
     */
    新規申請("1"),
    /**
     * 更新申請 <br />
     * コード : "2"
     */
    更新申請("2"),
    /**
     * 区分変更申請 <br />
     * コード : "3"
     */
    区分変更申請("3"),
    /**
     * 職権 <br />
     * コード : "4"
     */
    職権("4"),
    /**
     * 転入申請 <br />
     * コード : "5"
     */
    転入申請("5");
    private final RString code;
    private final RString theName;

    private YokaigoninteiShinseiKubun(String code) {
        this.code = new RString(code);
        this.theName = new RString(name());
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
     * name()と同じ文字列をRString型で返します。
     *
     * @return name()と同じ文字列を持ったRString
     */
    public RString toRString() {
        return this.theName;
    }
}
