package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiIinJohoToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinJohoTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinsakaiIinJohoIchiran")
    private ShinsakaiIinJohoIchiranDiv ShinsakaiIinJohoIchiran;
    @JsonProperty("ShinsakaiIinJohoTorokuInput")
    private ShinsakaiIinJohoTorokuInputDiv ShinsakaiIinJohoTorokuInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;
    @JsonProperty("hdnShinsakaiIinJohoSyosai")
    private RString hdnShinsakaiIinJohoSyosai;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;
    @JsonProperty("hdnChosaItakusakiChosainGuide")
    private RString hdnChosaItakusakiChosainGuide;
    @JsonProperty("hdnShozokuKikanIchiranSize")
    private RString hdnShozokuKikanIchiranSize;

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
     * getShinsakaiIinJohoIchiran
     * @return ShinsakaiIinJohoIchiran
     */
    @JsonProperty("ShinsakaiIinJohoIchiran")
    public ShinsakaiIinJohoIchiranDiv getShinsakaiIinJohoIchiran() {
        return ShinsakaiIinJohoIchiran;
    }

    /*
     * setShinsakaiIinJohoIchiran
     * @param ShinsakaiIinJohoIchiran ShinsakaiIinJohoIchiran
     */
    @JsonProperty("ShinsakaiIinJohoIchiran")
    public void setShinsakaiIinJohoIchiran(ShinsakaiIinJohoIchiranDiv ShinsakaiIinJohoIchiran) {
        this.ShinsakaiIinJohoIchiran = ShinsakaiIinJohoIchiran;
    }

    /*
     * getShinsakaiIinJohoTorokuInput
     * @return ShinsakaiIinJohoTorokuInput
     */
    @JsonProperty("ShinsakaiIinJohoTorokuInput")
    public ShinsakaiIinJohoTorokuInputDiv getShinsakaiIinJohoTorokuInput() {
        return ShinsakaiIinJohoTorokuInput;
    }

    /*
     * setShinsakaiIinJohoTorokuInput
     * @param ShinsakaiIinJohoTorokuInput ShinsakaiIinJohoTorokuInput
     */
    @JsonProperty("ShinsakaiIinJohoTorokuInput")
    public void setShinsakaiIinJohoTorokuInput(ShinsakaiIinJohoTorokuInputDiv ShinsakaiIinJohoTorokuInput) {
        this.ShinsakaiIinJohoTorokuInput = ShinsakaiIinJohoTorokuInput;
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
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * gethdnShinsakaiIinJohoSyosai
     * @return hdnShinsakaiIinJohoSyosai
     */
    @JsonProperty("hdnShinsakaiIinJohoSyosai")
    public RString getHdnShinsakaiIinJohoSyosai() {
        return hdnShinsakaiIinJohoSyosai;
    }

    /*
     * sethdnShinsakaiIinJohoSyosai
     * @param hdnShinsakaiIinJohoSyosai hdnShinsakaiIinJohoSyosai
     */
    @JsonProperty("hdnShinsakaiIinJohoSyosai")
    public void setHdnShinsakaiIinJohoSyosai(RString hdnShinsakaiIinJohoSyosai) {
        this.hdnShinsakaiIinJohoSyosai = hdnShinsakaiIinJohoSyosai;
    }

    /*
     * gethdnSubGyomuCode
     * @return hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    /*
     * sethdnSubGyomuCode
     * @param hdnSubGyomuCode hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode = hdnSubGyomuCode;
    }

    /*
     * gethdnShikibetsuCode
     * @return hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    /*
     * sethdnShikibetsuCode
     * @param hdnShikibetsuCode hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode = hdnShikibetsuCode;
    }

    /*
     * gethdnChosaItakusakiChosainGuide
     * @return hdnChosaItakusakiChosainGuide
     */
    @JsonProperty("hdnChosaItakusakiChosainGuide")
    public RString getHdnChosaItakusakiChosainGuide() {
        return hdnChosaItakusakiChosainGuide;
    }

    /*
     * sethdnChosaItakusakiChosainGuide
     * @param hdnChosaItakusakiChosainGuide hdnChosaItakusakiChosainGuide
     */
    @JsonProperty("hdnChosaItakusakiChosainGuide")
    public void setHdnChosaItakusakiChosainGuide(RString hdnChosaItakusakiChosainGuide) {
        this.hdnChosaItakusakiChosainGuide = hdnChosaItakusakiChosainGuide;
    }

    /*
     * gethdnShozokuKikanIchiranSize
     * @return hdnShozokuKikanIchiranSize
     */
    @JsonProperty("hdnShozokuKikanIchiranSize")
    public RString getHdnShozokuKikanIchiranSize() {
        return hdnShozokuKikanIchiranSize;
    }

    /*
     * sethdnShozokuKikanIchiranSize
     * @param hdnShozokuKikanIchiranSize hdnShozokuKikanIchiranSize
     */
    @JsonProperty("hdnShozokuKikanIchiranSize")
    public void setHdnShozokuKikanIchiranSize(RString hdnShozokuKikanIchiranSize) {
        this.hdnShozokuKikanIchiranSize = hdnShozokuKikanIchiranSize;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHyojiJoken() {
        return this.getKensakuJoken().getRadHyojiJoken();
    }

    @JsonIgnore
    public void  setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.getKensakuJoken().setRadHyojiJoken(radHyojiJoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtDispMax() {
        return this.getKensakuJoken().getTxtDispMax();
    }

    @JsonIgnore
    public void  setTxtDispMax(TextBoxNum txtDispMax) {
        this.getKensakuJoken().setTxtDispMax(txtDispMax);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnShinsakaiIinAdd() {
        return this.getShinsakaiIinJohoIchiran().getBtnShinsakaiIinAdd();
    }

    @JsonIgnore
    public void  setBtnShinsakaiIinAdd(Button btnShinsakaiIinAdd) {
        this.getShinsakaiIinJohoIchiran().setBtnShinsakaiIinAdd(btnShinsakaiIinAdd);
    }

    @JsonIgnore
    public Button getBtnKozaMitorokuCSV() {
        return this.getShinsakaiIinJohoIchiran().getBtnKozaMitorokuCSV();
    }

    @JsonIgnore
    public void  setBtnKozaMitorokuCSV(Button btnKozaMitorokuCSV) {
        this.getShinsakaiIinJohoIchiran().setBtnKozaMitorokuCSV(btnKozaMitorokuCSV);
    }

    @JsonIgnore
    public DataGrid<dgShinsaInJohoIchiran_Row> getDgShinsaInJohoIchiran() {
        return this.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran();
    }

    @JsonIgnore
    public void  setDgShinsaInJohoIchiran(DataGrid<dgShinsaInJohoIchiran_Row> dgShinsaInJohoIchiran) {
        this.getShinsakaiIinJohoIchiran().setDgShinsaInJohoIchiran(dgShinsaInJohoIchiran);
    }

    @JsonIgnore
    public ShinsakaiIinJohoDiv getShinsakaiIinJoho() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho();
    }

    @JsonIgnore
    public void  setShinsakaiIinJoho(ShinsakaiIinJohoDiv ShinsakaiIinJoho) {
        this.getShinsakaiIinJohoTorokuInput().setShinsakaiIinJoho(ShinsakaiIinJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtShinsainCode() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtShinsainCode();
    }

    @JsonIgnore
    public void  setTxtShinsainCode(TextBoxCode txtShinsainCode) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtShinsainCode(txtShinsainCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaIinYMDFrom() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtShinsaIinYMDFrom();
    }

    @JsonIgnore
    public void  setTxtShinsaIinYMDFrom(TextBoxDate txtShinsaIinYMDFrom) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtShinsaIinYMDFrom(txtShinsaIinYMDFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaIinYMDTo() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtShinsaIinYMDTo();
    }

    @JsonIgnore
    public void  setTxtShinsaIinYMDTo(TextBoxDate txtShinsaIinYMDTo) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtShinsaIinYMDTo(txtShinsaIinYMDTo);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBox getTxtKanaShimei() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtKanaShimei();
    }

    @JsonIgnore
    public void  setTxtKanaShimei(TextBox txtKanaShimei) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtKanaShimei(txtKanaShimei);
    }

    @JsonIgnore
    public RadioButton getRadSeibetsu() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getRadSeibetsu();
    }

    @JsonIgnore
    public void  setRadSeibetsu(RadioButton radSeibetsu) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setRadSeibetsu(radSeibetsu);
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthYMD() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuCode() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getDdlShikakuCode();
    }

    @JsonIgnore
    public void  setDdlShikakuCode(DropDownList ddlShikakuCode) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setDdlShikakuCode(ddlShikakuCode);
    }

    @JsonIgnore
    public TextBox getTxtBiko() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBox txtBiko) {
        this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdshinsakaiChikuCode() {
        return this.getShinsakaiIinJohoTorokuInput().getShinsakaiIinJoho().getCcdshinsakaiChikuCode();
    }

    @JsonIgnore
    public RenrakusakiKinyuKikanDiv getRenrakusakiKinyuKikan() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan();
    }

    @JsonIgnore
    public void  setRenrakusakiKinyuKikan(RenrakusakiKinyuKikanDiv RenrakusakiKinyuKikan) {
        this.getShinsakaiIinJohoTorokuInput().setRenrakusakiKinyuKikan(RenrakusakiKinyuKikan);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo1() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getTxtTelNo1();
    }

    @JsonIgnore
    public void  setTxtTelNo1(TextBoxTelNo txtTelNo1) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setTxtTelNo1(txtTelNo1);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxNo() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getTxtFaxNo();
    }

    @JsonIgnore
    public void  setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setTxtFaxNo(txtFaxNo);
    }

    @JsonIgnore
    public DropDownList getDdlYusoKubun() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getDdlYusoKubun();
    }

    @JsonIgnore
    public void  setDdlYusoKubun(DropDownList ddlYusoKubun) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setDdlYusoKubun(ddlYusoKubun);
    }

    @JsonIgnore
    public DropDownList getDdlHaishiFlag() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getDdlHaishiFlag();
    }

    @JsonIgnore
    public void  setDdlHaishiFlag(DropDownList ddlHaishiFlag) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setDdlHaishiFlag(ddlHaishiFlag);
    }

    @JsonIgnore
    public TextBoxDate getTxtHaishiYMD() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getTxtHaishiYMD();
    }

    @JsonIgnore
    public void  setTxtHaishiYMD(TextBoxDate txtHaishiYMD) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setTxtHaishiYMD(txtHaishiYMD);
    }

    @JsonIgnore
    public KozaJohoDiv getKozaJoho() {
        return this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().getKozaJoho();
    }

    @JsonIgnore
    public void  setKozaJoho(KozaJohoDiv KozaJoho) {
        this.getShinsakaiIinJohoTorokuInput().getRenrakusakiKinyuKikan().setKozaJoho(KozaJoho);
    }

    @JsonIgnore
    public ShozokuKikanIchiranDiv getShozokuKikanIchiran() {
        return this.getShinsakaiIinJohoTorokuInput().getShozokuKikanIchiran();
    }

    @JsonIgnore
    public void  setShozokuKikanIchiran(ShozokuKikanIchiranDiv ShozokuKikanIchiran) {
        this.getShinsakaiIinJohoTorokuInput().setShozokuKikanIchiran(ShozokuKikanIchiran);
    }

    @JsonIgnore
    public Button getBtnShozokuKikanAdd() {
        return this.getShinsakaiIinJohoTorokuInput().getShozokuKikanIchiran().getBtnShozokuKikanAdd();
    }

    @JsonIgnore
    public void  setBtnShozokuKikanAdd(Button btnShozokuKikanAdd) {
        this.getShinsakaiIinJohoTorokuInput().getShozokuKikanIchiran().setBtnShozokuKikanAdd(btnShozokuKikanAdd);
    }

    @JsonIgnore
    public DataGrid<dgShozokuKikanIchiran_Row> getDgShozokuKikanIchiran() {
        return this.getShinsakaiIinJohoTorokuInput().getShozokuKikanIchiran().getDgShozokuKikanIchiran();
    }

    @JsonIgnore
    public void  setDgShozokuKikanIchiran(DataGrid<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran) {
        this.getShinsakaiIinJohoTorokuInput().getShozokuKikanIchiran().setDgShozokuKikanIchiran(dgShozokuKikanIchiran);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getShinsakaiIinJohoTorokuInput().getBtnToroku();
    }

    @JsonIgnore
    public void  setBtnToroku(Button btnToroku) {
        this.getShinsakaiIinJohoTorokuInput().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getShinsakaiIinJohoTorokuInput().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getShinsakaiIinJohoTorokuInput().setBtnDelete(btnDelete);
    }

    // </editor-fold>
}
