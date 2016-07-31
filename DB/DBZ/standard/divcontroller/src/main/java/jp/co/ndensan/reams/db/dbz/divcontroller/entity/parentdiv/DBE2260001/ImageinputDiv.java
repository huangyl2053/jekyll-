package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBE2260001;
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
 * Imageinput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageinputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIkenshuOCRTorikomi")
    private Button btnIkenshuOCRTorikomi;
    @JsonProperty("dgshinseishaichiran")
    private DataGrid<dgshinseishaichiran_Row> dgshinseishaichiran;
    @JsonProperty("imeUploadPanel")
    private imeUploadPanelDiv imeUploadPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIkenshuOCRTorikomi
     * @return btnIkenshuOCRTorikomi
     */
    @JsonProperty("btnIkenshuOCRTorikomi")
    public Button getBtnIkenshuOCRTorikomi() {
        return btnIkenshuOCRTorikomi;
    }

    /*
     * setbtnIkenshuOCRTorikomi
     * @param btnIkenshuOCRTorikomi btnIkenshuOCRTorikomi
     */
    @JsonProperty("btnIkenshuOCRTorikomi")
    public void setBtnIkenshuOCRTorikomi(Button btnIkenshuOCRTorikomi) {
        this.btnIkenshuOCRTorikomi = btnIkenshuOCRTorikomi;
    }

    /*
     * getdgshinseishaichiran
     * @return dgshinseishaichiran
     */
    @JsonProperty("dgshinseishaichiran")
    public DataGrid<dgshinseishaichiran_Row> getDgshinseishaichiran() {
        return dgshinseishaichiran;
    }

    /*
     * setdgshinseishaichiran
     * @param dgshinseishaichiran dgshinseishaichiran
     */
    @JsonProperty("dgshinseishaichiran")
    public void setDgshinseishaichiran(DataGrid<dgshinseishaichiran_Row> dgshinseishaichiran) {
        this.dgshinseishaichiran = dgshinseishaichiran;
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
