package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * JutakuKaishuShinseiContents のクラスファイル
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiContentsDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShowJizenShinsei")
    private ButtonDialog btnShowJizenShinsei;
    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("txtRyoshuYMD")
    private TextBoxDate txtRyoshuYMD;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("chkKokubo")
    private CheckBoxList chkKokubo;
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    private JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo;
    @JsonProperty("shinsaKekkaPanel")
    private shinsaKekkaPanelDiv shinsaKekkaPanel;
    @JsonProperty("ShinseishaInfo")
    private ShinseishaInfoDiv ShinseishaInfo;
    @JsonProperty("JutakuKaishuShinseiReason")
    private JutakuKaishuShinseiReasonDiv JutakuKaishuShinseiReason;
    @JsonProperty("shiharaiHohoJyohoPanle")
    private shiharaiHohoJyohoPanleDiv shiharaiHohoJyohoPanle;
    @JsonProperty("ccdJutakugaisyunaiyoList")
    private JyutakugaisyunaiyoListDiv ccdJutakugaisyunaiyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShowJizenShinsei
     * @return btnShowJizenShinsei
     */
    @JsonProperty("btnShowJizenShinsei")
    public ButtonDialog getBtnShowJizenShinsei() {
        return btnShowJizenShinsei;
    }

    /*
     * setbtnShowJizenShinsei
     * @param btnShowJizenShinsei btnShowJizenShinsei
     */
    @JsonProperty("btnShowJizenShinsei")
    public void setBtnShowJizenShinsei(ButtonDialog btnShowJizenShinsei) {
        this.btnShowJizenShinsei = btnShowJizenShinsei;
    }

    /*
     * gettxtJutakuOwner
     * @return txtJutakuOwner
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    /*
     * settxtJutakuOwner
     * @param txtJutakuOwner txtJutakuOwner
     */
    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner = txtJutakuOwner;
    }

    /*
     * gettxtRelationWithHihokensha
     * @return txtRelationWithHihokensha
     */
    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    /*
     * settxtRelationWithHihokensha
     * @param txtRelationWithHihokensha txtRelationWithHihokensha
     */
    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha = txtRelationWithHihokensha;
    }

    /*
     * gettxtRyoshuYMD
     * @return txtRyoshuYMD
     */
    @JsonProperty("txtRyoshuYMD")
    public TextBoxDate getTxtRyoshuYMD() {
        return txtRyoshuYMD;
    }

    /*
     * settxtRyoshuYMD
     * @param txtRyoshuYMD txtRyoshuYMD
     */
    @JsonProperty("txtRyoshuYMD")
    public void setTxtRyoshuYMD(TextBoxDate txtRyoshuYMD) {
        this.txtRyoshuYMD = txtRyoshuYMD;
    }

    /*
     * getddlHokensha
     * @return ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    /*
     * setddlHokensha
     * @param ddlHokensha ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha = ddlHokensha;
    }

    /*
     * getchkKokubo
     * @return chkKokubo
     */
    @JsonProperty("chkKokubo")
    public CheckBoxList getChkKokubo() {
        return chkKokubo;
    }

    /*
     * setchkKokubo
     * @param chkKokubo chkKokubo
     */
    @JsonProperty("chkKokubo")
    public void setChkKokubo(CheckBoxList chkKokubo) {
        this.chkKokubo = chkKokubo;
    }

    /*
     * getJutakuKaishuShinseiResetInfo
     * @return JutakuKaishuShinseiResetInfo
     */
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return JutakuKaishuShinseiResetInfo;
    }

    /*
     * setJutakuKaishuShinseiResetInfo
     * @param JutakuKaishuShinseiResetInfo JutakuKaishuShinseiResetInfo
     */
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.JutakuKaishuShinseiResetInfo = JutakuKaishuShinseiResetInfo;
    }

    /*
     * getshinsaKekkaPanel
     * @return shinsaKekkaPanel
     */
    @JsonProperty("shinsaKekkaPanel")
    public shinsaKekkaPanelDiv getShinsaKekkaPanel() {
        return shinsaKekkaPanel;
    }

    /*
     * setshinsaKekkaPanel
     * @param shinsaKekkaPanel shinsaKekkaPanel
     */
    @JsonProperty("shinsaKekkaPanel")
    public void setShinsaKekkaPanel(shinsaKekkaPanelDiv shinsaKekkaPanel) {
        this.shinsaKekkaPanel = shinsaKekkaPanel;
    }

    /*
     * getShinseishaInfo
     * @return ShinseishaInfo
     */
    @JsonProperty("ShinseishaInfo")
    public ShinseishaInfoDiv getShinseishaInfo() {
        return ShinseishaInfo;
    }

    /*
     * setShinseishaInfo
     * @param ShinseishaInfo ShinseishaInfo
     */
    @JsonProperty("ShinseishaInfo")
    public void setShinseishaInfo(ShinseishaInfoDiv ShinseishaInfo) {
        this.ShinseishaInfo = ShinseishaInfo;
    }

    /*
     * getJutakuKaishuShinseiReason
     * @return JutakuKaishuShinseiReason
     */
    @JsonProperty("JutakuKaishuShinseiReason")
    public JutakuKaishuShinseiReasonDiv getJutakuKaishuShinseiReason() {
        return JutakuKaishuShinseiReason;
    }

    /*
     * setJutakuKaishuShinseiReason
     * @param JutakuKaishuShinseiReason JutakuKaishuShinseiReason
     */
    @JsonProperty("JutakuKaishuShinseiReason")
    public void setJutakuKaishuShinseiReason(JutakuKaishuShinseiReasonDiv JutakuKaishuShinseiReason) {
        this.JutakuKaishuShinseiReason = JutakuKaishuShinseiReason;
    }

    /*
     * getshiharaiHohoJyohoPanle
     * @return shiharaiHohoJyohoPanle
     */
    @JsonProperty("shiharaiHohoJyohoPanle")
    public shiharaiHohoJyohoPanleDiv getShiharaiHohoJyohoPanle() {
        return shiharaiHohoJyohoPanle;
    }

    /*
     * setshiharaiHohoJyohoPanle
     * @param shiharaiHohoJyohoPanle shiharaiHohoJyohoPanle
     */
    @JsonProperty("shiharaiHohoJyohoPanle")
    public void setShiharaiHohoJyohoPanle(shiharaiHohoJyohoPanleDiv shiharaiHohoJyohoPanle) {
        this.shiharaiHohoJyohoPanle = shiharaiHohoJyohoPanle;
    }

    /*
     * getccdJutakugaisyunaiyoList
     * @return ccdJutakugaisyunaiyoList
     */
    @JsonProperty("ccdJutakugaisyunaiyoList")
    public IJyutakugaisyunaiyoListDiv getCcdJutakugaisyunaiyoList() {
        return ccdJutakugaisyunaiyoList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getTemp1Space() {
        return this.getShinsaKekkaPanel().getTemp1Space();
    }

    @JsonIgnore
    public void setTemp1Space(Space temp1Space) {
        this.getShinsaKekkaPanel().setTemp1Space(temp1Space);
    }

    @JsonIgnore
    public Label getLblShinseiNaiyoyo() {
        return this.getShinsaKekkaPanel().getLblShinseiNaiyoyo();
    }

    @JsonIgnore
    public void setLblShinseiNaiyoyo(Label lblShinseiNaiyoyo) {
        this.getShinsaKekkaPanel().setLblShinseiNaiyoyo(lblShinseiNaiyoyo);
    }

    @JsonIgnore
    public RadioButton getRadShinseiNaiyoyo() {
        return this.getShinsaKekkaPanel().getRadShinseiNaiyoyo();
    }

    @JsonIgnore
    public void setRadShinseiNaiyoyo(RadioButton radShinseiNaiyoyo) {
        this.getShinsaKekkaPanel().setRadShinseiNaiyoyo(radShinseiNaiyoyo);
    }

    @JsonIgnore
    public Space getTemp2Space() {
        return this.getShinsaKekkaPanel().getTemp2Space();
    }

    @JsonIgnore
    public void setTemp2Space(Space temp2Space) {
        this.getShinsaKekkaPanel().setTemp2Space(temp2Space);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getShinseishaInfo().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getShinseishaInfo().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShinseishaKubun() {
        return this.getShinseishaInfo().getDdlShinseishaKubun();
    }

    @JsonIgnore
    public void setDdlShinseishaKubun(DropDownList ddlShinseishaKubun) {
        this.getShinseishaInfo().setDdlShinseishaKubun(ddlShinseishaKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShinseishaInfo().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShinseishaInfo().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyoshaNo() {
        return this.getShinseishaInfo().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.getShinseishaInfo().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyosha() {
        return this.getShinseishaInfo().getBtnJigyosha();
    }

    @JsonIgnore
    public void setBtnJigyosha(ButtonDialog btnJigyosha) {
        this.getShinseishaInfo().setBtnJigyosha(btnJigyosha);
    }

    @JsonIgnore
    public Button getBtnHonninJohoCopy() {
        return this.getShinseishaInfo().getBtnHonninJohoCopy();
    }

    @JsonIgnore
    public void setBtnHonninJohoCopy(Button btnHonninJohoCopy) {
        this.getShinseishaInfo().setBtnHonninJohoCopy(btnHonninJohoCopy);
    }

    @JsonIgnore
    public TextBox getTxtShinseishaNameKana() {
        return this.getShinseishaInfo().getTxtShinseishaNameKana();
    }

    @JsonIgnore
    public void setTxtShinseishaNameKana(TextBox txtShinseishaNameKana) {
        this.getShinseishaInfo().setTxtShinseishaNameKana(txtShinseishaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtShinseishaName() {
        return this.getShinseishaInfo().getTxtShinseishaName();
    }

    @JsonIgnore
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.getShinseishaInfo().setTxtShinseishaName(txtShinseishaName);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getShinseishaInfo().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getShinseishaInfo().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlShinseiTorikesuJiyu() {
        return this.getShinseishaInfo().getDdlShinseiTorikesuJiyu();
    }

    @JsonIgnore
    public void setDdlShinseiTorikesuJiyu(DropDownList ddlShinseiTorikesuJiyu) {
        this.getShinseishaInfo().setDdlShinseiTorikesuJiyu(ddlShinseiTorikesuJiyu);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getShinseishaInfo().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getShinseishaInfo().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtAddress() {
        return this.getShinseishaInfo().getTxtAddress();
    }

    @JsonIgnore
    public void setTxtAddress(TextBoxJusho txtAddress) {
        this.getShinseishaInfo().setTxtAddress(txtAddress);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getShiharaiHohoJyohoPanle().getCcdShiharaiHohoJyoho();
    }

    // </editor-fold>
}
