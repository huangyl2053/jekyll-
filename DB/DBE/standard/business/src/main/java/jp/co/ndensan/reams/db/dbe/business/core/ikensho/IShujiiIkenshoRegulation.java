/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import jp.co.ndensan.reams.db.dbe.definition.core.ikensho.ShujiiIkenshoItemKubun;
import java.util.Map;

/**
 * 主治医意見書の定義を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
interface IShujiiIkenshoRegulation {

    /**
     * 主治医意見書の定義を返します。
     *
     * @return 主治医意見書の定義
     */
    Map<ShujiiIkenshoItemKubun, IShujiiIkenshoItem> get意見書定義();
}
