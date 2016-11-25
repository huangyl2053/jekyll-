package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031;
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
 * ShafukuKeigenGakuPanel のクラスファイル 
 * 
 * @reamsid_L DBC-1030-080 xuhao
 */
public class ShafukuKeigenGakuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelShafukukenngengaku")
    private panelShafukukenngengakuDiv panelShafukukenngengaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
    }

    /*
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpanelShafukukenngengaku
     * @return panelShafukukenngengaku
     */
    @JsonProperty("panelShafukukenngengaku")
    public panelShafukukenngengakuDiv getPanelShafukukenngengaku() {
        return panelShafukukenngengaku;
    }

    /*
     * setpanelShafukukenngengaku
     * @param panelShafukukenngengaku panelShafukukenngengaku
     */
    @JsonProperty("panelShafukukenngengaku")
    public void setPanelShafukukenngengaku(panelShafukukenngengakuDiv panelShafukukenngengaku) {
        this.panelShafukukenngengaku = panelShafukukenngengaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlServiceShurui() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlServiceShurui();
    }

    @JsonIgnore
    public void  setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setDdlServiceShurui(ddlServiceShurui);
    }

    @JsonIgnore
    public DropDownList getDdlKengenritsu() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getDdlKengenritsu();
    }

    @JsonIgnore
    public void  setDdlKengenritsu(DropDownList ddlKengenritsu) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setDdlKengenritsu(ddlKengenritsu);
    }

    @JsonIgnore
    public Button getBtnCal() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getBtnCal();
    }

    @JsonIgnore
    public void  setBtnCal(Button btnCal) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setBtnCal(btnCal);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutangakuTotal() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutangakuTotal(TextBoxNum txtRiyoshaFutangakuTotal) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setTxtRiyoshaFutangakuTotal(txtRiyoshaFutangakuTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKengengaku() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKengengaku();
    }

    @JsonIgnore
    public void  setTxtKengengaku(TextBoxNum txtKengengaku) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setTxtKengengaku(txtKengengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigengoRiyoshaFutangaku() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku();
    }

    @JsonIgnore
    public void  setTxtKeigengoRiyoshaFutangaku(TextBoxNum txtKeigengoRiyoshaFutangaku) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setTxtKeigengoRiyoshaFutangaku(txtKeigengoRiyoshaFutangaku);
    }

    @JsonIgnore
    public TextBox getTxtBikou() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getTxtBikou();
    }

    @JsonIgnore
    public void  setTxtBikou(TextBox txtBikou) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setTxtBikou(txtBikou);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setBtnClear(btnClear);
    }

    // </editor-fold>
}
