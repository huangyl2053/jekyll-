/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.Unit;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.common.NotEmptyCheckers;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectValidatable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.common.NotNullCheker;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationChain;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * RString を保持するValueObjectに対するバリデーションの定義や、専用のバリデータを取得する機能を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class RStringValueObjects {

    private RStringValueObjects() {
    }

    /**
     * バリデーションの定義を行います。
     * <p>
     * 以下の様に定義をします。
     * <pre>
     * ①被保番号(②KaigoHihokenshaNo.class, ③Unit.桁, ④check(notNull(), CharType.半角数のみ, Length.equal(10))),
     *
     * ①: valueObjectの名前です。バリデーションのメッセージで用いられます。
     * ②: 対応するクラスです。
     * ③: valueObjectが持つ文字列の1文字をどのように数えるかを定義します。文字の長さをチェックをする時、バリデーションのメッセージで用いられます。
     * ④: check()の中にどのようなバリデーションを行うかを設定します。　任意の個数、設定できます。
     *     ・notNull()  … 保持する値としてnullを禁止します。
     *     ・notEmpty() … 保持する値としてRString.EMPTYを禁止します。
     *     ・CharType   … 文字列の種類を設定します。
     *     ・Length     … 文字列の長さに対する制約を設定します。
     *     上の例では、「null禁止」「半角数字のみ」「10桁」の3項目をチェックする、ということになります。
     * </pre>
     * </p>
     */
    private enum ValidationSpecifications implements IValueObjectValidatable<IValueObject<RString>> {

        被保番号(KaigoHihokenshaNo.class, Unit.桁, check(notNull(), CharType.半角数のみ, Length.equal(10)));

        private final Class<?> clazz;
        private final IValueObjectInfo objInfo;
        private final CheckItems checkItems;

        private <V extends IValueObject<RString>> ValidationSpecifications(Class<V> clazz, Unit unit, CheckItems checkItems) {
            this.clazz = clazz;
            this.objInfo = new ValueObjectInfo.Builder(new RString(name())).setUnit(unit).build();
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
         * 引数のclassに対応する IValueObjectValidatable を返します。
         *
         * @param type valueObjectのclass
         * @return 引数のclassに対応する IValueObjectValidatable
         * @throws IllegalArgumentException 引数のclassに対応する
         * IValueObjectValidatable が無い時
         */
        static <T extends IValueObject<RString>> IValueObjectValidatable getValidatable(Class<T> type) throws IllegalArgumentException {
            ValidationSpecifications validator = ClassToValue.get(type);
            if (validator != null) {
                return validator;
            }
            throw new IllegalArgumentException(new StringBuilder()
                    .append(type.getSimpleName())
                    .append("に対応するvalidatorがありません。必要な場合は作成してください。")
                    .toString()
            );
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

    /**
     * 引数のclass専用の{@link IValueObjectValidatable バリデーションロジック}を返します。
     *
     * @param <T> RStringを保持するvalueObjectの型
     * @param type RStringを保持するvalueObjectのclass
     * @return 引数のclass専用の{@link IValueObjectValidatable バリデーションロジック}
     */
    public static <T extends IValueObject<RString>> IValueObjectValidatable<T> validationFor(Class<T> type) {
        return ValidationSpecifications.getValidatable(type);
    }

//<editor-fold defaultstate="collapsed" desc="    private static class CheckItems {...}">
    private static class CheckItems implements Iterable<IValueObjectCheckable<RString>> {

        private final List<IValueObjectCheckable<RString>> list;

        CheckItems(List<IValueObjectCheckable<RString>> list) {
            this.list = list;
        }

        @Override
        public Iterator<IValueObjectCheckable<RString>> iterator() {
            return this.list.iterator();
        }
    }
//</editor-fold>

    private static CheckItems check(IValueObjectCheckable<RString>... validators) {
        return new CheckItems(Arrays.asList(validators));
    }

    static IValueObjectCheckable<RString> notNull() {
        return NotNullCheker.getInstance(RString.class);
    }

    static IValueObjectCheckable<RString> notEmpty() {
        return NotEmptyCheckers.RSTRING;
    }
}
