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
 * KensakuJoken のクラスファイル
 *
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-28_12-26-08">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJokenInput")
    private KensakuJokenInputDiv KensakuJokenInput;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("btnKensakku")
    private Button btnKensakku;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJokenInput
     * @return KensakuJokenInput
     */
    @JsonProperty("KensakuJokenInput")
    public KensakuJokenInputDiv getKensakuJokenInput() {
        return KensakuJokenInput;
    }

    /*
     * setKensakuJokenInput
     * @param KensakuJokenInput KensakuJokenInput
     */
    @JsonProperty("KensakuJokenInput")
    public void setKensakuJokenInput(KensakuJokenInputDiv KensakuJokenInput) {
        this.KensakuJokenInput = KensakuJokenInput;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getbtnKensakku
     * @return btnKensakku
     */
    @JsonProperty("btnKensakku")
    public Button getBtnKensakku() {
        return btnKensakku;
    }

    /*
     * setbtnKensakku
     * @param btnKensakku btnKensakku
     */
    @JsonProperty("btnKensakku")
    public void setBtnKensakku(Button btnKensakku) {
        this.btnKensakku = btnKensakku;
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
    public TextBoxCode getTxtShinsakaiIinCodeFrom() {
        return this.getKensakuJokenInput().getTxtShinsakaiIinCodeFrom();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIinCodeFrom(TextBoxCode txtShinsakaiIinCodeFrom) {
        this.getKensakuJokenInput().setTxtShinsakaiIinCodeFrom(txtShinsakaiIinCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtShinsakaiIinCodeTo() {
        return this.getKensakuJokenInput().getTxtShinsakaiIinCodeTo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIinCodeTo(TextBoxCode txtShinsakaiIinCodeTo) {
        this.getKensakuJokenInput().setTxtShinsakaiIinCodeTo(txtShinsakaiIinCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIinName() {
        return this.getKensakuJokenInput().getTxtShinsakaiIinName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIinName(TextBox txtShinsakaiIinName) {
        this.getKensakuJokenInput().setTxtShinsakaiIinName(txtShinsakaiIinName);
    }

    @JsonIgnore
    public DropDownList getDdlSeibetsu() {
        return this.getKensakuJokenInput().getDdlSeibetsu();
    }

    @JsonIgnore
    public void  setDdlSeibetsu(DropDownList ddlSeibetsu) {
        this.getKensakuJokenInput().setDdlSeibetsu(ddlSeibetsu);
    }

    @JsonIgnore
    public DropDownList getDdlShinsainShikakuCode() {
        return this.getKensakuJokenInput().getDdlShinsainShikakuCode();
    }

    @JsonIgnore
    public void  setDdlShinsainShikakuCode(DropDownList ddlShinsainShikakuCode) {
        this.getKensakuJokenInput().setDdlShinsainShikakuCode(ddlShinsainShikakuCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunbi() {
        return this.getKensakuJokenInput().getTxtKijunbi();
    }

    @JsonIgnore
    public void  setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.getKensakuJokenInput().setTxtKijunbi(txtKijunbi);
    }

    @JsonIgnore
    public RadioButton getRadKikan() {
        return this.getKensakuJokenInput().getRadKikan();
    }

    @JsonIgnore
    public void  setRadKikan(RadioButton radKikan) {
        this.getKensakuJokenInput().setRadKikan(radKikan);
    }

    @JsonIgnore
    public CheckBoxList getChkHaishi() {
        return this.getKensakuJokenInput().getChkHaishi();
    }

    @JsonIgnore
    public void  setChkHaishi(CheckBoxList chkHaishi) {
        this.getKensakuJokenInput().setChkHaishi(chkHaishi);
    }

    @JsonIgnore
    public pnlShosaiJokenDiv getPnlShosaiJoken() {
        return this.getKensakuJokenInput().getPnlShosaiJoken();
    }

    @JsonIgnore
    public void  setPnlShosaiJoken(pnlShosaiJokenDiv pnlShosaiJoken) {
        this.getKensakuJokenInput().setPnlShosaiJoken(pnlShosaiJoken);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensha() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getCcdHokensha();
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiCode() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getTxtChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiCode(TextBox txtChosaItakusakiCode) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setTxtChosaItakusakiCode(txtChosaItakusakiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaItakusaki() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getBtnChosaItakusaki();
    }

    @JsonIgnore
    public void  setBtnChosaItakusaki(ButtonDialog btnChosaItakusaki) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setBtnChosaItakusaki(btnChosaItakusaki);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiName() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getTxtChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setTxtChosaItakusakiName(txtChosaItakusakiName);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanCode() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCode(TextBox txtIryoKikanCode) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnIryoKikan() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getBtnIryoKikan();
    }

    @JsonIgnore
    public void  setBtnIryoKikan(ButtonDialog btnIryoKikan) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setBtnIryoKikan(btnIryoKikan);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanName() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getTxtIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setTxtIryoKikanName(txtIryoKikanName);
    }

    @JsonIgnore
    public TextBox getTxtSonotaJigyoshaCode() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getTxtSonotaJigyoshaCode();
    }

    @JsonIgnore
    public void  setTxtSonotaJigyoshaCode(TextBox txtSonotaJigyoshaCode) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setTxtSonotaJigyoshaCode(txtSonotaJigyoshaCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnSonotaJigyosha() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getBtnSonotaJigyosha();
    }

    @JsonIgnore
    public void  setBtnSonotaJigyosha(ButtonDialog btnSonotaJigyosha) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setBtnSonotaJigyosha(btnSonotaJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtSonotaJigyoshaName() {
        return this.getKensakuJokenInput().getPnlShosaiJoken().getTxtSonotaJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtSonotaJigyoshaName(TextBox txtSonotaJigyoshaName) {
        this.getKensakuJokenInput().getPnlShosaiJoken().setTxtSonotaJigyoshaName(txtSonotaJigyoshaName);
    }

    // </editor-fold>
}
