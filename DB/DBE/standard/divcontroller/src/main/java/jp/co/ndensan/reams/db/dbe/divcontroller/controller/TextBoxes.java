/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TextBoxesDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * TextBoxの挙動を調べるために作られました。
 *
 * @author N3327 三浦 凌
 */
public class TextBoxes {

    /**
     * onLoadといいつつ、ボタン押下時の処理です。
     *
     * @param div TextBoxesDiv
     * @return ResponseData
     */
    public ResponseData<TextBoxesDiv> onLoad(TextBoxesDiv div) {
        ResponseData<TextBoxesDiv> response = new ResponseData<>();

        System.out.println("*-- TextBox -----------------------*");
        _textBox(div.getTxtTextBox());
        System.out.println("");

        System.out.println("*-- TextBoxMultiLine --------------*");
        _textBoxMultiLine(div.getTxtTextBoxMultiLine());
        System.out.println("");

        System.out.println("*-- TextBoxCode -------------------*");
        _textBoxCode(div.getTxtTextBoxCode());
        System.out.println("");

        System.out.println("*-- TextBoxNum --------------------*");
        _textBoxNum(div.getTxtTextBoxNum());
        System.out.println("");

        System.out.println("*-- TextBoxDate -------------------*");
        _textBoxDate(div.getTxtTextBoxDate());
        System.out.println("");

        System.out.println("*-- TextBoxFlexibleDate -----------*");
        _textBoxFlexibleDate(div.getTxtTextBoxFlexibleDate());
        System.out.println("");

        System.out.println("*-- TextBoxYubinNo ----------------*");
        _textBoxYubinNo(div.getTxtTextBoxYubinNo());
        System.out.println("");

        System.out.println("*-- TextBoxTime -------------------*");
        _textBoxTime(div.getTxtTextBoxTime());
        System.out.println("");

        System.out.println("*-- TextBoxKana -------------------*");
        _textBox(div.getTxtTextBoxKana());
        System.out.println("");

        System.out.println("*----------------------------------*");

        response.data = div;
        return response;
    }

    private <T extends TextBox> void _textBox(T textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(RString.EMPTY);
        printGetValue_whenSet_empty(textBox.getValue());
        printGetText_whenSet_empty(textBox.getText());

        textBox.setValue(new RString("てすと"));
        printGetValue_whenSet_("text", textBox.getValue());
        printGetText_whenSet_("text", textBox.getText());
    }

    private void _textBoxMultiLine(TextBoxMultiLine textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(RString.EMPTY);
        printGetValue_whenSet_empty(textBox.getValue());
        printGetText_whenSet_empty(textBox.getText());

        textBox.setValue(new RString("てすと"));
        printGetValue_whenSet_("text", textBox.getValue());
        printGetText_whenSet_("text", textBox.getText());
    }

    private void _textBoxCode(TextBoxCode textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(RString.EMPTY);
        printGetValue_whenSet_empty(textBox.getValue());
        printGetText_whenSet_empty(textBox.getText());

        textBox.setValue(new RString("1"));
        printGetValue_whenSet_("1", textBox.getValue());
        printGetText_whenSet_("1", textBox.getText());
    }

    private void _textBoxNum(TextBoxNum textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(Decimal.ZERO);
        printGetValue_whenSet_("zero", textBox.getValue());
        printGetText_whenSet_("zero", textBox.getText());

        textBox.setValue(new Decimal("100"));
        printGetValue_whenSet_("100", textBox.getValue());
        printGetText_whenSet_("100", textBox.getText());
    }

    private void _textBoxDate(TextBoxDate textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(RDate.MAX);
        printGetValue_whenSet_("MAX", textBox.getValue());
        printGetText_whenSet_("MAX", textBox.getText());

        textBox.setValue(RDate.MIN);
        printGetValue_whenSet_("MIN", textBox.getValue());
        printGetText_whenSet_("MIN", textBox.getText());

        textBox.setValue(RDate.getNowDate());
        printGetValue_whenSet_("Now", textBox.getValue());
        printGetText_whenSet_("Now", textBox.getText());

        textBox.setValue(new RDate("19910227"));
        printGetValue_whenSet_("誕生日", textBox.getValue());
        printGetText_whenSet_("誕生日", textBox.getText());
    }

    private void _textBoxFlexibleDate(TextBoxFlexibleDate textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(FlexibleDate.EMPTY);
        printGetValue_whenSet_empty(textBox.getValue());
        printGetText_whenSet_empty(textBox.getText());

        textBox.setValue(FlexibleDate.getNowDate());
        printGetValue_whenSet_("Now", textBox.getValue());
        printGetText_whenSet_("Now", textBox.getText());

        textBox.setValue(FlexibleDate.MAX);
        printGetValue_whenSet_("MAX", textBox.getValue());
        printGetText_whenSet_("MAX", textBox.getText());
    }

    private void _textBoxYubinNo(TextBoxYubinNo textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(new YubinNo("381-0043"));
        printGetValue_whenSet_("吉田", textBox.getValue());
        printGetText_whenSet_("吉田", textBox.getText());
    }

    private void _textBoxTime(TextBoxTime textBox) {
        printGetValue_default(textBox.getValue());
        printGetText_default(textBox.getText());

        textBox.setValue(null);
        printGetValue_whenSet_null(textBox.getValue());
        printGetText_whenSet_null(textBox.getText());

        textBox.setValue(RTime.now());
        printGetValue_whenSet_("now", textBox.getValue());
        printGetText_whenSet_("now", textBox.getText());
    }

// getValue --------------------------------------------------------------------
    private void printGetValue_whenSet_(String element, Object value) {
        System.out.println("value - " + element + "\t: " + value + emptyだったらお知らせします(value));
    }

    private void printGetValue_default(Object value) {
        printGetValue_whenSet_("default", value);
    }

    private void printGetValue_whenSet_null(Object value) {
        printGetValue_whenSet_("null", value);
    }

    private void printGetValue_whenSet_empty(Object value) {
        printGetValue_whenSet_("empty", value);
    }

    private String emptyだったらお知らせします(Object obj) {
        if (RString.EMPTY.equals(obj)) {
            return "\"\" (RString.EMPTY)";
        } else {
            return "";
        }
    }
// getText  --------------------------------------------------------------------

    private void printGetText_whenSet_(String element, RString value) {
        System.out.println(" text - " + element + "\t: \"" + value + "\"" + emptyだったらお知らせします2(value));
    }

    private void printGetText_whenSet_null(RString value) {
        printGetText_whenSet_("null", value);
    }

    private void printGetText_default(RString value) {
        printGetText_whenSet_("default", value);
    }

    private void printGetText_whenSet_empty(RString value) {
        printGetText_whenSet_("empty", value);
    }

    private String emptyだったらお知らせします2(Object obj) {
        if (RString.EMPTY.equals(obj)) {
            return " (RString.EMPTY)";
        } else {
            return "";
        }
    }

}
