package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultL_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JudgementResultL のクラスファイル 
 * 
 * @author 自動生成
 */
public class JudgementResultLDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJudgementResultL")
    private DataGrid<dgJudgementResultL_Row> dgJudgementResultL;
    @JsonProperty("txtBikoL")
    private TextBox txtBikoL;
    @JsonProperty("txtUketsukeDateL")
    private TextBoxDate txtUketsukeDateL;
    @JsonProperty("txtKetteiDateL")
    private TextBoxDate txtKetteiDateL;
    @JsonProperty("radShinsaMethodL")
    private RadioButton radShinsaMethodL;
    @JsonProperty("txtShiharaiAmountL")
    private TextBoxNum txtShiharaiAmountL;
    @JsonProperty("radShikyuKubunL")
    private RadioButton radShikyuKubunL;
    @JsonProperty("txtShikyuAmountL")
    private TextBoxNum txtShikyuAmountL;
    @JsonProperty("txtFushikyuRiyuL")
    private TextBoxMultiLine txtFushikyuRiyuL;
    @JsonProperty("radKogakuAutoShokanL")
    private RadioButton radKogakuAutoShokanL;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJudgementResultL")
    public DataGrid<dgJudgementResultL_Row> getDgJudgementResultL() {
        return dgJudgementResultL;
    }

    @JsonProperty("dgJudgementResultL")
    public void setDgJudgementResultL(DataGrid<dgJudgementResultL_Row> dgJudgementResultL) {
        this.dgJudgementResultL=dgJudgementResultL;
    }

    @JsonProperty("txtBikoL")
    public TextBox getTxtBikoL() {
        return txtBikoL;
    }

    @JsonProperty("txtBikoL")
    public void setTxtBikoL(TextBox txtBikoL) {
        this.txtBikoL=txtBikoL;
    }

    @JsonProperty("txtUketsukeDateL")
    public TextBoxDate getTxtUketsukeDateL() {
        return txtUketsukeDateL;
    }

    @JsonProperty("txtUketsukeDateL")
    public void setTxtUketsukeDateL(TextBoxDate txtUketsukeDateL) {
        this.txtUketsukeDateL=txtUketsukeDateL;
    }

    @JsonProperty("txtKetteiDateL")
    public TextBoxDate getTxtKetteiDateL() {
        return txtKetteiDateL;
    }

    @JsonProperty("txtKetteiDateL")
    public void setTxtKetteiDateL(TextBoxDate txtKetteiDateL) {
        this.txtKetteiDateL=txtKetteiDateL;
    }

    @JsonProperty("radShinsaMethodL")
    public RadioButton getRadShinsaMethodL() {
        return radShinsaMethodL;
    }

    @JsonProperty("radShinsaMethodL")
    public void setRadShinsaMethodL(RadioButton radShinsaMethodL) {
        this.radShinsaMethodL=radShinsaMethodL;
    }

    @JsonProperty("txtShiharaiAmountL")
    public TextBoxNum getTxtShiharaiAmountL() {
        return txtShiharaiAmountL;
    }

    @JsonProperty("txtShiharaiAmountL")
    public void setTxtShiharaiAmountL(TextBoxNum txtShiharaiAmountL) {
        this.txtShiharaiAmountL=txtShiharaiAmountL;
    }

    @JsonProperty("radShikyuKubunL")
    public RadioButton getRadShikyuKubunL() {
        return radShikyuKubunL;
    }

    @JsonProperty("radShikyuKubunL")
    public void setRadShikyuKubunL(RadioButton radShikyuKubunL) {
        this.radShikyuKubunL=radShikyuKubunL;
    }

    @JsonProperty("txtShikyuAmountL")
    public TextBoxNum getTxtShikyuAmountL() {
        return txtShikyuAmountL;
    }

    @JsonProperty("txtShikyuAmountL")
    public void setTxtShikyuAmountL(TextBoxNum txtShikyuAmountL) {
        this.txtShikyuAmountL=txtShikyuAmountL;
    }

    @JsonProperty("txtFushikyuRiyuL")
    public TextBoxMultiLine getTxtFushikyuRiyuL() {
        return txtFushikyuRiyuL;
    }

    @JsonProperty("txtFushikyuRiyuL")
    public void setTxtFushikyuRiyuL(TextBoxMultiLine txtFushikyuRiyuL) {
        this.txtFushikyuRiyuL=txtFushikyuRiyuL;
    }

    @JsonProperty("radKogakuAutoShokanL")
    public RadioButton getRadKogakuAutoShokanL() {
        return radKogakuAutoShokanL;
    }

    @JsonProperty("radKogakuAutoShokanL")
    public void setRadKogakuAutoShokanL(RadioButton radKogakuAutoShokanL) {
        this.radKogakuAutoShokanL=radKogakuAutoShokanL;
    }

}
