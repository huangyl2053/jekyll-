/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * 審査会開催番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaisaiNo implements IValueObject<Integer>, Comparable<ShinsakaiKaisaiNo> {

    private final int 審査会開催番号;

    /**
     * 審査会開催番号を受け取り、インスタンスを生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     */
    public ShinsakaiKaisaiNo(int 審査会開催番号) {
        this.審査会開催番号 = 審査会開催番号;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.審査会開催番号;
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ShinsakaiKaisaiNo) 比較対象).value().equals(this.value());
    }

    @Override
    public Integer value() {
        return 審査会開催番号;
    }

    @Override
    public int compareTo(ShinsakaiKaisaiNo 比較対象) {
        return this.value().compareTo(比較対象.value());
    }
}
