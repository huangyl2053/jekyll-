package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaIraishoAndChosahyoAndIkenshoPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrintDiv extends Panel implements IChosaIraishoAndChosahyoAndIkenshoPrintDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("InsatsuTaishoShitei")
    private InsatsuTaishoShiteiDiv InsatsuTaishoShitei;
    @JsonProperty("PrintJoken")
    private PrintJokenDiv PrintJoken;
    @JsonProperty("TeishutsuKigen")
    private TeishutsuKigenDiv TeishutsuKigen;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnPrint")
    private ButtonReportPublish btnPrint;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;
    @JsonProperty("hiddenData")
    private RString hiddenData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getInsatsuTaishoShitei
     * @return InsatsuTaishoShitei
     */
    @JsonProperty("InsatsuTaishoShitei")
    public InsatsuTaishoShiteiDiv getInsatsuTaishoShitei() {
        return InsatsuTaishoShitei;
    }

    /*
     * setInsatsuTaishoShitei
     * @param InsatsuTaishoShitei InsatsuTaishoShitei
     */
    @JsonProperty("InsatsuTaishoShitei")
    public void setInsatsuTaishoShitei(InsatsuTaishoShiteiDiv InsatsuTaishoShitei) {
        this.InsatsuTaishoShitei = InsatsuTaishoShitei;
    }

    /*
     * getPrintJoken
     * @return PrintJoken
     */
    @JsonProperty("PrintJoken")
    public PrintJokenDiv getPrintJoken() {
        return PrintJoken;
    }

    /*
     * setPrintJoken
     * @param PrintJoken PrintJoken
     */
    @JsonProperty("PrintJoken")
    public void setPrintJoken(PrintJokenDiv PrintJoken) {
        this.PrintJoken = PrintJoken;
    }

    /*
     * getTeishutsuKigen
     * @return TeishutsuKigen
     */
    @JsonProperty("TeishutsuKigen")
    public TeishutsuKigenDiv getTeishutsuKigen() {
        return TeishutsuKigen;
    }

    /*
     * setTeishutsuKigen
     * @param TeishutsuKigen TeishutsuKigen
     */
    @JsonProperty("TeishutsuKigen")
    public void setTeishutsuKigen(TeishutsuKigenDiv TeishutsuKigen) {
        this.TeishutsuKigen = TeishutsuKigen;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * getbtnPrint
     * @return btnPrint
     */
    @JsonProperty("btnPrint")
    public ButtonReportPublish getBtnPrint() {
        return btnPrint;
    }

    /*
     * setbtnPrint
     * @param btnPrint btnPrint
     */
    @JsonProperty("btnPrint")
    public void setBtnPrint(ButtonReportPublish btnPrint) {
        this.btnPrint = btnPrint;
    }

    /*
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * gethiddenData
     * @return hiddenData
     */
    @JsonProperty("hiddenData")
    public RString getHiddenData() {
        return hiddenData;
    }

    /*
     * sethiddenData
     * @param hiddenData hiddenData
     */
    @JsonProperty("hiddenData")
    public void setHiddenData(RString hiddenData) {
        this.hiddenData = hiddenData;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getInsatsuTaishoShitei().getCcdHokenshaList();
    }

    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getInsatsuTaishoShitei().getNinteiChosa();
    }

    @JsonIgnore
    public void  setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getInsatsuTaishoShitei().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosa_Row> getDgNinteiChosa() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getDgNinteiChosa();
    }

    @JsonIgnore
    public void  setDgNinteiChosa(DataGrid<dgNinteiChosa_Row> dgNinteiChosa) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setDgNinteiChosa(dgNinteiChosa);
    }

    @JsonIgnore
    public NinteiChosaPrintDiv getNinteiChosaPrint() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint();
    }

    @JsonIgnore
    public void  setNinteiChosaPrint(NinteiChosaPrintDiv NinteiChosaPrint) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setNinteiChosaPrint(NinteiChosaPrint);
    }

    @JsonIgnore
    public CheckBoxList getChkIraisho() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkIraisho();
    }

    @JsonIgnore
    public void  setChkIraisho(CheckBoxList chkIraisho) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkIraisho(chkIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoKatamen() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyoKatamen();
    }

    @JsonIgnore
    public void  setChkChosahyoKatamen(CheckBoxList chkChosahyoKatamen) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyoKatamen(chkChosahyoKatamen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoRyomen() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyoRyomen();
    }

    @JsonIgnore
    public void  setChkChosahyoRyomen(CheckBoxList chkChosahyoRyomen) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyoRyomen(chkChosahyoRyomen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoGaikyo() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyoGaikyo();
    }

    @JsonIgnore
    public void  setChkChosahyoGaikyo(CheckBoxList chkChosahyoGaikyo) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyoGaikyo(chkChosahyoGaikyo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoSai() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyoSai();
    }

    @JsonIgnore
    public void  setChkChosahyoSai(CheckBoxList chkChosahyoSai) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyoSai(chkChosahyoSai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokki() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyoTokki();
    }

    @JsonIgnore
    public void  setChkChosahyoTokki(CheckBoxList chkChosahyoTokki) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyoTokki(chkChosahyoTokki);
    }

    @JsonIgnore
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho();
    }

    @JsonIgnore
    public void  setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.getInsatsuTaishoShitei().setShujiiIkensho(ShujiiIkensho);
    }

    @JsonIgnore
    public DataGrid<dgShujiiIkensho_Row> getDgShujiiIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getDgShujiiIkensho();
    }

    @JsonIgnore
    public void  setDgShujiiIkensho(DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setDgShujiiIkensho(dgShujiiIkensho);
    }

    @JsonIgnore
    public ShujiiIkenshoPrintDiv getShujiiIkenshoPrint() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint();
    }

    @JsonIgnore
    public void  setShujiiIkenshoPrint(ShujiiIkenshoPrintDiv ShujiiIkenshoPrint) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setShujiiIkenshoPrint(ShujiiIkenshoPrint);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoIraisho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkIkenshoIraisho();
    }

    @JsonIgnore
    public void  setChkIkenshoIraisho(CheckBoxList chkIkenshoIraisho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkIkenshoIraisho(chkIkenshoIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkIkensho();
    }

    @JsonIgnore
    public void  setChkIkensho(CheckBoxList chkIkensho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkIkensho(chkIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSeikyusho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkIkenshoSeikyusho();
    }

    @JsonIgnore
    public void  setChkIkenshoSeikyusho(CheckBoxList chkIkenshoSeikyusho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkIkenshoSeikyusho(chkIkenshoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkShindanMeireisho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkShindanMeireisho();
    }

    @JsonIgnore
    public void  setChkShindanMeireisho(CheckBoxList chkShindanMeireisho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkShindanMeireisho(chkShindanMeireisho);
    }

    @JsonIgnore
    public ShindanMeireiDiv getShindanMeirei() {
        return this.getInsatsuTaishoShitei().getShindanMeirei();
    }

    @JsonIgnore
    public void  setShindanMeirei(ShindanMeireiDiv ShindanMeirei) {
        this.getInsatsuTaishoShitei().setShindanMeirei(ShindanMeirei);
    }

    @JsonIgnore
    public RadioButton getRadJyushinKikan() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getRadJyushinKikan();
    }

    @JsonIgnore
    public void  setRadJyushinKikan(RadioButton radJyushinKikan) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setRadJyushinKikan(radJyushinKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtJyushinymd() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJyushinymd();
    }

    @JsonIgnore
    public void  setTxtJyushinymd(TextBoxDate txtJyushinymd) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJyushinymd(txtJyushinymd);
    }

    @JsonIgnore
    public TextBoxTime getTxtJushinTime() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJushinTime();
    }

    @JsonIgnore
    public void  setTxtJushinTime(TextBoxTime txtJushinTime) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJushinTime(txtJushinTime);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJushinKikan() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJushinKikan();
    }

    @JsonIgnore
    public void  setTxtJushinKikan(TextBoxDateRange txtJushinKikan) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJushinKikan(txtJushinKikan);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public TextBox getTxtJushinBasho() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJushinBasho();
    }

    @JsonIgnore
    public void  setTxtJushinBasho(TextBox txtJushinBasho) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJushinBasho(txtJushinBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkoYMD() {
        return this.getPrintJoken().getTxtHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.getPrintJoken().setTxtHakkoYMD(txtHakkoYMD);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return this.getPrintJoken().getCcdBunshoNo();
    }

    @JsonIgnore
    public RadioButton getRadTeishutsuKigen() {
        return this.getTeishutsuKigen().getRadTeishutsuKigen();
    }

    @JsonIgnore
    public void  setRadTeishutsuKigen(RadioButton radTeishutsuKigen) {
        this.getTeishutsuKigen().setRadTeishutsuKigen(radTeishutsuKigen);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getTeishutsuKigen().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getTeishutsuKigen().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKyotsuDay() {
        return this.getTeishutsuKigen().getTxtKyotsuDay();
    }

    @JsonIgnore
    public void  setTxtKyotsuDay(TextBoxDate txtKyotsuDay) {
        this.getTeishutsuKigen().setTxtKyotsuDay(txtKyotsuDay);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
