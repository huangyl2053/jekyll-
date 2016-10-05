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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShafukuRiyoshaKeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShafukuRiyoshaKeigenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtSetaiKazeiJokyo")
    private TextBox txtSetaiKazeiJokyo;
    @JsonProperty("btnShowSetaiJoho")
    private Button btnShowSetaiJoho;
    @JsonProperty("btnCloseSetaiJoho")
    private Button btnCloseSetaiJoho;
    @JsonProperty("btnShowGenmenJoho")
    private ButtonDialog btnShowGenmenJoho;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
    @JsonProperty("ShinseiList")
    private ShinseiListDiv ShinseiList;
    @JsonProperty("ShinseiDetail")
    private ShinseiDetailDiv ShinseiDetail;
    @JsonProperty("ccdShikakuKihon")
    private KaigoShikakuKihonDiv ccdShikakuKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("GyomuCode")
    private RString GyomuCode;
    @JsonProperty("sampleBunshoGroupCode")
    private RString sampleBunshoGroupCode;

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
     * gettxtSetaiKazeiJokyo
     * @return txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public TextBox getTxtSetaiKazeiJokyo() {
        return txtSetaiKazeiJokyo;
    }

    /*
     * settxtSetaiKazeiJokyo
     * @param txtSetaiKazeiJokyo txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public void setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.txtSetaiKazeiJokyo = txtSetaiKazeiJokyo;
    }

    /*
     * getbtnShowSetaiJoho
     * @return btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public Button getBtnShowSetaiJoho() {
        return btnShowSetaiJoho;
    }

    /*
     * setbtnShowSetaiJoho
     * @param btnShowSetaiJoho btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public void setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.btnShowSetaiJoho = btnShowSetaiJoho;
    }

    /*
     * getbtnCloseSetaiJoho
     * @return btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public Button getBtnCloseSetaiJoho() {
        return btnCloseSetaiJoho;
    }

    /*
     * setbtnCloseSetaiJoho
     * @param btnCloseSetaiJoho btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public void setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.btnCloseSetaiJoho = btnCloseSetaiJoho;
    }

    /*
     * getbtnShowGenmenJoho
     * @return btnShowGenmenJoho
     */
    @JsonProperty("btnShowGenmenJoho")
    public ButtonDialog getBtnShowGenmenJoho() {
        return btnShowGenmenJoho;
    }

    /*
     * setbtnShowGenmenJoho
     * @param btnShowGenmenJoho btnShowGenmenJoho
     */
    @JsonProperty("btnShowGenmenJoho")
    public void setBtnShowGenmenJoho(ButtonDialog btnShowGenmenJoho) {
        this.btnShowGenmenJoho = btnShowGenmenJoho;
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
     * getccdShikakuKihon
     * @return ccdShikakuKihon
     */
    @JsonProperty("ccdShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return ccdShikakuKihon;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
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
     * [ ショートカットの作成 ]
     */
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
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public ShoninJohoDiv getShoninJoho() {
        return this.getShinseiDetail().getShoninJoho();
    }

    @JsonIgnore
    public void  setShoninJoho(ShoninJohoDiv ShoninJoho) {
        this.getShinseiDetail().setShoninJoho(ShoninJoho);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getShinseiDetail().getShoninJoho().getRadKetteiKubun();
    }

    @JsonIgnore
    public void  setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getShinseiDetail().getShoninJoho().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getShinseiDetail().getShoninJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getShinseiDetail().getShoninJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getShinseiDetail().getShoninJoho().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void  setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getShinseiDetail().getShoninJoho().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getShinseiDetail().getShoninJoho().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getShinseiDetail().getShoninJoho().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkTokureiTaisho() {
        return this.getShinseiDetail().getShoninJoho().getChkTokureiTaisho();
    }

    @JsonIgnore
    public void  setChkTokureiTaisho(CheckBoxList chkTokureiTaisho) {
        this.getShinseiDetail().getShoninJoho().setChkTokureiTaisho(chkTokureiTaisho);
    }

    @JsonIgnore
    public DropDownList getDdlKeigenJiyu() {
        return this.getShinseiDetail().getShoninJoho().getDdlKeigenJiyu();
    }

    @JsonIgnore
    public void  setDdlKeigenJiyu(DropDownList ddlKeigenJiyu) {
        this.getShinseiDetail().getShoninJoho().setDdlKeigenJiyu(ddlKeigenJiyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsuBunshi() {
        return this.getShinseiDetail().getShoninJoho().getTxtKeigenRitsuBunshi();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsuBunshi(TextBoxNum txtKeigenRitsuBunshi) {
        this.getShinseiDetail().getShoninJoho().setTxtKeigenRitsuBunshi(txtKeigenRitsuBunshi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsuBunbo() {
        return this.getShinseiDetail().getShoninJoho().getTxtKeigenRitsuBunbo();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsuBunbo(TextBoxNum txtKeigenRitsuBunbo) {
        this.getShinseiDetail().getShoninJoho().setTxtKeigenRitsuBunbo(txtKeigenRitsuBunbo);
    }

    @JsonIgnore
    public CheckBoxList getChkKyotakuServiceGentei() {
        return this.getShinseiDetail().getShoninJoho().getChkKyotakuServiceGentei();
    }

    @JsonIgnore
    public void  setChkKyotakuServiceGentei(CheckBoxList chkKyotakuServiceGentei) {
        this.getShinseiDetail().getShoninJoho().setChkKyotakuServiceGentei(chkKyotakuServiceGentei);
    }

    @JsonIgnore
    public CheckBoxList getChkKyojuhiShokuhiGentei() {
        return this.getShinseiDetail().getShoninJoho().getChkKyojuhiShokuhiGentei();
    }

    @JsonIgnore
    public void  setChkKyojuhiShokuhiGentei(CheckBoxList chkKyojuhiShokuhiGentei) {
        this.getShinseiDetail().getShoninJoho().setChkKyojuhiShokuhiGentei(chkKyojuhiShokuhiGentei);
    }

    @JsonIgnore
    public CheckBoxList getChkKyusochiUnitGataJunKoshitsu() {
        return this.getShinseiDetail().getShoninJoho().getChkKyusochiUnitGataJunKoshitsu();
    }

    @JsonIgnore
    public void  setChkKyusochiUnitGataJunKoshitsu(CheckBoxList chkKyusochiUnitGataJunKoshitsu) {
        this.getShinseiDetail().getShoninJoho().setChkKyusochiUnitGataJunKoshitsu(chkKyusochiUnitGataJunKoshitsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKakuninNo() {
        return this.getShinseiDetail().getShoninJoho().getTxtKakuninNo();
    }

    @JsonIgnore
    public void  setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.getShinseiDetail().getShoninJoho().setTxtKakuninNo(txtKakuninNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnSelectHiShoninRiyu() {
        return this.getShinseiDetail().getShoninJoho().getBtnSelectHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnSelectHiShoninRiyu(ButtonDialog btnSelectHiShoninRiyu) {
        this.getShinseiDetail().getShoninJoho().setBtnSelectHiShoninRiyu(btnSelectHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShinseiDetail().getShoninJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShinseiDetail().getShoninJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
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
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getShinseiDetail().getCcdShinseiJoho();
    }

    // </editor-fold>
}
