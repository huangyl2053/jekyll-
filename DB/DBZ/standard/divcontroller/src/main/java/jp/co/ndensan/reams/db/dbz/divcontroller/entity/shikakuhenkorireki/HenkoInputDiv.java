package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.HenkoHokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HenkoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class HenkoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoDate")
    private TextBoxFlexibleDate txtHenkoDate;
    @JsonProperty("txtHenkoTodokedeDate")
    private TextBoxFlexibleDate txtHenkoTodokedeDate;
    @JsonProperty("ddlHenkoJiyu")
    private DropDownList ddlHenkoJiyu;
    @JsonProperty("HenkoHokenshaJoho")
    private HenkoHokenshaJohoDiv HenkoHokenshaJoho;
    @JsonProperty("btnHenkoKakutei")
    private Button btnHenkoKakutei;
    @JsonProperty("btnHenkoTorikeshi")
    private Button btnHenkoTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHenkoDate")
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return txtHenkoDate;
    }

    @JsonProperty("txtHenkoDate")
    public void setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.txtHenkoDate=txtHenkoDate;
    }

    @JsonProperty("txtHenkoTodokedeDate")
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return txtHenkoTodokedeDate;
    }

    @JsonProperty("txtHenkoTodokedeDate")
    public void setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.txtHenkoTodokedeDate=txtHenkoTodokedeDate;
    }

    @JsonProperty("ddlHenkoJiyu")
    public DropDownList getDdlHenkoJiyu() {
        return ddlHenkoJiyu;
    }

    @JsonProperty("ddlHenkoJiyu")
    public void setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.ddlHenkoJiyu=ddlHenkoJiyu;
    }

    @JsonProperty("HenkoHokenshaJoho")
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return HenkoHokenshaJoho;
    }

    @JsonProperty("HenkoHokenshaJoho")
    public void setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.HenkoHokenshaJoho=HenkoHokenshaJoho;
    }

    @JsonProperty("btnHenkoKakutei")
    public Button getBtnHenkoKakutei() {
        return btnHenkoKakutei;
    }

    @JsonProperty("btnHenkoKakutei")
    public void setBtnHenkoKakutei(Button btnHenkoKakutei) {
        this.btnHenkoKakutei=btnHenkoKakutei;
    }

    @JsonProperty("btnHenkoTorikeshi")
    public Button getBtnHenkoTorikeshi() {
        return btnHenkoTorikeshi;
    }

    @JsonProperty("btnHenkoTorikeshi")
    public void setBtnHenkoTorikeshi(Button btnHenkoTorikeshi) {
        this.btnHenkoTorikeshi=btnHenkoTorikeshi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHenkoShozaiHokensha() {
        return this.getHenkoHokenshaJoho().getDdlHenkoShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoShozaiHokensha(DropDownList ddlHenkoShozaiHokensha) {
        this.getHenkoHokenshaJoho().setDdlHenkoShozaiHokensha(ddlHenkoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlJuminJoho() {
        return this.getHenkoHokenshaJoho().getDdlJuminJoho();
    }

    @JsonIgnore
    public void  setDdlJuminJoho(DropDownList ddlJuminJoho) {
        this.getHenkoHokenshaJoho().setDdlJuminJoho(ddlJuminJoho);
    }

}
