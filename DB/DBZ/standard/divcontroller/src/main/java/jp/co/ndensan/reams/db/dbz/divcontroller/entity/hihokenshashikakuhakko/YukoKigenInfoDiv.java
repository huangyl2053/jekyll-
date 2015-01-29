package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
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
 * YukoKigenInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class YukoKigenInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYukoKigen")
    private TextBoxDate txtYukoKigen;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("ddlKofuJiyu")
    private DropDownList ddlKofuJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtYukoKigen")
    public TextBoxDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxDate txtYukoKigen) {
        this.txtYukoKigen=txtYukoKigen;
    }

    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate=txtKofuDate;
    }

    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("ddlKofuJiyu")
    public DropDownList getDdlKofuJiyu() {
        return ddlKofuJiyu;
    }

    @JsonProperty("ddlKofuJiyu")
    public void setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.ddlKofuJiyu=ddlKofuJiyu;
    }

}
