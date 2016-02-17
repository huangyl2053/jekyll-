/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYear;

/**
 * 賦課比較の処理の中で、DecorationClassを用いたテキストボックスの背景色の変更処理にて用いられるユーティリティです。
 */
class DecorationUtil {

    private static final RString DECORATION_CLASS;

    static {
        //TODO DecorationClassの管理方法の確立。(使用箇所それぞれに以下のような定数を宣言していると保守・管理が難しくなる。)
        DECORATION_CLASS = new RString("ColorOrangeTextBox");
    }

    private DecorationUtil() {
    }

    protected static void decorateBothIfDifferentRDate(TextBoxDate txtBox1, TextBoxDate txtBox2) {
        if (Objects.equals(txtBox1.getValue(), txtBox2.getValue())) {
            return;
        }
        txtBox1.setDecorationClass(DECORATION_CLASS);
        txtBox2.setDecorationClass(DECORATION_CLASS);
    }

    protected static void decorateBothIfDifferentNum(TextBoxNum txtBox1, TextBoxNum txtBox2) {
        if (Objects.equals(txtBox1.getValue(), txtBox2.getValue())) {
            return;
        }
        txtBox1.setDecorationClass(DECORATION_CLASS);
        txtBox1.setDecorationClass(DECORATION_CLASS);
    }

    protected static void decorateBothIfDifferentString(TextBox txtBox1, TextBox txtBox2) {
        if (Objects.equals(txtBox1.getValue(), txtBox2.getValue())) {
            return;
        }
        txtBox1.setDecorationClass(DECORATION_CLASS);
        txtBox1.setDecorationClass(DECORATION_CLASS);
    }
}
