/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteiyukokikantsukisu;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 認定有効期間月数を保持するクラスです。
 *
 */
public class NinteiYukoKikanTsukisu implements IValueObject<Integer>, Comparable<NinteiYukoKikanTsukisu>, IDbColumnMappable, IValidatable {

    private final Integer theValue;

    /**
     * コンストラクタです。<br/>
     *
     * @param value 値
     * @throws NullPointerException
     */
    public NinteiYukoKikanTsukisu(Integer value) throws NullPointerException {
        requireNonNull(value, UrSystemErrorMessages.値がnull.getReplacedMessage("value"));
        this.theValue = value;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link NinteiYukoKikanTsukisu}が持つvalueについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new NinteiYukoKikanTsukisuValidator(this).validate();
    }

    /**
     * {@link NinteiYukoKikanTsukisu}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のvalueについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param value {@link NinteiYukoKikanTsukisu}となる数字{@link Integer}
     * @return {@link NinteiYukoKikanTsukisu}
     * @throws IllegalArgumentException
     * {@link NinteiYukoKikanTsukisuSpec}の仕様を満たさない場合
     */
    public static NinteiYukoKikanTsukisu createCheckInstance(Integer value) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new NinteiYukoKikanTsukisuValidator(new NinteiYukoKikanTsukisu(value)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new NinteiYukoKikanTsukisu(value);
    }

    @Override
    public Integer value() {
        return this.theValue;
    }

    @Override
    public int compareTo(NinteiYukoKikanTsukisu target) {
        return this.theValue.compareTo(target.value());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((NinteiYukoKikanTsukisu) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + theValue;
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(NinteiYukoKikanTsukisu target) {
        return target.value().equals(this.theValue);
    }

    @Override
    public Integer getColumnValue() {
        return this.theValue;
    }

    @Override
    public String toString() {
        return this.theValue == null ? "" : this.theValue.toString();
    }
}
