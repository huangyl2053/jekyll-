/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiincode;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 審査会委員コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinCode implements IValueObject<RString>, Comparable<ShinsakaiIinCode>, IDbColumnMappable, IValidatable {

    private final RString 審査会委員コード;

    /**
     * {@link KoakuNo}のEMPTY値です。
     */
    public static final ShinsakaiIinCode EMPTY;

    static {
        EMPTY = new ShinsakaiIinCode(RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 審査会委員コード 審査会委員コード
     * @throws NullPointerException 引数にNullが渡されたとき
     * @throws IllegalArgumentException 引数の文字列が8桁で無いとき
     */
    public ShinsakaiIinCode(RString 審査会委員コード) throws NullPointerException, IllegalArgumentException {
        requireNonNull(審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会開催場所コード"));
        this.審査会委員コード = 審査会委員コード;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KoakuNo}が持つ審査会委員コードについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ShinsakaiIinCodeValidator(this).validate();
    }

    /**
     * {@link ShinsakaiIinCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の審査会委員コードについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 審査会委員コード {@link ShinsakaiIinCode}となる文字列{@link RString}
     * @return {@link ShinsakaiIinCode}
     * @throws IllegalArgumentException {@link ShinsakaiIinCodeSpec}の仕様を満たさない場合
     */
    public static ShinsakaiIinCode createCheckInstance(RString 審査会委員コード) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ShinsakaiIinCodeValidator(new ShinsakaiIinCode(審査会委員コード)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ShinsakaiIinCode(審査会委員コード);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.審査会委員コード);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ShinsakaiIinCode) 比較対象).value().equals(審査会委員コード);
    }

    @Override
    public RString value() {
        return 審査会委員コード;
    }

    @Override
    public int compareTo(ShinsakaiIinCode 比較対象) {
        return 審査会委員コード.compareTo(比較対象.value());
    }

    @Override
    public RString getColumnValue() {
        return this.審査会委員コード;
    }

    @Override
    public String toString() {
        return this.審査会委員コード == null ? "" : this.審査会委員コード.toString();
    }
}
