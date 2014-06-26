package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2030011;
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
 * JutokuTekiyoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuTekiyoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlJutokuTekiyoJiyu")
    private DropDownList ddlJutokuTekiyoJiyu;
    @JsonProperty("txtJutokuTekiyoDate")
    private TextBoxFlexibleDate txtJutokuTekiyoDate;
    @JsonProperty("txtJutokuTekiyoTodokedeDate")
    private TextBoxFlexibleDate txtJutokuTekiyoTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlJutokuTekiyoJiyu")
    public DropDownList getDdlJutokuTekiyoJiyu() {
        return ddlJutokuTekiyoJiyu;
    }

    @JsonProperty("ddlJutokuTekiyoJiyu")
    public void setDdlJutokuTekiyoJiyu(DropDownList ddlJutokuTekiyoJiyu) {
        this.ddlJutokuTekiyoJiyu=ddlJutokuTekiyoJiyu;
    }

    @JsonProperty("txtJutokuTekiyoDate")
    public TextBoxFlexibleDate getTxtJutokuTekiyoDate() {
        return txtJutokuTekiyoDate;
    }

    @JsonProperty("txtJutokuTekiyoDate")
    public void setTxtJutokuTekiyoDate(TextBoxFlexibleDate txtJutokuTekiyoDate) {
        this.txtJutokuTekiyoDate=txtJutokuTekiyoDate;
    }

    @JsonProperty("txtJutokuTekiyoTodokedeDate")
    public TextBoxFlexibleDate getTxtJutokuTekiyoTodokedeDate() {
        return txtJutokuTekiyoTodokedeDate;
    }

    @JsonProperty("txtJutokuTekiyoTodokedeDate")
    public void setTxtJutokuTekiyoTodokedeDate(TextBoxFlexibleDate txtJutokuTekiyoTodokedeDate) {
        this.txtJutokuTekiyoTodokedeDate=txtJutokuTekiyoTodokedeDate;
    }

}
