package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031;
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
 * @author 自動生成
 */
public class panelShakaiFukushiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
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
    @JsonProperty("txtRiyoshaFutangakuTotal")
    private TextBoxNum txtRiyoshaFutangakuTotal;
    @JsonProperty("txtKengengaku")
    private TextBoxNum txtKengengaku;
    @JsonProperty("txtKeigengoRiyoshaFutangaku")
    private TextBoxNum txtKeigengoRiyoshaFutangaku;
    @JsonProperty("txtBikou")
    private TextBox txtBikou;
    @JsonProperty("btnClose")
    private Button btnClose;

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
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
}
