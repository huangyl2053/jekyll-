package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023;
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
 * TokuteiShinryohiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiShinryohiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelOne")
    private panelOneDiv panelOne;
    @JsonProperty("panelTwo")
    private panelTwoDiv panelTwo;
    @JsonProperty("panelThree")
    private panelThreeDiv panelThree;
    @JsonProperty("hiddenYoshikiNo")
    private RString hiddenYoshikiNo;
    @JsonProperty("hiddenServiceTeikyoYM")
    private RString hiddenServiceTeikyoYM;
    @JsonProperty("hiddenShikibetsuCode")
    private RString hiddenShikibetsuCode;
    @JsonProperty("hiddenSelectCode")
    private RString hiddenSelectCode;
    @JsonProperty("hiddenSelectKoumoku")
    private RString hiddenSelectKoumoku;
    @JsonProperty("RowId")
    private RString RowId;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelOne
     * @return panelOne
     */
    @JsonProperty("panelOne")
    public panelOneDiv getPanelOne() {
        return panelOne;
    }

    /*
     * setpanelOne
     * @param panelOne panelOne
     */
    @JsonProperty("panelOne")
    public void setPanelOne(panelOneDiv panelOne) {
        this.panelOne = panelOne;
    }

    /*
     * getpanelTwo
     * @return panelTwo
     */
    @JsonProperty("panelTwo")
    public panelTwoDiv getPanelTwo() {
        return panelTwo;
    }

    /*
     * setpanelTwo
     * @param panelTwo panelTwo
     */
    @JsonProperty("panelTwo")
    public void setPanelTwo(panelTwoDiv panelTwo) {
        this.panelTwo = panelTwo;
    }

    /*
     * getpanelThree
     * @return panelThree
     */
    @JsonProperty("panelThree")
    public panelThreeDiv getPanelThree() {
        return panelThree;
    }

    /*
     * setpanelThree
     * @param panelThree panelThree
     */
    @JsonProperty("panelThree")
    public void setPanelThree(panelThreeDiv panelThree) {
        this.panelThree = panelThree;
    }

    /*
     * gethiddenYoshikiNo
     * @return hiddenYoshikiNo
     */
    @JsonProperty("hiddenYoshikiNo")
    public RString getHiddenYoshikiNo() {
        return hiddenYoshikiNo;
    }

    /*
     * sethiddenYoshikiNo
     * @param hiddenYoshikiNo hiddenYoshikiNo
     */
    @JsonProperty("hiddenYoshikiNo")
    public void setHiddenYoshikiNo(RString hiddenYoshikiNo) {
        this.hiddenYoshikiNo = hiddenYoshikiNo;
    }

    /*
     * gethiddenServiceTeikyoYM
     * @return hiddenServiceTeikyoYM
     */
    @JsonProperty("hiddenServiceTeikyoYM")
    public RString getHiddenServiceTeikyoYM() {
        return hiddenServiceTeikyoYM;
    }

    /*
     * sethiddenServiceTeikyoYM
     * @param hiddenServiceTeikyoYM hiddenServiceTeikyoYM
     */
    @JsonProperty("hiddenServiceTeikyoYM")
    public void setHiddenServiceTeikyoYM(RString hiddenServiceTeikyoYM) {
        this.hiddenServiceTeikyoYM = hiddenServiceTeikyoYM;
    }

    /*
     * gethiddenShikibetsuCode
     * @return hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public RString getHiddenShikibetsuCode() {
        return hiddenShikibetsuCode;
    }

    /*
     * sethiddenShikibetsuCode
     * @param hiddenShikibetsuCode hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public void setHiddenShikibetsuCode(RString hiddenShikibetsuCode) {
        this.hiddenShikibetsuCode = hiddenShikibetsuCode;
    }

    /*
     * gethiddenSelectCode
     * @return hiddenSelectCode
     */
    @JsonProperty("hiddenSelectCode")
    public RString getHiddenSelectCode() {
        return hiddenSelectCode;
    }

    /*
     * sethiddenSelectCode
     * @param hiddenSelectCode hiddenSelectCode
     */
    @JsonProperty("hiddenSelectCode")
    public void setHiddenSelectCode(RString hiddenSelectCode) {
        this.hiddenSelectCode = hiddenSelectCode;
    }

    /*
     * gethiddenSelectKoumoku
     * @return hiddenSelectKoumoku
     */
    @JsonProperty("hiddenSelectKoumoku")
    public RString getHiddenSelectKoumoku() {
        return hiddenSelectKoumoku;
    }

    /*
     * sethiddenSelectKoumoku
     * @param hiddenSelectKoumoku hiddenSelectKoumoku
     */
    @JsonProperty("hiddenSelectKoumoku")
    public void setHiddenSelectKoumoku(RString hiddenSelectKoumoku) {
        this.hiddenSelectKoumoku = hiddenSelectKoumoku;
    }

    /*
     * getRowId
     * @return RowId
     */
    @JsonProperty("RowId")
    public RString getRowId() {
        return RowId;
    }

    /*
     * setRowId
     * @param RowId RowId
     */
    @JsonProperty("RowId")
    public void setRowId(RString RowId) {
        this.RowId = RowId;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelThree().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelThree().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgdTokuteiShinryohi_Row> getDgdTokuteiShinryohi() {
        return this.getPanelThree().getDgdTokuteiShinryohi();
    }

    @JsonIgnore
    public void  setDgdTokuteiShinryohi(DataGrid<dgdTokuteiShinryohi_Row> dgdTokuteiShinryohi) {
        this.getPanelThree().setDgdTokuteiShinryohi(dgdTokuteiShinryohi);
    }

    @JsonIgnore
    public DataGrid<ddgToteishinryoTokubetushinryo_Row> getDdgToteishinryoTokubetushinryo() {
        return this.getPanelThree().getDdgToteishinryoTokubetushinryo();
    }

    @JsonIgnore
    public void  setDdgToteishinryoTokubetushinryo(DataGrid<ddgToteishinryoTokubetushinryo_Row> ddgToteishinryoTokubetushinryo) {
        this.getPanelThree().setDdgToteishinryoTokubetushinryo(ddgToteishinryoTokubetushinryo);
    }

    @JsonIgnore
    public panelFourDiv getPanelFour() {
        return this.getPanelThree().getPanelFour();
    }

    @JsonIgnore
    public void  setPanelFour(panelFourDiv panelFour) {
        this.getPanelThree().setPanelFour(panelFour);
    }

    @JsonIgnore
    public TextBox getTxtShobyoMei() {
        return this.getPanelThree().getPanelFour().getTxtShobyoMei();
    }

    @JsonIgnore
    public void  setTxtShobyoMei(TextBox txtShobyoMei) {
        this.getPanelThree().getPanelFour().setTxtShobyoMei(txtShobyoMei);
    }

    @JsonIgnore
    public TextBoxNum getTxtShidouKanri() {
        return this.getPanelThree().getPanelFour().getTxtShidouKanri();
    }

    @JsonIgnore
    public void  setTxtShidouKanri(TextBoxNum txtShidouKanri) {
        this.getPanelThree().getPanelFour().setTxtShidouKanri(txtShidouKanri);
    }

    @JsonIgnore
    public TextBoxNum getTxtRibabiriteishon() {
        return this.getPanelThree().getPanelFour().getTxtRibabiriteishon();
    }

    @JsonIgnore
    public void  setTxtRibabiriteishon(TextBoxNum txtRibabiriteishon) {
        this.getPanelThree().getPanelFour().setTxtRibabiriteishon(txtRibabiriteishon);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeishinkaSenmon() {
        return this.getPanelThree().getPanelFour().getTxtSeishinkaSenmon();
    }

    @JsonIgnore
    public void  setTxtSeishinkaSenmon(TextBoxNum txtSeishinkaSenmon) {
        this.getPanelThree().getPanelFour().setTxtSeishinkaSenmon(txtSeishinkaSenmon);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanjyunXline() {
        return this.getPanelThree().getPanelFour().getTxtTanjyunXline();
    }

    @JsonIgnore
    public void  setTxtTanjyunXline(TextBoxNum txtTanjyunXline) {
        this.getPanelThree().getPanelFour().setTxtTanjyunXline(txtTanjyunXline);
    }

    @JsonIgnore
    public TextBoxNum getTxtSochi() {
        return this.getPanelThree().getPanelFour().getTxtSochi();
    }

    @JsonIgnore
    public void  setTxtSochi(TextBoxNum txtSochi) {
        this.getPanelThree().getPanelFour().setTxtSochi(txtSochi);
    }

    @JsonIgnore
    public TextBoxNum getTxtTejyutsu() {
        return this.getPanelThree().getPanelFour().getTxtTejyutsu();
    }

    @JsonIgnore
    public void  setTxtTejyutsu(TextBoxNum txtTejyutsu) {
        this.getPanelThree().getPanelFour().setTxtTejyutsu(txtTejyutsu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelThree().getPanelFour().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelThree().getPanelFour().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtGoukei() {
        return this.getPanelThree().getPanelFour().getTxtGoukei();
    }

    @JsonIgnore
    public void  setTxtGoukei(TextBoxNum txtGoukei) {
        this.getPanelThree().getPanelFour().setTxtGoukei(txtGoukei);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMutiTekiyo() {
        return this.getPanelThree().getPanelFour().getTxtMutiTekiyo();
    }

    @JsonIgnore
    public void  setTxtMutiTekiyo(TextBoxMultiLine txtMutiTekiyo) {
        this.getPanelThree().getPanelFour().setTxtMutiTekiyo(txtMutiTekiyo);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelThree().getPanelFour().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelThree().getPanelFour().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelThree().getPanelFour().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelThree().getPanelFour().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelThree().getPanelFour().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelThree().getPanelFour().setBtnClear(btnClear);
    }

    @JsonIgnore
    public panelFiveDiv getPanelFive() {
        return this.getPanelThree().getPanelFive();
    }

    @JsonIgnore
    public void  setPanelFive(panelFiveDiv panelFive) {
        this.getPanelThree().setPanelFive(panelFive);
    }

    @JsonIgnore
    public TextBox getTxtShobyoMeiDown() {
        return this.getPanelThree().getPanelFive().getTxtShobyoMeiDown();
    }

    @JsonIgnore
    public void  setTxtShobyoMeiDown(TextBox txtShobyoMeiDown) {
        this.getPanelThree().getPanelFive().setTxtShobyoMeiDown(txtShobyoMeiDown);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getPanelThree().getPanelFive().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getPanelThree().getPanelFive().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyosha() {
        return this.getPanelThree().getPanelFive().getBtnJigyosha();
    }

    @JsonIgnore
    public void  setBtnJigyosha(ButtonDialog btnJigyosha) {
        this.getPanelThree().getPanelFive().setBtnJigyosha(btnJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getPanelThree().getPanelFive().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getPanelThree().getPanelFive().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBox getTxtTanyi() {
        return this.getPanelThree().getPanelFive().getTxtTanyi();
    }

    @JsonIgnore
    public void  setTxtTanyi(TextBox txtTanyi) {
        this.getPanelThree().getPanelFive().setTxtTanyi(txtTanyi);
    }

    @JsonIgnore
    public Label getLblComment1() {
        return this.getPanelThree().getPanelFive().getLblComment1();
    }

    @JsonIgnore
    public void  setLblComment1(Label lblComment1) {
        this.getPanelThree().getPanelFive().setLblComment1(lblComment1);
    }

    @JsonIgnore
    public Label getLblComment2() {
        return this.getPanelThree().getPanelFive().getLblComment2();
    }

    @JsonIgnore
    public void  setLblComment2(Label lblComment2) {
        this.getPanelThree().getPanelFive().setLblComment2(lblComment2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaiyisuNisu() {
        return this.getPanelThree().getPanelFive().getTxtKaiyisuNisu();
    }

    @JsonIgnore
    public void  setTxtKaiyisuNisu(TextBoxNum txtKaiyisuNisu) {
        this.getPanelThree().getPanelFive().setTxtKaiyisuNisu(txtKaiyisuNisu);
    }

    @JsonIgnore
    public Button getBtnCal() {
        return this.getPanelThree().getPanelFive().getBtnCal();
    }

    @JsonIgnore
    public void  setBtnCal(Button btnCal) {
        this.getPanelThree().getPanelFive().setBtnCal(btnCal);
    }

    @JsonIgnore
    public TextBoxNum getTxtGoukeiTanyi() {
        return this.getPanelThree().getPanelFive().getTxtGoukeiTanyi();
    }

    @JsonIgnore
    public void  setTxtGoukeiTanyi(TextBoxNum txtGoukeiTanyi) {
        this.getPanelThree().getPanelFive().setTxtGoukeiTanyi(txtGoukeiTanyi);
    }

    @JsonIgnore
    public TextBox getTxtTekiyoDown() {
        return this.getPanelThree().getPanelFive().getTxtTekiyoDown();
    }

    @JsonIgnore
    public void  setTxtTekiyoDown(TextBox txtTekiyoDown) {
        this.getPanelThree().getPanelFive().setTxtTekiyoDown(txtTekiyoDown);
    }

    @JsonIgnore
    public Button getBtnConfirm2() {
        return this.getPanelThree().getPanelFive().getBtnConfirm2();
    }

    @JsonIgnore
    public void  setBtnConfirm2(Button btnConfirm2) {
        this.getPanelThree().getPanelFive().setBtnConfirm2(btnConfirm2);
    }

    @JsonIgnore
    public Button getBtnCancel2() {
        return this.getPanelThree().getPanelFive().getBtnCancel2();
    }

    @JsonIgnore
    public void  setBtnCancel2(Button btnCancel2) {
        this.getPanelThree().getPanelFive().setBtnCancel2(btnCancel2);
    }

    @JsonIgnore
    public Button getBtnClear2() {
        return this.getPanelThree().getPanelFive().getBtnClear2();
    }

    @JsonIgnore
    public void  setBtnClear2(Button btnClear2) {
        this.getPanelThree().getPanelFive().setBtnClear2(btnClear2);
    }

    // </editor-fold>
}
