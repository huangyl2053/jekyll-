package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiTaishobi")
    private TextBoxDateRange txtZenkaiTaishobi;
    @JsonProperty("radHizukeSentaku")
    private RadioButton radHizukeSentaku;
    @JsonProperty("ChushutsubiNyuryokuEria")
    private ChushutsubiNyuryokuEriaDiv ChushutsubiNyuryokuEria;
    @JsonProperty("radInshoSentaku")
    private RadioButton radInshoSentaku;
    @JsonProperty("radKogakuJidoShokanSentaku")
    private RadioButton radKogakuJidoShokanSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiTaishobi
     * @return txtZenkaiTaishobi
     */
    @JsonProperty("txtZenkaiTaishobi")
    public TextBoxDateRange getTxtZenkaiTaishobi() {
        return txtZenkaiTaishobi;
    }

    /*
     * settxtZenkaiTaishobi
     * @param txtZenkaiTaishobi txtZenkaiTaishobi
     */
    @JsonProperty("txtZenkaiTaishobi")
    public void setTxtZenkaiTaishobi(TextBoxDateRange txtZenkaiTaishobi) {
        this.txtZenkaiTaishobi = txtZenkaiTaishobi;
    }

    /*
     * getradHizukeSentaku
     * @return radHizukeSentaku
     */
    @JsonProperty("radHizukeSentaku")
    public RadioButton getRadHizukeSentaku() {
        return radHizukeSentaku;
    }

    /*
     * setradHizukeSentaku
     * @param radHizukeSentaku radHizukeSentaku
     */
    @JsonProperty("radHizukeSentaku")
    public void setRadHizukeSentaku(RadioButton radHizukeSentaku) {
        this.radHizukeSentaku = radHizukeSentaku;
    }

    /*
     * getChushutsubiNyuryokuEria
     * @return ChushutsubiNyuryokuEria
     */
    @JsonProperty("ChushutsubiNyuryokuEria")
    public ChushutsubiNyuryokuEriaDiv getChushutsubiNyuryokuEria() {
        return ChushutsubiNyuryokuEria;
    }

    /*
     * setChushutsubiNyuryokuEria
     * @param ChushutsubiNyuryokuEria ChushutsubiNyuryokuEria
     */
    @JsonProperty("ChushutsubiNyuryokuEria")
    public void setChushutsubiNyuryokuEria(ChushutsubiNyuryokuEriaDiv ChushutsubiNyuryokuEria) {
        this.ChushutsubiNyuryokuEria = ChushutsubiNyuryokuEria;
    }

    /*
     * getradInshoSentaku
     * @return radInshoSentaku
     */
    @JsonProperty("radInshoSentaku")
    public RadioButton getRadInshoSentaku() {
        return radInshoSentaku;
    }

    /*
     * setradInshoSentaku
     * @param radInshoSentaku radInshoSentaku
     */
    @JsonProperty("radInshoSentaku")
    public void setRadInshoSentaku(RadioButton radInshoSentaku) {
        this.radInshoSentaku = radInshoSentaku;
    }

    /*
     * getradKogakuJidoShokanSentaku
     * @return radKogakuJidoShokanSentaku
     */
    @JsonProperty("radKogakuJidoShokanSentaku")
    public RadioButton getRadKogakuJidoShokanSentaku() {
        return radKogakuJidoShokanSentaku;
    }

    /*
     * setradKogakuJidoShokanSentaku
     * @param radKogakuJidoShokanSentaku radKogakuJidoShokanSentaku
     */
    @JsonProperty("radKogakuJidoShokanSentaku")
    public void setRadKogakuJidoShokanSentaku(RadioButton radKogakuJidoShokanSentaku) {
        this.radKogakuJidoShokanSentaku = radKogakuJidoShokanSentaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtUketukebi() {
        return this.getChushutsubiNyuryokuEria().getTxtUketukebi();
    }

    @JsonIgnore
    public void  setTxtUketukebi(TextBoxDateRange txtUketukebi) {
        this.getChushutsubiNyuryokuEria().setTxtUketukebi(txtUketukebi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteibi() {
        return this.getChushutsubiNyuryokuEria().getTxtKetteibi();
    }

    @JsonIgnore
    public void  setTxtKetteibi(TextBoxDateRange txtKetteibi) {
        this.getChushutsubiNyuryokuEria().setTxtKetteibi(txtKetteibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteishaUketukeNengetsu() {
        return this.getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu();
    }

    @JsonIgnore
    public void  setTxtKetteishaUketukeNengetsu(TextBoxDate txtKetteishaUketukeNengetsu) {
        this.getChushutsubiNyuryokuEria().setTxtKetteishaUketukeNengetsu(txtKetteishaUketukeNengetsu);
    }

    // </editor-fold>
}
