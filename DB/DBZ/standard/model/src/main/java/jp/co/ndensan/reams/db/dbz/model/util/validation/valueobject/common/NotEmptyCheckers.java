/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.common;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectInfo;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.ValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * Emptyでないことをチェックするオブジェクトを持ちます。<br/>
 * ValueObjectが保持する型のemptyをチェックするオブジェクトは、すべてこの中に作成してください。
 *
 * @author N3327 三浦 凌
 */
public final class NotEmptyCheckers {

    /**
     * 引数のRStringの{@code isEmpty()}がtrueならば、「必須入力」のバリデーションメッセージを返します。
     */
    public static final IValueObjectCheckable<RString> RSTRING;

    static {
        RSTRING = forRString();
    }

    private NotEmptyCheckers() {
    }

    private static _NotEmptyChecker<RString> forRString() {
        return new _NotEmptyChecker<RString>() {
            @Override
            public boolean isValid(IValueObject<RString> v) {
                if (v == null) {
                    return true;
                }
                return !v.value().isEmpty();
            }
        };
    }

    /**
     * Emptyでないことをチェックするオブジェクトの基底クラスです。
     *
     * @param <T> ValueObjectの型
     */
//<editor-fold defaultstate="collapsed" desc="    private abstract static class _NotEmptyChecker<T> implements IValueObjectCheckable<T> {...}">
    private abstract static class _NotEmptyChecker<T> implements IValueObjectCheckable<T> {

        @Override
        public IValidationMessages check(IValueObject v, IValueObjectInfo objInfo) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            if (!isValid(v)) {
                messages.add(ValidationMessages.必須入力項目, objInfo.getName().toString());
            }
            return messages;
        }
    }
//</editor-fold>
}
