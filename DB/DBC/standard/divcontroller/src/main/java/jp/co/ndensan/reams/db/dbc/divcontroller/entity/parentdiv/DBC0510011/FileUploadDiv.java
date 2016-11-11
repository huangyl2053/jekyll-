package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * FileUpload のクラスファイル
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class FileUploadDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
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
