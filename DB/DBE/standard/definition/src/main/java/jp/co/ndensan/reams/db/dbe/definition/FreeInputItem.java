/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定の各種項目における自由入力項目の情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class FreeInputItem implements IAnsweringItem {

    private final RString value;

    /**
     * インスタンスを生成します。
     *
     * @param value 入力値
     */
    public FreeInputItem(RString value) {
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
