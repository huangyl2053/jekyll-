package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
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
 * chosairaitaishoshaichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class chosairaitaishoshaichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShoriJyotai")
    private RadioButton radShoriJyotai;
    @JsonProperty("txtTotalCount")
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBoxNum txtCompleteCount;
    @JsonProperty("txtNoUpdate")
    private TextBoxNum txtNoUpdate;
    @JsonProperty("BatchParamPanel")
    private BatchParamPanelDiv BatchParamPanel;
    @JsonProperty("txtMaxCount")
    private TextBoxNum txtMaxCount;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShoriJyotai
     * @return radShoriJyotai
     */
    @JsonProperty("radShoriJyotai")
    public RadioButton getRadShoriJyotai() {
        return radShoriJyotai;
    }

    /*
     * setradShoriJyotai
     * @param radShoriJyotai radShoriJyotai
     */
    @JsonProperty("radShoriJyotai")
    public void setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.radShoriJyotai = radShoriJyotai;
    }

    /*
     * gettxtTotalCount
     * @return txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public TextBoxNum getTxtTotalCount() {
        return txtTotalCount;
    }

    /*
     * settxtTotalCount
     * @param txtTotalCount txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public void setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.txtTotalCount = txtTotalCount;
    }

    /*
     * gettxtCompleteCount
     * @return txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public TextBoxNum getTxtCompleteCount() {
        return txtCompleteCount;
    }

    /*
     * settxtCompleteCount
     * @param txtCompleteCount txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public void setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.txtCompleteCount = txtCompleteCount;
    }

    /*
     * gettxtNoUpdate
     * @return txtNoUpdate
     */
    @JsonProperty("txtNoUpdate")
    public TextBoxNum getTxtNoUpdate() {
        return txtNoUpdate;
    }

    /*
     * settxtNoUpdate
     * @param txtNoUpdate txtNoUpdate
     */
    @JsonProperty("txtNoUpdate")
    public void setTxtNoUpdate(TextBoxNum txtNoUpdate) {
        this.txtNoUpdate = txtNoUpdate;
    }

    /*
     * getBatchParamPanel
     * @return BatchParamPanel
     */
    @JsonProperty("BatchParamPanel")
    public BatchParamPanelDiv getBatchParamPanel() {
        return BatchParamPanel;
    }

    /*
     * setBatchParamPanel
     * @param BatchParamPanel BatchParamPanel
     */
    @JsonProperty("BatchParamPanel")
    public void setBatchParamPanel(BatchParamPanelDiv BatchParamPanel) {
        this.BatchParamPanel = BatchParamPanel;
    }

    /*
     * gettxtMaxCount
     * @return txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public TextBoxNum getTxtMaxCount() {
        return txtMaxCount;
    }

    /*
     * settxtMaxCount
     * @param txtMaxCount txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.txtMaxCount = txtMaxCount;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getBatchParamPanel().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getBatchParamPanel().setDgNinteiTaskList(dgNinteiTaskList);
    }

    // </editor-fold>
}
