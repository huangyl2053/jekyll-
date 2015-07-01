package jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaIraishoAndChosahyoAndIkenshoPrint;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChosaItakusakiAndChosainGuide")
    private ChosaItakusakiAndChosainInputDiv ccdChosaItakusakiAndChosainGuide;
    @JsonProperty("chk")
    private CheckBoxList chk;
    @JsonProperty("chkOcrChosahyo")
    private CheckBoxList chkOcrChosahyo;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("txtInsatsuSu")
    private TextBox txtInsatsuSu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdChosaItakusakiAndChosainGuide")
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainGuide() {
        return ccdChosaItakusakiAndChosainGuide;
    }

    @JsonProperty("chk")
    public CheckBoxList getChk() {
        return chk;
    }

    @JsonProperty("chk")
    public void setChk(CheckBoxList chk) {
        this.chk=chk;
    }

    @JsonProperty("chkOcrChosahyo")
    public CheckBoxList getChkOcrChosahyo() {
        return chkOcrChosahyo;
    }

    @JsonProperty("chkOcrChosahyo")
    public void setChkOcrChosahyo(CheckBoxList chkOcrChosahyo) {
        this.chkOcrChosahyo=chkOcrChosahyo;
    }

    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1=spSpace1;
    }

    @JsonProperty("txtInsatsuSu")
    public TextBox getTxtInsatsuSu() {
        return txtInsatsuSu;
    }

    @JsonProperty("txtInsatsuSu")
    public void setTxtInsatsuSu(TextBox txtInsatsuSu) {
        this.txtInsatsuSu=txtInsatsuSu;
    }

    // </editor-fold>
}
