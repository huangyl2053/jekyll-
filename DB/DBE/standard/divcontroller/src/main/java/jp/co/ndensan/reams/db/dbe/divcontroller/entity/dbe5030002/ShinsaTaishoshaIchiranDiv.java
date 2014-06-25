package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsaTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaTaishoshaIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsaTaishoshaIchiran")
    private DataGrid<dgShinsaTaishoshaIchiran_Row> dgShinsaTaishoshaIchiran;
    @JsonProperty("btnModoru")
    private Button btnModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsaTaishoshaIchiran")
    public DataGrid<dgShinsaTaishoshaIchiran_Row> getDgShinsaTaishoshaIchiran() {
        return dgShinsaTaishoshaIchiran;
    }

    @JsonProperty("dgShinsaTaishoshaIchiran")
    public void setDgShinsaTaishoshaIchiran(DataGrid<dgShinsaTaishoshaIchiran_Row> dgShinsaTaishoshaIchiran) {
        this.dgShinsaTaishoshaIchiran=dgShinsaTaishoshaIchiran;
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
