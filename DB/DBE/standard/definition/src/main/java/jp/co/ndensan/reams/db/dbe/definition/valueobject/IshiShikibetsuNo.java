/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医師識別番号を表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class IshiShikibetsuNo implements Comparable<IshiShikibetsuNo>, IValueObject {

    private final RString 医師識別番号;

    /**
     * インスタンスを生成します。
     *
     * @param 医師識別番号 医師識別番号
     */
    public IshiShikibetsuNo(RString 医師識別番号) {
        this.医師識別番号 = requireNonNull(医師識別番号, Messages.E00001.replace("医師識別番号").getMessage());
    }

    @Override
    public RString value() {
        return 医師識別番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof IshiShikibetsuNo)) {
            return false;
        }
        return ((IshiShikibetsuNo) 比較対象).value().equals(医師識別番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(医師識別番号);
        return hash;
    }

    @Override
    public int compareTo(IshiShikibetsuNo 比較対象) {
        return 医師識別番号.compareTo(比較対象.value());
    }
}
