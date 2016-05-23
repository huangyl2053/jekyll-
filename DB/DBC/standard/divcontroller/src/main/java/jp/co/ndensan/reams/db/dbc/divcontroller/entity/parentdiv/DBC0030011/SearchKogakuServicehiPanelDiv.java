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
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * SearchKogakuServicehiPanel のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class SearchKogakuServicehiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("radSearchKubun")
    private RadioButton radSearchKubun;
    @JsonProperty("SearchKogakuHihokensha")
    private SearchKogakuHihokenshaDiv SearchKogakuHihokensha;
    @JsonProperty("SearchYM")
    private SearchYMDiv SearchYM;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getradSearchKubun
     * @return radSearchKubun
     */
    @JsonProperty("radSearchKubun")
    public RadioButton getRadSearchKubun() {
        return radSearchKubun;
    }

    /*
     * setradSearchKubun
     * @param radSearchKubun radSearchKubun
     */
    @JsonProperty("radSearchKubun")
    public void setRadSearchKubun(RadioButton radSearchKubun) {
        this.radSearchKubun = radSearchKubun;
    }

    /*
     * getSearchKogakuHihokensha
     * @return SearchKogakuHihokensha
     */
    @JsonProperty("SearchKogakuHihokensha")
    public SearchKogakuHihokenshaDiv getSearchKogakuHihokensha() {
        return SearchKogakuHihokensha;
    }

    /*
     * setSearchKogakuHihokensha
     * @param SearchKogakuHihokensha SearchKogakuHihokensha
     */
    @JsonProperty("SearchKogakuHihokensha")
    public void setSearchKogakuHihokensha(SearchKogakuHihokenshaDiv SearchKogakuHihokensha) {
        this.SearchKogakuHihokensha = SearchKogakuHihokensha;
    }

    /*
     * getSearchYM
     * @return SearchYM
     */
    @JsonProperty("SearchYM")
    public SearchYMDiv getSearchYM() {
        return SearchYM;
    }

    /*
     * setSearchYM
     * @param SearchYM SearchYM
     */
    @JsonProperty("SearchYM")
    public void setSearchYM(SearchYMDiv SearchYM) {
        this.SearchYM = SearchYM;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getSearchKogakuHihokensha().getTxtHihoNo();
    }

    @JsonIgnore
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getSearchKogakuHihokensha().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchHihokensha() {
        return this.getSearchKogakuHihokensha().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void setBtnSearchHihokensha(ButtonDialog btnSearchHihokensha) {
        this.getSearchKogakuHihokensha().setBtnSearchHihokensha(btnSearchHihokensha);
    }

    @JsonIgnore
    public TextBox getTxtHihoName() {
        return this.getSearchKogakuHihokensha().getTxtHihoName();
    }

    @JsonIgnore
    public void setTxtHihoName(TextBox txtHihoName) {
        this.getSearchKogakuHihokensha().setTxtHihoName(txtHihoName);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return this.getSearchKogakuHihokensha().getTxtTeikyoYMRange();
    }

    @JsonIgnore
    public void setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.getSearchKogakuHihokensha().setTxtTeikyoYMRange(txtTeikyoYMRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiYMRange() {
        return this.getSearchKogakuHihokensha().getTxtShinseiYMRange();
    }

    @JsonIgnore
    public void setTxtShinseiYMRange(TextBoxDateRange txtShinseiYMRange) {
        this.getSearchKogakuHihokensha().setTxtShinseiYMRange(txtShinseiYMRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteiYMRange() {
        return this.getSearchKogakuHihokensha().getTxtKetteiYMRange();
    }

    @JsonIgnore
    public void setTxtKetteiYMRange(TextBoxDateRange txtKetteiYMRange) {
        this.getSearchKogakuHihokensha().setTxtKetteiYMRange(txtKetteiYMRange);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoYM() {
        return this.getSearchYM().getTxtTeikyoYM();
    }

    @JsonIgnore
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.getSearchYM().setTxtTeikyoYM(txtTeikyoYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYM() {
        return this.getSearchYM().getTxtShinseiYM();
    }

    @JsonIgnore
    public void setTxtShinseiYM(TextBoxDate txtShinseiYM) {
        this.getSearchYM().setTxtShinseiYM(txtShinseiYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYM() {
        return this.getSearchYM().getTxtKetteiYM();
    }

    @JsonIgnore
    public void setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.getSearchYM().setTxtKetteiYM(txtKetteiYM);
    }

    // </editor-fold>
}
