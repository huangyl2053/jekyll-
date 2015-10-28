/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.message;

import java.util.regex.Pattern;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBAのシステムエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbaSystemErrorMessages {

    // TODO 一つ目の要素が定義されたらこの要素は削除する。
    ダミーメッセージ(0, new RString(""));

    private final RString code;
    private final RString message;

    private DbaSystemErrorMessages(int no, RString message) {
        this.code = new RString(toCode("S", no));
        this.message = message;
    }

    /**
     * メッセージを返します。
     *
     * @return メッセージ
     */
    public RString getMessage() {
        return message;
    }

    /**
     * 自身のメッセージの?の部分を引数で受け取った値で置換した値を返します。
     *
     * @param replacers ?を置換する文字列
     * @return 引数で受け取った値で置換したメッセージ
     */
    public RString getReplacedMessage(String... replacers) {

        final RString replacee = new RString("?");

        if (getReplacerCount() != replacers.length) {
            throw new IllegalArgumentException("置換予定部分の数と、指定する置換文字列の数を一致させてください。");
        }

        RString replaced = message;
        int i = 0;

        while (true) {
            replaced = new RString(replaced.toString().replaceFirst(Pattern.quote(replacee.toString()), replacers[i++]));

            if (replaced.indexOf(replacee.toString()) < 0) {
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
