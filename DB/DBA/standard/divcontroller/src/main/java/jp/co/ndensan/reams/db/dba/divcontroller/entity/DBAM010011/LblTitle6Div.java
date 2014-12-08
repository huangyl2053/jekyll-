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
 * LblTitle6 のクラスファイル 
 * 
 * @author 自動生成
 */
public class LblTitle6Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBoxNum4")
    private TextBoxNum TextBoxNum4;
    @JsonProperty("TextBoxCode2")
    private TextBoxCode TextBoxCode2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBoxNum4")
    public TextBoxNum getTextBoxNum4() {
        return TextBoxNum4;
    }

    @JsonProperty("TextBoxNum4")
    public void setTextBoxNum4(TextBoxNum TextBoxNum4) {
        this.TextBoxNum4=TextBoxNum4;
    }

    @JsonProperty("TextBoxCode2")
    public TextBoxCode getTextBoxCode2() {
        return TextBoxCode2;
    }

    @JsonProperty("TextBoxCode2")
    public void setTextBoxCode2(TextBoxCode TextBoxCode2) {
        this.TextBoxCode2=TextBoxCode2;
    }

}
