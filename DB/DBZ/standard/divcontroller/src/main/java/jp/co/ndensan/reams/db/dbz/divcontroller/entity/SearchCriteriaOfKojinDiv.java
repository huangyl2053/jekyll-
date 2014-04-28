package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchCriteriaOfKojin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchCriteriaOfKojinDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShikibetsuCode")
    private Label lblShikibetsuCode;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("lblSetaiCode")
    private Label lblSetaiCode;
    @JsonProperty("txtSetaiCode")
    private TextBoxCode txtSetaiCode;
    @JsonProperty("lblKojinNo")
    private Label lblKojinNo;
    @JsonProperty("txtKojinNo")
    private TextBoxCode txtKojinNo;
    @JsonProperty("lblJuminShubetsu")
    private Label lblJuminShubetsu;
    @JsonProperty("ddlJuminShubetsu")
    private DropDownList ddlJuminShubetsu;
    @JsonProperty("lblShimei")
    private Label lblShimei;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("lblGender")
    private Label lblGender;
    @JsonProperty("chkGender")
    private CheckBoxList chkGender;
    @JsonProperty("lblPadding")
    private Label lblPadding;
    @JsonProperty("radSearchPatternOfShimei")
    private RadioButton radSearchPatternOfShimei;
    @JsonProperty("lblSearching")
    private Label lblSearching;
    @JsonProperty("lblBirthDay")
    private Label lblBirthDay;
    @JsonProperty("txtBirthDay")
    private TextBoxDate txtBirthDay;
    @JsonProperty("lblYubinNo")
    private Label lblYubinNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("lblJusho")
    private Label lblJusho;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShikibetsuCode")
    public Label getLblShikibetsuCode() {
        return lblShikibetsuCode;
    }

    @JsonProperty("lblShikibetsuCode")
    public void setLblShikibetsuCode(Label lblShikibetsuCode) {
        this.lblShikibetsuCode=lblShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("lblSetaiCode")
    public Label getLblSetaiCode() {
        return lblSetaiCode;
    }

    @JsonProperty("lblSetaiCode")
    public void setLblSetaiCode(Label lblSetaiCode) {
        this.lblSetaiCode=lblSetaiCode;
    }

    @JsonProperty("txtSetaiCode")
    public TextBoxCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.txtSetaiCode=txtSetaiCode;
    }

    @JsonProperty("lblKojinNo")
    public Label getLblKojinNo() {
        return lblKojinNo;
    }

    @JsonProperty("lblKojinNo")
    public void setLblKojinNo(Label lblKojinNo) {
        this.lblKojinNo=lblKojinNo;
    }

    @JsonProperty("txtKojinNo")
    public TextBoxCode getTxtKojinNo() {
        return txtKojinNo;
    }

    @JsonProperty("txtKojinNo")
    public void setTxtKojinNo(TextBoxCode txtKojinNo) {
        this.txtKojinNo=txtKojinNo;
    }

    @JsonProperty("lblJuminShubetsu")
    public Label getLblJuminShubetsu() {
        return lblJuminShubetsu;
    }

    @JsonProperty("lblJuminShubetsu")
    public void setLblJuminShubetsu(Label lblJuminShubetsu) {
        this.lblJuminShubetsu=lblJuminShubetsu;
    }

    @JsonProperty("ddlJuminShubetsu")
    public DropDownList getDdlJuminShubetsu() {
        return ddlJuminShubetsu;
    }

    @JsonProperty("ddlJuminShubetsu")
    public void setDdlJuminShubetsu(DropDownList ddlJuminShubetsu) {
        this.ddlJuminShubetsu=ddlJuminShubetsu;
    }

    @JsonProperty("lblShimei")
    public Label getLblShimei() {
        return lblShimei;
    }

    @JsonProperty("lblShimei")
    public void setLblShimei(Label lblShimei) {
        this.lblShimei=lblShimei;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("lblGender")
    public Label getLblGender() {
        return lblGender;
    }

    @JsonProperty("lblGender")
    public void setLblGender(Label lblGender) {
        this.lblGender=lblGender;
    }

    @JsonProperty("chkGender")
    public CheckBoxList getChkGender() {
        return chkGender;
    }

    @JsonProperty("chkGender")
    public void setChkGender(CheckBoxList chkGender) {
        this.chkGender=chkGender;
    }

    @JsonProperty("lblPadding")
    public Label getLblPadding() {
        return lblPadding;
    }

    @JsonProperty("lblPadding")
    public void setLblPadding(Label lblPadding) {
        this.lblPadding=lblPadding;
    }

    @JsonProperty("radSearchPatternOfShimei")
    public RadioButton getRadSearchPatternOfShimei() {
        return radSearchPatternOfShimei;
    }

    @JsonProperty("radSearchPatternOfShimei")
    public void setRadSearchPatternOfShimei(RadioButton radSearchPatternOfShimei) {
        this.radSearchPatternOfShimei=radSearchPatternOfShimei;
    }

    @JsonProperty("lblSearching")
    public Label getLblSearching() {
        return lblSearching;
    }

    @JsonProperty("lblSearching")
    public void setLblSearching(Label lblSearching) {
        this.lblSearching=lblSearching;
    }

    @JsonProperty("lblBirthDay")
    public Label getLblBirthDay() {
        return lblBirthDay;
    }

    @JsonProperty("lblBirthDay")
    public void setLblBirthDay(Label lblBirthDay) {
        this.lblBirthDay=lblBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public TextBoxDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxDate txtBirthDay) {
        this.txtBirthDay=txtBirthDay;
    }

    @JsonProperty("lblYubinNo")
    public Label getLblYubinNo() {
        return lblYubinNo;
    }

    @JsonProperty("lblYubinNo")
    public void setLblYubinNo(Label lblYubinNo) {
        this.lblYubinNo=lblYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("lblJusho")
    public Label getLblJusho() {
        return lblJusho;
    }

    @JsonProperty("lblJusho")
    public void setLblJusho(Label lblJusho) {
        this.lblJusho=lblJusho;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho=txtJusho;
    }

}
