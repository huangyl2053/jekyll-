package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.IKyufugakuSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiPnlTotal のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class YoguKonyuhiShikyuShinseiPnlTotalDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoCommonPanel")
    private KaigoCommonPanelDiv KaigoCommonPanel;
    @JsonProperty("PnlButton")
    private PnlButtonDiv PnlButton;
    @JsonProperty("YoguKonyuhiShikyuShinseiContentsPanel")
    private YoguKonyuhiShikyuShinseiContentsPanelDiv YoguKonyuhiShikyuShinseiContentsPanel;
    @JsonProperty("PnlKeteiJohoMsg")
    private PnlKeteiJohoMsgDiv PnlKeteiJohoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoCommonPanel
     * @return KaigoCommonPanel
     */
    @JsonProperty("KaigoCommonPanel")
    public KaigoCommonPanelDiv getKaigoCommonPanel() {
        return KaigoCommonPanel;
    }

    /*
     * setKaigoCommonPanel
     * @param KaigoCommonPanel KaigoCommonPanel
     */
    @JsonProperty("KaigoCommonPanel")
    public void setKaigoCommonPanel(KaigoCommonPanelDiv KaigoCommonPanel) {
        this.KaigoCommonPanel = KaigoCommonPanel;
    }

    /*
     * getPnlButton
     * @return PnlButton
     */
    @JsonProperty("PnlButton")
    public PnlButtonDiv getPnlButton() {
        return PnlButton;
    }

    /*
     * setPnlButton
     * @param PnlButton PnlButton
     */
    @JsonProperty("PnlButton")
    public void setPnlButton(PnlButtonDiv PnlButton) {
        this.PnlButton = PnlButton;
    }

    /*
     * getYoguKonyuhiShikyuShinseiContentsPanel
     * @return YoguKonyuhiShikyuShinseiContentsPanel
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiContentsPanel")
    public YoguKonyuhiShikyuShinseiContentsPanelDiv getYoguKonyuhiShikyuShinseiContentsPanel() {
        return YoguKonyuhiShikyuShinseiContentsPanel;
    }

    /*
     * setYoguKonyuhiShikyuShinseiContentsPanel
     * @param YoguKonyuhiShikyuShinseiContentsPanel YoguKonyuhiShikyuShinseiContentsPanel
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiContentsPanel")
    public void setYoguKonyuhiShikyuShinseiContentsPanel(YoguKonyuhiShikyuShinseiContentsPanelDiv YoguKonyuhiShikyuShinseiContentsPanel) {
        this.YoguKonyuhiShikyuShinseiContentsPanel = YoguKonyuhiShikyuShinseiContentsPanel;
    }

    /*
     * getPnlKeteiJohoMsg
     * @return PnlKeteiJohoMsg
     */
    @JsonProperty("PnlKeteiJohoMsg")
    public PnlKeteiJohoMsgDiv getPnlKeteiJohoMsg() {
        return PnlKeteiJohoMsg;
    }

    /*
     * setPnlKeteiJohoMsg
     * @param PnlKeteiJohoMsg PnlKeteiJohoMsg
     */
    @JsonProperty("PnlKeteiJohoMsg")
    public void setPnlKeteiJohoMsg(PnlKeteiJohoMsgDiv PnlKeteiJohoMsg) {
        this.PnlKeteiJohoMsg = PnlKeteiJohoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKyufugakuSummaryDiv getCcdKyufuGakuSummay() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getCcdKyufuGakuSummay();
    }

    @JsonIgnore
    public Label getLblShinseinaiyo() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().getLblShinseinaiyo();
    }

    @JsonIgnore
    public void setLblShinseinaiyo(Label lblShinseinaiyo) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setLblShinseinaiyo(lblShinseinaiyo);
    }

    @JsonIgnore
    public RadioButton getRadShinsakekka() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().getRadShinsakekka();
    }

    @JsonIgnore
    public void setRadShinsakekka(RadioButton radShinsakekka) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setRadShinsakekka(radShinsakekka);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseibi() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi();
    }

    @JsonIgnore
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShinseibi(txtShinseibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtUkechikebi() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi();
    }

    @JsonIgnore
    public void setTxtUkechikebi(TextBoxDate txtUkechikebi) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtUkechikebi(txtUkechikebi);
    }

    @JsonIgnore
    public TextBoxDate getTxtRyosyuYMD() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD();
    }

    @JsonIgnore
    public void setTxtRyosyuYMD(TextBoxDate txtRyosyuYMD) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtRyosyuYMD(txtRyosyuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShinseisyakubun() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun();
    }

    @JsonIgnore
    public void setDdlShinseisyakubun(DropDownList ddlShinseisyakubun) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setDdlShinseisyakubun(ddlShinseisyakubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiriyu() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu();
    }

    @JsonIgnore
    public void setTxtShinseiriyu(TextBoxMultiLine txtShinseiriyu) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShinseiriyu(txtShinseiriyu);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyosya() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya();
    }

    @JsonIgnore
    public void setTxtJigyosya(TextBoxCode txtJigyosya) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtJigyosya(txtJigyosya);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyosya() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getBtnJigyosya();
    }

    @JsonIgnore
    public void setBtnJigyosya(ButtonDialog btnJigyosya) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setBtnJigyosya(btnJigyosya);
    }

    @JsonIgnore
    public Button getBtnHonninJohoCopy() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getBtnHonninJohoCopy();
    }

    @JsonIgnore
    public void setBtnHonninJohoCopy(Button btnHonninJohoCopy) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setBtnHonninJohoCopy(btnHonninJohoCopy);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei();
    }

    @JsonIgnore
    public void setTxtShimei(TextBox txtShimei) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBoxKana getTxtShimeiKana() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana();
    }

    @JsonIgnore
    public void setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShinseisyaTel() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel();
    }

    @JsonIgnore
    public void setTxtShinseisyaTel(TextBoxTelNo txtShinseisyaTel) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShinseisyaTel(txtShinseisyaTel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShinseisyaYubin() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin();
    }

    @JsonIgnore
    public void setTxtShinseisyaYubin(TextBoxYubinNo txtShinseisyaYubin) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShinseisyaYubin(txtShinseisyaYubin);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShinseisyaJyusyo() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaJyusyo();
    }

    @JsonIgnore
    public void setTxtShinseisyaJyusyo(TextBoxJusho txtShinseisyaJyusyo) {
        this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().setTxtShinseisyaJyusyo(txtShinseisyaJyusyo);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoInfo() {
        return this.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShiharaiHoho().getCcdShiharaiHohoInfo();
    }

    // </editor-fold>
}
