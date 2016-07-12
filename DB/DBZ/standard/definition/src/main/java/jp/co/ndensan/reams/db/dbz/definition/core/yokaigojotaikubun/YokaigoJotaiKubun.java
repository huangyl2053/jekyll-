/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * すべての要介護状態区分を管理します。
 * <p/>
 * 要介護状態区分については、これまでの法改正で何度も見直されていますが、
 * コードとそれに対応する状態の関係については変わっていません。
 * このenumでは、歴代の要介護状態区分コードと対応する状態について、全般的に管理します。
 */
public enum YokaigoJotaiKubun {

    /**
     * 非該当
     */
    非該当("01"),
    /**
     * 事業対象者
     */
    事業対象者("06"),
    /**
     * みなし非該当
     */
    みなし非該当("09"),
    /**
     * 経過的要介護
     */
    要支援_経過的要介護("11"),
    /**
     * 要支援1
     */
    要支援1("12"),
    /**
     * 要支援2
     */
    要支援2("13"),
    /**
     * みなし要支援
     */
    みなし要支援("19"),
    /**
     * 要介護1
     */
    要介護1("21"),
    /**
     * 要介護2
     */
    要介護2("22"),
    /**
     * 要介護3
     */
    要介護3("23"),
    /**
     * 要介護4
     */
    要介護4("24"),
    /**
     * 要介護5
     */
    要介護5("25"),
    /**
     * 再調査
     */
    再調査("31"),
    /**
     * 照会
     */
    照会("32"),
    /**
     * 取消
     */
    取消("88"),
    /**
     * 保留
     */
    保留("98"),
    /**
     * なし
     */
    なし("99");

    private final RString aCode;

    private YokaigoJotaiKubun(String code) {
        this.aCode = new RString(code);
    }

    /**
     * コードを返却します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.aCode;
    }
}
