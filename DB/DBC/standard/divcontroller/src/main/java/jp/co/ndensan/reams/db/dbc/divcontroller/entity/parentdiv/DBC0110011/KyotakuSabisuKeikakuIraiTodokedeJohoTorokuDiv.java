package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

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
    @JsonProperty("Rireki")
    private RirekiDiv Rireki;
    @JsonProperty("ServiceAddAndServicePlanCreate")
    private ServiceAddAndServicePlanCreateDiv ServiceAddAndServicePlanCreate;
    @JsonProperty("Kanryo")
    private KanryoDiv Kanryo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
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
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
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
    public RadioButton getRadTodokedeKubun() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getRadTodokedeKubun();
    }

    @JsonIgnore
    public void setRadTodokedeKubun(RadioButton radTodokedeKubun) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setRadTodokedeKubun(radTodokedeKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYM() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTxtTodokedeYM();
    }

    @JsonIgnore
    public void setTxtTodokedeYM(TextBoxDate txtTodokedeYM) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTxtTodokedeYM(txtTodokedeYM);
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

//    @JsonIgnore
//    public TodokedeshaDiv getTodokedesha() {
//        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha();
//    }
//
//    @JsonIgnore
//    public void setTodokedesha(TodokedeshaDiv Todokedesha) {
//        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().setTodokedesha(Todokedesha);
//    }
    @JsonIgnore
    public TextBoxAtenaMeisho getTxtTodokedeshaShimei() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().getTxtTodokedeshaShimei();
    }

    @JsonIgnore
    public void setTxtTodokedeshaShimei(TextBoxAtenaMeisho txtTodokedeshaShimei) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().setTxtTodokedeshaShimei(txtTodokedeshaShimei);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtTodokedeshaShimeiKana() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().getTxtTodokedeshaShimeiKana();
    }

    @JsonIgnore
    public void setTxtTodokedeshaShimeiKana(TextBoxAtenaKanaMeisho txtTodokedeshaShimeiKana) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().setTxtTodokedeshaShimeiKana(txtTodokedeshaShimeiKana);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtTodokedeshaYubinNo() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().getTxtTodokedeshaYubinNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaYubinNo(TextBoxYubinNo txtTodokedeshaYubinNo) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().setTxtTodokedeshaYubinNo(txtTodokedeshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaJusho() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().getTxtTodokedeshaJusho();
    }

    @JsonIgnore
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().setTxtTodokedeshaJusho(txtTodokedeshaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTodokedeshaTelNo() {
        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().getTxtTodokedeshaTelNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaTelNo(TextBoxTelNo txtTodokedeshaTelNo) {
        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().setTxtTodokedeshaTelNo(txtTodokedeshaTelNo);
    }

//    @JsonIgnore
//    public DropDownList getDdlTodokedeshaKankeiKubun() {
//        return this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().getDdlTodokedeshaKankeiKubun();
//    }
//
//    @JsonIgnore
//    public void setDdlTodokedeshaKankeiKubun(DropDownList ddlTodokedeshaKankeiKubun) {
//        this.getServiceAddAndServicePlanCreate().getTodokedeshaJoho().getTodokedesha().setDdlTodokedeshaKankeiKubun(ddlTodokedeshaKankeiKubun);
//    }
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
    public TextBoxYubinNo getTxtJigyoshaYubinNo() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaYubinNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaYubinNo(TextBoxYubinNo txtJigyoshaYubinNo) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaYubinNo(txtJigyoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaJusho() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaJusho();
    }

    @JsonIgnore
    public void setTxtJigyoshaJusho(TextBox txtJigyoshaJusho) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaJusho(txtJigyoshaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJigyoshaTelNo() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaTelNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaTelNo(TextBoxTelNo txtJigyoshaTelNo) {
        this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setTxtJigyoshaTelNo(txtJigyoshaTelNo);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtJigyoshaKanrishaName() {
        return this.getServiceAddAndServicePlanCreate().getJigyoshaJoho().getTxtJigyoshaKanrishaName();
    }

    @JsonIgnore
    public void setTxtJigyoshaKanrishaName(TextBoxAtenaMeisho txtJigyoshaKanrishaName) {
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
