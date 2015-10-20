/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.yokaigojotaikubuncode;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 要介護状態区分コードを保持するクラスです。
 *
 */
public class YokaigoJotaiKubunCode implements Comparable<YokaigoJotaiKubunCode>, IValueObject<Code>, IDbColumnMappable, IValidatable {

    private final Code code;

    /**
     * {@link YokaigoJotaiKubunCode}のEMPTY値です。
     */
    public static final YokaigoJotaiKubunCode EMPTY;

    static {
        EMPTY = new YokaigoJotaiKubunCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 値
     */
    public YokaigoJotaiKubunCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("code"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link YokaigoJotaiKubunCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new YokaigoJotaiKubunCodeValidator(this).validate();
    }

    /**
     * {@link YokaigoJotaiKubunCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link YokaigoJotaiKubunCode}となるコード{@link Code}
     * @return {@link YokaigoJotaiKubunCode}
     * @throws IllegalArgumentException
     * {@link YokaigoJotaiKubunCodeSpec}の仕様を満たさない場合
     */
    public static YokaigoJotaiKubunCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new YokaigoJotaiKubunCodeValidator(new YokaigoJotaiKubunCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new YokaigoJotaiKubunCode(code);
    }

    public Code asCode() {
        return this.code;
    }

    @Override
    public Code value() {
        return this.code;
    }

    @Override
    public int compareTo(YokaigoJotaiKubunCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((YokaigoJotaiKubunCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(YokaigoJotaiKubunCode target) {
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
}
