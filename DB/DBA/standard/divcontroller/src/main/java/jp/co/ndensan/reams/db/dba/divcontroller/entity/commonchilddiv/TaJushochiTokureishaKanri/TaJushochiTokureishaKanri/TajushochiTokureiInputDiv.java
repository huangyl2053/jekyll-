package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hokenshajoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TajushochiTokureiInput のクラスファイル
 *
 * @reamsid_L DBA-0200-010 linghuhang
 */
public class TajushochiTokureiInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyusyobi")
    private TextBoxDate txtNyusyobi;
    @JsonProperty("txtTekiyobi")
    private TextBoxDate txtTekiyobi;
    @JsonProperty("txtTekiyoTodokedebi")
    private TextBoxDate txtTekiyoTodokedebi;
    @JsonProperty("ddlTekiyoJiyo")
    private DropDownList ddlTekiyoJiyo;
    @JsonProperty("txtTasyobi")
    private TextBoxDate txtTasyobi;
    @JsonProperty("txtKaijyobi")
    private TextBoxDate txtKaijyobi;
    @JsonProperty("txtKaijyoTodokedebi")
    private TextBoxDate txtKaijyoTodokedebi;
    @JsonProperty("ddlKaijyoJiyo")
    private DropDownList ddlKaijyoJiyo;
    @JsonProperty("panSotimotoJyoho")
    private panSotimotoJyohoDiv panSotimotoJyoho;
    @JsonProperty("panShisetsuJoho")
    private panShisetsuJohoDiv panShisetsuJoho;
    @JsonProperty("btnKakunin")
    private Button btnKakunin;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("HiddenInputShikibetsuCode")
    private RString HiddenInputShikibetsuCode;
    @JsonProperty("HiddenInputIdoYMD")
    private RString HiddenInputIdoYMD;
    @JsonProperty("HiddenInputEdaNo")
    private RString HiddenInputEdaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNyusyobi
     * @return txtNyusyobi
     */
    @JsonProperty("txtNyusyobi")
    public TextBoxDate getTxtNyusyobi() {
        return txtNyusyobi;
    }

    /*
     * settxtNyusyobi
     * @param txtNyusyobi txtNyusyobi
     */
    @JsonProperty("txtNyusyobi")
    public void setTxtNyusyobi(TextBoxDate txtNyusyobi) {
        this.txtNyusyobi = txtNyusyobi;
    }

    /*
     * gettxtTekiyobi
     * @return txtTekiyobi
     */
    @JsonProperty("txtTekiyobi")
    public TextBoxDate getTxtTekiyobi() {
        return txtTekiyobi;
    }

    /*
     * settxtTekiyobi
     * @param txtTekiyobi txtTekiyobi
     */
    @JsonProperty("txtTekiyobi")
    public void setTxtTekiyobi(TextBoxDate txtTekiyobi) {
        this.txtTekiyobi = txtTekiyobi;
    }

    /*
     * gettxtTekiyoTodokedebi
     * @return txtTekiyoTodokedebi
     */
    @JsonProperty("txtTekiyoTodokedebi")
    public TextBoxDate getTxtTekiyoTodokedebi() {
        return txtTekiyoTodokedebi;
    }

    /*
     * settxtTekiyoTodokedebi
     * @param txtTekiyoTodokedebi txtTekiyoTodokedebi
     */
    @JsonProperty("txtTekiyoTodokedebi")
    public void setTxtTekiyoTodokedebi(TextBoxDate txtTekiyoTodokedebi) {
        this.txtTekiyoTodokedebi = txtTekiyoTodokedebi;
    }

    /*
     * getddlTekiyoJiyo
     * @return ddlTekiyoJiyo
     */
    @JsonProperty("ddlTekiyoJiyo")
    public DropDownList getDdlTekiyoJiyo() {
        return ddlTekiyoJiyo;
    }

    /*
     * setddlTekiyoJiyo
     * @param ddlTekiyoJiyo ddlTekiyoJiyo
     */
    @JsonProperty("ddlTekiyoJiyo")
    public void setDdlTekiyoJiyo(DropDownList ddlTekiyoJiyo) {
        this.ddlTekiyoJiyo = ddlTekiyoJiyo;
    }

    /*
     * gettxtTasyobi
     * @return txtTasyobi
     */
    @JsonProperty("txtTasyobi")
    public TextBoxDate getTxtTasyobi() {
        return txtTasyobi;
    }

    /*
     * settxtTasyobi
     * @param txtTasyobi txtTasyobi
     */
    @JsonProperty("txtTasyobi")
    public void setTxtTasyobi(TextBoxDate txtTasyobi) {
        this.txtTasyobi = txtTasyobi;
    }

    /*
     * gettxtKaijyobi
     * @return txtKaijyobi
     */
    @JsonProperty("txtKaijyobi")
    public TextBoxDate getTxtKaijyobi() {
        return txtKaijyobi;
    }

    /*
     * settxtKaijyobi
     * @param txtKaijyobi txtKaijyobi
     */
    @JsonProperty("txtKaijyobi")
    public void setTxtKaijyobi(TextBoxDate txtKaijyobi) {
        this.txtKaijyobi = txtKaijyobi;
    }

    /*
     * gettxtKaijyoTodokedebi
     * @return txtKaijyoTodokedebi
     */
    @JsonProperty("txtKaijyoTodokedebi")
    public TextBoxDate getTxtKaijyoTodokedebi() {
        return txtKaijyoTodokedebi;
    }

    /*
     * settxtKaijyoTodokedebi
     * @param txtKaijyoTodokedebi txtKaijyoTodokedebi
     */
    @JsonProperty("txtKaijyoTodokedebi")
    public void setTxtKaijyoTodokedebi(TextBoxDate txtKaijyoTodokedebi) {
        this.txtKaijyoTodokedebi = txtKaijyoTodokedebi;
    }

    /*
     * getddlKaijyoJiyo
     * @return ddlKaijyoJiyo
     */
    @JsonProperty("ddlKaijyoJiyo")
    public DropDownList getDdlKaijyoJiyo() {
        return ddlKaijyoJiyo;
    }

    /*
     * setddlKaijyoJiyo
     * @param ddlKaijyoJiyo ddlKaijyoJiyo
     */
    @JsonProperty("ddlKaijyoJiyo")
    public void setDdlKaijyoJiyo(DropDownList ddlKaijyoJiyo) {
        this.ddlKaijyoJiyo = ddlKaijyoJiyo;
    }

    /*
     * getpanSotimotoJyoho
     * @return panSotimotoJyoho
     */
    @JsonProperty("panSotimotoJyoho")
    public panSotimotoJyohoDiv getPanSotimotoJyoho() {
        return panSotimotoJyoho;
    }

    /*
     * setpanSotimotoJyoho
     * @param panSotimotoJyoho panSotimotoJyoho
     */
    @JsonProperty("panSotimotoJyoho")
    public void setPanSotimotoJyoho(panSotimotoJyohoDiv panSotimotoJyoho) {
        this.panSotimotoJyoho = panSotimotoJyoho;
    }

    /*
     * getpanShisetsuJoho
     * @return panShisetsuJoho
     */
    @JsonProperty("panShisetsuJoho")
    public panShisetsuJohoDiv getPanShisetsuJoho() {
        return panShisetsuJoho;
    }

    /*
     * setpanShisetsuJoho
     * @param panShisetsuJoho panShisetsuJoho
     */
    @JsonProperty("panShisetsuJoho")
    public void setPanShisetsuJoho(panShisetsuJohoDiv panShisetsuJoho) {
        this.panShisetsuJoho = panShisetsuJoho;
    }

    /*
     * getbtnKakunin
     * @return btnKakunin
     */
    @JsonProperty("btnKakunin")
    public Button getBtnKakunin() {
        return btnKakunin;
    }

    /*
     * setbtnKakunin
     * @param btnKakunin btnKakunin
     */
    @JsonProperty("btnKakunin")
    public void setBtnKakunin(Button btnKakunin) {
        this.btnKakunin = btnKakunin;
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
     * getHiddenInputShikibetsuCode
     * @return HiddenInputShikibetsuCode
     */
    @JsonProperty("HiddenInputShikibetsuCode")
    public RString getHiddenInputShikibetsuCode() {
        return HiddenInputShikibetsuCode;
    }

    /*
     * setHiddenInputShikibetsuCode
     * @param HiddenInputShikibetsuCode HiddenInputShikibetsuCode
     */
    @JsonProperty("HiddenInputShikibetsuCode")
    public void setHiddenInputShikibetsuCode(RString HiddenInputShikibetsuCode) {
        this.HiddenInputShikibetsuCode = HiddenInputShikibetsuCode;
    }

    /*
     * getHiddenInputIdoYMD
     * @return HiddenInputIdoYMD
     */
    @JsonProperty("HiddenInputIdoYMD")
    public RString getHiddenInputIdoYMD() {
        return HiddenInputIdoYMD;
    }

    /*
     * setHiddenInputIdoYMD
     * @param HiddenInputIdoYMD HiddenInputIdoYMD
     */
    @JsonProperty("HiddenInputIdoYMD")
    public void setHiddenInputIdoYMD(RString HiddenInputIdoYMD) {
        this.HiddenInputIdoYMD = HiddenInputIdoYMD;
    }

    /*
     * getHiddenInputEdaNo
     * @return HiddenInputEdaNo
     */
    @JsonProperty("HiddenInputEdaNo")
    public RString getHiddenInputEdaNo() {
        return HiddenInputEdaNo;
    }

    /*
     * setHiddenInputEdaNo
     * @param HiddenInputEdaNo HiddenInputEdaNo
     */
    @JsonProperty("HiddenInputEdaNo")
    public void setHiddenInputEdaNo(RString HiddenInputEdaNo) {
        this.HiddenInputEdaNo = HiddenInputEdaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getPanSotimotoJyoho().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getPanSotimotoJyoho().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public IHokenshaJohoDiv getCcdHokensha() {
        return this.getPanSotimotoJyoho().getCcdHokensha();
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getPanShisetsuJoho().getCcdShisetsuJoho();
    }

    // </editor-fold>
}
