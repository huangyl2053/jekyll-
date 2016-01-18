package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokenryoNofuGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenryoNofuGengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHokenryoNofuGengaku")
    private RadioButton radHokenryoNofuGengaku;
    @JsonProperty("HohenryoNofuPanel")
    private HohenryoNofuPanelDiv HohenryoNofuPanel;
    @JsonProperty("HohenryoNofuNyuryoku")
    private HohenryoNofuNyuryokuDiv HohenryoNofuNyuryoku;
    @JsonProperty("State")
    private RString State;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHokenryoNofuGengaku
     * @return radHokenryoNofuGengaku
     */
    @JsonProperty("radHokenryoNofuGengaku")
    public RadioButton getRadHokenryoNofuGengaku() {
        return radHokenryoNofuGengaku;
    }

    /*
     * setradHokenryoNofuGengaku
     * @param radHokenryoNofuGengaku radHokenryoNofuGengaku
     */
    @JsonProperty("radHokenryoNofuGengaku")
    public void setRadHokenryoNofuGengaku(RadioButton radHokenryoNofuGengaku) {
        this.radHokenryoNofuGengaku = radHokenryoNofuGengaku;
    }

    /*
     * getHohenryoNofuPanel
     * @return HohenryoNofuPanel
     */
    @JsonProperty("HohenryoNofuPanel")
    public HohenryoNofuPanelDiv getHohenryoNofuPanel() {
        return HohenryoNofuPanel;
    }

    /*
     * setHohenryoNofuPanel
     * @param HohenryoNofuPanel HohenryoNofuPanel
     */
    @JsonProperty("HohenryoNofuPanel")
    public void setHohenryoNofuPanel(HohenryoNofuPanelDiv HohenryoNofuPanel) {
        this.HohenryoNofuPanel = HohenryoNofuPanel;
    }

    /*
     * getHohenryoNofuNyuryoku
     * @return HohenryoNofuNyuryoku
     */
    @JsonProperty("HohenryoNofuNyuryoku")
    public HohenryoNofuNyuryokuDiv getHohenryoNofuNyuryoku() {
        return HohenryoNofuNyuryoku;
    }

    /*
     * setHohenryoNofuNyuryoku
     * @param HohenryoNofuNyuryoku HohenryoNofuNyuryoku
     */
    @JsonProperty("HohenryoNofuNyuryoku")
    public void setHohenryoNofuNyuryoku(HohenryoNofuNyuryokuDiv HohenryoNofuNyuryoku) {
        this.HohenryoNofuNyuryoku = HohenryoNofuNyuryoku;
    }

    /*
     * getState
     * @return State
     */
    @JsonProperty("State")
    public RString getState() {
        return State;
    }

    /*
     * setState
     * @param State State
     */
    @JsonProperty("State")
    public void setState(RString State) {
        this.State = State;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnTuikaSuru() {
        return this.getHohenryoNofuPanel().getBtnTuikaSuru();
    }

    @JsonIgnore
    public void  setBtnTuikaSuru(Button btnTuikaSuru) {
        this.getHohenryoNofuPanel().setBtnTuikaSuru(btnTuikaSuru);
    }

    @JsonIgnore
    public DataGrid<dghokenryoNofu_Row> getDghokenryoNofu() {
        return this.getHohenryoNofuPanel().getDghokenryoNofu();
    }

    @JsonIgnore
    public void  setDghokenryoNofu(DataGrid<dghokenryoNofu_Row> dghokenryoNofu) {
        this.getHohenryoNofuPanel().setDghokenryoNofu(dghokenryoNofu);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuFromDate() {
        return this.getHohenryoNofuNyuryoku().getTxtHohenryoNofuFromDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuFromDate(TextBoxDate txtHohenryoNofuFromDate) {
        this.getHohenryoNofuNyuryoku().setTxtHohenryoNofuFromDate(txtHohenryoNofuFromDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuToDate() {
        return this.getHohenryoNofuNyuryoku().getTxtHohenryoNofuToDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuToDate(TextBoxDate txtHohenryoNofuToDate) {
        this.getHohenryoNofuNyuryoku().setTxtHohenryoNofuToDate(txtHohenryoNofuToDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyouSuruShutokuDankai() {
        return this.getHohenryoNofuNyuryoku().getDdlTekiyouSuruShutokuDankai();
    }

    @JsonIgnore
    public void  setDdlTekiyouSuruShutokuDankai(DropDownList ddlTekiyouSuruShutokuDankai) {
        this.getHohenryoNofuNyuryoku().setDdlTekiyouSuruShutokuDankai(ddlTekiyouSuruShutokuDankai);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getHohenryoNofuNyuryoku().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getHohenryoNofuNyuryoku().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getHohenryoNofuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getHohenryoNofuNyuryoku().setBtnKakutei(btnKakutei);
    }

    // </editor-fold>
}
