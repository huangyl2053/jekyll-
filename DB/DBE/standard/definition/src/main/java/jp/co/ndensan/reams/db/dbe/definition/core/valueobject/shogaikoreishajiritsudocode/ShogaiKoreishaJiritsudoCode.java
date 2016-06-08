/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shogaikoreishajiritsudocode;

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
 * 障害高齢者自立度コードを表すクラスです。
 *
 */
// TODO dingn
// public class ShogaiKoreishaJiritsudoCode implements Comparable<ShogaiKoreishaJiritsudoCode>, IValueObject<Code>, IDbColumnMappable, IValidatable {
public class ShogaiKoreishaJiritsudoCode implements Comparable<ShogaiKoreishaJiritsudoCode>, ICodeWrapValueObject, IDbColumnMappable, IValidatable {

    private final Code code;

    /**
     * {@link ShogaiKoreishaJiritsudoCode}のEMPTY値です。
     */
    public static final ShogaiKoreishaJiritsudoCode EMPTY;

    static {
        EMPTY = new ShogaiKoreishaJiritsudoCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code 障害高齢者自立度コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShogaiKoreishaJiritsudoCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("障害高齢者自立度コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/> {@link ShogaiKoreishaJiritsudoCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ShogaiKoreishaJiritsudoCodeValidator(this).validate();
    }

    /**
     * {@link ShogaiKoreishaJiritsudoCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link ShogaiKoreishaJiritsudoCode}となるコード{@link Code}
     * @return {@link ShogaiKoreishaJiritsudoCode}
     * @throws IllegalArgumentException {@link ShogaiKoreishaJiritsudoCodeSpec}の仕様を満たさない場合
     */
    public static ShogaiKoreishaJiritsudoCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ShogaiKoreishaJiritsudoCodeValidator(new ShogaiKoreishaJiritsudoCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ShogaiKoreishaJiritsudoCode(code);
    }

//    @Override
//    public Code value() {
//        return this.code;
//    }
    @Override
    public int compareTo(ShogaiKoreishaJiritsudoCode 比較対象) {
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
        return ((ShogaiKoreishaJiritsudoCode) 比較対象).value().equals(this.value());
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
