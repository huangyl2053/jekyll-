package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyuShinsaShuseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuShinsaShuseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchJutakuTesuryoSeikyuJohoPanel")
    private SearchJutakuTesuryoSeikyuJohoPanelDiv SearchJutakuTesuryoSeikyuJohoPanel;
    @JsonProperty("JutakuTesuryoSeikyuJohoPanel")
    private JutakuTesuryoSeikyuJohoPanelDiv JutakuTesuryoSeikyuJohoPanel;
    @JsonProperty("JutakuTesuryoSeikyuShosaiBase")
    private JutakuTesuryoSeikyuShosaiBaseDiv JutakuTesuryoSeikyuShosaiBase;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchJutakuTesuryoSeikyuJohoPanel
     * @return SearchJutakuTesuryoSeikyuJohoPanel
     */
    @JsonProperty("SearchJutakuTesuryoSeikyuJohoPanel")
    public SearchJutakuTesuryoSeikyuJohoPanelDiv getSearchJutakuTesuryoSeikyuJohoPanel() {
        return SearchJutakuTesuryoSeikyuJohoPanel;
    }

    /*
     * setSearchJutakuTesuryoSeikyuJohoPanel
     * @param SearchJutakuTesuryoSeikyuJohoPanel SearchJutakuTesuryoSeikyuJohoPanel
     */
    @JsonProperty("SearchJutakuTesuryoSeikyuJohoPanel")
    public void setSearchJutakuTesuryoSeikyuJohoPanel(SearchJutakuTesuryoSeikyuJohoPanelDiv SearchJutakuTesuryoSeikyuJohoPanel) {
        this.SearchJutakuTesuryoSeikyuJohoPanel = SearchJutakuTesuryoSeikyuJohoPanel;
    }

    /*
     * getJutakuTesuryoSeikyuJohoPanel
     * @return JutakuTesuryoSeikyuJohoPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuJohoPanel")
    public JutakuTesuryoSeikyuJohoPanelDiv getJutakuTesuryoSeikyuJohoPanel() {
        return JutakuTesuryoSeikyuJohoPanel;
    }

    /*
     * setJutakuTesuryoSeikyuJohoPanel
     * @param JutakuTesuryoSeikyuJohoPanel JutakuTesuryoSeikyuJohoPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuJohoPanel")
    public void setJutakuTesuryoSeikyuJohoPanel(JutakuTesuryoSeikyuJohoPanelDiv JutakuTesuryoSeikyuJohoPanel) {
        this.JutakuTesuryoSeikyuJohoPanel = JutakuTesuryoSeikyuJohoPanel;
    }

    /*
     * getJutakuTesuryoSeikyuShosaiBase
     * @return JutakuTesuryoSeikyuShosaiBase
     */
    @JsonProperty("JutakuTesuryoSeikyuShosaiBase")
    public JutakuTesuryoSeikyuShosaiBaseDiv getJutakuTesuryoSeikyuShosaiBase() {
        return JutakuTesuryoSeikyuShosaiBase;
    }

    /*
     * setJutakuTesuryoSeikyuShosaiBase
     * @param JutakuTesuryoSeikyuShosaiBase JutakuTesuryoSeikyuShosaiBase
     */
    @JsonProperty("JutakuTesuryoSeikyuShosaiBase")
    public void setJutakuTesuryoSeikyuShosaiBase(JutakuTesuryoSeikyuShosaiBaseDiv JutakuTesuryoSeikyuShosaiBase) {
        this.JutakuTesuryoSeikyuShosaiBase = JutakuTesuryoSeikyuShosaiBase;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtSearchSakuseiYM() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSearchSakuseiYM();
    }

    @JsonIgnore
    public void  setTxtSearchSakuseiYM(TextBoxDate txtSearchSakuseiYM) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setTxtSearchSakuseiYM(txtSearchSakuseiYM);
    }

    @JsonIgnore
    public CheckBoxList getChkSerchKetteiZumi() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getChkSerchKetteiZumi();
    }

    @JsonIgnore
    public void  setChkSerchKetteiZumi(CheckBoxList chkSerchKetteiZumi) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setChkSerchKetteiZumi(chkSerchKetteiZumi);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyosha() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getCcdJigyosha();
    }

    @JsonIgnore
    public DataGrid<dgSeikyu_Row> getDgSeikyu() {
        return this.getJutakuTesuryoSeikyuJohoPanel().getDgSeikyu();
    }

    @JsonIgnore
    public void  setDgSeikyu(DataGrid<dgSeikyu_Row> dgSeikyu) {
        this.getJutakuTesuryoSeikyuJohoPanel().setDgSeikyu(dgSeikyu);
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuKetteiPanelDiv getJutakuTesuryoSeikyuKetteiPanel() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuKetteiPanel(JutakuTesuryoSeikyuKetteiPanelDiv JutakuTesuryoSeikyuKetteiPanel) {
        this.getJutakuTesuryoSeikyuShosaiBase().setJutakuTesuryoSeikyuKetteiPanel(JutakuTesuryoSeikyuKetteiPanel);
    }

    @JsonIgnore
    public tblSeikyuKetteiDiv getTblSeikyuKettei() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei();
    }

    @JsonIgnore
    public void  setTblSeikyuKettei(tblSeikyuKetteiDiv tblSeikyuKettei) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().setTblSeikyuKettei(tblSeikyuKettei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getTxtKetteiYMD();
    }

    @JsonIgnore
    public RadioButton getRadShikyuFushikyuKubun() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getRadShikyuFushikyuKubun();
    }

    @JsonIgnore
    public TextBoxDate getTxtTesuryoShiharaiYoteiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getTxtTesuryoShiharaiYoteiYMD();
    }

    @JsonIgnore
    public Space getSpaSeikyuKettei() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getSpaSeikyuKettei();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getTxtFushikyuRiyu();
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuShosaiPanelDiv getJutakuTesuryoSeikyuShosaiPanel() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuShosaiPanel(JutakuTesuryoSeikyuShosaiPanelDiv JutakuTesuryoSeikyuShosaiPanel) {
        this.getJutakuTesuryoSeikyuShosaiBase().setJutakuTesuryoSeikyuShosaiPanel(JutakuTesuryoSeikyuShosaiPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtUketsukeYMD(txtUketsukeYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyoshaNo() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBoxDate getTxtSeikyuSakuseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtSeikyuSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtSeikyuSakuseiYMD(TextBoxDate txtSeikyuSakuseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtSeikyuSakuseiYMD(txtSeikyuSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtHdnShikibetsuCode() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtHdnShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtHdnShikibetsuCode(TextBoxCode txtHdnShikibetsuCode) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtHdnShikibetsuCode(txtHdnShikibetsuCode);
    }

    @JsonIgnore
    public DropDownList getDdlKozaShubetsu() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu();
    }

    @JsonIgnore
    public void  setDdlKozaShubetsu(DropDownList ddlKozaShubetsu) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setDdlKozaShubetsu(ddlKozaShubetsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKozaNo() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo();
    }

    @JsonIgnore
    public void  setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtKozaNo(txtKozaNo);
    }

    @JsonIgnore
    public TextBoxKana getTxtKozaNameKana() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana();
    }

    @JsonIgnore
    public void  setTxtKozaNameKana(TextBoxKana txtKozaNameKana) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtKozaNameKana(txtKozaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtKozaName() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName();
    }

    @JsonIgnore
    public void  setTxtKozaName(TextBox txtKozaName) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().setTxtKozaName(txtKozaName);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKinyuKikanInput() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput();
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuMeisaiDiv getJutakuTesuryoSeikyuMeisai() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuMeisai();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuMeisai(JutakuTesuryoSeikyuMeisaiDiv JutakuTesuryoSeikyuMeisai) {
        this.getJutakuTesuryoSeikyuShosaiBase().setJutakuTesuryoSeikyuMeisai(JutakuTesuryoSeikyuMeisai);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuMeisai_Row> getDgSeikyuMeisai() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuMeisai().getDgSeikyuMeisai();
    }

    @JsonIgnore
    public void  setDgSeikyuMeisai(DataGrid<dgSeikyuMeisai_Row> dgSeikyuMeisai) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuMeisai().setDgSeikyuMeisai(dgSeikyuMeisai);
    }

    @JsonIgnore
    public SeikyuMeisaiShosaiPanelDiv getSeikyuMeisaiShosaiPanel() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel();
    }

    @JsonIgnore
    public void  setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanelDiv SeikyuMeisaiShosaiPanel) {
        this.getJutakuTesuryoSeikyuShosaiBase().setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanel);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JutakuKaishuRiyushoPanelDiv getJutakuKaishuRiyushoPanel() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanelDiv JutakuKaishuRiyushoPanel) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtRiyushoSakuseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiYMD(TextBoxDate txtRiyushoSakuseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseiYMD(txtRiyushoSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxKana getTxtRiyushoSakuseishaMeiKana() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMeiKana(TextBoxKana txtRiyushoSakuseishaMeiKana) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMeiKana(txtRiyushoSakuseishaMeiKana);
    }

    @JsonIgnore
    public TextBox getTxtRiyushoSakuseishaMei() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMei(TextBox txtRiyushoSakuseishaMei) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMei(txtRiyushoSakuseishaMei);
    }

    @JsonIgnore
    public JutakuKaishuPanelDiv getJutakuKaishuPanel() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuPanel(JutakuKaishuPanelDiv JutakuKaishuPanel) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().setJutakuKaishuPanel(JutakuKaishuPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishuShikyuShinseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishuShikyuShinseiYMD(TextBoxDate txtKaishuShikyuShinseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuShikyuShinseiYMD(txtKaishuShikyuShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJutakuKaishuChakkoYMD() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuChakkoYMD(TextBoxDate txtJutakuKaishuChakkoYMD) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuChakkoYMD(txtJutakuKaishuChakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtJutakuKaishuJigyoshaMeisho() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuJigyoshaMeisho(TextBox txtJutakuKaishuJigyoshaMeisho) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuJigyoshaMeisho(txtJutakuKaishuJigyoshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKaishuTaishoJutakuJusho() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho();
    }

    @JsonIgnore
    public void  setTxtKaishuTaishoJutakuJusho(TextBox txtKaishuTaishoJutakuJusho) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuTaishoJutakuJusho(txtKaishuTaishoJutakuJusho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKaishuNaiyokashoKibo() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo();
    }

    @JsonIgnore
    public void  setTxtKaishuNaiyokashoKibo(TextBoxMultiLine txtKaishuNaiyokashoKibo) {
        this.getJutakuTesuryoSeikyuShosaiBase().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuNaiyokashoKibo(txtKaishuNaiyokashoKibo);
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuShukeiPanelDiv getJutakuTesuryoSeikyuShukeiPanel() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanelDiv JutakuTesuryoSeikyuShukeiPanel) {
        this.getJutakuTesuryoSeikyuShosaiBase().setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiTanka() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiTanka(TextBoxNum txtRiyushoSakuseiTanka) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiTanka(txtRiyushoSakuseiTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiKensu() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiKensu(TextBoxNum txtRiyushoSakuseiKensu) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiKensu(txtRiyushoSakuseiKensu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiSeikyuKingaku() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiSeikyuKingaku(TextBoxNum txtRiyushoSakuseiSeikyuKingaku) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiSeikyuKingaku(txtRiyushoSakuseiSeikyuKingaku);
    }

    @JsonIgnore
    public Button getBtnShukei() {
        return this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().getBtnShukei();
    }

    @JsonIgnore
    public void  setBtnShukei(Button btnShukei) {
        this.getJutakuTesuryoSeikyuShosaiBase().getJutakuTesuryoSeikyuShukeiPanel().setBtnShukei(btnShukei);
    }

    // </editor-fold>
}
