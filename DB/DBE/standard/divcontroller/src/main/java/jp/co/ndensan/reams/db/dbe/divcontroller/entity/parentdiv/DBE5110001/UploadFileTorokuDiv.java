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
 * UploadFileToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class UploadFileTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblUploadFile")
    private Label lblUploadFile;
    @JsonProperty("UploadFileTorokuBatch")
    private UploadFileTorokuBatchDiv UploadFileTorokuBatch;
    @JsonProperty("btnRegistUploadFile")
    private Button btnRegistUploadFile;
    @JsonProperty("btnKakunin")
    private Button btnKakunin;
    @JsonProperty("uploadedFileID")
    private RString uploadedFileID;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblUploadFile
     * @return lblUploadFile
     */
    @JsonProperty("lblUploadFile")
    public Label getLblUploadFile() {
        return lblUploadFile;
    }

    /*
     * setlblUploadFile
     * @param lblUploadFile lblUploadFile
     */
    @JsonProperty("lblUploadFile")
    public void setLblUploadFile(Label lblUploadFile) {
        this.lblUploadFile = lblUploadFile;
    }

    /*
     * getUploadFileTorokuBatch
     * @return UploadFileTorokuBatch
     */
    @JsonProperty("UploadFileTorokuBatch")
    public UploadFileTorokuBatchDiv getUploadFileTorokuBatch() {
        return UploadFileTorokuBatch;
    }

    /*
     * setUploadFileTorokuBatch
     * @param UploadFileTorokuBatch UploadFileTorokuBatch
     */
    @JsonProperty("UploadFileTorokuBatch")
    public void setUploadFileTorokuBatch(UploadFileTorokuBatchDiv UploadFileTorokuBatch) {
        this.UploadFileTorokuBatch = UploadFileTorokuBatch;
    }

    /*
     * getbtnRegistUploadFile
     * @return btnRegistUploadFile
     */
    @JsonProperty("btnRegistUploadFile")
    public Button getBtnRegistUploadFile() {
        return btnRegistUploadFile;
    }

    /*
     * setbtnRegistUploadFile
     * @param btnRegistUploadFile btnRegistUploadFile
     */
    @JsonProperty("btnRegistUploadFile")
    public void setBtnRegistUploadFile(Button btnRegistUploadFile) {
        this.btnRegistUploadFile = btnRegistUploadFile;
    }

    /*
     * getbtnKakunin
     * @return btnKakunin
     */
    @JsonProperty("btnKakunin")
    public Button getBtnKakunin() {
        return btnKakunin;
    }

    /*
     * setbtnKakunin
     * @param btnKakunin btnKakunin
     */
    @JsonProperty("btnKakunin")
    public void setBtnKakunin(Button btnKakunin) {
        this.btnKakunin = btnKakunin;
    }

    /*
     * getuploadedFileID
     * @return uploadedFileID
     */
    @JsonProperty("uploadedFileID")
    public RString getUploadedFileID() {
        return uploadedFileID;
    }

    /*
     * setuploadedFileID
     * @param uploadedFileID uploadedFileID
     */
    @JsonProperty("uploadedFileID")
    public void setUploadedFileID(RString uploadedFileID) {
        this.uploadedFileID = uploadedFileID;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplUploadPanel() {
        return this.getUploadFileTorokuBatch().getUplUploadPanel();
    }

    @JsonIgnore
    public void  setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.getUploadFileTorokuBatch().setUplUploadPanel(uplUploadPanel);
    }

    // </editor-fold>
}
