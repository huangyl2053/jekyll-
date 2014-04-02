/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.business.IAnswerItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaItem {

    /**
     * 自身が調査結果項目なのか調査項目なのかを判定します。
     *
     * @return 調査結果項目の場合はtrueを返します。調査項目の場合はfalseを返します。
     */
    boolean is調査結果項目();

    /**
     * 調査項目グループを返します。
     *
     * @return 調査項目グループ
     */
    INinteichosaItemGroup get調査項目グループ();

    /**
     * 調査項目サブグループを返します。
     *
     * @return 調査項目サブグループ
     */
    INinteichosaItemSubGroup get調査項目サブグループ();

    /**
     * 調査項目グループ内番号を返します。<br />
     * 調査項目グループ内番号とは、調査項目グループ内における調査項目の順番です。
     *
     * @return 調査項目グループ内番号
     */
    int get調査項目グループ内番号();

    /**
     * 調査項目サブグループ内番号を返します。<br />
     * 調査項目サブグループ内番号とは、調査項目サブグループ内における調査項目の順番です。
     *
     * @return 調査項目サブグループ内番号
     */
    int get調査項目サブグループ内番号();

    /**
     * 調査項目番号を返します。
     *
     * @return 調査項目番号
     */
    NinteichosaItemNo get調査項目番号();

    /**
     * 調査項目区分を返します。
     *
     * @return 調査項目区分
     */
    INinteichosaItemKubun get調査項目区分();

    /**
     * 表示名称を返します。
     *
     * @return 表示名称
     */
    RString get表示名称();

    /**
     * 回答項目を返します。
     *
     * @return 回答項目
     */
    IAnswerItem get回答項目();
}
