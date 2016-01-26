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
 * panelShafukukenngengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShafukukenngengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdShafukukeigenngaku")
    private DataGrid<dgdShafukukeigenngaku_Row> dgdShafukukeigenngaku;
    @JsonProperty("panelShakaiFukushiShokai")
    private panelShakaiFukushiShokaiDiv panelShakaiFukushiShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdShafukukeigenngaku
     * @return dgdShafukukeigenngaku
     */
    @JsonProperty("dgdShafukukeigenngaku")
    public DataGrid<dgdShafukukeigenngaku_Row> getDgdShafukukeigenngaku() {
        return dgdShafukukeigenngaku;
    }

    /*
     * setdgdShafukukeigenngaku
     * @param dgdShafukukeigenngaku dgdShafukukeigenngaku
     */
    @JsonProperty("dgdShafukukeigenngaku")
    public void setDgdShafukukeigenngaku(DataGrid<dgdShafukukeigenngaku_Row> dgdShafukukeigenngaku) {
        this.dgdShafukukeigenngaku = dgdShafukukeigenngaku;
    }

    /*
     * getpanelShakaiFukushiShokai
     * @return panelShakaiFukushiShokai
     */
    @JsonProperty("panelShakaiFukushiShokai")
    public panelShakaiFukushiShokaiDiv getPanelShakaiFukushiShokai() {
        return panelShakaiFukushiShokai;
    }

    /*
     * setpanelShakaiFukushiShokai
     * @param panelShakaiFukushiShokai panelShakaiFukushiShokai
     */
    @JsonProperty("panelShakaiFukushiShokai")
    public void setPanelShakaiFukushiShokai(panelShakaiFukushiShokaiDiv panelShakaiFukushiShokai) {
        this.panelShakaiFukushiShokai = panelShakaiFukushiShokai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtServiceShurui() {
        return this.getPanelShakaiFukushiShokai().getTxtServiceShurui();
    }

    @JsonIgnore
    public void  setTxtServiceShurui(TextBox txtServiceShurui) {
        this.getPanelShakaiFukushiShokai().setTxtServiceShurui(txtServiceShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtKengenritsu() {
        return this.getPanelShakaiFukushiShokai().getTxtKengenritsu();
    }

    @JsonIgnore
    public void  setTxtKengenritsu(TextBoxNum txtKengenritsu) {
        this.getPanelShakaiFukushiShokai().setTxtKengenritsu(txtKengenritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutangakuTotal() {
        return this.getPanelShakaiFukushiShokai().getTxtRiyoshaFutangakuTotal();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutangakuTotal(TextBoxNum txtRiyoshaFutangakuTotal) {
        this.getPanelShakaiFukushiShokai().setTxtRiyoshaFutangakuTotal(txtRiyoshaFutangakuTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtKengengaku() {
        return this.getPanelShakaiFukushiShokai().getTxtKengengaku();
    }

    @JsonIgnore
    public void  setTxtKengengaku(TextBoxNum txtKengengaku) {
        this.getPanelShakaiFukushiShokai().setTxtKengengaku(txtKengengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigengoRiyoshaFutangaku() {
        return this.getPanelShakaiFukushiShokai().getTxtKeigengoRiyoshaFutangaku();
    }

    @JsonIgnore
    public void  setTxtKeigengoRiyoshaFutangaku(TextBoxNum txtKeigengoRiyoshaFutangaku) {
        this.getPanelShakaiFukushiShokai().setTxtKeigengoRiyoshaFutangaku(txtKeigengoRiyoshaFutangaku);
    }

    @JsonIgnore
    public TextBox getTxtBikou() {
        return this.getPanelShakaiFukushiShokai().getTxtBikou();
    }

    @JsonIgnore
    public void  setTxtBikou(TextBox txtBikou) {
        this.getPanelShakaiFukushiShokai().setTxtBikou(txtBikou);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelShakaiFukushiShokai().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelShakaiFukushiShokai().setBtnClose(btnClose);
    }

    // </editor-fold>
}
