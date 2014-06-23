/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

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
     * </pre>
     *
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
     * Mapからkeyに対応するデータをRDate型で返します。
     *
     * @param key key
     * @return RDate。keyに対応するデータがないときは null。
     */
    public RDate getAsRDate(String key) {
        try {
            return new RDate(this.get(key).toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Mapからkeyに対応するデータをFlexibleDate型で返します。
     *
     * @param key key
     * @return FlexibleDate。keyに対応するデータがないときは FlexibleDate.EMPTY。
     */
    public FlexibleDate getAsFlexibleDate(String key) {
        try {
            return new FlexibleDate(this.get(key).toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            return FlexibleDate.EMPTY;
        }
    }

    /**
     * Mapからkeyに対応するデータをDecimal型で返します。
     *
     * @param key key
     * @return Decimal。keyに対応するデータがないときは null。
     */
    public Decimal getAsDecimal(String key) {
        try {
            return new Decimal(this.get(key).toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Mapからkeyに対応するデータをYubinNo型で返します。
     *
     * @param key key
     * @return YubinNo。keyに対応するデータがないときは null。
     */
    public YubinNo getAsYubinNo(String key) {
        try {
            return new YubinNo(this.get(key).toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            return null;
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
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxDateを返します。
     *
     * @param key key
     * @return TextBoxDate
     */
    public TextBoxDate getAsTextBoxDate(String key) {
        TextBoxDate textBoxDate = new TextBoxDate();
        RDate date = this.getAsRDate(key);
        if (date == null) {
            textBoxDate.clearValue();
        } else {
            textBoxDate.setValue(date);
        }
        //textBoxDate.setDisabled(true);
        textBoxDate.setReadOnly(true);
        return textBoxDate;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxFlexibleDateを返します。
     *
     * @param key key
     * @return TextBoxFlexibleDate
     */
    public TextBoxFlexibleDate getAsTextBoxFlexibleDate(String key) {
        TextBoxFlexibleDate textBoxFlexibleDate = new TextBoxFlexibleDate();
        FlexibleDate date = this.getAsFlexibleDate(key);
        if (date == FlexibleDate.EMPTY) {
            textBoxFlexibleDate.clearValue();
        } else {
            textBoxFlexibleDate.setValue(date);
        }
        //textBoxFlexibleDate.setDisabled(true);
        textBoxFlexibleDate.setReadOnly(true);
        return textBoxFlexibleDate;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxNumを返します。
     *
     * @param key key
     * @return TextBoxNum
     */
    public TextBoxNum getAsTextBoxNum(String key) {
        TextBoxNum textBoxNum = new TextBoxNum();
        Decimal num = this.getAsDecimal(key);
        if (num == null) {
            textBoxNum.clearValue();
        } else {
            textBoxNum.setValue(num);
        }
        //textBoxNum.setDisabled(true);
        textBoxNum.setReadOnly(true);
        return textBoxNum;
    }

    /**
     * Mapからkeyに対応するデータを取得し、その値を持ったTextBoxYubinNoを返します。
     *
     * @param key key
     * @return TextBoxYubinNo
     */
    public TextBoxYubinNo getAsTextBoxYubinNo(String key) {
        TextBoxYubinNo textBoxYubinNo = new TextBoxYubinNo();
        YubinNo yubinNo = this.getAsYubinNo(key);
        if (yubinNo == null) {
            textBoxYubinNo.clearValue();
        } else {
            textBoxYubinNo.setValue(yubinNo);
        }
        //textBoxYubinNo.setDisabled(true);
        textBoxYubinNo.setReadOnly(true);
        return textBoxYubinNo;
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
        //textBox.setDisabled(true);
        textBox.setReadOnly(true);
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
        //textBox.setDisabled(true);
        textBox.setReadOnly(true);
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
        textBox.setReadOnly(true);
        return textBox;
    }
}
