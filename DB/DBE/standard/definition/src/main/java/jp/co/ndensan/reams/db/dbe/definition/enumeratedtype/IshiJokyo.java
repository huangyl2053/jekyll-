/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医師の状況を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum IshiJokyo {

    /**
     * 有効 コード : "1"
     */
    有効(new RString("1")),
    /**
     * 無効 コード : "0"
     */
    無効(new RString("0"));
    private final RString jokyo;

    private IshiJokyo(RString code) {
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
     * 指定された医師の状況コードに該当する医師の状況を返します。
     *
     * @param code 医師の状況コード
     * @return 引数のコードに対応するIshiJokyo型のenum
     * @throws IllegalArgumentException 実在しない医師状況コードの場合
     */
    public static IshiJokyo toValue(RString code) throws NullPointerException, IllegalArgumentException {

        for (IshiJokyo item : IshiJokyo.values()) {
            if (item.jokyo.equals(code)) {
                return item;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する医師の状況").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する医師の状況").getMessage());
    }
}
