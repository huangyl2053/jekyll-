package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
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
 * ShinseishaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("ddlShinseishaKubun")
    private DropDownList ddlShinseishaKubun;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("btnJigyosha")
    private ButtonDialog btnJigyosha;
    @JsonProperty("btnHonninJohoCopy")
    private Button btnHonninJohoCopy;
    @JsonProperty("txtShinseishaNameKana")
    private TextBox txtShinseishaNameKana;
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("ddlShinseiTorikesuJiyu")
    private DropDownList ddlShinseiTorikesuJiyu;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtAddress")
    private TextBoxJusho txtAddress;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getddlShinseishaKubun
     * @return ddlShinseishaKubun
     */
    @JsonProperty("ddlShinseishaKubun")
    public DropDownList getDdlShinseishaKubun() {
        return ddlShinseishaKubun;
    }

    /*
     * setddlShinseishaKubun
     * @param ddlShinseishaKubun ddlShinseishaKubun
     */
    @JsonProperty("ddlShinseishaKubun")
    public void setDdlShinseishaKubun(DropDownList ddlShinseishaKubun) {
        this.ddlShinseishaKubun = ddlShinseishaKubun;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * getbtnJigyosha
     * @return btnJigyosha
     */
    @JsonProperty("btnJigyosha")
    public ButtonDialog getBtnJigyosha() {
        return btnJigyosha;
    }

    /*
     * setbtnJigyosha
     * @param btnJigyosha btnJigyosha
     */
    @JsonProperty("btnJigyosha")
    public void setBtnJigyosha(ButtonDialog btnJigyosha) {
        this.btnJigyosha = btnJigyosha;
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
     * gettxtShinseishaNameKana
     * @return txtShinseishaNameKana
     */
    @JsonProperty("txtShinseishaNameKana")
    public TextBox getTxtShinseishaNameKana() {
        return txtShinseishaNameKana;
    }

    /*
     * settxtShinseishaNameKana
     * @param txtShinseishaNameKana txtShinseishaNameKana
     */
    @JsonProperty("txtShinseishaNameKana")
    public void setTxtShinseishaNameKana(TextBox txtShinseishaNameKana) {
        this.txtShinseishaNameKana = txtShinseishaNameKana;
    }

    /*
     * gettxtShinseishaName
     * @return txtShinseishaName
     */
    @JsonProperty("txtShinseishaName")
    public TextBox getTxtShinseishaName() {
        return txtShinseishaName;
    }

    /*
     * settxtShinseishaName
     * @param txtShinseishaName txtShinseishaName
     */
    @JsonProperty("txtShinseishaName")
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.txtShinseishaName = txtShinseishaName;
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
     * getddlShinseiTorikesuJiyu
     * @return ddlShinseiTorikesuJiyu
     */
    @JsonProperty("ddlShinseiTorikesuJiyu")
    public DropDownList getDdlShinseiTorikesuJiyu() {
        return ddlShinseiTorikesuJiyu;
    }

    /*
     * setddlShinseiTorikesuJiyu
     * @param ddlShinseiTorikesuJiyu ddlShinseiTorikesuJiyu
     */
    @JsonProperty("ddlShinseiTorikesuJiyu")
    public void setDdlShinseiTorikesuJiyu(DropDownList ddlShinseiTorikesuJiyu) {
        this.ddlShinseiTorikesuJiyu = ddlShinseiTorikesuJiyu;
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
     * gettxtAddress
     * @return txtAddress
     */
    @JsonProperty("txtAddress")
    public TextBoxJusho getTxtAddress() {
        return txtAddress;
    }

    /*
     * settxtAddress
     * @param txtAddress txtAddress
     */
    @JsonProperty("txtAddress")
    public void setTxtAddress(TextBoxJusho txtAddress) {
        this.txtAddress = txtAddress;
    }

    // </editor-fold>
}
