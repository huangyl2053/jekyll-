package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8060001;
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
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;
    @JsonProperty("lblNinteiSHinseiYmd")
    private Label lblNinteiSHinseiYmd;
    @JsonProperty("txtNinteiShinseiYmdSt")
    private TextBoxDate txtNinteiShinseiYmdSt;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtNinteiShinseiYmdEd")
    private TextBoxDate txtNinteiShinseiYmdEd;
    @JsonProperty("lblChohyoShiji")
    private Label lblChohyoShiji;
    @JsonProperty("radNinteiShinseiMonitor")
    private RadioButton radNinteiShinseiMonitor;
    @JsonProperty("radShinseishaIchiran")
    private RadioButton radShinseishaIchiran;
    @JsonProperty("radShinseiKyakka")
    private RadioButton radShinseiKyakka;
    @JsonProperty("btnChohyoOutput")
    private Button btnChohyoOutput;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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

    @JsonProperty("radNinteiShinseiMonitor")
    public RadioButton getRadNinteiShinseiMonitor() {
        return radNinteiShinseiMonitor;
    }

    @JsonProperty("radNinteiShinseiMonitor")
    public void setRadNinteiShinseiMonitor(RadioButton radNinteiShinseiMonitor) {
        this.radNinteiShinseiMonitor=radNinteiShinseiMonitor;
    }

    @JsonProperty("radShinseishaIchiran")
    public RadioButton getRadShinseishaIchiran() {
        return radShinseishaIchiran;
    }

    @JsonProperty("radShinseishaIchiran")
    public void setRadShinseishaIchiran(RadioButton radShinseishaIchiran) {
        this.radShinseishaIchiran=radShinseishaIchiran;
    }

    @JsonProperty("radShinseiKyakka")
    public RadioButton getRadShinseiKyakka() {
        return radShinseiKyakka;
    }

    @JsonProperty("radShinseiKyakka")
    public void setRadShinseiKyakka(RadioButton radShinseiKyakka) {
        this.radShinseiKyakka=radShinseiKyakka;
    }

    @JsonProperty("btnChohyoOutput")
    public Button getBtnChohyoOutput() {
        return btnChohyoOutput;
    }

    @JsonProperty("btnChohyoOutput")
    public void setBtnChohyoOutput(Button btnChohyoOutput) {
        this.btnChohyoOutput=btnChohyoOutput;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
