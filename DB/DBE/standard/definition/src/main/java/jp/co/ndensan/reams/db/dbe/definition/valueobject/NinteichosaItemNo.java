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
 * 要介護認定調査の調査項目番号を表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaItemNo implements Comparable<NinteichosaItemNo>, IValueObject {

    private final RString 調査項目番号;

    /**
     * インスタンスを生成します。
     *
     * @param 調査項目番号 調査項目番号
     */
    public NinteichosaItemNo(RString 調査項目番号) {
        this.調査項目番号 = requireNonNull(調査項目番号, Messages.E00001.replace("調査項目番号").getMessage());
    }

    @Override
    public RString value() {
        return 調査項目番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof NinteichosaItemNo)) {
            return false;
        }
        return ((NinteichosaItemNo) 比較対象).value().equals(調査項目番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(調査項目番号);
        return hash;
    }

    @Override
    public int compareTo(NinteichosaItemNo 比較対象) {
        return 調査項目番号.compareTo(比較対象.value());
    }
}
