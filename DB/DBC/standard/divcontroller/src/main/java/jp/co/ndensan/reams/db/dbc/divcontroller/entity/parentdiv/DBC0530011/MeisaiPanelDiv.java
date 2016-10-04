package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MeisaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MeisaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokenshaNo")
    private DropDownList ddlHokenshaNo;
    @JsonProperty("txtHokenshaKaishiYMD")
    private TextBoxDate txtHokenshaKaishiYMD;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtHokenshaShuryoYMD")
    private TextBoxDate txtHokenshaShuryoYMD;
    @JsonProperty("txtShikakuShutokuYMD")
    private TextBoxDate txtShikakuShutokuYMD;
    @JsonProperty("ddlShikakuShutokuJiyu")
    private DropDownList ddlShikakuShutokuJiyu;
    @JsonProperty("txtShikakuSoshitsuYMD")
    private TextBoxDate txtShikakuSoshitsuYMD;
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    private DropDownList ddlShikakuSoshitsuJiyu;
    @JsonProperty("chkTorokuKubun")
    private CheckBoxList chkTorokuKubun;
    @JsonProperty("ddlKojinKubunCode")
    private DropDownList ddlKojinKubunCode;
    @JsonProperty("txtRirekiNo")
    private TextBox txtRirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokenshaNo
     * @return ddlHokenshaNo
     */
    @JsonProperty("ddlHokenshaNo")
    public DropDownList getDdlHokenshaNo() {
        return ddlHokenshaNo;
    }

    /*
     * setddlHokenshaNo
     * @param ddlHokenshaNo ddlHokenshaNo
     */
    @JsonProperty("ddlHokenshaNo")
    public void setDdlHokenshaNo(DropDownList ddlHokenshaNo) {
        this.ddlHokenshaNo = ddlHokenshaNo;
    }

    /*
     * gettxtHokenshaKaishiYMD
     * @return txtHokenshaKaishiYMD
     */
    @JsonProperty("txtHokenshaKaishiYMD")
    public TextBoxDate getTxtHokenshaKaishiYMD() {
        return txtHokenshaKaishiYMD;
    }

    /*
     * settxtHokenshaKaishiYMD
     * @param txtHokenshaKaishiYMD txtHokenshaKaishiYMD
     */
    @JsonProperty("txtHokenshaKaishiYMD")
    public void setTxtHokenshaKaishiYMD(TextBoxDate txtHokenshaKaishiYMD) {
        this.txtHokenshaKaishiYMD = txtHokenshaKaishiYMD;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtHokenshaShuryoYMD
     * @return txtHokenshaShuryoYMD
     */
    @JsonProperty("txtHokenshaShuryoYMD")
    public TextBoxDate getTxtHokenshaShuryoYMD() {
        return txtHokenshaShuryoYMD;
    }

    /*
     * settxtHokenshaShuryoYMD
     * @param txtHokenshaShuryoYMD txtHokenshaShuryoYMD
     */
    @JsonProperty("txtHokenshaShuryoYMD")
    public void setTxtHokenshaShuryoYMD(TextBoxDate txtHokenshaShuryoYMD) {
        this.txtHokenshaShuryoYMD = txtHokenshaShuryoYMD;
    }

    /*
     * gettxtShikakuShutokuYMD
     * @return txtShikakuShutokuYMD
     */
    @JsonProperty("txtShikakuShutokuYMD")
    public TextBoxDate getTxtShikakuShutokuYMD() {
        return txtShikakuShutokuYMD;
    }

    /*
     * settxtShikakuShutokuYMD
     * @param txtShikakuShutokuYMD txtShikakuShutokuYMD
     */
    @JsonProperty("txtShikakuShutokuYMD")
    public void setTxtShikakuShutokuYMD(TextBoxDate txtShikakuShutokuYMD) {
        this.txtShikakuShutokuYMD = txtShikakuShutokuYMD;
    }

    /*
     * getddlShikakuShutokuJiyu
     * @return ddlShikakuShutokuJiyu
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public DropDownList getDdlShikakuShutokuJiyu() {
        return ddlShikakuShutokuJiyu;
    }

    /*
     * setddlShikakuShutokuJiyu
     * @param ddlShikakuShutokuJiyu ddlShikakuShutokuJiyu
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public void setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.ddlShikakuShutokuJiyu = ddlShikakuShutokuJiyu;
    }

    /*
     * gettxtShikakuSoshitsuYMD
     * @return txtShikakuSoshitsuYMD
     */
    @JsonProperty("txtShikakuSoshitsuYMD")
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return txtShikakuSoshitsuYMD;
    }

    /*
     * settxtShikakuSoshitsuYMD
     * @param txtShikakuSoshitsuYMD txtShikakuSoshitsuYMD
     */
    @JsonProperty("txtShikakuSoshitsuYMD")
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.txtShikakuSoshitsuYMD = txtShikakuSoshitsuYMD;
    }

    /*
     * getddlShikakuSoshitsuJiyu
     * @return ddlShikakuSoshitsuJiyu
     */
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return ddlShikakuSoshitsuJiyu;
    }

    /*
     * setddlShikakuSoshitsuJiyu
     * @param ddlShikakuSoshitsuJiyu ddlShikakuSoshitsuJiyu
     */
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.ddlShikakuSoshitsuJiyu = ddlShikakuSoshitsuJiyu;
    }

    /*
     * getchkTorokuKubun
     * @return chkTorokuKubun
     */
    @JsonProperty("chkTorokuKubun")
    public CheckBoxList getChkTorokuKubun() {
        return chkTorokuKubun;
    }

    /*
     * setchkTorokuKubun
     * @param chkTorokuKubun chkTorokuKubun
     */
    @JsonProperty("chkTorokuKubun")
    public void setChkTorokuKubun(CheckBoxList chkTorokuKubun) {
        this.chkTorokuKubun = chkTorokuKubun;
    }

    /*
     * getddlKojinKubunCode
     * @return ddlKojinKubunCode
     */
    @JsonProperty("ddlKojinKubunCode")
    public DropDownList getDdlKojinKubunCode() {
        return ddlKojinKubunCode;
    }

    /*
     * setddlKojinKubunCode
     * @param ddlKojinKubunCode ddlKojinKubunCode
     */
    @JsonProperty("ddlKojinKubunCode")
    public void setDdlKojinKubunCode(DropDownList ddlKojinKubunCode) {
        this.ddlKojinKubunCode = ddlKojinKubunCode;
    }

    /*
     * gettxtRirekiNo
     * @return txtRirekiNo
     */
    @JsonProperty("txtRirekiNo")
    public TextBox getTxtRirekiNo() {
        return txtRirekiNo;
    }

    /*
     * settxtRirekiNo
     * @param txtRirekiNo txtRirekiNo
     */
    @JsonProperty("txtRirekiNo")
    public void setTxtRirekiNo(TextBox txtRirekiNo) {
        this.txtRirekiNo = txtRirekiNo;
    }

    // </editor-fold>
}
