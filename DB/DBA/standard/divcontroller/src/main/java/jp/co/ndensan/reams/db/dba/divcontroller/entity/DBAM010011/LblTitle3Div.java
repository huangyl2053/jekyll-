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
 * LblTitle3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class LblTitle3Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DropDownList2")
    private DropDownList DropDownList2;
    @JsonProperty("TextBoxNum1")
    private TextBoxNum TextBoxNum1;
    @JsonProperty("TextBoxNum2")
    private TextBoxNum TextBoxNum2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("DropDownList2")
    public DropDownList getDropDownList2() {
        return DropDownList2;
    }

    @JsonProperty("DropDownList2")
    public void setDropDownList2(DropDownList DropDownList2) {
        this.DropDownList2=DropDownList2;
    }

    @JsonProperty("TextBoxNum1")
    public TextBoxNum getTextBoxNum1() {
        return TextBoxNum1;
    }

    @JsonProperty("TextBoxNum1")
    public void setTextBoxNum1(TextBoxNum TextBoxNum1) {
        this.TextBoxNum1=TextBoxNum1;
    }

    @JsonProperty("TextBoxNum2")
    public TextBoxNum getTextBoxNum2() {
        return TextBoxNum2;
    }

    @JsonProperty("TextBoxNum2")
    public void setTextBoxNum2(TextBoxNum TextBoxNum2) {
        this.TextBoxNum2=TextBoxNum2;
    }

}
