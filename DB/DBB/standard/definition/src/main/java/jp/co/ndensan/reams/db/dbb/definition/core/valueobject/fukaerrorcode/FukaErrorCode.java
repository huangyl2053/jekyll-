/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.valueobject.fukaerrorcode;

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
 * 賦課のエラーコードを表すクラスです。
 *
 */
// TODO dingn
//public class FukaErrorCode implements Comparable<FukaErrorCode>, IValueObject<Code>, IDbColumnMappable, IValidatable
public class FukaErrorCode implements Comparable<FukaErrorCode>, ICodeWrapValueObject, IDbColumnMappable, IValidatable {

    private final Code errorCode;

    /**
     * {@link FukaErrorCode}のEMPTY値です。
     */
    public static final FukaErrorCode EMPTY;

    static {
        EMPTY = new FukaErrorCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param errorCode 賦課エラーコード
     * @throws NullPointerException 賦課エラーコード nullの場合
     */
    public FukaErrorCode(Code errorCode) throws NullPointerException {
        requireNonNull(errorCode, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課エラーコード"));
        this.errorCode = errorCode;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link FukaErrorCode}が持つerrorCodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new FukaErrorCodeValidator(this).validate();
    }

    /**
     * {@link FukaErrorCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のerrorCodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param errorCode {@link FukaErrorCode}となるコード{@link Code}
     * @return {@link FukaErrorCode}
     * @throws IllegalArgumentException {@link FukaErrorCodeSpec}の仕様を満たさない場合
     */
    public static FukaErrorCode createCheckInstance(Code errorCode) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new FukaErrorCodeValidator(new FukaErrorCode(errorCode)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new FukaErrorCode(errorCode);
    }

    public Code asCode() {
        return errorCode;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.errorCode);
        return hash;
    }

    @Override
    public int compareTo(FukaErrorCode target) {
        return this.errorCode.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((FukaErrorCode) target);
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(FukaErrorCode target) {
        return target.value().equals(this.errorCode.value());
    }

//    @Override
//    public Code value() {
//        return this.errorCode;
//    }
    @Override
    public Code getColumnValue() {
        return this.errorCode;
    }

    @Override
    public String toString() {
        return this.errorCode == null ? "" : this.errorCode.toString();
    }

    @Override
    public RString value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
