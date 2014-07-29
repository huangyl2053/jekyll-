/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * サービスコードを表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public class ServiceCode implements IDbColumnMappable, IValueObject, Comparable<ServiceCode> {

    private final RString code;

    /**
     * 指定した値からサービスコードを生成します。
     *
     * @param code サービスコード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ServiceCode(RString code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
    }

    @Override
    public RString value() {
        return code;
    }

    @Override
    public int compareTo(ServiceCode 比較対象) {
        return this.value().compareTo(比較対象.value());
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ServiceCode) 比較対象).value().equals(this.value());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public RString getColumnValue() {
        return code;
    }
}
