package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KogakuGassanShikyuKetteiHoseiListPanel のクラスファイル
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiListPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinkiPanel")
    private ShinkiPanelDiv ShinkiPanel;
    @JsonProperty("SearchPanel")
    private SearchPanelDiv SearchPanel;
    @JsonProperty("dgKogakuGassanShikyuFushikyuKettei")
    private DataGrid<dgKogakuGassanShikyuFushikyuKettei_Row> dgKogakuGassanShikyuFushikyuKettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinkiPanel
     * @return ShinkiPanel
     */
    @JsonProperty("ShinkiPanel")
    public ShinkiPanelDiv getShinkiPanel() {
        return ShinkiPanel;
    }

    /*
     * setShinkiPanel
     * @param ShinkiPanel ShinkiPanel
     */
    @JsonProperty("ShinkiPanel")
    public void setShinkiPanel(ShinkiPanelDiv ShinkiPanel) {
        this.ShinkiPanel = ShinkiPanel;
    }

    /*
     * getSearchPanel
     * @return SearchPanel
     */
    @JsonProperty("SearchPanel")
    public SearchPanelDiv getSearchPanel() {
        return SearchPanel;
    }

    /*
     * setSearchPanel
     * @param SearchPanel SearchPanel
     */
    @JsonProperty("SearchPanel")
    public void setSearchPanel(SearchPanelDiv SearchPanel) {
        this.SearchPanel = SearchPanel;
    }

    /*
     * getdgKogakuGassanShikyuFushikyuKettei
     * @return dgKogakuGassanShikyuFushikyuKettei
     */
    @JsonProperty("dgKogakuGassanShikyuFushikyuKettei")
    public DataGrid<dgKogakuGassanShikyuFushikyuKettei_Row> getDgKogakuGassanShikyuFushikyuKettei() {
        return dgKogakuGassanShikyuFushikyuKettei;
    }

    /*
     * setdgKogakuGassanShikyuFushikyuKettei
     * @param dgKogakuGassanShikyuFushikyuKettei dgKogakuGassanShikyuFushikyuKettei
     */
    @JsonProperty("dgKogakuGassanShikyuFushikyuKettei")
    public void setDgKogakuGassanShikyuFushikyuKettei(DataGrid<dgKogakuGassanShikyuFushikyuKettei_Row> dgKogakuGassanShikyuFushikyuKettei) {
        this.dgKogakuGassanShikyuFushikyuKettei = dgKogakuGassanShikyuFushikyuKettei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinkiTaishoNendo() {
        return this.getShinkiPanel().getTxtShinkiTaishoNendo();
    }

    @JsonIgnore
    public void setTxtShinkiTaishoNendo(TextBoxDate txtShinkiTaishoNendo) {
        this.getShinkiPanel().setTxtShinkiTaishoNendo(txtShinkiTaishoNendo);
    }

    @JsonIgnore
    public TextBox getTxtShinkiHihokenshaNo() {
        return this.getShinkiPanel().getTxtShinkiHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtShinkiHihokenshaNo(TextBox txtShinkiHihokenshaNo) {
        this.getShinkiPanel().setTxtShinkiHihokenshaNo(txtShinkiHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShinkiShikyuSeiriNo() {
        return this.getShinkiPanel().getTxtShinkiShikyuSeiriNo();
    }

    @JsonIgnore
    public void setTxtShinkiShikyuSeiriNo(TextBox txtShinkiShikyuSeiriNo) {
        this.getShinkiPanel().setTxtShinkiShikyuSeiriNo(txtShinkiShikyuSeiriNo);
    }

    @JsonIgnore
    public Button getBtnKetteiJohoAdd() {
        return this.getShinkiPanel().getBtnKetteiJohoAdd();
    }

    @JsonIgnore
    public void setBtnKetteiJohoAdd(Button btnKetteiJohoAdd) {
        this.getShinkiPanel().setBtnKetteiJohoAdd(btnKetteiJohoAdd);
    }

    @JsonIgnore
    public TextBoxDate getTxtKensakuTaishoNendo() {
        return this.getSearchPanel().getTxtKensakuTaishoNendo();
    }

    @JsonIgnore
    public void setTxtKensakuTaishoNendo(TextBoxDate txtKensakuTaishoNendo) {
        this.getSearchPanel().setTxtKensakuTaishoNendo(txtKensakuTaishoNendo);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getSearchPanel().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getSearchPanel().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public TextBox getTxtKensakuHihokenshaNo() {
        return this.getSearchPanel().getTxtKensakuHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtKensakuHihokenshaNo(TextBox txtKensakuHihokenshaNo) {
        this.getSearchPanel().setTxtKensakuHihokenshaNo(txtKensakuHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKensakuShikyuSeiriNo() {
        return this.getSearchPanel().getTxtKensakuShikyuSeiriNo();
    }

    @JsonIgnore
    public void setTxtKensakuShikyuSeiriNo(TextBox txtKensakuShikyuSeiriNo) {
        this.getSearchPanel().setTxtKensakuShikyuSeiriNo(txtKensakuShikyuSeiriNo);
    }

    // </editor-fold>
}
