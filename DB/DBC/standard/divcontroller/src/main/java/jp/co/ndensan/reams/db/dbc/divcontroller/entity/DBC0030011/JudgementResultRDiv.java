package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultR_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JudgementResultR のクラスファイル 
 * 
 * @author 自動生成
 */
public class JudgementResultRDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJudgementResultR")
    private DataGrid<dgJudgementResultR_Row> dgJudgementResultR;
    @JsonProperty("txtBikoR")
    private TextBox txtBikoR;
    @JsonProperty("txtUketsukeDateR")
    private TextBoxDate txtUketsukeDateR;
    @JsonProperty("txtKetteiDateR")
    private TextBoxDate txtKetteiDateR;
    @JsonProperty("radShinsaMethodR")
    private RadioButton radShinsaMethodR;
    @JsonProperty("txtShiharaiAmountR")
    private TextBoxNum txtShiharaiAmountR;
    @JsonProperty("radShikyuKubunR")
    private RadioButton radShikyuKubunR;
    @JsonProperty("txtShikyuAmountR")
    private TextBoxNum txtShikyuAmountR;
    @JsonProperty("txtFushikyuRiyuR")
    private TextBoxMultiLine txtFushikyuRiyuR;
    @JsonProperty("radKogakuAutoShokanR")
    private RadioButton radKogakuAutoShokanR;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJudgementResultR")
    public DataGrid<dgJudgementResultR_Row> getDgJudgementResultR() {
        return dgJudgementResultR;
    }

    @JsonProperty("dgJudgementResultR")
    public void setDgJudgementResultR(DataGrid<dgJudgementResultR_Row> dgJudgementResultR) {
        this.dgJudgementResultR=dgJudgementResultR;
    }

    @JsonProperty("txtBikoR")
    public TextBox getTxtBikoR() {
        return txtBikoR;
    }

    @JsonProperty("txtBikoR")
    public void setTxtBikoR(TextBox txtBikoR) {
        this.txtBikoR=txtBikoR;
    }

    @JsonProperty("txtUketsukeDateR")
    public TextBoxDate getTxtUketsukeDateR() {
        return txtUketsukeDateR;
    }

    @JsonProperty("txtUketsukeDateR")
    public void setTxtUketsukeDateR(TextBoxDate txtUketsukeDateR) {
        this.txtUketsukeDateR=txtUketsukeDateR;
    }

    @JsonProperty("txtKetteiDateR")
    public TextBoxDate getTxtKetteiDateR() {
        return txtKetteiDateR;
    }

    @JsonProperty("txtKetteiDateR")
    public void setTxtKetteiDateR(TextBoxDate txtKetteiDateR) {
        this.txtKetteiDateR=txtKetteiDateR;
    }

    @JsonProperty("radShinsaMethodR")
    public RadioButton getRadShinsaMethodR() {
        return radShinsaMethodR;
    }

    @JsonProperty("radShinsaMethodR")
    public void setRadShinsaMethodR(RadioButton radShinsaMethodR) {
        this.radShinsaMethodR=radShinsaMethodR;
    }

    @JsonProperty("txtShiharaiAmountR")
    public TextBoxNum getTxtShiharaiAmountR() {
        return txtShiharaiAmountR;
    }

    @JsonProperty("txtShiharaiAmountR")
    public void setTxtShiharaiAmountR(TextBoxNum txtShiharaiAmountR) {
        this.txtShiharaiAmountR=txtShiharaiAmountR;
    }

    @JsonProperty("radShikyuKubunR")
    public RadioButton getRadShikyuKubunR() {
        return radShikyuKubunR;
    }

    @JsonProperty("radShikyuKubunR")
    public void setRadShikyuKubunR(RadioButton radShikyuKubunR) {
        this.radShikyuKubunR=radShikyuKubunR;
    }

    @JsonProperty("txtShikyuAmountR")
    public TextBoxNum getTxtShikyuAmountR() {
        return txtShikyuAmountR;
    }

    @JsonProperty("txtShikyuAmountR")
    public void setTxtShikyuAmountR(TextBoxNum txtShikyuAmountR) {
        this.txtShikyuAmountR=txtShikyuAmountR;
    }

    @JsonProperty("txtFushikyuRiyuR")
    public TextBoxMultiLine getTxtFushikyuRiyuR() {
        return txtFushikyuRiyuR;
    }

    @JsonProperty("txtFushikyuRiyuR")
    public void setTxtFushikyuRiyuR(TextBoxMultiLine txtFushikyuRiyuR) {
        this.txtFushikyuRiyuR=txtFushikyuRiyuR;
    }

    @JsonProperty("radKogakuAutoShokanR")
    public RadioButton getRadKogakuAutoShokanR() {
        return radKogakuAutoShokanR;
    }

    @JsonProperty("radKogakuAutoShokanR")
    public void setRadKogakuAutoShokanR(RadioButton radKogakuAutoShokanR) {
        this.radKogakuAutoShokanR=radKogakuAutoShokanR;
    }

}
