package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001;
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
 * IraiJohoDataTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class IraiJohoDataTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uploadArea")
    private uploadAreaDiv uploadArea;
    @JsonProperty("panelIchiran")
    private panelIchiranDiv panelIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuploadArea
     * @return uploadArea
     */
    @JsonProperty("uploadArea")
    public uploadAreaDiv getUploadArea() {
        return uploadArea;
    }

    /*
     * setuploadArea
     * @param uploadArea uploadArea
     */
    @JsonProperty("uploadArea")
    public void setUploadArea(uploadAreaDiv uploadArea) {
        this.uploadArea = uploadArea;
    }

    /*
     * getpanelIchiran
     * @return panelIchiran
     */
    @JsonProperty("panelIchiran")
    public panelIchiranDiv getPanelIchiran() {
        return panelIchiran;
    }

    /*
     * setpanelIchiran
     * @param panelIchiran panelIchiran
     */
    @JsonProperty("panelIchiran")
    public void setPanelIchiran(panelIchiranDiv panelIchiran) {
        this.panelIchiran = panelIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUploadTool() {
        return this.getUploadArea().getUploadTool();
    }

    @JsonIgnore
    public void  setUploadTool(UploadPanel uploadTool) {
        this.getUploadArea().setUploadTool(uploadTool);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getUploadArea().getBtnUpload();
    }

    @JsonIgnore
    public void  setBtnUpload(Button btnUpload) {
        this.getUploadArea().setBtnUpload(btnUpload);
    }

    @JsonIgnore
    public DataGrid<dgTorikomiFileIchiran_Row> getDgTorikomiFileIchiran() {
        return this.getPanelIchiran().getDgTorikomiFileIchiran();
    }

    @JsonIgnore
    public void  setDgTorikomiFileIchiran(DataGrid<dgTorikomiFileIchiran_Row> dgTorikomiFileIchiran) {
        this.getPanelIchiran().setDgTorikomiFileIchiran(dgTorikomiFileIchiran);
    }

    // </editor-fold>
}
