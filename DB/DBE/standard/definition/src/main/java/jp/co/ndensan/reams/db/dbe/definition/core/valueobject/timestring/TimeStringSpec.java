/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.timestring;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ValueObjectの{@link TimeString}の仕様クラスです。
 */
public enum TimeStringSpec implements IPredicate<TimeString> {

    /**
     * 桁数が4桁であること。
     */
    桁数が4桁であること {
                /**
                 * 桁数が4桁である場合にtrueを返す。
                 *
                 * @param timeString 介護独自で、文字列で表した時間
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(TimeString timestring) {

                    final int length = 4;
                    return timestring.value().length() == length;
                }
            };
}
