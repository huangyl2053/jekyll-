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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    public IHokenshaListDiv getCcdHokensha() {
        return this.getKensakuJoken().getKensakuJokenInput().getCcdHokensha();
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
    public ShosaiJokenDiv getShosaiJoken() {
        return this.getKensakuJoken().getShosaiJoken();
    }

    @JsonIgnore
    public void  setShosaiJoken(ShosaiJokenDiv ShosaiJoken) {
        this.getKensakuJoken().setShosaiJoken(ShosaiJoken);
    }

    @JsonIgnore
    public Label getLblShozoku() {
        return this.getKensakuJoken().getShosaiJoken().getLblShozoku();
    }

    @JsonIgnore
    public void  setLblShozoku(Label lblShozoku) {
        this.getKensakuJoken().getShosaiJoken().setLblShozoku(lblShozoku);
    }

    @JsonIgnore
    public DropDownList getDdlIryoKikan() {
        return this.getKensakuJoken().getShosaiJoken().getDdlIryoKikan();
    }

    @JsonIgnore
    public void  setDdlIryoKikan(DropDownList ddlIryoKikan) {
        this.getKensakuJoken().getShosaiJoken().setDdlIryoKikan(ddlIryoKikan);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoJigyosha() {
        return this.getKensakuJoken().getShosaiJoken().getDdlKaigoJigyosha();
    }

    @JsonIgnore
    public void  setDdlKaigoJigyosha(DropDownList ddlKaigoJigyosha) {
        this.getKensakuJoken().getShosaiJoken().setDdlKaigoJigyosha(ddlKaigoJigyosha);
    }

    @JsonIgnore
    public DropDownList getDdlSonotaJigyosha() {
        return this.getKensakuJoken().getShosaiJoken().getDdlSonotaJigyosha();
    }

    @JsonIgnore
    public void  setDdlSonotaJigyosha(DropDownList ddlSonotaJigyosha) {
        this.getKensakuJoken().getShosaiJoken().setDdlSonotaJigyosha(ddlSonotaJigyosha);
    }

    @JsonIgnore
    public CheckBoxList getChkKiken() {
        return this.getKensakuJoken().getShosaiJoken().getChkKiken();
    }

    @JsonIgnore
    public void  setChkKiken(CheckBoxList chkKiken) {
        this.getKensakuJoken().getShosaiJoken().setChkKiken(chkKiken);
    }

    @JsonIgnore
    public CheckBoxList getChkHaishi() {
        return this.getKensakuJoken().getShosaiJoken().getChkHaishi();
    }

    @JsonIgnore
    public void  setChkHaishi(CheckBoxList chkHaishi) {
        this.getKensakuJoken().getShosaiJoken().setChkHaishi(chkHaishi);
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
