package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MainPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MainPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    private JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel;
    @JsonProperty("JutakuKaishuShinseiInfoPanel")
    private JutakuKaishuShinseiInfoPanelDiv JutakuKaishuShinseiInfoPanel;
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    private JutakuShikyuShinseiKanryoPanelDiv JutakuShikyuShinseiKanryoPanel;

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
     * getJutakuKaishuShinseiInfoPanel
     * @return JutakuKaishuShinseiInfoPanel
     */
    @JsonProperty("JutakuKaishuShinseiInfoPanel")
    public JutakuKaishuShinseiInfoPanelDiv getJutakuKaishuShinseiInfoPanel() {
        return JutakuKaishuShinseiInfoPanel;
    }

    /*
     * setJutakuKaishuShinseiInfoPanel
     * @param JutakuKaishuShinseiInfoPanel JutakuKaishuShinseiInfoPanel
     */
    @JsonProperty("JutakuKaishuShinseiInfoPanel")
    public void setJutakuKaishuShinseiInfoPanel(JutakuKaishuShinseiInfoPanelDiv JutakuKaishuShinseiInfoPanel) {
        this.JutakuKaishuShinseiInfoPanel = JutakuKaishuShinseiInfoPanel;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getUpLine() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getUpLine();
    }

    @JsonIgnore
    public void  setUpLine(HorizontalLine UpLine) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setUpLine(UpLine);
    }

    @JsonIgnore
    public Button getBtnShinseiJyoho() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getBtnShinseiJyoho();
    }

    @JsonIgnore
    public void  setBtnShinseiJyoho(Button btnShinseiJyoho) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setBtnShinseiJyoho(btnShinseiJyoho);
    }

    @JsonIgnore
    public Button getBtnShokanKetteiJyoho() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getBtnShokanKetteiJyoho();
    }

    @JsonIgnore
    public void  setBtnShokanKetteiJyoho(Button btnShokanKetteiJyoho) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setBtnShokanKetteiJyoho(btnShokanKetteiJyoho);
    }

    @JsonIgnore
    public HorizontalLine getDownLine() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getDownLine();
    }

    @JsonIgnore
    public void  setDownLine(HorizontalLine DownLine) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setDownLine(DownLine);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoYM() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setTxtTeikyoYM(txtTeikyoYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtSeiriNo() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtSeiriNo();
    }

    @JsonIgnore
    public void  setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setTxtSeiriNo(txtSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlSyomeisyo() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getDdlSyomeisyo();
    }

    @JsonIgnore
    public void  setDdlSyomeisyo(DropDownList ddlSyomeisyo) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setDdlSyomeisyo(ddlSyomeisyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().setTxtKyufuritsu(txtKyufuritsu);
    }

    // </editor-fold>
}
