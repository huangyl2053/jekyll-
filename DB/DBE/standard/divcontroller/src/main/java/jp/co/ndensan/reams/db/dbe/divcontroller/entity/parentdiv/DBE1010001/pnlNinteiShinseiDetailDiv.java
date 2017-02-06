package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * pnlNinteiShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlNinteiShinseiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-14_20-51-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryohokenGuide")
    private ButtonDialog btnIryohokenGuide;
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    private ButtonDialog btnNyuinAndShisetsuNyusho;
    @JsonProperty("btnJogaiShinsakaiIinGuide")
    private ButtonDialog btnJogaiShinsakaiIinGuide;
    @JsonProperty("btnShichosonRenrakuJiko")
    private ButtonDialog btnShichosonRenrakuJiko;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("btnTainoJokyo")
    private ButtonDialog btnTainoJokyo;
    @JsonProperty("tabShinseishaJoho")
    private tabShinseishaJohoDiv tabShinseishaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIryohokenGuide
     * @return btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public ButtonDialog getBtnIryohokenGuide() {
        return btnIryohokenGuide;
    }

    /*
     * setbtnIryohokenGuide
     * @param btnIryohokenGuide btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public void setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.btnIryohokenGuide = btnIryohokenGuide;
    }

    /*
     * getbtnRenrakusaki
     * @return btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public ButtonDialog getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    /*
     * setbtnRenrakusaki
     * @param btnRenrakusaki btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.btnRenrakusaki = btnRenrakusaki;
    }

    /*
     * getbtnNyuinAndShisetsuNyusho
     * @return btnNyuinAndShisetsuNyusho
     */
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    public ButtonDialog getBtnNyuinAndShisetsuNyusho() {
        return btnNyuinAndShisetsuNyusho;
    }

    /*
     * setbtnNyuinAndShisetsuNyusho
     * @param btnNyuinAndShisetsuNyusho btnNyuinAndShisetsuNyusho
     */
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    public void setBtnNyuinAndShisetsuNyusho(ButtonDialog btnNyuinAndShisetsuNyusho) {
        this.btnNyuinAndShisetsuNyusho = btnNyuinAndShisetsuNyusho;
    }

    /*
     * getbtnJogaiShinsakaiIinGuide
     * @return btnJogaiShinsakaiIinGuide
     */
    @JsonProperty("btnJogaiShinsakaiIinGuide")
    public ButtonDialog getBtnJogaiShinsakaiIinGuide() {
        return btnJogaiShinsakaiIinGuide;
    }

    /*
     * setbtnJogaiShinsakaiIinGuide
     * @param btnJogaiShinsakaiIinGuide btnJogaiShinsakaiIinGuide
     */
    @JsonProperty("btnJogaiShinsakaiIinGuide")
    public void setBtnJogaiShinsakaiIinGuide(ButtonDialog btnJogaiShinsakaiIinGuide) {
        this.btnJogaiShinsakaiIinGuide = btnJogaiShinsakaiIinGuide;
    }

    /*
     * getbtnShichosonRenrakuJiko
     * @return btnShichosonRenrakuJiko
     */
    @JsonProperty("btnShichosonRenrakuJiko")
    public ButtonDialog getBtnShichosonRenrakuJiko() {
        return btnShichosonRenrakuJiko;
    }

    /*
     * setbtnShichosonRenrakuJiko
     * @param btnShichosonRenrakuJiko btnShichosonRenrakuJiko
     */
    @JsonProperty("btnShichosonRenrakuJiko")
    public void setBtnShichosonRenrakuJiko(ButtonDialog btnShichosonRenrakuJiko) {
        this.btnShichosonRenrakuJiko = btnShichosonRenrakuJiko;
    }

    /*
     * getbtnChosaJokyo
     * @return btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public ButtonDialog getBtnChosaJokyo() {
        return btnChosaJokyo;
    }

    /*
     * setbtnChosaJokyo
     * @param btnChosaJokyo btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.btnChosaJokyo = btnChosaJokyo;
    }

    /*
     * getbtnTainoJokyo
     * @return btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public ButtonDialog getBtnTainoJokyo() {
        return btnTainoJokyo;
    }

    /*
     * setbtnTainoJokyo
     * @param btnTainoJokyo btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public void setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.btnTainoJokyo = btnTainoJokyo;
    }

    /*
     * gettabShinseishaJoho
     * @return tabShinseishaJoho
     */
    @JsonProperty("tabShinseishaJoho")
    public tabShinseishaJohoDiv getTabShinseishaJoho() {
        return tabShinseishaJoho;
    }

    /*
     * settabShinseishaJoho
     * @param tabShinseishaJoho tabShinseishaJoho
     */
    @JsonProperty("tabShinseishaJoho")
    public void setTabShinseishaJoho(tabShinseishaJohoDiv tabShinseishaJoho) {
        this.tabShinseishaJoho = tabShinseishaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplShinseijohoDiv getTplShinseijoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho();
    }

    @JsonIgnore
    public void  setTplShinseijoho(tplShinseijohoDiv tplShinseijoho) {
        this.getTabShinseishaJoho().setTplShinseijoho(tplShinseijoho);
    }

    @JsonIgnore
    public RadioButton getRadMode() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getRadMode();
    }

    @JsonIgnore
    public void  setRadMode(RadioButton radMode) {
        this.getTabShinseishaJoho().getTplShinseijoho().setRadMode(radMode);
    }

    @JsonIgnore
    public ServiceDelDiv getServiceDel() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getServiceDel();
    }

    @JsonIgnore
    public void  setServiceDel(ServiceDelDiv ServiceDel) {
        this.getTabShinseishaJoho().getTplShinseijoho().setServiceDel(ServiceDel);
    }

    @JsonIgnore
    public ButtonDialog getBtnServiceDelTeikeibunGuide() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getServiceDel().getBtnServiceDelTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnServiceDelTeikeibunGuide(ButtonDialog btnServiceDelTeikeibunGuide) {
        this.getTabShinseishaJoho().getTplShinseijoho().getServiceDel().setBtnServiceDelTeikeibunGuide(btnServiceDelTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceDeleteRiyu() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getServiceDel().getTxtServiceDeleteRiyu();
    }

    @JsonIgnore
    public void  setTxtServiceDeleteRiyu(TextBoxMultiLine txtServiceDeleteRiyu) {
        this.getTabShinseishaJoho().getTplShinseijoho().getServiceDel().setTxtServiceDeleteRiyu(txtServiceDeleteRiyu);
    }

    @JsonIgnore
    public SinseiTorisageDiv getSinseiTorisage() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage();
    }

    @JsonIgnore
    public void  setSinseiTorisage(SinseiTorisageDiv SinseiTorisage) {
        this.getTabShinseishaJoho().getTplShinseijoho().setSinseiTorisage(SinseiTorisage);
    }

    @JsonIgnore
    public DropDownList getDdlTorisageJiyu() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getDdlTorisageJiyu();
    }

    @JsonIgnore
    public void  setDdlTorisageJiyu(DropDownList ddlTorisageJiyu) {
        this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setDdlTorisageJiyu(ddlTorisageJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorisageDate() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getTxtTorisageDate();
    }

    @JsonIgnore
    public void  setTxtTorisageDate(TextBoxDate txtTorisageDate) {
        this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setTxtTorisageDate(txtTorisageDate);
    }

    @JsonIgnore
    public TextBox getTxtTorisageJiyu() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().getTxtTorisageJiyu();
    }

    @JsonIgnore
    public void  setTxtTorisageJiyu(TextBox txtTorisageJiyu) {
        this.getTabShinseishaJoho().getTplShinseijoho().getSinseiTorisage().setTxtTorisageJiyu(txtTorisageJiyu);
    }

    @JsonIgnore
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan();
    }

    @JsonIgnore
    public void  setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.getTabShinseishaJoho().getTplShinseijoho().setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikan);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public ChosainAndChosainInputDiv getChosainAndChosainInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput();
    }

    @JsonIgnore
    public void  setChosainAndChosainInput(ChosainAndChosainInputDiv ChosainAndChosainInput) {
        this.getTabShinseishaJoho().getTplShinseijoho().setChosainAndChosainInput(ChosainAndChosainInput);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChodsItakusakiAndChosainInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChosainAndChosainInput().getCcdChodsItakusakiAndChosainInput();
    }

    @JsonIgnore
    public HomonSakiDiv getHomonSaki() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki();
    }

    @JsonIgnore
    public void  setHomonSaki(HomonSakiDiv HomonSaki) {
        this.getTabShinseishaJoho().getTplShinseijoho().setHomonSaki(HomonSaki);
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void  setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTabShinseishaJoho().getTplShinseijoho().getHomonSaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ShisetsuJohoDiv getShisetsuJoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho();
    }

    @JsonIgnore
    public void  setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.getTabShinseishaJoho().getTplShinseijoho().setShisetsuJoho(ShisetsuJoho);
    }

    @JsonIgnore
    public TextBox getTxtNyushoShisetsu() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho().getTxtNyushoShisetsu();
    }

    @JsonIgnore
    public void  setTxtNyushoShisetsu(TextBox txtNyushoShisetsu) {
        this.getTabShinseishaJoho().getTplShinseijoho().getShisetsuJoho().setTxtNyushoShisetsu(txtNyushoShisetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiTsuchishoDoi() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChkNinteiTsuchishoDoi();
    }

    @JsonIgnore
    public void  setChkNinteiTsuchishoDoi(CheckBoxList chkNinteiTsuchishoDoi) {
        this.getTabShinseishaJoho().getTplShinseijoho().setChkNinteiTsuchishoDoi(chkNinteiTsuchishoDoi);
    }

    @JsonIgnore
    public CheckBoxList getChkJohoTeikyoDoi() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getChkJohoTeikyoDoi();
    }

    @JsonIgnore
    public void  setChkJohoTeikyoDoi(CheckBoxList chkJohoTeikyoDoi) {
        this.getTabShinseishaJoho().getTplShinseijoho().setChkJohoTeikyoDoi(chkJohoTeikyoDoi);
    }

    @JsonIgnore
    public DropDownList getDdlShinsakaiYusenKubun() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getDdlShinsakaiYusenKubun();
    }

    @JsonIgnore
    public void  setDdlShinsakaiYusenKubun(DropDownList ddlShinsakaiYusenKubun) {
        this.getTabShinseishaJoho().getTplShinseijoho().setDdlShinsakaiYusenKubun(ddlShinsakaiYusenKubun);
    }

    @JsonIgnore
    public DropDownList getDdlWariateKubun() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getDdlWariateKubun();
    }

    @JsonIgnore
    public void  setDdlWariateKubun(DropDownList ddlWariateKubun) {
        this.getTabShinseishaJoho().getTplShinseijoho().setDdlWariateKubun(ddlWariateKubun);
    }

    @JsonIgnore
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdKaigoNinteiShinseiKihon();
    }

    @JsonIgnore
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdZenkaiNinteiKekkaJoho();
    }

    @JsonIgnore
    public INinteiInputDiv getCcdNinteiInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdNinteiInput();
    }

    @JsonIgnore
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdShinseiSonotaJohoInput();
    }

    @JsonIgnore
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return this.getTabShinseishaJoho().getTplShinseijoho().getCcdShinseiTodokedesha();
    }

    @JsonIgnore
    public tplEnkiDiv getTplEnki() {
        return this.getTabShinseishaJoho().getTplEnki();
    }

    @JsonIgnore
    public void  setTplEnki(tplEnkiDiv tplEnki) {
        this.getTabShinseishaJoho().setTplEnki(tplEnki);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiKetteiYMD() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiKetteiYMD(TextBoxDate txtEnkiKetteiYMD) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnkiMikomiKikan() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiMikomiKikan();
    }

    @JsonIgnore
    public void  setTxtEnkiMikomiKikan(TextBoxDateRange txtEnkiMikomiKikan) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiMikomiKikan(txtEnkiMikomiKikan);
    }

    @JsonIgnore
    public Label getLblEnkiRiyu() {
        return this.getTabShinseishaJoho().getTplEnki().getLblEnkiRiyu();
    }

    @JsonIgnore
    public void  setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.getTabShinseishaJoho().getTplEnki().setLblEnkiRiyu(lblEnkiRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return this.getTabShinseishaJoho().getTplEnki().getBtnEnkiRiyuTeikeibun();
    }

    @JsonIgnore
    public void  setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.getTabShinseishaJoho().getTplEnki().setBtnEnkiRiyuTeikeibun(btnEnkiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiRiyu();
    }

    @JsonIgnore
    public void  setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiRiyu(txtEnkiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoYMD(TextBoxDate txtEnkiTsuchiHakkoYMD) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiTsuchiHakkoYMD(txtEnkiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return this.getTabShinseishaJoho().getTplEnki().getTxtEnkiTsuchishoHakkoCount();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.getTabShinseishaJoho().getTplEnki().setTxtEnkiTsuchishoHakkoCount(txtEnkiTsuchishoHakkoCount);
    }

    @JsonIgnore
    public tplShinseishaJohoDiv getTplShinseishaJoho() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho();
    }

    @JsonIgnore
    public void  setTplShinseishaJoho(tplShinseishaJohoDiv tplShinseishaJoho) {
        this.getTabShinseishaJoho().setTplShinseishaJoho(tplShinseishaJoho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtJohoAtenaMeisho() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoAtenaMeisho();
    }

    @JsonIgnore
    public void  setTxtJohoAtenaMeisho(TextBoxAtenaMeisho txtJohoAtenaMeisho) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoAtenaMeisho(txtJohoAtenaMeisho);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtJohoAtenaKanaMeisho() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoAtenaKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtJohoAtenaKanaMeisho(TextBoxAtenaKanaMeisho txtJohoAtenaKanaMeisho) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoAtenaKanaMeisho(txtJohoAtenaKanaMeisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtJohoBirthday() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoBirthday();
    }

    @JsonIgnore
    public void  setTxtJohoBirthday(TextBoxDate txtJohoBirthday) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoBirthday(txtJohoBirthday);
    }

    @JsonIgnore
    public RadioButton getRadJohoSeibetsu() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getRadJohoSeibetsu();
    }

    @JsonIgnore
    public void  setRadJohoSeibetsu(RadioButton radJohoSeibetsu) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setRadJohoSeibetsu(radJohoSeibetsu);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJohoYubinNo() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoYubinNo();
    }

    @JsonIgnore
    public void  setTxtJohoYubinNo(TextBoxYubinNo txtJohoYubinNo) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoYubinNo(txtJohoYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJohoJusho() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoJusho();
    }

    @JsonIgnore
    public void  setTxtJohoJusho(TextBoxJusho txtJohoJusho) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoJusho(txtJohoJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJohoTelNo() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoTelNo();
    }

    @JsonIgnore
    public void  setTxtJohoTelNo(TextBoxTelNo txtJohoTelNo) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoTelNo(txtJohoTelNo);
    }

    @JsonIgnore
    public TextBox getTxtJohoNenrei() {
        return this.getTabShinseishaJoho().getTplShinseishaJoho().getTxtJohoNenrei();
    }

    @JsonIgnore
    public void  setTxtJohoNenrei(TextBox txtJohoNenrei) {
        this.getTabShinseishaJoho().getTplShinseishaJoho().setTxtJohoNenrei(txtJohoNenrei);
    }

    // </editor-fold>
}
