package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001;
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
 * ShinsakaiKaisaiYoteiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiYoteiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiKaisaiYoteiIchiran")
    private ShinsakaiKaisaiYoteiIchiranDiv ShinsakaiKaisaiYoteiIchiran;
    @JsonProperty("ShinsakaiKaisaiGogitaiJohoIchran")
    private ShinsakaiKaisaiGogitaiJohoIchranDiv ShinsakaiKaisaiGogitaiJohoIchran;
    @JsonProperty("ShinsakaiKaisaiGogitaiJoho")
    private ShinsakaiKaisaiGogitaiJohoDiv ShinsakaiKaisaiGogitaiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiKaisaiYoteiIchiran
     * @return ShinsakaiKaisaiYoteiIchiran
     */
    @JsonProperty("ShinsakaiKaisaiYoteiIchiran")
    public ShinsakaiKaisaiYoteiIchiranDiv getShinsakaiKaisaiYoteiIchiran() {
        return ShinsakaiKaisaiYoteiIchiran;
    }

    /*
     * setShinsakaiKaisaiYoteiIchiran
     * @param ShinsakaiKaisaiYoteiIchiran ShinsakaiKaisaiYoteiIchiran
     */
    @JsonProperty("ShinsakaiKaisaiYoteiIchiran")
    public void setShinsakaiKaisaiYoteiIchiran(ShinsakaiKaisaiYoteiIchiranDiv ShinsakaiKaisaiYoteiIchiran) {
        this.ShinsakaiKaisaiYoteiIchiran = ShinsakaiKaisaiYoteiIchiran;
    }

    /*
     * getShinsakaiKaisaiGogitaiJohoIchran
     * @return ShinsakaiKaisaiGogitaiJohoIchran
     */
    @JsonProperty("ShinsakaiKaisaiGogitaiJohoIchran")
    public ShinsakaiKaisaiGogitaiJohoIchranDiv getShinsakaiKaisaiGogitaiJohoIchran() {
        return ShinsakaiKaisaiGogitaiJohoIchran;
    }

    /*
     * setShinsakaiKaisaiGogitaiJohoIchran
     * @param ShinsakaiKaisaiGogitaiJohoIchran ShinsakaiKaisaiGogitaiJohoIchran
     */
    @JsonProperty("ShinsakaiKaisaiGogitaiJohoIchran")
    public void setShinsakaiKaisaiGogitaiJohoIchran(ShinsakaiKaisaiGogitaiJohoIchranDiv ShinsakaiKaisaiGogitaiJohoIchran) {
        this.ShinsakaiKaisaiGogitaiJohoIchran = ShinsakaiKaisaiGogitaiJohoIchran;
    }

    /*
     * getShinsakaiKaisaiGogitaiJoho
     * @return ShinsakaiKaisaiGogitaiJoho
     */
    @JsonProperty("ShinsakaiKaisaiGogitaiJoho")
    public ShinsakaiKaisaiGogitaiJohoDiv getShinsakaiKaisaiGogitaiJoho() {
        return ShinsakaiKaisaiGogitaiJoho;
    }

    /*
     * setShinsakaiKaisaiGogitaiJoho
     * @param ShinsakaiKaisaiGogitaiJoho ShinsakaiKaisaiGogitaiJoho
     */
    @JsonProperty("ShinsakaiKaisaiGogitaiJoho")
    public void setShinsakaiKaisaiGogitaiJoho(ShinsakaiKaisaiGogitaiJohoDiv ShinsakaiKaisaiGogitaiJoho) {
        this.ShinsakaiKaisaiGogitaiJoho = ShinsakaiKaisaiGogitaiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblHyojiMonth() {
        return this.getShinsakaiKaisaiYoteiIchiran().getLblHyojiMonth();
    }

    @JsonIgnore
    public void  setLblHyojiMonth(Label lblHyojiMonth) {
        this.getShinsakaiKaisaiYoteiIchiran().setLblHyojiMonth(lblHyojiMonth);
    }

    @JsonIgnore
    public Button getBtnMonthBefore() {
        return this.getShinsakaiKaisaiYoteiIchiran().getBtnMonthBefore();
    }

    @JsonIgnore
    public void  setBtnMonthBefore(Button btnMonthBefore) {
        this.getShinsakaiKaisaiYoteiIchiran().setBtnMonthBefore(btnMonthBefore);
    }

    @JsonIgnore
    public Label getLblMonth() {
        return this.getShinsakaiKaisaiYoteiIchiran().getLblMonth();
    }

    @JsonIgnore
    public void  setLblMonth(Label lblMonth) {
        this.getShinsakaiKaisaiYoteiIchiran().setLblMonth(lblMonth);
    }

    @JsonIgnore
    public Button getBtnRight() {
        return this.getShinsakaiKaisaiYoteiIchiran().getBtnRight();
    }

    @JsonIgnore
    public void  setBtnRight(Button btnRight) {
        this.getShinsakaiKaisaiYoteiIchiran().setBtnRight(btnRight);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiKaisaiYoteiIchiran_Row> getDgShinsakaiKaisaiYoteiIchiran() {
        return this.getShinsakaiKaisaiYoteiIchiran().getDgShinsakaiKaisaiYoteiIchiran();
    }

    @JsonIgnore
    public void  setDgShinsakaiKaisaiYoteiIchiran(DataGrid<dgShinsakaiKaisaiYoteiIchiran_Row> dgShinsakaiKaisaiYoteiIchiran) {
        this.getShinsakaiKaisaiYoteiIchiran().setDgShinsakaiKaisaiYoteiIchiran(dgShinsakaiKaisaiYoteiIchiran);
    }

    @JsonIgnore
    public TextBox getTxtCopyFrom() {
        return this.getShinsakaiKaisaiYoteiIchiran().getTxtCopyFrom();
    }

    @JsonIgnore
    public void  setTxtCopyFrom(TextBox txtCopyFrom) {
        this.getShinsakaiKaisaiYoteiIchiran().setTxtCopyFrom(txtCopyFrom);
    }

    @JsonIgnore
    public Label getLblCopyFrom() {
        return this.getShinsakaiKaisaiYoteiIchiran().getLblCopyFrom();
    }

    @JsonIgnore
    public void  setLblCopyFrom(Label lblCopyFrom) {
        this.getShinsakaiKaisaiYoteiIchiran().setLblCopyFrom(lblCopyFrom);
    }

    @JsonIgnore
    public TextBox getTxtCopyTo() {
        return this.getShinsakaiKaisaiYoteiIchiran().getTxtCopyTo();
    }

    @JsonIgnore
    public void  setTxtCopyTo(TextBox txtCopyTo) {
        this.getShinsakaiKaisaiYoteiIchiran().setTxtCopyTo(txtCopyTo);
    }

    @JsonIgnore
    public Label getLblCopyTo() {
        return this.getShinsakaiKaisaiYoteiIchiran().getLblCopyTo();
    }

    @JsonIgnore
    public void  setLblCopyTo(Label lblCopyTo) {
        this.getShinsakaiKaisaiYoteiIchiran().setLblCopyTo(lblCopyTo);
    }

    @JsonIgnore
    public Button getBtnWeekCopy() {
        return this.getShinsakaiKaisaiYoteiIchiran().getBtnWeekCopy();
    }

    @JsonIgnore
    public void  setBtnWeekCopy(Button btnWeekCopy) {
        this.getShinsakaiKaisaiYoteiIchiran().setBtnWeekCopy(btnWeekCopy);
    }

    @JsonIgnore
    public Button getBtnKaisaiBangoFuban() {
        return this.getShinsakaiKaisaiYoteiIchiran().getBtnKaisaiBangoFuban();
    }

    @JsonIgnore
    public void  setBtnKaisaiBangoFuban(Button btnKaisaiBangoFuban) {
        this.getShinsakaiKaisaiYoteiIchiran().setBtnKaisaiBangoFuban(btnKaisaiBangoFuban);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiKaisaiGogitaiJoho_Row> getDgShinsakaiKaisaiGogitaiJoho() {
        return this.getShinsakaiKaisaiGogitaiJohoIchran().getDgShinsakaiKaisaiGogitaiJoho();
    }

    @JsonIgnore
    public void  setDgShinsakaiKaisaiGogitaiJoho(DataGrid<dgShinsakaiKaisaiGogitaiJoho_Row> dgShinsakaiKaisaiGogitaiJoho) {
        this.getShinsakaiKaisaiGogitaiJohoIchran().setDgShinsakaiKaisaiGogitaiJoho(dgShinsakaiKaisaiGogitaiJoho);
    }

    @JsonIgnore
    public TextBoxDate getTxtSeteibi() {
        return this.getShinsakaiKaisaiGogitaiJoho().getTxtSeteibi();
    }

    @JsonIgnore
    public void  setTxtSeteibi(TextBoxDate txtSeteibi) {
        this.getShinsakaiKaisaiGogitaiJoho().setTxtSeteibi(txtSeteibi);
    }

    @JsonIgnore
    public Button getBtnDayBefore() {
        return this.getShinsakaiKaisaiGogitaiJoho().getBtnDayBefore();
    }

    @JsonIgnore
    public void  setBtnDayBefore(Button btnDayBefore) {
        this.getShinsakaiKaisaiGogitaiJoho().setBtnDayBefore(btnDayBefore);
    }

    @JsonIgnore
    public Button getBtnDayAfter() {
        return this.getShinsakaiKaisaiGogitaiJoho().getBtnDayAfter();
    }

    @JsonIgnore
    public void  setBtnDayAfter(Button btnDayAfter) {
        this.getShinsakaiKaisaiGogitaiJoho().setBtnDayAfter(btnDayAfter);
    }

    @JsonIgnore
    public DataGrid<dgKaisaiYoteiNyuryokuran_Row> getDgKaisaiYoteiNyuryokuran() {
        return this.getShinsakaiKaisaiGogitaiJoho().getDgKaisaiYoteiNyuryokuran();
    }

    @JsonIgnore
    public void  setDgKaisaiYoteiNyuryokuran(DataGrid<dgKaisaiYoteiNyuryokuran_Row> dgKaisaiYoteiNyuryokuran) {
        this.getShinsakaiKaisaiGogitaiJoho().setDgKaisaiYoteiNyuryokuran(dgKaisaiYoteiNyuryokuran);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getShinsakaiKaisaiGogitaiJoho().getBtnToroku();
    }

    @JsonIgnore
    public void  setBtnToroku(Button btnToroku) {
        this.getShinsakaiKaisaiGogitaiJoho().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getShinsakaiKaisaiGogitaiJoho().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getShinsakaiKaisaiGogitaiJoho().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnShinsakaiIinWaritsuke() {
        return this.getShinsakaiKaisaiGogitaiJoho().getBtnShinsakaiIinWaritsuke();
    }

    @JsonIgnore
    public void  setBtnShinsakaiIinWaritsuke(Button btnShinsakaiIinWaritsuke) {
        this.getShinsakaiKaisaiGogitaiJoho().setBtnShinsakaiIinWaritsuke(btnShinsakaiIinWaritsuke);
    }

    // </editor-fold>
}
