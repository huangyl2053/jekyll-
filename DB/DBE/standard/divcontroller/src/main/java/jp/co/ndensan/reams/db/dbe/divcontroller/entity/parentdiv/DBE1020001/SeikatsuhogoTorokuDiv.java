package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SeikatsuhogoToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuhogoTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaNoSaiban")
    private HihokenshaNoSaibanDiv HihokenshaNoSaiban;
    @JsonProperty("SeikatsuHogoshaJohoInput")
    private SeikatsuHogoshaJohoInputDiv SeikatsuHogoshaJohoInput;
    @JsonProperty("hdnKey_Dialog")
    private RString hdnKey_Dialog;
    @JsonProperty("hdnKey_GyomuCode")
    private RString hdnKey_GyomuCode;
    @JsonProperty("hdnKey_SearchYusenKubun")
    private RString hdnKey_SearchYusenKubun;
    @JsonProperty("hdnKey_AgeArrivalDay")
    private RString hdnKey_AgeArrivalDay;
    @JsonProperty("hdnKey_OutShikibetsuCode")
    private RString hdnKey_OutShikibetsuCode;
    @JsonProperty("hdnGyoseikuCode")
    private RString hdnGyoseikuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHihokenshaNoSaiban
     * @return HihokenshaNoSaiban
     */
    @JsonProperty("HihokenshaNoSaiban")
    public HihokenshaNoSaibanDiv getHihokenshaNoSaiban() {
        return HihokenshaNoSaiban;
    }

    /*
     * setHihokenshaNoSaiban
     * @param HihokenshaNoSaiban HihokenshaNoSaiban
     */
    @JsonProperty("HihokenshaNoSaiban")
    public void setHihokenshaNoSaiban(HihokenshaNoSaibanDiv HihokenshaNoSaiban) {
        this.HihokenshaNoSaiban = HihokenshaNoSaiban;
    }

    /*
     * getSeikatsuHogoshaJohoInput
     * @return SeikatsuHogoshaJohoInput
     */
    @JsonProperty("SeikatsuHogoshaJohoInput")
    public SeikatsuHogoshaJohoInputDiv getSeikatsuHogoshaJohoInput() {
        return SeikatsuHogoshaJohoInput;
    }

    /*
     * setSeikatsuHogoshaJohoInput
     * @param SeikatsuHogoshaJohoInput SeikatsuHogoshaJohoInput
     */
    @JsonProperty("SeikatsuHogoshaJohoInput")
    public void setSeikatsuHogoshaJohoInput(SeikatsuHogoshaJohoInputDiv SeikatsuHogoshaJohoInput) {
        this.SeikatsuHogoshaJohoInput = SeikatsuHogoshaJohoInput;
    }

    /*
     * gethdnKey_Dialog
     * @return hdnKey_Dialog
     */
    @JsonProperty("hdnKey_Dialog")
    public RString getHdnKey_Dialog() {
        return hdnKey_Dialog;
    }

    /*
     * sethdnKey_Dialog
     * @param hdnKey_Dialog hdnKey_Dialog
     */
    @JsonProperty("hdnKey_Dialog")
    public void setHdnKey_Dialog(RString hdnKey_Dialog) {
        this.hdnKey_Dialog = hdnKey_Dialog;
    }

    /*
     * gethdnKey_GyomuCode
     * @return hdnKey_GyomuCode
     */
    @JsonProperty("hdnKey_GyomuCode")
    public RString getHdnKey_GyomuCode() {
        return hdnKey_GyomuCode;
    }

    /*
     * sethdnKey_GyomuCode
     * @param hdnKey_GyomuCode hdnKey_GyomuCode
     */
    @JsonProperty("hdnKey_GyomuCode")
    public void setHdnKey_GyomuCode(RString hdnKey_GyomuCode) {
        this.hdnKey_GyomuCode = hdnKey_GyomuCode;
    }

    /*
     * gethdnKey_SearchYusenKubun
     * @return hdnKey_SearchYusenKubun
     */
    @JsonProperty("hdnKey_SearchYusenKubun")
    public RString getHdnKey_SearchYusenKubun() {
        return hdnKey_SearchYusenKubun;
    }

    /*
     * sethdnKey_SearchYusenKubun
     * @param hdnKey_SearchYusenKubun hdnKey_SearchYusenKubun
     */
    @JsonProperty("hdnKey_SearchYusenKubun")
    public void setHdnKey_SearchYusenKubun(RString hdnKey_SearchYusenKubun) {
        this.hdnKey_SearchYusenKubun = hdnKey_SearchYusenKubun;
    }

    /*
     * gethdnKey_AgeArrivalDay
     * @return hdnKey_AgeArrivalDay
     */
    @JsonProperty("hdnKey_AgeArrivalDay")
    public RString getHdnKey_AgeArrivalDay() {
        return hdnKey_AgeArrivalDay;
    }

    /*
     * sethdnKey_AgeArrivalDay
     * @param hdnKey_AgeArrivalDay hdnKey_AgeArrivalDay
     */
    @JsonProperty("hdnKey_AgeArrivalDay")
    public void setHdnKey_AgeArrivalDay(RString hdnKey_AgeArrivalDay) {
        this.hdnKey_AgeArrivalDay = hdnKey_AgeArrivalDay;
    }

    /*
     * gethdnKey_OutShikibetsuCode
     * @return hdnKey_OutShikibetsuCode
     */
    @JsonProperty("hdnKey_OutShikibetsuCode")
    public RString getHdnKey_OutShikibetsuCode() {
        return hdnKey_OutShikibetsuCode;
    }

    /*
     * sethdnKey_OutShikibetsuCode
     * @param hdnKey_OutShikibetsuCode hdnKey_OutShikibetsuCode
     */
    @JsonProperty("hdnKey_OutShikibetsuCode")
    public void setHdnKey_OutShikibetsuCode(RString hdnKey_OutShikibetsuCode) {
        this.hdnKey_OutShikibetsuCode = hdnKey_OutShikibetsuCode;
    }

    /*
     * gethdnGyoseikuCode
     * @return hdnGyoseikuCode
     */
    @JsonProperty("hdnGyoseikuCode")
    public RString getHdnGyoseikuCode() {
        return hdnGyoseikuCode;
    }

    /*
     * sethdnGyoseikuCode
     * @param hdnGyoseikuCode hdnGyoseikuCode
     */
    @JsonProperty("hdnGyoseikuCode")
    public void setHdnGyoseikuCode(RString hdnGyoseikuCode) {
        this.hdnGyoseikuCode = hdnGyoseikuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShisho() {
        return this.getHihokenshaNoSaiban().getDdlShisho();
    }

    @JsonIgnore
    public void  setDdlShisho(DropDownList ddlShisho) {
        this.getHihokenshaNoSaiban().setDdlShisho(ddlShisho);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getHihokenshaNoSaiban().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getHihokenshaNoSaiban().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public Button getBtnSaiban() {
        return this.getHihokenshaNoSaiban().getBtnSaiban();
    }

    @JsonIgnore
    public void  setBtnSaiban(Button btnSaiban) {
        this.getHihokenshaNoSaiban().setBtnSaiban(btnSaiban);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getHihokenshaNoSaiban().getCcdHokenshaList();
    }

    @JsonIgnore
    public Button getBtnZenkaiSeikatsuhogoshaKensaku() {
        return this.getSeikatsuHogoshaJohoInput().getBtnZenkaiSeikatsuhogoshaKensaku();
    }

    @JsonIgnore
    public void  setBtnZenkaiSeikatsuhogoshaKensaku(Button btnZenkaiSeikatsuhogoshaKensaku) {
        this.getSeikatsuHogoshaJohoInput().setBtnZenkaiSeikatsuhogoshaKensaku(btnZenkaiSeikatsuhogoshaKensaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnAtenaKensaku() {
        return this.getSeikatsuHogoshaJohoInput().getBtnAtenaKensaku();
    }

    @JsonIgnore
    public void  setBtnAtenaKensaku(ButtonDialog btnAtenaKensaku) {
        this.getSeikatsuHogoshaJohoInput().setBtnAtenaKensaku(btnAtenaKensaku);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getSeikatsuHogoshaJohoInput().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getSeikatsuHogoshaJohoInput().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getSeikatsuHogoshaJohoInput().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getSeikatsuHogoshaJohoInput().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinNo() {
        return this.getSeikatsuHogoshaJohoInput().getTxtKojinNo();
    }

    @JsonIgnore
    public void  setTxtKojinNo(TextBoxCode txtKojinNo) {
        this.getSeikatsuHogoshaJohoInput().setTxtKojinNo(txtKojinNo);
    }

    @JsonIgnore
    public TextBox getTxtKanaShimei() {
        return this.getSeikatsuHogoshaJohoInput().getTxtKanaShimei();
    }

    @JsonIgnore
    public void  setTxtKanaShimei(TextBox txtKanaShimei) {
        this.getSeikatsuHogoshaJohoInput().setTxtKanaShimei(txtKanaShimei);
    }

    @JsonIgnore
    public TextBox getTxtGyoseiku() {
        return this.getSeikatsuHogoshaJohoInput().getTxtGyoseiku();
    }

    @JsonIgnore
    public void  setTxtGyoseiku(TextBox txtGyoseiku) {
        this.getSeikatsuHogoshaJohoInput().setTxtGyoseiku(txtGyoseiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtSetaiCode() {
        return this.getSeikatsuHogoshaJohoInput().getTxtSetaiCode();
    }

    @JsonIgnore
    public void  setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.getSeikatsuHogoshaJohoInput().setTxtSetaiCode(txtSetaiCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthYMD() {
        return this.getSeikatsuHogoshaJohoInput().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.getSeikatsuHogoshaJohoInput().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public RadioButton getRadSeibetsu() {
        return this.getSeikatsuHogoshaJohoInput().getRadSeibetsu();
    }

    @JsonIgnore
    public void  setRadSeibetsu(RadioButton radSeibetsu) {
        this.getSeikatsuHogoshaJohoInput().setRadSeibetsu(radSeibetsu);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getSeikatsuHogoshaJohoInput().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getSeikatsuHogoshaJohoInput().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getSeikatsuHogoshaJohoInput().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getSeikatsuHogoshaJohoInput().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput() {
        return this.getSeikatsuHogoshaJohoInput().getCcdZenkokuJushoInput();
    }

    // </editor-fold>
}
