/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 回答結果項目を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IAnswerResultItem {

    /**
     * 回答結果項目のコードを返します。
     *
     * @return コード
     */
    RString getCode();

    /**
     * 回答結果項目の値を返します。
     *
     * @return 値
     */
    RString getValue();
}
