/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者区分を表すコードです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaKubunCode implements ICodeWrapValueObject, Comparable<HihokenshaKubunCode> {

    private final Code code;

    /**
     * 引数から被保険者区分コードを受け取り、インスタンスを生成します。
     *
     * @param code 被保険者区分
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public HihokenshaKubunCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者区分コード", getClass().getName()));
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
}
