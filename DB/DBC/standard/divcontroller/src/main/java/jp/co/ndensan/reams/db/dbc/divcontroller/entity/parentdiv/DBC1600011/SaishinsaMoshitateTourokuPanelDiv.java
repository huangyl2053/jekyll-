package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
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
 * SaishinsaMoshitateTourokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaishinsaMoshitateTourokuPanelDiv extends Panel {
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
    @JsonProperty("hdn再検索フラグ")
    private RString hdn再検索フラグ;
    @JsonProperty("hdn一覧検索条件")
    private RString hdn一覧検索条件;
    @JsonProperty("hdn画面モード")
    private RString hdn画面モード;
    @JsonProperty("hdn履歴番号")
    private RString hdn履歴番号;
    @JsonProperty("hdnActiveRowId")
    private RString hdnActiveRowId;
    @JsonProperty("hdn被保険者番号")
    private RString hdn被保険者番号;
    @JsonProperty("hdn識別コード")
    private RString hdn識別コード;

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
     * gethdn再検索フラグ
     * @return hdn再検索フラグ
     */
    @JsonProperty("hdn再検索フラグ")
    public RString getHdn再検索フラグ() {
        return hdn再検索フラグ;
    }

    /*
     * sethdn再検索フラグ
     * @param hdn再検索フラグ hdn再検索フラグ
     */
    @JsonProperty("hdn再検索フラグ")
    public void setHdn再検索フラグ(RString hdn再検索フラグ) {
        this.hdn再検索フラグ = hdn再検索フラグ;
    }

    /*
     * gethdn一覧検索条件
     * @return hdn一覧検索条件
     */
    @JsonProperty("hdn一覧検索条件")
    public RString getHdn一覧検索条件() {
        return hdn一覧検索条件;
    }

    /*
     * sethdn一覧検索条件
     * @param hdn一覧検索条件 hdn一覧検索条件
     */
    @JsonProperty("hdn一覧検索条件")
    public void setHdn一覧検索条件(RString hdn一覧検索条件) {
        this.hdn一覧検索条件 = hdn一覧検索条件;
    }

    /*
     * gethdn画面モード
     * @return hdn画面モード
     */
    @JsonProperty("hdn画面モード")
    public RString getHdn画面モード() {
        return hdn画面モード;
    }

    /*
     * sethdn画面モード
     * @param hdn画面モード hdn画面モード
     */
    @JsonProperty("hdn画面モード")
    public void setHdn画面モード(RString hdn画面モード) {
        this.hdn画面モード = hdn画面モード;
    }

    /*
     * gethdn履歴番号
     * @return hdn履歴番号
     */
    @JsonProperty("hdn履歴番号")
    public RString getHdn履歴番号() {
        return hdn履歴番号;
    }

    /*
     * sethdn履歴番号
     * @param hdn履歴番号 hdn履歴番号
     */
    @JsonProperty("hdn履歴番号")
    public void setHdn履歴番号(RString hdn履歴番号) {
        this.hdn履歴番号 = hdn履歴番号;
    }

    /*
     * gethdnActiveRowId
     * @return hdnActiveRowId
     */
    @JsonProperty("hdnActiveRowId")
    public RString getHdnActiveRowId() {
        return hdnActiveRowId;
    }

    /*
     * sethdnActiveRowId
     * @param hdnActiveRowId hdnActiveRowId
     */
    @JsonProperty("hdnActiveRowId")
    public void setHdnActiveRowId(RString hdnActiveRowId) {
        this.hdnActiveRowId = hdnActiveRowId;
    }

    /*
     * gethdn被保険者番号
     * @return hdn被保険者番号
     */
    @JsonProperty("hdn被保険者番号")
    public RString getHdn被保険者番号() {
        return hdn被保険者番号;
    }

    /*
     * sethdn被保険者番号
     * @param hdn被保険者番号 hdn被保険者番号
     */
    @JsonProperty("hdn被保険者番号")
    public void setHdn被保険者番号(RString hdn被保険者番号) {
        this.hdn被保険者番号 = hdn被保険者番号;
    }

    /*
     * gethdn識別コード
     * @return hdn識別コード
     */
    @JsonProperty("hdn識別コード")
    public RString getHdn識別コード() {
        return hdn識別コード;
    }

    /*
     * sethdn識別コード
     * @param hdn識別コード hdn識別コード
     */
    @JsonProperty("hdn識別コード")
    public void setHdn識別コード(RString hdn識別コード) {
        this.hdn識別コード = hdn識別コード;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTextBox1() {
        return this.getSearchToKyufujissekiPanel().getTextBox1();
    }

    @JsonIgnore
    public void  setTextBox1(TextBoxCode TextBox1) {
        this.getSearchToKyufujissekiPanel().setTextBox1(TextBox1);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchJigyosha() {
        return this.getSearchToKyufujissekiPanel().getBtnSearchJigyosha();
    }

    @JsonIgnore
    public void  setBtnSearchJigyosha(ButtonDialog btnSearchJigyosha) {
        this.getSearchToKyufujissekiPanel().setBtnSearchJigyosha(btnSearchJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getSearchToKyufujissekiPanel().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getSearchToKyufujissekiPanel().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getSearchToKyufujissekiPanel().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
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
    public Button getButton1() {
        return this.getSearchToKyufujissekiPanel().getButton1();
    }

    @JsonIgnore
    public void  setButton1(Button Button1) {
        this.getSearchToKyufujissekiPanel().setButton1(Button1);
    }

    @JsonIgnore
    public IHokenshaListDiv getHokenshaList() {
        return this.getSearchToKyufujissekiPanel().getHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgHihokenshaSearchGaitosha_Row> getDgHihokenshaSearchGaitosha() {
        return this.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha();
    }

    @JsonIgnore
    public void  setDgHihokenshaSearchGaitosha(DataGrid<dgHihokenshaSearchGaitosha_Row> dgHihokenshaSearchGaitosha) {
        this.getKyufuJissekiGaitoshaListPanel().setDgHihokenshaSearchGaitosha(dgHihokenshaSearchGaitosha);
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
    public TextBox getTextBox2() {
        return this.getKagoMoshitatePanel().getTextBox2();
    }

    @JsonIgnore
    public void  setTextBox2(TextBox TextBox2) {
        this.getKagoMoshitatePanel().setTextBox2(TextBox2);
    }

    @JsonIgnore
    public TextBox getTextBox3() {
        return this.getKagoMoshitatePanel().getTextBox3();
    }

    @JsonIgnore
    public void  setTextBox3(TextBox TextBox3) {
        this.getKagoMoshitatePanel().setTextBox3(TextBox3);
    }

    @JsonIgnore
    public TextBox getTextBox5() {
        return this.getKagoMoshitatePanel().getTextBox5();
    }

    @JsonIgnore
    public void  setTextBox5(TextBox TextBox5) {
        this.getKagoMoshitatePanel().setTextBox5(TextBox5);
    }

    @JsonIgnore
    public TextBox getTextBox6() {
        return this.getKagoMoshitatePanel().getTextBox6();
    }

    @JsonIgnore
    public void  setTextBox6(TextBox TextBox6) {
        this.getKagoMoshitatePanel().setTextBox6(TextBox6);
    }

    @JsonIgnore
    public TextBox getTextBox7() {
        return this.getKagoMoshitatePanel().getTextBox7();
    }

    @JsonIgnore
    public void  setTextBox7(TextBox TextBox7) {
        this.getKagoMoshitatePanel().setTextBox7(TextBox7);
    }

    @JsonIgnore
    public TextBox getTextBox11() {
        return this.getKagoMoshitatePanel().getTextBox11();
    }

    @JsonIgnore
    public void  setTextBox11(TextBox TextBox11) {
        this.getKagoMoshitatePanel().setTextBox11(TextBox11);
    }

    @JsonIgnore
    public RadioButton getRadioButton1() {
        return this.getKagoMoshitatePanel().getRadioButton1();
    }

    @JsonIgnore
    public void  setRadioButton1(RadioButton RadioButton1) {
        this.getKagoMoshitatePanel().setRadioButton1(RadioButton1);
    }

    @JsonIgnore
    public DropDownList getDropDownList3() {
        return this.getKagoMoshitatePanel().getDropDownList3();
    }

    @JsonIgnore
    public void  setDropDownList3(DropDownList DropDownList3) {
        this.getKagoMoshitatePanel().setDropDownList3(DropDownList3);
    }

    @JsonIgnore
    public DropDownList getDropDownList6() {
        return this.getKagoMoshitatePanel().getDropDownList6();
    }

    @JsonIgnore
    public void  setDropDownList6(DropDownList DropDownList6) {
        this.getKagoMoshitatePanel().setDropDownList6(DropDownList6);
    }

    @JsonIgnore
    public DropDownList getDropDownList7() {
        return this.getKagoMoshitatePanel().getDropDownList7();
    }

    @JsonIgnore
    public void  setDropDownList7(DropDownList DropDownList7) {
        this.getKagoMoshitatePanel().setDropDownList7(DropDownList7);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate1() {
        return this.getKagoMoshitatePanel().getTextBoxDate1();
    }

    @JsonIgnore
    public void  setTextBoxDate1(TextBoxDate TextBoxDate1) {
        this.getKagoMoshitatePanel().setTextBoxDate1(TextBoxDate1);
    }

    @JsonIgnore
    public DropDownList getDropDownList2() {
        return this.getKagoMoshitatePanel().getDropDownList2();
    }

    @JsonIgnore
    public void  setDropDownList2(DropDownList DropDownList2) {
        this.getKagoMoshitatePanel().setDropDownList2(DropDownList2);
    }

    @JsonIgnore
    public TextBox getTextBox12() {
        return this.getKagoMoshitatePanel().getTextBox12();
    }

    @JsonIgnore
    public void  setTextBox12(TextBox TextBox12) {
        this.getKagoMoshitatePanel().setTextBox12(TextBox12);
    }

    @JsonIgnore
    public DropDownList getDropDownList4() {
        return this.getKagoMoshitatePanel().getDropDownList4();
    }

    @JsonIgnore
    public void  setDropDownList4(DropDownList DropDownList4) {
        this.getKagoMoshitatePanel().setDropDownList4(DropDownList4);
    }

    @JsonIgnore
    public CheckBoxList getCheckBoxList1() {
        return this.getKagoMoshitatePanel().getCheckBoxList1();
    }

    @JsonIgnore
    public void  setCheckBoxList1(CheckBoxList CheckBoxList1) {
        this.getKagoMoshitatePanel().setCheckBoxList1(CheckBoxList1);
    }

    @JsonIgnore
    public DropDownList getDropDownList5() {
        return this.getKagoMoshitatePanel().getDropDownList5();
    }

    @JsonIgnore
    public void  setDropDownList5(DropDownList DropDownList5) {
        this.getKagoMoshitatePanel().setDropDownList5(DropDownList5);
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
