package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyuGendogakuKyotakuServiceTop のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class ShikyuGendogakuKyotakuServiceTopDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtIdoDate")
    private TextBoxDate txtIdoDate;
    @JsonProperty("radIdoKubun")
    private RadioButton radIdoKubun;
    @JsonProperty("txtIdoJiyu")
    private TextBoxCode txtIdoJiyu;
    @JsonProperty("txtYukoDateRange")
    private TextBoxDateRange txtYukoDateRange;
    @JsonProperty("radTeiseiKubun")
    private RadioButton radTeiseiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIdoDate")
    public TextBoxDate getTxtIdoDate() {
        return txtIdoDate;
    }

    @JsonProperty("txtIdoDate")
    public void setTxtIdoDate(TextBoxDate txtIdoDate) {
        this.txtIdoDate = txtIdoDate;
    }

    @JsonProperty("radIdoKubun")
    public RadioButton getRadIdoKubun() {
        return radIdoKubun;
    }

    @JsonProperty("radIdoKubun")
    public void setRadIdoKubun(RadioButton radIdoKubun) {
        this.radIdoKubun = radIdoKubun;
    }

    @JsonProperty("txtIdoJiyu")
    public TextBoxCode getTxtIdoJiyu() {
        return txtIdoJiyu;
    }

    @JsonProperty("txtIdoJiyu")
    public void setTxtIdoJiyu(TextBoxCode txtIdoJiyu) {
        this.txtIdoJiyu = txtIdoJiyu;
    }

    @JsonProperty("txtYukoDateRange")
    public TextBoxDateRange getTxtYukoDateRange() {
        return txtYukoDateRange;
    }

    @JsonProperty("txtYukoDateRange")
    public void setTxtYukoDateRange(TextBoxDateRange txtYukoDateRange) {
        this.txtYukoDateRange = txtYukoDateRange;
    }

    @JsonProperty("radTeiseiKubun")
    public RadioButton getRadTeiseiKubun() {
        return radTeiseiKubun;
    }

    @JsonProperty("radTeiseiKubun")
    public void setRadTeiseiKubun(RadioButton radTeiseiKubun) {
        this.radTeiseiKubun = radTeiseiKubun;
    }

}
