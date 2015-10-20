/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiinshikakucode;

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
 * 介護認定審査会委員資格コードを表すクラスです。
 *
 */
public class ShinsakaiIinShikakuCode implements Comparable<ShinsakaiIinShikakuCode>, IValueObject<Code>, IDbColumnMappable, IValidatable {

    private final Code code;

    /**
     * {@link ShinsakaiIinShikakuCode}のEMPTY値です。
     */
    public static final ShinsakaiIinShikakuCode EMPTY;

    static {
        EMPTY = new ShinsakaiIinShikakuCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 審査会委員資格コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShinsakaiIinShikakuCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員資格コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link ShinsakaiIinShikakuCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ShinsakaiIinShikakuCodeValidator(this).validate();
    }

    /**
     * {@link ShinsakaiIinShikakuCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link ShinsakaiIinShikakuCode}となるコード{@link Code}
     * @return {@link ShinsakaiIinShikakuCode}
     * @throws IllegalArgumentException
     * {@link ShinsakaiIinShikakuCodeSpec}の仕様を満たさない場合
     */
    public static ShinsakaiIinShikakuCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ShinsakaiIinShikakuCodeValidator(new ShinsakaiIinShikakuCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ShinsakaiIinShikakuCode(code);
    }

    @Override
    public Code value() {
        return this.code;
    }

    @Override
    public int compareTo(ShinsakaiIinShikakuCode 比較対象) {
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
        return ((ShinsakaiIinShikakuCode) 比較対象).value().equals(this.value());
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
