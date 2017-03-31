package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiChosaSchedulePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaSchedulePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionPanel")
    private SearchConditionPanelDiv SearchConditionPanel;
    @JsonProperty("dgNinteiChosaSchedule")
    private DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchConditionPanel
     * @return SearchConditionPanel
     */
    @JsonProperty("SearchConditionPanel")
    public SearchConditionPanelDiv getSearchConditionPanel() {
        return SearchConditionPanel;
    }

    /*
     * setSearchConditionPanel
     * @param SearchConditionPanel SearchConditionPanel
     */
    @JsonProperty("SearchConditionPanel")
    public void setSearchConditionPanel(SearchConditionPanelDiv SearchConditionPanel) {
        this.SearchConditionPanel = SearchConditionPanel;
    }

    /*
     * getdgNinteiChosaSchedule
     * @return dgNinteiChosaSchedule
     */
    @JsonProperty("dgNinteiChosaSchedule")
    public DataGrid<dgNinteiChosaSchedule_Row> getDgNinteiChosaSchedule() {
        return dgNinteiChosaSchedule;
    }

    /*
     * setdgNinteiChosaSchedule
     * @param dgNinteiChosaSchedule dgNinteiChosaSchedule
     */
    @JsonProperty("dgNinteiChosaSchedule")
    public void setDgNinteiChosaSchedule(DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule) {
        this.dgNinteiChosaSchedule = dgNinteiChosaSchedule;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtConfigurationYM() {
        return this.getSearchConditionPanel().getTxtConfigurationYM();
    }

    @JsonIgnore
    public void  setTxtConfigurationYM(TextBoxFlexibleYearMonth txtConfigurationYM) {
        this.getSearchConditionPanel().setTxtConfigurationYM(txtConfigurationYM);
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
