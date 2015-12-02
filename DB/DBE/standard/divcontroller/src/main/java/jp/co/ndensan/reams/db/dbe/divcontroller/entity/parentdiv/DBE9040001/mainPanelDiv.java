package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * mainPanel のクラスファイル
 *
 * @author 自動生成
 */
public class mainPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("subPanel1")
    private subPanel1Div subPanel1;
    @JsonProperty("subPanel2")
    private subPanel2Div subPanel2;
    @JsonProperty("subPanel3")
    private subPanel3Div subPanel3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getsubPanel1
     * @return subPanel1
     */
    @JsonProperty("subPanel1")
    public subPanel1Div getSubPanel1() {
        return subPanel1;
    }

    /*
     * setsubPanel1
     * @param subPanel1 subPanel1
     */
    @JsonProperty("subPanel1")
    public void setSubPanel1(subPanel1Div subPanel1) {
        this.subPanel1 = subPanel1;
    }

    /*
     * getsubPanel2
     * @return subPanel2
     */
    @JsonProperty("subPanel2")
    public subPanel2Div getSubPanel2() {
        return subPanel2;
    }

    /*
     * setsubPanel2
     * @param subPanel2 subPanel2
     */
    @JsonProperty("subPanel2")
    public void setSubPanel2(subPanel2Div subPanel2) {
        this.subPanel2 = subPanel2;
    }

    /*
     * getsubPanel3
     * @return subPanel3
     */
    @JsonProperty("subPanel3")
    public subPanel3Div getSubPanel3() {
        return subPanel3;
    }

    /*
     * setsubPanel3
     * @param subPanel3 subPanel3
     */
    @JsonProperty("subPanel3")
    public void setSubPanel3(subPanel3Div subPanel3) {
        this.subPanel3 = subPanel3;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDropDownList1() {
        return this.getSubPanel1().getDropDownList1();
    }

    @JsonIgnore
    public void setDropDownList1(DropDownList DropDownList1) {
        this.getSubPanel1().setDropDownList1(DropDownList1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode1() {
        return this.getSubPanel1().getTextBoxCode1();
    }

    @JsonIgnore
    public void setTextBoxCode1(TextBoxCode TextBoxCode1) {
        this.getSubPanel1().setTextBoxCode1(TextBoxCode1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode2() {
        return this.getSubPanel1().getTextBoxCode2();
    }

    @JsonIgnore
    public void setTextBoxCode2(TextBoxCode TextBoxCode2) {
        this.getSubPanel1().setTextBoxCode2(TextBoxCode2);
    }

    @JsonIgnore
    public TextBox getTextBox1() {
        return this.getSubPanel1().getTextBox1();
    }

    @JsonIgnore
    public void setTextBox1(TextBox TextBox1) {
        this.getSubPanel1().setTextBox1(TextBox1);
    }

    @JsonIgnore
    public TextBoxKana getTextBoxKana1() {
        return this.getSubPanel1().getTextBoxKana1();
    }

    @JsonIgnore
    public void setTextBoxKana1(TextBoxKana TextBoxKana1) {
        this.getSubPanel1().setTextBoxKana1(TextBoxKana1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode3() {
        return this.getSubPanel1().getTextBoxCode3();
    }

    @JsonIgnore
    public void setTextBoxCode3(TextBoxCode TextBoxCode3) {
        this.getSubPanel1().setTextBoxCode3(TextBoxCode3);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode4() {
        return this.getSubPanel1().getTextBoxCode4();
    }

    @JsonIgnore
    public void setTextBoxCode4(TextBoxCode TextBoxCode4) {
        this.getSubPanel1().setTextBoxCode4(TextBoxCode4);
    }

    @JsonIgnore
    public TextBox getTextBox2() {
        return this.getSubPanel1().getTextBox2();
    }

    @JsonIgnore
    public void setTextBox2(TextBox TextBox2) {
        this.getSubPanel1().setTextBox2(TextBox2);
    }

    @JsonIgnore
    public TextBoxKana getTextBoxKana2() {
        return this.getSubPanel1().getTextBoxKana2();
    }

    @JsonIgnore
    public void setTextBoxKana2(TextBoxKana TextBoxKana2) {
        this.getSubPanel1().setTextBoxKana2(TextBoxKana2);
    }

    @JsonIgnore
    public DropDownList getDropDownList2() {
        return this.getSubPanel1().getDropDownList2();
    }

    @JsonIgnore
    public void setDropDownList2(DropDownList DropDownList2) {
        this.getSubPanel1().setDropDownList2(DropDownList2);
    }

    @JsonIgnore
    public RadioButton getRadioButton1() {
        return this.getSubPanel1().getRadioButton1();
    }

    @JsonIgnore
    public void setRadioButton1(RadioButton RadioButton1) {
        this.getSubPanel1().setRadioButton1(RadioButton1);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum1() {
        return this.getSubPanel1().getTextBoxNum1();
    }

    @JsonIgnore
    public void setTextBoxNum1(TextBoxNum TextBoxNum1) {
        this.getSubPanel1().setTextBoxNum1(TextBoxNum1);
    }

    @JsonIgnore
    public Button getButton1() {
        return this.getSubPanel1().getButton1();
    }

    @JsonIgnore
    public void setButton1(Button Button1) {
        this.getSubPanel1().setButton1(Button1);
    }

    @JsonIgnore
    public Button getButton2() {
        return this.getSubPanel1().getButton2();
    }

    @JsonIgnore
    public void setButton2(Button Button2) {
        this.getSubPanel1().setButton2(Button2);
    }

    // </editor-fold>
}
