/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.uz.uza.message.Message Message}
 * のインスタンス生成を補助するためのユーティリティクラスです。
 *
 * @author N9606 漢那 憲作
 */
final class MessageCreateHelper {

    static String toCode(String prefix, int no) {

        RString noString = new RString(Integer.toString(no));
        RString zeroPadded = noString.padZeroToLeft(5);

        return prefix + zeroPadded.toString();
    }
}
