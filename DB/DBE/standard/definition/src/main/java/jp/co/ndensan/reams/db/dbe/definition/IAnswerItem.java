/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnswerResultItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 回答項目を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IAnswerItem {

    /**
     * 引数の値に該当する回答結果項目を返します。
     *
     * @param 値 値
     * @return 回答結果項目
     */
    IAnswerResultItem toValue(RString 値);
}
