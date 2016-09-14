package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kensakujyoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakujyokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHyojiJoken")
    private RadioButton radHyojiJoken;
    @JsonProperty("txtDispMax")
    private TextBoxNum txtDispMax;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHyojiJoken
     * @return radHyojiJoken
     */
    @JsonProperty("radHyojiJoken")
    public RadioButton getRadHyojiJoken() {
        return radHyojiJoken;
    }

    /*
     * setradHyojiJoken
     * @param radHyojiJoken radHyojiJoken
     */
    @JsonProperty("radHyojiJoken")
    public void setRadHyojiJoken(RadioButton radHyojiJoken) {
        this.radHyojiJoken = radHyojiJoken;
    }

    /*
     * gettxtDispMax
     * @return txtDispMax
     */
    @JsonProperty("txtDispMax")
    public TextBoxNum getTxtDispMax() {
        return txtDispMax;
    }

    /*
     * settxtDispMax
     * @param txtDispMax txtDispMax
     */
    @JsonProperty("txtDispMax")
    public void setTxtDispMax(TextBoxNum txtDispMax) {
        this.txtDispMax = txtDispMax;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}
