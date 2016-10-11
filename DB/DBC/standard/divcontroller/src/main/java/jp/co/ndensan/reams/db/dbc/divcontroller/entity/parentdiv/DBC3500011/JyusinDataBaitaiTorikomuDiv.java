package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011;
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
 * JyusinDataBaitaiTorikomu のクラスファイル 
 * 
 * @author 自動生成
 */
public class JyusinDataBaitaiTorikomuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JyusinDataTorikomuButton")
    private Button JyusinDataTorikomuButton;
    @JsonProperty("JyusinDataList")
    private DataGrid<JyusinDataList_Row> JyusinDataList;
    @JsonProperty("PanelUpload")
    private PanelUploadDiv PanelUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJyusinDataTorikomuButton
     * @return JyusinDataTorikomuButton
     */
    @JsonProperty("JyusinDataTorikomuButton")
    public Button getJyusinDataTorikomuButton() {
        return JyusinDataTorikomuButton;
    }

    /*
     * setJyusinDataTorikomuButton
     * @param JyusinDataTorikomuButton JyusinDataTorikomuButton
     */
    @JsonProperty("JyusinDataTorikomuButton")
    public void setJyusinDataTorikomuButton(Button JyusinDataTorikomuButton) {
        this.JyusinDataTorikomuButton = JyusinDataTorikomuButton;
    }

    /*
     * getJyusinDataList
     * @return JyusinDataList
     */
    @JsonProperty("JyusinDataList")
    public DataGrid<JyusinDataList_Row> getJyusinDataList() {
        return JyusinDataList;
    }

    /*
     * setJyusinDataList
     * @param JyusinDataList JyusinDataList
     */
    @JsonProperty("JyusinDataList")
    public void setJyusinDataList(DataGrid<JyusinDataList_Row> JyusinDataList) {
        this.JyusinDataList = JyusinDataList;
    }

    /*
     * getPanelUpload
     * @return PanelUpload
     */
    @JsonProperty("PanelUpload")
    public PanelUploadDiv getPanelUpload() {
        return PanelUpload;
    }

    /*
     * setPanelUpload
     * @param PanelUpload PanelUpload
     */
    @JsonProperty("PanelUpload")
    public void setPanelUpload(PanelUploadDiv PanelUpload) {
        this.PanelUpload = PanelUpload;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUpload() {
        return this.getPanelUpload().getUpload();
    }

    @JsonIgnore
    public void  setUpload(UploadPanel Upload) {
        this.getPanelUpload().setUpload(Upload);
    }

    @JsonIgnore
    public Button getButtonUpload() {
        return this.getPanelUpload().getButtonUpload();
    }

    @JsonIgnore
    public void  setButtonUpload(Button ButtonUpload) {
        this.getPanelUpload().setButtonUpload(ButtonUpload);
    }

    @JsonIgnore
    public Button getButtonClose() {
        return this.getPanelUpload().getButtonClose();
    }

    @JsonIgnore
    public void  setButtonClose(Button ButtonClose) {
        this.getPanelUpload().setButtonClose(ButtonClose);
    }

    // </editor-fold>
}
