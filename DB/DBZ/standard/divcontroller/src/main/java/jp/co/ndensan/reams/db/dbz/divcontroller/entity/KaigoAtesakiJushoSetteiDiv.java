package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoAtesakiJushoSetteiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoAtesakiJushoSettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoAtesakiJushoSetteiDiv extends Panel implements IKaigoAtesakiJushoSetteiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJushoSettei")
    private RadioButton radJushoSettei;
    @JsonProperty("btnAtesakiJushoSettei")
    private Button btnAtesakiJushoSettei;
    @JsonProperty("txtAtesakiJushoSettei")
    private TextBox txtAtesakiJushoSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radJushoSettei")
    public RadioButton getRadJushoSettei() {
        return radJushoSettei;
    }

    @JsonProperty("radJushoSettei")
    public void setRadJushoSettei(RadioButton radJushoSettei) {
        this.radJushoSettei=radJushoSettei;
    }

    @JsonProperty("btnAtesakiJushoSettei")
    public Button getBtnAtesakiJushoSettei() {
        return btnAtesakiJushoSettei;
    }

    @JsonProperty("btnAtesakiJushoSettei")
    public void setBtnAtesakiJushoSettei(Button btnAtesakiJushoSettei) {
        this.btnAtesakiJushoSettei=btnAtesakiJushoSettei;
    }

    @JsonProperty("txtAtesakiJushoSettei")
    public TextBox getTxtAtesakiJushoSettei() {
        return txtAtesakiJushoSettei;
    }

    @JsonProperty("txtAtesakiJushoSettei")
    public void setTxtAtesakiJushoSettei(TextBox txtAtesakiJushoSettei) {
        this.txtAtesakiJushoSettei=txtAtesakiJushoSettei;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
