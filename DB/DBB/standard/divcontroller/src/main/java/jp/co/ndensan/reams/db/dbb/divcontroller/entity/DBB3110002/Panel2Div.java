package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110002.DataGrid2_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Panel2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Panel2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DataGrid2")
    private DataGrid<DataGrid2_Row> DataGrid2;
    @JsonProperty("Button4")
    private Button Button4;
    @JsonProperty("Button5")
    private Button Button5;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("DataGrid2")
    public DataGrid<DataGrid2_Row> getDataGrid2() {
        return DataGrid2;
    }

    @JsonProperty("DataGrid2")
    public void setDataGrid2(DataGrid<DataGrid2_Row> DataGrid2) {
        this.DataGrid2=DataGrid2;
    }

    @JsonProperty("Button4")
    public Button getButton4() {
        return Button4;
    }

    @JsonProperty("Button4")
    public void setButton4(Button Button4) {
        this.Button4=Button4;
    }

    @JsonProperty("Button5")
    public Button getButton5() {
        return Button5;
    }

    @JsonProperty("Button5")
    public void setButton5(Button Button5) {
        this.Button5=Button5;
    }

}
