package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
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
 * ShokanShikyuKetteiShomeishoKihonKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoKihonKikanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShomeishoKihonKaishiYMD")
    private TextBoxDate txtShomeishoKihonKaishiYMD;
    @JsonProperty("txtShomeishoKihonChushiYMD")
    private TextBoxDate txtShomeishoKihonChushiYMD;
    @JsonProperty("txtShomeishoKihonChushiRiyu")
    private TextBox txtShomeishoKihonChushiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShomeishoKihonKaishiYMD")
    public TextBoxDate getTxtShomeishoKihonKaishiYMD() {
        return txtShomeishoKihonKaishiYMD;
    }

    @JsonProperty("txtShomeishoKihonKaishiYMD")
    public void setTxtShomeishoKihonKaishiYMD(TextBoxDate txtShomeishoKihonKaishiYMD) {
        this.txtShomeishoKihonKaishiYMD=txtShomeishoKihonKaishiYMD;
    }

    @JsonProperty("txtShomeishoKihonChushiYMD")
    public TextBoxDate getTxtShomeishoKihonChushiYMD() {
        return txtShomeishoKihonChushiYMD;
    }

    @JsonProperty("txtShomeishoKihonChushiYMD")
    public void setTxtShomeishoKihonChushiYMD(TextBoxDate txtShomeishoKihonChushiYMD) {
        this.txtShomeishoKihonChushiYMD=txtShomeishoKihonChushiYMD;
    }

    @JsonProperty("txtShomeishoKihonChushiRiyu")
    public TextBox getTxtShomeishoKihonChushiRiyu() {
        return txtShomeishoKihonChushiRiyu;
    }

    @JsonProperty("txtShomeishoKihonChushiRiyu")
    public void setTxtShomeishoKihonChushiRiyu(TextBox txtShomeishoKihonChushiRiyu) {
        this.txtShomeishoKihonChushiRiyu=txtShomeishoKihonChushiRiyu;
    }

}
