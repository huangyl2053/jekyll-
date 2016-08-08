package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDataShutsuryoku")
    private RadioButton radDataShutsuryoku;
    @JsonProperty("txtNijiHanteibi")
    private TextBoxDateRange txtNijiHanteibi;
    @JsonProperty("txtDispMax")
    private TextBoxNum txtDispMax;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradDataShutsuryoku
     * @return radDataShutsuryoku
     */
    @JsonProperty("radDataShutsuryoku")
    public RadioButton getRadDataShutsuryoku() {
        return radDataShutsuryoku;
    }

    /*
     * setradDataShutsuryoku
     * @param radDataShutsuryoku radDataShutsuryoku
     */
    @JsonProperty("radDataShutsuryoku")
    public void setRadDataShutsuryoku(RadioButton radDataShutsuryoku) {
        this.radDataShutsuryoku = radDataShutsuryoku;
    }

    /*
     * gettxtNijiHanteibi
     * @return txtNijiHanteibi
     */
    @JsonProperty("txtNijiHanteibi")
    public TextBoxDateRange getTxtNijiHanteibi() {
        return txtNijiHanteibi;
    }

    /*
     * settxtNijiHanteibi
     * @param txtNijiHanteibi txtNijiHanteibi
     */
    @JsonProperty("txtNijiHanteibi")
    public void setTxtNijiHanteibi(TextBoxDateRange txtNijiHanteibi) {
        this.txtNijiHanteibi = txtNijiHanteibi;
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

    // </editor-fold>
}
