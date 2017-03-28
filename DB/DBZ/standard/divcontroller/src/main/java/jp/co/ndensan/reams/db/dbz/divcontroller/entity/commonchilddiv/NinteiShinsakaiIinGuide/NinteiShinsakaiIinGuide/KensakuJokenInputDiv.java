package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJokenInput のクラスファイル 
 * 
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public class KensakuJokenInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiIinCodeFrom")
    private TextBoxCode txtShinsakaiIinCodeFrom;
    @JsonProperty("txtShinsakaiIinCodeTo")
    private TextBoxCode txtShinsakaiIinCodeTo;
    @JsonProperty("txtShinsakaiIinName")
    private TextBox txtShinsakaiIinName;
    @JsonProperty("ddlSeibetsu")
    private DropDownList ddlSeibetsu;
    @JsonProperty("ddlShinsainShikakuCode")
    private DropDownList ddlShinsainShikakuCode;
    @JsonProperty("txtKijunbi")
    private TextBoxDate txtKijunbi;
    @JsonProperty("radKikan")
    private RadioButton radKikan;
    @JsonProperty("chkHaishi")
    private CheckBoxList chkHaishi;
    @JsonProperty("pnlShosaiJoken")
    private pnlShosaiJokenDiv pnlShosaiJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getddlSeibetsu
     * @return ddlSeibetsu
     */
    @JsonProperty("ddlSeibetsu")
    public DropDownList getDdlSeibetsu() {
        return ddlSeibetsu;
    }

    /*
     * setddlSeibetsu
     * @param ddlSeibetsu ddlSeibetsu
     */
    @JsonProperty("ddlSeibetsu")
    public void setDdlSeibetsu(DropDownList ddlSeibetsu) {
        this.ddlSeibetsu = ddlSeibetsu;
    }

    /*
     * getddlShinsainShikakuCode
     * @return ddlShinsainShikakuCode
     */
    @JsonProperty("ddlShinsainShikakuCode")
    public DropDownList getDdlShinsainShikakuCode() {
        return ddlShinsainShikakuCode;
    }

    /*
     * setddlShinsainShikakuCode
     * @param ddlShinsainShikakuCode ddlShinsainShikakuCode
     */
    @JsonProperty("ddlShinsainShikakuCode")
    public void setDdlShinsainShikakuCode(DropDownList ddlShinsainShikakuCode) {
        this.ddlShinsainShikakuCode = ddlShinsainShikakuCode;
    }

    /*
     * gettxtKijunbi
     * @return txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public TextBoxDate getTxtKijunbi() {
        return txtKijunbi;
    }

    /*
     * settxtKijunbi
     * @param txtKijunbi txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public void setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.txtKijunbi = txtKijunbi;
    }

    /*
     * getradKikan
     * @return radKikan
     */
    @JsonProperty("radKikan")
    public RadioButton getRadKikan() {
        return radKikan;
    }

    /*
     * setradKikan
     * @param radKikan radKikan
     */
    @JsonProperty("radKikan")
    public void setRadKikan(RadioButton radKikan) {
        this.radKikan = radKikan;
    }

    /*
     * getchkHaishi
     * @return chkHaishi
     */
    @JsonProperty("chkHaishi")
    public CheckBoxList getChkHaishi() {
        return chkHaishi;
    }

    /*
     * setchkHaishi
     * @param chkHaishi chkHaishi
     */
    @JsonProperty("chkHaishi")
    public void setChkHaishi(CheckBoxList chkHaishi) {
        this.chkHaishi = chkHaishi;
    }

    /*
     * getpnlShosaiJoken
     * @return pnlShosaiJoken
     */
    @JsonProperty("pnlShosaiJoken")
    public pnlShosaiJokenDiv getPnlShosaiJoken() {
        return pnlShosaiJoken;
    }

    /*
     * setpnlShosaiJoken
     * @param pnlShosaiJoken pnlShosaiJoken
     */
    @JsonProperty("pnlShosaiJoken")
    public void setPnlShosaiJoken(pnlShosaiJokenDiv pnlShosaiJoken) {
        this.pnlShosaiJoken = pnlShosaiJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getCcdHokensha() {
        return this.getPnlShosaiJoken().getCcdHokensha();
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiCode() {
        return this.getPnlShosaiJoken().getTxtChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiCode(TextBox txtChosaItakusakiCode) {
        this.getPnlShosaiJoken().setTxtChosaItakusakiCode(txtChosaItakusakiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaItakusaki() {
        return this.getPnlShosaiJoken().getBtnChosaItakusaki();
    }

    @JsonIgnore
    public void  setBtnChosaItakusaki(ButtonDialog btnChosaItakusaki) {
        this.getPnlShosaiJoken().setBtnChosaItakusaki(btnChosaItakusaki);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiName() {
        return this.getPnlShosaiJoken().getTxtChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.getPnlShosaiJoken().setTxtChosaItakusakiName(txtChosaItakusakiName);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanCode() {
        return this.getPnlShosaiJoken().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCode(TextBox txtIryoKikanCode) {
        this.getPnlShosaiJoken().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnIryoKikan() {
        return this.getPnlShosaiJoken().getBtnIryoKikan();
    }

    @JsonIgnore
    public void  setBtnIryoKikan(ButtonDialog btnIryoKikan) {
        this.getPnlShosaiJoken().setBtnIryoKikan(btnIryoKikan);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanName() {
        return this.getPnlShosaiJoken().getTxtIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.getPnlShosaiJoken().setTxtIryoKikanName(txtIryoKikanName);
    }

    @JsonIgnore
    public TextBox getTxtSonotaJigyoshaCode() {
        return this.getPnlShosaiJoken().getTxtSonotaJigyoshaCode();
    }

    @JsonIgnore
    public void  setTxtSonotaJigyoshaCode(TextBox txtSonotaJigyoshaCode) {
        this.getPnlShosaiJoken().setTxtSonotaJigyoshaCode(txtSonotaJigyoshaCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnSonotaJigyosha() {
        return this.getPnlShosaiJoken().getBtnSonotaJigyosha();
    }

    @JsonIgnore
    public void  setBtnSonotaJigyosha(ButtonDialog btnSonotaJigyosha) {
        this.getPnlShosaiJoken().setBtnSonotaJigyosha(btnSonotaJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtSonotaJigyoshaName() {
        return this.getPnlShosaiJoken().getTxtSonotaJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtSonotaJigyoshaName(TextBox txtSonotaJigyoshaName) {
        this.getPnlShosaiJoken().setTxtSonotaJigyoshaName(txtSonotaJigyoshaName);
    }

    // </editor-fold>
}
