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
 * JutokuKaijo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuKaijoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlJutokuKaijoJiyu")
    private DropDownList ddlJutokuKaijoJiyu;
    @JsonProperty("txtJutokuKaijoDate")
    private TextBoxFlexibleDate txtJutokuKaijoDate;
    @JsonProperty("txtJutokuKaijoTodokedeDate")
    private TextBoxFlexibleDate txtJutokuKaijoTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlJutokuKaijoJiyu")
    public DropDownList getDdlJutokuKaijoJiyu() {
        return ddlJutokuKaijoJiyu;
    }

    @JsonProperty("ddlJutokuKaijoJiyu")
    public void setDdlJutokuKaijoJiyu(DropDownList ddlJutokuKaijoJiyu) {
        this.ddlJutokuKaijoJiyu=ddlJutokuKaijoJiyu;
    }

    @JsonProperty("txtJutokuKaijoDate")
    public TextBoxFlexibleDate getTxtJutokuKaijoDate() {
        return txtJutokuKaijoDate;
    }

    @JsonProperty("txtJutokuKaijoDate")
    public void setTxtJutokuKaijoDate(TextBoxFlexibleDate txtJutokuKaijoDate) {
        this.txtJutokuKaijoDate=txtJutokuKaijoDate;
    }

    @JsonProperty("txtJutokuKaijoTodokedeDate")
    public TextBoxFlexibleDate getTxtJutokuKaijoTodokedeDate() {
        return txtJutokuKaijoTodokedeDate;
    }

    @JsonProperty("txtJutokuKaijoTodokedeDate")
    public void setTxtJutokuKaijoTodokedeDate(TextBoxFlexibleDate txtJutokuKaijoTodokedeDate) {
        this.txtJutokuKaijoTodokedeDate=txtJutokuKaijoTodokedeDate;
    }

}
