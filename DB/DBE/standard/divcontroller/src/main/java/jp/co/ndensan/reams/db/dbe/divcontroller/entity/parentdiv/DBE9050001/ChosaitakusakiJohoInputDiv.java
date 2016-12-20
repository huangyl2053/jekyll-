package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaitakusakiJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaitakusakiJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSonotaKikanCode")
    private TextBoxCode txtSonotaKikanCode;
    @JsonProperty("txtSonotaKikanname")
    private TextBox txtSonotaKikanname;
    @JsonProperty("txtSonotaKikanKananame")
    private TextBoxKana txtSonotaKikanKananame;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtJushoKana")
    private TextBoxJusho txtJushoKana;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("ddlItakusakikubun")
    private DropDownList ddlItakusakikubun;
    @JsonProperty("txtteiin")
    private TextBoxNum txtteiin;
    @JsonProperty("ddlKikankubun")
    private DropDownList ddlKikankubun;
    @JsonProperty("radHaishiFlag")
    private RadioButton radHaishiFlag;
    @JsonProperty("KozaJoho")
    private KozaJohoDiv KozaJoho;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("ccdChiku")
    private CodeInputDiv ccdChiku;
    @JsonProperty("ccdHokenshaJoho")
    private HokenshaJohoDiv ccdHokenshaJoho;
    @JsonProperty("state")
    private RString state;
    @JsonProperty("hiddenInputDiv")
    private RString hiddenInputDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSonotaKikanCode
     * @return txtSonotaKikanCode
     */
    @JsonProperty("txtSonotaKikanCode")
    public TextBoxCode getTxtSonotaKikanCode() {
        return txtSonotaKikanCode;
    }

    /*
     * settxtSonotaKikanCode
     * @param txtSonotaKikanCode txtSonotaKikanCode
     */
    @JsonProperty("txtSonotaKikanCode")
    public void setTxtSonotaKikanCode(TextBoxCode txtSonotaKikanCode) {
        this.txtSonotaKikanCode = txtSonotaKikanCode;
    }

    /*
     * gettxtSonotaKikanname
     * @return txtSonotaKikanname
     */
    @JsonProperty("txtSonotaKikanname")
    public TextBox getTxtSonotaKikanname() {
        return txtSonotaKikanname;
    }

    /*
     * settxtSonotaKikanname
     * @param txtSonotaKikanname txtSonotaKikanname
     */
    @JsonProperty("txtSonotaKikanname")
    public void setTxtSonotaKikanname(TextBox txtSonotaKikanname) {
        this.txtSonotaKikanname = txtSonotaKikanname;
    }

    /*
     * gettxtSonotaKikanKananame
     * @return txtSonotaKikanKananame
     */
    @JsonProperty("txtSonotaKikanKananame")
    public TextBoxKana getTxtSonotaKikanKananame() {
        return txtSonotaKikanKananame;
    }

    /*
     * settxtSonotaKikanKananame
     * @param txtSonotaKikanKananame txtSonotaKikanKananame
     */
    @JsonProperty("txtSonotaKikanKananame")
    public void setTxtSonotaKikanKananame(TextBoxKana txtSonotaKikanKananame) {
        this.txtSonotaKikanKananame = txtSonotaKikanKananame;
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
     * gettxtJushoKana
     * @return txtJushoKana
     */
    @JsonProperty("txtJushoKana")
    public TextBoxJusho getTxtJushoKana() {
        return txtJushoKana;
    }

    /*
     * settxtJushoKana
     * @param txtJushoKana txtJushoKana
     */
    @JsonProperty("txtJushoKana")
    public void setTxtJushoKana(TextBoxJusho txtJushoKana) {
        this.txtJushoKana = txtJushoKana;
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
     * getddlItakusakikubun
     * @return ddlItakusakikubun
     */
    @JsonProperty("ddlItakusakikubun")
    public DropDownList getDdlItakusakikubun() {
        return ddlItakusakikubun;
    }

    /*
     * setddlItakusakikubun
     * @param ddlItakusakikubun ddlItakusakikubun
     */
    @JsonProperty("ddlItakusakikubun")
    public void setDdlItakusakikubun(DropDownList ddlItakusakikubun) {
        this.ddlItakusakikubun = ddlItakusakikubun;
    }

    /*
     * gettxtteiin
     * @return txtteiin
     */
    @JsonProperty("txtteiin")
    public TextBoxNum getTxtteiin() {
        return txtteiin;
    }

    /*
     * settxtteiin
     * @param txtteiin txtteiin
     */
    @JsonProperty("txtteiin")
    public void setTxtteiin(TextBoxNum txtteiin) {
        this.txtteiin = txtteiin;
    }

    /*
     * getddlKikankubun
     * @return ddlKikankubun
     */
    @JsonProperty("ddlKikankubun")
    public DropDownList getDdlKikankubun() {
        return ddlKikankubun;
    }

    /*
     * setddlKikankubun
     * @param ddlKikankubun ddlKikankubun
     */
    @JsonProperty("ddlKikankubun")
    public void setDdlKikankubun(DropDownList ddlKikankubun) {
        this.ddlKikankubun = ddlKikankubun;
    }

    /*
     * getradHaishiFlag
     * @return radHaishiFlag
     */
    @JsonProperty("radHaishiFlag")
    public RadioButton getRadHaishiFlag() {
        return radHaishiFlag;
    }

    /*
     * setradHaishiFlag
     * @param radHaishiFlag radHaishiFlag
     */
    @JsonProperty("radHaishiFlag")
    public void setRadHaishiFlag(RadioButton radHaishiFlag) {
        this.radHaishiFlag = radHaishiFlag;
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
     * getccdChiku
     * @return ccdChiku
     */
    @JsonProperty("ccdChiku")
    public ICodeInputDiv getCcdChiku() {
        return ccdChiku;
    }

    /*
     * getccdHokenshaJoho
     * @return ccdHokenshaJoho
     */
    @JsonProperty("ccdHokenshaJoho")
    public IHokenshaJohoDiv getCcdHokenshaJoho() {
        return ccdHokenshaJoho;
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

    // </editor-fold>
}
