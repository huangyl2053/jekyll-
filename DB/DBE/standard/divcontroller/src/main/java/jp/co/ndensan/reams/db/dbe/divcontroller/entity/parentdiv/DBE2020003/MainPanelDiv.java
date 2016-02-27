package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003;
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
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionPanel")
    private SearchConditionPanelDiv SearchConditionPanel;
    @JsonProperty("ResultListPanel")
    private ResultListPanelDiv ResultListPanel;

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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ScheduleEditDiv getScheduleEdit() {
        return this.getSearchConditionPanel().getScheduleEdit();
    }

    @JsonIgnore
    public void  setScheduleEdit(ScheduleEditDiv ScheduleEdit) {
        this.getSearchConditionPanel().setScheduleEdit(ScheduleEdit);
    }

    @JsonIgnore
    public RadioButton getRadScheduleEdit() {
        return this.getSearchConditionPanel().getScheduleEdit().getRadScheduleEdit();
    }

    @JsonIgnore
    public void  setRadScheduleEdit(RadioButton radScheduleEdit) {
        this.getSearchConditionPanel().getScheduleEdit().setRadScheduleEdit(radScheduleEdit);
    }

    @JsonIgnore
    public ScheduleShokaiDiv getScheduleShokai() {
        return this.getSearchConditionPanel().getScheduleShokai();
    }

    @JsonIgnore
    public void  setScheduleShokai(ScheduleShokaiDiv ScheduleShokai) {
        this.getSearchConditionPanel().setScheduleShokai(ScheduleShokai);
    }

    @JsonIgnore
    public RadioButton getRadScheduleShokai() {
        return this.getSearchConditionPanel().getScheduleShokai().getRadScheduleShokai();
    }

    @JsonIgnore
    public void  setRadScheduleShokai(RadioButton radScheduleShokai) {
        this.getSearchConditionPanel().getScheduleShokai().setRadScheduleShokai(radScheduleShokai);
    }

    @JsonIgnore
    public MiteishaKanriDiv getMiteishaKanri() {
        return this.getSearchConditionPanel().getMiteishaKanri();
    }

    @JsonIgnore
    public void  setMiteishaKanri(MiteishaKanriDiv MiteishaKanri) {
        this.getSearchConditionPanel().setMiteishaKanri(MiteishaKanri);
    }

    @JsonIgnore
    public RadioButton getRadMiteishaKanri() {
        return this.getSearchConditionPanel().getMiteishaKanri().getRadMiteishaKanri();
    }

    @JsonIgnore
    public void  setRadMiteishaKanri(RadioButton radMiteishaKanri) {
        this.getSearchConditionPanel().getMiteishaKanri().setRadMiteishaKanri(radMiteishaKanri);
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
    public DropDownList getDdlHokensha() {
        return this.getSearchConditionPanel().getDdlHokensha();
    }

    @JsonIgnore
    public void  setDdlHokensha(DropDownList ddlHokensha) {
        this.getSearchConditionPanel().setDdlHokensha(ddlHokensha);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getSearchConditionPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getSearchConditionPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShikibetsuCode() {
        return this.getSearchConditionPanel().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.getSearchConditionPanel().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getSearchConditionPanel().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getSearchConditionPanel().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaShimei() {
        return this.getSearchConditionPanel().getTxtKanaShimei();
    }

    @JsonIgnore
    public void  setTxtKanaShimei(TextBoxKana txtKanaShimei) {
        this.getSearchConditionPanel().setTxtKanaShimei(txtKanaShimei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthDay() {
        return this.getSearchConditionPanel().getTxtBirthDay();
    }

    @JsonIgnore
    public void  setTxtBirthDay(TextBoxFlexibleDate txtBirthDay) {
        this.getSearchConditionPanel().setTxtBirthDay(txtBirthDay);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiYMDFrom() {
        return this.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiYMDFrom(TextBoxFlexibleDate txtNinteiShinseiYMDFrom) {
        this.getSearchConditionPanel().setTxtNinteiShinseiYMDFrom(txtNinteiShinseiYMDFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiYMDTo() {
        return this.getSearchConditionPanel().getTxtNinteiShinseiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiYMDTo(TextBoxFlexibleDate txtNinteiShinseiYMDTo) {
        this.getSearchConditionPanel().setTxtNinteiShinseiYMDTo(txtNinteiShinseiYMDTo);
    }

    @JsonIgnore
    public TextBox getTxtMemo() {
        return this.getSearchConditionPanel().getTxtMemo();
    }

    @JsonIgnore
    public void  setTxtMemo(TextBox txtMemo) {
        this.getSearchConditionPanel().setTxtMemo(txtMemo);
    }

    @JsonIgnore
    public NinteiChosaJokenDiv getNinteiChosaJoken() {
        return this.getSearchConditionPanel().getNinteiChosaJoken();
    }

    @JsonIgnore
    public void  setNinteiChosaJoken(NinteiChosaJokenDiv NinteiChosaJoken) {
        this.getSearchConditionPanel().setNinteiChosaJoken(NinteiChosaJoken);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusaki() {
        return this.getSearchConditionPanel().getNinteiChosaJoken().getDdlNinteiChosaItakusaki();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaItakusaki(DropDownList ddlNinteiChosaItakusaki) {
        this.getSearchConditionPanel().getNinteiChosaJoken().setDdlNinteiChosaItakusaki(ddlNinteiChosaItakusaki);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosain() {
        return this.getSearchConditionPanel().getNinteiChosaJoken().getDdlNinteiChosain();
    }

    @JsonIgnore
    public void  setDdlNinteiChosain(DropDownList ddlNinteiChosain) {
        this.getSearchConditionPanel().getNinteiChosaJoken().setDdlNinteiChosain(ddlNinteiChosain);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaYMDFrom() {
        return this.getSearchConditionPanel().getNinteiChosaJoken().getTxtNinteiChosaYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYMDFrom(TextBoxFlexibleDate txtNinteiChosaYMDFrom) {
        this.getSearchConditionPanel().getNinteiChosaJoken().setTxtNinteiChosaYMDFrom(txtNinteiChosaYMDFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaYMDTo() {
        return this.getSearchConditionPanel().getNinteiChosaJoken().getTxtNinteiChosaYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYMDTo(TextBoxFlexibleDate txtNinteiChosaYMDTo) {
        this.getSearchConditionPanel().getNinteiChosaJoken().setTxtNinteiChosaYMDTo(txtNinteiChosaYMDTo);
    }

    @JsonIgnore
    public TextBox getTxtMaxRow() {
        return this.getSearchConditionPanel().getTxtMaxRow();
    }

    @JsonIgnore
    public void  setTxtMaxRow(TextBox txtMaxRow) {
        this.getSearchConditionPanel().setTxtMaxRow(txtMaxRow);
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
    public Button getBtnClear() {
        return this.getSearchConditionPanel().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getSearchConditionPanel().setBtnClear(btnClear);
    }

    @JsonIgnore
    public DataGrid<dgResultList_Row> getDgResultList() {
        return this.getResultListPanel().getDgResultList();
    }

    @JsonIgnore
    public void  setDgResultList(DataGrid<dgResultList_Row> dgResultList) {
        this.getResultListPanel().setDgResultList(dgResultList);
    }

    // </editor-fold>
}
