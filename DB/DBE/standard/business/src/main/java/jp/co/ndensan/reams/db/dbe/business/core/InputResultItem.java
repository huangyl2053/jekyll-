/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core;

import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.IAnswerResultItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 回答結果項目（入力結果項目）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class InputResultItem implements IAnswerResultItem {

    private final RString value;

    /**
     * インスタンスを生成します。
     *
     * @param value 入力値
     */
    public InputResultItem(RString value) {
        this.value = value;
    }

    @Override
    public RString getCode() {
        return value;
    }

    @Override
    public RString getValue() {
        return value;
    }
}
