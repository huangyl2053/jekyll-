package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * JutakuKaishuShinseiJyohoToroku のクラスファイル
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiJyohoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    private JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel;
    @JsonProperty("CommHeadPanel")
    private CommHeadPanelDiv CommHeadPanel;
    @JsonProperty("JutakuKaishuShinseiContents")
    private JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents;
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    private JutakuShikyuShinseiKanryoPanelDiv JutakuShikyuShinseiKanryoPanel;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutakuKaishuShinseiHihokenshaPanel
     * @return JutakuKaishuShinseiHihokenshaPanel
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    public JutakuKaishuShinseiHihokenshaPanelDiv getJutakuKaishuShinseiHihokenshaPanel() {
        return JutakuKaishuShinseiHihokenshaPanel;
    }

    /*
     * setJutakuKaishuShinseiHihokenshaPanel
     * @param JutakuKaishuShinseiHihokenshaPanel JutakuKaishuShinseiHihokenshaPanel
     */
    @JsonProperty("JutakuKaishuShinseiHihokenshaPanel")
    public void setJutakuKaishuShinseiHihokenshaPanel(JutakuKaishuShinseiHihokenshaPanelDiv JutakuKaishuShinseiHihokenshaPanel) {
        this.JutakuKaishuShinseiHihokenshaPanel = JutakuKaishuShinseiHihokenshaPanel;
    }

    /*
     * getCommHeadPanel
     * @return CommHeadPanel
     */
    @JsonProperty("CommHeadPanel")
    public CommHeadPanelDiv getCommHeadPanel() {
        return CommHeadPanel;
    }

    /*
     * setCommHeadPanel
     * @param CommHeadPanel CommHeadPanel
     */
    @JsonProperty("CommHeadPanel")
    public void setCommHeadPanel(CommHeadPanelDiv CommHeadPanel) {
        this.CommHeadPanel = CommHeadPanel;
    }

    /*
     * getJutakuKaishuShinseiContents
     * @return JutakuKaishuShinseiContents
     */
    @JsonProperty("JutakuKaishuShinseiContents")
    public JutakuKaishuShinseiContentsDiv getJutakuKaishuShinseiContents() {
        return JutakuKaishuShinseiContents;
    }

    /*
     * setJutakuKaishuShinseiContents
     * @param JutakuKaishuShinseiContents JutakuKaishuShinseiContents
     */
    @JsonProperty("JutakuKaishuShinseiContents")
    public void setJutakuKaishuShinseiContents(JutakuKaishuShinseiContentsDiv JutakuKaishuShinseiContents) {
        this.JutakuKaishuShinseiContents = JutakuKaishuShinseiContents;
    }

    /*
     * getJutakuShikyuShinseiKanryoPanel
     * @return JutakuShikyuShinseiKanryoPanel
     */
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    public JutakuShikyuShinseiKanryoPanelDiv getJutakuShikyuShinseiKanryoPanel() {
        return JutakuShikyuShinseiKanryoPanel;
    }

    /*
     * setJutakuShikyuShinseiKanryoPanel
     * @param JutakuShikyuShinseiKanryoPanel JutakuShikyuShinseiKanryoPanel
     */
    @JsonProperty("JutakuShikyuShinseiKanryoPanel")
    public void setJutakuShikyuShinseiKanryoPanel(JutakuShikyuShinseiKanryoPanelDiv JutakuShikyuShinseiKanryoPanel) {
        this.JutakuShikyuShinseiKanryoPanel = JutakuShikyuShinseiKanryoPanel;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getUpLine() {
        return this.getCommHeadPanel().getUpLine();
    }

    @JsonIgnore
    public void setUpLine(HorizontalLine UpLine) {
        this.getCommHeadPanel().setUpLine(UpLine);
    }

    @JsonIgnore
    public Button getBtnShinseiJyoho() {
        return this.getCommHeadPanel().getBtnShinseiJyoho();
    }

    @JsonIgnore
    public void setBtnShinseiJyoho(Button btnShinseiJyoho) {
        this.getCommHeadPanel().setBtnShinseiJyoho(btnShinseiJyoho);
    }

    @JsonIgnore
    public Button getBtnShokanKetteiJyoho() {
        return this.getCommHeadPanel().getBtnShokanKetteiJyoho();
    }

    @JsonIgnore
    public void setBtnShokanKetteiJyoho(Button btnShokanKetteiJyoho) {
        this.getCommHeadPanel().setBtnShokanKetteiJyoho(btnShokanKetteiJyoho);
    }

    @JsonIgnore
    public HorizontalLine getDownLine() {
        return this.getCommHeadPanel().getDownLine();
    }

    @JsonIgnore
    public void setDownLine(HorizontalLine DownLine) {
        this.getCommHeadPanel().setDownLine(DownLine);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoYM() {
        return this.getCommHeadPanel().getTxtTeikyoYM();
    }

    @JsonIgnore
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.getCommHeadPanel().setTxtTeikyoYM(txtTeikyoYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtSeiriNo() {
        return this.getCommHeadPanel().getTxtSeiriNo();
    }

    @JsonIgnore
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.getCommHeadPanel().setTxtSeiriNo(txtSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlSyomeisyo() {
        return this.getCommHeadPanel().getDdlSyomeisyo();
    }

    @JsonIgnore
    public void setDdlSyomeisyo(DropDownList ddlSyomeisyo) {
        this.getCommHeadPanel().setDdlSyomeisyo(ddlSyomeisyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getCommHeadPanel().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getCommHeadPanel().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public Space getTemp1Space() {
        return this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getTemp1Space();
    }

    @JsonIgnore
    public void setTemp1Space(Space temp1Space) {
        this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setTemp1Space(temp1Space);
    }

    @JsonIgnore
    public Label getLblShinseiNaiyoyo() {
        return this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getLblShinseiNaiyoyo();
    }

    @JsonIgnore
    public void setLblShinseiNaiyoyo(Label lblShinseiNaiyoyo) {
        this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setLblShinseiNaiyoyo(lblShinseiNaiyoyo);
    }

    @JsonIgnore
    public RadioButton getRadShinseiNaiyoyo() {
        return this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo();
    }

    @JsonIgnore
    public void setRadShinseiNaiyoyo(RadioButton radShinseiNaiyoyo) {
        this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setRadShinseiNaiyoyo(radShinseiNaiyoyo);
    }

    @JsonIgnore
    public Space getTemp2Space() {
        return this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getTemp2Space();
    }

    @JsonIgnore
    public void setTemp2Space(Space temp2Space) {
        this.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setTemp2Space(temp2Space);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShinseishaKubun() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun();
    }

    @JsonIgnore
    public void setDdlShinseishaKubun(DropDownList ddlShinseishaKubun) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setDdlShinseishaKubun(ddlShinseishaKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyoshaNo() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyosha() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getBtnJigyosha();
    }

    @JsonIgnore
    public void setBtnJigyosha(ButtonDialog btnJigyosha) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setBtnJigyosha(btnJigyosha);
    }

    @JsonIgnore
    public Button getBtnHonninJohoCopy() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getBtnHonninJohoCopy();
    }

    @JsonIgnore
    public void setBtnHonninJohoCopy(Button btnHonninJohoCopy) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setBtnHonninJohoCopy(btnHonninJohoCopy);
    }

    @JsonIgnore
    public TextBox getTxtShinseishaNameKana() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana();
    }

    @JsonIgnore
    public void setTxtShinseishaNameKana(TextBox txtShinseishaNameKana) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtShinseishaNameKana(txtShinseishaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtShinseishaName() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName();
    }

    @JsonIgnore
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtShinseishaName(txtShinseishaName);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlShinseiTorikesuJiyu() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu();
    }

    @JsonIgnore
    public void setDdlShinseiTorikesuJiyu(DropDownList ddlShinseiTorikesuJiyu) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setDdlShinseiTorikesuJiyu(ddlShinseiTorikesuJiyu);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtAddress() {
        return this.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress();
    }

    @JsonIgnore
    public void setTxtAddress(TextBoxJusho txtAddress) {
        this.getJutakuKaishuShinseiContents().getShinseishaInfo().setTxtAddress(txtAddress);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJyoho() {
        return this.getJutakuKaishuShinseiContents().getShiharaiHohoJyohoPanle().getCcdShiharaiHohoJyoho();
    }

    // </editor-fold>
}
