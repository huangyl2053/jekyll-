package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon;
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
 * ChosaKekkaInfoKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaKekkaInfoKihonDiv extends Panel implements IChosaKekkaInfoKihonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    private TextBoxDate txtNinteichosaJisshiYMD;
    @JsonProperty("lblJisshiBasho")
    private Label lblJisshiBasho;
    @JsonProperty("txtChosaJisshiBashoMeisho")
    private TextBox txtChosaJisshiBashoMeisho;
    @JsonProperty("JisshiBashoMeishoPanel")
    private JisshiBashoMeishoPanelDiv JisshiBashoMeishoPanel;
    @JsonProperty("KihonChosaPanel")
    private KihonChosaPanelDiv KihonChosaPanel;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("ninteichosaRirekiNo")
    private RString ninteichosaRirekiNo;
    @JsonProperty("ninteichosaTokkijikoNoList")
    private RString ninteichosaTokkijikoNoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteichosaJisshiYMD
     * @return txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public TextBoxDate getTxtNinteichosaJisshiYMD() {
        return txtNinteichosaJisshiYMD;
    }

    /*
     * settxtNinteichosaJisshiYMD
     * @param txtNinteichosaJisshiYMD txtNinteichosaJisshiYMD
     */
    @JsonProperty("txtNinteichosaJisshiYMD")
    public void setTxtNinteichosaJisshiYMD(TextBoxDate txtNinteichosaJisshiYMD) {
        this.txtNinteichosaJisshiYMD = txtNinteichosaJisshiYMD;
    }

    /*
     * getlblJisshiBasho
     * @return lblJisshiBasho
     */
    @JsonProperty("lblJisshiBasho")
    public Label getLblJisshiBasho() {
        return lblJisshiBasho;
    }

    /*
     * setlblJisshiBasho
     * @param lblJisshiBasho lblJisshiBasho
     */
    @JsonProperty("lblJisshiBasho")
    public void setLblJisshiBasho(Label lblJisshiBasho) {
        this.lblJisshiBasho = lblJisshiBasho;
    }

    /*
     * gettxtChosaJisshiBashoMeisho
     * @return txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public TextBox getTxtChosaJisshiBashoMeisho() {
        return txtChosaJisshiBashoMeisho;
    }

    /*
     * settxtChosaJisshiBashoMeisho
     * @param txtChosaJisshiBashoMeisho txtChosaJisshiBashoMeisho
     */
    @JsonProperty("txtChosaJisshiBashoMeisho")
    public void setTxtChosaJisshiBashoMeisho(TextBox txtChosaJisshiBashoMeisho) {
        this.txtChosaJisshiBashoMeisho = txtChosaJisshiBashoMeisho;
    }

    /*
     * getJisshiBashoMeishoPanel
     * @return JisshiBashoMeishoPanel
     */
    @JsonProperty("JisshiBashoMeishoPanel")
    public JisshiBashoMeishoPanelDiv getJisshiBashoMeishoPanel() {
        return JisshiBashoMeishoPanel;
    }

    /*
     * setJisshiBashoMeishoPanel
     * @param JisshiBashoMeishoPanel JisshiBashoMeishoPanel
     */
    @JsonProperty("JisshiBashoMeishoPanel")
    public void setJisshiBashoMeishoPanel(JisshiBashoMeishoPanelDiv JisshiBashoMeishoPanel) {
        this.JisshiBashoMeishoPanel = JisshiBashoMeishoPanel;
    }

    /*
     * getKihonChosaPanel
     * @return KihonChosaPanel
     */
    @JsonProperty("KihonChosaPanel")
    public KihonChosaPanelDiv getKihonChosaPanel() {
        return KihonChosaPanel;
    }

    /*
     * setKihonChosaPanel
     * @param KihonChosaPanel KihonChosaPanel
     */
    @JsonProperty("KihonChosaPanel")
    public void setKihonChosaPanel(KihonChosaPanelDiv KihonChosaPanel) {
        this.KihonChosaPanel = KihonChosaPanel;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getninteichosaRirekiNo
     * @return ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public RString getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /*
     * setninteichosaRirekiNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    @JsonProperty("ninteichosaRirekiNo")
    public void setNinteichosaRirekiNo(RString ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /*
     * getninteichosaTokkijikoNoList
     * @return ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public RString getNinteichosaTokkijikoNoList() {
        return ninteichosaTokkijikoNoList;
    }

    /*
     * setninteichosaTokkijikoNoList
     * @param ninteichosaTokkijikoNoList ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public void setNinteichosaTokkijikoNoList(RString ninteichosaTokkijikoNoList) {
        this.ninteichosaTokkijikoNoList = ninteichosaTokkijikoNoList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DynamicImage getImgChosaJisshiBashoMeisho() {
        return this.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho();
    }

    @JsonIgnore
    public void  setImgChosaJisshiBashoMeisho(DynamicImage imgChosaJisshiBashoMeisho) {
        this.getJisshiBashoMeishoPanel().setImgChosaJisshiBashoMeisho(imgChosaJisshiBashoMeisho);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
