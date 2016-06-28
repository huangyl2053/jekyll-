package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class ShotokuJohoChushutsuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuJohoChushutsuBatchParameter")
    private ShotokuJohoChushutsuBatchParameterDiv ShotokuJohoChushutsuBatchParameter;
    @JsonProperty("UploadPanel")
    private UploadPanelDiv UploadPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuJohoChushutsuBatchParameter
     * @return ShotokuJohoChushutsuBatchParameter
     */
    @JsonProperty("ShotokuJohoChushutsuBatchParameter")
    public ShotokuJohoChushutsuBatchParameterDiv getShotokuJohoChushutsuBatchParameter() {
        return ShotokuJohoChushutsuBatchParameter;
    }

    /*
     * setShotokuJohoChushutsuBatchParameter
     * @param ShotokuJohoChushutsuBatchParameter ShotokuJohoChushutsuBatchParameter
     */
    @JsonProperty("ShotokuJohoChushutsuBatchParameter")
    public void setShotokuJohoChushutsuBatchParameter(ShotokuJohoChushutsuBatchParameterDiv ShotokuJohoChushutsuBatchParameter) {
        this.ShotokuJohoChushutsuBatchParameter = ShotokuJohoChushutsuBatchParameter;
    }

    /*
     * getUploadPanel
     * @return UploadPanel
     */
    @JsonProperty("UploadPanel")
    public UploadPanelDiv getUploadPanel() {
        return UploadPanel;
    }

    /*
     * setUploadPanel
     * @param UploadPanel UploadPanel
     */
    @JsonProperty("UploadPanel")
    public void setUploadPanel(UploadPanelDiv UploadPanel) {
        this.UploadPanel = UploadPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShoriNendo() {
        return this.getShotokuJohoChushutsuBatchParameter().getTxtShoriNendo();
    }

    @JsonIgnore
    public void setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.getShotokuJohoChushutsuBatchParameter().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShotokuJohoChushutsuBatchParameter().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getShotokuJohoChushutsuBatchParameter().setLin1(lin1);
    }

    @JsonIgnore
    public ShichosonIchiranDiv getShichosonIchiran() {
        return this.getShotokuJohoChushutsuBatchParameter().getShichosonIchiran();
    }

    @JsonIgnore
    public void setShichosonIchiran(ShichosonIchiranDiv ShichosonIchiran) {
        this.getShotokuJohoChushutsuBatchParameter().setShichosonIchiran(ShichosonIchiran);
    }

    @JsonIgnore
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return this.getShotokuJohoChushutsuBatchParameter().getShichosonIchiran().getDataGrid1();
    }

    @JsonIgnore
    public void setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.getShotokuJohoChushutsuBatchParameter().getShichosonIchiran().setDataGrid1(DataGrid1);
    }

    @JsonIgnore
    public UploadPanel getCcdUpload() {
        return this.getUploadPanel().getCcdUpload();
    }

    @JsonIgnore
    public void setCcdUpload(UploadPanel ccdUpload) {
        this.getUploadPanel().setCcdUpload(ccdUpload);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getUploadPanel().getBtnUpload();
    }

    @JsonIgnore
    public void setBtnUpload(Button btnUpload) {
        this.getUploadPanel().setBtnUpload(btnUpload);
    }

    // </editor-fold>
}
