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
 * JukyushaIdoRenrakuhyoTeisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoTeiseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HorizontalLine1")
    private HorizontalLine HorizontalLine1;
    @JsonProperty("TextBoxDate1")
    private TextBoxDate TextBoxDate1;
    @JsonProperty("RadioButton1")
    private RadioButton RadioButton1;
    @JsonProperty("HorizontalLine2")
    private HorizontalLine HorizontalLine2;

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

    @JsonProperty("TextBoxDate1")
    public TextBoxDate getTextBoxDate1() {
        return TextBoxDate1;
    }

    @JsonProperty("TextBoxDate1")
    public void setTextBoxDate1(TextBoxDate TextBoxDate1) {
        this.TextBoxDate1=TextBoxDate1;
    }

    @JsonProperty("RadioButton1")
    public RadioButton getRadioButton1() {
        return RadioButton1;
    }

    @JsonProperty("RadioButton1")
    public void setRadioButton1(RadioButton RadioButton1) {
        this.RadioButton1=RadioButton1;
    }

    @JsonProperty("HorizontalLine2")
    public HorizontalLine getHorizontalLine2() {
        return HorizontalLine2;
    }

    @JsonProperty("HorizontalLine2")
    public void setHorizontalLine2(HorizontalLine HorizontalLine2) {
        this.HorizontalLine2=HorizontalLine2;
    }

}
