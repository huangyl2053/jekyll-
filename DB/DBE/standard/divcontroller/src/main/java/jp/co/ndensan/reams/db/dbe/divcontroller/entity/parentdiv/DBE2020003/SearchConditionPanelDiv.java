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
 * SearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ScheduleEdit")
    private ScheduleEditDiv ScheduleEdit;
    @JsonProperty("ScheduleShokai")
    private ScheduleShokaiDiv ScheduleShokai;
    @JsonProperty("MiteishaKanri")
    private MiteishaKanriDiv MiteishaKanri;
    @JsonProperty("ddlTaishoChiku")
    private DropDownList ddlTaishoChiku;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBox txtShikibetsuCode;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtKanaShimei")
    private TextBoxKana txtKanaShimei;
    @JsonProperty("txtBirthDay")
    private TextBoxFlexibleDate txtBirthDay;
    @JsonProperty("txtNinteiShinseiYMDFrom")
    private TextBoxFlexibleDate txtNinteiShinseiYMDFrom;
    @JsonProperty("txtNinteiShinseiYMDTo")
    private TextBoxFlexibleDate txtNinteiShinseiYMDTo;
    @JsonProperty("txtMemo")
    private TextBox txtMemo;
    @JsonProperty("NinteiChosaJoken")
    private NinteiChosaJokenDiv NinteiChosaJoken;
    @JsonProperty("txtMaxRow")
    private TextBox txtMaxRow;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getScheduleEdit
     * @return ScheduleEdit
     */
    @JsonProperty("ScheduleEdit")
    public ScheduleEditDiv getScheduleEdit() {
        return ScheduleEdit;
    }

    /*
     * setScheduleEdit
     * @param ScheduleEdit ScheduleEdit
     */
    @JsonProperty("ScheduleEdit")
    public void setScheduleEdit(ScheduleEditDiv ScheduleEdit) {
        this.ScheduleEdit = ScheduleEdit;
    }

    /*
     * getScheduleShokai
     * @return ScheduleShokai
     */
    @JsonProperty("ScheduleShokai")
    public ScheduleShokaiDiv getScheduleShokai() {
        return ScheduleShokai;
    }

    /*
     * setScheduleShokai
     * @param ScheduleShokai ScheduleShokai
     */
    @JsonProperty("ScheduleShokai")
    public void setScheduleShokai(ScheduleShokaiDiv ScheduleShokai) {
        this.ScheduleShokai = ScheduleShokai;
    }

    /*
     * getMiteishaKanri
     * @return MiteishaKanri
     */
    @JsonProperty("MiteishaKanri")
    public MiteishaKanriDiv getMiteishaKanri() {
        return MiteishaKanri;
    }

    /*
     * setMiteishaKanri
     * @param MiteishaKanri MiteishaKanri
     */
    @JsonProperty("MiteishaKanri")
    public void setMiteishaKanri(MiteishaKanriDiv MiteishaKanri) {
        this.MiteishaKanri = MiteishaKanri;
    }

    /*
     * getddlTaishoChiku
     * @return ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public DropDownList getDdlTaishoChiku() {
        return ddlTaishoChiku;
    }

    /*
     * setddlTaishoChiku
     * @param ddlTaishoChiku ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public void setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.ddlTaishoChiku = ddlTaishoChiku;
    }

    /*
     * getddlHokensha
     * @return ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    /*
     * setddlHokensha
     * @param ddlHokensha ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha = ddlHokensha;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBox getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtKanaShimei
     * @return txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public TextBoxKana getTxtKanaShimei() {
        return txtKanaShimei;
    }

    /*
     * settxtKanaShimei
     * @param txtKanaShimei txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public void setTxtKanaShimei(TextBoxKana txtKanaShimei) {
        this.txtKanaShimei = txtKanaShimei;
    }

    /*
     * gettxtBirthDay
     * @return txtBirthDay
     */
    @JsonProperty("txtBirthDay")
    public TextBoxFlexibleDate getTxtBirthDay() {
        return txtBirthDay;
    }

    /*
     * settxtBirthDay
     * @param txtBirthDay txtBirthDay
     */
    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxFlexibleDate txtBirthDay) {
        this.txtBirthDay = txtBirthDay;
    }

    /*
     * gettxtNinteiShinseiYMDFrom
     * @return txtNinteiShinseiYMDFrom
     */
    @JsonProperty("txtNinteiShinseiYMDFrom")
    public TextBoxFlexibleDate getTxtNinteiShinseiYMDFrom() {
        return txtNinteiShinseiYMDFrom;
    }

    /*
     * settxtNinteiShinseiYMDFrom
     * @param txtNinteiShinseiYMDFrom txtNinteiShinseiYMDFrom
     */
    @JsonProperty("txtNinteiShinseiYMDFrom")
    public void setTxtNinteiShinseiYMDFrom(TextBoxFlexibleDate txtNinteiShinseiYMDFrom) {
        this.txtNinteiShinseiYMDFrom = txtNinteiShinseiYMDFrom;
    }

    /*
     * gettxtNinteiShinseiYMDTo
     * @return txtNinteiShinseiYMDTo
     */
    @JsonProperty("txtNinteiShinseiYMDTo")
    public TextBoxFlexibleDate getTxtNinteiShinseiYMDTo() {
        return txtNinteiShinseiYMDTo;
    }

    /*
     * settxtNinteiShinseiYMDTo
     * @param txtNinteiShinseiYMDTo txtNinteiShinseiYMDTo
     */
    @JsonProperty("txtNinteiShinseiYMDTo")
    public void setTxtNinteiShinseiYMDTo(TextBoxFlexibleDate txtNinteiShinseiYMDTo) {
        this.txtNinteiShinseiYMDTo = txtNinteiShinseiYMDTo;
    }

    /*
     * gettxtMemo
     * @return txtMemo
     */
    @JsonProperty("txtMemo")
    public TextBox getTxtMemo() {
        return txtMemo;
    }

    /*
     * settxtMemo
     * @param txtMemo txtMemo
     */
    @JsonProperty("txtMemo")
    public void setTxtMemo(TextBox txtMemo) {
        this.txtMemo = txtMemo;
    }

    /*
     * getNinteiChosaJoken
     * @return NinteiChosaJoken
     */
    @JsonProperty("NinteiChosaJoken")
    public NinteiChosaJokenDiv getNinteiChosaJoken() {
        return NinteiChosaJoken;
    }

    /*
     * setNinteiChosaJoken
     * @param NinteiChosaJoken NinteiChosaJoken
     */
    @JsonProperty("NinteiChosaJoken")
    public void setNinteiChosaJoken(NinteiChosaJokenDiv NinteiChosaJoken) {
        this.NinteiChosaJoken = NinteiChosaJoken;
    }

    /*
     * gettxtMaxRow
     * @return txtMaxRow
     */
    @JsonProperty("txtMaxRow")
    public TextBox getTxtMaxRow() {
        return txtMaxRow;
    }

    /*
     * settxtMaxRow
     * @param txtMaxRow txtMaxRow
     */
    @JsonProperty("txtMaxRow")
    public void setTxtMaxRow(TextBox txtMaxRow) {
        this.txtMaxRow = txtMaxRow;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadScheduleEdit() {
        return this.getScheduleEdit().getRadScheduleEdit();
    }

    @JsonIgnore
    public void  setRadScheduleEdit(RadioButton radScheduleEdit) {
        this.getScheduleEdit().setRadScheduleEdit(radScheduleEdit);
    }

    @JsonIgnore
    public RadioButton getRadScheduleShokai() {
        return this.getScheduleShokai().getRadScheduleShokai();
    }

    @JsonIgnore
    public void  setRadScheduleShokai(RadioButton radScheduleShokai) {
        this.getScheduleShokai().setRadScheduleShokai(radScheduleShokai);
    }

    @JsonIgnore
    public RadioButton getRadMiteishaKanri() {
        return this.getMiteishaKanri().getRadMiteishaKanri();
    }

    @JsonIgnore
    public void  setRadMiteishaKanri(RadioButton radMiteishaKanri) {
        this.getMiteishaKanri().setRadMiteishaKanri(radMiteishaKanri);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusaki() {
        return this.getNinteiChosaJoken().getDdlNinteiChosaItakusaki();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaItakusaki(DropDownList ddlNinteiChosaItakusaki) {
        this.getNinteiChosaJoken().setDdlNinteiChosaItakusaki(ddlNinteiChosaItakusaki);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosain() {
        return this.getNinteiChosaJoken().getDdlNinteiChosain();
    }

    @JsonIgnore
    public void  setDdlNinteiChosain(DropDownList ddlNinteiChosain) {
        this.getNinteiChosaJoken().setDdlNinteiChosain(ddlNinteiChosain);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaYMDFrom() {
        return this.getNinteiChosaJoken().getTxtNinteiChosaYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYMDFrom(TextBoxFlexibleDate txtNinteiChosaYMDFrom) {
        this.getNinteiChosaJoken().setTxtNinteiChosaYMDFrom(txtNinteiChosaYMDFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaYMDTo() {
        return this.getNinteiChosaJoken().getTxtNinteiChosaYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYMDTo(TextBoxFlexibleDate txtNinteiChosaYMDTo) {
        this.getNinteiChosaJoken().setTxtNinteiChosaYMDTo(txtNinteiChosaYMDTo);
    }

    // </editor-fold>
}
