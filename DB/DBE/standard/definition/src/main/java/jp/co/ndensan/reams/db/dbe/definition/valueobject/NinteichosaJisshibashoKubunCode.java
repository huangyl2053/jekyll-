/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の実施場所区分コードを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaJisshibashoKubunCode implements ICodeWrapValueObject, Comparable<NinteichosaJisshibashoKubunCode> {

    private final Code code;

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     */
    public NinteichosaJisshibashoKubunCode(Code code) {
        this.code = code;
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
    public int compareTo(NinteichosaJisshibashoKubunCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((NinteichosaJisshibashoKubunCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(NinteichosaJisshibashoKubunCode target) {
        return target.asCode().equals(this.code);
    }
}
