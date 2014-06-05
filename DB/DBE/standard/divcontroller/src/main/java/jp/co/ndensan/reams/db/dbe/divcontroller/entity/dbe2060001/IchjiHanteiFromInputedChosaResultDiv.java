package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
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
 * IchjiHanteiFromInputedChosaResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchjiHanteiFromInputedChosaResultDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIchijiHanteiResult")
    private TextBox txtIchijiHanteiResult;
    @JsonProperty("lblSpace4")
    private Label lblSpace4;
    @JsonProperty("btnIchjiHantei")
    private Button btnIchjiHantei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIchijiHanteiResult")
    public TextBox getTxtIchijiHanteiResult() {
        return txtIchijiHanteiResult;
    }

    @JsonProperty("txtIchijiHanteiResult")
    public void setTxtIchijiHanteiResult(TextBox txtIchijiHanteiResult) {
        this.txtIchijiHanteiResult=txtIchijiHanteiResult;
    }

    @JsonProperty("lblSpace4")
    public Label getLblSpace4() {
        return lblSpace4;
    }

    @JsonProperty("lblSpace4")
    public void setLblSpace4(Label lblSpace4) {
        this.lblSpace4=lblSpace4;
    }

    @JsonProperty("btnIchjiHantei")
    public Button getBtnIchjiHantei() {
        return btnIchjiHantei;
    }

    @JsonProperty("btnIchjiHantei")
    public void setBtnIchjiHantei(Button btnIchjiHantei) {
        this.btnIchjiHantei=btnIchjiHantei;
    }

}
