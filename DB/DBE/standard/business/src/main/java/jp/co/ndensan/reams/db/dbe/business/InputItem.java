/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.IAnswerResultItem;
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

    @Override
    public boolean isWapperFor(Class<?> iface) {
        return iface.isInstance(this);
    }

    @Override
    public <T> T unwrap(Class<T> iface) {
        return iface.cast(this);
    }
}
