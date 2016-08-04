package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKaisaiYoteiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiYoteiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHyojiMonth")
    private Label lblHyojiMonth;
    @JsonProperty("btnMonthBefore")
    private Button btnMonthBefore;
    @JsonProperty("lblMonth")
    private Label lblMonth;
    @JsonProperty("btnRight")
    private Button btnRight;
    @JsonProperty("dgShinsakaiKaisaiYoteiIchiran")
    private DataGrid<dgShinsakaiKaisaiYoteiIchiran_Row> dgShinsakaiKaisaiYoteiIchiran;
    @JsonProperty("txtCopyFrom")
    private TextBox txtCopyFrom;
    @JsonProperty("lblCopyFrom")
    private Label lblCopyFrom;
    @JsonProperty("txtCopyTo")
    private TextBox txtCopyTo;
    @JsonProperty("lblCopyTo")
    private Label lblCopyTo;
    @JsonProperty("btnWeekCopy")
    private Button btnWeekCopy;
    @JsonProperty("btnKaisaiBangoFuban")
    private Button btnKaisaiBangoFuban;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHyojiMonth
     * @return lblHyojiMonth
     */
    @JsonProperty("lblHyojiMonth")
    public Label getLblHyojiMonth() {
        return lblHyojiMonth;
    }

    /*
     * setlblHyojiMonth
     * @param lblHyojiMonth lblHyojiMonth
     */
    @JsonProperty("lblHyojiMonth")
    public void setLblHyojiMonth(Label lblHyojiMonth) {
        this.lblHyojiMonth = lblHyojiMonth;
    }

    /*
     * getbtnMonthBefore
     * @return btnMonthBefore
     */
    @JsonProperty("btnMonthBefore")
    public Button getBtnMonthBefore() {
        return btnMonthBefore;
    }

    /*
     * setbtnMonthBefore
     * @param btnMonthBefore btnMonthBefore
     */
    @JsonProperty("btnMonthBefore")
    public void setBtnMonthBefore(Button btnMonthBefore) {
        this.btnMonthBefore = btnMonthBefore;
    }

    /*
     * getlblMonth
     * @return lblMonth
     */
    @JsonProperty("lblMonth")
    public Label getLblMonth() {
        return lblMonth;
    }

    /*
     * setlblMonth
     * @param lblMonth lblMonth
     */
    @JsonProperty("lblMonth")
    public void setLblMonth(Label lblMonth) {
        this.lblMonth = lblMonth;
    }

    /*
     * getbtnRight
     * @return btnRight
     */
    @JsonProperty("btnRight")
    public Button getBtnRight() {
        return btnRight;
    }

    /*
     * setbtnRight
     * @param btnRight btnRight
     */
    @JsonProperty("btnRight")
    public void setBtnRight(Button btnRight) {
        this.btnRight = btnRight;
    }

    /*
     * getdgShinsakaiKaisaiYoteiIchiran
     * @return dgShinsakaiKaisaiYoteiIchiran
     */
    @JsonProperty("dgShinsakaiKaisaiYoteiIchiran")
    public DataGrid<dgShinsakaiKaisaiYoteiIchiran_Row> getDgShinsakaiKaisaiYoteiIchiran() {
        return dgShinsakaiKaisaiYoteiIchiran;
    }

    /*
     * setdgShinsakaiKaisaiYoteiIchiran
     * @param dgShinsakaiKaisaiYoteiIchiran dgShinsakaiKaisaiYoteiIchiran
     */
    @JsonProperty("dgShinsakaiKaisaiYoteiIchiran")
    public void setDgShinsakaiKaisaiYoteiIchiran(DataGrid<dgShinsakaiKaisaiYoteiIchiran_Row> dgShinsakaiKaisaiYoteiIchiran) {
        this.dgShinsakaiKaisaiYoteiIchiran = dgShinsakaiKaisaiYoteiIchiran;
    }

    /*
     * gettxtCopyFrom
     * @return txtCopyFrom
     */
    @JsonProperty("txtCopyFrom")
    public TextBox getTxtCopyFrom() {
        return txtCopyFrom;
    }

    /*
     * settxtCopyFrom
     * @param txtCopyFrom txtCopyFrom
     */
    @JsonProperty("txtCopyFrom")
    public void setTxtCopyFrom(TextBox txtCopyFrom) {
        this.txtCopyFrom = txtCopyFrom;
    }

    /*
     * getlblCopyFrom
     * @return lblCopyFrom
     */
    @JsonProperty("lblCopyFrom")
    public Label getLblCopyFrom() {
        return lblCopyFrom;
    }

    /*
     * setlblCopyFrom
     * @param lblCopyFrom lblCopyFrom
     */
    @JsonProperty("lblCopyFrom")
    public void setLblCopyFrom(Label lblCopyFrom) {
        this.lblCopyFrom = lblCopyFrom;
    }

    /*
     * gettxtCopyTo
     * @return txtCopyTo
     */
    @JsonProperty("txtCopyTo")
    public TextBox getTxtCopyTo() {
        return txtCopyTo;
    }

    /*
     * settxtCopyTo
     * @param txtCopyTo txtCopyTo
     */
    @JsonProperty("txtCopyTo")
    public void setTxtCopyTo(TextBox txtCopyTo) {
        this.txtCopyTo = txtCopyTo;
    }

    /*
     * getlblCopyTo
     * @return lblCopyTo
     */
    @JsonProperty("lblCopyTo")
    public Label getLblCopyTo() {
        return lblCopyTo;
    }

    /*
     * setlblCopyTo
     * @param lblCopyTo lblCopyTo
     */
    @JsonProperty("lblCopyTo")
    public void setLblCopyTo(Label lblCopyTo) {
        this.lblCopyTo = lblCopyTo;
    }

    /*
     * getbtnWeekCopy
     * @return btnWeekCopy
     */
    @JsonProperty("btnWeekCopy")
    public Button getBtnWeekCopy() {
        return btnWeekCopy;
    }

    /*
     * setbtnWeekCopy
     * @param btnWeekCopy btnWeekCopy
     */
    @JsonProperty("btnWeekCopy")
    public void setBtnWeekCopy(Button btnWeekCopy) {
        this.btnWeekCopy = btnWeekCopy;
    }

    /*
     * getbtnKaisaiBangoFuban
     * @return btnKaisaiBangoFuban
     */
    @JsonProperty("btnKaisaiBangoFuban")
    public Button getBtnKaisaiBangoFuban() {
        return btnKaisaiBangoFuban;
    }

    /*
     * setbtnKaisaiBangoFuban
     * @param btnKaisaiBangoFuban btnKaisaiBangoFuban
     */
    @JsonProperty("btnKaisaiBangoFuban")
    public void setBtnKaisaiBangoFuban(Button btnKaisaiBangoFuban) {
        this.btnKaisaiBangoFuban = btnKaisaiBangoFuban;
    }

    // </editor-fold>
}
