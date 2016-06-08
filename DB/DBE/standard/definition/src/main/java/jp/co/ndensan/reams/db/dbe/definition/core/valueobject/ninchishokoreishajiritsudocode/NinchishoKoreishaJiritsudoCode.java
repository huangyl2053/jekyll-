/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninchishokoreishajiritsudocode;

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
 * 認知症高齢者自立度コードを表すクラスです。
 *
 */
public class NinchishoKoreishaJiritsudoCode implements Comparable<NinchishoKoreishaJiritsudoCode>,
        IDbColumnMappable, IValidatable, ICodeWrapValueObject {
//public class NinchishoKoreishaJiritsudoCode implements Comparable<NinchishoKoreishaJiritsudoCode>,
//    IDbColumnMappable, IValidatable, IValueObject<Code> {

    private final Code code;
    /**
     * NinchishoKoreishaJiritsudoCodeのEMPTYです。
     */
    public static final NinchishoKoreishaJiritsudoCode EMPTY;

    /**
     * {@link NinchishoKoreishaJiritsudoCode}のEMPTY値です。
     */
    static {
        EMPTY = new NinchishoKoreishaJiritsudoCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 認知症高齢者自立度コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NinchishoKoreishaJiritsudoCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症高齢者自立度コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link NinchishoKoreishaJiritsudoCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new NinchishoKoreishaJiritsudoCodeValidator(this).validate();
    }

    /**
     * {@link NinchishoKoreishaJiritsudoCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link NinchishoKoreishaJiritsudoCode}となるコード{@link Code}
     * @return {@link NinchishoKoreishaJiritsudoCode}
     * @throws IllegalArgumentException {@link NinchishoKoreishaJiritsudoCodeSpec}の仕様を満たさない場合
     */
    public static NinchishoKoreishaJiritsudoCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new NinchishoKoreishaJiritsudoCodeValidator(new NinchishoKoreishaJiritsudoCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new NinchishoKoreishaJiritsudoCode(code);
    }

//    @Override
//    public Code value() {
//        return this.code;
//    }
    @Override
    public int compareTo(NinchishoKoreishaJiritsudoCode 比較対象) {
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
        return ((NinchishoKoreishaJiritsudoCode) 比較対象).value().equals(this.value());
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
