package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgShichoson_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShichosonSelector のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShichosonSelectorDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShichoson")
    private DataGrid<dgShichoson_Row> dgShichoson;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("btnDecision")
    private Button btnDecision;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShichoson")
    public DataGrid<dgShichoson_Row> getDgShichoson() {
        return dgShichoson;
    }

    @JsonProperty("dgShichoson")
    public void setDgShichoson(DataGrid<dgShichoson_Row> dgShichoson) {
        this.dgShichoson=dgShichoson;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

    @JsonProperty("btnDecision")
    public Button getBtnDecision() {
        return btnDecision;
    }

    @JsonProperty("btnDecision")
    public void setBtnDecision(Button btnDecision) {
        this.btnDecision=btnDecision;
    }

}
