/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 入力識別番号
 *
 * @author n8223
 */
public class InputShikibetsuNoCode implements ICodeWrapValueObject, Comparable<ServiceShuruiCode> {

    private final Code code;

    /**
     * 引数から合議体長コードを受け取り、インスタンスを生成します。
     *
     * @param code 合議体長区分コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public InputShikibetsuNoCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, Messages.E00003.replace("入力識別番号", getClass().getName()).getMessage());
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
    public int compareTo(ServiceShuruiCode 比較対象) {
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
        return ((ServiceShuruiCode) 比較対象).value().equals(this.value());
    }
}
