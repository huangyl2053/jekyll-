package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003;
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
 * TorikeshiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TorikeshiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorikeshiYMD")
    private TextBoxDate txtTorikeshiYMD;
    @JsonProperty("btnTorikeshiShurui")
    private Button btnTorikeshiShurui;
    @JsonProperty("txtTorikeshiShurui")
    private TextBox txtTorikeshiShurui;
    @JsonProperty("txtTorikeshiRiyu")
    private TextBoxMultiLine txtTorikeshiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTorikeshiYMD")
    public TextBoxDate getTxtTorikeshiYMD() {
        return txtTorikeshiYMD;
    }

    @JsonProperty("txtTorikeshiYMD")
    public void setTxtTorikeshiYMD(TextBoxDate txtTorikeshiYMD) {
        this.txtTorikeshiYMD=txtTorikeshiYMD;
    }

    @JsonProperty("btnTorikeshiShurui")
    public Button getBtnTorikeshiShurui() {
        return btnTorikeshiShurui;
    }

    @JsonProperty("btnTorikeshiShurui")
    public void setBtnTorikeshiShurui(Button btnTorikeshiShurui) {
        this.btnTorikeshiShurui=btnTorikeshiShurui;
    }

    @JsonProperty("txtTorikeshiShurui")
    public TextBox getTxtTorikeshiShurui() {
        return txtTorikeshiShurui;
    }

    @JsonProperty("txtTorikeshiShurui")
    public void setTxtTorikeshiShurui(TextBox txtTorikeshiShurui) {
        this.txtTorikeshiShurui=txtTorikeshiShurui;
    }

    @JsonProperty("txtTorikeshiRiyu")
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return txtTorikeshiRiyu;
    }

    @JsonProperty("txtTorikeshiRiyu")
    public void setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.txtTorikeshiRiyu=txtTorikeshiRiyu;
    }

}
