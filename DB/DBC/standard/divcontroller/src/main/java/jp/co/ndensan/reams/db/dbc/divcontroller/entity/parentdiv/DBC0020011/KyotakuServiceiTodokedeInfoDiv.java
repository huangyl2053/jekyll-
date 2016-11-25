package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuServiceiTodokedeInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceiTodokedeInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokedeYmd")
    private TextBoxDate txtTodokedeYmd;
    @JsonProperty("txtTodokedeKubun")
    private TextBox txtTodokedeKubun;
    @JsonProperty("txtTekiyoKikan")
    private TextBoxDateRange txtTekiyoKikan;
    @JsonProperty("txtKyotakuSogoJigyoKubun")
    private TextBox txtKyotakuSogoJigyoKubun;
    @JsonProperty("Todokedesha")
    private TodokedeshaDiv Todokedesha;
    @JsonProperty("txtKeikakuSakuseiKubun")
    private TextBox txtKeikakuSakuseiKubun;
    @JsonProperty("KeikakuJigyosha")
    private KeikakuJigyoshaDiv KeikakuJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTodokedeYmd
     * @return txtTodokedeYmd
     */
    @JsonProperty("txtTodokedeYmd")
    public TextBoxDate getTxtTodokedeYmd() {
        return txtTodokedeYmd;
    }

    /*
     * settxtTodokedeYmd
     * @param txtTodokedeYmd txtTodokedeYmd
     */
    @JsonProperty("txtTodokedeYmd")
    public void setTxtTodokedeYmd(TextBoxDate txtTodokedeYmd) {
        this.txtTodokedeYmd = txtTodokedeYmd;
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
     * gettxtTekiyoKikan
     * @return txtTekiyoKikan
     */
    @JsonProperty("txtTekiyoKikan")
    public TextBoxDateRange getTxtTekiyoKikan() {
        return txtTekiyoKikan;
    }

    /*
     * settxtTekiyoKikan
     * @param txtTekiyoKikan txtTekiyoKikan
     */
    @JsonProperty("txtTekiyoKikan")
    public void setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.txtTekiyoKikan = txtTekiyoKikan;
    }

    /*
     * gettxtKyotakuSogoJigyoKubun
     * @return txtKyotakuSogoJigyoKubun
     */
    @JsonProperty("txtKyotakuSogoJigyoKubun")
    public TextBox getTxtKyotakuSogoJigyoKubun() {
        return txtKyotakuSogoJigyoKubun;
    }

    /*
     * settxtKyotakuSogoJigyoKubun
     * @param txtKyotakuSogoJigyoKubun txtKyotakuSogoJigyoKubun
     */
    @JsonProperty("txtKyotakuSogoJigyoKubun")
    public void setTxtKyotakuSogoJigyoKubun(TextBox txtKyotakuSogoJigyoKubun) {
        this.txtKyotakuSogoJigyoKubun = txtKyotakuSogoJigyoKubun;
    }

    /*
     * getTodokedesha
     * @return Todokedesha
     */
    @JsonProperty("Todokedesha")
    public TodokedeshaDiv getTodokedesha() {
        return Todokedesha;
    }

    /*
     * setTodokedesha
     * @param Todokedesha Todokedesha
     */
    @JsonProperty("Todokedesha")
    public void setTodokedesha(TodokedeshaDiv Todokedesha) {
        this.Todokedesha = Todokedesha;
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
     * getKeikakuJigyosha
     * @return KeikakuJigyosha
     */
    @JsonProperty("KeikakuJigyosha")
    public KeikakuJigyoshaDiv getKeikakuJigyosha() {
        return KeikakuJigyosha;
    }

    /*
     * setKeikakuJigyosha
     * @param KeikakuJigyosha KeikakuJigyosha
     */
    @JsonProperty("KeikakuJigyosha")
    public void setKeikakuJigyosha(KeikakuJigyoshaDiv KeikakuJigyosha) {
        this.KeikakuJigyosha = KeikakuJigyosha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtJigyoshaNo() {
        return this.getKeikakuJigyosha().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNo(TextBox txtJigyoshaNo) {
        this.getKeikakuJigyosha().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getKeikakuJigyosha().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getKeikakuJigyosha().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiMeisho() {
        return this.getKeikakuJigyosha().getTxtServiceShuruiMeisho();
    }

    @JsonIgnore
    public void  setTxtServiceShuruiMeisho(TextBox txtServiceShuruiMeisho) {
        this.getKeikakuJigyosha().setTxtServiceShuruiMeisho(txtServiceShuruiMeisho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJigyoshaYubinNo() {
        return this.getKeikakuJigyosha().getTxtJigyoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaYubinNo(TextBoxYubinNo txtJigyoshaYubinNo) {
        this.getKeikakuJigyosha().setTxtJigyoshaYubinNo(txtJigyoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaJusho() {
        return this.getKeikakuJigyosha().getTxtJigyoshaJusho();
    }

    @JsonIgnore
    public void  setTxtJigyoshaJusho(TextBox txtJigyoshaJusho) {
        this.getKeikakuJigyosha().setTxtJigyoshaJusho(txtJigyoshaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJigyoshaTelNo() {
        return this.getKeikakuJigyosha().getTxtJigyoshaTelNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaTelNo(TextBoxTelNo txtJigyoshaTelNo) {
        this.getKeikakuJigyosha().setTxtJigyoshaTelNo(txtJigyoshaTelNo);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtKanrishaName() {
        return this.getKeikakuJigyosha().getTxtKanrishaName();
    }

    @JsonIgnore
    public void  setTxtKanrishaName(TextBoxAtenaMeisho txtKanrishaName) {
        this.getKeikakuJigyosha().setTxtKanrishaName(txtKanrishaName);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaNo() {
        return this.getKeikakuJigyosha().getTxtItakusakiJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtItakusakiJigyoshaNo(TextBox txtItakusakiJigyoshaNo) {
        this.getKeikakuJigyosha().setTxtItakusakiJigyoshaNo(txtItakusakiJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaName() {
        return this.getKeikakuJigyosha().getTxtItakusakiJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtItakusakiJigyoshaName(TextBox txtItakusakiJigyoshaName) {
        this.getKeikakuJigyosha().setTxtItakusakiJigyoshaName(txtItakusakiJigyoshaName);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoYMD() {
        return this.getKeikakuJigyosha().getTxtHenkoYMD();
    }

    @JsonIgnore
    public void  setTxtHenkoYMD(TextBoxDate txtHenkoYMD) {
        this.getKeikakuJigyosha().setTxtHenkoYMD(txtHenkoYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHenkoJiyu() {
        return this.getKeikakuJigyosha().getTxtHenkoJiyu();
    }

    @JsonIgnore
    public void  setTxtHenkoJiyu(TextBoxMultiLine txtHenkoJiyu) {
        this.getKeikakuJigyosha().setTxtHenkoJiyu(txtHenkoJiyu);
    }

    // </editor-fold>
}
