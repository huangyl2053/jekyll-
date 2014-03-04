/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 合議体がダミーであるかどうかを現す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum GogitaiDummyKubun {

    /**
     * ダミーであることを表します。
     */
    ダミー(true),
    /**
     * ダミーではないことを表します。
     */
    notダミー(false);
    private boolean ダミーフラグ;

    private GogitaiDummyKubun(boolean ダミーフラグ) {
        this.ダミーフラグ = ダミーフラグ;
    }

    /**
     * ダミーであるか否かを真理値で返します。
     *
     * @return ダミーであるならtrue
     */
    public boolean isダミー() {
        return ダミーフラグ;
    }

    /**
     * 引数に真理値を指定し、対応した合議体ダミー区分を返します。
     *
     * @param ダミーフラグ ダミーフラグ
     * @return 対応した合議体ダミー区分
     */
    public static GogitaiDummyKubun toValue(boolean ダミーフラグ) {
        if (ダミーフラグ) {
            return ダミー;
        }
        return notダミー;
    }
}
