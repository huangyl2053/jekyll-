package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * UploadFileToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class UploadFileTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblUploadFile")
    private Label lblUploadFile;
    @JsonProperty("uplUploadPanel")
    private UploadPanel uplUploadPanel;
    @JsonProperty("btnIkkatsuToroku")
    private Button btnIkkatsuToroku;

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
     * getbtnIkkatsuToroku
     * @return btnIkkatsuToroku
     */
    @JsonProperty("btnIkkatsuToroku")
    public Button getBtnIkkatsuToroku() {
        return btnIkkatsuToroku;
    }

    /*
     * setbtnIkkatsuToroku
     * @param btnIkkatsuToroku btnIkkatsuToroku
     */
    @JsonProperty("btnIkkatsuToroku")
    public void setBtnIkkatsuToroku(Button btnIkkatsuToroku) {
        this.btnIkkatsuToroku = btnIkkatsuToroku;
    }

    // </editor-fold>
}
