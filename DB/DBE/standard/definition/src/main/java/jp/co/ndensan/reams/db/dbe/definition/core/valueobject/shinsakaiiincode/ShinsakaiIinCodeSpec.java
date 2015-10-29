/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiincode;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link ShinsakaiIinCode}の仕様クラスです。
 */
public enum ShinsakaiIinCodeSpec implements IPredicate<ShinsakaiIinCode> {

    /**
     * 桁数が8桁であること。
     */
    桁数が8桁であること {
                /**
                 * 桁数が8桁である場合にtrueを返す。
                 *
                 * @param shinsakaiIinCode 審査会委員コード
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(ShinsakaiIinCode shinsakaiIinCode) {

                    final int length = 8;
                    return shinsakaiIinCode.value().length() == length;
                }
            };
}
