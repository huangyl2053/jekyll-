package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
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

/**
 * ChosaIraishoAndChosahyoAndIkenshoPrint のクラスファイル
 *
 * @author 自動生成
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrintDiv extends Panel implements IChosaIraishoAndChosahyoAndIkenshoPrintDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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
    public CheckBoxList getChk() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getChk();
    }

    @JsonIgnore
    public void setChk(CheckBoxList chk) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setChk(chk);
    }

    @JsonIgnore
    public CheckBoxList getChkOcrChosahyo() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getChkOcrChosahyo();
    }

    @JsonIgnore
    public void setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setChkOcrChosahyo(chkOcrChosahyo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getSpSpace1();
    }

    @JsonIgnore
    public void setSpSpace1(Space spSpace1) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public TextBox getTxtInsatsuSu() {
        return this.getInsatsuTaishoShitei().getNinteiChosa().getTxtInsatsuSu();
    }

    @JsonIgnore
    public void setTxtInsatsuSu(TextBox txtInsatsuSu) {
        this.getInsatsuTaishoShitei().getNinteiChosa().setTxtInsatsuSu(txtInsatsuSu);
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
    public CheckBoxList getChkInsatsuIkensho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getChkInsatsuIkensho();
    }

    @JsonIgnore
    public void setChkInsatsuIkensho(CheckBoxList chkInsatsuIkensho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setChkInsatsuIkensho(chkInsatsuIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiryoSeikyusho() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getChkIkenshoSakuseiryoSeikyusho();
    }

    @JsonIgnore
    public void setChkIkenshoSakuseiryoSeikyusho(CheckBoxList chkIkenshoSakuseiryoSeikyusho) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setChkIkenshoSakuseiryoSeikyusho(chkIkenshoSakuseiryoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiIchiran() {
        return this.getInsatsuTaishoShitei().getShujiiIkensho().getChkIkenshoSakuseiIchiran();
    }

    @JsonIgnore
    public void setChkIkenshoSakuseiIchiran(CheckBoxList chkIkenshoSakuseiIchiran) {
        this.getInsatsuTaishoShitei().getShujiiIkensho().setChkIkenshoSakuseiIchiran(chkIkenshoSakuseiIchiran);
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
