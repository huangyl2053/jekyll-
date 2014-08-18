/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員の状況を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ChosainJokyo {

    /**
     * 有効 コード : "1"
     */
    有効(new RString("1")),
    /**
     * 無効 コード : "0"
     */
    無効(new RString("0"));
    private final RString jokyo;

    private ChosainJokyo(RString code) {
        this.jokyo = code;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.jokyo;
    }

    /**
     * name()と同じ文字列をRString型で返します。
     *
     * @return name()と同じ文字列を持ったRString
     */
    public RString toRString() {
        return new RString(this.toString());
    }

    /**
     * 指定された調査員の状況コードに該当する調査員の状況を返します。
     *
     * @param code 調査員状況コード
     * @return 引数のコードに対応するChosainJokyo型のenum
     * @throws IllegalArgumentException 実在しない調査員状況コードの場合
     */
    public static ChosainJokyo toValue(RString code) throws NullPointerException, IllegalArgumentException {

        for (ChosainJokyo item : ChosainJokyo.values()) {
            if (item.jokyo.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("該当する調査員の状況").getMessage());
    }
}
