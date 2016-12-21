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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ImageJohoMasking のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageJohoMaskingDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
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
    @JsonProperty("hiddenImagePath")
    private RString hiddenImagePath;

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
     * gethiddenImagePath
     * @return hiddenImagePath
     */
    @JsonProperty("hiddenImagePath")
    public RString getHiddenImagePath() {
        return hiddenImagePath;
    }

    /*
     * sethiddenImagePath
     * @param hiddenImagePath hiddenImagePath
     */
    @JsonProperty("hiddenImagePath")
    public void setHiddenImagePath(RString hiddenImagePath) {
        this.hiddenImagePath = hiddenImagePath;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNumber() {
        return this.getShoriTaishoshaKensakuShiji().getTxtHihokenshaNumber();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNumber(TextBoxCode txtHihokenshaNumber) {
        this.getShoriTaishoshaKensakuShiji().setTxtHihokenshaNumber(txtHihokenshaNumber);
    }

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
    public Button getBtnClear() {
        return this.getShoriTaishoshaKensakuShiji().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getShoriTaishoshaKensakuShiji().setBtnClear(btnClear);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getShoriTaishoshaKensakuShiji().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getShoriTaishoshaKensakuShiji().setTxtMaxDisp(txtMaxDisp);
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
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return this.getHihokenshaInfoPanel().getCcdNinteiShinseishaKihonInfo();
    }

    @JsonIgnore
    public DataGrid<dgImageMaskingTaisho_Row> getDgImageMaskingTaisho() {
        return this.getImageMaskTaishoShiji().getDgImageMaskingTaisho();
    }

    @JsonIgnore
    public void  setDgImageMaskingTaisho(DataGrid<dgImageMaskingTaisho_Row> dgImageMaskingTaisho) {
        this.getImageMaskTaishoShiji().setDgImageMaskingTaisho(dgImageMaskingTaisho);
    }

    @JsonIgnore
    public ButtonDialog getBtnMaskingGenpon() {
        return this.getImageMaskTaishoShiji().getBtnMaskingGenpon();
    }

    @JsonIgnore
    public void  setBtnMaskingGenpon(ButtonDialog btnMaskingGenpon) {
        this.getImageMaskTaishoShiji().setBtnMaskingGenpon(btnMaskingGenpon);
    }

    @JsonIgnore
    public ButtonDialog getBtnMaskingMask() {
        return this.getImageMaskTaishoShiji().getBtnMaskingMask();
    }

    @JsonIgnore
    public void  setBtnMaskingMask(ButtonDialog btnMaskingMask) {
        this.getImageMaskTaishoShiji().setBtnMaskingMask(btnMaskingMask);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getImageMaskTaishoShiji().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getImageMaskTaishoShiji().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
