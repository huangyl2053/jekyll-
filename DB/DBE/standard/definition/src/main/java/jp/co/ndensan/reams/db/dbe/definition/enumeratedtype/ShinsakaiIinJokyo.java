/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 審査会委員状況を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum ShinsakaiIinJokyo {

    /**
     * 委員が有効であることを表します。
     */
    有効(true),
    /**
     * 委員が無効であることを表します。
     */
    無効(false);
    private final boolean 有効フラグ;

    private ShinsakaiIinJokyo(boolean 有効フラグ) {
        this.有効フラグ = 有効フラグ;
    }

    /**
     * 審査会委員状況が有効であるか否かを返します。
     *
     * @return 有効ならtrue
     */
    public boolean is有効() {
        return 有効フラグ;
    }

    /**
     * 引数に渡した値に対応する審査会委員状況を返します。
     *
     * @param 有効フラグ 有効フラグ
     * @return 対応した審査会開催場所状況
     */
    public static ShinsakaiIinJokyo toValue(boolean 有効フラグ) {
        if (有効フラグ) {
            return 有効;
        }
        return 無効;
    }
}
