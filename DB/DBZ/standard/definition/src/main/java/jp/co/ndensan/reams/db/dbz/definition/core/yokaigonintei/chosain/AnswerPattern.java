/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
public enum AnswerPattern {

    /**
     * 回答パターン1, 回答パターンコード: "1"。
     */
    回答パターン1(new RString("1")),
    /**
     * 回答パターン2, 回答パターンコード: "2"。
     */
    回答パターン2(new RString("2")),
    /**
     * 回答パターン3, 回答パターンコード: "3"。
     */
    回答パターン3(new RString("3")),
    /**
     * 回答パターン4, 回答パターンコード: "4"。
     */
    回答パターン4(new RString("4")),
    /**
     * 回答パターン5, 回答パターンコード: "5"。
     */
    回答パターン5(new RString("5")),
    /**
     * 回答パターン6, 回答パターンコード: "6"。
     */
    回答パターン6(new RString("6")),
    /**
     * 回答パターン7, 回答パターンコード: "7"。
     */
    回答パターン7(new RString("7")),
    /**
     * 回答パターン8, 回答パターンコード: "8"。
     */
    回答パターン8(new RString("8")),
    /**
     * 回答パターン9, 回答パターンコード: "9"。
     */
    回答パターン9(new RString("9")),
    /**
     * 回答パターン10, 回答パターンコード: "10"。
     */
    回答パターン10(new RString("10")),
    /**
     * 回答パターン11, 回答パターンコード: "11"。
     */
    回答パターン11(new RString("11")),
    /**
     * 回答パターン12, 回答パターンコード: "12"。
     */
    回答パターン12(new RString("12")),
    /**
     * 回答パターン13, 回答パターンコード: "13"。
     */
    回答パターン13(new RString("13")),
    /**
     * 回答パターン14, 回答パターンコード: "14"。
     */
    回答パターン14(new RString("14")),
    /**
     * 回答パターン15, 回答パターンコード: "15"。
     */
    回答パターン15(new RString("15")),
    /**
     * 回答パターン16, 回答パターンコード: "16"。
     */
    回答パターン16(new RString("16")),
    /**
     * 回答パターン17, 回答パターンコード: "17"。
     */
    回答パターン17(new RString("17")),
    /**
     * 回答パターン20, 回答パターンコード: "20"。
     */
    回答パターン20(new RString("20")),
    /**
     * 回答パターン21, 回答パターンコード: "21"。
     */
    回答パターン21(new RString("21")),
    /**
     * 回答パターン22, 回答パターンコード: "22"。
     */
    回答パターン22(new RString("22")),
    /**
     * 回答パターン23, 回答パターンコード: "23"。
     */
    回答パターン23(new RString("23")),
    /**
     * 回答パターン24, 回答パターンコード: "24"。
     */
    回答パターン24(new RString("24")),
    /**
     * 回答パターン30, 回答パターンコード: "30"。
     */
    回答パターン30(new RString("30")),
    /**
     * 回答パターン31, 回答パターンコード: "31"。
     */
    回答パターン31(new RString("31")),
    /**
     * 回答パターン32, 回答パターンコード: "32"。
     */
    回答パターン32(new RString("32")),
    /**
     * 回答パターン33, 回答パターンコード: "33"。
     */
    回答パターン33(new RString("33")),
    /**
     * 回答パターン34, 回答パターンコード: "34"。
     */
    回答パターン34(new RString("34"));

    private final RString answerPatternCode;

    private AnswerPattern(RString answerPatternCode) {
        this.answerPatternCode = answerPatternCode;
    }

    /**
     * ファイル名称を返します。
     *
     * @return コード
     */
    public RString getコード() {
        return this.answerPatternCode;
    }

    /**
     * 回答パターンのコードと一致する内容を探します。
     *
     * @param code 回答パターンのコード
     * @return {@code code} に対応する回答パターン
     */
    public static AnswerPattern toValue(RString code) {
        for (AnswerPattern answerPattern : AnswerPattern.values()) {
            if (answerPattern.answerPatternCode.equals(code)) {
                return answerPattern;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("回答パターン"));
    }

    public RString get回答(RString researchItem) {
        if (researchItem == null) {
            return RString.EMPTY;
        }

        if (AnswerPattern.回答パターン1.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser01.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン2.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser02.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン3.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser03.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン4.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser04.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン5.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser05.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン6.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser06.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン7.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser07.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン8.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser08.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン9.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser09.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン10.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser10.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン11.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser11.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン12.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser12.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン13.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser13.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン14.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser14.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン15.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser15.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン16.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser16.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン17.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser17.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン20.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser20.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン21.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser21.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン22.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser22.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン23.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser23.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン24.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser24.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン30.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser30.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン31.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser31.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン32.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser32.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン33.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser33.toValue(researchItem).get名称();
        }
        if (AnswerPattern.回答パターン34.getコード().equals(this.answerPatternCode)) {
            return ChosaAnser34.toValue(researchItem).get名称();
        }
        return RString.EMPTY;
    }
}
