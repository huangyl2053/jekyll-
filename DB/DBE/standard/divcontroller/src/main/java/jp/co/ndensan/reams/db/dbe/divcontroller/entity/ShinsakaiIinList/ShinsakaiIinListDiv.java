package jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsakaiIinList;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiIinList のクラスファイル
 *
 * @author 自動生成
 */
public class ShinsakaiIinListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("dgShinsakaiIinChildList")
    private DataGrid<dgShinsakaiIinChildList_Row> dgShinsakaiIinChildList;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsakaiIinChildList")
    public DataGrid<dgShinsakaiIinChildList_Row> getDgShinsakaiIinChildList() {
        return dgShinsakaiIinChildList;
    }

    @JsonProperty("dgShinsakaiIinChildList")
    public void setDgShinsakaiIinChildList(DataGrid<dgShinsakaiIinChildList_Row> dgShinsakaiIinChildList) {
        this.dgShinsakaiIinChildList = dgShinsakaiIinChildList;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

}
