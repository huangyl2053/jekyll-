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
 * ShinsakaiKaisaiGogitaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiGogitaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeteibi")
    private TextBoxDate txtSeteibi;
    @JsonProperty("btnDayBefore")
    private Button btnDayBefore;
    @JsonProperty("btnDayAfter")
    private Button btnDayAfter;
    @JsonProperty("dgKaisaiYoteiNyuryokuran")
    private DataGrid<dgKaisaiYoteiNyuryokuran_Row> dgKaisaiYoteiNyuryokuran;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnShinsakaiIinWaritsuke")
    private Button btnShinsakaiIinWaritsuke;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSeteibi
     * @return txtSeteibi
     */
    @JsonProperty("txtSeteibi")
    public TextBoxDate getTxtSeteibi() {
        return txtSeteibi;
    }

    /*
     * settxtSeteibi
     * @param txtSeteibi txtSeteibi
     */
    @JsonProperty("txtSeteibi")
    public void setTxtSeteibi(TextBoxDate txtSeteibi) {
        this.txtSeteibi = txtSeteibi;
    }

    /*
     * getbtnDayBefore
     * @return btnDayBefore
     */
    @JsonProperty("btnDayBefore")
    public Button getBtnDayBefore() {
        return btnDayBefore;
    }

    /*
     * setbtnDayBefore
     * @param btnDayBefore btnDayBefore
     */
    @JsonProperty("btnDayBefore")
    public void setBtnDayBefore(Button btnDayBefore) {
        this.btnDayBefore = btnDayBefore;
    }

    /*
     * getbtnDayAfter
     * @return btnDayAfter
     */
    @JsonProperty("btnDayAfter")
    public Button getBtnDayAfter() {
        return btnDayAfter;
    }

    /*
     * setbtnDayAfter
     * @param btnDayAfter btnDayAfter
     */
    @JsonProperty("btnDayAfter")
    public void setBtnDayAfter(Button btnDayAfter) {
        this.btnDayAfter = btnDayAfter;
    }

    /*
     * getdgKaisaiYoteiNyuryokuran
     * @return dgKaisaiYoteiNyuryokuran
     */
    @JsonProperty("dgKaisaiYoteiNyuryokuran")
    public DataGrid<dgKaisaiYoteiNyuryokuran_Row> getDgKaisaiYoteiNyuryokuran() {
        return dgKaisaiYoteiNyuryokuran;
    }

    /*
     * setdgKaisaiYoteiNyuryokuran
     * @param dgKaisaiYoteiNyuryokuran dgKaisaiYoteiNyuryokuran
     */
    @JsonProperty("dgKaisaiYoteiNyuryokuran")
    public void setDgKaisaiYoteiNyuryokuran(DataGrid<dgKaisaiYoteiNyuryokuran_Row> dgKaisaiYoteiNyuryokuran) {
        this.dgKaisaiYoteiNyuryokuran = dgKaisaiYoteiNyuryokuran;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnShinsakaiIinWaritsuke
     * @return btnShinsakaiIinWaritsuke
     */
    @JsonProperty("btnShinsakaiIinWaritsuke")
    public Button getBtnShinsakaiIinWaritsuke() {
        return btnShinsakaiIinWaritsuke;
    }

    /*
     * setbtnShinsakaiIinWaritsuke
     * @param btnShinsakaiIinWaritsuke btnShinsakaiIinWaritsuke
     */
    @JsonProperty("btnShinsakaiIinWaritsuke")
    public void setBtnShinsakaiIinWaritsuke(Button btnShinsakaiIinWaritsuke) {
        this.btnShinsakaiIinWaritsuke = btnShinsakaiIinWaritsuke;
    }

    // </editor-fold>
}
