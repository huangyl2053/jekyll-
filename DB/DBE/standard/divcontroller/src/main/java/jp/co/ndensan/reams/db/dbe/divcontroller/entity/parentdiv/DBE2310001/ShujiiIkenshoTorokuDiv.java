package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * ShujiiIkenshoToroku のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiIkenshoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTokkiJikoGuide")
    private ButtonDialog btnTokkiJikoGuide;
    @JsonProperty("btnSeikatsuKinoServiceGuide")
    private ButtonDialog btnSeikatsuKinoServiceGuide;
    @JsonProperty("btnShinshinJotaiGuide")
    private ButtonDialog btnShinshinJotaiGuide;
    @JsonProperty("btnTokubetsuIryoGuide")
    private ButtonDialog btnTokubetsuIryoGuide;
    @JsonProperty("btnShobyoGuide")
    private ButtonDialog btnShobyoGuide;
    @JsonProperty("IkenshoKihonJoho")
    private IkenshoKihonJohoDiv IkenshoKihonJoho;
    @JsonProperty("GaibuSoft")
    private GaibuSoftDiv GaibuSoft;
    @JsonProperty("IkenshoMemo")
    private IkenshoMemoDiv IkenshoMemo;
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("hdnHasChanged")
    private RString hdnHasChanged;
    @JsonProperty("hdnSampleText")
    private RString hdnSampleText;
    @JsonProperty("hdnSubGyomuCd")
    private RString hdnSubGyomuCd;
    @JsonProperty("hdnGroupCd")
    private RString hdnGroupCd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTokkiJikoGuide
     * @return btnTokkiJikoGuide
     */
    @JsonProperty("btnTokkiJikoGuide")
    public ButtonDialog getBtnTokkiJikoGuide() {
        return btnTokkiJikoGuide;
    }

    /*
     * setbtnTokkiJikoGuide
     * @param btnTokkiJikoGuide btnTokkiJikoGuide
     */
    @JsonProperty("btnTokkiJikoGuide")
    public void setBtnTokkiJikoGuide(ButtonDialog btnTokkiJikoGuide) {
        this.btnTokkiJikoGuide = btnTokkiJikoGuide;
    }

    /*
     * getbtnSeikatsuKinoServiceGuide
     * @return btnSeikatsuKinoServiceGuide
     */
    @JsonProperty("btnSeikatsuKinoServiceGuide")
    public ButtonDialog getBtnSeikatsuKinoServiceGuide() {
        return btnSeikatsuKinoServiceGuide;
    }

    /*
     * setbtnSeikatsuKinoServiceGuide
     * @param btnSeikatsuKinoServiceGuide btnSeikatsuKinoServiceGuide
     */
    @JsonProperty("btnSeikatsuKinoServiceGuide")
    public void setBtnSeikatsuKinoServiceGuide(ButtonDialog btnSeikatsuKinoServiceGuide) {
        this.btnSeikatsuKinoServiceGuide = btnSeikatsuKinoServiceGuide;
    }

    /*
     * getbtnShinshinJotaiGuide
     * @return btnShinshinJotaiGuide
     */
    @JsonProperty("btnShinshinJotaiGuide")
    public ButtonDialog getBtnShinshinJotaiGuide() {
        return btnShinshinJotaiGuide;
    }

    /*
     * setbtnShinshinJotaiGuide
     * @param btnShinshinJotaiGuide btnShinshinJotaiGuide
     */
    @JsonProperty("btnShinshinJotaiGuide")
    public void setBtnShinshinJotaiGuide(ButtonDialog btnShinshinJotaiGuide) {
        this.btnShinshinJotaiGuide = btnShinshinJotaiGuide;
    }

    /*
     * getbtnTokubetsuIryoGuide
     * @return btnTokubetsuIryoGuide
     */
    @JsonProperty("btnTokubetsuIryoGuide")
    public ButtonDialog getBtnTokubetsuIryoGuide() {
        return btnTokubetsuIryoGuide;
    }

    /*
     * setbtnTokubetsuIryoGuide
     * @param btnTokubetsuIryoGuide btnTokubetsuIryoGuide
     */
    @JsonProperty("btnTokubetsuIryoGuide")
    public void setBtnTokubetsuIryoGuide(ButtonDialog btnTokubetsuIryoGuide) {
        this.btnTokubetsuIryoGuide = btnTokubetsuIryoGuide;
    }

    /*
     * getbtnShobyoGuide
     * @return btnShobyoGuide
     */
    @JsonProperty("btnShobyoGuide")
    public ButtonDialog getBtnShobyoGuide() {
        return btnShobyoGuide;
    }

    /*
     * setbtnShobyoGuide
     * @param btnShobyoGuide btnShobyoGuide
     */
    @JsonProperty("btnShobyoGuide")
    public void setBtnShobyoGuide(ButtonDialog btnShobyoGuide) {
        this.btnShobyoGuide = btnShobyoGuide;
    }

    /*
     * getIkenshoKihonJoho
     * @return IkenshoKihonJoho
     */
    @JsonProperty("IkenshoKihonJoho")
    public IkenshoKihonJohoDiv getIkenshoKihonJoho() {
        return IkenshoKihonJoho;
    }

    /*
     * setIkenshoKihonJoho
     * @param IkenshoKihonJoho IkenshoKihonJoho
     */
    @JsonProperty("IkenshoKihonJoho")
    public void setIkenshoKihonJoho(IkenshoKihonJohoDiv IkenshoKihonJoho) {
        this.IkenshoKihonJoho = IkenshoKihonJoho;
    }

    /*
     * getGaibuSoft
     * @return GaibuSoft
     */
    @JsonProperty("GaibuSoft")
    public GaibuSoftDiv getGaibuSoft() {
        return GaibuSoft;
    }

    /*
     * setGaibuSoft
     * @param GaibuSoft GaibuSoft
     */
    @JsonProperty("GaibuSoft")
    public void setGaibuSoft(GaibuSoftDiv GaibuSoft) {
        this.GaibuSoft = GaibuSoft;
    }

    /*
     * getIkenshoMemo
     * @return IkenshoMemo
     */
    @JsonProperty("IkenshoMemo")
    public IkenshoMemoDiv getIkenshoMemo() {
        return IkenshoMemo;
    }

    /*
     * setIkenshoMemo
     * @param IkenshoMemo IkenshoMemo
     */
    @JsonProperty("IkenshoMemo")
    public void setIkenshoMemo(IkenshoMemoDiv IkenshoMemo) {
        this.IkenshoMemo = IkenshoMemo;
    }

    /*
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    /*
     * gethdnHasChanged
     * @return hdnHasChanged
     */
    @JsonProperty("hdnHasChanged")
    public RString getHdnHasChanged() {
        return hdnHasChanged;
    }

    /*
     * sethdnHasChanged
     * @param hdnHasChanged hdnHasChanged
     */
    @JsonProperty("hdnHasChanged")
    public void setHdnHasChanged(RString hdnHasChanged) {
        this.hdnHasChanged = hdnHasChanged;
    }

    /*
     * gethdnSampleText
     * @return hdnSampleText
     */
    @JsonProperty("hdnSampleText")
    public RString getHdnSampleText() {
        return hdnSampleText;
    }

    /*
     * sethdnSampleText
     * @param hdnSampleText hdnSampleText
     */
    @JsonProperty("hdnSampleText")
    public void setHdnSampleText(RString hdnSampleText) {
        this.hdnSampleText = hdnSampleText;
    }

    /*
     * gethdnSubGyomuCd
     * @return hdnSubGyomuCd
     */
    @JsonProperty("hdnSubGyomuCd")
    public RString getHdnSubGyomuCd() {
        return hdnSubGyomuCd;
    }

    /*
     * sethdnSubGyomuCd
     * @param hdnSubGyomuCd hdnSubGyomuCd
     */
    @JsonProperty("hdnSubGyomuCd")
    public void setHdnSubGyomuCd(RString hdnSubGyomuCd) {
        this.hdnSubGyomuCd = hdnSubGyomuCd;
    }

    /*
     * gethdnGroupCd
     * @return hdnGroupCd
     */
    @JsonProperty("hdnGroupCd")
    public RString getHdnGroupCd() {
        return hdnGroupCd;
    }

    /*
     * sethdnGroupCd
     * @param hdnGroupCd hdnGroupCd
     */
    @JsonProperty("hdnGroupCd")
    public void setHdnGroupCd(RString hdnGroupCd) {
        this.hdnGroupCd = hdnGroupCd;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShujiiJohoDiv getShujiiJoho() {
        return this.getIkenshoKihonJoho().getShujiiJoho();
    }

    @JsonIgnore
    public void setShujiiJoho(ShujiiJohoDiv ShujiiJoho) {
        this.getIkenshoKihonJoho().setShujiiJoho(ShujiiJoho);
    }

    @JsonIgnore
    public RadioButton getRadDoi() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getRadDoi();
    }

    @JsonIgnore
    public void setRadDoi(RadioButton radDoi) {
        this.getIkenshoKihonJoho().getShujiiJoho().setRadDoi(radDoi);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShimei() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiShimei();
    }

    @JsonIgnore
    public void setTxtShujiiShimei(TextBox txtShujiiShimei) {
        this.getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiShimei(txtShujiiShimei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinyuYMD() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getTxtKinyuYMD();
    }

    @JsonIgnore
    public void setTxtKinyuYMD(TextBoxDate txtKinyuYMD) {
        this.getIkenshoKihonJoho().getShujiiJoho().setTxtKinyuYMD(txtKinyuYMD);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanMeisho() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getTxtIryoKikanMeisho();
    }

    @JsonIgnore
    public void setTxtIryoKikanMeisho(TextBox txtIryoKikanMeisho) {
        this.getIkenshoKihonJoho().getShujiiJoho().setTxtIryoKikanMeisho(txtIryoKikanMeisho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanTelNumber() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiIryoKikanTelNumber();
    }

    @JsonIgnore
    public void setTxtShujiiIryoKikanTelNumber(TextBoxTelNo txtShujiiIryoKikanTelNumber) {
        this.getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiIryoKikanTelNumber(txtShujiiIryoKikanTelNumber);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShujiiIryoKikanShozaichi() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiIryoKikanShozaichi();
    }

    @JsonIgnore
    public void setTxtShujiiIryoKikanShozaichi(TextBoxJusho txtShujiiIryoKikanShozaichi) {
        this.getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiIryoKikanShozaichi(txtShujiiIryoKikanShozaichi);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanFaxNumber() {
        return this.getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiIryoKikanFaxNumber();
    }

    @JsonIgnore
    public void setTxtShujiiIryoKikanFaxNumber(TextBoxTelNo txtShujiiIryoKikanFaxNumber) {
        this.getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiIryoKikanFaxNumber(txtShujiiIryoKikanFaxNumber);
    }

    @JsonIgnore
    public ChosaTishoJohoDiv getChosaTishoJoho() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho();
    }

    @JsonIgnore
    public void setChosaTishoJoho(ChosaTishoJohoDiv ChosaTishoJoho) {
        this.getIkenshoKihonJoho().setChosaTishoJoho(ChosaTishoJoho);
    }

    @JsonIgnore
    public TextBoxDate getTxtSaishuShinryoYMD() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho().getTxtSaishuShinryoYMD();
    }

    @JsonIgnore
    public void setTxtSaishuShinryoYMD(TextBoxDate txtSaishuShinryoYMD) {
        this.getIkenshoKihonJoho().getChosaTishoJoho().setTxtSaishuShinryoYMD(txtSaishuShinryoYMD);
    }

    @JsonIgnore
    public RadioButton getRadIkenshoSakuseiKaisu() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho().getRadIkenshoSakuseiKaisu();
    }

    @JsonIgnore
    public void setRadIkenshoSakuseiKaisu(RadioButton radIkenshoSakuseiKaisu) {
        this.getIkenshoKihonJoho().getChosaTishoJoho().setRadIkenshoSakuseiKaisu(radIkenshoSakuseiKaisu);
    }

    @JsonIgnore
    public RadioButton getRadTakaShinryo() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho().getRadTakaShinryo();
    }

    @JsonIgnore
    public void setRadTakaShinryo(RadioButton radTakaShinryo) {
        this.getIkenshoKihonJoho().getChosaTishoJoho().setRadTakaShinryo(radTakaShinryo);
    }

    @JsonIgnore
    public CheckBoxList getChkTakaJushinSelect() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho().getChkTakaJushinSelect();
    }

    @JsonIgnore
    public void setChkTakaJushinSelect(CheckBoxList chkTakaJushinSelect) {
        this.getIkenshoKihonJoho().getChosaTishoJoho().setChkTakaJushinSelect(chkTakaJushinSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkSonota() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho().getChkSonota();
    }

    @JsonIgnore
    public void setChkSonota(CheckBoxList chkSonota) {
        this.getIkenshoKihonJoho().getChosaTishoJoho().setChkSonota(chkSonota);
    }

    @JsonIgnore
    public TextBox getTxtSonotaNyuryoku() {
        return this.getIkenshoKihonJoho().getChosaTishoJoho().getTxtSonotaNyuryoku();
    }

    @JsonIgnore
    public void setTxtSonotaNyuryoku(TextBox txtSonotaNyuryoku) {
        this.getIkenshoKihonJoho().getChosaTishoJoho().setTxtSonotaNyuryoku(txtSonotaNyuryoku);
    }

    @JsonIgnore
    public Label getLblGaibuSoft() {
        return this.getGaibuSoft().getLblGaibuSoft();
    }

    @JsonIgnore
    public void setLblGaibuSoft(Label lblGaibuSoft) {
        this.getGaibuSoft().setLblGaibuSoft(lblGaibuSoft);
    }

    @JsonIgnore
    public CheckBoxList getChkGaibuSoft() {
        return this.getGaibuSoft().getChkGaibuSoft();
    }

    @JsonIgnore
    public void setChkGaibuSoft(CheckBoxList chkGaibuSoft) {
        this.getGaibuSoft().setChkGaibuSoft(chkGaibuSoft);
    }

    @JsonIgnore
    public TextBox getTxtGaibuSoftName() {
        return this.getGaibuSoft().getTxtGaibuSoftName();
    }

    @JsonIgnore
    public void setTxtGaibuSoftName(TextBox txtGaibuSoftName) {
        this.getGaibuSoft().setTxtGaibuSoftName(txtGaibuSoftName);
    }

    @JsonIgnore
    public ButtonDialog getBtnMemoTeikeibunGuide() {
        return this.getIkenshoMemo().getBtnMemoTeikeibunGuide();
    }

    @JsonIgnore
    public void setBtnMemoTeikeibunGuide(ButtonDialog btnMemoTeikeibunGuide) {
        this.getIkenshoMemo().setBtnMemoTeikeibunGuide(btnMemoTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShujiiMemo() {
        return this.getIkenshoMemo().getTxtShujiiMemo();
    }

    @JsonIgnore
    public void setTxtShujiiMemo(TextBoxMultiLine txtShujiiMemo) {
        this.getIkenshoMemo().setTxtShujiiMemo(txtShujiiMemo);
    }

    // </editor-fold>
}
