package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002;
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
 * NinteiChosaScheduleShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaScheduleShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchNinteiChosaSchedule")
    private SearchNinteiChosaScheduleDiv SearchNinteiChosaSchedule;
    @JsonProperty("NchosainScheduleIchiran")
    private NchosainScheduleIchiranDiv NchosainScheduleIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchNinteiChosaSchedule
     * @return SearchNinteiChosaSchedule
     */
    @JsonProperty("SearchNinteiChosaSchedule")
    public SearchNinteiChosaScheduleDiv getSearchNinteiChosaSchedule() {
        return SearchNinteiChosaSchedule;
    }

    /*
     * setSearchNinteiChosaSchedule
     * @param SearchNinteiChosaSchedule SearchNinteiChosaSchedule
     */
    @JsonProperty("SearchNinteiChosaSchedule")
    public void setSearchNinteiChosaSchedule(SearchNinteiChosaScheduleDiv SearchNinteiChosaSchedule) {
        this.SearchNinteiChosaSchedule = SearchNinteiChosaSchedule;
    }

    /*
     * getNchosainScheduleIchiran
     * @return NchosainScheduleIchiran
     */
    @JsonProperty("NchosainScheduleIchiran")
    public NchosainScheduleIchiranDiv getNchosainScheduleIchiran() {
        return NchosainScheduleIchiran;
    }

    /*
     * setNchosainScheduleIchiran
     * @param NchosainScheduleIchiran NchosainScheduleIchiran
     */
    @JsonProperty("NchosainScheduleIchiran")
    public void setNchosainScheduleIchiran(NchosainScheduleIchiranDiv NchosainScheduleIchiran) {
        this.NchosainScheduleIchiran = NchosainScheduleIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtSetteiDate() {
        return this.getSearchNinteiChosaSchedule().getTxtSetteiDate();
    }

    @JsonIgnore
    public void  setTxtSetteiDate(TextBoxFlexibleDate txtSetteiDate) {
        this.getSearchNinteiChosaSchedule().setTxtSetteiDate(txtSetteiDate);
    }

    @JsonIgnore
    public Button getBtnSetteiDateToZenjitsu() {
        return this.getSearchNinteiChosaSchedule().getBtnSetteiDateToZenjitsu();
    }

    @JsonIgnore
    public void  setBtnSetteiDateToZenjitsu(Button btnSetteiDateToZenjitsu) {
        this.getSearchNinteiChosaSchedule().setBtnSetteiDateToZenjitsu(btnSetteiDateToZenjitsu);
    }

    @JsonIgnore
    public Button getBtnSetteiDateToJijitsu() {
        return this.getSearchNinteiChosaSchedule().getBtnSetteiDateToJijitsu();
    }

    @JsonIgnore
    public void  setBtnSetteiDateToJijitsu(Button btnSetteiDateToJijitsu) {
        this.getSearchNinteiChosaSchedule().setBtnSetteiDateToJijitsu(btnSetteiDateToJijitsu);
    }

    @JsonIgnore
    public TextBox getTxtTsujoMemo() {
        return this.getSearchNinteiChosaSchedule().getTxtTsujoMemo();
    }

    @JsonIgnore
    public void  setTxtTsujoMemo(TextBox txtTsujoMemo) {
        this.getSearchNinteiChosaSchedule().setTxtTsujoMemo(txtTsujoMemo);
    }

    @JsonIgnore
    public TextBox getTxtJuyoMemo() {
        return this.getSearchNinteiChosaSchedule().getTxtJuyoMemo();
    }

    @JsonIgnore
    public void  setTxtJuyoMemo(TextBox txtJuyoMemo) {
        this.getSearchNinteiChosaSchedule().setTxtJuyoMemo(txtJuyoMemo);
    }

    @JsonIgnore
    public ButtonDialog getBtnDisplayMemoInformation() {
        return this.getSearchNinteiChosaSchedule().getBtnDisplayMemoInformation();
    }

    @JsonIgnore
    public void  setBtnDisplayMemoInformation(ButtonDialog btnDisplayMemoInformation) {
        this.getSearchNinteiChosaSchedule().setBtnDisplayMemoInformation(btnDisplayMemoInformation);
    }

    @JsonIgnore
    public DropDownList getDdlTaishoChiku() {
        return this.getSearchNinteiChosaSchedule().getDdlTaishoChiku();
    }

    @JsonIgnore
    public void  setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.getSearchNinteiChosaSchedule().setDdlTaishoChiku(ddlTaishoChiku);
    }

    @JsonIgnore
    public RadioButton getRadChosainJokyo() {
        return this.getSearchNinteiChosaSchedule().getRadChosainJokyo();
    }

    @JsonIgnore
    public void  setRadChosainJokyo(RadioButton radChosainJokyo) {
        this.getSearchNinteiChosaSchedule().setRadChosainJokyo(radChosainJokyo);
    }

    @JsonIgnore
    public DropDownList getDdlHokensha() {
        return this.getSearchNinteiChosaSchedule().getDdlHokensha();
    }

    @JsonIgnore
    public void  setDdlHokensha(DropDownList ddlHokensha) {
        this.getSearchNinteiChosaSchedule().setDdlHokensha(ddlHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlninteiChosaItakusaki() {
        return this.getSearchNinteiChosaSchedule().getDdlninteiChosaItakusaki();
    }

    @JsonIgnore
    public void  setDdlninteiChosaItakusaki(DropDownList ddlninteiChosaItakusaki) {
        this.getSearchNinteiChosaSchedule().setDdlninteiChosaItakusaki(ddlninteiChosaItakusaki);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getSearchNinteiChosaSchedule().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getSearchNinteiChosaSchedule().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaSchedule_Row> getDgNinteiChosaSchedule() {
        return this.getNchosainScheduleIchiran().getDgNinteiChosaSchedule();
    }

    @JsonIgnore
    public void  setDgNinteiChosaSchedule(DataGrid<dgNinteiChosaSchedule_Row> dgNinteiChosaSchedule) {
        this.getNchosainScheduleIchiran().setDgNinteiChosaSchedule(dgNinteiChosaSchedule);
    }

    // </editor-fold>
}
