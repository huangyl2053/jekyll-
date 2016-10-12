package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

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
    @JsonProperty("ddlShinseiRiyu")
    private DropDownList ddlShinseiRiyu;
    @JsonProperty("izokuNenkinJukyu")
    private CheckBoxList izokuNenkinJukyu;
    @JsonProperty("shogaiNenkinJukyu")
    private CheckBoxList shogaiNenkinJukyu;
    @JsonProperty("HaigushaJoho")
    private HaigushaJohoDiv HaigushaJoho;
    @JsonProperty("YochokinJoho")
    private YochokinJohoDiv YochokinJoho;
    @JsonProperty("radKetteiKubun")
    private RadioButton radKetteiKubun;
    @JsonProperty("txtKetteiYMD")
    private TextBoxFlexibleDate txtKetteiYMD;
    @JsonProperty("txtTekiyoYMD")
    private TextBoxFlexibleDate txtTekiyoYMD;
    @JsonProperty("txtYukoKigenYMD")
    private TextBoxFlexibleDate txtYukoKigenYMD;
    @JsonProperty("ddlKyusochisha")
    private DropDownList ddlKyusochisha;
    @JsonProperty("ddlKyoshitsuShubetsu")
    private DropDownList ddlKyoshitsuShubetsu;
    @JsonProperty("chkKyokaiso")
    private CheckBoxList chkKyokaiso;
    @JsonProperty("chkGekihenKanwa")
    private CheckBoxList chkGekihenKanwa;
    @JsonProperty("ddlRiyoshaFutanDankai")
    private DropDownList ddlRiyoshaFutanDankai;
    @JsonProperty("lblFutanGendogaku")
    private Label lblFutanGendogaku;
    @JsonProperty("FutanGendogaku")
    private FutanGendogakuDiv FutanGendogaku;
    @JsonProperty("btnHiShoninRiyu")
    private ButtonDialog btnHiShoninRiyu;
    @JsonProperty("txtHiShoninRiyu")
    private TextBoxMultiLine txtHiShoninRiyu;
    @JsonProperty("btnShoninKakutei")
    private Button btnShoninKakutei;
    @JsonProperty("btnShinseiKakutei")
    private Button btnShinseiKakutei;
    @JsonProperty("btnBackToShinseiList")
    private Button btnBackToShinseiList;
    @JsonProperty("ccdGemmenGengakuShinsei")
    private GemmenGengakuShinseiDiv ccdGemmenGengakuShinsei;

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
     * getddlShinseiRiyu
     * @return ddlShinseiRiyu
     */
    @JsonProperty("ddlShinseiRiyu")
    public DropDownList getDdlShinseiRiyu() {
        return ddlShinseiRiyu;
    }

    /*
     * setddlShinseiRiyu
     * @param ddlShinseiRiyu ddlShinseiRiyu
     */
    @JsonProperty("ddlShinseiRiyu")
    public void setDdlShinseiRiyu(DropDownList ddlShinseiRiyu) {
        this.ddlShinseiRiyu = ddlShinseiRiyu;
    }

    /*
     * getizokuNenkinJukyu
     * @return izokuNenkinJukyu
     */
    @JsonProperty("izokuNenkinJukyu")
    public CheckBoxList getIzokuNenkinJukyu() {
        return izokuNenkinJukyu;
    }

    /*
     * setizokuNenkinJukyu
     * @param izokuNenkinJukyu izokuNenkinJukyu
     */
    @JsonProperty("izokuNenkinJukyu")
    public void setIzokuNenkinJukyu(CheckBoxList izokuNenkinJukyu) {
        this.izokuNenkinJukyu = izokuNenkinJukyu;
    }

    /*
     * getshogaiNenkinJukyu
     * @return shogaiNenkinJukyu
     */
    @JsonProperty("shogaiNenkinJukyu")
    public CheckBoxList getShogaiNenkinJukyu() {
        return shogaiNenkinJukyu;
    }

    /*
     * setshogaiNenkinJukyu
     * @param shogaiNenkinJukyu shogaiNenkinJukyu
     */
    @JsonProperty("shogaiNenkinJukyu")
    public void setShogaiNenkinJukyu(CheckBoxList shogaiNenkinJukyu) {
        this.shogaiNenkinJukyu = shogaiNenkinJukyu;
    }

    /*
     * getHaigushaJoho
     * @return HaigushaJoho
     */
    @JsonProperty("HaigushaJoho")
    public HaigushaJohoDiv getHaigushaJoho() {
        return HaigushaJoho;
    }

    /*
     * setHaigushaJoho
     * @param HaigushaJoho HaigushaJoho
     */
    @JsonProperty("HaigushaJoho")
    public void setHaigushaJoho(HaigushaJohoDiv HaigushaJoho) {
        this.HaigushaJoho = HaigushaJoho;
    }

    /*
     * getYochokinJoho
     * @return YochokinJoho
     */
    @JsonProperty("YochokinJoho")
    public YochokinJohoDiv getYochokinJoho() {
        return YochokinJoho;
    }

    /*
     * setYochokinJoho
     * @param YochokinJoho YochokinJoho
     */
    @JsonProperty("YochokinJoho")
    public void setYochokinJoho(YochokinJohoDiv YochokinJoho) {
        this.YochokinJoho = YochokinJoho;
    }

    /*
     * getradKetteiKubun
     * @return radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public RadioButton getRadKetteiKubun() {
        return radKetteiKubun;
    }

    /*
     * setradKetteiKubun
     * @param radKetteiKubun radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.radKetteiKubun = radKetteiKubun;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtTekiyoYMD
     * @return txtTekiyoYMD
     */
    @JsonProperty("txtTekiyoYMD")
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return txtTekiyoYMD;
    }

    /*
     * settxtTekiyoYMD
     * @param txtTekiyoYMD txtTekiyoYMD
     */
    @JsonProperty("txtTekiyoYMD")
    public void setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.txtTekiyoYMD = txtTekiyoYMD;
    }

    /*
     * gettxtYukoKigenYMD
     * @return txtYukoKigenYMD
     */
    @JsonProperty("txtYukoKigenYMD")
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return txtYukoKigenYMD;
    }

    /*
     * settxtYukoKigenYMD
     * @param txtYukoKigenYMD txtYukoKigenYMD
     */
    @JsonProperty("txtYukoKigenYMD")
    public void setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.txtYukoKigenYMD = txtYukoKigenYMD;
    }

    /*
     * getddlKyusochisha
     * @return ddlKyusochisha
     */
    @JsonProperty("ddlKyusochisha")
    public DropDownList getDdlKyusochisha() {
        return ddlKyusochisha;
    }

    /*
     * setddlKyusochisha
     * @param ddlKyusochisha ddlKyusochisha
     */
    @JsonProperty("ddlKyusochisha")
    public void setDdlKyusochisha(DropDownList ddlKyusochisha) {
        this.ddlKyusochisha = ddlKyusochisha;
    }

    /*
     * getddlKyoshitsuShubetsu
     * @return ddlKyoshitsuShubetsu
     */
    @JsonProperty("ddlKyoshitsuShubetsu")
    public DropDownList getDdlKyoshitsuShubetsu() {
        return ddlKyoshitsuShubetsu;
    }

    /*
     * setddlKyoshitsuShubetsu
     * @param ddlKyoshitsuShubetsu ddlKyoshitsuShubetsu
     */
    @JsonProperty("ddlKyoshitsuShubetsu")
    public void setDdlKyoshitsuShubetsu(DropDownList ddlKyoshitsuShubetsu) {
        this.ddlKyoshitsuShubetsu = ddlKyoshitsuShubetsu;
    }

    /*
     * getchkKyokaiso
     * @return chkKyokaiso
     */
    @JsonProperty("chkKyokaiso")
    public CheckBoxList getChkKyokaiso() {
        return chkKyokaiso;
    }

    /*
     * setchkKyokaiso
     * @param chkKyokaiso chkKyokaiso
     */
    @JsonProperty("chkKyokaiso")
    public void setChkKyokaiso(CheckBoxList chkKyokaiso) {
        this.chkKyokaiso = chkKyokaiso;
    }

    /*
     * getchkGekihenKanwa
     * @return chkGekihenKanwa
     */
    @JsonProperty("chkGekihenKanwa")
    public CheckBoxList getChkGekihenKanwa() {
        return chkGekihenKanwa;
    }

    /*
     * setchkGekihenKanwa
     * @param chkGekihenKanwa chkGekihenKanwa
     */
    @JsonProperty("chkGekihenKanwa")
    public void setChkGekihenKanwa(CheckBoxList chkGekihenKanwa) {
        this.chkGekihenKanwa = chkGekihenKanwa;
    }

    /*
     * getddlRiyoshaFutanDankai
     * @return ddlRiyoshaFutanDankai
     */
    @JsonProperty("ddlRiyoshaFutanDankai")
    public DropDownList getDdlRiyoshaFutanDankai() {
        return ddlRiyoshaFutanDankai;
    }

    /*
     * setddlRiyoshaFutanDankai
     * @param ddlRiyoshaFutanDankai ddlRiyoshaFutanDankai
     */
    @JsonProperty("ddlRiyoshaFutanDankai")
    public void setDdlRiyoshaFutanDankai(DropDownList ddlRiyoshaFutanDankai) {
        this.ddlRiyoshaFutanDankai = ddlRiyoshaFutanDankai;
    }

    /*
     * getlblFutanGendogaku
     * @return lblFutanGendogaku
     */
    @JsonProperty("lblFutanGendogaku")
    public Label getLblFutanGendogaku() {
        return lblFutanGendogaku;
    }

    /*
     * setlblFutanGendogaku
     * @param lblFutanGendogaku lblFutanGendogaku
     */
    @JsonProperty("lblFutanGendogaku")
    public void setLblFutanGendogaku(Label lblFutanGendogaku) {
        this.lblFutanGendogaku = lblFutanGendogaku;
    }

    /*
     * getFutanGendogaku
     * @return FutanGendogaku
     */
    @JsonProperty("FutanGendogaku")
    public FutanGendogakuDiv getFutanGendogaku() {
        return FutanGendogaku;
    }

    /*
     * setFutanGendogaku
     * @param FutanGendogaku FutanGendogaku
     */
    @JsonProperty("FutanGendogaku")
    public void setFutanGendogaku(FutanGendogakuDiv FutanGendogaku) {
        this.FutanGendogaku = FutanGendogaku;
    }

    /*
     * getbtnHiShoninRiyu
     * @return btnHiShoninRiyu
     */
    @JsonProperty("btnHiShoninRiyu")
    public ButtonDialog getBtnHiShoninRiyu() {
        return btnHiShoninRiyu;
    }

    /*
     * setbtnHiShoninRiyu
     * @param btnHiShoninRiyu btnHiShoninRiyu
     */
    @JsonProperty("btnHiShoninRiyu")
    public void setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.btnHiShoninRiyu = btnHiShoninRiyu;
    }

    /*
     * gettxtHiShoninRiyu
     * @return txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return txtHiShoninRiyu;
    }

    /*
     * settxtHiShoninRiyu
     * @param txtHiShoninRiyu txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public void setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.txtHiShoninRiyu = txtHiShoninRiyu;
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
     * getccdGemmenGengakuShinsei
     * @return ccdGemmenGengakuShinsei
     */
    @JsonProperty("ccdGemmenGengakuShinsei")
    public IGemmenGengakuShinseiDiv getCcdGemmenGengakuShinsei() {
        return ccdGemmenGengakuShinsei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHaigushaUmu() {
        return this.getHaigushaJoho().getRadHaigushaUmu();
    }

    @JsonIgnore
    public void  setRadHaigushaUmu(RadioButton radHaigushaUmu) {
        this.getHaigushaJoho().setRadHaigushaUmu(radHaigushaUmu);
    }

    @JsonIgnore
    public TextBoxShikibetsuCode getTxtHaigushaShikibetsuCode() {
        return this.getHaigushaJoho().getTxtHaigushaShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtHaigushaShikibetsuCode(TextBoxShikibetsuCode txtHaigushaShikibetsuCode) {
        this.getHaigushaJoho().setTxtHaigushaShikibetsuCode(txtHaigushaShikibetsuCode);
    }

    @JsonIgnore
    public Button getBtnHaigushaJohoSet() {
        return this.getHaigushaJoho().getBtnHaigushaJohoSet();
    }

    @JsonIgnore
    public void  setBtnHaigushaJohoSet(Button btnHaigushaJohoSet) {
        this.getHaigushaJoho().setBtnHaigushaJohoSet(btnHaigushaJohoSet);
    }

    @JsonIgnore
    public Button getBtnHaigushaClear() {
        return this.getHaigushaJoho().getBtnHaigushaClear();
    }

    @JsonIgnore
    public void  setBtnHaigushaClear(Button btnHaigushaClear) {
        this.getHaigushaJoho().setBtnHaigushaClear(btnHaigushaClear);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtHaigushaShimeiKana() {
        return this.getHaigushaJoho().getTxtHaigushaShimeiKana();
    }

    @JsonIgnore
    public void  setTxtHaigushaShimeiKana(TextBoxAtenaKanaMeisho txtHaigushaShimeiKana) {
        this.getHaigushaJoho().setTxtHaigushaShimeiKana(txtHaigushaShimeiKana);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtHaigushaShimei() {
        return this.getHaigushaJoho().getTxtHaigushaShimei();
    }

    @JsonIgnore
    public void  setTxtHaigushaShimei(TextBoxAtenaMeisho txtHaigushaShimei) {
        this.getHaigushaJoho().setTxtHaigushaShimei(txtHaigushaShimei);
    }

    @JsonIgnore
    public TextBoxDate getTxtHaigushaUmareYMD() {
        return this.getHaigushaJoho().getTxtHaigushaUmareYMD();
    }

    @JsonIgnore
    public void  setTxtHaigushaUmareYMD(TextBoxDate txtHaigushaUmareYMD) {
        this.getHaigushaJoho().setTxtHaigushaUmareYMD(txtHaigushaUmareYMD);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtHaigushaRenrakusaki() {
        return this.getHaigushaJoho().getTxtHaigushaRenrakusaki();
    }

    @JsonIgnore
    public void  setTxtHaigushaRenrakusaki(TextBoxTelNo txtHaigushaRenrakusaki) {
        this.getHaigushaJoho().setTxtHaigushaRenrakusaki(txtHaigushaRenrakusaki);
    }

    @JsonIgnore
    public TextBoxJusho getTxtHaigushaJusho1() {
        return this.getHaigushaJoho().getTxtHaigushaJusho1();
    }

    @JsonIgnore
    public void  setTxtHaigushaJusho1(TextBoxJusho txtHaigushaJusho1) {
        this.getHaigushaJoho().setTxtHaigushaJusho1(txtHaigushaJusho1);
    }

    @JsonIgnore
    public Label getLblJushoJan1st() {
        return this.getHaigushaJoho().getLblJushoJan1st();
    }

    @JsonIgnore
    public void  setLblJushoJan1st(Label lblJushoJan1st) {
        this.getHaigushaJoho().setLblJushoJan1st(lblJushoJan1st);
    }

    @JsonIgnore
    public TextBoxJusho getTxtHaigushaJusho2() {
        return this.getHaigushaJoho().getTxtHaigushaJusho2();
    }

    @JsonIgnore
    public void  setTxtHaigushaJusho2(TextBoxJusho txtHaigushaJusho2) {
        this.getHaigushaJoho().setTxtHaigushaJusho2(txtHaigushaJusho2);
    }

    @JsonIgnore
    public RadioButton getRadHaigushaKazeiKubun() {
        return this.getHaigushaJoho().getRadHaigushaKazeiKubun();
    }

    @JsonIgnore
    public void  setRadHaigushaKazeiKubun(RadioButton radHaigushaKazeiKubun) {
        this.getHaigushaJoho().setRadHaigushaKazeiKubun(radHaigushaKazeiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkYochokinKijunIka() {
        return this.getYochokinJoho().getChkYochokinKijunIka();
    }

    @JsonIgnore
    public void  setChkYochokinKijunIka(CheckBoxList chkYochokinKijunIka) {
        this.getYochokinJoho().setChkYochokinKijunIka(chkYochokinKijunIka);
    }

    @JsonIgnore
    public TextBoxNum getTxtYochokinGaku() {
        return this.getYochokinJoho().getTxtYochokinGaku();
    }

    @JsonIgnore
    public void  setTxtYochokinGaku(TextBoxNum txtYochokinGaku) {
        this.getYochokinJoho().setTxtYochokinGaku(txtYochokinGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtYukaShoken() {
        return this.getYochokinJoho().getTxtYukaShoken();
    }

    @JsonIgnore
    public void  setTxtYukaShoken(TextBoxNum txtYukaShoken) {
        this.getYochokinJoho().setTxtYukaShoken(txtYukaShoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonota() {
        return this.getYochokinJoho().getTxtSonota();
    }

    @JsonIgnore
    public void  setTxtSonota(TextBoxNum txtSonota) {
        this.getYochokinJoho().setTxtSonota(txtSonota);
    }

    @JsonIgnore
    public DropDownList getDdlShokuhi() {
        return this.getFutanGendogaku().getDdlShokuhi();
    }

    @JsonIgnore
    public void  setDdlShokuhi(DropDownList ddlShokuhi) {
        this.getFutanGendogaku().setDdlShokuhi(ddlShokuhi);
    }

    @JsonIgnore
    public DropDownList getDdlUnitGataKoshitsu() {
        return this.getFutanGendogaku().getDdlUnitGataKoshitsu();
    }

    @JsonIgnore
    public void  setDdlUnitGataKoshitsu(DropDownList ddlUnitGataKoshitsu) {
        this.getFutanGendogaku().setDdlUnitGataKoshitsu(ddlUnitGataKoshitsu);
    }

    @JsonIgnore
    public DropDownList getDdlUnitGataJunKoshitsu() {
        return this.getFutanGendogaku().getDdlUnitGataJunKoshitsu();
    }

    @JsonIgnore
    public void  setDdlUnitGataJunKoshitsu(DropDownList ddlUnitGataJunKoshitsu) {
        this.getFutanGendogaku().setDdlUnitGataJunKoshitsu(ddlUnitGataJunKoshitsu);
    }

    @JsonIgnore
    public DropDownList getDdlJuraiGataKoshitsuTokuyo() {
        return this.getFutanGendogaku().getDdlJuraiGataKoshitsuTokuyo();
    }

    @JsonIgnore
    public void  setDdlJuraiGataKoshitsuTokuyo(DropDownList ddlJuraiGataKoshitsuTokuyo) {
        this.getFutanGendogaku().setDdlJuraiGataKoshitsuTokuyo(ddlJuraiGataKoshitsuTokuyo);
    }

    @JsonIgnore
    public DropDownList getDdlJuraiGataKoshitsuRoken() {
        return this.getFutanGendogaku().getDdlJuraiGataKoshitsuRoken();
    }

    @JsonIgnore
    public void  setDdlJuraiGataKoshitsuRoken(DropDownList ddlJuraiGataKoshitsuRoken) {
        this.getFutanGendogaku().setDdlJuraiGataKoshitsuRoken(ddlJuraiGataKoshitsuRoken);
    }

    @JsonIgnore
    public DropDownList getDdlTashoshitsu() {
        return this.getFutanGendogaku().getDdlTashoshitsu();
    }

    @JsonIgnore
    public void  setDdlTashoshitsu(DropDownList ddlTashoshitsu) {
        this.getFutanGendogaku().setDdlTashoshitsu(ddlTashoshitsu);
    }

    // </editor-fold>
}
