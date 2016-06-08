/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.inputshikibetsunocode;

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
 * 入力識別番号コードを表すクラスです。
 *
 */
// TODO dingn
//public class InputShikibetsuNoCode implements Comparable<InputShikibetsuNoCode>, IValueObject<Code>, IDbColumnMappable, IValidatable
public class InputShikibetsuNoCode implements Comparable<InputShikibetsuNoCode>, ICodeWrapValueObject, IDbColumnMappable, IValidatable {

    private final Code code;

    /**
     * {@link InputShikibetsuNoCode}のEMPTY値です。
     */
    public static final InputShikibetsuNoCode EMPTY;

    static {
        EMPTY = new InputShikibetsuNoCode(Code.EMPTY);
    }

    /**
     * 引数から入力識別番号コードを受け取り、インスタンスを生成します。
     *
     * @param code 入力識別番号コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public InputShikibetsuNoCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link InputShikibetsuNoCode}が持つCodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new InputShikibetsuNoCodeValidator(this).validate();
    }

    /**
     * {@link InputShikibetsuNoCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link InputShikibetsuNoCode}となるコード{@link Code}
     * @return {@link InputShikibetsuNoCode}
     * @throws IllegalArgumentException {@link InputShikibetsuNoCodeSpec}の仕様を満たさない場合
     */
    public static InputShikibetsuNoCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new InputShikibetsuNoCodeValidator(new InputShikibetsuNoCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new InputShikibetsuNoCode(code);
    }

//    public Code value() {
//        return this.code;
//    }
    @Override
    public int compareTo(InputShikibetsuNoCode 比較対象) {
        return this.value().compareTo(比較対象.value());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((InputShikibetsuNoCode) 比較対象).value().equals(this.value());
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
    public Code asCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RString value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
