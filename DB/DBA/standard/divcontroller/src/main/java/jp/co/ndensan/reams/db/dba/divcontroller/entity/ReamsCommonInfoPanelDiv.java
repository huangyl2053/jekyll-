package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * ReamsCommonInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ReamsCommonInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJuminShubetsu")
    private TextBox txtJuminShubetsu;
    @JsonProperty("txtHurikana")
    private TextBox txtHurikana;
    @JsonProperty("txtGender")
    private TextBox txtGender;
    @JsonProperty("txtAge")
    private TextBox txtAge;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtDateOfBirth")
    private TextBoxFlexibleDate txtDateOfBirth;
    @JsonProperty("lblJusho")
    private Label lblJusho;
    @JsonProperty("txtJushoCode")
    private TextBox txtJushoCode;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtGyoseiku")
    private TextBox txtGyoseiku;
    @JsonProperty("txtKumiai")
    private TextBox txtKumiai;
    @JsonProperty("txtSetaiCode")
    private TextBox txtSetaiCode;
    @JsonProperty("txtJuminhyoCode")
    private TextBox txtJuminhyoCode;
    @JsonProperty("txtRenrakusaki1")
    private TextBox txtRenrakusaki1;
    @JsonProperty("txtRenrakusaki2")
    private TextBox txtRenrakusaki2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJuminShubetsu")
    public TextBox getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    @JsonProperty("txtJuminShubetsu")
    public void setTxtJuminShubetsu(TextBox txtJuminShubetsu) {
        this.txtJuminShubetsu=txtJuminShubetsu;
    }

    @JsonProperty("txtHurikana")
    public TextBox getTxtHurikana() {
        return txtHurikana;
    }

    @JsonProperty("txtHurikana")
    public void setTxtHurikana(TextBox txtHurikana) {
        this.txtHurikana=txtHurikana;
    }

    @JsonProperty("txtGender")
    public TextBox getTxtGender() {
        return txtGender;
    }

    @JsonProperty("txtGender")
    public void setTxtGender(TextBox txtGender) {
        this.txtGender=txtGender;
    }

    @JsonProperty("txtAge")
    public TextBox getTxtAge() {
        return txtAge;
    }

    @JsonProperty("txtAge")
    public void setTxtAge(TextBox txtAge) {
        this.txtAge=txtAge;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtDateOfBirth")
    public TextBoxFlexibleDate getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    @JsonProperty("txtDateOfBirth")
    public void setTxtDateOfBirth(TextBoxFlexibleDate txtDateOfBirth) {
        this.txtDateOfBirth=txtDateOfBirth;
    }

    @JsonProperty("lblJusho")
    public Label getLblJusho() {
        return lblJusho;
    }

    @JsonProperty("lblJusho")
    public void setLblJusho(Label lblJusho) {
        this.lblJusho=lblJusho;
    }

    @JsonProperty("txtJushoCode")
    public TextBox getTxtJushoCode() {
        return txtJushoCode;
    }

    @JsonProperty("txtJushoCode")
    public void setTxtJushoCode(TextBox txtJushoCode) {
        this.txtJushoCode=txtJushoCode;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("txtGyoseiku")
    public TextBox getTxtGyoseiku() {
        return txtGyoseiku;
    }

    @JsonProperty("txtGyoseiku")
    public void setTxtGyoseiku(TextBox txtGyoseiku) {
        this.txtGyoseiku=txtGyoseiku;
    }

    @JsonProperty("txtKumiai")
    public TextBox getTxtKumiai() {
        return txtKumiai;
    }

    @JsonProperty("txtKumiai")
    public void setTxtKumiai(TextBox txtKumiai) {
        this.txtKumiai=txtKumiai;
    }

    @JsonProperty("txtSetaiCode")
    public TextBox getTxtSetaiCode() {
        return txtSetaiCode;
    }

    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBox txtSetaiCode) {
        this.txtSetaiCode=txtSetaiCode;
    }

    @JsonProperty("txtJuminhyoCode")
    public TextBox getTxtJuminhyoCode() {
        return txtJuminhyoCode;
    }

    @JsonProperty("txtJuminhyoCode")
    public void setTxtJuminhyoCode(TextBox txtJuminhyoCode) {
        this.txtJuminhyoCode=txtJuminhyoCode;
    }

    @JsonProperty("txtRenrakusaki1")
    public TextBox getTxtRenrakusaki1() {
        return txtRenrakusaki1;
    }

    @JsonProperty("txtRenrakusaki1")
    public void setTxtRenrakusaki1(TextBox txtRenrakusaki1) {
        this.txtRenrakusaki1=txtRenrakusaki1;
    }

    @JsonProperty("txtRenrakusaki2")
    public TextBox getTxtRenrakusaki2() {
        return txtRenrakusaki2;
    }

    @JsonProperty("txtRenrakusaki2")
    public void setTxtRenrakusaki2(TextBox txtRenrakusaki2) {
        this.txtRenrakusaki2=txtRenrakusaki2;
    }

}
