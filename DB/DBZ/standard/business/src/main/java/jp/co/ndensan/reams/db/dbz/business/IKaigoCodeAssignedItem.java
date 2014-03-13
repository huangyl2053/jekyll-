/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コードマスタで管理する項目を扱うオブジェクトに、コードや名称を返す機能を提供するインタフェースです。 <br />
 * このインタフェースを実装するオブジェクトが持つのは、コードマスタ上の定義ではなく、
 * コードマスタ外のテーブルに格納された値(コード)と、それに対応する名称、略称でなければなりません。<br />
 * {@link #getCode}の返り値のクラスは、definitionに定義された独自のvalueObjectである必要があります。
 *
 * @author N3327 三浦 凌
 * @param <T> IValueObjectを実装したコードクラス
 */
public interface IKaigoCodeAssignedItem<T extends IValueObject> {

    /**
     * コードを返します。
     *
     * @return コード
     */
    T getCode();

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
