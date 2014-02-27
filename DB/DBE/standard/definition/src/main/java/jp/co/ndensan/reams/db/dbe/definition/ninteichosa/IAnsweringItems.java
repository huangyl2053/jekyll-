/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 回答項目のリストを扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IAnsweringItems {

    /**
     * 引数のコードに該当する回答項目を返します。
     *
     * @param コード コード
     * @return 回答項目
     */
    IAnsweringItem toValue(RString コード);

    /**
     * 回答項目のリストを返します。
     *
     * @return 回答項目のリスト
     */
    List<IAnsweringItem> asList();
}
