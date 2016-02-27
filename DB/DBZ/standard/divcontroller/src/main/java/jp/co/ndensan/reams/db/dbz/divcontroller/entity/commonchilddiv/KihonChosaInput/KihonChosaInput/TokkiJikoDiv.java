package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
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
 * TokkiJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiJikoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHanrei")
    private DataGrid<dgHanrei_Row> dgHanrei;
    @JsonProperty("tblTextTokkiJiko")
    private tblTextTokkiJikoDiv tblTextTokkiJiko;
    @JsonProperty("btnTextMasking")
    private ButtonDialog btnTextMasking;
    @JsonProperty("btnBeforeTextTokkiJiko")
    private Button btnBeforeTextTokkiJiko;
    @JsonProperty("lblTextCurrentHyojiNo")
    private Label lblTextCurrentHyojiNo;
    @JsonProperty("lblTextMaxPerCurrent")
    private Label lblTextMaxPerCurrent;
    @JsonProperty("lblTextMaxHyojino")
    private Label lblTextMaxHyojino;
    @JsonProperty("btnAfterTextTokkiJiko")
    private Button btnAfterTextTokkiJiko;
    @JsonProperty("linHolizontal")
    private HorizontalLine linHolizontal;
    @JsonProperty("tblTokkiJiko")
    private tblTokkiJikoDiv tblTokkiJiko;
    @JsonProperty("btnBeforeImageTokkiJiko")
    private Button btnBeforeImageTokkiJiko;
    @JsonProperty("lblImageCurrentHyojiNo")
    private Label lblImageCurrentHyojiNo;
    @JsonProperty("lblImageMaxPerCurrent")
    private Label lblImageMaxPerCurrent;
    @JsonProperty("lblImageTokkiNo")
    private Label lblImageTokkiNo;
    @JsonProperty("btnImageMasking")
    private ButtonDialog btnImageMasking;
    @JsonProperty("btnAfterImageTokkiJiko")
    private Button btnAfterImageTokkiJiko;
    @JsonProperty("btnSakujo")
    private Button btnSakujo;
    @JsonProperty("btnHozon")
    private Button btnHozon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgHanrei
     * @return dgHanrei
     */
    @JsonProperty("dgHanrei")
    public DataGrid<dgHanrei_Row> getDgHanrei() {
        return dgHanrei;
    }

    /*
     * setdgHanrei
     * @param dgHanrei dgHanrei
     */
    @JsonProperty("dgHanrei")
    public void setDgHanrei(DataGrid<dgHanrei_Row> dgHanrei) {
        this.dgHanrei = dgHanrei;
    }

    /*
     * gettblTextTokkiJiko
     * @return tblTextTokkiJiko
     */
    @JsonProperty("tblTextTokkiJiko")
    public tblTextTokkiJikoDiv getTblTextTokkiJiko() {
        return tblTextTokkiJiko;
    }

    /*
     * settblTextTokkiJiko
     * @param tblTextTokkiJiko tblTextTokkiJiko
     */
    @JsonProperty("tblTextTokkiJiko")
    public void setTblTextTokkiJiko(tblTextTokkiJikoDiv tblTextTokkiJiko) {
        this.tblTextTokkiJiko = tblTextTokkiJiko;
    }

    /*
     * getbtnTextMasking
     * @return btnTextMasking
     */
    @JsonProperty("btnTextMasking")
    public ButtonDialog getBtnTextMasking() {
        return btnTextMasking;
    }

    /*
     * setbtnTextMasking
     * @param btnTextMasking btnTextMasking
     */
    @JsonProperty("btnTextMasking")
    public void setBtnTextMasking(ButtonDialog btnTextMasking) {
        this.btnTextMasking = btnTextMasking;
    }

    /*
     * getbtnBeforeTextTokkiJiko
     * @return btnBeforeTextTokkiJiko
     */
    @JsonProperty("btnBeforeTextTokkiJiko")
    public Button getBtnBeforeTextTokkiJiko() {
        return btnBeforeTextTokkiJiko;
    }

    /*
     * setbtnBeforeTextTokkiJiko
     * @param btnBeforeTextTokkiJiko btnBeforeTextTokkiJiko
     */
    @JsonProperty("btnBeforeTextTokkiJiko")
    public void setBtnBeforeTextTokkiJiko(Button btnBeforeTextTokkiJiko) {
        this.btnBeforeTextTokkiJiko = btnBeforeTextTokkiJiko;
    }

    /*
     * getlblTextCurrentHyojiNo
     * @return lblTextCurrentHyojiNo
     */
    @JsonProperty("lblTextCurrentHyojiNo")
    public Label getLblTextCurrentHyojiNo() {
        return lblTextCurrentHyojiNo;
    }

    /*
     * setlblTextCurrentHyojiNo
     * @param lblTextCurrentHyojiNo lblTextCurrentHyojiNo
     */
    @JsonProperty("lblTextCurrentHyojiNo")
    public void setLblTextCurrentHyojiNo(Label lblTextCurrentHyojiNo) {
        this.lblTextCurrentHyojiNo = lblTextCurrentHyojiNo;
    }

    /*
     * getlblTextMaxPerCurrent
     * @return lblTextMaxPerCurrent
     */
    @JsonProperty("lblTextMaxPerCurrent")
    public Label getLblTextMaxPerCurrent() {
        return lblTextMaxPerCurrent;
    }

    /*
     * setlblTextMaxPerCurrent
     * @param lblTextMaxPerCurrent lblTextMaxPerCurrent
     */
    @JsonProperty("lblTextMaxPerCurrent")
    public void setLblTextMaxPerCurrent(Label lblTextMaxPerCurrent) {
        this.lblTextMaxPerCurrent = lblTextMaxPerCurrent;
    }

    /*
     * getlblTextMaxHyojino
     * @return lblTextMaxHyojino
     */
    @JsonProperty("lblTextMaxHyojino")
    public Label getLblTextMaxHyojino() {
        return lblTextMaxHyojino;
    }

    /*
     * setlblTextMaxHyojino
     * @param lblTextMaxHyojino lblTextMaxHyojino
     */
    @JsonProperty("lblTextMaxHyojino")
    public void setLblTextMaxHyojino(Label lblTextMaxHyojino) {
        this.lblTextMaxHyojino = lblTextMaxHyojino;
    }

    /*
     * getbtnAfterTextTokkiJiko
     * @return btnAfterTextTokkiJiko
     */
    @JsonProperty("btnAfterTextTokkiJiko")
    public Button getBtnAfterTextTokkiJiko() {
        return btnAfterTextTokkiJiko;
    }

    /*
     * setbtnAfterTextTokkiJiko
     * @param btnAfterTextTokkiJiko btnAfterTextTokkiJiko
     */
    @JsonProperty("btnAfterTextTokkiJiko")
    public void setBtnAfterTextTokkiJiko(Button btnAfterTextTokkiJiko) {
        this.btnAfterTextTokkiJiko = btnAfterTextTokkiJiko;
    }

    /*
     * getlinHolizontal
     * @return linHolizontal
     */
    @JsonProperty("linHolizontal")
    public HorizontalLine getLinHolizontal() {
        return linHolizontal;
    }

    /*
     * setlinHolizontal
     * @param linHolizontal linHolizontal
     */
    @JsonProperty("linHolizontal")
    public void setLinHolizontal(HorizontalLine linHolizontal) {
        this.linHolizontal = linHolizontal;
    }

    /*
     * gettblTokkiJiko
     * @return tblTokkiJiko
     */
    @JsonProperty("tblTokkiJiko")
    public tblTokkiJikoDiv getTblTokkiJiko() {
        return tblTokkiJiko;
    }

    /*
     * settblTokkiJiko
     * @param tblTokkiJiko tblTokkiJiko
     */
    @JsonProperty("tblTokkiJiko")
    public void setTblTokkiJiko(tblTokkiJikoDiv tblTokkiJiko) {
        this.tblTokkiJiko = tblTokkiJiko;
    }

    /*
     * getbtnBeforeImageTokkiJiko
     * @return btnBeforeImageTokkiJiko
     */
    @JsonProperty("btnBeforeImageTokkiJiko")
    public Button getBtnBeforeImageTokkiJiko() {
        return btnBeforeImageTokkiJiko;
    }

    /*
     * setbtnBeforeImageTokkiJiko
     * @param btnBeforeImageTokkiJiko btnBeforeImageTokkiJiko
     */
    @JsonProperty("btnBeforeImageTokkiJiko")
    public void setBtnBeforeImageTokkiJiko(Button btnBeforeImageTokkiJiko) {
        this.btnBeforeImageTokkiJiko = btnBeforeImageTokkiJiko;
    }

    /*
     * getlblImageCurrentHyojiNo
     * @return lblImageCurrentHyojiNo
     */
    @JsonProperty("lblImageCurrentHyojiNo")
    public Label getLblImageCurrentHyojiNo() {
        return lblImageCurrentHyojiNo;
    }

    /*
     * setlblImageCurrentHyojiNo
     * @param lblImageCurrentHyojiNo lblImageCurrentHyojiNo
     */
    @JsonProperty("lblImageCurrentHyojiNo")
    public void setLblImageCurrentHyojiNo(Label lblImageCurrentHyojiNo) {
        this.lblImageCurrentHyojiNo = lblImageCurrentHyojiNo;
    }

    /*
     * getlblImageMaxPerCurrent
     * @return lblImageMaxPerCurrent
     */
    @JsonProperty("lblImageMaxPerCurrent")
    public Label getLblImageMaxPerCurrent() {
        return lblImageMaxPerCurrent;
    }

    /*
     * setlblImageMaxPerCurrent
     * @param lblImageMaxPerCurrent lblImageMaxPerCurrent
     */
    @JsonProperty("lblImageMaxPerCurrent")
    public void setLblImageMaxPerCurrent(Label lblImageMaxPerCurrent) {
        this.lblImageMaxPerCurrent = lblImageMaxPerCurrent;
    }

    /*
     * getlblImageTokkiNo
     * @return lblImageTokkiNo
     */
    @JsonProperty("lblImageTokkiNo")
    public Label getLblImageTokkiNo() {
        return lblImageTokkiNo;
    }

    /*
     * setlblImageTokkiNo
     * @param lblImageTokkiNo lblImageTokkiNo
     */
    @JsonProperty("lblImageTokkiNo")
    public void setLblImageTokkiNo(Label lblImageTokkiNo) {
        this.lblImageTokkiNo = lblImageTokkiNo;
    }

    /*
     * getbtnImageMasking
     * @return btnImageMasking
     */
    @JsonProperty("btnImageMasking")
    public ButtonDialog getBtnImageMasking() {
        return btnImageMasking;
    }

    /*
     * setbtnImageMasking
     * @param btnImageMasking btnImageMasking
     */
    @JsonProperty("btnImageMasking")
    public void setBtnImageMasking(ButtonDialog btnImageMasking) {
        this.btnImageMasking = btnImageMasking;
    }

    /*
     * getbtnAfterImageTokkiJiko
     * @return btnAfterImageTokkiJiko
     */
    @JsonProperty("btnAfterImageTokkiJiko")
    public Button getBtnAfterImageTokkiJiko() {
        return btnAfterImageTokkiJiko;
    }

    /*
     * setbtnAfterImageTokkiJiko
     * @param btnAfterImageTokkiJiko btnAfterImageTokkiJiko
     */
    @JsonProperty("btnAfterImageTokkiJiko")
    public void setBtnAfterImageTokkiJiko(Button btnAfterImageTokkiJiko) {
        this.btnAfterImageTokkiJiko = btnAfterImageTokkiJiko;
    }

    /*
     * getbtnSakujo
     * @return btnSakujo
     */
    @JsonProperty("btnSakujo")
    public Button getBtnSakujo() {
        return btnSakujo;
    }

    /*
     * setbtnSakujo
     * @param btnSakujo btnSakujo
     */
    @JsonProperty("btnSakujo")
    public void setBtnSakujo(Button btnSakujo) {
        this.btnSakujo = btnSakujo;
    }

    /*
     * getbtnHozon
     * @return btnHozon
     */
    @JsonProperty("btnHozon")
    public Button getBtnHozon() {
        return btnHozon;
    }

    /*
     * setbtnHozon
     * @param btnHozon btnHozon
     */
    @JsonProperty("btnHozon")
    public void setBtnHozon(Button btnHozon) {
        this.btnHozon = btnHozon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTextTokkiJikoTitle() {
        return this.getTblTextTokkiJiko().getLblTextTokkiJikoTitle();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoGun() {
        return this.getTblTextTokkiJiko().getLblTextTokkiJikoGun();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoHyphen() {
        return this.getTblTextTokkiJiko().getLblTextTokkiJikoHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokkiJikoNoText() {
        return this.getTblTextTokkiJiko().getTxtTokkiJikoNoText();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoNaiyo() {
        return this.getTblTextTokkiJiko().getLblTextTokkiJikoNaiyo();
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeiBunGuide() {
        return this.getTblTextTokkiJiko().getBtnTeikeiBunGuide();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkijikoInput() {
        return this.getTblTextTokkiJiko().getTxtTokkijikoInput();
    }

    @JsonIgnore
    public Label getLblImageTokkiJikoTitle() {
        return this.getTblTokkiJiko().getLblImageTokkiJikoTitle();
    }

    @JsonIgnore
    public Label getLblImageTokkiJikkoGun() {
        return this.getTblTokkiJiko().getLblImageTokkiJikkoGun();
    }

    @JsonIgnore
    public Label getLblImageTokkiJikkoHyphen() {
        return this.getTblTokkiJiko().getLblImageTokkiJikkoHyphen();
    }

    @JsonIgnore
    public TextBoxNum getLblImageTokkiJikkoNo() {
        return this.getTblTokkiJiko().getLblImageTokkiJikkoNo();
    }

    @JsonIgnore
    public Label getLblTokkiJikoNaiyomage() {
        return this.getTblTokkiJiko().getLblTokkiJikoNaiyomage();
    }

    @JsonIgnore
    public StaticImage getImgMaskingImage() {
        return this.getTblTokkiJiko().getImgMaskingImage();
    }

    // </editor-fold>
}
