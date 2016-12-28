package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YouKaiGoNinTeiKekTesuChiMainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class YouKaiGoNinTeiKekTesuChiMainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-54-17">
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
    public IHokenshaListDiv getCcdHokensha() {
        return this.getSearchConditionPanel().getCcdHokensha();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNijiHanteiKikan() {
        return this.getSearchConditionPanel().getTxtNijiHanteiKikan();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiKikan(TextBoxDateRange txtNijiHanteiKikan) {
        this.getSearchConditionPanel().setTxtNijiHanteiKikan(txtNijiHanteiKikan);
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
    public TextBoxNum getTxtDispMax() {
        return this.getSearchConditionPanel().getTxtDispMax();
    }

    @JsonIgnore
    public void  setTxtDispMax(TextBoxNum txtDispMax) {
        this.getSearchConditionPanel().setTxtDispMax(txtDispMax);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getSearchConditionPanel().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getSearchConditionPanel().setBtnClear(btnClear);
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

    @JsonIgnore
    public RadioButton getRadPrintCondition() {
        return this.getPrintPanel().getRadPrintCondition();
    }

    @JsonIgnore
    public void  setRadPrintCondition(RadioButton radPrintCondition) {
        this.getPrintPanel().setRadPrintCondition(radPrintCondition);
    }

    // </editor-fold>
}
