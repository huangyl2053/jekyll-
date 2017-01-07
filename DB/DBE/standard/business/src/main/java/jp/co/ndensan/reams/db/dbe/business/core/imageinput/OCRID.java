/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取り込みで取り込むOCRIDの列挙です。
 */
public enum OCRID {

    _701("701"),
    _702("702"),
    _777("777"),
    _778("778"),
    _801("801"),
    EMPTY;

    private final RString theValue;

    private OCRID() {
        this.theValue = RString.EMPTY;
    }

    private OCRID(String value) {
        this.theValue = new RString(value);
    }

    /**
     * 指定の文字列と同じ値の{@link OCRID}が存在する場合は、その要素を返します。
     * 存在しない場合は{@link OCRID#EMPTY}を返します。
     *
     * @param rstr 文字列（数値3桁を想定）
     * @return 対応する{@link OCRID}, もしくは{@link OCRID#EMPTY}
     */
    public static OCRID toValueOrEMPTY(RString rstr) {
        for (OCRID value : values()) {
            if (value.theValue.equals(rstr)) {
                return value;
            }
        }
        return EMPTY;
    }
}
