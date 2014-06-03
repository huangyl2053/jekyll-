/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 運動能力が低下していない認知症高齢者の指標を表すコードです。
 *
 * @author n8178 城間篤人
 */
public class NoryokuMiteikaNinchishoKoreishaShihyoCode implements ICodeWrapValueObject,
        Comparable<NoryokuMiteikaNinchishoKoreishaShihyoCode> {

    private final Code code;

    /**
     * 運動能力未低下認知症高齢者の指標コードを受け取り、インスタンスを生成します。
     *
     * @param code 運動能力未低下認知症高齢者の指標コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoCode(Code code)
            throws NullPointerException {
        this.code = requireNonNull(code, Messages.E00003.replace("運動能力未低下認知症高齢者の指標コード", getClass().getName()).getMessage());
    }

    @Override
    public Code asCode() {
        return this.code;
    }

    @Override
    public RString value() {
        return this.code.value();
    }

    @Override
    public int compareTo(NoryokuMiteikaNinchishoKoreishaShihyoCode 比較対象) {
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
        return ((NoryokuMiteikaNinchishoKoreishaShihyoCode) 比較対象).value().equals(this.value());
    }
}
