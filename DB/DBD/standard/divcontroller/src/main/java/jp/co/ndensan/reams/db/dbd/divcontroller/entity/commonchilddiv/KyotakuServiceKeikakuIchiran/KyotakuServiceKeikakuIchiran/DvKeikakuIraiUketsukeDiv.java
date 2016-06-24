package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
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
 * DvKeikakuIraiUketsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvKeikakuIraiUketsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIraiNinteiShinseiJokyo")
    private TextBox txtIraiNinteiShinseiJokyo;
    @JsonProperty("txtTodokedeKubun")
    private TextBox txtTodokedeKubun;
    @JsonProperty("txtIraiShinseiDate")
    private TextBoxFlexibleDate txtIraiShinseiDate;
    @JsonProperty("txtKeikakuTekiyoStartDate")
    private TextBoxDate txtKeikakuTekiyoStartDate;
    @JsonProperty("txtIraiKeikakuTekiyoEndDate")
    private TextBoxDate txtIraiKeikakuTekiyoEndDate;
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtServiceShurui")
    private TextBox txtServiceShurui;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxMultiLine txtJusho;
    @JsonProperty("txtKanrishaName")
    private TextBoxMultiLine txtKanrishaName;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtItakusakiJigyoshaNo")
    private TextBoxCode txtItakusakiJigyoshaNo;
    @JsonProperty("txtItakusakiJigyoshaName")
    private TextBox txtItakusakiJigyoshaName;
    @JsonProperty("txtHenkoDate")
    private TextBoxDate txtHenkoDate;
    @JsonProperty("txtHenkoRiyu")
    private TextBoxMultiLine txtHenkoRiyu;
    @JsonProperty("btnKeikakuIraiClose")
    private Button btnKeikakuIraiClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIraiNinteiShinseiJokyo
     * @return txtIraiNinteiShinseiJokyo
     */
    @JsonProperty("txtIraiNinteiShinseiJokyo")
    public TextBox getTxtIraiNinteiShinseiJokyo() {
        return txtIraiNinteiShinseiJokyo;
    }

    /*
     * settxtIraiNinteiShinseiJokyo
     * @param txtIraiNinteiShinseiJokyo txtIraiNinteiShinseiJokyo
     */
    @JsonProperty("txtIraiNinteiShinseiJokyo")
    public void setTxtIraiNinteiShinseiJokyo(TextBox txtIraiNinteiShinseiJokyo) {
        this.txtIraiNinteiShinseiJokyo = txtIraiNinteiShinseiJokyo;
    }

    /*
     * gettxtTodokedeKubun
     * @return txtTodokedeKubun
     */
    @JsonProperty("txtTodokedeKubun")
    public TextBox getTxtTodokedeKubun() {
        return txtTodokedeKubun;
    }

    /*
     * settxtTodokedeKubun
     * @param txtTodokedeKubun txtTodokedeKubun
     */
    @JsonProperty("txtTodokedeKubun")
    public void setTxtTodokedeKubun(TextBox txtTodokedeKubun) {
        this.txtTodokedeKubun = txtTodokedeKubun;
    }

    /*
     * gettxtIraiShinseiDate
     * @return txtIraiShinseiDate
     */
    @JsonProperty("txtIraiShinseiDate")
    public TextBoxFlexibleDate getTxtIraiShinseiDate() {
        return txtIraiShinseiDate;
    }

    /*
     * settxtIraiShinseiDate
     * @param txtIraiShinseiDate txtIraiShinseiDate
     */
    @JsonProperty("txtIraiShinseiDate")
    public void setTxtIraiShinseiDate(TextBoxFlexibleDate txtIraiShinseiDate) {
        this.txtIraiShinseiDate = txtIraiShinseiDate;
    }

    /*
     * gettxtKeikakuTekiyoStartDate
     * @return txtKeikakuTekiyoStartDate
     */
    @JsonProperty("txtKeikakuTekiyoStartDate")
    public TextBoxDate getTxtKeikakuTekiyoStartDate() {
        return txtKeikakuTekiyoStartDate;
    }

    /*
     * settxtKeikakuTekiyoStartDate
     * @param txtKeikakuTekiyoStartDate txtKeikakuTekiyoStartDate
     */
    @JsonProperty("txtKeikakuTekiyoStartDate")
    public void setTxtKeikakuTekiyoStartDate(TextBoxDate txtKeikakuTekiyoStartDate) {
        this.txtKeikakuTekiyoStartDate = txtKeikakuTekiyoStartDate;
    }

    /*
     * gettxtIraiKeikakuTekiyoEndDate
     * @return txtIraiKeikakuTekiyoEndDate
     */
    @JsonProperty("txtIraiKeikakuTekiyoEndDate")
    public TextBoxDate getTxtIraiKeikakuTekiyoEndDate() {
        return txtIraiKeikakuTekiyoEndDate;
    }

    /*
     * settxtIraiKeikakuTekiyoEndDate
     * @param txtIraiKeikakuTekiyoEndDate txtIraiKeikakuTekiyoEndDate
     */
    @JsonProperty("txtIraiKeikakuTekiyoEndDate")
    public void setTxtIraiKeikakuTekiyoEndDate(TextBoxDate txtIraiKeikakuTekiyoEndDate) {
        this.txtIraiKeikakuTekiyoEndDate = txtIraiKeikakuTekiyoEndDate;
    }

    /*
     * gettxtKeikakuSakuseiKubun
     * @return txtKeikakuSakuseiKubun
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    public TextBox getTxtKeikakuSakuseiKubun() {
        return txtKeikakuSakuseiKubun;
    }

    /*
     * settxtKeikakuSakuseiKubun
     * @param txtKeikakuSakuseiKubun txtKeikakuSakuseiKubun
     */
    @JsonProperty("txtKeikakuSakuseiKubun")
    public void setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.txtKeikakuSakuseiKubun = txtKeikakuSakuseiKubun;
    }

    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
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
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * gettxtServiceShurui
     * @return txtServiceShurui
     */
    @JsonProperty("txtServiceShurui")
    public TextBox getTxtServiceShurui() {
        return txtServiceShurui;
    }

    /*
     * settxtServiceShurui
     * @param txtServiceShurui txtServiceShurui
     */
    @JsonProperty("txtServiceShurui")
    public void setTxtServiceShurui(TextBox txtServiceShurui) {
        this.txtServiceShurui = txtServiceShurui;
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
    public TextBoxMultiLine getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxMultiLine txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtKanrishaName
     * @return txtKanrishaName
     */
    @JsonProperty("txtKanrishaName")
    public TextBoxMultiLine getTxtKanrishaName() {
        return txtKanrishaName;
    }

    /*
     * settxtKanrishaName
     * @param txtKanrishaName txtKanrishaName
     */
    @JsonProperty("txtKanrishaName")
    public void setTxtKanrishaName(TextBoxMultiLine txtKanrishaName) {
        this.txtKanrishaName = txtKanrishaName;
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
     * gettxtItakusakiJigyoshaNo
     * @return txtItakusakiJigyoshaNo
     */
    @JsonProperty("txtItakusakiJigyoshaNo")
    public TextBoxCode getTxtItakusakiJigyoshaNo() {
        return txtItakusakiJigyoshaNo;
    }

    /*
     * settxtItakusakiJigyoshaNo
     * @param txtItakusakiJigyoshaNo txtItakusakiJigyoshaNo
     */
    @JsonProperty("txtItakusakiJigyoshaNo")
    public void setTxtItakusakiJigyoshaNo(TextBoxCode txtItakusakiJigyoshaNo) {
        this.txtItakusakiJigyoshaNo = txtItakusakiJigyoshaNo;
    }

    /*
     * gettxtItakusakiJigyoshaName
     * @return txtItakusakiJigyoshaName
     */
    @JsonProperty("txtItakusakiJigyoshaName")
    public TextBox getTxtItakusakiJigyoshaName() {
        return txtItakusakiJigyoshaName;
    }

    /*
     * settxtItakusakiJigyoshaName
     * @param txtItakusakiJigyoshaName txtItakusakiJigyoshaName
     */
    @JsonProperty("txtItakusakiJigyoshaName")
    public void setTxtItakusakiJigyoshaName(TextBox txtItakusakiJigyoshaName) {
        this.txtItakusakiJigyoshaName = txtItakusakiJigyoshaName;
    }

    /*
     * gettxtHenkoDate
     * @return txtHenkoDate
     */
    @JsonProperty("txtHenkoDate")
    public TextBoxDate getTxtHenkoDate() {
        return txtHenkoDate;
    }

    /*
     * settxtHenkoDate
     * @param txtHenkoDate txtHenkoDate
     */
    @JsonProperty("txtHenkoDate")
    public void setTxtHenkoDate(TextBoxDate txtHenkoDate) {
        this.txtHenkoDate = txtHenkoDate;
    }

    /*
     * gettxtHenkoRiyu
     * @return txtHenkoRiyu
     */
    @JsonProperty("txtHenkoRiyu")
    public TextBoxMultiLine getTxtHenkoRiyu() {
        return txtHenkoRiyu;
    }

    /*
     * settxtHenkoRiyu
     * @param txtHenkoRiyu txtHenkoRiyu
     */
    @JsonProperty("txtHenkoRiyu")
    public void setTxtHenkoRiyu(TextBoxMultiLine txtHenkoRiyu) {
        this.txtHenkoRiyu = txtHenkoRiyu;
    }

    /*
     * getbtnKeikakuIraiClose
     * @return btnKeikakuIraiClose
     */
    @JsonProperty("btnKeikakuIraiClose")
    public Button getBtnKeikakuIraiClose() {
        return btnKeikakuIraiClose;
    }

    /*
     * setbtnKeikakuIraiClose
     * @param btnKeikakuIraiClose btnKeikakuIraiClose
     */
    @JsonProperty("btnKeikakuIraiClose")
    public void setBtnKeikakuIraiClose(Button btnKeikakuIraiClose) {
        this.btnKeikakuIraiClose = btnKeikakuIraiClose;
    }

    // </editor-fold>
}
