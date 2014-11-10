/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common.NotEmptyChecker;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectValidationSpec;
import static jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.Unit.桁;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectCheckList;
import static jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectCheckList.checks;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectInfo.IValueObjectInfoBuilder;
import static jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectInfo.displayName;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.common.NotNullChecker;
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
    public enum ValidationSpec implements IValueObjectValidationSpec<RString> {

        /**
         * 被保番号, 半角数字のみ可
         */
        被保番号_半角数(displayName("被保番号").unit(桁), checks(notNull(), CharType.半角数のみ, Length.equal(10))),
        /**
         * 被保番号, 半角英数も可
         */
        被保番号_半角英数(displayName("被保険者番号").unit(桁), checks(notNull(), CharType.半角英数のみ, Length.equal(10)));

        private final IValueObjectInfo objInfo;
        private final ValueObjectCheckList<RString> checkItems;

        private ValidationSpec(IValueObjectInfoBuilder builder, ValueObjectCheckList<RString> checkItems) {
            this.objInfo = builder.build();
            this.checkItems = checkItems;
        }

        @Override
        public IValueObjectInfo getValueObjectInfo() {
            return this.objInfo;
        }

        @Override
        public ValueObjectCheckList<RString> getCheckList() {
            return this.checkItems;
        }
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
