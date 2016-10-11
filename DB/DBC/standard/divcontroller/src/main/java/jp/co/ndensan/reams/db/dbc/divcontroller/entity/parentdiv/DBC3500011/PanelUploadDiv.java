package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelUpload のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelUploadDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Upload")
    private UploadPanel Upload;
    @JsonProperty("ButtonUpload")
    private Button ButtonUpload;
    @JsonProperty("ButtonClose")
    private Button ButtonClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getUpload
     * @return Upload
     */
    @JsonProperty("Upload")
    public UploadPanel getUpload() {
        return Upload;
    }

    /*
     * setUpload
     * @param Upload Upload
     */
    @JsonProperty("Upload")
    public void setUpload(UploadPanel Upload) {
        this.Upload = Upload;
    }

    /*
     * getButtonUpload
     * @return ButtonUpload
     */
    @JsonProperty("ButtonUpload")
    public Button getButtonUpload() {
        return ButtonUpload;
    }

    /*
     * setButtonUpload
     * @param ButtonUpload ButtonUpload
     */
    @JsonProperty("ButtonUpload")
    public void setButtonUpload(Button ButtonUpload) {
        this.ButtonUpload = ButtonUpload;
    }

    /*
     * getButtonClose
     * @return ButtonClose
     */
    @JsonProperty("ButtonClose")
    public Button getButtonClose() {
        return ButtonClose;
    }

    /*
     * setButtonClose
     * @param ButtonClose ButtonClose
     */
    @JsonProperty("ButtonClose")
    public void setButtonClose(Button ButtonClose) {
        this.ButtonClose = ButtonClose;
    }

    // </editor-fold>
}
