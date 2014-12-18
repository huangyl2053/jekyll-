package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutokuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutokuTekiyoInput")
    private JutokuTekiyoInputDiv JutokuTekiyoInput;
    @JsonProperty("JutokuKaijoInput")
    private JutokuKaijoInputDiv JutokuKaijoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutokuTekiyoInput")
    public JutokuTekiyoInputDiv getJutokuTekiyoInput() {
        return JutokuTekiyoInput;
    }

    @JsonProperty("JutokuTekiyoInput")
    public void setJutokuTekiyoInput(JutokuTekiyoInputDiv JutokuTekiyoInput) {
        this.JutokuTekiyoInput=JutokuTekiyoInput;
    }

    @JsonProperty("JutokuKaijoInput")
    public JutokuKaijoInputDiv getJutokuKaijoInput() {
        return JutokuKaijoInput;
    }

    @JsonProperty("JutokuKaijoInput")
    public void setJutokuKaijoInput(JutokuKaijoInputDiv JutokuKaijoInput) {
        this.JutokuKaijoInput=JutokuKaijoInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return this.getJutokuTekiyoInput().getTxtTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.getJutokuTekiyoInput().setTxtTekiyoDate(txtTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekyoTodokedeDate() {
        return this.getJutokuTekiyoInput().getTxtTekyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTekyoTodokedeDate(TextBoxFlexibleDate txtTekyoTodokedeDate) {
        this.getJutokuTekiyoInput().setTxtTekyoTodokedeDate(txtTekyoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyu() {
        return this.getJutokuTekiyoInput().getDdlTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.getJutokuTekiyoInput().setDdlTekiyoJiyu(ddlTekiyoJiyu);
    }

    @JsonIgnore
    public JutokuTekiyoHokenshaJohoDiv getJutokuTekiyoHokenshaJoho() {
        return this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJohoDiv JutokuTekiyoHokenshaJoho) {
        this.getJutokuTekiyoInput().setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoShozaiHokensha() {
        return this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoShozaiHokensha(DropDownList ddlTekiyoShozaiHokensha) {
        this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoShozaiHokensha(ddlTekiyoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoSochimotoHokensha() {
        return this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoSochimotoHokensha(DropDownList ddlTekiyoSochimotoHokensha) {
        this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoSochimotoHokensha(ddlTekiyoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoKyuHokensha() {
        return this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoKyuHokensha(DropDownList ddlTekiyoKyuHokensha) {
        this.getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoKyuHokensha(ddlTekiyoKyuHokensha);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return this.getJutokuKaijoInput().getTxtKaijoDate();
    }

    @JsonIgnore
    public void  setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.getJutokuKaijoInput().setTxtKaijoDate(txtKaijoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return this.getJutokuKaijoInput().getTxtKaijoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.getJutokuKaijoInput().setTxtKaijoTodokedeDate(txtKaijoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJIyu() {
        return this.getJutokuKaijoInput().getDdlKaijoJIyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJIyu(DropDownList ddlKaijoJIyu) {
        this.getJutokuKaijoInput().setDdlKaijoJIyu(ddlKaijoJIyu);
    }

    @JsonIgnore
    public JutokuKaijoHokenshaJohoDiv getJutokuKaijoHokenshaJoho() {
        return this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJohoDiv JutokuKaijoHokenshaJoho) {
        this.getJutokuKaijoInput().setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoShozaiHokensha() {
        return this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoShozaiHokensha(DropDownList ddlKaijoShozaiHokensha) {
        this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoShozaiHokensha(ddlKaijoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoSochimotoHokensha() {
        return this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoSochimotoHokensha(DropDownList ddlKaijoSochimotoHokensha) {
        this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoSochimotoHokensha(ddlKaijoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoKyuHokensha() {
        return this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoKyuHokensha(DropDownList ddlKaijoKyuHokensha) {
        this.getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoKyuHokensha(ddlKaijoKyuHokensha);
    }

}
