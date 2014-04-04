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
 * 主治医意見書の項目番号を表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoItemNo implements Comparable<ShujiiIkenshoItemNo>, IValueObject {

    private final RString 項目番号;

    /**
     * インスタンスを生成します。
     *
     * @param 項目番号 項目番号
     */
    public ShujiiIkenshoItemNo(RString 項目番号) {
        this.項目番号 = requireNonNull(項目番号, Messages.E00001.replace("項目番号").getMessage());
    }

    @Override
    public RString value() {
        return 項目番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof ShujiiIkenshoItemNo)) {
            return false;
        }
        return ((ShujiiIkenshoItemNo) 比較対象).value().equals(項目番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(項目番号);
        return hash;
    }

    @Override
    public int compareTo(ShujiiIkenshoItemNo 比較対象) {
        return 項目番号.compareTo(比較対象.value());
    }
}
