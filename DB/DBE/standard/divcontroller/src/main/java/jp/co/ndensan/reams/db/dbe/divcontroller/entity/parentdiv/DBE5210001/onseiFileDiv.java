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
 * onseiFile のクラスファイル 
 * 
 * @author 自動生成
 */
public class onseiFileDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplUploadPanel")
    private UploadPanel uplUploadPanel;
    @JsonProperty("btnAddOnseiFile")
    private Button btnAddOnseiFile;

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
     * getbtnAddOnseiFile
     * @return btnAddOnseiFile
     */
    @JsonProperty("btnAddOnseiFile")
    public Button getBtnAddOnseiFile() {
        return btnAddOnseiFile;
    }

    /*
     * setbtnAddOnseiFile
     * @param btnAddOnseiFile btnAddOnseiFile
     */
    @JsonProperty("btnAddOnseiFile")
    public void setBtnAddOnseiFile(Button btnAddOnseiFile) {
        this.btnAddOnseiFile = btnAddOnseiFile;
    }

    // </editor-fold>
}
