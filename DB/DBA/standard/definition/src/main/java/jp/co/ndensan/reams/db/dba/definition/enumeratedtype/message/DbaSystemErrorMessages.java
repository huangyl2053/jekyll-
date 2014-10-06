/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message;

import java.util.regex.Pattern;
import static jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBAのシステムエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbaSystemErrorMessages {

    // TODO 一つ目の要素が定義されたらこの要素は削除する。
    ダミーメッセージ(0, "");

    private final String code;
    private final String message;

    private DbaSystemErrorMessages(int no, String message) {
        this.code = toCode("S", no);
        this.message = message;
    }

    /**
     * メッセージを返します。
     *
     * @return メッセージ
     */
    public String getMessage() {
        return message;
    }

    /**
     * 自身のメッセージの?の部分を引数で受け取った値で置換した値を返します。
     *
     * @param replacers ?を置換する文字列
     * @return 引数で受け取った値で置換したメッセージ
     */
    public String getReplacedMessage(String... replacers) {

        final RString REPLACEE = new RString("?");

        if (getReplacerCount() != replacers.length) {
            throw new IllegalArgumentException("置換予定部分の数と、指定する置換文字列の数を一致させてください。");
        }

        String replaced = message;
        int i = 0;

        while (true) {
            replaced = replaced.replaceFirst(Pattern.quote(REPLACEE.toString()), replacers[i++]);

            if (replaced.indexOf(REPLACEE.toString()) < 0) {
                return replaced;
            }
        }
    }

    private int getReplacerCount() {
        int count = 0;
        int position = 0;
        while (true) {
            int index = message.indexOf("?", position);
            if (index == -1) {
                break;
            }
            position += (index + 1);
            count++;
        }
        return count;
    }
}
