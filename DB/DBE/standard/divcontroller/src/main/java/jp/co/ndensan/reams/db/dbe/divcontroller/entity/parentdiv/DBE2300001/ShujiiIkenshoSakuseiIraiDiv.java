package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.INinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoSakuseiIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoSakuseiIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuOption")
    private KensakuOptionDiv KensakuOption;
    @JsonProperty("ShinseishaIchiran")
    private ShinseishaIchiranDiv ShinseishaIchiran;
    @JsonProperty("ShujiiIkenshoIraiJohoInput")
    private ShujiiIkenshoIraiJohoInputDiv ShujiiIkenshoIraiJohoInput;
    @JsonProperty("hdnClickedButton")
    private RString hdnClickedButton;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuOption
     * @return KensakuOption
     */
    @JsonProperty("KensakuOption")
    public KensakuOptionDiv getKensakuOption() {
        return KensakuOption;
    }

    /*
     * setKensakuOption
     * @param KensakuOption KensakuOption
     */
    @JsonProperty("KensakuOption")
    public void setKensakuOption(KensakuOptionDiv KensakuOption) {
        this.KensakuOption = KensakuOption;
    }

    /*
     * getShinseishaIchiran
     * @return ShinseishaIchiran
     */
    @JsonProperty("ShinseishaIchiran")
    public ShinseishaIchiranDiv getShinseishaIchiran() {
        return ShinseishaIchiran;
    }

    /*
     * setShinseishaIchiran
     * @param ShinseishaIchiran ShinseishaIchiran
     */
    @JsonProperty("ShinseishaIchiran")
    public void setShinseishaIchiran(ShinseishaIchiranDiv ShinseishaIchiran) {
        this.ShinseishaIchiran = ShinseishaIchiran;
    }

    /*
     * getShujiiIkenshoIraiJohoInput
     * @return ShujiiIkenshoIraiJohoInput
     */
    @JsonProperty("ShujiiIkenshoIraiJohoInput")
    public ShujiiIkenshoIraiJohoInputDiv getShujiiIkenshoIraiJohoInput() {
        return ShujiiIkenshoIraiJohoInput;
    }

    /*
     * setShujiiIkenshoIraiJohoInput
     * @param ShujiiIkenshoIraiJohoInput ShujiiIkenshoIraiJohoInput
     */
    @JsonProperty("ShujiiIkenshoIraiJohoInput")
    public void setShujiiIkenshoIraiJohoInput(ShujiiIkenshoIraiJohoInputDiv ShujiiIkenshoIraiJohoInput) {
        this.ShujiiIkenshoIraiJohoInput = ShujiiIkenshoIraiJohoInput;
    }

    /*
     * gethdnClickedButton
     * @return hdnClickedButton
     */
    @JsonProperty("hdnClickedButton")
    public RString getHdnClickedButton() {
        return hdnClickedButton;
    }

    /*
     * sethdnClickedButton
     * @param hdnClickedButton hdnClickedButton
     */
    @JsonProperty("hdnClickedButton")
    public void setHdnClickedButton(RString hdnClickedButton) {
        this.hdnClickedButton = hdnClickedButton;
    }

    /*
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuOption().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuOption().setBtnClear(btnClear);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getKensakuOption().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getKensakuOption().setTxtMaxDisp(txtMaxDisp);
    }

    @JsonIgnore
    public INinteiShinseishaFinderDiv getCcdNinteishinseishaFinder() {
        return this.getKensakuOption().getCcdNinteishinseishaFinder();
    }

    @JsonIgnore
    public DataGrid<dgShinseishaIchiran_Row> getDgShinseishaIchiran() {
        return this.getShinseishaIchiran().getDgShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgShinseishaIchiran(DataGrid<dgShinseishaIchiran_Row> dgShinseishaIchiran) {
        this.getShinseishaIchiran().setDgShinseishaIchiran(dgShinseishaIchiran);
    }

    @JsonIgnore
    public ButtonDialog getBtnPrint() {
        return this.getShinseishaIchiran().getBtnPrint();
    }

    @JsonIgnore
    public void  setBtnPrint(ButtonDialog btnPrint) {
        this.getShinseishaIchiran().setBtnPrint(btnPrint);
    }

    @JsonIgnore
    public ShujiiIryoKikanNyuryokuDiv getShujiiIryoKikanNyuryoku() {
        return this.getShujiiIkenshoIraiJohoInput().getShujiiIryoKikanNyuryoku();
    }

    @JsonIgnore
    public void  setShujiiIryoKikanNyuryoku(ShujiiIryoKikanNyuryokuDiv ShujiiIryoKikanNyuryoku) {
        this.getShujiiIkenshoIraiJohoInput().setShujiiIryoKikanNyuryoku(ShujiiIryoKikanNyuryoku);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return this.getShujiiIkenshoIraiJohoInput().getShujiiIryoKikanNyuryoku().getCcdShujiiIryoKikanAndShujiiInput();
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShujiiIkenshoIraiJohoInput().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getShujiiIkenshoIraiJohoInput().setLin1(lin1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkensahoSakuseiIraiDay() {
        return this.getShujiiIkenshoIraiJohoInput().getTxtShujiiIkensahoSakuseiIraiDay();
    }

    @JsonIgnore
    public void  setTxtShujiiIkensahoSakuseiIraiDay(TextBoxDate txtShujiiIkensahoSakuseiIraiDay) {
        this.getShujiiIkenshoIraiJohoInput().setTxtShujiiIkensahoSakuseiIraiDay(txtShujiiIkensahoSakuseiIraiDay);
    }

    @JsonIgnore
    public Button getBtnIrai() {
        return this.getShujiiIkenshoIraiJohoInput().getBtnIrai();
    }

    @JsonIgnore
    public void  setBtnIrai(Button btnIrai) {
        this.getShujiiIkenshoIraiJohoInput().setBtnIrai(btnIrai);
    }

    // </editor-fold>
}
