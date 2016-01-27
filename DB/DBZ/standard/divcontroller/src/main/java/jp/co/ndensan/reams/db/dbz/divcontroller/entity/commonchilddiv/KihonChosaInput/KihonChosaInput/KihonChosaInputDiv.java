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
 * KihonChosaInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonChosaInputDiv extends Panel implements IKihonChosaInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonChosaIchiran")
    private KihonChosaIchiranDiv KihonChosaIchiran;
    @JsonProperty("TokkiJiko")
    private TokkiJikoDiv TokkiJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonChosaIchiran
     * @return KihonChosaIchiran
     */
    @JsonProperty("KihonChosaIchiran")
    public KihonChosaIchiranDiv getKihonChosaIchiran() {
        return KihonChosaIchiran;
    }

    /*
     * setKihonChosaIchiran
     * @param KihonChosaIchiran KihonChosaIchiran
     */
    @JsonProperty("KihonChosaIchiran")
    public void setKihonChosaIchiran(KihonChosaIchiranDiv KihonChosaIchiran) {
        this.KihonChosaIchiran = KihonChosaIchiran;
    }

    /*
     * getTokkiJiko
     * @return TokkiJiko
     */
    @JsonProperty("TokkiJiko")
    public TokkiJikoDiv getTokkiJiko() {
        return TokkiJiko;
    }

    /*
     * setTokkiJiko
     * @param TokkiJiko TokkiJiko
     */
    @JsonProperty("TokkiJiko")
    public void setTokkiJiko(TokkiJikoDiv TokkiJiko) {
        this.TokkiJiko = TokkiJiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKihonChosaKomokuIchiran_Row> getDgKihonChosaKomokuIchiran() {
        return this.getKihonChosaIchiran().getDgKihonChosaKomokuIchiran();
    }

    @JsonIgnore
    public void  setDgKihonChosaKomokuIchiran(DataGrid<dgKihonChosaKomokuIchiran_Row> dgKihonChosaKomokuIchiran) {
        this.getKihonChosaIchiran().setDgKihonChosaKomokuIchiran(dgKihonChosaKomokuIchiran);
    }

    @JsonIgnore
    public Button getBtnNextGun() {
        return this.getKihonChosaIchiran().getBtnNextGun();
    }

    @JsonIgnore
    public void  setBtnNextGun(Button btnNextGun) {
        this.getKihonChosaIchiran().setBtnNextGun(btnNextGun);
    }

    @JsonIgnore
    public DataGrid<dgHanrei_Row> getDgHanrei() {
        return this.getTokkiJiko().getDgHanrei();
    }

    @JsonIgnore
    public void  setDgHanrei(DataGrid<dgHanrei_Row> dgHanrei) {
        this.getTokkiJiko().setDgHanrei(dgHanrei);
    }

    @JsonIgnore
    public tblTextTokkiJikoDiv getTblTextTokkiJiko() {
        return this.getTokkiJiko().getTblTextTokkiJiko();
    }

    @JsonIgnore
    public void  setTblTextTokkiJiko(tblTextTokkiJikoDiv tblTextTokkiJiko) {
        this.getTokkiJiko().setTblTextTokkiJiko(tblTextTokkiJiko);
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoTitle() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getLblTextTokkiJikoTitle();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoGun() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getLblTextTokkiJikoGun();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoHyphen() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getLblTextTokkiJikoHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtTokkiJikoNoText() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getTxtTokkiJikoNoText();
    }

    @JsonIgnore
    public Label getLblTextTokkiJikoNaiyo() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getLblTextTokkiJikoNaiyo();
    }

    @JsonIgnore
    public ButtonDialog getBtnTeikeiBunGuide() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getBtnTeikeiBunGuide();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkijikoInput() {
        return this.getTokkiJiko().getTblTextTokkiJiko().getTxtTokkijikoInput();
    }

    @JsonIgnore
    public ButtonDialog getBtnTextMasking() {
        return this.getTokkiJiko().getBtnTextMasking();
    }

    @JsonIgnore
    public void  setBtnTextMasking(ButtonDialog btnTextMasking) {
        this.getTokkiJiko().setBtnTextMasking(btnTextMasking);
    }

    @JsonIgnore
    public Button getBtnBeforeTextTokkiJiko() {
        return this.getTokkiJiko().getBtnBeforeTextTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnBeforeTextTokkiJiko(Button btnBeforeTextTokkiJiko) {
        this.getTokkiJiko().setBtnBeforeTextTokkiJiko(btnBeforeTextTokkiJiko);
    }

    @JsonIgnore
    public Label getLblTextCurrentHyojiNo() {
        return this.getTokkiJiko().getLblTextCurrentHyojiNo();
    }

    @JsonIgnore
    public void  setLblTextCurrentHyojiNo(Label lblTextCurrentHyojiNo) {
        this.getTokkiJiko().setLblTextCurrentHyojiNo(lblTextCurrentHyojiNo);
    }

    @JsonIgnore
    public Label getLblTextMaxPerCurrent() {
        return this.getTokkiJiko().getLblTextMaxPerCurrent();
    }

    @JsonIgnore
    public void  setLblTextMaxPerCurrent(Label lblTextMaxPerCurrent) {
        this.getTokkiJiko().setLblTextMaxPerCurrent(lblTextMaxPerCurrent);
    }

    @JsonIgnore
    public Label getLblTextMaxHyojino() {
        return this.getTokkiJiko().getLblTextMaxHyojino();
    }

    @JsonIgnore
    public void  setLblTextMaxHyojino(Label lblTextMaxHyojino) {
        this.getTokkiJiko().setLblTextMaxHyojino(lblTextMaxHyojino);
    }

    @JsonIgnore
    public Button getBtnAfterTextTokkiJiko() {
        return this.getTokkiJiko().getBtnAfterTextTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnAfterTextTokkiJiko(Button btnAfterTextTokkiJiko) {
        this.getTokkiJiko().setBtnAfterTextTokkiJiko(btnAfterTextTokkiJiko);
    }

    @JsonIgnore
    public HorizontalLine getLinHolizontal() {
        return this.getTokkiJiko().getLinHolizontal();
    }

    @JsonIgnore
    public void  setLinHolizontal(HorizontalLine linHolizontal) {
        this.getTokkiJiko().setLinHolizontal(linHolizontal);
    }

    @JsonIgnore
    public tblTokkiJikoDiv getTblTokkiJiko() {
        return this.getTokkiJiko().getTblTokkiJiko();
    }

    @JsonIgnore
    public void  setTblTokkiJiko(tblTokkiJikoDiv tblTokkiJiko) {
        this.getTokkiJiko().setTblTokkiJiko(tblTokkiJiko);
    }

    @JsonIgnore
    public Label getLblImageTokkiJikoTitle() {
        return this.getTokkiJiko().getTblTokkiJiko().getLblImageTokkiJikoTitle();
    }

    @JsonIgnore
    public Label getLblImageTokkiJikkoGun() {
        return this.getTokkiJiko().getTblTokkiJiko().getLblImageTokkiJikkoGun();
    }

    @JsonIgnore
    public Label getLblImageTokkiJikkoHyphen() {
        return this.getTokkiJiko().getTblTokkiJiko().getLblImageTokkiJikkoHyphen();
    }

    @JsonIgnore
    public TextBoxNum getLblImageTokkiJikkoNo() {
        return this.getTokkiJiko().getTblTokkiJiko().getLblImageTokkiJikkoNo();
    }

    @JsonIgnore
    public Label getLblTokkiJikoNaiyomage() {
        return this.getTokkiJiko().getTblTokkiJiko().getLblTokkiJikoNaiyomage();
    }

    @JsonIgnore
    public StaticImage getImgMaskingImage() {
        return this.getTokkiJiko().getTblTokkiJiko().getImgMaskingImage();
    }

    @JsonIgnore
    public Button getBtnBeforeImageTokkiJiko() {
        return this.getTokkiJiko().getBtnBeforeImageTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnBeforeImageTokkiJiko(Button btnBeforeImageTokkiJiko) {
        this.getTokkiJiko().setBtnBeforeImageTokkiJiko(btnBeforeImageTokkiJiko);
    }

    @JsonIgnore
    public Label getLblImageCurrentHyojiNo() {
        return this.getTokkiJiko().getLblImageCurrentHyojiNo();
    }

    @JsonIgnore
    public void  setLblImageCurrentHyojiNo(Label lblImageCurrentHyojiNo) {
        this.getTokkiJiko().setLblImageCurrentHyojiNo(lblImageCurrentHyojiNo);
    }

    @JsonIgnore
    public Label getLblImageMaxPerCurrent() {
        return this.getTokkiJiko().getLblImageMaxPerCurrent();
    }

    @JsonIgnore
    public void  setLblImageMaxPerCurrent(Label lblImageMaxPerCurrent) {
        this.getTokkiJiko().setLblImageMaxPerCurrent(lblImageMaxPerCurrent);
    }

    @JsonIgnore
    public Label getLblImageTokkiNo() {
        return this.getTokkiJiko().getLblImageTokkiNo();
    }

    @JsonIgnore
    public void  setLblImageTokkiNo(Label lblImageTokkiNo) {
        this.getTokkiJiko().setLblImageTokkiNo(lblImageTokkiNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnImageMasking() {
        return this.getTokkiJiko().getBtnImageMasking();
    }

    @JsonIgnore
    public void  setBtnImageMasking(ButtonDialog btnImageMasking) {
        this.getTokkiJiko().setBtnImageMasking(btnImageMasking);
    }

    @JsonIgnore
    public Button getBtnAfterImageTokkiJiko() {
        return this.getTokkiJiko().getBtnAfterImageTokkiJiko();
    }

    @JsonIgnore
    public void  setBtnAfterImageTokkiJiko(Button btnAfterImageTokkiJiko) {
        this.getTokkiJiko().setBtnAfterImageTokkiJiko(btnAfterImageTokkiJiko);
    }

    @JsonIgnore
    public Button getBtnSakujo() {
        return this.getTokkiJiko().getBtnSakujo();
    }

    @JsonIgnore
    public void  setBtnSakujo(Button btnSakujo) {
        this.getTokkiJiko().setBtnSakujo(btnSakujo);
    }

    @JsonIgnore
    public Button getBtnHozon() {
        return this.getTokkiJiko().getBtnHozon();
    }

    @JsonIgnore
    public void  setBtnHozon(Button btnHozon) {
        this.getTokkiJiko().setBtnHozon(btnHozon);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
