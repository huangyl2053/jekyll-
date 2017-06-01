package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FileUpload のクラスファイル 
 * 
 * @author 自動生成
 */
public class FileUploadDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplIdoJohoFile")
    private UploadPanel uplIdoJohoFile;
    @JsonProperty("btnUpload")
    private Button btnUpload;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplIdoJohoFile
     * @return uplIdoJohoFile
     */
    @JsonProperty("uplIdoJohoFile")
    public UploadPanel getUplIdoJohoFile() {
        return uplIdoJohoFile;
    }

    /*
     * setuplIdoJohoFile
     * @param uplIdoJohoFile uplIdoJohoFile
     */
    @JsonProperty("uplIdoJohoFile")
    public void setUplIdoJohoFile(UploadPanel uplIdoJohoFile) {
        this.uplIdoJohoFile = uplIdoJohoFile;
    }

    /*
     * getbtnUpload
     * @return btnUpload
     */
    @JsonProperty("btnUpload")
    public Button getBtnUpload() {
        return btnUpload;
    }

    /*
     * setbtnUpload
     * @param btnUpload btnUpload
     */
    @JsonProperty("btnUpload")
    public void setBtnUpload(Button btnUpload) {
        this.btnUpload = btnUpload;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    // </editor-fold>
}
