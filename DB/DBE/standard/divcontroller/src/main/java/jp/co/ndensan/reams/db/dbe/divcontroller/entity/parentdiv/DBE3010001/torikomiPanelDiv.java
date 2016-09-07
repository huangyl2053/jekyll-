package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * torikomiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class torikomiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("UploadPanel")
    private UploadPanel UploadPanel;
    @JsonProperty("uploadButton")
    private Button uploadButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getUploadPanel
     * @return UploadPanel
     */
    @JsonProperty("UploadPanel")
    public UploadPanel getUploadPanel() {
        return UploadPanel;
    }

    /*
     * setUploadPanel
     * @param UploadPanel UploadPanel
     */
    @JsonProperty("UploadPanel")
    public void setUploadPanel(UploadPanel UploadPanel) {
        this.UploadPanel = UploadPanel;
    }

    /*
     * getuploadButton
     * @return uploadButton
     */
    @JsonProperty("uploadButton")
    public Button getUploadButton() {
        return uploadButton;
    }

    /*
     * setuploadButton
     * @param uploadButton uploadButton
     */
    @JsonProperty("uploadButton")
    public void setUploadButton(Button uploadButton) {
        this.uploadButton = uploadButton;
    }

    // </editor-fold>
}
