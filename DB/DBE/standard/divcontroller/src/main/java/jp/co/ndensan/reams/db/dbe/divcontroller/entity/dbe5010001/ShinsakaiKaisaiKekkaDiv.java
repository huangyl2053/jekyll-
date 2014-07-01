package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001.ShinsakaiIinIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001.dgShinsakaiShinsainIchiran_Row;
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
    @JsonProperty("txtShinsakaiMeisho")
    private TextBox txtShinsakaiMeisho;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("txtJissiSu")
    private TextBoxNum txtJissiSu;
    @JsonProperty("txtKaisaiYoteibi")
    private TextBoxFlexibleDate txtKaisaiYoteibi;
    @JsonProperty("txtYoteiStartTime")
    private TextBoxTime txtYoteiStartTime;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtYoteiEndTime")
    private TextBoxTime txtYoteiEndTime;
    @JsonProperty("txtYoteiKaijo")
    private TextBox txtYoteiKaijo;
    @JsonProperty("txtKaisaiBi")
    private TextBoxFlexibleDate txtKaisaiBi;
    @JsonProperty("txtKaisaiStartTime")
    private TextBoxTime txtKaisaiStartTime;
    @JsonProperty("lblKara2")
    private Label lblKara2;
    @JsonProperty("txtKaisaiEndTime")
    private TextBoxTime txtKaisaiEndTime;
    @JsonProperty("ddlKaisaiBasho")
    private DropDownList ddlKaisaiBasho;
    @JsonProperty("lblShinsaIn")
    private Label lblShinsaIn;
    @JsonProperty("btnAddIin")
    private Button btnAddIin;
    @JsonProperty("btnRemoveIin")
    private Button btnRemoveIin;
    @JsonProperty("dgShinsakaiShinsainIchiran")
    private DataGrid<dgShinsakaiShinsainIchiran_Row> dgShinsakaiShinsainIchiran;
    @JsonProperty("btnToCancel")
    private Button btnToCancel;
    @JsonProperty("btnLoadData")
    private Button btnLoadData;
    @JsonProperty("ShinsakaiIinIchiran")
    private ShinsakaiIinIchiranDiv ShinsakaiIinIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiMeisho")
    public TextBox getTxtShinsakaiMeisho() {
        return txtShinsakaiMeisho;
    }

    @JsonProperty("txtShinsakaiMeisho")
    public void setTxtShinsakaiMeisho(TextBox txtShinsakaiMeisho) {
        this.txtShinsakaiMeisho=txtShinsakaiMeisho;
    }

    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai=txtGogitai;
    }

    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin=txtYoteiTeiin;
    }

    @JsonProperty("txtJissiSu")
    public TextBoxNum getTxtJissiSu() {
        return txtJissiSu;
    }

    @JsonProperty("txtJissiSu")
    public void setTxtJissiSu(TextBoxNum txtJissiSu) {
        this.txtJissiSu=txtJissiSu;
    }

    @JsonProperty("txtKaisaiYoteibi")
    public TextBoxFlexibleDate getTxtKaisaiYoteibi() {
        return txtKaisaiYoteibi;
    }

    @JsonProperty("txtKaisaiYoteibi")
    public void setTxtKaisaiYoteibi(TextBoxFlexibleDate txtKaisaiYoteibi) {
        this.txtKaisaiYoteibi=txtKaisaiYoteibi;
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

    @JsonProperty("txtYoteiKaijo")
    public TextBox getTxtYoteiKaijo() {
        return txtYoteiKaijo;
    }

    @JsonProperty("txtYoteiKaijo")
    public void setTxtYoteiKaijo(TextBox txtYoteiKaijo) {
        this.txtYoteiKaijo=txtYoteiKaijo;
    }

    @JsonProperty("txtKaisaiBi")
    public TextBoxFlexibleDate getTxtKaisaiBi() {
        return txtKaisaiBi;
    }

    @JsonProperty("txtKaisaiBi")
    public void setTxtKaisaiBi(TextBoxFlexibleDate txtKaisaiBi) {
        this.txtKaisaiBi=txtKaisaiBi;
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

    @JsonProperty("ddlKaisaiBasho")
    public DropDownList getDdlKaisaiBasho() {
        return ddlKaisaiBasho;
    }

    @JsonProperty("ddlKaisaiBasho")
    public void setDdlKaisaiBasho(DropDownList ddlKaisaiBasho) {
        this.ddlKaisaiBasho=ddlKaisaiBasho;
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

    @JsonProperty("btnToCancel")
    public Button getBtnToCancel() {
        return btnToCancel;
    }

    @JsonProperty("btnToCancel")
    public void setBtnToCancel(Button btnToCancel) {
        this.btnToCancel=btnToCancel;
    }

    @JsonProperty("btnLoadData")
    public Button getBtnLoadData() {
        return btnLoadData;
    }

    @JsonProperty("btnLoadData")
    public void setBtnLoadData(Button btnLoadData) {
        this.btnLoadData=btnLoadData;
    }

    @JsonProperty("ShinsakaiIinIchiran")
    public ShinsakaiIinIchiranDiv getShinsakaiIinIchiran() {
        return ShinsakaiIinIchiran;
    }

    @JsonProperty("ShinsakaiIinIchiran")
    public void setShinsakaiIinIchiran(ShinsakaiIinIchiranDiv ShinsakaiIinIchiran) {
        this.ShinsakaiIinIchiran=ShinsakaiIinIchiran;
    }

}
