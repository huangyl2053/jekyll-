/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格異動の事由であることを意味するインタフェースです。
 *
 * @author N3327 三浦 凌
 */
public interface IShikakuIdoJiyu {

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

    /**
     * 略称を返します。
     *
     * @return 略称
     */
    RString getShortName();
}
