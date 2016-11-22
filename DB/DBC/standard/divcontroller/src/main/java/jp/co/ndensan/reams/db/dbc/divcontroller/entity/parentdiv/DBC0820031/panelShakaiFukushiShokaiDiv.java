package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShakaiFukushiShokai のクラスファイル 
 * 
 * @reamsid_L DBC-1030-080 xuhao
 */
public class panelShakaiFukushiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlServiceShurui")
    private DropDownList ddlServiceShurui;
    @JsonProperty("ddlKengenritsu")
    private DropDownList ddlKengenritsu;
    @JsonProperty("btnCal")
    private Button btnCal;
    @JsonProperty("txtRiyoshaFutangakuTotal")
    private TextBoxNum txtRiyoshaFutangakuTotal;
    @JsonProperty("txtKengengaku")
    private TextBoxNum txtKengengaku;
    @JsonProperty("txtKeigengoRiyoshaFutangaku")
    private TextBoxNum txtKeigengoRiyoshaFutangaku;
    @JsonProperty("txtBikou")
    private TextBox txtBikou;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlServiceShurui
     * @return ddlServiceShurui
     */
    @JsonProperty("ddlServiceShurui")
    public DropDownList getDdlServiceShurui() {
        return ddlServiceShurui;
    }

    /*
     * setddlServiceShurui
     * @param ddlServiceShurui ddlServiceShurui
     */
    @JsonProperty("ddlServiceShurui")
    public void setDdlServiceShurui(DropDownList ddlServiceShurui) {
        this.ddlServiceShurui = ddlServiceShurui;
    }

    /*
     * getddlKengenritsu
     * @return ddlKengenritsu
     */
    @JsonProperty("ddlKengenritsu")
    public DropDownList getDdlKengenritsu() {
        return ddlKengenritsu;
    }

    /*
     * setddlKengenritsu
     * @param ddlKengenritsu ddlKengenritsu
     */
    @JsonProperty("ddlKengenritsu")
    public void setDdlKengenritsu(DropDownList ddlKengenritsu) {
        this.ddlKengenritsu = ddlKengenritsu;
    }

    /*
     * getbtnCal
     * @return btnCal
     */
    @JsonProperty("btnCal")
    public Button getBtnCal() {
        return btnCal;
    }

    /*
     * setbtnCal
     * @param btnCal btnCal
     */
    @JsonProperty("btnCal")
    public void setBtnCal(Button btnCal) {
        this.btnCal = btnCal;
    }

    /*
     * gettxtRiyoshaFutangakuTotal
     * @return txtRiyoshaFutangakuTotal
     */
    @JsonProperty("txtRiyoshaFutangakuTotal")
    public TextBoxNum getTxtRiyoshaFutangakuTotal() {
        return txtRiyoshaFutangakuTotal;
    }

    /*
     * settxtRiyoshaFutangakuTotal
     * @param txtRiyoshaFutangakuTotal txtRiyoshaFutangakuTotal
     */
    @JsonProperty("txtRiyoshaFutangakuTotal")
    public void setTxtRiyoshaFutangakuTotal(TextBoxNum txtRiyoshaFutangakuTotal) {
        this.txtRiyoshaFutangakuTotal = txtRiyoshaFutangakuTotal;
    }

    /*
     * gettxtKengengaku
     * @return txtKengengaku
     */
    @JsonProperty("txtKengengaku")
    public TextBoxNum getTxtKengengaku() {
        return txtKengengaku;
    }

    /*
     * settxtKengengaku
     * @param txtKengengaku txtKengengaku
     */
    @JsonProperty("txtKengengaku")
    public void setTxtKengengaku(TextBoxNum txtKengengaku) {
        this.txtKengengaku = txtKengengaku;
    }

    /*
     * gettxtKeigengoRiyoshaFutangaku
     * @return txtKeigengoRiyoshaFutangaku
     */
    @JsonProperty("txtKeigengoRiyoshaFutangaku")
    public TextBoxNum getTxtKeigengoRiyoshaFutangaku() {
        return txtKeigengoRiyoshaFutangaku;
    }

    /*
     * settxtKeigengoRiyoshaFutangaku
     * @param txtKeigengoRiyoshaFutangaku txtKeigengoRiyoshaFutangaku
     */
    @JsonProperty("txtKeigengoRiyoshaFutangaku")
    public void setTxtKeigengoRiyoshaFutangaku(TextBoxNum txtKeigengoRiyoshaFutangaku) {
        this.txtKeigengoRiyoshaFutangaku = txtKeigengoRiyoshaFutangaku;
    }

    /*
     * gettxtBikou
     * @return txtBikou
     */
    @JsonProperty("txtBikou")
    public TextBox getTxtBikou() {
        return txtBikou;
    }

    /*
     * settxtBikou
     * @param txtBikou txtBikou
     */
    @JsonProperty("txtBikou")
    public void setTxtBikou(TextBox txtBikou) {
        this.txtBikou = txtBikou;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    // </editor-fold>
}
