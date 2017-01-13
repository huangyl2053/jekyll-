/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取り込みで取り込むOCRIDの列挙です。
 */
public enum OCRID {

    /**
     * 認定調査票 概況調査区
     */
    _501("501"),
    /**
     * 認定調査票 基本調査
     */
    _502("502"),
    /**
     * 認定調査票 特記事項
     */
    _550("550"),
    /**
     * 認定調査票 概況特記 箇条書き特記
     */
    _570("570"),
    /**
     * 意見書OCR 1枚目
     */
    _701("701"),
    /**
     * 意見書OCR 2枚目
     */
    _702("702"),
    /**
     * 意見書規定外 表
     */
    _777("777"),
    /**
     * 意見書規定外 裏
     */
    _778("778"),
    /**
     * その他資料
     */
    _801("801"),
    /**
     * 空（nullObject）
     */
    EMPTY;

    private final RString theValue;

    private OCRID() {
        this.theValue = RString.EMPTY;
    }

    private OCRID(String value) {
        this.theValue = new RString(value);
    }

    /**
     * 値を返します。
     *
     * @return 値
     */
    public RString value() {
        return this.theValue;
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
