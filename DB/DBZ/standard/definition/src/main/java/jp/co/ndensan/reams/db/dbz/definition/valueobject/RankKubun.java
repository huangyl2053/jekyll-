/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * ランク区分です。
 *
 * @author N8156 宮本 康
 */
public class RankKubun implements IValueObject<RString>, Comparable<RankKubun> {

    private final RString ランク区分;

    /**
     * 指定の値をもったRankKubunを生成します。
     *
     * @param value ランク区分に相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public RankKubun(RString value) throws NullPointerException {
        requireNonNull(value, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        this.ランク区分 = value;
    }

    @Override
    public RString value() {
        return this.ランク区分;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((RankKubun) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.ランク区分);
        return hash;
    }

    @Override
    public int compareTo(RankKubun target) {
        return this.ランク区分.compareTo(target.value());
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(RankKubun target) {
        return target.value().equals(this.ランク区分);
    }
}
