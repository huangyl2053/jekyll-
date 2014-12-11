package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoHokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutokuKaijoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuKaijoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaijoDate")
    private TextBoxFlexibleDate txtKaijoDate;
    @JsonProperty("txtKaijoTodokedeDate")
    private TextBoxFlexibleDate txtKaijoTodokedeDate;
    @JsonProperty("ddlKaijoJIyu")
    private DropDownList ddlKaijoJIyu;
    @JsonProperty("JutokuKaijoHokenshaJoho")
    private JutokuKaijoHokenshaJohoDiv JutokuKaijoHokenshaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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

    @JsonProperty("ddlKaijoJIyu")
    public DropDownList getDdlKaijoJIyu() {
        return ddlKaijoJIyu;
    }

    @JsonProperty("ddlKaijoJIyu")
    public void setDdlKaijoJIyu(DropDownList ddlKaijoJIyu) {
        this.ddlKaijoJIyu=ddlKaijoJIyu;
    }

    @JsonProperty("JutokuKaijoHokenshaJoho")
    public JutokuKaijoHokenshaJohoDiv getJutokuKaijoHokenshaJoho() {
        return JutokuKaijoHokenshaJoho;
    }

    @JsonProperty("JutokuKaijoHokenshaJoho")
    public void setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJohoDiv JutokuKaijoHokenshaJoho) {
        this.JutokuKaijoHokenshaJoho=JutokuKaijoHokenshaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKaijoShozaiHokensha() {
        return this.getJutokuKaijoHokenshaJoho().getDdlKaijoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoShozaiHokensha(DropDownList ddlKaijoShozaiHokensha) {
        this.getJutokuKaijoHokenshaJoho().setDdlKaijoShozaiHokensha(ddlKaijoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoSochimotoHokensha() {
        return this.getJutokuKaijoHokenshaJoho().getDdlKaijoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoSochimotoHokensha(DropDownList ddlKaijoSochimotoHokensha) {
        this.getJutokuKaijoHokenshaJoho().setDdlKaijoSochimotoHokensha(ddlKaijoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoKyuHokensha() {
        return this.getJutokuKaijoHokenshaJoho().getDdlKaijoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoKyuHokensha(DropDownList ddlKaijoKyuHokensha) {
        this.getJutokuKaijoHokenshaJoho().setDdlKaijoKyuHokensha(ddlKaijoKyuHokensha);
    }

}
