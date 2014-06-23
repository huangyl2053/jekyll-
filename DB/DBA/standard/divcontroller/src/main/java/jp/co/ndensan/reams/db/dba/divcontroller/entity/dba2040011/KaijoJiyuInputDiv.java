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
 * KaijoJiyuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaijoJiyuInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKaijoJiyu")
    private DropDownList ddlKaijoJiyu;
    @JsonProperty("txtKaijoTodokedeDate")
    private TextBoxFlexibleDate txtKaijoTodokedeDate;
    @JsonProperty("txtKaijoDate")
    private TextBoxFlexibleDate txtKaijoDate;
    @JsonProperty("txtShisetsuTaishoDate")
    private TextBoxFlexibleDate txtShisetsuTaishoDate;

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

    @JsonProperty("txtKaijoTodokedeDate")
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return txtKaijoTodokedeDate;
    }

    @JsonProperty("txtKaijoTodokedeDate")
    public void setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.txtKaijoTodokedeDate=txtKaijoTodokedeDate;
    }

    @JsonProperty("txtKaijoDate")
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return txtKaijoDate;
    }

    @JsonProperty("txtKaijoDate")
    public void setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.txtKaijoDate=txtKaijoDate;
    }

    @JsonProperty("txtShisetsuTaishoDate")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate() {
        return txtShisetsuTaishoDate;
    }

    @JsonProperty("txtShisetsuTaishoDate")
    public void setTxtShisetsuTaishoDate(TextBoxFlexibleDate txtShisetsuTaishoDate) {
        this.txtShisetsuTaishoDate=txtShisetsuTaishoDate;
    }

}
