/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取り込みで取り込むOCRIDの列挙です。
 */
public enum OCRID {

    /**
     * 認定調査票 概況調査区
     */
    _501("501", false),
    /**
     * 認定調査票 基本調査
     */
    _502("502", true),
    /**
     * 認定調査票 特記事項
     */
    _550("550", false),
    /**
     * 認定調査票 概況特記 箇条書き特記
     */
    _570("570", false),
    /**
     * 意見書OCR 1枚目
     */
    _701("701", true),
    /**
     * 意見書OCR 2枚目
     */
    _702("702", true),
    /**
     * 意見書規定外 表
     */
    _777("777", true),
    /**
     * 意見書規定外 裏
     */
    _778("778", false),
    /**
     * その他資料
     */
    _801("801", false),
    /**
     * 空（nullObject）
     */
    EMPTY;

    private final RString theValue;
    private final boolean isUsedIchijiHanteiFlag;

    private OCRID() {
        this.theValue = RString.EMPTY;
        this.isUsedIchijiHanteiFlag = false;
    }

    private OCRID(String value, boolean isUsedIchijiHantei) {
        this.theValue = new RString(value);
        this.isUsedIchijiHanteiFlag = isUsedIchijiHantei;
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
     * @return コードに変換した結果
     */
    public Code asCode() {
        return new Code(this.theValue);
    }

    /**
     * @return 一次判定で利用される帳票である場合、{@code true}.
     */
    public boolean isUsesIchijiHantei() {
        return this.isUsedIchijiHanteiFlag;
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
