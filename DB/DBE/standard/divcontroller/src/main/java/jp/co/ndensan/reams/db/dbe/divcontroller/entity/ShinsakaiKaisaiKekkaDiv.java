package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsakaiShinsainIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiKaisaiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblYoteibi")
    private Label lblYoteibi;
    @JsonProperty("txtKaisaiYoteibi")
    private TextBoxFlexibleDate txtKaisaiYoteibi;
    @JsonProperty("lblYoteiTime")
    private Label lblYoteiTime;
    @JsonProperty("txtYoteiStartTime")
    private TextBoxTime txtYoteiStartTime;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtYoteiEndTime")
    private TextBoxTime txtYoteiEndTime;
    @JsonProperty("lblYoteiKaijo")
    private Label lblYoteiKaijo;
    @JsonProperty("txtYoteiKaijo")
    private TextBox txtYoteiKaijo;
    @JsonProperty("lblKaisaiBi")
    private Label lblKaisaiBi;
    @JsonProperty("txtKaisaiBi")
    private TextBoxFlexibleDate txtKaisaiBi;
    @JsonProperty("lblKaisaiTime")
    private Label lblKaisaiTime;
    @JsonProperty("txtKaisaiStartTime")
    private TextBoxTime txtKaisaiStartTime;
    @JsonProperty("lblKara2")
    private Label lblKara2;
    @JsonProperty("txtKaisaiEndTime")
    private TextBoxTime txtKaisaiEndTime;
    @JsonProperty("lblKaisaiKaijo")
    private Label lblKaisaiKaijo;
    @JsonProperty("ddlKaisaiBasho")
    private DropDownList ddlKaisaiBasho;
    @JsonProperty("lblGogitai")
    private Label lblGogitai;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("lblYoteiTeiin")
    private Label lblYoteiTeiin;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("lblJissiNinzu")
    private Label lblJissiNinzu;
    @JsonProperty("txtJissiSu")
    private TextBoxNum txtJissiSu;
    @JsonProperty("lblShinsaIn")
    private Label lblShinsaIn;
    @JsonProperty("btnAddIin")
    private Button btnAddIin;
    @JsonProperty("btnRemoveIin")
    private Button btnRemoveIin;
    @JsonProperty("dgShinsakaiShinsainIchiran")
    private DataGrid<dgShinsakaiShinsainIchiran_Row> dgShinsakaiShinsainIchiran;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblYoteibi")
    public Label getLblYoteibi() {
        return lblYoteibi;
    }

    @JsonProperty("lblYoteibi")
    public void setLblYoteibi(Label lblYoteibi) {
        this.lblYoteibi=lblYoteibi;
    }

    @JsonProperty("txtKaisaiYoteibi")
    public TextBoxFlexibleDate getTxtKaisaiYoteibi() {
        return txtKaisaiYoteibi;
    }

    @JsonProperty("txtKaisaiYoteibi")
    public void setTxtKaisaiYoteibi(TextBoxFlexibleDate txtKaisaiYoteibi) {
        this.txtKaisaiYoteibi=txtKaisaiYoteibi;
    }

    @JsonProperty("lblYoteiTime")
    public Label getLblYoteiTime() {
        return lblYoteiTime;
    }

    @JsonProperty("lblYoteiTime")
    public void setLblYoteiTime(Label lblYoteiTime) {
        this.lblYoteiTime=lblYoteiTime;
    }

    @JsonProperty("txtYoteiStartTime")
    public TextBoxTime getTxtYoteiStartTime() {
        return txtYoteiStartTime;
    }

    @JsonProperty("txtYoteiStartTime")
    public void setTxtYoteiStartTime(TextBoxTime txtYoteiStartTime) {
        this.txtYoteiStartTime=txtYoteiStartTime;
    }

    @JsonProperty("lblKara")
    public Label getLblKara() {
        return lblKara;
    }

    @JsonProperty("lblKara")
    public void setLblKara(Label lblKara) {
        this.lblKara=lblKara;
    }

    @JsonProperty("txtYoteiEndTime")
    public TextBoxTime getTxtYoteiEndTime() {
        return txtYoteiEndTime;
    }

    @JsonProperty("txtYoteiEndTime")
    public void setTxtYoteiEndTime(TextBoxTime txtYoteiEndTime) {
        this.txtYoteiEndTime=txtYoteiEndTime;
    }

    @JsonProperty("lblYoteiKaijo")
    public Label getLblYoteiKaijo() {
        return lblYoteiKaijo;
    }

    @JsonProperty("lblYoteiKaijo")
    public void setLblYoteiKaijo(Label lblYoteiKaijo) {
        this.lblYoteiKaijo=lblYoteiKaijo;
    }

    @JsonProperty("txtYoteiKaijo")
    public TextBox getTxtYoteiKaijo() {
        return txtYoteiKaijo;
    }

    @JsonProperty("txtYoteiKaijo")
    public void setTxtYoteiKaijo(TextBox txtYoteiKaijo) {
        this.txtYoteiKaijo=txtYoteiKaijo;
    }

    @JsonProperty("lblKaisaiBi")
    public Label getLblKaisaiBi() {
        return lblKaisaiBi;
    }

    @JsonProperty("lblKaisaiBi")
    public void setLblKaisaiBi(Label lblKaisaiBi) {
        this.lblKaisaiBi=lblKaisaiBi;
    }

    @JsonProperty("txtKaisaiBi")
    public TextBoxFlexibleDate getTxtKaisaiBi() {
        return txtKaisaiBi;
    }

    @JsonProperty("txtKaisaiBi")
    public void setTxtKaisaiBi(TextBoxFlexibleDate txtKaisaiBi) {
        this.txtKaisaiBi=txtKaisaiBi;
    }

    @JsonProperty("lblKaisaiTime")
    public Label getLblKaisaiTime() {
        return lblKaisaiTime;
    }

    @JsonProperty("lblKaisaiTime")
    public void setLblKaisaiTime(Label lblKaisaiTime) {
        this.lblKaisaiTime=lblKaisaiTime;
    }

    @JsonProperty("txtKaisaiStartTime")
    public TextBoxTime getTxtKaisaiStartTime() {
        return txtKaisaiStartTime;
    }

    @JsonProperty("txtKaisaiStartTime")
    public void setTxtKaisaiStartTime(TextBoxTime txtKaisaiStartTime) {
        this.txtKaisaiStartTime=txtKaisaiStartTime;
    }

    @JsonProperty("lblKara2")
    public Label getLblKara2() {
        return lblKara2;
    }

    @JsonProperty("lblKara2")
    public void setLblKara2(Label lblKara2) {
        this.lblKara2=lblKara2;
    }

    @JsonProperty("txtKaisaiEndTime")
    public TextBoxTime getTxtKaisaiEndTime() {
        return txtKaisaiEndTime;
    }

    @JsonProperty("txtKaisaiEndTime")
    public void setTxtKaisaiEndTime(TextBoxTime txtKaisaiEndTime) {
        this.txtKaisaiEndTime=txtKaisaiEndTime;
    }

    @JsonProperty("lblKaisaiKaijo")
    public Label getLblKaisaiKaijo() {
        return lblKaisaiKaijo;
    }

    @JsonProperty("lblKaisaiKaijo")
    public void setLblKaisaiKaijo(Label lblKaisaiKaijo) {
        this.lblKaisaiKaijo=lblKaisaiKaijo;
    }

    @JsonProperty("ddlKaisaiBasho")
    public DropDownList getDdlKaisaiBasho() {
        return ddlKaisaiBasho;
    }

    @JsonProperty("ddlKaisaiBasho")
    public void setDdlKaisaiBasho(DropDownList ddlKaisaiBasho) {
        this.ddlKaisaiBasho=ddlKaisaiBasho;
    }

    @JsonProperty("lblGogitai")
    public Label getLblGogitai() {
        return lblGogitai;
    }

    @JsonProperty("lblGogitai")
    public void setLblGogitai(Label lblGogitai) {
        this.lblGogitai=lblGogitai;
    }

    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai=txtGogitai;
    }

    @JsonProperty("lblYoteiTeiin")
    public Label getLblYoteiTeiin() {
        return lblYoteiTeiin;
    }

    @JsonProperty("lblYoteiTeiin")
    public void setLblYoteiTeiin(Label lblYoteiTeiin) {
        this.lblYoteiTeiin=lblYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin=txtYoteiTeiin;
    }

    @JsonProperty("lblJissiNinzu")
    public Label getLblJissiNinzu() {
        return lblJissiNinzu;
    }

    @JsonProperty("lblJissiNinzu")
    public void setLblJissiNinzu(Label lblJissiNinzu) {
        this.lblJissiNinzu=lblJissiNinzu;
    }

    @JsonProperty("txtJissiSu")
    public TextBoxNum getTxtJissiSu() {
        return txtJissiSu;
    }

    @JsonProperty("txtJissiSu")
    public void setTxtJissiSu(TextBoxNum txtJissiSu) {
        this.txtJissiSu=txtJissiSu;
    }

    @JsonProperty("lblShinsaIn")
    public Label getLblShinsaIn() {
        return lblShinsaIn;
    }

    @JsonProperty("lblShinsaIn")
    public void setLblShinsaIn(Label lblShinsaIn) {
        this.lblShinsaIn=lblShinsaIn;
    }

    @JsonProperty("btnAddIin")
    public Button getBtnAddIin() {
        return btnAddIin;
    }

    @JsonProperty("btnAddIin")
    public void setBtnAddIin(Button btnAddIin) {
        this.btnAddIin=btnAddIin;
    }

    @JsonProperty("btnRemoveIin")
    public Button getBtnRemoveIin() {
        return btnRemoveIin;
    }

    @JsonProperty("btnRemoveIin")
    public void setBtnRemoveIin(Button btnRemoveIin) {
        this.btnRemoveIin=btnRemoveIin;
    }

    @JsonProperty("dgShinsakaiShinsainIchiran")
    public DataGrid<dgShinsakaiShinsainIchiran_Row> getDgShinsakaiShinsainIchiran() {
        return dgShinsakaiShinsainIchiran;
    }

    @JsonProperty("dgShinsakaiShinsainIchiran")
    public void setDgShinsakaiShinsainIchiran(DataGrid<dgShinsakaiShinsainIchiran_Row> dgShinsakaiShinsainIchiran) {
        this.dgShinsakaiShinsainIchiran=dgShinsakaiShinsainIchiran;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
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
