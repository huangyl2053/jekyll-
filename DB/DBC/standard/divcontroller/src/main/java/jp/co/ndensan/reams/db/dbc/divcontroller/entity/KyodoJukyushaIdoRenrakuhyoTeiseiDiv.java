package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyodoJukyushaIdoRenrakuhyoTeisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoJukyushaIdoRenrakuhyoTeiseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HorizontalLine1")
    private HorizontalLine HorizontalLine1;
    @JsonProperty("TextBoxDate3")
    private TextBoxDate TextBoxDate3;
    @JsonProperty("RadioButton6")
    private RadioButton RadioButton6;
    @JsonProperty("HorizontalLine5")
    private HorizontalLine HorizontalLine5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HorizontalLine1")
    public HorizontalLine getHorizontalLine1() {
        return HorizontalLine1;
    }

    @JsonProperty("HorizontalLine1")
    public void setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.HorizontalLine1=HorizontalLine1;
    }

    @JsonProperty("TextBoxDate3")
    public TextBoxDate getTextBoxDate3() {
        return TextBoxDate3;
    }

    @JsonProperty("TextBoxDate3")
    public void setTextBoxDate3(TextBoxDate TextBoxDate3) {
        this.TextBoxDate3=TextBoxDate3;
    }

    @JsonProperty("RadioButton6")
    public RadioButton getRadioButton6() {
        return RadioButton6;
    }

    @JsonProperty("RadioButton6")
    public void setRadioButton6(RadioButton RadioButton6) {
        this.RadioButton6=RadioButton6;
    }

    @JsonProperty("HorizontalLine5")
    public HorizontalLine getHorizontalLine5() {
        return HorizontalLine5;
    }

    @JsonProperty("HorizontalLine5")
    public void setHorizontalLine5(HorizontalLine HorizontalLine5) {
        this.HorizontalLine5=HorizontalLine5;
    }

}
