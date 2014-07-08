package jp.co.ndensan.reams.db.dbe.divcontroller.entity.kaigoHihokenshaJoho;
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
 * KaigoHihokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoHihokenshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenshaNo")
    private TextBox txtHokenshaNo;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtHihokenshaShimei")
    private TextBox txtHihokenshaShimei;
    @JsonProperty("txtHihokenshaKubun")
    private TextBox txtHihokenshaKubun;
    @JsonProperty("txtBirthDay")
    private TextBoxDate txtBirthDay;
    @JsonProperty("txtNenrei")
    private TextBox txtNenrei;
    @JsonProperty("btnShichosonRenraku")
    private Button btnShichosonRenraku;
    @JsonProperty("txtNinteiShinseiYMD")
    private TextBoxFlexibleDate txtNinteiShinseiYMD;
    @JsonProperty("txtShinseiKubun")
    private TextBox txtShinseiKubun;
    @JsonProperty("txtZenkaiYokaigodo")
    private TextBox txtZenkaiYokaigodo;
    @JsonProperty("txtZenYukokikanStart")
    private TextBoxFlexibleDate txtZenYukokikanStart;
    @JsonProperty("lblKara2")
    private Label lblKara2;
    @JsonProperty("txtZenYukokikanEnd")
    private TextBoxFlexibleDate txtZenYukokikanEnd;
    @JsonProperty("btnRenrakusaki")
    private Button btnRenrakusaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHokenshaNo")
    public TextBox getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBox txtHokenshaNo) {
        this.txtHokenshaNo=txtHokenshaNo;
    }

    @JsonProperty("txtHokenshaMeisho")
    public TextBox getTxtHokenshaMeisho() {
        return txtHokenshaMeisho;
    }

    @JsonProperty("txtHokenshaMeisho")
    public void setTxtHokenshaMeisho(TextBox txtHokenshaMeisho) {
        this.txtHokenshaMeisho=txtHokenshaMeisho;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaShimei")
    public TextBox getTxtHihokenshaShimei() {
        return txtHihokenshaShimei;
    }

    @JsonProperty("txtHihokenshaShimei")
    public void setTxtHihokenshaShimei(TextBox txtHihokenshaShimei) {
        this.txtHihokenshaShimei=txtHihokenshaShimei;
    }

    @JsonProperty("txtHihokenshaKubun")
    public TextBox getTxtHihokenshaKubun() {
        return txtHihokenshaKubun;
    }

    @JsonProperty("txtHihokenshaKubun")
    public void setTxtHihokenshaKubun(TextBox txtHihokenshaKubun) {
        this.txtHihokenshaKubun=txtHihokenshaKubun;
    }

    @JsonProperty("txtBirthDay")
    public TextBoxDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxDate txtBirthDay) {
        this.txtBirthDay=txtBirthDay;
    }

    @JsonProperty("txtNenrei")
    public TextBox getTxtNenrei() {
        return txtNenrei;
    }

    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBox txtNenrei) {
        this.txtNenrei=txtNenrei;
    }

    @JsonProperty("btnShichosonRenraku")
    public Button getBtnShichosonRenraku() {
        return btnShichosonRenraku;
    }

    @JsonProperty("btnShichosonRenraku")
    public void setBtnShichosonRenraku(Button btnShichosonRenraku) {
        this.btnShichosonRenraku=btnShichosonRenraku;
    }

    @JsonProperty("txtNinteiShinseiYMD")
    public TextBoxFlexibleDate getTxtNinteiShinseiYMD() {
        return txtNinteiShinseiYMD;
    }

    @JsonProperty("txtNinteiShinseiYMD")
    public void setTxtNinteiShinseiYMD(TextBoxFlexibleDate txtNinteiShinseiYMD) {
        this.txtNinteiShinseiYMD=txtNinteiShinseiYMD;
    }

    @JsonProperty("txtShinseiKubun")
    public TextBox getTxtShinseiKubun() {
        return txtShinseiKubun;
    }

    @JsonProperty("txtShinseiKubun")
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.txtShinseiKubun=txtShinseiKubun;
    }

    @JsonProperty("txtZenkaiYokaigodo")
    public TextBox getTxtZenkaiYokaigodo() {
        return txtZenkaiYokaigodo;
    }

    @JsonProperty("txtZenkaiYokaigodo")
    public void setTxtZenkaiYokaigodo(TextBox txtZenkaiYokaigodo) {
        this.txtZenkaiYokaigodo=txtZenkaiYokaigodo;
    }

    @JsonProperty("txtZenYukokikanStart")
    public TextBoxFlexibleDate getTxtZenYukokikanStart() {
        return txtZenYukokikanStart;
    }

    @JsonProperty("txtZenYukokikanStart")
    public void setTxtZenYukokikanStart(TextBoxFlexibleDate txtZenYukokikanStart) {
        this.txtZenYukokikanStart=txtZenYukokikanStart;
    }

    @JsonProperty("lblKara2")
    public Label getLblKara2() {
        return lblKara2;
    }

    @JsonProperty("lblKara2")
    public void setLblKara2(Label lblKara2) {
        this.lblKara2=lblKara2;
    }

    @JsonProperty("txtZenYukokikanEnd")
    public TextBoxFlexibleDate getTxtZenYukokikanEnd() {
        return txtZenYukokikanEnd;
    }

    @JsonProperty("txtZenYukokikanEnd")
    public void setTxtZenYukokikanEnd(TextBoxFlexibleDate txtZenYukokikanEnd) {
        this.txtZenYukokikanEnd=txtZenYukokikanEnd;
    }

    @JsonProperty("btnRenrakusaki")
    public Button getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(Button btnRenrakusaki) {
        this.btnRenrakusaki=btnRenrakusaki;
    }

}
