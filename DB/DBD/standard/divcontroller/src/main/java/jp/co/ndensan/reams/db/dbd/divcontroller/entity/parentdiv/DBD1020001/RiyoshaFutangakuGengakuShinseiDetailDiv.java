package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.IGemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutangakuGengakuShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutangakuGengakuShinseiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYmd")
    private TextBoxFlexibleDate txtShinseiYmd;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("KetteiNaiyo")
    private KetteiNaiyoDiv KetteiNaiyo;
    @JsonProperty("ccdJohoAreaButton")
    private ccdJohoAreaButtonDiv ccdJohoAreaButton;
    @JsonProperty("ccdShinseiJoho")
    private GemmenGengakuShinseiDiv ccdShinseiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYmd
     * @return txtShinseiYmd
     */
    @JsonProperty("txtShinseiYmd")
    public TextBoxFlexibleDate getTxtShinseiYmd() {
        return txtShinseiYmd;
    }

    /*
     * settxtShinseiYmd
     * @param txtShinseiYmd txtShinseiYmd
     */
    @JsonProperty("txtShinseiYmd")
    public void setTxtShinseiYmd(TextBoxFlexibleDate txtShinseiYmd) {
        this.txtShinseiYmd = txtShinseiYmd;
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
     * getKetteiNaiyo
     * @return KetteiNaiyo
     */
    @JsonProperty("KetteiNaiyo")
    public KetteiNaiyoDiv getKetteiNaiyo() {
        return KetteiNaiyo;
    }

    /*
     * setKetteiNaiyo
     * @param KetteiNaiyo KetteiNaiyo
     */
    @JsonProperty("KetteiNaiyo")
    public void setKetteiNaiyo(KetteiNaiyoDiv KetteiNaiyo) {
        this.KetteiNaiyo = KetteiNaiyo;
    }

    /*
     * getccdJohoAreaButton
     * @return ccdJohoAreaButton
     */
    @JsonProperty("ccdJohoAreaButton")
    public ccdJohoAreaButtonDiv getCcdJohoAreaButton() {
        return ccdJohoAreaButton;
    }

    /*
     * setccdJohoAreaButton
     * @param ccdJohoAreaButton ccdJohoAreaButton
     */
    @JsonProperty("ccdJohoAreaButton")
    public void setCcdJohoAreaButton(ccdJohoAreaButtonDiv ccdJohoAreaButton) {
        this.ccdJohoAreaButton = ccdJohoAreaButton;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getKetteiNaiyo().getRadKetteiKubun();
    }

    @JsonIgnore
    public void  setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getKetteiNaiyo().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYmd() {
        return this.getKetteiNaiyo().getTxtKettaiYmd();
    }

    @JsonIgnore
    public void  setTxtKettaiYmd(TextBoxFlexibleDate txtKettaiYmd) {
        this.getKetteiNaiyo().setTxtKettaiYmd(txtKettaiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYmd() {
        return this.getKetteiNaiyo().getTxtTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoYmd(TextBoxFlexibleDate txtTekiyoYmd) {
        this.getKetteiNaiyo().setTxtTekiyoYmd(txtTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYmd() {
        return this.getKetteiNaiyo().getTxtYukoKigenYmd();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYmd(TextBoxFlexibleDate txtYukoKigenYmd) {
        this.getKetteiNaiyo().setTxtYukoKigenYmd(txtYukoKigenYmd);
    }

    @JsonIgnore
    public DropDownList getDdlKyusochiKubun() {
        return this.getKetteiNaiyo().getDdlKyusochiKubun();
    }

    @JsonIgnore
    public void  setDdlKyusochiKubun(DropDownList ddlKyusochiKubun) {
        this.getKetteiNaiyo().setDdlKyusochiKubun(ddlKyusochiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuRitsu() {
        return this.getKetteiNaiyo().getTxtKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.getKetteiNaiyo().setTxtKyufuRitsu(txtKyufuRitsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getKetteiNaiyo().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getKetteiNaiyo().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getKetteiNaiyo().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getKetteiNaiyo().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getBtnShinseiKakutei() {
        return this.getCcdJohoAreaButton().getBtnShinseiKakutei();
    }

    @JsonIgnore
    public void  setBtnShinseiKakutei(Button btnShinseiKakutei) {
        this.getCcdJohoAreaButton().setBtnShinseiKakutei(btnShinseiKakutei);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getCcdJohoAreaButton().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getCcdJohoAreaButton().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnBackShinseiIchirai() {
        return this.getCcdJohoAreaButton().getBtnBackShinseiIchirai();
    }

    @JsonIgnore
    public void  setBtnBackShinseiIchirai(Button btnBackShinseiIchirai) {
        this.getCcdJohoAreaButton().setBtnBackShinseiIchirai(btnBackShinseiIchirai);
    }

    // </editor-fold>
}
