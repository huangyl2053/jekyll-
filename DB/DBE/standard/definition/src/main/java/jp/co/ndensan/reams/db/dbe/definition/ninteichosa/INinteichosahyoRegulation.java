/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;

/**
 * 要介護認定調査の調査票定義を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosahyoRegulation {

    /**
     * サービス状況調査の定義を返します。
     *
     * @return サービス状況調査の定義
     */
    Map<NinteichosaItemKubun, INinteichosaItem> getサービス状況調査定義();

    /**
     * 基本調査の定義を返します。
     *
     * @return 基本調査の定義
     */
    Map<NinteichosaItemKubun, INinteichosaItem> get基本調査定義();
}
