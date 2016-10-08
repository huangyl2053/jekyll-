package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.IGemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HomonKaigoGengakuShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonKaigoGengakuShinseiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxFlexibleDate txtShinseiYMD;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("ShogaishaTecho")
    private ShogaishaTechoDiv ShogaishaTecho;
    @JsonProperty("KetteiJoho")
    private KetteiJohoDiv KetteiJoho;
    @JsonProperty("btnAddShinseiJoho")
    private Button btnAddShinseiJoho;
    @JsonProperty("btnReturnShinseiIchiran")
    private Button btnReturnShinseiIchiran;
    @JsonProperty("ccdShinseiJoho")
    private GemmenGengakuShinseiDiv ccdShinseiJoho;
    @JsonProperty("subGyomuCode")
    private RString subGyomuCode;
    @JsonProperty("sampleBunshoGroupCode")
    private RString sampleBunshoGroupCode;
    @JsonProperty("teikeibun")
    private RString teikeibun;

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
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
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
     * getShogaishaTecho
     * @return ShogaishaTecho
     */
    @JsonProperty("ShogaishaTecho")
    public ShogaishaTechoDiv getShogaishaTecho() {
        return ShogaishaTecho;
    }

    /*
     * setShogaishaTecho
     * @param ShogaishaTecho ShogaishaTecho
     */
    @JsonProperty("ShogaishaTecho")
    public void setShogaishaTecho(ShogaishaTechoDiv ShogaishaTecho) {
        this.ShogaishaTecho = ShogaishaTecho;
    }

    /*
     * getKetteiJoho
     * @return KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public KetteiJohoDiv getKetteiJoho() {
        return KetteiJoho;
    }

    /*
     * setKetteiJoho
     * @param KetteiJoho KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public void setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.KetteiJoho = KetteiJoho;
    }

    /*
     * getbtnAddShinseiJoho
     * @return btnAddShinseiJoho
     */
    @JsonProperty("btnAddShinseiJoho")
    public Button getBtnAddShinseiJoho() {
        return btnAddShinseiJoho;
    }

    /*
     * setbtnAddShinseiJoho
     * @param btnAddShinseiJoho btnAddShinseiJoho
     */
    @JsonProperty("btnAddShinseiJoho")
    public void setBtnAddShinseiJoho(Button btnAddShinseiJoho) {
        this.btnAddShinseiJoho = btnAddShinseiJoho;
    }

    /*
     * getbtnReturnShinseiIchiran
     * @return btnReturnShinseiIchiran
     */
    @JsonProperty("btnReturnShinseiIchiran")
    public Button getBtnReturnShinseiIchiran() {
        return btnReturnShinseiIchiran;
    }

    /*
     * setbtnReturnShinseiIchiran
     * @param btnReturnShinseiIchiran btnReturnShinseiIchiran
     */
    @JsonProperty("btnReturnShinseiIchiran")
    public void setBtnReturnShinseiIchiran(Button btnReturnShinseiIchiran) {
        this.btnReturnShinseiIchiran = btnReturnShinseiIchiran;
    }

    /*
     * getccdShinseiJoho
     * @return ccdShinseiJoho
     */
    @JsonProperty("ccdShinseiJoho")
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return ccdShinseiJoho;
    }

    /*
     * getsubGyomuCode
     * @return subGyomuCode
     */
    @JsonProperty("subGyomuCode")
    public RString getSubGyomuCode() {
        return subGyomuCode;
    }

    /*
     * setsubGyomuCode
     * @param subGyomuCode subGyomuCode
     */
    @JsonProperty("subGyomuCode")
    public void setSubGyomuCode(RString subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /*
     * getsampleBunshoGroupCode
     * @return sampleBunshoGroupCode
     */
    @JsonProperty("sampleBunshoGroupCode")
    public RString getSampleBunshoGroupCode() {
        return sampleBunshoGroupCode;
    }

    /*
     * setsampleBunshoGroupCode
     * @param sampleBunshoGroupCode sampleBunshoGroupCode
     */
    @JsonProperty("sampleBunshoGroupCode")
    public void setSampleBunshoGroupCode(RString sampleBunshoGroupCode) {
        this.sampleBunshoGroupCode = sampleBunshoGroupCode;
    }

    /*
     * getteikeibun
     * @return teikeibun
     */
    @JsonProperty("teikeibun")
    public RString getTeikeibun() {
        return teikeibun;
    }

    /*
     * setteikeibun
     * @param teikeibun teikeibun
     */
    @JsonProperty("teikeibun")
    public void setTeikeibun(RString teikeibun) {
        this.teikeibun = teikeibun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShogaishaTechoUmu() {
        return this.getShogaishaTecho().getRadShogaishaTechoUmu();
    }

    @JsonIgnore
    public void  setRadShogaishaTechoUmu(RadioButton radShogaishaTechoUmu) {
        this.getShogaishaTecho().setRadShogaishaTechoUmu(radShogaishaTechoUmu);
    }

    @JsonIgnore
    public TextBox getTxtShogaishaTechoTokyu() {
        return this.getShogaishaTecho().getTxtShogaishaTechoTokyu();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoTokyu(TextBox txtShogaishaTechoTokyu) {
        this.getShogaishaTecho().setTxtShogaishaTechoTokyu(txtShogaishaTechoTokyu);
    }

    @JsonIgnore
    public TextBox getTxtShogaishaTechoNo() {
        return this.getShogaishaTecho().getTxtShogaishaTechoNo();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoNo(TextBox txtShogaishaTechoNo) {
        this.getShogaishaTecho().setTxtShogaishaTechoNo(txtShogaishaTechoNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShogaishaTechoKofuYMD() {
        return this.getShogaishaTecho().getTxtShogaishaTechoKofuYMD();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoKofuYMD(TextBoxFlexibleDate txtShogaishaTechoKofuYMD) {
        this.getShogaishaTecho().setTxtShogaishaTechoKofuYMD(txtShogaishaTechoKofuYMD);
    }

    @JsonIgnore
    public RadioButton getDdlKettaiKubun() {
        return this.getKetteiJoho().getDdlKettaiKubun();
    }

    @JsonIgnore
    public void  setDdlKettaiKubun(RadioButton ddlKettaiKubun) {
        this.getKetteiJoho().setDdlKettaiKubun(ddlKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYmd() {
        return this.getKetteiJoho().getTxtKettaiYmd();
    }

    @JsonIgnore
    public void  setTxtKettaiYmd(TextBoxFlexibleDate txtKettaiYmd) {
        this.getKetteiJoho().setTxtKettaiYmd(txtKettaiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYmd() {
        return this.getKetteiJoho().getTxtTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoYmd(TextBoxFlexibleDate txtTekiyoYmd) {
        this.getKetteiJoho().setTxtTekiyoYmd(txtTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return this.getKetteiJoho().getTxtYukoKigen();
    }

    @JsonIgnore
    public void  setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.getKetteiJoho().setTxtYukoKigen(txtYukoKigen);
    }

    @JsonIgnore
    public DropDownList getDdlHobetsuKubun() {
        return this.getKetteiJoho().getDdlHobetsuKubun();
    }

    @JsonIgnore
    public void  setDdlHobetsuKubun(DropDownList ddlHobetsuKubun) {
        this.getKetteiJoho().setDdlHobetsuKubun(ddlHobetsuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuRitsu() {
        return this.getKetteiJoho().getTxtKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.getKetteiJoho().setTxtKyufuRitsu(txtKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtKohiFutanshaNo() {
        return this.getKetteiJoho().getTxtKohiFutanshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiFutanshaNo(TextBox txtKohiFutanshaNo) {
        this.getKetteiJoho().setTxtKohiFutanshaNo(txtKohiFutanshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJyukyshaNo() {
        return this.getKetteiJoho().getTxtKohiJyukyshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiJyukyshaNo(TextBoxCode txtKohiJyukyshaNo) {
        this.getKetteiJoho().setTxtKohiJyukyshaNo(txtKohiJyukyshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJyukyushaNoCheckDigit() {
        return this.getKetteiJoho().getTxtKohiJyukyushaNoCheckDigit();
    }

    @JsonIgnore
    public void  setTxtKohiJyukyushaNoCheckDigit(TextBoxCode txtKohiJyukyushaNoCheckDigit) {
        this.getKetteiJoho().setTxtKohiJyukyushaNoCheckDigit(txtKohiJyukyushaNoCheckDigit);
    }

    @JsonIgnore
    public ButtonDialog getBtnOpenHiShoninRiyu() {
        return this.getKetteiJoho().getBtnOpenHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnOpenHiShoninRiyu(ButtonDialog btnOpenHiShoninRiyu) {
        this.getKetteiJoho().setBtnOpenHiShoninRiyu(btnOpenHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    // </editor-fold>
}
