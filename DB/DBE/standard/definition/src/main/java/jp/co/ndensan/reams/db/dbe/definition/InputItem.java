/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnswerResultItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 回答項目（入力項目）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class InputItem implements IAnswerItem {

    /**
     * インスタンスを生成します。
     */
    public InputItem() {
    }

    @Override
    public IAnswerResultItem toValue(RString 値) {
        return new InputResultItem(値);
    }
}
