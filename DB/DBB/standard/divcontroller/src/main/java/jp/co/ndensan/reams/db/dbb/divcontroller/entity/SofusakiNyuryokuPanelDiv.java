package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 09:37:23 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SofusakiNyuryokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofusakiNyuryokuPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radMaeJusho")
    private RadioButton radMaeJusho;
    @JsonProperty("lblSpace26")
    private Label lblSpace26;
    @JsonProperty("txtMaeJusho")
    private TextBox txtMaeJusho;
    @JsonProperty("btnZenkokuJushoMae")
    private Button btnZenkokuJushoMae;
    @JsonProperty("lblSpace28")
    private Label lblSpace28;
    @JsonProperty("lblMessageMaeJusho")
    private Label lblMessageMaeJusho;
    @JsonProperty("lblSpace21")
    private Label lblSpace21;
    @JsonProperty("lblSofusakiYubinNo")
    private Label lblSofusakiYubinNo;
    @JsonProperty("txtSofusakiYubinNo")
    private TextBoxYubinNo txtSofusakiYubinNo;
    @JsonProperty("lblSpace01")
    private Label lblSpace01;
    @JsonProperty("txtSofusaki01")
    private TextBox txtSofusaki01;
    @JsonProperty("lblSpace02")
    private Label lblSpace02;
    @JsonProperty("txtSofusaki02")
    private TextBox txtSofusaki02;
    @JsonProperty("lblSpace03")
    private Label lblSpace03;
    @JsonProperty("txtSofusaki03")
    private TextBox txtSofusaki03;
    @JsonProperty("lblSpace04")
    private Label lblSpace04;
    @JsonProperty("txtSofusakiOnchu")
    private TextBox txtSofusakiOnchu;
    @JsonProperty("lblOnchu")
    private Label lblOnchu;
    @JsonProperty("lblSpace05")
    private Label lblSpace05;
    @JsonProperty("txtSofusakiSama")
    private TextBox txtSofusakiSama;
    @JsonProperty("lblSama")
    private Label lblSama;
    @JsonProperty("lblSofusakiMessage")
    private Label lblSofusakiMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radMaeJusho")
    public RadioButton getRadMaeJusho() {
        return radMaeJusho;
    }

    @JsonProperty("radMaeJusho")
    public void setRadMaeJusho(RadioButton radMaeJusho) {
        this.radMaeJusho=radMaeJusho;
    }

    @JsonProperty("lblSpace26")
    public Label getLblSpace26() {
        return lblSpace26;
    }

    @JsonProperty("lblSpace26")
    public void setLblSpace26(Label lblSpace26) {
        this.lblSpace26=lblSpace26;
    }

    @JsonProperty("txtMaeJusho")
    public TextBox getTxtMaeJusho() {
        return txtMaeJusho;
    }

    @JsonProperty("txtMaeJusho")
    public void setTxtMaeJusho(TextBox txtMaeJusho) {
        this.txtMaeJusho=txtMaeJusho;
    }

    @JsonProperty("btnZenkokuJushoMae")
    public Button getBtnZenkokuJushoMae() {
        return btnZenkokuJushoMae;
    }

    @JsonProperty("btnZenkokuJushoMae")
    public void setBtnZenkokuJushoMae(Button btnZenkokuJushoMae) {
        this.btnZenkokuJushoMae=btnZenkokuJushoMae;
    }

    @JsonProperty("lblSpace28")
    public Label getLblSpace28() {
        return lblSpace28;
    }

    @JsonProperty("lblSpace28")
    public void setLblSpace28(Label lblSpace28) {
        this.lblSpace28=lblSpace28;
    }

    @JsonProperty("lblMessageMaeJusho")
    public Label getLblMessageMaeJusho() {
        return lblMessageMaeJusho;
    }

    @JsonProperty("lblMessageMaeJusho")
    public void setLblMessageMaeJusho(Label lblMessageMaeJusho) {
        this.lblMessageMaeJusho=lblMessageMaeJusho;
    }

    @JsonProperty("lblSpace21")
    public Label getLblSpace21() {
        return lblSpace21;
    }

    @JsonProperty("lblSpace21")
    public void setLblSpace21(Label lblSpace21) {
        this.lblSpace21=lblSpace21;
    }

    @JsonProperty("lblSofusakiYubinNo")
    public Label getLblSofusakiYubinNo() {
        return lblSofusakiYubinNo;
    }

    @JsonProperty("lblSofusakiYubinNo")
    public void setLblSofusakiYubinNo(Label lblSofusakiYubinNo) {
        this.lblSofusakiYubinNo=lblSofusakiYubinNo;
    }

    @JsonProperty("txtSofusakiYubinNo")
    public TextBoxYubinNo getTxtSofusakiYubinNo() {
        return txtSofusakiYubinNo;
    }

    @JsonProperty("txtSofusakiYubinNo")
    public void setTxtSofusakiYubinNo(TextBoxYubinNo txtSofusakiYubinNo) {
        this.txtSofusakiYubinNo=txtSofusakiYubinNo;
    }

    @JsonProperty("lblSpace01")
    public Label getLblSpace01() {
        return lblSpace01;
    }

    @JsonProperty("lblSpace01")
    public void setLblSpace01(Label lblSpace01) {
        this.lblSpace01=lblSpace01;
    }

    @JsonProperty("txtSofusaki01")
    public TextBox getTxtSofusaki01() {
        return txtSofusaki01;
    }

    @JsonProperty("txtSofusaki01")
    public void setTxtSofusaki01(TextBox txtSofusaki01) {
        this.txtSofusaki01=txtSofusaki01;
    }

    @JsonProperty("lblSpace02")
    public Label getLblSpace02() {
        return lblSpace02;
    }

    @JsonProperty("lblSpace02")
    public void setLblSpace02(Label lblSpace02) {
        this.lblSpace02=lblSpace02;
    }

    @JsonProperty("txtSofusaki02")
    public TextBox getTxtSofusaki02() {
        return txtSofusaki02;
    }

    @JsonProperty("txtSofusaki02")
    public void setTxtSofusaki02(TextBox txtSofusaki02) {
        this.txtSofusaki02=txtSofusaki02;
    }

    @JsonProperty("lblSpace03")
    public Label getLblSpace03() {
        return lblSpace03;
    }

    @JsonProperty("lblSpace03")
    public void setLblSpace03(Label lblSpace03) {
        this.lblSpace03=lblSpace03;
    }

    @JsonProperty("txtSofusaki03")
    public TextBox getTxtSofusaki03() {
        return txtSofusaki03;
    }

    @JsonProperty("txtSofusaki03")
    public void setTxtSofusaki03(TextBox txtSofusaki03) {
        this.txtSofusaki03=txtSofusaki03;
    }

    @JsonProperty("lblSpace04")
    public Label getLblSpace04() {
        return lblSpace04;
    }

    @JsonProperty("lblSpace04")
    public void setLblSpace04(Label lblSpace04) {
        this.lblSpace04=lblSpace04;
    }

    @JsonProperty("txtSofusakiOnchu")
    public TextBox getTxtSofusakiOnchu() {
        return txtSofusakiOnchu;
    }

    @JsonProperty("txtSofusakiOnchu")
    public void setTxtSofusakiOnchu(TextBox txtSofusakiOnchu) {
        this.txtSofusakiOnchu=txtSofusakiOnchu;
    }

    @JsonProperty("lblOnchu")
    public Label getLblOnchu() {
        return lblOnchu;
    }

    @JsonProperty("lblOnchu")
    public void setLblOnchu(Label lblOnchu) {
        this.lblOnchu=lblOnchu;
    }

    @JsonProperty("lblSpace05")
    public Label getLblSpace05() {
        return lblSpace05;
    }

    @JsonProperty("lblSpace05")
    public void setLblSpace05(Label lblSpace05) {
        this.lblSpace05=lblSpace05;
    }

    @JsonProperty("txtSofusakiSama")
    public TextBox getTxtSofusakiSama() {
        return txtSofusakiSama;
    }

    @JsonProperty("txtSofusakiSama")
    public void setTxtSofusakiSama(TextBox txtSofusakiSama) {
        this.txtSofusakiSama=txtSofusakiSama;
    }

    @JsonProperty("lblSama")
    public Label getLblSama() {
        return lblSama;
    }

    @JsonProperty("lblSama")
    public void setLblSama(Label lblSama) {
        this.lblSama=lblSama;
    }

    @JsonProperty("lblSofusakiMessage")
    public Label getLblSofusakiMessage() {
        return lblSofusakiMessage;
    }

    @JsonProperty("lblSofusakiMessage")
    public void setLblSofusakiMessage(Label lblSofusakiMessage) {
        this.lblSofusakiMessage=lblSofusakiMessage;
    }

}
