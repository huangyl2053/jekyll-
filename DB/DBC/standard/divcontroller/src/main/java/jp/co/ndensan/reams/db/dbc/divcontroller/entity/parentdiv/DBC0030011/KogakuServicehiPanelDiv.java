package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KogakuServicehiPanel のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchKogakuServicehiPanel")
    private SearchKogakuServicehiPanelDiv SearchKogakuServicehiPanel;
    @JsonProperty("KogakuServicehiListPanel")
    private KogakuServicehiListPanelDiv KogakuServicehiListPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchKogakuServicehiPanel
     * @return SearchKogakuServicehiPanel
     */
    @JsonProperty("SearchKogakuServicehiPanel")
    public SearchKogakuServicehiPanelDiv getSearchKogakuServicehiPanel() {
        return SearchKogakuServicehiPanel;
    }

    /*
     * setSearchKogakuServicehiPanel
     * @param SearchKogakuServicehiPanel SearchKogakuServicehiPanel
     */
    @JsonProperty("SearchKogakuServicehiPanel")
    public void setSearchKogakuServicehiPanel(SearchKogakuServicehiPanelDiv SearchKogakuServicehiPanel) {
        this.SearchKogakuServicehiPanel = SearchKogakuServicehiPanel;
    }

    /*
     * getKogakuServicehiListPanel
     * @return KogakuServicehiListPanel
     */
    @JsonProperty("KogakuServicehiListPanel")
    public KogakuServicehiListPanelDiv getKogakuServicehiListPanel() {
        return KogakuServicehiListPanel;
    }

    /*
     * setKogakuServicehiListPanel
     * @param KogakuServicehiListPanel KogakuServicehiListPanel
     */
    @JsonProperty("KogakuServicehiListPanel")
    public void setKogakuServicehiListPanel(KogakuServicehiListPanelDiv KogakuServicehiListPanel) {
        this.KogakuServicehiListPanel = KogakuServicehiListPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHokensha() {
        return this.getSearchKogakuServicehiPanel().getDdlHokensha();
    }

    @JsonIgnore
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.getSearchKogakuServicehiPanel().setDdlHokensha(ddlHokensha);
    }

    @JsonIgnore
    public RadioButton getRadSearchKubun() {
        return this.getSearchKogakuServicehiPanel().getRadSearchKubun();
    }

    @JsonIgnore
    public void setRadSearchKubun(RadioButton radSearchKubun) {
        this.getSearchKogakuServicehiPanel().setRadSearchKubun(radSearchKubun);
    }

    @JsonIgnore
    public SearchKogakuHihokenshaDiv getSearchKogakuHihokensha() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
    }

    @JsonIgnore
    public void setSearchKogakuHihokensha(SearchKogakuHihokenshaDiv SearchKogakuHihokensha) {
        this.getSearchKogakuServicehiPanel().setSearchKogakuHihokensha(SearchKogakuHihokensha);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoNo();
    }

    @JsonIgnore
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchHihokensha() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void setBtnSearchHihokensha(ButtonDialog btnSearchHihokensha) {
        this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setBtnSearchHihokensha(btnSearchHihokensha);
    }

    @JsonIgnore
    public TextBox getTxtHihoName() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtHihoName();
    }

    @JsonIgnore
    public void setTxtHihoName(TextBox txtHihoName) {
        this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setTxtHihoName(txtHihoName);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange();
    }

    @JsonIgnore
    public void setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setTxtTeikyoYMRange(txtTeikyoYMRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiYMRange() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange();
    }

    @JsonIgnore
    public void setTxtShinseiYMRange(TextBoxDateRange txtShinseiYMRange) {
        this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setTxtShinseiYMRange(txtShinseiYMRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteiYMRange() {
        return this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange();
    }

    @JsonIgnore
    public void setTxtKetteiYMRange(TextBoxDateRange txtKetteiYMRange) {
        this.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().setTxtKetteiYMRange(txtKetteiYMRange);
    }

    @JsonIgnore
    public SearchYMDiv getSearchYM() {
        return this.getSearchKogakuServicehiPanel().getSearchYM();
    }

    @JsonIgnore
    public void setSearchYM(SearchYMDiv SearchYM) {
        this.getSearchKogakuServicehiPanel().setSearchYM(SearchYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoYM() {
        return this.getSearchKogakuServicehiPanel().getSearchYM().getTxtTeikyoYM();
    }

    @JsonIgnore
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.getSearchKogakuServicehiPanel().getSearchYM().setTxtTeikyoYM(txtTeikyoYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYM() {
        return this.getSearchKogakuServicehiPanel().getSearchYM().getTxtShinseiYM();
    }

    @JsonIgnore
    public void setTxtShinseiYM(TextBoxDate txtShinseiYM) {
        this.getSearchKogakuServicehiPanel().getSearchYM().setTxtShinseiYM(txtShinseiYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYM() {
        return this.getSearchKogakuServicehiPanel().getSearchYM().getTxtKetteiYM();
    }

    @JsonIgnore
    public void setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.getSearchKogakuServicehiPanel().getSearchYM().setTxtKetteiYM(txtKetteiYM);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getSearchKogakuServicehiPanel().getBtnClear();
    }

    @JsonIgnore
    public void setBtnClear(Button btnClear) {
        this.getSearchKogakuServicehiPanel().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getSearchKogakuServicehiPanel().getBtnSearch();
    }

    @JsonIgnore
    public void setBtnSearch(Button btnSearch) {
        this.getSearchKogakuServicehiPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgKogakuServicehiRireki_Row> getDgKogakuServicehiRireki() {
        return this.getKogakuServicehiListPanel().getDgKogakuServicehiRireki();
    }

    @JsonIgnore
    public void setDgKogakuServicehiRireki(DataGrid<dgKogakuServicehiRireki_Row> dgKogakuServicehiRireki) {
        this.getKogakuServicehiListPanel().setDgKogakuServicehiRireki(dgKogakuServicehiRireki);
    }

    @JsonIgnore
    public Button getBtnResearch() {
        return this.getKogakuServicehiListPanel().getBtnResearch();
    }

    @JsonIgnore
    public void setBtnResearch(Button btnResearch) {
        this.getKogakuServicehiListPanel().setBtnResearch(btnResearch);
    }

    // </editor-fold>
}
