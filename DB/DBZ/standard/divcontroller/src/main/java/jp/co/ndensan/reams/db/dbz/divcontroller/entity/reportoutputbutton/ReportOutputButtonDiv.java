package jp.co.ndensan.reams.db.dbz.divcontroller.entity.reportoutputbutton;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ReportOutputButton のクラスファイル 
 * 
 * @author 自動生成
 */
public class ReportOutputButtonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnCsvOutput")
    private Button btnCsvOutput;
    @JsonProperty("btnPdfOutput")
    private Button btnPdfOutput;
    @JsonProperty("btnExcelOutput")
    private Button btnExcelOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnCsvOutput")
    public Button getBtnCsvOutput() {
        return btnCsvOutput;
    }

    @JsonProperty("btnCsvOutput")
    public void setBtnCsvOutput(Button btnCsvOutput) {
        this.btnCsvOutput=btnCsvOutput;
    }

    @JsonProperty("btnPdfOutput")
    public Button getBtnPdfOutput() {
        return btnPdfOutput;
    }

    @JsonProperty("btnPdfOutput")
    public void setBtnPdfOutput(Button btnPdfOutput) {
        this.btnPdfOutput=btnPdfOutput;
    }

    @JsonProperty("btnExcelOutput")
    public Button getBtnExcelOutput() {
        return btnExcelOutput;
    }

    @JsonProperty("btnExcelOutput")
    public void setBtnExcelOutput(Button btnExcelOutput) {
        this.btnExcelOutput=btnExcelOutput;
    }

}
