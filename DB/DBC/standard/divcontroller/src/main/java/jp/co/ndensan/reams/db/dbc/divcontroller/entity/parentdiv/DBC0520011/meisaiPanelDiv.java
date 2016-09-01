package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * meisaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class meisaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKokuhoHokenshaNo")
    private DropDownList ddlKokuhoHokenshaNo;
    @JsonProperty("txtTaishokuGaitoYMD")
    private TextBoxDate txtTaishokuGaitoYMD;
    @JsonProperty("txtKokuhoHokenshoNo")
    private TextBoxNum txtKokuhoHokenshoNo;
    @JsonProperty("txtTaishokuHigaitoYMD")
    private TextBoxDate txtTaishokuHigaitoYMD;
    @JsonProperty("txtKokuhoKojinNo")
    private TextBoxCode txtKokuhoKojinNo;
    @JsonProperty("ddlKojinKubunCode")
    private DropDownList ddlKojinKubunCode;
    @JsonProperty("txtShikakuShutokuYMD")
    private TextBoxDate txtShikakuShutokuYMD;
    @JsonProperty("txtShikakuSoshitsuYMD")
    private TextBoxDate txtShikakuSoshitsuYMD;
    @JsonProperty("txtKokuhoNo")
    private TextBoxCode txtKokuhoNo;
    @JsonProperty("chkTorokuKubun")
    private CheckBoxList chkTorokuKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKokuhoHokenshaNo
     * @return ddlKokuhoHokenshaNo
     */
    @JsonProperty("ddlKokuhoHokenshaNo")
    public DropDownList getDdlKokuhoHokenshaNo() {
        return ddlKokuhoHokenshaNo;
    }

    /*
     * setddlKokuhoHokenshaNo
     * @param ddlKokuhoHokenshaNo ddlKokuhoHokenshaNo
     */
    @JsonProperty("ddlKokuhoHokenshaNo")
    public void setDdlKokuhoHokenshaNo(DropDownList ddlKokuhoHokenshaNo) {
        this.ddlKokuhoHokenshaNo = ddlKokuhoHokenshaNo;
    }

    /*
     * gettxtTaishokuGaitoYMD
     * @return txtTaishokuGaitoYMD
     */
    @JsonProperty("txtTaishokuGaitoYMD")
    public TextBoxDate getTxtTaishokuGaitoYMD() {
        return txtTaishokuGaitoYMD;
    }

    /*
     * settxtTaishokuGaitoYMD
     * @param txtTaishokuGaitoYMD txtTaishokuGaitoYMD
     */
    @JsonProperty("txtTaishokuGaitoYMD")
    public void setTxtTaishokuGaitoYMD(TextBoxDate txtTaishokuGaitoYMD) {
        this.txtTaishokuGaitoYMD = txtTaishokuGaitoYMD;
    }

    /*
     * gettxtKokuhoHokenshoNo
     * @return txtKokuhoHokenshoNo
     */
    @JsonProperty("txtKokuhoHokenshoNo")
    public TextBoxNum getTxtKokuhoHokenshoNo() {
        return txtKokuhoHokenshoNo;
    }

    /*
     * settxtKokuhoHokenshoNo
     * @param txtKokuhoHokenshoNo txtKokuhoHokenshoNo
     */
    @JsonProperty("txtKokuhoHokenshoNo")
    public void setTxtKokuhoHokenshoNo(TextBoxNum txtKokuhoHokenshoNo) {
        this.txtKokuhoHokenshoNo = txtKokuhoHokenshoNo;
    }

    /*
     * gettxtTaishokuHigaitoYMD
     * @return txtTaishokuHigaitoYMD
     */
    @JsonProperty("txtTaishokuHigaitoYMD")
    public TextBoxDate getTxtTaishokuHigaitoYMD() {
        return txtTaishokuHigaitoYMD;
    }

    /*
     * settxtTaishokuHigaitoYMD
     * @param txtTaishokuHigaitoYMD txtTaishokuHigaitoYMD
     */
    @JsonProperty("txtTaishokuHigaitoYMD")
    public void setTxtTaishokuHigaitoYMD(TextBoxDate txtTaishokuHigaitoYMD) {
        this.txtTaishokuHigaitoYMD = txtTaishokuHigaitoYMD;
    }

    /*
     * gettxtKokuhoKojinNo
     * @return txtKokuhoKojinNo
     */
    @JsonProperty("txtKokuhoKojinNo")
    public TextBoxCode getTxtKokuhoKojinNo() {
        return txtKokuhoKojinNo;
    }

    /*
     * settxtKokuhoKojinNo
     * @param txtKokuhoKojinNo txtKokuhoKojinNo
     */
    @JsonProperty("txtKokuhoKojinNo")
    public void setTxtKokuhoKojinNo(TextBoxCode txtKokuhoKojinNo) {
        this.txtKokuhoKojinNo = txtKokuhoKojinNo;
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
     * gettxtKokuhoNo
     * @return txtKokuhoNo
     */
    @JsonProperty("txtKokuhoNo")
    public TextBoxCode getTxtKokuhoNo() {
        return txtKokuhoNo;
    }

    /*
     * settxtKokuhoNo
     * @param txtKokuhoNo txtKokuhoNo
     */
    @JsonProperty("txtKokuhoNo")
    public void setTxtKokuhoNo(TextBoxCode txtKokuhoNo) {
        this.txtKokuhoNo = txtKokuhoNo;
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

    // </editor-fold>
}
