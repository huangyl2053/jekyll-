package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * KyotakuSabisuKeikakuIraiTodokedeJohoToroku のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("Rireki")
    private RirekiDiv Rireki;
    @JsonProperty("ServiceAddAndServicePlanCreate")
    private ServiceAddAndServicePlanCreateDiv ServiceAddAndServicePlanCreate;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("keikakuTekiyoStartYM")
    private RString keikakuTekiyoStartYM;
    @JsonProperty("serviceShurui")
    private RString serviceShurui;
    @JsonProperty("jigyoshaMode")
    private RString jigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getRireki
     * @return Rireki
     */
    @JsonProperty("Rireki")
    public RirekiDiv getRireki() {
        return Rireki;
    }

    /*
     * setRireki
     * @param Rireki Rireki
     */
    @JsonProperty("Rireki")
    public void setRireki(RirekiDiv Rireki) {
        this.Rireki = Rireki;
    }

    /*
     * getServiceAddAndServicePlanCreate
     * @return ServiceAddAndServicePlanCreate
     */
    @JsonProperty("ServiceAddAndServicePlanCreate")
    public ServiceAddAndServicePlanCreateDiv getServiceAddAndServicePlanCreate() {
        return ServiceAddAndServicePlanCreate;
    }

    /*
     * setServiceAddAndServicePlanCreate
     * @param ServiceAddAndServicePlanCreate ServiceAddAndServicePlanCreate
     */
    @JsonProperty("ServiceAddAndServicePlanCreate")
    public void setServiceAddAndServicePlanCreate(ServiceAddAndServicePlanCreateDiv ServiceAddAndServicePlanCreate) {
        this.ServiceAddAndServicePlanCreate = ServiceAddAndServicePlanCreate;
    }

    /*
     * getKanryo
     * @return Kanryo
     */
    @JsonProperty("Kanryo")
    public KanryoDiv getKanryo() {
        return Kanryo;
    }

    /*
     * setKanryo
     * @param Kanryo Kanryo
     */
    @JsonProperty("Kanryo")
    public void setKanryo(KanryoDiv Kanryo) {
        this.Kanryo = Kanryo;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * getkeikakuTekiyoStartYM
     * @return keikakuTekiyoStartYM
     */
    @JsonProperty("keikakuTekiyoStartYM")
    public RString getKeikakuTekiyoStartYM() {
        return keikakuTekiyoStartYM;
    }

    /*
     * setkeikakuTekiyoStartYM
     * @param keikakuTekiyoStartYM keikakuTekiyoStartYM
     */
    @JsonProperty("keikakuTekiyoStartYM")
    public void setKeikakuTekiyoStartYM(RString keikakuTekiyoStartYM) {
        this.keikakuTekiyoStartYM = keikakuTekiyoStartYM;
    }

    /*
     * getserviceShurui
     * @return serviceShurui
     */
    @JsonProperty("serviceShurui")
    public RString getServiceShurui() {
        return serviceShurui;
    }

    /*
     * setserviceShurui
     * @param serviceShurui serviceShurui
     */
    @JsonProperty("serviceShurui")
    public void setServiceShurui(RString serviceShurui) {
        this.serviceShurui = serviceShurui;
    }

    /*
     * getjigyoshaMode
     * @return jigyoshaMode
     */
    @JsonProperty("jigyoshaMode")
    public RString getJigyoshaMode() {
        return jigyoshaMode;
    }

    /*
     * setjigyoshaMode
     * @param jigyoshaMode jigyoshaMode
     */
    @JsonProperty("jigyoshaMode")
    public void setJigyoshaMode(RString jigyoshaMode) {
        this.jigyoshaMode = jigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTorokuState() {
        return this.getServiceAddAndServicePlanCreate().getShinkiToroku().getTxtTorokuState();
    }

    @JsonIgnore
    public void setTxtTorokuState(TextBox txtTorokuState) {
        this.getServiceAddAndServicePlanCreate().getShinkiToroku().setTxtTorokuState(txtTorokuState);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiShinki() {
        return this.getServiceAddAndServicePlanCreate().getShinkiToroku().getTxtNinteiShinseiShinki();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiShinki(TextBox txtNinteiShinseiShinki) {
        this.getServiceAddAndServicePlanCreate().getShinkiToroku().setTxtNinteiShinseiShinki(txtNinteiShinseiShinki);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiSaishinsei() {
        return this.getServiceAddAndServicePlanCreate().getShinkiToroku().getTxtNinteiShinseiSaishinsei();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiSaishinsei(TextBox txtNinteiShinseiSaishinsei) {
        this.getServiceAddAndServicePlanCreate().getShinkiToroku().setTxtNinteiShinseiSaishinsei(txtNinteiShinseiSaishinsei);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiHenkoShinsei() {
        return this.getServiceAddAndServicePlanCreate().getShinkiToroku().getTxtNinteiShinseiHenkoShinsei();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiHenkoShinsei(TextBox txtNinteiShinseiHenkoShinsei) {
        this.getServiceAddAndServicePlanCreate().getShinkiToroku().setTxtNinteiShinseiHenkoShinsei(txtNinteiShinseiHenkoShinsei);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiServiceHenko() {
        return this.getServiceAddAndServicePlanCreate().getShinkiToroku().getTxtNinteiShinseiServiceHenko();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiServiceHenko(TextBox txtNinteiShinseiServiceHenko) {
        this.getServiceAddAndServicePlanCreate().getShinkiToroku().setTxtNinteiShinseiServiceHenko(txtNinteiShinseiServiceHenko);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setLin1(lin1);
    }

    @JsonIgnore
    public RadioButton getRadKeikakuKubun() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getRadKeikakuKubun();
    }

    @JsonIgnore
    public void setRadKeikakuKubun(RadioButton radKeikakuKubun) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setRadKeikakuKubun(radKeikakuKubun);
    }

    @JsonIgnore
    public RadioButton getRadTodokedeKubun() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getRadTodokedeKubun();
    }

    @JsonIgnore
    public void setRadTodokedeKubun(RadioButton radTodokedeKubun) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setRadTodokedeKubun(radTodokedeKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYMD() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeYMD();
    }

    @JsonIgnore
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeYMD(txtTodokedeYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeikakuTekiyoStartYMD() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtKeikakuTekiyoStartYMD();
    }

    @JsonIgnore
    public void setTxtKeikakuTekiyoStartYMD(TextBoxDate txtKeikakuTekiyoStartYMD) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtKeikakuTekiyoStartYMD(txtKeikakuTekiyoStartYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeikakuTekiyoEndYMD() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtKeikakuTekiyoEndYMD();
    }

    @JsonIgnore
    public void setTxtKeikakuTekiyoEndYMD(TextBoxDate txtKeikakuTekiyoEndYMD) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtKeikakuTekiyoEndYMD(txtKeikakuTekiyoEndYMD);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaName() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeshaName();
    }

    @JsonIgnore
    public void setTxtTodokedeshaName(TextBox txtTodokedeshaName) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeshaName(txtTodokedeshaName);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaNameKana() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeshaNameKana();
    }

    @JsonIgnore
    public void setTxtTodokedeshaNameKana(TextBox txtTodokedeshaNameKana) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeshaNameKana(txtTodokedeshaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaYubinNo() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeshaYubinNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaYubinNo(TextBox txtTodokedeshaYubinNo) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeshaYubinNo(txtTodokedeshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaJusho() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeshaJusho();
    }

    @JsonIgnore
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeshaJusho(txtTodokedeshaJusho);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaTelNo() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeshaTelNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaTelNo(TextBox txtTodokedeshaTelNo) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeshaTelNo(txtTodokedeshaTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlTodokedeshaKankeiKubun() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getDdlTodokedeshaKankeiKubun();
    }

    @JsonIgnore
    public void setDdlTodokedeshaKankeiKubun(DropDownList ddlTodokedeshaKankeiKubun) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setDdlTodokedeshaKankeiKubun(ddlTodokedeshaKankeiKubun);
    }

    @JsonIgnore
    public RadioButton getRadKeikakuSakuseiKubun() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getRadKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void setRadKeikakuSakuseiKubun(RadioButton radKeikakuSakuseiKubun) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setRadKeikakuSakuseiKubun(radKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setLin2(lin2);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaNo() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaNo(TextBox txtJigyoshaNo) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyoshaKensaku() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getBtnJigyoshaKensaku();
    }

    @JsonIgnore
    public void setBtnJigyoshaKensaku(ButtonDialog btnJigyoshaKensaku) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setBtnJigyoshaKensaku(btnJigyoshaKensaku);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public RadioButton getRadServiceShurui() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getRadServiceShurui();
    }

    @JsonIgnore
    public void setRadServiceShurui(RadioButton radServiceShurui) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setRadServiceShurui(radServiceShurui);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaYubinNo() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaYubinNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaYubinNo(TextBox txtJigyoshaYubinNo) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaYubinNo(txtJigyoshaYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJigyoshaJusho() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaJusho();
    }

    @JsonIgnore
    public void setTxtJigyoshaJusho(TextBoxMultiLine txtJigyoshaJusho) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaJusho(txtJigyoshaJusho);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaTelNo() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaTelNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaTelNo(TextBox txtJigyoshaTelNo) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaTelNo(txtJigyoshaTelNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaKanrishaName() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaKanrishaName();
    }

    @JsonIgnore
    public void setTxtJigyoshaKanrishaName(TextBox txtJigyoshaKanrishaName) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaKanrishaName(txtJigyoshaKanrishaName);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaNo() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtItakusakiJigyoshaNo();
    }

    @JsonIgnore
    public void setTxtItakusakiJigyoshaNo(TextBox txtItakusakiJigyoshaNo) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtItakusakiJigyoshaNo(txtItakusakiJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnItakuSakiJigyoshaKensaku() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getBtnItakuSakiJigyoshaKensaku();
    }

    @JsonIgnore
    public void setBtnItakuSakiJigyoshaKensaku(ButtonDialog btnItakuSakiJigyoshaKensaku) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setBtnItakuSakiJigyoshaKensaku(btnItakuSakiJigyoshaKensaku);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaName() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtItakusakiJigyoshaName();
    }

    @JsonIgnore
    public void setTxtItakusakiJigyoshaName(TextBox txtItakusakiJigyoshaName) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtItakusakiJigyoshaName(txtItakusakiJigyoshaName);
    }

    @JsonIgnore
    public Label getLblJigyoshaDescription() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getLblJigyoshaDescription();
    }

    @JsonIgnore
    public void setLblJigyoshaDescription(Label lblJigyoshaDescription) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setLblJigyoshaDescription(lblJigyoshaDescription);
    }

    @JsonIgnore
    public TextBoxDate getTxtJigyoshaHenkoYMD() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaHenkoYMD();
    }

    @JsonIgnore
    public void setTxtJigyoshaHenkoYMD(TextBoxDate txtJigyoshaHenkoYMD) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaHenkoYMD(txtJigyoshaHenkoYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJigyoshaHenkoJiyu() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaHenkoJiyu();
    }

    @JsonIgnore
    public void setTxtJigyoshaHenkoJiyu(TextBoxMultiLine txtJigyoshaHenkoJiyu) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaHenkoJiyu(txtJigyoshaHenkoJiyu);
    }

    // </editor-fold>
}
