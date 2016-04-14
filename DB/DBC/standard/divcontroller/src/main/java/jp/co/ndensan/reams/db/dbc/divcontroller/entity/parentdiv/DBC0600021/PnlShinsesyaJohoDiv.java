package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * PnlShinsesyaJoho のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class PnlShinsesyaJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseibi")
    private TextBoxDate txtShinseibi;
    @JsonProperty("txtUkechikebi")
    private TextBoxDate txtUkechikebi;
    @JsonProperty("txtRyosyuYMD")
    private TextBoxDate txtRyosyuYMD;
    @JsonProperty("ddlShinseisyakubun")
    private DropDownList ddlShinseisyakubun;
    @JsonProperty("txtShinseiriyu")
    private TextBoxMultiLine txtShinseiriyu;
    @JsonProperty("txtJigyosya")
    private TextBoxCode txtJigyosya;
    @JsonProperty("btnJigyosya")
    private ButtonDialog btnJigyosya;
    @JsonProperty("btnHonninJohoCopy")
    private Button btnHonninJohoCopy;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtShimeiKana")
    private TextBoxKana txtShimeiKana;
    @JsonProperty("txtShinseisyaTel")
    private TextBoxTelNo txtShinseisyaTel;
    @JsonProperty("txtShinseisyaYubin")
    private TextBoxYubinNo txtShinseisyaYubin;
    @JsonProperty("txtShinseisyaJyusyo")
    private TextBoxJusho txtShinseisyaJyusyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxDate getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    /*
     * gettxtUkechikebi
     * @return txtUkechikebi
     */
    @JsonProperty("txtUkechikebi")
    public TextBoxDate getTxtUkechikebi() {
        return txtUkechikebi;
    }

    /*
     * settxtUkechikebi
     * @param txtUkechikebi txtUkechikebi
     */
    @JsonProperty("txtUkechikebi")
    public void setTxtUkechikebi(TextBoxDate txtUkechikebi) {
        this.txtUkechikebi = txtUkechikebi;
    }

    /*
     * gettxtRyosyuYMD
     * @return txtRyosyuYMD
     */
    @JsonProperty("txtRyosyuYMD")
    public TextBoxDate getTxtRyosyuYMD() {
        return txtRyosyuYMD;
    }

    /*
     * settxtRyosyuYMD
     * @param txtRyosyuYMD txtRyosyuYMD
     */
    @JsonProperty("txtRyosyuYMD")
    public void setTxtRyosyuYMD(TextBoxDate txtRyosyuYMD) {
        this.txtRyosyuYMD = txtRyosyuYMD;
    }

    /*
     * getddlShinseisyakubun
     * @return ddlShinseisyakubun
     */
    @JsonProperty("ddlShinseisyakubun")
    public DropDownList getDdlShinseisyakubun() {
        return ddlShinseisyakubun;
    }

    /*
     * setddlShinseisyakubun
     * @param ddlShinseisyakubun ddlShinseisyakubun
     */
    @JsonProperty("ddlShinseisyakubun")
    public void setDdlShinseisyakubun(DropDownList ddlShinseisyakubun) {
        this.ddlShinseisyakubun = ddlShinseisyakubun;
    }

    /*
     * gettxtShinseiriyu
     * @return txtShinseiriyu
     */
    @JsonProperty("txtShinseiriyu")
    public TextBoxMultiLine getTxtShinseiriyu() {
        return txtShinseiriyu;
    }

    /*
     * settxtShinseiriyu
     * @param txtShinseiriyu txtShinseiriyu
     */
    @JsonProperty("txtShinseiriyu")
    public void setTxtShinseiriyu(TextBoxMultiLine txtShinseiriyu) {
        this.txtShinseiriyu = txtShinseiriyu;
    }

    /*
     * gettxtJigyosya
     * @return txtJigyosya
     */
    @JsonProperty("txtJigyosya")
    public TextBoxCode getTxtJigyosya() {
        return txtJigyosya;
    }

    /*
     * settxtJigyosya
     * @param txtJigyosya txtJigyosya
     */
    @JsonProperty("txtJigyosya")
    public void setTxtJigyosya(TextBoxCode txtJigyosya) {
        this.txtJigyosya = txtJigyosya;
    }

    /*
     * getbtnJigyosya
     * @return btnJigyosya
     */
    @JsonProperty("btnJigyosya")
    public ButtonDialog getBtnJigyosya() {
        return btnJigyosya;
    }

    /*
     * setbtnJigyosya
     * @param btnJigyosya btnJigyosya
     */
    @JsonProperty("btnJigyosya")
    public void setBtnJigyosya(ButtonDialog btnJigyosya) {
        this.btnJigyosya = btnJigyosya;
    }

    /*
     * getbtnHonninJohoCopy
     * @return btnHonninJohoCopy
     */
    @JsonProperty("btnHonninJohoCopy")
    public Button getBtnHonninJohoCopy() {
        return btnHonninJohoCopy;
    }

    /*
     * setbtnHonninJohoCopy
     * @param btnHonninJohoCopy btnHonninJohoCopy
     */
    @JsonProperty("btnHonninJohoCopy")
    public void setBtnHonninJohoCopy(Button btnHonninJohoCopy) {
        this.btnHonninJohoCopy = btnHonninJohoCopy;
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
     * gettxtShimeiKana
     * @return txtShimeiKana
     */
    @JsonProperty("txtShimeiKana")
    public TextBoxKana getTxtShimeiKana() {
        return txtShimeiKana;
    }

    /*
     * settxtShimeiKana
     * @param txtShimeiKana txtShimeiKana
     */
    @JsonProperty("txtShimeiKana")
    public void setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.txtShimeiKana = txtShimeiKana;
    }

    /*
     * gettxtShinseisyaTel
     * @return txtShinseisyaTel
     */
    @JsonProperty("txtShinseisyaTel")
    public TextBoxTelNo getTxtShinseisyaTel() {
        return txtShinseisyaTel;
    }

    /*
     * settxtShinseisyaTel
     * @param txtShinseisyaTel txtShinseisyaTel
     */
    @JsonProperty("txtShinseisyaTel")
    public void setTxtShinseisyaTel(TextBoxTelNo txtShinseisyaTel) {
        this.txtShinseisyaTel = txtShinseisyaTel;
    }

    /*
     * gettxtShinseisyaYubin
     * @return txtShinseisyaYubin
     */
    @JsonProperty("txtShinseisyaYubin")
    public TextBoxYubinNo getTxtShinseisyaYubin() {
        return txtShinseisyaYubin;
    }

    /*
     * settxtShinseisyaYubin
     * @param txtShinseisyaYubin txtShinseisyaYubin
     */
    @JsonProperty("txtShinseisyaYubin")
    public void setTxtShinseisyaYubin(TextBoxYubinNo txtShinseisyaYubin) {
        this.txtShinseisyaYubin = txtShinseisyaYubin;
    }

    /*
     * gettxtShinseisyaJyusyo
     * @return txtShinseisyaJyusyo
     */
    @JsonProperty("txtShinseisyaJyusyo")
    public TextBoxJusho getTxtShinseisyaJyusyo() {
        return txtShinseisyaJyusyo;
    }

    /*
     * settxtShinseisyaJyusyo
     * @param txtShinseisyaJyusyo txtShinseisyaJyusyo
     */
    @JsonProperty("txtShinseisyaJyusyo")
    public void setTxtShinseisyaJyusyo(TextBoxJusho txtShinseisyaJyusyo) {
        this.txtShinseisyaJyusyo = txtShinseisyaJyusyo;
    }

    // </editor-fold>
}
