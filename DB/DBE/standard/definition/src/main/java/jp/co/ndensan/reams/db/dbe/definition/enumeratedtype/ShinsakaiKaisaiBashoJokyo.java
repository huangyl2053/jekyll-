/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 審査会開催場所の状況を表す列挙形です。
 *
 * @author N1013 松本直樹
 */
public enum ShinsakaiKaisaiBashoJokyo {

    /**
     * 有効
     */
    有効(true),
    /**
     * 無効
     */
    無効(false);
    private final boolean is有効;

    private ShinsakaiKaisaiBashoJokyo(boolean is有効) {
        this.is有効 = is有効;
    }

    /**
     * 有効か無効かBoolean値で返します。
     *
     * @return 有効・無効の区分を表すBoolean値
     */
    public boolean is有効() {
        return is有効;
    }

    /**
     * 渡されたbool値を元に、介護認定審査会開催場所の状況を返します。
     *
     * @param is有効 有効ならture、無効ならfalse
     * @return bool値に対応した介護認定審査会開催場所状況
     */
    public static ShinsakaiKaisaiBashoJokyo toValue(boolean is有効) {
        if (is有効) {
            return 有効;
        } else {
            return 無効;
        }
    }
}
