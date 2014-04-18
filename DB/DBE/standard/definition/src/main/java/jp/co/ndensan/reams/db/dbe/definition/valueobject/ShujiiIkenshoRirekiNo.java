/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 主治医意見書の履歴番号を表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoRirekiNo implements Comparable<ShujiiIkenshoRirekiNo>, IValueObject, IDbColumnMappable {

    private final Integer 履歴番号;

    /**
     * インスタンスを生成します。
     *
     * @param 履歴番号 履歴番号
     */
    public ShujiiIkenshoRirekiNo(int 履歴番号) {
        this.履歴番号 = Integer.valueOf(履歴番号);
    }

    @Override
    public Integer value() {
        return 履歴番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof ShujiiIkenshoRirekiNo)) {
            return false;
        }
        return ((ShujiiIkenshoRirekiNo) 比較対象).value().equals(履歴番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(履歴番号);
        return hash;
    }

    @Override
    public int compareTo(ShujiiIkenshoRirekiNo 比較対象) {
        return 履歴番号 - 比較対象.value();
    }

    @Override
    public Integer getColumnValue() {
        return 履歴番号;
    }
}
