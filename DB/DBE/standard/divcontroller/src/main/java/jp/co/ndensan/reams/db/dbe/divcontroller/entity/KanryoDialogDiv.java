package jp.co.ndensan.reams.db.dbe.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoDialog のクラスファイル
 *
 * @author 自動生成
 */
public class KanryoDialogDiv extends Panel implements IKanryoDialogDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SuccessInfo")
    private SuccessInfoDiv SuccessInfo;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SuccessInfo")
    public SuccessInfoDiv getSuccessInfo() {
        return SuccessInfo;
    }

    @JsonProperty("SuccessInfo")
    public void setSuccessInfo(SuccessInfoDiv SuccessInfo) {
        this.SuccessInfo = SuccessInfo;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------
}
