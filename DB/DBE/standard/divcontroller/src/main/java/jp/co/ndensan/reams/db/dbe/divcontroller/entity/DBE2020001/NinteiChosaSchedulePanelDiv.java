package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020001;
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
 * NinteiChosaSchedulePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaSchedulePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionPanel")
    private SearchConditionPanelDiv SearchConditionPanel;
    @JsonProperty("lblNinteiChosaScheduleList")
    private Label lblNinteiChosaScheduleList;
    @JsonProperty("dgNinteiChosaSchedule")
    private DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchConditionPanel")
    public SearchConditionPanelDiv getSearchConditionPanel() {
        return SearchConditionPanel;
    }

    @JsonProperty("SearchConditionPanel")
    public void setSearchConditionPanel(SearchConditionPanelDiv SearchConditionPanel) {
        this.SearchConditionPanel=SearchConditionPanel;
    }

    @JsonProperty("lblNinteiChosaScheduleList")
    public Label getLblNinteiChosaScheduleList() {
        return lblNinteiChosaScheduleList;
    }

    @JsonProperty("lblNinteiChosaScheduleList")
    public void setLblNinteiChosaScheduleList(Label lblNinteiChosaScheduleList) {
        this.lblNinteiChosaScheduleList=lblNinteiChosaScheduleList;
    }

    @JsonProperty("dgNinteiChosaSchedule")
    public DataGrid<dgNinteiChosaSchedule_Row> getDgNinteiChosaSchedule() {
        return dgNinteiChosaSchedule;
    }

    @JsonProperty("dgNinteiChosaSchedule")
    public void setDgNinteiChosaSchedule(DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule) {
        this.dgNinteiChosaSchedule=dgNinteiChosaSchedule;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtSetteiYM() {
        return this.getSearchConditionPanel().getTxtSetteiYM();
    }

    @JsonIgnore
    public void  setTxtSetteiYM(TextBoxFlexibleDate txtSetteiYM) {
        this.getSearchConditionPanel().setTxtSetteiYM(txtSetteiYM);
    }

    @JsonIgnore
    public Button getBtnPreviousMonth() {
        return this.getSearchConditionPanel().getBtnPreviousMonth();
    }

    @JsonIgnore
    public void  setBtnPreviousMonth(Button btnPreviousMonth) {
        this.getSearchConditionPanel().setBtnPreviousMonth(btnPreviousMonth);
    }

    @JsonIgnore
    public Button getBtnNextMonth() {
        return this.getSearchConditionPanel().getBtnNextMonth();
    }

    @JsonIgnore
    public void  setBtnNextMonth(Button btnNextMonth) {
        this.getSearchConditionPanel().setBtnNextMonth(btnNextMonth);
    }

    @JsonIgnore
    public DropDownList getDdlTaishoChiku() {
        return this.getSearchConditionPanel().getDdlTaishoChiku();
    }

    @JsonIgnore
    public void  setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.getSearchConditionPanel().setDdlTaishoChiku(ddlTaishoChiku);
    }

    @JsonIgnore
    public Button getBtnDisplay() {
        return this.getSearchConditionPanel().getBtnDisplay();
    }

    @JsonIgnore
    public void  setBtnDisplay(Button btnDisplay) {
        this.getSearchConditionPanel().setBtnDisplay(btnDisplay);
    }

    // </editor-fold>
}
