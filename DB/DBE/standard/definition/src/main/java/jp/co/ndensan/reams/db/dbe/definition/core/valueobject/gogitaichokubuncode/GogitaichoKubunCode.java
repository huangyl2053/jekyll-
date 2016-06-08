/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaichokubuncode;

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
 * 合議体（介護認定審査会）の長や長代理、委員などの区分コードを表すクラスです。
 *
 */
public class GogitaichoKubunCode implements Comparable<GogitaichoKubunCode>, IDbColumnMappable, IValidatable, ICodeWrapValueObject {
//public class GogitaichoKubunCode implements Comparable<GogitaichoKubunCode>, IDbColumnMappable, IValidatable, IValueObject<Code> {

    private final Code code;

    /**
     * {@link GogitaichoKubunCode}のEMPTY値です。
     */
    public static final GogitaichoKubunCode EMPTY;

    static {
        EMPTY = new GogitaichoKubunCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 合議体長区分コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public GogitaichoKubunCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体長区分コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link GogitaichoKubunCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new GogitaichoKubunCodeValidator(this).validate();
    }

    /**
     * {@link GogitaichoKubunCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link GogitaichoKubunCode}となるコード{@link Code}
     * @return {@link GogitaichoKubunCode}
     * @throws IllegalArgumentException {@link GogitaichoKubunCodeSpec}の仕様を満たさない場合
     */
    public static GogitaichoKubunCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new GogitaichoKubunCodeValidator(new GogitaichoKubunCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new GogitaichoKubunCode(code);
    }

    @Override
    public int compareTo(GogitaichoKubunCode 比較対象) {
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
        return ((GogitaichoKubunCode) 比較対象).value().equals(this.value());
    }

//    @Override
//    public Code value() {
//        return this.code;
//    }
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
