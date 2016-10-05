package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShotokuJokyo のクラスファイル
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public class ShotokuJokyoDiv extends Panel implements IShotokuJokyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("txtShoriNendo")
    private TextBoxFlexibleDate txtShoriNendo;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("lblSetaiinShotoku")
    private Label lblSetaiinShotoku;
    @JsonProperty("dgSteaiinShotoku")
    private DataGrid<dgSteaiinShotoku_Row> dgSteaiinShotoku;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hdnMode")
    private RString hdnMode;
    @JsonProperty("hdnShikibetuCode")
    private RString hdnShikibetuCode;
    @JsonProperty("hdnShoriNendo")
    private RString hdnShoriNendo;
    @JsonProperty("hdnKijunYMD")
    private RString hdnKijunYMD;
    @JsonProperty("hdnDaialogSelectSetaiinJoho")
    private RString hdnDaialogSelectSetaiinJoho;
    @JsonProperty("hdnGyomuCode")
    private RString hdnGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * gettxtShoriNendo
     * @return txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public TextBoxFlexibleDate getTxtShoriNendo() {
        return txtShoriNendo;
    }

    /*
     * settxtShoriNendo
     * @param txtShoriNendo txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public void setTxtShoriNendo(TextBoxFlexibleDate txtShoriNendo) {
        this.txtShoriNendo = txtShoriNendo;
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
     * getlblSetaiinShotoku
     * @return lblSetaiinShotoku
     */
    @JsonProperty("lblSetaiinShotoku")
    public Label getLblSetaiinShotoku() {
        return lblSetaiinShotoku;
    }

    /*
     * setlblSetaiinShotoku
     * @param lblSetaiinShotoku lblSetaiinShotoku
     */
    @JsonProperty("lblSetaiinShotoku")
    public void setLblSetaiinShotoku(Label lblSetaiinShotoku) {
        this.lblSetaiinShotoku = lblSetaiinShotoku;
    }

    /*
     * getdgSteaiinShotoku
     * @return dgSteaiinShotoku
     */
    @JsonProperty("dgSteaiinShotoku")
    public DataGrid<dgSteaiinShotoku_Row> getDgSteaiinShotoku() {
        return dgSteaiinShotoku;
    }

    /*
     * setdgSteaiinShotoku
     * @param dgSteaiinShotoku dgSteaiinShotoku
     */
    @JsonProperty("dgSteaiinShotoku")
    public void setDgSteaiinShotoku(DataGrid<dgSteaiinShotoku_Row> dgSteaiinShotoku) {
        this.dgSteaiinShotoku = dgSteaiinShotoku;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * gethdnMode
     * @return hdnMode
     */
    @JsonProperty("hdnMode")
    public RString getHdnMode() {
        return hdnMode;
    }

    /*
     * sethdnMode
     * @param hdnMode hdnMode
     */
    @JsonProperty("hdnMode")
    public void setHdnMode(RString hdnMode) {
        this.hdnMode = hdnMode;
    }

    /*
     * gethdnShikibetuCode
     * @return hdnShikibetuCode
     */
    @JsonProperty("hdnShikibetuCode")
    public RString getHdnShikibetuCode() {
        return hdnShikibetuCode;
    }

    /*
     * sethdnShikibetuCode
     * @param hdnShikibetuCode hdnShikibetuCode
     */
    @JsonProperty("hdnShikibetuCode")
    public void setHdnShikibetuCode(RString hdnShikibetuCode) {
        this.hdnShikibetuCode = hdnShikibetuCode;
    }

    /*
     * gethdnShoriNendo
     * @return hdnShoriNendo
     */
    @JsonProperty("hdnShoriNendo")
    public RString getHdnShoriNendo() {
        return hdnShoriNendo;
    }

    /*
     * sethdnShoriNendo
     * @param hdnShoriNendo hdnShoriNendo
     */
    @JsonProperty("hdnShoriNendo")
    public void setHdnShoriNendo(RString hdnShoriNendo) {
        this.hdnShoriNendo = hdnShoriNendo;
    }

    /*
     * gethdnKijunYMD
     * @return hdnKijunYMD
     */
    @JsonProperty("hdnKijunYMD")
    public RString getHdnKijunYMD() {
        return hdnKijunYMD;
    }

    /*
     * sethdnKijunYMD
     * @param hdnKijunYMD hdnKijunYMD
     */
    @JsonProperty("hdnKijunYMD")
    public void setHdnKijunYMD(RString hdnKijunYMD) {
        this.hdnKijunYMD = hdnKijunYMD;
    }

    /*
     * gethdnDaialogSelectSetaiinJoho
     * @return hdnDaialogSelectSetaiinJoho
     */
    @JsonProperty("hdnDaialogSelectSetaiinJoho")
    public RString getHdnDaialogSelectSetaiinJoho() {
        return hdnDaialogSelectSetaiinJoho;
    }

    /*
     * sethdnDaialogSelectSetaiinJoho
     * @param hdnDaialogSelectSetaiinJoho hdnDaialogSelectSetaiinJoho
     */
    @JsonProperty("hdnDaialogSelectSetaiinJoho")
    public void setHdnDaialogSelectSetaiinJoho(RString hdnDaialogSelectSetaiinJoho) {
        this.hdnDaialogSelectSetaiinJoho = hdnDaialogSelectSetaiinJoho;
    }

    /*
     * gethdnGyomuCode
     * @return hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public RString getHdnGyomuCode() {
        return hdnGyomuCode;
    }

    /*
     * sethdnGyomuCode
     * @param hdnGyomuCode hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public void setHdnGyomuCode(RString hdnGyomuCode) {
        this.hdnGyomuCode = hdnGyomuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
