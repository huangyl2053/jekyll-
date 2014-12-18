package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAM010011;
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
 * LblTitle4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class LblTitle4Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBoxNum3")
    private TextBoxNum TextBoxNum3;
    @JsonProperty("TextBoxCode1")
    private TextBoxCode TextBoxCode1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBoxNum3")
    public TextBoxNum getTextBoxNum3() {
        return TextBoxNum3;
    }

    @JsonProperty("TextBoxNum3")
    public void setTextBoxNum3(TextBoxNum TextBoxNum3) {
        this.TextBoxNum3=TextBoxNum3;
    }

    @JsonProperty("TextBoxCode1")
    public TextBoxCode getTextBoxCode1() {
        return TextBoxCode1;
    }

    @JsonProperty("TextBoxCode1")
    public void setTextBoxCode1(TextBoxCode TextBoxCode1) {
        this.TextBoxCode1=TextBoxCode1;
    }

}
