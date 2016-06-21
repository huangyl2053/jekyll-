package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvJikoSakuseiKeikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvJikoSakuseiKeikakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJikoNinteiShinseiJokyo")
    private TextBox txtJikoNinteiShinseiJokyo;
    @JsonProperty("linLine6")
    private HorizontalLine linLine6;
    @JsonProperty("txtSetteiYM")
    private TextBoxDate txtSetteiYM;
    @JsonProperty("linLine2")
    private HorizontalLine linLine2;
    @JsonProperty("txtSakuseiDate")
    private TextBoxDate txtSakuseiDate;
    @JsonProperty("txtJikoShinseiDate")
    private TextBoxFlexibleDate txtJikoShinseiDate;
    @JsonProperty("txtJikoKeikakuTekiyoStartDate")
    private TextBoxDate txtJikoKeikakuTekiyoStartDate;
    @JsonProperty("txtJikoKeikakuTekiyoEndDate")
    private TextBoxDate txtJikoKeikakuTekiyoEndDate;
    @JsonProperty("chkZanteiKeikaku")
    private CheckBoxList chkZanteiKeikaku;
    @JsonProperty("ninteiJoho")
    private ninteiJohoDiv ninteiJoho;
    @JsonProperty("btnJikoSakuseiClose")
    private Button btnJikoSakuseiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJikoNinteiShinseiJokyo
     * @return txtJikoNinteiShinseiJokyo
     */
    @JsonProperty("txtJikoNinteiShinseiJokyo")
    public TextBox getTxtJikoNinteiShinseiJokyo() {
        return txtJikoNinteiShinseiJokyo;
    }

    /*
     * settxtJikoNinteiShinseiJokyo
     * @param txtJikoNinteiShinseiJokyo txtJikoNinteiShinseiJokyo
     */
    @JsonProperty("txtJikoNinteiShinseiJokyo")
    public void setTxtJikoNinteiShinseiJokyo(TextBox txtJikoNinteiShinseiJokyo) {
        this.txtJikoNinteiShinseiJokyo = txtJikoNinteiShinseiJokyo;
    }

    /*
     * getlinLine6
     * @return linLine6
     */
    @JsonProperty("linLine6")
    public HorizontalLine getLinLine6() {
        return linLine6;
    }

    /*
     * setlinLine6
     * @param linLine6 linLine6
     */
    @JsonProperty("linLine6")
    public void setLinLine6(HorizontalLine linLine6) {
        this.linLine6 = linLine6;
    }

    /*
     * gettxtSetteiYM
     * @return txtSetteiYM
     */
    @JsonProperty("txtSetteiYM")
    public TextBoxDate getTxtSetteiYM() {
        return txtSetteiYM;
    }

    /*
     * settxtSetteiYM
     * @param txtSetteiYM txtSetteiYM
     */
    @JsonProperty("txtSetteiYM")
    public void setTxtSetteiYM(TextBoxDate txtSetteiYM) {
        this.txtSetteiYM = txtSetteiYM;
    }

    /*
     * getlinLine2
     * @return linLine2
     */
    @JsonProperty("linLine2")
    public HorizontalLine getLinLine2() {
        return linLine2;
    }

    /*
     * setlinLine2
     * @param linLine2 linLine2
     */
    @JsonProperty("linLine2")
    public void setLinLine2(HorizontalLine linLine2) {
        this.linLine2 = linLine2;
    }

    /*
     * gettxtSakuseiDate
     * @return txtSakuseiDate
     */
    @JsonProperty("txtSakuseiDate")
    public TextBoxDate getTxtSakuseiDate() {
        return txtSakuseiDate;
    }

    /*
     * settxtSakuseiDate
     * @param txtSakuseiDate txtSakuseiDate
     */
    @JsonProperty("txtSakuseiDate")
    public void setTxtSakuseiDate(TextBoxDate txtSakuseiDate) {
        this.txtSakuseiDate = txtSakuseiDate;
    }

    /*
     * gettxtJikoShinseiDate
     * @return txtJikoShinseiDate
     */
    @JsonProperty("txtJikoShinseiDate")
    public TextBoxFlexibleDate getTxtJikoShinseiDate() {
        return txtJikoShinseiDate;
    }

    /*
     * settxtJikoShinseiDate
     * @param txtJikoShinseiDate txtJikoShinseiDate
     */
    @JsonProperty("txtJikoShinseiDate")
    public void setTxtJikoShinseiDate(TextBoxFlexibleDate txtJikoShinseiDate) {
        this.txtJikoShinseiDate = txtJikoShinseiDate;
    }

    /*
     * gettxtJikoKeikakuTekiyoStartDate
     * @return txtJikoKeikakuTekiyoStartDate
     */
    @JsonProperty("txtJikoKeikakuTekiyoStartDate")
    public TextBoxDate getTxtJikoKeikakuTekiyoStartDate() {
        return txtJikoKeikakuTekiyoStartDate;
    }

    /*
     * settxtJikoKeikakuTekiyoStartDate
     * @param txtJikoKeikakuTekiyoStartDate txtJikoKeikakuTekiyoStartDate
     */
    @JsonProperty("txtJikoKeikakuTekiyoStartDate")
    public void setTxtJikoKeikakuTekiyoStartDate(TextBoxDate txtJikoKeikakuTekiyoStartDate) {
        this.txtJikoKeikakuTekiyoStartDate = txtJikoKeikakuTekiyoStartDate;
    }

    /*
     * gettxtJikoKeikakuTekiyoEndDate
     * @return txtJikoKeikakuTekiyoEndDate
     */
    @JsonProperty("txtJikoKeikakuTekiyoEndDate")
    public TextBoxDate getTxtJikoKeikakuTekiyoEndDate() {
        return txtJikoKeikakuTekiyoEndDate;
    }

    /*
     * settxtJikoKeikakuTekiyoEndDate
     * @param txtJikoKeikakuTekiyoEndDate txtJikoKeikakuTekiyoEndDate
     */
    @JsonProperty("txtJikoKeikakuTekiyoEndDate")
    public void setTxtJikoKeikakuTekiyoEndDate(TextBoxDate txtJikoKeikakuTekiyoEndDate) {
        this.txtJikoKeikakuTekiyoEndDate = txtJikoKeikakuTekiyoEndDate;
    }

    /*
     * getchkZanteiKeikaku
     * @return chkZanteiKeikaku
     */
    @JsonProperty("chkZanteiKeikaku")
    public CheckBoxList getChkZanteiKeikaku() {
        return chkZanteiKeikaku;
    }

    /*
     * setchkZanteiKeikaku
     * @param chkZanteiKeikaku chkZanteiKeikaku
     */
    @JsonProperty("chkZanteiKeikaku")
    public void setChkZanteiKeikaku(CheckBoxList chkZanteiKeikaku) {
        this.chkZanteiKeikaku = chkZanteiKeikaku;
    }

    /*
     * getninteiJoho
     * @return ninteiJoho
     */
    @JsonProperty("ninteiJoho")
    public ninteiJohoDiv getNinteiJoho() {
        return ninteiJoho;
    }

    /*
     * setninteiJoho
     * @param ninteiJoho ninteiJoho
     */
    @JsonProperty("ninteiJoho")
    public void setNinteiJoho(ninteiJohoDiv ninteiJoho) {
        this.ninteiJoho = ninteiJoho;
    }

    /*
     * getbtnJikoSakuseiClose
     * @return btnJikoSakuseiClose
     */
    @JsonProperty("btnJikoSakuseiClose")
    public Button getBtnJikoSakuseiClose() {
        return btnJikoSakuseiClose;
    }

    /*
     * setbtnJikoSakuseiClose
     * @param btnJikoSakuseiClose btnJikoSakuseiClose
     */
    @JsonProperty("btnJikoSakuseiClose")
    public void setBtnJikoSakuseiClose(Button btnJikoSakuseiClose) {
        this.btnJikoSakuseiClose = btnJikoSakuseiClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getNinteiJoho().getTxtYokaigodo();
    }

    @JsonIgnore
    public void  setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getNinteiJoho().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukokikan() {
        return this.getNinteiJoho().getTxtNinteiYukokikan();
    }

    @JsonIgnore
    public void  setTxtNinteiYukokikan(TextBoxDateRange txtNinteiYukokikan) {
        this.getNinteiJoho().setTxtNinteiYukokikan(txtNinteiYukokikan);
    }

    // </editor-fold>
}
