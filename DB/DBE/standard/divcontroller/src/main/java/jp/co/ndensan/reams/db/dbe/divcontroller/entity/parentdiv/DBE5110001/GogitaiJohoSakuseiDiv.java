package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GogitaiJohoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiJohoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("kensakujyoken")
    private kensakujyokenDiv kensakujyoken;
    @JsonProperty("GogitaiIchiran")
    private GogitaiIchiranDiv GogitaiIchiran;
    @JsonProperty("GogitaiShosai")
    private GogitaiShosaiDiv GogitaiShosai;
    @JsonProperty("UploadFileToroku")
    private UploadFileTorokuDiv UploadFileToroku;
    @JsonProperty("hiddenFileName")
    private RString hiddenFileName;
    @JsonProperty("hiddenFileId")
    private RString hiddenFileId;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getkensakujyoken
     * @return kensakujyoken
     */
    @JsonProperty("kensakujyoken")
    public kensakujyokenDiv getKensakujyoken() {
        return kensakujyoken;
    }

    /*
     * setkensakujyoken
     * @param kensakujyoken kensakujyoken
     */
    @JsonProperty("kensakujyoken")
    public void setKensakujyoken(kensakujyokenDiv kensakujyoken) {
        this.kensakujyoken = kensakujyoken;
    }

    /*
     * getGogitaiIchiran
     * @return GogitaiIchiran
     */
    @JsonProperty("GogitaiIchiran")
    public GogitaiIchiranDiv getGogitaiIchiran() {
        return GogitaiIchiran;
    }

    /*
     * setGogitaiIchiran
     * @param GogitaiIchiran GogitaiIchiran
     */
    @JsonProperty("GogitaiIchiran")
    public void setGogitaiIchiran(GogitaiIchiranDiv GogitaiIchiran) {
        this.GogitaiIchiran = GogitaiIchiran;
    }

    /*
     * getGogitaiShosai
     * @return GogitaiShosai
     */
    @JsonProperty("GogitaiShosai")
    public GogitaiShosaiDiv getGogitaiShosai() {
        return GogitaiShosai;
    }

    /*
     * setGogitaiShosai
     * @param GogitaiShosai GogitaiShosai
     */
    @JsonProperty("GogitaiShosai")
    public void setGogitaiShosai(GogitaiShosaiDiv GogitaiShosai) {
        this.GogitaiShosai = GogitaiShosai;
    }

    /*
     * getUploadFileToroku
     * @return UploadFileToroku
     */
    @JsonProperty("UploadFileToroku")
    public UploadFileTorokuDiv getUploadFileToroku() {
        return UploadFileToroku;
    }

    /*
     * setUploadFileToroku
     * @param UploadFileToroku UploadFileToroku
     */
    @JsonProperty("UploadFileToroku")
    public void setUploadFileToroku(UploadFileTorokuDiv UploadFileToroku) {
        this.UploadFileToroku = UploadFileToroku;
    }

    /*
     * gethiddenFileName
     * @return hiddenFileName
     */
    @JsonProperty("hiddenFileName")
    public RString getHiddenFileName() {
        return hiddenFileName;
    }

    /*
     * sethiddenFileName
     * @param hiddenFileName hiddenFileName
     */
    @JsonProperty("hiddenFileName")
    public void setHiddenFileName(RString hiddenFileName) {
        this.hiddenFileName = hiddenFileName;
    }

    /*
     * gethiddenFileId
     * @return hiddenFileId
     */
    @JsonProperty("hiddenFileId")
    public RString getHiddenFileId() {
        return hiddenFileId;
    }

    /*
     * sethiddenFileId
     * @param hiddenFileId hiddenFileId
     */
    @JsonProperty("hiddenFileId")
    public void setHiddenFileId(RString hiddenFileId) {
        this.hiddenFileId = hiddenFileId;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHyojiJoken() {
        return this.getKensakujyoken().getRadHyojiJoken();
    }

    @JsonIgnore
    public void  setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.getKensakujyoken().setRadHyojiJoken(radHyojiJoken);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakujyoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakujyoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnTsuika() {
        return this.getGogitaiIchiran().getBtnTsuika();
    }

    @JsonIgnore
    public void  setBtnTsuika(Button btnTsuika) {
        this.getGogitaiIchiran().setBtnTsuika(btnTsuika);
    }

    @JsonIgnore
    public DataGrid<dgGogitaiIchiran_Row> getDgGogitaiIchiran() {
        return this.getGogitaiIchiran().getDgGogitaiIchiran();
    }

    @JsonIgnore
    public void  setDgGogitaiIchiran(DataGrid<dgGogitaiIchiran_Row> dgGogitaiIchiran) {
        this.getGogitaiIchiran().setDgGogitaiIchiran(dgGogitaiIchiran);
    }

    @JsonIgnore
    public Button getBtnCSVShutsuryoku() {
        return this.getGogitaiIchiran().getBtnCSVShutsuryoku();
    }

    @JsonIgnore
    public void  setBtnCSVShutsuryoku(Button btnCSVShutsuryoku) {
        this.getGogitaiIchiran().setBtnCSVShutsuryoku(btnCSVShutsuryoku);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNumber() {
        return this.getGogitaiShosai().getTxtGogitaiNumber();
    }

    @JsonIgnore
    public void  setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.getGogitaiShosai().setTxtGogitaiNumber(txtGogitaiNumber);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiMeisho() {
        return this.getGogitaiShosai().getTxtGogitaiMeisho();
    }

    @JsonIgnore
    public void  setTxtGogitaiMeisho(TextBox txtGogitaiMeisho) {
        this.getGogitaiShosai().setTxtGogitaiMeisho(txtGogitaiMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlkaisaibasho() {
        return this.getGogitaiShosai().getDdlkaisaibasho();
    }

    @JsonIgnore
    public void  setDdlkaisaibasho(DropDownList ddlkaisaibasho) {
        this.getGogitaiShosai().setDdlkaisaibasho(ddlkaisaibasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoKaishiYMD() {
        return this.getGogitaiShosai().getTxtYukoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKaishiYMD(TextBoxDate txtYukoKaishiYMD) {
        this.getGogitaiShosai().setTxtYukoKaishiYMD(txtYukoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtYukoShuryoYMD() {
        return this.getGogitaiShosai().getTxtYukoShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtYukoShuryoYMD(TextBoxDate txtYukoShuryoYMD) {
        this.getGogitaiShosai().setTxtYukoShuryoYMD(txtYukoShuryoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getGogitaiShosai().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getGogitaiShosai().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBoxNum getTxtJidoWariateTeiin() {
        return this.getGogitaiShosai().getTxtJidoWariateTeiin();
    }

    @JsonIgnore
    public void  setTxtJidoWariateTeiin(TextBoxNum txtJidoWariateTeiin) {
        this.getGogitaiShosai().setTxtJidoWariateTeiin(txtJidoWariateTeiin);
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiYoteiTime() {
        return this.getGogitaiShosai().getTxtKaishiYoteiTime();
    }

    @JsonIgnore
    public void  setTxtKaishiYoteiTime(TextBoxTime txtKaishiYoteiTime) {
        this.getGogitaiShosai().setTxtKaishiYoteiTime(txtKaishiYoteiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoYoteiTime() {
        return this.getGogitaiShosai().getTxtShuryoYoteiTime();
    }

    @JsonIgnore
    public void  setTxtShuryoYoteiTime(TextBoxTime txtShuryoYoteiTime) {
        this.getGogitaiShosai().setTxtShuryoYoteiTime(txtShuryoYoteiTime);
    }

    @JsonIgnore
    public TextBoxNum getTxtIinTeiin() {
        return this.getGogitaiShosai().getTxtIinTeiin();
    }

    @JsonIgnore
    public void  setTxtIinTeiin(TextBoxNum txtIinTeiin) {
        this.getGogitaiShosai().setTxtIinTeiin(txtIinTeiin);
    }

    @JsonIgnore
    public RadioButton getRadSeishinkaiSonzai() {
        return this.getGogitaiShosai().getRadSeishinkaiSonzai();
    }

    @JsonIgnore
    public void  setRadSeishinkaiSonzai(RadioButton radSeishinkaiSonzai) {
        this.getGogitaiShosai().setRadSeishinkaiSonzai(radSeishinkaiSonzai);
    }

    @JsonIgnore
    public RadioButton getRadDummyFlag() {
        return this.getGogitaiShosai().getRadDummyFlag();
    }

    @JsonIgnore
    public void  setRadDummyFlag(RadioButton radDummyFlag) {
        this.getGogitaiShosai().setRadDummyFlag(radDummyFlag);
    }

    @JsonIgnore
    public Space getSpSpace() {
        return this.getGogitaiShosai().getSpSpace();
    }

    @JsonIgnore
    public void  setSpSpace(Space spSpace) {
        this.getGogitaiShosai().setSpSpace(spSpace);
    }

    @JsonIgnore
    public Label getLblShinsain() {
        return this.getGogitaiShosai().getLblShinsain();
    }

    @JsonIgnore
    public void  setLblShinsain(Label lblShinsain) {
        this.getGogitaiShosai().setLblShinsain(lblShinsain);
    }

    @JsonIgnore
    public DataGrid<dgShinsainList_Row> getDgShinsainList() {
        return this.getGogitaiShosai().getDgShinsainList();
    }

    @JsonIgnore
    public void  setDgShinsainList(DataGrid<dgShinsainList_Row> dgShinsainList) {
        this.getGogitaiShosai().setDgShinsainList(dgShinsainList);
    }

    @JsonIgnore
    public Button getBtnShinsainSelect() {
        return this.getGogitaiShosai().getBtnShinsainSelect();
    }

    @JsonIgnore
    public void  setBtnShinsainSelect(Button btnShinsainSelect) {
        this.getGogitaiShosai().setBtnShinsainSelect(btnShinsainSelect);
    }

    @JsonIgnore
    public Label getLblHoketsuShinsain() {
        return this.getGogitaiShosai().getLblHoketsuShinsain();
    }

    @JsonIgnore
    public void  setLblHoketsuShinsain(Label lblHoketsuShinsain) {
        this.getGogitaiShosai().setLblHoketsuShinsain(lblHoketsuShinsain);
    }

    @JsonIgnore
    public DataGrid<dgHoketsuShinsainList_Row> getDgHoketsuShinsainList() {
        return this.getGogitaiShosai().getDgHoketsuShinsainList();
    }

    @JsonIgnore
    public void  setDgHoketsuShinsainList(DataGrid<dgHoketsuShinsainList_Row> dgHoketsuShinsainList) {
        this.getGogitaiShosai().setDgHoketsuShinsainList(dgHoketsuShinsainList);
    }

    @JsonIgnore
    public Button getBtnSubShinsainSelect() {
        return this.getGogitaiShosai().getBtnSubShinsainSelect();
    }

    @JsonIgnore
    public void  setBtnSubShinsainSelect(Button btnSubShinsainSelect) {
        this.getGogitaiShosai().setBtnSubShinsainSelect(btnSubShinsainSelect);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getGogitaiShosai().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getGogitaiShosai().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public Button getBtnkosin() {
        return this.getGogitaiShosai().getBtnkosin();
    }

    @JsonIgnore
    public void  setBtnkosin(Button btnkosin) {
        this.getGogitaiShosai().setBtnkosin(btnkosin);
    }

    @JsonIgnore
    public Button getBtnback() {
        return this.getGogitaiShosai().getBtnback();
    }

    @JsonIgnore
    public void  setBtnback(Button btnback) {
        this.getGogitaiShosai().setBtnback(btnback);
    }

    @JsonIgnore
    public Label getLblUploadFile() {
        return this.getUploadFileToroku().getLblUploadFile();
    }

    @JsonIgnore
    public void  setLblUploadFile(Label lblUploadFile) {
        this.getUploadFileToroku().setLblUploadFile(lblUploadFile);
    }

    @JsonIgnore
    public UploadPanel getUplUploadPanel() {
        return this.getUploadFileToroku().getUplUploadPanel();
    }

    @JsonIgnore
    public void  setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.getUploadFileToroku().setUplUploadPanel(uplUploadPanel);
    }

    @JsonIgnore
    public Button getBtnIkkatsuToroku() {
        return this.getUploadFileToroku().getBtnIkkatsuToroku();
    }

    @JsonIgnore
    public void  setBtnIkkatsuToroku(Button btnIkkatsuToroku) {
        this.getUploadFileToroku().setBtnIkkatsuToroku(btnIkkatsuToroku);
    }

    // </editor-fold>
}
