package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
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
 * ChosaTaishoWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaTaishoWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    private WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha;
    @JsonProperty("txtChosaIraiDay")
    private TextBoxDate txtChosaIraiDay;
    @JsonProperty("btnWaritsuke")
    private Button btnWaritsuke;
    @JsonProperty("btnKaijo")
    private Button btnKaijo;
    @JsonProperty("MiwaritsukeShinseisha")
    private MiwaritsukeShinseishaDiv MiwaritsukeShinseisha;
    @JsonProperty("btnBackToChosaItakusakiSentaku")
    private Button btnBackToChosaItakusakiSentaku;
    @JsonProperty("btnBackToChosainSentaku")
    private Button btnBackToChosainSentaku;
    @JsonProperty("btnHozon")
    private Button btnHozon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getWaritsukeZumiTaishosha
     * @return WaritsukeZumiTaishosha
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    public WaritsukeZumiTaishoshaDiv getWaritsukeZumiTaishosha() {
        return WaritsukeZumiTaishosha;
    }

    /*
     * setWaritsukeZumiTaishosha
     * @param WaritsukeZumiTaishosha WaritsukeZumiTaishosha
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    public void setWaritsukeZumiTaishosha(WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha) {
        this.WaritsukeZumiTaishosha = WaritsukeZumiTaishosha;
    }

    /*
     * gettxtChosaIraiDay
     * @return txtChosaIraiDay
     */
    @JsonProperty("txtChosaIraiDay")
    public TextBoxDate getTxtChosaIraiDay() {
        return txtChosaIraiDay;
    }

    /*
     * settxtChosaIraiDay
     * @param txtChosaIraiDay txtChosaIraiDay
     */
    @JsonProperty("txtChosaIraiDay")
    public void setTxtChosaIraiDay(TextBoxDate txtChosaIraiDay) {
        this.txtChosaIraiDay = txtChosaIraiDay;
    }

    /*
     * getbtnWaritsuke
     * @return btnWaritsuke
     */
    @JsonProperty("btnWaritsuke")
    public Button getBtnWaritsuke() {
        return btnWaritsuke;
    }

    /*
     * setbtnWaritsuke
     * @param btnWaritsuke btnWaritsuke
     */
    @JsonProperty("btnWaritsuke")
    public void setBtnWaritsuke(Button btnWaritsuke) {
        this.btnWaritsuke = btnWaritsuke;
    }

    /*
     * getbtnKaijo
     * @return btnKaijo
     */
    @JsonProperty("btnKaijo")
    public Button getBtnKaijo() {
        return btnKaijo;
    }

    /*
     * setbtnKaijo
     * @param btnKaijo btnKaijo
     */
    @JsonProperty("btnKaijo")
    public void setBtnKaijo(Button btnKaijo) {
        this.btnKaijo = btnKaijo;
    }

    /*
     * getMiwaritsukeShinseisha
     * @return MiwaritsukeShinseisha
     */
    @JsonProperty("MiwaritsukeShinseisha")
    public MiwaritsukeShinseishaDiv getMiwaritsukeShinseisha() {
        return MiwaritsukeShinseisha;
    }

    /*
     * setMiwaritsukeShinseisha
     * @param MiwaritsukeShinseisha MiwaritsukeShinseisha
     */
    @JsonProperty("MiwaritsukeShinseisha")
    public void setMiwaritsukeShinseisha(MiwaritsukeShinseishaDiv MiwaritsukeShinseisha) {
        this.MiwaritsukeShinseisha = MiwaritsukeShinseisha;
    }

    /*
     * getbtnBackToChosaItakusakiSentaku
     * @return btnBackToChosaItakusakiSentaku
     */
    @JsonProperty("btnBackToChosaItakusakiSentaku")
    public Button getBtnBackToChosaItakusakiSentaku() {
        return btnBackToChosaItakusakiSentaku;
    }

    /*
     * setbtnBackToChosaItakusakiSentaku
     * @param btnBackToChosaItakusakiSentaku btnBackToChosaItakusakiSentaku
     */
    @JsonProperty("btnBackToChosaItakusakiSentaku")
    public void setBtnBackToChosaItakusakiSentaku(Button btnBackToChosaItakusakiSentaku) {
        this.btnBackToChosaItakusakiSentaku = btnBackToChosaItakusakiSentaku;
    }

    /*
     * getbtnBackToChosainSentaku
     * @return btnBackToChosainSentaku
     */
    @JsonProperty("btnBackToChosainSentaku")
    public Button getBtnBackToChosainSentaku() {
        return btnBackToChosainSentaku;
    }

    /*
     * setbtnBackToChosainSentaku
     * @param btnBackToChosainSentaku btnBackToChosainSentaku
     */
    @JsonProperty("btnBackToChosainSentaku")
    public void setBtnBackToChosainSentaku(Button btnBackToChosainSentaku) {
        this.btnBackToChosainSentaku = btnBackToChosainSentaku;
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
    public DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> getDgWaritsukeZumiShinseishaIchiran() {
        return this.getWaritsukeZumiTaishosha().getDgWaritsukeZumiShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgWaritsukeZumiShinseishaIchiran(DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran) {
        this.getWaritsukeZumiTaishosha().setDgWaritsukeZumiShinseishaIchiran(dgWaritsukeZumiShinseishaIchiran);
    }

    @JsonIgnore
    public DataGrid<dgMiwaritsukeShinseishaIchiran_Row> getDgMiwaritsukeShinseishaIchiran() {
        return this.getMiwaritsukeShinseisha().getDgMiwaritsukeShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgMiwaritsukeShinseishaIchiran(DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran) {
        this.getMiwaritsukeShinseisha().setDgMiwaritsukeShinseishaIchiran(dgMiwaritsukeShinseishaIchiran);
    }

    // </editor-fold>
}
