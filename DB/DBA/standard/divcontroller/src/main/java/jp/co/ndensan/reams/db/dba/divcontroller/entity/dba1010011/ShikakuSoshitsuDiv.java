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
 * ShikakuSoshitsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuSoshitsuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSoshitsuJiyu")
    private DropDownList ddlSoshitsuJiyu;
    @JsonProperty("txtSoshitsuDate")
    private TextBoxFlexibleDate txtSoshitsuDate;
    @JsonProperty("txtSoshitsuTodokedeDate")
    private TextBoxFlexibleDate txtSoshitsuTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlSoshitsuJiyu")
    public DropDownList getDdlSoshitsuJiyu() {
        return ddlSoshitsuJiyu;
    }

    @JsonProperty("ddlSoshitsuJiyu")
    public void setDdlSoshitsuJiyu(DropDownList ddlSoshitsuJiyu) {
        this.ddlSoshitsuJiyu=ddlSoshitsuJiyu;
    }

    @JsonProperty("txtSoshitsuDate")
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return txtSoshitsuDate;
    }

    @JsonProperty("txtSoshitsuDate")
    public void setTxtSoshitsuDate(TextBoxFlexibleDate txtSoshitsuDate) {
        this.txtSoshitsuDate=txtSoshitsuDate;
    }

    @JsonProperty("txtSoshitsuTodokedeDate")
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return txtSoshitsuTodokedeDate;
    }

    @JsonProperty("txtSoshitsuTodokedeDate")
    public void setTxtSoshitsuTodokedeDate(TextBoxFlexibleDate txtSoshitsuTodokedeDate) {
        this.txtSoshitsuTodokedeDate=txtSoshitsuTodokedeDate;
    }

}
