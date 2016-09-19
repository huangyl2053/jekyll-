package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KogakuGassanShikyuKetteiHoseiPanel のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("KogakuGassanShikyuKetteiHoseiListPanel")
    private KogakuGassanShikyuKetteiHoseiListPanelDiv KogakuGassanShikyuKetteiHoseiListPanel;
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetailPanel")
    private KogakuGassanShikyuKetteiHoseiDetailPanelDiv KogakuGassanShikyuKetteiHoseiDetailPanel;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("事業分フラグ")
    private RString 事業分フラグ;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getKogakuGassanShikyuKetteiHoseiListPanel
     * @return KogakuGassanShikyuKetteiHoseiListPanel
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiListPanel")
    public KogakuGassanShikyuKetteiHoseiListPanelDiv getKogakuGassanShikyuKetteiHoseiListPanel() {
        return KogakuGassanShikyuKetteiHoseiListPanel;
    }

    /*
     * setKogakuGassanShikyuKetteiHoseiListPanel
     * @param KogakuGassanShikyuKetteiHoseiListPanel KogakuGassanShikyuKetteiHoseiListPanel
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiListPanel")
    public void setKogakuGassanShikyuKetteiHoseiListPanel(KogakuGassanShikyuKetteiHoseiListPanelDiv KogakuGassanShikyuKetteiHoseiListPanel) {
        this.KogakuGassanShikyuKetteiHoseiListPanel = KogakuGassanShikyuKetteiHoseiListPanel;
    }

    /*
     * getKogakuGassanShikyuKetteiHoseiDetailPanel
     * @return KogakuGassanShikyuKetteiHoseiDetailPanel
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetailPanel")
    public KogakuGassanShikyuKetteiHoseiDetailPanelDiv getKogakuGassanShikyuKetteiHoseiDetailPanel() {
        return KogakuGassanShikyuKetteiHoseiDetailPanel;
    }

    /*
     * setKogakuGassanShikyuKetteiHoseiDetailPanel
     * @param KogakuGassanShikyuKetteiHoseiDetailPanel KogakuGassanShikyuKetteiHoseiDetailPanel
     */
    @JsonProperty("KogakuGassanShikyuKetteiHoseiDetailPanel")
    public void setKogakuGassanShikyuKetteiHoseiDetailPanel(KogakuGassanShikyuKetteiHoseiDetailPanelDiv KogakuGassanShikyuKetteiHoseiDetailPanel) {
        this.KogakuGassanShikyuKetteiHoseiDetailPanel = KogakuGassanShikyuKetteiHoseiDetailPanel;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * get事業分フラグ
     * @return 事業分フラグ
     */
    @JsonProperty("事業分フラグ")
    public RString get事業分フラグ() {
        return 事業分フラグ;
    }

    /*
     * set事業分フラグ
     * @param 事業分フラグ 事業分フラグ
     */
    @JsonProperty("事業分フラグ")
    public void set事業分フラグ(RString 事業分フラグ) {
        this.事業分フラグ = 事業分フラグ;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShinkiPanelDiv getShinkiPanel() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel();
    }

    @JsonIgnore
    public void setShinkiPanel(ShinkiPanelDiv ShinkiPanel) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().setShinkiPanel(ShinkiPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinkiTaishoNendo() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().getTxtShinkiTaishoNendo();
    }

    @JsonIgnore
    public void setTxtShinkiTaishoNendo(TextBoxDate txtShinkiTaishoNendo) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().setTxtShinkiTaishoNendo(txtShinkiTaishoNendo);
    }

    @JsonIgnore
    public TextBox getTxtShinkiHihokenshaNo() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().getTxtShinkiHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtShinkiHihokenshaNo(TextBox txtShinkiHihokenshaNo) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().setTxtShinkiHihokenshaNo(txtShinkiHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShinkiShikyuSeiriNo() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().getTxtShinkiShikyuSeiriNo();
    }

    @JsonIgnore
    public void setTxtShinkiShikyuSeiriNo(TextBox txtShinkiShikyuSeiriNo) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().setTxtShinkiShikyuSeiriNo(txtShinkiShikyuSeiriNo);
    }

    @JsonIgnore
    public Button getBtnKetteiJohoAdd() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().getBtnKetteiJohoAdd();
    }

    @JsonIgnore
    public void setBtnKetteiJohoAdd(Button btnKetteiJohoAdd) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getShinkiPanel().setBtnKetteiJohoAdd(btnKetteiJohoAdd);
    }

    @JsonIgnore
    public SearchPanelDiv getSearchPanel() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel();
    }

    @JsonIgnore
    public void setSearchPanel(SearchPanelDiv SearchPanel) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().setSearchPanel(SearchPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtKensakuTaishoNendo() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().getTxtKensakuTaishoNendo();
    }

    @JsonIgnore
    public void setTxtKensakuTaishoNendo(TextBoxDate txtKensakuTaishoNendo) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().setTxtKensakuTaishoNendo(txtKensakuTaishoNendo);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public TextBox getTxtKensakuHihokenshaNo() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().getTxtKensakuHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtKensakuHihokenshaNo(TextBox txtKensakuHihokenshaNo) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().setTxtKensakuHihokenshaNo(txtKensakuHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKensakuShikyuSeiriNo() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().getTxtKensakuShikyuSeiriNo();
    }

    @JsonIgnore
    public void setTxtKensakuShikyuSeiriNo(TextBox txtKensakuShikyuSeiriNo) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().getSearchPanel().setTxtKensakuShikyuSeiriNo(txtKensakuShikyuSeiriNo);
    }

    @JsonIgnore
    public DataGrid<dgKogakuGassanShikyuFushikyuKettei_Row> getDgKogakuGassanShikyuFushikyuKettei() {
        return this.getKogakuGassanShikyuKetteiHoseiListPanel().getDgKogakuGassanShikyuFushikyuKettei();
    }

    @JsonIgnore
    public void setDgKogakuGassanShikyuFushikyuKettei(DataGrid<dgKogakuGassanShikyuFushikyuKettei_Row> dgKogakuGassanShikyuFushikyuKettei) {
        this.getKogakuGassanShikyuKetteiHoseiListPanel().setDgKogakuGassanShikyuFushikyuKettei(dgKogakuGassanShikyuFushikyuKettei);
    }

    @JsonIgnore
    public TextBox getTxtStatusFlg() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtStatusFlg();
    }

    @JsonIgnore
    public void setTxtStatusFlg(TextBox txtStatusFlg) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setTxtStatusFlg(txtStatusFlg);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoNendo() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShikyuSeiriNo() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyuSeiriNo();
    }

    @JsonIgnore
    public void setTxtShikyuSeiriNo(TextBox txtShikyuSeiriNo) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setTxtShikyuSeiriNo(txtShikyuSeiriNo);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setLin2(lin2);
    }

    @JsonIgnore
    public tabKogakuGassanShikyuFushikyuKetteiDiv getTabKogakuGassanShikyuFushikyuKettei() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei();
    }

    @JsonIgnore
    public void setTabKogakuGassanShikyuFushikyuKettei(tabKogakuGassanShikyuFushikyuKetteiDiv tabKogakuGassanShikyuFushikyuKettei) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setTabKogakuGassanShikyuFushikyuKettei(tabKogakuGassanShikyuFushikyuKettei);
    }

    @JsonIgnore
    public tplKetteiDiv getTplKettei() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei();
    }

    @JsonIgnore
    public void setTplKettei(tplKetteiDiv tplKettei) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().setTplKettei(tplKettei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKeisanYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtKeisanYMD();
    }

    @JsonIgnore
    public void setTxtKeisanYMD(TextBoxDateRange txtKeisanYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtKeisanYMD(txtKeisanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNo() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtJikoFutanSeiriNo();
    }

    @JsonIgnore
    public void setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtJikoFutanSeiriNo(txtJikoFutanSeiriNo);
    }

    @JsonIgnore
    public KogakuGassanShikyuKetteiHoseiDetail1Div getKogakuGassanShikyuKetteiHoseiDetail1() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1();
    }

    @JsonIgnore
    public void setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1Div KogakuGassanShikyuKetteiHoseiDetail1) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setKogakuGassanShikyuKetteiHoseiDetail1(KogakuGassanShikyuKetteiHoseiDetail1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanSogaku() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtJikoFutanSogaku();
    }

    @JsonIgnore
    public void setTxtJikoFutanSogaku(TextBoxNum txtJikoFutanSogaku) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtJikoFutanSogaku(txtJikoFutanSogaku);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunCode() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getRadShikyuKubunCode();
    }

    @JsonIgnore
    public void setRadShikyuKubunCode(RadioButton radShikyuKubunCode) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setRadShikyuKubunCode(radShikyuKubunCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyugaku() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().getTxtShikyugaku();
    }

    @JsonIgnore
    public void setTxtShikyugaku(TextBoxNum txtShikyugaku) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail1().setTxtShikyugaku(txtShikyugaku);
    }

    @JsonIgnore
    public KogakuGassanShikyuKetteiHoseiDetail2Div getKogakuGassanShikyuKetteiHoseiDetail2() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2();
    }

    @JsonIgnore
    public void setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2Div KogakuGassanShikyuKetteiHoseiDetail2) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setKogakuGassanShikyuKetteiHoseiDetail2(KogakuGassanShikyuKetteiHoseiDetail2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyufuShurui() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().getTxtKyufuShurui();
    }

    @JsonIgnore
    public void setTxtKyufuShurui(TextBoxMultiLine txtKyufuShurui) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().setTxtKyufuShurui(txtKyufuShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getKogakuGassanShikyuKetteiHoseiDetail2().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setLin3(lin3);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiSakuseiYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtKetteiTsuchiSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiSakuseiYMD(TextBoxDate txtKetteiTsuchiSakuseiYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtKetteiTsuchiSakuseiYMD(txtKetteiTsuchiSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtFurikomiTsuchiSakuseiYMD() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().getTxtFurikomiTsuchiSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtFurikomiTsuchiSakuseiYMD(TextBoxDate txtFurikomiTsuchiSakuseiYMD) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplKettei().setTxtFurikomiTsuchiSakuseiYMD(txtFurikomiTsuchiSakuseiYMD);
    }

    @JsonIgnore
    public tplShiharaiDiv getTplShiharai() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplShiharai();
    }

    @JsonIgnore
    public void setTplShiharai(tplShiharaiDiv tplShiharai) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().setTplShiharai(tplShiharai);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().getTplShiharai().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public Button getBtnIchiramModoru() {
        return this.getKogakuGassanShikyuKetteiHoseiDetailPanel().getBtnIchiramModoru();
    }

    @JsonIgnore
    public void setBtnIchiramModoru(Button btnIchiramModoru) {
        this.getKogakuGassanShikyuKetteiHoseiDetailPanel().setBtnIchiramModoru(btnIchiramModoru);
    }

    // </editor-fold>
}
