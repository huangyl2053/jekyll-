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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabShinseishaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShinseishaJohoDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShinseijoho")
    private tplShinseijohoDiv tplShinseijoho;
    @JsonProperty("tplEnki")
    private tplEnkiDiv tplEnki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplShinseijoho
     * @return tplShinseijoho
     */
    @JsonProperty("tplShinseijoho")
    public tplShinseijohoDiv getTplShinseijoho() {
        return tplShinseijoho;
    }

    /*
     * settplShinseijoho
     * @param tplShinseijoho tplShinseijoho
     */
    @JsonProperty("tplShinseijoho")
    public void setTplShinseijoho(tplShinseijohoDiv tplShinseijoho) {
        this.tplShinseijoho = tplShinseijoho;
    }

    /*
     * gettplEnki
     * @return tplEnki
     */
    @JsonProperty("tplEnki")
    public tplEnkiDiv getTplEnki() {
        return tplEnki;
    }

    /*
     * settplEnki
     * @param tplEnki tplEnki
     */
    @JsonProperty("tplEnki")
    public void setTplEnki(tplEnkiDiv tplEnki) {
        this.tplEnki = tplEnki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ServiceDelDiv getServiceDel() {
        return this.getTplShinseijoho().getServiceDel();
    }

    @JsonIgnore
    public void  setServiceDel(ServiceDelDiv ServiceDel) {
        this.getTplShinseijoho().setServiceDel(ServiceDel);
    }

    @JsonIgnore
    public ButtonDialog getBtnServiceDelTeikeibunGuide() {
        return this.getTplShinseijoho().getServiceDel().getBtnServiceDelTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnServiceDelTeikeibunGuide(ButtonDialog btnServiceDelTeikeibunGuide) {
        this.getTplShinseijoho().getServiceDel().setBtnServiceDelTeikeibunGuide(btnServiceDelTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceDeleteRiyu() {
        return this.getTplShinseijoho().getServiceDel().getTxtServiceDeleteRiyu();
    }

    @JsonIgnore
    public void  setTxtServiceDeleteRiyu(TextBoxMultiLine txtServiceDeleteRiyu) {
        this.getTplShinseijoho().getServiceDel().setTxtServiceDeleteRiyu(txtServiceDeleteRiyu);
    }

    @JsonIgnore
    public SinseiTorisageDiv getSinseiTorisage() {
        return this.getTplShinseijoho().getSinseiTorisage();
    }

    @JsonIgnore
    public void  setSinseiTorisage(SinseiTorisageDiv SinseiTorisage) {
        this.getTplShinseijoho().setSinseiTorisage(SinseiTorisage);
    }

    @JsonIgnore
    public DropDownList getDdlTorisageJiyu() {
        return this.getTplShinseijoho().getSinseiTorisage().getDdlTorisageJiyu();
    }

    @JsonIgnore
    public void  setDdlTorisageJiyu(DropDownList ddlTorisageJiyu) {
        this.getTplShinseijoho().getSinseiTorisage().setDdlTorisageJiyu(ddlTorisageJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorisageDate() {
        return this.getTplShinseijoho().getSinseiTorisage().getTxtTorisageDate();
    }

    @JsonIgnore
    public void  setTxtTorisageDate(TextBoxDate txtTorisageDate) {
        this.getTplShinseijoho().getSinseiTorisage().setTxtTorisageDate(txtTorisageDate);
    }

    @JsonIgnore
    public TextBox getTxtTorisageJiyu() {
        return this.getTplShinseijoho().getSinseiTorisage().getTxtTorisageJiyu();
    }

    @JsonIgnore
    public void  setTxtTorisageJiyu(TextBox txtTorisageJiyu) {
        this.getTplShinseijoho().getSinseiTorisage().setTxtTorisageJiyu(txtTorisageJiyu);
    }

    @JsonIgnore
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return this.getTplShinseijoho().getShujiiAndShujiiIryoKikan();
    }

    @JsonIgnore
    public void  setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.getTplShinseijoho().setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikan);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getTplShinseijoho().getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public ChosainAndChosainInputDiv getChosainAndChosainInput() {
        return this.getTplShinseijoho().getChosainAndChosainInput();
    }

    @JsonIgnore
    public void  setChosainAndChosainInput(ChosainAndChosainInputDiv ChosainAndChosainInput) {
        this.getTplShinseijoho().setChosainAndChosainInput(ChosainAndChosainInput);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChodsItakusakiAndChosainInput() {
        return this.getTplShinseijoho().getChosainAndChosainInput().getCcdChodsItakusakiAndChosainInput();
    }

    @JsonIgnore
    public HomonSakiDiv getHomonSaki() {
        return this.getTplShinseijoho().getHomonSaki();
    }

    @JsonIgnore
    public void  setHomonSaki(HomonSakiDiv HomonSaki) {
        this.getTplShinseijoho().setHomonSaki(HomonSaki);
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getTplShinseijoho().getHomonSaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void  setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getTplShinseijoho().getHomonSaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getTplShinseijoho().getHomonSaki().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getTplShinseijoho().getHomonSaki().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTplShinseijoho().getHomonSaki().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getTplShinseijoho().getHomonSaki().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTplShinseijoho().getHomonSaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTplShinseijoho().getHomonSaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ShisetsuJohoDiv getShisetsuJoho() {
        return this.getTplShinseijoho().getShisetsuJoho();
    }

    @JsonIgnore
    public void  setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.getTplShinseijoho().setShisetsuJoho(ShisetsuJoho);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getTplShinseijoho().getShisetsuJoho().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiTsuchishoDoi() {
        return this.getTplShinseijoho().getChkNinteiTsuchishoDoi();
    }

    @JsonIgnore
    public void  setChkNinteiTsuchishoDoi(CheckBoxList chkNinteiTsuchishoDoi) {
        this.getTplShinseijoho().setChkNinteiTsuchishoDoi(chkNinteiTsuchishoDoi);
    }

    @JsonIgnore
    public CheckBoxList getChkJohoTeikyoDoi() {
        return this.getTplShinseijoho().getChkJohoTeikyoDoi();
    }

    @JsonIgnore
    public void  setChkJohoTeikyoDoi(CheckBoxList chkJohoTeikyoDoi) {
        this.getTplShinseijoho().setChkJohoTeikyoDoi(chkJohoTeikyoDoi);
    }

    @JsonIgnore
    public DropDownList getDdlShinsakaiYusenKubun() {
        return this.getTplShinseijoho().getDdlShinsakaiYusenKubun();
    }

    @JsonIgnore
    public void  setDdlShinsakaiYusenKubun(DropDownList ddlShinsakaiYusenKubun) {
        this.getTplShinseijoho().setDdlShinsakaiYusenKubun(ddlShinsakaiYusenKubun);
    }

    @JsonIgnore
    public DropDownList getDdlWariateKubun() {
        return this.getTplShinseijoho().getDdlWariateKubun();
    }

    @JsonIgnore
    public void  setDdlWariateKubun(DropDownList ddlWariateKubun) {
        this.getTplShinseijoho().setDdlWariateKubun(ddlWariateKubun);
    }

    @JsonIgnore
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return this.getTplShinseijoho().getCcdZenkaiNinteiKekkaJoho();
    }

    @JsonIgnore
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return this.getTplShinseijoho().getCcdKaigoNinteiShinseiKihon();
    }

    @JsonIgnore
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return this.getTplShinseijoho().getCcdShinseiSonotaJohoInput();
    }

    @JsonIgnore
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return this.getTplShinseijoho().getCcdShinseiTodokedesha();
    }

    @JsonIgnore
    public INinteiInputDiv getCcdNinteiInput() {
        return this.getTplShinseijoho().getCcdNinteiInput();
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiKetteiYMD() {
        return this.getTplEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiKetteiYMD(TextBoxDate txtEnkiKetteiYMD) {
        this.getTplEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnkiMikomiKikan() {
        return this.getTplEnki().getTxtEnkiMikomiKikan();
    }

    @JsonIgnore
    public void  setTxtEnkiMikomiKikan(TextBoxDateRange txtEnkiMikomiKikan) {
        this.getTplEnki().setTxtEnkiMikomiKikan(txtEnkiMikomiKikan);
    }

    @JsonIgnore
    public Label getLblEnkiRiyu() {
        return this.getTplEnki().getLblEnkiRiyu();
    }

    @JsonIgnore
    public void  setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.getTplEnki().setLblEnkiRiyu(lblEnkiRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return this.getTplEnki().getBtnEnkiRiyuTeikeibun();
    }

    @JsonIgnore
    public void  setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.getTplEnki().setBtnEnkiRiyuTeikeibun(btnEnkiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return this.getTplEnki().getTxtEnkiRiyu();
    }

    @JsonIgnore
    public void  setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.getTplEnki().setTxtEnkiRiyu(txtEnkiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getTplEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoYMD(TextBoxDate txtEnkiTsuchiHakkoYMD) {
        this.getTplEnki().setTxtEnkiTsuchiHakkoYMD(txtEnkiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return this.getTplEnki().getTxtEnkiTsuchishoHakkoCount();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.getTplEnki().setTxtEnkiTsuchishoHakkoCount(txtEnkiTsuchishoHakkoCount);
    }

    // </editor-fold>
}
