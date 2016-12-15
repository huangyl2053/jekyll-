package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuRiyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuRiyoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShisetsuShurui")
    private Label lblShisetsuShurui;
    @JsonProperty("txtRiyoShisetsuShurui")
    private TextBox txtRiyoShisetsuShurui;
    @JsonProperty("lblShisetsuShimei")
    private Label lblShisetsuShimei;
    @JsonProperty("lblTelNo")
    private Label lblTelNo;
    @JsonProperty("txtRiyoShisetsuMeisho")
    private TextBox txtRiyoShisetsuMeisho;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("ShisetsuMeishoPanel")
    private ShisetsuMeishoPanelDiv ShisetsuMeishoPanel;
    @JsonProperty("TelNoPanel")
    private TelNoPanelDiv TelNoPanel;
    @JsonProperty("lblRiyoShisetsuJusho")
    private Label lblRiyoShisetsuJusho;
    @JsonProperty("txtRiyoShisetsuJusho")
    private TextBox txtRiyoShisetsuJusho;
    @JsonProperty("ShisetsuJushoPanel")
    private ShisetsuJushoPanelDiv ShisetsuJushoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShisetsuShurui
     * @return lblShisetsuShurui
     */
    @JsonProperty("lblShisetsuShurui")
    public Label getLblShisetsuShurui() {
        return lblShisetsuShurui;
    }

    /*
     * setlblShisetsuShurui
     * @param lblShisetsuShurui lblShisetsuShurui
     */
    @JsonProperty("lblShisetsuShurui")
    public void setLblShisetsuShurui(Label lblShisetsuShurui) {
        this.lblShisetsuShurui = lblShisetsuShurui;
    }

    /*
     * gettxtRiyoShisetsuShurui
     * @return txtRiyoShisetsuShurui
     */
    @JsonProperty("txtRiyoShisetsuShurui")
    public TextBox getTxtRiyoShisetsuShurui() {
        return txtRiyoShisetsuShurui;
    }

    /*
     * settxtRiyoShisetsuShurui
     * @param txtRiyoShisetsuShurui txtRiyoShisetsuShurui
     */
    @JsonProperty("txtRiyoShisetsuShurui")
    public void setTxtRiyoShisetsuShurui(TextBox txtRiyoShisetsuShurui) {
        this.txtRiyoShisetsuShurui = txtRiyoShisetsuShurui;
    }

    /*
     * getlblShisetsuShimei
     * @return lblShisetsuShimei
     */
    @JsonProperty("lblShisetsuShimei")
    public Label getLblShisetsuShimei() {
        return lblShisetsuShimei;
    }

    /*
     * setlblShisetsuShimei
     * @param lblShisetsuShimei lblShisetsuShimei
     */
    @JsonProperty("lblShisetsuShimei")
    public void setLblShisetsuShimei(Label lblShisetsuShimei) {
        this.lblShisetsuShimei = lblShisetsuShimei;
    }

    /*
     * getlblTelNo
     * @return lblTelNo
     */
    @JsonProperty("lblTelNo")
    public Label getLblTelNo() {
        return lblTelNo;
    }

    /*
     * setlblTelNo
     * @param lblTelNo lblTelNo
     */
    @JsonProperty("lblTelNo")
    public void setLblTelNo(Label lblTelNo) {
        this.lblTelNo = lblTelNo;
    }

    /*
     * gettxtRiyoShisetsuMeisho
     * @return txtRiyoShisetsuMeisho
     */
    @JsonProperty("txtRiyoShisetsuMeisho")
    public TextBox getTxtRiyoShisetsuMeisho() {
        return txtRiyoShisetsuMeisho;
    }

    /*
     * settxtRiyoShisetsuMeisho
     * @param txtRiyoShisetsuMeisho txtRiyoShisetsuMeisho
     */
    @JsonProperty("txtRiyoShisetsuMeisho")
    public void setTxtRiyoShisetsuMeisho(TextBox txtRiyoShisetsuMeisho) {
        this.txtRiyoShisetsuMeisho = txtRiyoShisetsuMeisho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * getShisetsuMeishoPanel
     * @return ShisetsuMeishoPanel
     */
    @JsonProperty("ShisetsuMeishoPanel")
    public ShisetsuMeishoPanelDiv getShisetsuMeishoPanel() {
        return ShisetsuMeishoPanel;
    }

    /*
     * setShisetsuMeishoPanel
     * @param ShisetsuMeishoPanel ShisetsuMeishoPanel
     */
    @JsonProperty("ShisetsuMeishoPanel")
    public void setShisetsuMeishoPanel(ShisetsuMeishoPanelDiv ShisetsuMeishoPanel) {
        this.ShisetsuMeishoPanel = ShisetsuMeishoPanel;
    }

    /*
     * getTelNoPanel
     * @return TelNoPanel
     */
    @JsonProperty("TelNoPanel")
    public TelNoPanelDiv getTelNoPanel() {
        return TelNoPanel;
    }

    /*
     * setTelNoPanel
     * @param TelNoPanel TelNoPanel
     */
    @JsonProperty("TelNoPanel")
    public void setTelNoPanel(TelNoPanelDiv TelNoPanel) {
        this.TelNoPanel = TelNoPanel;
    }

    /*
     * getlblRiyoShisetsuJusho
     * @return lblRiyoShisetsuJusho
     */
    @JsonProperty("lblRiyoShisetsuJusho")
    public Label getLblRiyoShisetsuJusho() {
        return lblRiyoShisetsuJusho;
    }

    /*
     * setlblRiyoShisetsuJusho
     * @param lblRiyoShisetsuJusho lblRiyoShisetsuJusho
     */
    @JsonProperty("lblRiyoShisetsuJusho")
    public void setLblRiyoShisetsuJusho(Label lblRiyoShisetsuJusho) {
        this.lblRiyoShisetsuJusho = lblRiyoShisetsuJusho;
    }

    /*
     * gettxtRiyoShisetsuJusho
     * @return txtRiyoShisetsuJusho
     */
    @JsonProperty("txtRiyoShisetsuJusho")
    public TextBox getTxtRiyoShisetsuJusho() {
        return txtRiyoShisetsuJusho;
    }

    /*
     * settxtRiyoShisetsuJusho
     * @param txtRiyoShisetsuJusho txtRiyoShisetsuJusho
     */
    @JsonProperty("txtRiyoShisetsuJusho")
    public void setTxtRiyoShisetsuJusho(TextBox txtRiyoShisetsuJusho) {
        this.txtRiyoShisetsuJusho = txtRiyoShisetsuJusho;
    }

    /*
     * getShisetsuJushoPanel
     * @return ShisetsuJushoPanel
     */
    @JsonProperty("ShisetsuJushoPanel")
    public ShisetsuJushoPanelDiv getShisetsuJushoPanel() {
        return ShisetsuJushoPanel;
    }

    /*
     * setShisetsuJushoPanel
     * @param ShisetsuJushoPanel ShisetsuJushoPanel
     */
    @JsonProperty("ShisetsuJushoPanel")
    public void setShisetsuJushoPanel(ShisetsuJushoPanelDiv ShisetsuJushoPanel) {
        this.ShisetsuJushoPanel = ShisetsuJushoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DynamicImage getImgRiyoShisetsuMeisho() {
        return this.getShisetsuMeishoPanel().getImgRiyoShisetsuMeisho();
    }

    @JsonIgnore
    public void  setImgRiyoShisetsuMeisho(DynamicImage imgRiyoShisetsuMeisho) {
        this.getShisetsuMeishoPanel().setImgRiyoShisetsuMeisho(imgRiyoShisetsuMeisho);
    }

    @JsonIgnore
    public Label getLblNoImageRiyoShisetsuMeisho() {
        return this.getShisetsuMeishoPanel().getLblNoImageRiyoShisetsuMeisho();
    }

    @JsonIgnore
    public void  setLblNoImageRiyoShisetsuMeisho(Label lblNoImageRiyoShisetsuMeisho) {
        this.getShisetsuMeishoPanel().setLblNoImageRiyoShisetsuMeisho(lblNoImageRiyoShisetsuMeisho);
    }

    @JsonIgnore
    public DynamicImage getImgTelNo() {
        return this.getTelNoPanel().getImgTelNo();
    }

    @JsonIgnore
    public void  setImgTelNo(DynamicImage imgTelNo) {
        this.getTelNoPanel().setImgTelNo(imgTelNo);
    }

    @JsonIgnore
    public Label getLblNoImageTelNo() {
        return this.getTelNoPanel().getLblNoImageTelNo();
    }

    @JsonIgnore
    public void  setLblNoImageTelNo(Label lblNoImageTelNo) {
        this.getTelNoPanel().setLblNoImageTelNo(lblNoImageTelNo);
    }

    @JsonIgnore
    public DynamicImage getImgRiyoShisetsuJusho() {
        return this.getShisetsuJushoPanel().getImgRiyoShisetsuJusho();
    }

    @JsonIgnore
    public void setImgRiyoShisetsuJusho(DynamicImage imgRiyoShisetsuJusho) {
        this.getShisetsuJushoPanel().setImgRiyoShisetsuJusho(imgRiyoShisetsuJusho);
    }

    @JsonIgnore
    public Label getLblNoImageRiyoShisetsuJusho() {
        return this.getShisetsuJushoPanel().getLblNoImageRiyoShisetsuJusho();
    }

    @JsonIgnore
    public void  setLblNoImageRiyoShisetsuJusho(Label lblNoImageRiyoShisetsuJusho) {
        this.getShisetsuJushoPanel().setLblNoImageRiyoShisetsuJusho(lblNoImageRiyoShisetsuJusho);
    }

    // </editor-fold>
}
