/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 審査会開催年月日を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaisaiDate implements IValueObject<FlexibleDate>, Comparable<ShinsakaiKaisaiDate> {

    private final FlexibleDate 審査会開催年月日;

    /**
     * 指定の値を持った、審査会開催年月日を生成します。
     *
     * @param 審査会開催年月日 審査会開催年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShinsakaiKaisaiDate(FlexibleDate 審査会開催年月日) throws NullPointerException {
        requireNonNull(審査会開催年月日, Messages.E00003.replace("審査会開催年月日", getClass().getName()).getMessage());
        this.審査会開催年月日 = 審査会開催年月日;
    }

    @Override
    public FlexibleDate value() {
        return this.審査会開催年月日;
    }

    @Override
    public int compareTo(ShinsakaiKaisaiDate target) {
        return this.審査会開催年月日.compareTo(target.value());
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (isNull(比較対象) || isNotSameClass(比較対象.getClass())) {
            return false;
        }
        return hasSameValue((ShinsakaiKaisaiDate) 比較対象);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.審査会開催年月日);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ShinsakaiKaisaiDate target) {
        return target.value().equals(this.審査会開催年月日);
    }
}
