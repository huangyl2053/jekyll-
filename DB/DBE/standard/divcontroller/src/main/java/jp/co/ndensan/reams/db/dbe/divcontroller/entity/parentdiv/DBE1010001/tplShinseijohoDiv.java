package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinseijoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinseijohoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ServiceDel")
    private ServiceDelDiv ServiceDel;
    @JsonProperty("SinseiTorisage")
    private SinseiTorisageDiv SinseiTorisage;
    @JsonProperty("ShujiiAndShujiiIryoKikan")
    private ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan;
    @JsonProperty("ChosainAndChosainInput")
    private ChosainAndChosainInputDiv ChosainAndChosainInput;
    @JsonProperty("HomonSaki")
    private HomonSakiDiv HomonSaki;
    @JsonProperty("ShisetsuJoho")
    private ShisetsuJohoDiv ShisetsuJoho;
    @JsonProperty("chkNinteiTsuchishoDoi")
    private CheckBoxList chkNinteiTsuchishoDoi;
    @JsonProperty("chkJohoTeikyoDoi")
    private CheckBoxList chkJohoTeikyoDoi;
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    private ZenkaiNinteiKekkaJohoDiv ccdZenkaiNinteiKekkaJoho;
    @JsonProperty("ccdKaigoNinteiShinseiKihon")
    private KaigoNinteiShinseiKihonJohoInputDiv ccdKaigoNinteiShinseiKihon;
    @JsonProperty("ccdNinteiInput")
    private NinteiInputDiv ccdNinteiInput;
    @JsonProperty("ccdShinseiSonotaJohoInput")
    private ShinseiSonotaJohoInputDiv ccdShinseiSonotaJohoInput;
    @JsonProperty("ccdShinseiTodokedesha")
    private NinteiShinseiTodokedeshaDiv ccdShinseiTodokedesha;
    @JsonProperty("ddlShinsakaiYusenKubun")
    private DropDownList ddlShinsakaiYusenKubun;
    @JsonProperty("ddlWariateKubun")
    private DropDownList ddlWariateKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getServiceDel
     * @return ServiceDel
     */
    @JsonProperty("ServiceDel")
    public ServiceDelDiv getServiceDel() {
        return ServiceDel;
    }

    /*
     * setServiceDel
     * @param ServiceDel ServiceDel
     */
    @JsonProperty("ServiceDel")
    public void setServiceDel(ServiceDelDiv ServiceDel) {
        this.ServiceDel = ServiceDel;
    }

    /*
     * getSinseiTorisage
     * @return SinseiTorisage
     */
    @JsonProperty("SinseiTorisage")
    public SinseiTorisageDiv getSinseiTorisage() {
        return SinseiTorisage;
    }

    /*
     * setSinseiTorisage
     * @param SinseiTorisage SinseiTorisage
     */
    @JsonProperty("SinseiTorisage")
    public void setSinseiTorisage(SinseiTorisageDiv SinseiTorisage) {
        this.SinseiTorisage = SinseiTorisage;
    }

    /*
     * getShujiiAndShujiiIryoKikan
     * @return ShujiiAndShujiiIryoKikan
     */
    @JsonProperty("ShujiiAndShujiiIryoKikan")
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return ShujiiAndShujiiIryoKikan;
    }

    /*
     * setShujiiAndShujiiIryoKikan
     * @param ShujiiAndShujiiIryoKikan ShujiiAndShujiiIryoKikan
     */
    @JsonProperty("ShujiiAndShujiiIryoKikan")
    public void setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.ShujiiAndShujiiIryoKikan = ShujiiAndShujiiIryoKikan;
    }

    /*
     * getChosainAndChosainInput
     * @return ChosainAndChosainInput
     */
    @JsonProperty("ChosainAndChosainInput")
    public ChosainAndChosainInputDiv getChosainAndChosainInput() {
        return ChosainAndChosainInput;
    }

    /*
     * setChosainAndChosainInput
     * @param ChosainAndChosainInput ChosainAndChosainInput
     */
    @JsonProperty("ChosainAndChosainInput")
    public void setChosainAndChosainInput(ChosainAndChosainInputDiv ChosainAndChosainInput) {
        this.ChosainAndChosainInput = ChosainAndChosainInput;
    }

    /*
     * getHomonSaki
     * @return HomonSaki
     */
    @JsonProperty("HomonSaki")
    public HomonSakiDiv getHomonSaki() {
        return HomonSaki;
    }

    /*
     * setHomonSaki
     * @param HomonSaki HomonSaki
     */
    @JsonProperty("HomonSaki")
    public void setHomonSaki(HomonSakiDiv HomonSaki) {
        this.HomonSaki = HomonSaki;
    }

    /*
     * getShisetsuJoho
     * @return ShisetsuJoho
     */
    @JsonProperty("ShisetsuJoho")
    public ShisetsuJohoDiv getShisetsuJoho() {
        return ShisetsuJoho;
    }

    /*
     * setShisetsuJoho
     * @param ShisetsuJoho ShisetsuJoho
     */
    @JsonProperty("ShisetsuJoho")
    public void setShisetsuJoho(ShisetsuJohoDiv ShisetsuJoho) {
        this.ShisetsuJoho = ShisetsuJoho;
    }

    /*
     * getchkNinteiTsuchishoDoi
     * @return chkNinteiTsuchishoDoi
     */
    @JsonProperty("chkNinteiTsuchishoDoi")
    public CheckBoxList getChkNinteiTsuchishoDoi() {
        return chkNinteiTsuchishoDoi;
    }

    /*
     * setchkNinteiTsuchishoDoi
     * @param chkNinteiTsuchishoDoi chkNinteiTsuchishoDoi
     */
    @JsonProperty("chkNinteiTsuchishoDoi")
    public void setChkNinteiTsuchishoDoi(CheckBoxList chkNinteiTsuchishoDoi) {
        this.chkNinteiTsuchishoDoi = chkNinteiTsuchishoDoi;
    }

    /*
     * getchkJohoTeikyoDoi
     * @return chkJohoTeikyoDoi
     */
    @JsonProperty("chkJohoTeikyoDoi")
    public CheckBoxList getChkJohoTeikyoDoi() {
        return chkJohoTeikyoDoi;
    }

    /*
     * setchkJohoTeikyoDoi
     * @param chkJohoTeikyoDoi chkJohoTeikyoDoi
     */
    @JsonProperty("chkJohoTeikyoDoi")
    public void setChkJohoTeikyoDoi(CheckBoxList chkJohoTeikyoDoi) {
        this.chkJohoTeikyoDoi = chkJohoTeikyoDoi;
    }

    /*
     * getccdZenkaiNinteiKekkaJoho
     * @return ccdZenkaiNinteiKekkaJoho
     */
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return ccdZenkaiNinteiKekkaJoho;
    }

    /*
     * getccdKaigoNinteiShinseiKihon
     * @return ccdKaigoNinteiShinseiKihon
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihon")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return ccdKaigoNinteiShinseiKihon;
    }

    /*
     * getccdNinteiInput
     * @return ccdNinteiInput
     */
    @JsonProperty("ccdNinteiInput")
    public INinteiInputDiv getCcdNinteiInput() {
        return ccdNinteiInput;
    }

    /*
     * getccdShinseiSonotaJohoInput
     * @return ccdShinseiSonotaJohoInput
     */
    @JsonProperty("ccdShinseiSonotaJohoInput")
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return ccdShinseiSonotaJohoInput;
    }

    /*
     * getccdShinseiTodokedesha
     * @return ccdShinseiTodokedesha
     */
    @JsonProperty("ccdShinseiTodokedesha")
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return ccdShinseiTodokedesha;
    }

    /*
     * getddlShinsakaiYusenKubun
     * @return ddlShinsakaiYusenKubun
     */
    @JsonProperty("ddlShinsakaiYusenKubun")
    public DropDownList getDdlShinsakaiYusenKubun() {
        return ddlShinsakaiYusenKubun;
    }

    /*
     * setddlShinsakaiYusenKubun
     * @param ddlShinsakaiYusenKubun ddlShinsakaiYusenKubun
     */
    @JsonProperty("ddlShinsakaiYusenKubun")
    public void setDdlShinsakaiYusenKubun(DropDownList ddlShinsakaiYusenKubun) {
        this.ddlShinsakaiYusenKubun = ddlShinsakaiYusenKubun;
    }

    /*
     * getddlWariateKubun
     * @return ddlWariateKubun
     */
    @JsonProperty("ddlWariateKubun")
    public DropDownList getDdlWariateKubun() {
        return ddlWariateKubun;
    }

    /*
     * setddlWariateKubun
     * @param ddlWariateKubun ddlWariateKubun
     */
    @JsonProperty("ddlWariateKubun")
    public void setDdlWariateKubun(DropDownList ddlWariateKubun) {
        this.ddlWariateKubun = ddlWariateKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnServiceDelTeikeibunGuide() {
        return this.getServiceDel().getBtnServiceDelTeikeibunGuide();
    }

    @JsonIgnore
    public void  setBtnServiceDelTeikeibunGuide(ButtonDialog btnServiceDelTeikeibunGuide) {
        this.getServiceDel().setBtnServiceDelTeikeibunGuide(btnServiceDelTeikeibunGuide);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceDeleteRiyu() {
        return this.getServiceDel().getTxtServiceDeleteRiyu();
    }

    @JsonIgnore
    public void  setTxtServiceDeleteRiyu(TextBoxMultiLine txtServiceDeleteRiyu) {
        this.getServiceDel().setTxtServiceDeleteRiyu(txtServiceDeleteRiyu);
    }

    @JsonIgnore
    public DropDownList getDdlTorisageJiyu() {
        return this.getSinseiTorisage().getDdlTorisageJiyu();
    }

    @JsonIgnore
    public void  setDdlTorisageJiyu(DropDownList ddlTorisageJiyu) {
        this.getSinseiTorisage().setDdlTorisageJiyu(ddlTorisageJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorisageDate() {
        return this.getSinseiTorisage().getTxtTorisageDate();
    }

    @JsonIgnore
    public void  setTxtTorisageDate(TextBoxDate txtTorisageDate) {
        this.getSinseiTorisage().setTxtTorisageDate(txtTorisageDate);
    }

    @JsonIgnore
    public TextBox getTxtTorisageJiyu() {
        return this.getSinseiTorisage().getTxtTorisageJiyu();
    }

    @JsonIgnore
    public void  setTxtTorisageJiyu(TextBox txtTorisageJiyu) {
        this.getSinseiTorisage().setTxtTorisageJiyu(txtTorisageJiyu);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChodsItakusakiAndChosainInput() {
        return this.getChosainAndChosainInput().getCcdChodsItakusakiAndChosainInput();
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getHomonSaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void  setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getHomonSaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getHomonSaki().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getHomonSaki().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getHomonSaki().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getHomonSaki().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getHomonSaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getHomonSaki().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getShisetsuJoho().getCcdShisetsuJoho();
    }

    // </editor-fold>
}
