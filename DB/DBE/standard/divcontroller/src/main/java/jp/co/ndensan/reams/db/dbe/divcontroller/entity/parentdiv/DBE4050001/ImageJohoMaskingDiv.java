package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ImageJohoMasking のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageJohoMaskingDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriTaishoshaKensakuShiji")
    private ShoriTaishoshaKensakuShijiDiv ShoriTaishoshaKensakuShiji;
    @JsonProperty("ShoriTaishoshaIchiran")
    private ShoriTaishoshaIchiranDiv ShoriTaishoshaIchiran;
    @JsonProperty("hihokenshaInfoPanel")
    private hihokenshaInfoPanelDiv hihokenshaInfoPanel;
    @JsonProperty("ImageMaskTaishoShiji")
    private ImageMaskTaishoShijiDiv ImageMaskTaishoShiji;
    @JsonProperty("maskingPanel")
    private maskingPanelDiv maskingPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriTaishoshaKensakuShiji
     * @return ShoriTaishoshaKensakuShiji
     */
    @JsonProperty("ShoriTaishoshaKensakuShiji")
    public ShoriTaishoshaKensakuShijiDiv getShoriTaishoshaKensakuShiji() {
        return ShoriTaishoshaKensakuShiji;
    }

    /*
     * setShoriTaishoshaKensakuShiji
     * @param ShoriTaishoshaKensakuShiji ShoriTaishoshaKensakuShiji
     */
    @JsonProperty("ShoriTaishoshaKensakuShiji")
    public void setShoriTaishoshaKensakuShiji(ShoriTaishoshaKensakuShijiDiv ShoriTaishoshaKensakuShiji) {
        this.ShoriTaishoshaKensakuShiji = ShoriTaishoshaKensakuShiji;
    }

    /*
     * getShoriTaishoshaIchiran
     * @return ShoriTaishoshaIchiran
     */
    @JsonProperty("ShoriTaishoshaIchiran")
    public ShoriTaishoshaIchiranDiv getShoriTaishoshaIchiran() {
        return ShoriTaishoshaIchiran;
    }

    /*
     * setShoriTaishoshaIchiran
     * @param ShoriTaishoshaIchiran ShoriTaishoshaIchiran
     */
    @JsonProperty("ShoriTaishoshaIchiran")
    public void setShoriTaishoshaIchiran(ShoriTaishoshaIchiranDiv ShoriTaishoshaIchiran) {
        this.ShoriTaishoshaIchiran = ShoriTaishoshaIchiran;
    }

    /*
     * gethihokenshaInfoPanel
     * @return hihokenshaInfoPanel
     */
    @JsonProperty("hihokenshaInfoPanel")
    public hihokenshaInfoPanelDiv getHihokenshaInfoPanel() {
        return hihokenshaInfoPanel;
    }

    /*
     * sethihokenshaInfoPanel
     * @param hihokenshaInfoPanel hihokenshaInfoPanel
     */
    @JsonProperty("hihokenshaInfoPanel")
    public void setHihokenshaInfoPanel(hihokenshaInfoPanelDiv hihokenshaInfoPanel) {
        this.hihokenshaInfoPanel = hihokenshaInfoPanel;
    }

    /*
     * getImageMaskTaishoShiji
     * @return ImageMaskTaishoShiji
     */
    @JsonProperty("ImageMaskTaishoShiji")
    public ImageMaskTaishoShijiDiv getImageMaskTaishoShiji() {
        return ImageMaskTaishoShiji;
    }

    /*
     * setImageMaskTaishoShiji
     * @param ImageMaskTaishoShiji ImageMaskTaishoShiji
     */
    @JsonProperty("ImageMaskTaishoShiji")
    public void setImageMaskTaishoShiji(ImageMaskTaishoShijiDiv ImageMaskTaishoShiji) {
        this.ImageMaskTaishoShiji = ImageMaskTaishoShiji;
    }

    /*
     * getmaskingPanel
     * @return maskingPanel
     */
    @JsonProperty("maskingPanel")
    public maskingPanelDiv getMaskingPanel() {
        return maskingPanel;
    }

    /*
     * setmaskingPanel
     * @param maskingPanel maskingPanel
     */
    @JsonProperty("maskingPanel")
    public void setMaskingPanel(maskingPanelDiv maskingPanel) {
        this.maskingPanel = maskingPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKensakuTaisho() {
        return this.getShoriTaishoshaKensakuShiji().getDdlKensakuTaisho();
    }

    @JsonIgnore
    public void  setDdlKensakuTaisho(DropDownList ddlKensakuTaisho) {
        this.getShoriTaishoshaKensakuShiji().setDdlKensakuTaisho(ddlKensakuTaisho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSearchStYMD() {
        return this.getShoriTaishoshaKensakuShiji().getTxtSearchStYMD();
    }

    @JsonIgnore
    public void  setTxtSearchStYMD(TextBoxFlexibleDate txtSearchStYMD) {
        this.getShoriTaishoshaKensakuShiji().setTxtSearchStYMD(txtSearchStYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSearchEdYMD() {
        return this.getShoriTaishoshaKensakuShiji().getTxtSearchEdYMD();
    }

    @JsonIgnore
    public void  setTxtSearchEdYMD(TextBoxFlexibleDate txtSearchEdYMD) {
        this.getShoriTaishoshaKensakuShiji().setTxtSearchEdYMD(txtSearchEdYMD);
    }

    @JsonIgnore
    public Button getBtnTaishoKensaku() {
        return this.getShoriTaishoshaKensakuShiji().getBtnTaishoKensaku();
    }

    @JsonIgnore
    public void  setBtnTaishoKensaku(Button btnTaishoKensaku) {
        this.getShoriTaishoshaKensakuShiji().setBtnTaishoKensaku(btnTaishoKensaku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getShoriTaishoshaKensakuShiji().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getShoriTaishoshaKensakuShiji().setBtnClear(btnClear);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensya() {
        return this.getShoriTaishoshaKensakuShiji().getCcdHokensya();
    }

    @JsonIgnore
    public DataGrid<dgImageMaskShoriTaishosha_Row> getDgImageMaskShoriTaishosha() {
        return this.getShoriTaishoshaIchiran().getDgImageMaskShoriTaishosha();
    }

    @JsonIgnore
    public void  setDgImageMaskShoriTaishosha(DataGrid<dgImageMaskShoriTaishosha_Row> dgImageMaskShoriTaishosha) {
        this.getShoriTaishoshaIchiran().setDgImageMaskShoriTaishosha(dgImageMaskShoriTaishosha);
    }

    @JsonIgnore
    public Button getBtnSaiKensaku() {
        return this.getShoriTaishoshaIchiran().getBtnSaiKensaku();
    }

    @JsonIgnore
    public void  setBtnSaiKensaku(Button btnSaiKensaku) {
        this.getShoriTaishoshaIchiran().setBtnSaiKensaku(btnSaiKensaku);
    }

    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return this.getHihokenshaInfoPanel().getCcdNinteiShinseishaKihonInfo();
    }

    @JsonIgnore
    public RadioButton getRdoIkenshoHyo() {
        return this.getImageMaskTaishoShiji().getRdoIkenshoHyo();
    }

    @JsonIgnore
    public void  setRdoIkenshoHyo(RadioButton rdoIkenshoHyo) {
        this.getImageMaskTaishoShiji().setRdoIkenshoHyo(rdoIkenshoHyo);
    }

    @JsonIgnore
    public RadioButton getRdoIkenshoUra() {
        return this.getImageMaskTaishoShiji().getRdoIkenshoUra();
    }

    @JsonIgnore
    public void  setRdoIkenshoUra(RadioButton rdoIkenshoUra) {
        this.getImageMaskTaishoShiji().setRdoIkenshoUra(rdoIkenshoUra);
    }

    @JsonIgnore
    public DropDownList getDdlMaskKubun() {
        return this.getImageMaskTaishoShiji().getDdlMaskKubun();
    }

    @JsonIgnore
    public void  setDdlMaskKubun(DropDownList ddlMaskKubun) {
        this.getImageMaskTaishoShiji().setDdlMaskKubun(ddlMaskKubun);
    }

    @JsonIgnore
    public Button getBtnMasking() {
        return this.getImageMaskTaishoShiji().getBtnMasking();
    }

    @JsonIgnore
    public void  setBtnMasking(Button btnMasking) {
        this.getImageMaskTaishoShiji().setBtnMasking(btnMasking);
    }

    @JsonIgnore
    public TextBox getTextBox1() {
        return this.getMaskingPanel().getTextBox1();
    }

    @JsonIgnore
    public void  setTextBox1(TextBox TextBox1) {
        this.getMaskingPanel().setTextBox1(TextBox1);
    }

    // </editor-fold>
}
