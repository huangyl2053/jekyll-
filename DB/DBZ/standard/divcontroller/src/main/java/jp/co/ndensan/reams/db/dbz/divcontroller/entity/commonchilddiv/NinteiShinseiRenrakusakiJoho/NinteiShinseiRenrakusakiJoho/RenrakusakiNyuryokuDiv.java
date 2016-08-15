package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * RenrakusakiNyuryoku のクラスファイル
 *
 * @reamsid_L DBZ-1300-100 dongyabin
 */
public class RenrakusakiNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenban")
    private TextBoxCode txtRenban;
    @JsonProperty("ddlRenrakusakiKubun")
    private DropDownList ddlRenrakusakiKubun;
    @JsonProperty("ddlShisho")
    private DropDownList ddlShisho;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtKanaShimei")
    private TextBox txtKanaShimei;
    @JsonProperty("ddlTsuzukigara")
    private DropDownList ddlTsuzukigara;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("txtMobileNo")
    private TextBoxTelNo txtMobileNo;
    @JsonProperty("txtYusenJuni")
    private TextBoxCode txtYusenJuni;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRenban
     * @return txtRenban
     */
    @JsonProperty("txtRenban")
    public TextBoxCode getTxtRenban() {
        return txtRenban;
    }

    /*
     * settxtRenban
     * @param txtRenban txtRenban
     */
    @JsonProperty("txtRenban")
    public void setTxtRenban(TextBoxCode txtRenban) {
        this.txtRenban = txtRenban;
    }

    /*
     * getddlRenrakusakiKubun
     * @return ddlRenrakusakiKubun
     */
    @JsonProperty("ddlRenrakusakiKubun")
    public DropDownList getDdlRenrakusakiKubun() {
        return ddlRenrakusakiKubun;
    }

    /*
     * setddlRenrakusakiKubun
     * @param ddlRenrakusakiKubun ddlRenrakusakiKubun
     */
    @JsonProperty("ddlRenrakusakiKubun")
    public void setDdlRenrakusakiKubun(DropDownList ddlRenrakusakiKubun) {
        this.ddlRenrakusakiKubun = ddlRenrakusakiKubun;
    }

    /*
     * getddlShisho
     * @return ddlShisho
     */
    @JsonProperty("ddlShisho")
    public DropDownList getDdlShisho() {
        return ddlShisho;
    }

    /*
     * setddlShisho
     * @param ddlShisho ddlShisho
     */
    @JsonProperty("ddlShisho")
    public void setDdlShisho(DropDownList ddlShisho) {
        this.ddlShisho = ddlShisho;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtKanaShimei
     * @return txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public TextBox getTxtKanaShimei() {
        return txtKanaShimei;
    }

    /*
     * settxtKanaShimei
     * @param txtKanaShimei txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.txtKanaShimei = txtKanaShimei;
    }

    /*
     * getddlTsuzukigara
     * @return ddlTsuzukigara
     */
    @JsonProperty("ddlTsuzukigara")
    public DropDownList getDdlTsuzukigara() {
        return ddlTsuzukigara;
    }

    /*
     * setddlTsuzukigara
     * @param ddlTsuzukigara ddlTsuzukigara
     */
    @JsonProperty("ddlTsuzukigara")
    public void setDdlTsuzukigara(DropDownList ddlTsuzukigara) {
        this.ddlTsuzukigara = ddlTsuzukigara;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * gettxtMobileNo
     * @return txtMobileNo
     */
    @JsonProperty("txtMobileNo")
    public TextBoxTelNo getTxtMobileNo() {
        return txtMobileNo;
    }

    /*
     * settxtMobileNo
     * @param txtMobileNo txtMobileNo
     */
    @JsonProperty("txtMobileNo")
    public void setTxtMobileNo(TextBoxTelNo txtMobileNo) {
        this.txtMobileNo = txtMobileNo;
    }

    /*
     * gettxtYusenJuni
     * @return txtYusenJuni
     */
    @JsonProperty("txtYusenJuni")
    public TextBoxCode getTxtYusenJuni() {
        return txtYusenJuni;
    }

    /*
     * settxtYusenJuni
     * @param txtYusenJuni txtYusenJuni
     */
    @JsonProperty("txtYusenJuni")
    public void setTxtYusenJuni(TextBoxCode txtYusenJuni) {
        this.txtYusenJuni = txtYusenJuni;
    }

    // </editor-fold>
}
