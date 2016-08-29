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
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto")
    private TokubetsuTiikiKasannKeigennJiqsekiKannriRisutoDiv TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;
    @JsonProperty("hiddenJigyoshaMode")
    private RString hiddenJigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto
     * @return TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto
     */
    @JsonProperty("TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto")
    public TokubetsuTiikiKasannKeigennJiqsekiKannriRisutoDiv getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto() {
        return TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto;
    }

    /*
     * setTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto
     * @param TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto
     */
    @JsonProperty("TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto")
    public void setTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto(TokubetsuTiikiKasannKeigennJiqsekiKannriRisutoDiv TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto) {
        this.TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto = TokubetsuTiikiKasannKeigennJiqsekiKannriRisuto;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * gethiddenJigyoshaMode
     * @return hiddenJigyoshaMode
     */
    @JsonProperty("hiddenJigyoshaMode")
    public RString getHiddenJigyoshaMode() {
        return hiddenJigyoshaMode;
    }

    /*
     * sethiddenJigyoshaMode
     * @param hiddenJigyoshaMode hiddenJigyoshaMode
     */
    @JsonProperty("hiddenJigyoshaMode")
    public void setHiddenJigyoshaMode(RString hiddenJigyoshaMode) {
        this.hiddenJigyoshaMode = hiddenJigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChushutsuJoken() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getLblChushutsuJoken();
    }

    @JsonIgnore
    public void  setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setLblChushutsuJoken(lblChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getRadTaishoYM();
    }

    @JsonIgnore
    public void  setRadTaishoYM(RadioButton radTaishoYM) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtRangeYM() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getTxtRangeYM();
    }

    @JsonIgnore
    public void  setTxtRangeYM(TextBoxDateRange txtRangeYM) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setTxtRangeYM(txtRangeYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyoshaNo() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyoshaNo() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getBtnJigyoshaNo();
    }

    @JsonIgnore
    public void  setBtnJigyoshaNo(ButtonDialog btnJigyoshaNo) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setBtnJigyoshaNo(btnJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public ChushutsuJoken4Div getChushutsuJoken4() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4();
    }

    @JsonIgnore
    public void  setChushutsuJoken4(ChushutsuJoken4Div ChushutsuJoken4) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().setChushutsuJoken4(ChushutsuJoken4);
    }

    @JsonIgnore
    public ChushutsuJokenDiv getChushutsuJoken() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken();
    }

    @JsonIgnore
    public void  setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().setChushutsuJoken(ChushutsuJoken);
    }

    @JsonIgnore
    public Space getChikuSpace1() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getChikuSpace1();
    }

    @JsonIgnore
    public void  setChikuSpace1(Space ChikuSpace1) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setChikuSpace1(ChikuSpace1);
    }

    @JsonIgnore
    public DropDownList getDdlChiku() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChikuCodeFrom() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getTxtChikuCodeFrom();
    }

    @JsonIgnore
    public void  setTxtChikuCodeFrom(TextBoxCode txtChikuCodeFrom) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setTxtChikuCodeFrom(txtChikuCodeFrom);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuJushoCodeFrom() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getBtnChikuJushoCodeFrom();
    }

    @JsonIgnore
    public void  setBtnChikuJushoCodeFrom(ButtonDialog btnChikuJushoCodeFrom) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setBtnChikuJushoCodeFrom(btnChikuJushoCodeFrom);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuGyoseikuCodeFrom() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getBtnChikuGyoseikuCodeFrom();
    }

    @JsonIgnore
    public void  setBtnChikuGyoseikuCodeFrom(ButtonDialog btnChikuGyoseikuCodeFrom) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setBtnChikuGyoseikuCodeFrom(btnChikuGyoseikuCodeFrom);
    }

    @JsonIgnore
    public TextBox getTxtChikuNameFrom() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getTxtChikuNameFrom();
    }

    @JsonIgnore
    public void  setTxtChikuNameFrom(TextBox txtChikuNameFrom) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setTxtChikuNameFrom(txtChikuNameFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtChikuCodeTo() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getTxtChikuCodeTo();
    }

    @JsonIgnore
    public void  setTxtChikuCodeTo(TextBoxCode txtChikuCodeTo) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setTxtChikuCodeTo(txtChikuCodeTo);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuJushoCodeTo() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getBtnChikuJushoCodeTo();
    }

    @JsonIgnore
    public void  setBtnChikuJushoCodeTo(ButtonDialog btnChikuJushoCodeTo) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setBtnChikuJushoCodeTo(btnChikuJushoCodeTo);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuGyoseikuCodeTo() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getBtnChikuGyoseikuCodeTo();
    }

    @JsonIgnore
    public void  setBtnChikuGyoseikuCodeTo(ButtonDialog btnChikuGyoseikuCodeTo) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setBtnChikuGyoseikuCodeTo(btnChikuGyoseikuCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtChikuNameTo() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getTxtChikuNameTo();
    }

    @JsonIgnore
    public void  setTxtChikuNameTo(TextBox txtChikuNameTo) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setTxtChikuNameTo(txtChikuNameTo);
    }

    @JsonIgnore
    public Space getShichosonSpace1() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getShichosonSpace1();
    }

    @JsonIgnore
    public void  setShichosonSpace1(Space ShichosonSpace1) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setShichosonSpace1(ShichosonSpace1);
    }

    @JsonIgnore
    public ShichosonPanelDiv getShichosonPanel() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getShichosonPanel();
    }

    @JsonIgnore
    public void  setShichosonPanel(ShichosonPanelDiv ShichosonPanel) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().setShichosonPanel(ShichosonPanel);
    }

    @JsonIgnore
    public Space getChikuSpace2() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getShichosonPanel().getChikuSpace2();
    }

    @JsonIgnore
    public void  setChikuSpace2(Space ChikuSpace2) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getShichosonPanel().setChikuSpace2(ChikuSpace2);
    }

    @JsonIgnore
    public Space getShichosonSpace2() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getShichosonPanel().getShichosonSpace2();
    }

    @JsonIgnore
    public void  setShichosonSpace2(Space ShichosonSpace2) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getShichosonPanel().setShichosonSpace2(ShichosonSpace2);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getShichosonPanel().getCcdHokenshaList();
    }

    // </editor-fold>
}
