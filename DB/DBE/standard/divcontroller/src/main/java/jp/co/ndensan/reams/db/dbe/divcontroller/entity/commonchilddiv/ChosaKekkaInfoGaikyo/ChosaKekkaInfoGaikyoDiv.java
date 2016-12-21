package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaKekkaInfoGaikyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaKekkaInfoGaikyoDiv extends Panel implements IChosaKekkaInfoGaikyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    private TextBoxDate txtNinteichosaJisshiYMD;
    @JsonProperty("lblJisshiBasho")
    private Label lblJisshiBasho;
    @JsonProperty("txtChosaJisshiBashoCode")
    private TextBox txtChosaJisshiBashoCode;
    @JsonProperty("txtChosaJisshiBashoMeisho")
    private TextBox txtChosaJisshiBashoMeisho;
    @JsonProperty("JisshiBashoMeishoPanel")
    private JisshiBashoMeishoPanelDiv JisshiBashoMeishoPanel;
    @JsonProperty("GaikyoChosaTokkiPanel")
    private GaikyoChosaTokkiPanelDiv GaikyoChosaTokkiPanel;
    @JsonProperty("radServiceKubun")
    private RadioButton radServiceKubun;
    @JsonProperty("rdoJutakuKaishu")
    private RadioButton rdoJutakuKaishu;
    @JsonProperty("ServiceJokyoPanel")
    private ServiceJokyoPanelDiv ServiceJokyoPanel;
    @JsonProperty("ShisetsuRiyoPanel")
    private ShisetsuRiyoPanelDiv ShisetsuRiyoPanel;
    @JsonProperty("TokubetsuKyufuPanel")
    private TokubetsuKyufuPanelDiv TokubetsuKyufuPanel;
    @JsonProperty("ZaitakuServicePanel")
    private ZaitakuServicePanelDiv ZaitakuServicePanel;
    @JsonProperty("GaikyoTokkiPanel")
    private GaikyoTokkiPanelDiv GaikyoTokkiPanel;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("ninteichosaRirekiNo")
    private RString ninteichosaRirekiNo;
    @JsonProperty("genponText")
    private RString genponText;
    @JsonProperty("maskText")
    private RString maskText;
    @JsonProperty("genponImage")
    private RString genponImage;
    @JsonProperty("maskImage")
    private RString maskImage;
    @JsonProperty("hdnTextImageKubun")
    private RString hdnTextImageKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteichosaJisshiYMD
     * @return txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public TextBoxDate getTxtNinteichosaJisshiYMD() {
        return txtNinteichosaJisshiYMD;
    }

    /*
     * settxtNinteichosaJisshiYMD
     * @param txtNinteichosaJisshiYMD txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public void setTxtNinteichosaJisshiYMD(TextBoxDate txtNinteichosaJisshiYMD) {
        this.txtNinteichosaJisshiYMD = txtNinteichosaJisshiYMD;
    }

    /*
     * getlblJisshiBasho
     * @return lblJisshiBasho
     */
    @JsonProperty("lblJisshiBasho")
    public Label getLblJisshiBasho() {
        return lblJisshiBasho;
    }

    /*
     * setlblJisshiBasho
     * @param lblJisshiBasho lblJisshiBasho
     */
    @JsonProperty("lblJisshiBasho")
    public void setLblJisshiBasho(Label lblJisshiBasho) {
        this.lblJisshiBasho = lblJisshiBasho;
    }

    /*
     * gettxtChosaJisshiBashoCode
     * @return txtChosaJisshiBashoCode
     */
    @JsonProperty("txtChosaJisshiBashoCode")
    public TextBox getTxtChosaJisshiBashoCode() {
        return txtChosaJisshiBashoCode;
    }

    /*
     * settxtChosaJisshiBashoCode
     * @param txtChosaJisshiBashoCode txtChosaJisshiBashoCode
     */
    @JsonProperty("txtChosaJisshiBashoCode")
    public void setTxtChosaJisshiBashoCode(TextBox txtChosaJisshiBashoCode) {
        this.txtChosaJisshiBashoCode = txtChosaJisshiBashoCode;
    }

    /*
     * gettxtChosaJisshiBashoMeisho
     * @return txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public TextBox getTxtChosaJisshiBashoMeisho() {
        return txtChosaJisshiBashoMeisho;
    }

    /*
     * settxtChosaJisshiBashoMeisho
     * @param txtChosaJisshiBashoMeisho txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public void setTxtChosaJisshiBashoMeisho(TextBox txtChosaJisshiBashoMeisho) {
        this.txtChosaJisshiBashoMeisho = txtChosaJisshiBashoMeisho;
    }

    /*
     * getJisshiBashoMeishoPanel
     * @return JisshiBashoMeishoPanel
     */
    @JsonProperty("JisshiBashoMeishoPanel")
    public JisshiBashoMeishoPanelDiv getJisshiBashoMeishoPanel() {
        return JisshiBashoMeishoPanel;
    }

    /*
     * setJisshiBashoMeishoPanel
     * @param JisshiBashoMeishoPanel JisshiBashoMeishoPanel
     */
    @JsonProperty("JisshiBashoMeishoPanel")
    public void setJisshiBashoMeishoPanel(JisshiBashoMeishoPanelDiv JisshiBashoMeishoPanel) {
        this.JisshiBashoMeishoPanel = JisshiBashoMeishoPanel;
    }

    /*
     * getGaikyoChosaTokkiPanel
     * @return GaikyoChosaTokkiPanel
     */
    @JsonProperty("GaikyoChosaTokkiPanel")
    public GaikyoChosaTokkiPanelDiv getGaikyoChosaTokkiPanel() {
        return GaikyoChosaTokkiPanel;
    }

    /*
     * setGaikyoChosaTokkiPanel
     * @param GaikyoChosaTokkiPanel GaikyoChosaTokkiPanel
     */
    @JsonProperty("GaikyoChosaTokkiPanel")
    public void setGaikyoChosaTokkiPanel(GaikyoChosaTokkiPanelDiv GaikyoChosaTokkiPanel) {
        this.GaikyoChosaTokkiPanel = GaikyoChosaTokkiPanel;
    }

    /*
     * getradServiceKubun
     * @return radServiceKubun
     */
    @JsonProperty("radServiceKubun")
    public RadioButton getRadServiceKubun() {
        return radServiceKubun;
    }

    /*
     * setradServiceKubun
     * @param radServiceKubun radServiceKubun
     */
    @JsonProperty("radServiceKubun")
    public void setRadServiceKubun(RadioButton radServiceKubun) {
        this.radServiceKubun = radServiceKubun;
    }

    /*
     * getrdoJutakuKaishu
     * @return rdoJutakuKaishu
     */
    @JsonProperty("rdoJutakuKaishu")
    public RadioButton getRdoJutakuKaishu() {
        return rdoJutakuKaishu;
    }

    /*
     * setrdoJutakuKaishu
     * @param rdoJutakuKaishu rdoJutakuKaishu
     */
    @JsonProperty("rdoJutakuKaishu")
    public void setRdoJutakuKaishu(RadioButton rdoJutakuKaishu) {
        this.rdoJutakuKaishu = rdoJutakuKaishu;
    }

    /*
     * getServiceJokyoPanel
     * @return ServiceJokyoPanel
     */
    @JsonProperty("ServiceJokyoPanel")
    public ServiceJokyoPanelDiv getServiceJokyoPanel() {
        return ServiceJokyoPanel;
    }

    /*
     * setServiceJokyoPanel
     * @param ServiceJokyoPanel ServiceJokyoPanel
     */
    @JsonProperty("ServiceJokyoPanel")
    public void setServiceJokyoPanel(ServiceJokyoPanelDiv ServiceJokyoPanel) {
        this.ServiceJokyoPanel = ServiceJokyoPanel;
    }

    /*
     * getShisetsuRiyoPanel
     * @return ShisetsuRiyoPanel
     */
    @JsonProperty("ShisetsuRiyoPanel")
    public ShisetsuRiyoPanelDiv getShisetsuRiyoPanel() {
        return ShisetsuRiyoPanel;
    }

    /*
     * setShisetsuRiyoPanel
     * @param ShisetsuRiyoPanel ShisetsuRiyoPanel
     */
    @JsonProperty("ShisetsuRiyoPanel")
    public void setShisetsuRiyoPanel(ShisetsuRiyoPanelDiv ShisetsuRiyoPanel) {
        this.ShisetsuRiyoPanel = ShisetsuRiyoPanel;
    }

    /*
     * getTokubetsuKyufuPanel
     * @return TokubetsuKyufuPanel
     */
    @JsonProperty("TokubetsuKyufuPanel")
    public TokubetsuKyufuPanelDiv getTokubetsuKyufuPanel() {
        return TokubetsuKyufuPanel;
    }

    /*
     * setTokubetsuKyufuPanel
     * @param TokubetsuKyufuPanel TokubetsuKyufuPanel
     */
    @JsonProperty("TokubetsuKyufuPanel")
    public void setTokubetsuKyufuPanel(TokubetsuKyufuPanelDiv TokubetsuKyufuPanel) {
        this.TokubetsuKyufuPanel = TokubetsuKyufuPanel;
    }

    /*
     * getZaitakuServicePanel
     * @return ZaitakuServicePanel
     */
    @JsonProperty("ZaitakuServicePanel")
    public ZaitakuServicePanelDiv getZaitakuServicePanel() {
        return ZaitakuServicePanel;
    }

    /*
     * setZaitakuServicePanel
     * @param ZaitakuServicePanel ZaitakuServicePanel
     */
    @JsonProperty("ZaitakuServicePanel")
    public void setZaitakuServicePanel(ZaitakuServicePanelDiv ZaitakuServicePanel) {
        this.ZaitakuServicePanel = ZaitakuServicePanel;
    }

    /*
     * getGaikyoTokkiPanel
     * @return GaikyoTokkiPanel
     */
    @JsonProperty("GaikyoTokkiPanel")
    public GaikyoTokkiPanelDiv getGaikyoTokkiPanel() {
        return GaikyoTokkiPanel;
    }

    /*
     * setGaikyoTokkiPanel
     * @param GaikyoTokkiPanel GaikyoTokkiPanel
     */
    @JsonProperty("GaikyoTokkiPanel")
    public void setGaikyoTokkiPanel(GaikyoTokkiPanelDiv GaikyoTokkiPanel) {
        this.GaikyoTokkiPanel = GaikyoTokkiPanel;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getninteichosaRirekiNo
     * @return ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public RString getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /*
     * setninteichosaRirekiNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public void setNinteichosaRirekiNo(RString ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /*
     * getgenponText
     * @return genponText
     */
    @JsonProperty("genponText")
    public RString getGenponText() {
        return genponText;
    }

    /*
     * setgenponText
     * @param genponText genponText
     */
    @JsonProperty("genponText")
    public void setGenponText(RString genponText) {
        this.genponText = genponText;
    }

    /*
     * getmaskText
     * @return maskText
     */
    @JsonProperty("maskText")
    public RString getMaskText() {
        return maskText;
    }

    /*
     * setmaskText
     * @param maskText maskText
     */
    @JsonProperty("maskText")
    public void setMaskText(RString maskText) {
        this.maskText = maskText;
    }

    /*
     * getgenponImage
     * @return genponImage
     */
    @JsonProperty("genponImage")
    public RString getGenponImage() {
        return genponImage;
    }

    /*
     * setgenponImage
     * @param genponImage genponImage
     */
    @JsonProperty("genponImage")
    public void setGenponImage(RString genponImage) {
        this.genponImage = genponImage;
    }

    /*
     * getmaskImage
     * @return maskImage
     */
    @JsonProperty("maskImage")
    public RString getMaskImage() {
        return maskImage;
    }

    /*
     * setmaskImage
     * @param maskImage maskImage
     */
    @JsonProperty("maskImage")
    public void setMaskImage(RString maskImage) {
        this.maskImage = maskImage;
    }

    /*
     * gethdnTextImageKubun
     * @return hdnTextImageKubun
     */
    @JsonProperty("hdnTextImageKubun")
    public RString getHdnTextImageKubun() {
        return hdnTextImageKubun;
    }

    /*
     * sethdnTextImageKubun
     * @param hdnTextImageKubun hdnTextImageKubun
     */
    @JsonProperty("hdnTextImageKubun")
    public void setHdnTextImageKubun(RString hdnTextImageKubun) {
        this.hdnTextImageKubun = hdnTextImageKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DynamicImage getImgChosaJisshiBashoMeisho() {
        return this.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho();
    }

    @JsonIgnore
    public void  setImgChosaJisshiBashoMeisho(DynamicImage imgChosaJisshiBashoMeisho) {
        this.getJisshiBashoMeishoPanel().setImgChosaJisshiBashoMeisho(imgChosaJisshiBashoMeisho);
    }

    @JsonIgnore
    public Label getLblNoImageJisshiBasho() {
        return this.getJisshiBashoMeishoPanel().getLblNoImageJisshiBasho();
    }

    @JsonIgnore
    public void  setLblNoImageJisshiBasho(Label lblNoImageJisshiBasho) {
        this.getJisshiBashoMeishoPanel().setLblNoImageJisshiBasho(lblNoImageJisshiBasho);
    }

    @JsonIgnore
    public Label getLblShisetsuShurui() {
        return this.getShisetsuRiyoPanel().getLblShisetsuShurui();
    }

    @JsonIgnore
    public void  setLblShisetsuShurui(Label lblShisetsuShurui) {
        this.getShisetsuRiyoPanel().setLblShisetsuShurui(lblShisetsuShurui);
    }

    @JsonIgnore
    public TextBox getTxtRiyoShisetsuShurui() {
        return this.getShisetsuRiyoPanel().getTxtRiyoShisetsuShurui();
    }

    @JsonIgnore
    public void  setTxtRiyoShisetsuShurui(TextBox txtRiyoShisetsuShurui) {
        this.getShisetsuRiyoPanel().setTxtRiyoShisetsuShurui(txtRiyoShisetsuShurui);
    }

    @JsonIgnore
    public Label getLblShisetsuShimei() {
        return this.getShisetsuRiyoPanel().getLblShisetsuShimei();
    }

    @JsonIgnore
    public void  setLblShisetsuShimei(Label lblShisetsuShimei) {
        this.getShisetsuRiyoPanel().setLblShisetsuShimei(lblShisetsuShimei);
    }

    @JsonIgnore
    public Label getLblTelNo() {
        return this.getShisetsuRiyoPanel().getLblTelNo();
    }

    @JsonIgnore
    public void  setLblTelNo(Label lblTelNo) {
        this.getShisetsuRiyoPanel().setLblTelNo(lblTelNo);
    }

    @JsonIgnore
    public TextBox getTxtRiyoShisetsuMeisho() {
        return this.getShisetsuRiyoPanel().getTxtRiyoShisetsuMeisho();
    }

    @JsonIgnore
    public void  setTxtRiyoShisetsuMeisho(TextBox txtRiyoShisetsuMeisho) {
        this.getShisetsuRiyoPanel().setTxtRiyoShisetsuMeisho(txtRiyoShisetsuMeisho);
    }

    @JsonIgnore
    public TextBox getTxtTelNo() {
        return this.getShisetsuRiyoPanel().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBox txtTelNo) {
        this.getShisetsuRiyoPanel().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public ShisetsuMeishoPanelDiv getShisetsuMeishoPanel() {
        return this.getShisetsuRiyoPanel().getShisetsuMeishoPanel();
    }

    @JsonIgnore
    public void  setShisetsuMeishoPanel(ShisetsuMeishoPanelDiv ShisetsuMeishoPanel) {
        this.getShisetsuRiyoPanel().setShisetsuMeishoPanel(ShisetsuMeishoPanel);
    }

    @JsonIgnore
    public DynamicImage getImgRiyoShisetsuMeisho() {
        return this.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getImgRiyoShisetsuMeisho();
    }

    @JsonIgnore
    public void  setImgRiyoShisetsuMeisho(DynamicImage imgRiyoShisetsuMeisho) {
        this.getShisetsuRiyoPanel().getShisetsuMeishoPanel().setImgRiyoShisetsuMeisho(imgRiyoShisetsuMeisho);
    }

    @JsonIgnore
    public Label getLblNoImageRiyoShisetsuMeisho() {
        return this.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getLblNoImageRiyoShisetsuMeisho();
    }

    @JsonIgnore
    public void  setLblNoImageRiyoShisetsuMeisho(Label lblNoImageRiyoShisetsuMeisho) {
        this.getShisetsuRiyoPanel().getShisetsuMeishoPanel().setLblNoImageRiyoShisetsuMeisho(lblNoImageRiyoShisetsuMeisho);
    }

    @JsonIgnore
    public TelNoPanelDiv getTelNoPanel() {
        return this.getShisetsuRiyoPanel().getTelNoPanel();
    }

    @JsonIgnore
    public void  setTelNoPanel(TelNoPanelDiv TelNoPanel) {
        this.getShisetsuRiyoPanel().setTelNoPanel(TelNoPanel);
    }

    @JsonIgnore
    public DynamicImage getImgTelNo() {
        return this.getShisetsuRiyoPanel().getTelNoPanel().getImgTelNo();
    }

    @JsonIgnore
    public void  setImgTelNo(DynamicImage imgTelNo) {
        this.getShisetsuRiyoPanel().getTelNoPanel().setImgTelNo(imgTelNo);
    }

    @JsonIgnore
    public Label getLblNoImageTelNo() {
        return this.getShisetsuRiyoPanel().getTelNoPanel().getLblNoImageTelNo();
    }

    @JsonIgnore
    public void  setLblNoImageTelNo(Label lblNoImageTelNo) {
        this.getShisetsuRiyoPanel().getTelNoPanel().setLblNoImageTelNo(lblNoImageTelNo);
    }

    @JsonIgnore
    public Label getLblRiyoShisetsuJusho() {
        return this.getShisetsuRiyoPanel().getLblRiyoShisetsuJusho();
    }

    @JsonIgnore
    public void  setLblRiyoShisetsuJusho(Label lblRiyoShisetsuJusho) {
        this.getShisetsuRiyoPanel().setLblRiyoShisetsuJusho(lblRiyoShisetsuJusho);
    }

    @JsonIgnore
    public TextBox getTxtRiyoShisetsuJusho() {
        return this.getShisetsuRiyoPanel().getTxtRiyoShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtRiyoShisetsuJusho(TextBox txtRiyoShisetsuJusho) {
        this.getShisetsuRiyoPanel().setTxtRiyoShisetsuJusho(txtRiyoShisetsuJusho);
    }

    @JsonIgnore
    public ShisetsuJushoPanelDiv getShisetsuJushoPanel() {
        return this.getShisetsuRiyoPanel().getShisetsuJushoPanel();
    }

    @JsonIgnore
    public void  setShisetsuJushoPanel(ShisetsuJushoPanelDiv ShisetsuJushoPanel) {
        this.getShisetsuRiyoPanel().setShisetsuJushoPanel(ShisetsuJushoPanel);
    }

    @JsonIgnore
    public DynamicImage getImgRiyoShisetsuJusho() {
        return this.getShisetsuRiyoPanel().getShisetsuJushoPanel().getImgRiyoShisetsuJusho();
    }

    @JsonIgnore
    public void  setImgRiyoShisetsuJusho(DynamicImage imgRiyoShisetsuJusho) {
        this.getShisetsuRiyoPanel().getShisetsuJushoPanel().setImgRiyoShisetsuJusho(imgRiyoShisetsuJusho);
    }

    @JsonIgnore
    public Label getLblNoImageRiyoShisetsuJusho() {
        return this.getShisetsuRiyoPanel().getShisetsuJushoPanel().getLblNoImageRiyoShisetsuJusho();
    }

    @JsonIgnore
    public void  setLblNoImageRiyoShisetsuJusho(Label lblNoImageRiyoShisetsuJusho) {
        this.getShisetsuRiyoPanel().getShisetsuJushoPanel().setLblNoImageRiyoShisetsuJusho(lblNoImageRiyoShisetsuJusho);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
