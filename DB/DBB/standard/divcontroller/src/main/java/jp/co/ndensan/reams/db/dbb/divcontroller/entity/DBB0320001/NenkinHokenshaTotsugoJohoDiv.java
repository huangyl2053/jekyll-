package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * NenkinHokenshaTotsugoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenkinHokenshaTotsugoJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShimeiKana")
    private TextBox txtShimeiKana;
    @JsonProperty("txtSex")
    private TextBox txtSex;
    @JsonProperty("txtBirthYMD")
    private TextBox txtBirthYMD;
    @JsonProperty("txtShimeiKanji")
    private TextBox txtShimeiKanji;
    @JsonProperty("txtJushoKana")
    private TextBox txtJushoKana;
    @JsonProperty("txtJushoKanji")
    private TextBox txtJushoKanji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShimeiKana")
    public TextBox getTxtShimeiKana() {
        return txtShimeiKana;
    }

    @JsonProperty("txtShimeiKana")
    public void setTxtShimeiKana(TextBox txtShimeiKana) {
        this.txtShimeiKana=txtShimeiKana;
    }

    @JsonProperty("txtSex")
    public TextBox getTxtSex() {
        return txtSex;
    }

    @JsonProperty("txtSex")
    public void setTxtSex(TextBox txtSex) {
        this.txtSex=txtSex;
    }

    @JsonProperty("txtBirthYMD")
    public TextBox getTxtBirthYMD() {
        return txtBirthYMD;
    }

    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBox txtBirthYMD) {
        this.txtBirthYMD=txtBirthYMD;
    }

    @JsonProperty("txtShimeiKanji")
    public TextBox getTxtShimeiKanji() {
        return txtShimeiKanji;
    }

    @JsonProperty("txtShimeiKanji")
    public void setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.txtShimeiKanji=txtShimeiKanji;
    }

    @JsonProperty("txtJushoKana")
    public TextBox getTxtJushoKana() {
        return txtJushoKana;
    }

    @JsonProperty("txtJushoKana")
    public void setTxtJushoKana(TextBox txtJushoKana) {
        this.txtJushoKana=txtJushoKana;
    }

    @JsonProperty("txtJushoKanji")
    public TextBox getTxtJushoKanji() {
        return txtJushoKanji;
    }

    @JsonProperty("txtJushoKanji")
    public void setTxtJushoKanji(TextBox txtJushoKanji) {
        this.txtJushoKanji=txtJushoKanji;
    }

}
