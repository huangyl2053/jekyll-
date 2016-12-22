package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * UploadFileTorokuBatch のクラスファイル 
 * 
 * @author 自動生成
 */
public class UploadFileTorokuBatchDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplUploadPanel")
    private UploadPanel uplUploadPanel;
    @JsonProperty("uploadFileID")
    private RString uploadFileID;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplUploadPanel
     * @return uplUploadPanel
     */
    @JsonProperty("uplUploadPanel")
    public UploadPanel getUplUploadPanel() {
        return uplUploadPanel;
    }

    /*
     * setuplUploadPanel
     * @param uplUploadPanel uplUploadPanel
     */
    @JsonProperty("uplUploadPanel")
    public void setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.uplUploadPanel = uplUploadPanel;
    }

    /*
     * getuploadFileID
     * @return uploadFileID
     */
    @JsonProperty("uploadFileID")
    public RString getUploadFileID() {
        return uploadFileID;
    }

    /*
     * setuploadFileID
     * @param uploadFileID uploadFileID
     */
    @JsonProperty("uploadFileID")
    public void setUploadFileID(RString uploadFileID) {
        this.uploadFileID = uploadFileID;
    }

    // </editor-fold>
}
