package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * OnseiEditor のクラスファイル 
 * 
 * @author 自動生成
 */
public class OnseiEditorDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtOnseiNo")
    private TextBoxNum txtOnseiNo;
    @JsonProperty("txtOnseiFileTimestamp")
    private TextBox txtOnseiFileTimestamp;
    @JsonProperty("btnDownloadOnseiFile")
    private ButtonDownLoad btnDownloadOnseiFile;
    @JsonProperty("btnDeleteOnseiFile")
    private Button btnDeleteOnseiFile;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtOnseiNo
     * @return txtOnseiNo
     */
    @JsonProperty("txtOnseiNo")
    public TextBoxNum getTxtOnseiNo() {
        return txtOnseiNo;
    }

    /*
     * settxtOnseiNo
     * @param txtOnseiNo txtOnseiNo
     */
    @JsonProperty("txtOnseiNo")
    public void setTxtOnseiNo(TextBoxNum txtOnseiNo) {
        this.txtOnseiNo = txtOnseiNo;
    }

    /*
     * gettxtOnseiFileTimestamp
     * @return txtOnseiFileTimestamp
     */
    @JsonProperty("txtOnseiFileTimestamp")
    public TextBox getTxtOnseiFileTimestamp() {
        return txtOnseiFileTimestamp;
    }

    /*
     * settxtOnseiFileTimestamp
     * @param txtOnseiFileTimestamp txtOnseiFileTimestamp
     */
    @JsonProperty("txtOnseiFileTimestamp")
    public void setTxtOnseiFileTimestamp(TextBox txtOnseiFileTimestamp) {
        this.txtOnseiFileTimestamp = txtOnseiFileTimestamp;
    }

    /*
     * getbtnDownloadOnseiFile
     * @return btnDownloadOnseiFile
     */
    @JsonProperty("btnDownloadOnseiFile")
    public ButtonDownLoad getBtnDownloadOnseiFile() {
        return btnDownloadOnseiFile;
    }

    /*
     * setbtnDownloadOnseiFile
     * @param btnDownloadOnseiFile btnDownloadOnseiFile
     */
    @JsonProperty("btnDownloadOnseiFile")
    public void setBtnDownloadOnseiFile(ButtonDownLoad btnDownloadOnseiFile) {
        this.btnDownloadOnseiFile = btnDownloadOnseiFile;
    }

    /*
     * getbtnDeleteOnseiFile
     * @return btnDeleteOnseiFile
     */
    @JsonProperty("btnDeleteOnseiFile")
    public Button getBtnDeleteOnseiFile() {
        return btnDeleteOnseiFile;
    }

    /*
     * setbtnDeleteOnseiFile
     * @param btnDeleteOnseiFile btnDeleteOnseiFile
     */
    @JsonProperty("btnDeleteOnseiFile")
    public void setBtnDeleteOnseiFile(Button btnDeleteOnseiFile) {
        this.btnDeleteOnseiFile = btnDeleteOnseiFile;
    }

    // </editor-fold>
}
