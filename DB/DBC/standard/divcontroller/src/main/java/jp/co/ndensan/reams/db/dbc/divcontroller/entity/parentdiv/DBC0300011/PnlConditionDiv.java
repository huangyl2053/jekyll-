package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlConditionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("rdoBango")
    private RadioButton rdoBango;
    @JsonProperty("txtJigyosyakeyakuNo")
    private TextBoxNum txtJigyosyakeyakuNo;
    @JsonProperty("rdoMeisyo")
    private RadioButton rdoMeisyo;
    @JsonProperty("rdoJyusyo")
    private RadioButton rdoJyusyo;
    @JsonProperty("txtMeisyoKana")
    private TextBoxKana txtMeisyoKana;
    @JsonProperty("chkMeisyoKana")
    private CheckBoxList chkMeisyoKana;
    @JsonProperty("txtYubin")
    private TextBoxYubinNo txtYubin;
    @JsonProperty("txtMeisyoKanji")
    private TextBox txtMeisyoKanji;
    @JsonProperty("chkMeisyoKanji")
    private CheckBoxList chkMeisyoKanji;
    @JsonProperty("txtJyusyoKanji")
    private TextBox txtJyusyoKanji;
    @JsonProperty("chkJyusyoKanji")
    private CheckBoxList chkJyusyoKanji;
    @JsonProperty("ddlKeiyakuSyurui")
    private DropDownList ddlKeiyakuSyurui;
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
     * getrdoBango
     * @return rdoBango
     */
    @JsonProperty("rdoBango")
    public RadioButton getRdoBango() {
        return rdoBango;
    }

    /*
     * setrdoBango
     * @param rdoBango rdoBango
     */
    @JsonProperty("rdoBango")
    public void setRdoBango(RadioButton rdoBango) {
        this.rdoBango = rdoBango;
    }

    /*
     * gettxtJigyosyakeyakuNo
     * @return txtJigyosyakeyakuNo
     */
    @JsonProperty("txtJigyosyakeyakuNo")
    public TextBoxNum getTxtJigyosyakeyakuNo() {
        return txtJigyosyakeyakuNo;
    }

    /*
     * settxtJigyosyakeyakuNo
     * @param txtJigyosyakeyakuNo txtJigyosyakeyakuNo
     */
    @JsonProperty("txtJigyosyakeyakuNo")
    public void setTxtJigyosyakeyakuNo(TextBoxNum txtJigyosyakeyakuNo) {
        this.txtJigyosyakeyakuNo = txtJigyosyakeyakuNo;
    }

    /*
     * getrdoMeisyo
     * @return rdoMeisyo
     */
    @JsonProperty("rdoMeisyo")
    public RadioButton getRdoMeisyo() {
        return rdoMeisyo;
    }

    /*
     * setrdoMeisyo
     * @param rdoMeisyo rdoMeisyo
     */
    @JsonProperty("rdoMeisyo")
    public void setRdoMeisyo(RadioButton rdoMeisyo) {
        this.rdoMeisyo = rdoMeisyo;
    }

    /*
     * getrdoJyusyo
     * @return rdoJyusyo
     */
    @JsonProperty("rdoJyusyo")
    public RadioButton getRdoJyusyo() {
        return rdoJyusyo;
    }

    /*
     * setrdoJyusyo
     * @param rdoJyusyo rdoJyusyo
     */
    @JsonProperty("rdoJyusyo")
    public void setRdoJyusyo(RadioButton rdoJyusyo) {
        this.rdoJyusyo = rdoJyusyo;
    }

    /*
     * gettxtMeisyoKana
     * @return txtMeisyoKana
     */
    @JsonProperty("txtMeisyoKana")
    public TextBoxKana getTxtMeisyoKana() {
        return txtMeisyoKana;
    }

    /*
     * settxtMeisyoKana
     * @param txtMeisyoKana txtMeisyoKana
     */
    @JsonProperty("txtMeisyoKana")
    public void setTxtMeisyoKana(TextBoxKana txtMeisyoKana) {
        this.txtMeisyoKana = txtMeisyoKana;
    }

    /*
     * getchkMeisyoKana
     * @return chkMeisyoKana
     */
    @JsonProperty("chkMeisyoKana")
    public CheckBoxList getChkMeisyoKana() {
        return chkMeisyoKana;
    }

    /*
     * setchkMeisyoKana
     * @param chkMeisyoKana chkMeisyoKana
     */
    @JsonProperty("chkMeisyoKana")
    public void setChkMeisyoKana(CheckBoxList chkMeisyoKana) {
        this.chkMeisyoKana = chkMeisyoKana;
    }

    /*
     * gettxtYubin
     * @return txtYubin
     */
    @JsonProperty("txtYubin")
    public TextBoxYubinNo getTxtYubin() {
        return txtYubin;
    }

    /*
     * settxtYubin
     * @param txtYubin txtYubin
     */
    @JsonProperty("txtYubin")
    public void setTxtYubin(TextBoxYubinNo txtYubin) {
        this.txtYubin = txtYubin;
    }

    /*
     * gettxtMeisyoKanji
     * @return txtMeisyoKanji
     */
    @JsonProperty("txtMeisyoKanji")
    public TextBox getTxtMeisyoKanji() {
        return txtMeisyoKanji;
    }

    /*
     * settxtMeisyoKanji
     * @param txtMeisyoKanji txtMeisyoKanji
     */
    @JsonProperty("txtMeisyoKanji")
    public void setTxtMeisyoKanji(TextBox txtMeisyoKanji) {
        this.txtMeisyoKanji = txtMeisyoKanji;
    }

    /*
     * getchkMeisyoKanji
     * @return chkMeisyoKanji
     */
    @JsonProperty("chkMeisyoKanji")
    public CheckBoxList getChkMeisyoKanji() {
        return chkMeisyoKanji;
    }

    /*
     * setchkMeisyoKanji
     * @param chkMeisyoKanji chkMeisyoKanji
     */
    @JsonProperty("chkMeisyoKanji")
    public void setChkMeisyoKanji(CheckBoxList chkMeisyoKanji) {
        this.chkMeisyoKanji = chkMeisyoKanji;
    }

    /*
     * gettxtJyusyoKanji
     * @return txtJyusyoKanji
     */
    @JsonProperty("txtJyusyoKanji")
    public TextBox getTxtJyusyoKanji() {
        return txtJyusyoKanji;
    }

    /*
     * settxtJyusyoKanji
     * @param txtJyusyoKanji txtJyusyoKanji
     */
    @JsonProperty("txtJyusyoKanji")
    public void setTxtJyusyoKanji(TextBox txtJyusyoKanji) {
        this.txtJyusyoKanji = txtJyusyoKanji;
    }

    /*
     * getchkJyusyoKanji
     * @return chkJyusyoKanji
     */
    @JsonProperty("chkJyusyoKanji")
    public CheckBoxList getChkJyusyoKanji() {
        return chkJyusyoKanji;
    }

    /*
     * setchkJyusyoKanji
     * @param chkJyusyoKanji chkJyusyoKanji
     */
    @JsonProperty("chkJyusyoKanji")
    public void setChkJyusyoKanji(CheckBoxList chkJyusyoKanji) {
        this.chkJyusyoKanji = chkJyusyoKanji;
    }

    /*
     * getddlKeiyakuSyurui
     * @return ddlKeiyakuSyurui
     */
    @JsonProperty("ddlKeiyakuSyurui")
    public DropDownList getDdlKeiyakuSyurui() {
        return ddlKeiyakuSyurui;
    }

    /*
     * setddlKeiyakuSyurui
     * @param ddlKeiyakuSyurui ddlKeiyakuSyurui
     */
    @JsonProperty("ddlKeiyakuSyurui")
    public void setDdlKeiyakuSyurui(DropDownList ddlKeiyakuSyurui) {
        this.ddlKeiyakuSyurui = ddlKeiyakuSyurui;
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
