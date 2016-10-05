package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001;
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
 * ShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDetailDiv extends Panel {
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
    @JsonProperty("KetteiJoho")
    private KetteiJohoDiv KetteiJoho;
    @JsonProperty("txtDetermineShinsei")
    private Button txtDetermineShinsei;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnBackToShinseiList")
    private Button btnBackToShinseiList;
    @JsonProperty("ccdShinseiJoho")
    private GemmenGengakuShinseiDiv ccdShinseiJoho;

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
     * gettxtDetermineShinsei
     * @return txtDetermineShinsei
     */
    @JsonProperty("txtDetermineShinsei")
    public Button getTxtDetermineShinsei() {
        return txtDetermineShinsei;
    }

    /*
     * settxtDetermineShinsei
     * @param txtDetermineShinsei txtDetermineShinsei
     */
    @JsonProperty("txtDetermineShinsei")
    public void setTxtDetermineShinsei(Button txtDetermineShinsei) {
        this.txtDetermineShinsei = txtDetermineShinsei;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnBackToShinseiList
     * @return btnBackToShinseiList
     */
    @JsonProperty("btnBackToShinseiList")
    public Button getBtnBackToShinseiList() {
        return btnBackToShinseiList;
    }

    /*
     * setbtnBackToShinseiList
     * @param btnBackToShinseiList btnBackToShinseiList
     */
    @JsonProperty("btnBackToShinseiList")
    public void setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.btnBackToShinseiList = btnBackToShinseiList;
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
    public RadioButton getRadKettaiKubun() {
        return this.getKetteiJoho().getRadKettaiKubun();
    }

    @JsonIgnore
    public void  setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.getKetteiJoho().setRadKettaiKubun(radKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return this.getKetteiJoho().getTxtKettaiYMD();
    }

    @JsonIgnore
    public void  setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.getKetteiJoho().setTxtKettaiYMD(txtKettaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getKetteiJoho().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void  setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getKetteiJoho().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getKetteiJoho().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getKetteiJoho().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsu() {
        return this.getKetteiJoho().getTxtKeigenRitsu();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsu(TextBoxNum txtKeigenRitsu) {
        this.getKetteiJoho().setTxtKeigenRitsu(txtKeigenRitsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKakuninNo() {
        return this.getKetteiJoho().getTxtKakuninNo();
    }

    @JsonIgnore
    public void  setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.getKetteiJoho().setTxtKakuninNo(txtKakuninNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getKetteiJoho().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getKetteiJoho().setBtnHiShoninRiyu(btnHiShoninRiyu);
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
