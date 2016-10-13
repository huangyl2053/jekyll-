package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
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
    @JsonProperty("ccdShisetsuJohoCommonChildDiv")
    private ShisetsuJohoCommonChildDivDiv ccdShisetsuJohoCommonChildDiv;
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
     * getccdShisetsuJohoCommonChildDiv
     * @return ccdShisetsuJohoCommonChildDiv
     */
    @JsonProperty("ccdShisetsuJohoCommonChildDiv")
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJohoCommonChildDiv() {
        return ccdShisetsuJohoCommonChildDiv;
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
    public Label getLblJushoKara() {
        return this.getChushutsuJoken4().getChushutsuJoken().getLblJushoKara();
    }

    @JsonIgnore
    public void  setLblJushoKara(Label lblJushoKara) {
        this.getChushutsuJoken4().getChushutsuJoken().setLblJushoKara(lblJushoKara);
    }

    @JsonIgnore
    public Label getLblChiku2Kara() {
        return this.getChushutsuJoken4().getChushutsuJoken().getLblChiku2Kara();
    }

    @JsonIgnore
    public void  setLblChiku2Kara(Label lblChiku2Kara) {
        this.getChushutsuJoken4().getChushutsuJoken().setLblChiku2Kara(lblChiku2Kara);
    }

    @JsonIgnore
    public Label getLblGyoseikuKara() {
        return this.getChushutsuJoken4().getChushutsuJoken().getLblGyoseikuKara();
    }

    @JsonIgnore
    public void  setLblGyoseikuKara(Label lblGyoseikuKara) {
        this.getChushutsuJoken4().getChushutsuJoken().setLblGyoseikuKara(lblGyoseikuKara);
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
    public IChoikiInputDiv getCcdJyuusyoStart() {
        return this.getChushutsuJoken4().getChushutsuJoken().getCcdJyuusyoStart();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChikuEnd() {
        return this.getChushutsuJoken4().getChushutsuJoken().getCcdChikuEnd();
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJyuusyoEnd() {
        return this.getChushutsuJoken4().getChushutsuJoken().getCcdJyuusyoEnd();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChikuStart() {
        return this.getChushutsuJoken4().getChushutsuJoken().getCcdChikuStart();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyouseiEnd() {
        return this.getChushutsuJoken4().getChushutsuJoken().getCcdGyouseiEnd();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyouseiStart() {
        return this.getChushutsuJoken4().getChushutsuJoken().getCcdGyouseiStart();
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
