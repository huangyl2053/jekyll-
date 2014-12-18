/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分コードを表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum YokaigoJotaiKubun09 {

    /**
     * 要介護状態が「非該当」であることを表します。<br />
     * コード : 01
     */
    非該当("01"),
    /**
     * 要介護状態が「要支援1」であることを表します。<br />
     * コード : 12
     */
    要支援1("12"),
    /**
     * 要介護状態が「要支援2」であることを表します。<br />
     * コード : 13
     */
    要支援2("13"),
    /**
     * 要介護状態が「要介護1」であることを表します。<br />
     * コード : 21
     */
    要介護1("21"),
    /**
     * 要介護状態が「要介護2」であることを表します。<br />
     * コード : 221
     */
    要介護2("22"),
    /**
     * 要介護状態が「要介護3」であることを表します。<br />
     * コード : 23
     */
    要介護3("23"),
    /**
     * 要介護状態が「要介護4」であることを表します。<br />
     * コード : 24
     */
    要介護4("24"),
    /**
     * 要介護状態が「要介護5」であることを表します。<br />
     * コード : 25
     */
    要介護5("25"),
    /**
     * 要介護状態が「再調査」であることを表します。<br />
     * コード : 31
     */
    再調査("31"),
    /**
     * 要介護状態が「取消」であることを表します。<br />
     * コード : 88
     */
    取消("88"),
    /**
     * 要介護状態が「なし」であることを表します。<br />
     * コード : 99
     */
    なし("99");

    private final RString code;

    private YokaigoJotaiKubun09(String code) {
        this.code = new RString(code);
    }

    /**
     * RString型の台帳種別コードを返します。
     *
     * @return 台帳種別コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * RString型の要介護状態区分コードをもらい、コードに対応するYokaigoJotaiKubun09型のenumを返します。
     *
     * @param code 要介護状態区分コード
     * @return 引数のコードに対応するYokaigoJotaiKubun09型のenum
     */
    public static YokaigoJotaiKubun09 toValue(RString code) {
        for (YokaigoJotaiKubun09 data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

}
