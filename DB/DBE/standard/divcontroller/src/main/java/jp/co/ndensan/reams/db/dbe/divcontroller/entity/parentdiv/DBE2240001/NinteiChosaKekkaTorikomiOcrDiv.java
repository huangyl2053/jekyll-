package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001;
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
 * NinteiChosaKekkaTorikomiOcr のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaKekkaTorikomiOcrDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnChosahyoTorikomi")
    private Button btnChosahyoTorikomi;
    @JsonProperty("lblTorikomiKekka")
    private Label lblTorikomiKekka;
    @JsonProperty("txtError")
    private TextBoxNum txtError;
    @JsonProperty("dgTorikomiKekka")
    private DataGrid<dgTorikomiKekka_Row> dgTorikomiKekka;
    @JsonProperty("imeUploadPanel")
    private imeUploadPanelDiv imeUploadPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnChosahyoTorikomi
     * @return btnChosahyoTorikomi
     */
    @JsonProperty("btnChosahyoTorikomi")
    public Button getBtnChosahyoTorikomi() {
        return btnChosahyoTorikomi;
    }

    /*
     * setbtnChosahyoTorikomi
     * @param btnChosahyoTorikomi btnChosahyoTorikomi
     */
    @JsonProperty("btnChosahyoTorikomi")
    public void setBtnChosahyoTorikomi(Button btnChosahyoTorikomi) {
        this.btnChosahyoTorikomi = btnChosahyoTorikomi;
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
     * gettxtError
     * @return txtError
     */
    @JsonProperty("txtError")
    public TextBoxNum getTxtError() {
        return txtError;
    }

    /*
     * settxtError
     * @param txtError txtError
     */
    @JsonProperty("txtError")
    public void setTxtError(TextBoxNum txtError) {
        this.txtError = txtError;
    }

    /*
     * getdgTorikomiKekka
     * @return dgTorikomiKekka
     */
    @JsonProperty("dgTorikomiKekka")
    public DataGrid<dgTorikomiKekka_Row> getDgTorikomiKekka() {
        return dgTorikomiKekka;
    }

    /*
     * setdgTorikomiKekka
     * @param dgTorikomiKekka dgTorikomiKekka
     */
    @JsonProperty("dgTorikomiKekka")
    public void setDgTorikomiKekka(DataGrid<dgTorikomiKekka_Row> dgTorikomiKekka) {
        this.dgTorikomiKekka = dgTorikomiKekka;
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
