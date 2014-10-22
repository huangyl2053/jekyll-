/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationChain;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ValueObjectに対するバリデーターです。
 *
 * @author N3327 三浦 凌
 */
public final class RStringValueObjects {

    private RStringValueObjects() {
    }

    /**
     *
     * @param <T>
     * @param type
     * @return
     */
    public static <T extends IValueObject<RString>> IValueObjectValidatable<T> validationFor(Class<T> type) {
        return ValidationSpecifications.getValidatable(type);
    }

    private enum ValidationSpecifications implements IValueObjectValidatable<IValueObject<RString>> {

        被保番号(KaigoHihokenshaNo.class, Unit.桁, check(notNull(), CharType.半角数のみ, Length.equal(10)));

        private final Class<?> clazz;
        private final ValueObjectInfo objInfo;
        private final CheckItems checkItems;

        private <V extends IValueObject<RString>> ValidationSpecifications(Class<V> clazz, Unit unit, CheckItems checkItems) {
            this.clazz = clazz;
            this.objInfo = new ValueObjectInfo(new RString(name()), unit);
            this.checkItems = checkItems;
        }

        @Override
        public IValidationMessages validate(IValueObject<RString> valueObject) {
            ValidationChain chain = ValidationChain.validateFollowingItems();
            for (IValueObjectCheckable<RString> checkItem : this.checkItems) {
                chain.then(checkItem.check(valueObject, this.objInfo));
            }
            return chain.end();
        }

        private Class<?> type() {
            return this.clazz;
        }

        /**
         * 引数のクラスに対応する IValueObjectValidatable を返します。
         *
         * @param type clazz
         * @return クラスに対応する IValueObjectValidatable
         * @throws IllegalArgumentException クラスに対応する IValueObjectValidatable
         * が無い時
         */
        static <T extends IValueObject<RString>> IValueObjectValidatable getValidatable(Class<T> type) throws IllegalArgumentException {
            ValidationSpecifications validator = ClassToValue.get(type);
            if (validator != null) {
                return validator;
            }
            throw new IllegalArgumentException(new StringBuilder()
                    .append(type.getSimpleName())
                    .append("に対応するvalidatorがありません。必要な場合は作成してください。")
                    .toString());
        }

        //<editor-fold defaultstate="collapsed" desc="ClassToValue">
        private static final class ClassToValue {

            private static final Map<Class<?>, ValidationSpecifications> DICTHIONARY;

            static {
                Map<Class<?>, ValidationSpecifications> map = new HashMap<>();
                for (ValidationSpecifications value : values()) {
                    map.put(value.type(), value);
                }
                DICTHIONARY = Collections.unmodifiableMap(map);
            }

            static ValidationSpecifications get(Class<?> type) {
                return DICTHIONARY.get(type);
            }
        }
        //</editor-fold>
    }

//<editor-fold defaultstate="collapsed" desc="    private static class CheckItems {...}">
    private static class CheckItems implements Iterable<IValueObjectCheckable<RString>> {

        private final List<IValueObjectCheckable<RString>> list;

        CheckItems(List<IValueObjectCheckable<RString>> list) {
            this.list = list;
        }

        @Override
        public Iterator<IValueObjectCheckable<RString>> iterator() {
            return list.iterator();
        }
    }
//</editor-fold>

    private static CheckItems check(IValueObjectCheckable<RString>... validators) {
        return new CheckItems(Arrays.asList(validators));
    }

    private static IValueObjectCheckable<RString> notNull() {
        return NotNullCheker.getInstance(RString.class);
    }

    private static IValueObjectCheckable<RString> notEmpty() {
        return NotEmptyCheckers.RSTRING;
    }
}
