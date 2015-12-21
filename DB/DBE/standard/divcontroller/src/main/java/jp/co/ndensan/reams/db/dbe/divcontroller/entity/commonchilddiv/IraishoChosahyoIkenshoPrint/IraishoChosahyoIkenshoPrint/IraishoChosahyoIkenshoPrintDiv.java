package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IraishoChosahyoIkenshoPrint.IraishoChosahyoIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonPrint;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * IraishoChosahyoIkenshoPrint のクラスファイル
 *
 * @author 自動生成
 */
public class IraishoChosahyoIkenshoPrintDiv extends Panel implements IIraishoChosahyoIkenshoPrintDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdHokenshaList")
    private IHokenshaListDiv ccdHokenshaList;
    @JsonProperty("InsatsuTaishoShitei")
    private InsatsuTaishoShiteiDiv InsatsuTaishoShitei;
    @JsonProperty("TeishutsuKigen")
    private TeishutsuKigenDiv TeishutsuKigen;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnPrint")
    private ButtonPrint btnPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    @JsonProperty("InsatsuTaishoShitei")
    public InsatsuTaishoShiteiDiv getInsatsuTaishoShitei() {
        return InsatsuTaishoShitei;
    }

    @JsonProperty("InsatsuTaishoShitei")
    public void setInsatsuTaishoShitei(InsatsuTaishoShiteiDiv InsatsuTaishoShitei) {
        this.InsatsuTaishoShitei = InsatsuTaishoShitei;
    }

    @JsonProperty("TeishutsuKigen")
    public TeishutsuKigenDiv getTeishutsuKigen() {
        return TeishutsuKigen;
    }

    @JsonProperty("TeishutsuKigen")
    public void setTeishutsuKigen(TeishutsuKigenDiv TeishutsuKigen) {
        this.TeishutsuKigen = TeishutsuKigen;
    }

    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    @JsonProperty("btnPrint")
    public ButtonPrint getBtnPrint() {
        return btnPrint;
    }

    @JsonProperty("btnPrint")
    public void setBtnPrint(ButtonPrint btnPrint) {
        this.btnPrint = btnPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getInsatsuTaishoShitei().getNinteiChosa();
    }

    @JsonIgnore
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getInsatsuTaishoShitei().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainGuide() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getCcdChosaItakusakiAndChosainGuide();
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosa_Row> getDgNinteiChosa() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getDgNinteiChosa();
    }

    @JsonIgnore
    public void setDgNinteiChosa(DataGrid<dgNinteiChosa_Row> dgNinteiChosa) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setDgNinteiChosa(dgNinteiChosa);
    }

    @JsonIgnore
    public NinteiChosaPrintDiv getNinteiChosaPrint() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint();
    }

    @JsonIgnore
    public void setNinteiChosaPrint(NinteiChosaPrintDiv NinteiChosaPrint) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setNinteiChosaPrint(NinteiChosaPrint);
    }

    @JsonIgnore
    public CheckBoxList getChk() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChk();
    }

    @JsonIgnore
    public void setChk(CheckBoxList chk) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChk(chk);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyo() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyo();
    }

    @JsonIgnore
    public void setChkChosahyo(CheckBoxList chkChosahyo) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyo(chkChosahyo);
    }

    @JsonIgnore
    public CheckBoxList getChkOcrChosahyo() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkOcrChosahyo();
    }

    @JsonIgnore
    public void setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkOcrChosahyo(chkOcrChosahyo);
    }

    @JsonIgnore
    public TextBox getTxtInsatsuSu() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getTxtInsatsuSu();
    }

    @JsonIgnore
    public void setTxtInsatsuSu(TextBox txtInsatsuSu) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setTxtInsatsuSu(txtInsatsuSu);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyo2() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().getChkChosahyo2();
    }

    @JsonIgnore
    public void setChkChosahyo2(CheckBoxList chkChosahyo2) {
        this.getInsatsuTaishoShitei().getNinteiChosa().getNinteiChosaPrint().setChkChosahyo2(chkChosahyo2);
    }

    @JsonIgnore
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho();
    }

    @JsonIgnore
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.getInsatsuTaishoShitei().setShujiiIkensho(ShujiiIkensho);
    }

    @JsonIgnore
    public DataGrid<dgShujiiIkensho_Row> getDgShujiiIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getDgShujiiIkensho();
    }

    @JsonIgnore
    public void setDgShujiiIkensho(DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setDgShujiiIkensho(dgShujiiIkensho);
    }

    @JsonIgnore
    public ShujiiIkenshoPrintDiv getShujiiIkenshoPrint() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint();
    }

    @JsonIgnore
    public void setShujiiIkenshoPrint(ShujiiIkenshoPrintDiv ShujiiIkenshoPrint) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setShujiiIkenshoPrint(ShujiiIkenshoPrint);
    }

    @JsonIgnore
    public CheckBoxList getChkInsatsuIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkInsatsuIkensho();
    }

    @JsonIgnore
    public void setChkInsatsuIkensho(CheckBoxList chkInsatsuIkensho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkInsatsuIkensho(chkInsatsuIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiIchiran() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkIkenshoSakuseiIchiran();
    }

    @JsonIgnore
    public void setChkIkenshoSakuseiIchiran(CheckBoxList chkIkenshoSakuseiIchiran) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkIkenshoSakuseiIchiran(chkIkenshoSakuseiIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiryoSeikyusho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().getChkIkenshoSakuseiryoSeikyusho();
    }

    @JsonIgnore
    public void setChkIkenshoSakuseiryoSeikyusho(CheckBoxList chkIkenshoSakuseiryoSeikyusho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().getShujiiIkenshoPrint().setChkIkenshoSakuseiryoSeikyusho(chkIkenshoSakuseiryoSeikyusho);
    }

    @JsonIgnore
    public ShindanMeireiDiv getShindanMeirei() {
        return this.getInsatsuTaishoShitei().getShindanMeirei();
    }

    @JsonIgnore
    public void setShindanMeirei(ShindanMeireiDiv ShindanMeirei) {
        this.getInsatsuTaishoShitei().setShindanMeirei(ShindanMeirei);
    }

    @JsonIgnore
    public RadioButton getRadJyushinKikan() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getRadJyushinKikan();
    }

    @JsonIgnore
    public void setRadJyushinKikan(RadioButton radJyushinKikan) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setRadJyushinKikan(radJyushinKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtJyushinymd() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJyushinymd();
    }

    @JsonIgnore
    public void setTxtJyushinymd(TextBoxDate txtJyushinymd) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJyushinymd(txtJyushinymd);
    }

    @JsonIgnore
    public TextBoxTime getTxtJushinTime() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJushinTime();
    }

    @JsonIgnore
    public void setTxtJushinTime(TextBoxTime txtJushinTime) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJushinTime(txtJushinTime);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getSpSpace1();
    }

    @JsonIgnore
    public void setSpSpace1(Space spSpace1) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJushinKikan() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJushinKikan();
    }

    @JsonIgnore
    public void setTxtJushinKikan(TextBoxDateRange txtJushinKikan) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJushinKikan(txtJushinKikan);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getSpSpace3();
    }

    @JsonIgnore
    public void setSpSpace3(Space spSpace3) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public TextBox getTxtJushinBasho() {
        return this.getInsatsuTaishoShitei().getShindanMeirei().getTxtJushinBasho();
    }

    @JsonIgnore
    public void setTxtJushinBasho(TextBox txtJushinBasho) {
        this.getInsatsuTaishoShitei().getShindanMeirei().setTxtJushinBasho(txtJushinBasho);
    }

    @JsonIgnore
    public RadioButton getRadTeishutsuKigen() {
        return this.getTeishutsuKigen().getRadTeishutsuKigen();
    }

    @JsonIgnore
    public void setRadTeishutsuKigen(RadioButton radTeishutsuKigen) {
        this.getTeishutsuKigen().setRadTeishutsuKigen(radTeishutsuKigen);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getTeishutsuKigen().getSpSpace2();
    }

    @JsonIgnore
    public void setSpSpace2(Space spSpace2) {
        this.getTeishutsuKigen().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiteiDay() {
        return this.getTeishutsuKigen().getTxtShiteiDay();
    }

    @JsonIgnore
    public void setTxtShiteiDay(TextBoxDate txtShiteiDay) {
        this.getTeishutsuKigen().setTxtShiteiDay(txtShiteiDay);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
