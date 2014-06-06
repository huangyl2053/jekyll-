package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011;
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
 * ShikakuHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuHenkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHenkoJiyu")
    private DropDownList ddlHenkoJiyu;
    @JsonProperty("txtHenkoDate")
    private TextBoxFlexibleDate txtHenkoDate;
    @JsonProperty("txtHenkoTodokedeDate")
    private TextBoxFlexibleDate txtHenkoTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHenkoJiyu")
    public DropDownList getDdlHenkoJiyu() {
        return ddlHenkoJiyu;
    }

    @JsonProperty("ddlHenkoJiyu")
    public void setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.ddlHenkoJiyu=ddlHenkoJiyu;
    }

    @JsonProperty("txtHenkoDate")
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return txtHenkoDate;
    }

    @JsonProperty("txtHenkoDate")
    public void setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.txtHenkoDate=txtHenkoDate;
    }

    @JsonProperty("txtHenkoTodokedeDate")
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return txtHenkoTodokedeDate;
    }

    @JsonProperty("txtHenkoTodokedeDate")
    public void setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.txtHenkoTodokedeDate=txtHenkoTodokedeDate;
    }

}
