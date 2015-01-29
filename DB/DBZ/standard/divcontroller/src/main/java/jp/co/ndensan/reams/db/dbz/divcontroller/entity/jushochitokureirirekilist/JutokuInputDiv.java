package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JutokuKaijoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JutokuTekiyoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.KaijojiHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.TekiyojiHokenshaJohoDiv;
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
    @JsonProperty("btnJutokuKakutei")
    private Button btnJutokuKakutei;
    @JsonProperty("btnJutokuTorikeshi")
    private Button btnJutokuTorikeshi;

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

    @JsonProperty("btnJutokuKakutei")
    public Button getBtnJutokuKakutei() {
        return btnJutokuKakutei;
    }

    @JsonProperty("btnJutokuKakutei")
    public void setBtnJutokuKakutei(Button btnJutokuKakutei) {
        this.btnJutokuKakutei=btnJutokuKakutei;
    }

    @JsonProperty("btnJutokuTorikeshi")
    public Button getBtnJutokuTorikeshi() {
        return btnJutokuTorikeshi;
    }

    @JsonProperty("btnJutokuTorikeshi")
    public void setBtnJutokuTorikeshi(Button btnJutokuTorikeshi) {
        this.btnJutokuTorikeshi=btnJutokuTorikeshi;
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
    public TextBoxFlexibleDate getTxtTekiyoTodokedeDate() {
        return this.getJutokuTekiyoInput().getTxtTekiyoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTekiyoTodokedeDate(TextBoxFlexibleDate txtTekiyoTodokedeDate) {
        this.getJutokuTekiyoInput().setTxtTekiyoTodokedeDate(txtTekiyoTodokedeDate);
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
    public TekiyojiHokenshaJohoDiv getTekiyojiHokenshaJoho() {
        return this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho();
    }

    @JsonIgnore
    public void  setTekiyojiHokenshaJoho(TekiyojiHokenshaJohoDiv TekiyojiHokenshaJoho) {
        this.getJutokuTekiyoInput().setTekiyojiHokenshaJoho(TekiyojiHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyojiSochimotoHokensha() {
        return this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho().getDdlTekiyojiSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyojiSochimotoHokensha(DropDownList ddlTekiyojiSochimotoHokensha) {
        this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho().setDdlTekiyojiSochimotoHokensha(ddlTekiyojiSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyojiKyuHokensha() {
        return this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho().getDdlTekiyojiKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlTekiyojiKyuHokensha(DropDownList ddlTekiyojiKyuHokensha) {
        this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho().setDdlTekiyojiKyuHokensha(ddlTekiyojiKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyojiJuminJoho() {
        return this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho().getDdlTekiyojiJuminJoho();
    }

    @JsonIgnore
    public void  setDdlTekiyojiJuminJoho(DropDownList ddlTekiyojiJuminJoho) {
        this.getJutokuTekiyoInput().getTekiyojiHokenshaJoho().setDdlTekiyojiJuminJoho(ddlTekiyojiJuminJoho);
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
    public DropDownList getDdlKaijoJiyu() {
        return this.getJutokuKaijoInput().getDdlKaijoJiyu();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyu(DropDownList ddlKaijoJiyu) {
        this.getJutokuKaijoInput().setDdlKaijoJiyu(ddlKaijoJiyu);
    }

    @JsonIgnore
    public KaijojiHokenshaJohoDiv getKaijojiHokenshaJoho() {
        return this.getJutokuKaijoInput().getKaijojiHokenshaJoho();
    }

    @JsonIgnore
    public void  setKaijojiHokenshaJoho(KaijojiHokenshaJohoDiv KaijojiHokenshaJoho) {
        this.getJutokuKaijoInput().setKaijojiHokenshaJoho(KaijojiHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlKaijojiSochimotoHokensha() {
        return this.getJutokuKaijoInput().getKaijojiHokenshaJoho().getDdlKaijojiSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijojiSochimotoHokensha(DropDownList ddlKaijojiSochimotoHokensha) {
        this.getJutokuKaijoInput().getKaijojiHokenshaJoho().setDdlKaijojiSochimotoHokensha(ddlKaijojiSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijojiKyuHokensha() {
        return this.getJutokuKaijoInput().getKaijojiHokenshaJoho().getDdlKaijojiKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlKaijojiKyuHokensha(DropDownList ddlKaijojiKyuHokensha) {
        this.getJutokuKaijoInput().getKaijojiHokenshaJoho().setDdlKaijojiKyuHokensha(ddlKaijojiKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlKaijojiJuminJono() {
        return this.getJutokuKaijoInput().getKaijojiHokenshaJoho().getDdlKaijojiJuminJono();
    }

    @JsonIgnore
    public void  setDdlKaijojiJuminJono(DropDownList ddlKaijojiJuminJono) {
        this.getJutokuKaijoInput().getKaijojiHokenshaJoho().setDdlKaijojiJuminJono(ddlKaijojiJuminJono);
    }

}
