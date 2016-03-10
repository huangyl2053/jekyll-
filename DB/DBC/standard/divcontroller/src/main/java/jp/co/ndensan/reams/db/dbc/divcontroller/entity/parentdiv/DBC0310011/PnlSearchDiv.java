package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PnlSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("btnHihokensyaSearch")
    private Button btnHihokensyaSearch;
    @JsonProperty("txtName")
    private TextBox txtName;
    @JsonProperty("txtShinseiYMDRange")
    private TextBoxDateRange txtShinseiYMDRange;
    @JsonProperty("txtKetteYMDRange")
    private TextBoxDateRange txtKetteYMDRange;
    @JsonProperty("txtJigyoshakeiyakuNo")
    private TextBoxCode txtJigyoshakeiyakuNo;
    @JsonProperty("btnJigyoshakeiyakuSearch")
    private Button btnJigyoshakeiyakuSearch;
    @JsonProperty("txtJigyoshakeiyakuName")
    private TextBox txtJigyoshakeiyakuName;
    @JsonProperty("ddlKeiyakuServiceShurui")
    private DropDownList ddlKeiyakuServiceShurui;
    @JsonProperty("txtYear")
    private TextBoxYear txtYear;
    @JsonProperty("txtKeiyakuNo")
    private TextBoxCode txtKeiyakuNo;
    @JsonProperty("txtMaxCount")
    private TextBoxNum txtMaxCount;
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
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnHihokensyaSearch
     * @return btnHihokensyaSearch
     */
    @JsonProperty("btnHihokensyaSearch")
    public Button getBtnHihokensyaSearch() {
        return btnHihokensyaSearch;
    }

    /*
     * setbtnHihokensyaSearch
     * @param btnHihokensyaSearch btnHihokensyaSearch
     */
    @JsonProperty("btnHihokensyaSearch")
    public void setBtnHihokensyaSearch(Button btnHihokensyaSearch) {
        this.btnHihokensyaSearch = btnHihokensyaSearch;
    }

    /*
     * gettxtName
     * @return txtName
     */
    @JsonProperty("txtName")
    public TextBox getTxtName() {
        return txtName;
    }

    /*
     * settxtName
     * @param txtName txtName
     */
    @JsonProperty("txtName")
    public void setTxtName(TextBox txtName) {
        this.txtName = txtName;
    }

    /*
     * gettxtShinseiYMDRange
     * @return txtShinseiYMDRange
     */
    @JsonProperty("txtShinseiYMDRange")
    public TextBoxDateRange getTxtShinseiYMDRange() {
        return txtShinseiYMDRange;
    }

    /*
     * settxtShinseiYMDRange
     * @param txtShinseiYMDRange txtShinseiYMDRange
     */
    @JsonProperty("txtShinseiYMDRange")
    public void setTxtShinseiYMDRange(TextBoxDateRange txtShinseiYMDRange) {
        this.txtShinseiYMDRange = txtShinseiYMDRange;
    }

    /*
     * gettxtKetteYMDRange
     * @return txtKetteYMDRange
     */
    @JsonProperty("txtKetteYMDRange")
    public TextBoxDateRange getTxtKetteYMDRange() {
        return txtKetteYMDRange;
    }

    /*
     * settxtKetteYMDRange
     * @param txtKetteYMDRange txtKetteYMDRange
     */
    @JsonProperty("txtKetteYMDRange")
    public void setTxtKetteYMDRange(TextBoxDateRange txtKetteYMDRange) {
        this.txtKetteYMDRange = txtKetteYMDRange;
    }

    /*
     * gettxtJigyoshakeiyakuNo
     * @return txtJigyoshakeiyakuNo
     */
    @JsonProperty("txtJigyoshakeiyakuNo")
    public TextBoxCode getTxtJigyoshakeiyakuNo() {
        return txtJigyoshakeiyakuNo;
    }

    /*
     * settxtJigyoshakeiyakuNo
     * @param txtJigyoshakeiyakuNo txtJigyoshakeiyakuNo
     */
    @JsonProperty("txtJigyoshakeiyakuNo")
    public void setTxtJigyoshakeiyakuNo(TextBoxCode txtJigyoshakeiyakuNo) {
        this.txtJigyoshakeiyakuNo = txtJigyoshakeiyakuNo;
    }

    /*
     * getbtnJigyoshakeiyakuSearch
     * @return btnJigyoshakeiyakuSearch
     */
    @JsonProperty("btnJigyoshakeiyakuSearch")
    public Button getBtnJigyoshakeiyakuSearch() {
        return btnJigyoshakeiyakuSearch;
    }

    /*
     * setbtnJigyoshakeiyakuSearch
     * @param btnJigyoshakeiyakuSearch btnJigyoshakeiyakuSearch
     */
    @JsonProperty("btnJigyoshakeiyakuSearch")
    public void setBtnJigyoshakeiyakuSearch(Button btnJigyoshakeiyakuSearch) {
        this.btnJigyoshakeiyakuSearch = btnJigyoshakeiyakuSearch;
    }

    /*
     * gettxtJigyoshakeiyakuName
     * @return txtJigyoshakeiyakuName
     */
    @JsonProperty("txtJigyoshakeiyakuName")
    public TextBox getTxtJigyoshakeiyakuName() {
        return txtJigyoshakeiyakuName;
    }

    /*
     * settxtJigyoshakeiyakuName
     * @param txtJigyoshakeiyakuName txtJigyoshakeiyakuName
     */
    @JsonProperty("txtJigyoshakeiyakuName")
    public void setTxtJigyoshakeiyakuName(TextBox txtJigyoshakeiyakuName) {
        this.txtJigyoshakeiyakuName = txtJigyoshakeiyakuName;
    }

    /*
     * getddlKeiyakuServiceShurui
     * @return ddlKeiyakuServiceShurui
     */
    @JsonProperty("ddlKeiyakuServiceShurui")
    public DropDownList getDdlKeiyakuServiceShurui() {
        return ddlKeiyakuServiceShurui;
    }

    /*
     * setddlKeiyakuServiceShurui
     * @param ddlKeiyakuServiceShurui ddlKeiyakuServiceShurui
     */
    @JsonProperty("ddlKeiyakuServiceShurui")
    public void setDdlKeiyakuServiceShurui(DropDownList ddlKeiyakuServiceShurui) {
        this.ddlKeiyakuServiceShurui = ddlKeiyakuServiceShurui;
    }

    /*
     * gettxtYear
     * @return txtYear
     */
    @JsonProperty("txtYear")
    public TextBoxYear getTxtYear() {
        return txtYear;
    }

    /*
     * settxtYear
     * @param txtYear txtYear
     */
    @JsonProperty("txtYear")
    public void setTxtYear(TextBoxYear txtYear) {
        this.txtYear = txtYear;
    }

    /*
     * gettxtKeiyakuNo
     * @return txtKeiyakuNo
     */
    @JsonProperty("txtKeiyakuNo")
    public TextBoxCode getTxtKeiyakuNo() {
        return txtKeiyakuNo;
    }

    /*
     * settxtKeiyakuNo
     * @param txtKeiyakuNo txtKeiyakuNo
     */
    @JsonProperty("txtKeiyakuNo")
    public void setTxtKeiyakuNo(TextBoxCode txtKeiyakuNo) {
        this.txtKeiyakuNo = txtKeiyakuNo;
    }

    /*
     * gettxtMaxCount
     * @return txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public TextBoxNum getTxtMaxCount() {
        return txtMaxCount;
    }

    /*
     * settxtMaxCount
     * @param txtMaxCount txtMaxCount
     */
    @JsonProperty("txtMaxCount")
    public void setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.txtMaxCount = txtMaxCount;
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

    // </editor-fold>
}
