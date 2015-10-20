/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.jotaianteiseicode;

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
 * 要介護認定状態の安定性コードを表すクラスです。
 *
 */
public class JotaiAnteiseiCode implements Comparable<JotaiAnteiseiCode>, IValueObject<Code>, IDbColumnMappable, IValidatable {

    private final Code code;
    public static final JotaiAnteiseiCode EMPTY;

    /**
     * {@link KeiyakuNo}のEMPTY値です。
     */
    static {
        EMPTY = new JotaiAnteiseiCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 介護認定状態の安定性コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public JotaiAnteiseiCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定状態の安定性コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link JotaiAnteiseiCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new JotaiAnteiseiCodeValidator(this).validate();
    }

    /**
     * {@link JotaiAnteiseiCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link JotaiAnteiseiCode}となるコード{@link Code}
     * @return {@link JotaiAnteiseiCode}
     * @throws IllegalArgumentException {@link JotaiAnteiseiCodeSpec}の仕様を満たさない場合
     */
    public static JotaiAnteiseiCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new JotaiAnteiseiCodeValidator(new JotaiAnteiseiCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new JotaiAnteiseiCode(code);
    }

    @Override
    public Code value() {
        return this.code;
    }

    @Override
    public int compareTo(JotaiAnteiseiCode 比較対象) {
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
        return ((JotaiAnteiseiCode) 比較対象).value().equals(this.value());
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
