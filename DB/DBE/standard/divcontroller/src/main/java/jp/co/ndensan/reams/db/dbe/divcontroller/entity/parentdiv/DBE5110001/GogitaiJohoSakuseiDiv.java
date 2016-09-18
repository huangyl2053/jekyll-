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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kensakujyoken")
    private KensakujyokenDiv Kensakujyoken;
    @JsonProperty("GogitaiIchiran")
    private GogitaiIchiranDiv GogitaiIchiran;
    @JsonProperty("GogitaiShosai")
    private GogitaiShosaiDiv GogitaiShosai;
    @JsonProperty("UploadFileToroku")
    private UploadFileTorokuDiv UploadFileToroku;
    @JsonProperty("hiddenFileId")
    private RString hiddenFileId;
    @JsonProperty("hiddenFileName")
    private RString hiddenFileName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakujyoken
     * @return Kensakujyoken
     */
    @JsonProperty("Kensakujyoken")
    public KensakujyokenDiv getKensakujyoken() {
        return Kensakujyoken;
    }

    /*
     * setKensakujyoken
     * @param Kensakujyoken Kensakujyoken
     */
    @JsonProperty("Kensakujyoken")
    public void setKensakujyoken(KensakujyokenDiv Kensakujyoken) {
        this.Kensakujyoken = Kensakujyoken;
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
    public TextBoxNum getTxtDispMax() {
        return this.getKensakujyoken().getTxtDispMax();
    }

    @JsonIgnore
    public void  setTxtDispMax(TextBoxNum txtDispMax) {
        this.getKensakujyoken().setTxtDispMax(txtDispMax);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakujyoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakujyoken().setBtnClear(btnClear);
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
    public Button getBtnCSVShutsuryoku() {
        return this.getGogitaiIchiran().getBtnCSVShutsuryoku();
    }

    @JsonIgnore
    public void  setBtnCSVShutsuryoku(Button btnCSVShutsuryoku) {
        this.getGogitaiIchiran().setBtnCSVShutsuryoku(btnCSVShutsuryoku);
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
    public DropDownList getDdlkaisaibasho() {
        return this.getGogitaiShosai().getDdlkaisaibasho();
    }

    @JsonIgnore
    public void  setDdlkaisaibasho(DropDownList ddlkaisaibasho) {
        this.getGogitaiShosai().setDdlkaisaibasho(ddlkaisaibasho);
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
    public HorizontalLine getLin1() {
        return this.getGogitaiShosai().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getGogitaiShosai().setLin1(lin1);
    }

    @JsonIgnore
    public GogitaiShinsakaiIinSentakuDiv getGogitaiShinsakaiIinSentaku() {
        return this.getGogitaiShosai().getGogitaiShinsakaiIinSentaku();
    }

    @JsonIgnore
    public void  setGogitaiShinsakaiIinSentaku(GogitaiShinsakaiIinSentakuDiv GogitaiShinsakaiIinSentaku) {
        this.getGogitaiShosai().setGogitaiShinsakaiIinSentaku(GogitaiShinsakaiIinSentaku);
    }

    @JsonIgnore
    public Label getLblShinsain() {
        return this.getGogitaiShosai().getGogitaiShinsakaiIinSentaku().getLblShinsain();
    }

    @JsonIgnore
    public void  setLblShinsain(Label lblShinsain) {
        this.getGogitaiShosai().getGogitaiShinsakaiIinSentaku().setLblShinsain(lblShinsain);
    }

    @JsonIgnore
    public ButtonDialog getBtnShinsainSelect() {
        return this.getGogitaiShosai().getGogitaiShinsakaiIinSentaku().getBtnShinsainSelect();
    }

    @JsonIgnore
    public void  setBtnShinsainSelect(ButtonDialog btnShinsainSelect) {
        this.getGogitaiShosai().getGogitaiShinsakaiIinSentaku().setBtnShinsainSelect(btnShinsainSelect);
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
    public GogitaiVerticalLine1Div getGogitaiVerticalLine1() {
        return this.getGogitaiShosai().getGogitaiVerticalLine1();
    }

    @JsonIgnore
    public void  setGogitaiVerticalLine1(GogitaiVerticalLine1Div GogitaiVerticalLine1) {
        this.getGogitaiShosai().setGogitaiVerticalLine1(GogitaiVerticalLine1);
    }

    @JsonIgnore
    public VerticalLine getLin2() {
        return this.getGogitaiShosai().getGogitaiVerticalLine1().getLin2();
    }

    @JsonIgnore
    public void  setLin2(VerticalLine lin2) {
        this.getGogitaiShosai().getGogitaiVerticalLine1().setLin2(lin2);
    }

    @JsonIgnore
    public GogitaiHoketsuIinSentakuDiv getGogitaiHoketsuIinSentaku() {
        return this.getGogitaiShosai().getGogitaiHoketsuIinSentaku();
    }

    @JsonIgnore
    public void  setGogitaiHoketsuIinSentaku(GogitaiHoketsuIinSentakuDiv GogitaiHoketsuIinSentaku) {
        this.getGogitaiShosai().setGogitaiHoketsuIinSentaku(GogitaiHoketsuIinSentaku);
    }

    @JsonIgnore
    public Label getLblHoketsuShinsain() {
        return this.getGogitaiShosai().getGogitaiHoketsuIinSentaku().getLblHoketsuShinsain();
    }

    @JsonIgnore
    public void  setLblHoketsuShinsain(Label lblHoketsuShinsain) {
        this.getGogitaiShosai().getGogitaiHoketsuIinSentaku().setLblHoketsuShinsain(lblHoketsuShinsain);
    }

    @JsonIgnore
    public ButtonDialog getBtnSubShinsainSelect() {
        return this.getGogitaiShosai().getGogitaiHoketsuIinSentaku().getBtnSubShinsainSelect();
    }

    @JsonIgnore
    public void  setBtnSubShinsainSelect(ButtonDialog btnSubShinsainSelect) {
        this.getGogitaiShosai().getGogitaiHoketsuIinSentaku().setBtnSubShinsainSelect(btnSubShinsainSelect);
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
    public HorizontalLine getLin3() {
        return this.getGogitaiShosai().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getGogitaiShosai().setLin3(lin3);
    }

    @JsonIgnore
    public Button getBtnKosin() {
        return this.getGogitaiShosai().getBtnKosin();
    }

    @JsonIgnore
    public void  setBtnKosin(Button btnKosin) {
        this.getGogitaiShosai().setBtnKosin(btnKosin);
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
    public UploadFileTorokuBatchDiv getUploadFileTorokuBatch() {
        return this.getUploadFileToroku().getUploadFileTorokuBatch();
    }

    @JsonIgnore
    public void  setUploadFileTorokuBatch(UploadFileTorokuBatchDiv UploadFileTorokuBatch) {
        this.getUploadFileToroku().setUploadFileTorokuBatch(UploadFileTorokuBatch);
    }

    @JsonIgnore
    public UploadPanel getUplUploadPanel() {
        return this.getUploadFileToroku().getUploadFileTorokuBatch().getUplUploadPanel();
    }

    @JsonIgnore
    public void  setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.getUploadFileToroku().getUploadFileTorokuBatch().setUplUploadPanel(uplUploadPanel);
    }

    @JsonIgnore
    public Button getBtnRegistUploadFile() {
        return this.getUploadFileToroku().getBtnRegistUploadFile();
    }

    @JsonIgnore
    public void  setBtnRegistUploadFile(Button btnRegistUploadFile) {
        this.getUploadFileToroku().setBtnRegistUploadFile(btnRegistUploadFile);
    }

    @JsonIgnore
    public Button getBtnKakunin() {
        return this.getUploadFileToroku().getBtnKakunin();
    }

    @JsonIgnore
    public void  setBtnKakunin(Button btnKakunin) {
        this.getUploadFileToroku().setBtnKakunin(btnKakunin);
    }

    // </editor-fold>
}
