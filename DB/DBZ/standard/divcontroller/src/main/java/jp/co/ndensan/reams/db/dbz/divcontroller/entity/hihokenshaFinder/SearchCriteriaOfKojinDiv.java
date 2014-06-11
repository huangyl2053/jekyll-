package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder;
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
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtSetaiCode")
    private TextBoxCode txtSetaiCode;
    @JsonProperty("txtKojinNo")
    private TextBoxCode txtKojinNo;
    @JsonProperty("lblJuminShubetsu")
    private Label lblJuminShubetsu;
    @JsonProperty("ddlJuminShubetsu")
    private DropDownList ddlJuminShubetsu;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("chkGender")
    private CheckBoxList chkGender;
    @JsonProperty("radSearchPatternOfShimei")
    private RadioButton radSearchPatternOfShimei;
    @JsonProperty("lblSearching")
    private Label lblSearching;
    @JsonProperty("txtBirthDay")
    private TextBoxFlexibleDate txtBirthDay;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtSetaiCode")
    public TextBoxCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.txtSetaiCode=txtSetaiCode;
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

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("chkGender")
    public CheckBoxList getChkGender() {
        return chkGender;
    }

    @JsonProperty("chkGender")
    public void setChkGender(CheckBoxList chkGender) {
        this.chkGender=chkGender;
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

    @JsonProperty("txtBirthDay")
    public TextBoxFlexibleDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxFlexibleDate txtBirthDay) {
        this.txtBirthDay=txtBirthDay;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
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
