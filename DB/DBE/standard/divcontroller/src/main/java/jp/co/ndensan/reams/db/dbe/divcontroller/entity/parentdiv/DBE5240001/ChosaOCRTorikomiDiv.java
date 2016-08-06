package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001;
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
 * ChosaOCRTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaOCRTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotsuHyojiArea")
    private KyotsuHyojiAreaDiv KyotsuHyojiArea;
    @JsonProperty("btnOCRTorikomi")
    private Button btnOCRTorikomi;
    @JsonProperty("lblTorikomiKekka")
    private Label lblTorikomiKekka;
    @JsonProperty("txtErrKensu")
    private TextBoxNum txtErrKensu;
    @JsonProperty("dgChosahyoTorikomiKekka")
    private DataGrid<dgChosahyoTorikomiKekka_Row> dgChosahyoTorikomiKekka;
    @JsonProperty("imeUploadPanel")
    private imeUploadPanelDiv imeUploadPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyotsuHyojiArea
     * @return KyotsuHyojiArea
     */
    @JsonProperty("KyotsuHyojiArea")
    public KyotsuHyojiAreaDiv getKyotsuHyojiArea() {
        return KyotsuHyojiArea;
    }

    /*
     * setKyotsuHyojiArea
     * @param KyotsuHyojiArea KyotsuHyojiArea
     */
    @JsonProperty("KyotsuHyojiArea")
    public void setKyotsuHyojiArea(KyotsuHyojiAreaDiv KyotsuHyojiArea) {
        this.KyotsuHyojiArea = KyotsuHyojiArea;
    }

    /*
     * getbtnOCRTorikomi
     * @return btnOCRTorikomi
     */
    @JsonProperty("btnOCRTorikomi")
    public Button getBtnOCRTorikomi() {
        return btnOCRTorikomi;
    }

    /*
     * setbtnOCRTorikomi
     * @param btnOCRTorikomi btnOCRTorikomi
     */
    @JsonProperty("btnOCRTorikomi")
    public void setBtnOCRTorikomi(Button btnOCRTorikomi) {
        this.btnOCRTorikomi = btnOCRTorikomi;
    }

    /*
     * getlblTorikomiKekka
     * @return lblTorikomiKekka
     */
    @JsonProperty("lblTorikomiKekka")
    public Label getLblTorikomiKekka() {
        return lblTorikomiKekka;
    }

    /*
     * setlblTorikomiKekka
     * @param lblTorikomiKekka lblTorikomiKekka
     */
    @JsonProperty("lblTorikomiKekka")
    public void setLblTorikomiKekka(Label lblTorikomiKekka) {
        this.lblTorikomiKekka = lblTorikomiKekka;
    }

    /*
     * gettxtErrKensu
     * @return txtErrKensu
     */
    @JsonProperty("txtErrKensu")
    public TextBoxNum getTxtErrKensu() {
        return txtErrKensu;
    }

    /*
     * settxtErrKensu
     * @param txtErrKensu txtErrKensu
     */
    @JsonProperty("txtErrKensu")
    public void setTxtErrKensu(TextBoxNum txtErrKensu) {
        this.txtErrKensu = txtErrKensu;
    }

    /*
     * getdgChosahyoTorikomiKekka
     * @return dgChosahyoTorikomiKekka
     */
    @JsonProperty("dgChosahyoTorikomiKekka")
    public DataGrid<dgChosahyoTorikomiKekka_Row> getDgChosahyoTorikomiKekka() {
        return dgChosahyoTorikomiKekka;
    }

    /*
     * setdgChosahyoTorikomiKekka
     * @param dgChosahyoTorikomiKekka dgChosahyoTorikomiKekka
     */
    @JsonProperty("dgChosahyoTorikomiKekka")
    public void setDgChosahyoTorikomiKekka(DataGrid<dgChosahyoTorikomiKekka_Row> dgChosahyoTorikomiKekka) {
        this.dgChosahyoTorikomiKekka = dgChosahyoTorikomiKekka;
    }

    /*
     * getimeUploadPanel
     * @return imeUploadPanel
     */
    @JsonProperty("imeUploadPanel")
    public imeUploadPanelDiv getImeUploadPanel() {
        return imeUploadPanel;
    }

    /*
     * setimeUploadPanel
     * @param imeUploadPanel imeUploadPanel
     */
    @JsonProperty("imeUploadPanel")
    public void setImeUploadPanel(imeUploadPanelDiv imeUploadPanel) {
        this.imeUploadPanel = imeUploadPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinsakaiName() {
        return this.getKyotsuHyojiArea().getTxtShinsakaiName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.getKyotsuHyojiArea().setTxtShinsakaiName(txtShinsakaiName);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNo() {
        return this.getKyotsuHyojiArea().getTxtGogitaiNo();
    }

    @JsonIgnore
    public void  setTxtGogitaiNo(TextBox txtGogitaiNo) {
        this.getKyotsuHyojiArea().setTxtGogitaiNo(txtGogitaiNo);
    }

    @JsonIgnore
    public TextBox getTxtShinsaTaishosha() {
        return this.getKyotsuHyojiArea().getTxtShinsaTaishosha();
    }

    @JsonIgnore
    public void  setTxtShinsaTaishosha(TextBox txtShinsaTaishosha) {
        this.getKyotsuHyojiArea().setTxtShinsaTaishosha(txtShinsaTaishosha);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getKyotsuHyojiArea().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getKyotsuHyojiArea().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBoxCode getTxtChiku() {
        return this.getKyotsuHyojiArea().getTxtChiku();
    }

    @JsonIgnore
    public void  setTxtChiku(TextBoxCode txtChiku) {
        this.getKyotsuHyojiArea().setTxtChiku(txtChiku);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaijoJusho() {
        return this.getKyotsuHyojiArea().getTxtShinsakaijoJusho();
    }

    @JsonIgnore
    public void  setTxtShinsakaijoJusho(TextBox txtShinsakaijoJusho) {
        this.getKyotsuHyojiArea().setTxtShinsakaijoJusho(txtShinsakaijoJusho);
    }

    @JsonIgnore
    public TextBox getTxtTaishoNinzu() {
        return this.getKyotsuHyojiArea().getTxtTaishoNinzu();
    }

    @JsonIgnore
    public void  setTxtTaishoNinzu(TextBox txtTaishoNinzu) {
        this.getKyotsuHyojiArea().setTxtTaishoNinzu(txtTaishoNinzu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiNichiji() {
        return this.getKyotsuHyojiArea().getTxtKaisaiNichiji();
    }

    @JsonIgnore
    public void  setTxtKaisaiNichiji(TextBoxFlexibleDate txtKaisaiNichiji) {
        this.getKyotsuHyojiArea().setTxtKaisaiNichiji(txtKaisaiNichiji);
    }

    @JsonIgnore
    public TextBoxTimeRange getTxtKaisaiTimeRange() {
        return this.getKyotsuHyojiArea().getTxtKaisaiTimeRange();
    }

    @JsonIgnore
    public void  setTxtKaisaiTimeRange(TextBoxTimeRange txtKaisaiTimeRange) {
        this.getKyotsuHyojiArea().setTxtKaisaiTimeRange(txtKaisaiTimeRange);
    }

    @JsonIgnore
    public TextBox getTxtStutas() {
        return this.getKyotsuHyojiArea().getTxtStutas();
    }

    @JsonIgnore
    public void  setTxtStutas(TextBox txtStutas) {
        this.getKyotsuHyojiArea().setTxtStutas(txtStutas);
    }

    @JsonIgnore
    public UploadPanel getUplPanel() {
        return this.getImeUploadPanel().getUplPanel();
    }

    @JsonIgnore
    public void  setUplPanel(UploadPanel UplPanel) {
        this.getImeUploadPanel().setUplPanel(UplPanel);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getImeUploadPanel().getBtnUpload();
    }

    @JsonIgnore
    public void  setBtnUpload(Button btnUpload) {
        this.getImeUploadPanel().setBtnUpload(btnUpload);
    }

    // </editor-fold>
}
