package jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaIraishoAndChosahyoAndIkenshoPrint.dgShujiiIkensho_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * InsatsuTaishoShitei のクラスファイル 
 * 
 * @author 自動生成
 */
public class InsatsuTaishoShiteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("ShujiiIkensho")
    private ShujiiIkenshoDiv ShujiiIkensho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa=NinteiChosa;
    }

    @JsonProperty("ShujiiIkensho")
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return ShujiiIkensho;
    }

    @JsonProperty("ShujiiIkensho")
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.ShujiiIkensho=ShujiiIkensho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainGuide() {
        return this.getNinteiChosa().getCcdChosaItakusakiAndChosainGuide();
    }

    @JsonIgnore
    public CheckBoxList getChk() {
        return this.getNinteiChosa().getChk();
    }

    @JsonIgnore
    public void  setChk(CheckBoxList chk) {
        this.getNinteiChosa().setChk(chk);
    }

    @JsonIgnore
    public CheckBoxList getChkOcrChosahyo() {
        return this.getNinteiChosa().getChkOcrChosahyo();
    }

    @JsonIgnore
    public void  setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.getNinteiChosa().setChkOcrChosahyo(chkOcrChosahyo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getNinteiChosa().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getNinteiChosa().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public TextBox getTxtInsatsuSu() {
        return this.getNinteiChosa().getTxtInsatsuSu();
    }

    @JsonIgnore
    public void  setTxtInsatsuSu(TextBox txtInsatsuSu) {
        this.getNinteiChosa().setTxtInsatsuSu(txtInsatsuSu);
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
    public CheckBoxList getChkInsatsuIkensho() {
        return this.getShujiiIkensho().getChkInsatsuIkensho();
    }

    @JsonIgnore
    public void  setChkInsatsuIkensho(CheckBoxList chkInsatsuIkensho) {
        this.getShujiiIkensho().setChkInsatsuIkensho(chkInsatsuIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiryoSeikyusho() {
        return this.getShujiiIkensho().getChkIkenshoSakuseiryoSeikyusho();
    }

    @JsonIgnore
    public void  setChkIkenshoSakuseiryoSeikyusho(CheckBoxList chkIkenshoSakuseiryoSeikyusho) {
        this.getShujiiIkensho().setChkIkenshoSakuseiryoSeikyusho(chkIkenshoSakuseiryoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSakuseiIchiran() {
        return this.getShujiiIkensho().getChkIkenshoSakuseiIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoSakuseiIchiran(CheckBoxList chkIkenshoSakuseiIchiran) {
        this.getShujiiIkensho().setChkIkenshoSakuseiIchiran(chkIkenshoSakuseiIchiran);
    }

    // </editor-fold>
}
