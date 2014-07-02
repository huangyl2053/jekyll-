package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011;
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
 * ShogaishaKojoShinseisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoShinseishaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("txtShinseishaJusho")
    private TextBox txtShinseishaJusho;
    @JsonProperty("btnShinseishaCopy")
    private Button btnShinseishaCopy;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseishaName")
    public TextBox getTxtShinseishaName() {
        return txtShinseishaName;
    }

    @JsonProperty("txtShinseishaName")
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.txtShinseishaName=txtShinseishaName;
    }

    @JsonProperty("txtShinseishaJusho")
    public TextBox getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaJusho")
    public void setTxtShinseishaJusho(TextBox txtShinseishaJusho) {
        this.txtShinseishaJusho=txtShinseishaJusho;
    }

    @JsonProperty("btnShinseishaCopy")
    public Button getBtnShinseishaCopy() {
        return btnShinseishaCopy;
    }

    @JsonProperty("btnShinseishaCopy")
    public void setBtnShinseishaCopy(Button btnShinseishaCopy) {
        this.btnShinseishaCopy=btnShinseishaCopy;
    }

}
