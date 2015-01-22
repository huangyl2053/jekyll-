/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分を表すインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IYokaigoJotaiKubun {

    /**
     * コードを返します。
     *
     * @return コード
     */
    RString getCode();

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    RString getName();
}
