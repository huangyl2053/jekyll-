/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目情報を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaItem {

    /**
     * 調査票項目分類を返します。
     *
     * @return 調査票項目分類
     */
    IChosahyoItemGroup get調査票項目分類();

    /**
     * 調査項目番号を返します。
     *
     * @return 調査項目番号
     */
    NinteichosaItemNo get調査項目番号();

    /**
     * 調査票項目を返します。
     *
     * @return 調査票項目
     */
    ChosahyoItems get調査票項目();

    /**
     * 表示名称を返します。
     *
     * @return 表示名称
     */
    RString get表示名称();

    /**
     * 調査票項目の選択肢グループを返します。
     *
     * @return 選択肢グループ
     */
    IAnsweringItems get選択肢グループ();
}
