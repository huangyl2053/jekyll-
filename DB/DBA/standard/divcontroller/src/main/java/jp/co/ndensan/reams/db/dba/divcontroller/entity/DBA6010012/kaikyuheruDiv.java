package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012;
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
 * kaikyuheru のクラスファイル 
 * 
 * @author 自動生成
 */
public class kaikyuheruDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RadioButton1")
    private RadioButton RadioButton1;
    @JsonProperty("TextBox16")
    private TextBox TextBox16;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("RadioButton1")
    public RadioButton getRadioButton1() {
        return RadioButton1;
    }

    @JsonProperty("RadioButton1")
    public void setRadioButton1(RadioButton RadioButton1) {
        this.RadioButton1=RadioButton1;
    }

    @JsonProperty("TextBox16")
    public TextBox getTextBox16() {
        return TextBox16;
    }

    @JsonProperty("TextBox16")
    public void setTextBox16(TextBox TextBox16) {
        this.TextBox16=TextBox16;
    }

}
