package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
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
 * ChushutsuJokenB のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenBDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RadioButtonB")
    private RadioButtonBDiv RadioButtonB;
    @JsonProperty("ChushutsuShosaiB10")
    private ChushutsuShosaiB10Div ChushutsuShosaiB10;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRadioButtonB
     * @return RadioButtonB
     */
    @JsonProperty("RadioButtonB")
    public RadioButtonBDiv getRadioButtonB() {
        return RadioButtonB;
    }

    /*
     * setRadioButtonB
     * @param RadioButtonB RadioButtonB
     */
    @JsonProperty("RadioButtonB")
    public void setRadioButtonB(RadioButtonBDiv RadioButtonB) {
        this.RadioButtonB = RadioButtonB;
    }

    /*
     * getChushutsuShosaiB10
     * @return ChushutsuShosaiB10
     */
    @JsonProperty("ChushutsuShosaiB10")
    public ChushutsuShosaiB10Div getChushutsuShosaiB10() {
        return ChushutsuShosaiB10;
    }

    /*
     * setChushutsuShosaiB10
     * @param ChushutsuShosaiB10 ChushutsuShosaiB10
     */
    @JsonProperty("ChushutsuShosaiB10")
    public void setChushutsuShosaiB10(ChushutsuShosaiB10Div ChushutsuShosaiB10) {
        this.ChushutsuShosaiB10 = ChushutsuShosaiB10;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsuJokenB1() {
        return this.getRadioButtonB().getRadChushutsuJokenB1();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenB1(RadioButton radChushutsuJokenB1) {
        this.getRadioButtonB().setRadChushutsuJokenB1(radChushutsuJokenB1);
    }

    @JsonIgnore
    public Label getLblSpace() {
        return this.getRadioButtonB().getLblSpace();
    }

    @JsonIgnore
    public void  setLblSpace(Label lblSpace) {
        this.getRadioButtonB().setLblSpace(lblSpace);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenB2() {
        return this.getRadioButtonB().getRadChushutsuJokenB2();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenB2(RadioButton radChushutsuJokenB2) {
        this.getRadioButtonB().setRadChushutsuJokenB2(radChushutsuJokenB2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDateB() {
        return this.getChushutsuShosaiB10().getTxtKijunDateB();
    }

    @JsonIgnore
    public void  setTxtKijunDateB(TextBoxDate txtKijunDateB) {
        this.getChushutsuShosaiB10().setTxtKijunDateB(txtKijunDateB);
    }

    @JsonIgnore
    public Label getLblJitenTaishoshaB() {
        return this.getChushutsuShosaiB10().getLblJitenTaishoshaB();
    }

    @JsonIgnore
    public void  setLblJitenTaishoshaB(Label lblJitenTaishoshaB) {
        this.getChushutsuShosaiB10().setLblJitenTaishoshaB(lblJitenTaishoshaB);
    }

    @JsonIgnore
    public ChushutsuShosaiB20Div getChushutsuShosaiB20() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB20(ChushutsuShosaiB20Div ChushutsuShosaiB20) {
        this.getChushutsuShosaiB10().setChushutsuShosaiB20(ChushutsuShosaiB20);
    }

    @JsonIgnore
    public ChushutsuShosaiB21Div getChushutsuShosaiB21() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB21();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB21(ChushutsuShosaiB21Div ChushutsuShosaiB21) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB21(ChushutsuShosaiB21);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken1() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB21().getRadHaniJoken1();
    }

    @JsonIgnore
    public void  setRadHaniJoken1(RadioButton radHaniJoken1) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB21().setRadHaniJoken1(radHaniJoken1);
    }

    @JsonIgnore
    public ChushutsuShosaiB22Div getChushutsuShosaiB22() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB22(ChushutsuShosaiB22Div ChushutsuShosaiB22) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB22(ChushutsuShosaiB22);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken2() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().getRadHaniJoken2();
    }

    @JsonIgnore
    public void  setRadHaniJoken2(RadioButton radHaniJoken2) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().setRadHaniJoken2(radHaniJoken2);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseishaNomi() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().getChkShinseishaNomi();
    }

    @JsonIgnore
    public void  setChkShinseishaNomi(CheckBoxList chkShinseishaNomi) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().setChkShinseishaNomi(chkShinseishaNomi);
    }

    @JsonIgnore
    public ChushutsuShosaiB23Div getChushutsuShosaiB23() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB23();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB23(ChushutsuShosaiB23Div ChushutsuShosaiB23) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB23(ChushutsuShosaiB23);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken3() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB23().getRadHaniJoken3();
    }

    @JsonIgnore
    public void  setRadHaniJoken3(RadioButton radHaniJoken3) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB23().setRadHaniJoken3(radHaniJoken3);
    }

    @JsonIgnore
    public ChushutsuShosaiB24Div getChushutsuShosaiB24() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB24();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB24(ChushutsuShosaiB24Div ChushutsuShosaiB24) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB24(ChushutsuShosaiB24);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken4() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB24().getRadHaniJoken4();
    }

    @JsonIgnore
    public void  setRadHaniJoken4(RadioButton radHaniJoken4) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB24().setRadHaniJoken4(radHaniJoken4);
    }

    @JsonIgnore
    public ChushutsuShosaiB25Div getChushutsuShosaiB25() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB25(ChushutsuShosaiB25Div ChushutsuShosaiB25) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB25(ChushutsuShosaiB25);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().setTxtChushutsuHani(txtChushutsuHani);
    }

    @JsonIgnore
    public CheckBoxList getChkChokkinNomi2() {
        return this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().getChkChokkinNomi2();
    }

    @JsonIgnore
    public void  setChkChokkinNomi2(CheckBoxList chkChokkinNomi2) {
        this.getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().setChkChokkinNomi2(chkChokkinNomi2);
    }

    // </editor-fold>
}
