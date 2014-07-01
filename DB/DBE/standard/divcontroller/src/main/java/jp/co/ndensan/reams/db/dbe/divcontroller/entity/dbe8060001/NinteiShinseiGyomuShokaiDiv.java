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
    @JsonProperty("lblChohyoShiji")
    private Label lblChohyoShiji;
    @JsonProperty("chkNinteiShinseiMonitor")
    private CheckBoxList chkNinteiShinseiMonitor;
    @JsonProperty("txtKoshinbiRange")
    private TextBoxDateRange txtKoshinbiRange;
    @JsonProperty("chkShinseishaIchiran")
    private CheckBoxList chkShinseishaIchiran;
    @JsonProperty("txtShinseibiRange")
    private TextBoxDateRange txtShinseibiRange;
    @JsonProperty("chkShinseiKyakka")
    private CheckBoxList chkShinseiKyakka;
    @JsonProperty("txtKyakkabiRange")
    private TextBoxDateRange txtKyakkabiRange;
    @JsonProperty("lblDummy")
    private Label lblDummy;
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

    @JsonProperty("lblChohyoShiji")
    public Label getLblChohyoShiji() {
        return lblChohyoShiji;
    }

    @JsonProperty("lblChohyoShiji")
    public void setLblChohyoShiji(Label lblChohyoShiji) {
        this.lblChohyoShiji=lblChohyoShiji;
    }

    @JsonProperty("chkNinteiShinseiMonitor")
    public CheckBoxList getChkNinteiShinseiMonitor() {
        return chkNinteiShinseiMonitor;
    }

    @JsonProperty("chkNinteiShinseiMonitor")
    public void setChkNinteiShinseiMonitor(CheckBoxList chkNinteiShinseiMonitor) {
        this.chkNinteiShinseiMonitor=chkNinteiShinseiMonitor;
    }

    @JsonProperty("txtKoshinbiRange")
    public TextBoxDateRange getTxtKoshinbiRange() {
        return txtKoshinbiRange;
    }

    @JsonProperty("txtKoshinbiRange")
    public void setTxtKoshinbiRange(TextBoxDateRange txtKoshinbiRange) {
        this.txtKoshinbiRange=txtKoshinbiRange;
    }

    @JsonProperty("chkShinseishaIchiran")
    public CheckBoxList getChkShinseishaIchiran() {
        return chkShinseishaIchiran;
    }

    @JsonProperty("chkShinseishaIchiran")
    public void setChkShinseishaIchiran(CheckBoxList chkShinseishaIchiran) {
        this.chkShinseishaIchiran=chkShinseishaIchiran;
    }

    @JsonProperty("txtShinseibiRange")
    public TextBoxDateRange getTxtShinseibiRange() {
        return txtShinseibiRange;
    }

    @JsonProperty("txtShinseibiRange")
    public void setTxtShinseibiRange(TextBoxDateRange txtShinseibiRange) {
        this.txtShinseibiRange=txtShinseibiRange;
    }

    @JsonProperty("chkShinseiKyakka")
    public CheckBoxList getChkShinseiKyakka() {
        return chkShinseiKyakka;
    }

    @JsonProperty("chkShinseiKyakka")
    public void setChkShinseiKyakka(CheckBoxList chkShinseiKyakka) {
        this.chkShinseiKyakka=chkShinseiKyakka;
    }

    @JsonProperty("txtKyakkabiRange")
    public TextBoxDateRange getTxtKyakkabiRange() {
        return txtKyakkabiRange;
    }

    @JsonProperty("txtKyakkabiRange")
    public void setTxtKyakkabiRange(TextBoxDateRange txtKyakkabiRange) {
        this.txtKyakkabiRange=txtKyakkabiRange;
    }

    @JsonProperty("lblDummy")
    public Label getLblDummy() {
        return lblDummy;
    }

    @JsonProperty("lblDummy")
    public void setLblDummy(Label lblDummy) {
        this.lblDummy=lblDummy;
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
