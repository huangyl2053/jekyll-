package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlIryohokenJoho のクラスファイル
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 *
 */
public class pnlIryohokenJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbdKanyubi")
    private TextBoxDate tbdKanyubi;
    @JsonProperty("tbdDattabi")
    private TextBoxDate tbdDattabi;
    @JsonProperty("ddlSyubetsu")
    private DropDownList ddlSyubetsu;
    @JsonProperty("txtHokensyaKodo")
    private TextBox txtHokensyaKodo;
    @JsonProperty("txtHokensyaMeisho")
    private TextBox txtHokensyaMeisho;
    @JsonProperty("txtKigoBango")
    private TextBox txtKigoBango;
    @JsonProperty("status")
    private RString status;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbdKanyubi
     * @return tbdKanyubi
     */
    @JsonProperty("tbdKanyubi")
    public TextBoxDate getTbdKanyubi() {
        return tbdKanyubi;
    }

    /*
     * settbdKanyubi
     * @param tbdKanyubi tbdKanyubi
     */
    @JsonProperty("tbdKanyubi")
    public void setTbdKanyubi(TextBoxDate tbdKanyubi) {
        this.tbdKanyubi = tbdKanyubi;
    }

    /*
     * gettbdDattabi
     * @return tbdDattabi
     */
    @JsonProperty("tbdDattabi")
    public TextBoxDate getTbdDattabi() {
        return tbdDattabi;
    }

    /*
     * settbdDattabi
     * @param tbdDattabi tbdDattabi
     */
    @JsonProperty("tbdDattabi")
    public void setTbdDattabi(TextBoxDate tbdDattabi) {
        this.tbdDattabi = tbdDattabi;
    }

    /*
     * getddlSyubetsu
     * @return ddlSyubetsu
     */
    @JsonProperty("ddlSyubetsu")
    public DropDownList getDdlSyubetsu() {
        return ddlSyubetsu;
    }

    /*
     * setddlSyubetsu
     * @param ddlSyubetsu ddlSyubetsu
     */
    @JsonProperty("ddlSyubetsu")
    public void setDdlSyubetsu(DropDownList ddlSyubetsu) {
        this.ddlSyubetsu = ddlSyubetsu;
    }

    /*
     * gettxtHokensyaKodo
     * @return txtHokensyaKodo
     */
    @JsonProperty("txtHokensyaKodo")
    public TextBox getTxtHokensyaKodo() {
        return txtHokensyaKodo;
    }

    /*
     * settxtHokensyaKodo
     * @param txtHokensyaKodo txtHokensyaKodo
     */
    @JsonProperty("txtHokensyaKodo")
    public void setTxtHokensyaKodo(TextBox txtHokensyaKodo) {
        this.txtHokensyaKodo = txtHokensyaKodo;
    }

    /*
     * gettxtHokensyaMeisho
     * @return txtHokensyaMeisho
     */
    @JsonProperty("txtHokensyaMeisho")
    public TextBox getTxtHokensyaMeisho() {
        return txtHokensyaMeisho;
    }

    /*
     * settxtHokensyaMeisho
     * @param txtHokensyaMeisho txtHokensyaMeisho
     */
    @JsonProperty("txtHokensyaMeisho")
    public void setTxtHokensyaMeisho(TextBox txtHokensyaMeisho) {
        this.txtHokensyaMeisho = txtHokensyaMeisho;
    }

    /*
     * gettxtKigoBango
     * @return txtKigoBango
     */
    @JsonProperty("txtKigoBango")
    public TextBox getTxtKigoBango() {
        return txtKigoBango;
    }

    /*
     * settxtKigoBango
     * @param txtKigoBango txtKigoBango
     */
    @JsonProperty("txtKigoBango")
    public void setTxtKigoBango(TextBox txtKigoBango) {
        this.txtKigoBango = txtKigoBango;
    }

    /*
     * getstatus
     * @return status
     */
    @JsonProperty("status")
    public RString getStatus() {
        return status;
    }

    /*
     * setstatus
     * @param status status
     */
    @JsonProperty("status")
    public void setStatus(RString status) {
        this.status = status;
    }

    // </editor-fold>
}
