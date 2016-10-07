package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
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
    @JsonProperty("ShoninJoho")
    private ShoninJohoDiv ShoninJoho;
    @JsonProperty("btnShoninKakutei")
    private Button btnShoninKakutei;
    @JsonProperty("btnShinseiKakutei")
    private Button btnShinseiKakutei;
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
     * getShoninJoho
     * @return ShoninJoho
     */
    @JsonProperty("ShoninJoho")
    public ShoninJohoDiv getShoninJoho() {
        return ShoninJoho;
    }

    /*
     * setShoninJoho
     * @param ShoninJoho ShoninJoho
     */
    @JsonProperty("ShoninJoho")
    public void setShoninJoho(ShoninJohoDiv ShoninJoho) {
        this.ShoninJoho = ShoninJoho;
    }

    /*
     * getbtnShoninKakutei
     * @return btnShoninKakutei
     */
    @JsonProperty("btnShoninKakutei")
    public Button getBtnShoninKakutei() {
        return btnShoninKakutei;
    }

    /*
     * setbtnShoninKakutei
     * @param btnShoninKakutei btnShoninKakutei
     */
    @JsonProperty("btnShoninKakutei")
    public void setBtnShoninKakutei(Button btnShoninKakutei) {
        this.btnShoninKakutei = btnShoninKakutei;
    }

    /*
     * getbtnShinseiKakutei
     * @return btnShinseiKakutei
     */
    @JsonProperty("btnShinseiKakutei")
    public Button getBtnShinseiKakutei() {
        return btnShinseiKakutei;
    }

    /*
     * setbtnShinseiKakutei
     * @param btnShinseiKakutei btnShinseiKakutei
     */
    @JsonProperty("btnShinseiKakutei")
    public void setBtnShinseiKakutei(Button btnShinseiKakutei) {
        this.btnShinseiKakutei = btnShinseiKakutei;
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
    public RadioButton getRadKetteiKubun() {
        return this.getShoninJoho().getRadKetteiKubun();
    }

    @JsonIgnore
    public void  setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getShoninJoho().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getShoninJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getShoninJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getShoninJoho().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void  setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getShoninJoho().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getShoninJoho().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getShoninJoho().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkTokureiTaisho() {
        return this.getShoninJoho().getChkTokureiTaisho();
    }

    @JsonIgnore
    public void  setChkTokureiTaisho(CheckBoxList chkTokureiTaisho) {
        this.getShoninJoho().setChkTokureiTaisho(chkTokureiTaisho);
    }

    @JsonIgnore
    public DropDownList getDdlKeigenJiyu() {
        return this.getShoninJoho().getDdlKeigenJiyu();
    }

    @JsonIgnore
    public void  setDdlKeigenJiyu(DropDownList ddlKeigenJiyu) {
        this.getShoninJoho().setDdlKeigenJiyu(ddlKeigenJiyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsuBunshi() {
        return this.getShoninJoho().getTxtKeigenRitsuBunshi();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsuBunshi(TextBoxNum txtKeigenRitsuBunshi) {
        this.getShoninJoho().setTxtKeigenRitsuBunshi(txtKeigenRitsuBunshi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsuBunbo() {
        return this.getShoninJoho().getTxtKeigenRitsuBunbo();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsuBunbo(TextBoxNum txtKeigenRitsuBunbo) {
        this.getShoninJoho().setTxtKeigenRitsuBunbo(txtKeigenRitsuBunbo);
    }

    @JsonIgnore
    public CheckBoxList getChkKyotakuServiceGentei() {
        return this.getShoninJoho().getChkKyotakuServiceGentei();
    }

    @JsonIgnore
    public void  setChkKyotakuServiceGentei(CheckBoxList chkKyotakuServiceGentei) {
        this.getShoninJoho().setChkKyotakuServiceGentei(chkKyotakuServiceGentei);
    }

    @JsonIgnore
    public CheckBoxList getChkKyojuhiShokuhiGentei() {
        return this.getShoninJoho().getChkKyojuhiShokuhiGentei();
    }

    @JsonIgnore
    public void  setChkKyojuhiShokuhiGentei(CheckBoxList chkKyojuhiShokuhiGentei) {
        this.getShoninJoho().setChkKyojuhiShokuhiGentei(chkKyojuhiShokuhiGentei);
    }

    @JsonIgnore
    public CheckBoxList getChkKyusochiUnitGataJunKoshitsu() {
        return this.getShoninJoho().getChkKyusochiUnitGataJunKoshitsu();
    }

    @JsonIgnore
    public void  setChkKyusochiUnitGataJunKoshitsu(CheckBoxList chkKyusochiUnitGataJunKoshitsu) {
        this.getShoninJoho().setChkKyusochiUnitGataJunKoshitsu(chkKyusochiUnitGataJunKoshitsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKakuninNo() {
        return this.getShoninJoho().getTxtKakuninNo();
    }

    @JsonIgnore
    public void  setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.getShoninJoho().setTxtKakuninNo(txtKakuninNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnSelectHiShoninRiyu() {
        return this.getShoninJoho().getBtnSelectHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnSelectHiShoninRiyu(ButtonDialog btnSelectHiShoninRiyu) {
        this.getShoninJoho().setBtnSelectHiShoninRiyu(btnSelectHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShoninJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShoninJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    // </editor-fold>
}
