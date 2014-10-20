package jp.co.ndensan.reams.db.dbz.divcontroller.entity.reportview;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.reportview.dgReportView_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ReportView のクラスファイル 
 * 
 * @author 自動生成
 */
public class ReportViewDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtListName")
    private TextBox txtListName;
    @JsonProperty("txtBatchName")
    private TextBox txtBatchName;
    @JsonProperty("txtBatchStartingDate")
    private TextBoxDate txtBatchStartingDate;
    @JsonProperty("txtBatchStartingTime")
    private TextBoxTime txtBatchStartingTime;
    @JsonProperty("lblSubGyomuCode")
    private Label lblSubGyomuCode;
    @JsonProperty("lblChohyoCode")
    private Label lblChohyoCode;
    @JsonProperty("dgReportView")
    private DataGrid<dgReportView_Row> dgReportView;
    @JsonProperty("btnExcelOutput")
    private Button btnExcelOutput;
    @JsonProperty("btnPdfOutput")
    private Button btnPdfOutput;
    @JsonProperty("btnCsvOutput")
    private Button btnCsvOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtListName")
    public TextBox getTxtListName() {
        return txtListName;
    }

    @JsonProperty("txtListName")
    public void setTxtListName(TextBox txtListName) {
        this.txtListName=txtListName;
    }

    @JsonProperty("txtBatchName")
    public TextBox getTxtBatchName() {
        return txtBatchName;
    }

    @JsonProperty("txtBatchName")
    public void setTxtBatchName(TextBox txtBatchName) {
        this.txtBatchName=txtBatchName;
    }

    @JsonProperty("txtBatchStartingDate")
    public TextBoxDate getTxtBatchStartingDate() {
        return txtBatchStartingDate;
    }

    @JsonProperty("txtBatchStartingDate")
    public void setTxtBatchStartingDate(TextBoxDate txtBatchStartingDate) {
        this.txtBatchStartingDate=txtBatchStartingDate;
    }

    @JsonProperty("txtBatchStartingTime")
    public TextBoxTime getTxtBatchStartingTime() {
        return txtBatchStartingTime;
    }

    @JsonProperty("txtBatchStartingTime")
    public void setTxtBatchStartingTime(TextBoxTime txtBatchStartingTime) {
        this.txtBatchStartingTime=txtBatchStartingTime;
    }

    @JsonProperty("lblSubGyomuCode")
    public Label getLblSubGyomuCode() {
        return lblSubGyomuCode;
    }

    @JsonProperty("lblSubGyomuCode")
    public void setLblSubGyomuCode(Label lblSubGyomuCode) {
        this.lblSubGyomuCode=lblSubGyomuCode;
    }

    @JsonProperty("lblChohyoCode")
    public Label getLblChohyoCode() {
        return lblChohyoCode;
    }

    @JsonProperty("lblChohyoCode")
    public void setLblChohyoCode(Label lblChohyoCode) {
        this.lblChohyoCode=lblChohyoCode;
    }

    @JsonProperty("dgReportView")
    public DataGrid<dgReportView_Row> getDgReportView() {
        return dgReportView;
    }

    @JsonProperty("dgReportView")
    public void setDgReportView(DataGrid<dgReportView_Row> dgReportView) {
        this.dgReportView=dgReportView;
    }

    @JsonProperty("btnExcelOutput")
    public Button getBtnExcelOutput() {
        return btnExcelOutput;
    }

    @JsonProperty("btnExcelOutput")
    public void setBtnExcelOutput(Button btnExcelOutput) {
        this.btnExcelOutput=btnExcelOutput;
    }

    @JsonProperty("btnPdfOutput")
    public Button getBtnPdfOutput() {
        return btnPdfOutput;
    }

    @JsonProperty("btnPdfOutput")
    public void setBtnPdfOutput(Button btnPdfOutput) {
        this.btnPdfOutput=btnPdfOutput;
    }

    @JsonProperty("btnCsvOutput")
    public Button getBtnCsvOutput() {
        return btnCsvOutput;
    }

    @JsonProperty("btnCsvOutput")
    public void setBtnCsvOutput(Button btnCsvOutput) {
        this.btnCsvOutput=btnCsvOutput;
    }

}
