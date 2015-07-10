package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0200001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaitoshaList のクラスファイル
 *
 * @author 自動生成
 */
public class GaitoshaListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("dgGaitoshaList")
    private DataGrid<dgGaitoshaList_Row> dgGaitoshaList;
    @JsonProperty("btnReSearch")
    private Button btnReSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgGaitoshaList")
    public DataGrid<dgGaitoshaList_Row> getDgGaitoshaList() {
        return dgGaitoshaList;
    }

    @JsonProperty("dgGaitoshaList")
    public void setDgGaitoshaList(DataGrid<dgGaitoshaList_Row> dgGaitoshaList) {
        this.dgGaitoshaList = dgGaitoshaList;
    }

    @JsonProperty("btnReSearch")
    public Button getBtnReSearch() {
        return btnReSearch;
    }

    @JsonProperty("btnReSearch")
    public void setBtnReSearch(Button btnReSearch) {
        this.btnReSearch = btnReSearch;
    }

}
