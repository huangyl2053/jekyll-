package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.HenkoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.HenkoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013.dgHenko_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplHenkoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHenko")
    private DataGrid<dgHenko_Row> dgHenko;
    @JsonProperty("HenkoInput")
    private HenkoInputDiv HenkoInput;
    @JsonProperty("Button1")
    private Button Button1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgHenko")
    public DataGrid<dgHenko_Row> getDgHenko() {
        return dgHenko;
    }

    @JsonProperty("dgHenko")
    public void setDgHenko(DataGrid<dgHenko_Row> dgHenko) {
        this.dgHenko=dgHenko;
    }

    @JsonProperty("HenkoInput")
    public HenkoInputDiv getHenkoInput() {
        return HenkoInput;
    }

    @JsonProperty("HenkoInput")
    public void setHenkoInput(HenkoInputDiv HenkoInput) {
        this.HenkoInput=HenkoInput;
    }

    @JsonProperty("Button1")
    public Button getButton1() {
        return Button1;
    }

    @JsonProperty("Button1")
    public void setButton1(Button Button1) {
        this.Button1=Button1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return this.getHenkoInput().getTxtHenkoDate();
    }

    @JsonIgnore
    public void  setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.getHenkoInput().setTxtHenkoDate(txtHenkoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return this.getHenkoInput().getTxtHenkoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.getHenkoInput().setTxtHenkoTodokedeDate(txtHenkoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoJiyu() {
        return this.getHenkoInput().getDdlHenkoJiyu();
    }

    @JsonIgnore
    public void  setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.getHenkoInput().setDdlHenkoJiyu(ddlHenkoJiyu);
    }

    @JsonIgnore
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return this.getHenkoInput().getHenkoHokenshaJoho();
    }

    @JsonIgnore
    public void  setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.getHenkoInput().setHenkoHokenshaJoho(HenkoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoShozaiHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoShozaiHokensha(DropDownList ddlHenkoShozaiHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoShozaiHokensha(ddlHenkoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

}
