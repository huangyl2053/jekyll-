/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigodoctorcode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link KaigoDoctorCode}の仕様クラスです。
 */
public enum KaigoDoctorCodeSpec implements IPredicate<KaigoDoctorCode> {

    /**
     * コードがNullでないこと
     */
    コードがNullでないこと {
                /**
                 *
                 * @param kaigoDoctorCode 介護医師コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(KaigoDoctorCode kaigoDoctorCode) {
                    return true;
                }
            }
}
