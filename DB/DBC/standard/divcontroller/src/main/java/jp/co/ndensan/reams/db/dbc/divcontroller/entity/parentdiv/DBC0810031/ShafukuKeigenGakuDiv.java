package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031;
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
 * ShafukuKeigenGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShafukuKeigenGakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
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
    public DataGrid<dgdShafukukeigenngaku_Row> getDgdShafukukeigenngaku() {
        return this.getPanelShafukukenngengaku().getDgdShafukukeigenngaku();
    }

    @JsonIgnore
    public void  setDgdShafukukeigenngaku(DataGrid<dgdShafukukeigenngaku_Row> dgdShafukukeigenngaku) {
        this.getPanelShafukukenngengaku().setDgdShafukukeigenngaku(dgdShafukukeigenngaku);
    }

    @JsonIgnore
    public panelShakaiFukushiShokaiDiv getPanelShakaiFukushiShokai() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai();
    }

    @JsonIgnore
    public void  setPanelShakaiFukushiShokai(panelShakaiFukushiShokaiDiv panelShakaiFukushiShokai) {
        this.getPanelShafukukenngengaku().setPanelShakaiFukushiShokai(panelShakaiFukushiShokai);
    }

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
    public Button getBtnClose() {
        return this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setBtnClose(btnClose);
    }

    // </editor-fold>
}
