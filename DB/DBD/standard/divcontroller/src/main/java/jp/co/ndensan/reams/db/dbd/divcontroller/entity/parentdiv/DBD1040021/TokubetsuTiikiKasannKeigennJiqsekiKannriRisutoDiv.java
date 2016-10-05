package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;
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
 * TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuTiikiKasannKeigennJiqsekiKannriRisutoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("radTaishoYM")
    private RadioButton radTaishoYM;
    @JsonProperty("txtRangeYM")
    private TextBoxDateRange txtRangeYM;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("btnJigyoshaNo")
    private ButtonDialog btnJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("ChushutsuJoken4")
    private ChushutsuJoken4Div ChushutsuJoken4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChushutsuJoken
     * @return lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    /*
     * setlblChushutsuJoken
     * @param lblChushutsuJoken lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken = lblChushutsuJoken;
    }

    /*
     * getradTaishoYM
     * @return radTaishoYM
     */
    @JsonProperty("radTaishoYM")
    public RadioButton getRadTaishoYM() {
        return radTaishoYM;
    }

    /*
     * setradTaishoYM
     * @param radTaishoYM radTaishoYM
     */
    @JsonProperty("radTaishoYM")
    public void setRadTaishoYM(RadioButton radTaishoYM) {
        this.radTaishoYM = radTaishoYM;
    }

    /*
     * gettxtRangeYM
     * @return txtRangeYM
     */
    @JsonProperty("txtRangeYM")
    public TextBoxDateRange getTxtRangeYM() {
        return txtRangeYM;
    }

    /*
     * settxtRangeYM
     * @param txtRangeYM txtRangeYM
     */
    @JsonProperty("txtRangeYM")
    public void setTxtRangeYM(TextBoxDateRange txtRangeYM) {
        this.txtRangeYM = txtRangeYM;
    }

    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * getbtnJigyoshaNo
     * @return btnJigyoshaNo
     */
    @JsonProperty("btnJigyoshaNo")
    public ButtonDialog getBtnJigyoshaNo() {
        return btnJigyoshaNo;
    }

    /*
     * setbtnJigyoshaNo
     * @param btnJigyoshaNo btnJigyoshaNo
     */
    @JsonProperty("btnJigyoshaNo")
    public void setBtnJigyoshaNo(ButtonDialog btnJigyoshaNo) {
        this.btnJigyoshaNo = btnJigyoshaNo;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * getChushutsuJoken4
     * @return ChushutsuJoken4
     */
    @JsonProperty("ChushutsuJoken4")
    public ChushutsuJoken4Div getChushutsuJoken4() {
        return ChushutsuJoken4;
    }

    /*
     * setChushutsuJoken4
     * @param ChushutsuJoken4 ChushutsuJoken4
     */
    @JsonProperty("ChushutsuJoken4")
    public void setChushutsuJoken4(ChushutsuJoken4Div ChushutsuJoken4) {
        this.ChushutsuJoken4 = ChushutsuJoken4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ChushutsuJokenDiv getChushutsuJoken() {
        return this.getChushutsuJoken4().getChushutsuJoken();
    }

    @JsonIgnore
    public void  setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.getChushutsuJoken4().setChushutsuJoken(ChushutsuJoken);
    }

    @JsonIgnore
    public Space getChikuSpace1() {
        return this.getChushutsuJoken4().getChushutsuJoken().getChikuSpace1();
    }

    @JsonIgnore
    public void  setChikuSpace1(Space ChikuSpace1) {
        this.getChushutsuJoken4().getChushutsuJoken().setChikuSpace1(ChikuSpace1);
    }

    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getChushutsuJoken4().getChushutsuJoken().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getChushutsuJoken4().getChushutsuJoken().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChikuCodeFrom() {
        return this.getChushutsuJoken4().getChushutsuJoken().getTxtChikuCodeFrom();
    }

    @JsonIgnore
    public void  setTxtChikuCodeFrom(TextBoxCode txtChikuCodeFrom) {
        this.getChushutsuJoken4().getChushutsuJoken().setTxtChikuCodeFrom(txtChikuCodeFrom);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuJushoCodeFrom() {
        return this.getChushutsuJoken4().getChushutsuJoken().getBtnChikuJushoCodeFrom();
    }

    @JsonIgnore
    public void  setBtnChikuJushoCodeFrom(ButtonDialog btnChikuJushoCodeFrom) {
        this.getChushutsuJoken4().getChushutsuJoken().setBtnChikuJushoCodeFrom(btnChikuJushoCodeFrom);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuGyoseikuCodeFrom() {
        return this.getChushutsuJoken4().getChushutsuJoken().getBtnChikuGyoseikuCodeFrom();
    }

    @JsonIgnore
    public void  setBtnChikuGyoseikuCodeFrom(ButtonDialog btnChikuGyoseikuCodeFrom) {
        this.getChushutsuJoken4().getChushutsuJoken().setBtnChikuGyoseikuCodeFrom(btnChikuGyoseikuCodeFrom);
    }

    @JsonIgnore
    public TextBox getTxtChikuNameFrom() {
        return this.getChushutsuJoken4().getChushutsuJoken().getTxtChikuNameFrom();
    }

    @JsonIgnore
    public void  setTxtChikuNameFrom(TextBox txtChikuNameFrom) {
        this.getChushutsuJoken4().getChushutsuJoken().setTxtChikuNameFrom(txtChikuNameFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtChikuCodeTo() {
        return this.getChushutsuJoken4().getChushutsuJoken().getTxtChikuCodeTo();
    }

    @JsonIgnore
    public void  setTxtChikuCodeTo(TextBoxCode txtChikuCodeTo) {
        this.getChushutsuJoken4().getChushutsuJoken().setTxtChikuCodeTo(txtChikuCodeTo);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuJushoCodeTo() {
        return this.getChushutsuJoken4().getChushutsuJoken().getBtnChikuJushoCodeTo();
    }

    @JsonIgnore
    public void  setBtnChikuJushoCodeTo(ButtonDialog btnChikuJushoCodeTo) {
        this.getChushutsuJoken4().getChushutsuJoken().setBtnChikuJushoCodeTo(btnChikuJushoCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtChikuNameTo() {
        return this.getChushutsuJoken4().getChushutsuJoken().getTxtChikuNameTo();
    }

    @JsonIgnore
    public void  setTxtChikuNameTo(TextBox txtChikuNameTo) {
        this.getChushutsuJoken4().getChushutsuJoken().setTxtChikuNameTo(txtChikuNameTo);
    }

    @JsonIgnore
    public Space getShichosonSpace1() {
        return this.getChushutsuJoken4().getChushutsuJoken().getShichosonSpace1();
    }

    @JsonIgnore
    public void  setShichosonSpace1(Space ShichosonSpace1) {
        this.getChushutsuJoken4().getChushutsuJoken().setShichosonSpace1(ShichosonSpace1);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuGyoseikuCodeTo() {
        return this.getChushutsuJoken4().getChushutsuJoken().getBtnChikuGyoseikuCodeTo();
    }

    @JsonIgnore
    public void  setBtnChikuGyoseikuCodeTo(ButtonDialog btnChikuGyoseikuCodeTo) {
        this.getChushutsuJoken4().getChushutsuJoken().setBtnChikuGyoseikuCodeTo(btnChikuGyoseikuCodeTo);
    }

    @JsonIgnore
    public ShichosonPanelDiv getShichosonPanel() {
        return this.getChushutsuJoken4().getShichosonPanel();
    }

    @JsonIgnore
    public void  setShichosonPanel(ShichosonPanelDiv ShichosonPanel) {
        this.getChushutsuJoken4().setShichosonPanel(ShichosonPanel);
    }

    @JsonIgnore
    public Space getChikuSpace2() {
        return this.getChushutsuJoken4().getShichosonPanel().getChikuSpace2();
    }

    @JsonIgnore
    public void  setChikuSpace2(Space ChikuSpace2) {
        this.getChushutsuJoken4().getShichosonPanel().setChikuSpace2(ChikuSpace2);
    }

    @JsonIgnore
    public Space getShichosonSpace2() {
        return this.getChushutsuJoken4().getShichosonPanel().getShichosonSpace2();
    }

    @JsonIgnore
    public void  setShichosonSpace2(Space ShichosonSpace2) {
        this.getChushutsuJoken4().getShichosonPanel().setShichosonSpace2(ShichosonSpace2);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChushutsuJoken4().getShichosonPanel().getCcdHokenshaList();
    }

    // </editor-fold>
}
