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
 * SearchTekiyoJogaishaCommonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchTekiyoJogaishaCommonJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchShimei")
    private TextBox txtSearchShimei;
    @JsonProperty("txtSearchGender")
    private DropDownList txtSearchGender;
    @JsonProperty("txtSearchDateOfBirth")
    private TextBoxFlexibleDate txtSearchDateOfBirth;
    @JsonProperty("txtSearchShichoson")
    private TextBox txtSearchShichoson;
    @JsonProperty("txtSearchSetaiCode")
    private TextBox txtSearchSetaiCode;
    @JsonProperty("txtSearchShikibetsuCode")
    private TextBox txtSearchShikibetsuCode;

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

    @JsonProperty("txtSearchGender")
    public DropDownList getTxtSearchGender() {
        return txtSearchGender;
    }

    @JsonProperty("txtSearchGender")
    public void setTxtSearchGender(DropDownList txtSearchGender) {
        this.txtSearchGender=txtSearchGender;
    }

    @JsonProperty("txtSearchDateOfBirth")
    public TextBoxFlexibleDate getTxtSearchDateOfBirth() {
        return txtSearchDateOfBirth;
    }

    @JsonProperty("txtSearchDateOfBirth")
    public void setTxtSearchDateOfBirth(TextBoxFlexibleDate txtSearchDateOfBirth) {
        this.txtSearchDateOfBirth=txtSearchDateOfBirth;
    }

    @JsonProperty("txtSearchShichoson")
    public TextBox getTxtSearchShichoson() {
        return txtSearchShichoson;
    }

    @JsonProperty("txtSearchShichoson")
    public void setTxtSearchShichoson(TextBox txtSearchShichoson) {
        this.txtSearchShichoson=txtSearchShichoson;
    }

    @JsonProperty("txtSearchSetaiCode")
    public TextBox getTxtSearchSetaiCode() {
        return txtSearchSetaiCode;
    }

    @JsonProperty("txtSearchSetaiCode")
    public void setTxtSearchSetaiCode(TextBox txtSearchSetaiCode) {
        this.txtSearchSetaiCode=txtSearchSetaiCode;
    }

    @JsonProperty("txtSearchShikibetsuCode")
    public TextBox getTxtSearchShikibetsuCode() {
        return txtSearchShikibetsuCode;
    }

    @JsonProperty("txtSearchShikibetsuCode")
    public void setTxtSearchShikibetsuCode(TextBox txtSearchShikibetsuCode) {
        this.txtSearchShikibetsuCode=txtSearchShikibetsuCode;
    }

}
