package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiIinIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsakaiIinIchiran")
    private DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran;
    @JsonProperty("btnIinCancel")
    private Button btnIinCancel;
    @JsonProperty("btnIinSentaku")
    private Button btnIinSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsakaiIinIchiran")
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return dgShinsakaiIinIchiran;
    }

    @JsonProperty("dgShinsakaiIinIchiran")
    public void setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.dgShinsakaiIinIchiran=dgShinsakaiIinIchiran;
    }

    @JsonProperty("btnIinCancel")
    public Button getBtnIinCancel() {
        return btnIinCancel;
    }

    @JsonProperty("btnIinCancel")
    public void setBtnIinCancel(Button btnIinCancel) {
        this.btnIinCancel=btnIinCancel;
    }

    @JsonProperty("btnIinSentaku")
    public Button getBtnIinSentaku() {
        return btnIinSentaku;
    }

    @JsonProperty("btnIinSentaku")
    public void setBtnIinSentaku(Button btnIinSentaku) {
        this.btnIinSentaku=btnIinSentaku;
    }

}
