/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.uz.uza.message.Message Message}
 * のインスタンス生成を補助するためのユーティリティクラスです。
 *
 * @author N9606 漢那 憲作
 */
//TODO n8178 城間篤人 URZにも同じクラスが存在するが、現在参照不可。URZのクラスが参照可能なように修正されるなら、
//このクラスの処理をURを使用するように置き換えるか、このクラスを削除して、これを利用していたほかクラスのimportを修正する。 2015年2月
public final class MessageCreateHelper {

    private MessageCreateHelper() {
    }

    public static String toCode(String prefix, int no) {

        RString noString = new RString(Integer.toString(no));
        RString zeroPadded = noString.padZeroToLeft(5);

        return prefix + zeroPadded.toString();
    }
}
