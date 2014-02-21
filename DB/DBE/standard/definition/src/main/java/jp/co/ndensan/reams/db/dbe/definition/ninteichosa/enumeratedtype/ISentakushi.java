/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目に対する選択肢を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface ISentakushi {

    /**
     * 選択肢のコードを返します。
     *
     * @return コード
     */
    RString getCode();

    /**
     * 選択肢の名称を返します。
     *
     * @return 名称
     */
    RString getName();
}
