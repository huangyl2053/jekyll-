/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

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
     * 指定のTextBoxのvalueをクリアします。
     *
     * @param <T> TextBox
     * @param textBox target
     * @deprecated clearValue()を使うべきです。
     */
    @Deprecated
    public static <T extends TextBox> void clear(T textBox) {
        textBox.clearValue();
    }

    /**
     * 指定のTextBoxCodeのvalueをクリアします。
     *
     * @param <T> TextBoxCode
     * @param textBoxCode target
     * @deprecated clearValue()を使うべきです。
     */
    @Deprecated
    public static <T extends TextBoxCode> void clear(T textBoxCode) {
        textBoxCode.clearValue();
    }

    /**
     * 指定のTextBoxDateのvalueをクリアします。
     *
     * @param <T> TextBoxDate
     * @param textBoxDate target
     * @deprecated clearValue()を使うべきです。
     */
    @Deprecated
    public static <T extends TextBoxDate> void clear(T textBoxDate) {
        textBoxDate.clearValue();
    }

    /**
     * 指定のTextBoxYubinNoのvalueをクリアします。
     *
     * @param <T> TextBoxYubinNo
     * @param textBoxYubinNo target
     * @deprecated clearValue()を使うべきです。
     */
    @Deprecated
    public static <T extends TextBoxYubinNo> void clear(T textBoxYubinNo) {
        textBoxYubinNo.clearValue();
    }
}
