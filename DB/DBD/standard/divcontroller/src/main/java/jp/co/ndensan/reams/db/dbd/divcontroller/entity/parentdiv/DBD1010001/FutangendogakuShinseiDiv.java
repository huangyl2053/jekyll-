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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.IShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.ShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FutangendogakuShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutangendogakuShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Header")
    private HeaderDiv Header;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
    @JsonProperty("ShinseiList")
    private ShinseiListDiv ShinseiList;
    @JsonProperty("ShinseiDetail")
    private ShinseiDetailDiv ShinseiDetail;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("GyomuCode")
    private RString GyomuCode;
    @JsonProperty("sampleBunshoGroupCode")
    private RString sampleBunshoGroupCode;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("lockKey")
    private RString lockKey;
    @JsonProperty("jotai")
    private RString jotai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeader
     * @return Header
     */
    @JsonProperty("Header")
    public HeaderDiv getHeader() {
        return Header;
    }

    /*
     * setHeader
     * @param Header Header
     */
    @JsonProperty("Header")
    public void setHeader(HeaderDiv Header) {
        this.Header = Header;
    }

    /*
     * getSetaiJoho
     * @return SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public SetaiJohoDiv getSetaiJoho() {
        return SetaiJoho;
    }

    /*
     * setSetaiJoho
     * @param SetaiJoho SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public void setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.SetaiJoho = SetaiJoho;
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
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getGyomuCode
     * @return GyomuCode
     */
    @JsonProperty("GyomuCode")
    public RString getGyomuCode() {
        return GyomuCode;
    }

    /*
     * setGyomuCode
     * @param GyomuCode GyomuCode
     */
    @JsonProperty("GyomuCode")
    public void setGyomuCode(RString GyomuCode) {
        this.GyomuCode = GyomuCode;
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
     * getlockKey
     * @return lockKey
     */
    @JsonProperty("lockKey")
    public RString getLockKey() {
        return lockKey;
    }

    /*
     * setlockKey
     * @param lockKey lockKey
     */
    @JsonProperty("lockKey")
    public void setLockKey(RString lockKey) {
        this.lockKey = lockKey;
    }

    /*
     * getjotai
     * @return jotai
     */
    @JsonProperty("jotai")
    public RString getJotai() {
        return jotai;
    }

    /*
     * setjotai
     * @param jotai jotai
     */
    @JsonProperty("jotai")
    public void setJotai(RString jotai) {
        this.jotai = jotai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getHeader().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getHeader().setLin1(lin1);
    }

    @JsonIgnore
    public HosokuJohoDiv getHosokuJoho() {
        return this.getHeader().getHosokuJoho();
    }

    @JsonIgnore
    public void  setHosokuJoho(HosokuJohoDiv HosokuJoho) {
        this.getHeader().setHosokuJoho(HosokuJoho);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanDankai() {
        return this.getHeader().getHosokuJoho().getTxtRiyoshaFutanDankai();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanDankai(TextBox txtRiyoshaFutanDankai) {
        this.getHeader().getHosokuJoho().setTxtRiyoshaFutanDankai(txtRiyoshaFutanDankai);
    }

    @JsonIgnore
    public Button getBtnDispSetaiJoho() {
        return this.getHeader().getHosokuJoho().getBtnDispSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnDispSetaiJoho(Button btnDispSetaiJoho) {
        this.getHeader().getHosokuJoho().setBtnDispSetaiJoho(btnDispSetaiJoho);
    }

    @JsonIgnore
    public Button getBtnCloseSetaiJoho() {
        return this.getHeader().getHosokuJoho().getBtnCloseSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.getHeader().getHosokuJoho().setBtnCloseSetaiJoho(btnCloseSetaiJoho);
    }

    @JsonIgnore
    public DialogsDiv getDialogs() {
        return this.getHeader().getDialogs();
    }

    @JsonIgnore
    public void  setDialogs(DialogsDiv Dialogs) {
        this.getHeader().setDialogs(Dialogs);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispShisetsuJoho() {
        return this.getHeader().getDialogs().getBtnDispShisetsuJoho();
    }

    @JsonIgnore
    public void  setBtnDispShisetsuJoho(ButtonDialog btnDispShisetsuJoho) {
        this.getHeader().getDialogs().setBtnDispShisetsuJoho(btnDispShisetsuJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispGemmenJoho() {
        return this.getHeader().getDialogs().getBtnDispGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.getHeader().getDialogs().setBtnDispGemmenJoho(btnDispGemmenJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnHikazeiNenkinSho() {
        return this.getHeader().getDialogs().getBtnHikazeiNenkinSho();
    }

    @JsonIgnore
    public void  setBtnHikazeiNenkinSho(ButtonDialog btnHikazeiNenkinSho) {
        this.getHeader().getDialogs().setBtnHikazeiNenkinSho(btnHikazeiNenkinSho);
    }

    @JsonIgnore
    public IShisetSunyushoInfoDiv getCcdShisetsuNyushoInfo() {
        return this.getHeader().getCcdShisetsuNyushoInfo();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getHeader().getCcdAtenaInfo();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getHeader().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

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
    public DropDownList getDdlShinseiRiyu() {
        return this.getShinseiDetail().getDdlShinseiRiyu();
    }

    @JsonIgnore
    public void  setDdlShinseiRiyu(DropDownList ddlShinseiRiyu) {
        this.getShinseiDetail().setDdlShinseiRiyu(ddlShinseiRiyu);
    }

    @JsonIgnore
    public CheckBoxList getIzokuNenkinJukyu() {
        return this.getShinseiDetail().getIzokuNenkinJukyu();
    }

    @JsonIgnore
    public void  setIzokuNenkinJukyu(CheckBoxList izokuNenkinJukyu) {
        this.getShinseiDetail().setIzokuNenkinJukyu(izokuNenkinJukyu);
    }

    @JsonIgnore
    public CheckBoxList getShogaiNenkinJukyu() {
        return this.getShinseiDetail().getShogaiNenkinJukyu();
    }

    @JsonIgnore
    public void  setShogaiNenkinJukyu(CheckBoxList shogaiNenkinJukyu) {
        this.getShinseiDetail().setShogaiNenkinJukyu(shogaiNenkinJukyu);
    }

    @JsonIgnore
    public HaigushaJohoDiv getHaigushaJoho() {
        return this.getShinseiDetail().getHaigushaJoho();
    }

    @JsonIgnore
    public void  setHaigushaJoho(HaigushaJohoDiv HaigushaJoho) {
        this.getShinseiDetail().setHaigushaJoho(HaigushaJoho);
    }

    @JsonIgnore
    public RadioButton getRadHaigushaUmu() {
        return this.getShinseiDetail().getHaigushaJoho().getRadHaigushaUmu();
    }

    @JsonIgnore
    public void  setRadHaigushaUmu(RadioButton radHaigushaUmu) {
        this.getShinseiDetail().getHaigushaJoho().setRadHaigushaUmu(radHaigushaUmu);
    }

    @JsonIgnore
    public TextBoxShikibetsuCode getTxtHaigushaShikibetsuCode() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtHaigushaShikibetsuCode(TextBoxShikibetsuCode txtHaigushaShikibetsuCode) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaShikibetsuCode(txtHaigushaShikibetsuCode);
    }

    @JsonIgnore
    public Button getBtnHaigushaJohoSet() {
        return this.getShinseiDetail().getHaigushaJoho().getBtnHaigushaJohoSet();
    }

    @JsonIgnore
    public void  setBtnHaigushaJohoSet(Button btnHaigushaJohoSet) {
        this.getShinseiDetail().getHaigushaJoho().setBtnHaigushaJohoSet(btnHaigushaJohoSet);
    }

    @JsonIgnore
    public Button getBtnHaigushaClear() {
        return this.getShinseiDetail().getHaigushaJoho().getBtnHaigushaClear();
    }

    @JsonIgnore
    public void  setBtnHaigushaClear(Button btnHaigushaClear) {
        this.getShinseiDetail().getHaigushaJoho().setBtnHaigushaClear(btnHaigushaClear);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtHaigushaShimeiKana() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaShimeiKana();
    }

    @JsonIgnore
    public void  setTxtHaigushaShimeiKana(TextBoxAtenaKanaMeisho txtHaigushaShimeiKana) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaShimeiKana(txtHaigushaShimeiKana);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtHaigushaShimei() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaShimei();
    }

    @JsonIgnore
    public void  setTxtHaigushaShimei(TextBoxAtenaMeisho txtHaigushaShimei) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaShimei(txtHaigushaShimei);
    }

    @JsonIgnore
    public TextBoxDate getTxtHaigushaUmareYMD() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaUmareYMD();
    }

    @JsonIgnore
    public void  setTxtHaigushaUmareYMD(TextBoxDate txtHaigushaUmareYMD) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaUmareYMD(txtHaigushaUmareYMD);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtHaigushaRenrakusaki() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaRenrakusaki();
    }

    @JsonIgnore
    public void  setTxtHaigushaRenrakusaki(TextBoxTelNo txtHaigushaRenrakusaki) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaRenrakusaki(txtHaigushaRenrakusaki);
    }

    @JsonIgnore
    public TextBoxJusho getTxtHaigushaJusho1() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaJusho1();
    }

    @JsonIgnore
    public void  setTxtHaigushaJusho1(TextBoxJusho txtHaigushaJusho1) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaJusho1(txtHaigushaJusho1);
    }

    @JsonIgnore
    public Label getLblJushoJan1st() {
        return this.getShinseiDetail().getHaigushaJoho().getLblJushoJan1st();
    }

    @JsonIgnore
    public void  setLblJushoJan1st(Label lblJushoJan1st) {
        this.getShinseiDetail().getHaigushaJoho().setLblJushoJan1st(lblJushoJan1st);
    }

    @JsonIgnore
    public TextBoxJusho getTxtHaigushaJusho2() {
        return this.getShinseiDetail().getHaigushaJoho().getTxtHaigushaJusho2();
    }

    @JsonIgnore
    public void  setTxtHaigushaJusho2(TextBoxJusho txtHaigushaJusho2) {
        this.getShinseiDetail().getHaigushaJoho().setTxtHaigushaJusho2(txtHaigushaJusho2);
    }

    @JsonIgnore
    public RadioButton getRadHaigushaKazeiKubun() {
        return this.getShinseiDetail().getHaigushaJoho().getRadHaigushaKazeiKubun();
    }

    @JsonIgnore
    public void  setRadHaigushaKazeiKubun(RadioButton radHaigushaKazeiKubun) {
        this.getShinseiDetail().getHaigushaJoho().setRadHaigushaKazeiKubun(radHaigushaKazeiKubun);
    }

    @JsonIgnore
    public YochokinJohoDiv getYochokinJoho() {
        return this.getShinseiDetail().getYochokinJoho();
    }

    @JsonIgnore
    public void  setYochokinJoho(YochokinJohoDiv YochokinJoho) {
        this.getShinseiDetail().setYochokinJoho(YochokinJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkYochokinKijunIka() {
        return this.getShinseiDetail().getYochokinJoho().getChkYochokinKijunIka();
    }

    @JsonIgnore
    public void  setChkYochokinKijunIka(CheckBoxList chkYochokinKijunIka) {
        this.getShinseiDetail().getYochokinJoho().setChkYochokinKijunIka(chkYochokinKijunIka);
    }

    @JsonIgnore
    public TextBoxNum getTxtYochokinGaku() {
        return this.getShinseiDetail().getYochokinJoho().getTxtYochokinGaku();
    }

    @JsonIgnore
    public void  setTxtYochokinGaku(TextBoxNum txtYochokinGaku) {
        this.getShinseiDetail().getYochokinJoho().setTxtYochokinGaku(txtYochokinGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtYukaShoken() {
        return this.getShinseiDetail().getYochokinJoho().getTxtYukaShoken();
    }

    @JsonIgnore
    public void  setTxtYukaShoken(TextBoxNum txtYukaShoken) {
        this.getShinseiDetail().getYochokinJoho().setTxtYukaShoken(txtYukaShoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtSonota() {
        return this.getShinseiDetail().getYochokinJoho().getTxtSonota();
    }

    @JsonIgnore
    public void  setTxtSonota(TextBoxNum txtSonota) {
        this.getShinseiDetail().getYochokinJoho().setTxtSonota(txtSonota);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getShinseiDetail().getRadKetteiKubun();
    }

    @JsonIgnore
    public void  setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getShinseiDetail().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getShinseiDetail().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getShinseiDetail().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getShinseiDetail().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void  setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getShinseiDetail().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getShinseiDetail().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getShinseiDetail().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public DropDownList getDdlKyusochisha() {
        return this.getShinseiDetail().getDdlKyusochisha();
    }

    @JsonIgnore
    public void  setDdlKyusochisha(DropDownList ddlKyusochisha) {
        this.getShinseiDetail().setDdlKyusochisha(ddlKyusochisha);
    }

    @JsonIgnore
    public DropDownList getDdlKyoshitsuShubetsu() {
        return this.getShinseiDetail().getDdlKyoshitsuShubetsu();
    }

    @JsonIgnore
    public void  setDdlKyoshitsuShubetsu(DropDownList ddlKyoshitsuShubetsu) {
        this.getShinseiDetail().setDdlKyoshitsuShubetsu(ddlKyoshitsuShubetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkKyokaiso() {
        return this.getShinseiDetail().getChkKyokaiso();
    }

    @JsonIgnore
    public void  setChkKyokaiso(CheckBoxList chkKyokaiso) {
        this.getShinseiDetail().setChkKyokaiso(chkKyokaiso);
    }

    @JsonIgnore
    public CheckBoxList getChkGekihenKanwa() {
        return this.getShinseiDetail().getChkGekihenKanwa();
    }

    @JsonIgnore
    public void  setChkGekihenKanwa(CheckBoxList chkGekihenKanwa) {
        this.getShinseiDetail().setChkGekihenKanwa(chkGekihenKanwa);
    }

    @JsonIgnore
    public DropDownList getDdlRiyoshaFutanDankai() {
        return this.getShinseiDetail().getDdlRiyoshaFutanDankai();
    }

    @JsonIgnore
    public void  setDdlRiyoshaFutanDankai(DropDownList ddlRiyoshaFutanDankai) {
        this.getShinseiDetail().setDdlRiyoshaFutanDankai(ddlRiyoshaFutanDankai);
    }

    @JsonIgnore
    public Label getLblFutanGendogaku() {
        return this.getShinseiDetail().getLblFutanGendogaku();
    }

    @JsonIgnore
    public void  setLblFutanGendogaku(Label lblFutanGendogaku) {
        this.getShinseiDetail().setLblFutanGendogaku(lblFutanGendogaku);
    }

    @JsonIgnore
    public FutanGendogakuDiv getFutanGendogaku() {
        return this.getShinseiDetail().getFutanGendogaku();
    }

    @JsonIgnore
    public void  setFutanGendogaku(FutanGendogakuDiv FutanGendogaku) {
        this.getShinseiDetail().setFutanGendogaku(FutanGendogaku);
    }

    @JsonIgnore
    public DropDownList getDdlShokuhi() {
        return this.getShinseiDetail().getFutanGendogaku().getDdlShokuhi();
    }

    @JsonIgnore
    public void  setDdlShokuhi(DropDownList ddlShokuhi) {
        this.getShinseiDetail().getFutanGendogaku().setDdlShokuhi(ddlShokuhi);
    }

    @JsonIgnore
    public DropDownList getDdlUnitGataKoshitsu() {
        return this.getShinseiDetail().getFutanGendogaku().getDdlUnitGataKoshitsu();
    }

    @JsonIgnore
    public void  setDdlUnitGataKoshitsu(DropDownList ddlUnitGataKoshitsu) {
        this.getShinseiDetail().getFutanGendogaku().setDdlUnitGataKoshitsu(ddlUnitGataKoshitsu);
    }

    @JsonIgnore
    public DropDownList getDdlUnitGataJunKoshitsu() {
        return this.getShinseiDetail().getFutanGendogaku().getDdlUnitGataJunKoshitsu();
    }

    @JsonIgnore
    public void  setDdlUnitGataJunKoshitsu(DropDownList ddlUnitGataJunKoshitsu) {
        this.getShinseiDetail().getFutanGendogaku().setDdlUnitGataJunKoshitsu(ddlUnitGataJunKoshitsu);
    }

    @JsonIgnore
    public DropDownList getDdlJuraiGataKoshitsuTokuyo() {
        return this.getShinseiDetail().getFutanGendogaku().getDdlJuraiGataKoshitsuTokuyo();
    }

    @JsonIgnore
    public void  setDdlJuraiGataKoshitsuTokuyo(DropDownList ddlJuraiGataKoshitsuTokuyo) {
        this.getShinseiDetail().getFutanGendogaku().setDdlJuraiGataKoshitsuTokuyo(ddlJuraiGataKoshitsuTokuyo);
    }

    @JsonIgnore
    public DropDownList getDdlJuraiGataKoshitsuRoken() {
        return this.getShinseiDetail().getFutanGendogaku().getDdlJuraiGataKoshitsuRoken();
    }

    @JsonIgnore
    public void  setDdlJuraiGataKoshitsuRoken(DropDownList ddlJuraiGataKoshitsuRoken) {
        this.getShinseiDetail().getFutanGendogaku().setDdlJuraiGataKoshitsuRoken(ddlJuraiGataKoshitsuRoken);
    }

    @JsonIgnore
    public DropDownList getDdlTashoshitsu() {
        return this.getShinseiDetail().getFutanGendogaku().getDdlTashoshitsu();
    }

    @JsonIgnore
    public void  setDdlTashoshitsu(DropDownList ddlTashoshitsu) {
        this.getShinseiDetail().getFutanGendogaku().setDdlTashoshitsu(ddlTashoshitsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getShinseiDetail().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getShinseiDetail().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShinseiDetail().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShinseiDetail().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getBtnShoninKakutei() {
        return this.getShinseiDetail().getBtnShoninKakutei();
    }

    @JsonIgnore
    public void  setBtnShoninKakutei(Button btnShoninKakutei) {
        this.getShinseiDetail().setBtnShoninKakutei(btnShoninKakutei);
    }

    @JsonIgnore
    public Button getBtnShinseiKakutei() {
        return this.getShinseiDetail().getBtnShinseiKakutei();
    }

    @JsonIgnore
    public void  setBtnShinseiKakutei(Button btnShinseiKakutei) {
        this.getShinseiDetail().setBtnShinseiKakutei(btnShinseiKakutei);
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
    public IGemmenGengakuShinseiDiv getCcdGemmenGengakuShinsei() {
        return this.getShinseiDetail().getCcdGemmenGengakuShinsei();
    }

    // </editor-fold>
}
