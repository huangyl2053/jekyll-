package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplChushutsuJoken1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplChushutsuJoken1Div extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKonkaiTaishoYM")
    private RadioButton radKonkaiTaishoYM;
    @JsonProperty("txtRangeYM")
    private TextBoxDateRange txtRangeYM;
    @JsonProperty("txtRangeHihokenshaNoFrom")
    private TextBoxCode txtRangeHihokenshaNoFrom;
    @JsonProperty("txtRangeHihokenshaNoTo")
    private TextBoxCode txtRangeHihokenshaNoTo;
    @JsonProperty("btnHihokenshaNoFromSearch")
    private Button btnHihokenshaNoFromSearch;
    @JsonProperty("btnHihokenshaNoToSearch")
    private Button btnHihokenshaNoToSearch;
    @JsonProperty("radKyufuJissekiKubun")
    private RadioButton radKyufuJissekiKubun;
    @JsonProperty("chkYokaigodo")
    private CheckBoxList chkYokaigodo;
    @JsonProperty("linYokaigoShutrsuryokuYoshiki")
    private HorizontalLine linYokaigoShutrsuryokuYoshiki;
    @JsonProperty("tblchkShutsuryokuYoshiki")
    private tblchkShutsuryokuYoshikiDiv tblchkShutsuryokuYoshiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKonkaiTaishoYM
     * @return radKonkaiTaishoYM
     */
    @JsonProperty("radKonkaiTaishoYM")
    public RadioButton getRadKonkaiTaishoYM() {
        return radKonkaiTaishoYM;
    }

    /*
     * setradKonkaiTaishoYM
     * @param radKonkaiTaishoYM radKonkaiTaishoYM
     */
    @JsonProperty("radKonkaiTaishoYM")
    public void setRadKonkaiTaishoYM(RadioButton radKonkaiTaishoYM) {
        this.radKonkaiTaishoYM = radKonkaiTaishoYM;
    }

    /*
     * gettxtRangeYM
     * @return txtRangeYM
     */
    @JsonProperty("txtRangeYM")
    public TextBoxDateRange getTxtRangeYM() {
        return txtRangeYM;
    }

    /*
     * settxtRangeYM
     * @param txtRangeYM txtRangeYM
     */
    @JsonProperty("txtRangeYM")
    public void setTxtRangeYM(TextBoxDateRange txtRangeYM) {
        this.txtRangeYM = txtRangeYM;
    }

    /*
     * gettxtRangeHihokenshaNoFrom
     * @return txtRangeHihokenshaNoFrom
     */
    @JsonProperty("txtRangeHihokenshaNoFrom")
    public TextBoxCode getTxtRangeHihokenshaNoFrom() {
        return txtRangeHihokenshaNoFrom;
    }

    /*
     * settxtRangeHihokenshaNoFrom
     * @param txtRangeHihokenshaNoFrom txtRangeHihokenshaNoFrom
     */
    @JsonProperty("txtRangeHihokenshaNoFrom")
    public void setTxtRangeHihokenshaNoFrom(TextBoxCode txtRangeHihokenshaNoFrom) {
        this.txtRangeHihokenshaNoFrom = txtRangeHihokenshaNoFrom;
    }

    /*
     * gettxtRangeHihokenshaNoTo
     * @return txtRangeHihokenshaNoTo
     */
    @JsonProperty("txtRangeHihokenshaNoTo")
    public TextBoxCode getTxtRangeHihokenshaNoTo() {
        return txtRangeHihokenshaNoTo;
    }

    /*
     * settxtRangeHihokenshaNoTo
     * @param txtRangeHihokenshaNoTo txtRangeHihokenshaNoTo
     */
    @JsonProperty("txtRangeHihokenshaNoTo")
    public void setTxtRangeHihokenshaNoTo(TextBoxCode txtRangeHihokenshaNoTo) {
        this.txtRangeHihokenshaNoTo = txtRangeHihokenshaNoTo;
    }

    /*
     * getbtnHihokenshaNoFromSearch
     * @return btnHihokenshaNoFromSearch
     */
    @JsonProperty("btnHihokenshaNoFromSearch")
    public Button getBtnHihokenshaNoFromSearch() {
        return btnHihokenshaNoFromSearch;
    }

    /*
     * setbtnHihokenshaNoFromSearch
     * @param btnHihokenshaNoFromSearch btnHihokenshaNoFromSearch
     */
    @JsonProperty("btnHihokenshaNoFromSearch")
    public void setBtnHihokenshaNoFromSearch(Button btnHihokenshaNoFromSearch) {
        this.btnHihokenshaNoFromSearch = btnHihokenshaNoFromSearch;
    }

    /*
     * getbtnHihokenshaNoToSearch
     * @return btnHihokenshaNoToSearch
     */
    @JsonProperty("btnHihokenshaNoToSearch")
    public Button getBtnHihokenshaNoToSearch() {
        return btnHihokenshaNoToSearch;
    }

    /*
     * setbtnHihokenshaNoToSearch
     * @param btnHihokenshaNoToSearch btnHihokenshaNoToSearch
     */
    @JsonProperty("btnHihokenshaNoToSearch")
    public void setBtnHihokenshaNoToSearch(Button btnHihokenshaNoToSearch) {
        this.btnHihokenshaNoToSearch = btnHihokenshaNoToSearch;
    }

    /*
     * getradKyufuJissekiKubun
     * @return radKyufuJissekiKubun
     */
    @JsonProperty("radKyufuJissekiKubun")
    public RadioButton getRadKyufuJissekiKubun() {
        return radKyufuJissekiKubun;
    }

    /*
     * setradKyufuJissekiKubun
     * @param radKyufuJissekiKubun radKyufuJissekiKubun
     */
    @JsonProperty("radKyufuJissekiKubun")
    public void setRadKyufuJissekiKubun(RadioButton radKyufuJissekiKubun) {
        this.radKyufuJissekiKubun = radKyufuJissekiKubun;
    }

    /*
     * getchkYokaigodo
     * @return chkYokaigodo
     */
    @JsonProperty("chkYokaigodo")
    public CheckBoxList getChkYokaigodo() {
        return chkYokaigodo;
    }

    /*
     * setchkYokaigodo
     * @param chkYokaigodo chkYokaigodo
     */
    @JsonProperty("chkYokaigodo")
    public void setChkYokaigodo(CheckBoxList chkYokaigodo) {
        this.chkYokaigodo = chkYokaigodo;
    }

    /*
     * getlinYokaigoShutrsuryokuYoshiki
     * @return linYokaigoShutrsuryokuYoshiki
     */
    @JsonProperty("linYokaigoShutrsuryokuYoshiki")
    public HorizontalLine getLinYokaigoShutrsuryokuYoshiki() {
        return linYokaigoShutrsuryokuYoshiki;
    }

    /*
     * setlinYokaigoShutrsuryokuYoshiki
     * @param linYokaigoShutrsuryokuYoshiki linYokaigoShutrsuryokuYoshiki
     */
    @JsonProperty("linYokaigoShutrsuryokuYoshiki")
    public void setLinYokaigoShutrsuryokuYoshiki(HorizontalLine linYokaigoShutrsuryokuYoshiki) {
        this.linYokaigoShutrsuryokuYoshiki = linYokaigoShutrsuryokuYoshiki;
    }

    /*
     * gettblchkShutsuryokuYoshiki
     * @return tblchkShutsuryokuYoshiki
     */
    @JsonProperty("tblchkShutsuryokuYoshiki")
    public tblchkShutsuryokuYoshikiDiv getTblchkShutsuryokuYoshiki() {
        return tblchkShutsuryokuYoshiki;
    }

    /*
     * settblchkShutsuryokuYoshiki
     * @param tblchkShutsuryokuYoshiki tblchkShutsuryokuYoshiki
     */
    @JsonProperty("tblchkShutsuryokuYoshiki")
    public void setTblchkShutsuryokuYoshiki(tblchkShutsuryokuYoshikiDiv tblchkShutsuryokuYoshiki) {
        this.tblchkShutsuryokuYoshiki = tblchkShutsuryokuYoshiki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShutsuryokuYoshiki() {
        return this.getTblchkShutsuryokuYoshiki().getLblShutsuryokuYoshiki();
    }

    @JsonIgnore
    public Button getBtnShutsuryokuYoshikiAllCheck() {
        return this.getTblchkShutsuryokuYoshiki().getBtnShutsuryokuYoshikiAllCheck();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki1() {
        return this.getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki1();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki2() {
        return this.getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki2();
    }

    @JsonIgnore
    public Space getYoboSpace1() {
        return this.getTblchkShutsuryokuYoshiki().getYoboSpace1();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki3() {
        return this.getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki3();
    }

    @JsonIgnore
    public Space getYoboSpace2() {
        return this.getTblchkShutsuryokuYoshiki().getYoboSpace2();
    }

    @JsonIgnore
    public Space getYoboSpace3() {
        return this.getTblchkShutsuryokuYoshiki().getYoboSpace3();
    }

    @JsonIgnore
    public Space getYoboSpace4() {
        return this.getTblchkShutsuryokuYoshiki().getYoboSpace4();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki4() {
        return this.getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki4();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki5() {
        return this.getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki5();
    }

    // </editor-fold>
}
