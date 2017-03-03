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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * NinteiShinsakaiIinGuide のクラスファイル
 *
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public class NinteiShinsakaiIinGuideDiv extends Panel implements INinteiShinsakaiIinGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-28_12-26-08">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinsakaiIinIchiran")
    private ShinsakaiIinIchiranDiv ShinsakaiIinIchiran;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnSaikensaku")
    private Button btnSaikensaku;
    @JsonProperty("hdnShinsakaiIinCode")
    private RString hdnShinsakaiIinCode;
    @JsonProperty("hdnShinsakaiIinName")
    private RString hdnShinsakaiIinName;
    @JsonProperty("hiddenMode")
    private RString hiddenMode;
    @JsonProperty("hiddenKijunYMD")
    private RString hiddenKijunYMD;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getShinsakaiIinIchiran
     * @return ShinsakaiIinIchiran
     */
    @JsonProperty("ShinsakaiIinIchiran")
    public ShinsakaiIinIchiranDiv getShinsakaiIinIchiran() {
        return ShinsakaiIinIchiran;
    }

    /*
     * setShinsakaiIinIchiran
     * @param ShinsakaiIinIchiran ShinsakaiIinIchiran
     */
    @JsonProperty("ShinsakaiIinIchiran")
    public void setShinsakaiIinIchiran(ShinsakaiIinIchiranDiv ShinsakaiIinIchiran) {
        this.ShinsakaiIinIchiran = ShinsakaiIinIchiran;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * getbtnSaikensaku
     * @return btnSaikensaku
     */
    @JsonProperty("btnSaikensaku")
    public Button getBtnSaikensaku() {
        return btnSaikensaku;
    }

    /*
     * setbtnSaikensaku
     * @param btnSaikensaku btnSaikensaku
     */
    @JsonProperty("btnSaikensaku")
    public void setBtnSaikensaku(Button btnSaikensaku) {
        this.btnSaikensaku = btnSaikensaku;
    }

    /*
     * gethdnShinsakaiIinCode
     * @return hdnShinsakaiIinCode
     */
    @JsonProperty("hdnShinsakaiIinCode")
    public RString getHdnShinsakaiIinCode() {
        return hdnShinsakaiIinCode;
    }

    /*
     * sethdnShinsakaiIinCode
     * @param hdnShinsakaiIinCode hdnShinsakaiIinCode
     */
    @JsonProperty("hdnShinsakaiIinCode")
    public void setHdnShinsakaiIinCode(RString hdnShinsakaiIinCode) {
        this.hdnShinsakaiIinCode = hdnShinsakaiIinCode;
    }

    /*
     * gethdnShinsakaiIinName
     * @return hdnShinsakaiIinName
     */
    @JsonProperty("hdnShinsakaiIinName")
    public RString getHdnShinsakaiIinName() {
        return hdnShinsakaiIinName;
    }

    /*
     * sethdnShinsakaiIinName
     * @param hdnShinsakaiIinName hdnShinsakaiIinName
     */
    @JsonProperty("hdnShinsakaiIinName")
    public void setHdnShinsakaiIinName(RString hdnShinsakaiIinName) {
        this.hdnShinsakaiIinName = hdnShinsakaiIinName;
    }

    /*
     * gethiddenMode
     * @return hiddenMode
     */
    @JsonProperty("hiddenMode")
    public RString getHiddenMode() {
        return hiddenMode;
    }

    /*
     * sethiddenMode
     * @param hiddenMode hiddenMode
     */
    @JsonProperty("hiddenMode")
    public void setHiddenMode(RString hiddenMode) {
        this.hiddenMode = hiddenMode;
    }

    /*
     * gethiddenKijunYMD
     * @return hiddenKijunYMD
     */
    @JsonProperty("hiddenKijunYMD")
    public RString getHiddenKijunYMD() {
        return hiddenKijunYMD;
    }

    /*
     * sethiddenKijunYMD
     * @param hiddenKijunYMD hiddenKijunYMD
     */
    @JsonProperty("hiddenKijunYMD")
    public void setHiddenKijunYMD(RString hiddenKijunYMD) {
        this.hiddenKijunYMD = hiddenKijunYMD;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KensakuJokenInputDiv getKensakuJokenInput() {
        return this.getKensakuJoken().getKensakuJokenInput();
    }

    @JsonIgnore
    public void  setKensakuJokenInput(KensakuJokenInputDiv KensakuJokenInput) {
        this.getKensakuJoken().setKensakuJokenInput(KensakuJokenInput);
    }

    @JsonIgnore
    public TextBoxCode getTxtShinsakaiIinCodeFrom() {
        return this.getKensakuJoken().getKensakuJokenInput().getTxtShinsakaiIinCodeFrom();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIinCodeFrom(TextBoxCode txtShinsakaiIinCodeFrom) {
        this.getKensakuJoken().getKensakuJokenInput().setTxtShinsakaiIinCodeFrom(txtShinsakaiIinCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtShinsakaiIinCodeTo() {
        return this.getKensakuJoken().getKensakuJokenInput().getTxtShinsakaiIinCodeTo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIinCodeTo(TextBoxCode txtShinsakaiIinCodeTo) {
        this.getKensakuJoken().getKensakuJokenInput().setTxtShinsakaiIinCodeTo(txtShinsakaiIinCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIinName() {
        return this.getKensakuJoken().getKensakuJokenInput().getTxtShinsakaiIinName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIinName(TextBox txtShinsakaiIinName) {
        this.getKensakuJoken().getKensakuJokenInput().setTxtShinsakaiIinName(txtShinsakaiIinName);
    }

    @JsonIgnore
    public DropDownList getDdlSeibetsu() {
        return this.getKensakuJoken().getKensakuJokenInput().getDdlSeibetsu();
    }

    @JsonIgnore
    public void  setDdlSeibetsu(DropDownList ddlSeibetsu) {
        this.getKensakuJoken().getKensakuJokenInput().setDdlSeibetsu(ddlSeibetsu);
    }

    @JsonIgnore
    public DropDownList getDdlShinsainShikakuCode() {
        return this.getKensakuJoken().getKensakuJokenInput().getDdlShinsainShikakuCode();
    }

    @JsonIgnore
    public void  setDdlShinsainShikakuCode(DropDownList ddlShinsainShikakuCode) {
        this.getKensakuJoken().getKensakuJokenInput().setDdlShinsainShikakuCode(ddlShinsainShikakuCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunbi() {
        return this.getKensakuJoken().getKensakuJokenInput().getTxtKijunbi();
    }

    @JsonIgnore
    public void  setTxtKijunbi(TextBoxDate txtKijunbi) {
        this.getKensakuJoken().getKensakuJokenInput().setTxtKijunbi(txtKijunbi);
    }

    @JsonIgnore
    public RadioButton getRadKikan() {
        return this.getKensakuJoken().getKensakuJokenInput().getRadKikan();
    }

    @JsonIgnore
    public void  setRadKikan(RadioButton radKikan) {
        this.getKensakuJoken().getKensakuJokenInput().setRadKikan(radKikan);
    }

    @JsonIgnore
    public CheckBoxList getChkHaishi() {
        return this.getKensakuJoken().getKensakuJokenInput().getChkHaishi();
    }

    @JsonIgnore
    public void  setChkHaishi(CheckBoxList chkHaishi) {
        this.getKensakuJoken().getKensakuJokenInput().setChkHaishi(chkHaishi);
    }

    @JsonIgnore
    public pnlShosaiJokenDiv getPnlShosaiJoken() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken();
    }

    @JsonIgnore
    public void  setPnlShosaiJoken(pnlShosaiJokenDiv pnlShosaiJoken) {
        this.getKensakuJoken().getKensakuJokenInput().setPnlShosaiJoken(pnlShosaiJoken);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensha() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getCcdHokensha();
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiCode() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getTxtChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiCode(TextBox txtChosaItakusakiCode) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setTxtChosaItakusakiCode(txtChosaItakusakiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaItakusaki() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getBtnChosaItakusaki();
    }

    @JsonIgnore
    public void  setBtnChosaItakusaki(ButtonDialog btnChosaItakusaki) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setBtnChosaItakusaki(btnChosaItakusaki);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiName() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getTxtChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setTxtChosaItakusakiName(txtChosaItakusakiName);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanCode() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCode(TextBox txtIryoKikanCode) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnIryoKikan() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getBtnIryoKikan();
    }

    @JsonIgnore
    public void  setBtnIryoKikan(ButtonDialog btnIryoKikan) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setBtnIryoKikan(btnIryoKikan);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanName() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getTxtIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setTxtIryoKikanName(txtIryoKikanName);
    }

    @JsonIgnore
    public TextBox getTxtSonotaJigyoshaCode() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getTxtSonotaJigyoshaCode();
    }

    @JsonIgnore
    public void  setTxtSonotaJigyoshaCode(TextBox txtSonotaJigyoshaCode) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setTxtSonotaJigyoshaCode(txtSonotaJigyoshaCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnSonotaJigyosha() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getBtnSonotaJigyosha();
    }

    @JsonIgnore
    public void  setBtnSonotaJigyosha(ButtonDialog btnSonotaJigyosha) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setBtnSonotaJigyosha(btnSonotaJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtSonotaJigyoshaName() {
        return this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().getTxtSonotaJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtSonotaJigyoshaName(TextBox txtSonotaJigyoshaName) {
        this.getKensakuJoken().getKensakuJokenInput().getPnlShosaiJoken().setTxtSonotaJigyoshaName(txtSonotaJigyoshaName);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getKensakuJoken().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getKensakuJoken().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensakku() {
        return this.getKensakuJoken().getBtnKensakku();
    }

    @JsonIgnore
    public void  setBtnKensakku(Button btnKensakku) {
        this.getKensakuJoken().setBtnKensakku(btnKensakku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return this.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran();
    }

    @JsonIgnore
    public void  setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.getShinsakaiIinIchiran().setDgShinsakaiIinIchiran(dgShinsakaiIinIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
