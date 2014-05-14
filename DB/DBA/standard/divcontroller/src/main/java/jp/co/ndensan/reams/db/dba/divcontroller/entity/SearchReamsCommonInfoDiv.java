package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * SearchReamsCommonInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchReamsCommonInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchShimei")
    private TextBox txtSearchShimei;
    @JsonProperty("ddlSearchGender")
    private DropDownList ddlSearchGender;
    @JsonProperty("txtSearchDateOfBitrh")
    private TextBoxFlexibleDate txtSearchDateOfBitrh;
    @JsonProperty("txtShichoson")
    private TextBox txtShichoson;
    @JsonProperty("txtSearchJuminCode")
    private TextBox txtSearchJuminCode;
    @JsonProperty("txtSearchSetaiCode")
    private TextBox txtSearchSetaiCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSearchShimei")
    public TextBox getTxtSearchShimei() {
        return txtSearchShimei;
    }

    @JsonProperty("txtSearchShimei")
    public void setTxtSearchShimei(TextBox txtSearchShimei) {
        this.txtSearchShimei=txtSearchShimei;
    }

    @JsonProperty("ddlSearchGender")
    public DropDownList getDdlSearchGender() {
        return ddlSearchGender;
    }

    @JsonProperty("ddlSearchGender")
    public void setDdlSearchGender(DropDownList ddlSearchGender) {
        this.ddlSearchGender=ddlSearchGender;
    }

    @JsonProperty("txtSearchDateOfBitrh")
    public TextBoxFlexibleDate getTxtSearchDateOfBitrh() {
        return txtSearchDateOfBitrh;
    }

    @JsonProperty("txtSearchDateOfBitrh")
    public void setTxtSearchDateOfBitrh(TextBoxFlexibleDate txtSearchDateOfBitrh) {
        this.txtSearchDateOfBitrh=txtSearchDateOfBitrh;
    }

    @JsonProperty("txtShichoson")
    public TextBox getTxtShichoson() {
        return txtShichoson;
    }

    @JsonProperty("txtShichoson")
    public void setTxtShichoson(TextBox txtShichoson) {
        this.txtShichoson=txtShichoson;
    }

    @JsonProperty("txtSearchJuminCode")
    public TextBox getTxtSearchJuminCode() {
        return txtSearchJuminCode;
    }

    @JsonProperty("txtSearchJuminCode")
    public void setTxtSearchJuminCode(TextBox txtSearchJuminCode) {
        this.txtSearchJuminCode=txtSearchJuminCode;
    }

    @JsonProperty("txtSearchSetaiCode")
    public TextBox getTxtSearchSetaiCode() {
        return txtSearchSetaiCode;
    }

    @JsonProperty("txtSearchSetaiCode")
    public void setTxtSearchSetaiCode(TextBox txtSearchSetaiCode) {
        this.txtSearchSetaiCode=txtSearchSetaiCode;
    }

}
