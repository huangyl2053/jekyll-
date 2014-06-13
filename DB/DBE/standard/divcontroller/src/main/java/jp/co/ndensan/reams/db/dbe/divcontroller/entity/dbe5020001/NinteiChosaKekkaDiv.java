package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
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
 * NinteiChosaKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("rbSelectKekke")
    private RadioButton rbSelectKekke;
    @JsonProperty("btnKekkaUpdate")
    private Button btnKekkaUpdate;
    @JsonProperty("btnModoru")
    private Button btnModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("rbSelectKekke")
    public RadioButton getRbSelectKekke() {
        return rbSelectKekke;
    }

    @JsonProperty("rbSelectKekke")
    public void setRbSelectKekke(RadioButton rbSelectKekke) {
        this.rbSelectKekke=rbSelectKekke;
    }

    @JsonProperty("btnKekkaUpdate")
    public Button getBtnKekkaUpdate() {
        return btnKekkaUpdate;
    }

    @JsonProperty("btnKekkaUpdate")
    public void setBtnKekkaUpdate(Button btnKekkaUpdate) {
        this.btnKekkaUpdate=btnKekkaUpdate;
    }

    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru=btnModoru;
    }

}
