package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001;
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
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuTaisho")
    private RadioButton radChushutsuTaisho;
    @JsonProperty("ChushutsuHaniPanel")
    private ChushutsuHaniPanelDiv ChushutsuHaniPanel;
    @JsonProperty("NinteiKekkaPanel")
    private NinteiKekkaPanelDiv NinteiKekkaPanel;
    @JsonProperty("Ninteikekka2Panel")
    private Ninteikekka2PanelDiv Ninteikekka2Panel;
    @JsonProperty("ddlShikakuSoshitsuKubun")
    private DropDownList ddlShikakuSoshitsuKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuTaisho
     * @return radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public RadioButton getRadChushutsuTaisho() {
        return radChushutsuTaisho;
    }

    /*
     * setradChushutsuTaisho
     * @param radChushutsuTaisho radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public void setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.radChushutsuTaisho = radChushutsuTaisho;
    }

    /*
     * getChushutsuHaniPanel
     * @return ChushutsuHaniPanel
     */
    @JsonProperty("ChushutsuHaniPanel")
    public ChushutsuHaniPanelDiv getChushutsuHaniPanel() {
        return ChushutsuHaniPanel;
    }

    /*
     * setChushutsuHaniPanel
     * @param ChushutsuHaniPanel ChushutsuHaniPanel
     */
    @JsonProperty("ChushutsuHaniPanel")
    public void setChushutsuHaniPanel(ChushutsuHaniPanelDiv ChushutsuHaniPanel) {
        this.ChushutsuHaniPanel = ChushutsuHaniPanel;
    }

    /*
     * getNinteiKekkaPanel
     * @return NinteiKekkaPanel
     */
    @JsonProperty("NinteiKekkaPanel")
    public NinteiKekkaPanelDiv getNinteiKekkaPanel() {
        return NinteiKekkaPanel;
    }

    /*
     * setNinteiKekkaPanel
     * @param NinteiKekkaPanel NinteiKekkaPanel
     */
    @JsonProperty("NinteiKekkaPanel")
    public void setNinteiKekkaPanel(NinteiKekkaPanelDiv NinteiKekkaPanel) {
        this.NinteiKekkaPanel = NinteiKekkaPanel;
    }

    /*
     * getNinteikekka2Panel
     * @return Ninteikekka2Panel
     */
    @JsonProperty("Ninteikekka2Panel")
    public Ninteikekka2PanelDiv getNinteikekka2Panel() {
        return Ninteikekka2Panel;
    }

    /*
     * setNinteikekka2Panel
     * @param Ninteikekka2Panel Ninteikekka2Panel
     */
    @JsonProperty("Ninteikekka2Panel")
    public void setNinteikekka2Panel(Ninteikekka2PanelDiv Ninteikekka2Panel) {
        this.Ninteikekka2Panel = Ninteikekka2Panel;
    }

    /*
     * getddlShikakuSoshitsuKubun
     * @return ddlShikakuSoshitsuKubun
     */
    @JsonProperty("ddlShikakuSoshitsuKubun")
    public DropDownList getDdlShikakuSoshitsuKubun() {
        return ddlShikakuSoshitsuKubun;
    }

    /*
     * setddlShikakuSoshitsuKubun
     * @param ddlShikakuSoshitsuKubun ddlShikakuSoshitsuKubun
     */
    @JsonProperty("ddlShikakuSoshitsuKubun")
    public void setDdlShikakuSoshitsuKubun(DropDownList ddlShikakuSoshitsuKubun) {
        this.ddlShikakuSoshitsuKubun = ddlShikakuSoshitsuKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkSaisin() {
        return this.getChushutsuHaniPanel().getChkSaisin();
    }

    @JsonIgnore
    public void  setChkSaisin(CheckBoxList chkSaisin) {
        this.getChushutsuHaniPanel().setChkSaisin(chkSaisin);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunYmd() {
        return this.getChushutsuHaniPanel().getTxtKijyunYmd();
    }

    @JsonIgnore
    public void  setTxtKijyunYmd(TextBoxDate txtKijyunYmd) {
        this.getChushutsuHaniPanel().setTxtKijyunYmd(txtKijyunYmd);
    }

    @JsonIgnore
    public Label getLblNinteiYmdHani() {
        return this.getChushutsuHaniPanel().getLblNinteiYmdHani();
    }

    @JsonIgnore
    public void  setLblNinteiYmdHani(Label lblNinteiYmdHani) {
        this.getChushutsuHaniPanel().setLblNinteiYmdHani(lblNinteiYmdHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYmdHani() {
        return this.getChushutsuHaniPanel().getTxtNinteiYmdHani();
    }

    @JsonIgnore
    public void  setTxtNinteiYmdHani(TextBoxDateRange txtNinteiYmdHani) {
        this.getChushutsuHaniPanel().setTxtNinteiYmdHani(txtNinteiYmdHani);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekka() {
        return this.getNinteiKekkaPanel().getChkNinteiKekka();
    }

    @JsonIgnore
    public void  setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.getNinteiKekkaPanel().setChkNinteiKekka(chkNinteiKekka);
    }

    @JsonIgnore
    public CheckBoxList getＣｈｋKyuSochisya() {
        return this.getNinteikekka2Panel().getＣｈｋKyuSochisya();
    }

    @JsonIgnore
    public void  setＣｈｋKyuSochisya(CheckBoxList ｃｈｋKyuSochisya) {
        this.getNinteikekka2Panel().setＣｈｋKyuSochisya(ｃｈｋKyuSochisya);
    }

    @JsonIgnore
    public CheckBoxList getChkHihokensya() {
        return this.getNinteikekka2Panel().getChkHihokensya();
    }

    @JsonIgnore
    public void  setChkHihokensya(CheckBoxList chkHihokensya) {
        this.getNinteikekka2Panel().setChkHihokensya(chkHihokensya);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiSabisu() {
        return this.getNinteikekka2Panel().getChkNinteiSabisu();
    }

    @JsonIgnore
    public void  setChkNinteiSabisu(CheckBoxList chkNinteiSabisu) {
        this.getNinteikekka2Panel().setChkNinteiSabisu(chkNinteiSabisu);
    }

    // </editor-fold>
}
