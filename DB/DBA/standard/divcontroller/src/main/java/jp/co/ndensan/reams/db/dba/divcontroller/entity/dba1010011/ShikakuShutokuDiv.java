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
 * ShikakuShutoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShutokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    private DropDownList ddlShikakuShutokuJiyu;
    @JsonProperty("txtShutokuDate")
    private TextBoxFlexibleDate txtShutokuDate;
    @JsonProperty("txtShutokuTodokedeDate")
    private TextBoxFlexibleDate txtShutokuTodokedeDate;
    @JsonProperty("ddlHihokenshaKubun")
    private DropDownList ddlHihokenshaKubun;
    @JsonProperty("txtNenreiTotatsuDate")
    private TextBoxFlexibleDate txtNenreiTotatsuDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public DropDownList getDdlShikakuShutokuJiyu() {
        return ddlShikakuShutokuJiyu;
    }

    @JsonProperty("ddlShikakuShutokuJiyu")
    public void setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.ddlShikakuShutokuJiyu=ddlShikakuShutokuJiyu;
    }

    @JsonProperty("txtShutokuDate")
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return txtShutokuDate;
    }

    @JsonProperty("txtShutokuDate")
    public void setTxtShutokuDate(TextBoxFlexibleDate txtShutokuDate) {
        this.txtShutokuDate=txtShutokuDate;
    }

    @JsonProperty("txtShutokuTodokedeDate")
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return txtShutokuTodokedeDate;
    }

    @JsonProperty("txtShutokuTodokedeDate")
    public void setTxtShutokuTodokedeDate(TextBoxFlexibleDate txtShutokuTodokedeDate) {
        this.txtShutokuTodokedeDate=txtShutokuTodokedeDate;
    }

    @JsonProperty("ddlHihokenshaKubun")
    public DropDownList getDdlHihokenshaKubun() {
        return ddlHihokenshaKubun;
    }

    @JsonProperty("ddlHihokenshaKubun")
    public void setDdlHihokenshaKubun(DropDownList ddlHihokenshaKubun) {
        this.ddlHihokenshaKubun=ddlHihokenshaKubun;
    }

    @JsonProperty("txtNenreiTotatsuDate")
    public TextBoxFlexibleDate getTxtNenreiTotatsuDate() {
        return txtNenreiTotatsuDate;
    }

    @JsonProperty("txtNenreiTotatsuDate")
    public void setTxtNenreiTotatsuDate(TextBoxFlexibleDate txtNenreiTotatsuDate) {
        this.txtNenreiTotatsuDate=txtNenreiTotatsuDate;
    }

}
