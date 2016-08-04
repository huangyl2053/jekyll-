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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("ShosaiJoken")
    private ShosaiJokenDiv ShosaiJoken;

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
     * getShosaiJoken
     * @return ShosaiJoken
     */
    @JsonProperty("ShosaiJoken")
    public ShosaiJokenDiv getShosaiJoken() {
        return ShosaiJoken;
    }

    /*
     * setShosaiJoken
     * @param ShosaiJoken ShosaiJoken
     */
    @JsonProperty("ShosaiJoken")
    public void setShosaiJoken(ShosaiJokenDiv ShosaiJoken) {
        this.ShosaiJoken = ShosaiJoken;
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
    public IHokenshaListDiv getCcdHokensha() {
        return this.getKensakuJokenInput().getCcdHokensha();
    }

    @JsonIgnore
    public Label getLblShozoku() {
        return this.getShosaiJoken().getLblShozoku();
    }

    @JsonIgnore
    public void  setLblShozoku(Label lblShozoku) {
        this.getShosaiJoken().setLblShozoku(lblShozoku);
    }

    @JsonIgnore
    public DropDownList getDdlIryoKikan() {
        return this.getShosaiJoken().getDdlIryoKikan();
    }

    @JsonIgnore
    public void  setDdlIryoKikan(DropDownList ddlIryoKikan) {
        this.getShosaiJoken().setDdlIryoKikan(ddlIryoKikan);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoJigyosha() {
        return this.getShosaiJoken().getDdlKaigoJigyosha();
    }

    @JsonIgnore
    public void  setDdlKaigoJigyosha(DropDownList ddlKaigoJigyosha) {
        this.getShosaiJoken().setDdlKaigoJigyosha(ddlKaigoJigyosha);
    }

    @JsonIgnore
    public DropDownList getDdlSonotaJigyosha() {
        return this.getShosaiJoken().getDdlSonotaJigyosha();
    }

    @JsonIgnore
    public void  setDdlSonotaJigyosha(DropDownList ddlSonotaJigyosha) {
        this.getShosaiJoken().setDdlSonotaJigyosha(ddlSonotaJigyosha);
    }

    @JsonIgnore
    public CheckBoxList getChkKiken() {
        return this.getShosaiJoken().getChkKiken();
    }

    @JsonIgnore
    public void  setChkKiken(CheckBoxList chkKiken) {
        this.getShosaiJoken().setChkKiken(chkKiken);
    }

    @JsonIgnore
    public CheckBoxList getChkHaishi() {
        return this.getShosaiJoken().getChkHaishi();
    }

    @JsonIgnore
    public void  setChkHaishi(CheckBoxList chkHaishi) {
        this.getShosaiJoken().setChkHaishi(chkHaishi);
    }

    // </editor-fold>
}
