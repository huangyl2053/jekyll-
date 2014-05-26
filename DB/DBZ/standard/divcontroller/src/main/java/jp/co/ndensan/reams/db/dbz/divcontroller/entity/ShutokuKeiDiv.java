package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * ShutokuKei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShutokuKeiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJukiTorokuJiyu")
    private TextBox txtJukiTorokuJiyu;
    @JsonProperty("txtTorokuIdoYmd")
    private TextBoxFlexibleDate txtTorokuIdoYmd;
    @JsonProperty("txtTorokuTodokedeYmd")
    private TextBoxFlexibleDate txtTorokuTodokedeYmd;
    @JsonProperty("ddlShikakuShutokuJiyu")
    private DropDownList ddlShikakuShutokuJiyu;
    @JsonProperty("txtShikakuShutokuYmd")
    private TextBoxFlexibleDate txtShikakuShutokuYmd;
    @JsonProperty("txtShutokuTodokedeYmd")
    private TextBoxFlexibleDate txtShutokuTodokedeYmd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJukiTorokuJiyu")
    public TextBox getTxtJukiTorokuJiyu() {
        return txtJukiTorokuJiyu;
    }

    @JsonProperty("txtJukiTorokuJiyu")
    public void setTxtJukiTorokuJiyu(TextBox txtJukiTorokuJiyu) {
        this.txtJukiTorokuJiyu=txtJukiTorokuJiyu;
    }

    @JsonProperty("txtTorokuIdoYmd")
    public TextBoxFlexibleDate getTxtTorokuIdoYmd() {
        return txtTorokuIdoYmd;
    }

    @JsonProperty("txtTorokuIdoYmd")
    public void setTxtTorokuIdoYmd(TextBoxFlexibleDate txtTorokuIdoYmd) {
        this.txtTorokuIdoYmd=txtTorokuIdoYmd;
    }

    @JsonProperty("txtTorokuTodokedeYmd")
    public TextBoxFlexibleDate getTxtTorokuTodokedeYmd() {
        return txtTorokuTodokedeYmd;
    }

    @JsonProperty("txtTorokuTodokedeYmd")
    public void setTxtTorokuTodokedeYmd(TextBoxFlexibleDate txtTorokuTodokedeYmd) {
        this.txtTorokuTodokedeYmd=txtTorokuTodokedeYmd;
    }

    @JsonProperty("ddlShikakuShutokuJiyu")
    public DropDownList getDdlShikakuShutokuJiyu() {
        return ddlShikakuShutokuJiyu;
    }

    @JsonProperty("ddlShikakuShutokuJiyu")
    public void setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.ddlShikakuShutokuJiyu=ddlShikakuShutokuJiyu;
    }

    @JsonProperty("txtShikakuShutokuYmd")
    public TextBoxFlexibleDate getTxtShikakuShutokuYmd() {
        return txtShikakuShutokuYmd;
    }

    @JsonProperty("txtShikakuShutokuYmd")
    public void setTxtShikakuShutokuYmd(TextBoxFlexibleDate txtShikakuShutokuYmd) {
        this.txtShikakuShutokuYmd=txtShikakuShutokuYmd;
    }

    @JsonProperty("txtShutokuTodokedeYmd")
    public TextBoxFlexibleDate getTxtShutokuTodokedeYmd() {
        return txtShutokuTodokedeYmd;
    }

    @JsonProperty("txtShutokuTodokedeYmd")
    public void setTxtShutokuTodokedeYmd(TextBoxFlexibleDate txtShutokuTodokedeYmd) {
        this.txtShutokuTodokedeYmd=txtShutokuTodokedeYmd;
    }

}
