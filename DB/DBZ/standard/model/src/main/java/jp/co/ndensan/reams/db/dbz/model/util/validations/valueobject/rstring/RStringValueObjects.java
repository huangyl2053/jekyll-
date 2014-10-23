/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.Unit;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common.NotEmptyChecker;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.model.util.function.ISupplier;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectValidatable;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common.NotNullChecker;
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
     * RStringを保持するvalueObject用のバリデーションの定義です。
     * <p>
     * 以下の様に定義をします。
     * <pre>
     * ①被保番号(②nameToDisplay("被保番号"), ③Unit.桁, ④check(notNull(), CharType.半角英数のみ, Length.equal(10)))
     *
     * ①: 定義自体の名前です。外から定義を参照する際に用います。
     * ②: バリデーションのメッセージで用いる、valueObjectを表す名前です。
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
    public enum Definitions {

        /**
         * 被保番号, 半角数字のみ可
         */
        被保番号_半角数(nameToDisplay("被保番号"), Unit.桁, check(notNull(), CharType.半角数のみ, Length.equal(10))),
        /**
         * 被保番号, 半角英数も可
         */
        被保番号_半角英数(nameToDisplay("被保番号"), Unit.桁, check(notNull(), CharType.半角英数のみ, Length.equal(10)));

        private final IValueObjectInfo objInfo;
        private final CheckItems checkItems;

        private Definitions(ISupplier<RString> dispName, Unit unit, CheckItems checkItems) {
            this.objInfo = new ValueObjectInfo.Builder(dispName.get()).setUnit(unit).build();
            this.checkItems = checkItems;
        }
    }

    /**
     * 指定の定義と対象のvalueObjectのclassから、バリデーションロジックを生成して返します。
     *
     * @param <T> valueObjectの型
     * @param def バリデーションの定義
     * @param clazz valueObjectのclass
     * @return 指定の定義と対象のvalueObjectのclassに対応する、バリデーションロジック
     */
    public static <T extends IValueObject<RString>> IValueObjectValidatable<T> createValidation(Definitions def, Class<T> clazz) {
        return new _RStringValueObjectValidator<>(def);
    }

    //<editor-fold defaultstate="collapsed" desc="private static final class _RStringValueObjectValidator{...}">
    private static final class _RStringValueObjectValidator<T extends IValueObject<RString>> implements IValueObjectValidatable<T> {

        private final IValueObjectInfo objInfo;
        private final CheckItems checkItems;

        private <T extends IValueObject<RString>> _RStringValueObjectValidator(Definitions a) {
            this.objInfo = a.objInfo;
            this.checkItems = a.checkItems;
        }

        @Override
        public IValidationMessages validate(T v) {
            ValidationChain chain = ValidationChain.validateFollowingItems();
            for (IValueObjectCheckable<RString> checkItem : this.checkItems) {
                chain.then(checkItem.check(v, this.objInfo));
            }
            return chain.end();
        }
    }
    //</editor-fold>

    /**
     * Definitions において、表示する名前を定義するのに用います。
     *
     * @param name 表示する名前
     * @return 表示する名前を返すsupplier
     */
    private static ISupplier<RString> nameToDisplay(final String name) {
        Objects.requireNonNull(name);
        //<editor-fold defaultstate="collapsed" desc="return ()->{return new RString(name);};">
        return new ISupplier<RString>() {
            @Override
            public RString get() {
                return new RString(name);
            }
        };
        //</editor-fold>
    }

    /**
     * {@literal IValueObjectCheckable<RString>}のlistを持ちます。<br/>
     * Definitions で、チェック項目を定義する際に用います。
     */
    //<editor-fold defaultstate="collapsed" desc="private static class CheckItems {...}">
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

    /**
     * Definitions で、チェックする項目を定義するのに用います。
     * {@literal IValueObjectCheckable<RString>}を複数受け取り、CheckItems を生成します。
     *
     * @param validators チェック項目
     * @return CheckItems
     */
    private static CheckItems check(IValueObjectCheckable<RString>... validators) {
        return new CheckItems(Arrays.asList(validators));
    }

    /**
     * valueObject自身、または、その保持する{@link RString RString}がnullでないことを、調べるインスタンスを返します。
     *
     * @return nullでないことを調べるインスタンス
     */
    public static IValueObjectCheckable<RString> notNull() {
        return NotNullChecker.getInstance(RString.class);
    }

    /**
     * valueObjectの保持する{@link RString RString}が{@link RString#EMPTY RStirng.EMPTY}でないことを、調べるインスタンスを返します。
     *
     * @return {@link RString#EMPTY RStirng.EMPTY}でないことを調べるインスタンス
     */
    public static IValueObjectCheckable<RString> notEmpty() {
        return NotEmptyChecker.forRString();
    }
}
