package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020006;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020006.dgTimeScheduleList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionPanel")
    private SearchConditionPanelDiv SearchConditionPanel;
    @JsonProperty("SettingList")
    private SettingListDiv SettingList;
    @JsonProperty("btnNinteiChosaIkkatsuInput")
    private ButtonDialog btnNinteiChosaIkkatsuInput;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("SettingDetail")
    private SettingDetailDiv SettingDetail;

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

    @JsonProperty("SettingList")
    public SettingListDiv getSettingList() {
        return SettingList;
    }

    @JsonProperty("SettingList")
    public void setSettingList(SettingListDiv SettingList) {
        this.SettingList=SettingList;
    }

    @JsonProperty("btnNinteiChosaIkkatsuInput")
    public ButtonDialog getBtnNinteiChosaIkkatsuInput() {
        return btnNinteiChosaIkkatsuInput;
    }

    @JsonProperty("btnNinteiChosaIkkatsuInput")
    public void setBtnNinteiChosaIkkatsuInput(ButtonDialog btnNinteiChosaIkkatsuInput) {
        this.btnNinteiChosaIkkatsuInput=btnNinteiChosaIkkatsuInput;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
    }

    @JsonProperty("SettingDetail")
    public SettingDetailDiv getSettingDetail() {
        return SettingDetail;
    }

    @JsonProperty("SettingDetail")
    public void setSettingDetail(SettingDetailDiv SettingDetail) {
        this.SettingDetail=SettingDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTaishoChiku() {
        return this.getSearchConditionPanel().getDdlTaishoChiku();
    }

    @JsonIgnore
    public void  setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.getSearchConditionPanel().setDdlTaishoChiku(ddlTaishoChiku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSettingMonth() {
        return this.getSearchConditionPanel().getTxtSettingMonth();
    }

    @JsonIgnore
    public void  setTxtSettingMonth(TextBoxFlexibleDate txtSettingMonth) {
        this.getSearchConditionPanel().setTxtSettingMonth(txtSettingMonth);
    }

    @JsonIgnore
    public Button getBtnPrevious() {
        return this.getSearchConditionPanel().getBtnPrevious();
    }

    @JsonIgnore
    public void  setBtnPrevious(Button btnPrevious) {
        this.getSearchConditionPanel().setBtnPrevious(btnPrevious);
    }

    @JsonIgnore
    public Button getBtnNext() {
        return this.getSearchConditionPanel().getBtnNext();
    }

    @JsonIgnore
    public void  setBtnNext(Button btnNext) {
        this.getSearchConditionPanel().setBtnNext(btnNext);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiCode() {
        return this.getSearchConditionPanel().getTxtNinteiChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiCode(TextBox txtNinteiChosaItakusakiCode) {
        this.getSearchConditionPanel().setTxtNinteiChosaItakusakiCode(txtNinteiChosaItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getSearchConditionPanel().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getSearchConditionPanel().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainCode() {
        return this.getSearchConditionPanel().getTxtNinteiChosainCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainCode(TextBox txtNinteiChosainCode) {
        this.getSearchConditionPanel().setTxtNinteiChosainCode(txtNinteiChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getSearchConditionPanel().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getSearchConditionPanel().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearch() {
        return this.getSearchConditionPanel().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(ButtonDialog btnSearch) {
        this.getSearchConditionPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgTimeScheduleList_Row> getDgTimeScheduleList() {
        return this.getSettingList().getDgTimeScheduleList();
    }

    @JsonIgnore
    public void  setDgTimeScheduleList(DataGrid<dgTimeScheduleList_Row> dgTimeScheduleList) {
        this.getSettingList().setDgTimeScheduleList(dgTimeScheduleList);
    }

    @JsonIgnore
    public tabSettingDiv getTabSetting() {
        return this.getSettingDetail().getTabSetting();
    }

    @JsonIgnore
    public void  setTabSetting(tabSettingDiv tabSetting) {
        this.getSettingDetail().setTabSetting(tabSetting);
    }

    @JsonIgnore
    public TextBoxDate getTxtSetteiYMD() {
        return this.getSettingDetail().getTabSetting().getTxtSetteiYMD();
    }

    @JsonIgnore
    public TextBox getTxtJikanWaku() {
        return this.getSettingDetail().getTabSetting().getTxtJikanWaku();
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiJikan() {
        return this.getSettingDetail().getTabSetting().getTxtKaishiJikan();
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoJikan() {
        return this.getSettingDetail().getTabSetting().getTxtShuryoJikan();
    }

    @JsonIgnore
    public RadioButton getRadYoyaku() {
        return this.getSettingDetail().getTabSetting().getRadYoyaku();
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.getSettingDetail().getTabSetting().getTxtBiko();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getSettingDetail().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getSettingDetail().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getSettingDetail().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getSettingDetail().setBtnDelete(btnDelete);
    }

    // </editor-fold>
}
