package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KouzaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KouzaInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelOne")
    private panelOneDiv panelOne;
    @JsonProperty("panelTwo")
    private panelTwoDiv panelTwo;
    @JsonProperty("panelShinseiNaiyo")
    private panelShinseiNaiyoDiv panelShinseiNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelOne
     * @return panelOne
     */
    @JsonProperty("panelOne")
    public panelOneDiv getPanelOne() {
        return panelOne;
    }

    /*
     * setpanelOne
     * @param panelOne panelOne
     */
    @JsonProperty("panelOne")
    public void setPanelOne(panelOneDiv panelOne) {
        this.panelOne = panelOne;
    }

    /*
     * getpanelTwo
     * @return panelTwo
     */
    @JsonProperty("panelTwo")
    public panelTwoDiv getPanelTwo() {
        return panelTwo;
    }

    /*
     * setpanelTwo
     * @param panelTwo panelTwo
     */
    @JsonProperty("panelTwo")
    public void setPanelTwo(panelTwoDiv panelTwo) {
        this.panelTwo = panelTwo;
    }

    /*
     * getpanelShinseiNaiyo
     * @return panelShinseiNaiyo
     */
    @JsonProperty("panelShinseiNaiyo")
    public panelShinseiNaiyoDiv getPanelShinseiNaiyo() {
        return panelShinseiNaiyo;
    }

    /*
     * setpanelShinseiNaiyo
     * @param panelShinseiNaiyo panelShinseiNaiyo
     */
    @JsonProperty("panelShinseiNaiyo")
    public void setPanelShinseiNaiyo(panelShinseiNaiyoDiv panelShinseiNaiyo) {
        this.panelShinseiNaiyo = panelShinseiNaiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadioButton3() {
        return this.getPanelShinseiNaiyo().getRadioButton3();
    }

    @JsonIgnore
    public void  setRadioButton3(RadioButton RadioButton3) {
        this.getPanelShinseiNaiyo().setRadioButton3(RadioButton3);
    }

    @JsonIgnore
    public TextBox getTextBox3() {
        return this.getPanelShinseiNaiyo().getTextBox3();
    }

    @JsonIgnore
    public void  setTextBox3(TextBox TextBox3) {
        this.getPanelShinseiNaiyo().setTextBox3(TextBox3);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate2() {
        return this.getPanelShinseiNaiyo().getTextBoxDate2();
    }

    @JsonIgnore
    public void  setTextBoxDate2(TextBoxDate TextBoxDate2) {
        this.getPanelShinseiNaiyo().setTextBoxDate2(TextBoxDate2);
    }

    @JsonIgnore
    public TextBox getTextBox4() {
        return this.getPanelShinseiNaiyo().getTextBox4();
    }

    @JsonIgnore
    public void  setTextBox4(TextBox TextBox4) {
        this.getPanelShinseiNaiyo().setTextBox4(TextBox4);
    }

    @JsonIgnore
    public TextBoxTime getTextBoxTime1() {
        return this.getPanelShinseiNaiyo().getTextBoxTime1();
    }

    @JsonIgnore
    public void  setTextBoxTime1(TextBoxTime TextBoxTime1) {
        this.getPanelShinseiNaiyo().setTextBoxTime1(TextBoxTime1);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate3() {
        return this.getPanelShinseiNaiyo().getTextBoxDate3();
    }

    @JsonIgnore
    public void  setTextBoxDate3(TextBoxDate TextBoxDate3) {
        this.getPanelShinseiNaiyo().setTextBoxDate3(TextBoxDate3);
    }

    @JsonIgnore
    public TextBox getTextBox6() {
        return this.getPanelShinseiNaiyo().getTextBox6();
    }

    @JsonIgnore
    public void  setTextBox6(TextBox TextBox6) {
        this.getPanelShinseiNaiyo().setTextBox6(TextBox6);
    }

    @JsonIgnore
    public TextBoxTime getTextBoxTime3() {
        return this.getPanelShinseiNaiyo().getTextBoxTime3();
    }

    @JsonIgnore
    public void  setTextBoxTime3(TextBoxTime TextBoxTime3) {
        this.getPanelShinseiNaiyo().setTextBoxTime3(TextBoxTime3);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLine2() {
        return this.getPanelShinseiNaiyo().getHorizontalLine2();
    }

    @JsonIgnore
    public void  setHorizontalLine2(HorizontalLine HorizontalLine2) {
        this.getPanelShinseiNaiyo().setHorizontalLine2(HorizontalLine2);
    }

    @JsonIgnore
    public RadioButton getRadioButton4() {
        return this.getPanelShinseiNaiyo().getRadioButton4();
    }

    @JsonIgnore
    public void  setRadioButton4(RadioButton RadioButton4) {
        this.getPanelShinseiNaiyo().setRadioButton4(RadioButton4);
    }

    @JsonIgnore
    public Button getButton4() {
        return this.getPanelShinseiNaiyo().getButton4();
    }

    @JsonIgnore
    public void  setButton4(Button Button4) {
        this.getPanelShinseiNaiyo().setButton4(Button4);
    }

    @JsonIgnore
    public DropDownList getDropDownList1() {
        return this.getPanelShinseiNaiyo().getDropDownList1();
    }

    @JsonIgnore
    public void  setDropDownList1(DropDownList DropDownList1) {
        this.getPanelShinseiNaiyo().setDropDownList1(DropDownList1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode3() {
        return this.getPanelShinseiNaiyo().getTextBoxCode3();
    }

    @JsonIgnore
    public void  setTextBoxCode3(TextBoxCode TextBoxCode3) {
        this.getPanelShinseiNaiyo().setTextBoxCode3(TextBoxCode3);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode5() {
        return this.getPanelShinseiNaiyo().getTextBoxCode5();
    }

    @JsonIgnore
    public void  setTextBoxCode5(TextBoxCode TextBoxCode5) {
        this.getPanelShinseiNaiyo().setTextBoxCode5(TextBoxCode5);
    }

    @JsonIgnore
    public TextBox getTextBox5() {
        return this.getPanelShinseiNaiyo().getTextBox5();
    }

    @JsonIgnore
    public void  setTextBox5(TextBox TextBox5) {
        this.getPanelShinseiNaiyo().setTextBox5(TextBox5);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode4() {
        return this.getPanelShinseiNaiyo().getTextBoxCode4();
    }

    @JsonIgnore
    public void  setTextBoxCode4(TextBoxCode TextBoxCode4) {
        this.getPanelShinseiNaiyo().setTextBoxCode4(TextBoxCode4);
    }

    @JsonIgnore
    public TextBox getTextBox8() {
        return this.getPanelShinseiNaiyo().getTextBox8();
    }

    @JsonIgnore
    public void  setTextBox8(TextBox TextBox8) {
        this.getPanelShinseiNaiyo().setTextBox8(TextBox8);
    }

    @JsonIgnore
    public TextBoxKana getTextBoxKana3() {
        return this.getPanelShinseiNaiyo().getTextBoxKana3();
    }

    @JsonIgnore
    public void  setTextBoxKana3(TextBoxKana TextBoxKana3) {
        this.getPanelShinseiNaiyo().setTextBoxKana3(TextBoxKana3);
    }

    @JsonIgnore
    public TextBox getTextBox9() {
        return this.getPanelShinseiNaiyo().getTextBox9();
    }

    @JsonIgnore
    public void  setTextBox9(TextBox TextBox9) {
        this.getPanelShinseiNaiyo().setTextBox9(TextBox9);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLine4() {
        return this.getPanelShinseiNaiyo().getHorizontalLine4();
    }

    @JsonIgnore
    public void  setHorizontalLine4(HorizontalLine HorizontalLine4) {
        this.getPanelShinseiNaiyo().setHorizontalLine4(HorizontalLine4);
    }

    @JsonIgnore
    public RadioButton getRadioButton12() {
        return this.getPanelShinseiNaiyo().getRadioButton12();
    }

    @JsonIgnore
    public void  setRadioButton12(RadioButton RadioButton12) {
        this.getPanelShinseiNaiyo().setRadioButton12(RadioButton12);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode8() {
        return this.getPanelShinseiNaiyo().getTextBoxCode8();
    }

    @JsonIgnore
    public void  setTextBoxCode8(TextBoxCode TextBoxCode8) {
        this.getPanelShinseiNaiyo().setTextBoxCode8(TextBoxCode8);
    }

    @JsonIgnore
    public Button getButton2() {
        return this.getPanelShinseiNaiyo().getButton2();
    }

    @JsonIgnore
    public void  setButton2(Button Button2) {
        this.getPanelShinseiNaiyo().setButton2(Button2);
    }

    @JsonIgnore
    public Button getButton5() {
        return this.getPanelShinseiNaiyo().getButton5();
    }

    @JsonIgnore
    public void  setButton5(Button Button5) {
        this.getPanelShinseiNaiyo().setButton5(Button5);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode9() {
        return this.getPanelShinseiNaiyo().getTextBoxCode9();
    }

    @JsonIgnore
    public void  setTextBoxCode9(TextBoxCode TextBoxCode9) {
        this.getPanelShinseiNaiyo().setTextBoxCode9(TextBoxCode9);
    }

    @JsonIgnore
    public TextBox getTextBox10() {
        return this.getPanelShinseiNaiyo().getTextBox10();
    }

    @JsonIgnore
    public void  setTextBox10(TextBox TextBox10) {
        this.getPanelShinseiNaiyo().setTextBox10(TextBox10);
    }

    // </editor-fold>
}
