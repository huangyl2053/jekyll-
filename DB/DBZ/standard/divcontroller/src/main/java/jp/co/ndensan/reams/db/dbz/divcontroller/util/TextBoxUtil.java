/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * TextBox系統のUI部品を操作するためのユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class TextBoxUtil {

    private TextBoxUtil() {
    }

    /**
     * valueをクリアしたTextBoxを返します。
     *
     * @param <T> TextBox
     * @param textBox target
     * @return valueをクリアしたTextBox
     */
    public static <T extends TextBox> T cleared(T textBox) {
        T cleared = textBox;
        cleared.setValue(RString.EMPTY);
        return cleared;
    }

    /**
     * 指定のTextBoxのvalueをクリアします。
     *
     * @param <T> TextBox
     * @param textBox target
     */
    public static <T extends TextBox> void clear(T textBox) {
        textBox.setValue(RString.EMPTY);
    }

    /**
     * valueをクリアしたTextBoxCodeを返します。
     *
     * @param <T> TextBoxCode
     * @param textBoxCode target
     * @return valueをクリアしたTextBoxCode
     */
    public static <T extends TextBoxCode> T cleared(T textBoxCode) {
        T cleared = textBoxCode;
        cleared.setValue(RString.EMPTY);
        return cleared;
    }

    /**
     * 指定のTextBoxCodeのvalueをクリアします。
     *
     * @param <T> TextBoxCode
     * @param textBoxCode target
     */
    public static <T extends TextBoxCode> void clear(T textBoxCode) {
        textBoxCode.setValue(RString.EMPTY);
    }

    /**
     * valueをクリアしたTextBoxDateを返します。
     *
     * @param <T> TextBoxDate
     * @param textBoxDate target
     * @return valueをクリアしたTextBoxDate
     */
    public static <T extends TextBoxDate> T cleared(T textBoxDate) {
        T cleared = textBoxDate;
        cleared.setValue(null);
        return cleared;
    }

    /**
     * 指定のTextBoxDateのvalueをクリアします。
     *
     * @param <T> TextBoxDate
     * @param textBoxDate target
     */
    public static <T extends TextBoxDate> void clear(T textBoxDate) {
        textBoxDate.setValue(null);
    }

    /**
     * valueをクリアしたTextBoxYubinNoを返します。
     *
     * @param <T> TextBoxYubinNo
     * @param textBoxYubinNo target
     * @return valueをクリアしたTextBoxYubinNo
     */
    public static <T extends TextBoxYubinNo> T cleared(T textBoxYubinNo) {
        T cleared = textBoxYubinNo;
        cleared.setValue(RString.EMPTY);
        return cleared;
    }

    /**
     * 指定のTextBoxYubinNoのvalueをクリアします。
     *
     * @param <T> TextBoxYubinNo
     * @param textBoxYubinNo target
     */
    public static <T extends TextBoxYubinNo> void clear(T textBoxYubinNo) {
        textBoxYubinNo.setValue(RString.EMPTY);
    }
}
