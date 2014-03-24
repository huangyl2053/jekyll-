/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の項目サブグループを扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiIkenshoItemSubGroup {

    /**
     * 意見書項目サブグループの番号を返します。
     *
     * @return 番号
     */
    RString getNo();

    /**
     * 意見書項目サブグループの表示名称を返します。
     *
     * @return 表示名称
     */
    RString getName();

    /**
     * 意見書項目サブグループの省略名称を返します。
     *
     * @return 省略名称
     */
    RString getShortName();

    /**
     * 意見書項目サブグループ内で複数選択が可能かどうか判定します。
     *
     * @return 複数選択が可能な場合はtrueを返します。
     */
    boolean isMultiSelectable();
}
