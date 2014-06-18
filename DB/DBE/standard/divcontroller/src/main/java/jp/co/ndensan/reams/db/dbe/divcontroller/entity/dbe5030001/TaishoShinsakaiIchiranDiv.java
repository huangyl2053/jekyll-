package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030001.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TaishoShinsakaiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoShinsakaiIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsakaiIchiran")
    private DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("btnSelect")
    private Button btnSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsakaiIchiran")
    public DataGrid<dgShinsakaiIchiran_Row> getDgShinsakaiIchiran() {
        return dgShinsakaiIchiran;
    }

    @JsonProperty("dgShinsakaiIchiran")
    public void setDgShinsakaiIchiran(DataGrid<dgShinsakaiIchiran_Row> dgShinsakaiIchiran) {
        this.dgShinsakaiIchiran=dgShinsakaiIchiran;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    @JsonProperty("btnSelect")
    public Button getBtnSelect() {
        return btnSelect;
    }

    @JsonProperty("btnSelect")
    public void setBtnSelect(Button btnSelect) {
        this.btnSelect=btnSelect;
    }

}
