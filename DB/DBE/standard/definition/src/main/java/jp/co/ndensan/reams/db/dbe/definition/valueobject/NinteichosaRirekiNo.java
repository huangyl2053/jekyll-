/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * 要介護認定調査履歴番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaRirekiNo implements IValueObject<Integer> {

    private final int 履歴番号;

    public NinteichosaRirekiNo(int 履歴番号) {
        this.履歴番号 = 履歴番号;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.履歴番号;
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((NinteichosaRirekiNo) 比較対象).value().equals(this.value());
    }

    @Override
    public Integer value() {
        return 履歴番号;
    }
}
