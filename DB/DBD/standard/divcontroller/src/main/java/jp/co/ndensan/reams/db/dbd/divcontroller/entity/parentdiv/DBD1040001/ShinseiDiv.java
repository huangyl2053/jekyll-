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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtSetaiKazaiJokyo")
    private TextBox txtSetaiKazaiJokyo;
    @JsonProperty("btnDispSetaiJoho")
    private ButtonDialog btnDispSetaiJoho;
    @JsonProperty("btnDispGemmenJoho")
    private ButtonDialog btnDispGemmenJoho;
    @JsonProperty("ShinseiList")
    private ShinseiListDiv ShinseiList;
    @JsonProperty("ShinseiDetail")
    private ShinseiDetailDiv ShinseiDetail;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("subGyomuCode")
    private RString subGyomuCode;
    @JsonProperty("sampleBunshoGroupCode")
    private RString sampleBunshoGroupCode;
    @JsonProperty("txtShikibetsuCode")
    private RString txtShikibetsuCode;
    @JsonProperty("txtShotokuKijunYMDHMS")
    private RString txtShotokuKijunYMDHMS;
    @JsonProperty("subBunsho")
    private RString subBunsho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtSetaiKazaiJokyo
     * @return txtSetaiKazaiJokyo
     */
    @JsonProperty("txtSetaiKazaiJokyo")
    public TextBox getTxtSetaiKazaiJokyo() {
        return txtSetaiKazaiJokyo;
    }

    /*
     * settxtSetaiKazaiJokyo
     * @param txtSetaiKazaiJokyo txtSetaiKazaiJokyo
     */
    @JsonProperty("txtSetaiKazaiJokyo")
    public void setTxtSetaiKazaiJokyo(TextBox txtSetaiKazaiJokyo) {
        this.txtSetaiKazaiJokyo = txtSetaiKazaiJokyo;
    }

    /*
     * getbtnDispSetaiJoho
     * @return btnDispSetaiJoho
     */
    @JsonProperty("btnDispSetaiJoho")
    public ButtonDialog getBtnDispSetaiJoho() {
        return btnDispSetaiJoho;
    }

    /*
     * setbtnDispSetaiJoho
     * @param btnDispSetaiJoho btnDispSetaiJoho
     */
    @JsonProperty("btnDispSetaiJoho")
    public void setBtnDispSetaiJoho(ButtonDialog btnDispSetaiJoho) {
        this.btnDispSetaiJoho = btnDispSetaiJoho;
    }

    /*
     * getbtnDispGemmenJoho
     * @return btnDispGemmenJoho
     */
    @JsonProperty("btnDispGemmenJoho")
    public ButtonDialog getBtnDispGemmenJoho() {
        return btnDispGemmenJoho;
    }

    /*
     * setbtnDispGemmenJoho
     * @param btnDispGemmenJoho btnDispGemmenJoho
     */
    @JsonProperty("btnDispGemmenJoho")
    public void setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.btnDispGemmenJoho = btnDispGemmenJoho;
    }

    /*
     * getShinseiList
     * @return ShinseiList
     */
    @JsonProperty("ShinseiList")
    public ShinseiListDiv getShinseiList() {
        return ShinseiList;
    }

    /*
     * setShinseiList
     * @param ShinseiList ShinseiList
     */
    @JsonProperty("ShinseiList")
    public void setShinseiList(ShinseiListDiv ShinseiList) {
        this.ShinseiList = ShinseiList;
    }

    /*
     * getShinseiDetail
     * @return ShinseiDetail
     */
    @JsonProperty("ShinseiDetail")
    public ShinseiDetailDiv getShinseiDetail() {
        return ShinseiDetail;
    }

    /*
     * setShinseiDetail
     * @param ShinseiDetail ShinseiDetail
     */
    @JsonProperty("ShinseiDetail")
    public void setShinseiDetail(ShinseiDetailDiv ShinseiDetail) {
        this.ShinseiDetail = ShinseiDetail;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShotokuKijunYMDHMS
     * @return txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public RString getTxtShotokuKijunYMDHMS() {
        return txtShotokuKijunYMDHMS;
    }

    /*
     * settxtShotokuKijunYMDHMS
     * @param txtShotokuKijunYMDHMS txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public void setTxtShotokuKijunYMDHMS(RString txtShotokuKijunYMDHMS) {
        this.txtShotokuKijunYMDHMS = txtShotokuKijunYMDHMS;
    }

    /*
     * getsubBunsho
     * @return subBunsho
     */
    @JsonProperty("subBunsho")
    public RString getSubBunsho() {
        return subBunsho;
    }

    /*
     * setsubBunsho
     * @param subBunsho subBunsho
     */
    @JsonProperty("subBunsho")
    public void setSubBunsho(RString subBunsho) {
        this.subBunsho = subBunsho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getShinseiDetail().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getShinseiDetail().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKettaiKubun() {
        return this.getShinseiDetail().getKetteiJoho().getRadKettaiKubun();
    }

    @JsonIgnore
    public void  setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.getShinseiDetail().getKetteiJoho().setRadKettaiKubun(radKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return this.getShinseiDetail().getKetteiJoho().getTxtKettaiYMD();
    }

    @JsonIgnore
    public void  setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.getShinseiDetail().getKetteiJoho().setTxtKettaiYMD(txtKettaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getShinseiDetail().getKetteiJoho().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void  setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getShinseiDetail().getKetteiJoho().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getShinseiDetail().getKetteiJoho().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getShinseiDetail().getKetteiJoho().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsu() {
        return this.getShinseiDetail().getKetteiJoho().getTxtKeigenRitsu();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsu(TextBoxNum txtKeigenRitsu) {
        this.getShinseiDetail().getKetteiJoho().setTxtKeigenRitsu(txtKeigenRitsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKakuninNo() {
        return this.getShinseiDetail().getKetteiJoho().getTxtKakuninNo();
    }

    @JsonIgnore
    public void  setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.getShinseiDetail().getKetteiJoho().setTxtKakuninNo(txtKakuninNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getShinseiDetail().getKetteiJoho().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getShinseiDetail().getKetteiJoho().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShinseiDetail().getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShinseiDetail().getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getTxtDetermineShinsei() {
        return this.getShinseiDetail().getTxtDetermineShinsei();
    }

    @JsonIgnore
    public void  setTxtDetermineShinsei(Button txtDetermineShinsei) {
        this.getShinseiDetail().setTxtDetermineShinsei(txtDetermineShinsei);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getShinseiDetail().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getShinseiDetail().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnBackToShinseiList() {
        return this.getShinseiDetail().getBtnBackToShinseiList();
    }

    @JsonIgnore
    public void  setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.getShinseiDetail().setBtnBackToShinseiList(btnBackToShinseiList);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getShinseiDetail().getCcdShinseiJoho();
    }

    // </editor-fold>
}
