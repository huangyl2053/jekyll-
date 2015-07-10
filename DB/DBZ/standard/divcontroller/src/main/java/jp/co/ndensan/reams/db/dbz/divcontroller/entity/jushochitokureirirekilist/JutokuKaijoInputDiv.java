package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.KaijojiHokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    @JsonProperty("ddlKaijoJiyu")
    private DropDownList ddlKaijoJiyu;
    @JsonProperty("KaijojiHokenshaJoho")
    private KaijojiHokenshaJohoDiv KaijojiHokenshaJoho;
    @JsonProperty("kaijojiShichosonCode")
    private RString kaijojiShichosonCode;
    @JsonProperty("kaijojiHihokenshaNo")
    private RString kaijojiHihokenshaNo;
    @JsonProperty("kaijojiShoriDatetime")
    private RString kaijojiShoriDatetime;

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

    @JsonProperty("ddlKaijoJiyu")
    public DropDownList getDdlKaijoJiyu() {
        return ddlKaijoJiyu;
    }

    @JsonProperty("ddlKaijoJiyu")
    public void setDdlKaijoJiyu(DropDownList ddlKaijoJiyu) {
        this.ddlKaijoJiyu=ddlKaijoJiyu;
    }

    @JsonProperty("KaijojiHokenshaJoho")
    public KaijojiHokenshaJohoDiv getKaijojiHokenshaJoho() {
        return KaijojiHokenshaJoho;
    }

    @JsonProperty("KaijojiHokenshaJoho")
    public void setKaijojiHokenshaJoho(KaijojiHokenshaJohoDiv KaijojiHokenshaJoho) {
        this.KaijojiHokenshaJoho=KaijojiHokenshaJoho;
    }

    @JsonProperty("kaijojiShichosonCode")
    public RString getKaijojiShichosonCode() {
        return kaijojiShichosonCode;
    }

    @JsonProperty("kaijojiShichosonCode")
    public void setKaijojiShichosonCode(RString kaijojiShichosonCode) {
        this.kaijojiShichosonCode=kaijojiShichosonCode;
    }

    @JsonProperty("kaijojiHihokenshaNo")
    public RString getKaijojiHihokenshaNo() {
        return kaijojiHihokenshaNo;
    }

    @JsonProperty("kaijojiHihokenshaNo")
    public void setKaijojiHihokenshaNo(RString kaijojiHihokenshaNo) {
        this.kaijojiHihokenshaNo=kaijojiHihokenshaNo;
    }

    @JsonProperty("kaijojiShoriDatetime")
    public RString getKaijojiShoriDatetime() {
        return kaijojiShoriDatetime;
    }

    @JsonProperty("kaijojiShoriDatetime")
    public void setKaijojiShoriDatetime(RString kaijojiShoriDatetime) {
        this.kaijojiShoriDatetime=kaijojiShoriDatetime;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKaijojiSochimotoHokensha() {
        return this.getKaijojiHokenshaJoho().getDdlKaijojiSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijojiSochimotoHokensha(DropDownList ddlKaijojiSochimotoHokensha) {
        this.getKaijojiHokenshaJoho().setDdlKaijojiSochimotoHokensha(ddlKaijojiSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijojiKyuHokensha() {
        return this.getKaijojiHokenshaJoho().getDdlKaijojiKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijojiKyuHokensha(DropDownList ddlKaijojiKyuHokensha) {
        this.getKaijojiHokenshaJoho().setDdlKaijojiKyuHokensha(ddlKaijojiKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijojiJuminJono() {
        return this.getKaijojiHokenshaJoho().getDdlKaijojiJuminJono();
    }

    @JsonIgnore
    public void  setDdlKaijojiJuminJono(DropDownList ddlKaijojiJuminJono) {
        this.getKaijojiHokenshaJoho().setDdlKaijojiJuminJono(ddlKaijojiJuminJono);
    }

}
