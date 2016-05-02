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
 * TokubetsuChiikiKasanGemmenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuChiikiKasanGemmenDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinkiShinsei")
    private TextBox txtShinkiShinsei;
    @JsonProperty("txtSaishinsei")
    private TextBox txtSaishinsei;
    @JsonProperty("txtHenkoShinsei")
    private TextBox txtHenkoShinsei;
    @JsonProperty("txtServiceHenko")
    private TextBox txtServiceHenko;
    @JsonProperty("txtTodokedeKubun")
    private TextBox txtTodokedeKubun;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtKeikakuTekiyoStartDate")
    private TextBoxDate txtKeikakuTekiyoStartDate;
    @JsonProperty("txtKeikakuTekiyoEndDate")
    private TextBoxDate txtKeikakuTekiyoEndDate;
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtKyotakuKaigo")
    private TextBox txtKyotakuKaigo;
    @JsonProperty("txtKyotakuYobo")
    private TextBox txtKyotakuYobo;
    @JsonProperty("txtShokiboKaigo")
    private TextBox txtShokiboKaigo;
    @JsonProperty("txtShokiboYobo")
    private TextBox txtShokiboYobo;
    @JsonProperty("txtCare")
    private TextBox txtCare;
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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinkiShinsei
     * @return txtShinkiShinsei
     */
    @JsonProperty("txtShinkiShinsei")
    public TextBox getTxtShinkiShinsei() {
        return txtShinkiShinsei;
    }

    /*
     * settxtShinkiShinsei
     * @param txtShinkiShinsei txtShinkiShinsei
     */
    @JsonProperty("txtShinkiShinsei")
    public void setTxtShinkiShinsei(TextBox txtShinkiShinsei) {
        this.txtShinkiShinsei = txtShinkiShinsei;
    }

    /*
     * gettxtSaishinsei
     * @return txtSaishinsei
     */
    @JsonProperty("txtSaishinsei")
    public TextBox getTxtSaishinsei() {
        return txtSaishinsei;
    }

    /*
     * settxtSaishinsei
     * @param txtSaishinsei txtSaishinsei
     */
    @JsonProperty("txtSaishinsei")
    public void setTxtSaishinsei(TextBox txtSaishinsei) {
        this.txtSaishinsei = txtSaishinsei;
    }

    /*
     * gettxtHenkoShinsei
     * @return txtHenkoShinsei
     */
    @JsonProperty("txtHenkoShinsei")
    public TextBox getTxtHenkoShinsei() {
        return txtHenkoShinsei;
    }

    /*
     * settxtHenkoShinsei
     * @param txtHenkoShinsei txtHenkoShinsei
     */
    @JsonProperty("txtHenkoShinsei")
    public void setTxtHenkoShinsei(TextBox txtHenkoShinsei) {
        this.txtHenkoShinsei = txtHenkoShinsei;
    }

    /*
     * gettxtServiceHenko
     * @return txtServiceHenko
     */
    @JsonProperty("txtServiceHenko")
    public TextBox getTxtServiceHenko() {
        return txtServiceHenko;
    }

    /*
     * settxtServiceHenko
     * @param txtServiceHenko txtServiceHenko
     */
    @JsonProperty("txtServiceHenko")
    public void setTxtServiceHenko(TextBox txtServiceHenko) {
        this.txtServiceHenko = txtServiceHenko;
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
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
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
     * gettxtKeikakuTekiyoEndDate
     * @return txtKeikakuTekiyoEndDate
     */
    @JsonProperty("txtKeikakuTekiyoEndDate")
    public TextBoxDate getTxtKeikakuTekiyoEndDate() {
        return txtKeikakuTekiyoEndDate;
    }

    /*
     * settxtKeikakuTekiyoEndDate
     * @param txtKeikakuTekiyoEndDate txtKeikakuTekiyoEndDate
     */
    @JsonProperty("txtKeikakuTekiyoEndDate")
    public void setTxtKeikakuTekiyoEndDate(TextBoxDate txtKeikakuTekiyoEndDate) {
        this.txtKeikakuTekiyoEndDate = txtKeikakuTekiyoEndDate;
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
     * gettxtKyotakuKaigo
     * @return txtKyotakuKaigo
     */
    @JsonProperty("txtKyotakuKaigo")
    public TextBox getTxtKyotakuKaigo() {
        return txtKyotakuKaigo;
    }

    /*
     * settxtKyotakuKaigo
     * @param txtKyotakuKaigo txtKyotakuKaigo
     */
    @JsonProperty("txtKyotakuKaigo")
    public void setTxtKyotakuKaigo(TextBox txtKyotakuKaigo) {
        this.txtKyotakuKaigo = txtKyotakuKaigo;
    }

    /*
     * gettxtKyotakuYobo
     * @return txtKyotakuYobo
     */
    @JsonProperty("txtKyotakuYobo")
    public TextBox getTxtKyotakuYobo() {
        return txtKyotakuYobo;
    }

    /*
     * settxtKyotakuYobo
     * @param txtKyotakuYobo txtKyotakuYobo
     */
    @JsonProperty("txtKyotakuYobo")
    public void setTxtKyotakuYobo(TextBox txtKyotakuYobo) {
        this.txtKyotakuYobo = txtKyotakuYobo;
    }

    /*
     * gettxtShokiboKaigo
     * @return txtShokiboKaigo
     */
    @JsonProperty("txtShokiboKaigo")
    public TextBox getTxtShokiboKaigo() {
        return txtShokiboKaigo;
    }

    /*
     * settxtShokiboKaigo
     * @param txtShokiboKaigo txtShokiboKaigo
     */
    @JsonProperty("txtShokiboKaigo")
    public void setTxtShokiboKaigo(TextBox txtShokiboKaigo) {
        this.txtShokiboKaigo = txtShokiboKaigo;
    }

    /*
     * gettxtShokiboYobo
     * @return txtShokiboYobo
     */
    @JsonProperty("txtShokiboYobo")
    public TextBox getTxtShokiboYobo() {
        return txtShokiboYobo;
    }

    /*
     * settxtShokiboYobo
     * @param txtShokiboYobo txtShokiboYobo
     */
    @JsonProperty("txtShokiboYobo")
    public void setTxtShokiboYobo(TextBox txtShokiboYobo) {
        this.txtShokiboYobo = txtShokiboYobo;
    }

    /*
     * gettxtCare
     * @return txtCare
     */
    @JsonProperty("txtCare")
    public TextBox getTxtCare() {
        return txtCare;
    }

    /*
     * settxtCare
     * @param txtCare txtCare
     */
    @JsonProperty("txtCare")
    public void setTxtCare(TextBox txtCare) {
        this.txtCare = txtCare;
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

    // </editor-fold>
}
