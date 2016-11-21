package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
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
 * JutakuKaishuShinseiResetInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiResetInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHiyoTotal")
    private Label lblHiyoTotal;
    @JsonProperty("lblHokenTaishoHiyo")
    private Label lblHokenTaishoHiyo;
    @JsonProperty("lblHokenKyufuAmount")
    private Label lblHokenKyufuAmount;
    @JsonProperty("lblRiyoshaFutanAmount")
    private Label lblRiyoshaFutanAmount;
    @JsonProperty("txtHiyoTotalMae")
    private TextBoxNum txtHiyoTotalMae;
    @JsonProperty("txtHokenTaishoHiyoMae")
    private TextBoxNum txtHokenTaishoHiyoMae;
    @JsonProperty("txtHokenKyufuAmountMae")
    private TextBoxNum txtHokenKyufuAmountMae;
    @JsonProperty("txtRiyoshaFutanAmountMae")
    private TextBoxNum txtRiyoshaFutanAmountMae;
    @JsonProperty("txtHiyoTotalNow")
    private TextBoxNum txtHiyoTotalNow;
    @JsonProperty("txtHokenTaishoHiyoNow")
    private TextBoxNum txtHokenTaishoHiyoNow;
    @JsonProperty("txtHokenKyufuAmountNow")
    private TextBoxNum txtHokenKyufuAmountNow;
    @JsonProperty("txtRiyoshaFutanAmountNow")
    private TextBoxNum txtRiyoshaFutanAmountNow;
    @JsonProperty("btnLimitOverCheck")
    private Button btnLimitOverCheck;
    @JsonProperty("chkResetInfo")
    private CheckBoxList chkResetInfo;
    @JsonProperty("hdnResetServiceYM")
    private RString hdnResetServiceYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHiyoTotal
     * @return lblHiyoTotal
     */
    @JsonProperty("lblHiyoTotal")
    public Label getLblHiyoTotal() {
        return lblHiyoTotal;
    }

    /*
     * setlblHiyoTotal
     * @param lblHiyoTotal lblHiyoTotal
     */
    @JsonProperty("lblHiyoTotal")
    public void setLblHiyoTotal(Label lblHiyoTotal) {
        this.lblHiyoTotal = lblHiyoTotal;
    }

    /*
     * getlblHokenTaishoHiyo
     * @return lblHokenTaishoHiyo
     */
    @JsonProperty("lblHokenTaishoHiyo")
    public Label getLblHokenTaishoHiyo() {
        return lblHokenTaishoHiyo;
    }

    /*
     * setlblHokenTaishoHiyo
     * @param lblHokenTaishoHiyo lblHokenTaishoHiyo
     */
    @JsonProperty("lblHokenTaishoHiyo")
    public void setLblHokenTaishoHiyo(Label lblHokenTaishoHiyo) {
        this.lblHokenTaishoHiyo = lblHokenTaishoHiyo;
    }

    /*
     * getlblHokenKyufuAmount
     * @return lblHokenKyufuAmount
     */
    @JsonProperty("lblHokenKyufuAmount")
    public Label getLblHokenKyufuAmount() {
        return lblHokenKyufuAmount;
    }

    /*
     * setlblHokenKyufuAmount
     * @param lblHokenKyufuAmount lblHokenKyufuAmount
     */
    @JsonProperty("lblHokenKyufuAmount")
    public void setLblHokenKyufuAmount(Label lblHokenKyufuAmount) {
        this.lblHokenKyufuAmount = lblHokenKyufuAmount;
    }

    /*
     * getlblRiyoshaFutanAmount
     * @return lblRiyoshaFutanAmount
     */
    @JsonProperty("lblRiyoshaFutanAmount")
    public Label getLblRiyoshaFutanAmount() {
        return lblRiyoshaFutanAmount;
    }

    /*
     * setlblRiyoshaFutanAmount
     * @param lblRiyoshaFutanAmount lblRiyoshaFutanAmount
     */
    @JsonProperty("lblRiyoshaFutanAmount")
    public void setLblRiyoshaFutanAmount(Label lblRiyoshaFutanAmount) {
        this.lblRiyoshaFutanAmount = lblRiyoshaFutanAmount;
    }

    /*
     * gettxtHiyoTotalMae
     * @return txtHiyoTotalMae
     */
    @JsonProperty("txtHiyoTotalMae")
    public TextBoxNum getTxtHiyoTotalMae() {
        return txtHiyoTotalMae;
    }

    /*
     * settxtHiyoTotalMae
     * @param txtHiyoTotalMae txtHiyoTotalMae
     */
    @JsonProperty("txtHiyoTotalMae")
    public void setTxtHiyoTotalMae(TextBoxNum txtHiyoTotalMae) {
        this.txtHiyoTotalMae = txtHiyoTotalMae;
    }

    /*
     * gettxtHokenTaishoHiyoMae
     * @return txtHokenTaishoHiyoMae
     */
    @JsonProperty("txtHokenTaishoHiyoMae")
    public TextBoxNum getTxtHokenTaishoHiyoMae() {
        return txtHokenTaishoHiyoMae;
    }

    /*
     * settxtHokenTaishoHiyoMae
     * @param txtHokenTaishoHiyoMae txtHokenTaishoHiyoMae
     */
    @JsonProperty("txtHokenTaishoHiyoMae")
    public void setTxtHokenTaishoHiyoMae(TextBoxNum txtHokenTaishoHiyoMae) {
        this.txtHokenTaishoHiyoMae = txtHokenTaishoHiyoMae;
    }

    /*
     * gettxtHokenKyufuAmountMae
     * @return txtHokenKyufuAmountMae
     */
    @JsonProperty("txtHokenKyufuAmountMae")
    public TextBoxNum getTxtHokenKyufuAmountMae() {
        return txtHokenKyufuAmountMae;
    }

    /*
     * settxtHokenKyufuAmountMae
     * @param txtHokenKyufuAmountMae txtHokenKyufuAmountMae
     */
    @JsonProperty("txtHokenKyufuAmountMae")
    public void setTxtHokenKyufuAmountMae(TextBoxNum txtHokenKyufuAmountMae) {
        this.txtHokenKyufuAmountMae = txtHokenKyufuAmountMae;
    }

    /*
     * gettxtRiyoshaFutanAmountMae
     * @return txtRiyoshaFutanAmountMae
     */
    @JsonProperty("txtRiyoshaFutanAmountMae")
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return txtRiyoshaFutanAmountMae;
    }

    /*
     * settxtRiyoshaFutanAmountMae
     * @param txtRiyoshaFutanAmountMae txtRiyoshaFutanAmountMae
     */
    @JsonProperty("txtRiyoshaFutanAmountMae")
    public void setTxtRiyoshaFutanAmountMae(TextBoxNum txtRiyoshaFutanAmountMae) {
        this.txtRiyoshaFutanAmountMae = txtRiyoshaFutanAmountMae;
    }

    /*
     * gettxtHiyoTotalNow
     * @return txtHiyoTotalNow
     */
    @JsonProperty("txtHiyoTotalNow")
    public TextBoxNum getTxtHiyoTotalNow() {
        return txtHiyoTotalNow;
    }

    /*
     * settxtHiyoTotalNow
     * @param txtHiyoTotalNow txtHiyoTotalNow
     */
    @JsonProperty("txtHiyoTotalNow")
    public void setTxtHiyoTotalNow(TextBoxNum txtHiyoTotalNow) {
        this.txtHiyoTotalNow = txtHiyoTotalNow;
    }

    /*
     * gettxtHokenTaishoHiyoNow
     * @return txtHokenTaishoHiyoNow
     */
    @JsonProperty("txtHokenTaishoHiyoNow")
    public TextBoxNum getTxtHokenTaishoHiyoNow() {
        return txtHokenTaishoHiyoNow;
    }

    /*
     * settxtHokenTaishoHiyoNow
     * @param txtHokenTaishoHiyoNow txtHokenTaishoHiyoNow
     */
    @JsonProperty("txtHokenTaishoHiyoNow")
    public void setTxtHokenTaishoHiyoNow(TextBoxNum txtHokenTaishoHiyoNow) {
        this.txtHokenTaishoHiyoNow = txtHokenTaishoHiyoNow;
    }

    /*
     * gettxtHokenKyufuAmountNow
     * @return txtHokenKyufuAmountNow
     */
    @JsonProperty("txtHokenKyufuAmountNow")
    public TextBoxNum getTxtHokenKyufuAmountNow() {
        return txtHokenKyufuAmountNow;
    }

    /*
     * settxtHokenKyufuAmountNow
     * @param txtHokenKyufuAmountNow txtHokenKyufuAmountNow
     */
    @JsonProperty("txtHokenKyufuAmountNow")
    public void setTxtHokenKyufuAmountNow(TextBoxNum txtHokenKyufuAmountNow) {
        this.txtHokenKyufuAmountNow = txtHokenKyufuAmountNow;
    }

    /*
     * gettxtRiyoshaFutanAmountNow
     * @return txtRiyoshaFutanAmountNow
     */
    @JsonProperty("txtRiyoshaFutanAmountNow")
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return txtRiyoshaFutanAmountNow;
    }

    /*
     * settxtRiyoshaFutanAmountNow
     * @param txtRiyoshaFutanAmountNow txtRiyoshaFutanAmountNow
     */
    @JsonProperty("txtRiyoshaFutanAmountNow")
    public void setTxtRiyoshaFutanAmountNow(TextBoxNum txtRiyoshaFutanAmountNow) {
        this.txtRiyoshaFutanAmountNow = txtRiyoshaFutanAmountNow;
    }

    /*
     * getbtnLimitOverCheck
     * @return btnLimitOverCheck
     */
    @JsonProperty("btnLimitOverCheck")
    public Button getBtnLimitOverCheck() {
        return btnLimitOverCheck;
    }

    /*
     * setbtnLimitOverCheck
     * @param btnLimitOverCheck btnLimitOverCheck
     */
    @JsonProperty("btnLimitOverCheck")
    public void setBtnLimitOverCheck(Button btnLimitOverCheck) {
        this.btnLimitOverCheck = btnLimitOverCheck;
    }

    /*
     * getchkResetInfo
     * @return chkResetInfo
     */
    @JsonProperty("chkResetInfo")
    public CheckBoxList getChkResetInfo() {
        return chkResetInfo;
    }

    /*
     * setchkResetInfo
     * @param chkResetInfo chkResetInfo
     */
    @JsonProperty("chkResetInfo")
    public void setChkResetInfo(CheckBoxList chkResetInfo) {
        this.chkResetInfo = chkResetInfo;
    }

    /*
     * gethdnResetServiceYM
     * @return hdnResetServiceYM
     */
    @JsonProperty("hdnResetServiceYM")
    public RString getHdnResetServiceYM() {
        return hdnResetServiceYM;
    }

    /*
     * sethdnResetServiceYM
     * @param hdnResetServiceYM hdnResetServiceYM
     */
    @JsonProperty("hdnResetServiceYM")
    public void setHdnResetServiceYM(RString hdnResetServiceYM) {
        this.hdnResetServiceYM = hdnResetServiceYM;
    }

    // </editor-fold>
}
