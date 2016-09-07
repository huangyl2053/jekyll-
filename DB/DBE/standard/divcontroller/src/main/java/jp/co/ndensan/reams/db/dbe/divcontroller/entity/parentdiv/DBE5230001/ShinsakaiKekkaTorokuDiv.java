package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKekkaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKekkaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanryoMessagePanel")
    private KanryoMessagePanelDiv KanryoMessagePanel;
    @JsonProperty("KyotsuHyojiArea")
    private KyotsuHyojiAreaDiv KyotsuHyojiArea;
    @JsonProperty("ShinseishaIchiran")
    private ShinseishaIchiranDiv ShinseishaIchiran;
    @JsonProperty("KobetsuHyojiArea")
    private KobetsuHyojiAreaDiv KobetsuHyojiArea;
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
     * getKanryoMessagePanel
     * @return KanryoMessagePanel
     */
    @JsonProperty("KanryoMessagePanel")
    public KanryoMessagePanelDiv getKanryoMessagePanel() {
        return KanryoMessagePanel;
    }

    /*
     * setKanryoMessagePanel
     * @param KanryoMessagePanel KanryoMessagePanel
     */
    @JsonProperty("KanryoMessagePanel")
    public void setKanryoMessagePanel(KanryoMessagePanelDiv KanryoMessagePanel) {
        this.KanryoMessagePanel = KanryoMessagePanel;
    }

    /*
     * getKyotsuHyojiArea
     * @return KyotsuHyojiArea
     */
    @JsonProperty("KyotsuHyojiArea")
    public KyotsuHyojiAreaDiv getKyotsuHyojiArea() {
        return KyotsuHyojiArea;
    }

    /*
     * setKyotsuHyojiArea
     * @param KyotsuHyojiArea KyotsuHyojiArea
     */
    @JsonProperty("KyotsuHyojiArea")
    public void setKyotsuHyojiArea(KyotsuHyojiAreaDiv KyotsuHyojiArea) {
        this.KyotsuHyojiArea = KyotsuHyojiArea;
    }

    /*
     * getShinseishaIchiran
     * @return ShinseishaIchiran
     */
    @JsonProperty("ShinseishaIchiran")
    public ShinseishaIchiranDiv getShinseishaIchiran() {
        return ShinseishaIchiran;
    }

    /*
     * setShinseishaIchiran
     * @param ShinseishaIchiran ShinseishaIchiran
     */
    @JsonProperty("ShinseishaIchiran")
    public void setShinseishaIchiran(ShinseishaIchiranDiv ShinseishaIchiran) {
        this.ShinseishaIchiran = ShinseishaIchiran;
    }

    /*
     * getKobetsuHyojiArea
     * @return KobetsuHyojiArea
     */
    @JsonProperty("KobetsuHyojiArea")
    public KobetsuHyojiAreaDiv getKobetsuHyojiArea() {
        return KobetsuHyojiArea;
    }

    /*
     * setKobetsuHyojiArea
     * @param KobetsuHyojiArea KobetsuHyojiArea
     */
    @JsonProperty("KobetsuHyojiArea")
    public void setKobetsuHyojiArea(KobetsuHyojiAreaDiv KobetsuHyojiArea) {
        this.KobetsuHyojiArea = KobetsuHyojiArea;
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
    public TextBox getTxtShinsakaiName() {
        return this.getKyotsuHyojiArea().getTxtShinsakaiName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.getKyotsuHyojiArea().setTxtShinsakaiName(txtShinsakaiName);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNo() {
        return this.getKyotsuHyojiArea().getTxtGogitaiNo();
    }

    @JsonIgnore
    public void  setTxtGogitaiNo(TextBox txtGogitaiNo) {
        this.getKyotsuHyojiArea().setTxtGogitaiNo(txtGogitaiNo);
    }

    @JsonIgnore
    public TextBox getTxtShinsaTaishosha() {
        return this.getKyotsuHyojiArea().getTxtShinsaTaishosha();
    }

    @JsonIgnore
    public void  setTxtShinsaTaishosha(TextBox txtShinsaTaishosha) {
        this.getKyotsuHyojiArea().setTxtShinsaTaishosha(txtShinsaTaishosha);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getKyotsuHyojiArea().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getKyotsuHyojiArea().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBoxCode getTxtChiku() {
        return this.getKyotsuHyojiArea().getTxtChiku();
    }

    @JsonIgnore
    public void  setTxtChiku(TextBoxCode txtChiku) {
        this.getKyotsuHyojiArea().setTxtChiku(txtChiku);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaijoJusho() {
        return this.getKyotsuHyojiArea().getTxtShinsakaijoJusho();
    }

    @JsonIgnore
    public void  setTxtShinsakaijoJusho(TextBox txtShinsakaijoJusho) {
        this.getKyotsuHyojiArea().setTxtShinsakaijoJusho(txtShinsakaijoJusho);
    }

    @JsonIgnore
    public TextBox getTxtTaishoNinzu() {
        return this.getKyotsuHyojiArea().getTxtTaishoNinzu();
    }

    @JsonIgnore
    public void  setTxtTaishoNinzu(TextBox txtTaishoNinzu) {
        this.getKyotsuHyojiArea().setTxtTaishoNinzu(txtTaishoNinzu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiNichiji() {
        return this.getKyotsuHyojiArea().getTxtKaisaiNichiji();
    }

    @JsonIgnore
    public void  setTxtKaisaiNichiji(TextBoxFlexibleDate txtKaisaiNichiji) {
        this.getKyotsuHyojiArea().setTxtKaisaiNichiji(txtKaisaiNichiji);
    }

    @JsonIgnore
    public TextBoxTimeRange getTxtKaisaiTimeRange() {
        return this.getKyotsuHyojiArea().getTxtKaisaiTimeRange();
    }

    @JsonIgnore
    public void  setTxtKaisaiTimeRange(TextBoxTimeRange txtKaisaiTimeRange) {
        this.getKyotsuHyojiArea().setTxtKaisaiTimeRange(txtKaisaiTimeRange);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiShurui() {
        return this.getKyotsuHyojiArea().getChkShinsakaiShurui();
    }

    @JsonIgnore
    public void  setChkShinsakaiShurui(CheckBoxList chkShinsakaiShurui) {
        this.getKyotsuHyojiArea().setChkShinsakaiShurui(chkShinsakaiShurui);
    }

    @JsonIgnore
    public TextBox getTxtStutas() {
        return this.getKyotsuHyojiArea().getTxtStutas();
    }

    @JsonIgnore
    public void  setTxtStutas(TextBox txtStutas) {
        this.getKyotsuHyojiArea().setTxtStutas(txtStutas);
    }

    @JsonIgnore
    public Label getLblTaishosha() {
        return this.getShinseishaIchiran().getLblTaishosha();
    }

    @JsonIgnore
    public void  setLblTaishosha(Label lblTaishosha) {
        this.getShinseishaIchiran().setLblTaishosha(lblTaishosha);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getShinseishaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getShinseishaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiJunjo() {
        return this.getKobetsuHyojiArea().getTxtShinsakaiJunjo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiJunjo(TextBox txtShinsakaiJunjo) {
        this.getKobetsuHyojiArea().setTxtShinsakaiJunjo(txtShinsakaiJunjo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDay() {
        return this.getKobetsuHyojiArea().getTxtShinseiDay();
    }

    @JsonIgnore
    public void  setTxtShinseiDay(TextBoxFlexibleDate txtShinseiDay) {
        this.getKobetsuHyojiArea().setTxtShinseiDay(txtShinseiDay);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return this.getKobetsuHyojiArea().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.getKobetsuHyojiArea().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunShinseiji() {
        return this.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji();
    }

    @JsonIgnore
    public void  setTxtShinseiKubunShinseiji(TextBox txtShinseiKubunShinseiji) {
        this.getKobetsuHyojiArea().setTxtShinseiKubunShinseiji(txtShinseiKubunShinseiji);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunLow() {
        return this.getKobetsuHyojiArea().getTxtShinseiKubunLow();
    }

    @JsonIgnore
    public void  setTxtShinseiKubunLow(TextBox txtShinseiKubunLow) {
        this.getKobetsuHyojiArea().setTxtShinseiKubunLow(txtShinseiKubunLow);
    }

    @JsonIgnore
    public TextBox getTxtIchijiHantei() {
        return this.getKobetsuHyojiArea().getTxtIchijiHantei();
    }

    @JsonIgnore
    public void  setTxtIchijiHantei(TextBox txtIchijiHantei) {
        this.getKobetsuHyojiArea().setTxtIchijiHantei(txtIchijiHantei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNijiHanteiDay() {
        return this.getKobetsuHyojiArea().getTxtNijiHanteiDay();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiDay(TextBoxFlexibleDate txtNijiHanteiDay) {
        this.getKobetsuHyojiArea().setTxtNijiHanteiDay(txtNijiHanteiDay);
    }

    @JsonIgnore
    public TextBox getTxtTokuteiShippei() {
        return this.getKobetsuHyojiArea().getTxtTokuteiShippei();
    }

    @JsonIgnore
    public void  setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.getKobetsuHyojiArea().setTxtTokuteiShippei(txtTokuteiShippei);
    }

    @JsonIgnore
    public DropDownList getDdlJotaiZo() {
        return this.getKobetsuHyojiArea().getDdlJotaiZo();
    }

    @JsonIgnore
    public void  setDdlJotaiZo(DropDownList ddlJotaiZo) {
        this.getKobetsuHyojiArea().setDdlJotaiZo(ddlJotaiZo);
    }

    @JsonIgnore
    public DropDownList getDdlHanteiKekka() {
        return this.getKobetsuHyojiArea().getDdlHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlHanteiKekka(DropDownList ddlHanteiKekka) {
        this.getKobetsuHyojiArea().setDdlHanteiKekka(ddlHanteiKekka);
    }

    @JsonIgnore
    public DropDownList getDdlNijiHantei() {
        return this.getKobetsuHyojiArea().getDdlNijiHantei();
    }

    @JsonIgnore
    public void  setDdlNijiHantei(DropDownList ddlNijiHantei) {
        this.getKobetsuHyojiArea().setDdlNijiHantei(ddlNijiHantei);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiKikanFrom() {
        return this.getKobetsuHyojiArea().getTxtNinteiKikanFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKikanFrom(TextBoxDate txtNinteiKikanFrom) {
        this.getKobetsuHyojiArea().setTxtNinteiKikanFrom(txtNinteiKikanFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiKikanTo() {
        return this.getKobetsuHyojiArea().getTxtNinteiKikanTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKikanTo(TextBoxDate txtNinteiKikanTo) {
        this.getKobetsuHyojiArea().setTxtNinteiKikanTo(txtNinteiKikanTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtNinteiKikanMonth() {
        return this.getKobetsuHyojiArea().getTxtNinteiKikanMonth();
    }

    @JsonIgnore
    public void  setTxtNinteiKikanMonth(TextBoxNum txtNinteiKikanMonth) {
        this.getKobetsuHyojiArea().setTxtNinteiKikanMonth(txtNinteiKikanMonth);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizon() {
        return this.getKobetsuHyojiArea().getLinHorizon();
    }

    @JsonIgnore
    public void  setLinHorizon(HorizontalLine linHorizon) {
        this.getKobetsuHyojiArea().setLinHorizon(linHorizon);
    }

    @JsonIgnore
    public Label getLblShiinsakaiMemo() {
        return this.getKobetsuHyojiArea().getLblShiinsakaiMemo();
    }

    @JsonIgnore
    public void  setLblShiinsakaiMemo(Label lblShiinsakaiMemo) {
        this.getKobetsuHyojiArea().setLblShiinsakaiMemo(lblShiinsakaiMemo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShinsakaiMemoTeikeibunGuide() {
        return this.getKobetsuHyojiArea().getBtnShinsakaiMemoTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnShinsakaiMemoTeikeibunGuide(ButtonDialog btnShinsakaiMemoTeikeibunGuide) {
        this.getKobetsuHyojiArea().setBtnShinsakaiMemoTeikeibunGuide(btnShinsakaiMemoTeikeibunGuide);
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getKobetsuHyojiArea().getLblShinsakaiIken();
    }

    @JsonIgnore
    public void  setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.getKobetsuHyojiArea().setLblShinsakaiIken(lblShinsakaiIken);
    }

    @JsonIgnore
    public DropDownList getDdlShinsakaiIkenShurui() {
        return this.getKobetsuHyojiArea().getDdlShinsakaiIkenShurui();
    }

    @JsonIgnore
    public void  setDdlShinsakaiIkenShurui(DropDownList ddlShinsakaiIkenShurui) {
        this.getKobetsuHyojiArea().setDdlShinsakaiIkenShurui(ddlShinsakaiIkenShurui);
    }

    @JsonIgnore
    public ButtonDialog getBtnShinsakiIkenTeikeibunGuide() {
        return this.getKobetsuHyojiArea().getBtnShinsakiIkenTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnShinsakiIkenTeikeibunGuide(ButtonDialog btnShinsakiIkenTeikeibunGuide) {
        this.getKobetsuHyojiArea().setBtnShinsakiIkenTeikeibunGuide(btnShinsakiIkenTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsakaiMemo() {
        return this.getKobetsuHyojiArea().getTxtShinsakaiMemo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiMemo(TextBoxMultiLine txtShinsakaiMemo) {
        this.getKobetsuHyojiArea().setTxtShinsakaiMemo(txtShinsakaiMemo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return this.getKobetsuHyojiArea().getTxtShinsakaiIken();
    }

    @JsonIgnore
    public void  setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.getKobetsuHyojiArea().setTxtShinsakaiIken(txtShinsakaiIken);
    }

    @JsonIgnore
    public Label getLblIchijiHanteiKekkaHenkoRiyu() {
        return this.getKobetsuHyojiArea().getLblIchijiHanteiKekkaHenkoRiyu();
    }

    @JsonIgnore
    public void  setLblIchijiHanteiKekkaHenkoRiyu(Label lblIchijiHanteiKekkaHenkoRiyu) {
        this.getKobetsuHyojiArea().setLblIchijiHanteiKekkaHenkoRiyu(lblIchijiHanteiKekkaHenkoRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchijiHanteiTeikeibunGuide() {
        return this.getKobetsuHyojiArea().getBtnIchijiHanteiTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnIchijiHanteiTeikeibunGuide(ButtonDialog btnIchijiHanteiTeikeibunGuide) {
        this.getKobetsuHyojiArea().setBtnIchijiHanteiTeikeibunGuide(btnIchijiHanteiTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtIchijiHanteiKekkaHenkoRiyu() {
        return this.getKobetsuHyojiArea().getTxtIchijiHanteiKekkaHenkoRiyu();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiKekkaHenkoRiyu(TextBoxMultiLine txtIchijiHanteiKekkaHenkoRiyu) {
        this.getKobetsuHyojiArea().setTxtIchijiHanteiKekkaHenkoRiyu(txtIchijiHanteiKekkaHenkoRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiChosaJokyoShokai() {
        return this.getKobetsuHyojiArea().getBtnNinteiChosaJokyoShokai();
    }

    @JsonIgnore
    public void  setBtnNinteiChosaJokyoShokai(ButtonDialog btnNinteiChosaJokyoShokai) {
        this.getKobetsuHyojiArea().setBtnNinteiChosaJokyoShokai(btnNinteiChosaJokyoShokai);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getKobetsuHyojiArea().getBtnToroku();
    }

    @JsonIgnore
    public void  setBtnToroku(Button btnToroku) {
        this.getKobetsuHyojiArea().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public ButtonDialog getBtnIchigoHantei() {
        return this.getKobetsuHyojiArea().getBtnIchigoHantei();
    }

    @JsonIgnore
    public void  setBtnIchigoHantei(ButtonDialog btnIchigoHantei) {
        this.getKobetsuHyojiArea().setBtnIchigoHantei(btnIchigoHantei);
    }

    // </editor-fold>
}
