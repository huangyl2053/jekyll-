/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.tokuteishippeicode;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 特定疾病コードを保持するクラスです。
 *
 */
//public class TokuteiShippeiCode implements Comparable<TokuteiShippeiCode>, IValueObject<Code>, IDbColumnMappable, IValidatable {
public class TokuteiShippeiCode implements Comparable<TokuteiShippeiCode>, ICodeWrapValueObject, IDbColumnMappable, IValidatable {

    private final Code code;

    /**
     * {@link TokuteiShippeiCode}のEMPTY値です。
     */
    public static final TokuteiShippeiCode EMPTY;

    static {
        EMPTY = new TokuteiShippeiCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 値
     */
    public TokuteiShippeiCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("code"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link TokuteiShippeiCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new TokuteiShippeiCodeValidator(this).validate();
    }

    /**
     * {@link TokuteiShippeiCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link TokuteiShippeiCode}となるコード{@link Code}
     * @return {@link TokuteiShippeiCode}
     * @throws IllegalArgumentException {@link TokuteiShippeiCodeSpec}の仕様を満たさない場合
     */
    public static TokuteiShippeiCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new TokuteiShippeiCodeValidator(new TokuteiShippeiCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new TokuteiShippeiCode(code);
    }

    public Code asCode() {
        return this.code;
    }
//
//    @Override
//    public Code value() {
//        return this.code;
//    }

    @Override
    public int compareTo(TokuteiShippeiCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((TokuteiShippeiCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(TokuteiShippeiCode target) {
        return target.asCode().equals(this.code);
    }

    @Override
    public Code getColumnValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.code == null ? "" : this.code.toString();
    }

    @Override
    public RString value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
