package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoKyufuhiKagoMositateTouroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoKyufuhiKagoMositateTourokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchToKyufujissekiPanel")
    private SearchToKyufujissekiPanelDiv SearchToKyufujissekiPanel;
    @JsonProperty("KyufuJissekiGaitoshaListPanel")
    private KyufuJissekiGaitoshaListPanelDiv KyufuJissekiGaitoshaListPanel;
    @JsonProperty("KagoMoshitatePanel")
    private KagoMoshitatePanelDiv KagoMoshitatePanel;
    @JsonProperty("CommonKiagoKanryoMessageChildDiv1")
    private KaigoKanryoMessageDiv CommonKiagoKanryoMessageChildDiv1;
    @JsonProperty("hdnKyuufuKubunn")
    private RString hdnKyuufuKubunn;
    @JsonProperty("hdnKensaku")
    private RString hdnKensaku;
    @JsonProperty("hdnState")
    private RString hdnState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchToKyufujissekiPanel
     * @return SearchToKyufujissekiPanel
     */
    @JsonProperty("SearchToKyufujissekiPanel")
    public SearchToKyufujissekiPanelDiv getSearchToKyufujissekiPanel() {
        return SearchToKyufujissekiPanel;
    }

    /*
     * setSearchToKyufujissekiPanel
     * @param SearchToKyufujissekiPanel SearchToKyufujissekiPanel
     */
    @JsonProperty("SearchToKyufujissekiPanel")
    public void setSearchToKyufujissekiPanel(SearchToKyufujissekiPanelDiv SearchToKyufujissekiPanel) {
        this.SearchToKyufujissekiPanel = SearchToKyufujissekiPanel;
    }

    /*
     * getKyufuJissekiGaitoshaListPanel
     * @return KyufuJissekiGaitoshaListPanel
     */
    @JsonProperty("KyufuJissekiGaitoshaListPanel")
    public KyufuJissekiGaitoshaListPanelDiv getKyufuJissekiGaitoshaListPanel() {
        return KyufuJissekiGaitoshaListPanel;
    }

    /*
     * setKyufuJissekiGaitoshaListPanel
     * @param KyufuJissekiGaitoshaListPanel KyufuJissekiGaitoshaListPanel
     */
    @JsonProperty("KyufuJissekiGaitoshaListPanel")
    public void setKyufuJissekiGaitoshaListPanel(KyufuJissekiGaitoshaListPanelDiv KyufuJissekiGaitoshaListPanel) {
        this.KyufuJissekiGaitoshaListPanel = KyufuJissekiGaitoshaListPanel;
    }

    /*
     * getKagoMoshitatePanel
     * @return KagoMoshitatePanel
     */
    @JsonProperty("KagoMoshitatePanel")
    public KagoMoshitatePanelDiv getKagoMoshitatePanel() {
        return KagoMoshitatePanel;
    }

    /*
     * setKagoMoshitatePanel
     * @param KagoMoshitatePanel KagoMoshitatePanel
     */
    @JsonProperty("KagoMoshitatePanel")
    public void setKagoMoshitatePanel(KagoMoshitatePanelDiv KagoMoshitatePanel) {
        this.KagoMoshitatePanel = KagoMoshitatePanel;
    }

    /*
     * getCommonKiagoKanryoMessageChildDiv1
     * @return CommonKiagoKanryoMessageChildDiv1
     */
    @JsonProperty("CommonKiagoKanryoMessageChildDiv1")
    public IKaigoKanryoMessageDiv getCommonKiagoKanryoMessageChildDiv1() {
        return CommonKiagoKanryoMessageChildDiv1;
    }

    /*
     * gethdnKyuufuKubunn
     * @return hdnKyuufuKubunn
     */
    @JsonProperty("hdnKyuufuKubunn")
    public RString getHdnKyuufuKubunn() {
        return hdnKyuufuKubunn;
    }

    /*
     * sethdnKyuufuKubunn
     * @param hdnKyuufuKubunn hdnKyuufuKubunn
     */
    @JsonProperty("hdnKyuufuKubunn")
    public void setHdnKyuufuKubunn(RString hdnKyuufuKubunn) {
        this.hdnKyuufuKubunn = hdnKyuufuKubunn;
    }

    /*
     * gethdnKensaku
     * @return hdnKensaku
     */
    @JsonProperty("hdnKensaku")
    public RString getHdnKensaku() {
        return hdnKensaku;
    }

    /*
     * sethdnKensaku
     * @param hdnKensaku hdnKensaku
     */
    @JsonProperty("hdnKensaku")
    public void setHdnKensaku(RString hdnKensaku) {
        this.hdnKensaku = hdnKensaku;
    }

    /*
     * gethdnState
     * @return hdnState
     */
    @JsonProperty("hdnState")
    public RString getHdnState() {
        return hdnState;
    }

    /*
     * sethdnState
     * @param hdnState hdnState
     */
    @JsonProperty("hdnState")
    public void setHdnState(RString hdnState) {
        this.hdnState = hdnState;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHihoNo() {
        return this.getSearchToKyufujissekiPanel().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBox txtHihoNo) {
        this.getSearchToKyufujissekiPanel().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public Button getBtnSearchHihokensha() {
        return this.getSearchToKyufujissekiPanel().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void  setBtnSearchHihokensha(Button btnSearchHihokensha) {
        this.getSearchToKyufujissekiPanel().setBtnSearchHihokensha(btnSearchHihokensha);
    }

    @JsonIgnore
    public TextBox getTxtHihoName() {
        return this.getSearchToKyufujissekiPanel().getTxtHihoName();
    }

    @JsonIgnore
    public void  setTxtHihoName(TextBox txtHihoName) {
        this.getSearchToKyufujissekiPanel().setTxtHihoName(txtHihoName);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return this.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange();
    }

    @JsonIgnore
    public void  setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.getSearchToKyufujissekiPanel().setTxtTeikyoYMRange(txtTeikyoYMRange);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getSearchToKyufujissekiPanel().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getSearchToKyufujissekiPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public CheckBoxList getMoshitateshoSakuseiZumi() {
        return this.getSearchToKyufujissekiPanel().getMoshitateshoSakuseiZumi();
    }

    @JsonIgnore
    public void  setMoshitateshoSakuseiZumi(CheckBoxList MoshitateshoSakuseiZumi) {
        this.getSearchToKyufujissekiPanel().setMoshitateshoSakuseiZumi(MoshitateshoSakuseiZumi);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaSentaku() {
        return this.getSearchToKyufujissekiPanel().getCcdJigyoshaSentaku();
    }

    @JsonIgnore
    public IHokenshaListDiv getHokenshalist() {
        return this.getSearchToKyufujissekiPanel().getHokenshalist();
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLine1() {
        return this.getKagoMoshitatePanel().getHorizontalLine1();
    }

    @JsonIgnore
    public void  setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.getKagoMoshitatePanel().setHorizontalLine1(HorizontalLine1);
    }

    @JsonIgnore
    public TextBoxCode getTxtMeisaiJigyoshaNo() {
        return this.getKagoMoshitatePanel().getTxtMeisaiJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtMeisaiJigyoshaNo(TextBoxCode txtMeisaiJigyoshaNo) {
        this.getKagoMoshitatePanel().setTxtMeisaiJigyoshaNo(txtMeisaiJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtMeisaiJigyoshaName() {
        return this.getKagoMoshitatePanel().getTxtMeisaiJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtMeisaiJigyoshaName(TextBox txtMeisaiJigyoshaName) {
        this.getKagoMoshitatePanel().setTxtMeisaiJigyoshaName(txtMeisaiJigyoshaName);
    }

    @JsonIgnore
    public TextBox getTxtMeisaiMoshitateshaKubun() {
        return this.getKagoMoshitatePanel().getTxtMeisaiMoshitateshaKubun();
    }

    @JsonIgnore
    public void  setTxtMeisaiMoshitateshaKubun(TextBox txtMeisaiMoshitateshaKubun) {
        this.getKagoMoshitatePanel().setTxtMeisaiMoshitateshaKubun(txtMeisaiMoshitateshaKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtMeisaiSendYM() {
        return this.getKagoMoshitatePanel().getTxtMeisaiSendYM();
    }

    @JsonIgnore
    public void  setTxtMeisaiSendYM(TextBoxDate txtMeisaiSendYM) {
        this.getKagoMoshitatePanel().setTxtMeisaiSendYM(txtMeisaiSendYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtMeisaiShokisaiHokenshaNo() {
        return this.getKagoMoshitatePanel().getTxtMeisaiShokisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtMeisaiShokisaiHokenshaNo(TextBoxCode txtMeisaiShokisaiHokenshaNo) {
        this.getKagoMoshitatePanel().setTxtMeisaiShokisaiHokenshaNo(txtMeisaiShokisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtMeisaiShokisaiHokenshaName() {
        return this.getKagoMoshitatePanel().getTxtMeisaiShokisaiHokenshaName();
    }

    @JsonIgnore
    public void  setTxtMeisaiShokisaiHokenshaName(TextBox txtMeisaiShokisaiHokenshaName) {
        this.getKagoMoshitatePanel().setTxtMeisaiShokisaiHokenshaName(txtMeisaiShokisaiHokenshaName);
    }

    @JsonIgnore
    public TextBoxDate getTxtMeisaiTeikyoYM() {
        return this.getKagoMoshitatePanel().getTxtMeisaiTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtMeisaiTeikyoYM(TextBoxDate txtMeisaiTeikyoYM) {
        this.getKagoMoshitatePanel().setTxtMeisaiTeikyoYM(txtMeisaiTeikyoYM);
    }

    @JsonIgnore
    public TextBox getTxtMeisaiKagoForm() {
        return this.getKagoMoshitatePanel().getTxtMeisaiKagoForm();
    }

    @JsonIgnore
    public void  setTxtMeisaiKagoForm(TextBox txtMeisaiKagoForm) {
        this.getKagoMoshitatePanel().setTxtMeisaiKagoForm(txtMeisaiKagoForm);
    }

    @JsonIgnore
    public TextBoxDate getTxtMeisaiMoshitateDate() {
        return this.getKagoMoshitatePanel().getTxtMeisaiMoshitateDate();
    }

    @JsonIgnore
    public void  setTxtMeisaiMoshitateDate(TextBoxDate txtMeisaiMoshitateDate) {
        this.getKagoMoshitatePanel().setTxtMeisaiMoshitateDate(txtMeisaiMoshitateDate);
    }

    @JsonIgnore
    public DropDownList getDdlMeisaiKagoMoshitateRiyu() {
        return this.getKagoMoshitatePanel().getDdlMeisaiKagoMoshitateRiyu();
    }

    @JsonIgnore
    public void  setDdlMeisaiKagoMoshitateRiyu(DropDownList ddlMeisaiKagoMoshitateRiyu) {
        this.getKagoMoshitatePanel().setDdlMeisaiKagoMoshitateRiyu(ddlMeisaiKagoMoshitateRiyu);
    }

    @JsonIgnore
    public CheckBoxList getChkMeisaiForDogetsuShinsa() {
        return this.getKagoMoshitatePanel().getChkMeisaiForDogetsuShinsa();
    }

    @JsonIgnore
    public void  setChkMeisaiForDogetsuShinsa(CheckBoxList chkMeisaiForDogetsuShinsa) {
        this.getKagoMoshitatePanel().setChkMeisaiForDogetsuShinsa(chkMeisaiForDogetsuShinsa);
    }

    @JsonIgnore
    public CheckBoxList getKokuhirenSaiSofu() {
        return this.getKagoMoshitatePanel().getKokuhirenSaiSofu();
    }

    @JsonIgnore
    public void  setKokuhirenSaiSofu(CheckBoxList KokuhirenSaiSofu) {
        this.getKagoMoshitatePanel().setKokuhirenSaiSofu(KokuhirenSaiSofu);
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCommonKaigoshikakuKihonChildDiv2() {
        return this.getKagoMoshitatePanel().getCommonKaigoshikakuKihonChildDiv2();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCommonKaigpAtenainfoChildDiv1() {
        return this.getKagoMoshitatePanel().getCommonKaigpAtenainfoChildDiv1();
    }

    // </editor-fold>
}
