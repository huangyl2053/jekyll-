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
public enum GogitaiDummy {

    /**
     * ダミーであることを表します。
     */
    ダミー(true),
    /**
     * ダミーではないことを表します。
     */
    notダミー(false);
    private boolean ダミーフラグ;

    private GogitaiDummy(boolean ダミーフラグ) {
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
     * 引数に真理値を指定し、祖霊に対応したGogitaiDummyを返します。
     *
     * @param ダミーフラグ ダミーフラグ
     * @return 対応した合議体ダミー
     */
    public static GogitaiDummy toValue(boolean ダミーフラグ) {
        if (ダミーフラグ) {
            return ダミー;
        }
        return notダミー;
    }
}
