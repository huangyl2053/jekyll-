/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 算定状態（仮算定／本算定）を表します。
 *
 * @author N3317 塚田 萌
 */
public enum SanteiState {

    /**
     * 仮算定
     */
    仮算定("1"),
    /**
     * 本算定
     */
    本算定("2");
    private final RString key;

    private SanteiState(String key) {
        this.key = new RString(key);
    }

    /**
     * 算定状態ラジオボタンのキーを返します。
     *
     * @return 算定状態ラジオボタンのキー
     */
    public RString getKey() {
        return this.key;
    }
}
