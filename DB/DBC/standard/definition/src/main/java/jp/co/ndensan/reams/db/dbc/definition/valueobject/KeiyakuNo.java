/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 受領委任契約番号を表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public class KeiyakuNo implements IValueObject, Comparable<KeiyakuNo> {

    private final RString 契約番号;

    /**
     * 指定した値から契約番号を生成します。
     *
     * @param 契約番号 契約番号
     */
    public KeiyakuNo(RString 契約番号) {
        this.契約番号 = requireNonNull(契約番号, Messages.E00001.replace("契約番号").getMessage());
    }

    @Override
    public RString value() {
        return 契約番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KeiyakuNo)) {
            return false;
        }
        return ((KeiyakuNo) 比較対象).value().equals(契約番号);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.契約番号);
        return hash;
    }

    @Override
    public int compareTo(KeiyakuNo 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
