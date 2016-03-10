package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011;
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
 * PnlTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlSearch")
    private PnlSearchDiv PnlSearch;
    @JsonProperty("PnlKeiyakusyaList")
    private PnlKeiyakusyaListDiv PnlKeiyakusyaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlSearch
     * @return PnlSearch
     */
    @JsonProperty("PnlSearch")
    public PnlSearchDiv getPnlSearch() {
        return PnlSearch;
    }

    /*
     * setPnlSearch
     * @param PnlSearch PnlSearch
     */
    @JsonProperty("PnlSearch")
    public void setPnlSearch(PnlSearchDiv PnlSearch) {
        this.PnlSearch = PnlSearch;
    }

    /*
     * getPnlKeiyakusyaList
     * @return PnlKeiyakusyaList
     */
    @JsonProperty("PnlKeiyakusyaList")
    public PnlKeiyakusyaListDiv getPnlKeiyakusyaList() {
        return PnlKeiyakusyaList;
    }

    /*
     * setPnlKeiyakusyaList
     * @param PnlKeiyakusyaList PnlKeiyakusyaList
     */
    @JsonProperty("PnlKeiyakusyaList")
    public void setPnlKeiyakusyaList(PnlKeiyakusyaListDiv PnlKeiyakusyaList) {
        this.PnlKeiyakusyaList = PnlKeiyakusyaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getPnlSearch().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getPnlSearch().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public Button getBtnHihokensyaSearch() {
        return this.getPnlSearch().getBtnHihokensyaSearch();
    }

    @JsonIgnore
    public void  setBtnHihokensyaSearch(Button btnHihokensyaSearch) {
        this.getPnlSearch().setBtnHihokensyaSearch(btnHihokensyaSearch);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getPnlSearch().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getPnlSearch().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiYMDRange() {
        return this.getPnlSearch().getTxtShinseiYMDRange();
    }

    @JsonIgnore
    public void  setTxtShinseiYMDRange(TextBoxDateRange txtShinseiYMDRange) {
        this.getPnlSearch().setTxtShinseiYMDRange(txtShinseiYMDRange);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteYMDRange() {
        return this.getPnlSearch().getTxtKetteYMDRange();
    }

    @JsonIgnore
    public void  setTxtKetteYMDRange(TextBoxDateRange txtKetteYMDRange) {
        this.getPnlSearch().setTxtKetteYMDRange(txtKetteYMDRange);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyoshakeiyakuNo() {
        return this.getPnlSearch().getTxtJigyoshakeiyakuNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshakeiyakuNo(TextBoxCode txtJigyoshakeiyakuNo) {
        this.getPnlSearch().setTxtJigyoshakeiyakuNo(txtJigyoshakeiyakuNo);
    }

    @JsonIgnore
    public Button getBtnJigyoshakeiyakuSearch() {
        return this.getPnlSearch().getBtnJigyoshakeiyakuSearch();
    }

    @JsonIgnore
    public void  setBtnJigyoshakeiyakuSearch(Button btnJigyoshakeiyakuSearch) {
        this.getPnlSearch().setBtnJigyoshakeiyakuSearch(btnJigyoshakeiyakuSearch);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshakeiyakuName() {
        return this.getPnlSearch().getTxtJigyoshakeiyakuName();
    }

    @JsonIgnore
    public void  setTxtJigyoshakeiyakuName(TextBox txtJigyoshakeiyakuName) {
        this.getPnlSearch().setTxtJigyoshakeiyakuName(txtJigyoshakeiyakuName);
    }

    @JsonIgnore
    public DropDownList getDdlKeiyakuServiceShurui() {
        return this.getPnlSearch().getDdlKeiyakuServiceShurui();
    }

    @JsonIgnore
    public void  setDdlKeiyakuServiceShurui(DropDownList ddlKeiyakuServiceShurui) {
        this.getPnlSearch().setDdlKeiyakuServiceShurui(ddlKeiyakuServiceShurui);
    }

    @JsonIgnore
    public TextBoxYear getTxtYear() {
        return this.getPnlSearch().getTxtYear();
    }

    @JsonIgnore
    public void  setTxtYear(TextBoxYear txtYear) {
        this.getPnlSearch().setTxtYear(txtYear);
    }

    @JsonIgnore
    public TextBoxCode getTxtKeiyakuNo() {
        return this.getPnlSearch().getTxtKeiyakuNo();
    }

    @JsonIgnore
    public void  setTxtKeiyakuNo(TextBoxCode txtKeiyakuNo) {
        this.getPnlSearch().setTxtKeiyakuNo(txtKeiyakuNo);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getPnlSearch().getTxtMaxCount();
    }

    @JsonIgnore
    public void  setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getPnlSearch().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPnlSearch().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPnlSearch().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getPnlSearch().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getPnlSearch().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgKeyakusya_Row> getDgKeyakusya() {
        return this.getPnlKeiyakusyaList().getDgKeyakusya();
    }

    @JsonIgnore
    public void  setDgKeyakusya(DataGrid<dgKeyakusya_Row> dgKeyakusya) {
        this.getPnlKeiyakusyaList().setDgKeyakusya(dgKeyakusya);
    }

    @JsonIgnore
    public Button getBtnSearchAgain() {
        return this.getPnlKeiyakusyaList().getBtnSearchAgain();
    }

    @JsonIgnore
    public void  setBtnSearchAgain(Button btnSearchAgain) {
        this.getPnlKeiyakusyaList().setBtnSearchAgain(btnSearchAgain);
    }

    // </editor-fold>
}
