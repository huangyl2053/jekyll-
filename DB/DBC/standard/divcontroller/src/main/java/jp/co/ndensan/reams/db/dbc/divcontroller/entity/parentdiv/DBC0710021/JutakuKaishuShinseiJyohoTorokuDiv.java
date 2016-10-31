package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinseiJyohoToroku のクラスファイル
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiJyohoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    private JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel;
    @JsonProperty("CommHeadPanel")
    private CommHeadPanelDiv CommHeadPanel;
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    private JutakuShikyuShinseiKanryoPanelDiv JutakuShikyuShinseiKanryoPanel;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutakuKaishuShinseiHihokenshaPanel
     * @return JutakuKaishuShinseiHihokenshaPanel
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    public JutakuKaishuShinseiHihokenshaPanelDiv getJutakuKaishuShinseiHihokenshaPanel() {
        return JutakuKaishuShinseiHihokenshaPanel;
    }

    /*
     * setJutakuKaishuShinseiHihokenshaPanel
     * @param JutakuKaishuShinseiHihokenshaPanel JutakuKaishuShinseiHihokenshaPanel
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    public void setJutakuKaishuShinseiHihokenshaPanel(JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel) {
        this.JutakuKaishuShinseiHihokenshaPanel = JutakuKaishuShinseiHihokenshaPanel;
    }

    /*
     * getCommHeadPanel
     * @return CommHeadPanel
     */
    @JsonProperty("CommHeadPanel")
    public CommHeadPanelDiv getCommHeadPanel() {
        return CommHeadPanel;
    }

    /*
     * setCommHeadPanel
     * @param CommHeadPanel CommHeadPanel
     */
    @JsonProperty("CommHeadPanel")
    public void setCommHeadPanel(CommHeadPanelDiv CommHeadPanel) {
        this.CommHeadPanel = CommHeadPanel;
    }

    /*
     * getJutakuShikyuShinseiKanryoPanel
     * @return JutakuShikyuShinseiKanryoPanel
     */
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    public JutakuShikyuShinseiKanryoPanelDiv getJutakuShikyuShinseiKanryoPanel() {
        return JutakuShikyuShinseiKanryoPanel;
    }

    /*
     * setJutakuShikyuShinseiKanryoPanel
     * @param JutakuShikyuShinseiKanryoPanel JutakuShikyuShinseiKanryoPanel
     */
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    public void setJutakuShikyuShinseiKanryoPanel(JutakuShikyuShinseiKanryoPanelDiv JutakuShikyuShinseiKanryoPanel) {
        this.JutakuShikyuShinseiKanryoPanel = JutakuShikyuShinseiKanryoPanel;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getUpLine() {
        return this.getCommHeadPanel().getUpLine();
    }

    @JsonIgnore
    public void setUpLine(HorizontalLine UpLine) {
        this.getCommHeadPanel().setUpLine(UpLine);
    }

    @JsonIgnore
    public Button getBtnShinseiJyoho() {
        return this.getCommHeadPanel().getBtnShinseiJyoho();
    }

    @JsonIgnore
    public void setBtnShinseiJyoho(Button btnShinseiJyoho) {
        this.getCommHeadPanel().setBtnShinseiJyoho(btnShinseiJyoho);
    }

    @JsonIgnore
    public Button getBtnShokanKetteiJyoho() {
        return this.getCommHeadPanel().getBtnShokanKetteiJyoho();
    }

    @JsonIgnore
    public void setBtnShokanKetteiJyoho(Button btnShokanKetteiJyoho) {
        this.getCommHeadPanel().setBtnShokanKetteiJyoho(btnShokanKetteiJyoho);
    }

    @JsonIgnore
    public HorizontalLine getDownLine() {
        return this.getCommHeadPanel().getDownLine();
    }

    @JsonIgnore
    public void setDownLine(HorizontalLine DownLine) {
        this.getCommHeadPanel().setDownLine(DownLine);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoYM() {
        return this.getCommHeadPanel().getTxtTeikyoYM();
    }

    @JsonIgnore
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.getCommHeadPanel().setTxtTeikyoYM(txtTeikyoYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtSeiriNo() {
        return this.getCommHeadPanel().getTxtSeiriNo();
    }

    @JsonIgnore
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.getCommHeadPanel().setTxtSeiriNo(txtSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlSyomeisyo() {
        return this.getCommHeadPanel().getDdlSyomeisyo();
    }

    @JsonIgnore
    public void setDdlSyomeisyo(DropDownList ddlSyomeisyo) {
        this.getCommHeadPanel().setDdlSyomeisyo(ddlSyomeisyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getCommHeadPanel().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getCommHeadPanel().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public tabShinseiContentsDiv getTabShinseiContents() {
        return this.getCommHeadPanel().getTabShinseiContents();
    }

    @JsonIgnore
    public void setTabShinseiContents(tabShinseiContentsDiv tabShinseiContents) {
        this.getCommHeadPanel().setTabShinseiContents(tabShinseiContents);
    }

    @JsonIgnore
    public tabShinseiJyohoDiv getTabShinseiJyoho() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabShinseiJyoho();
    }

    @JsonIgnore
    public void setTabShinseiJyoho(tabShinseiJyohoDiv tabShinseiJyoho) {
        this.getCommHeadPanel().getTabShinseiContents().setTabShinseiJyoho(tabShinseiJyoho);
    }

    @JsonIgnore
    public JutakuKaishuShinseiContentsDiv getJutakuKaishuShinseiContents() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabShinseiJyoho().getJutakuKaishuShinseiContents();
    }

    @JsonIgnore
    public void setJutakuKaishuShinseiContents(JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents) {
        this.getCommHeadPanel().getTabShinseiContents().getTabShinseiJyoho().setJutakuKaishuShinseiContents(JutakuKaishuShinseiContents);
    }

    @JsonIgnore
    public tabKozaJyohoDiv getTabKozaJyoho() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabKozaJyoho();
    }

    @JsonIgnore
    public void setTabKozaJyoho(tabKozaJyohoDiv tabKozaJyoho) {
        this.getCommHeadPanel().getTabShinseiContents().setTabKozaJyoho(tabKozaJyoho);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabKozaJyoho().getCcdShiharaiHohoJyoho();
    }

    @JsonIgnore
    public tabJutakuKaisyuJyohoDiv getTabJutakuKaisyuJyoho() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho();
    }

    @JsonIgnore
    public void setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyohoDiv tabJutakuKaisyuJyoho) {
        this.getCommHeadPanel().getTabShinseiContents().setTabJutakuKaisyuJyoho(tabJutakuKaisyuJyoho);
    }

    @JsonIgnore
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getJutakuKaishuShinseiResetInfo();
    }

    @JsonIgnore
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.getCommHeadPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfo);
    }

    @JsonIgnore
    public IJyutakugaisyunaiyoListDiv getCcdJutakugaisyunaiyoList() {
        return this.getCommHeadPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getCcdJutakugaisyunaiyoList();
    }

    // </editor-fold>
}
