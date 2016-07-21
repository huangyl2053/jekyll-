package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikinaiTenkyoRirekiHenkan のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikinaiTenkyoRirekiHenkanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinseishaIchiran")
    private ShinseishaIchiranDiv ShinseishaIchiran;
    @JsonProperty("KoikinaiTenkyo")
    private KoikinaiTenkyoDiv KoikinaiTenkyo;
    @JsonProperty("ShinsakaiMessage")
    private ShinsakaiMessageDiv ShinsakaiMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
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
     * getKoikinaiTenkyo
     * @return KoikinaiTenkyo
     */
    @JsonProperty("KoikinaiTenkyo")
    public KoikinaiTenkyoDiv getKoikinaiTenkyo() {
        return KoikinaiTenkyo;
    }

    /*
     * setKoikinaiTenkyo
     * @param KoikinaiTenkyo KoikinaiTenkyo
     */
    @JsonProperty("KoikinaiTenkyo")
    public void setKoikinaiTenkyo(KoikinaiTenkyoDiv KoikinaiTenkyo) {
        this.KoikinaiTenkyo = KoikinaiTenkyo;
    }

    /*
     * getShinsakaiMessage
     * @return ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public ShinsakaiMessageDiv getShinsakaiMessage() {
        return ShinsakaiMessage;
    }

    /*
     * setShinsakaiMessage
     * @param ShinsakaiMessage ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public void setShinsakaiMessage(ShinsakaiMessageDiv ShinsakaiMessage) {
        this.ShinsakaiMessage = ShinsakaiMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHihokenshaNumber() {
        return this.getKensakuJoken().getTxtHihokenshaNumber();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNumber(TextBox txtHihokenshaNumber) {
        this.getKensakuJoken().setTxtHihokenshaNumber(txtHihokenshaNumber);
    }

    @JsonIgnore
    public HorizontalLine getSpaceName() {
        return this.getKensakuJoken().getSpaceName();
    }

    @JsonIgnore
    public void  setSpaceName(HorizontalLine spaceName) {
        this.getKensakuJoken().setSpaceName(spaceName);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNameJyouken() {
        return this.getKensakuJoken().getTxtHihokenshaNameJyouken();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNameJyouken(TextBox txtHihokenshaNameJyouken) {
        this.getKensakuJoken().setTxtHihokenshaNameJyouken(txtHihokenshaNameJyouken);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaNameMatchType() {
        return this.getKensakuJoken().getDdlHihokenshaNameMatchType();
    }

    @JsonIgnore
    public void  setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.getKensakuJoken().setDdlHihokenshaNameMatchType(ddlHihokenshaNameMatchType);
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiFlag() {
        return this.getKensakuJoken().getChkMinashiFlag();
    }

    @JsonIgnore
    public void  setChkMinashiFlag(CheckBoxList chkMinashiFlag) {
        this.getKensakuJoken().setChkMinashiFlag(chkMinashiFlag);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiDateFrom() {
        return this.getKensakuJoken().getTxtNinteiShinseiDateFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiDateFrom(TextBoxFlexibleDate txtNinteiShinseiDateFrom) {
        this.getKensakuJoken().setTxtNinteiShinseiDateFrom(txtNinteiShinseiDateFrom);
    }

    @JsonIgnore
    public Label getLblNinteiShinseiDate() {
        return this.getKensakuJoken().getLblNinteiShinseiDate();
    }

    @JsonIgnore
    public void  setLblNinteiShinseiDate(Label lblNinteiShinseiDate) {
        this.getKensakuJoken().setLblNinteiShinseiDate(lblNinteiShinseiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiDateTo() {
        return this.getKensakuJoken().getTxtNinteiShinseiDateTo();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseiDateTo(TextBoxFlexibleDate txtNinteiShinseiDateTo) {
        this.getKensakuJoken().setTxtNinteiShinseiDateTo(txtNinteiShinseiDateTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthDateFrom() {
        return this.getKensakuJoken().getTxtBirthDateFrom();
    }

    @JsonIgnore
    public void  setTxtBirthDateFrom(TextBoxFlexibleDate txtBirthDateFrom) {
        this.getKensakuJoken().setTxtBirthDateFrom(txtBirthDateFrom);
    }

    @JsonIgnore
    public Label getLblBirthDate() {
        return this.getKensakuJoken().getLblBirthDate();
    }

    @JsonIgnore
    public void  setLblBirthDate(Label lblBirthDate) {
        this.getKensakuJoken().setLblBirthDate(lblBirthDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthDateTo() {
        return this.getKensakuJoken().getTxtBirthDateTo();
    }

    @JsonIgnore
    public void  setTxtBirthDateTo(TextBoxFlexibleDate txtBirthDateTo) {
        this.getKensakuJoken().setTxtBirthDateTo(txtBirthDateTo);
    }

    @JsonIgnore
    public DropDownList getDdlShinseijiShinseiKubun() {
        return this.getKensakuJoken().getDdlShinseijiShinseiKubun();
    }

    @JsonIgnore
    public void  setDdlShinseijiShinseiKubun(DropDownList ddlShinseijiShinseiKubun) {
        this.getKensakuJoken().setDdlShinseijiShinseiKubun(ddlShinseijiShinseiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkSeibetsu() {
        return this.getKensakuJoken().getChkSeibetsu();
    }

    @JsonIgnore
    public void  setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.getKensakuJoken().setChkSeibetsu(chkSeibetsu);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum() {
        return this.getKensakuJoken().getTextBoxNum();
    }

    @JsonIgnore
    public void  setTextBoxNum(TextBoxNum TextBoxNum) {
        this.getKensakuJoken().setTextBoxNum(TextBoxNum);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearchClear() {
        return this.getKensakuJoken().getBtnKyufuJissekiSearchClear();
    }

    @JsonIgnore
    public void  setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.getKensakuJoken().setBtnKyufuJissekiSearchClear(btnKyufuJissekiSearchClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgShinseishaIchiran_Row> getDgShinseishaIchiran() {
        return this.getShinseishaIchiran().getDgShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgShinseishaIchiran(DataGrid<dgShinseishaIchiran_Row> dgShinseishaIchiran) {
        this.getShinseishaIchiran().setDgShinseishaIchiran(dgShinseishaIchiran);
    }

    @JsonIgnore
    public KoikinaiTenkyoTenkyomaeDiv getKoikinaiTenkyoTenkyomae() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae();
    }

    @JsonIgnore
    public void  setKoikinaiTenkyoTenkyomae(KoikinaiTenkyoTenkyomaeDiv KoikinaiTenkyoTenkyomae) {
        this.getKoikinaiTenkyo().setKoikinaiTenkyoTenkyomae(KoikinaiTenkyoTenkyomae);
    }

    @JsonIgnore
    public TextBox getTxtShokisaiHokenshaNo() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtShokisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokenshaNo(TextBox txtShokisaiHokenshaNo) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtShokisaiHokenshaNo(txtShokisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShokisaiHokensha() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtShokisaiHokensha();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokensha(TextBox txtShokisaiHokensha) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtShokisaiHokensha(txtShokisaiHokensha);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJusho() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBox txtJusho) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBox getTxtSex() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtSex();
    }

    @JsonIgnore
    public void  setTxtSex(TextBox txtSex) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtSex(txtSex);
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthYMD() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public TextBox getTxtAge() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtAge();
    }

    @JsonIgnore
    public void  setTxtAge(TextBox txtAge) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtAge(txtAge);
    }

    @JsonIgnore
    public TextBox getTxtTelNo() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBox txtTelNo) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBox getTxtYubinNo() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBox txtYubinNo) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtNijiHanteiKekka() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiKekka(TextBox txtNijiHanteiKekka) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtNijiHanteiKekka(txtNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteibi() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtNijiHanteibi();
    }

    @JsonIgnore
    public void  setTxtNijiHanteibi(TextBoxDate txtNijiHanteibi) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtNijiHanteibi(txtNijiHanteibi);
    }

    @JsonIgnore
    public TextBox getTxtNinteiYukoKikan() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikan(TextBox txtNinteiYukoKikan) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtNinteiYukoKikan(txtNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukoKikanKaishiShuryo() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtNinteiYukoKikanKaishiShuryo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanKaishiShuryo(TextBoxDateRange txtNinteiYukoKikanKaishiShuryo) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtNinteiYukoKikanKaishiShuryo(txtNinteiYukoKikanKaishiShuryo);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiMeisho() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtNinteiChosaItakusakiMeisho();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiMeisho(TextBox txtNinteiChosaItakusakiMeisho) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtNinteiChosaItakusakiMeisho(txtNinteiChosaItakusakiMeisho);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryoKikanMeisho() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtShujiiIryoKikanMeisho();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanMeisho(TextBox txtShujiiIryoKikanMeisho) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtShujiiIryoKikanMeisho(txtShujiiIryoKikanMeisho);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public TextBox getTxtKaigoNinteiShinsakaiNo() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtKaigoNinteiShinsakaiNo();
    }

    @JsonIgnore
    public void  setTxtKaigoNinteiShinsakaiNo(TextBox txtKaigoNinteiShinsakaiNo) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtKaigoNinteiShinsakaiNo(txtKaigoNinteiShinsakaiNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiKaisabi() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().getTxtKaigoNinteiShinsakaiKaisabi();
    }

    @JsonIgnore
    public void  setTxtKaigoNinteiShinsakaiKaisabi(TextBoxDate txtKaigoNinteiShinsakaiKaisabi) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyomae().setTxtKaigoNinteiShinsakaiKaisabi(txtKaigoNinteiShinsakaiKaisabi);
    }

    @JsonIgnore
    public KoikinaiTenkyoTenkyosakiDiv getKoikinaiTenkyoTenkyosaki() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyosaki();
    }

    @JsonIgnore
    public void  setKoikinaiTenkyoTenkyosaki(KoikinaiTenkyoTenkyosakiDiv KoikinaiTenkyoTenkyosaki) {
        this.getKoikinaiTenkyo().setKoikinaiTenkyoTenkyosaki(KoikinaiTenkyoTenkyosaki);
    }

    @JsonIgnore
    public DropDownList getDdlShokisaiHokenshaNoSaki() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyosaki().getDdlShokisaiHokenshaNoSaki();
    }

    @JsonIgnore
    public void  setDdlShokisaiHokenshaNoSaki(DropDownList ddlShokisaiHokenshaNoSaki) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyosaki().setDdlShokisaiHokenshaNoSaki(ddlShokisaiHokenshaNoSaki);
    }

    @JsonIgnore
    public TextBox getTxtShokisaiHokenshaSaki() {
        return this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyosaki().getTxtShokisaiHokenshaSaki();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokenshaSaki(TextBox txtShokisaiHokenshaSaki) {
        this.getKoikinaiTenkyo().getKoikinaiTenkyoTenkyosaki().setTxtShokisaiHokenshaSaki(txtShokisaiHokenshaSaki);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getKoikinaiTenkyo().getBtnToroku();
    }

    @JsonIgnore
    public void  setBtnToroku(Button btnToroku) {
        this.getKoikinaiTenkyo().setBtnToroku(btnToroku);
    }

    // </editor-fold>
}
