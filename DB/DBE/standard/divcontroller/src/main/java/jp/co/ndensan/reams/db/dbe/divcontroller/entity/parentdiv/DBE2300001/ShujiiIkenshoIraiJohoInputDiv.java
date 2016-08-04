package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoIraiJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoIraiJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiIryoKikanNyuryoku")
    private ShujiiIryoKikanNyuryokuDiv ShujiiIryoKikanNyuryoku;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtShujiiIkensahoSakuseiIraiDay")
    private TextBoxDate txtShujiiIkensahoSakuseiIraiDay;
    @JsonProperty("btnIrai")
    private Button btnIrai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiIryoKikanNyuryoku
     * @return ShujiiIryoKikanNyuryoku
     */
    @JsonProperty("ShujiiIryoKikanNyuryoku")
    public ShujiiIryoKikanNyuryokuDiv getShujiiIryoKikanNyuryoku() {
        return ShujiiIryoKikanNyuryoku;
    }

    /*
     * setShujiiIryoKikanNyuryoku
     * @param ShujiiIryoKikanNyuryoku ShujiiIryoKikanNyuryoku
     */
    @JsonProperty("ShujiiIryoKikanNyuryoku")
    public void setShujiiIryoKikanNyuryoku(ShujiiIryoKikanNyuryokuDiv ShujiiIryoKikanNyuryoku) {
        this.ShujiiIryoKikanNyuryoku = ShujiiIryoKikanNyuryoku;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtShujiiIkensahoSakuseiIraiDay
     * @return txtShujiiIkensahoSakuseiIraiDay
     */
    @JsonProperty("txtShujiiIkensahoSakuseiIraiDay")
    public TextBoxDate getTxtShujiiIkensahoSakuseiIraiDay() {
        return txtShujiiIkensahoSakuseiIraiDay;
    }

    /*
     * settxtShujiiIkensahoSakuseiIraiDay
     * @param txtShujiiIkensahoSakuseiIraiDay txtShujiiIkensahoSakuseiIraiDay
     */
    @JsonProperty("txtShujiiIkensahoSakuseiIraiDay")
    public void setTxtShujiiIkensahoSakuseiIraiDay(TextBoxDate txtShujiiIkensahoSakuseiIraiDay) {
        this.txtShujiiIkensahoSakuseiIraiDay = txtShujiiIkensahoSakuseiIraiDay;
    }

    /*
     * getbtnIrai
     * @return btnIrai
     */
    @JsonProperty("btnIrai")
    public Button getBtnIrai() {
        return btnIrai;
    }

    /*
     * setbtnIrai
     * @param btnIrai btnIrai
     */
    @JsonProperty("btnIrai")
    public void setBtnIrai(Button btnIrai) {
        this.btnIrai = btnIrai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return this.getShujiiIryoKikanNyuryoku().getCcdShujiiIryoKikanAndShujiiInput();
    }

    // </editor-fold>
}
