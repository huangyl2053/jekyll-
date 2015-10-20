/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ichijihanteikeikokucode;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 一次判定警告コードを表すクラスです。
 *
 */
public class IchijiHanteiKeikokuCode implements Comparable<IchijiHanteiKeikokuCode>, IDbColumnMappable, IValidatable, IValueObject<Code> {

    private final Code code;

    public static final IchijiHanteiKeikokuCode EMPTY;

    /**
     * {@link IchijiHanteiKeikokuCode}のEMPTY値です。
     */
    static {
        EMPTY = new IchijiHanteiKeikokuCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 一次判定警告コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public IchijiHanteiKeikokuCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定警告コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KoakuNo}が持つvalueについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new IchijiHanteiKeikokuCodeValidator(this).validate();
    }

    /**
     * {@link IchijiHanteiKeikokuCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のvalueについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link IchijiHanteiKeikokuCode}となるコード{@link RString}
     * @return {@link IchijiHanteiKeikokuCode}
     * @throws IllegalArgumentException
     * {@link IchijiHanteiKeikokuCodeSpec}の仕様を満たさない場合
     */
    public static IchijiHanteiKeikokuCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new IchijiHanteiKeikokuCodeValidator(new IchijiHanteiKeikokuCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new IchijiHanteiKeikokuCode(code);
    }

    @Override
    public Code value() {
        return this.code;
    }

    @Override
    public int compareTo(IchijiHanteiKeikokuCode 比較対象) {
        return this.value().compareTo(比較対象.value());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((IchijiHanteiKeikokuCode) 比較対象).value().equals(this.value());
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
