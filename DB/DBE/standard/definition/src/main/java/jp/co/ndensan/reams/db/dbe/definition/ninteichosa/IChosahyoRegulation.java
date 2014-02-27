/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;

/**
 * 要介護認定調査の調査票定義情報を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IChosahyoRegulation {

    /**
     * 調査票定義情報を返します。
     *
     * @return 調査票定義情報
     */
    Map<ChosahyoItems, INinteichosaItem> get調査票定義();
}
