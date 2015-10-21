/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hihokenshakubuncode;

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
 * 被保険者区分を表すコードです。
 *
 */
// TODO HihokenshaKubunコンパイルできるため、臨時「ICodeWrapValueObject」をINTERFACEする　dingn
//public class HihokenshaKubunCode implements Comparable<HihokenshaKubunCode>, IValueObject<Code>, IDbColumnMappable, IValidatable {
public class HihokenshaKubunCode implements Comparable<HihokenshaKubunCode>, ICodeWrapValueObject, IDbColumnMappable, IValidatable {

    private final Code code;

    /**
     * {@link HihokenshaKubunCode}のEMPTY値です。
     */
    public static final HihokenshaKubunCode EMPTY;

    static {
        EMPTY = new HihokenshaKubunCode(Code.EMPTY);
    }

    /**
     * 引数から被保険者区分コードを受け取り、インスタンスを生成します。
     *
     * @param code 被保険者区分
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public HihokenshaKubunCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link HihokenshaKubunCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new HihokenshaKubunCodeValidator(this).validate();
    }

    /**
     * {@link HihokenshaKubunCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link HihokenshaKubunCode}となるコード{@link Code}
     * @return {@link HihokenshaKubunCode}
     * @throws IllegalArgumentException {@link HihokenshaKubunCodeSpec}の仕様を満たさない場合
     */
    public static HihokenshaKubunCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new HihokenshaKubunCodeValidator(new HihokenshaKubunCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new HihokenshaKubunCode(code);
    }

//    public Code value() {
//        return this.code;
//    }
    @Override
    public int compareTo(HihokenshaKubunCode 比較対象) {
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
        return ((HihokenshaKubunCode) 比較対象).value().equals(this.value());
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
