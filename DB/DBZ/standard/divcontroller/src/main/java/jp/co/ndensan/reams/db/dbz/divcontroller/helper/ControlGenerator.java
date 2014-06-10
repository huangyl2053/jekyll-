/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * YAMLから取得したMapにマッピングされた値を、各コントロールへ変換します。
 *
 * @author N3327 三浦 凌
 */
public class ControlGenerator {

    private final Map source;

    /**
     * MapからControlGeneratorを生成します。<br/>
     * <pre>
     * 使用例:
     * {@code List<HashMap> list = YamlLoader.loadAsList("fileName");}
     * {@code ControlGenerator cg = new ControlGenerator(list.get(0));}
     * {@code RString hihoNo = cg.getAsRString("被保番号");}
     * <pre/>
     * @param source YAMLから取得されるMap
     */
    public ControlGenerator(Map source) {
        this.source = source;
    }

    /**
     * Mapからkeyに対応するデータを返します。
     *
     * @param key key
     * @return Object。keyに対応するデータがないときは null。
     */
    public Object get(Object key) {
        return this.source.get(key);
    }

    /**
     * Mapからkeyに対応するデータをRString型で返します。
     *
     * @param key key
     * @return RString。keyに対応するデータがないときは RString.EMPTY。
     */
    public RString getAsRString(String key) {
        try {
            return new RString(this.get(key).toString());
        } catch (NullPointerException e) {
            return RString.EMPTY;
        }
    }

    /**
     * Mapからkeyに対応するデータをboolean型で取得します。
     *
     * @param key key
     * @return boolean value。keyに対応するデータがないときは false。
     */
    public boolean getAsBooleanValue(String key) {
        try {
            return Boolean.valueOf(this.get(key).toString()).booleanValue();
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxFlexibleDateを返します。
     *
     * @param key key
     * @return TextBoxFlexibleDate
     */
    public TextBoxFlexibleDate getAsTextBoxFlexibleDate(String key) {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        try {
            textBoxFlexibleDate.setValue(new FlexibleDate(this.get(key).toString()));
        } catch (NullPointerException | IllegalArgumentException e) {
            textBoxFlexibleDate.clearValue();
        }
        textBoxFlexibleDate.setDisabled(true);
        return textBoxFlexibleDate;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxDateを返します。
     *
     * @param key key
     * @return TextBoxDate
     */
    public TextBoxDate getAsTextBoxDate(String key) {
        TextBoxDate textBoxDate = new TextBoxDate();
        try {
            textBoxDate.setValue(new RDate(this.get(key).toString()));
        } catch (NullPointerException | IllegalArgumentException e) {
            textBoxDate.clearValue();
        }
        textBoxDate.setDisabled(true);
        return textBoxDate;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxNumを返します。
     *
     * @param key key
     * @return TextBoxNum
     */
    public TextBoxNum getAsTextBoxNum(String key) {
        TextBoxNum textBoxNum = new TextBoxNum();
        try {
            textBoxNum.setValue(new Decimal(this.get(key).toString()));
        } catch (NullPointerException | NumberFormatException e) {
            textBoxNum.clearValue();
        }
        textBoxNum.setDisabled(true);
        return textBoxNum;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxを返します。
     *
     * @param key key
     * @return TextBox
     */
    public TextBox getAsTextBox(String key) {
        TextBox textBox = new TextBox();
        textBox.setValue(this.getAsRString(key));
        textBox.setDisabled(true);
        return textBox;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxを返します。
     *
     * @param key key
     * @return TextBoxCode
     */
    public TextBoxCode getAsTextBoxCode(String key) {
        TextBoxCode textBox = new TextBoxCode();
        try {
            textBox.setValue(new RString(this.get(key).toString()));
        } catch (NullPointerException ex) {
            textBox.clearValue();
        }
        textBox.setDisabled(true);
        return textBox;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxMultiLineを返します。
     *
     * @param key key
     * @return TextBoxMultiLine
     */
    public TextBoxMultiLine getTextBoxMultiLine(String key) {
        TextBoxMultiLine textBox = new TextBoxMultiLine();
        textBox.setValue(this.getAsRString(key));
        return textBox;
    }
}
