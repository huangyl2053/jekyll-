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
 * panelShafukukenngengaku のクラスファイル 
 * 
 * @reamsid_L DBC-1030-080 xuhao
 */
public class panelShafukukenngengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdShafukukeigenngaku")
    private DataGrid<dgdShafukukeigenngaku_Row> dgdShafukukeigenngaku;
    @JsonProperty("panelShakaiFukushiShokai")
    private panelShakaiFukushiShokaiDiv panelShakaiFukushiShokai;
    @JsonProperty("rowId")
    private TextBoxNum rowId;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

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
     * getrowId
     * @return rowId
     */
    @JsonProperty("rowId")
    public TextBoxNum getRowId() {
        return rowId;
    }

    /*
     * setrowId
     * @param rowId rowId
     */
    @JsonProperty("rowId")
    public void setRowId(TextBoxNum rowId) {
        this.rowId = rowId;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlServiceShurui() {
        return this.getPanelShakaiFukushiShokai().getDdlServiceShurui();
    }

    @JsonIgnore
    public void  setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.getPanelShakaiFukushiShokai().setDdlServiceShurui(ddlServiceShurui);
    }

    @JsonIgnore
    public DropDownList getDdlKengenritsu() {
        return this.getPanelShakaiFukushiShokai().getDdlKengenritsu();
    }

    @JsonIgnore
    public void  setDdlKengenritsu(DropDownList ddlKengenritsu) {
        this.getPanelShakaiFukushiShokai().setDdlKengenritsu(ddlKengenritsu);
    }

    @JsonIgnore
    public Button getBtnCal() {
        return this.getPanelShakaiFukushiShokai().getBtnCal();
    }

    @JsonIgnore
    public void  setBtnCal(Button btnCal) {
        this.getPanelShakaiFukushiShokai().setBtnCal(btnCal);
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
    public Button getBtnConfirm() {
        return this.getPanelShakaiFukushiShokai().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelShakaiFukushiShokai().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelShakaiFukushiShokai().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelShakaiFukushiShokai().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelShakaiFukushiShokai().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelShakaiFukushiShokai().setBtnClear(btnClear);
    }

    // </editor-fold>
}
