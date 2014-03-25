/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * 意見書作成依頼履歴番号を表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class IkenshosakuseiIraiRirekiNo implements Comparable<IkenshosakuseiIraiRirekiNo>, IValueObject {

    private final int 意見書作成依頼履歴番号;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     */
    public IkenshosakuseiIraiRirekiNo(int 意見書作成依頼履歴番号) {
        this.意見書作成依頼履歴番号 = 意見書作成依頼履歴番号;
    }

    @Override
    public Integer value() {
        return Integer.valueOf(意見書作成依頼履歴番号);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof IkenshosakuseiIraiRirekiNo)) {
            return false;
        }
        return ((IkenshosakuseiIraiRirekiNo) 比較対象).value().equals(意見書作成依頼履歴番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(意見書作成依頼履歴番号);
        return hash;
    }

    @Override
    public int compareTo(IkenshosakuseiIraiRirekiNo 比較対象) {
        return 意見書作成依頼履歴番号 - 比較対象.value();
    }
}
