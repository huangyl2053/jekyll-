package jp.co.ndensan.reams.db.dbz.divcontroller.entity.SaishinsaMoshitate;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SaishinsaMoshitate.SaishinsaTaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SaishinsaMoshitate のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaishinsaMoshitateDiv extends Panel {
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
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtSendYM")
    private TextBoxDate txtSendYM;
    @JsonProperty("txtShokisaiHokenshaNo")
    private TextBoxCode txtShokisaiHokenshaNo;
    @JsonProperty("txtShokisaiHokenshaName")
    private TextBox txtShokisaiHokenshaName;
    @JsonProperty("radSaishinsaTaisho")
    private RadioButton radSaishinsaTaisho;
    @JsonProperty("SaishinsaTaisho")
    private SaishinsaTaishoDiv SaishinsaTaisho;
    @JsonProperty("txtMoshitateDate")
    private TextBoxDate txtMoshitateDate;
    @JsonProperty("ddlMoshitateshaKubun")
    private DropDownList ddlMoshitateshaKubun;
    @JsonProperty("txtMoshitateTanisu")
    private TextBoxNum txtMoshitateTanisu;
    @JsonProperty("ddlMoshitateTaishoItem")
    private DropDownList ddlMoshitateTaishoItem;
    @JsonProperty("ddlMoshitateRiyu")
    private DropDownList ddlMoshitateRiyu;

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

    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM=txtTeikyoYM;
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

    @JsonProperty("radSaishinsaTaisho")
    public RadioButton getRadSaishinsaTaisho() {
        return radSaishinsaTaisho;
    }

    @JsonProperty("radSaishinsaTaisho")
    public void setRadSaishinsaTaisho(RadioButton radSaishinsaTaisho) {
        this.radSaishinsaTaisho=radSaishinsaTaisho;
    }

    @JsonProperty("SaishinsaTaisho")
    public SaishinsaTaishoDiv getSaishinsaTaisho() {
        return SaishinsaTaisho;
    }

    @JsonProperty("SaishinsaTaisho")
    public void setSaishinsaTaisho(SaishinsaTaishoDiv SaishinsaTaisho) {
        this.SaishinsaTaisho=SaishinsaTaisho;
    }

    @JsonProperty("txtMoshitateDate")
    public TextBoxDate getTxtMoshitateDate() {
        return txtMoshitateDate;
    }

    @JsonProperty("txtMoshitateDate")
    public void setTxtMoshitateDate(TextBoxDate txtMoshitateDate) {
        this.txtMoshitateDate=txtMoshitateDate;
    }

    @JsonProperty("ddlMoshitateshaKubun")
    public DropDownList getDdlMoshitateshaKubun() {
        return ddlMoshitateshaKubun;
    }

    @JsonProperty("ddlMoshitateshaKubun")
    public void setDdlMoshitateshaKubun(DropDownList ddlMoshitateshaKubun) {
        this.ddlMoshitateshaKubun=ddlMoshitateshaKubun;
    }

    @JsonProperty("txtMoshitateTanisu")
    public TextBoxNum getTxtMoshitateTanisu() {
        return txtMoshitateTanisu;
    }

    @JsonProperty("txtMoshitateTanisu")
    public void setTxtMoshitateTanisu(TextBoxNum txtMoshitateTanisu) {
        this.txtMoshitateTanisu=txtMoshitateTanisu;
    }

    @JsonProperty("ddlMoshitateTaishoItem")
    public DropDownList getDdlMoshitateTaishoItem() {
        return ddlMoshitateTaishoItem;
    }

    @JsonProperty("ddlMoshitateTaishoItem")
    public void setDdlMoshitateTaishoItem(DropDownList ddlMoshitateTaishoItem) {
        this.ddlMoshitateTaishoItem=ddlMoshitateTaishoItem;
    }

    @JsonProperty("ddlMoshitateRiyu")
    public DropDownList getDdlMoshitateRiyu() {
        return ddlMoshitateRiyu;
    }

    @JsonProperty("ddlMoshitateRiyu")
    public void setDdlMoshitateRiyu(DropDownList ddlMoshitateRiyu) {
        this.ddlMoshitateRiyu=ddlMoshitateRiyu;
    }

}
