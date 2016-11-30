package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiIkenshoTorokuTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoTorokuTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-10_12-10-23">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiIkenshoToroku")
    private ShujiiIkenshoTorokuDiv ShujiiIkenshoToroku;
    @JsonProperty("KaigoKanryoMsg")
    private KaigoKanryoMsgDiv KaigoKanryoMsg;
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
     * getShujiiIkenshoToroku
     * @return ShujiiIkenshoToroku
     */
    @JsonProperty("ShujiiIkenshoToroku")
    public ShujiiIkenshoTorokuDiv getShujiiIkenshoToroku() {
        return ShujiiIkenshoToroku;
    }

    /*
     * setShujiiIkenshoToroku
     * @param ShujiiIkenshoToroku ShujiiIkenshoToroku
     */
    @JsonProperty("ShujiiIkenshoToroku")
    public void setShujiiIkenshoToroku(ShujiiIkenshoTorokuDiv ShujiiIkenshoToroku) {
        this.ShujiiIkenshoToroku = ShujiiIkenshoToroku;
    }

    /*
     * getKaigoKanryoMsg
     * @return KaigoKanryoMsg
     */
    @JsonProperty("KaigoKanryoMsg")
    public KaigoKanryoMsgDiv getKaigoKanryoMsg() {
        return KaigoKanryoMsg;
    }

    /*
     * setKaigoKanryoMsg
     * @param KaigoKanryoMsg KaigoKanryoMsg
     */
    @JsonProperty("KaigoKanryoMsg")
    public void setKaigoKanryoMsg(KaigoKanryoMsgDiv KaigoKanryoMsg) {
        this.KaigoKanryoMsg = KaigoKanryoMsg;
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
    public ButtonDialog getBtnShobyoGuide() {
        return this.getShujiiIkenshoToroku().getBtnShobyoGuide();
    }

    @JsonIgnore
    public void  setBtnShobyoGuide(ButtonDialog btnShobyoGuide) {
        this.getShujiiIkenshoToroku().setBtnShobyoGuide(btnShobyoGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokubetsuIryoGuide() {
        return this.getShujiiIkenshoToroku().getBtnTokubetsuIryoGuide();
    }

    @JsonIgnore
    public void  setBtnTokubetsuIryoGuide(ButtonDialog btnTokubetsuIryoGuide) {
        this.getShujiiIkenshoToroku().setBtnTokubetsuIryoGuide(btnTokubetsuIryoGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnShinshinJotaiGuide() {
        return this.getShujiiIkenshoToroku().getBtnShinshinJotaiGuide();
    }

    @JsonIgnore
    public void  setBtnShinshinJotaiGuide(ButtonDialog btnShinshinJotaiGuide) {
        this.getShujiiIkenshoToroku().setBtnShinshinJotaiGuide(btnShinshinJotaiGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnSeikatsuKinoServiceGuide() {
        return this.getShujiiIkenshoToroku().getBtnSeikatsuKinoServiceGuide();
    }

    @JsonIgnore
    public void  setBtnSeikatsuKinoServiceGuide(ButtonDialog btnSeikatsuKinoServiceGuide) {
        this.getShujiiIkenshoToroku().setBtnSeikatsuKinoServiceGuide(btnSeikatsuKinoServiceGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokkiJikoGuide() {
        return this.getShujiiIkenshoToroku().getBtnTokkiJikoGuide();
    }

    @JsonIgnore
    public void  setBtnTokkiJikoGuide(ButtonDialog btnTokkiJikoGuide) {
        this.getShujiiIkenshoToroku().setBtnTokkiJikoGuide(btnTokkiJikoGuide);
    }

    @JsonIgnore
    public IkenshoKihonJohoDiv getIkenshoKihonJoho() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho();
    }

    @JsonIgnore
    public void  setIkenshoKihonJoho(IkenshoKihonJohoDiv IkenshoKihonJoho) {
        this.getShujiiIkenshoToroku().setIkenshoKihonJoho(IkenshoKihonJoho);
    }

    @JsonIgnore
    public ShujiiJohoDiv getShujiiJoho() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho();
    }

    @JsonIgnore
    public void  setShujiiJoho(ShujiiJohoDiv ShujiiJoho) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().setShujiiJoho(ShujiiJoho);
    }

    @JsonIgnore
    public RadioButton getRadDoi() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getRadDoi();
    }

    @JsonIgnore
    public void  setRadDoi(RadioButton radDoi) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setRadDoi(radDoi);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShimei() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiShimei();
    }

    @JsonIgnore
    public void  setTxtShujiiShimei(TextBox txtShujiiShimei) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiShimei(txtShujiiShimei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKinyuYMD() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getTxtKinyuYMD();
    }

    @JsonIgnore
    public void  setTxtKinyuYMD(TextBoxDate txtKinyuYMD) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setTxtKinyuYMD(txtKinyuYMD);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanMeisho() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getTxtIryoKikanMeisho();
    }

    @JsonIgnore
    public void  setTxtIryoKikanMeisho(TextBox txtIryoKikanMeisho) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setTxtIryoKikanMeisho(txtIryoKikanMeisho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanTelNumber() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiIryoKikanTelNumber();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanTelNumber(TextBoxTelNo txtShujiiIryoKikanTelNumber) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiIryoKikanTelNumber(txtShujiiIryoKikanTelNumber);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShujiiIryoKikanShozaichi() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiIryoKikanShozaichi();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanShozaichi(TextBoxJusho txtShujiiIryoKikanShozaichi) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiIryoKikanShozaichi(txtShujiiIryoKikanShozaichi);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanFaxNumber() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().getTxtShujiiIryoKikanFaxNumber();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanFaxNumber(TextBoxTelNo txtShujiiIryoKikanFaxNumber) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getShujiiJoho().setTxtShujiiIryoKikanFaxNumber(txtShujiiIryoKikanFaxNumber);
    }

    @JsonIgnore
    public ChosaTishoJohoDiv getChosaTishoJoho() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho();
    }

    @JsonIgnore
    public void  setChosaTishoJoho(ChosaTishoJohoDiv ChosaTishoJoho) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().setChosaTishoJoho(ChosaTishoJoho);
    }

    @JsonIgnore
    public TextBoxDate getTxtSaishuShinryoYMD() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().getTxtSaishuShinryoYMD();
    }

    @JsonIgnore
    public void  setTxtSaishuShinryoYMD(TextBoxDate txtSaishuShinryoYMD) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().setTxtSaishuShinryoYMD(txtSaishuShinryoYMD);
    }

    @JsonIgnore
    public RadioButton getRadIkenshoSakuseiKaisu() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().getRadIkenshoSakuseiKaisu();
    }

    @JsonIgnore
    public void  setRadIkenshoSakuseiKaisu(RadioButton radIkenshoSakuseiKaisu) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().setRadIkenshoSakuseiKaisu(radIkenshoSakuseiKaisu);
    }

    @JsonIgnore
    public RadioButton getRadTakaShinryo() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().getRadTakaShinryo();
    }

    @JsonIgnore
    public void  setRadTakaShinryo(RadioButton radTakaShinryo) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().setRadTakaShinryo(radTakaShinryo);
    }

    @JsonIgnore
    public CheckBoxList getChkTakaJushinSelect() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().getChkTakaJushinSelect();
    }

    @JsonIgnore
    public void  setChkTakaJushinSelect(CheckBoxList chkTakaJushinSelect) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().setChkTakaJushinSelect(chkTakaJushinSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkSonota() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().getChkSonota();
    }

    @JsonIgnore
    public void  setChkSonota(CheckBoxList chkSonota) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().setChkSonota(chkSonota);
    }

    @JsonIgnore
    public TextBox getTxtSonotaNyuryoku() {
        return this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().getTxtSonotaNyuryoku();
    }

    @JsonIgnore
    public void  setTxtSonotaNyuryoku(TextBox txtSonotaNyuryoku) {
        this.getShujiiIkenshoToroku().getIkenshoKihonJoho().getChosaTishoJoho().setTxtSonotaNyuryoku(txtSonotaNyuryoku);
    }

    @JsonIgnore
    public IkenshoMemoDiv getIkenshoMemo() {
        return this.getShujiiIkenshoToroku().getIkenshoMemo();
    }

    @JsonIgnore
    public void  setIkenshoMemo(IkenshoMemoDiv IkenshoMemo) {
        this.getShujiiIkenshoToroku().setIkenshoMemo(IkenshoMemo);
    }

    @JsonIgnore
    public ButtonDialog getBtnMemoTeikeibunGuide() {
        return this.getShujiiIkenshoToroku().getIkenshoMemo().getBtnMemoTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnMemoTeikeibunGuide(ButtonDialog btnMemoTeikeibunGuide) {
        this.getShujiiIkenshoToroku().getIkenshoMemo().setBtnMemoTeikeibunGuide(btnMemoTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShujiiMemo() {
        return this.getShujiiIkenshoToroku().getIkenshoMemo().getTxtShujiiMemo();
    }

    @JsonIgnore
    public void  setTxtShujiiMemo(TextBoxMultiLine txtShujiiMemo) {
        this.getShujiiIkenshoToroku().getIkenshoMemo().setTxtShujiiMemo(txtShujiiMemo);
    }

    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return this.getShujiiIkenshoToroku().getCcdNinteiShinseishaKihonInfo();
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return this.getKaigoKanryoMsg().getCcdKaigoKanryoMessage();
    }

    // </editor-fold>
}
