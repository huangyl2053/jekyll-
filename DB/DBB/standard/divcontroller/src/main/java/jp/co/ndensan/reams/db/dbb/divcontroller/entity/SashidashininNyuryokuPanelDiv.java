package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 17:14:03 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SashidashininNyuryokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SashidashininNyuryokuPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSashidashininYubinNo")
    private Label lblSashidashininYubinNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("btnSashidashininZenkokuJusho")
    private Button btnSashidashininZenkokuJusho;
    @JsonProperty("lblShozai")
    private Label lblShozai;
    @JsonProperty("txtShozai")
    private TextBox txtShozai;
    @JsonProperty("lblTantoBusho")
    private Label lblTantoBusho;
    @JsonProperty("txtTantoBusho")
    private TextBox txtTantoBusho;
    @JsonProperty("lblTellNo")
    private Label lblTellNo;
    @JsonProperty("txtTellNo")
    private TextBox txtTellNo;
    @JsonProperty("btnSashidashininHozon")
    private Button btnSashidashininHozon;
    @JsonProperty("btnSashidashininHaki")
    private Button btnSashidashininHaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblSashidashininYubinNo")
    public Label getLblSashidashininYubinNo() {
        return lblSashidashininYubinNo;
    }

    @JsonProperty("lblSashidashininYubinNo")
    public void setLblSashidashininYubinNo(Label lblSashidashininYubinNo) {
        this.lblSashidashininYubinNo=lblSashidashininYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("btnSashidashininZenkokuJusho")
    public Button getBtnSashidashininZenkokuJusho() {
        return btnSashidashininZenkokuJusho;
    }

    @JsonProperty("btnSashidashininZenkokuJusho")
    public void setBtnSashidashininZenkokuJusho(Button btnSashidashininZenkokuJusho) {
        this.btnSashidashininZenkokuJusho=btnSashidashininZenkokuJusho;
    }

    @JsonProperty("lblShozai")
    public Label getLblShozai() {
        return lblShozai;
    }

    @JsonProperty("lblShozai")
    public void setLblShozai(Label lblShozai) {
        this.lblShozai=lblShozai;
    }

    @JsonProperty("txtShozai")
    public TextBox getTxtShozai() {
        return txtShozai;
    }

    @JsonProperty("txtShozai")
    public void setTxtShozai(TextBox txtShozai) {
        this.txtShozai=txtShozai;
    }

    @JsonProperty("lblTantoBusho")
    public Label getLblTantoBusho() {
        return lblTantoBusho;
    }

    @JsonProperty("lblTantoBusho")
    public void setLblTantoBusho(Label lblTantoBusho) {
        this.lblTantoBusho=lblTantoBusho;
    }

    @JsonProperty("txtTantoBusho")
    public TextBox getTxtTantoBusho() {
        return txtTantoBusho;
    }

    @JsonProperty("txtTantoBusho")
    public void setTxtTantoBusho(TextBox txtTantoBusho) {
        this.txtTantoBusho=txtTantoBusho;
    }

    @JsonProperty("lblTellNo")
    public Label getLblTellNo() {
        return lblTellNo;
    }

    @JsonProperty("lblTellNo")
    public void setLblTellNo(Label lblTellNo) {
        this.lblTellNo=lblTellNo;
    }

    @JsonProperty("txtTellNo")
    public TextBox getTxtTellNo() {
        return txtTellNo;
    }

    @JsonProperty("txtTellNo")
    public void setTxtTellNo(TextBox txtTellNo) {
        this.txtTellNo=txtTellNo;
    }

    @JsonProperty("btnSashidashininHozon")
    public Button getBtnSashidashininHozon() {
        return btnSashidashininHozon;
    }

    @JsonProperty("btnSashidashininHozon")
    public void setBtnSashidashininHozon(Button btnSashidashininHozon) {
        this.btnSashidashininHozon=btnSashidashininHozon;
    }

    @JsonProperty("btnSashidashininHaki")
    public Button getBtnSashidashininHaki() {
        return btnSashidashininHaki;
    }

    @JsonProperty("btnSashidashininHaki")
    public void setBtnSashidashininHaki(Button btnSashidashininHaki) {
        this.btnSashidashininHaki=btnSashidashininHaki;
    }

}
