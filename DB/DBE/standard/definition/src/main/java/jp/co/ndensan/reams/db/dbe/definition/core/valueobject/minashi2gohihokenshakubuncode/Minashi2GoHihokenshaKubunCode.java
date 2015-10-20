/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.minashi2gohihokenshakubuncode;

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
 * みなし2号者の被保険者区分を表すコードです。
 *
 */
public class Minashi2GoHihokenshaKubunCode implements Comparable<Minashi2GoHihokenshaKubunCode>, IDbColumnMappable, IValidatable, IValueObject<Code> {

    private final Code code;

    public static final Minashi2GoHihokenshaKubunCode EMPTY;

    /**
     * {@link Minashi2GoHihokenshaKubunCode}のEMPTY値です。
     */
    static {
        EMPTY = new Minashi2GoHihokenshaKubunCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code みなし2号被保険者区分
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public Minashi2GoHihokenshaKubunCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし2号被保険者区分コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link Minashi2GoHihokenshaKubunCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new Minashi2GoHihokenshaKubunCodeValidator(this).validate();
    }

    /**
     * {@link Minashi2GoHihokenshaKubunCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link Minashi2GoHihokenshaKubunCode}となるコード{@link Code}
     * @return {@link Minashi2GoHihokenshaKubunCode}
     * @throws IllegalArgumentException
     * {@link Minashi2GoHihokenshaKubunCodeSpec}の仕様を満たさない場合
     */
    public static Minashi2GoHihokenshaKubunCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new Minashi2GoHihokenshaKubunCodeValidator(new Minashi2GoHihokenshaKubunCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new Minashi2GoHihokenshaKubunCode(code);
    }

    @Override
    public Code value() {
        return this.code;
    }

    @Override
    public int compareTo(Minashi2GoHihokenshaKubunCode 比較対象) {
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
        return ((Minashi2GoHihokenshaKubunCode) 比較対象).value().equals(this.value());
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
