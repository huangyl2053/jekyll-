package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shujiiIryokikanandshujiiinput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionPanel")
    private SearchConditionPanelDiv SearchConditionPanel;
    @JsonProperty("DoctorSelectionPanel")
    private DoctorSelectionPanelDiv DoctorSelectionPanel;
    @JsonProperty("ResultListPanel")
    private ResultListPanelDiv ResultListPanel;
    @JsonProperty("PrintPanel")
    private PrintPanelDiv PrintPanel;

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
     * getDoctorSelectionPanel
     * @return DoctorSelectionPanel
     */
    @JsonProperty("DoctorSelectionPanel")
    public DoctorSelectionPanelDiv getDoctorSelectionPanel() {
        return DoctorSelectionPanel;
    }

    /*
     * setDoctorSelectionPanel
     * @param DoctorSelectionPanel DoctorSelectionPanel
     */
    @JsonProperty("DoctorSelectionPanel")
    public void setDoctorSelectionPanel(DoctorSelectionPanelDiv DoctorSelectionPanel) {
        this.DoctorSelectionPanel = DoctorSelectionPanel;
    }

    /*
     * getResultListPanel
     * @return ResultListPanel
     */
    @JsonProperty("ResultListPanel")
    public ResultListPanelDiv getResultListPanel() {
        return ResultListPanel;
    }

    /*
     * setResultListPanel
     * @param ResultListPanel ResultListPanel
     */
    @JsonProperty("ResultListPanel")
    public void setResultListPanel(ResultListPanelDiv ResultListPanel) {
        this.ResultListPanel = ResultListPanel;
    }

    /*
     * getPrintPanel
     * @return PrintPanel
     */
    @JsonProperty("PrintPanel")
    public PrintPanelDiv getPrintPanel() {
        return PrintPanel;
    }

    /*
     * setPrintPanel
     * @param PrintPanel PrintPanel
     */
    @JsonProperty("PrintPanel")
    public void setPrintPanel(PrintPanelDiv PrintPanel) {
        this.PrintPanel = PrintPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteiKikan() {
        return this.getSearchConditionPanel().getTxtNijiHanteiKikan();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiKikan(TextBoxDateRange txtNijiHanteiKikan) {
        this.getSearchConditionPanel().setTxtNijiHanteiKikan(txtNijiHanteiKikan);
    }

    @JsonIgnore
    public RadioButton getRadPrintCondition() {
        return this.getSearchConditionPanel().getRadPrintCondition();
    }

    @JsonIgnore
    public void  setRadPrintCondition(RadioButton radPrintCondition) {
        this.getSearchConditionPanel().setRadPrintCondition(radPrintCondition);
    }

    @JsonIgnore
    public RadioButton getRadKekkaTsuchiOutputTaisho() {
        return this.getSearchConditionPanel().getRadKekkaTsuchiOutputTaisho();
    }

    @JsonIgnore
    public void  setRadKekkaTsuchiOutputTaisho(RadioButton radKekkaTsuchiOutputTaisho) {
        this.getSearchConditionPanel().setRadKekkaTsuchiOutputTaisho(radKekkaTsuchiOutputTaisho);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getSearchConditionPanel().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getSearchConditionPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getSearchConditionPanel().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public DataGrid<dgDoctorSelection_Row> getDgDoctorSelection() {
        return this.getDoctorSelectionPanel().getDgDoctorSelection();
    }

    @JsonIgnore
    public void  setDgDoctorSelection(DataGrid<dgDoctorSelection_Row> dgDoctorSelection) {
        this.getDoctorSelectionPanel().setDgDoctorSelection(dgDoctorSelection);
    }

    @JsonIgnore
    public DataGrid<dgResultList_Row> getDgResultList() {
        return this.getResultListPanel().getDgResultList();
    }

    @JsonIgnore
    public void  setDgResultList(DataGrid<dgResultList_Row> dgResultList) {
        this.getResultListPanel().setDgResultList(dgResultList);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiJokyoTeikyoYMD() {
        return this.getPrintPanel().getTxtNinteiJokyoTeikyoYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiJokyoTeikyoYMD(TextBoxDate txtNinteiJokyoTeikyoYMD) {
        this.getPrintPanel().setTxtNinteiJokyoTeikyoYMD(txtNinteiJokyoTeikyoYMD);
    }

    // </editor-fold>
}
