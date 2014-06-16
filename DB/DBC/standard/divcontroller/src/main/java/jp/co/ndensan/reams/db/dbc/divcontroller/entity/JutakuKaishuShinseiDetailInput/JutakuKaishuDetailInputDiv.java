package jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput;
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
 * JutakuKaishuDetailInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuDetailInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaishuContents")
    private TextBoxMultiLine txtKaishuContents;
    @JsonProperty("txtKaishuJigyoshaName")
    private TextBox txtKaishuJigyoshaName;
    @JsonProperty("lblKaishuTaishoAddress")
    private Label lblKaishuTaishoAddress;
    @JsonProperty("btnCopyAddress")
    private Button btnCopyAddress;
    @JsonProperty("txtKaishuTaishoAddress")
    private TextBox txtKaishuTaishoAddress;
    @JsonProperty("txtChakkoDueDate")
    private TextBoxDate txtChakkoDueDate;
    @JsonProperty("txtKanseiDueDate")
    private TextBoxDate txtKanseiDueDate;
    @JsonProperty("txtEstimatedAmount")
    private TextBoxNum txtEstimatedAmount;
    @JsonProperty("btnClearDetail")
    private Button btnClearDetail;
    @JsonProperty("btnModifyDetail")
    private Button btnModifyDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKaishuContents")
    public TextBoxMultiLine getTxtKaishuContents() {
        return txtKaishuContents;
    }

    @JsonProperty("txtKaishuContents")
    public void setTxtKaishuContents(TextBoxMultiLine txtKaishuContents) {
        this.txtKaishuContents=txtKaishuContents;
    }

    @JsonProperty("txtKaishuJigyoshaName")
    public TextBox getTxtKaishuJigyoshaName() {
        return txtKaishuJigyoshaName;
    }

    @JsonProperty("txtKaishuJigyoshaName")
    public void setTxtKaishuJigyoshaName(TextBox txtKaishuJigyoshaName) {
        this.txtKaishuJigyoshaName=txtKaishuJigyoshaName;
    }

    @JsonProperty("lblKaishuTaishoAddress")
    public Label getLblKaishuTaishoAddress() {
        return lblKaishuTaishoAddress;
    }

    @JsonProperty("lblKaishuTaishoAddress")
    public void setLblKaishuTaishoAddress(Label lblKaishuTaishoAddress) {
        this.lblKaishuTaishoAddress=lblKaishuTaishoAddress;
    }

    @JsonProperty("btnCopyAddress")
    public Button getBtnCopyAddress() {
        return btnCopyAddress;
    }

    @JsonProperty("btnCopyAddress")
    public void setBtnCopyAddress(Button btnCopyAddress) {
        this.btnCopyAddress=btnCopyAddress;
    }

    @JsonProperty("txtKaishuTaishoAddress")
    public TextBox getTxtKaishuTaishoAddress() {
        return txtKaishuTaishoAddress;
    }

    @JsonProperty("txtKaishuTaishoAddress")
    public void setTxtKaishuTaishoAddress(TextBox txtKaishuTaishoAddress) {
        this.txtKaishuTaishoAddress=txtKaishuTaishoAddress;
    }

    @JsonProperty("txtChakkoDueDate")
    public TextBoxDate getTxtChakkoDueDate() {
        return txtChakkoDueDate;
    }

    @JsonProperty("txtChakkoDueDate")
    public void setTxtChakkoDueDate(TextBoxDate txtChakkoDueDate) {
        this.txtChakkoDueDate=txtChakkoDueDate;
    }

    @JsonProperty("txtKanseiDueDate")
    public TextBoxDate getTxtKanseiDueDate() {
        return txtKanseiDueDate;
    }

    @JsonProperty("txtKanseiDueDate")
    public void setTxtKanseiDueDate(TextBoxDate txtKanseiDueDate) {
        this.txtKanseiDueDate=txtKanseiDueDate;
    }

    @JsonProperty("txtEstimatedAmount")
    public TextBoxNum getTxtEstimatedAmount() {
        return txtEstimatedAmount;
    }

    @JsonProperty("txtEstimatedAmount")
    public void setTxtEstimatedAmount(TextBoxNum txtEstimatedAmount) {
        this.txtEstimatedAmount=txtEstimatedAmount;
    }

    @JsonProperty("btnClearDetail")
    public Button getBtnClearDetail() {
        return btnClearDetail;
    }

    @JsonProperty("btnClearDetail")
    public void setBtnClearDetail(Button btnClearDetail) {
        this.btnClearDetail=btnClearDetail;
    }

    @JsonProperty("btnModifyDetail")
    public Button getBtnModifyDetail() {
        return btnModifyDetail;
    }

    @JsonProperty("btnModifyDetail")
    public void setBtnModifyDetail(Button btnModifyDetail) {
        this.btnModifyDetail=btnModifyDetail;
    }

}
