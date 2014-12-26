package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuKaijoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.JutokuTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.dgJutoku_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplJutoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplJutokuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJutoku")
    private DataGrid<dgJutoku_Row> dgJutoku;
    @JsonProperty("JutokuInput")
    private JutokuInputDiv JutokuInput;
    @JsonProperty("Button3")
    private Button Button3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJutoku")
    public DataGrid<dgJutoku_Row> getDgJutoku() {
        return dgJutoku;
    }

    @JsonProperty("dgJutoku")
    public void setDgJutoku(DataGrid<dgJutoku_Row> dgJutoku) {
        this.dgJutoku=dgJutoku;
    }

    @JsonProperty("JutokuInput")
    public JutokuInputDiv getJutokuInput() {
        return JutokuInput;
    }

    @JsonProperty("JutokuInput")
    public void setJutokuInput(JutokuInputDiv JutokuInput) {
        this.JutokuInput=JutokuInput;
    }

    @JsonProperty("Button3")
    public Button getButton3() {
        return Button3;
    }

    @JsonProperty("Button3")
    public void setButton3(Button Button3) {
        this.Button3=Button3;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JutokuTekiyoInputDiv getJutokuTekiyoInput() {
        return this.getJutokuInput().getJutokuTekiyoInput();
    }

    @JsonIgnore
    public void  setJutokuTekiyoInput(JutokuTekiyoInputDiv JutokuTekiyoInput) {
        this.getJutokuInput().setJutokuTekiyoInput(JutokuTekiyoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return this.getJutokuInput().getJutokuTekiyoInput().getTxtTekiyoDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.getJutokuInput().getJutokuTekiyoInput().setTxtTekiyoDate(txtTekiyoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekyoTodokedeDate() {
        return this.getJutokuInput().getJutokuTekiyoInput().getTxtTekyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTekyoTodokedeDate(TextBoxFlexibleDate txtTekyoTodokedeDate) {
        this.getJutokuInput().getJutokuTekiyoInput().setTxtTekyoTodokedeDate(txtTekyoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyu() {
        return this.getJutokuInput().getJutokuTekiyoInput().getDdlTekiyoJiyu();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.getJutokuInput().getJutokuTekiyoInput().setDdlTekiyoJiyu(ddlTekiyoJiyu);
    }

    @JsonIgnore
    public JutokuTekiyoHokenshaJohoDiv getJutokuTekiyoHokenshaJoho() {
        return this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJohoDiv JutokuTekiyoHokenshaJoho) {
        this.getJutokuInput().getJutokuTekiyoInput().setJutokuTekiyoHokenshaJoho(JutokuTekiyoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoShozaiHokensha() {
        return this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoShozaiHokensha(DropDownList ddlTekiyoShozaiHokensha) {
        this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoShozaiHokensha(ddlTekiyoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoSochimotoHokensha() {
        return this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoSochimotoHokensha(DropDownList ddlTekiyoSochimotoHokensha) {
        this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoSochimotoHokensha(ddlTekiyoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoKyuHokensha() {
        return this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().getDdlTekiyoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyoKyuHokensha(DropDownList ddlTekiyoKyuHokensha) {
        this.getJutokuInput().getJutokuTekiyoInput().getJutokuTekiyoHokenshaJoho().setDdlTekiyoKyuHokensha(ddlTekiyoKyuHokensha);
    }

    @JsonIgnore
    public JutokuKaijoInputDiv getJutokuKaijoInput() {
        return this.getJutokuInput().getJutokuKaijoInput();
    }

    @JsonIgnore
    public void  setJutokuKaijoInput(JutokuKaijoInputDiv JutokuKaijoInput) {
        this.getJutokuInput().setJutokuKaijoInput(JutokuKaijoInput);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return this.getJutokuInput().getJutokuKaijoInput().getTxtKaijoDate();
    }

    @JsonIgnore
    public void  setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.getJutokuInput().getJutokuKaijoInput().setTxtKaijoDate(txtKaijoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return this.getJutokuInput().getJutokuKaijoInput().getTxtKaijoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.getJutokuInput().getJutokuKaijoInput().setTxtKaijoTodokedeDate(txtKaijoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJIyu() {
        return this.getJutokuInput().getJutokuKaijoInput().getDdlKaijoJIyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJIyu(DropDownList ddlKaijoJIyu) {
        this.getJutokuInput().getJutokuKaijoInput().setDdlKaijoJIyu(ddlKaijoJIyu);
    }

    @JsonIgnore
    public JutokuKaijoHokenshaJohoDiv getJutokuKaijoHokenshaJoho() {
        return this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho();
    }

    @JsonIgnore
    public void  setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJohoDiv JutokuKaijoHokenshaJoho) {
        this.getJutokuInput().getJutokuKaijoInput().setJutokuKaijoHokenshaJoho(JutokuKaijoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoShozaiHokensha() {
        return this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoShozaiHokensha(DropDownList ddlKaijoShozaiHokensha) {
        this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoShozaiHokensha(ddlKaijoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoSochimotoHokensha() {
        return this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoSochimotoHokensha(DropDownList ddlKaijoSochimotoHokensha) {
        this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoSochimotoHokensha(ddlKaijoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoKyuHokensha() {
        return this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().getDdlKaijoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijoKyuHokensha(DropDownList ddlKaijoKyuHokensha) {
        this.getJutokuInput().getJutokuKaijoInput().getJutokuKaijoHokenshaJoho().setDdlKaijoKyuHokensha(ddlKaijoKyuHokensha);
    }

}
