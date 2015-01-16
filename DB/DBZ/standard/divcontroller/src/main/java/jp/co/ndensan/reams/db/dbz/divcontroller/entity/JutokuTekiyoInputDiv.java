package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tekiyojiHokenshaJohoDiv;
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
    @JsonProperty("txtTekiyoTodokedeDate")
    private TextBoxFlexibleDate txtTekiyoTodokedeDate;
    @JsonProperty("ddlTekiyoJiyu")
    private DropDownList ddlTekiyoJiyu;
    @JsonProperty("tekiyojiHokenshaJoho")
    private tekiyojiHokenshaJohoDiv tekiyojiHokenshaJoho;

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

    @JsonProperty("txtTekiyoTodokedeDate")
    public TextBoxFlexibleDate getTxtTekiyoTodokedeDate() {
        return txtTekiyoTodokedeDate;
    }

    @JsonProperty("txtTekiyoTodokedeDate")
    public void setTxtTekiyoTodokedeDate(TextBoxFlexibleDate txtTekiyoTodokedeDate) {
        this.txtTekiyoTodokedeDate=txtTekiyoTodokedeDate;
    }

    @JsonProperty("ddlTekiyoJiyu")
    public DropDownList getDdlTekiyoJiyu() {
        return ddlTekiyoJiyu;
    }

    @JsonProperty("ddlTekiyoJiyu")
    public void setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.ddlTekiyoJiyu=ddlTekiyoJiyu;
    }

    @JsonProperty("tekiyojiHokenshaJoho")
    public tekiyojiHokenshaJohoDiv getTekiyojiHokenshaJoho() {
        return tekiyojiHokenshaJoho;
    }

    @JsonProperty("tekiyojiHokenshaJoho")
    public void setTekiyojiHokenshaJoho(tekiyojiHokenshaJohoDiv tekiyojiHokenshaJoho) {
        this.tekiyojiHokenshaJoho=tekiyojiHokenshaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTekiyojiShozaiHokensha() {
        return this.getTekiyojiHokenshaJoho().getDdlTekiyojiShozaiHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyojiShozaiHokensha(DropDownList ddlTekiyojiShozaiHokensha) {
        this.getTekiyojiHokenshaJoho().setDdlTekiyojiShozaiHokensha(ddlTekiyojiShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyojiSochimotoHokensha() {
        return this.getTekiyojiHokenshaJoho().getDdlTekiyojiSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyojiSochimotoHokensha(DropDownList ddlTekiyojiSochimotoHokensha) {
        this.getTekiyojiHokenshaJoho().setDdlTekiyojiSochimotoHokensha(ddlTekiyojiSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyojiKyuHokensha() {
        return this.getTekiyojiHokenshaJoho().getDdlTekiyojiKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyojiKyuHokensha(DropDownList ddlTekiyojiKyuHokensha) {
        this.getTekiyojiHokenshaJoho().setDdlTekiyojiKyuHokensha(ddlTekiyojiKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyojiJuminJoho() {
        return this.getTekiyojiHokenshaJoho().getDdlTekiyojiJuminJoho();
    }

    @JsonIgnore
    public void  setDdlTekiyojiJuminJoho(DropDownList ddlTekiyojiJuminJoho) {
        this.getTekiyojiHokenshaJoho().setDdlTekiyojiJuminJoho(ddlTekiyojiJuminJoho);
    }

}
