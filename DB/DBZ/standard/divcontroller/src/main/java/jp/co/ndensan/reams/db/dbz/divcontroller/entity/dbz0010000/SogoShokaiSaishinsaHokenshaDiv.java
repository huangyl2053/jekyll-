package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
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
 * SogoShokaiSaishinsaHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiSaishinsaHokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishinsaHokenshaKekka")
    private TextBox txtSaishinsaHokenshaKekka;
    @JsonProperty("txtSaishinsaHokenshaToshoTanisu")
    private TextBoxNum txtSaishinsaHokenshaToshoTanisu;
    @JsonProperty("txtSaishinsaHokenshaGenshinTanisu")
    private TextBoxNum txtSaishinsaHokenshaGenshinTanisu;
    @JsonProperty("txtSaishinsaHokenshaMoshitateTanisu")
    private TextBoxNum txtSaishinsaHokenshaMoshitateTanisu;
    @JsonProperty("txtSaishinsaHokenshaKetteiTanisu")
    private TextBoxNum txtSaishinsaHokenshaKetteiTanisu;
    @JsonProperty("txtSaishinsaHokenshaChoseiTanisu")
    private TextBoxNum txtSaishinsaHokenshaChoseiTanisu;
    @JsonProperty("txtSaishinsaHokenshaFutangaku")
    private TextBoxNum txtSaishinsaHokenshaFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSaishinsaHokenshaKekka")
    public TextBox getTxtSaishinsaHokenshaKekka() {
        return txtSaishinsaHokenshaKekka;
    }

    @JsonProperty("txtSaishinsaHokenshaKekka")
    public void setTxtSaishinsaHokenshaKekka(TextBox txtSaishinsaHokenshaKekka) {
        this.txtSaishinsaHokenshaKekka=txtSaishinsaHokenshaKekka;
    }

    @JsonProperty("txtSaishinsaHokenshaToshoTanisu")
    public TextBoxNum getTxtSaishinsaHokenshaToshoTanisu() {
        return txtSaishinsaHokenshaToshoTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaToshoTanisu")
    public void setTxtSaishinsaHokenshaToshoTanisu(TextBoxNum txtSaishinsaHokenshaToshoTanisu) {
        this.txtSaishinsaHokenshaToshoTanisu=txtSaishinsaHokenshaToshoTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaGenshinTanisu")
    public TextBoxNum getTxtSaishinsaHokenshaGenshinTanisu() {
        return txtSaishinsaHokenshaGenshinTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaGenshinTanisu")
    public void setTxtSaishinsaHokenshaGenshinTanisu(TextBoxNum txtSaishinsaHokenshaGenshinTanisu) {
        this.txtSaishinsaHokenshaGenshinTanisu=txtSaishinsaHokenshaGenshinTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaMoshitateTanisu")
    public TextBoxNum getTxtSaishinsaHokenshaMoshitateTanisu() {
        return txtSaishinsaHokenshaMoshitateTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaMoshitateTanisu")
    public void setTxtSaishinsaHokenshaMoshitateTanisu(TextBoxNum txtSaishinsaHokenshaMoshitateTanisu) {
        this.txtSaishinsaHokenshaMoshitateTanisu=txtSaishinsaHokenshaMoshitateTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaKetteiTanisu")
    public TextBoxNum getTxtSaishinsaHokenshaKetteiTanisu() {
        return txtSaishinsaHokenshaKetteiTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaKetteiTanisu")
    public void setTxtSaishinsaHokenshaKetteiTanisu(TextBoxNum txtSaishinsaHokenshaKetteiTanisu) {
        this.txtSaishinsaHokenshaKetteiTanisu=txtSaishinsaHokenshaKetteiTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaChoseiTanisu")
    public TextBoxNum getTxtSaishinsaHokenshaChoseiTanisu() {
        return txtSaishinsaHokenshaChoseiTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaChoseiTanisu")
    public void setTxtSaishinsaHokenshaChoseiTanisu(TextBoxNum txtSaishinsaHokenshaChoseiTanisu) {
        this.txtSaishinsaHokenshaChoseiTanisu=txtSaishinsaHokenshaChoseiTanisu;
    }

    @JsonProperty("txtSaishinsaHokenshaFutangaku")
    public TextBoxNum getTxtSaishinsaHokenshaFutangaku() {
        return txtSaishinsaHokenshaFutangaku;
    }

    @JsonProperty("txtSaishinsaHokenshaFutangaku")
    public void setTxtSaishinsaHokenshaFutangaku(TextBoxNum txtSaishinsaHokenshaFutangaku) {
        this.txtSaishinsaHokenshaFutangaku=txtSaishinsaHokenshaFutangaku;
    }

}
