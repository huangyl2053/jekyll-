package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyugakuKeisanKekkaToroku のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaInfo")
    private HihokenshaInfoDiv HihokenshaInfo;
    @JsonProperty("ShikyugakuKeisanKekkaTorokuListPanel")
    private ShikyugakuKeisanKekkaTorokuListPanelDiv ShikyugakuKeisanKekkaTorokuListPanel;
    @JsonProperty("ShikyugakuKeisanKekkaTorokuDetailPanel")
    private ShikyugakuKeisanKekkaTorokuDetailPanelDiv ShikyugakuKeisanKekkaTorokuDetailPanel;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHihokenshaInfo
     * @return HihokenshaInfo
     */
    @JsonProperty("HihokenshaInfo")
    public HihokenshaInfoDiv getHihokenshaInfo() {
        return HihokenshaInfo;
    }

    /*
     * setHihokenshaInfo
     * @param HihokenshaInfo HihokenshaInfo
     */
    @JsonProperty("HihokenshaInfo")
    public void setHihokenshaInfo(HihokenshaInfoDiv HihokenshaInfo) {
        this.HihokenshaInfo = HihokenshaInfo;
    }

    /*
     * getShikyugakuKeisanKekkaTorokuListPanel
     * @return ShikyugakuKeisanKekkaTorokuListPanel
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuListPanel")
    public ShikyugakuKeisanKekkaTorokuListPanelDiv getShikyugakuKeisanKekkaTorokuListPanel() {
        return ShikyugakuKeisanKekkaTorokuListPanel;
    }

    /*
     * setShikyugakuKeisanKekkaTorokuListPanel
     * @param ShikyugakuKeisanKekkaTorokuListPanel ShikyugakuKeisanKekkaTorokuListPanel
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuListPanel")
    public void setShikyugakuKeisanKekkaTorokuListPanel(ShikyugakuKeisanKekkaTorokuListPanelDiv ShikyugakuKeisanKekkaTorokuListPanel) {
        this.ShikyugakuKeisanKekkaTorokuListPanel = ShikyugakuKeisanKekkaTorokuListPanel;
    }

    /*
     * getShikyugakuKeisanKekkaTorokuDetailPanel
     * @return ShikyugakuKeisanKekkaTorokuDetailPanel
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuDetailPanel")
    public ShikyugakuKeisanKekkaTorokuDetailPanelDiv getShikyugakuKeisanKekkaTorokuDetailPanel() {
        return ShikyugakuKeisanKekkaTorokuDetailPanel;
    }

    /*
     * setShikyugakuKeisanKekkaTorokuDetailPanel
     * @param ShikyugakuKeisanKekkaTorokuDetailPanel ShikyugakuKeisanKekkaTorokuDetailPanel
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuDetailPanel")
    public void setShikyugakuKeisanKekkaTorokuDetailPanel(ShikyugakuKeisanKekkaTorokuDetailPanelDiv ShikyugakuKeisanKekkaTorokuDetailPanel) {
        this.ShikyugakuKeisanKekkaTorokuDetailPanel = ShikyugakuKeisanKekkaTorokuDetailPanel;
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
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getHihokenshaInfo().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getHihokenshaInfo().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKensakuTaishoNendo() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getTxtKensakuTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtKensakuTaishoNendo(TextBoxDateRange txtKensakuTaishoNendo) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setTxtKensakuTaishoNendo(txtKensakuTaishoNendo);
    }

    @JsonIgnore
    public CheckBoxList getChkRirekiHyoji() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getChkRirekiHyoji();
    }

    @JsonIgnore
    public void  setChkRirekiHyoji(CheckBoxList chkRirekiHyoji) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setChkRirekiHyoji(chkRirekiHyoji);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public HorizontalLine getLin01() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getLin01();
    }

    @JsonIgnore
    public void  setLin01(HorizontalLine lin01) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setLin01(lin01);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikyuShinseishoSeiriNoInput() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getTxtShikyuShinseishoSeiriNoInput();
    }

    @JsonIgnore
    public void  setTxtShikyuShinseishoSeiriNoInput(TextBoxCode txtShikyuShinseishoSeiriNoInput) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setTxtShikyuShinseishoSeiriNoInput(txtShikyuShinseishoSeiriNoInput);
    }

    @JsonIgnore
    public Button getBtnAddKeisanKekka() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getBtnAddKeisanKekka();
    }

    @JsonIgnore
    public void  setBtnAddKeisanKekka(Button btnAddKeisanKekka) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setBtnAddKeisanKekka(btnAddKeisanKekka);
    }

    @JsonIgnore
    public HorizontalLine getLin02() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getLin02();
    }

    @JsonIgnore
    public void  setLin02(HorizontalLine lin02) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setLin02(lin02);
    }

    @JsonIgnore
    public DataGrid<dgKogakuGassanShikyuGakuKeisanKekka_Row> getDgKogakuGassanShikyuGakuKeisanKekka() {
        return this.getShikyugakuKeisanKekkaTorokuListPanel().getDgKogakuGassanShikyuGakuKeisanKekka();
    }

    @JsonIgnore
    public void  setDgKogakuGassanShikyuGakuKeisanKekka(DataGrid<dgKogakuGassanShikyuGakuKeisanKekka_Row> dgKogakuGassanShikyuGakuKeisanKekka) {
        this.getShikyugakuKeisanKekkaTorokuListPanel().setDgKogakuGassanShikyuGakuKeisanKekka(dgKogakuGassanShikyuGakuKeisanKekka);
    }

    @JsonIgnore
    public TextBox getTxtSanteiKubun() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTxtSanteiKubun();
    }

    @JsonIgnore
    public void  setTxtSanteiKubun(TextBox txtSanteiKubun) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTxtSanteiKubun(txtSanteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtStatusFlg() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTxtStatusFlg();
    }

    @JsonIgnore
    public void  setTxtStatusFlg(TextBox txtStatusFlg) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTxtStatusFlg(txtStatusFlg);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoNendo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public TextBox getTxtShoKisaiHokenshaNoa() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTxtShoKisaiHokenshaNoa();
    }

    @JsonIgnore
    public void  setTxtShoKisaiHokenshaNoa(TextBox txtShoKisaiHokenshaNoa) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTxtShoKisaiHokenshaNoa(txtShoKisaiHokenshaNoa);
    }

    @JsonIgnore
    public TextBox getTxtShikyuShinseishoSeiriNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTxtShikyuShinseishoSeiriNo();
    }

    @JsonIgnore
    public void  setTxtShikyuShinseishoSeiriNo(TextBox txtShikyuShinseishoSeiriNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTxtShikyuShinseishoSeiriNo(txtShikyuShinseishoSeiriNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtSofuYM() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTxtSofuYM();
    }

    @JsonIgnore
    public void  setTxtSofuYM(TextBoxDate txtSofuYM) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTxtSofuYM(txtSofuYM);
    }

    @JsonIgnore
    public CheckBoxList getChkSaiso() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getChkSaiso();
    }

    @JsonIgnore
    public void  setChkSaiso(CheckBoxList chkSaiso) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setChkSaiso(chkSaiso);
    }

    @JsonIgnore
    public tabMeisaiDiv getTabMeisai() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai();
    }

    @JsonIgnore
    public void  setTabMeisai(tabMeisaiDiv tabMeisai) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().setTabMeisai(tabMeisai);
    }

    @JsonIgnore
    public tabShikyugakuKeisanKekkaTorokuUchiwakeDiv getTabShikyugakuKeisanKekkaTorokuUchiwake() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake();
    }

    @JsonIgnore
    public void  setTabShikyugakuKeisanKekkaTorokuUchiwake(tabShikyugakuKeisanKekkaTorokuUchiwakeDiv tabShikyugakuKeisanKekkaTorokuUchiwake) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().setTabShikyugakuKeisanKekkaTorokuUchiwake(tabShikyugakuKeisanKekkaTorokuUchiwake);
    }

    @JsonIgnore
    public ShikyugakuKeisanKekkaTorokuUchiwakeListDiv getShikyugakuKeisanKekkaTorokuUchiwakeList() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList();
    }

    @JsonIgnore
    public void  setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeListDiv ShikyugakuKeisanKekkaTorokuUchiwakeList) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeList);
    }

    @JsonIgnore
    public Button getBtnUchiwakeAdd() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getBtnUchiwakeAdd();
    }

    @JsonIgnore
    public void  setBtnUchiwakeAdd(Button btnUchiwakeAdd) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setBtnUchiwakeAdd(btnUchiwakeAdd);
    }

    @JsonIgnore
    public DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> getDgKogakuGassanShikyugakuKeisanKekkaMeisai() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getDgKogakuGassanShikyugakuKeisanKekkaMeisai();
    }

    @JsonIgnore
    public void  setDgKogakuGassanShikyugakuKeisanKekkaMeisai(DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> dgKogakuGassanShikyugakuKeisanKekkaMeisai) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setDgKogakuGassanShikyugakuKeisanKekkaMeisai(dgKogakuGassanShikyugakuKeisanKekkaMeisai);
    }

    @JsonIgnore
    public GokeiJohoPanelDiv getGokeiJohoPanel() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel();
    }

    @JsonIgnore
    public void  setGokeiJohoPanel(GokeiJohoPanelDiv GokeiJohoPanel) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setGokeiJohoPanel(GokeiJohoPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70FutangakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70FutangakuGokei(TextBoxNum txtJohoOver70FutangakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70FutangakuGokei(txtJohoOver70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70ShikyugakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70ShikyugakuGokei(TextBoxNum txtJohoOver70ShikyugakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70ShikyugakuGokei(txtJohoOver70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70FutangakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70FutangakuGokei(TextBoxNum txtJohoUnder70FutangakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70FutangakuGokei(txtJohoUnder70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoFutangakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoFutangakuGokei(TextBoxNum txtJohoFutangakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoFutangakuGokei(txtJohoFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70ShikyugakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70ShikyugakuGokei(TextBoxNum txtJohoUnder70ShikyugakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70ShikyugakuGokei(txtJohoUnder70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoShikyugakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoShikyugakuGokei(TextBoxNum txtJohoShikyugakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoShikyugakuGokei(txtJohoShikyugakuGokei);
    }

    @JsonIgnore
    public ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv getShikyugakuKeisanKekkaTorokuUchiwakeDetail() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail();
    }

    @JsonIgnore
    public void  setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv ShikyugakuKeisanKekkaTorokuUchiwakeDetail) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetail);
    }

    @JsonIgnore
    public DropDownList getDdlHokenSeido() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getDdlHokenSeido();
    }

    @JsonIgnore
    public void  setDdlHokenSeido(DropDownList ddlHokenSeido) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setDdlHokenSeido(ddlHokenSeido);
    }

    @JsonIgnore
    public TextBox getTxtShoKisaiHokenshaNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShoKisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShoKisaiHokenshaNo(TextBox txtShoKisaiHokenshaNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShoKisaiHokenshaNo(txtShoKisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHokenshaMei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHokenshaMei();
    }

    @JsonIgnore
    public void  setTxtHokenshaMei(TextBox txtHokenshaMei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHokenshaMei(txtHokenshaMei);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin3(lin3);
    }

    @JsonIgnore
    public TextBoxCode getTxtKokuhoHihokenshaShoKigo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtKokuhoHihokenshaShoKigo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHihokenshaShoKigo(TextBoxCode txtKokuhoHihokenshaShoKigo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtKokuhoHihokenshaShoKigo(txtKokuhoHihokenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtTaishoshaShimei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtTaishoshaShimei();
    }

    @JsonIgnore
    public void  setTxtTaishoshaShimei(TextBox txtTaishoshaShimei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtTaishoshaShimei(txtTaishoshaShimei);
    }

    @JsonIgnore
    public TextBoxCode getTxtHiHokenshaShoNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHiHokenshaShoNo();
    }

    @JsonIgnore
    public void  setTxtHiHokenshaShoNo(TextBoxCode txtHiHokenshaShoNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHiHokenshaShoNo(txtHiHokenshaShoNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtJikoFutanSeiriNom() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtJikoFutanSeiriNom();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNom(TextBoxCode txtJikoFutanSeiriNom) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtJikoFutanSeiriNom(txtJikoFutanSeiriNom);
    }

    @JsonIgnore
    public HorizontalLine getLin4() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin4();
    }

    @JsonIgnore
    public void  setLin4(HorizontalLine lin4) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin4(lin4);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Futangaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Futangaku();
    }

    @JsonIgnore
    public void  setTxtOver70Futangaku(TextBoxNum txtOver70Futangaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Futangaku(txtOver70Futangaku);
    }

    @JsonIgnore
    public TextBox getTxtOver70AmbunRitsu() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70AmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtOver70AmbunRitsu(TextBox txtOver70AmbunRitsu) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70AmbunRitsu(txtOver70AmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Shikyugaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70Shikyugaku(TextBoxNum txtOver70Shikyugaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Shikyugaku(txtOver70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Futangaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Futangaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Futangaku(TextBoxNum txtUnder70Futangaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Futangaku(txtUnder70Futangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutangaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtFutangaku();
    }

    @JsonIgnore
    public void  setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtFutangaku(txtFutangaku);
    }

    @JsonIgnore
    public TextBox getTxtAmbunRitsu() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtAmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtAmbunRitsu(TextBox txtAmbunRitsu) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtAmbunRitsu(txtAmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Shikyugaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Shikyugaku(TextBoxNum txtUnder70Shikyugaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Shikyugaku(txtUnder70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtShikyuGaku(TextBoxNum txtShikyuGaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShikyuGaku(txtShikyuGaku);
    }

    @JsonIgnore
    public HorizontalLine getLin5() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin5();
    }

    @JsonIgnore
    public void  setLin5(HorizontalLine lin5) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin5(lin5);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Biko() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Biko();
    }

    @JsonIgnore
    public void  setTxtOver70Biko(TextBoxNum txtOver70Biko) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Biko(txtOver70Biko);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Biko() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Biko();
    }

    @JsonIgnore
    public void  setTxtUnder70Biko(TextBoxNum txtUnder70Biko) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Biko(txtUnder70Biko);
    }

    @JsonIgnore
    public HorizontalLine getLin7() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin7();
    }

    @JsonIgnore
    public void  setLin7(HorizontalLine lin7) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin7(lin7);
    }

    @JsonIgnore
    public Button getBtnUchiwakeKakutei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeKakutei();
    }

    @JsonIgnore
    public void  setBtnUchiwakeKakutei(Button btnUchiwakeKakutei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeKakutei(btnUchiwakeKakutei);
    }

    @JsonIgnore
    public Button getBtnUchiwakeIchiramModoru() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeIchiramModoru();
    }

    @JsonIgnore
    public void  setBtnUchiwakeIchiramModoru(Button btnUchiwakeIchiramModoru) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeIchiramModoru(btnUchiwakeIchiramModoru);
    }

    @JsonIgnore
    public tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv getTabShikyugakuKeisanKekkaTorokuShikyuGaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku();
    }

    @JsonIgnore
    public void  setTabShikyugakuKeisanKekkaTorokuShikyuGaku(tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv tabShikyugakuKeisanKekkaTorokuShikyuGaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().setTabShikyugakuKeisanKekkaTorokuShikyuGaku(tabShikyugakuKeisanKekkaTorokuShikyuGaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikan() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtTaishoKeisanKikan();
    }

    @JsonIgnore
    public void  setTxtTaishoKeisanKikan(TextBoxDateRange txtTaishoKeisanKikan) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtTaishoKeisanKikan(txtTaishoKeisanKikan);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtJikoFutanSeiriNo();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtJikoFutanSeiriNo(txtJikoFutanSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiFutanSogaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiFutanSogaku();
    }

    @JsonIgnore
    public void  setTxtSetaiFutanSogaku(TextBoxNum txtSetaiFutanSogaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiFutanSogaku(txtSetaiFutanSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiShikyuSogaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiShikyuSogaku();
    }

    @JsonIgnore
    public void  setTxtSetaiShikyuSogaku(TextBoxNum txtSetaiShikyuSogaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiShikyuSogaku(txtSetaiShikyuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SetaiShikyuSogaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SetaiShikyuSogaku();
    }

    @JsonIgnore
    public void  setTxtOver70SetaiShikyuSogaku(TextBoxNum txtOver70SetaiShikyuSogaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SetaiShikyuSogaku(txtOver70SetaiShikyuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiGassanGaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiGassanGaku();
    }

    @JsonIgnore
    public void  setTxtSetaiGassanGaku(TextBoxNum txtSetaiGassanGaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiGassanGaku(txtSetaiGassanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SetaiGassanGaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SetaiGassanGaku();
    }

    @JsonIgnore
    public void  setTxtOver70SetaiGassanGaku(TextBoxNum txtOver70SetaiGassanGaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SetaiGassanGaku(txtOver70SetaiGassanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHonninShikyugaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtHonninShikyugaku();
    }

    @JsonIgnore
    public void  setTxtHonninShikyugaku(TextBoxNum txtHonninShikyugaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtHonninShikyugaku(txtHonninShikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70HonninShikyugaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70HonninShikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70HonninShikyugaku(TextBoxNum txtOver70HonninShikyugaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70HonninShikyugaku(txtOver70HonninShikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSanteiKijunGaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSanteiKijunGaku();
    }

    @JsonIgnore
    public void  setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSanteiKijunGaku(txtSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SanteiKijyunGaku() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SanteiKijyunGaku();
    }

    @JsonIgnore
    public void  setTxtOver70SanteiKijyunGaku(TextBoxNum txtOver70SanteiKijyunGaku) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SanteiKijyunGaku(txtOver70SanteiKijyunGaku);
    }

    @JsonIgnore
    public CheckBoxList getCblTeiShotoku1SaiKeisanUmu() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getCblTeiShotoku1SaiKeisanUmu();
    }

    @JsonIgnore
    public void  setCblTeiShotoku1SaiKeisanUmu(CheckBoxList cblTeiShotoku1SaiKeisanUmu) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setCblTeiShotoku1SaiKeisanUmu(cblTeiShotoku1SaiKeisanUmu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv getTabShikyugakuKeisanKekkaTorokuRenrakuhyo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo();
    }

    @JsonIgnore
    public void  setTabShikyugakuKeisanKekkaTorokuRenrakuhyo(tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv tabShikyugakuKeisanKekkaTorokuRenrakuhyo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().setTabShikyugakuKeisanKekkaTorokuRenrakuhyo(tabShikyugakuKeisanKekkaTorokuRenrakuhyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchiYMD() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getTxtTsuchiYMD();
    }

    @JsonIgnore
    public void  setTxtTsuchiYMD(TextBoxDate txtTsuchiYMD) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setTxtTsuchiYMD(txtTsuchiYMD);
    }

    @JsonIgnore
    public RenrakuhyoHakkoshaPanelDiv getRenrakuhyoHakkoshaPanel() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel();
    }

    @JsonIgnore
    public void  setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanelDiv RenrakuhyoHakkoshaPanel) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanel);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaMei() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaMei();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaMei(TextBox txtRenrakuhyoHakkoshaMei) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaMei(txtRenrakuhyoHakkoshaMei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtRenrakuhyoHakkoshaYubinNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaYubinNo(TextBoxYubinNo txtRenrakuhyoHakkoshaYubinNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaYubinNo(txtRenrakuhyoHakkoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaJusho() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaJusho();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaJusho(TextBox txtRenrakuhyoHakkoshaJusho) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaJusho(txtRenrakuhyoHakkoshaJusho);
    }

    @JsonIgnore
    public ToiawasesakiPanelDiv getToiawasesakiPanel() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel();
    }

    @JsonIgnore
    public void  setToiawasesakiPanel(ToiawasesakiPanelDiv ToiawasesakiPanel) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setToiawasesakiPanel(ToiawasesakiPanel);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho1() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiMeisho1();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho1(TextBox txtToiawasesakiMeisho1) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiMeisho1(txtToiawasesakiMeisho1);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtToiawasesakiYobinNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiYobinNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiYobinNo(TextBoxYubinNo txtToiawasesakiYobinNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiYobinNo(txtToiawasesakiYobinNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho2() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiMeisho2();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho2(TextBox txtToiawasesakiMeisho2) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiMeisho2(txtToiawasesakiMeisho2);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiTelNo() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiTelNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiTelNo(TextBox txtToiawasesakiTelNo) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiTelNo(txtToiawasesakiTelNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiJusho() {
        return this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiJusho();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiJusho(TextBox txtToiawasesakiJusho) {
        this.getShikyugakuKeisanKekkaTorokuDetailPanel().getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiJusho(txtToiawasesakiJusho);
    }

    // </editor-fold>
}
