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
 * KagoMoshitate のクラスファイル 
 * 
 * @author 自動生成
 */
public class KagoMoshitateDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtMoshitateshaKubun")
    private TextBox txtMoshitateshaKubun;
    @JsonProperty("txtSendYM")
    private TextBoxDate txtSendYM;
    @JsonProperty("txtShokisaiHokenshaNo")
    private TextBoxCode txtShokisaiHokenshaNo;
    @JsonProperty("txtShokisaiHokenshaName")
    private TextBox txtShokisaiHokenshaName;
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtKagoForm")
    private TextBox txtKagoForm;
    @JsonProperty("txtMoshitateDate")
    private TextBoxDate txtMoshitateDate;
    @JsonProperty("ddlKagoMoshitateRiyu")
    private DropDownList ddlKagoMoshitateRiyu;
    @JsonProperty("chkForDogetsuShinsa")
    private CheckBoxList chkForDogetsuShinsa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo=txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName=txtJigyoshaName;
    }

    @JsonProperty("txtMoshitateshaKubun")
    public TextBox getTxtMoshitateshaKubun() {
        return txtMoshitateshaKubun;
    }

    @JsonProperty("txtMoshitateshaKubun")
    public void setTxtMoshitateshaKubun(TextBox txtMoshitateshaKubun) {
        this.txtMoshitateshaKubun=txtMoshitateshaKubun;
    }

    @JsonProperty("txtSendYM")
    public TextBoxDate getTxtSendYM() {
        return txtSendYM;
    }

    @JsonProperty("txtSendYM")
    public void setTxtSendYM(TextBoxDate txtSendYM) {
        this.txtSendYM=txtSendYM;
    }

    @JsonProperty("txtShokisaiHokenshaNo")
    public TextBoxCode getTxtShokisaiHokenshaNo() {
        return txtShokisaiHokenshaNo;
    }

    @JsonProperty("txtShokisaiHokenshaNo")
    public void setTxtShokisaiHokenshaNo(TextBoxCode txtShokisaiHokenshaNo) {
        this.txtShokisaiHokenshaNo=txtShokisaiHokenshaNo;
    }

    @JsonProperty("txtShokisaiHokenshaName")
    public TextBox getTxtShokisaiHokenshaName() {
        return txtShokisaiHokenshaName;
    }

    @JsonProperty("txtShokisaiHokenshaName")
    public void setTxtShokisaiHokenshaName(TextBox txtShokisaiHokenshaName) {
        this.txtShokisaiHokenshaName=txtShokisaiHokenshaName;
    }

    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM=txtTeikyoYM;
    }

    @JsonProperty("txtKagoForm")
    public TextBox getTxtKagoForm() {
        return txtKagoForm;
    }

    @JsonProperty("txtKagoForm")
    public void setTxtKagoForm(TextBox txtKagoForm) {
        this.txtKagoForm=txtKagoForm;
    }

    @JsonProperty("txtMoshitateDate")
    public TextBoxDate getTxtMoshitateDate() {
        return txtMoshitateDate;
    }

    @JsonProperty("txtMoshitateDate")
    public void setTxtMoshitateDate(TextBoxDate txtMoshitateDate) {
        this.txtMoshitateDate=txtMoshitateDate;
    }

    @JsonProperty("ddlKagoMoshitateRiyu")
    public DropDownList getDdlKagoMoshitateRiyu() {
        return ddlKagoMoshitateRiyu;
    }

    @JsonProperty("ddlKagoMoshitateRiyu")
    public void setDdlKagoMoshitateRiyu(DropDownList ddlKagoMoshitateRiyu) {
        this.ddlKagoMoshitateRiyu=ddlKagoMoshitateRiyu;
    }

    @JsonProperty("chkForDogetsuShinsa")
    public CheckBoxList getChkForDogetsuShinsa() {
        return chkForDogetsuShinsa;
    }

    @JsonProperty("chkForDogetsuShinsa")
    public void setChkForDogetsuShinsa(CheckBoxList chkForDogetsuShinsa) {
        this.chkForDogetsuShinsa=chkForDogetsuShinsa;
    }

}
