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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
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
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("jigyoshaCode")
    private RString jigyoshaCode;
    @JsonProperty("jigyoshaMeisho")
    private RString jigyoshaMeisho;
    @JsonProperty("jigyoshaCodeMeisho")
    private RString jigyoshaCodeMeisho;

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
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getjigyoshaCode
     * @return jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    /*
     * setjigyoshaCode
     * @param jigyoshaCode jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public void setJigyoshaCode(RString jigyoshaCode) {
        this.jigyoshaCode = jigyoshaCode;
    }

    /*
     * getjigyoshaMeisho
     * @return jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /*
     * setjigyoshaMeisho
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /*
     * getjigyoshaCodeMeisho
     * @return jigyoshaCodeMeisho
     */
    @JsonProperty("jigyoshaCodeMeisho")
    public RString getJigyoshaCodeMeisho() {
        return jigyoshaCodeMeisho;
    }

    /*
     * setjigyoshaCodeMeisho
     * @param jigyoshaCodeMeisho jigyoshaCodeMeisho
     */
    @JsonProperty("jigyoshaCodeMeisho")
    public void setJigyoshaCodeMeisho(RString jigyoshaCodeMeisho) {
        this.jigyoshaCodeMeisho = jigyoshaCodeMeisho;
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
    public Label getLblJushoKara() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getLblJushoKara();
    }

    @JsonIgnore
    public void  setLblJushoKara(Label lblJushoKara) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setLblJushoKara(lblJushoKara);
    }

    @JsonIgnore
    public Label getLblChiku2Kara() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getLblChiku2Kara();
    }

    @JsonIgnore
    public void  setLblChiku2Kara(Label lblChiku2Kara) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setLblChiku2Kara(lblChiku2Kara);
    }

    @JsonIgnore
    public Label getLblGyoseikuKara() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getLblGyoseikuKara();
    }

    @JsonIgnore
    public void  setLblGyoseikuKara(Label lblGyoseikuKara) {
        this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().setLblGyoseikuKara(lblGyoseikuKara);
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
    public IChoikiInputDiv getCcdJyuusyoStart() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getCcdJyuusyoStart();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyouseiStart() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getCcdGyouseiStart();
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJyuusyoEnd() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getCcdJyuusyoEnd();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChikuStart() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getCcdChikuStart();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyouseiEnd() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getCcdGyouseiEnd();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChikuEnd() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getChushutsuJoken4().getChushutsuJoken().getCcdChikuEnd();
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

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJohoCommonChildDiv() {
        return this.getTokubetsuTiikiKasannKeigennJiqsekiKannriRisuto().getCcdShisetsuJohoCommonChildDiv();
    }

    // </editor-fold>
}
