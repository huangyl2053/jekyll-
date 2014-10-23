/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ValueObjectが持つ1文字をどう数えるか、という「単位」です。
 *
 * @author N3327 三浦 凌
 */
public enum Unit {

    /**
     * 「文字」
     */
    文字,
    /**
     * 「桁」
     */
    桁;
    private final RString theName;

    private Unit() {
        this.theName = new RString(name());
    }

    /**
     * {@link #name()}をRStringに変換した物と同じ値を返します。
     *
     * @return {@link #name()}をRStringに変換した物と同じ値
     */
    public RString asRString() {
        return this.theName;
    }
}
