/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の項目グループを扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiIkenshoItemGroup {

    /**
     * 意見書項目グループの番号を返します。
     *
     * @return 番号
     */
    RString getNo();

    /**
     * 意見書項目グループの表示名称を返します。
     *
     * @return 表示名称
     */
    RString getName();

    /**
     * 意見書項目グループの省略名称を返します。
     *
     * @return 省略名称
     */
    RString getShortName();
}
