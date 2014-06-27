package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011;
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
 * ShisetsuHenkoTekiyoJiyuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuHenkoTekiyoJiyuInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuHenkoTekiyoJiyu")
    private TextBox txtShisetsuHenkoTekiyoJiyu;
    @JsonProperty("txtShisetsuHenkoTekiyoDate")
    private TextBoxFlexibleDate txtShisetsuHenkoTekiyoDate;
    @JsonProperty("txtShisetsuHenkoTekiyoTodokedeDate")
    private TextBoxFlexibleDate txtShisetsuHenkoTekiyoTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShisetsuHenkoTekiyoJiyu")
    public TextBox getTxtShisetsuHenkoTekiyoJiyu() {
        return txtShisetsuHenkoTekiyoJiyu;
    }

    @JsonProperty("txtShisetsuHenkoTekiyoJiyu")
    public void setTxtShisetsuHenkoTekiyoJiyu(TextBox txtShisetsuHenkoTekiyoJiyu) {
        this.txtShisetsuHenkoTekiyoJiyu=txtShisetsuHenkoTekiyoJiyu;
    }

    @JsonProperty("txtShisetsuHenkoTekiyoDate")
    public TextBoxFlexibleDate getTxtShisetsuHenkoTekiyoDate() {
        return txtShisetsuHenkoTekiyoDate;
    }

    @JsonProperty("txtShisetsuHenkoTekiyoDate")
    public void setTxtShisetsuHenkoTekiyoDate(TextBoxFlexibleDate txtShisetsuHenkoTekiyoDate) {
        this.txtShisetsuHenkoTekiyoDate=txtShisetsuHenkoTekiyoDate;
    }

    @JsonProperty("txtShisetsuHenkoTekiyoTodokedeDate")
    public TextBoxFlexibleDate getTxtShisetsuHenkoTekiyoTodokedeDate() {
        return txtShisetsuHenkoTekiyoTodokedeDate;
    }

    @JsonProperty("txtShisetsuHenkoTekiyoTodokedeDate")
    public void setTxtShisetsuHenkoTekiyoTodokedeDate(TextBoxFlexibleDate txtShisetsuHenkoTekiyoTodokedeDate) {
        this.txtShisetsuHenkoTekiyoTodokedeDate=txtShisetsuHenkoTekiyoTodokedeDate;
    }

}
