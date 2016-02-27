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
 * JutakuKaishuShinseiInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiInfoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CommHeadPanel")
    private CommHeadPanelDiv CommHeadPanel;
    @JsonProperty("ShokanbaraiKetteiJyohoPanel")
    private ShokanbaraiKetteiJyohoPanelDiv ShokanbaraiKetteiJyohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getShokanbaraiKetteiJyohoPanel
     * @return ShokanbaraiKetteiJyohoPanel
     */
    @JsonProperty("ShokanbaraiKetteiJyohoPanel")
    public ShokanbaraiKetteiJyohoPanelDiv getShokanbaraiKetteiJyohoPanel() {
        return ShokanbaraiKetteiJyohoPanel;
    }

    /*
     * setShokanbaraiKetteiJyohoPanel
     * @param ShokanbaraiKetteiJyohoPanel ShokanbaraiKetteiJyohoPanel
     */
    @JsonProperty("ShokanbaraiKetteiJyohoPanel")
    public void setShokanbaraiKetteiJyohoPanel(ShokanbaraiKetteiJyohoPanelDiv ShokanbaraiKetteiJyohoPanel) {
        this.ShokanbaraiKetteiJyohoPanel = ShokanbaraiKetteiJyohoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getUpLine() {
        return this.getCommHeadPanel().getUpLine();
    }

    @JsonIgnore
    public void  setUpLine(HorizontalLine UpLine) {
        this.getCommHeadPanel().setUpLine(UpLine);
    }

    @JsonIgnore
    public Button getBtnShinseiJyoho() {
        return this.getCommHeadPanel().getBtnShinseiJyoho();
    }

    @JsonIgnore
    public void  setBtnShinseiJyoho(Button btnShinseiJyoho) {
        this.getCommHeadPanel().setBtnShinseiJyoho(btnShinseiJyoho);
    }

    @JsonIgnore
    public Button getBtnShokanKetteiJyoho() {
        return this.getCommHeadPanel().getBtnShokanKetteiJyoho();
    }

    @JsonIgnore
    public void  setBtnShokanKetteiJyoho(Button btnShokanKetteiJyoho) {
        this.getCommHeadPanel().setBtnShokanKetteiJyoho(btnShokanKetteiJyoho);
    }

    @JsonIgnore
    public HorizontalLine getDownLine() {
        return this.getCommHeadPanel().getDownLine();
    }

    @JsonIgnore
    public void  setDownLine(HorizontalLine DownLine) {
        this.getCommHeadPanel().setDownLine(DownLine);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoYM() {
        return this.getCommHeadPanel().getTxtTeikyoYM();
    }

    @JsonIgnore
    public void  setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.getCommHeadPanel().setTxtTeikyoYM(txtTeikyoYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtSeiriNo() {
        return this.getCommHeadPanel().getTxtSeiriNo();
    }

    @JsonIgnore
    public void  setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.getCommHeadPanel().setTxtSeiriNo(txtSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlSyomeisyo() {
        return this.getCommHeadPanel().getDdlSyomeisyo();
    }

    @JsonIgnore
    public void  setDdlSyomeisyo(DropDownList ddlSyomeisyo) {
        this.getCommHeadPanel().setDdlSyomeisyo(ddlSyomeisyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getCommHeadPanel().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getCommHeadPanel().setTxtKyufuritsu(txtKyufuritsu);
    }

    // </editor-fold>
}
