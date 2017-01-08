package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHyojiJoken")
    private RadioButton radHyojiJoken;
    @JsonProperty("txtShinsakaiIinCodeFrom")
    private TextBoxCode txtShinsakaiIinCodeFrom;
    @JsonProperty("txtShinsakaiIinCodeTo")
    private TextBoxCode txtShinsakaiIinCodeTo;
    @JsonProperty("ddlShinsainShikakuMeisho")
    private DropDownList ddlShinsainShikakuMeisho;
    @JsonProperty("txtShinsakaiIinName")
    private TextBox txtShinsakaiIinName;
    @JsonProperty("ddlShinsakaiIinMeisho")
    private DropDownList ddlShinsakaiIinMeisho;
    @JsonProperty("txtShinsakaiIinKanaName")
    private TextBoxKana txtShinsakaiIinKanaName;
    @JsonProperty("ddlShinsakaiIinKanaMeisho")
    private DropDownList ddlShinsakaiIinKanaMeisho;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("txtDispMax")
    private TextBoxNum txtDispMax;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHyojiJoken
     * @return radHyojiJoken
     */
    @JsonProperty("radHyojiJoken")
    public RadioButton getRadHyojiJoken() {
        return radHyojiJoken;
    }

    /*
     * setradHyojiJoken
     * @param radHyojiJoken radHyojiJoken
     */
    @JsonProperty("radHyojiJoken")
    public void setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.radHyojiJoken = radHyojiJoken;
    }

    /*
     * gettxtShinsakaiIinCodeFrom
     * @return txtShinsakaiIinCodeFrom
     */
    @JsonProperty("txtShinsakaiIinCodeFrom")
    public TextBoxCode getTxtShinsakaiIinCodeFrom() {
        return txtShinsakaiIinCodeFrom;
    }

    /*
     * settxtShinsakaiIinCodeFrom
     * @param txtShinsakaiIinCodeFrom txtShinsakaiIinCodeFrom
     */
    @JsonProperty("txtShinsakaiIinCodeFrom")
    public void setTxtShinsakaiIinCodeFrom(TextBoxCode txtShinsakaiIinCodeFrom) {
        this.txtShinsakaiIinCodeFrom = txtShinsakaiIinCodeFrom;
    }

    /*
     * gettxtShinsakaiIinCodeTo
     * @return txtShinsakaiIinCodeTo
     */
    @JsonProperty("txtShinsakaiIinCodeTo")
    public TextBoxCode getTxtShinsakaiIinCodeTo() {
        return txtShinsakaiIinCodeTo;
    }

    /*
     * settxtShinsakaiIinCodeTo
     * @param txtShinsakaiIinCodeTo txtShinsakaiIinCodeTo
     */
    @JsonProperty("txtShinsakaiIinCodeTo")
    public void setTxtShinsakaiIinCodeTo(TextBoxCode txtShinsakaiIinCodeTo) {
        this.txtShinsakaiIinCodeTo = txtShinsakaiIinCodeTo;
    }

    /*
     * getddlShinsainShikakuMeisho
     * @return ddlShinsainShikakuMeisho
     */
    @JsonProperty("ddlShinsainShikakuMeisho")
    public DropDownList getDdlShinsainShikakuMeisho() {
        return ddlShinsainShikakuMeisho;
    }

    /*
     * setddlShinsainShikakuMeisho
     * @param ddlShinsainShikakuMeisho ddlShinsainShikakuMeisho
     */
    @JsonProperty("ddlShinsainShikakuMeisho")
    public void setDdlShinsainShikakuMeisho(DropDownList ddlShinsainShikakuMeisho) {
        this.ddlShinsainShikakuMeisho = ddlShinsainShikakuMeisho;
    }

    /*
     * gettxtShinsakaiIinName
     * @return txtShinsakaiIinName
     */
    @JsonProperty("txtShinsakaiIinName")
    public TextBox getTxtShinsakaiIinName() {
        return txtShinsakaiIinName;
    }

    /*
     * settxtShinsakaiIinName
     * @param txtShinsakaiIinName txtShinsakaiIinName
     */
    @JsonProperty("txtShinsakaiIinName")
    public void setTxtShinsakaiIinName(TextBox txtShinsakaiIinName) {
        this.txtShinsakaiIinName = txtShinsakaiIinName;
    }

    /*
     * getddlShinsakaiIinMeisho
     * @return ddlShinsakaiIinMeisho
     */
    @JsonProperty("ddlShinsakaiIinMeisho")
    public DropDownList getDdlShinsakaiIinMeisho() {
        return ddlShinsakaiIinMeisho;
    }

    /*
     * setddlShinsakaiIinMeisho
     * @param ddlShinsakaiIinMeisho ddlShinsakaiIinMeisho
     */
    @JsonProperty("ddlShinsakaiIinMeisho")
    public void setDdlShinsakaiIinMeisho(DropDownList ddlShinsakaiIinMeisho) {
        this.ddlShinsakaiIinMeisho = ddlShinsakaiIinMeisho;
    }

    /*
     * gettxtShinsakaiIinKanaName
     * @return txtShinsakaiIinKanaName
     */
    @JsonProperty("txtShinsakaiIinKanaName")
    public TextBoxKana getTxtShinsakaiIinKanaName() {
        return txtShinsakaiIinKanaName;
    }

    /*
     * settxtShinsakaiIinKanaName
     * @param txtShinsakaiIinKanaName txtShinsakaiIinKanaName
     */
    @JsonProperty("txtShinsakaiIinKanaName")
    public void setTxtShinsakaiIinKanaName(TextBoxKana txtShinsakaiIinKanaName) {
        this.txtShinsakaiIinKanaName = txtShinsakaiIinKanaName;
    }

    /*
     * getddlShinsakaiIinKanaMeisho
     * @return ddlShinsakaiIinKanaMeisho
     */
    @JsonProperty("ddlShinsakaiIinKanaMeisho")
    public DropDownList getDdlShinsakaiIinKanaMeisho() {
        return ddlShinsakaiIinKanaMeisho;
    }

    /*
     * setddlShinsakaiIinKanaMeisho
     * @param ddlShinsakaiIinKanaMeisho ddlShinsakaiIinKanaMeisho
     */
    @JsonProperty("ddlShinsakaiIinKanaMeisho")
    public void setDdlShinsakaiIinKanaMeisho(DropDownList ddlShinsakaiIinKanaMeisho) {
        this.ddlShinsakaiIinKanaMeisho = ddlShinsakaiIinKanaMeisho;
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
     * gettxtDispMax
     * @return txtDispMax
     */
    @JsonProperty("txtDispMax")
    public TextBoxNum getTxtDispMax() {
        return txtDispMax;
    }

    /*
     * settxtDispMax
     * @param txtDispMax txtDispMax
     */
    @JsonProperty("txtDispMax")
    public void setTxtDispMax(TextBoxNum txtDispMax) {
        this.txtDispMax = txtDispMax;
    }

    // </editor-fold>
}
