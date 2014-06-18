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
 * ShoKaishuJokyoShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoKaishuJokyoShosaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txt")
    private TextBox txt;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("txtYukoKigen")
    private TextBoxFlexibleDate txtYukoKigen;
    @JsonProperty("txtKofuJiyu")
    private TextBox txtKofuJiyu;
    @JsonProperty("txtKofuRiyu")
    private TextBoxMultiLine txtKofuRiyu;
    @JsonProperty("txtKaishuDate")
    private TextBoxFlexibleDate txtKaishuDate;
    @JsonProperty("ddlKaishuJiyu")
    private DropDownList ddlKaishuJiyu;
    @JsonProperty("txtKaishuRiyu")
    private TextBoxMultiLine txtKaishuRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txt")
    public TextBox getTxt() {
        return txt;
    }

    @JsonProperty("txt")
    public void setTxt(TextBox txt) {
        this.txt=txt;
    }

    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate=txtKofuDate;
    }

    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen=txtYukoKigen;
    }

    @JsonProperty("txtKofuJiyu")
    public TextBox getTxtKofuJiyu() {
        return txtKofuJiyu;
    }

    @JsonProperty("txtKofuJiyu")
    public void setTxtKofuJiyu(TextBox txtKofuJiyu) {
        this.txtKofuJiyu=txtKofuJiyu;
    }

    @JsonProperty("txtKofuRiyu")
    public TextBoxMultiLine getTxtKofuRiyu() {
        return txtKofuRiyu;
    }

    @JsonProperty("txtKofuRiyu")
    public void setTxtKofuRiyu(TextBoxMultiLine txtKofuRiyu) {
        this.txtKofuRiyu=txtKofuRiyu;
    }

    @JsonProperty("txtKaishuDate")
    public TextBoxFlexibleDate getTxtKaishuDate() {
        return txtKaishuDate;
    }

    @JsonProperty("txtKaishuDate")
    public void setTxtKaishuDate(TextBoxFlexibleDate txtKaishuDate) {
        this.txtKaishuDate=txtKaishuDate;
    }

    @JsonProperty("ddlKaishuJiyu")
    public DropDownList getDdlKaishuJiyu() {
        return ddlKaishuJiyu;
    }

    @JsonProperty("ddlKaishuJiyu")
    public void setDdlKaishuJiyu(DropDownList ddlKaishuJiyu) {
        this.ddlKaishuJiyu=ddlKaishuJiyu;
    }

    @JsonProperty("txtKaishuRiyu")
    public TextBoxMultiLine getTxtKaishuRiyu() {
        return txtKaishuRiyu;
    }

    @JsonProperty("txtKaishuRiyu")
    public void setTxtKaishuRiyu(TextBoxMultiLine txtKaishuRiyu) {
        this.txtKaishuRiyu=txtKaishuRiyu;
    }

}
