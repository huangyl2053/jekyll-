/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.Choices;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の項目を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujiiIkenshoItem {

    /**
     * 意見書項目グループを返します。
     *
     * @return 意見書項目グループ
     */
    IShujiiIkenshoItemGroup get意見書項目グループ();

    /**
     * 意見書項目サブグループを返します。
     *
     * @return 意見書項目サブグループ
     */
    IShujiiIkenshoItemSubGroup get意見書項目サブグループ();

    /**
     * 意見書項目グループ内番号を返します。<br />
     * 意見書項目グループ内番号とは、意見書項目グループ内における意見書項目の順番です。
     *
     * @return 項目グループ内番号
     */
    int get意見書項目グループ内番号();

    /**
     * 意見書項目サブグループ内番号を返します。<br />
     * 意見書項目サブグループ内番号とは、意見書項目サブグループ内における意見書項目の順番です。
     *
     * @return 項目サブグループ内番号
     */
    int get意見書項目サブグループ内番号();

    /**
     * 意見書項目番号を返します。
     *
     * @return 意見書項目番号
     */
    ShujiiIkenshoItemNo get意見書項目番号();

    /**
     * 意見書項目区分を返します。
     *
     * @return 意見書項目区分
     */
    IShujiiIkenshoItemKubun get意見書項目区分();

    /**
     * 表示名称を返します。
     *
     * @return 表示名称
     */
    RString get表示名称();

    /**
     * 意見書項目の選択肢を返します。
     *
     * @return 選択肢
     */
    Choices get選択肢();

    /**
     * 主要意見書項目かどうか判定します。
     *
     * @return 主要意見書項目の場合はtrueを返します。
     */
    boolean is主要意見書項目();
}
