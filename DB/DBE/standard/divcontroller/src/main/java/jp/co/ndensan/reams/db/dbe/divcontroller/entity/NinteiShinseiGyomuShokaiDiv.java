package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * NinteiShinseiGyomuShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiGyomuShokaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHokensha")
    private Label lblHokensha;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;
    @JsonProperty("lblNinteiSHinseiYmd")
    private Label lblNinteiSHinseiYmd;
    @JsonProperty("lblNinteiShinseiYmdSt")
    private Label lblNinteiShinseiYmdSt;
    @JsonProperty("txtNinteiShinseiYmdSt")
    private TextBoxDate txtNinteiShinseiYmdSt;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtNinteiShinseiYmdEd")
    private TextBoxDate txtNinteiShinseiYmdEd;
    @JsonProperty("lblChohyoShiji")
    private Label lblChohyoShiji;
    @JsonProperty("lblChohyomei1")
    private Label lblChohyomei1;
    @JsonProperty("radNinteiShinseiMonitor")
    private RadioButton radNinteiShinseiMonitor;
    @JsonProperty("lblChohyomei2")
    private Label lblChohyomei2;
    @JsonProperty("radShinseishaIchiran")
    private RadioButton radShinseishaIchiran;
    @JsonProperty("lblChohyomei3")
    private Label lblChohyomei3;
    @JsonProperty("radShinseiKyakka")
    private RadioButton radShinseiKyakka;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnChohyoOutput")
    private Button btnChohyoOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHokensha")
    public Label getLblHokensha() {
        return lblHokensha;
    }

    @JsonProperty("lblHokensha")
    public void setLblHokensha(Label lblHokensha) {
        this.lblHokensha=lblHokensha;
    }

    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("txtHokenshaMeisho")
    public TextBox getTxtHokenshaMeisho() {
        return txtHokenshaMeisho;
    }

    @JsonProperty("txtHokenshaMeisho")
    public void setTxtHokenshaMeisho(TextBox txtHokenshaMeisho) {
        this.txtHokenshaMeisho=txtHokenshaMeisho;
    }

    @JsonProperty("lblNinteiSHinseiYmd")
    public Label getLblNinteiSHinseiYmd() {
        return lblNinteiSHinseiYmd;
    }

    @JsonProperty("lblNinteiSHinseiYmd")
    public void setLblNinteiSHinseiYmd(Label lblNinteiSHinseiYmd) {
        this.lblNinteiSHinseiYmd=lblNinteiSHinseiYmd;
    }

    @JsonProperty("lblNinteiShinseiYmdSt")
    public Label getLblNinteiShinseiYmdSt() {
        return lblNinteiShinseiYmdSt;
    }

    @JsonProperty("lblNinteiShinseiYmdSt")
    public void setLblNinteiShinseiYmdSt(Label lblNinteiShinseiYmdSt) {
        this.lblNinteiShinseiYmdSt=lblNinteiShinseiYmdSt;
    }

    @JsonProperty("txtNinteiShinseiYmdSt")
    public TextBoxDate getTxtNinteiShinseiYmdSt() {
        return txtNinteiShinseiYmdSt;
    }

    @JsonProperty("txtNinteiShinseiYmdSt")
    public void setTxtNinteiShinseiYmdSt(TextBoxDate txtNinteiShinseiYmdSt) {
        this.txtNinteiShinseiYmdSt=txtNinteiShinseiYmdSt;
    }

    @JsonProperty("lblKara")
    public Label getLblKara() {
        return lblKara;
    }

    @JsonProperty("lblKara")
    public void setLblKara(Label lblKara) {
        this.lblKara=lblKara;
    }

    @JsonProperty("txtNinteiShinseiYmdEd")
    public TextBoxDate getTxtNinteiShinseiYmdEd() {
        return txtNinteiShinseiYmdEd;
    }

    @JsonProperty("txtNinteiShinseiYmdEd")
    public void setTxtNinteiShinseiYmdEd(TextBoxDate txtNinteiShinseiYmdEd) {
        this.txtNinteiShinseiYmdEd=txtNinteiShinseiYmdEd;
    }

    @JsonProperty("lblChohyoShiji")
    public Label getLblChohyoShiji() {
        return lblChohyoShiji;
    }

    @JsonProperty("lblChohyoShiji")
    public void setLblChohyoShiji(Label lblChohyoShiji) {
        this.lblChohyoShiji=lblChohyoShiji;
    }

    @JsonProperty("lblChohyomei1")
    public Label getLblChohyomei1() {
        return lblChohyomei1;
    }

    @JsonProperty("lblChohyomei1")
    public void setLblChohyomei1(Label lblChohyomei1) {
        this.lblChohyomei1=lblChohyomei1;
    }

    @JsonProperty("radNinteiShinseiMonitor")
    public RadioButton getRadNinteiShinseiMonitor() {
        return radNinteiShinseiMonitor;
    }

    @JsonProperty("radNinteiShinseiMonitor")
    public void setRadNinteiShinseiMonitor(RadioButton radNinteiShinseiMonitor) {
        this.radNinteiShinseiMonitor=radNinteiShinseiMonitor;
    }

    @JsonProperty("lblChohyomei2")
    public Label getLblChohyomei2() {
        return lblChohyomei2;
    }

    @JsonProperty("lblChohyomei2")
    public void setLblChohyomei2(Label lblChohyomei2) {
        this.lblChohyomei2=lblChohyomei2;
    }

    @JsonProperty("radShinseishaIchiran")
    public RadioButton getRadShinseishaIchiran() {
        return radShinseishaIchiran;
    }

    @JsonProperty("radShinseishaIchiran")
    public void setRadShinseishaIchiran(RadioButton radShinseishaIchiran) {
        this.radShinseishaIchiran=radShinseishaIchiran;
    }

    @JsonProperty("lblChohyomei3")
    public Label getLblChohyomei3() {
        return lblChohyomei3;
    }

    @JsonProperty("lblChohyomei3")
    public void setLblChohyomei3(Label lblChohyomei3) {
        this.lblChohyomei3=lblChohyomei3;
    }

    @JsonProperty("radShinseiKyakka")
    public RadioButton getRadShinseiKyakka() {
        return radShinseiKyakka;
    }

    @JsonProperty("radShinseiKyakka")
    public void setRadShinseiKyakka(RadioButton radShinseiKyakka) {
        this.radShinseiKyakka=radShinseiKyakka;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    @JsonProperty("btnChohyoOutput")
    public Button getBtnChohyoOutput() {
        return btnChohyoOutput;
    }

    @JsonProperty("btnChohyoOutput")
    public void setBtnChohyoOutput(Button btnChohyoOutput) {
        this.btnChohyoOutput=btnChohyoOutput;
    }

}
