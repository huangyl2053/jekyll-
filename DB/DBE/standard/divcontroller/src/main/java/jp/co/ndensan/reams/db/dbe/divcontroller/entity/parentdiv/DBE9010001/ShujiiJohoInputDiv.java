package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShichoson")
    private TextBoxCode txtShichoson;
    @JsonProperty("btnToSearchShichoson")
    private ButtonDialog btnToSearchShichoson;
    @JsonProperty("txtShichosonmei")
    private TextBox txtShichosonmei;
    @JsonProperty("txtShujiiIryoKikanCode")
    private TextBoxCode txtShujiiIryoKikanCode;
    @JsonProperty("txtiryokikanCode")
    private TextBoxCode txtiryokikanCode;
    @JsonProperty("btnToSearchIryoKikan")
    private ButtonDialog btnToSearchIryoKikan;
    @JsonProperty("txtiryokikanname")
    private TextBox txtiryokikanname;
    @JsonProperty("txtiryokikanKananame")
    private TextBoxKana txtiryokikanKananame;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtFaxNo")
    private TextBoxTelNo txtFaxNo;
    @JsonProperty("txtdaihyoshaname")
    private TextBox txtdaihyoshaname;
    @JsonProperty("txtdaihyoshakananame")
    private TextBoxKana txtdaihyoshakananame;
    @JsonProperty("radJokyoFlag")
    private RadioButton radJokyoFlag;
    @JsonProperty("KozaJoho")
    private KozaJohoDiv KozaJoho;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("btnshujiiinsert")
    private Button btnshujiiinsert;
    @JsonProperty("hdnkey_KamokuCode")
    private RString hdnkey_KamokuCode;
    @JsonProperty("hiddenInputDiv")
    private RString hiddenInputDiv;
    @JsonProperty("state")
    private RString state;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShichoson
     * @return txtShichoson
     */
    @JsonProperty("txtShichoson")
    public TextBoxCode getTxtShichoson() {
        return txtShichoson;
    }

    /*
     * settxtShichoson
     * @param txtShichoson txtShichoson
     */
    @JsonProperty("txtShichoson")
    public void setTxtShichoson(TextBoxCode txtShichoson) {
        this.txtShichoson = txtShichoson;
    }

    /*
     * getbtnToSearchShichoson
     * @return btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public ButtonDialog getBtnToSearchShichoson() {
        return btnToSearchShichoson;
    }

    /*
     * setbtnToSearchShichoson
     * @param btnToSearchShichoson btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public void setBtnToSearchShichoson(ButtonDialog btnToSearchShichoson) {
        this.btnToSearchShichoson = btnToSearchShichoson;
    }

    /*
     * gettxtShichosonmei
     * @return txtShichosonmei
     */
    @JsonProperty("txtShichosonmei")
    public TextBox getTxtShichosonmei() {
        return txtShichosonmei;
    }

    /*
     * settxtShichosonmei
     * @param txtShichosonmei txtShichosonmei
     */
    @JsonProperty("txtShichosonmei")
    public void setTxtShichosonmei(TextBox txtShichosonmei) {
        this.txtShichosonmei = txtShichosonmei;
    }

    /*
     * gettxtShujiiIryoKikanCode
     * @return txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return txtShujiiIryoKikanCode;
    }

    /*
     * settxtShujiiIryoKikanCode
     * @param txtShujiiIryoKikanCode txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public void setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.txtShujiiIryoKikanCode = txtShujiiIryoKikanCode;
    }

    /*
     * gettxtiryokikanCode
     * @return txtiryokikanCode
     */
    @JsonProperty("txtiryokikanCode")
    public TextBoxCode getTxtiryokikanCode() {
        return txtiryokikanCode;
    }

    /*
     * settxtiryokikanCode
     * @param txtiryokikanCode txtiryokikanCode
     */
    @JsonProperty("txtiryokikanCode")
    public void setTxtiryokikanCode(TextBoxCode txtiryokikanCode) {
        this.txtiryokikanCode = txtiryokikanCode;
    }

    /*
     * getbtnToSearchIryoKikan
     * @return btnToSearchIryoKikan
     */
    @JsonProperty("btnToSearchIryoKikan")
    public ButtonDialog getBtnToSearchIryoKikan() {
        return btnToSearchIryoKikan;
    }

    /*
     * setbtnToSearchIryoKikan
     * @param btnToSearchIryoKikan btnToSearchIryoKikan
     */
    @JsonProperty("btnToSearchIryoKikan")
    public void setBtnToSearchIryoKikan(ButtonDialog btnToSearchIryoKikan) {
        this.btnToSearchIryoKikan = btnToSearchIryoKikan;
    }

    /*
     * gettxtiryokikanname
     * @return txtiryokikanname
     */
    @JsonProperty("txtiryokikanname")
    public TextBox getTxtiryokikanname() {
        return txtiryokikanname;
    }

    /*
     * settxtiryokikanname
     * @param txtiryokikanname txtiryokikanname
     */
    @JsonProperty("txtiryokikanname")
    public void setTxtiryokikanname(TextBox txtiryokikanname) {
        this.txtiryokikanname = txtiryokikanname;
    }

    /*
     * gettxtiryokikanKananame
     * @return txtiryokikanKananame
     */
    @JsonProperty("txtiryokikanKananame")
    public TextBoxKana getTxtiryokikanKananame() {
        return txtiryokikanKananame;
    }

    /*
     * settxtiryokikanKananame
     * @param txtiryokikanKananame txtiryokikanKananame
     */
    @JsonProperty("txtiryokikanKananame")
    public void setTxtiryokikanKananame(TextBoxKana txtiryokikanKananame) {
        this.txtiryokikanKananame = txtiryokikanKananame;
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
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
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
     * gettxtFaxNo
     * @return txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public TextBoxTelNo getTxtFaxNo() {
        return txtFaxNo;
    }

    /*
     * settxtFaxNo
     * @param txtFaxNo txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    /*
     * gettxtdaihyoshaname
     * @return txtdaihyoshaname
     */
    @JsonProperty("txtdaihyoshaname")
    public TextBox getTxtdaihyoshaname() {
        return txtdaihyoshaname;
    }

    /*
     * settxtdaihyoshaname
     * @param txtdaihyoshaname txtdaihyoshaname
     */
    @JsonProperty("txtdaihyoshaname")
    public void setTxtdaihyoshaname(TextBox txtdaihyoshaname) {
        this.txtdaihyoshaname = txtdaihyoshaname;
    }

    /*
     * gettxtdaihyoshakananame
     * @return txtdaihyoshakananame
     */
    @JsonProperty("txtdaihyoshakananame")
    public TextBoxKana getTxtdaihyoshakananame() {
        return txtdaihyoshakananame;
    }

    /*
     * settxtdaihyoshakananame
     * @param txtdaihyoshakananame txtdaihyoshakananame
     */
    @JsonProperty("txtdaihyoshakananame")
    public void setTxtdaihyoshakananame(TextBoxKana txtdaihyoshakananame) {
        this.txtdaihyoshakananame = txtdaihyoshakananame;
    }

    /*
     * getradJokyoFlag
     * @return radJokyoFlag
     */
    @JsonProperty("radJokyoFlag")
    public RadioButton getRadJokyoFlag() {
        return radJokyoFlag;
    }

    /*
     * setradJokyoFlag
     * @param radJokyoFlag radJokyoFlag
     */
    @JsonProperty("radJokyoFlag")
    public void setRadJokyoFlag(RadioButton radJokyoFlag) {
        this.radJokyoFlag = radJokyoFlag;
    }

    /*
     * getKozaJoho
     * @return KozaJoho
     */
    @JsonProperty("KozaJoho")
    public KozaJohoDiv getKozaJoho() {
        return KozaJoho;
    }

    /*
     * setKozaJoho
     * @param KozaJoho KozaJoho
     */
    @JsonProperty("KozaJoho")
    public void setKozaJoho(KozaJohoDiv KozaJoho) {
        this.KozaJoho = KozaJoho;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getbtnshujiiinsert
     * @return btnshujiiinsert
     */
    @JsonProperty("btnshujiiinsert")
    public Button getBtnshujiiinsert() {
        return btnshujiiinsert;
    }

    /*
     * setbtnshujiiinsert
     * @param btnshujiiinsert btnshujiiinsert
     */
    @JsonProperty("btnshujiiinsert")
    public void setBtnshujiiinsert(Button btnshujiiinsert) {
        this.btnshujiiinsert = btnshujiiinsert;
    }

    /*
     * gethdnkey_KamokuCode
     * @return hdnkey_KamokuCode
     */
    @JsonProperty("hdnkey_KamokuCode")
    public RString getHdnkey_KamokuCode() {
        return hdnkey_KamokuCode;
    }

    /*
     * sethdnkey_KamokuCode
     * @param hdnkey_KamokuCode hdnkey_KamokuCode
     */
    @JsonProperty("hdnkey_KamokuCode")
    public void setHdnkey_KamokuCode(RString hdnkey_KamokuCode) {
        this.hdnkey_KamokuCode = hdnkey_KamokuCode;
    }

    /*
     * gethiddenInputDiv
     * @return hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public RString getHiddenInputDiv() {
        return hiddenInputDiv;
    }

    /*
     * sethiddenInputDiv
     * @param hiddenInputDiv hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public void setHiddenInputDiv(RString hiddenInputDiv) {
        this.hiddenInputDiv = hiddenInputDiv;
    }

    /*
     * getstate
     * @return state
     */
    @JsonProperty("state")
    public RString getState() {
        return state;
    }

    /*
     * setstate
     * @param state state
     */
    @JsonProperty("state")
    public void setState(RString state) {
        this.state = state;
    }

    // </editor-fold>
}
