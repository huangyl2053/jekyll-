/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医医療機関コードを表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIryoKikanCode implements Comparable<ShujiiIryoKikanCode>, IValueObject {

    private final RString 主治医医療機関コード;

    /**
     * インスタンスを生成します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     */
    public ShujiiIryoKikanCode(RString 主治医医療機関コード) {
        this.主治医医療機関コード = requireNonNull(主治医医療機関コード, Messages.E00001.replace("主治医医療機関コード").getMessage());
    }

    @Override
    public RString value() {
        return 主治医医療機関コード;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof ShujiiIryoKikanCode)) {
            return false;
        }
        return ((ShujiiIryoKikanCode) 比較対象).value().equals(主治医医療機関コード);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(主治医医療機関コード);
        return hash;
    }

    @Override
    public int compareTo(ShujiiIryoKikanCode 比較対象) {
        return 主治医医療機関コード.compareTo(比較対象.value());
    }
}
