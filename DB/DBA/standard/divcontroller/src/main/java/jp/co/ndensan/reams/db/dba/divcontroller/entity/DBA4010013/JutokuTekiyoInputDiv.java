package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoHokenshaJohoDiv;
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
    @JsonProperty("txtTekiyoDate")
    private TextBoxFlexibleDate txtTekiyoDate;
    @JsonProperty("txtTekyoTodokedeDate")
    private TextBoxFlexibleDate txtTekyoTodokedeDate;
    @JsonProperty("ddlTekiyoJiyu")
    private DropDownList ddlTekiyoJiyu;
    @JsonProperty("JutokuTekiyoHokenshaJoho")
    private JutokuTekiyoHokenshaJohoDiv JutokuTekiyoHokenshaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTekiyoDate")
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.txtTekiyoDate=txtTekiyoDate;
    }

    @JsonProperty("txtTekyoTodokedeDate")
    public TextBoxFlexibleDate getTxtTekyoTodokedeDate() {
        return txtTekyoTodokedeDate;
    }

    @JsonProperty("txtTekyoTodokedeDate")
    public void setTxtTekyoTodokedeDate(TextBoxFlexibleDate txtTekyoTodokedeDate) {
        this.txtTekyoTodokedeDate=txtTekyoTodokedeDate;
    }

    @JsonProperty("ddlTekiyoJiyu")
    public DropDownList getDdlTekiyoJiyu() {
        return ddlTekiyoJiyu;
    }

    @JsonProperty("ddlTekiyoJiyu")
    public void setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.ddlTekiyoJiyu=ddlTekiyoJiyu;
    }

    @JsonProperty("JutokuTekiyoHokenshaJoho")
    public JutokuTekiyoHokenshaJohoDiv getJutokuTekiyoHokenshaJoho() {
        return JutokuTekiyoHokenshaJoho;
    }

    @JsonProperty("JutokuTekiyoHokenshaJoho")
    public void setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJohoDiv JutokuTekiyoHokenshaJoho) {
        this.JutokuTekiyoHokenshaJoho=JutokuTekiyoHokenshaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTekiyoShozaiHokensha() {
        return this.getJutokuTekiyoHokenshaJoho().getDdlTekiyoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoShozaiHokensha(DropDownList ddlTekiyoShozaiHokensha) {
        this.getJutokuTekiyoHokenshaJoho().setDdlTekiyoShozaiHokensha(ddlTekiyoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoSochimotoHokensha() {
        return this.getJutokuTekiyoHokenshaJoho().getDdlTekiyoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoSochimotoHokensha(DropDownList ddlTekiyoSochimotoHokensha) {
        this.getJutokuTekiyoHokenshaJoho().setDdlTekiyoSochimotoHokensha(ddlTekiyoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoKyuHokensha() {
        return this.getJutokuTekiyoHokenshaJoho().getDdlTekiyoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoKyuHokensha(DropDownList ddlTekiyoKyuHokensha) {
        this.getJutokuTekiyoHokenshaJoho().setDdlTekiyoKyuHokensha(ddlTekiyoKyuHokensha);
    }

}
