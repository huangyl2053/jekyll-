package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKaisaiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiKekkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
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
    @JsonProperty("txtYoteiEndTime")
    private TextBoxTime txtYoteiEndTime;
    @JsonProperty("txtYoteiKaijo")
    private TextBox txtYoteiKaijo;
    @JsonProperty("txtKaisaiBi")
    private TextBoxFlexibleDate txtKaisaiBi;
    @JsonProperty("txtKaisaiStartTime")
    private TextBoxTime txtKaisaiStartTime;
    @JsonProperty("txtKaisaiEndTime")
    private TextBoxTime txtKaisaiEndTime;
    @JsonProperty("txtShoyoTime")
    private TextBox txtShoyoTime;
    @JsonProperty("ddlKaisaiBasho")
    private DropDownList ddlKaisaiBasho;
    @JsonProperty("ShinsakaiIinToroku")
    private ShinsakaiIinTorokuDiv ShinsakaiIinToroku;
    @JsonProperty("onseiFile")
    private onseiFileDiv onseiFile;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiMeisho
     * @return txtShinsakaiMeisho
     */
    @JsonProperty("txtShinsakaiMeisho")
    public TextBox getTxtShinsakaiMeisho() {
        return txtShinsakaiMeisho;
    }

    /*
     * settxtShinsakaiMeisho
     * @param txtShinsakaiMeisho txtShinsakaiMeisho
     */
    @JsonProperty("txtShinsakaiMeisho")
    public void setTxtShinsakaiMeisho(TextBox txtShinsakaiMeisho) {
        this.txtShinsakaiMeisho = txtShinsakaiMeisho;
    }

    /*
     * gettxtGogitai
     * @return txtGogitai
     */
    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    /*
     * settxtGogitai
     * @param txtGogitai txtGogitai
     */
    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai = txtGogitai;
    }

    /*
     * gettxtYoteiTeiin
     * @return txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    /*
     * settxtYoteiTeiin
     * @param txtYoteiTeiin txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin = txtYoteiTeiin;
    }

    /*
     * gettxtJissiSu
     * @return txtJissiSu
     */
    @JsonProperty("txtJissiSu")
    public TextBoxNum getTxtJissiSu() {
        return txtJissiSu;
    }

    /*
     * settxtJissiSu
     * @param txtJissiSu txtJissiSu
     */
    @JsonProperty("txtJissiSu")
    public void setTxtJissiSu(TextBoxNum txtJissiSu) {
        this.txtJissiSu = txtJissiSu;
    }

    /*
     * gettxtKaisaiYoteibi
     * @return txtKaisaiYoteibi
     */
    @JsonProperty("txtKaisaiYoteibi")
    public TextBoxFlexibleDate getTxtKaisaiYoteibi() {
        return txtKaisaiYoteibi;
    }

    /*
     * settxtKaisaiYoteibi
     * @param txtKaisaiYoteibi txtKaisaiYoteibi
     */
    @JsonProperty("txtKaisaiYoteibi")
    public void setTxtKaisaiYoteibi(TextBoxFlexibleDate txtKaisaiYoteibi) {
        this.txtKaisaiYoteibi = txtKaisaiYoteibi;
    }

    /*
     * gettxtYoteiStartTime
     * @return txtYoteiStartTime
     */
    @JsonProperty("txtYoteiStartTime")
    public TextBoxTime getTxtYoteiStartTime() {
        return txtYoteiStartTime;
    }

    /*
     * settxtYoteiStartTime
     * @param txtYoteiStartTime txtYoteiStartTime
     */
    @JsonProperty("txtYoteiStartTime")
    public void setTxtYoteiStartTime(TextBoxTime txtYoteiStartTime) {
        this.txtYoteiStartTime = txtYoteiStartTime;
    }

    /*
     * gettxtYoteiEndTime
     * @return txtYoteiEndTime
     */
    @JsonProperty("txtYoteiEndTime")
    public TextBoxTime getTxtYoteiEndTime() {
        return txtYoteiEndTime;
    }

    /*
     * settxtYoteiEndTime
     * @param txtYoteiEndTime txtYoteiEndTime
     */
    @JsonProperty("txtYoteiEndTime")
    public void setTxtYoteiEndTime(TextBoxTime txtYoteiEndTime) {
        this.txtYoteiEndTime = txtYoteiEndTime;
    }

    /*
     * gettxtYoteiKaijo
     * @return txtYoteiKaijo
     */
    @JsonProperty("txtYoteiKaijo")
    public TextBox getTxtYoteiKaijo() {
        return txtYoteiKaijo;
    }

    /*
     * settxtYoteiKaijo
     * @param txtYoteiKaijo txtYoteiKaijo
     */
    @JsonProperty("txtYoteiKaijo")
    public void setTxtYoteiKaijo(TextBox txtYoteiKaijo) {
        this.txtYoteiKaijo = txtYoteiKaijo;
    }

    /*
     * gettxtKaisaiBi
     * @return txtKaisaiBi
     */
    @JsonProperty("txtKaisaiBi")
    public TextBoxFlexibleDate getTxtKaisaiBi() {
        return txtKaisaiBi;
    }

    /*
     * settxtKaisaiBi
     * @param txtKaisaiBi txtKaisaiBi
     */
    @JsonProperty("txtKaisaiBi")
    public void setTxtKaisaiBi(TextBoxFlexibleDate txtKaisaiBi) {
        this.txtKaisaiBi = txtKaisaiBi;
    }

    /*
     * gettxtKaisaiStartTime
     * @return txtKaisaiStartTime
     */
    @JsonProperty("txtKaisaiStartTime")
    public TextBoxTime getTxtKaisaiStartTime() {
        return txtKaisaiStartTime;
    }

    /*
     * settxtKaisaiStartTime
     * @param txtKaisaiStartTime txtKaisaiStartTime
     */
    @JsonProperty("txtKaisaiStartTime")
    public void setTxtKaisaiStartTime(TextBoxTime txtKaisaiStartTime) {
        this.txtKaisaiStartTime = txtKaisaiStartTime;
    }

    /*
     * gettxtKaisaiEndTime
     * @return txtKaisaiEndTime
     */
    @JsonProperty("txtKaisaiEndTime")
    public TextBoxTime getTxtKaisaiEndTime() {
        return txtKaisaiEndTime;
    }

    /*
     * settxtKaisaiEndTime
     * @param txtKaisaiEndTime txtKaisaiEndTime
     */
    @JsonProperty("txtKaisaiEndTime")
    public void setTxtKaisaiEndTime(TextBoxTime txtKaisaiEndTime) {
        this.txtKaisaiEndTime = txtKaisaiEndTime;
    }

    /*
     * gettxtShoyoTime
     * @return txtShoyoTime
     */
    @JsonProperty("txtShoyoTime")
    public TextBox getTxtShoyoTime() {
        return txtShoyoTime;
    }

    /*
     * settxtShoyoTime
     * @param txtShoyoTime txtShoyoTime
     */
    @JsonProperty("txtShoyoTime")
    public void setTxtShoyoTime(TextBox txtShoyoTime) {
        this.txtShoyoTime = txtShoyoTime;
    }

    /*
     * getddlKaisaiBasho
     * @return ddlKaisaiBasho
     */
    @JsonProperty("ddlKaisaiBasho")
    public DropDownList getDdlKaisaiBasho() {
        return ddlKaisaiBasho;
    }

    /*
     * setddlKaisaiBasho
     * @param ddlKaisaiBasho ddlKaisaiBasho
     */
    @JsonProperty("ddlKaisaiBasho")
    public void setDdlKaisaiBasho(DropDownList ddlKaisaiBasho) {
        this.ddlKaisaiBasho = ddlKaisaiBasho;
    }

    /*
     * getShinsakaiIinToroku
     * @return ShinsakaiIinToroku
     */
    @JsonProperty("ShinsakaiIinToroku")
    public ShinsakaiIinTorokuDiv getShinsakaiIinToroku() {
        return ShinsakaiIinToroku;
    }

    /*
     * setShinsakaiIinToroku
     * @param ShinsakaiIinToroku ShinsakaiIinToroku
     */
    @JsonProperty("ShinsakaiIinToroku")
    public void setShinsakaiIinToroku(ShinsakaiIinTorokuDiv ShinsakaiIinToroku) {
        this.ShinsakaiIinToroku = ShinsakaiIinToroku;
    }

    /*
     * getonseiFile
     * @return onseiFile
     */
    @JsonProperty("onseiFile")
    public onseiFileDiv getOnseiFile() {
        return onseiFile;
    }

    /*
     * setonseiFile
     * @param onseiFile onseiFile
     */
    @JsonProperty("onseiFile")
    public void setOnseiFile(onseiFileDiv onseiFile) {
        this.onseiFile = onseiFile;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return this.getShinsakaiIinToroku().getDgShinsakaiIinIchiran();
    }

    @JsonIgnore
    public void  setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.getShinsakaiIinToroku().setDgShinsakaiIinIchiran(dgShinsakaiIinIchiran);
    }

    @JsonIgnore
    public UploadPanel getUplUploadPanel() {
        return this.getOnseiFile().getUplUploadPanel();
    }

    @JsonIgnore
    public void  setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.getOnseiFile().setUplUploadPanel(uplUploadPanel);
    }

    @JsonIgnore
    public Button getBtnAddOnseiFile() {
        return this.getOnseiFile().getBtnAddOnseiFile();
    }

    @JsonIgnore
    public void  setBtnAddOnseiFile(Button btnAddOnseiFile) {
        this.getOnseiFile().setBtnAddOnseiFile(btnAddOnseiFile);
    }

    // </editor-fold>
}
