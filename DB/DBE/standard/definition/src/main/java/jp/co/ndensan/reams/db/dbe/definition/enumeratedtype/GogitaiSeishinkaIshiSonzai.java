/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 合議体に精神科の医師が存在しているかを表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum GogitaiSeishinkaIshiSonzai {

    /**
     * 精神科医が存在していることを表します。
     */
    存在(true),
    /**
     * 精神科医が不在であることを表します。
     */
    不在(false);
    private final boolean 存在フラグ;

    private GogitaiSeishinkaIshiSonzai(boolean 存在フラグ) {
        this.存在フラグ = 存在フラグ;
    }

    /**
     * 精神科医が在籍しているかどうかを返します。
     *
     * @return 在籍しているならtrue
     */
    public boolean is存在() {
        return 存在フラグ;
    }

    /**
     * 引数に指定した真理値に対応するGogitaiSehishinkaIshiSonzaiを返します。
     *
     * @param 存在フラグ 存在フラグ
     * @return 対応した合議体精神科医師存在
     */
    public static GogitaiSeishinkaIshiSonzai toValue(boolean 存在フラグ) {
        if (存在フラグ) {
            return 存在;
        }
        return 不在;
    }
}
