package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * InsatsuTaishoShitei のクラスファイル 
 * 
 * @author 自動生成
 */
public class InsatsuTaishoShiteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("ShujiiIkensho")
    private ShujiiIkenshoDiv ShujiiIkensho;
    @JsonProperty("ShindanMeirei")
    private ShindanMeireiDiv ShindanMeirei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * getNinteiChosa
     * @return NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    /*
     * setNinteiChosa
     * @param NinteiChosa NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa = NinteiChosa;
    }

    /*
     * getShujiiIkensho
     * @return ShujiiIkensho
     */
    @JsonProperty("ShujiiIkensho")
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return ShujiiIkensho;
    }

    /*
     * setShujiiIkensho
     * @param ShujiiIkensho ShujiiIkensho
     */
    @JsonProperty("ShujiiIkensho")
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.ShujiiIkensho = ShujiiIkensho;
    }

    /*
     * getShindanMeirei
     * @return ShindanMeirei
     */
    @JsonProperty("ShindanMeirei")
    public ShindanMeireiDiv getShindanMeirei() {
        return ShindanMeirei;
    }

    /*
     * setShindanMeirei
     * @param ShindanMeirei ShindanMeirei
     */
    @JsonProperty("ShindanMeirei")
    public void setShindanMeirei(ShindanMeireiDiv ShindanMeirei) {
        this.ShindanMeirei = ShindanMeirei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgNinteiChosa_Row> getDgNinteiChosa() {
        return this.getNinteiChosa().getDgNinteiChosa();
    }

    @JsonIgnore
    public void  setDgNinteiChosa(DataGrid<dgNinteiChosa_Row> dgNinteiChosa) {
        this.getNinteiChosa().setDgNinteiChosa(dgNinteiChosa);
    }

    @JsonIgnore
    public NinteiChosaPrintDiv getNinteiChosaPrint() {
        return this.getNinteiChosa().getNinteiChosaPrint();
    }

    @JsonIgnore
    public void  setNinteiChosaPrint(NinteiChosaPrintDiv NinteiChosaPrint) {
        this.getNinteiChosa().setNinteiChosaPrint(NinteiChosaPrint);
    }

    @JsonIgnore
    public CheckBoxList getChk() {
        return this.getNinteiChosa().getNinteiChosaPrint().getChk();
    }

    @JsonIgnore
    public void  setChk(CheckBoxList chk) {
        this.getNinteiChosa().getNinteiChosaPrint().setChk(chk);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyo() {
        return this.getNinteiChosa().getNinteiChosaPrint().getChkChosahyo();
    }

    @JsonIgnore
    public void  setChkChosahyo(CheckBoxList chkChosahyo) {
        this.getNinteiChosa().getNinteiChosaPrint().setChkChosahyo(chkChosahyo);
    }

    @JsonIgnore
    public CheckBoxList getChkOcrChosahyo() {
        return this.getNinteiChosa().getNinteiChosaPrint().getChkOcrChosahyo();
    }

    @JsonIgnore
    public void  setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.getNinteiChosa().getNinteiChosaPrint().setChkOcrChosahyo(chkOcrChosahyo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyo2() {
        return this.getNinteiChosa().getNinteiChosaPrint().getChkChosahyo2();
    }

    @JsonIgnore
    public void  setChkChosahyo2(CheckBoxList chkChosahyo2) {
        this.getNinteiChosa().getNinteiChosaPrint().setChkChosahyo2(chkChosahyo2);
    }

    @JsonIgnore
    public DataGrid<dgShujiiIkensho_Row> getDgShujiiIkensho() {
        return this.getShujiiIkensho().getDgShujiiIkensho();
    }

    @JsonIgnore
    public void  setDgShujiiIkensho(DataGrid<dgShujiiIkensho_Row> dgShujiiIkensho) {
        this.getShujiiIkensho().setDgShujiiIkensho(dgShujiiIkensho);
    }

    @JsonIgnore
    public ShujiiIkenshoPrintDiv getShujiiIkenshoPrint() {
        return this.getShujiiIkensho().getShujiiIkenshoPrint();
    }

    @JsonIgnore
    public void  setShujiiIkenshoPrint(ShujiiIkenshoPrintDiv ShujiiIkenshoPrint) {
        this.getShujiiIkensho().setShujiiIkenshoPrint(ShujiiIkenshoPrint);
    }

    @JsonIgnore
    public CheckBoxList getChkInsatsuIkensho() {
        return this.getShujiiIkensho().getShujiiIkenshoPrint().getChkInsatsuIkensho();
    }

    @JsonIgnore
    public void  setChkInsatsuIkensho(CheckBoxList chkInsatsuIkensho) {
        this.getShujiiIkensho().getShujiiIkenshoPrint().setChkInsatsuIkensho(chkInsatsuIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiIchiran() {
        return this.getShujiiIkensho().getShujiiIkenshoPrint().getChkIkenshoSakuseiIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoSakuseiIchiran(CheckBoxList chkIkenshoSakuseiIchiran) {
        this.getShujiiIkensho().getShujiiIkenshoPrint().setChkIkenshoSakuseiIchiran(chkIkenshoSakuseiIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiryoSeikyusho() {
        return this.getShujiiIkensho().getShujiiIkenshoPrint().getChkIkenshoSakuseiryoSeikyusho();
    }

    @JsonIgnore
    public void  setChkIkenshoSakuseiryoSeikyusho(CheckBoxList chkIkenshoSakuseiryoSeikyusho) {
        this.getShujiiIkensho().getShujiiIkenshoPrint().setChkIkenshoSakuseiryoSeikyusho(chkIkenshoSakuseiryoSeikyusho);
    }

    @JsonIgnore
    public RadioButton getRadJyushinKikan() {
        return this.getShindanMeirei().getRadJyushinKikan();
    }

    @JsonIgnore
    public void  setRadJyushinKikan(RadioButton radJyushinKikan) {
        this.getShindanMeirei().setRadJyushinKikan(radJyushinKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtJyushinymd() {
        return this.getShindanMeirei().getTxtJyushinymd();
    }

    @JsonIgnore
    public void  setTxtJyushinymd(TextBoxDate txtJyushinymd) {
        this.getShindanMeirei().setTxtJyushinymd(txtJyushinymd);
    }

    @JsonIgnore
    public TextBoxTime getTxtJushinTime() {
        return this.getShindanMeirei().getTxtJushinTime();
    }

    @JsonIgnore
    public void  setTxtJushinTime(TextBoxTime txtJushinTime) {
        this.getShindanMeirei().setTxtJushinTime(txtJushinTime);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getShindanMeirei().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getShindanMeirei().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJushinKikan() {
        return this.getShindanMeirei().getTxtJushinKikan();
    }

    @JsonIgnore
    public void  setTxtJushinKikan(TextBoxDateRange txtJushinKikan) {
        this.getShindanMeirei().setTxtJushinKikan(txtJushinKikan);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getShindanMeirei().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getShindanMeirei().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public TextBox getTxtJushinBasho() {
        return this.getShindanMeirei().getTxtJushinBasho();
    }

    @JsonIgnore
    public void  setTxtJushinBasho(TextBox txtJushinBasho) {
        this.getShindanMeirei().setTxtJushinBasho(txtJushinBasho);
    }

    // </editor-fold>
}
