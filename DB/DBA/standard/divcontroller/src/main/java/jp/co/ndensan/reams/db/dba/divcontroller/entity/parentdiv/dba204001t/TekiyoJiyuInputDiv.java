package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.dba204001t;
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
 * TekiyoJiyuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJiyuInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTekiyoJiyu")
    private DropDownList ddlTekiyoJiyu;
    @JsonProperty("txtShisetsuNyushoDate")
    private TextBoxFlexibleDate txtShisetsuNyushoDate;
    @JsonProperty("txtTekiyoDate")
    private TextBoxFlexibleDate txtTekiyoDate;
    @JsonProperty("txtTekiyoTodokedeDate")
    private TextBoxFlexibleDate txtTekiyoTodokedeDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTekiyoJiyu")
    public DropDownList getDdlTekiyoJiyu() {
        return ddlTekiyoJiyu;
    }

    @JsonProperty("ddlTekiyoJiyu")
    public void setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.ddlTekiyoJiyu=ddlTekiyoJiyu;
    }

    @JsonProperty("txtShisetsuNyushoDate")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate() {
        return txtShisetsuNyushoDate;
    }

    @JsonProperty("txtShisetsuNyushoDate")
    public void setTxtShisetsuNyushoDate(TextBoxFlexibleDate txtShisetsuNyushoDate) {
        this.txtShisetsuNyushoDate=txtShisetsuNyushoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.txtTekiyoDate=txtTekiyoDate;
    }

    @JsonProperty("txtTekiyoTodokedeDate")
    public TextBoxFlexibleDate getTxtTekiyoTodokedeDate() {
        return txtTekiyoTodokedeDate;
    }

    @JsonProperty("txtTekiyoTodokedeDate")
    public void setTxtTekiyoTodokedeDate(TextBoxFlexibleDate txtTekiyoTodokedeDate) {
        this.txtTekiyoTodokedeDate=txtTekiyoTodokedeDate;
    }

}
