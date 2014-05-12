package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KariPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KogakuKaigoKyufuhiTaishoshaTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblExtractionCondition")
    private Label lblExtractionCondition;
    @JsonProperty("txtShinsaYM")
    private TextBoxDateRange txtShinsaYM;
    @JsonProperty("lblReportOutput")
    private Label lblReportOutput;
    @JsonProperty("radIsCreateIchiranhyo")
    private RadioButton radIsCreateIchiranhyo;
    @JsonProperty("KariPanel")
    private KariPanelDiv KariPanel;
    @JsonProperty("btnRegistry")
    private Button btnRegistry;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblExtractionCondition")
    public Label getLblExtractionCondition() {
        return lblExtractionCondition;
    }

    @JsonProperty("lblExtractionCondition")
    public void setLblExtractionCondition(Label lblExtractionCondition) {
        this.lblExtractionCondition=lblExtractionCondition;
    }

    @JsonProperty("txtShinsaYM")
    public TextBoxDateRange getTxtShinsaYM() {
        return txtShinsaYM;
    }

    @JsonProperty("txtShinsaYM")
    public void setTxtShinsaYM(TextBoxDateRange txtShinsaYM) {
        this.txtShinsaYM=txtShinsaYM;
    }

    @JsonProperty("lblReportOutput")
    public Label getLblReportOutput() {
        return lblReportOutput;
    }

    @JsonProperty("lblReportOutput")
    public void setLblReportOutput(Label lblReportOutput) {
        this.lblReportOutput=lblReportOutput;
    }

    @JsonProperty("radIsCreateIchiranhyo")
    public RadioButton getRadIsCreateIchiranhyo() {
        return radIsCreateIchiranhyo;
    }

    @JsonProperty("radIsCreateIchiranhyo")
    public void setRadIsCreateIchiranhyo(RadioButton radIsCreateIchiranhyo) {
        this.radIsCreateIchiranhyo=radIsCreateIchiranhyo;
    }

    @JsonProperty("KariPanel")
    public KariPanelDiv getKariPanel() {
        return KariPanel;
    }

    @JsonProperty("KariPanel")
    public void setKariPanel(KariPanelDiv KariPanel) {
        this.KariPanel=KariPanel;
    }

    @JsonProperty("btnRegistry")
    public Button getBtnRegistry() {
        return btnRegistry;
    }

    @JsonProperty("btnRegistry")
    public void setBtnRegistry(Button btnRegistry) {
        this.btnRegistry=btnRegistry;
    }

}
