package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJissekiGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiGaitoshaDiv extends Panel {
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
    @JsonProperty("hdn支給限度額一本化年月")
    private RString hdn支給限度額一本化年月;

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
     * gethdn支給限度額一本化年月
     * @return hdn支給限度額一本化年月
     */
    @JsonProperty("hdn支給限度額一本化年月")
    public RString getHdn支給限度額一本化年月() {
        return hdn支給限度額一本化年月;
    }

    /*
     * sethdn支給限度額一本化年月
     * @param hdn支給限度額一本化年月 hdn支給限度額一本化年月
     */
    @JsonProperty("hdn支給限度額一本化年月")
    public void setHdn支給限度額一本化年月(RString hdn支給限度額一本化年月) {
        this.hdn支給限度額一本化年月 = hdn支給限度額一本化年月;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getSearchToKyufujissekiPanel().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getSearchToKyufujissekiPanel().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchHihokensha() {
        return this.getSearchToKyufujissekiPanel().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void  setBtnSearchHihokensha(ButtonDialog btnSearchHihokensha) {
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
    public TextBoxCode getTxtJigyoshaNo() {
        return this.getSearchToKyufujissekiPanel().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.getSearchToKyufujissekiPanel().setTxtJigyoshaNo(txtJigyoshaNo);
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
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return this.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange();
    }

    @JsonIgnore
    public void  setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.getSearchToKyufujissekiPanel().setTxtTeikyoYMRange(txtTeikyoYMRange);
    }

    @JsonIgnore
    public Label getLbl1() {
        return this.getSearchToKyufujissekiPanel().getLbl1();
    }

    @JsonIgnore
    public void  setLbl1(Label lbl1) {
        this.getSearchToKyufujissekiPanel().setLbl1(lbl1);
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
    public DataGrid<dgHihokenshaSearchGaitosha_Row> getDgHihokenshaSearchGaitosha() {
        return this.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha();
    }

    @JsonIgnore
    public void  setDgHihokenshaSearchGaitosha(DataGrid<dgHihokenshaSearchGaitosha_Row> dgHihokenshaSearchGaitosha) {
        this.getKyufuJissekiGaitoshaListPanel().setDgHihokenshaSearchGaitosha(dgHihokenshaSearchGaitosha);
    }

    // </editor-fold>
}
