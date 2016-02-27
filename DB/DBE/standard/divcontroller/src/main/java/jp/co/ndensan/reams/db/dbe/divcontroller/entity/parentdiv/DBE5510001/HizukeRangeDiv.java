package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HizukeRange のクラスファイル 
 * 
 * @author 自動生成
 */
public class HizukeRangeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHizukeHani")
    private RadioButton radHizukeHani;
    @JsonProperty("txtShiteiHizukeForm")
    private TextBoxDate txtShiteiHizukeForm;
    @JsonProperty("txtShiteiHizukeTo")
    private TextBoxDate txtShiteiHizukeTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHizukeHani
     * @return radHizukeHani
     */
    @JsonProperty("radHizukeHani")
    public RadioButton getRadHizukeHani() {
        return radHizukeHani;
    }

    /*
     * setradHizukeHani
     * @param radHizukeHani radHizukeHani
     */
    @JsonProperty("radHizukeHani")
    public void setRadHizukeHani(RadioButton radHizukeHani) {
        this.radHizukeHani = radHizukeHani;
    }

    /*
     * gettxtShiteiHizukeForm
     * @return txtShiteiHizukeForm
     */
    @JsonProperty("txtShiteiHizukeForm")
    public TextBoxDate getTxtShiteiHizukeForm() {
        return txtShiteiHizukeForm;
    }

    /*
     * settxtShiteiHizukeForm
     * @param txtShiteiHizukeForm txtShiteiHizukeForm
     */
    @JsonProperty("txtShiteiHizukeForm")
    public void setTxtShiteiHizukeForm(TextBoxDate txtShiteiHizukeForm) {
        this.txtShiteiHizukeForm = txtShiteiHizukeForm;
    }

    /*
     * gettxtShiteiHizukeTo
     * @return txtShiteiHizukeTo
     */
    @JsonProperty("txtShiteiHizukeTo")
    public TextBoxDate getTxtShiteiHizukeTo() {
        return txtShiteiHizukeTo;
    }

    /*
     * settxtShiteiHizukeTo
     * @param txtShiteiHizukeTo txtShiteiHizukeTo
     */
    @JsonProperty("txtShiteiHizukeTo")
    public void setTxtShiteiHizukeTo(TextBoxDate txtShiteiHizukeTo) {
        this.txtShiteiHizukeTo = txtShiteiHizukeTo;
    }

    // </editor-fold>
}
