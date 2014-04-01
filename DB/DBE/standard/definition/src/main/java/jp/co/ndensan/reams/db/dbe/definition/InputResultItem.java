/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnswerResultItem;
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

    /**
     * 回答項目（入力項目）を返します。
     *
     * @return 回答項目（入力項目）
     */
    public static IAnswerItem getAnswerItem() {
        return new InputItem();
    }
}
