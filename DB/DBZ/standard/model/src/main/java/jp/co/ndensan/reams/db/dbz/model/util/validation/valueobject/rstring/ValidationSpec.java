/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectValidationSpec;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.Unit;
import static jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.Unit.桁;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValueObjectCheckList;
import static jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValueObjectCheckList.checks;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValueObjectInfo;
import static jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValueObjectInfo.displayName;
import static jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring.RStringValueObjects.notNull;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
 *
 * @author N3327 三浦 凌
 */
public enum ValidationSpec implements IValueObjectValidationSpec<RString> {

    /**
     * 被保番号, 半角数字のみ可
     */
    被保番号_半角数("被保番号", Unit.桁, checks(notNull(), CharType.半角数のみ, Length.equal(10))),
    /**
     * 被保番号, 半角英数も可
     */
    被保番号_半角英数(displayName("被保険者番号").unit(桁), checks(notNull(), CharType.半角英数のみ, Length.equal(10)));

    private final IValueObjectInfo objInfo;
    private final ValueObjectCheckList<RString> checkItems;

    private ValidationSpec(ValueObjectInfo.IValueObjectInfoBuilder builder, ValueObjectCheckList<RString> checkItems) {
        this.objInfo = builder.build();
        this.checkItems = checkItems;
    }

    private ValidationSpec(String name, Unit unit, ValueObjectCheckList<RString> checkItems) {
        this.objInfo = ValueObjectInfo.of(name, unit);
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
