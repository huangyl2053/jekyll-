package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbza010001;
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
 * SoushitsuKei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SoushitsuKeiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJukiShojoJiyu")
    private TextBox txtJukiShojoJiyu;
    @JsonProperty("txtShojoTodokedeYmd")
    private TextBoxFlexibleDate txtShojoTodokedeYmd;
    @JsonProperty("txtShojoIdoYmd")
    private TextBoxFlexibleDate txtShojoIdoYmd;
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    private DropDownList ddlShikakuSoshitsuJiyu;
    @JsonProperty("txtShikakuSoshitsuYmd")
    private TextBoxFlexibleDate txtShikakuSoshitsuYmd;
    @JsonProperty("txtSoshitsuTodokedeYmd")
    private TextBoxFlexibleDate txtSoshitsuTodokedeYmd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJukiShojoJiyu")
    public TextBox getTxtJukiShojoJiyu() {
        return txtJukiShojoJiyu;
    }

    @JsonProperty("txtJukiShojoJiyu")
    public void setTxtJukiShojoJiyu(TextBox txtJukiShojoJiyu) {
        this.txtJukiShojoJiyu=txtJukiShojoJiyu;
    }

    @JsonProperty("txtShojoTodokedeYmd")
    public TextBoxFlexibleDate getTxtShojoTodokedeYmd() {
        return txtShojoTodokedeYmd;
    }

    @JsonProperty("txtShojoTodokedeYmd")
    public void setTxtShojoTodokedeYmd(TextBoxFlexibleDate txtShojoTodokedeYmd) {
        this.txtShojoTodokedeYmd=txtShojoTodokedeYmd;
    }

    @JsonProperty("txtShojoIdoYmd")
    public TextBoxFlexibleDate getTxtShojoIdoYmd() {
        return txtShojoIdoYmd;
    }

    @JsonProperty("txtShojoIdoYmd")
    public void setTxtShojoIdoYmd(TextBoxFlexibleDate txtShojoIdoYmd) {
        this.txtShojoIdoYmd=txtShojoIdoYmd;
    }

    @JsonProperty("ddlShikakuSoshitsuJiyu")
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return ddlShikakuSoshitsuJiyu;
    }

    @JsonProperty("ddlShikakuSoshitsuJiyu")
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.ddlShikakuSoshitsuJiyu=ddlShikakuSoshitsuJiyu;
    }

    @JsonProperty("txtShikakuSoshitsuYmd")
    public TextBoxFlexibleDate getTxtShikakuSoshitsuYmd() {
        return txtShikakuSoshitsuYmd;
    }

    @JsonProperty("txtShikakuSoshitsuYmd")
    public void setTxtShikakuSoshitsuYmd(TextBoxFlexibleDate txtShikakuSoshitsuYmd) {
        this.txtShikakuSoshitsuYmd=txtShikakuSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuTodokedeYmd")
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeYmd() {
        return txtSoshitsuTodokedeYmd;
    }

    @JsonProperty("txtSoshitsuTodokedeYmd")
    public void setTxtSoshitsuTodokedeYmd(TextBoxFlexibleDate txtSoshitsuTodokedeYmd) {
        this.txtSoshitsuTodokedeYmd=txtSoshitsuTodokedeYmd;
    }

}
