package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011;
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
 * JogaishaKaijoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JogaishaKaijoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKaijoJiyu")
    private DropDownList ddlKaijoJiyu;
    @JsonProperty("txtTaishoDate")
    private TextBoxFlexibleDate txtTaishoDate;
    @JsonProperty("txtKaijoDate")
    private TextBoxFlexibleDate txtKaijoDate;
    @JsonProperty("txtKaijoTodokedeDate")
    private TextBoxFlexibleDate txtKaijoTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlKaijoJiyu")
    public DropDownList getDdlKaijoJiyu() {
        return ddlKaijoJiyu;
    }

    @JsonProperty("ddlKaijoJiyu")
    public void setDdlKaijoJiyu(DropDownList ddlKaijoJiyu) {
        this.ddlKaijoJiyu=ddlKaijoJiyu;
    }

    @JsonProperty("txtTaishoDate")
    public TextBoxFlexibleDate getTxtTaishoDate() {
        return txtTaishoDate;
    }

    @JsonProperty("txtTaishoDate")
    public void setTxtTaishoDate(TextBoxFlexibleDate txtTaishoDate) {
        this.txtTaishoDate=txtTaishoDate;
    }

    @JsonProperty("txtKaijoDate")
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return txtKaijoDate;
    }

    @JsonProperty("txtKaijoDate")
    public void setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.txtKaijoDate=txtKaijoDate;
    }

    @JsonProperty("txtKaijoTodokedeDate")
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return txtKaijoTodokedeDate;
    }

    @JsonProperty("txtKaijoTodokedeDate")
    public void setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.txtKaijoTodokedeDate=txtKaijoTodokedeDate;
    }

}
