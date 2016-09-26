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
 * ChushutsuShosaiB10 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuShosaiB10Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunDateB")
    private TextBoxDate txtKijunDateB;
    @JsonProperty("lblJitenTaishoshaB")
    private Label lblJitenTaishoshaB;
    @JsonProperty("ChushutsuShosaiB20")
    private ChushutsuShosaiB20Div ChushutsuShosaiB20;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunDateB
     * @return txtKijunDateB
     */
    @JsonProperty("txtKijunDateB")
    public TextBoxDate getTxtKijunDateB() {
        return txtKijunDateB;
    }

    /*
     * settxtKijunDateB
     * @param txtKijunDateB txtKijunDateB
     */
    @JsonProperty("txtKijunDateB")
    public void setTxtKijunDateB(TextBoxDate txtKijunDateB) {
        this.txtKijunDateB = txtKijunDateB;
    }

    /*
     * getlblJitenTaishoshaB
     * @return lblJitenTaishoshaB
     */
    @JsonProperty("lblJitenTaishoshaB")
    public Label getLblJitenTaishoshaB() {
        return lblJitenTaishoshaB;
    }

    /*
     * setlblJitenTaishoshaB
     * @param lblJitenTaishoshaB lblJitenTaishoshaB
     */
    @JsonProperty("lblJitenTaishoshaB")
    public void setLblJitenTaishoshaB(Label lblJitenTaishoshaB) {
        this.lblJitenTaishoshaB = lblJitenTaishoshaB;
    }

    /*
     * getChushutsuShosaiB20
     * @return ChushutsuShosaiB20
     */
    @JsonProperty("ChushutsuShosaiB20")
    public ChushutsuShosaiB20Div getChushutsuShosaiB20() {
        return ChushutsuShosaiB20;
    }

    /*
     * setChushutsuShosaiB20
     * @param ChushutsuShosaiB20 ChushutsuShosaiB20
     */
    @JsonProperty("ChushutsuShosaiB20")
    public void setChushutsuShosaiB20(ChushutsuShosaiB20Div ChushutsuShosaiB20) {
        this.ChushutsuShosaiB20 = ChushutsuShosaiB20;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ChushutsuShosaiB21Div getChushutsuShosaiB21() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB21();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB21(ChushutsuShosaiB21Div ChushutsuShosaiB21) {
        this.getChushutsuShosaiB20().setChushutsuShosaiB21(ChushutsuShosaiB21);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken1() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB21().getRadHaniJoken1();
    }

    @JsonIgnore
    public void  setRadHaniJoken1(RadioButton radHaniJoken1) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB21().setRadHaniJoken1(radHaniJoken1);
    }

    @JsonIgnore
    public ChushutsuShosaiB22Div getChushutsuShosaiB22() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB22();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB22(ChushutsuShosaiB22Div ChushutsuShosaiB22) {
        this.getChushutsuShosaiB20().setChushutsuShosaiB22(ChushutsuShosaiB22);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken2() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB22().getRadHaniJoken2();
    }

    @JsonIgnore
    public void  setRadHaniJoken2(RadioButton radHaniJoken2) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB22().setRadHaniJoken2(radHaniJoken2);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseishaNomi() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB22().getChkShinseishaNomi();
    }

    @JsonIgnore
    public void  setChkShinseishaNomi(CheckBoxList chkShinseishaNomi) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB22().setChkShinseishaNomi(chkShinseishaNomi);
    }

    @JsonIgnore
    public ChushutsuShosaiB23Div getChushutsuShosaiB23() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB23();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB23(ChushutsuShosaiB23Div ChushutsuShosaiB23) {
        this.getChushutsuShosaiB20().setChushutsuShosaiB23(ChushutsuShosaiB23);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken3() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB23().getRadHaniJoken3();
    }

    @JsonIgnore
    public void  setRadHaniJoken3(RadioButton radHaniJoken3) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB23().setRadHaniJoken3(radHaniJoken3);
    }

    @JsonIgnore
    public ChushutsuShosaiB24Div getChushutsuShosaiB24() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB24();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB24(ChushutsuShosaiB24Div ChushutsuShosaiB24) {
        this.getChushutsuShosaiB20().setChushutsuShosaiB24(ChushutsuShosaiB24);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken4() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB24().getRadHaniJoken4();
    }

    @JsonIgnore
    public void  setRadHaniJoken4(RadioButton radHaniJoken4) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB24().setRadHaniJoken4(radHaniJoken4);
    }

    @JsonIgnore
    public ChushutsuShosaiB25Div getChushutsuShosaiB25() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB25();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB25(ChushutsuShosaiB25Div ChushutsuShosaiB25) {
        this.getChushutsuShosaiB20().setChushutsuShosaiB25(ChushutsuShosaiB25);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB25().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB25().setTxtChushutsuHani(txtChushutsuHani);
    }

    @JsonIgnore
    public CheckBoxList getChkChokkinNomi2() {
        return this.getChushutsuShosaiB20().getChushutsuShosaiB25().getChkChokkinNomi2();
    }

    @JsonIgnore
    public void  setChkChokkinNomi2(CheckBoxList chkChokkinNomi2) {
        this.getChushutsuShosaiB20().getChushutsuShosaiB25().setChkChokkinNomi2(chkChokkinNomi2);
    }

    // </editor-fold>
}
